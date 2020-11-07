package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.annotation.switch

object Sorter extends TreeTransformation {

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(members = sorted(s.members), ctors = sorted(s.ctors).asInstanceOf[IArray[CtorTree]])

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = sorted(s.members))

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = sorted(s.members))

  def sorted(members: IArray[Tree]): IArray[Tree] = {
    val (_1, _2, _3, _4) = members.partitionCollect3(
      // sort ^ first
      { case x if x.name === Name.namespaced => x },
      // sort methods and fields together
      { case x: MemberTree => x },
      // and sort traits and objects together
      { case x: InheritanceTree => x },
    )

    IArray(_1, _2, _3, _4).map(_.sorted(TreeOrdering)).flatten
  }
  object TreeOrdering extends Ordering[Tree] {
    override def compare(x: Tree, y: Tree): Int =
      (x, y) match {
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
          (s1.name.unescaped.compareTo(s2.name.unescaped): @switch) match {
            case 0     => s1.getClass.getSimpleName.compareTo(s2.getClass.getSimpleName)
            case other => other
          }
      }
  }
}
