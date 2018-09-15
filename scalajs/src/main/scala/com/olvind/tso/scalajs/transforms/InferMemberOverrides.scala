package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.maps.sum

/**
  * When a class inherits the same method/field from two ancestors,
  *  we need to provide an override
  */
object InferMemberOverrides extends SymbolVisitor {

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    if (s.parents.lengthCompare(1) > 0) s.copy(members = newMembers(scope, s, s.members, FieldTypeNative))
    else s

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    if (s.parents.lengthCompare(1) > 0) {
      val fieldType = if (s.annotations.contains(JsNative)) FieldTypeNative else FieldTypeNotImplemented
      s.copy(members = newMembers(scope, s, s.members, fieldType))
    } else s

  private def newMembers[S >: MemberSymbol <: Symbol](scope:     SymbolScope,
                                                      sym:       ContainerSymbol,
                                                      members:   Seq[S],
                                                      fieldType: FieldType): Seq[S] = {
    val root = ParentsResolver(scope, sym)

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
        case (_, fs) =>
          val head    = fs.head._1
          val newType = TypeRef.Intersection(fs.map(_._1.tpe))
          head.copy(
            isOverride = fs.exists(_._1.fieldType =/= FieldTypeNotImplemented),
            tpe = newType,
            isReadOnly = true,
            fieldType = updatedFieldType(head.fieldType, fieldType, Some(newType)),
            comments = head.comments + Comment("/* InferMemberOverrides */\n")
          )
      }

    val inheritedMethods: Seq[MethodSymbol] =
      root.transitiveParents.values.to[Seq] flatMap (_.members collect { case c: MethodSymbol => c })

    val addedMethods: Iterable[MethodSymbol] =
      inheritedMethods groupBy Erasure.base(scope) collect {
        case (_, fs) if fs.size > 1 =>
          fs.head.copy(
            isOverride = true,
            resultType = TypeRef.Intersection(fs.map(_.resultType)),
            fieldType = updatedFieldType(fs.head.fieldType, fieldType, None),
            comments = fs.head.comments + Comment("/* InferMemberOverrides */\n")
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

  private def updatedFieldType(original: FieldType, `override`: FieldType, newType: Option[TypeRef]): FieldType =
    original match {
      case FieldTypeNative | FieldTypeNotImplemented                                      => `override`
      case FieldTypeScala("js.undefined") if newType.fold(false)(x => !canBeUndefined(x)) => `override`
      case other                                                                          => other
    }
}
