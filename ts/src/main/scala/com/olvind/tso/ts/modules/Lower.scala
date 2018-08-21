package com.olvind.tso
package ts.modules

import com.olvind.tso.ts._

object Lower {
  def decl(d: TsContainerOrDecl): Seq[TsMember] =
    d match {
      case x: TsDeclVar =>
        Seq(
          TsMemberProperty(x.comments, Default, x.name, x.tpe, isStatic = false, isReadOnly = true, isOptional = false)
        )
      case x: TsDeclFunction =>
        Seq(
          TsMemberFunction(x.comments,
                           Default,
                           x.name,
                           x.signature,
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false)
        )
      case x: TsDeclClass =>
        val ctorOpt: Option[TsTypeConstructor] =
          x.members.collectFirst {
            case TsMemberCtor(_, Default, sig) =>
              TsTypeConstructor(TsTypeFunction(sig.copy(tparams = x.tparams ++ sig.tparams)))
            case TsMemberFunction(_, Default, TsIdent.constructor, sig, _, _, _) =>
              TsTypeConstructor(TsTypeFunction(sig.copy(tparams = x.tparams ++ sig.tparams)))
          }

        ctorOpt.to[Seq].map { ctor =>
          TsMemberProperty(x.comments,
                           Default,
                           x.name,
                           Option(ctor),
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false)
        }
      case x: TsDeclModule =>
        Seq(
          TsMemberProperty(x.comments,
                           Default,
                           x.name,
                           Some(TsTypeObject(x.members.flatMap(decl))),
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false)
        )

      case x: TsDeclNamespace =>
        Seq(
          TsMemberProperty(x.comments,
                           Default,
                           x.name,
                           Some(TsTypeObject(x.members.flatMap(decl))),
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false)
        )
      case _ => Nil
    }

  def mod(m: TsDeclModule): TsDeclVar =
    TsDeclVar(
      m.comments,
      declared = true,
      readOnly = true,
      TsIdentSimple(m.name.value),
      Some(TsTypeObject(m.members flatMap decl)),
      None,
      m.jsLocation,
      m.codePath,
      isOptional = false
    )
}
