package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TreeScope.LoopDetector

object ResolveTypeQueries extends TreeVisitorScopedChanges {
  override def leaveTsType(t: TreeScope)(x: TsType): TsType =
    x match {
      case xx: TsTypeQuery => resolve(t, xx, new LoopDetector())
      case other => other
    }

  object RewrittenClass {
    def unapply(decl: TsContainerOrDecl): Option[(TsDeclClass, TsTypeConstructor)] =
      decl match {
        case cls: TsDeclClass =>
          val existingCtorOpt: Option[(TsDeclClass, TsTypeConstructor)] =
            cls.members collectFirst {
//            case TsMemberCtor(cs, _, sig) =>
//              (cls, TsTypeConstructor(TsTypeFunction(sig.copy(tparams = cls.tparams ++ sig.tparams))))
              case TsMemberFunction(cs, _, TsIdent.constructor, sig, _, _, _) =>
                (cls,
                 TsTypeConstructor(
                   TsTypeFunction(
                     sig.copy(
                       comments = sig.comments ++ cs,
                       tparams  = cls.tparams ++ sig.tparams,
                       resultType =
                         Some(TsTypeRef(cls.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(sig.tparams)))
                     )
                   )
                 ))
            }

          existingCtorOpt orElse Some(
            (cls,
             TsTypeConstructor(
               TsTypeFunction(
                 TsFunSig(NoComments, Nil, Nil, Some(TsTypeRef(cls.codePath.forceHasPath.codePath, Nil)))
               )
             ))
          )
        case _ => None
      }
  }

  object P extends Picker[TsDeclVar] {
    def pack(tpe: TsType): Some[TsDeclVar] =
      Some(
        TsDeclVar(NoComments,
                  declared = false,
                  readOnly = false,
                  TsIdent.dummy,
                  Some(tpe),
                  None,
                  JsLocation.Zero,
                  CodePath.NoPath,
                  isOptional = false)
      )

    def unapply(t: TsNamedDecl): Option[TsDeclVar] =
      t match {
        case RewrittenClass((_, typeConstructor)) => pack(typeConstructor)
        case TsDeclVar(_, _, _, _, tpe, literal, _, _, _) =>
          tpe match {
            case Some(TsTypeQuery(nested)) => None
            case Some(other)               => pack(other)
            case None =>
              literal flatMap { lit =>
                pack(TsTypeLiteral(lit))
              }
          }
        case TsDeclFunction(_, _, _, sig, _, _) =>
          pack(TsTypeFunction(sig))
        case TsDeclNamespace(_, _, _, members, _, _) =>
          pack(typeObject(members))
        case m @ TsDeclModule(_, _, _, members, _, _) if false =>
          pack(typeObject(members))
        case _ => None
      }
  }

  private def resolve(t: TreeScope, target: TsTypeQuery, loopDetector: LoopDetector): TsType =
    target.expr match {
      case wanted if TsQIdent.BuiltIn(wanted) || TsQIdent.Primitive(wanted) => TsTypeRef(wanted, Nil)
      case wanted =>
        val found = t.`..`.lookupBase(P, wanted)
        val mappedOpt = found.collectFirst {
          case (TsDeclVar(_, _, _, _, Some(tpe), _, _, _, _), _) => tpe
        }
        mappedOpt match {
          case Some(mapped) =>
            t.logger.info(s"Resolved $target")
            mapped
          case None =>
            t.lookupBase(Picker.All, wanted)
            t.logger.warn(s"Couldn't resolve $target")
            TsTypeRef.any
        }
    }
  private def typeObject(members: Seq[TsContainerOrDecl]): TsTypeObject =
    TsTypeObject(members collect {
      case TsDeclFunction(cs, _, name, sig: TsFunSig, _, _) =>
        TsMemberFunction(cs, Default, name, sig, isStatic = false, isReadOnly = true, isOptional = false)
      case TsDeclVar(cs, _, isReadOnly, name, tpe, lit, _, _, isOptional) =>
        TsMemberProperty(cs,
                         Default,
                         name,
                         tpe,
                         lit,
                         isStatic   = false,
                         isReadOnly = isReadOnly,
                         isOptional = isOptional)
      case RewrittenClass((cls, typeConstructor)) =>
        TsMemberProperty(cls.comments,
                         Default,
                         cls.name,
                         Some(typeConstructor),
                         None,
                         isStatic   = false,
                         isReadOnly = false,
                         isOptional = false)
    })
}
