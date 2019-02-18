package com.olvind.tso
package scalajs

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
      NoComments,
      QualifiedName.Array
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
        CtorTree(Default, Seq(ParamTree(Name("args"), TypeRef.Repeated(TypeRef.String, NoComments), None, NoComments)), NoComments)
      ),
      Seq(
        FieldTree(Nil, Name("length"), TypeRef.Int, MemberImplNative, isReadOnly = false, isOverride = false, NoComments),
        MethodTree(Nil, Default, Name("call"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
        MethodTree(Nil, Default, Name("bind"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImplNative, TypeRef.Any, isOverride = false, NoComments),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Function
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassTree = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: Seq[ParamTree] =
      if (isThis) Seq(ParamTree(Name.This, TypeRef.ThisType(NoComments), None, NoComments)) else Nil

    val inputParams = 0 until arity map (n => ParamTree(T(n), TypeRef(T(n)), None, NoComments))
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

    val qname = QualifiedName.FunctionArity(isThis, arity)

    ClassTree(
      annotations = Seq(JsNative),
      name        = qname.parts.last,
      tparams     = ThisTParam ++ inputTParams ++ outputTParams,
      parents     = Seq(TypeRef(QualifiedName.Function)),
      ctors       = Nil,
      members     = Seq(Apply),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      qname
    )
  }

  val Functions: Seq[ClassTree] =
    0 to 22 flatMap (n => List(ScalaJsF(isThis = false, n), ScalaJsF(isThis = true, n)))

  val ScalaJsTypes: Map[List[Name], ClassTree] =
    (Functions :+ ScalaJsFunction :+ ScalaJsArray :+ ObjectMembers.ScalaJsObject :+ ObjectMembers.ScalaObject)
      .map(x => x.codePath.parts -> x)
      .toMap
}
