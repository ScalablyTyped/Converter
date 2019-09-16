package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso
import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.IdentifyReactComponents.Component
import com.olvind.tso.seqs._

import scala.collection.mutable

object SlinkyComponents {
  val Slinky                   = Name("Slinky")
  val Props                    = Name("Props")
  val Element                  = Name("Element")
  val RefType                  = Name("RefType")
  val component                = Name("component")
  val ref                      = Name("ref")
  val Ignore                   = Set(Name("key"), Name("children"))
  val SlinkyCore               = QualifiedName(List(Name("slinky"), Name("core")))
  val ExternalComponentProps   = SlinkyCore + Name("ExternalComponentWithAttributesWithRefType")
  val ExternalComponentNoProps = SlinkyCore + Name("ExternalComponentNoPropsWithAttributesWithRefType")
  val BuildingComponent        = SlinkyCore + Name("BuildingComponent")
  val TagElement               = SlinkyCore + Name("TagElement")
  val SlinkyCoreFacade         = SlinkyCore + Name("facade")
  val SlinkyWeb                = QualifiedName(List(Name("slinky"), Name("web")))
  val SlinkyWebSvg             = SlinkyWeb + Name("svg")
  val SlinkyWebHtml            = SlinkyWeb + Name("html")

  val ExternalComponentPropsCls = ClassTree(
    Nil,
    ExternalComponentProps.parts.last,
    Seq(
      TypeParamTree(Name("E"), Some(TypeRef(TagElement)), NoComments),
      TypeParamTree(Name("R"), Some(TypeRef.Object), NoComments),
    ),
    Nil,
    Nil,
    List(
      TypeAliasTree(Props, Nil, TypeRef.Any, NoComments, ExternalComponentProps + Props),
      TypeAliasTree(Element, Nil, TypeRef(Name("E")), NoComments, ExternalComponentProps + Element),
      TypeAliasTree(RefType, Nil, TypeRef(Name("R")), NoComments, ExternalComponentProps + RefType),
    ),
    ClassType.Class,
    isSealed = false,
    NoComments,
    ExternalComponentProps,
  )

  val ExternalComponentNoPropsCls = ClassTree(
    Nil,
    ExternalComponentNoProps.parts.last,
    Seq(
      TypeParamTree(Name("E"), Some(TypeRef(TagElement)), NoComments),
      TypeParamTree(Name("R"), Some(TypeRef.Object), NoComments),
    ),
    Nil,
    Nil,
    List(
      TypeAliasTree(Props, Nil, TypeRef.Any, NoComments, ExternalComponentNoProps + Props),
      TypeAliasTree(Element, Nil, TypeRef(Name("E")), NoComments, ExternalComponentNoProps + Element),
      TypeAliasTree(RefType, Nil, TypeRef(Name("R")), NoComments, ExternalComponentNoProps + RefType),
    ),
    ClassType.Class,
    isSealed = false,
    NoComments,
    ExternalComponentNoProps,
  )

  def SlinkyElement(isSvg: Boolean, name: String): TypeRef =
    TypeRef.Singleton(
      TypeRef(
        (if (isSvg) SlinkyWebSvg else SlinkyWebHtml) + Name(name) + Name("tag"),
        Nil,
        NoComments,
      ),
    )

  val AnyHtmlElement: TypeRef = SlinkyElement(isSvg = false, "*")
  val AnySvgElement:  TypeRef = SlinkyElement(isSvg = true, "*")

  def React(name: String, tparams: Seq[TypeRef] = Nil): QualifiedName =
    QualifiedName(List(ScalaConfig.outputPkg, Name("react"), Name("reactMod"), Name(name)))

  val ReactNode         = React("ReactNode")
  val ReactElement      = React("ReactElement")
  val ReactType         = React("ReactType")
  val AllHTMLAttributes = React("AllHTMLAttributes")
  val SVGAttributes     = React("SVGAttributes")

  val SlinkyReplacements: TypeRef => TypeRef = {
    case TypeRef(ReactNode, _, cs)    => TypeRef(SlinkyCore + Name("TagMod"), List(TypeRef.ScalaAny), cs)
    case TypeRef(ReactElement, _, cs) => TypeRef(SlinkyCoreFacade + Name("ReactElement"), Nil, cs)
    case TypeRef(ReactType, Seq(one), cs) =>
      TypeRef(SlinkyCore + Name("ReactComponentClass"), Seq(one), cs)
    case TypeRef(name, targs, cs) if IdentifyReactComponents.Names.isComponent(name) =>
      TypeRef(SlinkyCore + Name("ReactComponentClass"), targs.take(1), cs)
    case other => other
  }

