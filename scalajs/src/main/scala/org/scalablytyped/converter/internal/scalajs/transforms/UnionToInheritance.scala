package org.scalablytyped.converter.internal
package scalajs
package transforms

/**
  * Inheritance works better than the userland union types, so we rewrite the latter to the former:
  *
  * ```scala
  * package thisLib {
  *   trait Foo
  *   trait Bar
  *   type A = thisLib.Foo | thisLib.Bar
  * }
  *
  * // ->
  *
  * package thisLib {
  *   trait A
  *   trait Foo extends thisLib.A
  *   trait Bar extends thisLib.A
  * }
  * ```
  *
  * There is also a somewhat more complicated case where some types cannot be rewritten:
  * ```scala
  * package otherLib {
  *   trait FooBar
  * }
  * package thisLib {
  *   trait Foo
  *   trait WithTypeParams[T]
  *   type A[T] = thisLib.Foo | thisLib.WithTypeParams[T] | otherLib.FooBar
  * }
  *
  * // ->
  *
  * package thisLib {
  *   trait A_[T]
  *   trait Foo extends thisLib.A_[js.Any]
  *   trait WithTypeParams[T] extends A_[T]
  *   type A[T] = A_ | WithTypeParams[T] | otherLib.FooBar
  * }
  * ```
  *
  * And finally, an even more complicated case where we invert type parameters, barring quite a few restrictions to
  *  (hopefully) keep the transformations sound:
  *
  * ```typescript
  * interface Either<L, R> {
  *     value: R
  * }
  * type Foo<T1, T2, T3> = "foo" | Either<T2, T3>
  * ```
  *
  * We turn this into
  * ```scala
  * trait Foo[T1, T2, T3] extends js.Object
  *
  * trait Either[L, R]
  *   extends Foo[js.Any, L, R] {
  *   var value: R
  * }
  *
  * sealed trait foo with Foo[js.Any, js.Any, js.Any]
  * ```
  */
object UnionToInheritance {

  /* used to reconstruct a rewritten type alias in phases *after* this rewrite has finished */
  case class RewrittenTypeUnion(
      codePath:      QualifiedName,
      tparams:       IArray[TypeParamTree],
      asInheritance: IArray[TypeRef],
      noRewrites:    IArray[TypeRef],
  ) {
    def all = asInheritance ++ noRewrites
  }

  object RewrittenTypeUnion {
    def unapply(tree: Tree): Option[RewrittenTypeUnion] =
      tree match {
        case cls: ClassTree =>
          cls.comments.extract { case x: UnionToInheritance.WasUnion => x } map {
            case (UnionToInheritance.WasUnion(asInheritance, noRewrites), _) =>
              RewrittenTypeUnion(cls.codePath, cls.tparams, asInheritance, noRewrites)

          }

        case ta: TypeAliasTree =>
          ta.comments.extract { case x: UnionToInheritance.WasUnion => x } map {
            case (UnionToInheritance.WasUnion(asInheritance, noRewrites), _) =>
              RewrittenTypeUnion(ta.codePath, ta.tparams, asInheritance, noRewrites)
          } orElse {
            ta.alias match {
              case TypeRef.Union(types, _) => Some(RewrittenTypeUnion(ta.codePath, ta.tparams, Empty, types))
              case _                       => None
            }
          }
        case _ => None
      }
  }

  final case class WasUnion(asInheritance: IArray[TypeRef], noRewrites: IArray[TypeRef]) extends Comment.Data

  def apply(
      scope:               TreeScope,
      tree:                ContainerTree,
      inLib:               Name,
      willBeExternalTypes: Set[QualifiedName],
  ): ContainerTree = {
    val rewrites = Rewrite.identify(inLib, tree, scope / tree, willBeExternalTypes)

    val newParentsByCodePath: Map[QualifiedName, IArray[InvertingTypeParamRef]] =
      rewrites
        .flatMap(InvertingTypeParamRef.apply)
        .groupBy(_._1)
        .mapValues(_.map(_._2).sortBy(_.codePath.parts.last))

    val indexedRewrites: Map[QualifiedName, Rewrite] =
      rewrites.groupBy(_.original.codePath).mapValues(_.head)

    val withRewrittenTypes =
      typesToInterfaces(tree, indexedRewrites, newParentsByCodePath)

    addedInheritance(withRewrittenTypes, newParentsByCodePath)
  }

