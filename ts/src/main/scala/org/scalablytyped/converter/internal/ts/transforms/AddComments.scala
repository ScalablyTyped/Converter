package org.scalablytyped.converter.internal
package ts
package transforms

case class AddComments(newComments: Comments) extends TreeTransformationUnit {
  override def enterTsMember(t: Unit)(x: TsMember): TsMember =
    x match {
      case x: TsMemberCall       => x.copy(comments = x.comments ++ newComments)
      case x: TsMemberCtor       => x.copy(comments = x.comments ++ newComments)
      case x: TsMemberFunction   => x.copy(comments = x.comments ++ newComments)
      case x: TsMemberIndex      => x.copy(comments = x.comments ++ newComments)
      case x: TsMemberTypeMapped => x.copy(comments = x.comments ++ newComments)
      case x: TsMemberProperty   => x.copy(comments = x.comments ++ newComments)
    }
}
