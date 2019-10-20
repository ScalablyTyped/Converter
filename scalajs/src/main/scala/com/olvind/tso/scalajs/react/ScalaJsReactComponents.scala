package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.react.CastConversion.TypeRewriterCast
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
    val reactReactEventFrom:             QualifiedName = react + Name("ReactEventFrom")
    val component:                       QualifiedName = react + Name("component")
    val componentUnmountedWithRoot:      QualifiedName = component + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val componentJs:                     QualifiedName = component + Name("Js")
    val componentJsUnmountedSimple:      QualifiedName = componentJs + Name("UnmountedSimple")
    val componentJsMountedWithRawType:   QualifiedName = componentJs + Name("MountedWithRawType")
    val componentJsRawMounted:           QualifiedName = componentJs + Name("RawMounted")
    val vdom:                            QualifiedName = react + Name("vdom")
    val vdomTagMod:                      QualifiedName = vdom + Name("TagMod")
    val VdomAttr:                        QualifiedName = vdom + Name("VdomAttr")
    val vdomReactElement:                QualifiedName = vdom + Name("VdomElement")
    val VdomArray:                       QualifiedName = vdom + Name("VdomArray")
    val vdomVdomNode:                    QualifiedName = vdom + Name("VdomNode")
    val vdomVdomNodeCast:                QualifiedName = vdomVdomNode + Name("cast")
    val raw:                             QualifiedName = react + Name("raw")
    val rawReact:                        QualifiedName = raw + Name("React")
    val rawReactChildren:                QualifiedName = rawReact + Name("Children")
    val rawReactComponent:               QualifiedName = rawReact + Name("Component")
    val rawReactComponentClassP:         QualifiedName = rawReact + Name("ComponentClassP")
    val rawReactDOMElement:              QualifiedName = rawReact + Name("DOMElement")
    val rawReactElement:                 QualifiedName = rawReact + Name("Element")
    val rawReactElementType:             QualifiedName = rawReact + Name("ElementType")
    val rawReactNode:                    QualifiedName = rawReact + Name("Node")
    val rawReactRef:                     QualifiedName = rawReact + Name("Ref")

    val scalaJsDomRaw = QualifiedName("org.scalajs.dom.raw")

    val conversions: Seq[CastConversion] = {
      import CastConversion.TParam._
      val _1Element = _1.among(CastConversion.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
      val _2Element = _2.among(CastConversion.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
      val _1Object = _1.among(Set.empty, QualifiedName.Object)

      CastConversion.All ++ Seq(
        CastConversion(QualifiedName.ScalaAny, QualifiedName.Any), // todo: is this needed?
        CastConversion(QualifiedName.WILDCARD, QualifiedName.Any), // todo: this should not leak out here
        CastConversion(QualifiedName.React.ComponentState, QualifiedName.Object),
        CastConversion(QualifiedName.React.ReactDOM, QualifiedName.Any),
        CastConversion(QualifiedName.React.ReactNode, rawReactNode),
        CastConversion(QualifiedName.React.Ref, rawReactRef),
        CastConversion(QualifiedName.React.Component, rawReactComponent, _1, TypeRef.Object),
        CastConversion(QualifiedName.React.ComponentClass, rawReactComponentClassP, _1Object),
        CastConversion(QualifiedName.React.ReactElement, rawReactElement),
        CastConversion(QualifiedName.React.DOMElement, rawReactDOMElement),
        CastConversion(QualifiedName.React.ElementType, rawReactElementType),
        CastConversion(QualifiedName.React.BaseSyntheticEvent, reactReactEventFrom, _2Element),
        CastConversion(QualifiedName.React.ChangeEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.FormEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.InvalidEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.SyntheticEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.AnimationEvent, react + Name("ReactAnimationEventFrom"), _1Element),
        CastConversion(QualifiedName.React.ClipboardEvent, react + Name("ReactClipboardEventFrom"), _1Element),
        CastConversion(QualifiedName.React.CompositionEvent, react + Name("ReactCompositionEventFrom"), _1Element),
        CastConversion(QualifiedName.React.DragEvent, react + Name("ReactDragEventFrom"), _1Element),
        CastConversion(QualifiedName.React.FocusEvent, react + Name("ReactFocusEventFrom"), _1Element),
        CastConversion(QualifiedName.React.KeyboardEvent, react + Name("ReactKeyboardEventFrom"), _1Element),
        CastConversion(QualifiedName.React.MouseEvent, react + Name("ReactMouseEventFrom"), _1Element),
        CastConversion(QualifiedName.React.PointerEvent, react + Name("ReactPointerEventFrom"), _1Element),
        CastConversion(QualifiedName.React.TouchEvent, react + Name("ReactTouchEventFrom"), _1Element),
        CastConversion(QualifiedName.React.TransitionEvent, react + Name("ReactTransitionEventFrom"), _1Element),
        CastConversion(QualifiedName.React.UIEvent, react + Name("ReactUIEventFrom"), _1Element),
        CastConversion(QualifiedName.React.WheelEvent, react + Name("ReactWheelEventFrom"), _1Element),
      )
    }
  }

  val rewriter = TypeRewriterCast(scalaJsReact.conversions)

  private def memberParameter(scope: TreeScope, tree: MemberTree): Option[Param] =
    Companions
      .memberParameter(scope, tree)
      .map(
        /* rewrite types after `memberParameter`, as it's resolving aliases, referencing superclasses and so on */
        p => p.copy(parameter = p.parameter.copy(tpe = rewriter.visitTypeRef(scope)(p.parameter.tpe))),
      ) map {
      case p @ Param(pt @ ParamTree(name, TypeRef.ScalaFunction(paramTypes, _), _, _), _, _) =>
        // rewrite functions returning a Callback so that javascript land can call them
        def fn(obj: String) = {
          val params =
            paramTypes.zipWithIndex
              .map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }
              .mkString(", ")
          val paramRefs = paramTypes.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")
          val rewrittenFn =
            s"js.Any.fromFunction${paramTypes.length}((($params) => ${name.value}($paramRefs).runNow()))"
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
        }

        p.copy(
          parameter = pt.copy(tpe = TypeRef.ScalaFunction(paramTypes, TypeRef(scalaJsReact.reactCallback), NoComments)),
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(scalaJsReact.rawReactElement, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(scalaJsReact.vdomReactElement)),
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(scalaJsReact.rawReactNode, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(scalaJsReact.vdomVdomNode)),
          asString  = Right(fn),
        )

      case dontChange => dontChange
    }

