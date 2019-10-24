package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.transforms.Companions
import com.olvind.tso.seqs._

import scala.collection.mutable

/**
  * Generate a package with Slinky compatible react components
  */
object SlinkyComponents {
  val IgnoredProps = Set(Name("key"), Name("children"))

  object slinky {
    val Slinky    = Name("Slinky")
    val Props     = Name("Props")
    val Element   = Name("Element")
    val RefType   = Name("RefType")
    val component = Name("component")

    /* Fully qualified references to slinky types */
    val slinky                   = QualifiedName(List(Name("slinky")))
    val slinkyCore               = slinky + Name("core")
    val ReactComponentClass      = slinkyCore + Name("ReactComponentClass")
    val TagMod                   = slinkyCore + Name("TagMod")
    val ExternalComponentProps   = slinkyCore + Name("ExternalComponentWithAttributesWithRefType")
    val ExternalComponentNoProps = slinkyCore + Name("ExternalComponentNoPropsWithAttributesWithRefType")
    val BuildingComponent        = slinkyCore + Name("BuildingComponent")
    val TagElement               = slinkyCore + Name("TagElement")
    val SlinkyCoreFacade         = slinkyCore + Name("facade")
    val ReactElement             = SlinkyCoreFacade + Name("ReactElement")
    val slinkyWeb                = slinky + Name("web")
    val slinkyWebSvg             = slinkyWeb + Name("svg")
    val slinkyWebHtml            = slinkyWeb + Name("html")
  }

