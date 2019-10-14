package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.transforms.Companions
import com.olvind.tso.seqs._

import scala.collection.mutable

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
object ScalaJsReactComponents {
  private val IgnoredProps = Set(Name("key"), Name("children"))

  private object scalaJsReact {
    val ScalaJsReact = Name("ScalaJsReact")

    val japgollyScalajs               = QualifiedName(List(Name("japgolly"))) + Name("scalajs")
    val react                         = japgollyScalajs + Name("react")
    val reactCallback                 = react + Name("Callback")
    val reactChildren                 = react + Name("Children")
    val reactChildrenNone             = reactChildren + Name("None")
    val reactChildrenVarargs          = reactChildren + Name("Varargs")
    val reactJsComponent              = react + Name("JsComponent")
    val reactJsForwardRefComponent    = react + Name("JsForwardRefComponent")
    val reactChildArg                 = react + Name("CtorType") + Name("ChildArg")
    val component                     = react + Name("component")
    val componentUnmountedWithRoot    = component + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val componentJs                   = component + Name("Js")
    val componentJsUnmountedSimple    = componentJs + Name("UnmountedSimple")
    val componentJsMountedWithRawType = componentJs + Name("MountedWithRawType")
    val componentJsRawMounted         = componentJs + Name("RawMounted")
    val vdom                          = japgollyScalajs + Name("vdom")
    val vdomTagMod                    = vdom + Name("TagMod")
    val vdomReactElement              = vdom + Name("VdomElement")
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
      QualifiedName("typings.react.reactMod.ReactElement") -> QualifiedName(" japgolly.scalajs.react.vdom.VdomElement"),
      QualifiedName("typings.react.reactMod.ReactNode") -> QualifiedName("japgolly.scalajs.react.vdom.VdomNode"),
      QualifiedName("typings.react.reactMod.ReactNodeArray") -> QualifiedName("japgolly.scalajs.react.vdom.VdomArray"),
      QualifiedName("typings.react.reactMod.Attributes") -> QualifiedName("japgolly.scalajs.react.vdom.VdomAttr"),
      QualifiedName.ScalaAny -> QualifiedName.Any,
    )

