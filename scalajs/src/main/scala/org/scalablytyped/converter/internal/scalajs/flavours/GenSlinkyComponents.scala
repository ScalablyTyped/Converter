package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.flavours.GenSlinkyComponents.Mode
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res

object GenSlinkyComponents {
  sealed trait Mode[N, W] {
    def forNative[NN](f: N => NN): Mode[NN, W] =
      this match {
        case Native(native) => Native(f(native))
        case Web(web)       => Web(web)
      }

    def forWeb[WW](f: W => WW): Mode[N, WW] =
      this match {
        case Native(native) => Native(native)
        case Web(web)       => Web(f(web))
      }
  }

  case class Native[N, W](native: N) extends Mode[N, W]
  case class Web[N, W](web:       W) extends Mode[N, W]

  case class SplitProps(props: IArray[Prop]) {
    val (refTypes, _, _optionals, requireds, Empty) = props.partitionCollect4(
      { case Prop(ParamTree(Name("ref"), _, tpe, _, _), _, _)       => tpe },
      { case Prop(pt, _, _) if GenSlinkyComponents.shouldIgnore(pt) => null },
      { case Prop(p, Right(f), _)                                   => p -> f },
      { case Prop(p, Left(str), _)                                  => p -> str },
    )
    val optionals = _optionals ++ AdditionalOptionalParams

    val noNormalProps: Boolean = _optionals.isEmpty && requireds.isEmpty
  }

  final case class DomInfo(domProps: IArray[FieldTree], domType: TypeRef)

  /* Disable the minimizer for component objects */
  val Keep = Comments(CommentData(Minimization.Keep(Empty)))

  val slinkyName = Name("slinky")

  object names {
    val components      = Name("components")
    val Props           = Name("Props")
    val Element         = Name("Element")
    val RefType         = Name("RefType")
    val component       = Name("component")
    val componentImport = Name("componentImport")
    val ComponentRef    = Name("ComponentRef")

    /* Fully qualified references to slinky types */
    val slinky                      = QualifiedName(IArray(GenSlinkyComponents.slinkyName))
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

    val ignoredNames = Set(Name("key"), Name("children"))
  }

  def orNothing(modeDomInfo: Mode[Unit, DomInfo]): TypeRef =
    modeDomInfo match {
      case Native(())   => TypeRef.Nothing
      case Web(domInfo) => domInfo.domType
    }

  def ExternalComponentProps(modeDomInfo: Mode[Unit, DomInfo], refType: TypeRef) =
    TypeRef(names.ExternalComponentProps, IArray(orNothing(modeDomInfo), refType), NoComments)

  def ExternalComponentNoProps(modeDomInfo: Mode[Unit, DomInfo], refType: TypeRef) =
    TypeRef(names.ExternalComponentNoProps, IArray(orNothing(modeDomInfo), refType), NoComments)

  def BuildingComponent(modeDomInfo: Mode[Unit, DomInfo], refType: TypeRef) =
    TypeRef(names.BuildingComponent, IArray(orNothing(modeDomInfo), refType), NoComments)

  def TagMod(modeDomInfo: Mode[Unit, DomInfo]) = {
    val domInfo = modeDomInfo match {
      case Native(())   => TypeRef.Any
      case Web(domInfo) => domInfo.domType
    }
    TypeRef(names.TagMod, IArray(domInfo), NoComments)
  }

  def shouldIgnore(paramTree: ParamTree) = names.ignoredNames(paramTree.name)

  val AdditionalOptionalParams: IArray[(ParamTree, String => String)] = {
    val overridesUpdate: String => String = obj =>
      s"if (_overrides != null) js.Dynamic.global.Object.assign($obj, _overrides)"
    val overridesParam = ParamTree(
      name       = Name("_overrides"),
      isImplicit = false,
      tpe        = TypeRef.StringDictionary(TypeRef.Any, NoComments),
      default    = Some(TypeRef.`null`),
      comments   = NoComments,
    )
    IArray(overridesParam -> overridesUpdate)
  }

