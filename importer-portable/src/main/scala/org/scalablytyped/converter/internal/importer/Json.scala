package org.scalablytyped.converter.internal
package importer

import java.io.File
import java.nio.file.{Files, Path}

import cats.data.ValidatedNel
import io.circe._
import io.circe.syntax._

import scala.util.control.NonFatal

object Json {

  /** gah. I had to change to jackson parser to allow all idiotic things people do.
    *  I also had to inline most of the integration code to enable the features below
    */
  object CustomJacksonParser extends Parser {
    import com.fasterxml.jackson.core.{JsonFactory, JsonParser}
    import com.fasterxml.jackson.databind.ObjectMapper
    import io.circe.jackson.CirceJsonModule

    val Features = Set(
      JsonParser.Feature.ALLOW_COMMENTS,
      JsonParser.Feature.ALLOW_YAML_COMMENTS,
      JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
      JsonParser.Feature.ALLOW_SINGLE_QUOTES,
      JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
      JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
      JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,
      JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS,
      JsonParser.Feature.ALLOW_MISSING_VALUES,
      JsonParser.Feature.ALLOW_TRAILING_COMMA,
    )

    private val mapper:      ObjectMapper = Features.foldLeft((new ObjectMapper).registerModule(CirceJsonModule))(_ enable _)
    private val jsonFactory: JsonFactory  = new JsonFactory(mapper)

    def lenient(p: JsonParser) = Features.foldLeft(p)(_ enable _)

    def jsonStringParser(input: String): JsonParser =
      lenient(jsonFactory.createParser(input))
    def jsonFileParser(file: File): JsonParser =
      lenient(jsonFactory.createParser(file))
    def jsonBytesParser(bytes: Array[Byte]): JsonParser =
      lenient(jsonFactory.createParser(bytes))

    final def parse(input: String): Either[ParsingFailure, Json] =
      try {
        Right(mapper.readValue(jsonStringParser(input), classOf[Json]))
      } catch {
        case NonFatal(error) => Left(ParsingFailure(error.getMessage, error))
      }

    final def parseFile(file: File): Either[ParsingFailure, Json] =
      try {
        Right(mapper.readValue(jsonFileParser(file), classOf[Json]))
      } catch {
        case NonFatal(error) => Left(ParsingFailure(error.getMessage, error))
      }

    final def parseByteArray(bytes: Array[Byte]): Either[ParsingFailure, Json] =
      try {
        Right(mapper.readValue(jsonBytesParser(bytes), classOf[Json]))
      } catch {
        case NonFatal(error) => Left(ParsingFailure(error.getMessage, error))
      }

    final def decodeByteArray[A: Decoder](bytes: Array[Byte]): Either[Error, A] =
      finishDecode[A](parseByteArray(bytes))

    final def decodeByteArrayAccumulating[A: Decoder](bytes: Array[Byte]): ValidatedNel[Error, A] =
      finishDecodeAccumulating[A](parseByteArray(bytes))

    final def decodeFile[A: Decoder](file: File): Either[Error, A] =
      finishDecode[A](parseFile(file))

    final def decodeFileAccumulating[A: Decoder](file: File): ValidatedNel[Error, A] =
      finishDecodeAccumulating[A](parseFile(file))
  }

  private val BOM = "\uFEFF"

  def apply[T: Decoder](path: os.Path): T =
    apply(files content InFile(path)) match {
      case Left(error) => sys.error(s"Error while parsing: $path: $error")
      case Right(t)    => t
    }

  def apply[T: Decoder](path: Path): T =
    apply(new String(Files.readAllBytes(path), constants.Utf8)) match {
      case Left(error) => sys.error(s"Error while parsing: $path: $error")
      case Right(t)    => t
    }

  def apply[T: Decoder](original: String): Either[Error, T] = {
    val str = original match {
      case withBom if withBom.startsWith(BOM) => withBom.replace(BOM, "")
      case ok                                 => ok
    }

    CustomJacksonParser.decode[T](str)
  }

  def opt[T: Decoder](path: os.Path): Option[T] =
    if (os.exists(path)) Some(apply[T](path)) else None

  def opt[T: Decoder](path: Path): Option[T] =
    if (Files.exists(path)) Some(apply(path)) else None

  def persist[V: Encoder](file: os.Path)(value: V): Synced =
    persist(file.toNIO)(value)

  def persist[V: Encoder](file: Path)(value: V): Synced =
    files.softWrite(file)(_.append(value.asJson.noSpaces))
}
