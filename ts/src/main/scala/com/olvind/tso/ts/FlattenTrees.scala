package com.olvind.tso
package ts

import com.olvind.tso.seqs.BufferOps
import com.olvind.tso.seqs.TraversableOps

import scala.collection.mutable

/**
  * In Typescript, classes, interfaces and namespaces can be extended,
  *  both within the same file, or by includes.
  */
object FlattenTrees {
  private val Empty = TsParsedFile(NoComments, Seq.empty, Seq.empty, CodePath.NoPath)

  def apply(files: Traversable[TsParsedFile]): TsParsedFile =
    files.foldLeft(Empty)(mergeFile)

  def file(file: TsParsedFile): TsParsedFile =
    mergeFile(Empty, file)

  def mergeCodePath(one: CodePath, two: CodePath): CodePath =
    (one, two) match {
      case (CodePath.NoPath, other) => other
      case (other, _)               => other
    }

  def mergeJsLocation(one: JsLocation, two: JsLocation): JsLocation =
    (one, two) match {
      case (JsLocation.Zero, other) => other
      case (other, _)               => other
    }

  def mergeFile(one: TsParsedFile, two: TsParsedFile): TsParsedFile =
    TsParsedFile(
      comments   = mergeComments(one.comments, two.comments),
      directives = (one.directives ++ two.directives).distinct,
      members    = newMembers(one.members, two.members),
      codePath   = mergeCodePath(one.codePath, two.codePath)
    )

  def newMembers(these: Seq[TsContainerOrDecl], thats: Seq[TsContainerOrDecl]): Seq[TsContainerOrDecl] = {

    val (theseNamed, theseUnnamed) = these.partitionCollect { case x: TsNamedDecl => x }
    val (thatsNamed, thatsUnnamed) = thats.partitionCollect { case x: TsNamedDecl => x }

    val rets = mutable.ArrayBuffer[TsContainerOrDecl](theseUnnamed: _*)

    thatsUnnamed foreach {
      case that: TsGlobal =>
        rets.addOrUpdateMatching(that)(
          x => x.copy(members = newMembers(Seq.empty, x.members))
        ) {
          case existing: TsGlobal => mergeGlobal(that, existing)
        }
      case that => rets += that
    }

    rets ++= newNamedMembers(theseNamed, thatsNamed)

    rets.to[Seq].distinct
  }

  def newNamedMembers(these: Seq[TsNamedDecl], thats: Seq[TsNamedDecl]): Seq[TsNamedDecl] = {
    val rets = mutable.ArrayBuffer[TsNamedDecl](these: _*)

    thats foreach {
      case that: TsDeclNamespace =>
        rets.addOrUpdateMatching(that)(x => x.copy(members = newMembers(Nil, x.members))) {
          case existing: TsDeclNamespace if that.name === existing.name =>
            mergeNamespace(that, existing)
        }

      case that: TsDeclModule =>
        rets.addOrUpdateMatching(that)(x => x.copy(members = newMembers(Nil, x.members))) {
          case existing: TsDeclModule if that.name === existing.name =>
            mergeModule(that, existing)
        }
      case that: TsDeclClass =>
        rets.addOrUpdateMatching(that)(m => m.copy(members = newClassMembers(Nil, m.members))) {
          case existing: TsDeclClass if that.name === existing.name     => mergeClass(that, existing)
          case existing: TsDeclInterface if that.name === existing.name => mergedClassAndInterface(that, existing)
        }

      case that: TsDeclInterface =>
        rets.addOrUpdateMatching(that.copy(members = newClassMembers(Nil, that.members)): TsNamedDecl)(m => m) {
          case existing: TsDeclInterface if that.name === existing.name => mergeInterface(that, existing)
          case existing: TsDeclClass if that.name === existing.name     => mergedClassAndInterface(existing, that)
        }
      case that: TsDeclVar =>
        rets.addOrUpdateMatching(that)(m => m) {
          case existing: TsDeclVar if that.name === existing.name =>
            existing.copy(
              comments   = mergeComments(existing.comments, that.comments),
              tpe        = bothTypes(existing.tpe, that.tpe),
              isOptional = existing.isOptional || that.isOptional
            )
        }

      case that: TsAugmentedModule =>
        rets.addOrUpdateMatching(that: TsAugmentedModule)(x => x.copy(members = newMembers(Nil, x.members))) {
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
            TsDeclTypeAlias(
              comments = mergeComments(existing.comments, that.comments),
              declared = existing.declared || that.declared,
              name     = existing.name,
              tparams  = mergeTypeParams(existing.tparams, that.tparams),
              alias    = TsTypeIntersect.simplified(existing.alias :: that.alias :: Nil),
              codePath = mergeCodePath(existing.codePath, that.codePath)
            )

        }

      case that => rets += that
    }

    rets.to[Seq]
  }

  def newClassMembers(these: Seq[TsMember], thats: Seq[TsMember]): Seq[TsMember] = {

    val rets = mutable.ArrayBuffer[TsMember]()

    (these ++ thats) foreach {
      case that: TsMemberProperty =>
        rets.addOrUpdateMatching(that)(x => x) {
          case existing: TsMemberProperty if that.name === existing.name && that.isStatic === existing.isStatic =>
            existing.copy(
              comments   = mergeComments(existing.comments, that.comments),
              tpe        = bothTypes(existing.tpe, that.tpe),
              isOptional = existing.isOptional || that.isOptional
            )
        }

      case that: TsMemberIndex =>
        rets.addOrUpdateMatching(that)(x => x) {
          case existing: TsMemberIndex if that.indexing === existing.indexing =>
            existing.copy(
              comments   = mergeComments(existing.comments, that.comments),
              valueType  = TsTypeIntersect.simplified(Seq(existing.valueType, that.valueType)),
              isOptional = existing.isOptional || that.isOptional
            )
        }

      case other =>
        rets += other
    }

    rets.to[Seq].distinct
  }

  def bothTypes(one: Option[TsType], two: Option[TsType]): Option[TsType] =
    (one, two) match {
      case (Some(_1), Some(_2)) => Some(TsTypeIntersect.simplified(Seq(_1, _2)))
      case (Some(_1), None)     => Some(_1)
      case (None, Some(_2))     => Some(_2)
      case (None, None)         => None

    }
  def mergeAugmentedModule(that: TsAugmentedModule, existing: TsAugmentedModule) =
    TsAugmentedModule(
      name       = existing.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = that.jsLocation
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

  def mergeTypeParams(thats: Seq[TsTypeParam], existings: Seq[TsTypeParam]): Seq[TsTypeParam] =
    if (thats.length >= existings.length) thats else existings

  def mergeClass(that: TsDeclClass, existing: TsDeclClass): TsDeclClass = {
    val inheritance = (existing.parent.to[Seq] ++ that.parent ++ existing.implements ++ that.implements).distinct
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
      codePath   = mergeCodePath(existing.codePath, that.codePath)
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

  def mergeNamespace(that: TsDeclNamespace, existing: TsDeclNamespace) =
    TsDeclNamespace(
      comments   = mergeComments(existing.comments, that.comments),
      declared   = existing.declared || that.declared,
      name       = existing.name,
      members    = newMembers(existing.members, that.members),
      codePath   = mergeCodePath(existing.codePath, that.codePath),
      jsLocation = mergeJsLocation(existing.jsLocation, that.jsLocation),
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
