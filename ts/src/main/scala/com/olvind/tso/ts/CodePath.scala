package com.olvind.tso
package ts

trait HasCodePath {
  def codePath: CodePath
  def withCodePath(newCodePath: CodePath): HasCodePath
}

sealed trait CodePath {
  def forceHasPath: CodePath.HasPath =
    this match {
      case hp: CodePath.HasPath => hp
      case CodePath.NoPath => sys.error("Expected code path")
    }
}

object CodePath {
  case object NoPath extends CodePath

  case class HasPath private (inLibrary: TsIdent, codePathPart: TsQIdent) extends CodePath {
    lazy val codePath: TsQIdent =
      TsQIdent(inLibrary +: codePathPart.parts)

    def /(tree: TsTree): CodePath.HasPath =
      tree match {
        case TsDeclModule(_, _, name, _, _, _) =>
          HasPath(inLibrary, codePathPart + name)
        case named: TsNamedDecl =>
          HasPath(inLibrary, codePathPart + named.name)
        case TsGlobal(_, _, _, _) =>
          HasPath(inLibrary, codePathPart + TsIdent.Global)
        case _ => this
      }

    def +(tsIdent: TsIdent): CodePath.HasPath =
      HasPath(inLibrary, codePathPart + tsIdent)
  }
}
