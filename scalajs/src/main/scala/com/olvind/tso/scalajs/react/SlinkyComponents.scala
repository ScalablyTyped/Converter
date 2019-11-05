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
    val Slinky       = Name("slinky")
    val Props        = Name("Props")
    val Element      = Name("Element")
    val RefType      = Name("RefType")
    val component    = Name("component")
    val ComponentRef = Name("ComponentRef")

    /* Fully qualified references to slinky types */
    val slinky                      = QualifiedName(List(Name("slinky")))
    val slinkyCore                  = slinky + Name("core")
    val ReactComponentClass         = slinkyCore + Name("ReactComponentClass")
    val TagMod                      = slinkyCore + Name("TagMod")
    val ExternalComponentProps      = slinkyCore + Name("ExternalComponentWithAttributesWithRefType")
    val ExternalComponentNoProps    = slinkyCore + Name("ExternalComponentNoPropsWithAttributesWithRefType")
    val BuildingComponent           = slinkyCore + Name("BuildingComponent")
    val TagElement                  = slinkyCore + Name("TagElement")
    val SlinkyCoreFacade            = slinkyCore + Name("facade")
    val ExternalPropsWriterProvider = slinkyCore + Name("ExternalPropsWriterProvider")
    val ReactElement                = SlinkyCoreFacade + Name("ReactElement")
    val slinkyWeb                   = slinky + Name("web")
    val slinkyWebSvg                = slinkyWeb + Name("svg")
    val slinkyWebHtml               = slinkyWeb + Name("html")
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
  def SlinkyHtmlElement(name: String): TypeRef = SlinkyElement(false, name)
  def SlinkySvgElement(name:  String): TypeRef = SlinkyElement(true, name)

  val AnyHtmlElement: TypeRef = SlinkyHtmlElement("*")
  val AnySvgElement:  TypeRef = SlinkySvgElement("*")

  val rewriter = TypeRewriterCast(names.conversions)

  val additionalOptionalParams: Seq[(ParamTree, String => String)] = {
    val overridesUpdate: String => String = obj =>
      s"if (overrides != null) js.Dynamic.global.Object.assign($obj, overrides)"
    val overridesParam = ParamTree(
      name       = Name("overrides"),
      isImplicit = false,
      tpe        = TypeRef.StringDictionary(TypeRef.Any, NoComments),
      default    = Some(TypeRef.`null`),
      comments   = NoComments,
    )
    Seq(overridesParam -> overridesUpdate)
  }

  case class Props(ref: TypeRef, params: Seq[Param], domParams: Seq[FieldTree]) {
    val (refTypes, _, _optionals, requireds, Nil) = params.partitionCollect4(
      { case Param(ParamTree(Name("ref"), _, tpe, _, _), _, _) => tpe },
      { case Param(pt, _, _) if names.shouldIgnore(pt)         => () },
      { case Param(p, _, Right(f))                             => p -> f },
      { case Param(p, _, Left(str))                            => p -> str },
    )
    val optionals = _optionals ++ additionalOptionalParams

    val noNormalProps: Boolean = optionals.isEmpty && requireds.isEmpty
  }

  def apply(_scope: TreeScope, tree: PackageTree, allComponents: Seq[Component]): PackageTree = {
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
    val outerPkgCp = tree.codePath + names.Slinky
    val pkgCp      = outerPkgCp + scope.libName

    val generatedCode: Seq[Tree] =
      allComponents
        .groupBy(c => (c.props, c.knownRef.isDefined, c.tparams))
        .to[Seq]
        .flatMap {
          case ((propsRefOpt, hasKnownRef, tparams), components) =>
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

              if (props.noNormalProps)
                components.map(genComponent(scope, pkgCp, props, domType))
              else
                components match {
                  case Seq(one) =>
                    List(genComponent(scope, pkgCp, props, domType)(one))
                  case many =>
                    /** We share `apply` methods for each props type in abstract classes to limit compilation time.
                      *  References causes some trouble, so if the component knows it we thread it through a type param.
                      */
                    val knownRefRewritten = if (hasKnownRef) Some(TypeRef(names.ComponentRef)) else None
                    val propsCls          = genSharedPropsClass(scope, pkgCp, props, knownRefRewritten, tparams, domType)
                    List(propsCls) ++ many.map(genComponentForSharedProps(pkgCp, propsCls, props))
                }
            }
        }

    /* Only generate the package if we have mapped any components */
    generatedCode match {
      case Seq() => tree
      case nonEmpty =>
        val newPackage = PackageTree(
          Nil,
          names.Slinky,
          List(PackageTree(Nil, scope.libName, nonEmpty, NoComments, pkgCp)),
          NoComments,
          outerPkgCp,
        )
        tree.copy(members = tree.members :+ newPackage)
    }
  }

  def genSharedPropsClass(
      scope:             TreeScope,
      pkgCp:             QualifiedName,
      props:             Props,
      knownRefRewritten: Option[TypeRef],
      tparams:           Seq[TypeParamTree],
      domType:           TypeRef,
  ): ClassTree = {
    // todo: improve on this, but ensure unique
    val name = Name(
      s"SharedApply_${props.ref.name.unescaped}${(props.ref, knownRefRewritten, tparams).hashCode}"
        .replaceAllLiterally("-", "_"),
    )
    val classCp = pkgCp + name

    val (parent, applyMethodOpt, typeAliasOpt) = genContent(scope, props, tparams, knownRefRewritten, domType, classCp)

    val refInTParams =
      knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, Some(TypeRef.Object), NoComments)).to[List]

    ClassTree(
      Nil,
      name,
      refInTParams,
      List(parent),
      List(
        CtorTree(
          ProtectionLevel.Default,
          List(ParamTree(Name("pw"), isImplicit = true, TypeRef(names.ExternalPropsWriterProvider), None, NoComments)),
          NoComments,
        ),
      ),
      applyMethodOpt.toList ++ typeAliasOpt,
      ClassType.AbstractClass,
      false,
      NoComments,
      classCp,
    )
  }

  def genComponentForSharedProps(pkgCp: QualifiedName, propsClass: ClassTree, props: Props)(
      c:                                Component,
  ): ModuleTree = {
    val componentCp = pkgCp + c.fullName

    ModuleTree(
      annotations = Nil,
      name        = c.fullName,
      parents     = List(TypeRef(propsClass.codePath, c.knownRef.map(TypeRef.stripTargs).to[List], NoComments)),
      members     = List(genComponentField(c, componentCp)),
      comments    = genDomWarning(props) + CommentData(KeepOnlyReferenced.Keep(List(c.ref))),
      codePath    = componentCp,
    )
  }

  def genComponent(scope: TreeScope, pkgCp: QualifiedName, props: Props, domType: TypeRef)(c: Component): ModuleTree = {
    val componentCp                            = pkgCp + c.fullName
    val (parent, applyMethodOpt, typeAliasOpt) = genContent(scope, props, c.tparams, c.knownRef, domType, componentCp)
    ModuleTree(
      annotations = Nil,
      name        = c.fullName,
      parents     = List(parent),
      members     = List(genComponentField(c, componentCp)) ++ applyMethodOpt ++ typeAliasOpt,
      comments    = genDomWarning(props) + CommentData(KeepOnlyReferenced.Keep(List(c.ref))),
      codePath    = componentCp,
    )
  }

  def genContent(
      scope:    TreeScope,
      props:    Props,
      tparams:  Seq[TypeParamTree],
      knownRef: Option[TypeRef],
      domType:  TypeRef,
      ownerCp:  QualifiedName,
  ): (TypeRef, Option[MethodTree], Option[TypeAliasTree]) = {
    /* Observe type bound of :< js.Object */
    val refType = {
      knownRef orElse props.refTypes.headOption map TypeRef.stripTargs match {
        case Some(x @ TypeRef(QualifiedName(List(names.ComponentRef)), _, _)) => x
        case Some(value) =>
          scope
            .lookup(value.typeName)
            .collectFirst { case (_: ClassTree, _) => value }
            .getOrElse(TypeRef.Intersection(List(value, TypeRef.Object)))
        case None => TypeRef.Object
      }
    }

    if (props.noNormalProps) {
      (TypeRef(names.ExternalComponentNoProps, List(domType, refType), NoComments), None, None)
    } else {
      val propsAlias =
        TypeAliasTree(names.Props, Nil, TypeRef.stripTargs(props.ref), NoComments, ownerCp + names.Props)

      /**
        *  The `apply` method that the slinky method would normally construct.
        *  We implement it ourselves for flexibility and performance. Otherwise we would need to generate
        *  a case class and suffer macro execution time.
        */
      val applyMethod: MethodTree = {
        val ret  = TypeRef(names.BuildingComponent, List(domType, refType), NoComments)
        val cast = if (tparams.nonEmpty) s".asInstanceOf[${Printer.formatTypeRef(0)(ret)}]" else ""

        MethodTree(
          annotations = Nil,
          level       = ProtectionLevel.Default,
          name        = Name.APPLY,
          tparams     = tparams,
          params      = List(props.requireds.map(_._1) ++ props.optionals.map(_._1)),
          impl = MemberImpl.Custom(
            s"""{
               |  val __obj = js.Dynamic.literal(${props.requireds.map(_._2).mkString(", ")})
               |${props.optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
               |  super.apply(__obj.asInstanceOf[Props])$cast
               |}""".stripMargin,
          ),
          resultType = ret,
          isOverride = false,
          comments   = NoComments,
          codePath   = ownerCp + Name.APPLY,
        )
      }

      (TypeRef(names.ExternalComponentProps, List(domType, refType), NoComments), Some(applyMethod), Some(propsAlias))
    }
  }

  def genDomWarning(props: Props): Comments =
    if (props.domParams.isEmpty) NoComments
    else {
      val details = props.domParams.map(_.name.unescaped).sorted.mkString(", ")
      Comments(Comment(s"/* The following DOM/SVG props were specified: $details */\n"))
    }

  def genComponentField(c: Component, componentCp: QualifiedName): FieldTree =
    FieldTree(
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

  // todo: this was all the mapping i had the energy to do.
  val ElementMapping = Map(
    "HTMLAnchorElement" -> SlinkyHtmlElement("a"),
    "HTMLAppletElement" -> AnyHtmlElement,
    "HTMLAreaElement" -> SlinkyHtmlElement("area"),
    "HTMLAudioElement" -> SlinkyHtmlElement("audio"),
    "HTMLBaseElement" -> SlinkyHtmlElement("base"),
    "HTMLBaseFontElement" -> AnyHtmlElement,
    "HTMLBodyElement" -> SlinkyHtmlElement("body"),
    "HTMLBRElement" -> SlinkyHtmlElement("br"),
    "HTMLButtonElement" -> SlinkyHtmlElement("button"),
    "HTMLCanvasElement" -> SlinkyHtmlElement("canvas"),
    "HTMLDataElement" -> SlinkyHtmlElement("data"),
    "HTMLDataListElement" -> SlinkyHtmlElement("datalist"),
    "HTMLDetailsElement" -> SlinkyHtmlElement("details"),
    "HTMLDialogElement" -> SlinkyHtmlElement("dialog"),
    "HTMLDirectoryElement" -> AnyHtmlElement,
    "HTMLDivElement" -> SlinkyHtmlElement("div"),
    "HTMLDListElement" -> SlinkyHtmlElement("dl"),
    "HTMLElement" -> AnyHtmlElement,
    "HTMLEmbedElement" -> SlinkyHtmlElement("embed"),
    "HTMLFieldSetElement" -> SlinkyHtmlElement("fieldset"),
    "HTMLFontElement" -> AnyHtmlElement,
    "HTMLFormElement" -> SlinkyHtmlElement("form"),
    "HTMLFrameElement" -> AnyHtmlElement,
    "HTMLFrameSetElement" -> AnyHtmlElement,
    "HTMLHeadElement" -> SlinkyHtmlElement("head"),
    "HTMLHeadingElement" -> AnyHtmlElement,
    "HTMLHRElement" -> SlinkyHtmlElement("hr"),
    "HTMLHtmlElement" -> SlinkyHtmlElement("html"),
    "HTMLIFrameElement" -> SlinkyHtmlElement("iframe"),
    "HTMLImageElement" -> SlinkyHtmlElement("img"),
    "HTMLInputElement" -> SlinkyHtmlElement("input"),
    "HTMLLabelElement" -> SlinkyHtmlElement("label"),
    "HTMLLegendElement" -> SlinkyHtmlElement("legend"),
    "HTMLLIElement" -> SlinkyHtmlElement("li"),
    "HTMLLinkElement" -> SlinkyHtmlElement("link"),
    "HTMLMapElement" -> SlinkyHtmlElement("map"),
    "HTMLMarqueeElement" -> AnyHtmlElement,
    "HTMLMediaElement" -> AnyHtmlElement,
    "HTMLMenuElement" -> SlinkyHtmlElement("menu"),
    "HTMLMetaElement" -> SlinkyHtmlElement("meta"),
    "HTMLMeterElement" -> SlinkyHtmlElement("meter"),
    "HTMLModElement" -> AnyHtmlElement,
    "HTMLObjectElement" -> SlinkyHtmlElement("object"),
    "HTMLOListElement" -> SlinkyHtmlElement("ol"),
    "HTMLOptGroupElement" -> SlinkyHtmlElement("optgroup"),
    "HTMLOptionElement" -> SlinkyHtmlElement("option"),
    "HTMLOutputElement" -> SlinkyHtmlElement("output"),
    "HTMLParagraphElement" -> SlinkyHtmlElement("p"),
    "HTMLParamElement" -> SlinkyHtmlElement("param"),
    "HTMLPictureElement" -> SlinkyHtmlElement("picture"),
    "HTMLPreElement" -> SlinkyHtmlElement("pre"),
    "HTMLProgressElement" -> SlinkyHtmlElement("progress"),
    "HTMLQuoteElement" -> SlinkyHtmlElement("q"),
    "HTMLScriptElement" -> SlinkyHtmlElement("script"),
    "HTMLSelectElement" -> SlinkyHtmlElement("select"),
    "HTMLSlotElement" -> AnyHtmlElement,
    "HTMLSourceElement" -> SlinkyHtmlElement("source"),
    "HTMLSpanElement" -> SlinkyHtmlElement("span"),
    "HTMLStyleElement" -> SlinkyHtmlElement("style"),
    "HTMLTableCaptionElement" -> AnyHtmlElement,
    "HTMLTableCellElement" -> AnyHtmlElement,
    "HTMLTableColElement" -> AnyHtmlElement,
    "HTMLTableDataCellElement" -> AnyHtmlElement,
    "HTMLTableElement" -> SlinkyHtmlElement("table"),
    "HTMLTableHeaderCellElement" -> AnyHtmlElement,
    "HTMLTableRowElement" -> AnyHtmlElement,
    "HTMLTableSectionElement" -> AnyHtmlElement,
    "HTMLTemplateElement" -> AnyHtmlElement,
    "HTMLTextAreaElement" -> AnyHtmlElement,
    "HTMLTimeElement" -> AnyHtmlElement,
    "HTMLTitleElement" -> AnyHtmlElement,
    "HTMLTrackElement" -> AnyHtmlElement,
    "HTMLUListElement" -> SlinkyHtmlElement("ul"),
    "HTMLVideoElement" -> AnyHtmlElement,
    "SVGAElement" -> SlinkySvgElement("a"),
    "SVGAnimateElement" -> SlinkySvgElement("animate"),
    "SVGAnimateMotionElement" -> SlinkySvgElement("animateMotion"),
    "SVGAnimateTransformElement" -> SlinkySvgElement("animateTransform"),
    "SVGAnimationElement" -> AnySvgElement,
    "SVGCircleElement" -> SlinkySvgElement("circle"),
    "SVGClipPathElement" -> SlinkySvgElement("clipPath"),
    "SVGComponentTransferFunctionElement" -> AnySvgElement,
    "SVGCursorElement" -> SlinkySvgElement("cursor"),
    "SVGDefsElement" -> SlinkySvgElement("defs"),
    "SVGDescElement" -> SlinkySvgElement("desc"),
    "SVGElement" -> AnySvgElement,
    "SVGEllipseElement" -> SlinkySvgElement("ellipse"),
    "SVGFEBlendElement" -> SlinkySvgElement("feBlend"),
    "SVGFEColorMatrixElement" -> SlinkySvgElement("feColorMatrix"),
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
