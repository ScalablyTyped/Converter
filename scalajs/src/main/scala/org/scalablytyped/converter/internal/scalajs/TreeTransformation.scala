package org.scalablytyped.converter.internal
package scalajs

//column-editing driven development FTW
class TreeTransformation { self =>
  def leaveClassTree(scope:     TreeScope)(s: ClassTree):     ClassTree     = s
  def leaveContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree = s
  def leaveCtorTree(scope:      TreeScope)(s: CtorTree):      CtorTree      = s
  def leaveExprTree(scope:      TreeScope)(s: ExprTree):      ExprTree      = s
  def leaveExprRefTree(scope:   TreeScope)(s: ExprTree.Ref):  ExprTree.Ref  = s
  def leaveFieldTree(scope:     TreeScope)(s: FieldTree):     FieldTree     = s
  def leaveImplTree(scope:      TreeScope)(s: ImplTree):      ImplTree      = s
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
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        tparams = s.tparams.map(visitTypeParamTree(childrenScope)),
        parents = s.parents.map(visitTypeRef(childrenScope)),
        ctors   = s.ctors.map(visitCtorTree(childrenScope)),
        members = s.members.map(visitTree(childrenScope)),
      )

    leaveClassTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitCtorTree(scope: TreeScope)(s: CtorTree): CtorTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(params = s.params.map(visitParamTree(childrenScope)))

    leaveCtorTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitFieldTree(scope: TreeScope)(s: FieldTree): FieldTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        tpe  = visitTypeRef(childrenScope)(s.tpe),
        impl = visitImplTree(childrenScope)(s.impl),
      )

    leaveFieldTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitExprTree(scope: TreeScope)(s: ExprTree): ExprTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s match {
        case ExprTree.undefined =>
          ExprTree.undefined
        case ExprTree.Null =>
          ExprTree.Null
        case ExprTree.`:_*`(e) =>
          ExprTree.`:_*`(visitExprTree(childrenScope)(e))
        case ExprTree.Val(name, value) =>
          ExprTree.Val(name, visitExprTree(childrenScope)(value))
        case ExprTree.Throw(expr) =>
          ExprTree.Throw(visitExprTree(childrenScope)(expr))
        case ExprTree.TApply(ref, targs) =>
          ExprTree.TApply(
            visitExprTree(childrenScope)(ref),
            targs.map(visitTypeRef(childrenScope)),
          )
        case ExprTree.If(pred, ifTrue, ifFalse) =>
          ExprTree.If(
            visitExprTree(childrenScope)(pred),
            visitExprTree(childrenScope)(ifTrue),
            ifFalse.map(visitExprTree(childrenScope)),
          )
        case ExprTree.Block(expressions) => ExprTree.Block(expressions.map(visitExprTree(childrenScope)))
        case ExprTree.Select(from, path) => ExprTree.Select(visitExprTree(childrenScope)(from), path)
        case ExprTree.Call(function, params) =>
          ExprTree.Call(
            visitExprTree(childrenScope)(function),
            params.map(_.map(visitExprTree(childrenScope))),
          )
        case ExprTree.Unary(op, expr) =>
          ExprTree.Unary(op, visitExprTree(childrenScope)(expr))
        case ExprTree.BinaryOp(one, op, two) =>
          ExprTree.BinaryOp(visitExprTree(childrenScope)(one), op, visitExprTree(childrenScope)(two))
        case ExprTree.New(expr, params) =>
          ExprTree.New(visitTypeRef(childrenScope)(expr), params.map(visitExprTree(childrenScope)))
        case ExprTree.Lambda(params, body) =>
          ExprTree.Lambda(params.map(visitParamTree(childrenScope)), visitExprTree(childrenScope)(body))
        case ExprTree.Arg.Named(name, expr) =>
          ExprTree.Arg.Named(name, visitExprTree(childrenScope)(expr))
        case ExprTree.Arg.Pos(expr) =>
          ExprTree.Arg.Pos(visitExprTree(childrenScope)(expr))
        case ExprTree.Arg.Variable(expr) =>
          ExprTree.Arg.Variable(visitExprTree(childrenScope)(expr))
        case x: ExprTree.Ref        => x
        case x: ExprTree.NumberLit  => x
        case x: ExprTree.StringLit  => x
        case x: ExprTree.BooleanLit => x

      }

    leaveExprTree(scope)(updatedChildren)
  }

  final def visitExprRefTree(scope: TreeScope)(s: ExprTree.Ref): ExprTree.Ref = {
    val childrenScope = scope / s
    leaveExprRefTree(childrenScope)(s)
  }

  final def visitMethodTree(scope: TreeScope)(s: MethodTree): MethodTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        tparams    = s.tparams.map(visitTypeParamTree(childrenScope)),
        params     = s.params.map(_.map(visitParamTree(childrenScope))),
        impl       = visitImplTree(childrenScope)(s.impl),
        resultType = visitTypeRef(childrenScope)(s.resultType),
      )

    leaveMethodTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        parents = s.parents.map(visitTypeRef(childrenScope)),
        members = s.members.map(visitTree(childrenScope)),
      )

    leaveModuleTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitPackageTree(scope: TreeScope)(s: PackageTree): PackageTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        members = s.members.map(visitTree(childrenScope)),
      )

    leavePackageTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitParamTree(scope: TreeScope)(s: ParamTree): ParamTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        tpe     = visitTypeRef(childrenScope)(s.tpe),
        default = visitImplTree(childrenScope)(s.default),
      )

    leaveParamTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        tparams = s.tparams.map(visitTypeParamTree(childrenScope)),
        alias   = visitTypeRef(childrenScope)(s.alias),
      )

    leaveTypeAliasTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitTypeParamTree(scope: TreeScope)(s: TypeParamTree): TypeParamTree = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(
        upperBound = s.upperBound.map(visitTypeRef(childrenScope)),
        params     = s.params.map(visitTypeParamTree(childrenScope)),
      )

    leaveTypeParamTree(scope / updatedChildren)(updatedChildren)
  }

  final def visitTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = {
    val childrenScope =
      scope / s

    val updatedChildren =
      s.copy(targs = s.targs.map(visitTypeRef(childrenScope)))

    leaveTypeRef(scope / updatedChildren)(updatedChildren)
  }

  final def visitContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
    leaveContainerTree(scope / s)(
      s match {
        case x: PackageTree => visitPackageTree(scope)(x)
        case x: ModuleTree  => visitModuleTree(scope)(x)
      },
    )

  final def visitImplTree(scope: TreeScope)(s: ImplTree): ImplTree =
    leaveImplTree(scope)(s match {
      case NotImplemented => NotImplemented
      case expr: ExprTree => visitExprTree(scope)(expr)
    })

  final def visitMemberTree(scope: TreeScope)(s: MemberTree): MemberTree =
    leaveMemberTree(scope / s)(s match {
      case x: MethodTree => visitMethodTree(scope)(x)
      case x: FieldTree  => visitFieldTree(scope)(x)
    })

  final def visitTree(scope: TreeScope)(s: Tree): Tree =
    leaveTree(scope / s)(
      s match {
        case x: ContainerTree => visitContainerTree(scope)(x)
        case x: ClassTree     => visitClassTree(scope)(x)
        case x: CtorTree      => visitCtorTree(scope)(x)
        case x: ImplTree      => visitImplTree(scope)(x)
        case x: MemberTree    => visitMemberTree(scope)(x)
        case x: ParamTree     => visitParamTree(scope)(x)
        case x: TypeAliasTree => visitTypeAliasTree(scope)(x)
        case x: TypeParamTree => visitTypeParamTree(scope)(x)
        case x: TypeRef       => visitTypeRef(scope)(x)
      },
    )

  final def >>(that: TreeTransformation): TreeTransformation =
    new TreeTransformation {
      override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
        that.leaveClassTree(scope)(self.leaveClassTree(scope)(s))
      override def leaveContainerTree(scope: TreeScope)(s: ContainerTree): ContainerTree =
        that.leaveContainerTree(scope)(self.leaveContainerTree(scope)(s))
      override def leaveCtorTree(scope: TreeScope)(s: CtorTree): CtorTree =
        that.leaveCtorTree(scope)(self.leaveCtorTree(scope)(s))
      override def leaveExprTree(scope: TreeScope)(s: ExprTree): ExprTree =
        that.leaveExprTree(scope)(self.leaveExprTree(scope)(s))
      override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
        that.leaveFieldTree(scope)(self.leaveFieldTree(scope)(s))
      override def leaveImplTree(scope: TreeScope)(s: ImplTree): ImplTree =
        that.leaveImplTree(scope)(self.leaveImplTree(scope)(s))
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
