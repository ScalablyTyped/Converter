package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.scalajs.IdentifyReactComponents.{Component, Names}

object CollectReactComponents {
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
            .sortBy(_.name.unescaped)
            .flatMap {
              case comp if comp.isAbstractProps => Nil
              case comp =>
                val propsName = Name(comp.name.unescaped + "Props")
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
          members     = components.sortBy(_.name.unescaped).map(comp => genComponentRef(comp, moduleCodePath)),
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
    scope lookup comp.props.typeName collectFirst {
      case (x: TypeAliasTree, _) => x.tparams
      case (x: ClassTree, _)     => x.tparams
    } map { tps =>
      TypeAliasTree(
        propsName,
        tps,
        comp.props.copy(targs = TypeParamTree.asTypeArgs(tps)),
        NoComments,
        moduleCodePath + propsName,
      )
    }

  def genPropsRef(
      scope:          TreeScope,
      comp:           Component,
      moduleCodePath: QualifiedName,
      propsName:      Name,
  ): Option[MethodTree] =
    scope.lookup(comp.props.typeName).collectFirst {
      case (generatedPropsCompanion: ModuleTree, _) if !generatedPropsCompanion.isNative =>
        MethodTree(
          Annotation.Inline :: Nil,
          ProtectionLevel.Default,
          propsName,
          Nil,
          Nil,
          MemberImpl.Custom(Printer.formatQN(Nil, generatedPropsCompanion.codePath)),
          TypeRef.Singleton(comp.props.copy(targs = Nil)),
          isOverride = false,
          NoComments,
          moduleCodePath + propsName,
        )
    }

  def genComponentRef(comp: Component, moduleCodePath: QualifiedName): MethodTree =
    MethodTree(
      Annotation.Inline :: Nil,
      ProtectionLevel.Default,
      comp.name,
      comp.tparams,
      Nil,
      MemberImpl.Custom(
        s"${Component.formatReferenceTo(comp.ref, comp.componentType)}.asInstanceOf[${Printer
          .formatTypeRef(Nil, 0)(TypeRef(Names.ComponentType, comp.props :: Nil, NoComments))}]",
      ),
      TypeRef(Names.ComponentType, comp.props :: Nil, NoComments),
      isOverride = false,
      NoComments,
      moduleCodePath + comp.name,
    )
}
