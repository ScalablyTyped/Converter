package com.olvind.tso.importer.build
import java.io.File
import java.util.Optional

import bloop.Compiler.Result
import io.circe.Decoder.withReattempt
import io.circe._
import io.circe.generic.semiauto
import xsbti.{Position, Problem, Severity}

/**
  * The future, they said. It'll be fun, they said.
  * Note: we drop `Throwable`s
  * Note: I'm pretty sure there is a protobuf schema or something we could have used, but meh
  */
object ResultFailedJsonCodec {
  implicit def decodeOptional[A](implicit d: Decoder[A]): Decoder[Optional[A]] = withReattempt[Optional[A]] {
    case c: HCursor =>
      if (c.value.isNull) Right(Optional.empty())
      else
        d(c) match {
          case Right(a) => Right(Optional.of(a))
          case Left(df) => Left(df)
        }
    case c: FailedCursor =>
      if (!c.incorrectFocus) Right(Optional.empty()) else Left(DecodingFailure("[A]Optional[A]", c.history))
  }

  implicit def encodeOptional[A](implicit e: Encoder[A]): Encoder[Optional[A]] =
    (a: Optional[A]) => if (a.isPresent) e(a.get) else Json.Null

  implicit val FileDecoder: Decoder[File] =
    Decoder.decodeString.map(new File(_))

  implicit val FileEncoder: Encoder[File] =
    Encoder.encodeString.contramap(_.getAbsolutePath)

  implicit val SeverityEncoder: Decoder[Severity] =
    Decoder.decodeInt.map(x => Severity.values()(x))

  implicit val SeverityDecoder: Encoder[Severity] =
    Encoder.encodeInt.contramap(_.ordinal())

  implicit val PositionDecoder: Decoder[Position] =
    Decoder
      .forProduct13[Position, Optional[Integer], String, Optional[Integer], Optional[Integer], Optional[String], Optional[
        String
      ], Optional[File], Optional[Integer], Optional[Integer], Optional[Integer], Optional[Integer], Optional[Integer], Optional[
        Integer
      ]](
        "line",
        "lineContent",
        "offset",
        "pointer",
        "pointerSpace",
        "sourcePath",
        "sourceFile",
        "startOffset",
        "endOffset",
        "startLine",
        "startColumn",
        "endLine",
        "endColumn"
      )(
        (_line,
         _lineContent,
         _offset,
         _pointer,
         _pointerSpace,
         _sourcePath,
         _sourceFile,
         _startOffset,
         _endOffset,
         _startLine,
         _startColumn,
         _endLine,
         _endColumn) =>
          new Position {
            override def line():         Optional[Integer] = _line
            override def lineContent():  String            = _lineContent
            override def offset():       Optional[Integer] = _offset
            override def pointer():      Optional[Integer] = _pointer
            override def pointerSpace(): Optional[String]  = _pointerSpace
            override def sourcePath():   Optional[String]  = _sourcePath
            override def sourceFile():   Optional[File]    = _sourceFile
            override def startOffset():  Optional[Integer] = _startOffset
            override def endOffset():    Optional[Integer] = _endOffset
            override def startLine():    Optional[Integer] = _startLine
            override def startColumn():  Optional[Integer] = _startColumn
            override def endLine():      Optional[Integer] = _endLine
            override def endColumn():    Optional[Integer] = _endColumn
        }
      )

  implicit val PositionEncoder: Encoder[Position] =
    Encoder.forProduct13(
      "line",
      "lineContent",
      "offset",
      "pointer",
      "pointerSpace",
      "sourcePath",
      "sourceFile",
      "startOffset",
      "endOffset",
      "startLine",
      "startColumn",
      "endLine",
      "endColumn"
    )(
      (p: Position) =>
        (p.line,
         p.lineContent,
         p.offset,
         p.pointer,
         p.pointerSpace,
         p.sourcePath,
         p.sourceFile,
         p.startOffset,
         p.endOffset,
         p.startLine,
         p.startColumn,
         p.endLine,
         p.endColumn)
    )

  implicit val ProblemDecoder: Decoder[Problem] =
    Decoder.forProduct4[Problem, String, Severity, String, Position]("category", "severity", "message", "position")(
      (_category, _severity, _message, _position) =>
        new Problem {
          override def category(): String   = _category
          override def severity(): Severity = _severity
          override def message():  String   = _message
          override def position(): Position = _position
      }
    )

  implicit val ProblemEncoder: Encoder[Problem] =
    Encoder.forProduct4("category", "severity", "message", "position")(
      (p: Problem) => (p.category(), p.severity(), p.message(), p.position())
    )

  implicit val OptionThrowableDecoder: Decoder[Option[Throwable]] = _ => Right(None)
  implicit val OptionThrowableEncoder: Encoder[Option[Throwable]] = _ => Json.Null

  implicit val FailedDecoder: Decoder[Result.Failed] =
    semiauto.deriveDecoder[Result.Failed]

  implicit val FailedEncoder: Encoder[Result.Failed] =
    semiauto.deriveEncoder[Result.Failed]
}
