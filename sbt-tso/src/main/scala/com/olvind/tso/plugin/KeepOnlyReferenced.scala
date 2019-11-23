package com.olvind.tso
package plugin

import com.olvind.logging.Logger
import com.olvind.tso.importer.{Phase2Res, Source}
import com.olvind.tso.scalajs._
import com.olvind.tso.scalajs.react.VIP

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object KeepOnlyReferenced {
  def findReferences(
      globalScope: TreeScope,
      libs:        Map[Source.TsLibSource, Phase2Res.LibScalaJs],
  ): Seq[QualifiedName] = {

    val vipsTrees: Seq[QualifiedName] =
      libs.values.to[Seq].flatMap { lib =>
        TreeTraverse
          .collect(lib.packageTree) {
            case VIP.FromTree(refs) => refs
          }
          .flatten
      }

    var queue: List[QualifiedName]                            = vipsTrees.toList
    val keep:  ArrayBuffer[QualifiedName]                     = mutable.ArrayBuffer(vipsTrees: _*)
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

  def apply(globalScope: TreeScope, keep: Set[QualifiedName], logger: Logger[Unit], lib: PackageTree): PackageTree =
    new FilteringTransformation(keep).visitPackageTree(globalScope)(lib)

  final class FilteringTransformation(keep: Set[QualifiedName]) extends TreeTransformation {
    override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
      if (s.comments.extract { case VIP(_) => () }.nonEmpty) s
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
