package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.ParentsResolver.WithParents
import org.scalablytyped.converter.internal.ts._

object CanBeScalaJsDefined {
  def apply(interface: WithParents[TsDeclInterface]): Boolean =
    pred(interface.value) && (interface.parents forall pred)

  def legalName(name: TsIdent) =
    name =/= TsIdent.Apply && name =/= TsIdent.namespaced && !name.value.startsWith("$")

  def pred(x: HasClassMembers): Boolean =
    x match {
      case _:   TsDeclClass => false
      case int: TsDeclInterface if TsQIdent.Function.parts.head === int.name => false
      case int: TsDeclInterface =>
        val fromUnnamed = int.unnamed.forall {
          case _: TsMemberTypeMapped => false
          case TsMemberIndex(_, _, _, IndexingSingle(_), _, _) => false
          case _                                               => true
        }

        val fromNamed = int.membersByName.forall {
          case (TsIdent.Apply, _) => false
          case (_, Seq(one)) =>
            one match {
              case _: TsMemberCtor | _: TsMemberCall => false
              case x: TsMemberProperty => !x.isStatic && legalName(x.name)
              case x: TsMemberFunction => !x.isStatic && legalName(x.name)
              case _ => true
            }
          case (_, many) =>
            many.forall {
              case x: TsMemberProperty => !x.isStatic // will combine later
              case _ => false
            }
        }

        fromUnnamed && fromNamed
      case _ => false
    }
}
