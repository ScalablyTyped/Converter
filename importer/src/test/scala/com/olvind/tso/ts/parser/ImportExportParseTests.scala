package com.olvind.tso
package ts
package parser

import com.olvind.tso.ts.JsLocation.Zero
import org.scalatest.{FunSuite, Matchers}

final class ImportExportParseTests extends FunSuite with Matchers {
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
          List(
            (TsQIdent(List(TsIdent("AuthenticationContext"))), None),
            (TsQIdent(List(TsIdent("Logging"))), None),
          ),
          None,
        ),
      )
    }
  }

  test("export default") {
    shouldParseAs("export default Abs", TsParser.tsExport)(
      TsExport(NoComments, ExportType.Defaulted, TsExporteeNames(Seq((TsQIdent(List(TsIdent("Abs"))), None)), None)),
    )
  }

  test("export object") {
    shouldParseAs("""export {Pool, PoolConfig} from "pg"""", TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeNames(
          List(
            (TsQIdent(List(TsIdent("Pool"))), None),
            (TsQIdent(List(TsIdent("PoolConfig"))), None),
          ),
          Some(TsIdentModule.simple("pg")),
        ),
      ),
    )
  }

  test("export alias") {
    shouldParseAs("""export * from "aphrodite"""", TsParser.tsExport)(
      TsExport(NoComments, ExportType.Named, TsExporteeStar(TsIdentModule.simple("aphrodite"), None)),
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
            TsIdent("RoundingMode"),
            Nil,
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
      TsImport(Seq(TsImportedIdent(TsIdent("http"))), TsImporteeRequired(TsIdentModule.simple("http"))),
    )
  }

  test("import destructure") {
    shouldParseAs("""import {EventEmitter} from "events"""", TsParser.tsImport)(
      TsImport(
        Seq(TsImportedDestructured(List((TsIdent("EventEmitter"), None)))),
        TsImporteeFrom(TsIdentModule.simple("events")),
      ),
    )
  }

  test("import * from ") {
    shouldParseAs("""import * as e from 'express'""", TsParser.tsImport)(
      TsImport(Seq(TsImportedStar(Some(TsIdent("e")))), TsImporteeFrom(TsIdentModule.simple("express"))),
    )
  }

  test("import qualifiedIdent") {
    shouldParseAs("""import ng = angular.dynamicLocale""", TsParser.tsImport)(
      TsImport(
        Seq(TsImportedIdent(TsIdent("ng"))),
        TsImporteeLocal(TsQIdent(List(TsIdent("angular"), TsIdent("dynamicLocale")))),
      ),
    )
  }

  test("import ident") {
    shouldParseAs("""import ng = angular""", TsParser.tsImport)(
      TsImport(
        Seq(TsImportedIdent(TsIdent("ng"))),
        TsImporteeLocal(TsQIdent(List(TsIdent("angular")))),
      ),
    )
  }

  test("import various") {
    shouldParseAs("""import traverse, {Visitor} from "babel-traverse"""", TsParser.tsImport)(
      TsImport(
        Seq(TsImportedIdent(TsIdent("traverse")), TsImportedDestructured(List((TsIdent("Visitor"), None)))),
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
            List(TsImportedIdent(TsIdent("AppBar"))),
            TsImporteeLocal(TsQIdent(List(TsIdent("__MaterialUI"), TsIdent("AppBar")))),
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
        List(TsImportedDestructured(List((TsIdent("default"), Some(TsIdent("SidebarPushable")))))),
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
        List(
          TsImportedDestructured(
            List(
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
              List(),
              List(
                TsFunParam(
                  NoComments,
                  TsIdent("engine"),
                  Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("StorageEngine"))), List())),
                  isOptional = false,
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("whitelist"),
                  Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("FilterList"))), List())),
                  isOptional = true,
                ),
                TsFunParam(
                  NoComments,
                  TsIdent("blacklist"),
                  Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("FilterList"))), List())),
                  isOptional = true,
                ),
              ),
              Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("StorageEngine"))), List())),
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
      TsImport(List(TsImportedStar(None)), TsImporteeFrom(TsIdentModule.simple("jquery"))),
    )
    shouldParseAs("""import "../index"""", TsParser.tsImport)(
      TsImport(List(TsImportedStar(None)), TsImporteeFrom(TsIdentModule(None, ".." :: "index" :: Nil))),
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
            List(),
            Some(
              TsTypeRef(
                NoComments,
                TsQIdent(List(TsIdent("React"), TsIdent("Component"))),
                List(
                  TsTypeObject(
                    List(
                      TsMemberProperty(
                        NoComments,
                        Default,
                        TsIdent("statusCode"),
                        Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("number"))), List())),
                        None,
                        isStatic   = false,
                        isReadOnly = false,
                        isOptional = false,
                      ),
                    ),
                  ),
                  TsTypeObject(List()),
                ),
              ),
            ),
            List(),
            List(),
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }
}
