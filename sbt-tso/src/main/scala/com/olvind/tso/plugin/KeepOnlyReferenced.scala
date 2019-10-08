package com.olvind.tso
package plugin

import com.olvind.logging.Logger
import com.olvind.tso.importer.{Phase2Res, Source}
import com.olvind.tso.scalajs._

import scala.collection.immutable.SortedMap
import scala.collection.mutable

object KeepOnlyReferenced {
  def findReferences(
      globalScope: TreeScope,
      libs:        SortedMap[Source.TsLibSource, Phase2Res.LibScalaJs],
  ): Seq[QualifiedName] = {
    val vipsTrees: Seq[QualifiedName] =
      libs.values.to[Seq].flatMap { lib =>
        TreeTraverse.collect(lib.packageTree) {
          case x: Tree with scalajs.HasCodePath if x.comments has Markers.VIP => x.codePath
        }
      }

    val cache = mutable.Map.empty[QualifiedName, Seq[QualifiedName]]
    var toCheck: List[QualifiedName] = vipsTrees.toList
    val keep = mutable.ArrayBuffer[QualifiedName](vipsTrees: _*)

    while (toCheck.nonEmpty) {
      val currentCp = toCheck.head
      val newToCheck: Seq[QualifiedName] =
        if (cache.contains(currentCp)) Nil
        else {
          val currents = globalScope.lookup(currentCp)
          val referenced = TreeTraverse.collectSeq(currents.map(_._1)) {
            case TypeRef(typeName, _, _)
                if typeName =/= currentCp &&
                  !cache.contains(typeName) // optimization
                =>
              typeName
          }
          cache.put(currentCp, referenced)

          //              if (referenced.nonEmpty)
          //                println(currentCp + " ==> " + referenced.size ++ s" (first ten: ${referenced.take(10)})")

          keep ++= referenced
          referenced
        }
      toCheck = newToCheck.toList ++ toCheck.tail
    }
    keep.flatMap(qname => qname.parts.indices.map(n => QualifiedName(qname.parts.take(n + 1))))(collection.breakOut)
  }

  def apply(globalScope: TreeScope, keep: Set[QualifiedName], logger: Logger[Unit], lib: PackageTree): PackageTree =
    new FilteringTransformation(keep).visitPackageTree(globalScope)(lib)

  final class FilteringTransformation(keep: Set[QualifiedName]) extends TreeTransformation {
    override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
      if (s.comments has Markers.VIP) s
      else
        s.copy(
          parents = s.parents.filter(tr => keep(tr.typeName)),
          members = s.members.filter {
            case x: MemberTree if x.name === Name.APPLY => true
            case x: scalajs.HasCodePath                 => keep(x.codePath)
            case _ => false
          },
        )
    override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
      s.copy(members = s.members.filter {
        case x: scalajs.HasCodePath => keep(x.codePath)
        case _ => false
      })
  }
}
