package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.flavours.GenImplicitOpsClass.AvailableName
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyGenComponents.Mode
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyWeb.TagName

object SlinkyGenComponents {
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

  final case class SplitProps(_props: IArray[Prop]) {
    val (refTypes, _, props) = {
      (_props)
        .partitionCollect2(
          //refTypes
          { case n: Prop.Normal if n.name.unescaped === "ref" => n.main.tpe },
          // ignored
          {
            case n: Prop.Normal if SlinkyGenComponents.shouldIgnoreProp(n.name, n.main.tpe)    => null
            case n: Prop.CompressedProp if SlinkyGenComponents.shouldIgnoreProp(n.name, n.tpe) => null
          },
        )
    }

    val hasRequiredProps = props.exists(_.isRequired)
  }

  final case class PropsDom(propsRef: TypeRef, splitProps: Res[IArray[String], SplitProps], domInfo: Mode[Unit, DomTag])

  final case class DomTag(domType: TypeRef)

  def domTag(modeDomInfo: Mode[Unit, DomTag]): TypeRef =
    modeDomInfo match {
      case Native(())   => TypeRef.Nothing
      case Web(domInfo) => domInfo.domType
    }

  /* Disable the minimizer for component objects */
  val Keep = Comments(CommentData(Minimization.Keep(Empty)))

  val slinkyName = Name("slinky")

  object names {
    val components   = Name("components")
    val Props        = Name("Props")
    val Element      = Name("Element")
    val RefType      = Name("RefType")
    val component    = Name("component")
    val ComponentRef = Name("ComponentRef")

    /* Fully qualified references to slinky types */
    val slinky                      = QualifiedName(IArray(SlinkyGenComponents.slinkyName))
    val slinkyCore                  = slinky + Name("core")
    val ReactComponentClass         = slinkyCore + Name("ReactComponentClass")
    val TagMod                      = slinkyCore + Name("TagMod")
    val BuildingComponent           = slinkyCore + Name("BuildingComponent")
    val TagElement                  = slinkyCore + Name("TagElement")
    val SlinkyCoreFacade            = slinkyCore + Name("facade")
    val ExternalPropsWriterProvider = slinkyCore + Name("ExternalPropsWriterProvider")
    val SyntheticEvent              = slinkyCore + Name("SyntheticEvent")
    val AttrPair                    = slinkyCore + Name("AttrPair")
    val OptionalAttrPair            = slinkyCore + Name("OptionalAttrPair")
    val ReactElement                = SlinkyCoreFacade + Name("ReactElement")
    val ReactRef                    = SlinkyCoreFacade + Name("ReactRef")

    val ignoredNames = Set(Name("key"), Name("children"))

    val slinkyWeb     = SlinkyGenComponents.names.slinky + Name("web")
    val slinkyWebSvg  = slinkyWeb + Name("svg")
    val slinkyWebHtml = slinkyWeb + Name("html")

    def SlinkyHtmlElement(tag: TagName): TypeRef =
      TypeRef.Singleton(TypeRef(slinkyWebHtml + tag.asName + Name("tag"), Empty, NoComments))

    def SlinkySvgElement(tag: TagName): TypeRef =
      TypeRef.Singleton(TypeRef(slinkyWebSvg + tag.asName + Name("tag"), Empty, NoComments))

    val AnyHtmlElement: TypeRef = SlinkyHtmlElement(TagName.Any)
    val AnySvgElement:  TypeRef = SlinkySvgElement(TagName.Any)
  }

  def shouldIgnoreProp(name: Name, tpe: TypeRef): Boolean = {
    val byName = names.ignoredNames(name)
    /* we always add our own override string dictionary to all components */
    val byType = tpe.typeName === QualifiedName.StringDictionary
    byName || byType
  }

  trait GenBuilder {
    def apply(ownerCp: QualifiedName, component: Component): Builder
  }

  sealed trait Builder {
    val ref: TypeRef =
      this match {
        case Builder.External(ref) => ref
        case Builder.Include(cls)  => TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)
      }

