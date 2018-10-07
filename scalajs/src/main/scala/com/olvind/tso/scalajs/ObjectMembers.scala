package com.olvind.tso
package scalajs

object ObjectMembers {
  // format: off
  val ScalaObject =
    ClassSymbol(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodSymbol(Nil, Default, Name("getClass"), Nil, Seq(Seq()), MemberImplNative, TypeRef(QualifiedName(Name.java :: Name.lang :: Name("Class") :: Nil), Nil, NoComments), false, NoComments),
        MethodSymbol(Nil, Default, Name("hashCode"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodSymbol(Nil, Default, Name("eq"), Nil, Seq(Seq(ParamSymbol(Name("obj"), TypeRef.JObject, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodSymbol(Nil, Default, Name("equals"), Nil, Seq(Seq(ParamSymbol(Name("obj"), TypeRef.JObject, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodSymbol(Nil, Default, Name("toString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments),
        MethodSymbol(Nil, Default, Name("ne"), Nil, Seq(Seq(ParamSymbol(Name("obj"), TypeRef.JObject, NoComments))), MemberImplNative, TypeRef.Int, false, NoComments),
        MethodSymbol(Nil, Default, Name("notify"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodSymbol(Nil, Default, Name("notifyAll"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodSymbol(Nil, Default, Name("wait"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodSymbol(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamSymbol(Name("timeout"), TypeRef.Long, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodSymbol(Nil, Default, Name("wait"), Nil, Seq(Seq(ParamSymbol(Name("timeout"), TypeRef.Long, NoComments), ParamSymbol(Name("nanos"), TypeRef.Int, NoComments))), MemberImplNative, TypeRef.Unit, false, NoComments),
        MethodSymbol(Nil, Protected, Name("clone"), Nil, Seq(Seq()), MemberImplNative, TypeRef.JObject, false, NoComments),
        MethodSymbol(Nil, Protected, Name("finalize"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Unit, false, NoComments)
      ),
      ClassType.Class,
      isSealed = false,
      NoComments
    )

  val ScalaJsObject =
    ClassSymbol(
      Nil,
      Name.Object,
      Nil,
      Nil,
      Nil,
      Seq(
        MethodSymbol(Nil, Default, Name("toLocaleString"), Nil, Seq(Seq()), MemberImplNative, TypeRef.String, false, NoComments),
        MethodSymbol(Nil, Default, Name("valueOf"), Nil, Seq(Seq()), MemberImplNative, TypeRef.Any, false, NoComments),
        MethodSymbol(Nil, Default, Name("hasOwnProperty"), Nil, Seq(Seq(ParamSymbol(Name("v"), TypeRef.String, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
        MethodSymbol(Nil, Default, Name("isPrototypeOf"), Nil, Seq(Seq(ParamSymbol(Name("v"), TypeRef.Object, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
        MethodSymbol(Nil, Default, Name("propertyIsEnumerable"), Nil, Seq(Seq(ParamSymbol(Name("v"), TypeRef.String, NoComments))), MemberImplNative, TypeRef.Boolean, false, NoComments),
      ),
      ClassType.Class,
      isSealed = false,
      NoComments
    )
  // format: on

  val members: Seq[MemberSymbol] =
    ScalaObject.members ++ ScalaJsObject.members

  val byName: Map[Name, Seq[MemberSymbol]] =
    members.groupBy(_.name)

}
