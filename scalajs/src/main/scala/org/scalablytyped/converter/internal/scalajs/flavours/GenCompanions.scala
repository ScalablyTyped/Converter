package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.Params.Res
import org.scalablytyped.converter.internal.seqs._

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
class GenCompanions(memberToParam: MemberToParam, findParams: Params) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
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
        case cls: ClassTree if !nameConflict(cls.name) =>
          findParams.forClassTree(
            cls,
            scope / cls,
            memberToParam,
            Params.MaxParamsForMethod,
            acceptNativeTraits = false,
          ) match {
            case Res.Error(_) =>
              List(cls)

            case Res.One(_, params) =>
              val modOpt: Option[ModuleTree] =
                generateCreator(Name.APPLY, params, cls.codePath, cls.tparams)
                  .map(method =>
                    ModuleTree(Nil, cls.name, Nil, Seq(method), NoComments, cls.codePath, isOverride = false),
                  )
                  .filter(ensureNotTooManyStrings)

              List(cls) ++ modOpt

            case Res.Many(paramsMap) =>
              val methods: Seq[MethodTree] =
                paramsMap.flatMap {
                  case (name, params) => generateCreator(name, params, cls.codePath, cls.tparams)
                }(collection.breakOut)

              val modOpt: Option[ModuleTree] =
                Some(ModuleTree(Nil, cls.name, Nil, methods, NoComments, cls.codePath, isOverride = false))
                  .filter(ensureNotTooManyStrings)

              List(cls) ++ modOpt
          }

        case other => List(other)
      })
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(mod: ModuleTree): Boolean = {
    val MaxWeight = 32768 // an estimate. If you see the error again, decrease this

    var stringLength = 0
    TreeTraverse.foreach(mod) {
      case QualifiedName(parts) => parts.foreach(p => stringLength += p.unescaped.length)
      case _                    => ()
    }

    stringLength < MaxWeight
  }

  def generateCreator(
      name:        Name,
      params:      Seq[Param],
      typeCp:      QualifiedName,
      typeTparams: Seq[TypeParamTree],
  ): Option[MethodTree] =
    params match {
      case Nil => None
      case params =>
        val (optionals, inLiterals, Nil) = params.partitionCollect2(
          { case Param(_, Right(f))  => f },
          { case Param(_, Left(str)) => str },
        )
        val typeName = typeCp.parts.last

        val ret = TypeRef(QualifiedName(typeName :: Nil), TypeParamTree.asTypeArgs(typeTparams), NoComments)

        Some(
          MethodTree(
            Annotation.Inline :: Nil,
            ProtectionLevel.Default,
            name,
            typeTparams,
            params.map(_.parameter) :: Nil,
            MemberImpl.Custom(s"""{
                  |  val __obj = js.Dynamic.literal(${inLiterals.mkString(", ")})
                  |${optionals.map(f => "  " + f("__obj")).mkString("\n")}
                  |  __obj.asInstanceOf[${Printer.formatTypeRef(0)(ret)}]
                  |}""".stripMargin),
            ret,
            isOverride = false,
            NoComments,
            typeCp + name,
          ),
        )
    }
}
