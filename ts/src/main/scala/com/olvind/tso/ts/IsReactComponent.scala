package com.olvind.tso
package ts

object IsReactComponent {
  val ComponentNames: Set[String] =
    Set(
      "ClassicComponent",
      "ClassicComponentClass",
      "ComponentClass",
      "ComponentType",
      "ExoticComponent",
      "FC",
      "FunctionComponent",
      "LazyExoticComponent",
      "MemoExoticComponent",
      "NamedExoticComponent",
      "ProviderExoticComponent",
      "PureComponent",
      "RefForwardingComponent",
      "SFC",
      "StatelessComponent",
    )

  val React = List(TsIdentLibrarySimple("react"), TsIdentModule(None, List("react")))

  val FunctionalComponent: Set[TsQIdent] =
    ComponentNames.flatMap(
      name => List(TsQIdent(React :+ TsIdentNamespace("React") :+ TsIdent(name)), TsQIdent(React :+ TsIdent(name))),
    )

  def apply(scope: TsTreeScope, tpe: TsType): Boolean = FollowAliases(scope)(tpe) match {
    case TsTypeRef(NoComments, qname, _) => FunctionalComponent(qname)
    case _                               => false
  }
}
