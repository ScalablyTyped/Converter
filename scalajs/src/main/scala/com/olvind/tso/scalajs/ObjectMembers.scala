package com.olvind.tso
package scalajs

object ObjectMembers {
  // format: off
  val ScalaObject =
    ClassTree(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodTree(Nil, ProtectionLevel.Default, Name("getClass"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef(QualifiedName(Name.java :: Name.lang :: Name("Class") :: Nil), Nil, NoComments), isOverride = false, NoComments, QualifiedName.ScalaAny + Name("getClass")),
        MethodTree(Nil, ProtectionLevel.Default, Name("hashCode"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("hashCode")),
        MethodTree(Nil, ProtectionLevel.Default, Name("eq"), Nil, Seq(Seq(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("eq")),
        MethodTree(Nil, ProtectionLevel.Default, Name("equals"), Nil, Seq(Seq(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("equals")),
        MethodTree(Nil, ProtectionLevel.Default, Name("toString"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.String, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("toString")),
        MethodTree(Nil, ProtectionLevel.Default, Name("ne"), Nil, Seq(Seq(ParamTree(Name("obj"), isImplicit = false, TypeRef.ScalaAny, None, NoComments))), MemberImpl.Native, TypeRef.Int, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("ne")),
        MethodTree(Nil, ProtectionLevel.Default, Name("notify"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("notify")),
        MethodTree(Nil, ProtectionLevel.Default, Name("notifyAll"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("notifyAll")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), isImplicit = false, TypeRef.Long, None, NoComments))), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), isImplicit = false, TypeRef.Long, None, NoComments), ParamTree(Name("nanos"), isImplicit = false, TypeRef.Int, None, NoComments))), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Protected, Name("clone"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.ScalaAny, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("clone")),
        MethodTree(Nil, ProtectionLevel.Protected, Name("finalize"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, isOverride = false, NoComments, QualifiedName.ScalaAny + Name("finalize")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.ScalaAny,
    )

  val ScalaJsObject =
    ClassTree(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodTree(Nil, ProtectionLevel.Default, Name("toLocaleString"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.String, isOverride = false, NoComments, QualifiedName.Object + Name("toLocaleString")),
        MethodTree(Nil, ProtectionLevel.Default, Name("valueOf"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Any, isOverride = false, NoComments, QualifiedName.Object + Name("valueOf")),
        MethodTree(Nil, ProtectionLevel.Default, Name("hasOwnProperty"), Nil, Seq(Seq(ParamTree(Name("v"), isImplicit = false, TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("hasOwnProperty")),
        MethodTree(Nil, ProtectionLevel.Default, Name("isPrototypeOf"), Nil, Seq(Seq(ParamTree(Name("v"), isImplicit = false, TypeRef.Object, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("isPrototypeOf")),
        MethodTree(Nil, ProtectionLevel.Default, Name("propertyIsEnumerable"), Nil, Seq(Seq(ParamTree(Name("v"), isImplicit = false, TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, isOverride = false, NoComments, QualifiedName.Object + Name("propertyIsEnumerable")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Object,
    )
  // format: on

  val members: Seq[Tree] =
    ScalaObject.members ++ ScalaJsObject.members

  val byName: Map[Name, Seq[Tree]] =
    members.groupBy(_.name)

}
