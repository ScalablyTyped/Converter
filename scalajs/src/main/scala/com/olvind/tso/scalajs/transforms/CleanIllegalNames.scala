package com.olvind.tso.scalajs.transforms

import com.olvind.tso.scalajs._

object CleanIllegalNames extends SymbolVisitor {
  override def enterFieldSymbol(scope: SymbolScope)(s: FieldSymbol): FieldSymbol =
    s.name match {
      case Name.js | Name.java => s.withSuffix("_")
      case Name("`")           => s.renamed(Name("backtick"))
      case Name("'")           => s.renamed(Name("quote"))
      case _                   => s
    }

  override def enterMethodSymbol(scope: SymbolScope)(s: MethodSymbol): MethodSymbol =
    s.name match {
      case Name.js | Name.java => s.withSuffix("_")
      case Name("`")           => s.renamed(Name("backtick"))
      case Name("'")           => s.renamed(Name("quote"))
      case _                   => s
    }

  override def enterParamSymbol(scope: SymbolScope)(s: ParamSymbol): ParamSymbol =
    s.name match {
      case Name.js | Name.java => s.copy(name = s.name.withSuffix("_"))
      case _                   => s
    }
}