  /* Slinky doesnt really support generic components. We hack it in in the `apply` method */
  def stripTargs(tr: TypeRef): TypeRef = tr.copy(targs = tr.targs.map(_ => TypeRef.Any))

  def apply(_scope: TreeScope, tree: ContainerTree): ContainerTree = {
    val scope = _scope / tree

    val domFields: Map[Name, TypeRef] = fieldsFor(scope, AllHTMLAttributes) ++ fieldsFor(scope, SVGAttributes)

    val allComponents: Seq[Component] =
      IdentifyReactComponents.oneOfEach(scope, tree)

    val slinkyModCp = tree.codePath + Slinky

    val slinkyMembers = allComponents.flatMap { c =>
      val componentCp = slinkyModCp + c.fullName

      val componentField = FieldTree(
        Nil,
        component,
        TypeRef.Union(List(TypeRef.String, TypeRef.Object), sort = false),
        MemberImpl.Custom(
          Component.formatReferenceTo(stripTargs(c.ref), c.componentType) + ".asInstanceOf[String | js.Object]",
        ),
        isReadOnly = true,
        isOverride = true,
        NoComments,
        componentCp + component,
      )
      val props = c.props getOrElse TypeRef.Object

      def propsAlias(props: TypeRef) =
        TypeAliasTree(Props, Nil, stripTargs(props), NoComments, componentCp + Props)

      scope lookup FollowAliases(scope)(props).typeName firstDefined {
        case (_cls: ClassTree, _) if _cls.classType === ClassType.Trait =>
          val cls = TypeRewriterFn(SlinkyReplacements).visitClassTree(scope)(_cls)

          val domParams = mutable.ArrayBuffer.empty[FieldTree]

          ConstructObjectOfType(cls, scope, maxNum = Int.MaxValue) {
            case (scope, fieldTree: FieldTree) =>
              val isDom = domFields.get(fieldTree.name) match {
                case Some(tpe) =>
                  fieldTree.tpe match {
                    case Nullable(ftpe) => ftpe.typeName === tpe.typeName
                    case ftpe           => ftpe.typeName === tpe.typeName
                  }
                case None => false
              }
              if (isDom) {
                domParams += fieldTree
                None
              } else Companions.memberParameter(scope, fieldTree)
            case (scope, tree) => Companions.memberParameter(scope, tree)
          } match {
            case Nil => None
            case params =>
              val domType = domParams
                .firstDefined {
                  case FieldTree(_, _, TypeRef(typeName, Seq(elemType), _), _, _, _, _, _)
                      if typeName.parts.last.unescaped.endsWith("Event") =>
                    ElementMapping.get(elemType.name.unescaped)
                  case _ => None
                }
                .getOrElse(AnyHtmlElement)

              val (refTypes, _, optionals, inLiterals, Nil) = params.partitionCollect4(
                { case Param(ParamTree(`ref`, tpe, _, _), _, _)                      => tpe },
                { case Param(ParamTree(propName, _, _, _), _, _) if Ignore(propName) => () },
                { case Param(p, _, Right(f))                                         => p -> f },
                { case Param(p, _, Left(str))                                        => p -> str },
              )

              def genApply(elem: TypeRef, ref: TypeRef) = {
                val ret  = TypeRef(BuildingComponent, List(elem, ref), NoComments)
                val cast = if (ref.targs.nonEmpty) s".asInstanceOf[${Printer.formatTypeRef(0)(ret)}]" else ""

                MethodTree(
                  Nil,
                  ProtectionLevel.Default,
                  Name.APPLY,
                  cls.tparams,
                  List(inLiterals.map(_._1) ++ optionals.map(_._1)),
                  MemberImpl.Custom(s"""{
                                         |  val __obj = js.Dynamic.literal(${inLiterals.map(_._2).mkString(", ")})
                                         |${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
                                         |  super.apply(__obj.asInstanceOf[Props])$cast
                                         |}""".stripMargin),
                  ret,
                  isOverride = false,
                  NoComments,
                  componentCp + Name.APPLY,
                )
              }

              val (parent, members) = {
                val refType = stripTargs(c.knownRef orElse refTypes.headOption getOrElse TypeRef.Object)
                c.props match {
                  case Some(props) =>
                    (
                      TypeRef(ExternalComponentProps, List(domType, refType), NoComments),
                      List(genApply(domType, refType), propsAlias(props)),
                    )
                  case None => (TypeRef(ExternalComponentNoProps, List(domType, refType), NoComments), Nil)
                }
              }

              val comments =
                if (domParams.isEmpty) tso.NoComments
                else
                  Comments(
                    Comment(
                      s"/* The following DOM/SVG props were specified: ${domParams.map(_.name.unescaped).mkString(", ")} */\n",
                    ),
                  )

              Some(
                ModuleTree(
                  annotations = Nil,
                  name        = c.fullName,
                  parents     = List(parent),
                  members     = List(componentField) ++ members,
                  comments    = comments,
                  codePath    = componentCp,
                ),
              )
          }

        case (_: ClassTree | _: TypeAliasTree, _) =>
          val (parent, propsAliasOpt) = {
            val refType = stripTargs(c.knownRef getOrElse TypeRef.Object)
            val domType = AnyHtmlElement
            c.props match {
              case Some(props) =>
                (TypeRef(ExternalComponentProps, List(domType, refType), NoComments), List(propsAlias(props)))
              case None => (TypeRef(ExternalComponentNoProps, List(domType, refType), NoComments), Nil)
            }
          }

          val mod = ModuleTree(
            annotations = Nil,
            name        = c.name,
            parents     = List(parent),
            members     = List(componentField) ++ propsAliasOpt,
            comments    = NoComments,
            codePath    = componentCp,
          )
          Some(mod)

        case _ => None
      }
    }

    slinkyMembers match {
      case Nil      => tree
      case nonEmpty => tree.withMembers(tree.members :+ PackageTree(Nil, Slinky, nonEmpty, NoComments, slinkyModCp))
    }
  }

