package com.olvind.tso
package ts
package transforms

import com.olvind.logging
import com.olvind.tso.ts.parser.TsParser
import org.scalatest.FunSuite

class DefaultedHasTParamsTest extends FunSuite with DiffingAssertions {
  import ParserHarness._

  test("work") {
    val content = """
    interface Element {}
    interface ComponentLifecycle<P, S> {}
  interface Component<P = {}, S = {}> extends ComponentLifecycle<P, S> { }
  type ReactInstance = Component<any> | Element;
    """

    val parsed: TsParsedFile = TsParser(content).force
    val actual =
      DefaultedTParams.visitTsParsedFile(TreeScope(TsIdent.dummy, Map.empty, logging.stdout))(parsed)

    val expected = TsParsedFile(
      NoComments,
      List(),
      List(
        TsDeclInterface(NoComments, false, TsIdentSimple("Element"), List(), List(), List(), CodePath.NoPath),
        TsDeclInterface(
          NoComments,
          false,
          TsIdentSimple("ComponentLifecycle"),
          List(TsTypeParam(NoComments, TsIdentSimple("P"), None, None),
               TsTypeParam(NoComments, TsIdentSimple("S"), None, None)),
          List(),
          List(),
          CodePath.NoPath
        ),
        TsDeclInterface(
          NoComments,
          false,
          TsIdent("Component"),
          List(TsTypeParam(NoComments, TsIdent("P"), None, Some(TsTypeObject(List()))),
               TsTypeParam(NoComments, TsIdent("S"), None, Some(TsTypeObject(List())))),
          List(
            TsTypeRef(TsQIdent(List(TsIdent("ComponentLifecycle"))),
                      List(TsTypeRef(TsQIdent(List(TsIdent("P"))), List()),
                           TsTypeRef(TsQIdent(List(TsIdent("S"))), List())))
          ),
          List(),
          CodePath.NoPath
        ),
        TsDeclTypeAlias(
          NoComments,
          false,
          TsIdent("ReactInstance"),
          List(),
          TsTypeUnion(
            List(
              TsTypeRef(TsQIdent(List(TsIdent("Component"))),
                        List(TsTypeRef(TsQIdent(List(TsIdent("any"))), List()), TsTypeObject(List()))),
              TsTypeRef(TsQIdent(List(TsIdent("Element"))), List())
            )
          ),
          CodePath.NoPath
        )
      ),
      CodePath.NoPath
    )
    shouldEqual(actual)(expected)
  }
}
