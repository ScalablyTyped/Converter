package com.olvind.tso
package importer

import com.olvind.tso.scalajs.{Annotation, Name, QualifiedName}
import com.olvind.tso.ts._

/**
  * @param knownLibraries A known library in this context is the one we
  *                       are converting, or any of it's dependencies
  */
class ImportName(val outputPkg: Name, knownLibraries: Set[TsIdentLibrary], prettyString: PrettyString) {
  def unapply(qident: TsQIdent): Some[QualifiedName] =
    Some(apply(qident))

  def unapply(x: TsIdent): Some[Name] =
    Some(apply(x))

  def apply(ident: TsQIdent): QualifiedName =
    ident match {
      /* hack/shortcut: all qualified idents are fully qualified, which means only abstract things should have length one */
      case TsQIdent(one :: Nil) => QualifiedName(List(apply(one)))
      case TsQIdent(parts)      => QualifiedName(outputPkg +: (parts map apply))
    }

  def apply(cp: CodePath): QualifiedName =
    QualifiedName(outputPkg +: (cp.forceHasPath.codePath.parts map apply))

  def apply(i: TsIdent): Name =
    if (i == TsIdent.Apply) Name.APPLY
    else {
      val base = i match {
        case TsIdentSimple(value) => value
        case x: TsIdentLibrary => prettyString(x.value, "", forceCamelCase = true)
        case x: TsIdentModule =>
          val shortenedOpt: Option[String] =
            x match {
              case TsIdentModule(Some(scope), head :: tail) if !(tail.size === 1 && tail.head === head) =>
                knownLibraries.collectFirst {
                  case TsIdentLibraryScoped(`scope`, `head`) => tail.mkString("/")
                }
              case TsIdentModule(None, head :: tail) if !(tail.size === 1 && tail.head === head) =>
                knownLibraries.collectFirst {
                  case TsIdentLibrarySimple(`head`) => tail.mkString("/")
                }
              case _ => None
            }

          prettyString(shortenedOpt.filter(_.nonEmpty).getOrElse(x.value), "Mod", forceCamelCase = true)

        case x: TsIdentImport =>
          sys.error(s"Unexpected: $x")
      }

      Name.necessaryRewrite(Name(base))
    }
}

object ImportName {
  def skipConversion(i:     TsIdent):  Name          = Name(i.value)
  def skipConversion(ident: TsQIdent): QualifiedName = QualifiedName(ident.parts map skipConversion)

  object valueDefinition {
    def apply(original: TsIdentSimple): (Name, Option[Annotation.JsName]) =
      Name.clean(original.value)

    def unapply(original: TsIdentSimple): Some[(Name, Option[Annotation.JsName])] =
      Some(apply(original))
  }
}
