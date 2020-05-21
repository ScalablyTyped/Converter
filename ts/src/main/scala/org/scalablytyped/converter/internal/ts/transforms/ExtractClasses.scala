package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.maps._

object ExtractClasses extends TransformLeaveMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] = {
    val findName = FindAvailableName(x, scope)

    val byNames = x.membersByName.flatMapToIArray {
      case (_, sameName) =>
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
      scope:    TsTreeScope,
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
        Some(FollowAliases.typeRef(scope)(resultType)),
        Empty,
        IArray(
          TsMemberFunction(
            cs1,
            level,
            TsIdent.constructor,
            MethodType.Normal,
            TsFunSig(NoComments, Empty, params, None),
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
          maps.combine(IArray(x1.membersByName, x2.membersByName))
        case _ => x.membersByName
      }
      new FindAvailableName(idx)
    }
  }

  class FindAvailableName private (index: Map[TsIdent, IArray[TsNamedDecl]]) {
    def apply(potentialName: TsIdentSimple): Option[TsIdentSimple] = {
      def backupName =
        if (potentialName === TsIdent.namespaced) TsIdent.namespacedCls
        else TsIdentSimple(potentialName.value + "Cls")

      availableTypeName(potentialName) orElse availableTypeName(backupName)
    }

    def availableTypeName(potentialName: TsIdentSimple): Option[TsIdentSimple] =
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
      sameName: IArray[TsNamedDecl],
      findName: FindAvailableName,
  ): Option[IArray[TsNamedDecl]] = {
    val (vars, namespaces, classes, rest: IArray[TsNamedDecl]) =
      sameName.partitionCollect3({ case x: TsDeclVar   => x }, { case x: TsDeclNamespace => x }, {
        case x:                            TsDeclClass => x
      })

    vars match {
      case IArray.headTail(v @ TsDeclVar(cs, declared, _, name, Some(tpe), None, jsLocation, cp, false), restVars)
          if classes.isEmpty =>
        val allMembers = AllMembersFor.forType(scope, LoopDetector.initial)(tpe)

        /* extract named constructors inside the value into proper classes in a namespace, if possible */
        val newNamespacesAndV: IArray[TsNamedValueDecl] =
          allMembers collect typeCtorToClass(scope, findName, jsLocation, cp) match {
            case IArray.Empty => namespaces :+ v
            case some =>
              val inlinedVar = v.copy(name = TsIdent.namespaced, codePath = cp + TsIdent.namespaced)
              namespaces match {
                case IArray.Empty => IArray(TsDeclNamespace(cs, declared, name, some :+ inlinedVar, cp, jsLocation))
                case IArray.headTail(existing, rest) =>
                  existing.copy(members = existing.members ++ some :+ inlinedVar) +: rest
              }
          }

        object ValidCtors {
          def unapply(arg: IArray[TsMemberCtor]): Option[IArray[(TsMemberCtor, TsTypeRef)]] =
            arg.collect {
              case x @ TsMemberCtor(_, _, sig @ TsFunSig(_, _, _, Some(rt: TsTypeRef)))
                  if isSimpleType(rt, scope / sig) =>
                x -> rt
            }.nonEmptyOpt
        }

        val clsOpt: Option[TsDeclClass] =
          allMembers.collect { case x: TsMemberCtor => x } match {
            case ValidCtors(ctorsBase) =>
              /* need to take care here, as constructors with fewer type parameters might underspecify,
               * for instance `Array<T>` has a constructor `new(): Array<any>` */
              val (longestTParams, resultType) = {
                val max = ctorsBase.maxBy(_._1.signature.tparams.length)
                (max._1.signature.tparams, max._1.signature.resultType.get.asInstanceOf[TsTypeRef])
              }

              /* keep only constructors with compatible type parameters and return type */
              val ctors: IArray[TsMemberFunction] =
                ctorsBase collect {
                  case (ctor, _)
                      if longestTParams.startsWith(ctor.signature.tparams) &&
                        ctor.signature.resultType.contains(resultType) =>
                    TsMemberFunction(
                      ctor.comments ++ ctor.signature.comments,
                      ctor.level,
                      TsIdent.constructor,
                      MethodType.Normal,
                      TsFunSig(NoComments, Empty, ctor.signature.params, None),
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
                  parent     = Some(FollowAliases.typeRef(scope)(resultType)),
                  implements = Empty,
                  members    = ctors,
                  jsLocation = jsLocation,
                  codePath   = cp replaceLast clsName,
                )
              }

            case _ => None
          }

        Some(restVars ++ IArray.fromOption(clsOpt) ++ newNamespacesAndV ++ rest)

      case _ => None
    }
  }
}
