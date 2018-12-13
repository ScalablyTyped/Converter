package com.olvind.tso
package ts
package transforms

/**
  * Typescript allows things like `type T = number | string | T[]`, while scala doesn't
  * We rewrite the recursive references to the type alias (on rhs) to `object`
  */
object SimplifyRecursiveTypeAlias extends TreeTransformationScopedChanges {
  override def enterTsTypeRef(scope: TsTreeScope)(tr: TsTypeRef): TsTypeRef = {
    val rewrittenOpt = scope.stack.collectFirst {
      case owner: TsDeclTypeAlias if owner.codePath.forceHasPath.codePath === tr.name =>
        scope.logger.info(s"Simplified recursive type alias")
        TsTypeRef.`object`
    }
    rewrittenOpt getOrElse tr

  }
}
