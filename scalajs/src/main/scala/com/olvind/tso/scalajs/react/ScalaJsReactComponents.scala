package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.transforms.Companions
import com.olvind.tso.seqs._

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
object ScalaJsReactComponents {
  private object names {
    val ScalaJsReact = Name("ScalaJsReact")
    val children     = Name("children")
    val ref          = Name("ref")
    val key          = Name("key")

    val Ignored = Set(key, children)
  }

  private object scalaJsReact {

    val react:                           QualifiedName = QualifiedName("japgolly.scalajs.react")
    val reactCallback:                   QualifiedName = react + Name("Callback")
    val reactChildren:                   QualifiedName = react + Name("Children")
    val reactChildrenNone:               QualifiedName = reactChildren + Name("None")
    val reactChildrenVarargs:            QualifiedName = reactChildren + Name("Varargs")
    val reactJsComponent:                QualifiedName = react + Name("JsComponent")
    val reactJsForwardRefComponent:      QualifiedName = react + Name("JsForwardRefComponent")
    val reactJsForwardRefComponentForce: QualifiedName = reactJsForwardRefComponent + Name("force")
    val reactChildArg:                   QualifiedName = react + Name("CtorType") + Name("ChildArg")
    val component:                       QualifiedName = react + Name("component")
    val componentUnmountedWithRoot:      QualifiedName = component + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val componentJs:                     QualifiedName = component + Name("Js")
    val componentJsUnmountedSimple:      QualifiedName = componentJs + Name("UnmountedSimple")
    val componentJsMountedWithRawType:   QualifiedName = componentJs + Name("MountedWithRawType")
    val componentJsRawMounted:           QualifiedName = componentJs + Name("RawMounted")
    val vdom:                            QualifiedName = react + Name("vdom")
    val vdomTagMod:                      QualifiedName = vdom + Name("TagMod")
    val vdomReactElement:                QualifiedName = vdom + Name("VdomElement")
    val vdomVdomNode:                    QualifiedName = vdom + Name("VdomNode")
    val vdomVdomNodeCast:                QualifiedName = vdomVdomNode + Name("cast")
  }

  /**
    * We do type rewriting in two phases (for now). The initial rewrite is done in `Companions.memberParameter` below.
    * As can be see from the name, we just reuse what was written for `Companions`.
    *
    * As it stands now, those rewrites are not recursive (ie will rewrite `foo: T`, but not `foo: Promise<T>`), but
    * are more powerful because we can specify how to convert (implicit conversions and whatnot)
    *
    * In addition these here are rewrites here are done recursively, but with the demand that the conversion is a cast.
    *
    * todo: these two approaches should be refactored into one
    */
  private def typeMapper(in: TypeRef): TypeRef = {

    //TODO: SearchCategory::results: js.Array[ComponentClass[SearchResultProps, js.Object]] = null
    //TODO: should instead be results: js.Array[SearchResultProps] = null

    val map = Map(
      QualifiedName("typings.react.reactMod.SyntheticEvent") -> QualifiedName(
        "japgolly.scalajs.react.raw.SyntheticEvent",
      ),
      QualifiedName("typings.react.reactMod.ChangeEvent") -> QualifiedName("japgolly.scalajs.react.ReactEventFrom"),
      QualifiedName("typings.react.reactMod.AnimationEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactAnimationEventFrom",
      ),
      QualifiedName("typings.react.reactMod.ClipboardEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactClipboardEventFrom",
      ),
      QualifiedName("typings.react.reactMod.ComponentState") -> QualifiedName.Object,
      QualifiedName("typings.react.reactMod.CompositionEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactCompositionEventFrom",
      ),
      QualifiedName("typings.react.reactMod.DragEvent") -> QualifiedName("japgolly.scalajs.react.ReactDragEventFrom"),
      QualifiedName("typings.react.reactMod.FocusEvent") -> QualifiedName("japgolly.scalajs.react.ReactFocusEventFrom"),
      QualifiedName("typings.react.reactMod.KeyboardEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactKeyboardEventFrom",
      ),
      QualifiedName("typings.react.reactMod.MouseEvent") -> QualifiedName("japgolly.scalajs.react.ReactMouseEventFrom"),
      QualifiedName("typings.react.reactMod.TouchEvent") -> QualifiedName("japgolly.scalajs.react.ReactTouchEventFrom"),
      QualifiedName("typings.react.reactMod.PointerEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactPointerEventFrom",
      ),
      QualifiedName("typings.react.reactMod.TransitionEvent") -> QualifiedName(
        "japgolly.scalajs.react.ReactTransitionEventFrom",
      ),
      QualifiedName("typings.react.reactMod.UIEvent") -> QualifiedName("japgolly.scalajs.react.ReactUIEventFrom"),
      QualifiedName("typings.react.reactMod.WheelEvent") -> QualifiedName("japgolly.scalajs.react.ReactWheelEventFrom"),
      QualifiedName("typings.react.NativeMouseEvent") -> QualifiedName(
        "japgolly.scalajs.react.raw.SyntheticMouseEvent",
      ),
      QualifiedName("typings.react.reactMod.Component") -> QualifiedName("japgolly.scalajs.react.raw.React.Component"),
      QualifiedName("typings.react.reactMod.ComponentClass") -> QualifiedName(
        "japgolly.scalajs.react.raw.React.ComponentClass",
      ),
      QualifiedName("typings.react.reactMod.ReactDOM") -> QualifiedName("japgolly.scalajs.react.raw.React.ReactDOM"),
      QualifiedName("typings.react.reactMod.ReactElement") -> scalaJsReact.vdomReactElement,
      QualifiedName("typings.react.reactMod.ReactNode") -> scalaJsReact.vdomVdomNode,
      QualifiedName("typings.react.reactMod.ReactNodeArray") -> QualifiedName("japgolly.scalajs.react.vdom.VdomArray"),
      QualifiedName("typings.react.reactMod.Attributes") -> QualifiedName("japgolly.scalajs.react.vdom.VdomAttr"),
      QualifiedName.ScalaAny -> QualifiedName.Any,
    )

    in match {
      case TypeRef(name, targs, comments) if name.parts.lastOption.fold(false)(_.value.endsWith("Event")) =>
        //In jagpolly, events don't take a second type (the Synthetic type)
        val newName = map.getOrElse(name, name)
        TypeRef(newName, targs.take(1).map(typeMapper), comments)
      case TypeRef(name, targs, comments) if name.parts.lastOption.fold(false)(_.value.endsWith("Element")) =>
        //There's too many elements to actually map, so it's better to do it here instead of using the map
        val newName = QualifiedName("org.scalajs.dom.raw") + name.parts.last
        TypeRef(newName, targs.map(typeMapper), comments)
      case TypeRef(name, _, _) if name.parts.mkString(".").startsWith("typings.react") =>
        //Make sure we don't miss anything that should have been mapped
        throw new Error(s"$name needs to be mapped")
      case TypeRef(name, targs, comments) =>
        //Not a special case, see if there's a match in the map, and regardless, if there's type arguments, we need to loop through those as well
        val newName = map.getOrElse(name, name)
        TypeRef(newName, targs.map(typeMapper), comments)
    }

  }

