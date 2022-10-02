package org.scalablytyped.converter.internal
package scalajs
package flavours

object GenPromiseOps extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
    if (scope.libName == Name.std && s.name == Name.std) {
      val newCompanions = IArray
        .fromOptions(
          flaff(s, Name("Promise")),
          flaff(s, Name("PromiseLike")),
        )
        .toMap

      val filteredMembers = s.members.filter {
        case x: ModuleTree if newCompanions.contains(x.name) => false
        case _ => true
      }
      s.withMembers(filteredMembers ++ IArray.fromTraversable(newCompanions.values))
    } else s

  def flaff(s: ContainerTree, name: Name): Option[(Name, ModuleTree)] = {
    val (existingClass, existingModule, _) = s.index
      .getOrElse(name, IArray.Empty)
      .partitionCollect2({ case x: ClassTree => x }, { case x: ModuleTree => x })

    existingClass match {
      case IArray.first(cls) =>
        val mod = existingModule.headOption.getOrElse(
          ModuleTree(
            Empty,
            level      = ProtectionLevel.Public,
            name       = cls.name,
            parents    = Empty,
            members    = Empty,
            comments   = NoComments,
            codePath   = cls.codePath,
            isOverride = false,
          ),
        )
        val ops  = genPromiseOps(cls, mod)
        val mod1 = mod.copy(members = mod.members :+ ops)
        Some((name, mod1))
      case _ => None
    }
  }

  def genPromiseOps(cls: ClassTree, mod: ModuleTree) = {
    val paramName = Name("promise")
    val Ops       = Name(cls.name.unescaped + "Ops")
    val OpsCP     = mod.codePath + Ops

    val toPromise = {
      val name = Name("toPromise")
      val tpe  = TypeRef(QualifiedName.JsPromise, TypeParamTree.asTypeArgs(cls.tparams), NoComments)
      MethodTree(
        annotations = Empty,
        level       = ProtectionLevel.Public,
        name        = name,
        tparams     = Empty,
        params      = Empty,
        impl        = ExprTree.AsInstanceOf(ExprTree.Ref(paramName), tpe),
        resultType  = tpe,
        isOverride  = false,
        comments    = NoComments,
        codePath    = OpsCP + name,
        isImplicit  = false,
      )
    }

    val toFuture = {
      val name = Name("toFuture")
      val tpe = TypeRef(
        QualifiedName(IArray(Name.scala, Name("concurrent"), Name("Future"))),
        TypeParamTree.asTypeArgs(cls.tparams),
        NoComments,
      )
      MethodTree(
        annotations = Empty,
        level       = ProtectionLevel.Public,
        name        = name,
        tparams     = Empty,
        params      = Empty,
        impl        = ExprTree.Select(ExprTree.Ref(toPromise.name), Name("toFuture")),
        resultType  = tpe,
        isOverride  = false,
        comments    = NoComments,
        codePath    = OpsCP + name,
        isImplicit  = false,
      )
    }
    ClassTree(
      isImplicit  = true,
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Public,
      name        = Ops,
      tparams     = cls.tparams,
      parents     = IArray(TypeRef.AnyVal),
      ctors = IArray(
        CtorTree(
          ProtectionLevel.Public,
          IArray(
            ParamTree(
              name       = paramName,
              isImplicit = false,
              isVal      = true,
              tpe        = TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
              default    = NotImplemented,
              comments   = NoComments,
            ),
          ),
          NoComments,
        ),
      ),
      members   = IArray(toPromise, toFuture),
      classType = ClassType.Class,
      isSealed  = false,
      comments  = NoComments,
      codePath  = OpsCP,
    )
  }
}
