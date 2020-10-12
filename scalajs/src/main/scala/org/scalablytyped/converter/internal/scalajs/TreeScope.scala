package org.scalablytyped.converter.internal
package scalajs

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.scalajs.TypeRef.ThisType
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyGenComponents

sealed abstract class TreeScope { outer =>
  def stack: List[Tree]
  val libName: Name
  def tparams: Map[Name, TypeParamTree]
  def _lookup(fragments: IArray[Name]): IArray[(Tree, TreeScope)]
  def logger:   Logger[Unit]
  def pedantic: Boolean
  val outputPkg: Name

  final def `..` : TreeScope =
    this match {
      case root:   TreeScope.Root[_] => root
      case scoped: TreeScope.Scoped  => scoped.outer
    }
  final def root: TreeScope.Root[_] =
    this match {
      case root: TreeScope.Root[_] => root
      case x:    TreeScope.Scoped  => x.outer.root
    }

  final def lookup(wanted: QualifiedName): IArray[(Tree, TreeScope)] =
    if (ScalaJsClasses.ScalaJsTypes.contains(wanted)) IArray((ScalaJsClasses.ScalaJsTypes(wanted), this))
    else if (TreeScope.dontLookup(wanted)) Empty
    else {
      var searchFrom: TreeScope = this
      var continue = true
      while (continue) {
        searchFrom match {
          case _: TreeScope.Root[_] =>
            continue = false
          case x: TreeScope.Scoped =>
            x.outer match {
              case _: TreeScope.Root[_] =>
                continue = false
              case outer: TreeScope.Scoped =>
                searchFrom = outer
            }
        }
      }

      val res = searchFrom._lookup(wanted.parts)

      if (res.isEmpty && pedantic) {
        searchFrom._lookup(wanted.parts)
        logger.fatal(s"Couldn't resolve ${wanted.parts}")
      }

      res
    }

  def lookupNoBacktrack(names: IArray[Name]): IArray[(Tree, TreeScope)]

  final def /(current: Tree): TreeScope =
    new TreeScope.Scoped(outputPkg, libName, outer, current)

  final lazy val nameStack: List[Name] =
    stack.reverse.map(_.name)

  final override def toString: String =
    nameStack.mkString(" / ")

  final def isAbstract(tr: TypeRef): Boolean =
    tr match {
      case TypeRef(QualifiedName(IArray.exactlyOne(one)), Empty, _) => tparams.contains(one)
      case _                                                        => false
    }

  override lazy val hashCode: Int = (13 * root.libName.hashCode) * stack.hashCode

  override def equals(obj: Any): Boolean =
    obj match {
      case that: TreeScope if root.libName === that.root.libName && hashCode === that.hashCode => stack === that.stack
      case _ => false
    }

  def owner: Option[InheritanceTree] =
    stack.collectFirst { case x: InheritanceTree => x }

  def isNative: Boolean =
    owner.fold(true)(_.isNative)
}

object TreeScope {
  object dontLookup {
    private val ExternalsPrefixes: Set[Name] = Set(
      Name.scala,
      Name.java,
      Name("japgolly"),
      SlinkyGenComponents.slinkyName,
    ) ++ Name.Internal

    def apply(wanted: QualifiedName): Boolean =
      if (wanted.parts.isEmpty) false
      else if (ExternalsPrefixes(wanted.parts(0))) true
      else if (wanted.parts(0) === Name.org)
        wanted.parts.startsWith(QualifiedName.Runtime.parts) || wanted.parts.startsWith(QualifiedName.ScalaJsDom.parts)
      else false
  }

  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  class Root[Source](
      val outputPkg: Name,
      val libName:   Name,
      _dependencies: Map[Name, ContainerTree],
      val logger:    Logger[Unit],
      val pedantic:  Boolean,
  ) extends TreeScope {

    lazy val dependencies: Map[Name, TreeScope] =
      _dependencies.mapValues(x => this / x)

    override val stack: List[Tree] =
      Nil

    def tparams: Map[Name, TypeParamTree] = Map.empty

    override def _lookup(fragments: IArray[Name]): IArray[(Tree, TreeScope)] =
      fragments match {
        case IArray.headHeadTail(`outputPkg`, head, tail) =>
          dependencies.get(head) match {
            case Some(dep) => dep.lookupNoBacktrack(outputPkg +: head +: tail)
            case None      => Empty
          }
        case _ => Empty
      }

    override def lookupNoBacktrack(names: IArray[Name]): IArray[(Tree, TreeScope)] =
      Empty
  }

  final class Scoped(val outputPkg: Name, val libName: Name, val outer: TreeScope, val current: Tree)
      extends TreeScope {

    var _stack: List[Tree] = null
    override def stack: List[Tree] = {
      if (_stack == null) {
        _stack = current :: outer.stack
      }
      _stack
    }

    override lazy val logger =
      outer.logger.withContext(this)

    override def pedantic: Boolean =
      outer.pedantic

    lazy val tparams: Map[Name, TypeParamTree] = {
      val newTParams: IArray[TypeParamTree] =
        current match {
          case x: ClassTree     => x.tparams
          case x: TypeAliasTree => x.tparams
          case x: MethodTree    => x.tparams
          case _ => Empty
        }

      outer.tparams ++ newTParams.map(x => x.name -> x).toMap
    }

    def lookupNoBacktrack(names: IArray[Name]): IArray[(Tree, TreeScope)] =
      names match {
        case IArray.exactlyOne(current.name) =>
          IArray((current, this))

        case IArray.headHeadTail(current.name, head, tail) =>
          current match {
            case c: ContainerTree =>
              c.index.get(head) match {
                case Some(founds) =>
                  founds.flatMap {
                    case FieldTree(_, _, ThisType(_), _, _, _, _, _) =>
                      lookupNoBacktrack(tail)
                    case tree =>
                      (this / tree).lookupNoBacktrack(head +: tail)
                  }
                case None => Empty
              }
            case _ =>
              Empty
          }

        case _ => Empty
      }

    override def _lookup(names: IArray[Name]): IArray[(Tree, TreeScope)] =
      lookupNoBacktrack(names) match {
        case Empty => outer._lookup(names)
        case found => found
      }
  }

  trait Lib {
    def packageTree:  ContainerTree
    def dependencies: Map[_, Lib]
  }
}
