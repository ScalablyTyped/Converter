package com.olvind.tso
package ts
package transforms

/**
  * Simplify
  * ```typescript
  *     type EventHandler<E extends SyntheticEvent<any>> = { bivarianceHack(event: E): void }["bivarianceHack"];
  * ```
  * to
  * ```typescript
  *     type EventHandler<E extends SyntheticEvent<any>> = (event: E) => void;
  * ```
  */
object RemoveBivarianceHacks extends TreeVisitorScopedChanges {

  override def enterTsType(t: TreeScope)(x: TsType): TsType =
    x match {
      case TsTypeLookup(TsTypeObject(Seq(TsMemberFunction(_, _, TsIdent(name1), sig, _, _, _))), Left(TsIdent(name2)))
          if name1 === name2 =>
        t.logger.info(s"Simplified $name1")
        TsTypeFunction(sig)
      case other => other
    }

//  val from = TsTypeLookup(
//    TsTypeObject(
//      List(TsMemberFunction(
//        NoComments,
//        Default,
//        TsIdent("bivarianceHack"),
//        TsFunSig(
//          NoComments,
//          List(),
//          List(TsFunParam(NoComments,
//                          TsIdent("event"),
//                          Some(TsTypeRef(TsQIdent(List(TsIdent("E"))), List())),
//                          isOptional = false)),
//          Some(TsTypeRef(TsQIdent(List(TsIdent("void"))), List()))
//        ),
//        isStatic = false,
//        isReadOnly = false,
//        isOptional = false
//      ))),
//    Left(TsLiteralString("bivarianceHack"))
//  )
//
//  val to = TsTypeFunction(
//    TsFunSig(
//      NoComments,
//      List(),
//      List(
//        TsFunParam(NoComments,
//                   TsIdent("event"),
//                   Some(TsTypeRef(TsQIdent(List(TsIdent("E"))), List())),
//                   isOptional = false)),
//      Some(TsTypeRef(TsQIdent(List(TsIdent("void"))), List()))
//    ))
}
