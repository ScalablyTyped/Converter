package org.scalablytyped.converter.internal
package scalajs
package transforms

/**
  * So far we've been pretty pedantic in the handling of things like re-exported types.
  * ```typescript
  * declare module "libfoo/impl/foo" {
  * export class Foo {}
  * }
  * declare module "libfoo" {
  * export import {Foo} from "libfoo/impl/foo";
  * export class Bar {
  * constructor(foo: Foo) {}
  * }
  * }
  * ```
  *
  * In most cases `Bar` has pointed to `libfoo.Foo` so far, while the intention was really something compatible with `libfoo/impl/foo.Foo`
  *
  * In the name of pragmatism, assert that if a class has a parent with the same name and type parameters, accept that in the place of the child class.
  *
  * Also, only do this for types in input position
  */
class GeneralizeTypeRefs(parentsResolver: ParentsResolver) extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
    if (shouldGeneralize(scope)) generalize(scope)(tr).copy(comments = tr.comments) else tr

  def shouldGeneralize(scope: TreeScope): Boolean =
    scope.stack.headOption.fold(false) {
      case _: MethodTree => false // return type
      case _: ClassTree  => false // parent
      case _ => true
    }

  def generalize(scope: TreeScope)(tr: TypeRef): TypeRef =
    if (scope.isAbstract(tr)) tr
    else {
      FollowAliases(scope)(tr) match {
        case dealiasedTr if dealiasedTr.name === tr.name && dealiasedTr.targs.length === tr.targs.length =>
          val generalizedOpt = scope
            ._lookup(dealiasedTr.typeName.parts)
            .collectFirst {
              case (cls: ClassTree, newScope) if cls.tparams.length === tr.targs.length =>
                val newCls = FillInTParams(cls, newScope, dealiasedTr.targs, Empty)

                def noNewMembers: Boolean = {
                  val allParentMemberNames: Set[Name] =
                    parentsResolver(scope, newCls.parents).transitiveParents.flatMap {
                      case (_, parentClass) => parentClass.index
                    }.keySet

                  cls.index.keys.exists(clsMemberName => allParentMemberNames.contains(clsMemberName))
                }

                newCls.parents match {
                  case IArray.exactlyOne(p) if p.name === tr.name && noNewMembers =>
                    // commit at this point
                    generalize(newScope)(p)
                  case _ =>
                    tr
                }
              case _ => tr
            }

          generalizedOpt.getOrElse(tr)

        case _ => tr
      }
    }
}
