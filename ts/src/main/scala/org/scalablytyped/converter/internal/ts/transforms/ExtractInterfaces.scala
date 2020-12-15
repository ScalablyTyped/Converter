package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.maps._
import scala.collection.mutable

object ExtractInterfaces {
  def apply(inLibrary: TsIdentLibrary, into: TsIdentSimple, scope: TsTreeScope)(file: TsParsedFile): TsParsedFile = {
    val store   = new ConflictHandlingStore(inLibrary, into)
    val newFile = new LiftTypeObjects(store).visitTsParsedFile(scope)(file)

    store.interfaces.toIArrayValues match {
      case Empty => newFile
      case nonEmpty =>
        newFile.copy(members = newFile.members :+
          TsDeclNamespace(
            NoComments,
            declared = false,
            into,
            nonEmpty,
            CodePath.HasPath(inLibrary, TsQIdent.of(into)),
            JsLocation.Zero,
          ),
        )
    }
  }

  class ConflictHandlingStore(inLibrary: TsIdent, into: TsIdentSimple) {
    val interfaces = mutable.Map.empty[TsIdent, TsDeclInterface]

    def addInterface(
        scope:             TsTreeScope,
        prefix:            String,
        members:           IArray[TsMember],
        referencedTparams: IArray[TsTypeParam],
    )(
        construct: TsIdentSimple => TsDeclInterface,
    ): CodePath.HasPath = {
      val interface = DeriveNonConflictingName(prefix, members) {
        case conflict if referencedTparams.exists(_.name === conflict) => None
        case name =>
          val interface = construct(name).withCodePath(CodePath.HasPath(inLibrary, TsQIdent(IArray(into, name))))

          interfaces.get(name) match {
            case Some(existing) if existing.members =/= interface.members || existing.tparams =/= interface.tparams =>
              None
            case Some(_) => Some(interface)
            case None    => Some(interface)
          }

      }
      interfaces.put(interface.name, interface)
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
      case TsMemberIndex(_, _, _, IndexingDict(_, _), _) => true
      case _                                             => false
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

          val prefix: String = {
            def isFunction =
              obj.members.forall {
                case _: TsMemberCall => true
                case _ => false
              }

            obj.comments.extract { case Markers.NameHint(hint) => hint } match {
              case Some((nameHint, _)) => nameHint.take(25)
              case None if isFunction  => DeriveNonConflictingName.Fn
              case None                => DeriveNonConflictingName.Anon
            }
          }

          val codePath = store.addInterface(scope, prefix, obj.members, referencedTparams) { name =>
            TsDeclInterface(
              obj.comments.extract { case Markers.NameHint(hint) => hint }.fold(obj.comments)(_._2),
              declared = true,
              name,
              referencedTparams,
              Empty,
              obj.members,
              CodePath.NoPath,
            )
          }

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
