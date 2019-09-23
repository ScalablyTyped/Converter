package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.IdentifyReactComponents.Component
import com.olvind.tso.seqs._

import scala.collection.mutable

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
object ScalaJsReactComponents {
  private val IgnoredProps = Set(Name("key"), Name("children"))

  object scalaJsReact {
    val ScalaJsReact = Name("ScalaJsReact")
    val Props        = Name("Props")
    val Element      = Name("Element")
    val component    = Name("component")

    /* Fully qualified references to slinky types */
    val japgolly                      = QualifiedName(List(Name("japgolly")))
    val japgollyScalajs: QualifiedName = japgolly + Name("scalajs")
    val japgollyScalajsReact: QualifiedName = japgollyScalajs + Name("react")
    val japgollyScalajsReactVDom: QualifiedName = japgollyScalajs + Name("vdom")
    val TagMod: QualifiedName = japgollyScalajsReactVDom + Name("TagMod")
    val ReactElement: QualifiedName = japgollyScalajsReactVDom + Name("VdomElement")
    val japgollyScalajsReactComponent: QualifiedName = japgollyScalajsReact + Name("component")
    val ReactComponentClass: QualifiedName = japgollyScalajsReactComponent + Name("Component")
    val Children: QualifiedName = japgollyScalajsReact + Name("Children")
    val ChildArg: QualifiedName = japgollyScalajsReact + Name("CtorType") + Name("ChildArg")
    val UnmountedWithRoot: QualifiedName = japgollyScalajsReactComponent + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val callback: QualifiedName = japgollyScalajsReact + Name("Callback")

    //This is probably crap
    val japgollyScalajsWeb: QualifiedName = japgollyScalajs + Name("web")
    val japgollyScalajsWebSvg: QualifiedName = japgollyScalajsWeb + Name("svg")
    val japgollyScalajsWebHtml: QualifiedName = japgollyScalajsWeb + Name("html")
  }

  def ScalaJsReactElement(isSvg: Boolean, name: String): TypeRef =
    TypeRef.Singleton(
      TypeRef(
        (if (isSvg) scalaJsReact.japgollyScalajsWebSvg else scalaJsReact.japgollyScalajsWebHtml) + Name(name) + Name(
          "tag",
        ),
        Nil,
        NoComments,
      ),
    )

  val AnyHtmlElement: TypeRef = ScalaJsReactElement(isSvg = false, "*")
  val AnySvgElement:  TypeRef = ScalaJsReactElement(isSvg = true, "*")

  /**
    * We do type rewriting in two phases (for now). The initial rewrite is done in `Companions.memberParameter` below.
    * As can be see from the name, we just reuse what was written for `Companions`.
    *
    * As it stands now, those rewrites are not recursive (ie will rewrite `foo: T`, but not `foo: Promise<T>`), but
    *  are more powerful because we can specify how to convert (implicit conversions and whatnot)
    *
    * In addition these here are rewrites here are done recursively, but with the demand that the conversion is a cast.
    *
    * todo: these two approaches should be refactored into one
    */

  val reactSyntheticEvents = Set(
    "AnimationEvent",
    "ClipboardEvent",
    "CompositionEvent",
    "DragEvent",
    "FocusEvent",
    "KeyboardEvent",
    "MouseEvent",
    "TouchEvent",
    "PointerEvent",
    "TransitionEvent",
    "UIEvent",
    "WheelEvent"
  )

  def typingsToDomType(src: TypeRef):TypeRef = {
    TypeRef(QualifiedName(List(Name("org"), Name("scalajs"), Name("dom"), Name("raw"), src.name)))
  }

  val ScalaJsReactReplacements: TypeRef => TypeRef = {
    case TypeRef(QualifiedName.React.ReactNode, _, cs)        => TypeRef(scalaJsReact.TagMod, List(TypeRef.ScalaAny), cs)
    case TypeRef(QualifiedName.React.ReactElement, _, cs)     => TypeRef(scalaJsReact.ReactElement, Nil, cs)
    case TypeRef(QualifiedName.React.ReactType, Seq(one), cs) => TypeRef(scalaJsReact.ReactComponentClass, Seq(one), cs)
    case TypeRef(name, targs, cs) if QualifiedName.React.isComponent(name) =>
      TypeRef(scalaJsReact.ReactComponentClass, targs.take(1), cs)
    case TypeRef(name, targs, cs) if name.parts.lastOption.fold(false)(e => reactSyntheticEvents.contains(e.unescaped)) => {
      val nodeType = targs.find(_.name.value.contains("Element")).map(a=>Seq(typingsToDomType(a))).getOrElse(Nil)
      TypeRef(scalaJsReact.japgollyScalajsReact + Name(s"React${name.parts.lastOption.fold("")(_.value)}From"), nodeType, cs)
    }
    case TypeRef(name, targs, cs) =>
      TypeRef(name, targs, cs)
  }

