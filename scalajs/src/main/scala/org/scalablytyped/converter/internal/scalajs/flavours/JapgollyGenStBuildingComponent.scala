package org.scalablytyped.converter.internal
package scalajs
package flavours

import ExprTree._

class JapgollyGenStBuildingComponent(val outputPkg: Name, val scalaVersion: Versions.Scala) {

  /** Need to disable this on 2.12 because it cannot represent universal traits with `this` types */
  val enableAnyVal = if (scalaVersion.binVersion <= "2.12") None else Some(TypeRef.AnyVal)

  val StBuildingComponent = Name("StBuildingComponent")
  val builderCp           = QualifiedName(IArray(outputPkg, StBuildingComponent))
  val R                   = TypeParamTree(Name("R"), Empty, Some(TypeRef.Object), NoComments, ignoreBound = false)
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
    val unsafeSpread = {
      val param = ParamTree(Name("obj"), false, false, TypeRef.Any, NotImplemented, NoComments)
      val name  = Name("unsafeSpread")
      val assign = Call(
        Ref(QualifiedName.Object + Name("assign")),
        IArray(
          IArray(
            Cast(Call(Ref(args.name), IArray(IArray(NumberLit("1")))), TypeRef.Object),
            Cast(Ref(param.name), TypeRef.Object),
          ),
        ),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
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
        ProtectionLevel.Default,
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
//        tt.mods.foreach(applyTagMod)
//      } else if (t.isInstanceOf[VdomNode]) {
//        val tt = t.asInstanceOf[VdomNode]
//        b.args.push(tt.rawNode.asInstanceOf[js.Any])
//      } else {
//        val tt = t.toJs
//        tt.addClassNameToProps()
//        tt.addKeyToProps()
//        tt.addStyleToProps()
//        tt.nonEmptyChildren.foreach(children => b.args.push(children))
//        tt.nonEmptyProps.foreach(props => js.Object.assign(b.args(1).asInstanceOf[js.Object], props))
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
                TypeRef(QualifiedName.Array, IArray(ReactNode), NoComments),
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
              IArray(IArray(Ref(unsafeSpread.name))),
            ),
          )
        }

        If(
          InstanceOf(Ref(tParam.name), TagModComposite),
          Block(
            Val(ttName, Cast(Ref(tParam.name), TagModComposite)),
            Call(Ref(QualifiedName(IArray(ttName, Name("mods"), Name("foreach")))), IArray(IArray(Ref(name)))),
          ),
          Some(
            If(
              InstanceOf(Ref(tParam.name), VdomNode),
              Block(
                Val(ttName, Cast(Ref(tParam.name), VdomNode)),
                Call(
                  Select(Ref(args.name), Name("push")),
                  IArray(IArray(Cast(Select(Ref(ttName), Name("rawNode")), TypeRef.Any))),
                ),
              ),
              Some(fallback),
            ),
          ),
        )
      }

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
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
//      mods.foreach(applyTagMod)
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
          Call(Select(Ref(modsParam.name), Name("foreach")), IArray(IArray(Ref(applyTagMod.name)))),
          Ref(Name.THIS),
        )

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
        TypeRef(JapgollyNames.Key),
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
      val tpe   = TypeRef(JapgollyNames.RefSimple, IArray(TypeRef(R.name)), NoComments)
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
      parents     = IArray.fromOption(enableAnyVal.map(_ => TypeRef.ScalaAny)),
      ctors       = Empty,
      members     = IArray(args, set, withComponent, unsafeSpread, build, applyTagMod, apply, withKey, withRef1, withRef2),
      classType   = ClassType.Trait,
      isSealed    = false,
      comments    = NoComments,
      codePath    = builderCp,
    )
  }

  lazy val Default: ClassTree = {
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
      // drop specific type parameters to help type inference in case they are inferred as `Nothing`
      val wildcardRef        = builderRef.copy(targs = builderRef.targs.map(_ => TypeRef.Wildcard))
      val compParam          = ParamTree(Name("comp"), false, false, wildcardRef, NotImplemented, NoComments)
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
            TypeRef(JapgollyNames.rawReact.Element),
          ),
        ),
        inDevMode(Call(Select(compArgs, Name("update")), IArray(IArray(NumberLit("0"), Null)))),
        Call(Ref(JapgollyNames.vdom.ReactElement), IArray(IArray(Ref(ret)))),
      )

      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
        name,
        Empty,
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
      StBuildingComponent,
      Empty,
      IArray(ReactRaw, make, Default),
      Minimization.KeepMarker,
      builderCp,
      isOverride = false,
    )
  }
}
