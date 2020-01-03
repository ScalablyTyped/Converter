package org.scalablytyped.converter.internal.ts.transforms

import org.scalablytyped.converter.internal.ts._

object SetJsLocation extends TreeTransformation[JsLocation] {
  override def enterTsDecl(loc: JsLocation)(x: TsDecl): TsDecl =
    x match {
      case xx: HasJsLocation => xx.withJsLocation(loc).asInstanceOf[TsDecl]
      case other => other
    }

  override def enterTsNamedDecl(loc: JsLocation)(x: TsNamedDecl): TsNamedDecl =
    x match {
      case xx: HasJsLocation => xx.withJsLocation(loc).asInstanceOf[TsNamedDecl]
      case other => other
    }

  override def enterTsContainer(loc: JsLocation)(x: TsContainer): TsContainer =
    x match {
      case xx: HasJsLocation => xx.withJsLocation(loc).asInstanceOf[TsContainer]
      case other => other
    }

  override def withTree(t: JsLocation, tree: TsTree): JsLocation = t / tree
}
