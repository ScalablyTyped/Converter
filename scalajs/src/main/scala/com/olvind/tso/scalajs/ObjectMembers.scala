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
        MethodTree(Nil, ProtectionLevel.Default, Name("getClass"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef(QualifiedName(Name.java :: Name.lang :: Name("Class") :: Nil), Nil, NoComments), false, NoComments, QualifiedName.JObject + Name("getClass")),
        MethodTree(Nil, ProtectionLevel.Default, Name("hashCode"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("hashCode")),
        MethodTree(Nil, ProtectionLevel.Default, Name("eq"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImpl.Native, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("eq")),
        MethodTree(Nil, ProtectionLevel.Default, Name("equals"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImpl.Native, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("equals")),
        MethodTree(Nil, ProtectionLevel.Default, Name("toString"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.String, false, NoComments, QualifiedName.JObject + Name("toString")),
        MethodTree(Nil, ProtectionLevel.Default, Name("ne"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImpl.Native, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("ne")),
        MethodTree(Nil, ProtectionLevel.Default, Name("notify"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("notify")),
        MethodTree(Nil, ProtectionLevel.Default, Name("notifyAll"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("notifyAll")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments))), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments), ParamTree(Name("nanos"), TypeRef.Int, None, NoComments))), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, ProtectionLevel.Protected, Name("clone"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.JObject, false, NoComments, QualifiedName.JObject + Name("clone")),
        MethodTree(Nil, ProtectionLevel.Protected, Name("finalize"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("finalize")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.JObject,
    )

  val ScalaJsObject =
    ClassTree(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodTree(Nil, ProtectionLevel.Default, Name("toLocaleString"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.String, false, NoComments, QualifiedName.Object + Name("toLocaleString")),
        MethodTree(Nil, ProtectionLevel.Default, Name("valueOf"), Nil, Seq(Seq()), MemberImpl.Native, TypeRef.Any, false, NoComments, QualifiedName.Object + Name("valueOf")),
        MethodTree(Nil, ProtectionLevel.Default, Name("hasOwnProperty"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("hasOwnProperty")),
        MethodTree(Nil, ProtectionLevel.Default, Name("isPrototypeOf"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.Object, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("isPrototypeOf")),
        MethodTree(Nil, ProtectionLevel.Default, Name("propertyIsEnumerable"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImpl.Native, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("propertyIsEnumerable")),
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
