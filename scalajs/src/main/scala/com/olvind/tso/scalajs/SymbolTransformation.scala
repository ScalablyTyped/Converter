package com.olvind.tso
package scalajs

//column-editing driven development FTW
class SymbolTransformation { self =>
  def enterClassSymbol(scope:     SymbolScope)(s: ClassSymbol):     ClassSymbol     = s
  def enterContainerSymbol(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol = s
  def enterCtorSymbol(scope:      SymbolScope)(s: CtorSymbol):      CtorSymbol      = s
  def enterFieldSymbol(scope:     SymbolScope)(s: FieldSymbol):     FieldSymbol     = s
  def enterMemberSymbol(scope:    SymbolScope)(s: MemberSymbol):    MemberSymbol    = s
  def enterMethodSymbol(scope:    SymbolScope)(s: MethodSymbol):    MethodSymbol    = s
  def enterModuleSymbol(scope:    SymbolScope)(s: ModuleSymbol):    ModuleSymbol    = s
  def enterPackageSymbol(scope:   SymbolScope)(s: PackageSymbol):   PackageSymbol   = s
  def enterParamSymbol(scope:     SymbolScope)(s: ParamSymbol):     ParamSymbol     = s
  def enterSymbol(scope:          SymbolScope)(s: Symbol):          Symbol          = s
  def enterTypeAliasSymbol(scope: SymbolScope)(s: TypeAliasSymbol): TypeAliasSymbol = s
  def enterTypeParamSymbol(scope: SymbolScope)(s: TypeParamSymbol): TypeParamSymbol = s
  def enterTypeRef(scope:         SymbolScope)(s: TypeRef):         TypeRef         = s

  def leaveClassSymbol(scope:     SymbolScope)(s: ClassSymbol):     ClassSymbol     = s
  def leaveContainerSymbol(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol = s
  def leaveCtorSymbol(scope:      SymbolScope)(s: CtorSymbol):      CtorSymbol      = s
  def leaveFieldSymbol(scope:     SymbolScope)(s: FieldSymbol):     FieldSymbol     = s
  def leaveMemberSymbol(scope:    SymbolScope)(s: MemberSymbol):    MemberSymbol    = s
  def leaveMethodSymbol(scope:    SymbolScope)(s: MethodSymbol):    MethodSymbol    = s
  def leaveModuleSymbol(scope:    SymbolScope)(s: ModuleSymbol):    ModuleSymbol    = s
  def leavePackageSymbol(scope:   SymbolScope)(s: PackageSymbol):   PackageSymbol   = s
  def leaveParamSymbol(scope:     SymbolScope)(s: ParamSymbol):     ParamSymbol     = s
  def leaveSymbol(scope:          SymbolScope)(s: Symbol):          Symbol          = s
  def leaveTypeAliasSymbol(scope: SymbolScope)(s: TypeAliasSymbol): TypeAliasSymbol = s
  def leaveTypeParamSymbol(scope: SymbolScope)(s: TypeParamSymbol): TypeParamSymbol = s
  def leaveTypeRef(scope:         SymbolScope)(s: TypeRef):         TypeRef         = s

  final def visitClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol = {
    val transformed =
      enterClassSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        tparams  = transformed.tparams map visitTypeParamSymbol(childrenScope),
        parents  = transformed.parents map visitTypeRef(childrenScope),
        ctors    = transformed.ctors map visitCtorSymbol(childrenScope),
        members  = transformed.members map visitMemberSymbol(childrenScope),
        comments = transformed.comments
      )

    leaveClassSymbol(scope)(updatedChildren)
  }

  final def visitCtorSymbol(scope: SymbolScope)(s: CtorSymbol): CtorSymbol = {
    val transformed =
      enterCtorSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(params = transformed.params map visitParamSymbol(childrenScope), comments = transformed.comments)

    leaveCtorSymbol(scope)(updatedChildren)
  }

  final def visitFieldSymbol(scope: SymbolScope)(s: FieldSymbol): FieldSymbol = {
    val transformed =
      enterFieldSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(tpe = visitTypeRef(childrenScope)(transformed.tpe), comments = transformed.comments)

    leaveFieldSymbol(scope)(updatedChildren)
  }

  final def visitMethodSymbol(scope: SymbolScope)(s: MethodSymbol): MethodSymbol = {
    val transformed =
      enterMethodSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        tparams    = transformed.tparams map visitTypeParamSymbol(childrenScope),
        params     = transformed.params.map(_.map(visitParamSymbol(childrenScope))),
        resultType = visitTypeRef(childrenScope)(transformed.resultType),
        comments   = transformed.comments
      )

    leaveMethodSymbol(scope)(updatedChildren)
  }

