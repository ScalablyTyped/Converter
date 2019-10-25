package com.olvind.tso
package scalajs

import com.olvind.logging.Logger

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object KeepOnlyReferenced {
  final case class Keep(related: Seq[TypeRef]) extends Comment.Data

  def findReferences(globalScope: TreeScope, trees: Traversable[PackageTree]): Set[QualifiedName] = {
    val allKeptReferences: Set[QualifiedName] =
      TreeTraverse.collectSeq(trees) { case KeptRefs(refs) => refs }.flatten.to[Set]
    var queue: List[QualifiedName]                            = allKeptReferences.toList
    val keep:  ArrayBuffer[QualifiedName]                     = mutable.ArrayBuffer(queue: _*)
    val cache: mutable.Map[QualifiedName, Seq[QualifiedName]] = mutable.Map.empty

    while (queue.nonEmpty) {
      queue match {
        case head :: tail if cache contains head =>
          queue = tail
        case head :: tail =>
          val trees: Seq[Tree] =
            globalScope lookup head map (_._1)

          val referenced: Seq[QualifiedName] =
            TreeTraverse.collectSeq(trees) {
              case TypeRef(typeName, _, _) if typeName =/= head && !cache.contains(typeName) => typeName
            }

          cache.put(head, referenced)
          keep ++= referenced
          queue = referenced.toList ++ tail
      }
    }

    keep.flatMap(qname => qname.parts.indices.map(n => QualifiedName(qname.parts.take(n + 1))))(collection.breakOut)
  }

  private object KeptRefs {
    def unapply(arg: Tree): Option[Seq[QualifiedName]] =
      arg match {
        case tree: HasCodePath =>
          tree.comments.extract { case Keep(related) => related }.map {
            case (refs, _) =>
              val related = TreeTraverse.collectSeq(refs) {
                case TypeRef(typeName, _, _) => typeName
              }
              tree.codePath +: related
          }
        case _ => None
      }
  }

  def apply(globalScope: TreeScope, keep: Set[QualifiedName], logger: Logger[Unit], lib: PackageTree): PackageTree =
    new FilteringTransformation(keep).visitPackageTree(globalScope)(lib)

  private final class FilteringTransformation(keep: Set[QualifiedName]) extends TreeTransformation {
    override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
      if (s.comments.extract { case Keep(_) => () }.nonEmpty) s
      else
        s.copy(
          parents = s.parents.filter(tr => keep(tr.typeName)),
          members = s.members.filter {
            case x: MemberTree if x.name === Name.APPLY => true
            case x: HasCodePath                         => keep(x.codePath)
            case _ => false
          },
        )
    override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
      s.copy(members = s.members.filter {
        case x: HasCodePath => keep(x.codePath)
        case _ => false
      })
  }
}
