package com.olvind.tso
package ts
package transforms

object QualifyReferences extends TreeTransformationScopedChanges {

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x: TsTypeRef => TsTypeIntersect.simplified(resolveTypeRef(scope, x, Picker.Types))
      case other => other
    }

  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    resolveTypeRef(scope, x, Picker.Types) match {
      case Seq(one) => one
      case multiple =>
        /* due to the type signature we can't intersect these */
        multiple.find(_.name.parts.contains(TsIdent.std)).getOrElse(multiple.head)
    }

  /* Special case because sometimes classes inherit from an interface with the same name */
  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val picker = Picker.ButNot(Picker.Types, x)
    x.copy(implements = x.implements.flatMap(i => resolveTypeRef(scope, i, picker)))
  }

  def resolveTypeRef(scope: TsTreeScope, tr: TsTypeRef, picker: Picker[TsNamedDecl]): Seq[TsTypeRef] =
    if (shouldQualify(tr.name, scope)) {
      val many = referenceFrom(scope.lookupBase(picker, tr.name)) match {
        case Nil =>
          val msg = s"Couldn't qualify ${TsTypeFormatter(tr)}"
          scope.logger.warn(msg)
          List(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))
        case locations =>
          locations.map(loc => tr.copy(name = loc.codePath))
      }
      /* todo: let's drop this extra information for now, need to analyze the changes first */
      many.take(1)
    } else List(tr)

  def shouldQualify(name: TsQIdent, scope: TsTreeScope): Boolean =
    if (TsQIdent Primitive name) false
    else if (name.parts.head.isInstanceOf[TsIdentLibrary]) false
    else if (scope isAbstract name) false
    else true

  def referenceFrom(types: Seq[(TsNamedDecl, TsTreeScope)]): Seq[CodePath.HasPath] =
    types map {
      case (named, _) => named.codePath.forceHasPath
    }
}
