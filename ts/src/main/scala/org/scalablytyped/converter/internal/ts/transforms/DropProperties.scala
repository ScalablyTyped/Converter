package org.scalablytyped.converter.internal
package ts.transforms

import org.scalablytyped.converter.internal.ts._

object DropProperties extends TransformClassMembers with TransformMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.filter {
      case x: TsNamedValueDecl => x.name.value =/= "__promisify__"
      case _ => true
    }

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember] =
    x.members.filter {
      case TsMemberProperty(_, _, TsIdent.prototype, _, _, _, _)                      => false
      case TsMemberProperty(_, _, ident, _, _, _, _) if ident.value.startsWith("\\u") => false
      case TsMemberProperty(_, _, _, Some(TsTypeRef.never), _, _, _)                  => false
      case _                                                                          => true
    }
}
