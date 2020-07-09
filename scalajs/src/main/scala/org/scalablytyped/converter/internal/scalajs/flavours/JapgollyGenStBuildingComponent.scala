package org.scalablytyped.converter.internal
package scalajs
package flavours

import ExprTree._

class JapgollyGenStBuildingComponent(val outputPkg: Name) {

  val StBuildingComponent = Name("StBuildingComponent")
  val builderCp           = QualifiedName(IArray(outputPkg, StBuildingComponent))
  val R                   = TypeParamTree(Name("R"), Empty, Some(TypeRef.Object), NoComments)
  val builderTparams      = IArray(R)
  val builderRef          = TypeRef(builderCp, TypeParamTree.asTypeArgs(builderTparams), NoComments)

  //  def args: js.Array[js.Any]
  val args: MethodTree = {
    val name: Name = Name("args")
    MethodTree(
      IArray(Annotation.Inline),
      ProtectionLevel.Default,
      name,
      Empty,
      Empty,
      NotImplemented,
      TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments),
      isOverride = false,
      NoComments,
      builderCp + name,
      isImplicit = false,
    )
  }

  //  @inline final def set(key: String, value: js.Any): this.type = {
  //    args(1).asInstanceOf[js.Dynamic].updateDynamic(key)(value)
  //    this
  //  }
  val set: MethodTree = {
    val keyParam =
      ParamTree(Name("key"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments)
    val valueParam =
      ParamTree(Name("value"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments)

    val impl = Block(
      Call(
        Select(Cast(Call(Ref(args.name), IArray(IArray(NumberLit("1")))), TypeRef.Dynamic), Name("updateDynamic")),
        IArray(IArray(Ref(keyParam.name)), IArray(Ref(valueParam.name))),
      ),
      Ref(QualifiedName.THIS),
    )
    val name: Name = Name("set")

    MethodTree(
      IArray(Annotation.Inline),
      ProtectionLevel.Default,
      name,
      Empty,
      IArray(IArray(keyParam, valueParam)),
      impl,
      TypeRef(QualifiedName.THIS),
      isOverride = false,
      NoComments,
      builderCp + name,
      isImplicit = false,
    )
  }

  //  @inline final def withComponent(f: js.Any => js.Any): this.type = {
  //    args.update(0, f(args(0))
  //    this
  //  }
  val withComponent: MethodTree = {
    val fParam =
      ParamTree(
        Name("f"),
        isImplicit = false,
        isVal      = false,
        TypeRef.ScalaFunction(IArray(TypeRef.Any), TypeRef.Any, NoComments),
        NotImplemented,
        NoComments,
      )

    val impl = Block(
      Call(
        Select(Ref(args.name), Name("update")),
        IArray(
          IArray(
            NumberLit("0"),
            Call(Ref(fParam.name), IArray(IArray(Call(Ref(args.name), IArray(IArray(NumberLit("0"))))))),
          ),
        ),
      ),
      Ref(QualifiedName.THIS),
    )
    val name: Name = Name("withComponent")

    MethodTree(
      IArray(Annotation.Inline),
      ProtectionLevel.Default,
      name,
      Empty,
      IArray(IArray(fParam)),
      impl,
      TypeRef(QualifiedName.THIS),
      isOverride = false,
      NoComments,
      builderCp + name,
      isImplicit = false,
    )
  }

  val Trait: ClassTree = {

//  @inline final def apply(children: japgolly.scalajs.react.vdom.VdomNode*): this.type = {
//    mods.foreach((mod: japgolly.scalajs.react.vdom.VdomNode) => args.push(mod.rawNode))
//    this
//  }
    val `apply` = {
      val VdomNode = TypeRef(JapgollyGenComponents.japgolly.vdomVdomNode)
      val modsParam = ParamTree(
        name       = Name("mods"),
        isImplicit = false,
        isVal      = false,
        tpe        = TypeRef.Repeated(VdomNode, NoComments),
        default    = NotImplemented,
        comments   = NoComments,
      )
      val impl = {
        val modParam = ParamTree(Name("mod"), isImplicit = false, isVal = false, VdomNode, NotImplemented, NoComments)
        val modRef   = Ref(modParam.name)

        val lambda = Lambda(
          IArray(modParam),
          Call(
            Select(Ref(args.name), Name("push")),
            IArray(IArray(Cast(Select(modRef, Name("rawNode")), TypeRef.Any))),
          ),
        )

        Block(Call(Select(Ref(modsParam.name), Name("foreach")), IArray(IArray(lambda))), Ref(Name.THIS))
      }

      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Default,
        name        = Name.APPLY,
        tparams     = Empty,
        params      = IArray(IArray(modsParam)),
        impl,
        resultType = TypeRef(QualifiedName.THIS),
        isOverride = false,
        comments   = NoComments,
        codePath   = builderCp + Name.APPLY,
        isImplicit = false,
      )

    }

    //  @inline final def withKey(key: japgolly.scalajs.react.Key): this.type = set("key", key)
    val withKey = {
      val param = ParamTree(
        Name("key"),
        isImplicit = false,
        isVal      = false,
        TypeRef(JapgollyGenComponents.japgolly.reactKey),
        NotImplemented,
        NoComments,
      )
      val name = Name("withKey")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Default,
        name        = name,
        tparams     = Empty,
        params      = IArray(IArray(param)),
        impl        = Call(Ref(set.name), IArray(IArray(StringLit(param.name.unescaped), Cast(Ref(param.name), TypeRef.Any)))),
        resultType  = TypeRef(QualifiedName.THIS),
        isOverride  = false,
        comments    = NoComments,
        codePath    = builderCp + name,
        isImplicit  = false,
      )
    }

    //
    //  @inline final def withRef(ref: R => Unit): this.type = set("ref", ref)
    val withRef1 = {
      val tpe   = TypeRef.ScalaFunction(IArray(TypeRef(R.name)), TypeRef.Unit, NoComments)
      val param = ParamTree(Name("ref"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
      val name  = Name("withRef")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Default,
        name        = name,
        tparams     = Empty,
        params      = IArray(IArray(param)),
        impl        = Call(Ref(set.name), IArray(IArray(StringLit(param.name.unescaped), Ref(param.name)))),
        resultType  = TypeRef(QualifiedName.THIS),
        isOverride  = false,
        comments    = NoComments,
        codePath    = builderCp + name,
        isImplicit  = false,
      )
    }
    //
    //  @inline final def withRef(ref: japgolly.scalajs.react.Ref.Simple[R]): this.type = set("ref", ref.rawSetFn)
    val withRef2 = {
      val tpe   = TypeRef(JapgollyGenComponents.japgolly.RefSimple, IArray(TypeRef(R.name)), NoComments)
      val param = ParamTree(Name("ref"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
      val name  = Name("withRef")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Default,
        name        = name,
        tparams     = Empty,
        params      = IArray(IArray(param)),
        impl = Call(
          Ref(set.name),
          IArray(IArray(StringLit(param.name.unescaped), Select(Ref(param.name), Name("rawSetFn")))),
        ),
        resultType = TypeRef(QualifiedName.THIS),
        isOverride = false,
        comments   = NoComments,
        codePath   = builderCp + name,
        isImplicit = false,
      )
    }

    ClassTree(
      isImplicit  = false,
      annotations = Empty,
      name        = StBuildingComponent,
      tparams     = builderTparams,
      parents     = IArray(TypeRef.ScalaAny),
      ctors       = Empty,
      members     = IArray(args, set, withComponent, apply, withKey, withRef1, withRef2),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      codePath    = builderCp,
    )
  }

  val Default: ClassTree = {
    val ctor = CtorTree(
      ProtectionLevel.Default,
      IArray(
        ParamTree(
          Name("args"),
          isImplicit = false,
          isVal      = true,
          TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments),
          NotImplemented,
          NoComments,
        ),
      ),
      NoComments,
    )

    val name = Name("Default")
    ClassTree(
      isImplicit  = false,
      annotations = Empty,
      name        = name,
      tparams     = builderTparams,
      parents     = IArray(TypeRef.AnyVal, builderRef),
      ctors       = IArray(ctor),
      members     = Empty,
      classType   = ClassType.Class,
      isSealed    = false,
      comments    = NoComments,
      codePath    = builderCp + name,
    )
  }

  val Object: ModuleTree = {
    //    @js.native
    //    @JSImport("react", JSImport.Namespace, "React")
    //    object ReactRaw extends js.Object {
    //      val createElement: js.Dynamic = js.native // used for WithAttrs
    //    }
    val ReactRaw = {
      val name          = Name("ReactRaw")
      val ReactRawCp    = builderCp + name
      val createElement = Name("createElement")
      val createElementField = FieldTree(
        annotations = Empty,
        name        = createElement,
        tpe         = TypeRef.Dynamic,
        impl        = ExprTree.native,
        isReadOnly  = true,
        isOverride  = false,
        comments    = NoComments,
        codePath    = ReactRawCp + createElement,
      )
      ModuleTree(
        IArray(
          Annotation.JsImport("react", Imported.Namespace, Some(Annotation.JsGlobal(QualifiedName("React")))),
          Annotation.JsNative,
        ), // todo global
        name,
        IArray(TypeRef.Object),
        IArray(createElementField),
        Minimization.KeepMarker,
        ReactRawCp,
        isOverride = false,
      )
    }
//    @inline implicit def make[R <: js.Object](comp: StBuildingComponent[R]): japgolly.scalajs.react.vdom.VdomElement = {
//      if (comp.args(0) == null) {
//        throw new IllegalStateException(
//          "This component has already been built into a ReactElement, and cannot be reused"
//        )
//      }
//      val ret = ReactRaw.createElement
//        .applyDynamic("apply")(ReactRaw, comp.args)
//        .asInstanceOf[japgolly.scalajs.react.raw.React.Element]
//
//      comp.args.update(0, null)
//      japgolly.scalajs.react.vdom.VdomElement(ret)
//    }
    val make: MethodTree = {
      val compParam          = ParamTree(Name("comp"), false, false, builderRef, NotImplemented, NoComments)
      val name               = Name("make")
      val compArgs           = Select(Ref(compParam.name), Name("args"))
      val args0              = Call(compArgs, IArray(IArray(NumberLit("0"))))
      val reactRawName       = Ref(ReactRaw.name)
      val createElementApply = Select(Select(reactRawName, Name("createElement")), Name("applyDynamic"))
      val ret                = Name("ret")

      def inDevMode(expr: ExprTree) =
        If(Unary("!", Ref(QualifiedName.linkingInfo_productionMode)), Block(expr), None)

      val impl = Block(
        inDevMode(
          If(
            BinaryOp(args0, "==", Null),
            Throw(
              New(
                TypeRef(QualifiedName("java.lang.IllegalStateException")),
                IArray(StringLit("This component has already been built into a ReactElement, and cannot be reused")),
              ),
            ),
            None,
          ),
        ),
        Val(
          ret,
          Cast(
            Call(createElementApply, IArray(IArray(StringLit("apply")), IArray(reactRawName, compArgs))),
            TypeRef(JapgollyGenComponents.japgolly.reactElement),
          ),
        ),
        inDevMode(Call(Select(compArgs, Name("update")), IArray(IArray(NumberLit("0"), Null)))),
        Call(Ref(JapgollyGenComponents.japgolly.vdomReactElement), IArray(IArray(Ref(ret)))),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
        name,
        builderTparams,
        IArray(IArray(compParam)),
        impl,
        TypeRef(JapgollyGenComponents.japgolly.vdomReactElement),
        isOverride = false,
        NoComments,
        builderCp + name,
        isImplicit = true,
      )
    }

    ModuleTree(
      Empty,
      StBuildingComponent,
      Empty,
      IArray(ReactRaw, make, Default),
      Minimization.KeepMarker,
      builderCp,
      isOverride = false,
    )
  }
}
