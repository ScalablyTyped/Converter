package org.scalablytyped.converter.internal
package scalajs

import io.circe013.{Decoder, Encoder}
import io.circe013.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class QualifiedName(parts: IArray[Name]) {
  def +(name: Name) =
    QualifiedName(parts :+ name)

  def ++(other: QualifiedName): QualifiedName =
    QualifiedName(parts ++ other.parts)

  def startsWith(other: QualifiedName): Boolean =
    parts.startsWith(other.parts)

  override lazy val hashCode = parts.hashCode

  override def equals(obj: Any): Boolean =
    obj match {
      case other: QualifiedName if other.hashCode == hashCode =>
        parts === other.parts
      case _ => false
    }
}

object QualifiedName {
  def apply(str: String): QualifiedName = QualifiedName(IArray.fromArray(str.split("\\.")).map(Name(_)))

  val java_lang: QualifiedName = QualifiedName(IArray(Name.java, Name.lang))
  val String:    QualifiedName = java_lang + Name.String
  val Array:     QualifiedName = java_lang + Name.Array

  val scala:   QualifiedName = QualifiedName(IArray(Name.scala))
  val Any:     QualifiedName = scala + Name.Any
  val AnyRef:  QualifiedName = scala + Name.AnyRef
  val AnyVal:  QualifiedName = scala + Name.AnyVal
  val Byte:    QualifiedName = scala + Name.Byte
  val Short:   QualifiedName = scala + Name.Short
  val Float:   QualifiedName = scala + Name.Float
  val Double:  QualifiedName = scala + Name.Double
  val Int:     QualifiedName = scala + Name.Int
  val Long:    QualifiedName = scala + Name.Long
  val Boolean: QualifiedName = scala + Name.Boolean
  val Unit:    QualifiedName = scala + Name.Unit
  val Null:    QualifiedName = scala + Name.Null
  val Nothing: QualifiedName = scala + Name.Nothing

  val scala_scalajs: QualifiedName = scala + Name.scalajs
  val scala_js:      QualifiedName = scala_scalajs + Name.js
  val JsAny:         QualifiedName = scala_js + Name.Any
  val JsObject:      QualifiedName = scala_js + Name.Object
  val JsArray:       QualifiedName = scala_js + Name.Array
  val JsBigInt:      QualifiedName = scala_js + Name("BigInt")
  val JsThenable:    QualifiedName = scala_js + Name("Thenable")
  val JsPromise:     QualifiedName = scala_js + Name("Promise")
  val JsFunction:    QualifiedName = scala_js + Name.Function
  val JsSymbol:      QualifiedName = scala_js + Name.Symbol
  val JsUndefOr:     QualifiedName = scala_js + Name.UndefOr
  val `|`          : QualifiedName = scala_js + Name("|")
  val isUndefined:   QualifiedName = scala_js + Name("isUndefined")
  val JsDictionary:  QualifiedName = scala_js + Name("Dictionary")
  val JsDynamic:     QualifiedName = scala_js + Name.Dynamic

  val Runtime:          QualifiedName = QualifiedName(IArray(Name("org"), Name("scalablytyped"), Name("runtime")))
  val NumberDictionary: QualifiedName = Runtime + Name("NumberDictionary")
  val StringDictionary: QualifiedName = Runtime + Name("StringDictionary")
  val TopLevel:         QualifiedName = Runtime + Name("TopLevel")
  val Shortcut:         QualifiedName = Runtime + Name("Shortcut")
  // Note: this is special. we use `jsObject` throughout, and only talk about this very late, in the `Printer`.
  val StObject: QualifiedName = Runtime + Name("StObject")

  val UNION:           QualifiedName = QualifiedName(IArray(Name.UNION))
  val INTERSECTION:    QualifiedName = QualifiedName(IArray(Name.INTERSECTION))
  val STRING_LITERAL:  QualifiedName = QualifiedName(IArray(Name.STRING_LITERAL))
  val DOUBLE_LITERAL:  QualifiedName = QualifiedName(IArray(Name.DOUBLE_LITERAL))
  val INT_LITERAL:     QualifiedName = QualifiedName(IArray(Name.INT_LITERAL))
  val BOOLEAN_LITERAL: QualifiedName = QualifiedName(IArray(Name.BOOLEAN_LITERAL))
  val THIS:            QualifiedName = QualifiedName(IArray(Name.THIS))
  val WILDCARD:        QualifiedName = QualifiedName(IArray(Name.WILDCARD))
  val REPEATED:        QualifiedName = QualifiedName(IArray(Name.REPEATED))
  val SINGLETON:       QualifiedName = QualifiedName(IArray(Name.SINGLETON))
  val UNDEFINED:       QualifiedName = QualifiedName(IArray(Name.UNDEFINED))

  def AnyFromFunction(n: Int): QualifiedName = JsAny + Name(s"fromFunction$n")

  class StdNames(outputPkg: Name) {
    val lib:                   QualifiedName = QualifiedName(IArray(outputPkg, Name.std))
    val Array:                 QualifiedName = lib + Name.Array
    val Boolean:               QualifiedName = lib + Name.Boolean
    val BigInt:                QualifiedName = lib + Name("BigInt")
    val ConcatArray:           QualifiedName = lib + Name("ConcatArray")
    val Element:               QualifiedName = lib + Name("Element")
    val Function:              QualifiedName = lib + Name.Function
    val HTMLElementTagNameMap: QualifiedName = lib + Name("HTMLElementTagNameMap")
    val Number:                QualifiedName = lib + Name("Number")
    val Object:                QualifiedName = lib + Name.Object
    val Promise:               QualifiedName = lib + Name("Promise")
    val PromiseLike:           QualifiedName = lib + Name("PromiseLike")
    val ReadonlyArray:         QualifiedName = lib + Name("ReadonlyArray")
    val SVGElementTagNameMap:  QualifiedName = lib + Name("SVGElementTagNameMap")
    val String:                QualifiedName = lib + Name.String
    val Symbol:                QualifiedName = lib + Name.Symbol
  }

  def Instantiable(arity:       Int): QualifiedName = Runtime + Name(s"Instantiable$arity")
  def FunctionArity(isThis:     Boolean, arity: Int): QualifiedName = scala_js + Name.FunctionArity(isThis, arity)
  def ScalaFunctionArity(arity: Int): QualifiedName = scala + Name.FunctionArity(isThis = false, arity)

  def Tuple(arity: Int): QualifiedName =
    arity match {
      case 0 | 1 => JsArray
      case n     => scala_js + Name("Tuple" + n.toString)
    }

  implicit val suffix:  ToSuffix[QualifiedName] = t => ToSuffix(t.parts.last)
  implicit val encodes: Encoder[QualifiedName]  = deriveEncoder
  implicit val decodes: Decoder[QualifiedName]  = deriveDecoder
}
