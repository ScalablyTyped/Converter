package com.olvind.tso
package ts
package transforms

object QualifyReferences extends TreeTransformationScopedChanges {

  /* don't qualify built ins */
  private def shouldQualify(name: TsQIdent, scope: TsTreeScope): Boolean =
    if (TsQIdent Primitive name) false
    else if (name.parts.head.isInstanceOf[TsIdentLibrary]) false
    else if (scope.isAbstract(name)) false
    else true

  case class P(x: TsTypeQuery) extends Picker[TsNamedValueDecl] {
    override def unapply(t: TsNamedDecl): Option[TsNamedValueDecl] =
      t match {
        case v: TsDeclVar        => if (v.tpe.exists(_ eq x)) None else Some(v)
        case x: TsNamedValueDecl => Some(x)
        case _ => None
      }
  }

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case x @ TsTypeQuery(expr) =>
        if (shouldQualify(expr, scope)) {
          val picker = P(x)
          scope.lookupBase(picker, expr) match {
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

  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    resolveTypeRef(scope, x, Picker.Types)

  /* Special case because sometimes classes inherit from an interface with the same name */
  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val picker = Picker.ButNot(Picker.Types, x)
    x.copy(implements = x.implements.map(i => resolveTypeRef(scope, i, picker)))
  }

  private def resolveTypeRef(scope: TsTreeScope, tr: TsTypeRef, picker: Picker[TsNamedDecl]): TsTypeRef =
    if (shouldQualify(tr.name, scope)) {
      referenceFrom(scope.lookupBase(picker, tr.name)) match {
        case Some(newLocation) => tr.copy(name = newLocation.codePath)
        case None =>
          val msg = s"Couldn't qualify ${TsTypeFormatter(tr)}"
          scope.logger.warn(msg)
          TsTypeRef.any.copy(comments = Comments(Comment.warning(msg)))
      }
    } else tr

  private def referenceFrom(types: Seq[(TsNamedDecl, TsTreeScope)]): Option[CodePath.HasPath] =
    types collectFirst {
      case (xx: TsNamedDecl, _) => xx.codePath.forceHasPath
    }
}
