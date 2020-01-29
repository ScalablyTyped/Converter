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
        ExportType.Namespaced,
        TsExporteeNames(
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
      TsExport(NoComments, ExportType.Defaulted, TsExporteeNames(IArray((TsQIdent(IArray(TsIdent("Abs"))), None)), None)),
    )
  }

  test("export object") {
    shouldParseAs("""export {Pool, PoolConfig} from "pg"""", TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeNames(
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
      TsExport(NoComments, ExportType.Named, TsExporteeStar(TsIdentModule.simple("aphrodite"))),
    )
  }

  test("export decl") {
    shouldParseAs("""export const enum RoundingMode{}""", TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeTree(
          TsDeclEnum(
            NoComments,
            declared = false,
            isConst = true,
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
      TsImport(IArray(TsImportedIdent(TsIdent("http"))), TsImporteeRequired(TsIdentModule.simple("http"))),
    )
  }

  test("import destructure") {
    shouldParseAs("""import {EventEmitter} from "events"""", TsParser.tsImport)(
      TsImport(
        IArray(TsImportedDestructured(IArray((TsIdent("EventEmitter"), None)))),
        TsImporteeFrom(TsIdentModule.simple("events")),
      ),
    )
  }

  test("import * from ") {
    shouldParseAs("""import * as e from 'express'""", TsParser.tsImport)(
      TsImport(IArray(TsImportedStar(Some(TsIdent("e")))), TsImporteeFrom(TsIdentModule.simple("express"))),
    )
  }

  test("import qualifiedIdent") {
    shouldParseAs("""import ng = angular.dynamicLocale""", TsParser.tsImport)(
      TsImport(
        IArray(TsImportedIdent(TsIdent("ng"))),
        TsImporteeLocal(TsQIdent(IArray(TsIdent("angular"), TsIdent("dynamicLocale")))),
      ),
    )
  }

  test("import ident") {
    shouldParseAs("""import ng = angular""", TsParser.tsImport)(
      TsImport(
        IArray(TsImportedIdent(TsIdent("ng"))),
        TsImporteeLocal(TsQIdent(IArray(TsIdent("angular")))),
      ),
    )
  }

  test("import various") {
    shouldParseAs("""import traverse, {Visitor} from "babel-traverse"""", TsParser.tsImport)(
      TsImport(
        IArray(TsImportedIdent(TsIdent("traverse")), TsImportedDestructured(IArray((TsIdent("Visitor"), None)))),
        TsImporteeFrom(TsIdentModule.simple("babel-traverse")),
      ),
    )
  }

  test("export import") {
    shouldParseAs("""export import AppBar = __MaterialUI.AppBar""", TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeTree(
          TsImport(
            IArray(TsImportedIdent(TsIdent("AppBar"))),
            TsImporteeLocal(TsQIdent(IArray(TsIdent("__MaterialUI"), TsIdent("AppBar")))),
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
        IArray(TsImportedDestructured(IArray((TsIdent("default"), Some(TsIdent("SidebarPushable")))))),
        TsImporteeFrom(TsIdentModule(None, "." :: "SidebarPushable" :: Nil)),
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
        IArray(
          TsImportedDestructured(
            IArray(
              (TsIdent("ValidationOptions"), Some(TsIdent("JoiValidationOptions"))),
              (TsIdent("SchemaMap"), Some(TsIdent("JoiSchemaMap"))),
              (TsIdent("Schema"), Some(TsIdent("JoiSchema"))),
            ),
          ),
        ),
        TsImporteeFrom(TsIdentModule.simple("joi")),
      ),
    )
  }

  test("export default function") {
    val content =
      """export default function (engine: StorageEngine, whitelist?: FilterList, blacklist?: FilterList): StorageEngine"""
    shouldParseAs(content, TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Defaulted,
        TsExporteeTree(
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
                  isOptional = false,
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("whitelist"),
                  Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("FilterList"))), IArray())),
                  isOptional = true,
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("blacklist"),
                  Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("FilterList"))), IArray())),
                  isOptional = true,
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
      TsImport(IArray(TsImportedStar(None)), TsImporteeFrom(TsIdentModule.simple("jquery"))),
    )
    shouldParseAs("""import "../index"""", TsParser.tsImport)(
      TsImport(IArray(TsImportedStar(None)), TsImporteeFrom(TsIdentModule(None, ".." :: "index" :: Nil))),
    )
  }

  test("export default class") {
    shouldParseAs("""export default class extends React.Component<{statusCode: number}, {}> {}""", TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Defaulted,
        TsExporteeTree(
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
                        ProtectionLevel.Default,
                        TsIdent("statusCode"),
                        Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("number"))), IArray())),
                        None,
                        isStatic   = false,
                        isReadOnly = false,
                        isOptional = false,
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
}
