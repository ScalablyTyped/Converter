package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.maps.sum
import com.olvind.tso.seqs.TraversableOps

/**
  * When a class inherits the same method/field from two ancestors,
  *  we need to provide an override
  */
object InferMemberOverrides extends TreeTransformation {

  override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    if (s.parents.lengthCompare(1) > 0) s.copy(members = newMembers(scope, s, s.members, MemberImplNative))
    else s

  override def enterClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    if (s.parents.lengthCompare(1) > 0) {
      val fieldType = if (s.annotations.contains(JsNative)) MemberImplNative else MemberImplNotImplemented
      s.copy(members = newMembers(scope, s, s.members, fieldType))
    } else s

  private def newMembers[S >: MemberTree <: Tree](scope:     TreeScope,
                                                  tree:      ContainerTree,
                                                  members:   Seq[S],
                                                  fieldType: MemberImpl): Seq[S] = {
    val root = ParentsResolver(scope, tree)

    val (methods, fields, _) = members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x }
    )
    val fieldsByName: Map[Name, Seq[FieldTree]] =
      fields.groupBy(_.name)

    val methodsByBase: Map[MethodBase, Seq[MethodTree]] =
      methods groupBy Erasure.base(scope)

    val inheritedFields: Map[Name, Seq[(FieldTree, TypeRef)]] =
      sum(
        root.directParents.map(
          branch =>
            branch.transitiveParents.flatMap {
              case (parentRef, p) => p.members collect { case c: FieldTree => c.name -> (c -> parentRef) }
          }
        )
      ).filter {
        case (_, containedFields) => containedFields.map(_._2).distinct.size > 1
      }

    val addedFields: Iterable[FieldTree] =
      inheritedFields collect {
        case (name, fs) if !fieldsByName.contains(name) =>
          val head    = fs.head._1
          val newType = TypeRef.Intersection(fs.map(_._1.tpe))
          head.copy(
            isOverride = true,
            tpe        = newType,
            isReadOnly = true,
            impl       = updatedFieldType(head.impl, fieldType, Some(newType)),
            comments   = head.comments + Comment("/* InferMemberOverrides */\n")
          )
      }

    val inheritedMethods: Seq[MethodTree] =
      root.transitiveParents.values.to[Seq] flatMap (_.members collect { case c: MethodTree => c })

    val addedMethods: Iterable[MethodTree] =
      inheritedMethods groupBy Erasure.base(scope) collect {
        case (base, fs) if fs.size > 1 && !methodsByBase.contains(base) =>
          fs.head.copy(
            isOverride = true,
            resultType = TypeRef.Intersection(fs.map(_.resultType)),
            impl       = updatedFieldType(fs.head.impl, fieldType, None),
            comments   = fs.head.comments + Comment("/* InferMemberOverrides */\n")
          )
      }

    if (addedFields.nonEmpty)
      scope.logger.info(s"added override fields ${addedFields.map(_.name)}")

    if (addedMethods.nonEmpty)
      scope.logger.info(s"added override methods ${addedMethods.map(_.name)}")

    members ++ addedFields ++ addedMethods
  }

  def canBeUndefined(tpe: TypeRef): Boolean =
    tpe match {
      case TypeRef(QualifiedName.UndefOr, _, _) => true
      case TypeRef.Intersection(types)          => types forall canBeUndefined
      case _                                    => false
    }

  private def updatedFieldType(original: MemberImpl, `override`: MemberImpl, newType: Option[TypeRef]): MemberImpl =
    original match {
      case MemberImplNative | MemberImplNotImplemented => `override`
      case MemberImplCustom("js.undefined") if newType.fold(false)(x => !canBeUndefined(x)) => `override`
      case other => other
    }
}
