package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.annotation.switch

object Sorter extends TreeTransformation {

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(members = s.members.sorted(TreeOrdering), ctors = s.ctors.sorted(TreeOrdering))

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = s.members.sorted(TreeOrdering))

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = s.members.sorted(TreeOrdering))

  object TreeOrdering extends Ordering[Tree] {
    override def compare(x: Tree, y: Tree): Int =
      (x, y) match {
        // sort ^ first
        case (one, _) if one.name === Name.namespaced => -1
        case (_, two) if two.name === Name.namespaced => 1
        // we sort by type, but methods and fields together
        case (m: MethodTree, f: FieldTree) =>
          m.name.unescaped.compareTo(f.name.unescaped)
        case (f: FieldTree, m: MethodTree) =>
          f.name.unescaped.compareTo(m.name.unescaped)
        /* and sort traits and objects together */
        case (c: ClassTree, m: ModuleTree) =>
          c.name.unescaped.compareTo(m.name.unescaped)
        case (m: ModuleTree, c: ClassTree) =>
          m.name.unescaped.compareTo(c.name.unescaped)

        case (m1: MethodTree, m2: MethodTree) =>
          (m1.name.unescaped.compareTo(m2.name.unescaped): @switch) match {
            case 0 =>
              (m1.tparams.length.compareTo(m2.tparams.length): @switch) match {
                case 0 =>
                  (m1.params.length.compareTo(m2.params.length): @switch) match {
                    case 0 =>
                      // well, the rest was fast enough, so... :)
                      val p1: String =
                        m1.params.flatten
                          .map(p => p.name.unescaped + Printer.formatQN(p.tpe.typeName))
                          .mkString
                      val p2: String =
                        m2.params.flatten
                          .map(p => p.name.unescaped + Printer.formatQN(p.tpe.typeName))
                          .mkString
                      p1.compareTo(p2)
                    case other => other
                  }
                case other => other
              }
            case other => other
          }

        case (c1: CtorTree, c2: CtorTree) =>
          (c1.params.length.compareTo(c2.params.length): @switch) match {
            case 0 =>
              val p1: String =
                c1.params.map(p => p.name.unescaped + Printer.formatQN(p.tpe.typeName)).mkString
              val p2: String =
                c2.params.map(p => p.name.unescaped + Printer.formatQN(p.tpe.typeName)).mkString

              p1.compareTo(p2)
            case other => other
          }

        case (s1, s2) =>
          (s1.getClass.getSimpleName.compareTo(s2.getClass.getSimpleName): @switch) match {
            case 0     => s1.name.unescaped.compareTo(s2.name.unescaped)
            case other => other
          }
      }
  }
}
