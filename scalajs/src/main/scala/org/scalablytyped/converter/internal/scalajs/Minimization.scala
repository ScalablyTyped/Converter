package org.scalablytyped.converter.internal
package scalajs

import com.olvind.logging.Logger

import scala.collection.mutable

object Minimization {
  val KeepMarker = Comments(Marker.MinimizationKeep(Empty))

  /* some refs we only keep when they refer to objects/packages */
  type OnlyStatic = Boolean

  type KeepIndex = Map[QualifiedName, OnlyStatic]

  def findReferences(
      globalScope:                TreeScope,
      entryPoints:                IArray[QualifiedName],
      packagesWithShouldMinimize: IArray[(PackageTree, Boolean)],
  ): KeepIndex = {

    val keep = mutable.Map.empty[QualifiedName, OnlyStatic]
    keep.sizeHint(50000)

    def addStaticParents(qname: QualifiedName): Unit = {
      var idx = 1
      while (idx < qname.parts.length) {
        val parent = QualifiedName(qname.parts.take(idx))

        if (keep.contains(parent)) ()
        else {
          if (!keep.contains(parent))
            keep(parent) = true

          addStaticParents(parent)

          globalScope.lookup(parent).foreach {
            case (tree, _) =>
              tree.comments.extract {
                case Marker.MinimizationRelated(related) =>
                  TreeTraverse.foreach(related) {
                    case TypeRef(typeName, _, _) if typeName =/= parent =>
                      expand(typeName)
                    case _ => ()
                  }
              }
              ()
          }
        }

        idx += 1
      }
    }

    def expand(qname: QualifiedName): Unit =
      keep.get(qname) match {
        case Some(false) => ()
        case _ =>
          keep(qname) = false

          addStaticParents(qname)

          val trees: IArray[Tree] =
            globalScope.lookup(qname).map(_._1)

          val relatedRefs: IArray[TypeRef] =
            trees.flatMap { t =>
              t.comments.extract { case Marker.MinimizationRelated(x) => x } match {
                case Some(value) => value._1
                case None        => Empty
              }
            }

          TreeTraverse.foreach(relatedRefs ++ trees) {
            case TypeRef(typeName, _, _) if typeName =/= qname =>
              expand(typeName)
            case _ => ()
          }

      }

    entryPoints.foreach(expand)

    packagesWithShouldMinimize.foreach {
      case (pkg, shouldMinimize) =>
        TreeTraverse.foreach(pkg) {
          case tree: Tree with HasCodePath =>
            tree.comments.extract {
              case Marker.MinimizationKeep(related) =>
                expand(tree.codePath)
                TreeTraverse.foreach(related) {
                  case TypeRef(typeName, _, _) => expand(typeName)
                  case _                       => ()
                }
            }
            ()
          case TypeRef(typeName, _, _) if !shouldMinimize =>
            expand(typeName)
          case _ => ()
        }
    }

    keep.toMap
  }

  def apply(globalScope: TreeScope, keep: KeepIndex, logger: Logger[Unit], lib: PackageTree): PackageTree =
    new FilteringTransformation(keep).visitPackageTree(globalScope)(lib)

  private final class FilteringTransformation(keep: KeepIndex) extends TreeTransformation {
    override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
      if (s.comments.has[Marker.MinimizationKeep]) s
      else {
        val newParents = s.parents.filter(tr => keep.contains(tr.typeName))
        val newMembers = filterMembers(s.members)

        s.copy(parents = newParents, members = newMembers)
      }

    override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
      s.copy(members = filterMembers(s.members))

    def filterMembers(members: IArray[Tree]): IArray[Tree] =
      members.filter {
        case x: ClassTree     => keep.contains(x.codePath) && !keep(x.codePath)
        case x: TypeAliasTree => keep.contains(x.codePath) && !keep(x.codePath)
        case x: HasCodePath   => keep.contains(x.codePath)
        case _ => false
      }
  }
}
