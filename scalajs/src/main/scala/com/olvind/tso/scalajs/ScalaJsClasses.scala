package com.olvind.tso
package scalajs

import scala.collection.mutable

object ScalaJsClasses {
  // format: off
  val ScalaJsFunction =
    ClassSymbol(
      Seq(JsNative, JsGlobalScope),
      Name("Function"),
      Nil,
      Nil,
      Seq(
        CtorSymbol(Default, Seq(ParamSymbol(Name("args"), TypeRef.Repeated(TypeRef.String, NoComments), NoComments)), NoComments)
      ),
      Seq(
        FieldSymbol(Nil, Name("length"), TypeRef.Int, FieldTypeNative, isReadOnly = false, isOverride = false, NoComments),
        MethodSymbol(Nil, Default, Name("call"), Nil, Seq(Seq(ParamSymbol(Name("thisArg"), TypeRef.Any, NoComments), ParamSymbol(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), FieldTypeNative, TypeRef.Any, isOverride = false, NoComments),
        MethodSymbol(Nil, Default, Name("bind"), Nil, Seq(Seq(ParamSymbol(Name("thisArg"), TypeRef.Any, NoComments), ParamSymbol(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), FieldTypeNative, TypeRef.Any, isOverride = false, NoComments),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments
    )
  // format: on

  def ScalaJsF(arity: Int): ClassSymbol = {
    def T(n: Int) = Name(s"T" + n)

    val Apply: MethodSymbol =
      MethodSymbol(
        annotations = Nil,
        level       = Default,
        name        = Name("apply"),
        tparams     = Nil,
        params      = Seq(0 to arity map (n => ParamSymbol(T(n), TypeRef(T(n)), NoComments))),
        fieldType   = FieldTypeNotImplemented,
        resultType  = TypeRef(Name("R")),
        isOverride  = false,
        comments    = NoComments
      )

    ClassSymbol(
      annotations = Seq(JsNative),
      name        = QualifiedName.FunctionArity(arity).parts.last,
      tparams     = 0 to arity map (n => TypeParamSymbol(T(n), None, NoComments)),
      parents     = Seq(TypeRef(QualifiedName.Function)),
      ctors       = Nil,
      members     = Seq(Apply),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments
    )
  }
  private val Functions = mutable.Map.empty[Int, ClassSymbol]

  val MatchFunction = "Function(\\d*)".r
  object Lookup {
    def unapply(fragments: List[Name]): Option[ClassSymbol] =
      if ((fragments.length === QualifiedName.Function.parts.length)
          && fragments.startsWith(QualifiedName.scala_js.parts)) {

        fragments.last.unescaped match {
          case MatchFunction(numStr) =>
            if (numStr.isEmpty) Some(ScalaJsFunction)
            else {
              val num = numStr.toInt
              Some(Functions.getOrElseUpdate(num, ScalaJsF(num)))
            }
          case _ => None
        }
      } else None
  }
}
