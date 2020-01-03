package com.olvind.tso
package scalajs

import com.olvind.logging.Logger

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object KeepOnlyReferenced {
  final case class Keep(related:    Seq[TypeRef]) extends Comment.Data
  final case class Related(related: Seq[TypeRef]) extends Comment.Data

  def findReferences(globalScope: TreeScope, trees: Traversable[(Boolean, PackageTree)]): Index = {
    val allKeptReferences: Set[QualifiedName] =
      trees
        .flatMap {
          case (true, tree) =>
            TreeTraverse.collect(tree) { case KeptRefs(refs) => refs }.flatten.to[Set]
          case (false, tree) =>
            TreeTraverse
              .collect(tree) {
                case KeptRefs(refs)          => refs
                case TypeRef(typeName, _, _) => List(typeName)
              }
              .flatten
        }
        .to[Set]

//    val inheritanceTree: Map[QualifiedName, Traversable[QualifiedName]] = {
//      val superSub = trees.flatMap {
//        case (_, tree) =>
//          TreeTraverse
//            .collect(tree) {
//              case cls: ClassTree if cls.parents.nonEmpty =>
//                cls.parents.collect {
//                  case TypeRef(name, _, _) if name.parts.take(2) === cls.codePath.parts.take(2) => name -> cls.codePath
//                }
//            }
//            .flatten
//      }
//      superSub.groupBy(_._1).map { case (supr, subs) => supr -> subs.map(_._2) }
//    }

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

          val relatedRefs: Seq[TypeRef] =
            trees.flatMap { t =>
              t.comments.extract { case Related(x) => x } match {
                case Some(value) => value._1
                case None        => Nil
              }
            }

          val referenced: Seq[QualifiedName] =
            TreeTraverse.collectSeq(relatedRefs ++ trees) {
              case TypeRef(typeName, _, _) if typeName =/= head && !cache.contains(typeName) => typeName
            }

//          println(s"${Printer.formatQN(head)} => ${referenced.map(Printer.formatQN).mkString(",  ")}")
          cache.put(head, referenced)
          keep ++= referenced
          queue = referenced.toList ++ tail
      }
    }

    Index(keep)
  }

  /* some refs we only keep when they refer to objects/packages */
  type OnlyStatic = Boolean

  type Index = Map[QualifiedName, OnlyStatic]

  object Index {
    def apply(keep: ArrayBuffer[QualifiedName]): Index = {
      val ret = mutable.Map.empty[QualifiedName, OnlyStatic]
      keep.foreach(k => ret(k) = false)

      keep.foreach { qname =>
        qname.parts.indices.foreach { n =>
          val subQname = QualifiedName(qname.parts.take(n + 1))
          if (!ret.contains(subQname)) {
            ret(subQname) = true
          }
        }
      }
      ret.toMap
    }
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
              val fromTree = TreeTraverse.collect(tree) {
                case TypeRef(typeName, _, _) => typeName
              }

              tree.codePath +: (fromTree ++ related)
          }
        case _ => None
      }
  }

  def apply(globalScope: TreeScope, keep: Index, logger: Logger[Unit], lib: PackageTree): PackageTree =
    new FilteringTransformation(keep).visitPackageTree(globalScope)(lib)

  private final class FilteringTransformation(keep: Index) extends TreeTransformation {
    override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
      if (s.comments.extract { case Keep(_) => () }.nonEmpty) s
      else
        s.copy(
          parents = s.parents.filter(tr => keep.contains(tr.typeName)),
          members = s.members.filter {
            case x: ClassTree                           => keep.contains(x.codePath) && !keep(x.codePath)
            case x: TypeAliasTree                       => keep.contains(x.codePath) && !keep(x.codePath)
            case x: MemberTree if x.name === Name.APPLY => true
            case x: HasCodePath                         => keep.contains(x.codePath)
            case _ => false
          },
        )
    override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
      s.copy(members = s.members.filter {
        case x: ClassTree     => keep.contains(x.codePath) && !keep(x.codePath)
        case x: TypeAliasTree => keep.contains(x.codePath) && !keep(x.codePath)
        case x: HasCodePath   => keep.contains(x.codePath)
        case _ => false
      })
  }
}
