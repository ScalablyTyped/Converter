package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.ExprTree._

class JapgollyGenStBuildingComponent(val outputPkg: Name, val scalaVersion: Versions.Scala) {

  /** Need to disable this on 2.12 because it cannot represent universal traits with `this` types */
  val enableAnyVal = if (scalaVersion.binVersion <= "2.12") None else Some(TypeRef.AnyVal)

  val StBuildingComponent = Name("StBuildingComponent")
  val builderCp           = QualifiedName(IArray(outputPkg, StBuildingComponent))
  val R                   = TypeParamTree(Name("R"), Empty, Some(TypeRef.JsObject), NoComments, ignoreBound = false)
  val builderTparams      = IArray(R)
  val builderRef          = TypeRef(builderCp, TypeParamTree.asTypeArgs(builderTparams), NoComments)
  val modParam            = ParamTree(Name("m"), false, false, TypeRef(JapgollyNames.vdom.TagMod), NotImplemented, NoComments)
  val jsAnyParam          = ParamTree(Name("m"), false, false, TypeRef.Any, NotImplemented, NoComments)

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

    //    @scala.inline
//    def applyTagMod(t: TagMod): Unit =
//      if (t.isInstanceOf[TagMod.Composite]) {
//        val tt = t.asInstanceOf[TagMod.Composite]
//        tt.mods.foreach((m: TagMod) => applyTagMod(m))
//      } else if (t.isInstanceOf[VdomNode]) {
//        val tt = t.asInstanceOf[VdomNode]
//        b.args.push(tt.rawNode.asInstanceOf[js.Any])
//      } else {
//        val tt = t.toJs
//        tt.addClassNameToProps()
//        tt.addKeyToProps()
//        tt.addStyleToProps()
//        tt.nonEmptyChildren.foreach((children: js.Array[Node]) => b.args.push(children))
//        tt.nonEmptyProps.foreach((m: js.Any) => unsafeSpread(m))
//      }
    val applyTagMod = {
      val TagMod          = TypeRef(JapgollyNames.vdom.TagMod)
      val VdomNode        = TypeRef(JapgollyNames.vdom.VdomNode)
      val ReactNode       = TypeRef(JapgollyNames.rawReact.Node)
      val TagModComposite = TypeRef(JapgollyNames.vdom.TagMod + Name("Composite"))

      val tParam = ParamTree(Name("t"), false, false, TagMod, NotImplemented, NoComments)
      val name   = Name("applyTagMod")
      val impl = {
        val ttName = Name("tt")
        val fallback = {
          val childrenName = Name("children")
          val childrenLambda = Lambda(
            IArray(
              ParamTree(
                childrenName,
                false,
                false,
                TypeRef(QualifiedName.JsArray, IArray(ReactNode), NoComments),
                NotImplemented,
                NoComments,
              ),
            ),
            Call(Select(Ref(args.name), Name("push")), IArray(IArray(Ref(childrenName)))),
          )
          Block(
            Val(ttName, Select(Ref(tParam.name), Name("toJs"))),
            Call(Ref(QualifiedName(IArray(ttName, Name("addClassNameToProps")))), IArray(Empty)),
            Call(Ref(QualifiedName(IArray(ttName, Name("addKeyToProps")))), IArray(Empty)),
            Call(Ref(QualifiedName(IArray(ttName, Name("addStyleToProps")))), IArray(Empty)),
            Call(
              Ref(QualifiedName(IArray(ttName, Name("nonEmptyChildren"), Name("foreach")))),
              IArray(IArray(childrenLambda)),
            ),
            Call(
              Ref(QualifiedName(IArray(ttName, Name("nonEmptyProps"), Name("foreach")))),
              IArray(
                IArray(Lambda(IArray(jsAnyParam), Call(Ref(unsafeSpread.name), IArray(IArray(Ref(modParam.name)))))),
              ),
            ),
          )
        }

        If(
          IsInstanceOf(Ref(tParam.name), TagModComposite),
          Block(
            Val(ttName, AsInstanceOf(Ref(tParam.name), TagModComposite)),
            Call(
              Ref(QualifiedName(IArray(ttName, Name("mods"), Name("foreach")))),
              IArray(IArray(Lambda(IArray(modParam), Call(Ref(name), IArray(IArray(Ref(modParam.name))))))),
            ),
          ),
          Some(
            If(
              IsInstanceOf(Ref(tParam.name), VdomNode),
              Block(
                Val(ttName, AsInstanceOf(Ref(tParam.name), VdomNode)),
                Call(
                  Select(Ref(args.name), Name("push")),
                  IArray(IArray(AsInstanceOf(Select(Ref(ttName), Name("rawNode")), TypeRef.JsAny))),
                ),
              ),
              Some(fallback),
            ),
          ),
        )
      }

      MethodTree(
        Empty,
        ProtectionLevel.Public,
        name,
        Empty,
        IArray(IArray(tParam)),
        impl,
        TypeRef.Unit,
        false,
        NoComments,
        builderCp + Name.APPLY + name,
        false,
      )
    }

//    @scala.inline
//    def apply(mods: TagMod*): this.type = {
//      mods.foreach((m: TagMod) => applyTagMod(m))
//      this
//    }
    val `apply` = {
      val modsParam = ParamTree(
        name       = Name("mods"),
        isImplicit = false,
        isVal      = false,
        tpe        = TypeRef.Repeated(TypeRef(JapgollyNames.vdom.TagMod), NoComments),
        default    = NotImplemented,
        comments   = NoComments,
      )
      val impl =
        Block(
          Call(
            Select(Ref(modsParam.name), Name("foreach")),
            IArray(IArray(Lambda(IArray(modParam), Call(Ref(applyTagMod.name), IArray(IArray(Ref(modParam.name))))))),
          ),
          Ref(Name.THIS),
        )

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

//    @scala.inline
//    def apply(children: japgolly.scalajs.react.PropsChildren): this.type = {
//      args.push(children.raw)
//      this
//    }
    val applyChildren = {
      val childrenParam = ParamTree(
        name       = Name("children"),
        isImplicit = false,
        isVal      = false,
        tpe        = TypeRef(JapgollyNames.PropsChildren),
        default    = NotImplemented,
        comments   = NoComments,
      )
      val impl =
        Block(
          Call(
            Ref(args.name).select("push"),
            IArray(IArray(Ref(childrenParam.name).select("raw"))),
          ),
          Ref(Name.THIS),
        )

      val name = Name("children")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Public,
        name        = name,
        tparams     = Empty,
        params      = IArray(IArray(childrenParam)),
        impl,
        resultType = TypeRef(QualifiedName.THIS),
        isOverride = false,
        comments   = NoComments,
        codePath   = builderCp + name,
        isImplicit = false,
      )
    }

