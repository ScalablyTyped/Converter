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

  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree =
    if (mod.parents.length > 1 && mod.isNative)
      mod.copy(members = newMembers(scope, mod, mod.members))
    else mod

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree =
    if (cls.parents.length > 1 && cls.isNative)
      cls.copy(members = newMembers(scope, cls, cls.members))
    else cls

  private def newMembers(scope: TreeScope, tree: InheritanceTree, members: Seq[Tree]): Seq[Tree] = {
    val root = ParentsResolver(scope, tree)

    val (methods, fields, _) = members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
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
            },
        ),
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
            isReadOnly = fs.forall { case (f, _) => f.isReadOnly },
            impl       = updatedImpl(fs.map(_._1.impl), Some(newType), tree.isScalaJsDefined),
            comments   = head.comments + Comment("/* InferMemberOverrides */\n"),
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
            impl       = updatedImpl(fs.map(_.impl), None, tree.isScalaJsDefined),
            comments   = fs.head.comments + Comment("/* InferMemberOverrides */\n"),
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
      case Optional.UndefinedMarker     => true
      case TypeRef.Intersection(types) => types forall canBeUndefined
      case TypeRef.Union(types)        => types exists canBeUndefined
      case _                           => false
    }

  private def updatedImpl(
      fieldTypes:       Seq[MemberImpl],
      typeOpt:          Option[TypeRef],
      isScalaJsDefined: Boolean,
  ): MemberImpl =
    if (isScalaJsDefined) {
      fieldTypes.partitionCollect3(
        { case MemberImpl.Native         => MemberImpl.Native },
        { case MemberImpl.NotImplemented => MemberImpl.NotImplemented },
        { case MemberImpl.Undefined      => MemberImpl.Undefined },
      ) match {
        case (Nil, _, Nil, Nil)                                     => MemberImpl.NotImplemented
        case (Nil, _, _, Nil) if typeOpt.fold(true)(canBeUndefined) => MemberImpl.Undefined
        case _                                                      => MemberImpl.Native
      }
    } else MemberImpl.Native
}
