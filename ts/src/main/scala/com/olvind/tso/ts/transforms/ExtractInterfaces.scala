package com.olvind.tso
package ts
package transforms

import scala.collection.mutable

object ExtractInterfaces {
  def apply(inLibrary: TsIdentLibrary, scope: TsTreeScope)(file: TsParsedFile): TsParsedFile = {
    val store = new ConflictHandlingStore(inLibrary)
    val V     = new LiftTypeObjects(store)
    val asd   = V.visitTsParsedFile(scope)(file)

    asd.copy(members = asd.members ++ store.interfaces.values)
  }

  class ConflictHandlingStore(inLibrary: TsIdent) {
    val interfaces = mutable.Map.empty[TsIdent, TsDeclInterface]

    def addInterface(scope:     TsTreeScope,
                     prefix:    String,
                     members:   Seq[TsTree],
                     construct: TsIdent => TsDeclInterface): CodePath.HasPath = {
      val interface = DeriveNonConflictingName(prefix, members) { name =>
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

  private class LiftTypeObjects(store: ConflictHandlingStore) extends TreeTransformationScopedChanges {
    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case TsDeclTypeAlias(cs, dec, name, tparams, TsTypeObject(members), cp) if !isTypeMapping(members) =>
          TsDeclInterface(cs, dec, name, tparams, Nil, members, cp)
        case other => other
      }

    def isDictionary(obj: TsTypeObject): Boolean =
      obj.members forall {
        case _: TsMemberIndex => true
        case _ => false
      }

    def partOfTypeMapping(stack: List[TsTree], obj: TsTypeObject): Boolean =
      stack.exists(_.isInstanceOf[TsMemberTypeMapped]) || obj.members.forall(_.isInstanceOf[TsMemberTypeMapped])

    override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
      x match {
        case obj: TsTypeObject
            if obj.members.nonEmpty &&
              !isDictionary(obj) &&
              !partOfTypeMapping(scope.stack, obj) &&
              shouldBeExtracted(scope) =>
          val referencedTparams: Seq[TsTypeParam] =
            TypeParamsReferencedInTree(scope.tparams, obj)

          val codePath = store.addInterface(
            scope,
            "Anon_",
            obj.members,
            name =>
              TsDeclInterface(
                NoComments,
                declared = true,
                name,
                referencedTparams,
                Nil,
                obj.members,
                CodePath.NoPath
            )
          )

          TsTypeRef(NoComments, codePath.codePath, TsTypeParam.asTypeArgs(referencedTparams))

        case _ => x
      }
  }

  def shouldBeExtracted(t: TsTreeScope): Boolean =
    t.stack match {
      case List(_, _: TsDeclVar, _: TsParsedFile) => false
      case _ => true
    }

  def isTypeMapping(members: Seq[TsMember]): Boolean =
    members.exists {
      case _: TsMemberTypeMapped => true
      case _ => false
    }
}