  /* These definitions are here to make `ShortenNames` work in the presence of inherited names. */
  object classDefs {
    import slinky._

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
        TypeAliasTree(Element, Nil, TypeRef(Name("E")), NoComments, ExternalComponentNoProps + Element),
        TypeAliasTree(RefType, Nil, TypeRef(Name("R")), NoComments, ExternalComponentNoProps + RefType),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      ExternalComponentNoProps,
    )
  }

  def SlinkyElement(isSvg: Boolean, name: String): TypeRef =
    TypeRef.Singleton(
      TypeRef(
        (if (isSvg) slinky.slinkyWebSvg else slinky.slinkyWebHtml) + Name(name) + Name("tag"),
        Nil,
        NoComments,
      ),
    )

  val AnyHtmlElement: TypeRef = SlinkyElement(isSvg = false, "*")
  val AnySvgElement:  TypeRef = SlinkyElement(isSvg = true, "*")

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
  val SlinkyReplacements: TypeRef => TypeRef = {
    case TypeRef(QualifiedName.React.ReactNode, _, cs)        => TypeRef(slinky.TagMod, List(TypeRef.ScalaAny), cs)
    case TypeRef(QualifiedName.React.ReactElement, _, cs)     => TypeRef(slinky.ReactElement, Nil, cs)
    case TypeRef(QualifiedName.React.ReactType, Seq(one), cs) => TypeRef(slinky.ReactComponentClass, Seq(one), cs)
    case TypeRef(name, targs, cs) if QualifiedName.React.isComponent(name) =>
      TypeRef(slinky.ReactComponentClass, targs.take(1), cs)
    case other => other
  }

  /* Slinky doesnt really support generic components. We hack it in in the `apply` method */
  def stripTargs(tr: TypeRef): TypeRef = tr.copy(targs = tr.targs.map(_ => TypeRef.Any))

  def apply(_scope: TreeScope, tree: ContainerTree, allComponents: Seq[Component]): ContainerTree = {
    val scope = _scope / tree

    /* for slinky we strip all dom props, because the user can specify them using normal slinky syntax */
    val domFields: Map[Name, TypeRef] =
      fieldsFor(scope, QualifiedName.React.AllHTMLAttributes) ++
        fieldsFor(scope, QualifiedName.React.SVGAttributes)

    /* Every tree knows it's own location (called `CodePath`).
       It's used for a lot of things, so it's important to get right */
    val slinkyPkgCp = tree.codePath + slinky.Slinky

    val slinkyMembers = allComponents.flatMap { c =>
      val componentCp = slinkyPkgCp + c.fullName

      val componentField = FieldTree(
        Nil,
        slinky.component,
        TypeRef.Union(List(TypeRef.String, TypeRef.Object), sort = false),
        MemberImpl.Custom(
          Component.formatReferenceTo(stripTargs(c.ref), c.componentType) + ".asInstanceOf[String | js.Object]",
        ),
        isReadOnly = true,
        isOverride = true,
        NoComments,
        componentCp + slinky.component,
      )
      val keepRefInTree = {
        val ref =
          c.componentType match {
            case ComponentType.Class    => c.ref
            case ComponentType.Function => TypeRef.Singleton(TypeRef(QualifiedName(c.ref.typeName.parts.dropRight(1))))
            case ComponentType.Field    => TypeRef.Singleton(TypeRef(c.ref.typeName))

          }
        TypeAliasTree(Name.dummy, c.tparams, ref, Comments(CommentData(Markers.VIP)), componentCp + Name.dummy)
      }
      val props = c.props getOrElse TypeRef.Object

      def propsAlias(props: TypeRef) =
        TypeAliasTree(slinky.Props, Nil, stripTargs(props), NoComments, componentCp + slinky.Props)

      val dealiased = FollowAliases(scope)(props)
      scope lookup dealiased.typeName firstDefined {
        case (_cls: ClassTree, newScope) if _cls.classType === ClassType.Trait =>
          val cls = TypeRewriterFn(SlinkyReplacements).visitClassTree(scope)(
            FillInTParams(_cls, newScope, dealiased.targs, c.tparams),
          )

          val domParams = mutable.ArrayBuffer.empty[FieldTree]

          val allParams: Seq[Param] =
            ConstructObjectOfType(cls, scope, maxNum = Int.MaxValue) {
              case (scope, fieldTree: FieldTree) =>
                /* todo: refactor out a name/type check which ignores optionality */
                val isDom: Boolean =
                  domFields.get(fieldTree.name) match {
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
                } else Companions.memberParameter(scope, fieldTree)
              case (scope, tree) => Companions.memberParameter(scope, tree)
            }

          allParams match {
            case Nil => None
            case params =>
              val domType: TypeRef =
                domParams
                  .firstDefined {
                    case FieldTree(_, _, TypeRef(typeName, tparams, _), _, _, _, _, _)
                        if typeName.parts.last.unescaped.endsWith("Event") && tparams.nonEmpty =>
                      ElementMapping.get(tparams.head.name.unescaped)
                    case _ => None
                  }
                  .getOrElse(AnyHtmlElement)

              val (refTypes, _, optionals, requireds, Nil) = params.partitionCollect4(
                { case Param(ParamTree(Name("ref"), tpe, _, _), _, _)                      => tpe },
                { case Param(ParamTree(propName, _, _, _), _, _) if IgnoredProps(propName) => () },
                { case Param(p, _, Right(f))                                               => p -> f },
                { case Param(p, _, Left(str))                                              => p -> str },
              )

              /**
                *  The `apply` method that the slinky method would normally construct.
                *  We implement it ourselves for flexibility and performance. Otherwise we would need to generate
                *  a case class and suffer macro execution time.
                */
              def genApply(elem: TypeRef, ref: TypeRef): MethodTree = {
                val ret  = TypeRef(slinky.BuildingComponent, List(elem, ref), NoComments)
                val cast = if (c.ref.targs.nonEmpty) s".asInstanceOf[${Printer.formatTypeRef(0)(ret)}]" else ""

                MethodTree(
                  annotations = Nil,
                  level       = ProtectionLevel.Default,
                  name        = Name.APPLY,
                  tparams     = c.tparams,
                  params      = List(requireds.map(_._1) ++ optionals.map(_._1)),
                  impl        = MemberImpl.Custom(s"""{
                       |  val __obj = js.Dynamic.literal(${requireds.map(_._2).mkString(", ")})
                       |${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
                       |  super.apply(__obj.asInstanceOf[Props])$cast
                       |}""".stripMargin),
                  resultType  = ret,
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = componentCp + Name.APPLY,
                )
              }

              val (parent, members) = {
                val refType = stripTargs(c.knownRef orElse refTypes.headOption getOrElse TypeRef.Object)
                c.props match {
                  case Some(props) =>
                    (
                      TypeRef(slinky.ExternalComponentProps, List(domType, refType), NoComments),
                      List(genApply(domType, refType), propsAlias(props)),
                    )
                  case None => (TypeRef(slinky.ExternalComponentNoProps, List(domType, refType), NoComments), Nil)
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
                  parents     = List(parent),
                  members     = List(componentField /*, keepRefInTree*/ ) ++ members,
                  comments    = domWarning + CommentData(Markers.VIP),
                  codePath    = componentCp,
                ),
              )
          }

        /* This is a fallback when the props type is complicated. I'm not convinced the result is very useful */
        case (_: ClassTree | _: TypeAliasTree, _) =>
          val (parent, propsAliasOpt) = {
            val refType = stripTargs(c.knownRef getOrElse TypeRef.Object)
            val domType = AnyHtmlElement
            c.props match {
              case Some(props) =>
                (
                  TypeRef(slinky.ExternalComponentProps, List(domType, refType), NoComments),
                  Option(propsAlias(props)),
                )
              case None => (TypeRef(slinky.ExternalComponentNoProps, List(domType, refType), NoComments), None)
            }
          }

          val mod = ModuleTree(
            annotations = Nil,
            name        = c.fullName,
            parents     = List(parent),
            members     = List(componentField) ++ propsAliasOpt,
            comments    = Comments(CommentData(Markers.VIP)),
            codePath    = componentCp,
          )
          Some(mod)

        case _ => None
      }
    }

    /* Only generate the package if we have mapped any components */
    slinkyMembers match {
      case Nil => tree
      case nonEmpty =>
        tree.withMembers(tree.members :+ PackageTree(Nil, slinky.Slinky, nonEmpty, NoComments, slinkyPkgCp))
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
