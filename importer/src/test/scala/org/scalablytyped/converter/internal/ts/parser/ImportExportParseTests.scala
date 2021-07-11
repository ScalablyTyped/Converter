package org.scalablytyped.converter.internal
package ts
package parser

import org.scalablytyped.converter.internal.ts.JsLocation.Zero
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class ImportExportParseTests extends AnyFunSuite with Matchers {
  import ParserHarness._

  test("accept export without ';'") {
    val content =
      """declare namespace acorn {
        |    var version: string;
        |}
        |
        |declare module "acorn" {
        |    export = acorn;
        |}
        |""".stripMargin

    parseAs(content, TsParser.tsContainerOrDecls)
  }

  test("allow select expressions in export") {
    parseAs(
      """declare module "3d-bin-packing" {export = bws.packer;}""",
      TsParser.tsContainerOrDecls,
    )
  }

  test("export equals object") {
    shouldParseAs("export = { AuthenticationContext, Logging, }", TsParser.tsExport) {
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Namespaced,
        TsExportee.Names(
          IArray(
            (TsQIdent(IArray(TsIdent("AuthenticationContext"))), None),
            (TsQIdent(IArray(TsIdent("Logging"))), None),
          ),
          None,
        ),
      )
    }
  }

  test("export default") {
    shouldParseAs("export default Abs", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Defaulted,
        TsExportee.Names(IArray((TsQIdent(IArray(TsIdent("Abs"))), None)), None),
      ),
    )
  }

  test("export object") {
    shouldParseAs("""export {Pool, PoolConfig} from "pg"""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Named,
        TsExportee.Names(
          IArray(
            (TsQIdent(IArray(TsIdent("Pool"))), None),
            (TsQIdent(IArray(TsIdent("PoolConfig"))), None),
          ),
          Some(TsIdentModule.simple("pg")),
        ),
      ),
    )
  }

  test("export alias") {
    shouldParseAs("""export * from "aphrodite"""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Named,
        TsExportee.Star(None, TsIdentModule.simple("aphrodite")),
      ),
    )
  }

  test("export decl") {
    shouldParseAs("""export const enum RoundingMode{}""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Named,
        TsExportee.Tree(
          TsDeclEnum(
            NoComments,
            declared = false,
            isConst  = true,
            TsIdent("RoundingMode"),
            Empty,
            isValue      = true,
            exportedFrom = None,
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("import require") {
    shouldParseAs("import http = require('http')", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Ident(TsIdent("http"))),
        TsImportee.Required(TsIdentModule.simple("http")),
      ),
    )
  }

  test("import destructure") {
    shouldParseAs("""import {EventEmitter} from "events"""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Destructured(IArray((TsIdent("EventEmitter"), None)))),
        TsImportee.From(TsIdentModule.simple("events")),
      ),
    )
  }

  test("import * from ") {
    shouldParseAs("""import * as e from 'express'""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Star(Some(TsIdent("e")))),
        TsImportee.From(TsIdentModule.simple("express")),
      ),
    )
  }

  test("import qualifiedIdent") {
    shouldParseAs("""import ng = angular.dynamicLocale""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Ident(TsIdent("ng"))),
        TsImportee.Local(TsQIdent(IArray(TsIdent("angular"), TsIdent("dynamicLocale")))),
      ),
    )
  }

  test("import ident") {
    shouldParseAs("""import ng = angular""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Ident(TsIdent("ng"))),
        TsImportee.Local(TsQIdent(IArray(TsIdent("angular")))),
      ),
    )
  }

  test("import various") {
    shouldParseAs("""import traverse, {Visitor} from "babel-traverse"""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Ident(TsIdent("traverse")), TsImported.Destructured(IArray((TsIdent("Visitor"), None)))),
        TsImportee.From(TsIdentModule.simple("babel-traverse")),
      ),
    )
  }

  test("export import") {
    shouldParseAs("""export import AppBar = __MaterialUI.AppBar""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Named,
        TsExportee.Tree(
          TsImport(
            typeOnly = false,
            IArray(TsImported.Ident(TsIdent("AppBar"))),
            TsImportee.Local(TsQIdent(IArray(TsIdent("__MaterialUI"), TsIdent("AppBar")))),
          ),
        ),
      ),
    )
  }

  test("export as namespace") {
    shouldParseAs("""export as namespace History""", TsParser.exportAsNamespace)(
      TsExportAsNamespace(TsIdent("History")),
    )
  }

  test("import renamed default") {
    shouldParseAs("""import { default as SidebarPushable } from './SidebarPushable'""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Destructured(IArray((TsIdent("default"), Some(TsIdent("SidebarPushable")))))),
        TsImportee.From(TsIdentModule(None, "." :: "SidebarPushable" :: Nil)),
      ),
    )
  }

  test("trailing comma") {
    val content = """import {
    ValidationOptions as JoiValidationOptions,
    SchemaMap as JoiSchemaMap,
    Schema as JoiSchema,
} from 'joi'
"""
    shouldParseAs(content, TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(
          TsImported.Destructured(
            IArray(
              (TsIdent("ValidationOptions"), Some(TsIdent("JoiValidationOptions"))),
              (TsIdent("SchemaMap"), Some(TsIdent("JoiSchemaMap"))),
              (TsIdent("Schema"), Some(TsIdent("JoiSchema"))),
            ),
          ),
        ),
        TsImportee.From(TsIdentModule.simple("joi")),
      ),
    )
  }

  test("export default function") {
    val content =
      """export default function (engine: StorageEngine, whitelist?: FilterList, blacklist?: FilterList): StorageEngine"""
    shouldParseAs(content, TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Defaulted,
        TsExportee.Tree(
          TsDeclFunction(
            NoComments,
            declared = false,
            TsIdent.default,
            TsFunSig(
              NoComments,
              IArray(),
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdent("engine"),
                  Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("StorageEngine"))), IArray())),
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("whitelist"),
                  Some(OptionalType(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("FilterList"))), IArray()))),
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("blacklist"),
                  Some(OptionalType(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("FilterList"))), IArray()))),
                ),
              ),
              Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("StorageEngine"))), IArray())),
            ),
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("history") {
    withTsFile("parsertests/history.d.ts") { contents: String =>
      parseAs(contents, TsParser.parsedTsFile)
    }
  }

  test("import 'foo'") {
    shouldParseAs("""import 'jquery'""", TsParser.tsImport)(
      TsImport(typeOnly = false, IArray(TsImported.Star(None)), TsImportee.From(TsIdentModule.simple("jquery"))),
    )
    shouldParseAs("""import "../index"""", TsParser.tsImport)(
      TsImport(
        typeOnly = false,
        IArray(TsImported.Star(None)),
        TsImportee.From(TsIdentModule(None, ".." :: "index" :: Nil)),
      ),
    )
  }

  test("export default class") {
    shouldParseAs("""export default class extends React.Component<{statusCode: number}, {}> {}""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Defaulted,
        TsExportee.Tree(
          TsDeclClass(
            NoComments,
            declared   = false,
            isAbstract = false,
            TsIdent("default"),
            IArray(),
            Some(
              TsTypeRef(
                NoComments,
                TsQIdent(IArray(TsIdent("React"), TsIdent("Component"))),
                IArray(
                  TsTypeObject(
                    NoComments,
                    IArray(
                      TsMemberProperty(
                        NoComments,
                        TsProtectionLevel.Default,
                        TsIdent("statusCode"),
                        Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("number"))), IArray())),
                        None,
                        isStatic   = false,
                        isReadOnly = false,
                      ),
                    ),
                  ),
                  TsTypeObject(NoComments, IArray()),
                ),
              ),
            ),
            IArray(),
            IArray(),
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("export default class <T>") {
    shouldParseAs("export default class <T> {}", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = false,
        ExportType.Defaulted,
        TsExportee.Tree(
          TsDeclClass(
            NoComments,
            declared   = false,
            isAbstract = false,
            TsIdent("default"),
            IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
            None,
            IArray(),
            IArray(),
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("import type") {
    shouldParseAs("""import type { DiffOptions, DiffOptionsNormalized } from './types'""", TsParser.tsImport)(
      TsImport(
        typeOnly = true,
        IArray(
          TsImported.Destructured(
            IArray((TsIdentSimple("DiffOptions"), None), (TsIdentSimple("DiffOptionsNormalized"), None)),
          ),
        ),
        TsImportee.From(TsIdentModule(None, List(".", "types"))),
      ),
    )
  }
  test("export type") {
    shouldParseAs("""export type { DiffOptions, DiffOptionsColor } from './types'""", TsParser.tsExport)(
      TsExport(
        NoComments,
        typeOnly = true,
        tpe      = ExportType.Named,
        exported = TsExportee.Names(
          IArray(
            (TsQIdent(IArray(TsIdentSimple("DiffOptions"))), None),
            (TsQIdent(IArray(TsIdentSimple("DiffOptionsColor"))), None),
          ),
          Some(TsIdentModule(None, List(".", "types"))),
        ),
      ),
    )
  }

  test("export type edge case") {
    val content = """declare module "esri/renderers/smartMapping/creators/type" {
  import type = __esri.type;
  export = type;
}
"""
    shouldParseAs(content, TsParser.tsDeclModule) {
      TsDeclModule(
        NoComments,
        declared = true,
        TsIdentModule(None, List("esri", "renderers", "smartMapping", "creators", "type")),
        IArray(
          TsImport(
            typeOnly = true,
            IArray(),
            TsImportee.Local(TsQIdent(IArray(TsIdentSimple("__esri"), TsIdentSimple("type")))),
          ),
          TsExport(
            NoComments,
            typeOnly = false,
            ExportType.Namespaced,
            TsExportee.Names(IArray((TsQIdent(IArray(TsIdentSimple("type"))), None)), None),
          ),
        ),
        CodePath.NoPath,
        Zero,
      )
    }
  }

  test("export * as") {
    val content = """export * as specialChars from './specialChars'"""
    shouldParseAs(content, TsParser.tsExport)(
      TsExport(
        NoComments,
        false,
        ExportType.Named,
        TsExportee.Star(Some(TsIdentSimple("specialChars")), TsIdentModule(None, List(".", "specialChars"))),
      ),
    )
  }
}
