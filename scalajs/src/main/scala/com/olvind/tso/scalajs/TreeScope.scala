package com.olvind.tso
package scalajs

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.scalajs.TypeRef.ThisType
import com.olvind.tso.scalajs.flavours.{GenJapgollyComponents, GenSlinkyComponents}
import com.olvind.tso.seqs.Head

sealed abstract class TreeScope { outer =>
  def stack: List[Tree]
  val libName: Name
  def tparams: Map[Name, TypeParamTree]
  def _lookup(fragments: List[Name]): Seq[(Tree, TreeScope)]
  def logger:   Logger[Unit]
  def pedantic: Boolean

  final def root: TreeScope.Root[_] =
    this match {
      case root: TreeScope.Root[_] => root
      case TreeScope.Scoped(_, outer, _) => outer.root
    }

  final def lookup(fragments: List[Name]): Seq[(Tree, TreeScope)] =
    fragments match {
      case x if ScalaJsClasses.ScalaJsTypes.contains(x) => Seq((ScalaJsClasses.ScalaJsTypes(x), this))
      case Head(Name.scala | Name.java | GenJapgollyComponents.names.japgolly | GenSlinkyComponents.slinkyName) =>
        Nil
      case fs if fs.startsWith(QualifiedName.Runtime.parts)    => Nil
      case fs if fs.startsWith(QualifiedName.ScalaJsDom.parts) => Nil
      case Head(name) if Name.Internal(name)                   => Nil
      case _ =>
        val res = _lookup(fragments)

        if (res.isEmpty && pedantic) {
          _lookup(fragments)
          logger fatal s"Couldn't resolve $fragments"
        }

        res
    }

  final def lookup(qname: QualifiedName): Seq[(Tree, TreeScope)] =
    lookup(qname.parts)

  def lookupNoBacktrack(names: List[Name]): Seq[(Tree, TreeScope)]

  final def /(current: Tree): TreeScope =
    TreeScope.Scoped(libName, outer, current)

  final lazy val nameStack: List[Name] =
    stack.reverse.map(_.name)

  final override def toString: String =
    nameStack.mkString(" / ")

  final def isAbstract(tr: TypeRef): Boolean =
    tr match {
      case TypeRef(QualifiedName(one :: Nil), Nil, _) => tparams.contains(one)
      case _                                          => false
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

  final case class Scoped(libName: Name, outer: TreeScope, current: Tree) extends TreeScope {
    override val stack: List[Tree] =
      current :: outer.stack

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

    lazy val outputPkg = root.outputPkg

    def lookupNoBacktrack(names: List[Name]): Seq[(Tree, TreeScope)] =
      names match {
        case current.name :: Nil =>
          Seq((current, this))

        // 99% a shortcut, plus handle fully qualified types more places in the pipeline
        case `outputPkg` :: rest if rest.startsWith(nameStack) =>
          lookupNoBacktrack(names.drop(nameStack.length))

        case current.name :: head :: tail =>
          current match {
            case c: ContainerTree =>
              c.index
                .get(head)
                .to[Seq]
                .flatten
                .flatMap {
                  case FieldTree(_, _, ThisType(_), _, _, _, _, _) =>
                    lookupNoBacktrack(tail)
                  case tree =>
                    this / tree lookupNoBacktrack (head :: tail)
                }
            case _ =>
              Seq.empty
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