  private def fieldsFor(scope: TreeScope, attributes: QualifiedName) =
    scope
      .lookup(attributes)
      .collectFirst {
        case (x: ClassTree, newScope) =>
          ParentsResolver(newScope, x).directParents.flatMap(_.members) ++ x.members collect {
            case FieldTree(_, name, Nullable(tpe), _, _, _, _, _) => name -> tpe
            case FieldTree(_, name, tpe, _, _, _, _, _)           => name -> tpe
          }
      }
      .fold(Map.empty[Name, TypeRef])(_.toMap)

  // todo: this was all the mapping i had the energy to do.
  val ElementMapping = Map(
    "HTMLAnchorElement" -> SlinkyElement(isSvg = false, "a"),
    "HTMLAppletElement" -> AnyHtmlElement,
    "HTMLAreaElement" -> SlinkyElement(isSvg  = false, "area"),
    "HTMLAudioElement" -> SlinkyElement(isSvg = false, "audio"),
    "HTMLBaseElement" -> SlinkyElement(isSvg  = false, "base"),
    "HTMLBaseFontElement" -> AnyHtmlElement,
    "HTMLBodyElement" -> SlinkyElement(isSvg     = false, "body"),
    "HTMLBRElement" -> SlinkyElement(isSvg       = false, "br"),
    "HTMLButtonElement" -> SlinkyElement(isSvg   = false, "button"),
    "HTMLCanvasElement" -> SlinkyElement(isSvg   = false, "canvas"),
    "HTMLDataElement" -> SlinkyElement(isSvg     = false, "data"),
    "HTMLDataListElement" -> SlinkyElement(isSvg = false, "datalist"),
    "HTMLDetailsElement" -> SlinkyElement(isSvg  = false, "details"),
    "HTMLDialogElement" -> SlinkyElement(isSvg   = false, "dialog"),
    "HTMLDirectoryElement" -> AnyHtmlElement,
    "HTMLDivElement" -> SlinkyElement(isSvg   = false, "div"),
    "HTMLDListElement" -> SlinkyElement(isSvg = false, "dl"),
    "HTMLElement" -> AnyHtmlElement,
    "HTMLEmbedElement" -> SlinkyElement(isSvg    = false, "embed"),
    "HTMLFieldSetElement" -> SlinkyElement(isSvg = false, "fieldset"),
    "HTMLFontElement" -> AnyHtmlElement,
    "HTMLFormElement" -> SlinkyElement(isSvg = false, "form"),
    "HTMLFrameElement" -> AnyHtmlElement,
    "HTMLFrameSetElement" -> AnyHtmlElement,
    "HTMLHeadElement" -> SlinkyElement(isSvg = false, "head"),
    "HTMLHeadingElement" -> AnyHtmlElement,
    "HTMLHRElement" -> SlinkyElement(isSvg     = false, "hr"),
    "HTMLHtmlElement" -> SlinkyElement(isSvg   = false, "html"),
    "HTMLIFrameElement" -> SlinkyElement(isSvg = false, "iframe"),
    "HTMLImageElement" -> SlinkyElement(isSvg  = false, "img"),
    "HTMLInputElement" -> SlinkyElement(isSvg  = false, "input"),
    "HTMLLabelElement" -> SlinkyElement(isSvg  = false, "label"),
    "HTMLLegendElement" -> SlinkyElement(isSvg = false, "legend"),
    "HTMLLIElement" -> SlinkyElement(isSvg     = false, "li"),
    "HTMLLinkElement" -> SlinkyElement(isSvg   = false, "link"),
    "HTMLMapElement" -> SlinkyElement(isSvg    = false, "map"),
    "HTMLMarqueeElement" -> AnyHtmlElement,
    "HTMLMediaElement" -> AnyHtmlElement,
    "HTMLMenuElement" -> SlinkyElement(isSvg  = false, "menu"),
    "HTMLMetaElement" -> SlinkyElement(isSvg  = false, "meta"),
    "HTMLMeterElement" -> SlinkyElement(isSvg = false, "meter"),
    "HTMLModElement" -> AnyHtmlElement,
    "HTMLObjectElement" -> SlinkyElement(isSvg    = false, "object"),
    "HTMLOListElement" -> SlinkyElement(isSvg     = false, "ol"),
    "HTMLOptGroupElement" -> SlinkyElement(isSvg  = false, "optgroup"),
    "HTMLOptionElement" -> SlinkyElement(isSvg    = false, "option"),
    "HTMLOutputElement" -> SlinkyElement(isSvg    = false, "output"),
    "HTMLParagraphElement" -> SlinkyElement(isSvg = false, "p"),
    "HTMLParamElement" -> SlinkyElement(isSvg     = false, "param"),
    "HTMLPictureElement" -> SlinkyElement(isSvg   = false, "picture"),
    "HTMLPreElement" -> SlinkyElement(isSvg       = false, "pre"),
    "HTMLProgressElement" -> SlinkyElement(isSvg  = false, "progress"),
    "HTMLQuoteElement" -> SlinkyElement(isSvg     = false, "q"),
    "HTMLScriptElement" -> SlinkyElement(isSvg    = false, "script"),
    "HTMLSelectElement" -> SlinkyElement(isSvg    = false, "select"),
    "HTMLSlotElement" -> AnyHtmlElement,
    "HTMLSourceElement" -> SlinkyElement(isSvg = false, "source"),
    "HTMLSpanElement" -> SlinkyElement(isSvg   = false, "span"),
    "HTMLStyleElement" -> SlinkyElement(isSvg  = false, "style"),
    "HTMLTableCaptionElement" -> AnyHtmlElement,
    "HTMLTableCellElement" -> AnyHtmlElement,
    "HTMLTableColElement" -> AnyHtmlElement,
    "HTMLTableDataCellElement" -> AnyHtmlElement,
    "HTMLTableElement" -> SlinkyElement(isSvg = false, "table"),
    "HTMLTableHeaderCellElement" -> AnyHtmlElement,
    "HTMLTableRowElement" -> AnyHtmlElement,
    "HTMLTableSectionElement" -> AnyHtmlElement,
    "HTMLTemplateElement" -> AnyHtmlElement,
    "HTMLTextAreaElement" -> AnyHtmlElement,
    "HTMLTimeElement" -> AnyHtmlElement,
    "HTMLTitleElement" -> AnyHtmlElement,
    "HTMLTrackElement" -> AnyHtmlElement,
    "HTMLUListElement" -> SlinkyElement(isSvg = false, "ul"),
    "HTMLVideoElement" -> AnyHtmlElement,
    "SVGAElement" -> SlinkyElement(isSvg                = true, "a"),
    "SVGAnimateElement" -> SlinkyElement(isSvg          = true, "animate"),
    "SVGAnimateMotionElement" -> SlinkyElement(isSvg    = true, "animateMotion"),
    "SVGAnimateTransformElement" -> SlinkyElement(isSvg = true, "animateTransform"),
    "SVGAnimationElement" -> AnySvgElement,
    "SVGCircleElement" -> SlinkyElement(isSvg   = true, "circle"),
    "SVGClipPathElement" -> SlinkyElement(isSvg = true, "clipPath"),
    "SVGComponentTransferFunctionElement" -> AnySvgElement,
    "SVGCursorElement" -> SlinkyElement(isSvg = true, "cursor"),
    "SVGDefsElement" -> SlinkyElement(isSvg   = true, "defs"),
    "SVGDescElement" -> SlinkyElement(isSvg   = true, "desc"),
    "SVGElement" -> AnySvgElement,
    "SVGEllipseElement" -> SlinkyElement(isSvg       = true, "ellipse"),
    "SVGFEBlendElement" -> SlinkyElement(isSvg       = true, "feBlend"),
    "SVGFEColorMatrixElement" -> SlinkyElement(isSvg = true, "feColorMatrix"),
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
