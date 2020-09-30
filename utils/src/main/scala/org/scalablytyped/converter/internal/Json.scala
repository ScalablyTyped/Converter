package org.scalablytyped.converter.internal

import java.io.File
import java.nio.file.{Files, Path}

import cats.data.ValidatedNel
import io.circe013._
import io.circe013.syntax._

import scala.io.Source
import scala.util.control.NonFatal

object Json {

  /** gah. I had to change to jackson parser to allow all idiotic things people do.
    *  I also had to inline most of the integration code to enable the features below
    */
  object CustomJacksonParser extends Parser {
    import com.fasterxml.jackson.core.{JsonFactory, JsonParser}
    import com.fasterxml.jackson.databind.ObjectMapper
    import io.circe013.jackson.CirceJsonModule

//    val Features = Set[JsonReadFeature](
//      JsonReadFeature.ALLOW_JAVA_COMMENTS,
//      JsonReadFeature.ALLOW_YAML_COMMENTS,
//      JsonReadFeature.ALLOW_SINGLE_QUOTES,
//      JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES,
//      JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS,
//      JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
//      JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS,
//      JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS,
//      JsonReadFeature.ALLOW_MISSING_VALUES,
//      JsonReadFeature.ALLOW_TRAILING_COMMA,
//    )

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

    private val mapper: ObjectMapper =
      Features.foldLeft((new ObjectMapper).registerModule(CirceJsonModule))(_.enable(_))
    private val jsonFactory: JsonFactory = new JsonFactory(mapper)

    def lenient(p: JsonParser) = Features.foldLeft(p)(_.enable(_))

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

  def force[T: Decoder](path: os.Path): T =
    force(path.toNIO)

  def force[T: Decoder](path: Path): T =
    apply(new String(Files.readAllBytes(path), constants.Utf8)) match {
      case Left(error) => sys.error(s"Error while parsing: $path: $error")
      case Right(t)    => t
    }

  def forceResource[T: Decoder](resource: String): T =
    Option(getClass.getResourceAsStream(resource)) match {
      case Some(is) =>
        val s = Source.fromInputStream(is, constants.Utf8.name)
        try force[T](s.mkString)
        finally s.close()
      case None => sys.error(s"Couldn't find resource $resource")
    }

  def force[T: Decoder](original: String): T =
    apply[T](original) match {
      case Left(error) => sys.error(s"Error while parsing: $error")
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
    if (files.exists(path)) Some(force[T](path)) else None

  def opt[T: Decoder](path: Path): Option[T] =
    if (Files.exists(path)) Some(force(path)) else None

  def persist[V: Encoder](file: os.Path)(value: V): Synced =
    persist(file.toNIO)(value)

  def persist[V: Encoder](file: Path)(value: V): Synced =
    files.softWrite(file)(_.append(value.asJson.noSpaces))
}
