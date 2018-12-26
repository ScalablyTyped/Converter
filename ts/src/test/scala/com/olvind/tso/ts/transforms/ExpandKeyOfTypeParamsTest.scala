package com.olvind.tso.ts
package transforms

import com.olvind.logging
import com.olvind.tso.{Default, DiffingAssertions, NoComments}
import com.olvind.tso.ParserHarness._
import com.olvind.tso.ts.parser.TsParser
import org.scalatest.FunSuite

class ExpandKeyOfTypeParamsTest extends FunSuite with DiffingAssertions {
  test("work") {
    val original =
      TsParser("""
  
  interface HTMLElementTagNameMap {
      "a": HTMLAnchorElement;
  }
  
  interface ElementTagNameMap extends HTMLElementTagNameMap {
      "abbr": HTMLElement;
  }
  
  type ElementListTagNameMap = {
      [key in keyof ElementTagNameMap]: NodeListOf<ElementTagNameMap[key]>
  };
  
  interface NodeSelector {
      querySelector<K extends keyof ElementTagNameMap>(selectors: K): ElementTagNameMap[K] | null;
      querySelector(selectors: string): Element | null;
//      querySelectorAll<K extends keyof ElementListTagNameMap>(selectors: K): ElementListTagNameMap[K];
//      querySelectorAll(selectors: string): NodeListOf<Element>;
  }
  """).force

    val scope     = TsTreeScope(TsIdent.dummy, pedantic = true, Map.empty, logging.stdout)
    val rewritten = ExpandKeyOfTypeParams.visitTsParsedFile(scope)(original)

    val NodeSelectorActual = rewritten.members.collectFirst {
      case x: TsDeclInterface if x.name.value === "NodeSelector" => x
    }.get

    val NodeSelectorExpected =
      TsDeclInterface(
        NoComments,
        false,
        TsIdentSimple("NodeSelector"),
        List(),
        List(),
        List(
          TsMemberFunction(
            NoComments,
            Default,
            TsIdentSimple("querySelector"),
            TsFunSig(
              NoComments,
              List(),
              List(
                TsFunParam(NoComments, TsIdentSimple("selectors"), Some(TsTypeLiteral(TsLiteralString("abbr"))), false)
              ),
              Some(
                TsTypeUnion(
                  List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("HTMLElement"))), List()),
                       TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("null"))), List()))
                )
              )
            ),
            false,
            false,
            false
          ),
          TsMemberFunction(
            NoComments,
            Default,
            TsIdentSimple("querySelector"),
            TsFunSig(
              NoComments,
              List(),
              List(
                TsFunParam(NoComments, TsIdentSimple("selectors"), Some(TsTypeLiteral(TsLiteralString("a"))), false)
              ),
              Some(
                TsTypeUnion(
                  List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("HTMLAnchorElement"))), List()),
                       TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("null"))), List()))
                )
              )
            ),
            false,
            false,
            false
          ),
          TsMemberFunction(
            NoComments,
            Default,
            TsIdentSimple("querySelector"),
            TsFunSig(
              NoComments,
              List(),
              List(
                TsFunParam(NoComments,
                           TsIdentSimple("selectors"),
                           Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("string"))), List())),
                           false)
              ),
              Some(
                TsTypeUnion(
                  List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Element"))), List()),
                       TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("null"))), List()))
                )
              )
            ),
            false,
            false,
            false
          ),
//          TsMemberFunction(
//            NoComments,
//            Default,
//            TsIdentSimple("querySelectorAll"),
//            TsFunSig(
//              NoComments,
//              List(),
//              List(
//                TsFunParam(NoComments, TsIdentSimple("selectors"), Some(TsTypeLiteral(TsLiteralString("abbr"))), false)
//              ),
//              Some(
//                TsTypeRef(NoComments,
//                          TsQIdent(List(TsIdentSimple("NodeListOf"))),
//                          List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("HTMLElement"))), List())))
//              )
//            ),
//            false,
//            false,
//            false
//          ),
//          TsMemberFunction(
//            NoComments,
//            Default,
//            TsIdentSimple("querySelectorAll"),
//            TsFunSig(
//              NoComments,
//              List(),
//              List(
//                TsFunParam(NoComments, TsIdentSimple("selectors"), Some(TsTypeLiteral(TsLiteralString("a"))), false)
//              ),
//              Some(
//                TsTypeRef(NoComments,
//                          TsQIdent(List(TsIdentSimple("NodeListOf"))),
//                          List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("HTMLAnchorElement"))), List())))
//              )
//            ),
//            false,
//            false,
//            false
//          ),
//          TsMemberFunction(
//            NoComments,
//            Default,
//            TsIdentSimple("querySelectorAll"),
//            TsFunSig(
//              NoComments,
//              List(),
//              List(
//                TsFunParam(NoComments,
//                           TsIdentSimple("selectors"),
//                           Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("string"))), List())),
//                           false)
//              ),
//              Some(
//                TsTypeRef(NoComments,
//                          TsQIdent(List(TsIdentSimple("NodeListOf"))),
//                          List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Element"))), List())))
//              )
//            ),
//            false,
//            false,
//            false
//          )
        ),
        CodePath.NoPath
      )

    shouldEqual(NodeSelectorActual)(NodeSelectorExpected)
  }
}