    //  @inline final def withKey(key: japgolly.scalajs.react.Key): this.type = set("key", key)
    val withKey = {
      val param = ParamTree(
        Name("key"),
        isImplicit = false,
        isVal      = false,
        TypeRef(JapgollyNames.Key),
        NotImplemented,
        NoComments,
      )
      val name = Name("withKey")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Public,
        name        = name,
        tparams     = Empty,
        params      = IArray(IArray(param)),
        impl = Call(
          Ref(set.name),
          IArray(IArray(StringLit(param.name.unescaped), AsInstanceOf(Ref(param.name), TypeRef.JsAny))),
        ),
        resultType = TypeRef(QualifiedName.THIS),
        isOverride = false,
        comments   = NoComments,
        codePath   = builderCp + name,
        isImplicit = false,
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
    //  @inline final def withRef(ref: japgolly.scalajs.react.Ref.Simple[R]): this.type = set("ref", ref.rawSetFn)
    val withRef2 = {
      val tpe   = TypeRef(JapgollyNames.RefSimple, IArray(TypeRef(R.name)), NoComments)
      val param = ParamTree(Name("ref"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
      val name  = Name("withRef")
      MethodTree(
        annotations = IArray(Annotation.Inline),
        level       = ProtectionLevel.Public,
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
      level       = ProtectionLevel.Public,
      name        = StBuildingComponent,
      tparams     = builderTparams,
      parents     = IArray.fromOption(enableAnyVal.map(_ => TypeRef.Any)),
      ctors       = Empty,
      members = IArray(
        args,
        set,
        withComponent,
        unsafeSpread,
        build,
        applyTagMod,
        apply,
        applyChildren,
        withKey,
        withRef1,
        withRef2,
      ),
      classType = ClassType.Trait,
      isSealed  = false,
      comments  = NoComments,
      codePath  = builderCp,
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
//    @inline implicit def make(comp: StBuildingComponent[_]): japgolly.scalajs.react.vdom.VdomElement = {
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
            TypeRef(JapgollyNames.rawReact.Element),
          ),
        ),
        inDevMode(Call(Select(compArgs, Name("update")), IArray(IArray(IntLit("0"), Null)))),
        Call(Ref(JapgollyNames.vdom.ReactElement), IArray(IArray(Ref(ret)))),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Public,
        name,
        builderTparams,
        IArray(IArray(compParam)),
        impl,
        TypeRef(JapgollyNames.vdom.ReactElement),
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
