package org.scalablytyped.converter.internal
package scalajs
package flavours

import maps._
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames

case class LaminarFlavour(outputPkg: Name) extends FlavourImpl {
  override val dependencies: Set[Dep] =
    Set(Versions.scalaJsDom, Versions.runtime, Versions.laminar)

  override val rewritesOpt: Option[TypeRewriterCast] =
    Some(new TypeRewriterCast(scalaJsDomNames.All))

  val memberToProp  = new MemberToProp.Default(rewritesOpt)
  val findProps     = new FindProps(new CleanIllegalNames(outputPkg), memberToProp, parentsResolver)
  val genCompanions = new GenCompanions(findProps, false)

  // the normal utilities for looking up terms and types operate on fully qualified names.
  // this is specialized enough that we leave it in here for now.
  def findCustomTags(tree: Tree): IArray[(Name, TypeRef)] =
    tree match {
      case x: ClassTree if x.name.unescaped === "HTMLElementTagNameMap" =>
        x.members.collect {
          case x: FieldTree => x.name -> x.tpe
        }
      case x: ContainerTree =>
        x.members.flatMap(findCustomTags)
      case _ =>
        IArray.Empty
    }

  object names {
    val tag                 = Name("tag")
    val Ref                 = Name("Ref")
    val ModFunction         = Name("ModFunction")
    val Mod                 = QualifiedName("com.raquo.domtypes.generic.Modifier")
    val ReactiveHtmlElement = QualifiedName("com.raquo.laminar.nodes.ReactiveHtmlElement")
    val L                   = QualifiedName("com.raquo.laminar.api.L")
    val HtmlElement         = L + Name("HtmlElement")
    val HtmlTag             = QualifiedName("com.raquo.laminar.builders.HtmlTag")
    val ReactiveHtmlAttr    = QualifiedName("com.raquo.laminar.keys.ReactiveHtmlAttr")
    val StringAsIsCodec     = QualifiedName("com.raquo.domtypes.generic.codecs.StringAsIsCodec")
  }

  def gen(tagName: Name, tpe: TypeRef, scope: TreeScope, codePath: QualifiedName): Option[ModuleTree] = {
    val modCp       = codePath + tagName
    val refAlias    = genRefAlias(tpe, modCp)
    val tagField    = genTagField(tagName, modCp)
    val ModFunction = genModFunctionAlias(modCp)

    scope.lookup(tpe.typeName).collectFirst {
      case (cls: ClassTree, newScope) =>
        val allMembers: IArray[Tree] =
          parentsResolver(newScope, cls).transitiveParents.flatMapToIArray(_._2.members) ++ cls.members

        val allFields: IArray[FieldTree] =
          allMembers
            .collect {
              case x: FieldTree => x.copy(name = x.originalName) /* in case of conflicting types in different*/
            }
            .reverse // test this: I think this should keep field definition as close to `cls` as possible in case of conflicts
            .distinctBy(_.name)
            .sortBy(_.name)

        val stringFields: IArray[FieldTree] =
          allFields.collect {
            case FieldTree(_, name, TypeRef.String, _, _, _, _, _) =>
              val impl: ImplTree = {
                import ExprTree._
                Call(
                  Select(Ref(names.L), Name("customHtmlAttr")),
                  IArray(IArray(StringLit(name.unescaped), Ref(names.StringAsIsCodec))),
                )
              }
              FieldTree(
                Empty,
                name,
                TypeRef(names.ReactiveHtmlAttr, IArray(TypeRef.String), NoComments),
                impl,
                isReadOnly = true,
                isOverride = false,
                NoComments,
                modCp + name,
              )
          }

        val Apply: MethodTree = genApply(modCp, ModFunction)
        ModuleTree(
          annotations = Empty,
          name        = tagName,
          parents     = Empty,
          members     = IArray(refAlias, ModFunction, tagField) ++ stringFields ++ IArray(Apply),
          comments    = Comments(List(Marker.ManglerLeaveAlone)),
          codePath    = modCp,
          isOverride  = false,
        )
    }
  }

  // private val tag: HtmlTag[Ref] = customHtmlTag("mwc-button")
  private def genTagField(tagName: Name, modCp: QualifiedName): FieldTree = {
    import ExprTree._
    val impl = Call(Select(Ref(names.L), Name("customHtmlTag")), IArray(IArray(StringLit(tagName.unescaped))))
    FieldTree(
      Empty,
      names.tag,
      TypeRef(names.HtmlTag, IArray(TypeRef(names.Ref)), NoComments),
      impl,
      isReadOnly = false,
      isOverride = false,
      NoComments,
      modCp + names.Ref,
    )
  }

  private def genRefAlias(tpe: TypeRef, modCp: QualifiedName): TypeAliasTree =
    TypeAliasTree(
      names.Ref,
      Empty,
      TypeRef.Intersection(IArray(tpe, TypeRef(scalaJsDomNames.HTMLElement)), NoComments),
      NoComments,
      modCp + names.Ref,
    )

  def genModFunctionAlias(modCp: QualifiedName): TypeAliasTree =
    TypeAliasTree(
      names.ModFunction,
      Empty,
      TypeRef.ScalaFunction(
        IArray(TypeRef.Singleton(TypeRef(modCp, Empty, NoComments))),
        TypeRef(
          names.Mod,
          IArray(TypeRef(names.ReactiveHtmlElement, IArray(TypeRef(names.Ref)), NoComments)),
          NoComments,
        ),
        NoComments,
      ),
      NoComments,
      modCp + names.ModFunction,
    )

  def genApply(modCp: QualifiedName, ModFunction: TypeAliasTree): MethodTree = {
    import ExprTree._
    val modsParam = ParamTree(
      Name("mods"),
      isImplicit = false,
      isVal      = false,
      TypeRef.Repeated(TypeRef(ModFunction.codePath), NoComments),
      NotImplemented,
      NoComments,
    )
    val impl: ImplTree = {
      val modParam = ParamTree(
        Name("mod"),
        isImplicit = false,
        isVal      = false,
        TypeRef(ModFunction.codePath),
        NotImplemented,
        NoComments,
      )
      val callMods   = Lambda(IArray(modParam), Call(Ref(modParam.name), IArray(IArray(Ref(modCp)))))
      val calledMods = Call(Select(Ref(modsParam.name), Name("map")), IArray(IArray(callMods)))
      Call(Ref(names.tag), IArray(IArray(`:_*`(calledMods))))
    }

    MethodTree(
      Empty,
      ProtectionLevel.Default,
      Name.APPLY,
      Empty,
      IArray(IArray(modsParam)),
      impl,
      TypeRef(names.HtmlElement),
      isOverride = false,
      NoComments,
      modCp + Name.APPLY,
      isImplicit = false,
    )

  }

  // can perform any rewrite of the package inside here. However, keep in mind that downstream libraries depend on type names. if you change type names, downstream needs to be updated similarly.
  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val withCustomTags: PackageTree = {
      val generated: IArray[ModuleTree] =
        findCustomTags(tree).distinctBy(_._1).mapNotNone {
          case (tagName, tpe) => gen(tagName, tpe, scope / tree, codePath = tree.codePath)
        }

      tree.copy(members = tree.members ++ generated)
    }

    // generation of companion objects lies in flavours since it's possible to request that they not be generated.
    // in other words just keep this
    val withCompanions = genCompanions.visitPackageTree(scope)(withCustomTags)

    // rewrite type names from generated types to scala-js-dom type names
    rewritesOpt.foldLeft(withCompanions) {
      case (tree, rewriter) => rewriter.visitPackageTree(scope)(tree)
    }
  }
}
