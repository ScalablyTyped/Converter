package com.olvind.tso
package ts
package transforms

object QualifyReferences extends TreeVisitorScopedChanges {

  /* don't qualify built ins */
  private def shouldQualify(name: TsQIdent, scope: TreeScope): Boolean =
    if (TsQIdent Primitive name) false
    else if (name.parts.head.isInstanceOf[TsIdentLibrary]) false
    else if (scope.isAbstract(name)) false
    else true

  override def enterTsType(scope: TreeScope)(x: TsType): TsType =
    x match {
      case x @ TsTypeQuery(expr) =>
        if (shouldQualify(expr, scope)) {
          scope.lookupBase(Picker.NamedValues, expr, skipValidation = true) match {
            case (found, _) +: _ =>
              found.codePath match {
                case CodePath.NoPath => x
                case hasPath: CodePath.HasPath => TsTypeQuery(hasPath.codePath)
              }
            case Nil => x
          }
        } else x

      case x: TsTypeRef => enterTsTypeRef(scope)(x)
      case other => other
    }

  override def enterTsTypeRef(scope: TreeScope)(x: TsTypeRef): TsTypeRef =
    resolveTypeRef(scope, x, Picker.Types)

  /* Special case because sometimes classes inherit from an interface with the same name */
  override def enterTsDeclClass(scope: TreeScope)(x: TsDeclClass): TsDeclClass = {
    val picker = Picker.ButNot(Picker.Types, x)
    x.copy(implements = x.implements.map(i => resolveTypeRef(scope, i, picker)))
  }

  private def resolveTypeRef(scope: TreeScope, tr: TsTypeRef, picker: Picker[TsNamedDecl]) =
    if (shouldQualify(tr.name, scope)) {
      referenceFrom(scope.lookupBase(picker, tr.name)) match {
        case Some(newLocation) => tr.copy(name = newLocation.codePath)
        case None =>
          scope.logger.warn(s"Couldn't qualify $tr, defaulting to any")
          TsTypeRef.any
      }
    } else tr

  private def referenceFrom(types: Seq[(TsNamedDecl, TreeScope)]): Option[CodePath.HasPath] =
    types collectFirst {
      case (xx: TsNamedDecl, _) => xx.codePath.forceHasPath
    }
}
