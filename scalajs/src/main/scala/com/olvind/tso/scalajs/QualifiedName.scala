package com.olvind.tso
package scalajs

final case class QualifiedName(parts: List[Name]) {
  def +(name: Name) =
    QualifiedName(parts :+ name)

  def ++(other: QualifiedName): QualifiedName =
    QualifiedName(parts ++ other.parts)

  def startsWith(other: QualifiedName): Boolean =
    parts.startsWith(other.parts)
}

object QualifiedName {
  val java_lang:     QualifiedName = QualifiedName(Name.java :: Name.lang :: Nil)
  val scala:         QualifiedName = QualifiedName(Name.scala :: Nil)
  val scala_scalajs: QualifiedName = scala + Name.scalajs
  val scala_js:      QualifiedName = scala_scalajs + Name.js
  val scala_js_ann:  QualifiedName = scala_js + Name("annotation")
  val Runtime:       QualifiedName = QualifiedName(List(Name("org"), Name("scalablytyped"), Name("runtime")))

  val String:           QualifiedName = java_lang + Name.String
  val JObject:          QualifiedName = java_lang + Name.Object
  val JArray:           QualifiedName = java_lang + Name.Array
  val ScalaAny:         QualifiedName = scala + Name.Any
  val Double:           QualifiedName = scala + Name.Double
  val Int:              QualifiedName = scala + Name.Int
  val Long:             QualifiedName = scala + Name.Long
  val Boolean:          QualifiedName = scala + Name.Boolean
  val Unit:             QualifiedName = scala + Name.Unit
  val Null:             QualifiedName = scala + Name.Null
  val Nothing:          QualifiedName = scala + Name.Nothing
  val Any:              QualifiedName = scala_js + Name.Any
  val Object:           QualifiedName = scala_js + Name.Object
  val Array:            QualifiedName = scala_js + Name.Array
  val Thenable:         QualifiedName = scala_js + Name("Thenable")
  val Promise:          QualifiedName = scala_js + Name("Promise")
  val `|`             : QualifiedName = scala_js + Name("|")
  val Function:         QualifiedName = scala_js + Name.Function
  val Symbol:           QualifiedName = scala_js + Name.Symbol
  val UndefOr:          QualifiedName = scala_js + Name.UndefOr
  val Dynamic:          QualifiedName = scala_js + Name.Dynamic
  val NumberDictionary: QualifiedName = Runtime + Name("NumberDictionary")
  val StringDictionary: QualifiedName = Runtime + Name("StringDictionary")
  val TopLevel:         QualifiedName = Runtime + Name("TopLevel")
  val UNION:            QualifiedName = QualifiedName(Name.UNION :: Nil)
  val INTERSECTION:     QualifiedName = QualifiedName(Name.INTERSECTION :: Nil)
  val LITERAL:          QualifiedName = QualifiedName(Name.LITERAL :: Nil)
  val THIS_TYPE:        QualifiedName = QualifiedName(Name.THIS_TYPE :: Nil)
  val WILDCARD:         QualifiedName = QualifiedName(Name.WILDCARD :: Nil)
  val REPEATED:         QualifiedName = QualifiedName(Name.REPEATED :: Nil)
  val SINGLETON:        QualifiedName = QualifiedName(Name.SINGLETON :: Nil)

  object Std {
    private val std = QualifiedName(ScalaConfig.outputPkg :: ScalaConfig.std :: Nil)

    val Array:         QualifiedName = std + Name.Array
    val Boolean:       QualifiedName = std + Name.Boolean
    val BigInt:        QualifiedName = std + Name("BigInt")
    val ConcatArray:   QualifiedName = std + Name("ConcatArray")
    val Function:      QualifiedName = std + Name.Function
    val Number:        QualifiedName = std + Name("Number")
    val Object:        QualifiedName = std + Name.Object
    val Promise:       QualifiedName = std + Name("Promise")
    val PromiseLike:   QualifiedName = std + Name("PromiseLike")
    val ReadonlyArray: QualifiedName = std + Name("ReadonlyArray")
    val String:        QualifiedName = std + Name.String
    val Symbol:        QualifiedName = std + Name.Symbol
  }

  def Instantiable(arity:       Int): QualifiedName = Runtime + Name(s"Instantiable$arity")
  def FunctionArity(isThis:     Boolean, arity: Int): QualifiedName = scala_js + Name.FunctionArity(isThis, arity)
  def ScalaFunctionArity(arity: Int): QualifiedName = scala + Name.FunctionArity(isThis = false, arity)

  def Tuple(arity: Int): QualifiedName =
    arity match {
      case 0 | 1 => Array
      case n     => scala_js + Name("Tuple" + n.toString)
    }

  implicit val QualifiedNameSuffix: ToSuffix[QualifiedName] = t => ToSuffix(t.parts.last)
}