    in match {
      case TypeRef(name, targs, comments) if (name.parts.lastOption.fold(false)(_.value.endsWith("Event"))) =>
        //In jagpolly, events don't take a second type (the Synthetic type)
        val newName = map.getOrElse(name, name)
        TypeRef(newName, targs.take(1).map(typeMapper), comments)
      case TypeRef(name, targs, comments) if (name.parts.lastOption.fold(false)(_.value.endsWith("Element"))) =>
        //There's too many elements to actually map, so it's better to do it here instead of using the map
        val newName = QualifiedName("org.scalajs.dom.raw") + name.parts.last
        TypeRef(newName, targs.map(typeMapper), comments)
      case TypeRef(name, _, _) if (name.parts.mkString(".").startsWith("typings.react")) =>
        //Make sure we don't miss anything that should have been mapped
        throw new Error(s"$name needs to be mapped")
      case TypeRef(name, targs, comments) =>
        //Not a special case, see if there's a match in the map, and regardless, if there's type arguments, we need to loop through those as well
        val newName = map.getOrElse(name, name)
        TypeRef(newName, targs.map(typeMapper), comments)
    }

  }

  private def fieldsFor(scope: TreeScope, attributes: QualifiedName) =
    scope
      .lookup(attributes)
      .collectFirst {
        case (x: ClassTree, newScope) =>
          ParentsResolver(newScope, x).directParents.flatMap(_.members) ++ x.members collect {
            case FieldTree(_, name, Nullable(tpe), _, _, _, _, _) => name -> FollowAliases(newScope)(tpe)
            case FieldTree(_, name, tpe, _, _, _, _, _)           => name -> FollowAliases(newScope)(tpe)
          }
      }
      .fold(Map.empty[Name, TypeRef])(_.toMap)

  private def memberParameter(scope: TreeScope, tree: MemberTree): Option[Param] = {
    val ret = Companions.memberParameter(scope, tree)
    ret match {
      case Some(Param(ParamTree(name, TypeRef.ScalaFunction(paramTypes, resType), default, comments), isOptional, s)) =>
        // rewrite functions returning a Callback so that javascript land can call them
        val mapped = paramTypes.map(typeMapper)

        def fn(obj: String) = {
          val params =
            mapped.zipWithIndex.map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }.mkString(", ")
          val paramRefs = mapped.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")
          val rewrittenFn =
            s"js.Any.fromFunction${mapped.length}((($params) => ${name.value}($paramRefs).runNow()))"
          s"""    if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
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
      case Some(Param(ParamTree(name, tpe, default, comments), isOptional, asString))
          if (tpe.typeName.parts.lastOption.fold(false)(_.value.endsWith("Element"))) =>
        def fn(obj: String) =
          s"""    if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
        Some(Param(ParamTree(name, typeMapper(tpe), default, comments), isOptional, Right(fn)))
      case Some(Param(ParamTree(name, tpe, default, comments), isOptional, asString))
          if (tpe.typeName == QualifiedName("typings.react.reactMod.ReactNode")) =>
        def fn(obj: String) =
          s"""    if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
        Some(Param(ParamTree(name, typeMapper(tpe), default, comments), isOptional, Right(fn)))
      // In addition Consider replacing:
      // Scala collections
      // javascript collections. Only need to rewrite if type parameter is <:< TOJS
      // Other scalajs-react things we need to rewrite
      //  TagOf -> $target.render.rawElement.asInstanceOf[js.Any]
      // Other values. Keep AnyVal below at least CallbackTo
      case Some(Param(parameter, isOptional, asString)) =>
        Some(Param(parameter.copy(tpe = typeMapper(parameter.tpe)), isOptional, asString))
      case _ =>
        ret
    }
  }

  def apply(_scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree = {
    val scope = _scope / tree

    val domFields: Map[Name, TypeRef] = fieldsFor(scope, QualifiedName.React.AllHTMLAttributes) ++
      fieldsFor(scope, QualifiedName.React.SVGAttributes)

    val scalaJsReactModCp = tree.codePath + scalaJsReact.ScalaJsReact

    val scalaJsReactMembers = components.flatMap { c =>
      val componentCp = scalaJsReactModCp + c.fullName

      val props = c.props getOrElse TypeRef.Object

      scope lookup FollowAliases(scope)(props).typeName firstDefined {
        case (_cls: ClassTree, _) if _cls.classType === ClassType.Trait =>
          val cls = TypeRewriterFn(typeMapper).visitClassTree(scope)(_cls)

          val domParams = mutable.ArrayBuffer.empty[FieldTree]

          ConstructObjectOfType(cls, scope, maxNum = Int.MaxValue) {
            case (scope, fieldTree: FieldTree) =>
              /* todo: refactor out a name/type check which ignores optionality */
              val isDom = domFields.get(fieldTree.name) match {
                case Some(tpe) =>
                  FollowAliases(scope)(fieldTree.tpe) match {
                    case Nullable(ftpe) => ftpe.typeName === tpe.typeName
                    case ftpe           => ftpe.typeName === tpe.typeName
                  }
                case None => false
              }
              if (isDom) {
                domParams += fieldTree
                None
              } else memberParameter(scope, fieldTree)
            case (scope, tree) => memberParameter(scope, tree)
          } match {
            case Nil => None
            case params =>
              val domType = domParams
                .firstDefined {
                  case FieldTree(_, _, TypeRef(typeName, tparams, _), _, _, _, _, _)
                      if typeName.parts.last.unescaped.endsWith("Event") && tparams.nonEmpty =>
                    Option(typeMapper(tparams.head))
                  case _ => None
                }
                .getOrElse(TypeRef(QualifiedName("org.scalajs.dom.raw.HTMLElement")))

              val (refTypes, _, optionals, inLiterals, Nil) = params.partitionCollect4(
                { case Param(ParamTree(Name("ref"), tpe, _, _), _, _)                      => tpe },
                { case Param(ParamTree(propName, _, _, _), _, _) if IgnoredProps(propName) => () },
                { case Param(p, _, Right(f))                                               => p -> f },
                { case Param(p, _, Left(str))                                              => p -> str },
              )

              val childrenParam = domParams
                .find(_.name.value == "children")
                .map(
                  p =>
                    ParamTree(
                      name     = p.name,
                      tpe      = TypeRef.Repeated(TypeRef(scalaJsReact.reactChildArg), p.comments),
                      default  = None,
                      comments = NoComments,
                    ),
                )

              def genApply(elem: TypeRef, refTypeOpt: Option[TypeRef]) = {
                val childrenRef = childrenParam match {
                  case Some(_) => TypeRef(scalaJsReact.reactChildrenVarargs)
                  case None    => TypeRef(scalaJsReact.reactChildrenNone)
                }

                val (createWrapper, resultType) = refTypeOpt match {
                  case Some(refType) =>
                    val c =
                      TypeRef(scalaJsReact.reactJsForwardRefComponent, List(props, childrenRef, refType), NoComments)
                    val r =
                      TypeRef(
                        scalaJsReact.componentUnmountedWithRoot,
                        List(props, refType, TypeRef.Unit, props),
                        NoComments,
                      )
                    (c, r)
                  case None =>
                    val c = TypeRef(scalaJsReact.reactJsComponent, List(props, childrenRef, TypeRef.Object), NoComments)
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
                  tparams     = cls.tparams,
                  params      = List(inLiterals.map(_._1) ++ optionals.map(_._1)) ++ childrenParam.map(p => List(p)),
                  impl = {
                    val formattedProps         = Printer.formatTypeRef(0)(props)
                    val formattedComponent     = Component.formatReferenceTo(c.ref, c.componentType)
                    val formattedCreateWrapper = Printer.formatTypeRef(0)(createWrapper)

                    MemberImpl.Custom(
                      s"""{
                         |  val __obj = js.Dynamic.literal(${inLiterals.map(_._2).mkString(", ")})
                         |
                         |  ${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
                         |
                         |  val f = ${formattedCreateWrapper}($formattedComponent)
                         |  f(__obj.asInstanceOf[$formattedProps])${childrenParam.fold("")(_ => "(children: _*)")}
                         |}""".stripMargin,
                    )
                  },
                  resultType = resultType,
                  isOverride = false,
                  comments   = NoComments,
                  codePath   = componentCp + Name.APPLY,
                )
              }

              val members = {
                List(genApply(domType, c.knownRef orElse refTypes.headOption))
              }

              val domWarning =
                if (domParams.isEmpty) NoComments
                else {
                  val details = domParams.map(_.name.unescaped).sorted.mkString(", ")
                  Comments(Comment(s"/* The following DOM/SVG props were specified: $details */\n"))
                }

              Some(
                ModuleTree(
                  annotations = Nil,
                  name        = c.fullName,
                  parents     = Nil,
                  members     = members,
                  comments    = domWarning + CommentData(Markers.VIP),
                  codePath    = componentCp,
                ),
              )
          }

        /* This is a fallback when the props type is complicated. I'm not convinced the result is very useful */
        case (_: ClassTree | _: TypeAliasTree, _) =>
          val mod = ModuleTree(
            annotations = Nil,
            name        = c.fullName,
            parents     = Nil,
            members     = Nil,
            comments    = Comments(CommentData(Markers.VIP)),
            codePath    = componentCp,
          )
          Some(mod)

        case _ => None
      }
    }

    /* Only generate the package if we have mapped any components */
    scalaJsReactMembers match {
      case Nil => tree
      case nonEmpty =>
        tree.withMembers(
          tree.members :+ PackageTree(Nil, scalaJsReact.ScalaJsReact, nonEmpty, NoComments, scalaJsReactModCp),
        )
    }
  }

}