  private def memberParameter(scope: TreeScope, tree: MemberTree): Option[Param] =
    Companions.memberParameter(scope, tree) match {
      case Some(
          Param(ParamTree(name, TypeRef.ScalaFunction(paramTypes, resType @ _), default, comments), isOptional, s @ _),
          ) =>
        // rewrite functions returning a Callback so that javascript land can call them
        val mapped = paramTypes.map(typeMapper)

        def fn(obj: String) = {
          val params =
            mapped.zipWithIndex.map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }.mkString(", ")
          val paramRefs   = mapped.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")
          val rewrittenFn = s"js.Any.fromFunction${mapped.length}((($params) => ${name.value}($paramRefs).runNow()))"
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
        }

        Some(
          Param(
            ParamTree(
              name,
              TypeRef.ScalaFunction(mapped, TypeRef(scalaJsReact.reactCallback), NoComments),
              default,
              comments,
            ),
            isOptional,
            Right(fn),
          ),
        )
      case Some(Param(ParamTree(name, tpe, default, comments), isOptional, _))
          if tpe.typeName.parts.lastOption.fold(false)(_.value.endsWith("Element")) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
        Some(Param(ParamTree(name, typeMapper(tpe), default, comments), isOptional, Right(fn)))
      case Some(Param(ParamTree(name, tpe, default, comments), isOptional, _))
          if tpe.typeName == QualifiedName("typings.react.reactMod.ReactNode") =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
        Some(Param(ParamTree(name, typeMapper(tpe), default, comments), isOptional, Right(fn)))
      // In addition Consider replacing:
      // Scala collections
      // javascript collections. Only need to rewrite if type parameter is <:< TOJS
      // Other scalajs-react things we need to rewrite
      //  TagOf -> $target.render.rawElement.asInstanceOf[js.Any]
      // Other values. Keep AnyVal below at least CallbackTo
      case Some(Param(parameter, isOptional, asString)) =>
        Some(Param(parameter.copy(tpe = typeMapper(parameter.tpe)), isOptional, asString))

