package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import seqs._

object ExtractClasses extends TransformMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] = {
    val byNames = x.membersByName.flatMap {
      case (name, sameName: Seq[TsNamedDecl]) =>
        extractClasses(scope, sameName, x.membersByName).getOrElse(sameName)
    }

    x.unnamed ++ byNames
  }

  /* avoid generating a class extending from a type parameter, say */
  def isSimpleType(ref: TsTypeRef, s: TsTreeScope): Boolean =
    s.lookupTypeIncludeScope(ref.name).headOption match {
      case Some((_: TsDeclClass | _: TsDeclInterface, _)) =>
        true
      case Some((TsDeclTypeAlias(_, _, _, _, alias: TsTypeRef, _), newScope)) =>
        isSimpleType(alias, newScope)
      case _ => false
    }

  def typeCtorToClass(ownerLoc: JsLocation, ownerCp: CodePath): PartialFunction[TsMember, TsDeclClass] = {
    case TsMemberProperty(
        cs,
        level,
        name,
        Some(
          TsTypeConstructor(TsTypeFunction(TsFunSig(cs1, tparams, params, Some(resultType: TsTypeRef))))
        ),
        None,
        isStatic,
        isReadOnly,
        false
        ) =>
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
            isOptional = false
          )
        ),
        ownerLoc + name,
        ownerCp + name
      )

  }

  private def extractClasses(scope:    TsTreeScope,
                             sameName: Seq[TsNamedDecl],
                             index:    Map[TsIdent, Seq[TsNamedDecl]]): Option[List[TsNamedDecl]] = {
    val (vars, rest: Seq[TsNamedDecl]) =
      sameName.partitionCollect { case x: TsDeclVar => x }

    def existsNamespace: Boolean =
      rest.exists {
        case _: TsDeclNamespace => true;
        case _ => false
      }

    def availableTypeName(potentialName: TsIdent): Option[TsIdent] =
      index.get(potentialName) match {
        case None => Some(potentialName)
        case Some(existings) =>
          val isCollision = existings.exists {
            case _: TsDeclInterface => true;
            case _: TsDeclClass     => true;
            case x: TsDeclTypeAlias => true
            case _ => false
          }
          if (isCollision) None else Some(potentialName)
      }

    vars.toList match {
      case (v @ TsDeclVar(cs, declared, _, name, Some(tpe), None, jsLocation, cp, false)) :: _ =>
        val allMembers = AllMembersFor.forType(scope, LoopDetector.initial)(tpe)

        /* extract named constructors in class into proper classes in a parallel namespace, if possible */
        val namespaceOpt: Option[TsDeclNamespace] =
          if (existsNamespace) None
          else {
            val nameNs    = TsIdentNamespace(name.value)
            val patchedCp = cp.replaceLast(nameNs)

            allMembers.collect(typeCtorToClass(jsLocation, patchedCp)) match {
              case Nil  => None
              case some => Some(TsDeclNamespace(cs, declared, nameNs, some, patchedCp, jsLocation))
            }
          }

        object ValidCtors {
          def unapply(arg: List[TsMemberCtor]): Option[List[(TsMemberCtor, TsTypeRef)]] =
            arg.collect {
              case x @ TsMemberCtor(_, _, TsFunSig(_, _, _, Some(rt: TsTypeRef))) if isSimpleType(rt, scope) => x -> rt
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
                      isOptional = false
                    )
                }

              availableTypeName(name) orElse availableTypeName(TsIdentSimple(name.value + "Cls")) map { clsName =>
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
                  codePath   = cp replaceLast clsName
                )
              }

            case _ => None
          }

        /* make the namespace more discoverable by adding a comment describing the change */
        val newVar: TsDeclVar =
          namespaceOpt match {
            case None => v
            case Some(x) =>
              val msg = s"""/* Extracted nested Instantiables into classes in ${name.value}Ns */\n"""
              v.copy(comments = v.comments + Comment(msg))
          }

        Some(List(newVar) ++ clsOpt ++ namespaceOpt ++ rest)

      case _ => None
    }
  }
}
