package org.scalablytyped.converter.internal
package scalajs
package flavours

/**
  * This generated class is our replacement for Slinkys ExternalComponent... types, which didnt really work.
  */
class SlinkyGenStBuildingComponent(val outputPkg: Name, val scalaVersion: Versions.Scala) {
  import ExprTree._

  /** Need to disable this on 2.12 because it cannot represent universal traits with `this` types */
  val enableAnyVal = if (scalaVersion.binVersion <= "2.12") None else Some(TypeRef.AnyVal)

  val StBuildingComponent = Name("StBuildingComponent")
  val builderCp           = QualifiedName(IArray(outputPkg, StBuildingComponent))
  val E                   = TypeParamTree(Name("E"), Empty, None, NoComments, ignoreBound = false)
  val R                   = TypeParamTree(Name("R"), Empty, Some(TypeRef.JsObject), NoComments, ignoreBound = false)
  val builderTparams      = IArray(E, R)
  val builderRef          = TypeRef(builderCp, TypeParamTree.asTypeArgs(builderTparams), NoComments)

  //  def args: js.Array[js.Any]
  val args: MethodTree = {
    val name: Name = Name("args")
    MethodTree(
      Empty,
      ProtectionLevel.Public,
      name,
      Empty,
      Empty,
      NotImplemented,
      TypeRef(QualifiedName.JsArray, IArray(TypeRef.Any), NoComments),
      isOverride = false,
      comments   = NoComments,
      codePath   = builderCp + name,
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
        Select(
          AsInstanceOf(Call(Ref(args.name), IArray(IArray(IntLit("1")))), TypeRef.JsDynamic),
          Name("updateDynamic"),
        ),
        IArray(IArray(Ref(keyParam.name)), IArray(AsInstanceOf(Ref(valueParam.name), TypeRef.JsAny))),
      ),
      Ref(QualifiedName.THIS),
    )
    val name: Name = Name("set")

