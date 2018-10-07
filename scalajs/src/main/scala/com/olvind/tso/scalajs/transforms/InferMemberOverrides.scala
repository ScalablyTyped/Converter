package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.maps.sum
import seqs.TraversableOps

/**
  * When a class inherits the same method/field from two ancestors,
  *  we need to provide an override
  */
object InferMemberOverrides extends SymbolVisitor {

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    if (s.parents.lengthCompare(1) > 0) s.copy(members = newMembers(scope, s, s.members, MemberImplNative))
    else s

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    if (s.parents.lengthCompare(1) > 0) {
      val fieldType = if (s.annotations.contains(JsNative)) MemberImplNative else MemberImplNotImplemented
      s.copy(members = newMembers(scope, s, s.members, fieldType))
    } else s

  private def newMembers[S >: MemberSymbol <: Symbol](scope:     SymbolScope,
                                                      sym:       ContainerSymbol,
                                                      members:   Seq[S],
                                                      fieldType: MemberImpl): Seq[S] = {
    val root = ParentsResolver(scope, sym)

    val (methods, fields, _) = members.partitionCollect2(
      { case x: MethodSymbol => x },
      { case x: FieldSymbol  => x }
    )
    val fieldsByName: Map[Name, Seq[FieldSymbol]] =
      fields.groupBy(_.name)

    val methodsByBase: Map[MethodBase, Seq[MethodSymbol]] =
      methods groupBy Erasure.base(scope)

    val inheritedFields: Map[Name, Seq[(FieldSymbol, TypeRef)]] =
      sum(
        root.directParents.map(
          branch =>
            branch.transitiveParents.flatMap {
              case (parentRef, p) => p.members collect { case c: FieldSymbol => c.name -> (c -> parentRef) }
          }
        )
      ).filter {
        case (_, containedFields) => containedFields.map(_._2).distinct.size > 1
      }

    val addedFields: Iterable[FieldSymbol] =
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

    val inheritedMethods: Seq[MethodSymbol] =
      root.transitiveParents.values.to[Seq] flatMap (_.members collect { case c: MethodSymbol => c })

    val addedMethods: Iterable[MethodSymbol] =
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
