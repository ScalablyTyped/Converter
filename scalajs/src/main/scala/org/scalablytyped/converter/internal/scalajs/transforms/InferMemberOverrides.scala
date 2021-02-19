package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.maps.sum

/**
  * When a class inherits the same method/field from two ancestors,
  * we need to provide an override
  */
class InferMemberOverrides(erasure: Erasure, parentsResolver: ParentsResolver) extends TreeTransformation {

  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree =
    if (mod.parents.length > 1 && mod.isNative)
      mod.copy(members = newMembers(scope, mod, mod.members))
    else mod

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree =
    if (cls.parents.length > 1 && cls.isNative)
      cls.copy(members = newMembers(scope, cls, cls.members))
    else cls

  private def newMembers(scope: TreeScope, tree: InheritanceTree, members: IArray[Tree]): IArray[Tree] = {
    val root = parentsResolver(scope, tree)

    val (methods, fields, _) = members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )
    val fieldsByName: Map[Name, IArray[FieldTree]] =
      fields.groupBy(_.name)

    val methodsByBase: Map[MethodBase, IArray[MethodTree]] =
      methods.groupBy(erasure.base(scope))

    val inheritedFields: Map[Name, IArray[(FieldTree, TypeRef)]] =
      sum(
        root.directParents.map { branch =>
          branch.transitiveParents.flatMap {
            case (parentRef, p) => p.members.collect { case c: FieldTree => c.name -> (c -> parentRef) }.toMap
          }
        },
      ).filter {
        case (_, containedFields) => containedFields.map(_._2).distinct.length > 1
      }

    val addedFields: IArray[FieldTree] =
      inheritedFields.mapToIArray(
        {
          case (name, fs) if !fieldsByName.contains(name) =>
            val head    = fs.head._1
            val newType = TypeRef.Intersection(fs.map(_._1.tpe), NoComments)

            head.copy(
              isOverride = true,
              tpe        = newType,
              isReadOnly = fs.forall { case (f, _) => f.isReadOnly },
              impl       = updatedImpl(fs.map(_._1.impl), Some(newType), tree.isScalaJsDefined),
              comments   = head.comments + Comment("/* InferMemberOverrides */\n"),
            )
        },
        keep = { case (name, _) => !fieldsByName.contains(name) },
      )

    val inheritedMethods: IArray[MethodTree] =
      root.transitiveParents.flatMapToIArray { case (_, v) => v.members.collect { case c: MethodTree => c } }

    val addedMethods: IArray[MethodTree] =
      IArray.fromTraversable(inheritedMethods.groupBy(erasure.base(scope))).collect {
        case (base, fs) if fs.length > 1 && !methodsByBase.contains(base) =>
          fs.head.copy(
            isOverride = true,
            resultType = TypeRef.Intersection(fs.map(_.resultType), NoComments),
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
      case TypeRef(QualifiedName.JsUndefOr, _, _) => true
      case TypeRef.undefined                      => true
      case TypeRef.Intersection(types, _)         => types.forall(canBeUndefined)
      case TypeRef.Union(types, _)                => types.exists(canBeUndefined)
      case _                                      => false
    }

  private def updatedImpl(
      fieldTypes:       IArray[ImplTree],
      typeOpt:          Option[TypeRef],
      isScalaJsDefined: Boolean,
  ): ImplTree =
    if (isScalaJsDefined) {
      fieldTypes.partitionCollect3(
        { case ExprTree.`native`    => ExprTree.native },
        { case NotImplemented       => NotImplemented },
        { case ExprTree.`undefined` => ExprTree.undefined },
      ) match {
        case (Empty, _, Empty, Empty)                                   => NotImplemented
        case (Empty, _, _, Empty) if typeOpt.fold(true)(canBeUndefined) => ExprTree.undefined
        case _                                                          => ExprTree.native
      }
    } else ExprTree.native
}
