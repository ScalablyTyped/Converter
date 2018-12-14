package com.olvind.tso
package scalajs

import scala.collection.mutable

object ScalaJsClasses {
  // format: off
  val ScalaJsArray =
    ClassTree(
      Seq(JsNative, JsGlobalScope),
      Name("Array"),
      Seq(TypeParamTree(Name("T"), None, NoComments)),
      // todo: fill in
      Nil,
      Nil,
      Nil,
      ClassType.Class,
      isSealed = false,
      NoComments
    )
  // format: on

  // format: off
  val ScalaJsFunction =
    ClassTree(
      Seq(JsNative, JsGlobalScope),
      Name("Function"),
      Nil,
      Nil,
      Seq(
        CtorTree(Default, Seq(ParamTree(Name("args"), TypeRef.Repeated(TypeRef.String, NoComments), NoComments)), NoComments)
      ),
      Seq(
        FieldTree(Nil, Name("length"), TypeRef.Int, MemberImplNative, isReadOnly = false, isOverride = false, NoComments),
        MethodTree(Nil, Default, Name("call"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
        MethodTree(Nil, Default, Name("bind"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassTree = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: Seq[ParamTree] =
      if (isThis) Seq(ParamTree(Name.This, TypeRef.ThisType(NoComments), NoComments)) else Nil

    val inputParams = 0 until arity map (n => ParamTree(T(n), TypeRef(T(n)), NoComments))
    val R           = TypeRef(Name("R"))
    val Apply: MethodTree =
      MethodTree(
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

    val ThisTParam: Seq[TypeParamTree] =
      if (isThis) Seq(TypeParamTree(Name.This, None, NoComments)) else Nil

    val inputTParams: Seq[TypeParamTree] =
      0 until arity map (n => TypeParamTree(T(n), None, NoComments))

    val outputTParams: Seq[TypeParamTree] =
      Seq(TypeParamTree(R.name, None, NoComments))

    ClassTree(
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
  private val Functions = mutable.Map.empty[(Boolean, Int), ClassTree]

  val MatchFunction = "(This|)Function(\\d*)".r

  object isFunction {
    def unapply(fragments: List[Name]): Option[ClassTree] =
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
