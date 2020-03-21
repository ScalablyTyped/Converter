package org.scalablytyped.converter.internal
package ts
package parser

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TypeExpansionTest extends AnyFunSuite with Matchers with TypeExpansionHarness {

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
    val out = run(s"""
type Exclude<T, U> = T extends U ? never : T;
export declare type PanelMode = 'time' | 'date' | 'week' | 'month' | 'year' | 'decade';
export declare type PickerMode = Exclude<PanelMode, 'datetime' | 'decade'>;
""").extract[TsDeclEnum]("PickerMode")

    val expected = Set("time", "date", "week", "month", "year")

    out.members.map(_.name.value).toSet.shouldBe(expected)
  }

  test("circular") {
    val out = run(s"""

        interface ToJsonOutput {
            children?: Array<ToJsonOutput & { name?: string }>;
        }

        interface Array<T>{}
""").extract[TsDeclInterface]("ToJsonOutput")

    val expected =
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("children"),
        Some(
          TsTypeRef(
            NoComments,
            TsQIdent(IArray(TsIdentLibrarySimple("testing"), TsIdentSimple("Array"))),
            IArray(
              TsTypeIntersect(
                IArray(
                  TsTypeRef(
                    NoComments,
                    TsQIdent(IArray(TsIdentLibrarySimple("testing"), TsIdentSimple("ToJsonOutput"))),
                    IArray(),
                  ),
                  TsTypeRef(
                    NoComments,
                    TsQIdent(IArray(TsIdentLibrarySimple("testing"), TsIdentSimple("Anon_Name"))),
                    IArray(),
                  ),
                ),
              ),
            ),
          ),
        ),
        None,
        false,
        false,
        true,
      )

    out.membersByName(TsIdent("children")).shouldBe(IArray(expected))
  }
}
