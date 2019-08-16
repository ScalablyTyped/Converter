package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.seqs._
import ConstructObjectOfType.Param

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
object Companions extends TreeTransformation {
  override def enterContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.exists { case mod: ModuleTree => mod.isNative; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Nil) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case cls: ClassTree if cls.classType === ClassType.Trait && cls.isScalaJsDefined && !nameConflict(cls.name) =>
          List(cls) ++ generateModule(scope, cls)
        case other => List(other)
      })
    }

  def generateModule(scope: TreeScope, cls: ClassTree): Option[ModuleTree] =
    ConstructObjectOfType(cls, scope)(memberParameter) match {
      case Nil => None
      case params =>
        val (optionals, inLiterals, Nil) = params.partitionCollect2(
          { case Param(_, _, Right(f))  => f },
          { case Param(_, _, Left(str)) => str },
        )
        val applyRet = TypeRef(
          QualifiedName(cls.name :: Nil),
          cls.tparams.map(tp => TypeRef(QualifiedName(tp.name :: Nil), Nil, NoComments)),
          NoComments,
        )

        Some(
          ModuleTree(
            Nil,
            cls.name,
            Nil,
            Seq(
              MethodTree(
                Annotation.Inline :: Nil,
                ProtectionLevel.Default,
                Name.APPLY,
                cls.tparams,
                params.map(_.parameter) :: Nil,
                MemberImpl.Custom(s"""{
                                       |  val __obj = js.Dynamic.literal(${inLiterals.mkString(", ")})
                                       |${optionals.map(f => "  " + f("__obj")).mkString("\n")}
                                       |  __obj.asInstanceOf[${Printer.formatTypeRef(0)(applyRet)}]
                                       |}""".stripMargin),
                applyRet,
                isOverride = false,
                NoComments,
                cls.codePath + Name.APPLY,
              ),
            ),
            NoComments,
            cls.codePath,
          ),
        )
    }

  /* yeah, i know. We'll refactor if we'll do many more rewrites */
  def memberParameter(scope: TreeScope, x: MemberTree): Param =
    x match {
      /* fix irritating type inference issue with `js.UndefOr[Double]` where you provide an `Int` */
      case f @ FieldTree(_, name, Nullable(TypeRef.Double), _, _, _, _, _) =>
        val tpe = TypeRef.Union(List(TypeRef.Int, TypeRef.Double), sort = false)
        Param(
          ParamTree(name, tpe, Some(TypeRef.`null`), NoComments),
          isOptional = true,
          Right(
            obj =>
              s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}${OptionalCast(
                scope,
                tpe,
              )})""",
          ),
        )
      case f @ FieldTree(_, name, Nullable(tpe), _, _, _, _, _) if IsPrimitive(tpe, scope / x) =>
        Param(
          ParamTree(name, TypeRef.UndefOr(tpe), Some(TypeRef.undefined), NoComments),
          isOptional = true,
          Right(
            obj =>
              s"""if (!js.isUndefined(${name.value})) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}${OptionalCast(
                scope,
                tpe,
              )})""",
          ),
        )

      case f @ FieldTree(_, name, Nullable(TypeRef.Function(paramTypes, retType)), _, _, _, _, _) =>
        val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

        Param(
          ParamTree(name, TypeRef.ScalaFunction(paramTypes, retType, NoComments), Some(TypeRef.`null`), NoComments),
          isOptional = true,
          Right(
            obj =>
              s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")($convertedTarget)""",
          ),
        )

      case f @ FieldTree(_, name, Nullable(_tpe), _, _, _, _, _) =>
        val tpe = if (_tpe === TypeRef.Wildcard) TypeRef.Any else _tpe

        Param(
          ParamTree(name, tpe, Some(TypeRef.`null`), NoComments),
          isOptional = true,
          Right(
            obj =>
              s"""if (${name.value} != null) $obj.updateDynamic("${f.originalName.unescaped}")(${name.value}${OptionalCast(
                scope,
                tpe,
              )})""",
          ),
        )

      case f @ FieldTree(_, name, TypeRef.Function(paramTypes, retType), _, _, _, _, _) =>
        val convertedTarget = s"js.Any.fromFunction${paramTypes.length}(${name.value})"

        Param(
          ParamTree(name, TypeRef.ScalaFunction(paramTypes, retType, NoComments), None, NoComments),
          isOptional = false,
          if (!ScalaNameEscape.needsEscaping(name.unescaped) && f.originalName === name)
            Left(s"""${name.value} = $convertedTarget""")
          else
            Right(
              obj => s"""$obj.updateDynamic("${f.originalName.unescaped}")($convertedTarget)""",
            ),
        )

      case f @ FieldTree(_, name, tpe, _, _, _, _, _) =>
        Param(
          ParamTree(name, tpe, None, NoComments),
          isOptional = false,
          if (!ScalaNameEscape.needsEscaping(name.unescaped) && f.originalName === name)
            Left(s"""${name.value} = ${name.value}${OptionalCast(scope, tpe)}""")
          else
            Right(
              obj => s"""$obj.updateDynamic("${f.originalName.unescaped}")(${name.value}${OptionalCast(scope, tpe)})""",
            ),
        )

      case _m: MethodTree =>
        val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.Any))
        val convertedTarget = s"js.Any.fromFunction${m.params.flatten.length}(${m.name.value})"

        Param(
          ParamTree(
            m.name,
            TypeRef.ScalaFunction(m.params.flatten.map(p => p.tpe), m.resultType, NoComments),
            None,
            NoComments,
          ),
          isOptional = false,
          if (!ScalaNameEscape.needsEscaping(m.name.unescaped) && m.originalName === m.name)
            Left(s"""${m.name.value} = $convertedTarget""")
          else
            Right(obj => s"""$obj.updateDynamic("${m.originalName.unescaped}")($convertedTarget)"""),
        )
    }

  /* `js.|` doesn't extend js.Any */
  private object OptionalCast {
    private val Cast = ".asInstanceOf[js.Any]"

    def apply(scope: TreeScope, tpe: TypeRef): String =
      if (resolvesToUnionOrAbstract(tpe, scope)) {
        Cast
      } else ""

    def resolvesToUnionOrAbstract(tpe: TypeRef, scope: TreeScope): Boolean =
      tpe match {
        case x if scope.tparams.contains(x.typeName.parts.last) => true
        case TypeRef.Union(_)                                   => true
        case TypeRef.UndefOr(_)                                 => true
        case TypeRef.Intersection(types)                        => resolvesToUnionOrAbstract(types.head, scope)
        case other =>
          scope.lookup(other.typeName) collectFirst {
            case (TypeAliasTree(_, _, alias, _, _), newScope) => resolvesToUnionOrAbstract(alias, newScope)
          } getOrElse false
      }
  }
}