  def typesToInterfaces(
      c:                    ContainerTree,
      indexedRewrites:      Map[QualifiedName, Rewrite],
      newParentsByCodePath: Map[QualifiedName, IArray[InvertingTypeParamRef]],
  ): ContainerTree = {
    val newMembers = c.members.flatMap {
      case p: ContainerTree =>
        IArray(typesToInterfaces(p, indexedRewrites, newParentsByCodePath))

      case ta: TypeAliasTree if indexedRewrites.contains(ta.codePath) =>
        val commentsOpt = ta.alias match {
          case TypeRef.Union(tps, cs) =>
            val strings = tps.map(Printer.formatTypeRef(0)).map("  - " + _)
            Some(cs + Comment(s"/* Rewritten from type alias, can be one of: \n${strings.mkString("\n")}\n*/\n"))
          case _ => None
        }

        val Rewrite(_, asInheritance, noRewrites) = indexedRewrites(ta.codePath)

        val cls = ClassTree(
          isImplicit = false,
          IArray(Annotation.ScalaJSDefined),
          ta.name,
          ta.tparams,
          Empty,
          Empty,
          Empty,
          ClassType.Trait,
          isSealed = false,
          ta.comments ++? commentsOpt + CommentData(Minimization.Related(asInheritance)) +
            CommentData(WasUnion(asInheritance, noRewrites)),
          ta.codePath,
        )

        IArray(cls)

      case other => IArray(other)
    }

    c.withMembers(newMembers)
  }

  def addedInheritance(
      c:                    ContainerTree,
      newParentsByCodePath: Map[QualifiedName, IArray[InvertingTypeParamRef]],
  ): ContainerTree =
    c.withMembers(c.members.map {
      case p: PackageTree =>
        addedInheritance(p, newParentsByCodePath)
      case p: ModuleTree =>
        addedInheritance(p, newParentsByCodePath)
      case x: ClassTree =>
        newParentsByCodePath.get(x.codePath) match {
          case None => x
          case Some(newParents) =>
            x.copy(parents = x.parents ++ newParents.map(_.instantiate(x.tparams)))
        }
      case other => other
    })

  final case class Rewrite(original: TypeAliasTree, asInheritance: IArray[TypeRef], unchanged: IArray[TypeRef]) {
    def all = asInheritance ++ unchanged
  }

  object Rewrite {
    def identify(
        inLib:               Name,
        p:                   ContainerTree,
        scope:               TreeScope,
        willBeExternalTypes: Set[QualifiedName],
    ): IArray[Rewrite] = {
      def go(p: ContainerTree, scope: TreeScope): IArray[Rewrite] = {
        def legalClassName(name: Name): Boolean =
          p index name forall {
            case _: PackageTree => false
            case _ => true
          }

        p.members.flatMap {
          case p:  ContainerTree => identify(inLib, p, scope / p, willBeExternalTypes)
          case ta: TypeAliasTree if legalClassName(ta.name) =>
            IArray.fromOption(canRewrite(inLib, ta, scope / ta, willBeExternalTypes))
          case _ => Empty
        }
      }

      go(p, scope)
    }

    def canRewrite(
        inLib:               Name,
        ta:                  TypeAliasTree,
        scope:               TreeScope,
        willBeExternalTypes: Set[QualifiedName],
    ): Option[Rewrite] =
      ta.alias match {
        case TypeRef.Union(types, _) =>
          def legalTarget(tr: TypeRef): Boolean =
            if (willBeExternalTypes(tr.typeName)) false
            else
              scope.lookup(tr.typeName).exists {
                case (_:  ClassTree, _)     => true
                case (ta: TypeAliasTree, _) => canRewrite(inLib, ta, scope, willBeExternalTypes).isDefined
                case _ => false
              }

          val InLibrary: PartialFunction[TypeRef, TypeRef] = {
            case tr @ TypeRef(QualifiedName(parts), _, _)
                if parts.length > 2 && parts(1) === inLib && legalTarget(tr) =>
              tr
          }

          val HasIllegalTypeParams: PartialFunction[TypeRef, TypeRef] = {
            case tr @ TypeRef(_, targs, _)
                if targs.exists(x => !scope.isAbstract(x)) || targs.toSet.size =/= targs.length =>
              tr
          }

          val (illegalTParams, inLibrary, outsideLib) = types.partitionCollect2(HasIllegalTypeParams, InLibrary)
          Some(Rewrite(ta, asInheritance = inLibrary, unchanged = illegalTParams ++ outsideLib))

        case _ => None
      }
  }

  case class InvertingTypeParamRef(codePath: QualifiedName, tParamRefs: IArray[(TypeParamTree, Option[Int])]) {
    def instantiate(tparams: IArray[TypeParamTree]): TypeRef = {
      val targs = tParamRefs.map {
        case (_, Some(idx)) => TypeRef(tparams(idx).name)
        case (_, None)      => TypeRef.Any
      }
      TypeRef(codePath, targs, NoComments)
    }
  }

  object InvertingTypeParamRef {
    def apply(r: Rewrite): IArray[(QualifiedName, InvertingTypeParamRef)] =
      r.asInheritance.map { (newParent: TypeRef) =>
        val tParamReferencedAt: IArray[(TypeParamTree, Option[Int])] =
          r.original.tparams.map(tparam =>
            tparam -> newParent.targs.zipWithIndex.collectFirst {
              case (x, idx) if x.name === tparam.name => idx
            },
          )
        newParent.typeName -> InvertingTypeParamRef(r.original.codePath, tParamReferencedAt)
      }
  }
}