    MethodTree(
      IArray(Annotation.Inline),
      ProtectionLevel.Public,
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
            IntLit("0"),
            Call(Ref(fParam.name), IArray(IArray(Call(Ref(args.name), IArray(IArray(IntLit("0"))))))),
          ),
        ),
      ),
      Ref(QualifiedName.THIS),
    )
    val name: Name = Name("withComponent")

    MethodTree(
      IArray(Annotation.Inline),
      ProtectionLevel.Public,
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
    val build = {
      val name = Name("build")

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Public,
        name,
        Empty,
        Empty,
        Call(Ref(Object.make.codePath), IArray(IArray(Ref(QualifiedName.THIS)))),
        Object.make.resultType,
        false,
        Comments(
          Comment(
            "/* You typically shouldnt call this yourself, but it can be useful if you're for instance mapping a sequence and you need types to infer properly */\n",
          ),
        ),
        builderCp + name,
        false,
      )
    }

    val unsafeSpread = {
      val param = ParamTree(Name("obj"), false, false, TypeRef.Any, NotImplemented, NoComments)
      val name  = Name("unsafeSpread")
      val assign = Call(
        Ref(QualifiedName.JsObject + Name("assign")),
        IArray(
          IArray(
            AsInstanceOf(Call(Ref(args.name), IArray(IArray(IntLit("1")))), TypeRef.JsObject),
            AsInstanceOf(Ref(param.name), TypeRef.JsObject),
          ),
        ),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Public,
        name,
        Empty,
        IArray(IArray(param)),
        Block(assign, Ref(QualifiedName.THIS)),
        TypeRef(QualifiedName.THIS),
        false,
        NoComments,
        builderCp + name,
        false,
      )
    }

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
        val modParam = ParamTree(Name.mod, isImplicit = false, isVal = false, TagModE, NotImplemented, NoComments)
        val modRef   = Ref(modParam.name)

        val AttrPair = TypeRef(SlinkyGenComponents.names.AttrPair, IArray(TypeRef.Wildcard), NoComments)
        val ifIsAttrPair = {
          val a = Name("a")
          Block(
            Val(a, AsInstanceOf(modRef, AttrPair)),
            Call(Ref(set.name), IArray(IArray(Select(Ref(a), Name("name")), Select(Ref(a), Name("value"))))),
          )
        }
        val OptionalAttrPair = TypeRef(SlinkyGenComponents.names.OptionalAttrPair, IArray(TypeRef.Wildcard), NoComments)
        val ifIsOptionalAttrPair = {
          val o      = Name("o")
          val oValue = Select(Ref(o), Name("value"))
          Block(
            Val(o, AsInstanceOf(modRef, OptionalAttrPair)),
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
            IsInstanceOf(modRef, AttrPair),
            ifIsAttrPair,
            Some(
              If(
                IsInstanceOf(modRef, OptionalAttrPair),
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
        level       = ProtectionLevel.Public,
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
        level       = ProtectionLevel.Public,
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
    //  @inline final def withRef(ref: js.Function1[R, Unit]): this.type = set("ref", ref)
    val withRef1 = {
      val tpe   = TypeRef.JsFunction(None, IArray(TypeRef(R.name)), TypeRef.Unit, NoComments)
      val param = ParamTree(Name("ref"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
      val name  = Name("withRef")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Public,
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
        level       = ProtectionLevel.Public,
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
      level       = ProtectionLevel.Public,
      name        = StBuildingComponent,
      tparams     = builderTparams,
      parents     = IArray.fromOption(enableAnyVal.map(_ => TypeRef.Any)),
      ctors       = Empty,
      members     = IArray(args, set, withComponent, build, unsafeSpread, apply, withKey, withRef1, withRef2),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      codePath    = builderCp,
    )
  }

  lazy val Default: ClassTree = {
    val ctor = CtorTree(
      ProtectionLevel.Public,
      IArray(
        ParamTree(
          Name("args"),
          isImplicit = false,
          isVal      = true,
          TypeRef(QualifiedName.JsArray, IArray(TypeRef.Any), NoComments),
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
      level       = ProtectionLevel.Public,
      name        = name,
      tparams     = builderTparams,
      parents     = IArray.fromOption(enableAnyVal) ++ IArray(builderRef),
      ctors       = IArray(ctor),
      members     = Empty,
      classType   = ClassType.Class,
      isSealed    = false,
      comments    = NoComments,
      codePath    = builderCp + name,
    )
  }

  object Object {
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
        level       = ProtectionLevel.Public,
        name        = createElement,
        tpe         = TypeRef.JsDynamic,
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
        ProtectionLevel.Public,
        name,
        IArray(TypeRef.JsObject),
        IArray(createElementField),
        Minimization.KeepMarker + Marker.ManglerLeaveAlone,
        ReactRawCp,
        isOverride = false,
      )
    }

//    @inline implicit def make(comp: StBuildingComponent[_, _]): slinky.core.facade.ReactElement = {
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
    val make: MethodTree = {
      val compParam          = ParamTree(Name("comp"), false, false, builderRef, NotImplemented, NoComments)
      val name               = Name("make")
      val compArgs           = Select(Ref(compParam.name), Name("args"))
      val args0              = Call(compArgs, IArray(IArray(IntLit("0"))))
      val reactRawName       = Ref(ReactRaw.name)
      val createElementApply = reactRawName.select("createElement", "applyDynamic")
      val ret                = Name("ret")

      def inDevMode(expr: ExprTree) =
        If(
          Unary(
            "!",
            Ref(QualifiedName.scala_scalajs).select("runtime", "linkingInfo", "productionMode"),
          ),
          Block(expr),
          None,
        )

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
          AsInstanceOf(
            Call(createElementApply, IArray(IArray(StringLit("apply")), IArray(reactRawName, compArgs))),
            TypeRef(SlinkyGenComponents.names.ReactElement),
          ),
        ),
        inDevMode(Call(Select(compArgs, Name("update")), IArray(IArray(IntLit("0"), Null)))),
        Ref(ret),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Public,
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

    val tree = ModuleTree(
      Empty,
      ProtectionLevel.Public,
      StBuildingComponent,
      Empty,
      IArray(ReactRaw, make, Default),
      Minimization.KeepMarker + Marker.ManglerLeaveAlone,
      builderCp,
      isOverride = false,
    )
  }
}
