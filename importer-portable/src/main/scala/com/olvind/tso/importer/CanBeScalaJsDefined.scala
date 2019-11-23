package com.olvind.tso
package importer

import com.olvind.tso.ts.ParentsResolver.WithParents
import com.olvind.tso.ts._

object CanBeScalaJsDefined {
  def apply(interface: WithParents[TsDeclInterface]): Boolean =
    pred(interface.value) && (interface.parents forall pred)

  def pred(x: HasClassMembers): Boolean =
    x match {
      case _:   TsDeclClass => false
      case int: TsDeclInterface if int.name === TsQIdent.Function.parts.head => false
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
              case x: TsMemberProperty => !x.isStatic && x.name =/= TsIdent.namespaced
              case x: TsMemberFunction => !x.isStatic && x.name =/= TsIdent.Apply && x.name =/= TsIdent.namespaced
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
