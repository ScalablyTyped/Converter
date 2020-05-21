package org.scalablytyped.converter.internal
package scalajs
package flavours

/**
  * This generated class is our replacement for Slinkys ExternalComponent... types, which didnt really work.
  */
class SlinkyGenStBuildingComponent(val outputPkg: Name) {
  import ExprTree._

  val StBuildingComponent = Name("StBuildingComponent")
  val builderCp           = QualifiedName(IArray(outputPkg, StBuildingComponent))
  val E                   = TypeParamTree(Name("E"), Empty, None, NoComments)
  val R                   = TypeParamTree(Name("R"), Empty, Some(TypeRef.Object), NoComments)
  val builderTparams      = IArray(E, R)
  val builderRef          = TypeRef(builderCp, TypeParamTree.asTypeArgs(builderTparams), NoComments)

  //  def args: js.Array[js.Any]
  val args = {
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

  val Trait = {

//  @inline final def apply(mods: slinky.core.TagMod[E]*): this.type = {
//    mods.foreach((mod: slinky.core.TagMod[E]) =>
//      if (mod.isInstanceOf[slinky.core.AttrPair]) {
//        val a = mod.asInstanceOf[AttrPair]
//        set(a.name, a.value)
//      } else {
//        if (mod.isInstanceOf[slinky.core.OptionalAttrPair]) {
//          val o = mod.asInstanceOf[slinky.core.OptionalAttrPair]
//          if (o.value.isDefined) {
//            set(o.name, o.value.get)
//          }
//        } else args.push(mod)
//      }
//    )
//    this
//  }
    val `apply` = {
      val TagModE = TypeRef(SlinkyGenComponents.names.TagMod, IArray(TypeRef(E.name)), NoComments)
      val modsParam = ParamTree(
        name       = Name("mods"),
        isImplicit = false,
        isVal      = false,
        tpe        = TypeRef.Repeated(TagModE, NoComments),
        default    = NotImplemented,
        comments   = NoComments,
      )
      val impl = {
        val modParam = ParamTree(Name("mod"), isImplicit = false, isVal = false, TagModE, NotImplemented, NoComments)
        val modRef   = Ref(modParam.name)

        val AttrPair = TypeRef(SlinkyGenComponents.names.AttrPair, IArray(TypeRef.Wildcard), NoComments)
        val ifIsAttrPair = {
          val a = Name("a")
          Block(
            Val(a, Cast(modRef, AttrPair)),
            Call(Ref(set.name), IArray(IArray(Select(Ref(a), Name("name")), Select(Ref(a), Name("value"))))),
          )
        }
        val OptionalAttrPair = TypeRef(SlinkyGenComponents.names.OptionalAttrPair, IArray(TypeRef.Wildcard), NoComments)
        val ifIsOptionalAttrPair = {
          val o      = Name("o")
          val oValue = Select(Ref(o), Name("value"))
          Block(
            Val(o, Cast(modRef, OptionalAttrPair)),
            If(
              Select(oValue, Name("isDefined")),
              Call(Ref(set.name), IArray(IArray(Select(Ref(o), Name("name")), Select(oValue, Name("get"))))),
              None,
            ),
          )
        }
        val lambda = Lambda(
          IArray(modParam),
          If(
            InstanceOf(modRef, AttrPair),
            ifIsAttrPair,
            Some(
              If(
                InstanceOf(modRef, OptionalAttrPair),
                ifIsOptionalAttrPair,
                Some(Call(Select(Ref(args.name), Name("push")), IArray(IArray(modRef)))),
              ),
            ),
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

    //  @inline final def withKey(key: String): this.type = set("key", key)
    val withKey = {
      val param = ParamTree(Name("key"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments)
      val name  = Name("withKey")
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
    //  @inline final def withRef(ref: slinky.core.facade.ReactRef[R]): this.type = set("ref", ref)
    val withRef2 = {
      val tpe   = TypeRef(SlinkyGenComponents.names.ReactRef, IArray(TypeRef(R.name)), NoComments)
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

  val Default = {
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

  val Object = {
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
        NoComments,
        ReactRawCp,
        isOverride = false,
      )
    }
//    @inline implicit def make[E, R <: js.Object](comp: StBuildingComponent[E, R]): slinky.core.facade.ReactElement = {
//      if (comp.args(0) == null) {
//        throw new IllegalStateException(
//          "This component has already been built into a ReactElement, and cannot be reused"
//        )
//      }
//      val ret = ReactRaw.createElement
//        .applyDynamic("apply")(ReactRaw, comp.args)
//        .asInstanceOf[slinky.core.facade.ReactElement]
//
//      comp.args.update(0, null)
//      ret
//    }
    val make = {
      val compParam          = ParamTree(Name("comp"), false, false, builderRef, NotImplemented, NoComments)
      val name               = Name("make")
      val compArgs           = Select(Ref(compParam.name), Name("args"))
      val args0              = Call(compArgs, IArray(IArray(NumberLit("0"))))
      val reactRawName       = Ref(ReactRaw.name)
      val createElementApply = Select(Select(reactRawName, Name("createElement")), Name("applyDynamic"))

      val ret = Name("ret")
      val impl = Block(
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
        Val(
          ret,
          Cast(
            Call(createElementApply, IArray(IArray(StringLit("apply")), IArray(reactRawName, compArgs))),
            TypeRef(SlinkyGenComponents.names.ReactElement),
          ),
        ),
        Call(Select(compArgs, Name("update")), IArray(IArray(NumberLit("0"), Null))),
        Ref(ret),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
        name,
        builderTparams,
        IArray(IArray(compParam)),
        impl,
        TypeRef(SlinkyGenComponents.names.ReactElement),
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
      NoComments,
      builderCp,
      isOverride = false,
    )
  }
}
