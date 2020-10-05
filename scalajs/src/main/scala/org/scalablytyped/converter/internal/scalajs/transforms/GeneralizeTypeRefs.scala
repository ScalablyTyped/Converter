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
object GeneralizeTypeRefs extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
    if (shouldGeneralize(scope)) generalize(scope)(tr).copy(comments = tr.comments) else tr

  def shouldGeneralize(scope: TreeScope): Boolean =
    scope.stack.filterNot(_.isInstanceOf[TypeRef]) match {
      case (_: MethodTree) :: _ => false // return type
      case (_: ClassTree) :: _  => false // parent
      case _ => true
    }

  def generalize(scope: TreeScope)(tr: TypeRef): TypeRef =
    if (scope.isAbstract(tr)) tr
    else
      FollowAliases(scope)(tr) match {
        case dealiasedTr if dealiasedTr.name === tr.name && dealiasedTr.targs.length === tr.targs.length =>
          scope
            ._lookup(dealiasedTr.typeName.parts)
            .collectFirst {
              case (cls: ClassTree, newScope) if cls.tparams.length === tr.targs.length =>
                val newCls = FillInTParams(cls, newScope, dealiasedTr.targs, Empty)
                newCls.parents match {
                  case IArray.exactlyOne(p) if p.name === tr.name =>
                    // commit at this point
                    generalize(newScope)(p)
                  case _ =>
                    tr
                }
              case _ => tr
            }
            .getOrElse(tr)

        case _ => tr
      }
}
