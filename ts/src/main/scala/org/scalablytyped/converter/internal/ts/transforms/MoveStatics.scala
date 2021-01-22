package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * Extract statics into a namespace.
  *
  * Freely create duplicate namespaces, since they will be combined right after
  */
object MoveStatics extends TransformMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.flatMap {
      case int: TsDeclInterface =>
        val comment = Comment(
          s"/* Note: this doesnt actually exist! a class implementing ${int.name.value} should have this defined on it's companion object */\n",
        )

        val (statics, nonStatics) = extractStatics(int.members, comment)

        statics.mapNotNone(Hoisting.memberToDecl(int.codePath, JsLocation.Zero)) match {
          case Empty => IArray(int)
          case nonEmpty =>
            val ns = TsDeclNamespace(NoComments, int.declared, int.name, nonEmpty, int.codePath, JsLocation.Zero)
            IArray(int.copy(comments = int.comments + comment, members = nonStatics), ns)
        }

      case cls: TsDeclClass =>
        val (statics, nonStatics) = extractStatics(cls.members, Comment("/* static member */\n"))

        statics.mapNotNone(Hoisting.memberToDecl(cls.codePath, cls.jsLocation)) match {
          case Empty =>
            IArray(cls)
          case nonEmpty =>
            val ns = TsDeclNamespace(NoComments, cls.declared, cls.name, nonEmpty, cls.codePath, cls.jsLocation)
            IArray(cls.copy(members = nonStatics), ns)
        }

      case other => IArray(other)
    }

  def extractStatics(members: IArray[TsMember], comment: Comment): (IArray[TsMember], IArray[TsMember]) =
    members.partitionCollect {
      case x: TsMemberProperty if x.isStatic =>
        x.copy(isStatic = false, comments = x.comments + comment)
      case x: TsMemberFunction if x.isStatic =>
        x.copy(isStatic = false, comments = x.comments + comment)
    }
}
