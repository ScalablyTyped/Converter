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
        MethodTree(Nil, Default, Name("getClass"), Nil, Seq(Seq()), MemberImplNative, TypeRef(QualifiedName(Name.java :: Name.lang :: Name("Class") :: Nil), Nil, NoComments), false, NoComments),
        MethodTree(Nil, Default, Name("hashCode"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodTree(Nil, Default, Name("eq"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodTree(Nil, Default, Name("equals"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodTree(Nil, Default, Name("toString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments),
        MethodTree(Nil, Default, Name("ne"), Nil, Seq(Seq(ParamTree(Name("obj"), TypeRef.JObject, None, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodTree(Nil, Default, Name("notify"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodTree(Nil, Default, Name("notifyAll"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodTree(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamTree(Name("timeout"), TypeRef.Long, None, NoComments), ParamTree(Name("nanos"), TypeRef.Int, None, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodTree(Nil, Protected, Name("clone"), Nil, Seq(Seq()), MemberImplNative, TypeRef.JObject, false, NoComments),
        MethodTree(Nil, Protected, Name("finalize"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments)
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
        MethodTree(Nil, Default, Name("toLocaleString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments),
        MethodTree(Nil, Default, Name("valueOf"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Any, false, NoComments),
        MethodTree(Nil, Default, Name("hasOwnProperty"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
        MethodTree(Nil, Default, Name("isPrototypeOf"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.Object, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
        MethodTree(Nil, Default, Name("propertyIsEnumerable"), Nil, Seq(Seq(ParamTree(Name("v"), TypeRef.String, None, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
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