  /* ScalaJs doesnt really support generic components. We hack it in in the `apply` method */
  def stripTargs(tr: TypeRef): TypeRef = tr.copy(targs = tr.targs.map(_ => TypeRef.Any))

  def memberParameter(scope: TreeScope, fieldTree: FieldTree): Option[Param] = {
    //TODO hook up here to rewrite the member parameters
    val ret = Companions.memberParameter(scope, fieldTree)
    ret match {
      case Some(Param(ParamTree(name, TypeRef.ScalaFunction(typeParams, resType), default, comments), isOptional, asString)) =>
        Some(Param(ParamTree(name, TypeRef.ScalaFunction(typeParams.map(ScalaJsReactReplacements), TypeRef(scalaJsReact.callback), NoComments), default, comments), isOptional, asString))
      case _ => ret
    }
  }

  def apply(_scope: TreeScope, tree: ContainerTree): ContainerTree = {
    val scope = _scope / tree

    val domFields: Map[Name, TypeRef] = fieldsFor(scope, QualifiedName.React.AllHTMLAttributes) ++
      fieldsFor(scope, QualifiedName.React.SVGAttributes)

    val allComponents: Seq[Component] =
      IdentifyReactComponents.oneOfEach(scope, tree)

    val scalaJsReactModCp = tree.codePath + scalaJsReact.ScalaJsReact

    val scalaJsReactMembers = allComponents.flatMap { c =>
      val componentCp = scalaJsReactModCp + c.fullName

      val props = c.props getOrElse TypeRef.Object

      def propsAlias(props: TypeRef) =
        TypeAliasTree(scalaJsReact.Props, Nil, stripTargs(props), NoComments, componentCp + scalaJsReact.Props)

      scope lookup FollowAliases(scope)(props).typeName firstDefined {
        case (_cls: ClassTree, _) if _cls.classType === ClassType.Trait =>
          val cls = TypeRewriterFn(ScalaJsReactReplacements).visitClassTree(scope)(_cls)

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
            case (scope, tree) => Companions.memberParameter(scope, tree)
          } match {
            case Nil => None
            case params =>
              val domType = domParams
                .firstDefined {
                  case FieldTree(_, _, TypeRef(typeName, tparams, _), _, _, _, _, _)
                      if typeName.parts.last.unescaped.endsWith("Event") && tparams.nonEmpty =>
                    ElementMapping.get(tparams.head.name.unescaped)
                  case _ => None
                }
                .getOrElse(AnyHtmlElement)

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
                      tpe = TypeRef.Repeated(TypeRef(scalaJsReact.ChildArg), p.comments),
                      default  = None,
                      comments = NoComments,
                    ),
                )
              /**
               *  The `apply` method that the slinky method would normally construct.
               *  We implement it ourselves for flexibility and performance. Otherwise we would need to generate
               *  a case class and suffer macro execution time.
               */
              def genApply(elem: TypeRef, ref: TypeRef) = {
                val ret = TypeRef(scalaJsReact.UnmountedWithRoot, List(props, ref, TypeRef.Unit, props), NoComments)

                MethodTree(
                  annotations = Nil,
                  level       = ProtectionLevel.Default,
                  name        = Name.APPLY,
                  tparams     = cls.tparams,
                  params = List(
                    inLiterals.map(_._1) ++ optionals.map(_._1),
                    childrenParam.fold(List.empty[ParamTree])(p => List(p)),
                  ),
                  impl = MemberImpl.Custom(
                    s"""{
                       |  import japgolly.scalajs.react._
                       |
                       |  val __obj = js.Dynamic.literal(${inLiterals.map(_._2).mkString(", ")})
                       |
                       |  type ${c.name.value}Type = ${ref.typeName.parts.map(_.value).mkString(".")}
                       |
                       |  ${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
                       |
                       |  val props = __obj.asInstanceOf[Props]
                       |  val f = JsForwardRefComponent.force[Props, ${
                      childrenParam.fold(
                         "Children.None",
                       )(p => "Children.Varargs")}, ${c.name.value}Type](js.constructorOf[${c.name.value}Type])
                       |
                       |  f(props)${childrenParam.fold("")(_ => "(children: _*)")}
                       |}""".stripMargin,
                  ),
                  resultType = ret,
                  isOverride = false,
                  comments   = NoComments,
                  codePath   = componentCp + Name.APPLY,
                )
              }

              val members = {
                val refType = stripTargs(c.knownRef orElse refTypes.headOption getOrElse TypeRef.Object)
                c.props match {
                  case Some(props) =>
                    List(genApply(domType, refType), propsAlias(props))
                      //TODO add objectType alias here
                  case None => Nil
                }
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
                  parents = Nil,
                  members = members,
                  comments    = domWarning,
                  codePath    = componentCp,
                ),
              )
          }

        /* This is a fallback when the props type is complicated. I'm not convinced the result is very useful */
        case (_: ClassTree | _: TypeAliasTree, _) =>
          val propsAliasOpt = c.props match {
            case Some(props) => List(propsAlias(props))
            case None => Nil
            }

          val mod = ModuleTree(
            annotations = Nil,
            name        = c.name,
            parents = Nil,
            members = propsAliasOpt,
            comments    = NoComments,
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

  // todo: this was all the mapping i had the energy to do.
  private val ElementMapping = Map(
    "HTMLAnchorElement" -> ScalaJsReactElement(isSvg = false, "a"),
    "HTMLAppletElement" -> AnyHtmlElement,
    "HTMLAreaElement" -> ScalaJsReactElement(isSvg  = false, "area"),
    "HTMLAudioElement" -> ScalaJsReactElement(isSvg = false, "audio"),
    "HTMLBaseElement" -> ScalaJsReactElement(isSvg  = false, "base"),
    "HTMLBaseFontElement" -> AnyHtmlElement,
    "HTMLBodyElement" -> ScalaJsReactElement(isSvg     = false, "body"),
    "HTMLBRElement" -> ScalaJsReactElement(isSvg       = false, "br"),
    "HTMLButtonElement" -> ScalaJsReactElement(isSvg   = false, "button"),
    "HTMLCanvasElement" -> ScalaJsReactElement(isSvg   = false, "canvas"),
    "HTMLDataElement" -> ScalaJsReactElement(isSvg     = false, "data"),
    "HTMLDataListElement" -> ScalaJsReactElement(isSvg = false, "datalist"),
    "HTMLDetailsElement" -> ScalaJsReactElement(isSvg  = false, "details"),
    "HTMLDialogElement" -> ScalaJsReactElement(isSvg   = false, "dialog"),
    "HTMLDirectoryElement" -> AnyHtmlElement,
    "HTMLDivElement" -> ScalaJsReactElement(isSvg   = false, "div"),
    "HTMLDListElement" -> ScalaJsReactElement(isSvg = false, "dl"),
    "HTMLElement" -> AnyHtmlElement,
    "HTMLEmbedElement" -> ScalaJsReactElement(isSvg    = false, "embed"),
    "HTMLFieldSetElement" -> ScalaJsReactElement(isSvg = false, "fieldset"),
    "HTMLFontElement" -> AnyHtmlElement,
    "HTMLFormElement" -> ScalaJsReactElement(isSvg = false, "form"),
    "HTMLFrameElement" -> AnyHtmlElement,
    "HTMLFrameSetElement" -> AnyHtmlElement,
    "HTMLHeadElement" -> ScalaJsReactElement(isSvg = false, "head"),
    "HTMLHeadingElement" -> AnyHtmlElement,
    "HTMLHRElement" -> ScalaJsReactElement(isSvg     = false, "hr"),
    "HTMLHtmlElement" -> ScalaJsReactElement(isSvg   = false, "html"),
    "HTMLIFrameElement" -> ScalaJsReactElement(isSvg = false, "iframe"),
    "HTMLImageElement" -> ScalaJsReactElement(isSvg  = false, "img"),
    "HTMLInputElement" -> ScalaJsReactElement(isSvg  = false, "input"),
    "HTMLLabelElement" -> ScalaJsReactElement(isSvg  = false, "label"),
    "HTMLLegendElement" -> ScalaJsReactElement(isSvg = false, "legend"),
    "HTMLLIElement" -> ScalaJsReactElement(isSvg     = false, "li"),
    "HTMLLinkElement" -> ScalaJsReactElement(isSvg   = false, "link"),
    "HTMLMapElement" -> ScalaJsReactElement(isSvg    = false, "map"),
    "HTMLMarqueeElement" -> AnyHtmlElement,
    "HTMLMediaElement" -> AnyHtmlElement,
    "HTMLMenuElement" -> ScalaJsReactElement(isSvg  = false, "menu"),
    "HTMLMetaElement" -> ScalaJsReactElement(isSvg  = false, "meta"),
    "HTMLMeterElement" -> ScalaJsReactElement(isSvg = false, "meter"),
    "HTMLModElement" -> AnyHtmlElement,
    "HTMLObjectElement" -> ScalaJsReactElement(isSvg    = false, "object"),
    "HTMLOListElement" -> ScalaJsReactElement(isSvg     = false, "ol"),
    "HTMLOptGroupElement" -> ScalaJsReactElement(isSvg  = false, "optgroup"),
    "HTMLOptionElement" -> ScalaJsReactElement(isSvg    = false, "option"),
    "HTMLOutputElement" -> ScalaJsReactElement(isSvg    = false, "output"),
    "HTMLParagraphElement" -> ScalaJsReactElement(isSvg = false, "p"),
    "HTMLParamElement" -> ScalaJsReactElement(isSvg     = false, "param"),
    "HTMLPictureElement" -> ScalaJsReactElement(isSvg   = false, "picture"),
    "HTMLPreElement" -> ScalaJsReactElement(isSvg       = false, "pre"),
    "HTMLProgressElement" -> ScalaJsReactElement(isSvg  = false, "progress"),
    "HTMLQuoteElement" -> ScalaJsReactElement(isSvg     = false, "q"),
    "HTMLScriptElement" -> ScalaJsReactElement(isSvg    = false, "script"),
    "HTMLSelectElement" -> ScalaJsReactElement(isSvg    = false, "select"),
    "HTMLSlotElement" -> AnyHtmlElement,
    "HTMLSourceElement" -> ScalaJsReactElement(isSvg = false, "source"),
    "HTMLSpanElement" -> ScalaJsReactElement(isSvg   = false, "span"),
    "HTMLStyleElement" -> ScalaJsReactElement(isSvg  = false, "style"),
    "HTMLTableCaptionElement" -> AnyHtmlElement,
    "HTMLTableCellElement" -> AnyHtmlElement,
    "HTMLTableColElement" -> AnyHtmlElement,
    "HTMLTableDataCellElement" -> AnyHtmlElement,
    "HTMLTableElement" -> ScalaJsReactElement(isSvg = false, "table"),
    "HTMLTableHeaderCellElement" -> AnyHtmlElement,
    "HTMLTableRowElement" -> AnyHtmlElement,
    "HTMLTableSectionElement" -> AnyHtmlElement,
    "HTMLTemplateElement" -> AnyHtmlElement,
    "HTMLTextAreaElement" -> AnyHtmlElement,
    "HTMLTimeElement" -> AnyHtmlElement,
    "HTMLTitleElement" -> AnyHtmlElement,
    "HTMLTrackElement" -> AnyHtmlElement,
    "HTMLUListElement" -> ScalaJsReactElement(isSvg = false, "ul"),
    "HTMLVideoElement" -> AnyHtmlElement,
    "SVGAElement" -> ScalaJsReactElement(isSvg                = true, "a"),
    "SVGAnimateElement" -> ScalaJsReactElement(isSvg          = true, "animate"),
    "SVGAnimateMotionElement" -> ScalaJsReactElement(isSvg    = true, "animateMotion"),
    "SVGAnimateTransformElement" -> ScalaJsReactElement(isSvg = true, "animateTransform"),
    "SVGAnimationElement" -> AnySvgElement,
    "SVGCircleElement" -> ScalaJsReactElement(isSvg   = true, "circle"),
    "SVGClipPathElement" -> ScalaJsReactElement(isSvg = true, "clipPath"),
    "SVGComponentTransferFunctionElement" -> AnySvgElement,
    "SVGCursorElement" -> ScalaJsReactElement(isSvg = true, "cursor"),
    "SVGDefsElement" -> ScalaJsReactElement(isSvg   = true, "defs"),
    "SVGDescElement" -> ScalaJsReactElement(isSvg   = true, "desc"),
    "SVGElement" -> AnySvgElement,
    "SVGEllipseElement" -> ScalaJsReactElement(isSvg       = true, "ellipse"),
    "SVGFEBlendElement" -> ScalaJsReactElement(isSvg       = true, "feBlend"),
    "SVGFEColorMatrixElement" -> ScalaJsReactElement(isSvg = true, "feColorMatrix"),
    "SVGFEComponentTransferElement" -> AnySvgElement,
    "SVGFECompositeElement" -> AnySvgElement,
    "SVGFEConvolveMatrixElement" -> AnySvgElement,
    "SVGFEDiffuseLightingElement" -> AnySvgElement,
    "SVGFEDisplacementMapElement" -> AnySvgElement,
    "SVGFEDistantLightElement" -> AnySvgElement,
    "SVGFEDropShadowElement" -> AnySvgElement,
    "SVGFEFloodElement" -> AnySvgElement,
    "SVGFEFuncAElement" -> AnySvgElement,
    "SVGFEFuncBElement" -> AnySvgElement,
    "SVGFEFuncGElement" -> AnySvgElement,
    "SVGFEFuncRElement" -> AnySvgElement,
    "SVGFEGaussianBlurElement" -> AnySvgElement,
    "SVGFEImageElement" -> AnySvgElement,
    "SVGFEMergeElement" -> AnySvgElement,
    "SVGFEMergeNodeElement" -> AnySvgElement,
    "SVGFEMorphologyElement" -> AnySvgElement,
    "SVGFEOffsetElement" -> AnySvgElement,
    "SVGFEPointLightElement" -> AnySvgElement,
    "SVGFESpecularLightingElement" -> AnySvgElement,
    "SVGFESpotLightElement" -> AnySvgElement,
    "SVGFETileElement" -> AnySvgElement,
    "SVGFETurbulenceElement" -> AnySvgElement,
    "SVGFilterElement" -> AnySvgElement,
    "SVGForeignObjectElement" -> AnySvgElement,
    "SVGGElement" -> AnySvgElement,
    "SVGGeometryElement" -> AnySvgElement,
    "SVGGradientElement" -> AnySvgElement,
    "SVGGraphicsElement" -> AnySvgElement,
    "SVGImageElement" -> AnySvgElement,
    "SVGLinearGradientElement" -> AnySvgElement,
    "SVGLineElement" -> AnySvgElement,
    "SVGMarkerElement" -> AnySvgElement,
    "SVGMaskElement" -> AnySvgElement,
    "SVGMetadataElement" -> AnySvgElement,
    "SVGPathElement" -> AnySvgElement,
    "SVGPatternElement" -> AnySvgElement,
    "SVGPolygonElement" -> AnySvgElement,
    "SVGPolylineElement" -> AnySvgElement,
    "SVGRadialGradientElement" -> AnySvgElement,
    "SVGRectElement" -> AnySvgElement,
    "SVGScriptElement" -> AnySvgElement,
    "SVGStopElement" -> AnySvgElement,
    "SVGStyleElement" -> AnySvgElement,
    "SVGSVGElement" -> AnySvgElement,
    "SVGSwitchElement" -> AnySvgElement,
    "SVGSymbolElement" -> AnySvgElement,
    "SVGTextContentElement" -> AnySvgElement,
    "SVGTextElement" -> AnySvgElement,
    "SVGTextPathElement" -> AnySvgElement,
    "SVGTextPositioningElement" -> AnySvgElement,
    "SVGTitleElement" -> AnySvgElement,
    "SVGTSpanElement" -> AnySvgElement,
    "SVGUseElement" -> AnySvgElement,
    "SVGViewElement" -> AnySvgElement,
  )

}
