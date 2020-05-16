package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.flavours.GenSlinkyComponents.Mode
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyWeb.TagName

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

    def webPresent[WW](implicit ev: W =:= Option[WW]): Option[Mode[N, WW]] =
      this match {
        case Native(native) => Some(Native(native))
        case Web(ow) =>
          ev(ow) match {
            case Some(ww) => Some(Web(ww))
            case None     => None
          }
      }
  }

  final case class Native[N, W](native: N) extends Mode[N, W]
  final case class Web[N, W](web:       W) extends Mode[N, W]

  final case class SplitProps(props: IArray[Prop]) {
    val (refTypes, _, _optionals, requireds, Empty) = props.partitionCollect4(
      { case Prop(Prop.Variant(ParamTree(Name("ref"), _, _, tpe, _, _), _, _), _, _, _) => tpe },
      { case Prop(pt, _, _, _) if GenSlinkyComponents.shouldIgnore(pt.tree)             => null },
      { case Prop(Prop.Variant(p, Right(f), _), _, _, _)                                => p -> f },
      { case Prop(Prop.Variant(p, Left(expr), _), _, _, _)                              => p -> expr },
    )
    val optionals = _optionals ++ AdditionalOptionalParams

    val noNormalProps: Boolean = _optionals.isEmpty && requireds.isEmpty
  }

  final case class PropsDom(propsRef: TypeRef, splitProps: Res[SplitProps], domInfo: Mode[Unit, DomInfo])

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

    val slinkyWeb     = GenSlinkyComponents.names.slinky + Name("web")
    val slinkyWebSvg  = slinkyWeb + Name("svg")
    val slinkyWebHtml = slinkyWeb + Name("html")

    def SlinkyHtmlElement(tag: TagName): TypeRef =
      TypeRef.Singleton(TypeRef(slinkyWebHtml + tag.asName + Name("tag"), Empty, NoComments))

    def SlinkySvgElement(tag: TagName): TypeRef =
      TypeRef.Singleton(TypeRef(slinkyWebSvg + tag.asName + Name("tag"), Empty, NoComments))

    val AnyHtmlElement: TypeRef = SlinkyHtmlElement(TagName.Any)
    val AnySvgElement:  TypeRef = SlinkySvgElement(TagName.Any)

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

  def shouldIgnore(paramTree: ParamTree): Boolean = {
    val byName = names.ignoredNames(paramTree.name)
    /* we always add our own override string dictionary to all components */
    val byType = paramTree.tpe.typeName === QualifiedName.StringDictionary
    byName || byType
  }

  val AdditionalOptionalParams: IArray[(ParamTree, Name => ExprTree)] = {
    import ExprTree._
    val _overrides = Name("_overrides")
    val overridesUpdate: Name => ExprTree = obj =>
      If(
        BinaryOp(Ref(_overrides), "!=", Null),
        Call(Ref(QualifiedName.DynamicGlobalObjectAssign), IArray(IArray(Ref(obj), Ref(_overrides)))),
        None,
      )

    val overridesParam = ParamTree(
      name       = _overrides,
      isImplicit = false,
      isVal      = false,
      tpe        = TypeRef.StringDictionary(TypeRef.Any, NoComments),
      default    = ExprTree.Null,
      comments   = NoComments,
    )
    IArray(overridesParam -> overridesUpdate)
  }

  /* These definitions are here to make `ShortenNames` work in the presence of inherited names. */
  object classDefs {
    val ExternalComponentPropsCls = ClassTree(
      isImplicit = false,
      Empty,
      names.ExternalComponentProps.parts.last,
      IArray(
        TypeParamTree(Name("E"), Empty, Some(TypeRef(names.TagElement)), NoComments),
        TypeParamTree(Name("R"), Empty, Some(TypeRef.Object), NoComments),
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
      isImplicit = false,
      Empty,
      names.ExternalComponentNoProps.parts.last,
      IArray(
        TypeParamTree(Name("E"), Empty, Some(TypeRef(names.TagElement)), NoComments),
        TypeParamTree(Name("R"), Empty, Some(TypeRef.Object), NoComments),
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
    mode:         Mode[Unit, Option[SlinkyWeb]],
    memberToProp: MemberToProp,
    findProps:    FindProps,
) {
  import GenSlinkyComponents._

  def apply(scope: TreeScope, tree: ContainerTree, allComponents: IArray[Component]): ContainerTree =
    mode.webPresent[SlinkyWeb] match {
      case Some(mode) =>
        /* Every tree knows it's own location (called `CodePath`).
             It's used for a lot of things, so it's important to get right */
        val pkgCp = tree.codePath + GenSlinkyComponents.names.components

        /** We group components on what essentially means they have the same interface.
          * When there is more than one they'll share some of the generated code
          */
        val grouped: Map[(Option[TypeRef], Boolean, IArray[TypeParamTree]), IArray[Component]] =
          allComponents
            .groupBy(c => (c.props, c.knownRef.isDefined, c.tparams))

        val generatedCode: IArray[Tree] =
          IArray.fromTraversable(grouped).flatMap {
            case ((propsRefOpt, hasKnownRef, tparams), components) =>
              val PropsDom(propsRef, resProps, domInfo) =
                findPropsAndSeparateDomProps(scope, mode, propsRefOpt, tparams)

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
      case None => tree
    }

  def findPropsAndSeparateDomProps(
      scope:        TreeScope,
      withDomProps: Mode[Unit, SlinkyWeb],
      propsRefOpt:  Option[TypeRef],
      tparams:      IArray[TypeParamTree],
  ): PropsDom =
    propsRefOpt match {
      case Some(propsRef) =>
        val maxNumProps = FindProps.MaxParamsForMethod - AdditionalOptionalParams.length

        withDomProps match {
          case Native(()) =>
            val resProps: Res[FindProps.Filtered[Unit]] =
              findProps.forType(
                propsRef,
                tparams,
                scope,
                memberToProp,
                maxNumProps,
                acceptNativeTraits = true,
                FindProps.keepAll,
              )

            PropsDom(propsRef, resProps.map(f => SplitProps(f.yes)), Native(()))

          case Web(slinkyWeb: SlinkyWeb) =>
            /* pardon the mutability. we *need* to do this in several phases, and we *need* to infer the same each time */
            var inferredTagNameCache = Option.empty[TagName]

            def extractDomProps(props: IArray[Prop]): (IArray[Prop], IArray[FieldTree]) = {
              val inferredTagName: TagName = inferredTagNameCache.getOrElse {
                val i = inferSlinkyTag(props, slinkyWeb)
                inferredTagNameCache = Some(i)
                i
              }
              val tagAttrs: Map[Name, TypeRef] = slinkyWeb.tags(inferredTagName).attributes
              val yes = IArray.Builder.empty[Prop]
              val no  = IArray.Builder.empty[FieldTree]

              props.foreach {
                case prop @ Prop(_, _, _, Right(fieldTree: FieldTree)) =>
                  val isOptionalDom: Boolean =
                    if (!prop.isOptional) false
                    else
                      tagAttrs.get(fieldTree.name) match {
                        case Some(tpe) =>
                          /* todo: refactor out a name/type check which ignores optionality */
                          FollowAliases(scope)(fieldTree.tpe) match {
                            case Optional(ftpe) => ftpe === tpe
                            case ftpe           => ftpe === tpe
                          }
                        case None => false
                      }

                  if (isOptionalDom) {
                    no += fieldTree
                  } else {
                    yes += prop
                  }
                case prop =>
                  yes += prop
              }

              (yes.result(), no.result())
            }

            val resProps: Res[FindProps.Filtered[IArray[FieldTree]]] =
              findProps.forType(
                propsRef,
                tparams,
                scope,
                memberToProp,
                maxNumProps,
                acceptNativeTraits = true,
                extractDomProps,
              )

            val domInfo: Web[Unit, DomInfo] = {
              val domProps = IArray
                .fromTraversable(resProps.asMap)
                .flatMap { case (_, FindProps.Filtered(_, domFields)) => domFields }
                .distinctBy(_.name)

              Web(DomInfo(domProps, slinkyWeb.tags(inferredTagNameCache.getOrElse(TagName.Any)).slinkyTagRef))
            }

            val resSplitProps: Res[SplitProps] =
              resProps map { case FindProps.Filtered(props, _) => SplitProps(props) }

            PropsDom(propsRef, resSplitProps, domInfo)
        }

      case None =>
        val domInfo: Mode[Unit, DomInfo] =
          mode.forWeb(_ => DomInfo(IArray.Empty, names.AnyHtmlElement))

        val value: Res[SplitProps] =
          Res.One(TypeRef.Object, SplitProps(Empty))

        PropsDom(TypeRef.Object, value, domInfo)
    }

  def inferSlinkyTag(props: IArray[Prop], slinkyWeb: SlinkyWeb): TagName = {
    val successfullyMapped: IArray[TagName] =
      props.flatMap {
        case Prop(_, _, _, Left(_)) =>
          Empty
        case Prop(_, _, _, Right(tree)) =>
          TreeTraverse.collect(tree) {
            case tr: TypeRef if slinkyWeb.uniqueTagsByStdRef.contains(tr) =>
              slinkyWeb.uniqueTagsByStdRef(tr).tagName
          }
      }

    successfullyMapped match {
      case Empty => TagName.Any
      case some  => some.groupBy(identity).maxBy { case (_, list) => list.length }._1
    }
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
      IArray.fromOption(
        knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, Empty, Some(TypeRef.Object), NoComments)),
      )

    ClassTree(
      isImplicit = false,
      Empty,
      name,
      refInTParams,
      IArray(parent),
      IArray(
        CtorTree(
          ProtectionLevel.Default,
          IArray(
            ParamTree(
              Name("pw"),
              isImplicit = true,
              isVal      = false,
              TypeRef(names.ExternalPropsWriterProvider),
              NotImplemented,
              NoComments,
            ),
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

        val impl = {
          import ExprTree._
          val __obj        = Name("__obj")
          val requiredArgs = IArray(props.requireds.map { case (_, expr) => expr })
          Block.flatten(
            IArray(Val(__obj, Call(Ref(QualifiedName.DynamicLiteral), requiredArgs))),
            props.optionals.map { case (_, f) => f(__obj) },
            Call(
              Ref(QualifiedName(IArray(Name.SUPER, Name.APPLY))),
              IArray(IArray(Cast(Ref(__obj), TypeRef(names.Props)))),
            ) match {
              case call if tparams.nonEmpty => IArray(Cast(call, buildingComponent))
              case call                     => IArray(call)
            },
          )
        }
        MethodTree(
          annotations = Empty,
          level       = ProtectionLevel.Default,
          name        = name,
          tparams     = tparams,
          params      = IArray(props.requireds.map(_._1) ++ props.optionals.map(_._1)),
          impl        = impl,
          resultType  = buildingComponent,
          isOverride  = false,
          comments    = genDomWarning(domInfo),
          codePath    = ownerCp + name,
        )
      }

      /* directly accept slinky attributes/children if there are no required props */
      def noPropsApplyOpt =
        if (resProps.asMap.exists(_._2.requireds.isEmpty)) {
          val modsName = Name("mods")

          val impl = {
            import ExprTree._
            val newed = New(
              buildingComponent,
              IArray(
                Call(
                  Ref(QualifiedName.Array),
                  IArray(IArray(Cast(Ref(names.component), TypeRef.Any), Ref(QualifiedName.DictionaryEmpty))),
                ),
              ),
            )
            Call(Select(newed, Name.APPLY), IArray(IArray(Arg.Variable(Ref(modsName)))))
          }
          Some(
            MethodTree(
              annotations = Empty,
              level       = ProtectionLevel.Default,
              name        = Name.APPLY,
              tparams     = Empty,
              params = IArray(
                IArray(
                  ParamTree(
                    modsName,
                    isImplicit = false,
                    isVal      = false,
                    TypeRef.Repeated(TagMod(domInfo), NoComments),
                    NotImplemented,
                    NoComments,
                  ),
                ),
              ),
              impl       = impl,
              resultType = buildingComponent,
              isOverride = false,
              comments   = NoComments,
              codePath   = ownerCp + Name.APPLY,
            ),
          )
        } else None

      val methods: IArray[MethodTree] =
        resProps match {
          case Res.Error(_)      => Empty // we could generate something, but there is already an `apply` in the parent
          case Res.One(_, props) => IArray(applyMethod(Name.APPLY, props))
          case Res.Many(values) =>
            IArray.fromTraversable(values.map { case (propsRef, props) => applyMethod(propsRef.name, props) })
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
        annotations = IArray(Annotation.JsNative, c.location),
        name        = names.componentImport,
        parents     = Empty,
        members     = Empty,
        comments    = NoComments,
        codePath    = componentCp + names.componentImport,
        isOverride  = false,
      ),
      FieldTree(
        annotations = Empty,
        name        = names.component,
        tpe         = TypeRef.Union(IArray(TypeRef.String, TypeRef.Object), sort = false),
        impl        = ExprTree.Ref(QualifiedName(IArray(Name.THIS, names.componentImport))),
        isReadOnly  = true,
        isOverride  = true,
        comments    = Keep,
        codePath    = componentCp + names.component,
      ),
    )
}
