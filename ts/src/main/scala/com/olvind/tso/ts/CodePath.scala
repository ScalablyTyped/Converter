package com.olvind.tso
package ts

trait HasCodePath {
  def codePath: CodePath
  def withCodePath(newCodePath: CodePath): HasCodePath
}

sealed trait CodePath {
  def forceHasPath: CodePath.HasPath =
    get getOrElse sys.error("Expected code path")

  def get: Option[CodePath.HasPath] =
    this match {
      case hp: CodePath.HasPath => Some(hp)
      case CodePath.NoPath => None
    }

  def replaceLast(newLast: TsIdent): CodePath =
    this match {
      case CodePath.HasPath(inLib, parts) =>
        CodePath.HasPath(inLib, parts.dropRight(1) :+ newLast)
      case CodePath.NoPath => CodePath.NoPath
    }

  def +(ident: TsIdent): CodePath
}

object CodePath {
  case object NoPath extends CodePath {
    def +(ident: TsIdent): NoPath.type = NoPath
  }

  case class HasPath private (inLibrary: TsIdent, codePathPart: List[TsIdent]) extends CodePath {
    lazy val codePath: TsQIdent =
      TsQIdent(inLibrary +: codePathPart)

    def /(tree: TsTree): CodePath.HasPath =
      tree match {
        case named: TsNamedDecl =>
          this + named.name
        case TsGlobal(_, _, _, _) =>
          this + TsIdent.Global
        case _ => this
      }

    def +(tsIdent: TsIdent): CodePath.HasPath =
      HasPath(inLibrary, codePathPart :+ tsIdent)
  }
}
