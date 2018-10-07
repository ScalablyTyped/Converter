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
        FieldSymbol(Nil, Name("length"), TypeRef.Int, MemberImplNative, isReadOnly = false, isOverride = false, NoComments),
        MethodSymbol(Nil, Default, Name("call"), Nil, Seq(Seq(ParamSymbol(Name("thisArg"), TypeRef.Any, NoComments), ParamSymbol(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
        MethodSymbol(Nil, Default, Name("bind"), Nil, Seq(Seq(ParamSymbol(Name("thisArg"), TypeRef.Any, NoComments), ParamSymbol(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassSymbol = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: Seq[ParamSymbol] =
      if (isThis) Seq(ParamSymbol(Name.This, TypeRef.ThisType(NoComments), NoComments)) else Nil

    val inputParams = 0 until arity map (n => ParamSymbol(T(n), TypeRef(T(n)), NoComments))
    val R           = TypeRef(Name("R"))
    val Apply: MethodSymbol =
      MethodSymbol(
        annotations = Nil,
        level       = Default,
        name        = Name.APPLY,
        tparams     = Nil,
        params      = Seq(ThisParam ++ inputParams),
        impl        = MemberImplNotImplemented,
        resultType  = R,
        isOverride  = false,
        comments    = NoComments
      )

    val ThisTParam: Seq[TypeParamSymbol] =
      if (isThis) Seq(TypeParamSymbol(Name.This, None, NoComments)) else Nil

    val inputTParams: Seq[TypeParamSymbol] =
      0 until arity map (n => TypeParamSymbol(T(n), None, NoComments))

    val outputTParams: Seq[TypeParamSymbol] =
      Seq(TypeParamSymbol(R.name, None, NoComments))

    ClassSymbol(
      annotations = Seq(JsNative),
      name        = QualifiedName.FunctionArity(isThis, arity).parts.last,
      tparams     = ThisTParam ++ inputTParams ++ outputTParams,
      parents     = Seq(TypeRef(QualifiedName.Function)),
      ctors       = Nil,
      members     = Seq(Apply),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments
    )
  }
  private val Functions = mutable.Map.empty[(Boolean, Int), ClassSymbol]

  val MatchFunction = "(This|)Function(\\d*)".r

  object Lookup {
    def unapply(fragments: List[Name]): Option[ClassSymbol] =
      if ((fragments.length === QualifiedName.Function.parts.length)
          && fragments.startsWith(QualifiedName.scala_js.parts)) {

        fragments.last.unescaped match {
          case MatchFunction(thisStr, numStr) =>
            if (thisStr.isEmpty && numStr.isEmpty) Some(ScalaJsFunction)
            else {
              val isThis = thisStr === Name.This.unescaped
              val num    = numStr.toInt
              Some(Functions.getOrElseUpdate((isThis, num), ScalaJsF(isThis, num)))
            }
          case _ => None
        }
      } else None
  }
}
