package org.scalablytyped.converter.internal
package scalajs

object ObjectMembers {
  // format: off
  val ScalaObject =
    ClassTree(
      Empty,
      Name.Object,
      Empty,
      Empty,
      Empty,
      IArray(
        MethodTree(Empty, ProtectionLevel.Default, Name("getClass"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef(QualifiedName(IArray(Name.java, Name.lang, Name("Class"))), Empty, NoComments), isOverride = false, NoComments, QualifiedName.ScalaAny + Name("getClass")),
        MethodTree(Empty, ProtectionLevel.Default, Name("hashCode"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("hashCode")),
        MethodTree(Empty, ProtectionLevel.Default, Name("eq"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("eq")),
        MethodTree(Empty, ProtectionLevel.Default, Name("equals"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("equals")),
        MethodTree(Empty, ProtectionLevel.Default, Name("toString"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.String, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("toString")),
        MethodTree(Empty, ProtectionLevel.Default, Name("ne"), Empty, IArray(IArray(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("ne")),
        MethodTree(Empty, ProtectionLevel.Default, Name("notify"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("notify")),
        MethodTree(Empty, ProtectionLevel.Default, Name("notifyAll"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("notifyAll")),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray(ParamTree(Name("timeout"), isImplicit = false, TypeRef.Long, None, NoComments))), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Empty, ProtectionLevel.Default, Name("wait"), Empty, IArray(IArray(ParamTree(Name("timeout"), isImplicit = false, TypeRef.Long, None, NoComments), ParamTree(Name("nanos"), isImplicit = false, TypeRef.Int, None, NoComments))), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Empty, ProtectionLevel.Protected, Name("clone"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.ScalaAny, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("clone")),
        MethodTree(Empty, ProtectionLevel.Protected, Name("finalize"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("finalize")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.ScalaAny,
    )

  val ScalaJsObject =
    ClassTree(
      Empty,
      Name.Object,
      Empty,
      Empty,
      Empty,
      IArray(
        MethodTree(Empty, ProtectionLevel.Default, Name("toLocaleString"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.String, isOverride = false, NoComments, QualifiedName.Object + Name("toLocaleString")),
        MethodTree(Empty, ProtectionLevel.Default, Name("valueOf"), Empty, IArray(IArray()), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Object + Name("valueOf")),
        MethodTree(Empty, ProtectionLevel.Default, Name("hasOwnProperty"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("hasOwnProperty")),
        MethodTree(Empty, ProtectionLevel.Default, Name("isPrototypeOf"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, TypeRef.Object, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("isPrototypeOf")),
        MethodTree(Empty, ProtectionLevel.Default, Name("propertyIsEnumerable"), Empty, IArray(IArray(ParamTree(Name("v"), isImplicit = false, TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("propertyIsEnumerable")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Object,
    )
  // format: on

  val members: IArray[Tree] =
    ScalaObject.members ++ ScalaJsObject.members

  val byName: Map[Name, IArray[Tree]] =
    members.groupBy(_.name)

}
