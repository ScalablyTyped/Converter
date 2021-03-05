package org.scalablytyped.converter
package internal
package ts

/**
  * In Typescript, classes, interfaces and namespaces can be extended,
  *  both within the same file, or by includes.
  */
object FlattenTrees {
  private val EmptyFile = TsParsedFile(NoComments, Empty, Empty, CodePath.NoPath)

  def apply(files: IArray[TsParsedFile]): TsParsedFile =
    files.foldLeft(EmptyFile)(mergeFile)

  def apply(file: TsParsedFile): TsParsedFile =
    mergeFile(EmptyFile, file)

  def mergeCodePath(one: CodePath, two: CodePath): CodePath =
    (one, two) match {
      case (CodePath.NoPath, other) => other
      case (other, _)               => other
    }

  def mergeJsLocation(one: JsLocation, two: JsLocation): JsLocation =
    (one, two) match {
      case (g:   JsLocation.Global, mod: JsLocation.Module) => JsLocation.Both(mod, g)
      case (mod: JsLocation.Module, g:   JsLocation.Global) => JsLocation.Both(mod, g)
      case (JsLocation.Zero, other) => other
      case (other, _)               => other
    }

  def mergeFile(one: TsParsedFile, two: TsParsedFile): TsParsedFile =
    TsParsedFile(
      comments   = mergeComments(one.comments, two.comments),
      directives = (one.directives ++ two.directives).distinct,
      members    = newMembers(one.members, two.members),
      codePath   = mergeCodePath(one.codePath, two.codePath),
    )

  def newMembers(these: IArray[TsContainerOrDecl], thats: IArray[TsContainerOrDecl]): IArray[TsContainerOrDecl] = {

    val (theseNamed, theseUnnamed) = these.partitionCollect { case x: TsNamedDecl => x }
    val (thatsNamed, thatsUnnamed) = thats.partitionCollect { case x: TsNamedDecl => x }

    val rets = IArray.Builder[TsContainerOrDecl](theseUnnamed, these.length + thats.length)

    thatsUnnamed.foreach {
      case that: TsGlobal =>
        rets.addOrUpdateMatching(that)(x => x.copy(members = newMembers(Empty, x.members))) {
          case existing: TsGlobal => mergeGlobal(that, existing)
        }
      case that => rets += that
    }

    newNamedMembers(theseNamed, thatsNamed).foreach(rets += _)

    rets.result().distinct
  }

