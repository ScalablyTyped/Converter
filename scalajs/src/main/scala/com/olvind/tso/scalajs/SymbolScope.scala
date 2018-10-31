package com.olvind.tso
package scalajs

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.scalajs.TypeRef.ThisType
import com.olvind.tso.seqs.Head

sealed abstract class SymbolScope { outer =>
  def stack: List[Symbol]
  val libName: Name
  def tparams: Map[Name, TypeParamSymbol]
  def _lookup(fragments: List[Name]): Seq[(Symbol, SymbolScope)]
  def logger: Logger[Unit]

  final def lookup(fragments: List[Name]): Seq[(Symbol, SymbolScope)] =
    fragments match {
      case ScalaJsClasses.isFunction(f)                  => Seq((f, this))
      case a if a === QualifiedName.Array.parts          => Seq((ScalaJsClasses.ScalaJsArray, this))
      case Head(Name.scala | Name.java | Name.OutputPkg) => Seq.empty
      case Head(name) if Name.Internal(name)             => Seq.empty
      case _ =>
        val res = _lookup(fragments)

        if (res.isEmpty && constants.Pedantic) {
          _lookup(fragments)
          logger warn s"Couldn't resolve $fragments"
        }

        res
    }

  final def lookup(qname: QualifiedName): Seq[(Symbol, SymbolScope)] =
    lookup(qname.parts)

  def lookupNoBacktrack(names: List[Name]): Seq[(Symbol, SymbolScope)]

  final def /(current: Symbol): SymbolScope =
    SymbolScope.Scoped(libName, outer, current)

  final lazy val nameStack: List[Name] =
    stack.reverse.map(_.name)

  final override def toString: String =
    nameStack.mkString(" / ")
}

object SymbolScope {
  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  class Root[Source](val libName: Name, _dependencies: Set[LibScalaJs[Source]], val logger: Logger[Unit])
      extends SymbolScope {
    lazy val dependencies: Map[Name, SymbolScope] =
      mapDeps(this, _dependencies)

    override val stack: List[Symbol] =
      Nil

    def tparams: Map[Name, TypeParamSymbol] = Map.empty

    override def _lookup(fragments: List[Name]): Seq[(Symbol, SymbolScope)] =
      fragments match {
        case head :: tail =>
          dependencies.get(head) match {
            case Some(dep) => dep.lookupNoBacktrack(head :: tail)
            case None      => Seq.empty
          }
        case _ => Seq.empty
      }

    override def lookupNoBacktrack(names: List[Name]): Seq[(Symbol, SymbolScope)] =
      Seq.empty

  }

  final case class Scoped(libName: Name, outer: SymbolScope, current: Symbol) extends SymbolScope {
    override val stack: List[Symbol] =
      current :: outer.stack

    override lazy val logger =
      outer.logger.withContext(this)

    lazy val tparams: Map[Name, TypeParamSymbol] = {
      val newTParams: Seq[TypeParamSymbol] =
        current match {
          case x: ClassSymbol     => x.tparams
          case x: TypeAliasSymbol => x.tparams
          case x: MethodSymbol    => x.tparams
          case _ => Nil
        }

      outer.tparams ++ newTParams.map(x => x.name -> x)
    }

    def lookupNoBacktrack(names: List[Name]): Seq[(Symbol, SymbolScope)] =
      names match {
        case current.name :: Nil =>
          Seq((current, this))

        case current.name :: head :: tail =>
          current match {
            case c: ContainerSymbol =>
              c.index
                .get(head)
                .to[Seq]
                .flatten
                .flatMap {
                  case FieldSymbol(_, _, ThisType(_), _, _, _, _) =>
                    lookupNoBacktrack(tail)
                  case sym =>
                    this / sym lookupNoBacktrack (head :: tail)
                }
            case _ =>
              Seq.empty
          }

        case _ => Nil
      }

    override def _lookup(names: List[Name]): Seq[(Symbol, SymbolScope)] =
      lookupNoBacktrack(names) match {
        case Nil   => outer _lookup names
        case found => found
      }
  }

  private def mapDeps[Source](self: SymbolScope, _dependencies: Set[LibScalaJs[Source]]): Map[Name, SymbolScope] =
    _dependencies
      .to[Seq] // the seq is to avoid keeping symbols in a set
      .flatMap(
        dep => Map(dep.packageSymbol.name -> self / dep.packageSymbol) ++ mapDeps(self, dep.dependencies)
      )
      .toMap
}
