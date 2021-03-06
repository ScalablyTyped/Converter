package org.scalablytyped.converter.internal
package ts
package transforms

class QualifyReferences(skipValidation: Boolean) extends TreeTransformationScopedChanges {

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x: TsTypeRef => TsTypeIntersect.simplified(resolveTypeRef(scope, x, None))
      case other => other
    }

  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    resolveTypeRef(scope, x, None) match {
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
        val resolved = resolveTypeRef(scope, x, Some(_.codePath =/= ta.codePath))
        val newAlias = TsTypeIntersect.simplified(resolved)
        ta.copy(alias = newAlias)
      case _ => ta
    }

  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val all: IArray[TsTypeRef] =
      x.parent.foldRight(x.implements)(_ +: _)

    /** Special case because sometimes classes inherit from an interface with the same name
      * We'll just merge them instead
      */
    val filtered: IArray[TsTypeRef] =
      all.filter {
        case TsTypeRef(_, TsQIdent(IArray.exactlyOne(x.name)), _) => false
        case _                                                    => true
      }

    val qualified: IArray[TsTypeRef] =
      filtered.flatMap(i => resolveTypeRef(scope, i, None))

    x.copy(parent = qualified.headOption, implements = qualified.drop(1))
  }

  def resolveTypeRef(
      scope:       TsTreeScope,
      tr:          TsTypeRef,
      maybeFilter: Option[TsNamedDecl => Boolean],
  ): IArray[TsTypeRef] =
    if (shouldQualify(tr.name, scope)) {
      val all: IArray[TsNamedDecl] =
        scope.lookupType(tr.name, skipValidation = skipValidation)

      val filtered: IArray[TsNamedDecl] =
        maybeFilter.foldLeft(all)(_.filter(_))

      val many: IArray[TsTypeRef] =
        filtered.map(_.codePath.forceHasPath) match {
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
    if (TsQIdent.Primitive(name)) false
    else if (name.parts.head.isInstanceOf[TsIdentLibrary]) false
    else if (scope.isAbstract(name)) false
    else true
}
