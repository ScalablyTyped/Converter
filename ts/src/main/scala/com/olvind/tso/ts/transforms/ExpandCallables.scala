package com.olvind.tso
package ts
package transforms

import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TreeScope.LoopDetector

/**
  * Oh boy. Work around https://github.com/scala-js/scala-js/issues/3435
  * For instance, every time we have this pattern:
  *
  * ```typescript
  * interface I {
  *   foo: I2;
  * }
  * interface I2 {
  *   (): void;
  * }
  * ```
  *
  * We expand the function call so it becomes a method
  * ````
  * interface I {
  *   foo(): void;
  * }
  * ````
  *
  * If not it wouldn't be safe to call from scala since it discards `this`.
  */
object ExpandCallables extends TreeVisitorScopedChanges {
  /* yeah, sorry. This is out of band information because we cannot
      rename the original member until we reach scala :/
   */
  val MarkerComment = Comment("/* Expanded */")

  override def enterTsDeclClass(scope: TreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(scope, x.members))

  override def enterTsDeclInterface(scope: TreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(scope, x.members))

  private def newClassMembers(scope: TreeScope, members: Seq[TsMember]): Seq[TsMember] =
    members.flatMap {
      case m @ TsMemberProperty(cs, level, name, Some(tpe), None, isStatic, isReadonly, false) =>
        callableTypes(scope)(tpe) match {
          case Expand(callables, keepOriginalMember) if callables.nonEmpty =>
            val keptOpt: Option[TsMemberProperty] =
              if (keepOriginalMember || !isReadonly) Some(m.copy(comments = m.comments + MarkerComment)) else None

            val fs: Seq[TsMemberFunction] =
              callables.map {
                case (comments, sig) =>
                  val newCs = comments ++ cs
                  TsMemberFunction(newCs, level, name, sig, isStatic, isReadOnly = true, isOptional = false)
              }

            scope.logger.info(s"Expanded ${name.value} into ${fs.size} methods")

            fs ++ keptOpt
          case _ => m :: Nil
        }

      case other => other :: Nil
    }

  sealed trait Result
  object Result {
    def combine(rs: Seq[Result]): Result = {
      val (expands, _) = rs.partitionCollect {
        case i: Expand => i
      }
      if (expands.nonEmpty) Expand(expands.flatMap(_.callables), expands.exists(_.keepOriginalMember))
      else Noop
    }
  }
  case class Expand(callables: Seq[(Comments, TsFunSig)], keepOriginalMember: Boolean) extends Result
  case object Noop extends Result

  def callableTypes(scope: TreeScope)(tpe: TsType): Result =
    tpe match {
      case x: TsTypeFunction  => Expand((NoComments, x.signature) :: Nil, keepOriginalMember = false)
      case x: TsTypeIntersect => Result.combine(x.types map callableTypes(scope))

      case x: TsTypeObject =>
        val (callables, rest) = x.members.partitionCollect { case TsMemberCall(cs, _, signature) => (cs, signature) }
        if (callables.nonEmpty) Expand(callables, rest.nonEmpty) else Noop

      case typeRef: TsTypeRef if !TsQIdent.BuiltIn(typeRef.name) =>
        scope
          .lookupTypeIncludeScope(typeRef.name)
          .collectFirst {
            case CallableInterface((_i, newScope)) =>
              val ms = AllMembersFor.forInterface(new LoopDetector(), _i, newScope, typeRef.tparams)
              val (callables, rest) = ms.partitionCollect {
                case TsMemberCall(cs, _, signature) => (cs, signature)
              }
              if (callables.nonEmpty) Expand(callables, rest.nonEmpty) else Noop

            case (ta: TsDeclTypeAlias, newScope) =>
              callableTypes(newScope)(FillInTParams(ta, typeRef.tparams).alias)
          }
          .getOrElse(Noop)

      case _: TsTypeUnion       => Noop //todo: think about this
      case _: TsTypeConstructor => Noop //todo may want to do this later
      case _ => Noop
    }

  object CallableInterface {
    def hasCallMember(i: TsDeclInterface): Boolean =
      i.members exists {
        case _: TsMemberCall => true
        case _ => false
      }

    def unapply(x: (TsNamedDecl, TreeScope)): Option[(TsDeclInterface, TreeScope)] =
      x match {
        case (i: TsDeclInterface, s) if hasCallMember(i) => Some((i, s))
        case _ => None
      }
  }
}
