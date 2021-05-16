package org.scalablytyped.converter.internal
package scalajs

object ObjectMembers {
  // format: off
  val ScalaObject =
    ClassTree(
      isImplicit = false,
      Empty,
      Name.Object,
      Empty,
      Empty,
      Empty,
      IArray(
        MethodTree(Empty, ProtectionLevel.Default, Name("getClass"), Empty, IArray(IArray()), ExprTree.native, TypeRef(QualifiedName(IArray(Name.java, Name.lang, Name("Class"))), Empty, NoComments), isOverride = false, NoComments, QualifiedName.Any + Name("getClass"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("hashCode"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.Any + Name("hashCode"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("eq"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments))), ExprTree.native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.Any + Name("eq"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("equals"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments))), ExprTree.native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.Any + Name("equals"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("toString"), Empty, IArray(IArray()), ExprTree.native, TypeRef.String, isOverride = false, NoComments, QualifiedName.Any + Name("toString"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("ne"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, isVal = false, TypeRef.Any, NotImplemented, NoComments))), ExprTree.native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.Any + Name("ne"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("notify"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("notify"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("notifyAll"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("notifyAll"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("wait"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray(ParamTree(Name("timeout"), isImplicit = false, isVal = false, TypeRef.Long, NotImplemented, NoComments))), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("wait"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray(ParamTree(Name("timeout"), isImplicit = false, isVal = false, TypeRef.Long, NotImplemented, NoComments), ParamTree(Name("nanos"), isImplicit = false, isVal = false, TypeRef.Int, NotImplemented, NoComments))), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("wait"), false),
        MethodTree(Empty, ProtectionLevel.Protected, Name("clone"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Any + Name("clone"), false),
        MethodTree(Empty, ProtectionLevel.Protected, Name("finalize"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.Any + Name("finalize"), false),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Any,
    )

  val ScalaJsObject =
    ClassTree(
      isImplicit = false,Empty,
      Name.Object,
      Empty,
      Empty,
      Empty,
      IArray(
        MethodTree(Empty, ProtectionLevel.Default, Name("toLocaleString"), Empty, IArray(IArray()), ExprTree.native, TypeRef.String, isOverride = false, NoComments, QualifiedName.JsObject + Name("toLocaleString"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("valueOf"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.JsObject + Name("valueOf"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("hasOwnProperty"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("hasOwnProperty"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("isPrototypeOf"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.JsObject, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("isPrototypeOf"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("propertyIsEnumerable"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("propertyIsEnumerable"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("toLocaleString"), Empty, IArray(IArray()), ExprTree.native, TypeRef.String, isOverride = false, NoComments, QualifiedName.JsObject + Name("toLocaleString"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("valueOf"), Empty, IArray(IArray()), ExprTree.native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.JsObject + Name("valueOf"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("hasOwnProperty"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("hasOwnProperty"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("isPrototypeOf"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.JsObject, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("isPrototypeOf"), false),
        MethodTree(Empty, ProtectionLevel.Default, Name("propertyIsEnumerable"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, isVal = false, TypeRef.String, NotImplemented, NoComments))), ExprTree.native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.JsObject + Name("propertyIsEnumerable"), false),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.JsObject,
    )
  // format: on

  val members: IArray[Tree] =
    ScalaObject.members ++ ScalaJsObject.members

  val byName: Map[Name, IArray[Tree]] =
    members.groupBy(_.name)

}
