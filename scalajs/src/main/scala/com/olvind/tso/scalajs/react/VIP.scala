package com.olvind.tso
package scalajs
package react

case class VIP(related: Seq[TypeRef]) extends Comment.Data
object VIP {
  object FromTree {
    def unapply(arg: Tree): Option[Seq[QualifiedName]] =
      arg match {
        case tree: HasCodePath =>
          tree.comments.extract { case VIP(related) => related }.map {
            case (refs, _) =>
              val related = TreeTraverse.collectSeq(refs) {
                case TypeRef(typeName, _, _) => typeName
              }
              tree.codePath +: related
          }
        case _ => None
      }
  }
}
