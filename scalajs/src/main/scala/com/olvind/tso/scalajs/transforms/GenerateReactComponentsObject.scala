package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.scalajs.IdentifyReactComponents.{Component, Names}

object GenerateReactComponentsObject {
  /* Let's not torture the scala compiler too much, because there *will* be a revenge
   * in the form of difficult-to-diagnose autoslaying
   */
  val MaxNumComponents = 3500

  def apply(_scope: TreeScope, tree: ContainerTree): ContainerTree = {
    val scope = _scope / tree

    val allComponents: Seq[Component] =
      IdentifyReactComponents.limited(scope, tree)

    val components = allComponents take MaxNumComponents

    if (components.isEmpty) tree
    else {
      val comments = allComponents.length - components.length match {
        case 0          => NoComments
        case numDropped => Comments(Comment(s"/* Dropped $numDropped components to please scalac */\n"))
      }

      val traitName     = Name(tree.name.unescaped + "Props")
      val traitCodePath = tree.codePath + traitName
      val `trait` = {
        val forwarders: Seq[Tree] =
          components
            .sortBy(_.fullName.unescaped)
            .flatMap {
              case comp if comp.isAbstractProps => Nil
              case comp =>
                val propsName = Name(comp.fullName.unescaped + "Props")
                genPropsRef(scope, comp, traitCodePath, propsName) ++
                  genPropsAlias(scope, comp, traitCodePath, propsName)
            }

        ClassTree(
          annotations = Nil,
          name        = traitName,
          tparams     = Nil,
          parents     = Nil,
          ctors       = Nil,
          members     = forwarders,
          classType   = ClassType.Trait,
          isSealed    = false,
          comments    = NoComments,
          codePath    = traitCodePath,
        )
      }

      val module = {
        val moduleName     = Name(tree.name.unescaped + "Components")
        val moduleCodePath = tree.codePath + moduleName
        ModuleTree(
          annotations = Nil,
          name        = moduleName,
          parents     = List(TypeRef(traitCodePath)),
          members     = components.sortBy(_.fullName.unescaped).map(comp => genComponentRef(comp, moduleCodePath)),
          comments    = comments,
          codePath    = moduleCodePath,
        )
      }

      tree.withMembers(tree.members :+ module :+ `trait`)
    }
  }

  def genPropsAlias(
      scope:          TreeScope,
      comp:           Component,
      moduleCodePath: QualifiedName,
      propsName:      Name,
  ): Option[TypeAliasTree] =
    comp.props.flatMap(
      propsType =>
        scope lookup propsType.typeName collectFirst {
          case (x: TypeAliasTree, _) => x.tparams
          case (x: ClassTree, _)     => x.tparams
        } map { tps =>
          TypeAliasTree(
            propsName,
            tps,
            propsType.copy(targs = TypeParamTree.asTypeArgs(tps)),
            NoComments,
            moduleCodePath + propsName,
          )
        },
    )

  def genPropsRef(
      scope:          TreeScope,
      comp:           Component,
      moduleCodePath: QualifiedName,
      propsName:      Name,
  ): Option[MethodTree] =
    comp.props.flatMap(
      propsType =>
        scope.lookup(propsType.typeName).collectFirst {
          case (generatedPropsCompanion: ModuleTree, _) if !generatedPropsCompanion.isNative =>
            MethodTree(
              annotations = Annotation.Inline :: Nil,
              level       = ProtectionLevel.Default,
              name        = propsName,
              tparams     = Nil,
              params      = Nil,
              impl        = MemberImpl.Custom(Printer.formatQN(generatedPropsCompanion.codePath)),
              resultType  = TypeRef.Singleton(propsType.copy(targs = Nil)),
              isOverride  = false,
              comments    = NoComments,
              codePath    = moduleCodePath + propsName,
            )
        },
    )

  def genComponentRef(comp: Component, moduleCodePath: QualifiedName): MethodTree = {
    val retType = TypeRef(Names.ComponentType, comp.props.getOrElse(TypeRef.Object) :: Nil, NoComments)
    MethodTree(
      annotations = Annotation.Inline :: Nil,
      level       = ProtectionLevel.Default,
      name        = comp.fullName,
      tparams     = comp.tparams,
      params      = Nil,
      impl = MemberImpl.Custom(
        s"${Component.formatReferenceTo(comp.ref, comp.componentType)}.asInstanceOf[${Printer.formatTypeRef(0)(retType)}]",
      ),
      resultType = retType,
      isOverride = false,
      comments   = NoComments,
      codePath   = moduleCodePath + comp.fullName,
    )
  }
}
