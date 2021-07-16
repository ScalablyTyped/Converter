package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.ParentsResolver.WithParents
import org.scalablytyped.converter.internal.ts._

/**
  * This is a heuristic.
  *
  * For our purposes, there are two kind of javascript objects:
  * - code (implementation of libraries)
  * - data (may be implemented by user)
  *
  * For the latter, we want to provide different ways of instantiating an instance of the structure,
  *  either through mutable builders or `@ScalaJSDefined` traits.
  *
  */
object IsUserImplementable {
  def apply(interface: WithParents[TsDeclInterface]): Boolean =
    if (interface.unresolved.nonEmpty) false
    else pred(interface.value) && interface.parents.forall(pred)

  def legalName(name: TsIdent): Boolean =
    name =/= TsIdent.Apply && name =/= TsIdent.namespaced

  def pred(x: HasClassMembers): Boolean =
    x match {
      case _:   TsDeclClass => false
      case int: TsDeclInterface if TsQIdent.Function.parts.head === int.name => false
      case int: TsDeclInterface =>
        val fromUnnamed = int.unnamed.forall {
          case _: TsMemberTypeMapped => false
          case TsMemberIndex(_, _, _, Indexing.Single(_), _) => false
          case _                                             => true
        }

        val fromNamed = int.membersByName.forall {
          case (TsIdent.Apply, _) => false
          case (_, sameName)      =>
            // the logic here:
            // if something is declared in typescript with overloads, it's very likely not meant to be user implementable.
            // however, if we have created these overloads (one property and one or more synthetic functions), don't consider those

            val toConsider: IArray[TsMember] =
              sameName
                .collectFirst {
                  case x: TsMemberProperty if x.comments.has[Marker.ExpandedCallables.type] => IArray(x)
                }
                .getOrElse(sameName)

            toConsider match {
              case IArray.exactlyOne(one) =>
                one match {
                  case _: TsMemberCtor | _: TsMemberCall => false
                  case x: TsMemberProperty => !x.isStatic && legalName(x.name)
                  case x: TsMemberFunction => !x.isStatic && legalName(x.name) && x.methodType === MethodType.Normal
                  case _ => true
                }
              case many =>
                many.forall {
                  case x: TsMemberProperty => !x.isStatic // will combine later
                  case _ => false
                }
            }
        }

        fromUnnamed && fromNamed
      case _ => false
    }
}
