package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
final class GenCompanions(memberToProp: MemberToProp, findProps: FindProps) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.exists { case mod: ModuleTree => mod.isNative; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Empty) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case cls: ClassTree if !nameConflict(cls.name) =>
          findProps.forClassTree(
            cls,
            scope / cls,
            memberToProp,
            FindProps.MaxParamsForMethod,
            acceptNativeTraits = false,
          ) match {
            case Res.Error(_) =>
              IArray(cls)

            case Res.One(_, params) =>
              val modOpt: Option[ModuleTree] =
                generateCreator(Name.APPLY, params, cls.codePath, cls.tparams)
                  .map(method =>
                    ModuleTree(Empty, cls.name, Empty, IArray(method), NoComments, cls.codePath, isOverride = false),
                  )
                  .filter(ensureNotTooManyStrings(scope))

              IArray.fromOptions(Some(cls), modOpt)

            case Res.Many(paramsMap) =>
              val methods: IArray[MethodTree] =
                IArray.fromTraversable(paramsMap.flatMap {
                  case (name, params) => generateCreator(name, params, cls.codePath, cls.tparams)
                })

              val modOpt: Option[ModuleTree] =
                Some(ModuleTree(Empty, cls.name, Empty, methods, NoComments, cls.codePath, isOverride = false))
                  .filter(ensureNotTooManyStrings(scope))

              IArray.fromOptions(Some(cls), modOpt)
          }

        case other => IArray(other)
      })
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(scope: TreeScope)(mod: ModuleTree): Boolean = {
    val MaxWeight = 32768 // an estimate. If you see the error again, decrease this

    object Dealias extends TreeTransformation {
      override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = FollowAliases(scope)(s)
    }

    var stringLength = 0

    TreeTraverse.foreach(Dealias.visitModuleTree(scope)(mod)) {
      case name: QualifiedName =>
        name.parts.foreach(p => stringLength += p.unescaped.length)
      case _ => ()
    }

    stringLength < MaxWeight
  }

  def generateCreator(
      name:        Name,
      params:      IArray[Prop],
      typeCp:      QualifiedName,
      typeTparams: IArray[TypeParamTree],
  ): Option[MethodTree] =
    params match {
      case Empty => None
      case props =>
        val (optionals, inLiterals, Empty) = props.partitionCollect2(
          { case Prop(_, Right(f), _)  => f },
          { case Prop(_, Left(str), _) => str },
        )
        val typeName = typeCp.parts.last

        val ret = TypeRef(QualifiedName(IArray(typeName)), TypeParamTree.asTypeArgs(typeTparams), NoComments)

        Some(
          MethodTree(
            IArray(Annotation.Inline),
            ProtectionLevel.Default,
            name,
            typeTparams,
            IArray(props.map(_.parameter)),
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
