package com.olvind.tso
package scalajs

/**
  * @deprecated This doesn't handle any of `Name.Internal`.
  *
  * Ideally we'll handle all of that on the typescript side, but we don't yet
  */
object ParentsResolver {

  sealed trait ParentTree {
    def transitiveParents: Map[TypeRef, ClassSymbol] =
      this match {
        case Root(ps) => ps.flatMap(_.transitiveParents).toMap
        case x: NotRoot => Map(x.ref -> x.classSymbol) ++ x.parents.flatMap(_.transitiveParents)
      }
  }

  case class NotRoot(ref: TypeRef, classSymbol: ClassSymbol, foundIn: SymbolScope, parents: Seq[NotRoot])
      extends ParentTree {

    def map(f: (SymbolScope, ClassSymbol) => ClassSymbol): NotRoot =
      NotRoot(ref, f(foundIn, classSymbol), foundIn, parents)
  }

  case class Root(directParents: Seq[NotRoot]) extends ParentTree {
    def map(f: (SymbolScope, ClassSymbol) => ClassSymbol): Root =
      Root(directParents.map(_.map(f)))

    def pruneClasses: Root = {
      def maybe(it: NotRoot): Option[NotRoot] =
        it match {
          case NotRoot(_, ClassSymbol(_, _, _, _, _, _, ClassType.Class, _, _), _, _) => None
          case NotRoot(ref, cls, scope, ps)                                           => Some(NotRoot(ref, cls, scope, ps.flatMap(maybe)))
        }
      copy(directParents = directParents.flatMap(maybe))
    }
  }

  def apply(scope: SymbolScope, symbol: ContainerSymbol): Root = {
    val ld = new LoopDetector
    Root(parentRefs(symbol).flatMap(tr => recurse(scope, tr, tr, ld)))
  }

  private def parentRefs(symbol: ContainerSymbol): Seq[TypeRef] =
    symbol match {
      case x: ClassSymbol  => x.parents
      case x: ModuleSymbol => x.parents
      case _ => Nil
    }

  private def recurse(scope: SymbolScope, typeRef: TypeRef, retainTypeRef: TypeRef, ld: LoopDetector): Option[NotRoot] =
    ld.including(typeRef.typeName.parts, scope) match {
      case Left(()) =>
        scope.logger.warn(s"Circular inheritance?")
        None
      case Right(newLd) =>
        (scope lookup typeRef.typeName).headOption match {
          case Some((cls: ClassSymbol, foundInScope)) =>
            val rewritten = FillInTParams(cls, scope, typeRef.targs)
            Some(
              NotRoot(
                retainTypeRef,
                rewritten,
                foundInScope,
                parentRefs(rewritten).flatMap(tr => recurse(foundInScope, tr, tr, newLd))
              )
            )

          case Some((ta: TypeAliasSymbol, foundInScope)) =>
            val rewritten = FillInTParams(ta, scope, typeRef.targs)
            recurse(foundInScope, rewritten.alias, typeRef, newLd)

          case _ => None
        }

    }
}