  final def visitModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol = {
    val transformed =
      enterModuleSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(parents  = transformed.parents map visitTypeRef(childrenScope),
                       members  = transformed.members map visitSymbol(childrenScope),
                       comments = transformed.comments)

    leaveModuleSymbol(scope)(updatedChildren)
  }

  final def visitPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol = {
    val transformed =
      enterPackageSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(
        members  = transformed.members map visitSymbol(childrenScope),
        comments = transformed.comments
      )

    leavePackageSymbol(scope)(updatedChildren)
  }

  final def visitParamSymbol(scope: SymbolScope)(s: ParamSymbol): ParamSymbol = {
    val transformed =
      enterParamSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(tpe = visitTypeRef(childrenScope)(transformed.tpe), comments = transformed.comments)

    leaveParamSymbol(scope)(updatedChildren)
  }

  final def visitTypeAliasSymbol(scope: SymbolScope)(s: TypeAliasSymbol): TypeAliasSymbol = {
    val transformed =
      enterTypeAliasSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(tparams  = transformed.tparams map visitTypeParamSymbol(childrenScope),
                       alias    = visitTypeRef(childrenScope)(transformed.alias),
                       comments = transformed.comments)

    leaveTypeAliasSymbol(scope)(updatedChildren)
  }

  final def visitTypeParamSymbol(scope: SymbolScope)(s: TypeParamSymbol): TypeParamSymbol = {
    val transformed =
      enterTypeParamSymbol(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(upperBound = transformed.upperBound map visitTypeRef(childrenScope),
                       comments   = transformed.comments)

    leaveTypeParamSymbol(scope)(updatedChildren)
  }

  final def visitTypeRef(scope: SymbolScope)(s: TypeRef): TypeRef = {
    val transformed =
      enterTypeRef(scope / s)(s)

    val childrenScope =
      scope / transformed

    val updatedChildren =
      transformed.copy(targs = transformed.targs map visitTypeRef(childrenScope), comments = transformed.comments)

    leaveTypeRef(scope)(updatedChildren)
  }

  final def visitContainerSymbol(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol =
    leaveContainerSymbol(scope)(
      enterContainerSymbol(scope)(s) match {
        case x: PackageSymbol => visitPackageSymbol(scope)(x)
        case x: ClassSymbol   => visitClassSymbol(scope)(x)
        case x: ModuleSymbol  => visitModuleSymbol(scope)(x)
      }
    )

  final def visitMemberSymbol(scope: SymbolScope)(s: MemberSymbol): MemberSymbol =
    leaveMemberSymbol(scope)(enterMemberSymbol(scope)(s) match {
      case x: MethodSymbol => visitMethodSymbol(scope)(x)
      case x: FieldSymbol  => visitFieldSymbol(scope)(x)
    })

  final def visitSymbol(scope: SymbolScope)(s: Symbol): Symbol =
    leaveSymbol(scope)(
      enterSymbol(scope)(s) match {
        case x: ContainerSymbol => visitContainerSymbol(scope)(x)
        case x: CtorSymbol      => visitCtorSymbol(scope)(x)
        case x: MemberSymbol    => visitMemberSymbol(scope)(x)
        case x: ParamSymbol     => visitParamSymbol(scope)(x)
        case x: TypeAliasSymbol => visitTypeAliasSymbol(scope)(x)
        case x: TypeParamSymbol => visitTypeParamSymbol(scope)(x)
        case x: TypeRef         => visitTypeRef(scope)(x)
      }
    )

  final def >>(that: SymbolTransformation): SymbolTransformation =
    new SymbolTransformation {
      override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
        that.enterClassSymbol(scope)(self.enterClassSymbol(scope)(s))
      override def enterContainerSymbol(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol =
        that.enterContainerSymbol(scope)(self.enterContainerSymbol(scope)(s))
      override def enterCtorSymbol(scope: SymbolScope)(s: CtorSymbol): CtorSymbol =
        that.enterCtorSymbol(scope)(self.enterCtorSymbol(scope)(s))
      override def enterFieldSymbol(scope: SymbolScope)(s: FieldSymbol): FieldSymbol =
        that.enterFieldSymbol(scope)(self.enterFieldSymbol(scope)(s))
      override def enterMemberSymbol(scope: SymbolScope)(s: MemberSymbol): MemberSymbol =
        that.enterMemberSymbol(scope)(self.enterMemberSymbol(scope)(s))
      override def enterMethodSymbol(scope: SymbolScope)(s: MethodSymbol): MethodSymbol =
        that.enterMethodSymbol(scope)(self.enterMethodSymbol(scope)(s))
      override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
        that.enterModuleSymbol(scope)(self.enterModuleSymbol(scope)(s))
      override def enterPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
        that.enterPackageSymbol(scope)(self.enterPackageSymbol(scope)(s))
      override def enterParamSymbol(scope: SymbolScope)(s: ParamSymbol): ParamSymbol =
        that.enterParamSymbol(scope)(self.enterParamSymbol(scope)(s))
      override def enterSymbol(scope: SymbolScope)(s: Symbol): Symbol =
        that.enterSymbol(scope)(self.enterSymbol(scope)(s))
      override def enterTypeAliasSymbol(scope: SymbolScope)(s: TypeAliasSymbol): TypeAliasSymbol =
        that.enterTypeAliasSymbol(scope)(self.enterTypeAliasSymbol(scope)(s))
      override def enterTypeParamSymbol(scope: SymbolScope)(s: TypeParamSymbol): TypeParamSymbol =
        that.enterTypeParamSymbol(scope)(self.enterTypeParamSymbol(scope)(s))
      override def enterTypeRef(scope: SymbolScope)(s: TypeRef): TypeRef =
        that.enterTypeRef(scope)(self.enterTypeRef(scope)(s))
      override def leaveClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
        that.leaveClassSymbol(scope)(self.leaveClassSymbol(scope)(s))
      override def leaveContainerSymbol(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol =
        that.leaveContainerSymbol(scope)(self.leaveContainerSymbol(scope)(s))
      override def leaveCtorSymbol(scope: SymbolScope)(s: CtorSymbol): CtorSymbol =
        that.leaveCtorSymbol(scope)(self.leaveCtorSymbol(scope)(s))
      override def leaveFieldSymbol(scope: SymbolScope)(s: FieldSymbol): FieldSymbol =
        that.leaveFieldSymbol(scope)(self.leaveFieldSymbol(scope)(s))
      override def leaveMemberSymbol(scope: SymbolScope)(s: MemberSymbol): MemberSymbol =
        that.leaveMemberSymbol(scope)(self.leaveMemberSymbol(scope)(s))
      override def leaveMethodSymbol(scope: SymbolScope)(s: MethodSymbol): MethodSymbol =
        that.leaveMethodSymbol(scope)(self.leaveMethodSymbol(scope)(s))
      override def leaveModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
        that.leaveModuleSymbol(scope)(self.leaveModuleSymbol(scope)(s))
      override def leavePackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
        that.leavePackageSymbol(scope)(self.leavePackageSymbol(scope)(s))
      override def leaveParamSymbol(scope: SymbolScope)(s: ParamSymbol): ParamSymbol =
        that.leaveParamSymbol(scope)(self.leaveParamSymbol(scope)(s))
      override def leaveSymbol(scope: SymbolScope)(s: Symbol): Symbol =
        that.leaveSymbol(scope)(self.leaveSymbol(scope)(s))
      override def leaveTypeAliasSymbol(scope: SymbolScope)(s: TypeAliasSymbol): TypeAliasSymbol =
        that.leaveTypeAliasSymbol(scope)(self.leaveTypeAliasSymbol(scope)(s))
      override def leaveTypeParamSymbol(scope: SymbolScope)(s: TypeParamSymbol): TypeParamSymbol =
        that.leaveTypeParamSymbol(scope)(self.leaveTypeParamSymbol(scope)(s))
      override def leaveTypeRef(scope: SymbolScope)(s: TypeRef): TypeRef =
        that.leaveTypeRef(scope)(self.leaveTypeRef(scope)(s))
    }
}
