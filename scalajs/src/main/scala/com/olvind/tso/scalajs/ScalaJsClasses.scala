package com.olvind.tso
package scalajs

object ScalaJsClasses {
  // format: off
  val ScalaJsArray =
    ClassTree(
      Seq(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Array"),
      Seq(TypeParamTree(Name("T"), None, NoComments)),
      // todo: fill in
      Nil,
      Nil,
      Nil,
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Array,
    )
  // format: on

  // format: off
  val ScalaJsFunction =
    ClassTree(
      Seq(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Function"),
      Nil,
      Nil,
      Seq(
        CtorTree(ProtectionLevel.Default, Seq(ParamTree(Name("args"), TypeRef.Repeated(TypeRef.String, NoComments), None, NoComments)), NoComments),
      ),
      Seq(
        FieldTree(Nil, Name("length"), TypeRef.Int, MemberImpl.Native, isReadOnly = false, isOverride = false, NoComments, QualifiedName.Function + Name("length")),
        MethodTree(Nil, ProtectionLevel.Default, Name("call"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("call")),
        MethodTree(Nil, ProtectionLevel.Default, Name("bind"), Nil, Seq(Seq(ParamTree(Name("thisArg"), TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("bind")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Function,
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassTree = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: Seq[ParamTree] =
      if (isThis) Seq(ParamTree(Name.This, TypeRef.ThisType(NoComments), None, NoComments)) else Nil

    val inputParams = 0 until arity map (n => ParamTree(T(n), TypeRef(T(n)), None, NoComments))
    val R           = TypeRef(Name("R"))
    val codePath    = QualifiedName.FunctionArity(isThis, arity)

    val Apply: MethodTree =
      MethodTree(
        annotations = Nil,
        level       = ProtectionLevel.Default,
        name        = Name.APPLY,
        tparams     = Nil,
        params      = Seq(ThisParam ++ inputParams),
        impl        = MemberImpl.NotImplemented,
        resultType  = R,
        isOverride  = false,
        comments    = NoComments,
        codePath    = codePath + Name.APPLY,
      )

    val ThisTParam: Seq[TypeParamTree] =
      if (isThis) Seq(TypeParamTree(Name.This, None, NoComments)) else Nil

    val inputTParams: Seq[TypeParamTree] =
      0 until arity map (n => TypeParamTree(T(n), None, NoComments))

    val outputTParams: Seq[TypeParamTree] =
      Seq(TypeParamTree(R.name, None, NoComments))

    ClassTree(
      annotations = Seq(Annotation.JsNative),
      name        = codePath.parts.last,
      tparams     = ThisTParam ++ inputTParams ++ outputTParams,
      parents     = Seq(TypeRef(QualifiedName.Function)),
      ctors       = Nil,
      members     = Seq(Apply),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      codePath,
    )
  }

  val StringDictionary =
    ClassTree(
      Seq(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("StringDictionary"),
      Seq(TypeParamTree(Name("T"), None, NoComments)),
      Nil,
      Nil,
      Nil,
      ClassType.Trait,
      isSealed = false,
      NoComments,
      QualifiedName.StringDictionary,
    )

  val NumberDictionary =
    ClassTree(
      Seq(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("NumberDictionary"),
      Seq(TypeParamTree(Name("T"), None, NoComments)),
      Nil,
      Nil,
      Nil,
      ClassType.Trait,
      isSealed = false,
      NoComments,
      QualifiedName.NumberDictionary,
    )

  val Functions: Seq[ClassTree] =
    0 to 22 flatMap (n => List(ScalaJsF(isThis = false, n), ScalaJsF(isThis = true, n)))

  val ScalaJsTypes: Map[List[Name], ClassTree] =
    (Functions ++ List(
      ScalaJsFunction,
      ScalaJsArray,
      ObjectMembers.ScalaJsObject,
      ObjectMembers.ScalaObject,
      StringDictionary,
      NumberDictionary,
      react.SlinkyComponents.classDefs.ExternalComponentNoPropsCls,
      react.SlinkyComponents.classDefs.ExternalComponentPropsCls,
    )).map(x => x.codePath.parts -> x).toMap
}
