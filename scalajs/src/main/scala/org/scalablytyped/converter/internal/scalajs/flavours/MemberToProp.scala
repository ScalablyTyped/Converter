package org.scalablytyped.converter.internal
package scalajs
package flavours

trait MemberToProp {
  def apply(scope: TreeScope, x: MemberTree): Option[Prop]
}

object MemberToProp {
  def escapeIntoString(name: Name) =
    stringUtils.quote(name.unescaped)

  object Default extends MemberToProp {
    private val Cast = ".asInstanceOf[js.Any]"

    /* yeah, i know. We'll refactor if we'll do many more rewrites */
    override def apply(scope: TreeScope, x: MemberTree): Option[Prop] =
      x match {
        /* fix irritating type inference issue with `js.UndefOr[Double]` where you provide an `Int` */
        case f @ FieldTree(_, name, origTpe, _, _, _, _, _) =>
          FollowAliases(scope)(origTpe) match {
            case Optional(TypeRef.Double) =>
              val tpe = TypeRef.Union(IArray(TypeRef.Int, TypeRef.Double), sort = false)
              Some(
                Prop(
                  ParamTree(name, isImplicit = false, tpe, Some(TypeRef.`null`), NoComments),
                  Right(obj =>
                    s"""if (${name.value} != null) $obj.updateDynamic(${escapeIntoString(f.originalName)})(${name.value}$Cast)""",
                  ),
                  Right(f),
                ),
              )
            case Optional(tpe) if TypeRef.Primitive(TypeRef(Erasure.simplify(scope / x, tpe))) =>
              Some(
                Prop(
                  ParamTree(name, isImplicit = false, TypeRef.UndefOr(tpe), Some(TypeRef.undefined), NoComments),
                  Right(obj =>
                    s"""if (!js.isUndefined(${name.value})) $obj.updateDynamic(${escapeIntoString(f.originalName)})(${name.value}$Cast)""",
                  ),
                  Right(f),
                ),
              )
            case Optional(TypeRef.Function(paramTypes, retType)) =>
              val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"
              if (paramTypes.contains(TypeRef.Nothing)) None // edge case which doesnt work
              else
                Some(
                  Prop(
                    ParamTree(
                      name,
                      isImplicit = false,
                      TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                      Some(TypeRef.`null`),
                      NoComments,
                    ),
                    Right(obj =>
                      s"""if (${name.value} != null) $obj.updateDynamic(${escapeIntoString(f.originalName)})($convertedTarget)""",
                    ),
                    Right(f),
                  ),
                )
            case Optional(_) =>
              /* Undo effect of FollowAliases above */
              val tpe = Optional.unapply(origTpe).getOrElse(origTpe) match {
                case TypeRef.Wildcard => TypeRef.Any
                case other            => other
              }

              Some(
                Prop(
                  ParamTree(name, isImplicit = false, tpe, Some(TypeRef.`null`), NoComments),
                  Right(obj =>
                    s"""if (${name.value} != null) $obj.updateDynamic(${escapeIntoString(f.originalName)})(${name.value}$Cast)""",
                  ),
                  Right(f),
                ),
              )
            case TypeRef.Function(paramTypes, retType) =>
              val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

              if (paramTypes.contains(TypeRef.Nothing)) None
              else
                Some(
                  Prop(
                    ParamTree(
                      name,
                      isImplicit = false,
                      TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                      None,
                      NoComments,
                    ),
                    if (!name.isEscaped && f.originalName === name)
                      Left(s"""${name.value} = $convertedTarget""")
                    else
                      Right(obj => s"""$obj.updateDynamic(${escapeIntoString(f.originalName)})($convertedTarget)"""),
                    Right(f),
                  ),
                )
            case _ =>
              Some(
                Prop(
                  ParamTree(name, isImplicit = false, origTpe, None, NoComments),
                  if (!name.isEscaped && f.originalName === name)
                    Left(s"""${name.value} = ${name.value}$Cast""")
                  else
                    Right(obj => s"""$obj.updateDynamic(${escapeIntoString(f.originalName)})(${name.value}$Cast)"""),
                  Right(f),
                ),
              )
          }

        case _m: MethodTree =>
          val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.Any), Empty)
          val flattenedParams = m.params.flatten
          val convertedTarget = s"js.Any.fromFunction${flattenedParams.length}(${m.name.value})"

          if (flattenedParams.exists(_.tpe === TypeRef.Nothing)) None // edge case which doesnt work
          else
            Some(
              Prop(
                ParamTree(
                  m.name,
                  isImplicit = false,
                  TypeRef.ScalaFunction(flattenedParams.map(p => p.tpe), m.resultType, NoComments),
                  None,
                  NoComments,
                ),
                if (!m.name.isEscaped && m.originalName === m.name)
                  Left(s"""${m.name.value} = $convertedTarget""")
                else
                  Right(obj => s"""$obj.updateDynamic(${escapeIntoString(m.originalName)})($convertedTarget)"""),
                Right(m),
              ),
            )
      }
  }
}
