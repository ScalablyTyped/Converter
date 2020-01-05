package org.scalablytyped.converter.internal
package scalajs

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.scalajs.TypeRef.ThisType
import org.scalablytyped.converter.internal.scalajs.flavours.{GenJapgollyComponents, GenSlinkyComponents}

sealed abstract class TreeScope { outer =>
  def stack: List[Tree]
  val libName: Name
  def tparams: Map[Name, TypeParamTree]
  def _lookup(fragments: List[Name]): IArray[(Tree, TreeScope)]
  def logger:   Logger[Unit]
  def pedantic: Boolean
  val outputPkg: Name

  final def root: TreeScope.Root[_] =
    this match {
      case root: TreeScope.Root[_] => root
      case x:    TreeScope.Scoped  => x.outer.root
    }

  final def lookup(wanted: QualifiedName): IArray[(Tree, TreeScope)] =
    if (ScalaJsClasses.ScalaJsTypes.contains(wanted)) IArray((ScalaJsClasses.ScalaJsTypes(wanted), this))
    else
      wanted.parts match {
        case Name.scala :: _                                     => Empty
        case Name.java :: _                                      => Empty
        case GenJapgollyComponents.names.japgolly :: _           => Empty
        case GenSlinkyComponents.slinkyName :: _                 => Empty
        case fs if fs.startsWith(QualifiedName.Runtime.parts)    => Empty
        case fs if fs.startsWith(QualifiedName.ScalaJsDom.parts) => Empty
        case name :: _ if Name.Internal(name)                    => Empty
        case parts =>
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

          val res = searchFrom._lookup(parts)

          if (res.isEmpty && pedantic) {
            searchFrom._lookup(parts)
            logger fatal s"Couldn't resolve $parts"
          }

          res
      }

  def lookupNoBacktrack(names: List[Name]): IArray[(Tree, TreeScope)]

  final def /(current: Tree): TreeScope =
    new TreeScope.Scoped(outputPkg, libName, outer, current)

  final lazy val nameStack: List[Name] =
    stack.reverse.map(_.name)

  final override def toString: String =
    nameStack.mkString(" / ")

  final def isAbstract(tr: TypeRef): Boolean =
    tr match {
      case TypeRef(QualifiedName(one :: Nil), Empty, _) => tparams.contains(one)
      case _                                            => false
    }

  override lazy val hashCode: Int = (13 * root.libName.hashCode) * stack.hashCode

  override def equals(obj: Any): Boolean =
    obj match {
      case that: TreeScope if root.libName === that.root.libName && hashCode === that.hashCode => stack === that.stack
      case _ => false
    }
}

object TreeScope {
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

    override def _lookup(fragments: List[Name]): IArray[(Tree, TreeScope)] =
      fragments match {
        case `outputPkg` :: head :: tail =>
          dependencies.get(head) match {
            case Some(dep) => dep.lookupNoBacktrack(outputPkg :: head :: tail)
            case None      => Empty
          }
        case _ => Empty
      }

    override def lookupNoBacktrack(names: List[Name]): IArray[(Tree, TreeScope)] =
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

    def lookupNoBacktrack(names: List[Name]): IArray[(Tree, TreeScope)] =
      names match {
        case current.name :: Nil =>
          IArray((current, this))

        case current.name :: head :: tail =>
          current match {
            case c: ContainerTree =>
              c.index.get(head) match {
                case Some(founds) =>
                  founds.flatMap {
                    case FieldTree(_, _, ThisType(_), _, _, _, _, _) =>
                      lookupNoBacktrack(tail)
                    case tree =>
                      this / tree lookupNoBacktrack (head :: tail)
                  }
                case None => Empty
              }
            case _ =>
              Empty
          }

        case _ => Empty
      }

    override def _lookup(names: List[Name]): IArray[(Tree, TreeScope)] =
      lookupNoBacktrack(names) match {
        case Empty => outer _lookup names
        case found => found
      }
  }

  trait Lib {
    def packageTree:  ContainerTree
    def dependencies: Map[_, Lib]
  }
}