  /* These definitions are here to make `ShortenNames` work in the presence of inherited names. */
  object classDefs {
    val ExternalComponentPropsCls = ClassTree(
      Empty,
      names.ExternalComponentProps.parts.last,
      IArray(
        TypeParamTree(Name("E"), Some(TypeRef(names.TagElement)), NoComments),
        TypeParamTree(Name("R"), Some(TypeRef.Object), NoComments),
      ),
      Empty,
      Empty,
      IArray(
        TypeAliasTree(names.Props, Empty, TypeRef.Any, NoComments, names.ExternalComponentProps + names.Props),
        TypeAliasTree(
          names.Element,
          Empty,
          TypeRef(Name("E")),
          NoComments,
          names.ExternalComponentProps + names.Element,
        ),
        TypeAliasTree(
          names.RefType,
          Empty,
          TypeRef(Name("R")),
          NoComments,
          names.ExternalComponentProps + names.RefType,
        ),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      names.ExternalComponentProps,
    )

    val ExternalComponentNoPropsCls = ClassTree(
      Empty,
      names.ExternalComponentNoProps.parts.last,
      IArray(
        TypeParamTree(Name("E"), Some(TypeRef(names.TagElement)), NoComments),
        TypeParamTree(Name("R"), Some(TypeRef.Object), NoComments),
      ),
      Empty,
      Empty,
      IArray(
        TypeAliasTree(
          names.Element,
          Empty,
          TypeRef(Name("E")),
          NoComments,
          names.ExternalComponentNoProps + names.Element,
        ),
        TypeAliasTree(
          names.RefType,
          Empty,
          TypeRef(Name("R")),
          NoComments,
          names.ExternalComponentNoProps + names.RefType,
        ),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      names.ExternalComponentNoProps,
    )
  }
}

/**
  * Generate a package with Slinky compatible react components
  */
class GenSlinkyComponents(
    scalaJsDomNames: ScalaJsDomNames,
    mode:            Mode[Unit, SlinkyWeb],
    stdNames:        QualifiedName.StdNames,
    reactNames:      ReactNames,
    findProps:       FindProps,
) {
  import GenSlinkyComponents._

  val conversions: IArray[CastConversion] = {
    import CastConversion.TParam._
    import names._

    val base = IArray(
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
    )

    val components: IArray[CastConversion] =
      IArray.fromTraversable(reactNames.ComponentQNames.map(from => CastConversion(from, ReactComponentClass, _1)))

    val shared = scalaJsDomNames.AllExceptDeprecated ++ base ++ components
    mode match {
      case Native(())    => shared
      case Web(webNames) => shared ++ webNames.conversions
    }
  }

  val ToSlinkyTypes = TypeRewriterCast(conversions)

  val memberToProp: MemberToProp =
    (scope, tree) => MemberToProp.Default(scope, ToSlinkyTypes.visitMemberTree(scope)(tree))

  def apply(scope: TreeScope, tree: ContainerTree, allComponents: IArray[Component]): ContainerTree = {
    /* for slinky/web we strip all dom props, because the user can specify them using normal slinky syntax */
    val withDomProps: Mode[Unit, (SlinkyWeb, Map[Name, TypeRef])] =
      mode.forWeb { slinkyWeb =>
        def fieldsFor(scope: TreeScope, attributes: QualifiedName) =
          scope
            .lookup(attributes)
            .collectFirst {
              case (x: ClassTree, newScope) =>
                ParentsResolver(newScope, x).directParents.flatMap(_.members) ++ x.members collect {
                  case FieldTree(_, name, Optional(tpe), _, _, _, _, _) => name -> FollowAliases(newScope)(tpe)
                  case FieldTree(_, name, tpe, _, _, _, _, _)           => name -> FollowAliases(newScope)(tpe)
                }
            }
            .fold(Map.empty[Name, TypeRef])(_.toMap)
            .filterKeys(slinkyWeb.attributes)

        val all = fieldsFor(scope, reactNames.AllHTMLAttributes) ++
          fieldsFor(scope, reactNames.SVGAttributes)
        (slinkyWeb -> all)
      }

    /* Every tree knows it's own location (called `CodePath`).
       It's used for a lot of things, so it's important to get right */
    val pkgCp = tree.codePath + GenSlinkyComponents.names.components

    /** We group components on what essentially means they have the same interface.
      * When there is more than one they'll share some of the generated code
      */
    val grouped: Map[(Option[TypeRef], Boolean, IArray[TypeParamTree]), IArray[Component]] =
      allComponents.map(_.rewritten(scope, ToSlinkyTypes)).groupBy(c => (c.props, c.knownRef.isDefined, c.tparams))

    val generatedCode: IArray[Tree] =
      IArray.fromTraversable(grouped).flatMap {
        case ((propsRefOpt, hasKnownRef, tparams), components) =>
          val (propsRef, resProps, domInfo): (TypeRef, Res[SplitProps], Mode[Unit, DomInfo]) =
            propsRefOpt match {
              case Some(propsRef) =>
                val resProps = findProps.forType(
                  propsRef,
                  tparams,
                  scope,
                  memberToProp,
                  maxNum             = FindProps.MaxParamsForMethod - AdditionalOptionalParams.length,
                  acceptNativeTraits = true,
                )

                withDomProps match {
                  case Native(()) =>
                    (propsRef, resProps.map(SplitProps), Native(()))
                  case Web((slinkyWeb, domFields)) =>
                    val (props, domInfo) = webProps(scope, resProps, slinkyWeb, domFields)
                    (propsRef, props, Web(domInfo))
                }

              case None =>
                (
                  TypeRef.Object,
                  Res.One(TypeRef.Object.name, SplitProps(Empty)),
                  mode.forWeb(slinkyWeb => DomInfo(IArray.Empty, slinkyWeb.AnyHtmlElement)),
                )
            }

          (resProps, components) match {
            case (successProps: Res.Success[SplitProps], many)
                if many.length > 1 &&
                  !resProps.asMap.forall { case (_, props) => props.noNormalProps } =>
              /** We share `apply` methods for each props type in abstract classes to limit compilation time.
                *  References causes some trouble, so if the component knows it we thread it through a type param.
                */
              val knownRefRewritten = if (hasKnownRef) Some(TypeRef(names.ComponentRef)) else None
              val propsCls =
                genSharedPropsClass(propsRef, scope, pkgCp, successProps, knownRefRewritten, tparams, domInfo)
              IArray(propsCls) ++ many.map(genComponentForSharedProps(pkgCp, propsCls))
            case (_, components) =>
              components.map(genComponent(scope, pkgCp, propsRef, resProps, domInfo))
          }
      }

    /* Only generate the package if we have mapped any components */
    generatedCode match {
      case IArray.Empty => tree
      case nonEmpty =>
        val newPackage = setCodePath(pkgCp, PackageTree(Empty, names.components, nonEmpty, NoComments, pkgCp))
        tree.withMembers(tree.members :+ newPackage)
    }
  }

  def webProps(
      scope:      TreeScope,
      resPropsIn: Res[IArray[Prop]],
      slinkyWeb:  SlinkyWeb,
      domFields:  Map[Name, TypeRef],
  ): (Res[SplitProps], DomInfo) = {
    val domPropsBuilder = IArray.Builder.empty[FieldTree]

    val resPropsOut: Res[SplitProps] =
      resPropsIn.map { props =>
        val rewrittenProps = props
          .filter {
            case Prop(param, _, _) if param.tpe.typeName === QualifiedName.StringDictionary => false
            case prop @ Prop(_, _, Right(fieldTree: FieldTree)) =>
              val isOptionalDom: Boolean =
                if (!prop.isOptional) false
                else
                  domFields.get(fieldTree.name) match {
                    case Some(tpe) =>
                      /* todo: refactor out a name/type check which ignores optionality */
                      FollowAliases(scope)(fieldTree.tpe) match {
                        case Optional(ftpe) => ftpe.typeName === tpe.typeName
                        case ftpe           => ftpe.typeName === tpe.typeName
                      }
                    case None => false
                  }

              if (isOptionalDom) {
                domPropsBuilder += fieldTree
                false
              } else true

            case _ => true
          }
          .take(FindProps.MaxParamsForMethod)

        SplitProps(rewrittenProps)
      }

    val domProps = domPropsBuilder.result().distinct

    val inferredDomType: Option[TypeRef] =
      domProps
        .firstDefined { f =>
          val referencedElements = TreeTraverse.collect(f) {
            case TypeRef(QualifiedName(IArray.exactlyThree(reactNames.outputPkg, stdNames.stdName, name)), Empty, _)
                if name.value.endsWith("Element") =>
              name.value
          }
          referencedElements.firstDefined(slinkyWeb.ElementMapping.get)
        }

    (resPropsOut, DomInfo(domProps, inferredDomType getOrElse slinkyWeb.AnyHtmlElement))
  }

  def genSharedPropsClass(
      propsRef:          TypeRef,
      scope:             TreeScope,
      pkgCp:             QualifiedName,
      resProps:          Res.Success[SplitProps],
      knownRefRewritten: Option[TypeRef],
      tparams:           IArray[TypeParamTree],
      domType:           Mode[Unit, DomInfo],
  ): ClassTree = {
    // todo: improve on this, but ensure unique
    val name = Name(
      s"SharedApply_${propsRef.name.unescaped}${(propsRef, knownRefRewritten, tparams).hashCode}"
        .replaceAllLiterally("-", "_"),
    )
    val classCp = pkgCp + name

    val (parent, methods, typeAliasOpt) =
      genContent(scope, propsRef, resProps, tparams, knownRefRewritten, domType, classCp)

    val refInTParams =
      IArray.fromOption(knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, Some(TypeRef.Object), NoComments)))

