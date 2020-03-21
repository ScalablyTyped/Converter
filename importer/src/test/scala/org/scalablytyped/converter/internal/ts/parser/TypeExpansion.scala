package org.scalablytyped.converter.internal
package ts
package parser

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TypeExpansion extends AnyFunSuite with Matchers with TypeExpansionHarness {

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

    val isOptionals = out.members.collect[java.lang.Boolean] {
      case TsMemberProperty(_, _, _, _, _, _, _, isOptional) => isOptional
    }

    isOptionals.shouldBe(IArray[java.lang.Boolean](true, true, true, true, true, true))
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

    out.alias.shouldBe(TsTypeUnion(IArray("c", "d", "e", "f").map(str => TsTypeLiteral(TsLiteralString(str)))))
  }

  test("Except from union type") {
    pending
    val out = run(s"""
type Exclude<T, U> = T extends U ? never : T;
export declare type PanelMode = 'time' | 'date' | 'week' | 'month' | 'year' | 'decade';
export declare type PickerMode = Exclude<PanelMode, 'datetime' | 'decade'>;
""").extract[TsDeclTypeAlias]("PickerMode")

    val Out = IArray("time", "date", "week", "month", "year").map(x => TsTypeLiteral(TsLiteralString(x)))
    out.alias.shouldBe(TsTypeUnion(Out))
  }
}
