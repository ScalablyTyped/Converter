package org.scalablytyped.converter.internal
package ts

sealed trait CodePath {
  def forceHasPath: CodePath.HasPath =
    get.getOrElse(sys.error("Expected code path"))

  def get: Option[CodePath.HasPath] =
    this match {
      case hp: CodePath.HasPath => Some(hp)
      case CodePath.NoPath => None
    }

  def replaceLast(newLast: TsIdent): CodePath =
    this match {
      case CodePath.HasPath(inLib, TsQIdent(parts)) =>
        CodePath.HasPath(inLib, TsQIdent(parts.dropRight(1) :+ newLast))
      case CodePath.NoPath => CodePath.NoPath
    }

  def +(ident: TsIdent): CodePath
}

object CodePath {
  trait Has {
    def codePath: CodePath
    def withCodePath(newCodePath: CodePath): CodePath.Has
  }

  case object NoPath extends CodePath {
    def +(ident: TsIdent): NoPath.type = NoPath
  }

  case class HasPath(inLibrary: TsIdent, codePathPart: TsQIdent) extends CodePath {
    lazy val codePath: TsQIdent =
      TsQIdent(inLibrary +: codePathPart.parts)

    def /(tree: TsTree): CodePath.HasPath =
      tree match {
        case named: TsNamedDecl =>
          this + named.name
        case TsGlobal(_, _, _, _) =>
          this + TsIdent.Global
        case _ => this
      }

    def +(tsIdent: TsIdent): CodePath.HasPath =
      HasPath(inLibrary, codePathPart + tsIdent)
  }
}
