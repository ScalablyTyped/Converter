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
        int.membersByName forall {
          case (TsIdent.Apply, _) => false
          case (_, Seq(one)) =>
            one match {
              case _: TsMemberCtor | _: TsMemberCall => false
              case x: TsMemberProperty => !x.isStatic
              case x: TsMemberFunction => !x.isStatic && x.name =/= TsIdent.Apply
              case _ => true
            }
          case (_, _) => false
        }
      case _ => false
    }
}
