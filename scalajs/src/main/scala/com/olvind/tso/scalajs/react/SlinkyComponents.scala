package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.react.CastConversion.TypeRewriterCast
import com.olvind.tso.scalajs.transforms.Companions
import com.olvind.tso.seqs._

import scala.collection.mutable

/**
  * Generate a package with Slinky compatible react components
  */
object SlinkyComponents {

  object names {
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

    val conversions: Seq[CastConversion] = {
      import CastConversion.TParam._
      CastConversion.All ++ Seq(
        CastConversion(QualifiedName.WILDCARD, QualifiedName.Any), // todo: this should not leak out here
        CastConversion(QualifiedName.React.ReactNode, TagMod, Ref(TypeRef.ScalaAny)),
        CastConversion(QualifiedName.React.ReactElement, ReactElement),
        CastConversion(QualifiedName.React.ReactType, ReactComponentClass, _1),
      ) ++ QualifiedName.React.isComponent.map(from => CastConversion(from, ReactComponentClass, _1))
    }

    private val ignoredNames = Set(Name("key"), Name("children"))
    def shouldIgnore(paramTree: ParamTree) = ignoredNames(paramTree.name)
  }

  /* These definitions are here to make `ShortenNames` work in the presence of inherited names. */
  object classDefs {
    import names._

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
        TypeAliasTree(names.Props, Nil, TypeRef.Any, NoComments, ExternalComponentProps + names.Props),
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
        (if (isSvg) names.slinkyWebSvg else names.slinkyWebHtml) + Name(name) + Name("tag"),
        Nil,
        NoComments,
      ),
    )

  val AnyHtmlElement: TypeRef = SlinkyElement(isSvg = false, "*")
  val AnySvgElement:  TypeRef = SlinkyElement(isSvg = true, "*")

  val rewriter = TypeRewriterCast(names.conversions)

  case class Props(ref: TypeRef, params: Seq[Param], domParams: Seq[FieldTree])

  def apply(_scope: TreeScope, tree: ContainerTree, allComponents: Seq[Component]): ContainerTree = {
    val scope = _scope / tree

    /* for slinky we strip all dom props, because the user can specify them using normal slinky syntax */
    val domFields: Map[Name, TypeRef] = {
      def fieldsFor(scope: TreeScope, attributes: QualifiedName) =
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

      fieldsFor(scope, QualifiedName.React.AllHTMLAttributes) ++
        fieldsFor(scope, QualifiedName.React.SVGAttributes)
    }

    /* Every tree knows it's own location (called `CodePath`).
       It's used for a lot of things, so it's important to get right */
    val pkgCp = tree.codePath + names.Slinky

    val generatedCode: Seq[Tree] =
      allComponents
        .groupBy(c => (c.props, c.tparams))
        .to[Seq]
        .flatMap {
          case ((propsRefOpt, tparams), components) =>
            // accept components with no props, but not those with too complicated props (type aliases that ExpandTypeMappings doesnt expand yet)
            val propsParamsOpt: Option[Props] =
              propsRefOpt match {
                case Some(propsRef) =>
                  val domParams = mutable.ArrayBuffer.empty[FieldTree]

                  val dealiased = FollowAliases(scope)(propsRef)

                  val paramsOpt: Option[Seq[Param]] =
                    scope lookup dealiased.typeName collectFirst {
                      case (cls: ClassTree, newScope) if cls.classType === ClassType.Trait =>
                        ConstructObjectOfType(FillInTParams(cls, newScope, dealiased.targs, tparams), scope) {
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
                          case (scope, methodTree: MethodTree) =>
                            Companions.memberParameter(scope, methodTree)
                        }
                    }

                  paramsOpt.map { params =>
                    /* rewrite types after `memberParameter`, as it's resolving aliases, referencing superclasses and so on */
                    val rewrittenParams = params.map(
                      p => p.copy(parameter = p.parameter.copy(tpe = rewriter.visitTypeRef(scope)(p.parameter.tpe))),
                    )

                    Props(propsRef, rewrittenParams, domParams.to[Seq])
                  }

                case None =>
                  Some(Props(TypeRef.Object, Nil, Nil))
              }

            propsParamsOpt.to[List].flatMap { props: Props =>
              val domType: TypeRef =
                props.domParams
                  .firstDefined { f =>
                    val referencedElements = TreeTraverse.collect(f) {
                      case TypeRef(QualifiedName(List(ScalaConfig.outputPkg, ScalaConfig.std, name)), Nil, _)
                          if name.value.endsWith("Element") =>
                        name.value
                    }
                    referencedElements.toSet.firstDefined(ElementMapping.get)
                  }
                  .getOrElse(AnyHtmlElement)

              components.map(genComponent(scope, pkgCp, props, domType))
//              components match {
//                case Seq(one) =>
//                  List(genComponent(scope, pkgCp, props, domType)(one))
//                  case many =>
//                    /** We share `apply` methods for each props type in abstract classes to limit compilation time.
//                      *  References causes some trouble, so if the component knows it we thread it through a type param.
//                      */
//                    val knownRefRewritten = if (hasKnownRef) Some(TypeRef(names.ComponentRef)) else None
//                    val propsCls          = genSharedPropsClass(pkgCp, props, params, knownRefRewritten, tparams)
//                    List(propsCls) ++ many.map(genComponentForSharedProps(pkgCp, propsCls))
//              }
            }
        }

    /* Only generate the package if we have mapped any components */
    generatedCode match {
      case Seq() => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.Slinky, nonEmpty, NoComments, pkgCp)
        tree.withMembers(tree.members :+ newPackage)
    }
  }

  def genComponent(
      scope:   TreeScope,
      pkgCp:   QualifiedName,
      props:   Props,
      domType: TypeRef,
  )(c:         Component): ModuleTree = {
    val componentCp = pkgCp + c.fullName

    val componentField = FieldTree(
      Nil,
      names.component,
      TypeRef.Union(List(TypeRef.String, TypeRef.Object), sort = false),
      MemberImpl.Custom(
        Component.formatReferenceTo(TypeRef.stripTargs(c.ref), c.componentType) + ".asInstanceOf[String | js.Object]",
      ),
      isReadOnly = true,
      isOverride = true,
      NoComments,
      componentCp + names.component,
    )
    val (refTypes, _, optionals, requireds, Nil) = props.params.partitionCollect4(
      { case Param(ParamTree(Name("ref"), tpe, _, _), _, _) => tpe },
      { case Param(pt, _, _) if names.shouldIgnore(pt)      => () },
      { case Param(p, _, Right(f))                          => p -> f },
      { case Param(p, _, Left(str))                         => p -> str },
    )

    /**
      *  The `apply` method that the slinky method would normally construct.
      *  We implement it ourselves for flexibility and performance. Otherwise we would need to generate
      *  a case class and suffer macro execution time.
      */
    def genApply(elem: TypeRef, ref: TypeRef): MethodTree = {
      val ret  = TypeRef(names.BuildingComponent, List(elem, ref), NoComments)
      val cast = if (c.ref.targs.nonEmpty) s".asInstanceOf[${Printer.formatTypeRef(0)(ret)}]" else ""

      MethodTree(
        annotations = Nil,
        level       = ProtectionLevel.Default,
        name        = Name.APPLY,
        tparams     = c.tparams,
        params      = List(requireds.map(_._1) ++ optionals.map(_._1)),
        impl = MemberImpl.Custom(s"""{
                                    |  val __obj = js.Dynamic.literal(${requireds
                                      .map(_._2)
                                      .mkString(", ")})
                                    |${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
                                    |  super.apply(__obj.asInstanceOf[Props])$cast
                                    |}""".stripMargin),
        resultType = ret,
        isOverride = false,
        comments   = NoComments,
        codePath   = componentCp + Name.APPLY,
      )
    }

    val (parent, members) = {
      /* Observe type bound of :< js.Object */
      val refType = {
        c.knownRef orElse refTypes.headOption map TypeRef.stripTargs match {
          case Some(value) =>
            scope
              .lookup(value.typeName)
              .collectFirst { case (_: ClassTree, _) => value }
              .getOrElse(TypeRef.Intersection(List(value, TypeRef.Object)))
          case None => TypeRef.Object
        }
      }

      if (props.params.nonEmpty) {
        val propsAlias =
          TypeAliasTree(names.Props, Nil, TypeRef.stripTargs(props.ref), NoComments, componentCp + names.Props)
        (
          TypeRef(names.ExternalComponentProps, List(domType, refType), NoComments),
          List(genApply(domType, refType), propsAlias),
        )
      } else
        (TypeRef(names.ExternalComponentNoProps, List(domType, refType), NoComments), Nil)
    }

    val domWarning =
      if (props.domParams.isEmpty) NoComments
      else {
        val details = props.domParams.map(_.name.unescaped).sorted.mkString(", ")
        Comments(Comment(s"/* The following DOM/SVG props were specified: $details */\n"))
      }

    ModuleTree(
      annotations = Nil,
      name        = c.fullName,
      parents     = List(parent),
      members     = List(componentField) ++ members,
      comments    = domWarning + CommentData(KeepOnlyReferenced.Keep(List(c.ref))),
      codePath    = componentCp,
    )
  }

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
