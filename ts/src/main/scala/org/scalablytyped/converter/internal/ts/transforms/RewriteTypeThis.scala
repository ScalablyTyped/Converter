package org.scalablytyped.converter.internal
package ts
package transforms

object RewriteTypeThis extends TreeTransformationScopedChanges {
  override def enterTsType(scope: TsTreeScope)(tpe: TsType): TsType =
    tpe match {
      case x: TsTypeRef
          if x.tparams.isEmpty &&
            isReferenceToOwner(scope.stack, x.name) &&
            isReferencedInFunction(scope.stack) &&
            !isReferencedInIndexType(scope.stack) &&
            !isReferencedInTypeLookup(scope.stack) &&
            !isReferencedInConstructor(scope.stack) =>
        TsTypeThis()

      case x: TsTypeThis if isReferencedInConstructor(scope.stack) || isReferencedInIndexType(scope.stack) =>
        scope.stack
          .collectFirst {
            case owner: TsDeclClass =>
              TsTypeRef(NoComments, owner.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(owner.tparams))
            case owner: TsDeclInterface =>
              TsTypeRef(NoComments, owner.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(owner.tparams))
          }
          .getOrElse(x)

      case other => other
    }

  def isReferenceToOwner(stack: List[TsTree], ownerName: TsQIdent): Boolean =
    stack.exists {
      case owner: TsDeclInterface if ownerName.parts.last === owner.name => true
      case owner: TsDeclClass if ownerName.parts.last === owner.name     => true
      case _ => false
    }

  def isReferencedInFunction(stack: List[TsTree]): Boolean =
    stack.exists {
      case _: TsTypeFunction => true
      case _ => false
    }

  def isReferencedInConstructor(stack: List[TsTree]): Boolean =
    stack.exists {
      case _:     TsTypeConstructor                                      => true
      case owner: TsMemberFunction if owner.name === TsIdent.constructor => true
      case _:     TsMemberCtor                                           => true
      case _ => false
    }

  def isReferencedInTypeLookup(stack: List[TsTree]): Boolean =
    stack.exists {
      case _: TsTypeLookup => true
      case _ => false
    }

  def isReferencedInIndexType(stack: List[TsTree]): Boolean =
    stack.exists {
      case TsMemberIndex(_, _, _, IndexingDict(_, _), _) => true
      case _                                             => false
    }
}
