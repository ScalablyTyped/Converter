package com.olvind.tso
package ts
package transforms

import com.olvind.tso.seqs._
import com.olvind.tso.ts.TsTreeScope.LoopDetector

object ExtractClasses extends TransformLeaveMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] = {
    val findName = FindAvailableName(x, scope)

    val byNames = x.membersByName.flatMap {
      case (_, sameName: Seq[TsNamedDecl]) =>
        extractClasses(scope, sameName, findName).getOrElse(sameName)
    }

    x.unnamed ++ byNames
  }

  /* avoid generating a class extending from a type parameter, say */
  @scala.annotation.tailrec
  def isSimpleType(ref: TsTypeRef, s: TsTreeScope): Boolean =
    if (s.isAbstract(ref.name)) false
    else
      s.lookupTypeIncludeScope(ref.name).headOption match {
        case Some((_: TsDeclClass | _: TsDeclInterface, _)) =>
          true
        case Some((TsDeclTypeAlias(_, _, _, _, alias: TsTypeRef, _), newScope)) =>
          isSimpleType(alias, newScope)
        case _ => false
      }

  def typeCtorToClass(
      findName: FindAvailableName,
      ownerLoc: JsLocation,
      ownerCp:  CodePath,
  ): PartialFunction[TsMember, TsDeclClass] = {
    case TsMemberProperty(
        cs,
        level,
        origName,
        Some(
          TsTypeConstructor(TsTypeFunction(TsFunSig(cs1, tparams, params, Some(resultType: TsTypeRef)))),
        ),
        None,
        isStatic,
        isReadOnly,
        false,
        ) if findName(origName).isDefined =>
      val name = findName(origName).get
      TsDeclClass(
        cs,
        declared   = false,
        isAbstract = false,
        name,
        tparams,
        Some(resultType),
        Nil,
        List(
          TsMemberFunction(
            cs1,
            level,
            TsIdent.constructor,
            TsFunSig(NoComments, Nil, params, None),
            isStatic,
            isReadOnly,
            isOptional = false,
          ),
        ),
        ownerLoc + origName,
        ownerCp + name,
      )
  }

  object FindAvailableName {
    def apply(x: TsContainer, scope: TsTreeScope): FindAvailableName = {
      val idx = scope.stack match {
        case (x1: TsDeclNamespace) :: (x2: TsContainer) :: _ if x1.name === TsIdent.namespaced =>
          maps.combine(List(x1.membersByName, x2.membersByName))
        case _ => x.membersByName
      }
      new FindAvailableName(idx)
    }
  }

  class FindAvailableName private (index: Map[TsIdent, Seq[TsNamedDecl]]) {
    def apply(potentialName: TsIdent): Option[TsIdent] = {
      def backupName =
        if (potentialName === TsIdent.namespaced) TsIdent.namespacedCls
        else TsIdentSimple(potentialName.value + "Cls")

      availableTypeName(potentialName) orElse availableTypeName(backupName)
    }

    def availableTypeName(potentialName: TsIdent): Option[TsIdent] =
      index.get(potentialName) match {
        case None => Some(potentialName)
        case Some(existings) =>
          val isCollision = existings.exists {
            case _: TsDeclInterface => true;
            case _: TsDeclClass     => true;
            case _: TsDeclTypeAlias => true
            case _ => false
          }
          if (isCollision) None else Some(potentialName)
      }
  }

  private def extractClasses(
      scope:    TsTreeScope,
      sameName: Seq[TsNamedDecl],
      findName: FindAvailableName,
  ): Option[List[TsNamedDecl]] = {
    val (vars, namespaces, rest: Seq[TsNamedDecl]) =
      sameName.partitionCollect2({ case x: TsDeclVar => x }, { case x: TsDeclNamespace => x })

    vars.toList match {
      case (v @ TsDeclVar(cs, declared, _, name, Some(tpe), None, jsLocation, cp, false)) :: restVars =>
        val allMembers = AllMembersFor.forType(scope, LoopDetector.initial)(tpe)

        /* extract named constructors inside the value into proper classes in a namespace, if possible */
        val newNamespacesAndV: Seq[TsNamedValueDecl] =
          allMembers collect typeCtorToClass(findName, jsLocation, cp) match {
            case Nil => namespaces :+ v
            case some =>
              val inlinedVar = v.copy(name = TsIdent.namespaced, codePath = cp + TsIdent.namespaced)
              namespaces match {
                case Nil              => List(TsDeclNamespace(cs, declared, name, some :+ inlinedVar, cp, jsLocation))
                case existing :: rest => existing.copy(members = existing.members ++ some :+ inlinedVar) :: rest
              }
          }

        object ValidCtors {
          def unapply(arg: List[TsMemberCtor]): Option[List[(TsMemberCtor, TsTypeRef)]] =
            arg.collect {
              case x @ TsMemberCtor(_, _, sig @ TsFunSig(_, _, _, Some(rt: TsTypeRef)))
                  if isSimpleType(rt, scope / sig) =>
                x -> rt
            }.nonEmptyOpt
        }

        val clsOpt: Option[TsDeclClass] =
          allMembers.toList.collect { case x: TsMemberCtor => x } match {
            case ValidCtors(ctorsBase) =>
              /* need to take care here, as constructors with fewer type parameters might underspecify,
               * for instance `Array<T>` has a constructor `new(): Array<any>` */
              val (longestTParams, resultType) = {
                val max = ctorsBase.maxBy(_._1.signature.tparams.length)
                (max._1.signature.tparams, max._1.signature.resultType.get.asInstanceOf[TsTypeRef])
              }

              /* keep only constructors with compatible type parameters and return type */
              val ctors: List[TsMemberFunction] =
                ctorsBase collect {
                  case (ctor, _)
                      if longestTParams.startsWith(ctor.signature.tparams) &&
                        ctor.signature.resultType.contains(resultType) =>
                    TsMemberFunction(
                      ctor.comments ++ ctor.signature.comments,
                      ctor.level,
                      TsIdent.constructor,
                      TsFunSig(NoComments, Nil, ctor.signature.params, None),
                      isStatic   = false,
                      isReadOnly = false,
                      isOptional = false,
                    )
                }

              findName(name) map { clsName =>
                TsDeclClass(
                  comments   = NoComments,
                  declared   = declared,
                  isAbstract = false,
                  name       = clsName,
                  tparams    = longestTParams,
                  parent     = Some(resultType),
                  implements = Nil,
                  members    = ctors,
                  jsLocation = jsLocation,
                  codePath   = cp replaceLast clsName,
                )
              }

            case _ => None
          }

        Some(restVars ++ clsOpt ++ newNamespacesAndV ++ rest)

      case _ => None
    }
  }
}
