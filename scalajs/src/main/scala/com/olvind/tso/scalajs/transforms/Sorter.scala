package com.olvind.tso
package scalajs
package transforms

import scala.annotation.switch

object Sorter extends SymbolVisitor {
  private object SymbolOrdering extends Ordering[Symbol] {
    override def compare(x: Symbol, y: Symbol): Int =
      (x, y) match {
        case (m1: MethodSymbol, m2: MethodSymbol) =>
          (m1.name.unescaped.compareTo(m2.name.unescaped): @switch) match {
            case 0 =>
              (m1.tparams.size.compareTo(m2.tparams.size): @switch) match {
                case 0 =>
                  (m1.params.size.compareTo(m2.params.size): @switch) match {
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

        case (c1: CtorSymbol, c2: CtorSymbol) =>
          (c1.params.size.compareTo(c2.params.size): @switch) match {
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

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    s.copy(members = s.members.sorted(SymbolOrdering), ctors = s.ctors.sorted(SymbolOrdering))

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    s.copy(members = s.members.sorted(SymbolOrdering))

  override def enterPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
    s.copy(members = s.members.sorted(SymbolOrdering))
}
