package com.olvind.tso
package scalajs

//column-editing driven development FTW
class TreeTransformation { self =>
  def enterClassTree(scope:     TreeScope)(s: ClassTree):     ClassTree     = s
  def enterContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree = s
  def enterCtorTree(scope:      TreeScope)(s: CtorTree):      CtorTree      = s
  def enterFieldTree(scope:     TreeScope)(s: FieldTree):     FieldTree     = s
  def enterMemberTree(scope:    TreeScope)(s: MemberTree):    MemberTree    = s
  def enterMethodTree(scope:    TreeScope)(s: MethodTree):    MethodTree    = s
  def enterModuleTree(scope:    TreeScope)(s: ModuleTree):    ModuleTree    = s
  def enterPackageTree(scope:   TreeScope)(s: PackageTree):   PackageTree   = s
  def enterParamTree(scope:     TreeScope)(s: ParamTree):     ParamTree     = s
  def enterTree(scope:          TreeScope)(s: Tree):          Tree          = s
  def enterTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree = s
  def enterTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree = s
  def enterTypeRef(scope:       TreeScope)(s: TypeRef):       TypeRef       = s

  def leaveClassTree(scope:     TreeScope)(s: ClassTree):     ClassTree     = s
  def leaveContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree = s
  def leaveCtorTree(scope:      TreeScope)(s: CtorTree):      CtorTree      = s
  def leaveFieldTree(scope:     TreeScope)(s: FieldTree):     FieldTree     = s
  def leaveMemberTree(scope:    TreeScope)(s: MemberTree):    MemberTree    = s
  def leaveMethodTree(scope:    TreeScope)(s: MethodTree):    MethodTree    = s
  def leaveModuleTree(scope:    TreeScope)(s: ModuleTree):    ModuleTree    = s
  def leavePackageTree(scope:   TreeScope)(s: PackageTree):   PackageTree   = s
  def leaveParamTree(scope:     TreeScope)(s: ParamTree):     ParamTree     = s
  def leaveTree(scope:          TreeScope)(s: Tree):          Tree          = s
  def leaveTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree = s
  def leaveTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree = s
  def leaveTypeRef(scope:       TreeScope)(s: TypeRef):       TypeRef       = s

  final def visitClassTree(scope: TreeScope)(s: ClassTree): ClassTree = {
    val transformed =
      enterClassTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        tparams  = transformed.tparams map visitTypeParamTree(childrenScope),
        parents  = transformed.parents map visitTypeRef(childrenScope),
        ctors    = transformed.ctors map visitCtorTree(childrenScope),
        members  = transformed.members map visitTree(childrenScope),
        comments = transformed.comments,
      )

