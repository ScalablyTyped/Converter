package org.scalablytyped.converter.internal
package scalajs

object ScalaJsClasses {
  // format: off
  val ScalaJsArray =
    ClassTree(
      isImplicit = false,
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Array"),
      IArray(TypeParamTree(Name("T"), Empty, None, NoComments, ignoreBound = false)),
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
      isImplicit = false,
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Function"),
      Empty,
      Empty,
      IArray(
        CtorTree(ProtectionLevel.Default, IArray(ParamTree(Name("args"), isImplicit = false, isVal = false, TypeRef.Repeated(TypeRef.String, NoComments), NotImplemented, NoComments)), NoComments),
      ),
      IArray(
        FieldTree(Empty, Name("length"), TypeRef.Int, ExprTree.native, isReadOnly = false, isOverride = false, NoComments, QualifiedName.Function + Name("length")),
        MethodTree(Empty, ProtectionLevel.Default, Name("call"), Empty, IArray(IArray(ParamTree(Name("thisArg"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments), ParamTree(Name("argArray"), isImplicit = false, isVal = false, TypeRef.Repeated(TypeRef.Dynamic, NoComments), NotImplemented, NoComments))), ExprTree.native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("call"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("bind"), Empty, IArray(IArray(ParamTree(Name("thisArg"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments), ParamTree(Name("argArray"), isImplicit = false, isVal = false, TypeRef.Repeated(TypeRef.Dynamic, NoComments), NotImplemented, NoComments))), ExprTree.native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Function + Name("bind"), false),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Function,
    )
  // format: on

  // format: off
  val ScalaJsPromise =
    ClassTree(
      isImplicit = false,
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Promise"),
      IArray(TypeParamTree(Name("T"), Empty, None, NoComments, ignoreBound = true)),
      parents = IArray(TypeRef(QualifiedName.Thenable)),
      Empty,
      Empty,
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Promise,
    )
  // format: on

  // format: off
  val ScalaJsThenable =
    ClassTree(
      isImplicit = false,
      IArray(Annotation.JsNative, Annotation.JsGlobalScope),
      Name("Thenable"),
      IArray(TypeParamTree(Name("T"), Empty, None, NoComments, ignoreBound = true)),
      Empty,
      Empty,
      Empty,
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Thenable,
    )
  // format: on

  def ScalaJsF(isThis: Boolean, arity: Int): ClassTree = {
    def T(n: Int) = Name(s"T" + n)

    val ThisParam: IArray[ParamTree] =
      if (isThis)
        IArray(ParamTree(Name.This, false, isVal = false, TypeRef.ThisType(NoComments), NotImplemented, NoComments))
      else Empty

    val inputParams =
      (0 until arity).map(n => ParamTree(T(n), false, isVal = false, TypeRef(T(n)), NotImplemented, NoComments))
    val R        = TypeRef(Name("R"))
    val codePath = QualifiedName.FunctionArity(isThis, arity)

    val Apply: MethodTree =
      MethodTree(
        annotations = Empty,
        level       = ProtectionLevel.Default,
        name        = Name.APPLY,
        tparams     = Empty,
        params      = IArray(ThisParam ++ IArray.fromTraversable(inputParams)),
        impl        = NotImplemented,
        resultType  = R,
        isOverride  = false,
        comments    = NoComments,
        codePath    = codePath + Name.APPLY,
        isImplicit  = false,
      )

    val ThisTParam: IArray[TypeParamTree] =
      if (isThis) IArray(TypeParamTree(Name.This, Empty, None, NoComments, ignoreBound = true)) else Empty

    val inputTParams: IArray[TypeParamTree] =
      IArray.fromTraversable((0 until arity).map(n => TypeParamTree(T(n), Empty, None, NoComments, ignoreBound = true)))

    val outputTParams: IArray[TypeParamTree] =
      IArray(TypeParamTree(R.name, Empty, None, NoComments, ignoreBound = true))

    ClassTree(
      isImplicit  = false,
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
      isImplicit = false,
      IArray(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("StringDictionary"),
      IArray(TypeParamTree(Name("T"), Empty, None, NoComments, ignoreBound = true)),
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
      isImplicit = false,
      IArray(Annotation.ScalaJSDefined, Annotation.JsGlobalScope),
      Name("NumberDictionary"),
      IArray(TypeParamTree(Name("T"), Empty, None, NoComments, ignoreBound = true)),
      Empty,
      Empty,
      Empty,
      ClassType.Trait,
      isSealed = false,
      NoComments,
      QualifiedName.NumberDictionary,
    )

  val Functions: IArray[ClassTree] =
    IArray.fromTraversable((0 to 22).flatMap(n => List(ScalaJsF(isThis = false, n), ScalaJsF(isThis = true, n))))

  val ScalaJsTypes: Map[QualifiedName, Tree] =
    (Functions ++ IArray(
      ScalaJsPromise,
      ScalaJsThenable,
      ScalaJsFunction,
      ScalaJsArray,
      ObjectMembers.ScalaJsObject,
      ObjectMembers.ScalaObject,
      StringDictionary,
      NumberDictionary,
    )).map(x => x.codePath -> x).toMap
}
