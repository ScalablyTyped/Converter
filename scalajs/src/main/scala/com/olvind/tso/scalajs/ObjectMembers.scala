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
        MethodTree(Nil, Default, Name("getClass"), Nil, Seq(Seq()), MemberImplNative, TypeRef(QualifiedName(Name.java :: Name.lang :: Name("Class") :: Nil), Nil, NoComments), false, NoComments, QualifiedName.JObject + Name("getClass")),
        MethodTree(Nil, Default, Name("hashCode"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("hashCode")),
        MethodTree(Nil, Default, Name("eq"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("eq")),
        MethodTree(Nil, Default, Name("equals"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("equals")),
        MethodTree(Nil, Default, Name("toString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments, QualifiedName.JObject + Name("toString")),
        MethodTree(Nil, Default, Name("ne"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments, QualifiedName.JObject + Name("ne")),
        MethodTree(Nil, Default, Name("notify"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("notify")),
        MethodTree(Nil, Default, Name("notifyAll"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("notifyAll")),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments), ParamTree(Name("nanos"), TypeRef.Int, None, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("wait")),
        MethodTree(Nil, Protected, Name("clone"), Nil, Seq(Seq()), MemberImplNative, TypeRef.JObject, false, NoComments, QualifiedName.JObject + Name("clone")),
        MethodTree(Nil, Protected, Name("finalize"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments, QualifiedName.JObject + Name("finalize")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.JObject
    )

  val ScalaJsObject =
    ClassTree(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodTree(Nil, Default, Name("toLocaleString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments, QualifiedName.Object + Name("toLocaleString")),
        MethodTree(Nil, Default, Name("valueOf"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Any, false, NoComments, QualifiedName.Object + Name("valueOf")),
        MethodTree(Nil, Default, Name("hasOwnProperty"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("hasOwnProperty")),
        MethodTree(Nil, Default, Name("isPrototypeOf"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.Object, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("isPrototypeOf")),
        MethodTree(Nil, Default, Name("propertyIsEnumerable"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments, QualifiedName.Object + Name("propertyIsEnumerable")),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments,
      QualifiedName.Object,
    )
  // format: on

  val members: Seq[MemberTree] =
    ScalaObject.members ++ ScalaJsObject.members

  val byName: Map[Name, Seq[MemberTree]] =
    members.groupBy(_.name)

}
