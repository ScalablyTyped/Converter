package com.olvind.tso
package scalajs

import org.scalatest.FunSuite

class OptionalTest extends FunSuite {

  test("works") {
//    TypeRef.UndefOr(TypeRef.Any) match {
//      case IsOptional.undefined(TypeRef.Any) => //ok
//    }

    TypeRef.Union(List(TypeRef.Any, TypeRef.Null, Optional.UndefinedMarker), sort = false) match {
      case Optional.IsNullableAndUndefined(TypeRef.Any) =>

    }

//    TypeRef.UndefOr(TypeRef.Union(List(TypeRef.String, TypeRef.Any), sort = false)) match {
//      case IsOptional.undefined(TypeRef.Union(List(TypeRef.String, TypeRef.Any))) => //ok
//    }

  }
}
