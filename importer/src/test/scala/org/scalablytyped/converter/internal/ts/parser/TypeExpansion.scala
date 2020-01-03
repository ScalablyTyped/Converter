package org.scalablytyped.converter.internal.ts
package parser

import org.scalatest.{FunSuite, Matchers}

class TypeExpansion extends FunSuite with Matchers with TypeExpansionHarness {

  test("Partial") {

    val out = run(s"""
type Partial<T> = {
    [P in keyof T]?: T[P];
};
interface A {
  a: number
  b: number | null,
  c: number | null | undefined,
  d?: number
  e?: number | null,
  f?: number | null | undefined
}
type AA = Partial<A>
""").extract[TsDeclInterface]("AA")

    val isOptionals = out.members.collect { case TsMemberProperty(_, _, _, _, _, _, _, isOptional) => isOptional }

    isOptionals.shouldBe(List(true, true, true, true, true, true))
  }

  test("OptionalKey") {
    pending
    val out = run(s"""
    type OptionalKey<T> = { [K in keyof T]-?: undefined extends T[K] ? K : never }[keyof T];
    interface A {
      a: number
      b: number | null,
      c: number | null | undefined,
      d?: number
      e?: number | null,
      f?: number | null | undefined
    }
    type Ta = OptionalKey<A>
""").extract[TsDeclTypeAlias]("Ta")

    out.alias.shouldBe(TsTypeUnion(List("c", "d", "e", "f").map(str => TsTypeLiteral(TsLiteralString(str)))))
  }
}
