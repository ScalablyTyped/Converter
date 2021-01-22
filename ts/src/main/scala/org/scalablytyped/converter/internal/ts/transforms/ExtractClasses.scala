package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ExtractClasses extends TransformLeaveMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] = {
    val findName = FindAvailableName(x, scope)

    val rewrittenNameds: IArray[TsNamedDecl] =
      x.membersByName.flatMapToIArray {
        case (_, sameName) => extractClasses(scope, sameName, findName).getOrElse(sameName)
      }

    x.unnamed ++ rewrittenNameds
  }

  def extractClasses(
      scope:    TsTreeScope,
      sameName: IArray[TsNamedDecl],
      findName: FindAvailableName,
  ): Option[IArray[TsNamedDecl]] = {
    val (vars, namespaces, classes, rest: IArray[TsNamedDecl]) =
      sameName.partitionCollect3(
        { case x: TsDeclVar       => x },
        { case x: TsDeclNamespace => x },
        { case x: TsDeclClass     => x },
      )

    vars match {
      case IArray.headTail(v @ TsDeclVar(cs, declared, _, name, Some(tpe), None, jsLocation, cp), restVars)
          if classes.isEmpty =>
        val allMembers = AllMembersFor.forType(scope, LoopDetector.initial)(tpe)

        /* extract named constructors inside the value into proper classes in a namespace, if possible */
        val newNamespacesAndV: IArray[TsNamedValueDecl] =
          allMembers.mapNotNone(extractClassFromMember(scope, findName, jsLocation, cp)) match {
            case Empty => namespaces :+ v
            case inferredClasses =>
              val inlinedVar = v.copy(name = TsIdent.namespaced, codePath = cp + TsIdent.namespaced)
              namespaces match {
                case Empty =>
                  IArray(TsDeclNamespace(cs, declared, name, inferredClasses :+ inlinedVar, cp, jsLocation))
                case IArray.headTail(existing, rest) =>
                  existing.copy(members = existing.members ++ inferredClasses :+ inlinedVar) +: rest
              }
          }

        val clsOpt: Option[TsDeclClass] =
          AnalyzedCtors.from(scope, tpe).flatMap {
            case AnalyzedCtors(longestTParams, resultType, ctors) =>
              findName(name).map {
                case (clsName, wasBackup) =>
                  val realCtors: IArray[TsMemberFunction] =
                    ctors.map(ctor =>
                      TsMemberFunction(
                        ctor.comments,
                        ProtectionLevel.Default,
                        TsIdent.constructor,
                        MethodType.Normal,
                        TsFunSig(NoComments, Empty, ctor.params, None),
                        isStatic   = false,
                        isReadOnly = false,
                      ),
                    )

                  val clsCodePath = clsName match {
                    case TsIdent.namespaced => cp
                    case other              => cp.replaceLast(other)
                  }

                  TsDeclClass(
                    comments   = commentFor(wasBackup),
                    declared   = declared,
                    isAbstract = false,
                    name       = clsName,
                    tparams    = longestTParams,
                    parent     = Some(FollowAliases.typeRef(scope)(resultType)),
                    implements = Empty,
                    members    = realCtors,
                    jsLocation = jsLocation,
                    codePath   = clsCodePath,
                  )
              }
            case _ => None
          }

        Some(restVars ++ IArray.fromOption(clsOpt) ++ newNamespacesAndV ++ rest)

      case _ => None
    }
  }

  def commentFor(wasBackup: Boolean): Comments = {
    val msg = ("This class was inferred from a value with a constructor", wasBackup) match {
      case (base, true) =>
        s"/* $base, it was renamed because a distinct type already exists with the same name. */\n"
      case (base, false) =>
        s"/* $base. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */\n"
    }
    Comments(List(CommentData(Markers.ExpandedClass), Comment(msg)))
  }

  def extractClassFromMember(
      scope:    TsTreeScope,
      findName: FindAvailableName,
      ownerLoc: JsLocation,
      ownerCp:  CodePath,
  )(member:     TsMember): Option[TsDeclClass] =
    member match {
      case TsMemberProperty(cs, level, origName, Some(tpe), None, isStatic, isReadOnly) =>
        AnalyzedCtors.from(scope, tpe).flatMap {
          case AnalyzedCtors(longestTParams, resultType, ctors) =>
            findName(origName).map {
              case (name, wasBackup) =>
                val realCtors: IArray[TsMemberFunction] =
                  ctors.map {
                    case TsFunSig(cs1, _, params, _) =>
                      TsMemberFunction(
                        comments   = cs1,
                        level      = level,
                        name       = TsIdent.constructor,
                        methodType = MethodType.Normal,
                        signature  = TsFunSig(NoComments, Empty, params, None),
                        isStatic   = isStatic,
                        isReadOnly = isReadOnly,
                      )
                  }

                TsDeclClass(
                  comments   = cs ++ commentFor(wasBackup),
                  declared   = false,
                  isAbstract = false,
                  name       = name,
                  tparams    = longestTParams,
                  parent     = Some(FollowAliases.typeRef(scope)(resultType)),
                  implements = Empty,
                  members    = realCtors,
                  jsLocation = ownerLoc + origName,
                  codePath   = ownerCp + name,
                )
            }
        }
      case _ => None
    }

  case class AnalyzedCtors(longestTParams: IArray[TsTypeParam], resultType: TsTypeRef, ctors: IArray[TsFunSig])

  object AnalyzedCtors {
    def from(scope: TsTreeScope, tpe: TsType): Option[AnalyzedCtors] = {
      val ctors = findCtors(scope, LoopDetector.initial)(tpe)

      val withSimpleType: IArray[(TsFunSig, TsTypeRef)] =
        ctors.collect {
          case sig @ TsFunSig(_, _, _, Some(rt: TsTypeRef)) if isSimpleType(rt, scope / sig) => sig -> rt
        }

      withSimpleType match {
        case Empty    => None
        case nonEmpty =>
          /* need to take care here, as constructors with fewer type parameters might underspecify,
           * for instance `Array<T>` has a constructor `new(): Array<any>` */
          val (longestTParams: IArray[TsTypeParam], resultType: TsTypeRef) = {
            val max = nonEmpty.maxBy(_._1.tparams.length)
            (max._1.tparams, max._1.resultType.get.asInstanceOf[TsTypeRef])
          }

          /* keep only constructors with compatible type parameters and return type */
          val comforming = nonEmpty.collect {
            case (ctor, _) if longestTParams.startsWith(ctor.tparams) && ctor.resultType.contains(resultType) => ctor
          }

          comforming match {
            case Empty    => None
            case nonEmpty => Some(new AnalyzedCtors(longestTParams, resultType, nonEmpty))
          }
      }
    }

    def findCtors(scope: TsTreeScope, loopDetector: LoopDetector)(tpe: TsType): IArray[TsFunSig] = {
      def from(x: HasClassMembers): IArray[TsFunSig] =
        x.membersByName.get(TsIdent.constructor) match {
          case Some(ctors) =>
            ctors.collect { case x: TsMemberCtor => x.signature.copy(comments = x.signature.comments ++ x.comments) }
          case None => Empty
        }

      FollowAliases(scope)(tpe) match {
        case TsTypeIntersect(types)                 => types.flatMap(findCtors(scope, loopDetector))
        case TsTypeConstructor(TsTypeFunction(sig)) => IArray(sig)
        case tr: TsTypeRef =>
          loopDetector.including(tr, scope) match {
            case Left(()) => Empty
            case Right(newLd) =>
              scope.lookupType(tr.name).flatMap {
                case x: TsDeclInterface =>
                  val xx = FillInTParams(x, tr.tparams)
                  from(xx) ++ xx.inheritance.flatMap(findCtors(scope, newLd))
                case _ => Empty
              }
          }
        case x: TsTypeObject => from(x)
        case _ => Empty
      }
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
    def apply(potentialName: TsIdentSimple): Option[(TsIdentSimple, Boolean)] = {
      def backupName =
        if (potentialName === TsIdent.namespaced) TsIdent.namespacedCls
        else TsIdentSimple(potentialName.value + "Cls")

      availableTypeName(potentialName, wasBackup = false).orElse(availableTypeName(backupName, wasBackup = true))
    }

    def availableTypeName(potentialName: TsIdentSimple, wasBackup: Boolean): Option[(TsIdentSimple, Boolean)] =
      index.get(potentialName) match {
        case None => Some((potentialName, wasBackup))
        case Some(existings) =>
          val isCollision = existings.exists {
            case _: TsDeclInterface => true;
            case _: TsDeclClass     => true;
            case _: TsDeclTypeAlias => true
            case _ => false
          }
          if (isCollision) None else Some((potentialName, wasBackup))
      }
  }
}
