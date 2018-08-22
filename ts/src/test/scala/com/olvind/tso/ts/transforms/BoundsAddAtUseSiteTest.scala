package com.olvind.tso
package ts
package transforms

import com.olvind.logging
import com.olvind.tso.ts.JsLocation.Zero
import com.olvind.tso.ts.parser.TsParser
import org.scalatest.FunSuite

class BoundsAddAtUseSiteTest extends FunSuite with DiffingAssertions {
  import ParserHarness._

  test("add simple bound") {
    val content =
      """
interface Element{}
interface HTMLCollection{}
interface HTMLAnchorElement extends Element {}
interface HTMLAreaElement extends Element {}

interface HTMLCollectionOf<T extends Element> extends HTMLCollection {
    item(index: number): T;
}

interface Document {
    links: HTMLCollectionOf<HTMLAnchorElement | HTMLAreaElement>;
}
"""

    val res = BoundsAddAtUseSite.visitTsParsedFile(TreeScope(TsIdent.dummy, Map.empty, logging.stdout))(
      TsParser(content).force
    )
    val Document = res.members.collectFirst {
      case x: TsDeclInterface if x.name == TsIdent("Document") => x
    }.get

    val expected = TsDeclInterface(
      NoComments,
      declared = false,
      TsIdent("Document"),
      Nil,
      Nil,
      List(
        TsMemberProperty(
          NoComments,
          Default,
          TsIdent("links"),
          Some(
            TsTypeRef(
              TsQIdent.of("HTMLCollectionOf"),
              List(
                TsTypeIntersect(
                  Seq(
                    TsTypeRef(TsQIdent.of("Element"), Nil),
                    TsTypeUnion(
                      List(TsTypeRef(TsQIdent.of("HTMLAnchorElement"), Nil),
                           TsTypeRef(TsQIdent.of("HTMLAreaElement"), Nil))
                    )
                  )
                )
              )
            )
          ),
          isStatic = false,
          isReadOnly = false,
          isOptional = false
        )
      ),
      CodePath.NoPath
    )

    shouldEqual(Document)(expected)
  }

  test("createFactory") {
    val content =
      """
interface DOMAttributes<T> {}
function createFactory<P extends DOMAttributes<T>, T extends Element>(type: string): DOMFactory<P, T>;
    """

    val res = BoundsAddAtUseSite.visitTsParsedFile(TreeScope(TsIdent.dummy, Map.empty, logging.stdout))(
      TsParser(content).force
    )

    val createFactory = res.members.collectFirst {
      case x: TsDeclFunction if x.name == TsIdent("createFactory") => x
    }.get

    val expected = TsDeclFunction(
      NoComments,
      declared = false,
      TsIdent("createFactory"),
      TsFunSig(
        NoComments,
        List(
          TsTypeParam(NoComments,
                      TsIdent("P"),
                      Some(
                        TsTypeRef(TsQIdent(List(TsIdent("DOMAttributes"))),
                                  List(TsTypeRef(TsQIdent(List(TsIdent("T"))), List())))
                      ),
                      None),
          TsTypeParam(NoComments, TsIdent("T"), Some(TsTypeRef(TsQIdent(List(TsIdent("Element"))), List())), None)
        ),
        List(
          TsFunParam(NoComments,
                     TsIdent("type"),
                     Some(TsTypeRef(TsQIdent(List(TsIdent("string"))), List())),
                     isOptional = false)
        ),
        Some(
          TsTypeRef(TsQIdent(List(TsIdent("DOMFactory"))),
                    List(TsTypeRef(TsQIdent(List(TsIdent("P"))), List()),
                         TsTypeRef(TsQIdent(List(TsIdent("T"))), List())))
        )
      ),
      Zero,
      CodePath.NoPath
    )

    shouldEqual(createFactory)(expected)
  }
}
