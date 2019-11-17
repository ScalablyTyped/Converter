package com.olvind.tso
package scalajs
package flavours

trait MemberToParam {
  def apply(scope: TreeScope, x: MemberTree): Option[Param]
}

object MemberToParam {
  object Default extends MemberToParam {
    private val Cast = ".asInstanceOf[js.Any]"

    /* yeah, i know. We'll refactor if we'll do many more rewrites */
    override def apply(scope: TreeScope, x: MemberTree): Option[Param] =
      x match {
        /* fix irritating type inference issue with `js.UndefOr[Double]` where you provide an `Int` */
        case f @ FieldTree(_, name, origTpe, _, _, _, _, _) =>
          FollowAliases(scope)(origTpe) match {
            case Nullable(TypeRef.Double) =>
              val tpe = TypeRef.Union(List(TypeRef.Int, TypeRef.Double), sort = false)
              Some(
                Param(
                  ParamTree(name, isImplicit = false, tpe, Some(TypeRef.`null`), NoComments),
                  Right(
                    obj =>
                      s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}$Cast)""",
                  ),
                ),
              )
            case Nullable(tpe) if IsPrimitive(tpe, scope / x) =>
              Some(
                Param(
                  ParamTree(name, isImplicit = false, TypeRef.UndefOr(tpe), Some(TypeRef.undefined), NoComments),
                  Right(
                    obj =>
                      s"""if (!js.isUndefined(${name.value})) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}$Cast)""",
                  ),
                ),
              )
            case Nullable(TypeRef.Function(paramTypes, retType)) =>
              val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"
              if (paramTypes.contains(TypeRef.Nothing)) None // edge case which doesnt work
              else
                Some(
                  Param(
                    ParamTree(
                      name,
                      isImplicit = false,
                      TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                      Some(TypeRef.`null`),
                      NoComments,
                    ),
                    Right(
                      obj =>
                        s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")($convertedTarget)""",
                    ),
                  ),
                )
            case Nullable(_) =>
              /* Undo effect of FollowAliases above */
              val tpe = Nullable.unapply(origTpe).getOrElse(origTpe) match {
                case TypeRef.Wildcard => TypeRef.Any
                case other            => other
              }

              Some(
                Param(
                  ParamTree(name, isImplicit = false, tpe, Some(TypeRef.`null`), NoComments),
                  Right(
                    obj =>
                      s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}$Cast)""",
                  ),
                ),
              )
            case TypeRef.Function(paramTypes, retType) =>
              val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

              if (paramTypes.contains(TypeRef.Nothing)) None
              else
                Some(
                  Param(
                    ParamTree(
                      name,
                      isImplicit = false,
                      TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                      None,
                      NoComments,
                    ),
                    if (!ScalaNameEscape.needsEscaping(name.unescaped) && f.originalName === name)
                      Left(s"""${name.value} = $convertedTarget""")
                    else
                      Right(
                        obj => s"""$obj.updateDynamic("${f.originalName.unescaped}")($convertedTarget)""",
                      ),
                  ),
                )
            case _ =>
              Some(
                Param(
                  ParamTree(name, isImplicit = false, origTpe, None, NoComments),
                  if (!ScalaNameEscape.needsEscaping(name.unescaped) && f.originalName === name)
                    Left(s"""${name.value} = ${name.value}$Cast""")
                  else
                    Right(
                      obj => s"""$obj.updateDynamic("${f.originalName.unescaped}")(${name.value}$Cast)""",
                    ),
                ),
              )
          }

        case _m: MethodTree =>
          val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.Any), Nil)
          val flattenedParams = m.params.flatten
          val convertedTarget = s"js.Any.fromFunction${flattenedParams.length}(${m.name.value})"

          if (flattenedParams.exists(_.tpe === TypeRef.Nothing)) None // edge case which doesnt work
          else
            Some(
              Param(
                ParamTree(
                  m.name,
                  isImplicit = false,
                  TypeRef.ScalaFunction(flattenedParams.map(p => p.tpe), m.resultType, NoComments),
                  None,
                  NoComments,
                ),
                if (!ScalaNameEscape.needsEscaping(m.name.unescaped) && m.originalName === m.name)
                  Left(s"""${m.name.value} = $convertedTarget""")
                else
                  Right(obj => s"""$obj.updateDynamic("${m.originalName.unescaped}")($convertedTarget)"""),
              ),
            )
      }
  }
}