    def include: Option[ClassTree] =
      this match {
        case Builder.External(_)  => None
        case Builder.Include(cls) => Some(cls)
      }
  }

  object Builder {
    case class External(typeRef: TypeRef) extends Builder
    case class Include(cls:      ClassTree) extends Builder
  }

  case class SharedBuilder(cls: ClassTree, needRef: Boolean)
}

/**
  * Generate a package with Slinky compatible react components
  */
class SlinkyGenComponents(
    mode:         Mode[Unit, Option[SlinkyWeb]],
    findProps:    FindProps,
    genStBuilder: SlinkyGenStBuildingComponent,
) {
  import SlinkyGenComponents._

  def apply(scope: TreeScope, tree: ContainerTree, allComponents: IArray[Component]): ContainerTree =
    mode.webPresent[SlinkyWeb] match {
      case Some(mode) =>
        /* Every tree knows it's own location (called `CodePath`).
             It's used for a lot of things, so it's important to get right */
        val pkgCp = tree.codePath + SlinkyGenComponents.names.components

        /** We group components on what essentially means they have the same interface.
          * When there is more than one they'll share some of the generated code
          */
        val grouped: Map[(Option[TypeRef], Boolean, IArray[TypeParamTree]), IArray[Component]] =
          allComponents
            .groupBy(c => (c.props, c.referenceTo.isDefined, c.tparams))

        val generatedCode: IArray[Tree] =
          grouped.flatMapToIArray {
            case ((propsRefOpt, canBeReferenced, tparams), components) =>
              val PropsDom(propsRef, resProps, domInfo) =
                findPropsAndInferDomInfo(scope, mode, propsRefOpt, tparams)

              val resPropsSharedBuilders: Res[IArray[String], (SplitProps, Option[SharedBuilder])] = resProps.map {
                case splitProps if components.length > 1 =>
                  val sharedBuilder: Option[SharedBuilder] = {
                    val name = Name(
                      s"SharedBuilder_${propsRef.name.unescaped}${(propsRef, canBeReferenced, tparams).hashCode}"
                        .replaceAllLiterally("-", "_"),
                    )
                    val hasRef = canBeReferenced || refFromProps(resProps).isDefined
                    if (hasRef) {
                      val RR           = genStBuilder.R.copy(name = AvailableName(tparams.map(_.name))(genStBuilder.R.name))
                      val typeArgs     = IArray(domTag(domInfo), TypeRef(RR.name))
                      val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)
                      genBuilderClass(pkgCp, name, RR +: tparams, stBuilderRef, splitProps.props)
                        .map(cls => SharedBuilder(cls, needRef = true))

                    } else {
                      val typeArgs     = IArray(domTag(domInfo), TypeRef.Nothing)
                      val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)
                      genBuilderClass(pkgCp, name, tparams, stBuilderRef, splitProps.props)
                        .map(cls => SharedBuilder(cls, needRef = false))
                    }
                  }
                  splitProps -> sharedBuilder
                case splitProps => splitProps -> None
              }

              val resPropsAndBuilders = resPropsSharedBuilders
                .mapError { errors =>
                  val genBuilder: GenBuilder =
                    (ownerCp: QualifiedName, c: Component) => {
                      val typeArgs     = IArray(domTag(domInfo), effectiveRef(scope, resProps, c.referenceTo))
                      val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)

                      genBuilderClass(ownerCp, Name("Builder"), tparams, stBuilderRef, Empty) match {
                        case Some(b) => Builder.Include(b)
                        case None =>
                          Builder.External(TypeRef(genStBuilder.Default.codePath, typeArgs, NoComments))
                      }
                    }

                  errors -> genBuilder
                }
                .map {
                  case (splitProps, sharedBuilderOpt) =>
                    val genBuilder: GenBuilder =
                      (ownerCp: QualifiedName, c: Component) =>
                        sharedBuilderOpt match {
                          case Some(SharedBuilder(cls, needsRef)) =>
                            val targs: IArray[TypeRef] =
                              (needsRef, TypeParamTree.asTypeArgs(c.tparams)) match {
                                case (true, rest) => effectiveRef(scope, resProps, c.referenceTo) +: rest
                                case (false, all) => all
                              }

                            Builder.External(TypeRef(cls.codePath, targs, NoComments))
                          case None =>
                            val typeArgs     = IArray(domTag(domInfo), effectiveRef(scope, resProps, c.referenceTo))
                            val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)

                            genBuilderClass(ownerCp, Name("Builder"), tparams, stBuilderRef, splitProps.props) match {
                              case Some(b) => Builder.Include(b)
                              case None =>
                                Builder.External(TypeRef(genStBuilder.Default.codePath, typeArgs, NoComments))
                            }
                        }

                    splitProps -> genBuilder
                }

              val componentModules: IArray[ModuleTree] =
                components.map(genComponent(pkgCp, propsRef, resPropsAndBuilders))

              val sharedBuilders: IArray[ClassTree] =
                resPropsSharedBuilders.asMap
                  .flatMapToIArray {
                    case (_, (_, Some(SharedBuilder(sharedBuilder, _)))) => IArray(sharedBuilder)
                    case _                                               => Empty
                  }
                  .distinctBy(_.name)

              componentModules ++ sharedBuilders
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

  def refFromProps[E](resProps: Res[E, SplitProps]): Option[TypeRef] =
    resProps.asMap.flatMapToIArray { case (_, v) => v.refTypes }.headOption

  def effectiveRef(
      scope:             TreeScope,
      resProps:          Res[IArray[String], SplitProps],
      classComponentRef: Option[TypeRef],
  ): TypeRef =
    classComponentRef orElse refFromProps(resProps) map TypeRef.stripTargs match {
      case Some(x @ TypeRef(QualifiedName(IArray.exactlyOne(names.ComponentRef)), _, _)) => x
      /* Observe type bound of :< js.Object */
      case Some(value) =>
        scope
          .lookup(value.typeName)
          .collectFirst { case (_: ClassTree, _) => value }
          .getOrElse(TypeRef.Intersection(IArray(value, TypeRef.Object), NoComments))
      case None => TypeRef.Object
    }

  def findPropsAndInferDomInfo(
      scope:        TreeScope,
      withDomProps: Mode[Unit, SlinkyWeb],
      propsRefOpt:  Option[TypeRef],
      tparams:      IArray[TypeParamTree],
  ): PropsDom =
    propsRefOpt match {
      case Some(propsRef) =>
        val resProps: Res[IArray[String], IArray[Prop]] =
          findProps.forType(
            propsRef,
            tparams,
            scope,
            maxNum             = Int.MaxValue,
            acceptNativeTraits = true,
          )

        withDomProps match {
          case Native(()) =>
            PropsDom(propsRef, resProps.map(SplitProps.apply), Native(()))

          case Web(slinkyWeb: SlinkyWeb) =>
            val domInfo: Web[Unit, DomTag] = {
              val inferredTagName =
                resProps.headOption.map(props => inferSlinkyTag(props, slinkyWeb)).getOrElse(TagName.Any)
              Web(DomTag(slinkyWeb.tags(inferredTagName).slinkyTagRef))
            }

            PropsDom(propsRef, resProps.map(SplitProps.apply), domInfo)
        }

      case None =>
        val domInfo: Mode[Unit, DomTag] =
          mode.forWeb(_ => DomTag(names.AnyHtmlElement))

        val value: Res[IArray[String], SplitProps] =
          Res.One(TypeRef.Object, SplitProps(Empty))

        PropsDom(TypeRef.Object, value, domInfo)
    }

  def inferSlinkyTag(props: IArray[Prop], slinkyWeb: SlinkyWeb): TagName = {
    val successfullyMapped: IArray[TagName] =
      props.flatMap {
        case Prop.Normal(_, _, _, _, tree) =>
          TreeTraverse.collect(tree) {
            case tr: TypeRef if slinkyWeb.uniqueTagsByStdRef.contains(tr) =>
              slinkyWeb.uniqueTagsByStdRef(tr).tagName
          }
        case Prop.CompressedProp(_, _, _, _) =>
          Empty
      }

    successfullyMapped match {
      case Empty => TagName.Any
      case some  => some.groupBy(identity).maxBy { case (_, list) => list.length }._1
    }
  }

  def genComponent(
      pkgCp:    QualifiedName,
      propsRef: TypeRef,
      resProps: Res[(IArray[String], GenBuilder), (SplitProps, GenBuilder)],
  )(c:          Component): ModuleTree = {
    val componentCp = pkgCp + c.fullName

    resProps match {
      case Res.Error((errors, genBuilder)) =>
        errorModule(propsRef, c, componentCp, errors, genBuilder)

      case Res.One(propsRef, (splitProps, genBuilder)) =>
        componentModule(
          c.fullName,
          c,
          componentCp,
          propsRef,
          splitProps,
          genBuilder,
        )

      case Res.Many(values) =>
        val members = values.mapToIArray {
          case (propsRef, (splitProps, genBuilder: GenBuilder)) =>
            componentModule(propsRef.name, c, componentCp + propsRef.name, propsRef, splitProps, genBuilder)
        }

        ModuleTree(
          annotations = Empty,
          name        = c.fullName,
          parents     = Empty,
          members     = members,
          comments    = Comments(CommentData(Minimization.Keep(Empty))),
          codePath    = componentCp,
          isOverride  = false,
        )
    }
  }

  def errorModule(
      propsRef:    TypeRef,
      c:           flavours.Component,
      componentCp: QualifiedName,
      errors:      IArray[String],
      genBuilder:  GenBuilder,
  ): ModuleTree = {
    val builder = genBuilder(componentCp, c)
    val members = IArray.fromOptions(
      builder.include,
      Some(genPropsMethod(Name.APPLY, componentCp, propsRef, c.tparams, builder.ref)),
      genImplicitConversionOpt(Name("make"), componentCp, c.tparams, props = SplitProps(Empty), builder.ref),
    )

    val errorComment =
      Comment(
        s"/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . ${errors
          .mkString(", ")} */\n",
      )

    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = Empty,
      members     = IArray(genImportModule(c, componentCp)) ++ members,
      comments    = Comments(List(CommentData(Minimization.Keep(Empty)), errorComment)),
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  def componentModule(
      name:       Name,
      c:          Component,
      ownerCp:    QualifiedName,
      propsRef:   TypeRef,
      splitProps: SplitProps,
      genBuilder: GenBuilder,
  ): ModuleTree = {
    val builder = genBuilder(ownerCp, c)

    val members = IArray.fromOptions(
      Some(genImportModule(c, ownerCp)),
      builder.include,
      Some(genPropsMethod(Name("withProps"), ownerCp, propsRef, c.tparams, builder.ref)),
      genApplyMethodOpt(Name.APPLY, ownerCp, propsRef, splitProps, c.tparams, builder.ref),
      genImplicitConversionOpt(Name("make"), ownerCp, c.tparams, splitProps, builder.ref),
    )

    ModuleTree(
      annotations = Empty,
      name        = name,
      parents     = Empty,
      members     = members,
      comments    = Comments(CommentData(Minimization.Keep(Empty))),
      codePath    = ownerCp,
      isOverride  = false,
    )
  }

  /* only necessary if there are required props */
  def genApplyMethodOpt(
      name:       Name,
      ownerCp:    QualifiedName,
      propsRef:   TypeRef,
      splitProps: SplitProps,
      tparams:    IArray[TypeParamTree],
      builderRef: TypeRef,
  ): Option[MethodTree] =
    if (!splitProps.hasRequiredProps) None
    else {
      val props = splitProps.props.filter(_.isRequired)

      val interpretedProps = props.map(defaultInterpretation.apply)

      val (mutators, initializers, Empty) = interpretedProps.partitionCollect2(
        { case (x: Mutator, _)     => x },
        { case (x: Initializer, _) => x },
      )

      val impl: ExprTree = {
        val objName = Name("__props")

        val newed = New(
          builderRef,
          IArray(
            Call(
              Ref(QualifiedName.Array),
              IArray(
                IArray(
                  Ref(QualifiedName(IArray(Name.THIS, names.component))),
                  Cast(Ref(QualifiedName(IArray(objName))), propsRef),
                ),
              ),
            ),
          ),
        )

        Block.flatten(
          IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(initializers.map(_.value))))),
          mutators.map(f => f.value(Ref(objName))),
          IArray(newed),
        )
      }

      Some(
        MethodTree(
          annotations = IArray(Annotation.Inline),
          level       = ProtectionLevel.Default,
          name        = name,
          tparams     = tparams,
          params      = IArray(interpretedProps.map(_._2)),
          impl        = impl,
          resultType  = builderRef,
          isOverride  = false,
          comments    = NoComments,
          codePath    = ownerCp + name,
          isImplicit  = false,
        ),
      )
    }

  /* support directly using the companion as a builder if no required props */
  def genImplicitConversionOpt(
      conversionName: Name,
      ownerCp:        QualifiedName,
      tparams:        IArray[TypeParamTree],
      props:          SplitProps,
      builderRef:     TypeRef,
  ): Option[MethodTree] =
    if (props.hasRequiredProps) None
    else {
      val implicitConversion = {
        val param =
          ParamTree(
            Name("companion"),
            isImplicit = false,
            isVal      = false,
            TypeRef.Singleton(TypeRef(ownerCp.parts.last)),
            NotImplemented,
            NoComments,
          )

        val impl = {
          val newed = New(
            builderRef,
            IArray(
              Call(
                Ref(QualifiedName.Array),
                IArray(
                  IArray(Ref(QualifiedName(IArray(Name.THIS, names.component))), Ref(QualifiedName.DictionaryEmpty)),
                ),
              ),
            ),
          )
          Call(newed, IArray(IArray()))
        }

        MethodTree(
          annotations = Empty,
          level       = ProtectionLevel.Default,
          name        = conversionName,
          tparams     = tparams,
          params      = IArray(IArray(param)),
          impl        = impl,
          resultType  = builderRef,
          isOverride  = false,
          comments    = NoComments,
          codePath    = ownerCp + conversionName,
          isImplicit  = true,
        )

      }

      Some(implicitConversion)
    }

  def genPropsMethod(
      name:       Name,
      ownerCp:    QualifiedName,
      propsRef:   TypeRef,
      tparams:    IArray[TypeParamTree],
      builderRef: TypeRef,
  ): MethodTree = {
    val param = ParamTree(
      name       = Name("p"),
      isImplicit = false,
      isVal      = false,
      tpe        = propsRef,
      default    = NotImplemented,
      comments   = NoComments,
    )
    val impl = {
      New(
        builderRef,
        IArray(
          Call(
            Ref(QualifiedName.Array),
            IArray(IArray(Ref(QualifiedName(IArray(Name.THIS, names.component))), Cast(Ref(param.name), TypeRef.Any))),
          ),
        ),
      )
    }
    MethodTree(
      annotations = Empty,
      level       = ProtectionLevel.Default,
      name        = name,
      tparams     = tparams,
      params      = IArray(IArray(param)),
      impl        = impl,
      resultType  = builderRef,
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + name,
      isImplicit  = false,
    )
  }

  def genImportModule(c: Component, componentCp: QualifiedName): ModuleTree =
    ModuleTree(
      annotations = IArray(Annotation.JsNative, c.location),
      name        = names.component,
      parents     = Empty,
      members     = Empty,
      comments    = NoComments,
      codePath    = componentCp + names.component,
      isOverride  = false,
    )

  def genBuilderClass(
      owner:                QualifiedName,
      name:                 Name,
      tparams:              IArray[TypeParamTree],
      buildingComponentRef: TypeRef,
      props:                IArray[Prop],
  ): Option[ClassTree] = {
    val clsCodePath = owner + name

    val members: IArray[MethodTree] =
      props.filterNot(_.isRequired).flatMap {
        case Prop.CompressedProp(name, tpe, asExpr, isRequired) =>
          val args1 = Call(Ref(genStBuilder.args.name), IArray(IArray(NumberLit("1"))))

          val (default, update) =
            if (isRequired) (NotImplemented, asExpr(args1))
            else (Null, If(BinaryOp(Ref(name), "!=", Null), asExpr(args1), None))

          val impl = Block(update, Ref(QualifiedName.THIS))

          val param = ParamTree(name, isImplicit = false, isVal = false, tpe, default, NoComments)

          IArray(
            MethodTree(
              annotations = IArray(Annotation.Inline),
              level       = ProtectionLevel.Default,
              name        = name,
              tparams     = Empty,
              params      = IArray(IArray(param)),
              impl        = impl,
              resultType  = TypeRef.ThisType(NoComments),
              isOverride  = false,
              comments    = NoComments,
              codePath    = clsCodePath + name,
              isImplicit  = false,
            ),
          )

        case prop: Prop.Normal =>
          val variantsForProp: Map[Name, Prop.Variant] = {
            val fromVariants: Map[Name, Prop.Variant] =
              prop.variants.filter(_.isRewritten).groupBy(param => nameFor(param.tpe)).map {
                case (alternativeName, IArray.first(one)) =>
                  Name(s"${prop.name.unescaped}${alternativeName.capitalize}") -> one
              }

            fromVariants.updated(prop.name, prop.main)
          }

          val variantsMethods: IArray[MethodTree] = variantsForProp.mapToIArray {
            case (methodName, Prop.Variant(tpe, asExpr, _, _)) =>
              val param = ParamTree(Name("value"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
              val impl = Call(
                Ref(genStBuilder.set.name),
                IArray(IArray(StringLit(prop.originalName.unescaped), asExpr(Ref(param.name)))),
              )
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Default,
                name        = methodName,
                tparams     = Empty,
                params      = IArray(IArray(param)),
                impl        = impl,
                resultType  = TypeRef.ThisType(NoComments),
                isOverride  = false,
                comments    = NoComments,
                codePath    = clsCodePath + methodName,
                isImplicit  = false,
              )
          }

          val nullCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Null | Optionality.NullOrUndef =>
              val impl = Call(
                Ref(genStBuilder.set.name),
                IArray(IArray(StringLit(prop.originalName.unescaped), Null)),
              )

              val name = Name(s"${prop.name.unescaped}Null")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Default,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = TypeRef.ThisType(NoComments),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                  isImplicit  = false,
                ),
              )

            case _ => None
          }

          variantsMethods ++ IArray.fromOptions(nullCaseOpt)
        case _ => Empty
      }

    def ctor = CtorTree(
      ProtectionLevel.Default,
      IArray(
        ParamTree(
          Name("args"),
          isImplicit = false,
          isVal      = true,
          TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments),
          NotImplemented,
          NoComments,
        ),
      ),
      NoComments,
    )

    if (members.isEmpty && tparams.isEmpty) None
    else
      Some(
        ClassTree(
          isImplicit  = false,
          annotations = IArray(Annotation.Inline),
          name        = name,
          tparams     = tparams,
          parents     = IArray(TypeRef.AnyVal, buildingComponentRef),
          ctors       = IArray(ctor),
          members     = members.distinctBy(_.name.unescaped.toLowerCase),
          classType   = ClassType.Class,
          isSealed    = false,
          comments    = NoComments,
          codePath    = clsCodePath,
        ),
      ),
  }
}
