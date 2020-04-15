package org.scalablytyped.converter.internal
package scalajs
package flavours

class GenReactFacadeComponents(reactNames: ReactNames) {
  /* Let's not torture the scala compiler too much, because there *will* be a revenge
   * in the form of difficult-to-diagnose autoslaying
   */
  val MaxNumComponents = 3500

  def apply(_scope: TreeScope, tree: ContainerTree, allComponents: IArray[Component]): ContainerTree = {
    val scope = _scope / tree

    val components = allComponents take MaxNumComponents sortBy (_.fullName.unescaped)

    if (components.isEmpty) tree
    else {
      val comments = allComponents.length - components.length match {
        case 0          => NoComments
        case numDropped => Comments(Comment(s"/* Dropped $numDropped components to please scalac */\n"))
      }

      val traitName     = Name(scope.libName.unescaped + "Props")
      val traitCodePath = tree.codePath + traitName
      val `trait` = {
        val forwarders: IArray[Tree] =
          components
            .flatMap {
              case comp if comp.isAbstractProps => Empty
              case comp =>
                IArray.fromOptions(genPropsRef(scope, comp, traitCodePath), genPropsAlias(scope, comp, traitCodePath))
            }

        setCodePath(
          traitCodePath,
          ClassTree(
            isImplicit  = false,
            annotations = Empty,
            name        = traitName,
            tparams     = Empty,
            parents     = Empty,
            ctors       = Empty,
            members     = forwarders,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = NoComments,
            codePath    = traitCodePath,
          ),
        )
      }

      val module = {
        val moduleName     = Name(scope.libName.unescaped + "Components")
        val moduleCodePath = tree.codePath + moduleName
        setCodePath(
          moduleCodePath,
          ModuleTree(
            annotations = Empty,
            name        = moduleName,
            parents     = IArray(TypeRef(traitCodePath)),
            members     = components.map(comp => genComponentRef(scope, comp, moduleCodePath)),
            comments    = comments,
            codePath    = moduleCodePath,
            isOverride  = false,
          ),
        )
      }

      tree.withMembers(tree.members :+ module :+ `trait`)
    }
  }

  def genPropsAlias(scope: TreeScope, comp: Component, moduleCodePath: QualifiedName): Option[TypeAliasTree] =
    comp.props.flatMap(propsType =>
      scope lookup propsType.typeName collectFirst {
        case (x: TypeAliasTree, _) => x.tparams
        case (x: ClassTree, _)     => x.tparams
      } map { tps =>
        TypeAliasTree(
          comp.shortenedPropsName,
          tps,
          propsType.copy(targs = TypeParamTree.asTypeArgs(tps)),
          NoComments,
          moduleCodePath + comp.shortenedPropsName,
        )
      },
    )

  def genPropsRef(scope: TreeScope, comp: Component, moduleCodePath: QualifiedName): Option[MethodTree] =
    comp.props.flatMap(propsType =>
      scope.lookup(FollowAliases(scope)(propsType).typeName).collectFirst {
        case (generatedPropsCompanion: ModuleTree, _) if !generatedPropsCompanion.isNative =>
          MethodTree(
            annotations = IArray(Annotation.Inline),
            level       = ProtectionLevel.Default,
            name        = comp.shortenedPropsName,
            tparams     = Empty,
            params      = Empty,
            impl        = ExprTree.Ref(generatedPropsCompanion.codePath),
            resultType  = TypeRef.Singleton(TypeRef(generatedPropsCompanion.codePath, Empty, NoComments)),
            isOverride  = false,
            comments    = NoComments,
            codePath    = moduleCodePath + comp.shortenedPropsName,
          )
      },
    )

  def genComponentRef(scope: TreeScope, comp: Component, moduleCodePath: QualifiedName): MethodTree = {
    val shortenedProps = genPropsAlias(scope, comp, QualifiedName(IArray.Empty)) match {
      case Some(ta) => TypeRef(QualifiedName(IArray(ta.name)), comp.props.get.targs, ta.comments)
      case None     => comp.props getOrElse TypeRef.Object
    }

    val retType = TypeRef(reactNames.ComponentType, IArray(shortenedProps), NoComments)
    val impl    = ExprTree.Cast(Component.formatReferenceTo(comp.scalaRef, comp.componentType), retType)

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Default,
      name        = comp.fullName,
      tparams     = comp.tparams,
      params      = Empty,
      impl        = impl,
      resultType  = retType,
      isOverride  = false,
      comments    = NoComments,
      codePath    = moduleCodePath + comp.fullName,
    )
  }
}