// todo:
//  val map = Map(
//    QualifiedName("typings.react.reactMod.Attributes") -> scalaJsReact.VdomAttr,
//    QualifiedName("typings.react.reactMod.ReactElement") -> scalaJsReact.vdomReactElement,
//    QualifiedName("typings.react.reactMod.ReactNodeArray") -> scalaJsReact.VdomArray,
//    QualifiedName("typings.react.reactMod.ReactNode") -> scalaJsReact.vdomVdomNode,
//  TagOf -> $target.render.rawElement.asInstanceOf[js.Any]
// Other scalajs-react things we need to rewrite?

  def apply(_scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree = {
    val scope = _scope / tree

    components flatMap generateComponent(tree.codePath + names.ScalaJsReact, scope) match {
      case Nil => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.ScalaJsReact, nonEmpty, NoComments, tree.codePath + names.ScalaJsReact)
        tree.withMembers(tree.members :+ newPackage)
    }
  }

  def generateComponent(pkgCodePath: QualifiedName, scope: TreeScope)(c: Component): Option[ModuleTree] = {
    // accept components with no props, but not those with too complicated props (type aliases that ExpandTypeMappings doesnt expand yet)
    val propsParamsOpt: Option[(TypeRef, Seq[Param])] =
      c.props match {
        case Some(props) =>
          val dealiased = FollowAliases(scope)(props)
          val paramsOpt: Option[Seq[Param]] =
            scope lookup dealiased.typeName collectFirst {
              case (cls: ClassTree, newScope) if cls.classType === ClassType.Trait =>
                ConstructObjectOfType(FillInTParams(cls, newScope, dealiased.targs, c.tparams), scope)(memberParameter)
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