      case dontChange => dontChange
    }

  def apply(_scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
    components flatMap generateComponent(tree.codePath + names.ScalaJsReact, _scope / tree) match {
      case Nil => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.ScalaJsReact, nonEmpty, NoComments, tree.codePath + names.ScalaJsReact)
        tree.withMembers(tree.members :+ newPackage)
    }

  def generateComponent(pkgCodePath: QualifiedName, scope: TreeScope)(c: Component): Option[ModuleTree] = {
    // accept components with no props, but not those with too complicated props (type aliases that ExpandTypeMappings doesnt expand yet)
    val propsParamsOpt: Option[(TypeRef, Seq[Param])] =
      c.props match {
        case Some(props) =>
          val paramsOpt: Option[Seq[Param]] =
            scope lookup FollowAliases(scope)(props).typeName collectFirst {
              case (_cls: ClassTree, _) if _cls.classType === ClassType.Trait =>
                val cls = TypeRewriterFn(typeMapper).visitClassTree(scope)(_cls)

                ConstructObjectOfType(cls, scope)(memberParameter)
            }
          paramsOpt.map(ps => props -> ps)
        case None =>
          Some(TypeRef.Object -> Nil)
      }

    propsParamsOpt map {
      case (props, params) =>
        val componentCp = pkgCodePath + c.fullName

        val (refTypes, declaredChildren, _, optionals, inLiterals, Nil) =
          params.partitionCollect5(
            { case Param(ParamTree(names.ref, tpe, _, _), _, _) => tpe },
            // take note of declared children, but saying `ReactNode` should be a noop
            { case Param(ParamTree(names.children, t, _, _), _, _) if t.typeName =/= scalaJsReact.vdomVdomNode => t },
            { case Param(ParamTree(propName, _, _, _), _, _) if names.Ignored(propName)                        => () },
            { case Param(p, _, Right(f))                                                                       => p -> f },
            { case Param(p, _, Left(str))                                                                      => p -> str },
          )

        val childrenParam: ParamTree =
          declaredChildren.headOption match {
            case Some(param) => ParamTree(name = names.children, tpe = param, default = None, comments = param.comments)
            case _ =>
              ParamTree(
                name     = names.children,
                tpe      = TypeRef.Repeated(TypeRef(scalaJsReact.reactChildArg), NoComments),
                default  = None,
                comments = NoComments,
              )
          }

        val applyMethod = {
          val (createWrapper, resultType) = c.knownRef orElse refTypes.headOption match {
            case Some(refType) =>
              val c =
                TypeRef(
                  scalaJsReact.reactJsForwardRefComponentForce,
                  List(props, TypeRef(scalaJsReact.reactChildrenVarargs), refType),
                  NoComments,
                )
              val r =
                TypeRef(
                  scalaJsReact.componentUnmountedWithRoot,
                  List(props, refType, TypeRef.Unit, props),
                  NoComments,
                )
              (c, r)
            case None =>
              val c = TypeRef(
                scalaJsReact.reactJsComponent,
                List(props, TypeRef(scalaJsReact.reactChildrenVarargs), TypeRef.Object),
                NoComments,
              )
              val r = TypeRef(
                scalaJsReact.componentJsUnmountedSimple,
                List(
                  props,
                  TypeRef(
                    scalaJsReact.componentJsMountedWithRawType,
                    List(
                      props,
                      TypeRef.Object,
                      TypeRef(scalaJsReact.componentJsRawMounted, List(props, TypeRef.Object), NoComments),
                    ),
                    NoComments,
                  ),
                ),
                NoComments,
              )
              (c, r)
          }

          MethodTree(
            annotations = Nil,
            level       = ProtectionLevel.Default,
            name        = Name.APPLY,
            tparams     = c.tparams,
            params      = List(inLiterals.map(_._1) ++ optionals.map(_._1)) ++ List(List(childrenParam)),
            impl = {
              val formattedProps         = Printer.formatTypeRef(0)(props)
              val formattedComponent     = Component.formatReferenceTo(c.ref, c.componentType)
              val formattedCreateWrapper = Printer.formatTypeRef(0)(createWrapper)
              val formattedChildren = declaredChildren.headOption match {
                case Some(_) => Printer.formatQN(scalaJsReact.vdomVdomNodeCast) + "(children)"
                case None    => "children: _*"
              }

              MemberImpl.Custom(
                s"""{
               |  val __obj = js.Dynamic.literal(${inLiterals.map(_._2).mkString(", ")})
               |
               |  ${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
               |
               |  val f = $formattedCreateWrapper($formattedComponent)
               |  f(__obj.asInstanceOf[$formattedProps])($formattedChildren)
               |}""".stripMargin,
              )
            },
            resultType = resultType,
            isOverride = false,
            comments   = NoComments,
            codePath   = componentCp + Name.APPLY,
          )
        }

        ModuleTree(
          annotations = Nil,
          name        = c.fullName,
          parents     = Nil,
          members     = List(applyMethod),
          comments    = Comments(CommentData(Markers.VIP)),
          codePath    = componentCp,
        )
    }
  }
}
