package org.scalablytyped.converter.internal
package ts
package parser

import org.scalablytyped.converter.internal.ts.parser.TsLexer.{CommentLineToken, DirectiveToken}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class CommentTests extends AnyFunSuite with Matchers {
  import ParserHarness._

  test("block comment") {
    val content =
      """/**
        | * Width of the tangible instance, length on the X-axis in 3D.
        | */""".stripMargin
    shouldParseAs(content, TsParser.lexical.comment)(
      TsParser.lexical.CommentBlockToken(content),
    )
  }

  test("line comment") {
    val content = " //asdasdasd\n"
    shouldParseAs(content, TsParser.lexical.comment)(
      TsParser.lexical.CommentLineToken("//asdasdasd\n"),
    )
  }

  test("line comments") {
    parseAs("""| //one
                |    //two
                |  //three
                |""".stripMargin, TsParser.lexical.comment.*)
  }

  test("contain keywords") {
    val content =
      """    // use the following interface in an app code to get access to route param values, history, location...
    // interface MyComponentProps extends ReactRouter.RouteComponentProps<{}, { id: number }> {}
    // somewhere in MyComponent
    // ...
    //   let id = this.props.routeParams.id
    // ...
    //   this.props.history. ...
    // ...
    interface RouteComponentProps<P, R> {
        history?: History
    }""".stripMargin

    parseAs(content, TsParser.tsDeclInterface)
  }

  test("both kinds of comments") {
    val content =
      """        // Actual classes exposed on module.exports
        /**
         * A react component that renders a row of the grid
         */
        export class Row extends React.Component<any, any> { }"""

    val value: TsExport =
      parseAs(content, TsParser.tsExport)

    val expecteds =
      Comments(
        "// Actual classes exposed on module.exports\n",
        """/**
          |         * A react component that renders a row of the grid
          |         */
          |""".stripMargin,
      )

    value.comments.cs.zip(expecteds.cs).foreach {
      case (actual, expected) =>
        actual should equal(expected)
    }
  }

  test("directive one") {
    shouldParseAs("/// <reference path=\"../react/react.d.ts\"/>", TsParser.lexical.directive)(
      TsParser.lexical.DirectiveToken("reference", "path", "../react/react.d.ts"),
    )
  }

  test("directive two") {
    shouldParseAs(
      "/// <reference path=\"../bluebird/bluebird-2.0.d.ts\" />",
      TsParser.lexical.directive,
    )(DirectiveToken("reference", "path", "../bluebird/bluebird-2.0.d.ts"))
  }

  test("directive three") {
    shouldParseAs(
      "/// <reference path='../bluebird/bluebird-2.0.d.ts' />",
      TsParser.lexical.directive,
    )(DirectiveToken("reference", "path", "../bluebird/bluebird-2.0.d.ts"))
  }

  test("directive lib") {
    shouldParseAs(
      """/// <reference lib="dom.iterable" />""",
      TsParser.lexical.directive,
    )(DirectiveToken("reference", "lib", "dom.iterable"))
  }

  test("directive no-default-lib") {
    shouldParseAs(
      """/// <reference no-default-lib="true"/>""",
      TsParser.lexical.directive,
    )(DirectiveToken("reference", "no-default-lib", "true"))
  }

  test("amd-module") {
    shouldParseAs(
      """/// <amd-module name="angular/packages/zone.js/lib/zone"/>""",
      TsParser.lexical.directive,
    )(DirectiveToken("amd-module", "name", "angular/packages/zone.js/lib/zone"))
  }

  test("parameter comments") {
    val content = """	/** A parser and formatter for DSV (CSV and TSV) files.
                    |Extracted from D3. */
                    |    var loader: (
                    |        /** the symbol used to seperate cells in the row.*/
                    |        delimiter: string,
                    |        /** example: "text/plain" */
                    |        encoding?: string) => _d3dsv.D3Dsv
                    |""".stripMargin

    TsTreeTraverse
      .collectIArray(parseAs(content, TsParser.tsDeclVars)) {
        case s: TsDeclVar  => s.comments
        case s: TsFunParam => s.comments
      }
      .toList
      .flatMap(_.cs)
      .size should be(3)
  }

  test("bug") {
    shouldParseAs(
      """{    id: string;
        |
        |    size: number;
        |    // Not guaranteed to have, since it's a non-mandatory option
        |}""".stripMargin,
      TsParser.tsType,
    )(
      TsTypeObject(
        NoComments,
        IArray(
          TsMemberProperty(
            NoComments,
            TsProtectionLevel.Default,
            TsIdent("id"),
            Some(TsTypeRef.string),
            None,
            isStatic   = false,
            isReadOnly = false,
          ),
          TsMemberProperty(
            NoComments,
            TsProtectionLevel.Default,
            TsIdent("size"),
            Some(TsTypeRef(NoComments, TsQIdent.number, Empty)),
            None,
            isStatic   = false,
            isReadOnly = false,
          ),
        ),
      ),
    )
  }

  test("comments before type") {
    val content = "export function Map<K, V>(iter: Iterable<any, /*[K,V]*/Array<any>>): Map<K, V>;"
    shouldParseAs(content, TsParser.tsContainerOrDecl)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Named,
        TsExportee.Tree(
          TsDeclFunction(
            NoComments,
            declared = false,
            TsIdent("Map"),
            TsFunSig(
              NoComments,
              IArray(
                TsTypeParam(NoComments, TsIdent("K"), None, None),
                TsTypeParam(NoComments, TsIdent("V"), None, None),
              ),
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdent("iter"),
                  Some(
                    TsTypeRef(
                      NoComments,
                      TsQIdent(IArray(TsIdent("Iterable"))),
                      IArray(
                        TsTypeRef.any,
                        TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("Array"))), IArray(TsTypeRef.any)),
                      ),
                    ),
                  ),
                ),
              ),
              Some(
                TsTypeRef(
                  NoComments,
                  TsQIdent(IArray(TsIdent("Map"))),
                  IArray(
                    TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("K"))), Empty),
                    TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("V"))), Empty),
                  ),
                ),
              ),
            ),
            JsLocation.Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("bug2") {
    val content =
      """interface Int16ArrayConstructor {
        |    new (elements: Iterable<number>): Int16Array;
        |
        |    /**
        |      * Creates an array from an array-like or iterable object.
        |      * @param arrayLike An array-like or iterable object to convert to an array.
        |      * @param mapfn A mapping function to call on every element of the array.
        |      * @param thisArg Value of 'this' used to invoke the mapfn.
        |      */
        |    from(arrayLike: Iterable<number>, mapfn?: (v: number, k: number) => number, thisArg?: any): Int16Array;
        |}
        |
        |/**
        |  * A typed array of 16-bit unsigned integer values. The contents are initialized to 0. If the
        |  * requested number of bytes could not be allocated an exception is raised.
        |  */
        |interface Uint16Array {
        |    [Symbol.iterator](): IterableIterator<number>;
        |    /**
        |      * Returns an array of key, value pairs for every entry in the array
        |      */
        |    entries(): IterableIterator<[number, number]>;
        |    /**
        |      * Returns an list of keys in the array
        |      */
        |    keys(): IterableIterator<number>;
        |    /**
        |      * Returns an list of values in the array
        |      */
        |    values(): IterableIterator<number>;
        |}
        |""".stripMargin

    parseAs(content, TsParser.parsedTsFile)
  }

  test("handle stray references") {
    withTsFile("parsertests/graphql.d.ts") { content =>
      parseAs(content, TsParser.tsContainerOrDecls)
    }
  }

  test("trailing comments") {
    withTsFile("parsertests/egg.d.ts") { content =>
      parseAs(content, TsParser.tsContainerOrDecls)
    }
  }

  test("trailing comments (2)") {
    withTsFile("parsertests/emissary.d.ts") { content =>
      parseAs(content, TsParser.parsedTsFile)
    }
  }

  test("trailing comments (3)") {
    val content = """export {
    BrowserRouter,
    HashRouter,
    LinkProps, // TypeScript specific, not from React Router itself
    NavLinkProps, // TypeScript specific, not from React Router itself
    Link,
    NavLink,
    Prompt,
  }"""
    parseAs(content, TsParser.parsedTsFile)
  }

  test("handle trailing comments in block") {
    withTsFile("parsertests/knockout.d.ts") { content =>
      parseAs(content, TsParser.tsContainerOrDecls)
    }
  }

  test("comments in tuple type") {
    val content = """[
        Position, // End point: x, y, <z>, <m>
        Position2D, // Center point: center_x, center_y
        number, // minor
        number, // clockwise
        number, // rotation
        number, // axis
        number // ratio
    ]"""
    parseAs(content, TsParser.tsType)
  }

  test("arne") {
    shouldParseAs(
      """F<A, /* foo */
        B>""",
      TsParser.tsTypeRef,
    )(
      TsTypeRef(
        NoComments,
        TsQIdent(IArray(TsIdentSimple("F"))),
        IArray(
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("A"))), IArray()),
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("B"))), IArray()),
        ),
      ),
    )
  }

  test("directives bug") {
    val content =
      """// Type definitions for DateJS
// Project: http://www.datejs.com/
// Definitions by: David Khristepher Santos <http://github.com/rupertavery>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

//NOTE: This definition file is for the library located at http://datejs.googlecode.com/svn/ and documented at https://code.google.com/p/datejs/wiki/APIDocumentation
//That version of the library is more recent than the one provided at https://code.google.com/p/datejs/downloads/list, which has a slightly different API

/// <reference path="sugarpak.d.ts" />

/** Defines a structure to be used in the add and set instance methods */
interface IDateJSLiteral {
    milliseconds: number;
}
"""
    parseAs(content, TsParser.parsedTsFile)
  }

  test("directives bug2") {
    val content =
      """/*! *****************************************************************************
Copyright (c) Microsoft Corporation. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at http://www.apache.org/licenses/LICENSE-2.0

THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.

See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */



/// <reference no-default-lib="true"/>


/// <reference lib="esnext" />
/// <reference lib="dom" />
/// <reference lib="webworker.importscripts" />
/// <reference lib="scripthost" />
/// <reference lib="dom.iterable" />
"""
    parseAs(content, TsParser.parsedTsFile)
  }

  test("ignore directives not on top of file") {
    val content = """
    /*! *****************************************************************************
See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */



/// <reference no-default-lib="true"/>


/////////////////////////////
/// ECMAScript APIs
/////////////////////////////

declare const NaN: number;
/// <reference no-default-lib="true"/>
declare const Infinity: number;
"""

    val forced: TsParsedFile = TsParser.parsedTsFile(content).force
    assert(forced.directives.length == 1)
  }

  test("flaff") {
    val content = """declare type A<P, /* A*/
B > = number"""
    val forced: TsDeclTypeAlias = TsParser.tsDeclTypeAlias(content).force
    assert(forced.tparams.length == 2)
  }

  test("handle extraneous comments in type parameter list 2") {
    val content = """interface A<T/**/
/**/
/**/
/**/
>{}"""
    val forced  = TsParser.tsDeclInterface(content).force
    assert(forced.tparams.length == 1)
  }
}
