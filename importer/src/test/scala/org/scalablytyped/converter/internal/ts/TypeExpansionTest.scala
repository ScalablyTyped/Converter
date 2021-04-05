package org.scalablytyped.converter.internal.ts

import org.scalablytyped.converter.internal.{IArray, NoComments, ProtectionLevel}
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
      case TsMemberProperty(_, _, _, Some(OptionalType(_)), _, _, _) => true
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

    out.alias.shouldBe(TsTypeUnion(IArray("c", "d", "e", "f").map(str => TsTypeLiteral(TsLiteral.Str(str)))))
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
          OptionalType(
            TsTypeRef(
              NoComments,
              TsQIdent(IArray(TsIdentLibrarySimple("testing"), TsIdentSimple("Array"))),
              IArray(
                TsTypeRef(
                  NoComments,
                  TsQIdent(
                    IArray(
                      TsIdentLibrarySimple("testing"),
                      TsIdentSimple("anon"),
                      TsIdentSimple("ToJsonOutputnamestringund"),
                    ),
                  ),
                  IArray(),
                ),
              ),
            ),
          ),
        ),
        None,
        false,
        false,
      )

    out.membersByName(TsIdent("children")).shouldBe(IArray(expected))
  }

  test("bug") {
    val out = run(s"""
interface CSSProperties {
  alignContent?: number;
}

type StringOrNumberOrCallback = string | number | ((args: any) => string | number);
type VictoryStyleObject = { [K in keyof CSSProperties]: StringOrNumberOrCallback };
""").extract[TsDeclInterface]("VictoryStyleObject")

    val expected = TsMemberProperty(
      NoComments,
      ProtectionLevel.Default,
      TsIdentSimple("alignContent"),
      Some(
        OptionalType(
          TsTypeRef(
            NoComments,
            TsQIdent(IArray(TsIdentLibrarySimple("testing"), TsIdentSimple("StringOrNumberOrCallback"))),
            IArray(),
          ),
        ),
      ),
      None,
      isStatic   = false,
      isReadOnly = false,
    )

    out.membersByName(TsIdent("alignContent")).shouldBe(IArray(expected))
  }

  test("Required") {
    val out = run(s"""
type Required<T> = {
    [P in keyof T]-?: T[P];
};
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};

interface CSSProperties {
  fontFamily?: string;
  fontSize?: string;
  fontWeight?: string;
  color?: string;
}
type Test = Required<Pick<CSSProperties, 'fontFamily' | 'fontSize' | 'fontWeight' | 'color'>>
""").extract[TsDeclInterface]("Test")

    val expected = TsMemberProperty(
      NoComments,
      ProtectionLevel.Default,
      TsIdentSimple("color"),
      Some(TsTypeRef.string),
      None,
      isStatic   = false,
      isReadOnly = false,
    )

    out.membersByName(TsIdent("color")).shouldBe(IArray(expected))
  }
}