    ClassTree(
      Empty,
      name,
      refInTParams,
      IArray(parent),
      IArray(
        CtorTree(
          ProtectionLevel.Default,
          IArray(
            ParamTree(Name("pw"), isImplicit = true, TypeRef(names.ExternalPropsWriterProvider), None, NoComments),
          ),
          NoComments,
        ),
      ),
      methods ++ IArray.fromOption(typeAliasOpt),
      ClassType.AbstractClass,
      isSealed = false,
      NoComments,
      classCp,
    )
  }

  def genComponentForSharedProps(pkgCp: QualifiedName, propsClass: ClassTree)(c: Component): ModuleTree = {
    val componentCp = pkgCp + c.fullName

    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = IArray(TypeRef(propsClass.codePath, IArray.fromOption(c.knownRef).map(TypeRef.stripTargs), NoComments)),
      members     = genComponentField(c, componentCp),
      comments    = Comments(CommentData(Minimization.Keep(Empty))),
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  def genComponent(
      scope:    TreeScope,
      pkgCp:    QualifiedName,
      propsRef: TypeRef,
      resProps: Res[SplitProps],
      domInfo:  Mode[Unit, DomInfo],
  )(c:          Component): ModuleTree = {
    val componentCp = pkgCp + c.fullName
    val (parent, methods, typeAliasOpt) =
      genContent(scope, propsRef, resProps, c.tparams, c.knownRef, domInfo, componentCp)

    val errorCommentOpt =
      resProps match {
        case Res.Success(_) => None
        case Res.Error(msg) =>
          val str =
            s"/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. $msg */\n"
          Some(Comment(str))
      }
    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = IArray(parent),
      members     = genComponentField(c, componentCp) ++ methods ++ IArray.fromOption(typeAliasOpt),
      comments    = Comments(CommentData(Minimization.Keep(Empty))) +? errorCommentOpt,
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  def genContent(
      scope:    TreeScope,
      propsRef: TypeRef,
      resProps: Res[SplitProps],
      tparams:  IArray[TypeParamTree],
      knownRef: Option[TypeRef],
      domInfo:  Mode[Unit, DomInfo],
      ownerCp:  QualifiedName,
  ): (TypeRef, IArray[MethodTree], Option[TypeAliasTree]) = {
    /* Observe type bound of :< js.Object */
    val refType: TypeRef = {
      def refFromProps = IArray.fromTraversable(resProps.asMap.values).flatMap(_.refTypes).headOption

      knownRef orElse refFromProps map TypeRef.stripTargs match {
        case Some(x @ TypeRef(QualifiedName(IArray.exactlyOne(names.ComponentRef)), _, _)) => x
        case Some(value) =>
          scope
            .lookup(value.typeName)
            .collectFirst { case (_: ClassTree, _) => value }
            .getOrElse(TypeRef.Intersection(IArray(value, TypeRef.Object)))
        case None => TypeRef.Object
      }
    }

    val exposeProps: Boolean =
      resProps match {
        case Res.Many(propss)  => !propss.forall { case (_, props) => props.noNormalProps }
        case Res.One(_, props) => !props.noNormalProps
        case Res.Error(_)      => true
      }

    if (!exposeProps) {
      (ExternalComponentNoProps(domInfo, refType), Empty, None)
    } else {
      val EraseTParams = TypeRewriter(tparams.map(x => TypeRef(x.name) -> TypeRef.Any).toMap)
      val propsAlias =
        TypeAliasTree(names.Props, Empty, EraseTParams.visitTypeRef(scope)(propsRef), NoComments, ownerCp + names.Props)

      val buildingComponent = BuildingComponent(domInfo, refType)

      /**
        *  The `apply` method that the slinky method would normally construct.
        *  We implement it ourselves for flexibility and performance. Otherwise we would need to generate
        *  a case class and suffer macro execution time.
        */
      def applyMethod(name: Name, props: SplitProps): MethodTree = {
        val cast = if (tparams.nonEmpty) s".asInstanceOf[${Printer.formatTypeRef(0)(buildingComponent)}]" else ""

        MethodTree(
          annotations = Empty,
          level       = ProtectionLevel.Default,
          name        = name,
          tparams     = tparams,
          params      = IArray(props.requireds.map(_._1) ++ props.optionals.map(_._1)),
          impl = MemberImpl.Custom(
            s"""{
               |  val __obj = js.Dynamic.literal(${props.requireds.map(_._2).mkString(", ")})
               |${props.optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
               |  super.apply(__obj.asInstanceOf[Props])$cast
               |}""".stripMargin,
          ),
          resultType = buildingComponent,
          isOverride = false,
          comments   = genDomWarning(domInfo),
          codePath   = ownerCp + name,
        )
      }

      /* directly accept slinky attributes/children if there are no required props */
      def noPropsApplyOpt =
        if (resProps.asMap.exists(_._2.requireds.isEmpty))
          Some(
            MethodTree(
              Empty,
              ProtectionLevel.Default,
              Name.APPLY,
              Empty,
              IArray(
                IArray(
                  ParamTree(
                    Name("mods"),
                    isImplicit = false,
                    TypeRef.Repeated(TagMod(domInfo), NoComments),
                    None,
                    NoComments,
                  ),
                ),
              ),
              MemberImpl.Custom(
                s"new ${Printer.formatTypeRef(0)(buildingComponent)}(js.Array(component.asInstanceOf[js.Any], js.Dictionary.empty)).apply(mods: _*)",
              ),
              buildingComponent,
              isOverride = false,
              NoComments,
              ownerCp + Name.APPLY,
            ),
          )
        else None

      val methods: IArray[MethodTree] =
        resProps match {
          case Res.Error(_)      => Empty // we could generate something, but there is already an `apply` in the parent
          case Res.One(_, props) => IArray(applyMethod(Name.APPLY, props))
          case Res.Many(values)  => IArray.fromTraversable(values.map { case (name, props) => applyMethod(name, props) })
        }

      (
        ExternalComponentProps(domInfo, refType),
        methods ++ IArray.fromOption(noPropsApplyOpt),
        Some(propsAlias),
      )
    }
  }

  def genDomWarning(domInfo: Mode[Unit, DomInfo]): Comments =
    domInfo match {
      case Native(())                    => NoComments
      case Web(DomInfo(IArray.Empty, _)) => NoComments
      case Web(DomInfo(domProps, _)) =>
        val details = domProps.map(_.name.unescaped).sorted.mkString(", ")
        Comments(Comment(s"/* The following DOM/SVG props were specified: $details */\n"))
    }

  def genComponentField(c: Component, componentCp: QualifiedName): IArray[Tree with HasCodePath] =
    IArray(
      ModuleTree(
        IArray(Annotation.JsNative, c.location),
        names.componentImport,
        Empty,
        Empty,
        NoComments,
        componentCp + names.componentImport,
        isOverride = false,
      ),
      FieldTree(
        Empty,
        names.component,
        TypeRef.Union(IArray(TypeRef.String, TypeRef.Object), sort = false),
        MemberImpl.Custom(s"this.${names.componentImport.value}"),
        isReadOnly = true,
        isOverride = true,
        Keep,
        componentCp + names.component,
      ),
    )
}
