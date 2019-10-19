package com.olvind.tso
package importer

import com.olvind.tso.scalajs.{Name, QualifiedName}
import com.olvind.tso.ts._

/**
  * @param knownLibraries A known library in this context is the one we
  *                       are converting, or any of it's dependencies
  */
class ImportName(val outputPkg: Name, knownLibraries: Set[TsIdentLibrary], conflicts: Set[TsQIdent]) { self =>
  val moduleConflicts = conflicts.flatMap(_.parts.collectFirst { case x: TsIdentModule => x })

  def unapply(qident: TsQIdent): Some[QualifiedName] =
    Some(apply(qident))

  def unapply(x: TsIdent): Some[::[Name]] =
    Some(apply(x))

  object assertOne {
    def apply(i: TsIdent): Name =
      self.apply(i) match {
        case value :: Nil => value
        case other        => sys.error(s"Expected one name, got $other")
      }

    def unapply(x: TsIdent): Option[Name] =
      self.unapply(x) map {
        case one :: Nil => one
        case other      => sys.error(s"Expected on, got $other")
      }
  }

  def apply(ident: TsQIdent): QualifiedName =
    ident match {
      /* hack/shortcut: all qualified idents are fully qualified, which means only abstract things should have length one */
      case TsQIdent(one :: Nil) => QualifiedName(apply(one).to[List])
      case TsQIdent(parts)      => QualifiedName(`outputPkg` +: (parts flatMap apply))
    }

  def apply(cp: CodePath): QualifiedName =
    QualifiedName(outputPkg +: (cp.forceHasPath.codePath.parts flatMap apply))

  def apply(i: TsIdent): ::[Name] =
    i match {
      case TsIdent.Apply => ::(Name.APPLY, Nil)
//      case TsIdentSimple("js") => ::(Name("js_"), Nil)
//      case TsIdentSimple("scala") => ::(Name("scala_"), Nil)
//      case TsIdentSimple("com") => ::(Name("com_"), Nil)
//      case TsIdentSimple("org") => ::(Name("org_"), Nil)
      case TsIdentSimple(value) => ::(Name(value), Nil)
      case x: TsIdentLibrary => ::(tsIdentLibrary(x), Nil)
      case x: TsIdentModule  => tsIdentModule(x)
      case x: TsIdentImport  => sys.error(s"Unexpected: $x")
    }

  def tsIdentLibrary(i: TsIdentLibrary): Name =
    i match {
      case TsIdentLibraryScoped(scope, name) =>
        Name(prettyString(scope ++ name.capitalize, forceCamelCase = true))
      case TsIdentLibrarySimple(value) =>
        Name(prettyString(value, forceCamelCase = true))
    }

  /**
    * We shorten a module name if it starts with the name of a known library.
    */
  private def tsIdentModule(x: TsIdentModule): ::[Name] = {
    val shortenedOpt: Option[List[String]] =
      x match {
        case TsIdentModule(Some(scope), head :: tail) if !(tail.size === 1 && tail.head === head) =>
          knownLibraries.collectFirst {
            case TsIdentLibraryScoped(`scope`, `head`) => tail
          }
        case TsIdentModule(None, head :: tail) if !(tail.size === 1 && tail.head === head) =>
          knownLibraries.collectFirst {
            case TsIdentLibrarySimple(`head`) => tail
          }
        case _ => None
      }

    ::(
      Name("mod"),
      shortenedOpt getOrElse x.parts map { part =>
        val prettyPart = prettyString(part, forceCamelCase = false)
        Name(prettyPart + (if (moduleConflicts(x)) "Mod" else ""))
      },
    )
  }
}

object ImportName {
  def skipConversion(i:     TsIdent):  Name          = Name(i.value)
  def skipConversion(ident: TsQIdent): QualifiedName = QualifiedName(ident.parts map skipConversion)
}