  def newNamedMembers(these: IArray[TsNamedDecl], thats: IArray[TsNamedDecl]): IArray[TsNamedDecl] = {
    val rets = IArray.Builder[TsNamedDecl](these, these.length + thats.length)

    thats.foreach {
      case that: TsDeclNamespace =>
        rets.addOrUpdateMatching(that)(x => x.copy(members = newMembers(Empty, x.members))) {
          case existing: TsDeclNamespace if that.name === existing.name =>
            mergeNamespaces(that, existing)
          case existing: TsDeclFunction if that.name === existing.name =>
            mergeNamespaceAndFunction(that, existing)
          case existing: TsDeclVar if that.name === existing.name =>
            mergeNamespaceAndVar(that, existing)
        }

      case that: TsDeclFunction =>
        rets.addOrUpdateMatching(that: TsNamedDecl)(x => x) {
          case existing: TsDeclNamespace if that.name === existing.name =>
            mergeNamespaceAndFunction(existing, that)
        }

      case that: TsDeclModule =>
        rets.addOrUpdateMatching(that)(x => x.copy(members = newMembers(Empty, x.members))) {
          case existing: TsDeclModule if that.name === existing.name =>
            mergeModule(that, existing)
        }
      case that: TsDeclClass =>
        rets.addOrUpdateMatching(that)(m => m.copy(members = newClassMembers(Empty, m.members))) {
          case existing: TsDeclClass if that.name === existing.name     => mergeClass(that, existing)
          case existing: TsDeclInterface if that.name === existing.name => mergedClassAndInterface(that, existing)
        }

      case that: TsDeclInterface =>
        rets.addOrUpdateMatching(that.copy(members = newClassMembers(Empty, that.members)): TsNamedDecl)(m => m) {
          case existing: TsDeclInterface if that.name === existing.name => mergeInterface(that, existing)
          case existing: TsDeclClass if that.name === existing.name     => mergedClassAndInterface(existing, that)
        }

      case that: TsDeclEnum =>
        rets.addOrUpdateMatching(that)(m => m) {
          case existing: TsDeclEnum if that.name === existing.name => mergeEnum(that, existing)
        }
      case that: TsDeclVar =>
        rets.addOrUpdateMatching(that: TsNamedDecl)(m => m) {
          case existing: TsDeclVar if that.name === existing.name =>
            existing.copy(
              comments = mergeComments(existing.comments, that.comments),
              tpe      = bothTypes(existing.tpe, that.tpe),
            )
          case existing: TsDeclNamespace if that.name === existing.name =>
            mergeNamespaceAndVar(existing, that)
        }

      case that: TsAugmentedModule =>
        rets.addOrUpdateMatching(that: TsAugmentedModule)(x => x.copy(members = newMembers(Empty, x.members))) {
          case existing: TsAugmentedModule if that.name === existing.name =>
            mergeAugmentedModule(that, existing)
        }

      /**
        * Typescript doesn't do this, but we do. The reason is that sometimes a file is included twice
        *  and it's hard to avoid (see augmented-modules test, for instance).
        * This ensures that we handle it
        */
      case that: TsDeclTypeAlias =>
        rets.addOrUpdateMatching(that)(x => x) {
          case existing: TsDeclTypeAlias if that.name === existing.name =>
            IArray(existing, that).find(ta => !ta.comments.has[Markers.IsTrivial.type]).getOrElse {
              TsDeclTypeAlias(
                comments = mergeComments(existing.comments, that.comments),
                declared = existing.declared || that.declared,
                name     = existing.name,
                tparams  = mergeTypeParams(existing.tparams, that.tparams),
                alias    = TsTypeIntersect.simplified(IArray(existing.alias, that.alias)),
                codePath = mergeCodePath(existing.codePath, that.codePath),
              )
            }
        }

      case that => rets += that
    }

    rets.result()
  }

  def newClassMembers(these: IArray[TsMember], thats: IArray[TsMember]): IArray[TsMember] = {

    val rets = IArray.Builder[TsMember](IArray.Empty, these.length + thats.length)

    (these ++ thats).foreach {
      case that: TsMemberProperty =>
        rets.addOrUpdateMatching(that)(x => x) {
          case existing: TsMemberProperty if that.name === existing.name && that.isStatic === existing.isStatic =>
            existing.copy(
              comments = mergeComments(existing.comments, that.comments),
              tpe      = bothTypes(existing.tpe, that.tpe),
            )
        }

      case that: TsMemberIndex =>
        rets.addOrUpdateMatching(that)(x => x) {
          case existing: TsMemberIndex if that.indexing === existing.indexing =>
            existing.copy(
              comments  = mergeComments(existing.comments, that.comments),
              valueType = Some(TsTypeIntersect.simplified(IArray.fromOptions(existing.valueType, that.valueType))),
            )
        }

      case other =>
        rets += other
    }

    rets.result().distinct
  }

  def bothTypes(one: Option[TsType], two: Option[TsType]): Option[TsType] =
    IArray.fromOptions(one, two) match {
      case IArray.Empty           => None
      case IArray.exactlyOne(one) => Some(one)
      case more                   =>
        /* if we combine a type query with an actual type, drop the former */
        val filtered = more.filterNot(_.isInstanceOf[TsTypeQuery]) match {
          case IArray.Empty           => more
          case IArray.exactlyOne(one) => IArray(one)
          case _                      => more
        }
        Some(TsTypeIntersect.simplified(filtered))
    }

  def mergeAugmentedModule(that: TsAugmentedModule, existing: TsAugmentedModule) =
    TsAugmentedModule(
      comments   = mergeComments(existing.comments, that.comments),
      name       = existing.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = that.jsLocation,
    )

  def mergeInterface(that: TsDeclInterface, existing: TsDeclInterface) =
    TsDeclInterface(
      comments    = mergeComments(existing.comments, that.comments),
      declared    = existing.declared || that.declared,
      name        = existing.name,
      tparams     = mergeTypeParams(that.tparams, existing.tparams),
      inheritance = (existing.inheritance ++ that.inheritance).distinct,
      members     = newClassMembers(existing.members, that.members),
      codePath    = mergeCodePath(existing.codePath, that.codePath),
    )

