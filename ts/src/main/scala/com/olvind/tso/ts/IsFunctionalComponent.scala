package com.olvind.tso.ts
import com.olvind.tso.{NoComments, Set}

object IsFunctionalComponent {
  val FunctionalComponent: Set[TsQIdent] = {
    val React = List(TsIdentLibrarySimple("react"), TsIdentModule(None, List("react")))
    Set(
      TsQIdent(React :+ TsIdentNamespace("React") :+ TsIdent("FC")),
      TsQIdent(React :+ TsIdentNamespace("React") :+ TsIdent("SFC")),
      TsQIdent(React :+ TsIdentNamespace("React") :+ TsIdent("StatelessComponent")),
      TsQIdent(React :+ TsIdent("FC")),
      TsQIdent(React :+ TsIdent("SFC")),
      TsQIdent(React :+ TsIdent("StatelessComponent")),
    )
  }

  def apply(tpe: TsType): Boolean = tpe match {
    case TsTypeRef(NoComments, qname, _) => FunctionalComponent(qname)
    case _                               => false
  }
}
