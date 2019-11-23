package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.scalajs.flavours.CastConversion.TypeRewriterCast
import com.olvind.tso.seqs._

import scala.collection.mutable

object GenSlinkyComponents {
  val slinkyName = Name("slinky")
  object names {
    val components   = Name("components")
    val Props        = Name("Props")
    val Element      = Name("Element")
    val RefType      = Name("RefType")
    val component    = Name("component")
    val ComponentRef = Name("ComponentRef")

    /* Fully qualified references to slinky types */
    val slinky                      = QualifiedName(List(GenSlinkyComponents.slinkyName))
    val slinkyCore                  = slinky + Name("core")
    val ReactComponentClass         = slinkyCore + Name("ReactComponentClass")
    val TagMod                      = slinkyCore + Name("TagMod")
    val ExternalComponentProps      = slinkyCore + Name("ExternalComponentWithAttributesWithRefType")
    val ExternalComponentNoProps    = slinkyCore + Name("ExternalComponentNoPropsWithAttributesWithRefType")
    val BuildingComponent           = slinkyCore + Name("BuildingComponent")
    val TagElement                  = slinkyCore + Name("TagElement")
    val SlinkyCoreFacade            = slinkyCore + Name("facade")
    val ExternalPropsWriterProvider = slinkyCore + Name("ExternalPropsWriterProvider")
    val SyntheticEvent              = slinkyCore + Name("SyntheticEvent")
    val ReactElement                = SlinkyCoreFacade + Name("ReactElement")
    val ReactRef                    = SlinkyCoreFacade + Name("ReactRef")
    val slinkyWeb                   = slinky + Name("web")
    val slinkyWebSvg                = slinkyWeb + Name("svg")
    val slinkyWebHtml               = slinkyWeb + Name("html")

    val ignoredNames = Set(Name("key"), Name("children"))
  }
  def shouldIgnore(paramTree: ParamTree) = names.ignoredNames(paramTree.name)

  def SlinkyElement(isSvg: Boolean, name: String): TypeRef =
    TypeRef.Singleton(
      TypeRef(
        (if (isSvg) names.slinkyWebSvg else names.slinkyWebHtml) + Name(name) + Name("tag"),
        Nil,
        NoComments,
      ),
    )

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
}

/**
  * Generate a package with Slinky compatible react components
  */