    leaveClassTree(scope)(updatedChildren)
  }

  final def visitCtorTree(scope: TreeScope)(s: CtorTree): CtorTree = {
    val transformed =
      enterCtorTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(params = transformed.params map visitParamTree(childrenScope), comments = transformed.comments)

    leaveCtorTree(scope)(updatedChildren)
  }

  final def visitFieldTree(scope: TreeScope)(s: FieldTree): FieldTree = {
    val transformed =
      enterFieldTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(tpe = visitTypeRef(childrenScope)(transformed.tpe), comments = transformed.comments)

    leaveFieldTree(scope)(updatedChildren)
  }

  final def visitMethodTree(scope: TreeScope)(s: MethodTree): MethodTree = {
    val transformed =
      enterMethodTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        tparams    = transformed.tparams map visitTypeParamTree(childrenScope),
        params     = transformed.params.map(_.map(visitParamTree(childrenScope))),
        resultType = visitTypeRef(childrenScope)(transformed.resultType),
        comments   = transformed.comments,
      )

    leaveMethodTree(scope)(updatedChildren)
  }

  final def visitModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree = {
    val transformed =
      enterModuleTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        parents  = transformed.parents map visitTypeRef(childrenScope),
        members  = transformed.members map visitTree(childrenScope),
        comments = transformed.comments,
      )

    leaveModuleTree(scope)(updatedChildren)
  }

  final def visitPackageTree(scope: TreeScope)(s: PackageTree): PackageTree = {
    val transformed =
      enterPackageTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        members  = transformed.members map visitTree(childrenScope),
        comments = transformed.comments,
      )

    leavePackageTree(scope)(updatedChildren)
  }

  final def visitParamTree(scope: TreeScope)(s: ParamTree): ParamTree = {
    val transformed =
      enterParamTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(tpe = visitTypeRef(childrenScope)(transformed.tpe), comments = transformed.comments)

    leaveParamTree(scope)(updatedChildren)
  }

  final def visitTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree = {
    val transformed =
      enterTypeAliasTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        tparams  = transformed.tparams map visitTypeParamTree(childrenScope),
        alias    = visitTypeRef(childrenScope)(transformed.alias),
        comments = transformed.comments,
      )

    leaveTypeAliasTree(scope)(updatedChildren)
  }

  final def visitTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree = {
    val transformed =
      enterTypeParamTree(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        upperBound = transformed.upperBound map visitTypeRef(childrenScope),
        comments   = transformed.comments,
      )

    leaveTypeParamTree(scope)(updatedChildren)
  }

  final def visitTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = {
    val transformed =
      enterTypeRef(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(targs = transformed.targs map visitTypeRef(childrenScope), comments = transformed.comments)

    leaveTypeRef(scope)(updatedChildren)
  }

  final def visitContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
    leaveContainerTree(scope / s)(
      enterContainerTree(scope / s)(s) match {
        case x: PackageTree => visitPackageTree(scope)(x)
        case x: ModuleTree  => visitModuleTree(scope)(x)
      },
    )

  final def visitMemberTree(scope: TreeScope)(s: MemberTree): MemberTree =
    leaveMemberTree(scope / s)(enterMemberTree(scope / s)(s) match {
      case x: MethodTree => visitMethodTree(scope)(x)
      case x: FieldTree  => visitFieldTree(scope)(x)
    })

  final def visitTree(scope: TreeScope)(s: Tree): Tree =
    leaveTree(scope / s)(
      enterTree(scope / s)(s) match {
        case x: ContainerTree => visitContainerTree(scope)(x)
        case x: ClassTree     => visitClassTree(scope)(x)
        case x: CtorTree      => visitCtorTree(scope)(x)
        case x: MemberTree    => visitMemberTree(scope)(x)
        case x: ParamTree     => visitParamTree(scope)(x)
        case x: TypeAliasTree => visitTypeAliasTree(scope)(x)
        case x: TypeParamTree => visitTypeParamTree(scope)(x)
        case x: TypeRef       => visitTypeRef(scope)(x)
      },
    )

  final def >>(that: TreeTransformation): TreeTransformation =
    new TreeTransformation {
      override def enterClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
        that.enterClassTree(scope)(self.enterClassTree(scope)(s))
      override def enterContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
        that.enterContainerTree(scope)(self.enterContainerTree(scope)(s))
      override def enterCtorTree(scope: TreeScope)(s: CtorTree): CtorTree =
        that.enterCtorTree(scope)(self.enterCtorTree(scope)(s))
      override def enterFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
        that.enterFieldTree(scope)(self.enterFieldTree(scope)(s))
      override def enterMemberTree(scope: TreeScope)(s: MemberTree): MemberTree =
        that.enterMemberTree(scope)(self.enterMemberTree(scope)(s))
      override def enterMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
        that.enterMethodTree(scope)(self.enterMethodTree(scope)(s))
      override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
        that.enterModuleTree(scope)(self.enterModuleTree(scope)(s))
      override def enterPackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
        that.enterPackageTree(scope)(self.enterPackageTree(scope)(s))
      override def enterParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
        that.enterParamTree(scope)(self.enterParamTree(scope)(s))
      override def enterTree(scope: TreeScope)(s: Tree): Tree =
        that.enterTree(scope)(self.enterTree(scope)(s))
      override def enterTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree =
        that.enterTypeAliasTree(scope)(self.enterTypeAliasTree(scope)(s))
      override def enterTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree =
        that.enterTypeParamTree(scope)(self.enterTypeParamTree(scope)(s))
      override def enterTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
        that.enterTypeRef(scope)(self.enterTypeRef(scope)(s))
      override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
        that.leaveClassTree(scope)(self.leaveClassTree(scope)(s))
      override def leaveContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
        that.leaveContainerTree(scope)(self.leaveContainerTree(scope)(s))
      override def leaveCtorTree(scope: TreeScope)(s: CtorTree): CtorTree =
        that.leaveCtorTree(scope)(self.leaveCtorTree(scope)(s))
      override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
        that.leaveFieldTree(scope)(self.leaveFieldTree(scope)(s))
      override def leaveMemberTree(scope: TreeScope)(s: MemberTree): MemberTree =
        that.leaveMemberTree(scope)(self.leaveMemberTree(scope)(s))
      override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
        that.leaveMethodTree(scope)(self.leaveMethodTree(scope)(s))
      override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
        that.leaveModuleTree(scope)(self.leaveModuleTree(scope)(s))
      override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
        that.leavePackageTree(scope)(self.leavePackageTree(scope)(s))
      override def leaveParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
        that.leaveParamTree(scope)(self.leaveParamTree(scope)(s))
      override def leaveTree(scope: TreeScope)(s: Tree): Tree =
        that.leaveTree(scope)(self.leaveTree(scope)(s))
      override def leaveTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree =
        that.leaveTypeAliasTree(scope)(self.leaveTypeAliasTree(scope)(s))
      override def leaveTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree =
        that.leaveTypeParamTree(scope)(self.leaveTypeParamTree(scope)(s))
      override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
        that.leaveTypeRef(scope)(self.leaveTypeRef(scope)(s))
    }
}