  def mergeEnum(that: TsDeclEnum, existing: TsDeclEnum) = {
    val both         = IArray(existing, that)
    val codePaths    = both.map(_.codePath.forceHasPath.codePath).toSet
    val exportedFrom = both.mapNotNone(_.exportedFrom).filterNot(x => codePaths(x.name)).headOption

    TsDeclEnum(
      comments     = mergeComments(existing.comments, that.comments),
      declared     = existing.declared || that.declared,
      isConst      = existing.isConst,
      name         = existing.name,
      members      = existing.members,
      codePath     = existing.codePath,
      isValue      = existing.isValue || that.isValue,
      exportedFrom = exportedFrom,
      jsLocation   = mergeJsLocation(existing.jsLocation, that.jsLocation),
    )
  }

  def mergeTypeParams(thats: IArray[TsTypeParam], existings: IArray[TsTypeParam]): IArray[TsTypeParam] =
    if (thats.length >= existings.length) thats else existings

  def mergeClass(that: TsDeclClass, existing: TsDeclClass): TsDeclClass = {
    val inheritance =
      (IArray.fromOptions(existing.parent, that.parent) ++ existing.implements ++ that.implements).distinct
    TsDeclClass(
      comments   = mergeComments(existing.comments, that.comments),
      declared   = existing.declared || that.declared,
      isAbstract = existing.isAbstract && that.isAbstract,
      name       = existing.name,
      tparams    = mergeTypeParams(that.tparams, existing.tparams),
      parent     = inheritance.headOption,
      implements = inheritance.drop(1),
      members    = newClassMembers(existing.members, that.members),
      jsLocation = mergeJsLocation(existing.jsLocation, that.jsLocation),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
    )
  }
  def mergeModule(that: TsDeclModule, existing: TsDeclModule) =
    TsDeclModule(
      comments   = mergeComments(existing.comments, that.comments),
      declared   = existing.declared || that.declared,
      name       = that.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = mergeJsLocation(existing.jsLocation, that.jsLocation),
    )

  def mergeModuleAndAugmented(that: TsAugmentedModule, existing: TsDeclModule) =
    TsDeclModule(
      comments   = existing.comments,
      declared   = existing.declared,
      name       = that.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = mergeJsLocation(existing.jsLocation, that.jsLocation),
    )

  def mergeGlobal(that: TsGlobal, existing: TsGlobal) =
    TsGlobal(
      comments = mergeComments(existing.comments, that.comments),
      members  = newMembers(existing.members, that.members),
      declared = existing.declared || that.declared,
      codePath = mergeCodePath(existing.codePath, that.codePath),
    )

  def mergeNamespaces(that: TsDeclNamespace, existing: TsDeclNamespace) =
    TsDeclNamespace(
      comments   = mergeComments(existing.comments, that.comments),
      declared   = existing.declared || that.declared,
      name       = existing.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = mergeJsLocation(existing.jsLocation, that.jsLocation),
    )

  def mergeNamespaceAndFunction(ns: TsDeclNamespace, x: TsDeclFunction): TsDeclNamespace =
    ns.copy(members = ns.members :+ x
      .copy(name = TsIdent.namespaced, codePath = x.codePath.replaceLast(TsIdent.namespaced)),
    )

  def mergeNamespaceAndVar(ns: TsDeclNamespace, x: TsDeclVar): TsDeclNamespace =
    ns.copy(members = ns.members :+ x
      .copy(name = TsIdent.namespaced, codePath = x.codePath.replaceLast(TsIdent.namespaced)),
    )

  def mergedClassAndInterface(c: TsDeclClass, i: TsDeclInterface): TsDeclClass =
    TsDeclClass(
      comments   = mergeComments(i.comments, c.comments),
      declared   = i.declared || c.declared,
      isAbstract = c.isAbstract,
      name       = i.name,
      tparams    = mergeTypeParams(c.tparams, i.tparams),
      parent     = c.parent,
      implements = (i.inheritance ++ c.implements).distinct,
      members    = newClassMembers(c.members, i.members),
      jsLocation = c.jsLocation,
      codePath   = mergeCodePath(c.codePath, i.codePath),
    )

  def mergeComments(one: Comments, two: Comments): Comments =
    if (one.cs === two.cs) one else one ++ two
}
