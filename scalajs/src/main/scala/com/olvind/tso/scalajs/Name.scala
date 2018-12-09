package com.olvind.tso
package scalajs

final case class Name(unescaped: String) extends AnyVal {

  def withSuffix[T: ToSuffix](t: T): Name =
    new Name(unescaped + ToSuffix(t).unescaped)

  def value: String =
    ScalaNameEscape(unescaped)
}

object Name {
  val dummy:      Name = Name("dummy")
  val Any:        Name = Name("Any")
  val Double:     Name = Name("Double")
  val Int:        Name = Name("Int")
  val Long:       Name = Name("Long")
  val Boolean:    Name = Name("Boolean")
  val Unit:       Name = Name("Unit")
  val Null:       Name = Name("Null")
  val Nothing:    Name = Name("Nothing")
  val String:     Name = Name("String")
  val Array:      Name = Name("Array")
  val update:     Name = Name("update")
  val value:      Name = Name("value")
  val scala:      Name = Name("scala")
  val scalajs:    Name = Name("scalajs")
  val js:         Name = Name("js")
  val java:       Name = Name("java")
  val lang:       Name = Name("lang")
  val Statics:    Name = Name("Statics")
  val `package`:  Name = Name("package")
  val Object:     Name = Name("Object")
  val Function:   Name = Name("Function")
  val Default:    Name = Name("default")
  val StdLib:     Name = Name("StdLib")
  val Symbol:     Name = Name("Symbol")
  val This:       Name = Name("This")
  val UndefOr:    Name = Name("UndefOr")
  val Dynamic:    Name = Name("Dynamic")
  val namespaced: Name = Name("namespaced")
  val underscore: Name = Name("_")

  val APPLY:        Name = Name("<apply>")
  val CONSTRUCTOR:  Name = Name("<init>")
  val UNION:        Name = Name("<union>")
  val INTERSECTION: Name = Name("<intersection>")
  val SINGLETON:    Name = Name("<typeof>")
  val LITERAL:      Name = Name("<literal>")
  val THIS_TYPE:    Name = Name("<this>")
  val WILDCARD:     Name = Name("<wildcard>")
  val REPEATED:     Name = Name("*")

  def FunctionArity(isThis: Boolean, arity: Int): Name =
    Name((if (isThis) This.unescaped else "") + "Function" + arity.toString)

  val Internal = Set(UNION, INTERSECTION, SINGLETON, LITERAL, THIS_TYPE, WILDCARD, REPEATED, APPLY)

  val Primitive = Set(Any, Double, Int, Long, Boolean, Unit, Null, Nothing, String, Array)

  implicit object NameSuffix extends ToSuffix[Name] {
    override def to(t: Name): Suffix = Suffix(t.unescaped)
  }
  implicit object NameKey extends IsKey[Name]
}