class GenSlinkyComponents(
    scalaJsDomNames: ScalaJsDomNames,
    stdNames:        QualifiedName.StdNames,
    reactNames:      ReactNames,
    findParams:      Params,
) {
  import GenSlinkyComponents._

  def SlinkyHtmlElement(name: String): TypeRef = SlinkyElement(false, name)
  def SlinkySvgElement(name:  String): TypeRef = SlinkyElement(true, name)

  val AnyHtmlElement: TypeRef = SlinkyHtmlElement("*")
  val AnySvgElement:  TypeRef = SlinkySvgElement("*")

  val conversions: Seq[CastConversion] = {
    import CastConversion.TParam._
    import names._

    scalaJsDomNames.All ++ Seq(
      CastConversion(reactNames.ReactType, ReactComponentClass, _1),
      CastConversion(reactNames.ComponentState, QualifiedName.Object),
      CastConversion(reactNames.ReactDOM, QualifiedName.Any),
      CastConversion(reactNames.ReactNode, TagMod, Ref(TypeRef.ScalaAny)),
      CastConversion(reactNames.RefObject, ReactRef, _1),
      //        CastConversion(reactNames.Component, rawReactComponent, _1, TypeRef.Object),
      //        CastConversion(reactNames.ComponentClass, rawReactComponentClassP, _1Object),
      CastConversion(reactNames.ReactElement, ReactElement),
      CastConversion(reactNames.DOMElement, ReactElement),
      CastConversion(reactNames.ElementType, ReactElement),
      CastConversion(reactNames.BaseSyntheticEvent, SyntheticEvent, _2, _1),
      //        CastConversion(reactNames.ChangeEvent, SyntheticEvent, _2, _1),
      //        CastConversion(reactNames.FormEvent, SyntheticEvent, _2, _1),
      //        CastConversion(reactNames.InvalidEvent, SyntheticEvent, _2, _1),
      CastConversion(reactNames.SyntheticEvent, SyntheticEvent, _2, _1),
      CastConversion(reactNames.AnimationEvent, slinkyWeb + Name("SyntheticAnimationEvent"), _1),
      CastConversion(reactNames.ClipboardEvent, slinkyWeb + Name("SyntheticClipboardEvent"), _1),
      CastConversion(reactNames.CompositionEvent, slinkyWeb + Name("SyntheticCompositionEvent"), _1),
      //        CastConversion(reactNames.DragEvent, slinkyWeb + Name("ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, slinkyWeb + Name("SyntheticFocusEvent"), _1),
      CastConversion(reactNames.KeyboardEvent, slinkyWeb + Name("SyntheticKeyboardEvent"), _1),
      CastConversion(reactNames.MouseEvent, slinkyWeb + Name("SyntheticMouseEvent"), _1),
      CastConversion(reactNames.PointerEvent, slinkyWeb + Name("SyntheticPointerEvent"), _1),
      CastConversion(reactNames.TouchEvent, slinkyWeb + Name("SyntheticTouchEvent"), _1),
      CastConversion(reactNames.TransitionEvent, slinkyWeb + Name("SyntheticTransitionEvent"), _1),
      CastConversion(reactNames.UIEvent, slinkyWeb + Name("SyntheticUIEvent"), _1),
      CastConversion(reactNames.WheelEvent, slinkyWeb + Name("SyntheticWheelEvent"), _1),
    ) ++ reactNames.isComponent.map(from => CastConversion(from, ReactComponentClass, _1))
  }

  val ToSlinkyTypes = TypeRewriterCast(conversions)

  val memberToParameter: MemberToParam =
    (scope, tree) => MemberToParam.Default(scope, ToSlinkyTypes.visitMemberTree(scope)(tree))

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
      { case Param(ParamTree(Name("ref"), _, tpe, _, _), _)       => tpe },
      { case Param(pt, _) if GenSlinkyComponents.shouldIgnore(pt) => () },
      { case Param(p, Right(f))                                   => p -> f },
      { case Param(p, Left(str))                                  => p -> str },
    )
    val optionals = _optionals ++ additionalOptionalParams

    val noNormalProps: Boolean = optionals.isEmpty && requireds.isEmpty
  }

  def apply(scope: TreeScope, tree: ContainerTree, allComponents: Seq[Component]): ContainerTree = {
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
          .filterKeys(SlinkyAttributes)

      fieldsFor(scope, reactNames.AllHTMLAttributes) ++
        fieldsFor(scope, reactNames.SVGAttributes)
    }

    /* Every tree knows it's own location (called `CodePath`).
       It's used for a lot of things, so it's important to get right */
    val pkgCp = tree.codePath + GenSlinkyComponents.names.components

    val generatedCode: Seq[Tree] =
      allComponents
        .map(_.rewritten(scope, ToSlinkyTypes))
        .groupBy(c => (c.props, c.knownRef.isDefined, c.tparams))
        .to[Seq]
        .flatMap {
          case ((propsRefOpt, hasKnownRef, tparams), components) =>
            val propsOpt: Option[Props] =
              propsRefOpt match {
                case Some(propsRef) =>
                  val referredTrait: Option[ClassTree] = {
                    val dealiased = FollowAliases(scope)(propsRef)
                    scope lookup dealiased.typeName collectFirst {
                      case (cls: ClassTree, newScope) if cls.classType === ClassType.Trait =>
                        FillInTParams(cls, newScope, dealiased.targs, tparams)
                    }
                  }

                  referredTrait map { cls =>
                    val domParams = mutable.ArrayBuffer.empty[FieldTree]

                    val params = findParams
                      .forClassTree(cls, scope / cls, Params.MaxParamsForMethod)
                      .flatMap {
                        case Left(param) => List(param)
                        case Right(fieldTree: FieldTree) =>
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
                            Nil
                          } else memberToParameter(scope, fieldTree)

                        case Right(methodTree: MethodTree) =>
                          memberToParameter(scope, methodTree)
                      }
                      .sorted

                    Props(propsRef, params, domParams.to[Seq])
                  }
                case None => Some(Props(TypeRef.Object, Nil, Nil))
              }

            val domType: TypeRef =
              propsOpt
                .flatMap(
                  _.domParams
                    .firstDefined { f =>
                      val referencedElements = TreeTraverse.collect(f) {
                        case TypeRef(QualifiedName(List(reactNames.outputPkg, stdNames.stdName, name)), Nil, _)
                            if name.value.endsWith("Element") =>
                          name.value
                      }
                      referencedElements.toSet.firstDefined(ElementMapping.get)
                    },
                )
                .getOrElse(AnyHtmlElement)

            propsOpt match {
              case Some(props) =>
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

              case None =>
                val propsWithObject = propsRefOpt match {
                  case Some(propsRef) => TypeRef.Intersection(List(propsRef, TypeRef.Object))
                  case None           => TypeRef.Object
                }
                val (_, Left(param)) = findParams.parentParameter(Name("props"), propsWithObject, isRequired = true)
                val props            = Props(TypeRef.Object, List(param), Nil)

                components.map { c =>
                  val mod = genComponent(scope, pkgCp, props, domType)(c)
                  val comment = Comment(
                    "/* This component has complicated props, you'll have to assemble it yourself using js.Dynamic.literal(...) or similar */\n",
                  )
                  mod.copy(comments = mod.comments + comment)
                }

            }
        }

    /* Only generate the package if we have mapped any components */
    generatedCode match {
      case Seq() => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.components, nonEmpty, NoComments, pkgCp)
        tree.withMembers(tree.members :+ newPackage)
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
      comments    = genDomWarning(props) + CommentData(KeepOnlyReferenced.Keep(List(c.scalaRef))),
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
      comments    = genDomWarning(props) + CommentData(KeepOnlyReferenced.Keep(List(c.scalaRef))),
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
        Component
          .formatReferenceTo(TypeRef.stripTargs(c.scalaRef), c.componentType) + ".asInstanceOf[String | js.Object]",
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

  /* typescript declares more attributes than slinky */
  val SlinkyAttributes: Set[Name] = Set(
    "type",
    "accept",
    "action",
    "alt",
    "aria",
    "async",
    "autoComplete",
    "autoFocus",
    "capture",
    "challenge",
    "checked",
    "className",
    "cols",
    "colSpan",
    "content",
    "contentEditable",
    "controls",
    "coords",
    "dangerouslySetInnerHTML",
    "default",
    "defaultChecked",
    "defaultValue",
    "defer",
    "dir",
    "disabled",
    "download",
    "draggable",
    "headers",
    "height",
    "hidden",
    "high",
    "href",
    "htmlFor",
    "icon",
    "id",
    "integrity",
    "key",
    "kind",
    "lang",
    "list",
    "loop",
    "low",
    "manifest",
    "max",
    "media",
    "method",
    "min",
    "multiple",
    "muted",
    "name",
    "nonce",
    "on",
    "onAbort",
    "onAnimationEnd",
    "onAnimationIteration",
    "onAnimationStart",
    "onBlur",
    "onCancel",
    "onCanPlay",
    "onCanPlayThrough",
    "onChange",
    "onClick",
    "onClose",
    "onCompositionEnd",
    "onCompositionStart",
    "onCompositionUpdate",
    "onContextMenu",
    "onCopy",
    "onCut",
    "onDoubleClick",
    "onDrag",
    "onDragEnd",
    "onDragEnter",
    "onDragExit",
    "onDragLeave",
    "onDragOver",
    "onDragStart",
    "onDrop",
    "onDurationChange",
    "onEmptied",
    "onEncrypted",
    "onEnded",
    "onError",
    "onFocus",
    "onGotPointerCapture",
    "onInput",
    "onInvalid",
    "onKeyDown",
    "onKeyPress",
    "onKeyUp",
    "onLoad",
    "onLoadedData",
    "onLoadedMetadata",
    "onLoadStart",
    "onLostPointerCapture",
    "onMouseDown",
    "onMouseEnter",
    "onMouseLeave",
    "onMouseMove",
    "onMouseOut",
    "onMouseOver",
    "onMouseUp",
    "onPaste",
    "onPause",
    "onPlay",
    "onPlaying",
    "onPointerCancel",
    "onPointerDown",
    "onPointerEnter",
    "onPointerLeave",
    "onPointerMove",
    "onPointerOut",
    "onPointerOver",
    "onPointerUp",
    "onProgress",
    "onRateChange",
    "onScroll",
    "onSeeked",
    "onSeeking",
    "onSelect",
    "onStalled",
    "onSubmit",
    "onSuspend",
    "onTimeUpdate",
    "onToggle",
    "onTouchCancel",
    "onTouchEnd",
    "onTouchMove",
    "onTouchStart",
    "onTransitionEnd",
    "onVolumeChange",
    "onWaiting",
    "onWheel",
    "open",
    "optimum",
    "pattern",
    "placeholder",
    "poster",
    "preload",
    "profile",
    "readOnly",
    "ref",
    "rel",
    "required",
    "reversed",
    "rows",
    "rowSpan",
    "sandbox",
    "scope",
    "scoped",
    "scrolling",
    "selected",
    "shape",
    "size",
    "sizes",
    "spellCheck",
    "src",
    "start",
    "step",
    "suppressContentEditableWarning",
    "tabIndex",
    "target",
    "value",
    "width",
    "wrap",
  ) map Name.apply
}
