package org.scalablytyped.converter.internal
package ts
package transforms

import scala.collection.mutable

object ExtractInterfaces {

  def apply(inLibrary: TsIdentLibrary, scope: TsTreeScope)(file: TsParsedFile): TsParsedFile = {
    val store = new ConflictHandlingStore(inLibrary)
    val V     = new LiftTypeObjects(store)
    val asd   = V.visitTsParsedFile(scope)(file)

    asd.copy(members = asd.members ++ IArray.fromTraversable(store.interfaces.values))
  }

  class ConflictHandlingStore(inLibrary: TsIdent) {
    val interfaces = mutable.Map.empty[TsIdent, TsDeclInterface]

    def addInterface(
        scope:       TsTreeScope,
        prefix:      String,
        members:     IArray[TsMember],
        minNumParts: Int,
        construct:   TsIdentSimple => TsDeclInterface,
    ): CodePath.HasPath = {
      val interface = DeriveNonConflictingName(prefix, minNumParts, members) { name =>
        val interface = construct(name) withCodePath CodePath.HasPath(inLibrary, TsQIdent.of(name))

        interfaces get name match {
          case Some(existing)
              if existing.members =/= interface.members ||
                existing.tparams =/= interface.tparams =>
            None
          case Some(_) => Some(interface)
          case None    => Some(interface)
        }

      }
      interfaces.put(interface.name, interface)
      scope.logger info s"Extracted anonymous interface ${interface.name}"
      interface.codePath.forceHasPath
    }
  }

  def partOfTypeMapping(stack: List[TsTree], obj: TsTypeObject): Boolean =
    stack.exists(_.isInstanceOf[TsMemberTypeMapped]) || isTypeMapping(obj.members)

  def isTypeMapping(members: IArray[TsMember]): Boolean =
    members match {
      case IArray.exactlyOne(_: TsMemberTypeMapped) => true
      case _ => false
    }

  def isDictionary(members: IArray[TsMember]): Boolean =
    members.nonEmpty && members.forall {
      case TsMemberIndex(_, _, _, IndexingDict(_, _), _, _) => true
      case _                                                => false
    }

  private class LiftTypeObjects(store: ConflictHandlingStore) extends TreeTransformationScopedChanges {
    override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
      x match {
        case obj: TsTypeObject
            if obj.members.nonEmpty &&
              !isDictionary(obj.members) &&
              !partOfTypeMapping(scope.stack, obj) &&
              shouldBeExtracted(scope) =>
          val referencedTparams: IArray[TsTypeParam] =
            TypeParamsReferencedInTree(scope.tparams, obj)

          val nameHint = obj.comments.extract {
            case Markers.NameHint(hint) => hint
          }

          def isFunction = obj.members.forall { case _: TsMemberCall => true; case _ => false }

          val codePath = store.addInterface(
            scope,
            nameHint.fold(if (isFunction) "Fn_" else "Anon_")(_._1),
            obj.members,
            minNumParts = nameHint.fold(2)(_ => 1),
            name =>
              TsDeclInterface(
                nameHint.fold(obj.comments)(_._2),
                declared = true,
                name,
                referencedTparams,
                Empty,
                obj.members,
                CodePath.NoPath,
              ),
          )

          TsTypeRef(NoComments, codePath.codePath, TsTypeParam.asTypeArgs(referencedTparams))

        case _ => x
      }
  }

  def shouldBeExtracted(t: TsTreeScope): Boolean =
    t.stack match {
      case _ :: (_: TsDeclVar) :: _ => false
      case _ => true
    }
}
