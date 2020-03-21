package org.scalablytyped.converter.internal
package ts
package transforms

class QualifyReferences(skipValidation: Boolean) extends TreeTransformationScopedChanges {

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x: TsTypeRef => TsTypeIntersect.simplified(resolveTypeRef(scope, x, Picker.Types))
      case other => other
    }

  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    resolveTypeRef(scope, x, Picker.Types) match {
      case IArray.exactlyOne(one) => one
      case multiple               =>
        /* due to the type signature we can't intersect these */
        multiple.find(_.name.parts.contains(TsIdent.std)).getOrElse(multiple.head)
    }

  /** special case because apparently this makes sense:
    * ```typescript
    * import {Options} from '...'
    * export type Options = Options
    * ```
    */
  override def enterTsDeclTypeAlias(scope: TsTreeScope)(ta: TsDeclTypeAlias): TsDeclTypeAlias =
    ta.alias match {
      case x: TsTypeRef =>
        val picker   = Picker.ButNot(Picker.Types, ta)
        val newAlias = TsTypeIntersect.simplified(resolveTypeRef(scope, x, picker))
        ta.copy(alias = newAlias)
      case _ => ta
    }

  /* Special case because sometimes classes inherit from an interface with the same name */
  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val picker = Picker.ButNot(Picker.Types, x)
    x.copy(implements = x.implements.flatMap(i => resolveTypeRef(scope, i, picker)))
  }

  def resolveTypeRef(scope: TsTreeScope, tr: TsTypeRef, picker: Picker[TsNamedDecl]): IArray[TsTypeRef] =
    if (shouldQualify(tr.name, scope)) {
      val many = referenceFrom(scope.lookupBase(picker, tr.name, skipValidation = skipValidation)) match {
        case Empty if skipValidation => IArray(tr)
        case Empty =>
          val msg = s"Couldn't qualify ${TsTypeFormatter(tr)}"
          scope.logger.warn(msg)
          IArray(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))
        case locations =>
          locations.map(loc => tr.copy(name = loc.codePath))
      }
      /* todo: let's drop this extra information for now, need to analyze the changes first */
      many.take(1)
    } else IArray(tr)

  def shouldQualify(name: TsQIdent, scope: TsTreeScope): Boolean =
    if (TsQIdent Primitive name) false
    else if (name.parts.head.isInstanceOf[TsIdentLibrary]) false
    else if (scope isAbstract name) false
    else true

  def referenceFrom(types: IArray[(TsNamedDecl, TsTreeScope)]): IArray[CodePath.HasPath] =
    types map {
      case (named, _) => named.codePath.forceHasPath
    }
}
