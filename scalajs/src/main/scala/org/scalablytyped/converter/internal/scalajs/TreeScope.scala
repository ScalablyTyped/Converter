package org.scalablytyped.converter.internal
package scalajs

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.scalajs.TypeRef.ThisType
import org.scalablytyped.converter.internal.scalajs.flavours.{GenJapgollyComponents, GenSlinkyComponents}
import org.scalablytyped.converter.internal.seqs.Head

sealed abstract class TreeScope { outer =>
  def stack: List[Tree]
  val libName: Name
  def tparams: Map[Name, TypeParamTree]
  def _lookup(fragments: List[Name]): Seq[(Tree, TreeScope)]
  def logger:   Logger[Unit]
  def pedantic: Boolean
  val outputPkg: Name

  final def root: TreeScope.Root[_] =
    this match {
      case root: TreeScope.Root[_] => root
      case x:    TreeScope.Scoped  => x.outer.root
    }

  final def lookup(wanted: QualifiedName): Seq[(Tree, TreeScope)] =
    if (ScalaJsClasses.ScalaJsTypes.contains(wanted)) Seq((ScalaJsClasses.ScalaJsTypes(wanted), this))
    else
      wanted.parts match {
        case Name.scala :: _                                     => Nil
        case Name.java :: _                                      => Nil
        case GenJapgollyComponents.names.japgolly :: _           => Nil
        case GenSlinkyComponents.slinkyName :: _                 => Nil
        case fs if fs.startsWith(QualifiedName.Runtime.parts)    => Nil
        case fs if fs.startsWith(QualifiedName.ScalaJsDom.parts) => Nil
        case Head(name) if Name.Internal(name)                   => Nil
        case parts =>
          val res = _lookup(parts)

          if (res.isEmpty && pedantic) {
            _lookup(parts)
            logger fatal s"Couldn't resolve $parts"
          }

          res
      }

  def lookupNoBacktrack(names: List[Name]): Seq[(Tree, TreeScope)]

  final def /(current: Tree): TreeScope =
    new TreeScope.Scoped(outputPkg, libName, outer, current)

  final lazy val nameStack: List[Name] =
    stack.reverse.map(_.name)

  final override def toString: String =
    nameStack.mkString(" / ")

  final def isAbstract(tr: TypeRef): Boolean =
    tr match {
      case TypeRef(QualifiedName(one :: Nil), Nil, _) => tparams.contains(one)
      case _                                          => false
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

    override def _lookup(fragments: List[Name]): Seq[(Tree, TreeScope)] =
      fragments match {
        case `outputPkg` :: head :: tail =>
          dependencies.get(head) match {
            case Some(dep) => dep.lookupNoBacktrack(outputPkg :: head :: tail)
            case None      => Seq.empty
          }
        case _ => Seq.empty
      }

    override def lookupNoBacktrack(names: List[Name]): Seq[(Tree, TreeScope)] =
      Seq.empty
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
      val newTParams: Seq[TypeParamTree] =
        current match {
          case x: ClassTree     => x.tparams
          case x: TypeAliasTree => x.tparams
          case x: MethodTree    => x.tparams
          case _ => Nil
        }

      outer.tparams ++ newTParams.map(x => x.name -> x)
    }

    def lookupNoBacktrack(names: List[Name]): Seq[(Tree, TreeScope)] =
      names match {
        case current.name :: Nil =>
          List((current, this))

        // 99% a shortcut, plus handle fully qualified types more places in the pipeline
        case `outputPkg` :: rest if rest.startsWith(nameStack) =>
          lookupNoBacktrack(names.drop(nameStack.length))

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
                case None => Nil
              }
            case _ =>
              Nil
          }

        case _ => Nil
      }

    override def _lookup(names: List[Name]): Seq[(Tree, TreeScope)] =
      lookupNoBacktrack(names) match {
        case Nil   => outer _lookup names
        case found => found
      }
  }

  trait Lib {
    def packageTree:  ContainerTree
    def dependencies: Map[_, Lib]
  }
}
