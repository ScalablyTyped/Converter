package org.scalablytyped.converter.internal
package scalajs

object ScalaJsClasses {
  // format: off
  val ScalaJsArray =
    ClassTree(
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Array"),
      IArray(TypeParamTree(Name("T"), None, NoComments)),
      // todo: fill in
      Empty,
      Empty,
      Empty,
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Array,
    )
  // format: on

  // format: off
  val ScalaJsFunction =
    ClassTree(
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Function"),
      Empty,
      Empty,
      IArray(
        CtorTree(ProtectionLevel.Default, IArray(ParamTree(Name("args"), isImplicit = false, TypeRef.Repeated(TypeRef.String, NoComments), None, NoComments)), NoComments),
      ),
      IArray(
        FieldTree(Empty, Name("length"), TypeRef.Int, MemberImpl.Native, isReadOnly = false, isOverride = false, NoComments, QualifiedName.Function + Name("length")),
        MethodTree(Empty, ProtectionLevel.Default, Name("call"), Empty, IArray(IArray(ParamTree(Name("thisArg"), isImplicit = false, TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), isImplicit = false, TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("call")),
        MethodTree(Empty, ProtectionLevel.Default, Name("bind"), Empty, IArray(IArray(ParamTree(Name("thisArg"), isImplicit = false, TypeRef.Any, None, NoComments), ParamTree(Name("argArray"), isImplicit = false, TypeRef.Repeated(TypeRef.Dynamic, NoComments), None, NoComments))), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("bind")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Function,
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassTree = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: IArray[ParamTree] =
      if (isThis) IArray(ParamTree(Name.This, false, TypeRef.ThisType(NoComments), None, NoComments)) else Empty

    val inputParams = 0 until arity map (n => ParamTree(T(n), false, TypeRef(T(n)), None, NoComments))
    val R           = TypeRef(Name("R"))
    val codePath    = QualifiedName.FunctionArity(isThis, arity)

    val Apply: MethodTree =
      MethodTree(
        annotations = Empty,
        level       = ProtectionLevel.Default,
        name        = Name.APPLY,
        tparams     = Empty,
        params      = IArray(ThisParam ++ IArray.fromTraversable(inputParams)),
        impl        = MemberImpl.NotImplemented,
        resultType  = R,
        isOverride  = false,
        comments    = NoComments,
        codePath    = codePath + Name.APPLY,
      )

    val ThisTParam: IArray[TypeParamTree] =
      if (isThis) IArray(TypeParamTree(Name.This, None, NoComments)) else Empty

    val inputTParams: IArray[TypeParamTree] =
      IArray.fromTraversable(0 until arity map (n => TypeParamTree(T(n), None, NoComments)))

    val outputTParams: IArray[TypeParamTree] =
      IArray(TypeParamTree(R.name, None, NoComments))

    ClassTree(
      annotations = IArray(Annotation.JsNative),
      name        = codePath.parts.last,
      tparams     = ThisTParam ++ inputTParams ++ outputTParams,
      parents     = IArray(TypeRef(QualifiedName.Function)),
      ctors       = Empty,
      members     = IArray(Apply),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      codePath,
    )
  }

  val StringDictionary =
    ClassTree(
      IArray(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("StringDictionary"),
      IArray(TypeParamTree(Name("T"), None, NoComments)),
      Empty,
      Empty,
      Empty,
      ClassType.Trait,
      isSealed = false,
      NoComments,
      QualifiedName.StringDictionary,
    )

  val NumberDictionary =
    ClassTree(
      IArray(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("NumberDictionary"),
      IArray(TypeParamTree(Name("T"), None, NoComments)),
      Empty,
      Empty,
      Empty,
      ClassType.Trait,
      isSealed = false,
      NoComments,
      QualifiedName.NumberDictionary,
    )

  val Functions: IArray[ClassTree] =
    IArray.fromTraversable(0 to 22 flatMap (n => List(ScalaJsF(isThis = false, n), ScalaJsF(isThis = true, n))))

  val ScalaJsTypes: Map[QualifiedName, Tree] =
    (Functions ++ IArray(
      ScalaJsFunction,
      ScalaJsArray,
      ObjectMembers.ScalaJsObject,
      ObjectMembers.ScalaObject,
      StringDictionary,
      NumberDictionary,
      flavours.GenSlinkyComponents.classDefs.ExternalComponentNoPropsCls,
      flavours.GenSlinkyComponents.classDefs.ExternalComponentPropsCls,
    )).map(x => x.codePath -> x).toMap
}
