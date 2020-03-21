package org.scalablytyped.converter.internal
package ts
package parser

import org.scalablytyped.converter.internal.ts.JsLocation.Zero
import org.scalablytyped.converter.internal.ts.OptionalModifier.Noop
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

final class ParserTests extends AnyFunSuite {
  private val T = TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("T"))), Empty)

  import ParserHarness._

  test("whole file") {
    withTsFile("parsertests/path-case.d.ts") { content =>
      val expected =
        TsParsedFile(
          NoComments,
          IArray(DirectivePathRef("./path-case.d.ts")),
          IArray(
            TsDeclModule(
              NoComments,
              declared = true,
              name     = TsIdentModule.simple("path-case"),
              members = IArray(
                TsDeclFunction(
                  NoComments,
                  declared = false,
                  name     = TsIdent("pathCase"),
                  signature = TsFunSig(
                    NoComments,
                    Empty,
                    IArray(
                      TsFunParam(
                        NoComments,
                        name       = TsIdent("string"),
                        tpe        = Some(TsTypeRef.string),
                        isOptional = false,
                      ),
                      TsFunParam(
                        NoComments,
                        name       = TsIdent("locale"),
                        tpe        = Some(TsTypeRef.string),
                        isOptional = true,
                      ),
                    ),
                    Some(TsTypeRef.string),
                  ),
                  Zero,
                  CodePath.NoPath,
                ),
                TsExport(
                  NoComments,
                  ExportType.Namespaced,
                  TsExporteeNames(IArray((TsQIdent(IArray(TsIdent("pathCase"))), None)), None),
                ),
              ),
              CodePath.NoPath,
              JsLocation.Zero,
            ),
          ),
          CodePath.NoPath,
        )

      shouldParseAs(content, TsParser.parsedTsFile)(expected)
    }
  }

  test("handle byte order mark") {
    withTsFile("parsertests/adm-zip.d.ts") { content =>
      parseAs(content, TsParser.tsContainerOrDecls)
    }
  }

  test("handle nbsp") {
    shouldParseAs("\u00a0var _: string", TsParser.tsDeclVars)(
      IArray(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = false,
          TsIdent("_"),
          Some(TsTypeRef.string),
          None,
          Zero,
          CodePath.NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("windows line separators and mixed newlines/whitespace") {
    withTsFile("parsertests/adal.d.ts") { content =>
      parseAs(content, TsParser.parsedTsFile)
    }
  }

  test("interface") {
    val content: String =
      """    interface Options {
        |        algorithm?: string;
        |        saltLength?: number;
        |        iterations?: number;
        |    }
        |""".stripMargin

    val expected: TsDeclInterface =
      TsDeclInterface(
        NoComments,
        declared    = false,
        name        = TsIdent("Options"),
        tparams     = Empty,
        inheritance = Empty,
        members = IArray(
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("algorithm"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("saltLength"),
            tpe        = Some(TsTypeRef.number),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("iterations"),
            tpe        = Some(TsTypeRef.number),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
        ),
        CodePath.NoPath,
      )

    shouldParseAs(content, TsParser.tsDeclInterface)(expected)
  }

  test("class") {
    val content: String =
      """    class Base {
        |        constructor(params?: { [key: string]: any });
        |        destroy(): void;
        |    }
        |""".stripMargin

    val expected: TsDeclClass =
      TsDeclClass(
        NoComments,
        declared   = false,
        isAbstract = false,
        name       = TsIdent("Base"),
        tparams    = Empty,
        parent     = None,
        implements = Empty,
        members = IArray(
          TsMemberFunction(
            NoComments,
            level = ProtectionLevel.Default,
            name  = TsIdent.constructor,
            signature = TsFunSig(
              NoComments,
              Empty,
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdent("params"),
                  tpe = Some(
                    TsTypeObject(
                      NoComments,
                      members = IArray(
                        TsMemberIndex(
                          NoComments,
                          isReadOnly = false,
                          level      = ProtectionLevel.Default,
                          indexing   = IndexingDict(TsIdent("key"), TsTypeRef.string),
                          valueType  = Some(TsTypeRef.any),
                          isOptional = false,
                        ),
                      ),
                    ),
                  ),
                  isOptional = true,
                ),
              ),
              None,
            ),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false,
          ),
          TsMemberFunction(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("destroy"),
            signature  = TsFunSig(NoComments, tparams = Empty, params = Empty, resultType = Some(TsTypeRef.void)),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false,
          ),
        ),
        Zero,
        CodePath.NoPath,
      )

    shouldParseAs(content, TsParser.tsDeclClass)(expected)
  }

  test("abstract class") {
    val content =
      """    abstract class Instance {
        |        /**
        |         * Width of the tangible instance, length on the X-axis in 3D.
        |         */
        |        width: number;
        |        /**
        |         * Height of the tangible instance, length on the Y-axis in 3D.
        |         */
        |        height: number;
        |    }
        |""".stripMargin

    parseAs(content, TsParser.tsDeclClass).isAbstract should be(true)
  }

  test("enums") {
    shouldParseAs(
      """enum LoggingLevel {ERROR = 0, WARNING = 1}""".stripMargin,
      TsParser.tsDeclEnum,
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        isConst  = false,
        TsIdent("LoggingLevel"),
        IArray(
          TsEnumMember(NoComments, TsIdent("ERROR"), Some(TsExpr.Literal(TsLiteralNumber("0")))),
          TsEnumMember(NoComments, TsIdent("WARNING"), Some(TsExpr.Literal(TsLiteralNumber("1")))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath,
      ),
    )

    shouldParseAs(
      "const enum ErrorCode { OTHER_CAUSE = -1, INTERNAL_SERVER_ERROR = 1,}",
      TsParser.tsDeclEnum,
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        isConst  = true,
        TsIdent("ErrorCode"),
        IArray(
          TsEnumMember(NoComments, TsIdent("OTHER_CAUSE"), Some(TsExpr.Literal(TsLiteralNumber("-1")))),
          TsEnumMember(NoComments, TsIdent("INTERNAL_SERVER_ERROR"), Some(TsExpr.Literal(TsLiteralNumber("1")))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath,
      ),
    )

    shouldParseAs(
      """enum HitType {'pageview', /* arne */
        |'screenview', 'event', 'transaction', 'item', 'social', 'exception', 'timing'}""".stripMargin,
      TsParser.tsDeclEnum,
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        isConst  = false,
        TsIdent("HitType"),
        IArray(
          TsEnumMember(NoComments, TsIdent("pageview"), None),
          TsEnumMember(NoComments, TsIdent("screenview"), None),
          TsEnumMember(NoComments, TsIdent("event"), None),
          TsEnumMember(NoComments, TsIdent("transaction"), None),
          TsEnumMember(NoComments, TsIdent("item"), None),
          TsEnumMember(NoComments, TsIdent("social"), None),
          TsEnumMember(NoComments, TsIdent("exception"), None),
          TsEnumMember(NoComments, TsIdent("timing"), None),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("class, untyped member, protection levels, comments, constructor") {
    val content =
      """class Packer extends samchon.protocol.Entity {
        |    /**
        |     * Candidate wrappers who can contain instances.
        |     */
        |    protected wrapperArray;
        |    /**
        |     * Instances trying to pack into the wrapper.
        |     */
        |    private instanceArray;
        |    /**
        |     * ProtectionLevel.Default Constructor.
        |     */
        |    constructor();
        |}""".stripMargin
    val tree: TsDeclClass =
      parseAs(content, TsParser.tsDeclClass)

    TsTreeTraverse
      .collect(tree) {
        case t: TsMemberFunction => t.comments
        case t: TsMemberProperty => t.comments
      }
      .toList
      .flatMap(_.cs)
      .size should be(3)

    TsTreeTraverse.collect(tree) {
      case TsMemberProperty(_, level, _, _, _, false, _, _)                => level
      case TsMemberFunction(_, level, TsIdent.constructor, _, false, _, _) => level
    } should be(IArray(ProtectionLevel.Protected, ProtectionLevel.Private, ProtectionLevel.Default))

    TsTreeTraverse
      .collect(tree) {
        case TsMemberProperty(_, _, _, tpe, _, false, _, _) => tpe
      }
      .distinct should be(IArray(None))
  }

  test("var, let, const") {
    val content =
      """declare module "brorand" {
        |	var Brorand1: BrorandStatic;
        |	let Brorand2: BrorandStatic;
        |	const Brorand3: BrorandStatic;
        |}
        |""".stripMargin

    val res: TsDecl =
      parseAs(content, TsParser.tsDeclModule)

    val names: IArray[String] =
      TsTreeTraverse.collect(res) {
        case TsDeclVar(
            _,
            _,
            _,
            TsIdent(name),
            Some(TsTypeRef(NoComments, TsQIdent(IArray.exactlyOne(TsIdent("BrorandStatic"))), _)),
            None,
            _,
            _,
            _,
            ) =>
          name
      }

    names should equal(IArray("Brorand1", "Brorand2", "Brorand3"))
  }

  test("constructor type literals") {
    shouldParseAs(
      "type ActionsClassConstructor = new (alt:Alt) => AltJS.ActionsClass",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("ActionsClassConstructor"),
        Empty,
        TsTypeConstructor(
          TsTypeFunction(
            TsFunSig(
              NoComments,
              Empty,
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdentSimple("alt"),
                  Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Alt"))), Empty)),
                  isOptional = false,
                ),
              ),
              Some(
                TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("AltJS"), TsIdentSimple("ActionsClass"))), Empty),
              ),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("top level type alias") {
    shouldParseAs(
      "type ChartColor = string | CanvasGradient | CanvasPattern",
      TsParser.tsContainerOrDecl,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("ChartColor"),
        Empty,
        TsTypeUnion(
          IArray(
            TsTypeRef.string,
            TsTypeRef(NoComments, TsQIdent.of("CanvasGradient"), Empty),
            TsTypeRef(NoComments, TsQIdent.of("CanvasPattern"), Empty),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("type parameter with refinement") {
    val content =
      "export function ordinal<Domain extends { toString(): string }, Range>(): Ordinal<Domain, Range>"

    shouldParseAs(content, TsParser.tsExport)(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeTree(
          TsDeclFunction(
            NoComments,
            declared = false,
            TsIdent("ordinal"),
            TsFunSig(
              NoComments,
              tparams = IArray(
                TsTypeParam(
                  NoComments,
                  name = TsIdent("Domain"),
                  upperBound = Some(
                    TsTypeObject(
                      NoComments,
                      members = IArray(
                        TsMemberFunction(
                          NoComments,
                          level = ProtectionLevel.Default,
                          name  = TsIdent("toString"),
                          signature =
                            TsFunSig(NoComments, tparams = Empty, params = Empty, resultType = Some(TsTypeRef.string)),
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false,
                        ),
                      ),
                    ),
                  ),
                  None,
                ),
                TsTypeParam(NoComments, name = TsIdent("Range"), upperBound = None, default = None),
              ),
              params = Empty,
              resultType = Some(
                TsTypeRef(
                  NoComments,
                  name = TsQIdent.of("Ordinal"),
                  tparams = IArray(
                    TsTypeRef(NoComments, TsQIdent.of("Domain"), Empty),
                    TsTypeRef(NoComments, TsQIdent.of("Range"), Empty),
                  ),
                ),
              ),
            ),
            Zero,
            CodePath.NoPath,
          ),
        ),
      ),
    )
  }

  test("intersection / union types") {
    val content =
      """export type AjvValidate = ((data: any) => boolean | PromiseLike<boolean>) & {
        |    errors: ValidationError[];
        |}
        |""".stripMargin

    val expected = TsExport(
      NoComments,
      ExportType.Named,
      TsExporteeTree(
        TsDeclTypeAlias(
          NoComments,
          declared = false,
          TsIdent("AjvValidate"),
          Empty,
          TsTypeIntersect(
            IArray(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(TsFunParam(NoComments, name = TsIdent("data"), tpe = Some(TsTypeRef.any), isOptional = false)),
                  Some(
                    TsTypeUnion(
                      IArray(
                        TsTypeRef(NoComments, TsQIdent.boolean, Empty),
                        TsTypeRef(
                          NoComments,
                          TsQIdent.of("PromiseLike"),
                          IArray(TsTypeRef(NoComments, TsQIdent.boolean, Empty)),
                        ),
                      ),
                    ),
                  ),
                ),
              ),
              TsTypeObject(
                NoComments,
                IArray(
                  TsMemberProperty(
                    NoComments,
                    level = ProtectionLevel.Default,
                    name  = TsIdent("errors"),
                    tpe = Some(
                      TsTypeRef(
                        NoComments,
                        name    = TsQIdent.Array,
                        tparams = IArray(TsTypeRef(NoComments, TsQIdent.of("ValidationError"), Empty)),
                      ),
                    ),
                    expr       = None,
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false,
                  ),
                ),
              ),
            ),
          ),
          CodePath.NoPath,
        ),
      ),
    )

    shouldParseAs(content, TsParser.tsExport)(expected)
  }

  test("string expr types") {
    shouldParseAs("""toolbarPlacement?: "ProtectionLevel.Default" | "top" | "bottom"""", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        level = ProtectionLevel.Default,
        name  = TsIdent("toolbarPlacement"),
        tpe = Some(
          TsTypeUnion(
            IArray(
              TsTypeLiteral(TsLiteralString("ProtectionLevel.Default")),
              TsTypeLiteral(TsLiteralString("top")),
              TsTypeLiteral(TsLiteralString("bottom")),
            ),
          ),
        ),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = true,
      ),
    )
  }

  test("numeric literals type") {
    shouldParseAs("""primary_key?: 0 | 1 | boolean""", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        level = ProtectionLevel.Default,
        name  = TsIdent("primary_key"),
        tpe = Some(
          TsTypeUnion(
            IArray(
              TsTypeLiteral(TsLiteralNumber("0")),
              TsTypeLiteral(TsLiteralNumber("1")),
              TsTypeRef(NoComments, TsQIdent.boolean, Empty),
            ),
          ),
        ),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = true,
      ),
    )
  }

  test("negative numbers") {
    shouldParseAs("OTHER_CAUSE = -1", TsParser.tsEnumMembers.map(_.head))(
      TsEnumMember(NoComments, TsIdent("OTHER_CAUSE"), Some(TsExpr.Literal(TsLiteralNumber("-1")))),
    )
  }

  test("bigint literals") {
    shouldParseAs("-1n", TsParser.tsLiteral)(TsLiteralNumber("-1"))
  }

  test("this type") {
    shouldParseAs("useBasicAuth(apiKey: string): this", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("useBasicAuth"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(TsFunParam(NoComments, TsIdent("apiKey"), Some(TsTypeRef.string), isOptional = false)),
          Some(TsTypeThis()),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("`static` identifier") {
    shouldParseAs("static: boolean", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("static"),
        Some(TsTypeRef(NoComments, TsQIdent.boolean, Empty)),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("numeric identifier") {
    shouldParseAs("0?: string", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        level      = ProtectionLevel.Default,
        name       = TsIdent("0"),
        tpe        = Some(TsTypeRef.string),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = true,
      ),
    )
  }

  test("T extends (typeof)") {
    val content =
      """interface ComponentDecorator {
        |    <T extends (typeof FormComponent)>(component: T): T;
        |}
        |""".stripMargin

    shouldParseAs(content, TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("ComponentDecorator"),
        Empty,
        Empty,
        IArray(
          TsMemberCall(
            NoComments,
            ProtectionLevel.Default,
            TsFunSig(
              NoComments,
              IArray(
                TsTypeParam(
                  NoComments,
                  TsIdent("T"),
                  Some(TsTypeQuery(TsQIdent(IArray(TsIdent("FormComponent"))))),
                  None,
                ),
              ),
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdent("component"),
                  Some(TsTypeRef(NoComments, TsQIdent.of("T"), Empty)),
                  isOptional = false,
                ),
              ),
              Some(TsTypeRef(NoComments, TsQIdent.of("T"), Empty)),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("is types ") {
    shouldParseAs("function isValidElement<P>(object: {}): object is ReactElement<P>", TsParser.tsDeclFunction)(
      TsDeclFunction(
        NoComments,
        declared = false,
        TsIdent("isValidElement"),
        TsFunSig(
          NoComments,
          IArray(TsTypeParam(NoComments, TsIdent("P"), None, None)),
          IArray(
            TsFunParam(NoComments, TsIdent("object"), Some(TsTypeObject(NoComments, Empty)), isOptional = false),
          ),
          Some(
            TsTypeIs(
              TsIdent("object"),
              TsTypeRef(
                NoComments,
                TsQIdent.of("ReactElement"),
                IArray(TsTypeRef(NoComments, TsQIdent.of("P"), Empty)),
              ),
            ),
          ),
        ),
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("complex type with comment") {
    shouldParseAs(
      """when<T>(...deferreds: Array<T|JQueryPromise<T>/* as JQueryDeferred<T> */>): JQueryPromise<T>""".stripMargin,
      TsParser.tsMemberNamed,
    )(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("when"),
        TsFunSig(
          NoComments,
          IArray(TsTypeParam(NoComments, TsIdent("T"), None, None)),
          IArray(
            TsFunParam(
              NoComments,
              TsIdent("deferreds"),
              Some(
                TsTypeRepeated(
                  TsTypeUnion(
                    IArray(
                      TsTypeRef(NoComments, TsQIdent.of("T"), Empty),
                      TsTypeRef(
                        NoComments,
                        TsQIdent.of("JQueryPromise"),
                        IArray(TsTypeRef(NoComments, TsQIdent.of("T"), Empty)),
                      ),
                    ),
                  ),
                ),
              ),
              isOptional = false,
            ),
          ),
          Some(
            TsTypeRef(NoComments, TsQIdent.of("JQueryPromise"), IArray(TsTypeRef(NoComments, TsQIdent.of("T"), Empty))),
          ),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("extends union type - this will be interesting") {
    shouldParseAs(
      "function withRouter<C extends React.ComponentClass<any> | React.StatelessComponent<any> | React.PureComponent<any, any>>(component: C): C",
      TsParser.tsDeclFunction,
    )(
      TsDeclFunction(
        NoComments,
        declared = false,
        TsIdent("withRouter"),
        TsFunSig(
          NoComments,
          IArray(
            TsTypeParam(
              NoComments,
              TsIdent("C"),
              Some(
                TsTypeUnion(
                  IArray(
                    TsTypeRef(
                      NoComments,
                      TsQIdent.of("React", "ComponentClass"),
                      IArray(TsTypeRef(NoComments, TsQIdent.any, Empty)),
                    ),
                    TsTypeRef(
                      NoComments,
                      TsQIdent.of("React", "StatelessComponent"),
                      IArray(TsTypeRef(NoComments, TsQIdent.any, Empty)),
                    ),
                    TsTypeRef(
                      NoComments,
                      TsQIdent.of("React", "PureComponent"),
                      IArray(TsTypeRef(NoComments, TsQIdent.any, Empty), TsTypeRef(NoComments, TsQIdent.any, Empty)),
                    ),
                  ),
                ),
              ),
              None,
            ),
          ),
          IArray(
            TsFunParam(
              NoComments,
              TsIdent("component"),
              Some(TsTypeRef(NoComments, TsQIdent.of("C"), Empty)),
              isOptional = false,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent.of("C"), Empty)),
        ),
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("keyword identifiers are apparently legal") {
    shouldParseAs("module|module[]", TsParser.tsType)(
      TsTypeUnion(
        IArray(
          TsTypeRef(NoComments, TsQIdent.of("module"), Empty),
          TsTypeRef(NoComments, TsQIdent.Array, IArray(TsTypeRef(NoComments, TsQIdent.of("module"), Empty))),
        ),
      ),
    )

    shouldParseAs("public", TsParser.tsIdent)(
      TsIdent("public"),
    )

    shouldParseAs("public: boolean", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("public"),
        Some(TsTypeRef(NoComments, TsQIdent.boolean, Empty)),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )

    shouldParseAs("static public?: private", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("public"),
        Some(TsTypeRef(NoComments, TsQIdent.of("private"), Empty)),
        expr       = None,
        isStatic   = true,
        isReadOnly = false,
        isOptional = true,
      ),
    )
  }

  test("global") {
    shouldParseAs("global {}", TsParser.tsGlobal)(
      TsGlobal(NoComments, declared = false, Empty, CodePath.NoPath),
    )

    val m1 =
      """declare module "react-data-grid/addons" {
        |    /* attach to window */
        |    global {
        |        interface Window {
        |            i: number
        |        }
        |    }
        |}
        |""".stripMargin

    val windowMembers = IArray(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("i"),
        Some(TsTypeRef(NoComments, TsQIdent.number, Empty)),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )

    shouldParseAs(m1, TsParser.tsContainerOrDecl)(
      TsDeclModule(
        NoComments,
        declared = true,
        TsIdentModule(None, "react-data-grid" :: "addons" :: Nil),
        IArray(
          TsGlobal(
            NoComments,
            declared = false,
            IArray(
              TsDeclInterface(
                NoComments,
                declared = false,
                TsIdent("Window"),
                Empty,
                Empty,
                windowMembers,
                CodePath.NoPath,
              ),
            ),
            CodePath.NoPath,
          ),
        ),
        CodePath.NoPath,
        JsLocation.Zero,
      ),
    )

    val m2 =
      """declare global {
        |    namespace JSX {
        |        interface Element extends React.ReactElement<any> { }
        |    }
        |}
        |""".stripMargin

    val elementInterface = TsDeclInterface(
      NoComments,
      declared = false,
      TsIdent("Element"),
      Empty,
      IArray(
        TsTypeRef(NoComments, TsQIdent.of("React", "ReactElement"), IArray(TsTypeRef(NoComments, TsQIdent.any, Empty))),
      ),
      Empty,
      CodePath.NoPath,
    )

    shouldParseAs(m2, TsParser.tsContainerOrDecl)(
      TsGlobal(
        NoComments,
        declared = true,
        IArray(
          TsDeclNamespace(
            NoComments,
            declared = false,
            TsIdent("JSX"),
            IArray(elementInterface),
            CodePath.NoPath,
            JsLocation.Zero,
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("readonly") {
    val content =
      """interface WebGLActiveInfo {
        |    readonly name: string;
        |    readonly size: number;
        |    readonly type: number;
        |}
        |""".stripMargin

    shouldParseAs(content, TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("WebGLActiveInfo"),
        Empty,
        Empty,
        IArray(
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("name"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = true,
            isOptional = false,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("size"),
            tpe        = Some(TsTypeRef.number),
            expr       = None,
            isStatic   = false,
            isReadOnly = true,
            isOptional = false,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("type"),
            tpe        = Some(TsTypeRef.number),
            expr       = None,
            isStatic   = false,
            isReadOnly = true,
            isOptional = false,
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("string member field name") {
    val content =
      """    interface MDThemeHues {
        |        default?: string;
        |        'hue-1'?: string;
        |        'hue-2'?: string;
        |        'hue-3'?: string;
        |    }
        |""".stripMargin

    shouldParseAs(content, TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("MDThemeHues"),
        Empty,
        Empty,
        IArray(
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("default"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("hue-1"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("hue-2"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
          TsMemberProperty(
            NoComments,
            level      = ProtectionLevel.Default,
            name       = TsIdent("hue-3"),
            tpe        = Some(TsTypeRef.string),
            expr       = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true,
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("readonly index member") {
    val content = """{readonly [index: number]: string}"""
    shouldParseAs(content, TsParser.tsMembers)(
      IArray(
        TsMemberIndex(
          comments   = NoComments,
          isReadOnly = true,
          level      = ProtectionLevel.Default,
          indexing   = IndexingDict(TsIdent("index"), TsTypeRef(NoComments, TsQIdent.number, Empty)),
          valueType  = Some(TsTypeRef.string),
          isOptional = false,
        ),
      ),
    )
  }

  test("type queries / lookups") {

    val addEventListener =
      """addEventListener<K extends keyof MSBaseReaderEventMap>(type: K, listener: (this: FileReader, ev: MSBaseReaderEventMap[K]) => any, useCapture?: boolean): void"""

    shouldParseAs(addEventListener, TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("addEventListener"),
        TsFunSig(
          NoComments,
          IArray(
            TsTypeParam(
              NoComments,
              TsIdent("K"),
              Some(TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("MSBaseReaderEventMap"), Empty))),
              None,
            ),
          ),
          IArray(
            TsFunParam(
              NoComments,
              TsIdent("type"),
              Some(TsTypeRef(NoComments, TsQIdent.of("K"), Empty)),
              isOptional = false,
            ),
            TsFunParam(
              NoComments,
              TsIdent("listener"),
              Some(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Empty,
                    IArray(
                      TsFunParam(
                        NoComments,
                        TsIdent("this"),
                        Some(TsTypeRef(NoComments, TsQIdent.of("FileReader"), Empty)),
                        isOptional = false,
                      ),
                      TsFunParam(
                        NoComments,
                        TsIdent("ev"),
                        Some(
                          TsTypeLookup(
                            TsTypeRef(NoComments, TsQIdent.of("MSBaseReaderEventMap"), Empty),
                            TsTypeRef.of(TsIdent("K")),
                          ),
                        ),
                        isOptional = false,
                      ),
                    ),
                    Some(TsTypeRef(NoComments, TsQIdent.any, Empty)),
                  ),
                ),
              ),
              isOptional = false,
            ),
            TsFunParam(
              NoComments,
              TsIdent("useCapture"),
              Some(TsTypeRef(NoComments, TsQIdent.boolean, Empty)),
              isOptional = true,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent.void, Empty)),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )

    val Partial =
      """type Partial<T> = {
        |    [P in keyof T]?: T[P];
        |}""".stripMargin

    shouldParseAs(Partial, TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("Partial"),
        IArray(TsTypeParam(NoComments, TsIdent("T"), None, None)),
        TsTypeObject(
          NoComments,
          IArray(
            TsMemberTypeMapped(
              NoComments,
              level       = ProtectionLevel.Default,
              readonly    = ReadonlyModifier.Noop,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("T"), Empty)),
              optionalize = OptionalModifier.Optionalize,
              to          = TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Empty), TsTypeRef.of(TsIdent("P"))),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )

    val Pick =
      """type Pick<T, K extends keyof T> = {
        |    [P in K]: T[P];
        |}""".stripMargin

    shouldParseAs(Pick, TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("Pick"),
        IArray(
          TsTypeParam(NoComments, TsIdent("T"), None, None),
          TsTypeParam(
            NoComments,
            TsIdent("K"),
            Some(TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("T"), Empty))),
            None,
          ),
        ),
        TsTypeObject(
          NoComments,
          IArray(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = ProtectionLevel.Default,
              readonly    = ReadonlyModifier.Noop,
              key         = TsIdent("P"),
              from        = TsTypeRef(NoComments, TsQIdent.of("K"), Empty),
              optionalize = OptionalModifier.Noop,
              to          = TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Empty), TsTypeRef.of(TsIdent("P"))),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )

    val Proxify =
      """type Proxify<T> = {
        |    [P in keyof T]: { get(): T[P]; set(v: T[P]): void }
        |}""".stripMargin

    shouldParseAs(Proxify, TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("Proxify"),
        IArray(TsTypeParam(NoComments, TsIdent("T"), None, None)),
        TsTypeObject(
          NoComments,
          IArray(
            TsMemberTypeMapped(
              NoComments,
              level       = ProtectionLevel.Default,
              readonly    = ReadonlyModifier.Noop,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(T),
              optionalize = OptionalModifier.Noop,
              to = TsTypeObject(
                NoComments,
                IArray(
                  TsMemberFunction(
                    NoComments,
                    level = ProtectionLevel.Default,
                    name  = TsIdent("get"),
                    signature = TsFunSig(
                      NoComments,
                      Empty,
                      Empty,
                      Some(TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Empty), TsTypeRef.of(TsIdent("P")))),
                    ),
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false,
                  ),
                  TsMemberFunction(
                    NoComments,
                    ProtectionLevel.Default,
                    TsIdent("set"),
                    TsFunSig(
                      NoComments,
                      Empty,
                      IArray(
                        TsFunParam(
                          NoComments,
                          TsIdent("v"),
                          Some(
                            TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Empty), TsTypeRef.of(TsIdent("P"))),
                          ),
                          isOptional = false,
                        ),
                      ),
                      Some(TsTypeRef(NoComments, TsQIdent.void, Empty)),
                    ),
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false,
                  ),
                ),
              ),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )

    val Readonly = """
type Readonly<T> = {
    readonly [P in keyof T]: T[P];
}"""
    shouldParseAs(Readonly, TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Readonly"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeObject(
          NoComments,
          IArray(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = ProtectionLevel.Default,
              readonly    = ReadonlyModifier.Yes,
              key         = TsIdentSimple("P"),
              from        = TsTypeKeyOf(T),
              optionalize = Noop,
              to          = TsTypeLookup(T, TsTypeRef.of(TsIdentSimple("P"))),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )

  }

  test("symbols") {
    val content =
      """interface Symbol {
        |    readonly [Symbol.toStringTag]: "Symbol";
        |}
        |""".stripMargin

    shouldParseAs(content, TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("Symbol"),
        Empty,
        Empty,
        IArray(
          ts.TsMemberIndex(
            comments   = NoComments,
            isReadOnly = true,
            level      = ProtectionLevel.Default,
            indexing   = IndexingSingle(TsQIdent(IArray(TsIdent("Symbol"), TsIdent("toStringTag")))),
            isOptional = false,
            valueType  = Some(TsTypeLiteral(TsLiteralString("Symbol"))),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("expr symbols") {
    shouldParseAs("""["@@transducer/init"](): TResult | void""", TsParser.tsMember)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("@@transducer/init"),
        TsFunSig(
          NoComments,
          Empty,
          Empty,
          Some(
            TsTypeUnion(
              IArray(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("TResult"))), Empty), TsTypeRef.void),
            ),
          ),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("bug") {
    val content =
      """    function cloneElement<P extends Q, Q>(
        |        element: SFCElement<P>, // a
        |        props?: Q,
        |        ...children: ReactNode[]): SFCElement<P>
        |""".stripMargin

    shouldParseAs(content, TsParser.tsDeclFunction)(
      TsDeclFunction(
        NoComments,
        declared = false,
        TsIdent("cloneElement"),
        TsFunSig(
          NoComments,
          IArray(
            TsTypeParam(
              NoComments,
              TsIdent("P"),
              Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("Q"))), Empty)),
              None,
            ),
            TsTypeParam(NoComments, TsIdent("Q"), None, None),
          ),
          IArray(
            TsFunParam(
              NoComments,
              TsIdent("element"),
              Some(
                TsTypeRef(
                  NoComments,
                  TsQIdent(IArray(TsIdent("SFCElement"))),
                  IArray(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("P"))), Empty)),
                ),
              ),
              isOptional = false,
            ),
            TsFunParam(
              NoComments,
              TsIdent("props"),
              Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("Q"))), Empty)),
              isOptional = true,
            ),
            TsFunParam(
              NoComments,
              TsIdent("children"),
              Some(TsTypeRepeated(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("ReactNode"))), Empty))),
              isOptional = false,
            ),
          ),
          Some(
            TsTypeRef(
              NoComments,
              TsQIdent(IArray(TsIdent("SFCElement"))),
              IArray(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("P"))), Empty)),
            ),
          ),
        ),
        Zero,
        CodePath.NoPath,
      ),
    )

  }

  test("boolean expr") {
    shouldParseAs("true", TsParser.tsLiteral)(TsLiteralBoolean(true))
    shouldParseAs("false", TsParser.tsLiteral)(TsLiteralBoolean(false))
    shouldParseAs("boolean", TsParser.tsType)(
      TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("boolean"))), Empty),
    )
    shouldParseAs("trueSpeed: boolean", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("trueSpeed"),
        Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("boolean"))), Empty)),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("destructured parameter name") {
    shouldParseAs("static delegating({ token }: TokenAuthData): TokenHandshake", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("delegating"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(
            TsFunParam(
              NoComments,
              TsIdent("hasToken"),
              Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("TokenAuthData"))), Empty)),
              isOptional = false,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("TokenHandshake"))), Empty)),
        ),
        isStatic   = true,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("ProtectionLevel.Default type parameter") {
    shouldParseAs("interface Component<P = {}, S = {}> extends ComponentLifecycle<P, S> { }", TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("Component"),
        IArray(
          TsTypeParam(NoComments, TsIdent("P"), None, Some(TsTypeObject(NoComments, Empty))),
          TsTypeParam(NoComments, TsIdent("S"), None, Some(TsTypeObject(NoComments, Empty))),
        ),
        IArray(
          TsTypeRef(
            NoComments,
            TsQIdent(IArray(TsIdent("ComponentLifecycle"))),
            IArray(
              TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("P"))), Empty),
              TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("S"))), Empty),
            ),
          ),
        ),
        Empty,
        CodePath.NoPath,
      ),
    )
  }

  test("empty type") {
    shouldParseAs("isEmptyObject(obj: any): obj is {}", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("isEmptyObject"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(
            TsFunParam(NoComments, TsIdent("obj"), Some(TsTypeRef.any), isOptional = false),
          ),
          Some(TsTypeIs(TsIdent("obj"), TsTypeObject(NoComments, Empty))),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("prefixed union") {
    val content =
      """        loadOptions:
        | ((input: string) => Promise<AutocompleteResult>)
        | ((input: string, callback: (err: any, result: AutocompleteResult) => void) => void)
      """
    shouldParseAs(content, TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("loadOptions"),
        Some(
          TsTypeUnion(
            IArray(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(
                    TsFunParam(
                      NoComments,
                      TsIdent("input"),
                      Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("string"))), Empty)),
                      isOptional = false,
                    ),
                  ),
                  Some(
                    TsTypeRef(
                      NoComments,
                      TsQIdent(IArray(TsIdent("Promise"))),
                      IArray(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("AutocompleteResult"))), Empty)),
                    ),
                  ),
                ),
              ),
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(
                    TsFunParam(
                      NoComments,
                      TsIdent("input"),
                      Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("string"))), Empty)),
                      isOptional = false,
                    ),
                    TsFunParam(
                      NoComments,
                      TsIdent("callback"),
                      Some(
                        TsTypeFunction(
                          TsFunSig(
                            NoComments,
                            Empty,
                            IArray(
                              TsFunParam(NoComments, TsIdent("err"), Some(TsTypeRef.any), isOptional = false),
                              TsFunParam(
                                NoComments,
                                TsIdent("result"),
                                Some(
                                  TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("AutocompleteResult"))), Empty),
                                ),
                                isOptional = false,
                              ),
                            ),
                            Some(TsTypeRef.void),
                          ),
                        ),
                      ),
                      isOptional = false,
                    ),
                  ),
                  Some(TsTypeRef.void),
                ),
              ),
            ),
          ),
        ),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("keyof 1") {
    shouldParseAs("LoDashImplicitArrayWrapper<T[keyof T]>", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent(IArray(TsIdent("LoDashImplicitArrayWrapper"))),
        IArray(
          TsTypeLookup(
            TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("T"))), Empty),
            TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("T"))), Empty)),
          ),
        ),
      ),
    )
  }

  test("type lookup") {
    shouldParseAs("KeywordTypeNode[\"kind\"]", TsParser.tsType)(
      TsTypeLookup(
        TsTypeRef(NoComments, TsQIdent(IArray(TsIdent("KeywordTypeNode"))), Empty),
        TsTypeLiteral(TsLiteralString("kind")),
      ),
    )
  }

  test("double expr") {
    shouldParseAs("swipeVelocityThreshold: 0.25", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("swipeVelocityThreshold"),
        Some(TsTypeLiteral(TsLiteralNumber("0.25"))),
        expr       = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("keyof typeof") {
    shouldParseAs("type KEYWORD = keyof typeof cssKeywords", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("KEYWORD"),
        Empty,
        TsTypeKeyOf(TsTypeQuery(TsQIdent(IArray(TsIdentSimple("cssKeywords"))))),
        CodePath.NoPath,
      ),
    )
  }

  test("class extends method call? wtf") {
    shouldParseAs(
      """       class ManyArray<T> extends Ember.Object.extend(
            Ember.MutableArray,
            Ember.Evented
        ) {}
 """,
      TsParser.tsDeclClass,
    )(
      TsDeclClass(
        NoComments,
        declared   = false,
        isAbstract = false,
        TsIdentSimple("ManyArray"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        Some(TsTypeRef.any),
        Empty,
        Empty,
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("trailing comma in tparams") {
    shouldParseAs("""interface A<B, C,> {}""", TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdentSimple("A"),
        IArray(
          TsTypeParam(NoComments, TsIdentSimple("B"), None, None),
          TsTypeParam(NoComments, TsIdentSimple("C"), None, None),
        ),
        Empty,
        Empty,
        CodePath.NoPath,
      ),
    )
  }

  test("destructured parameter") {
    val content =
      """
    searchForFacetValues({
      facetName,
      facetQuery,
      ...qp,
    }: {
      facetName: string;
      facetQuery: string;
    } & AlgoliaQueryParameters): Promise<any>
"""
    shouldParseAs(content, TsParser.tsMember)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("searchForFacetValues"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(
            TsFunParam(
              NoComments,
              TsIdentSimple("hasFacetNameFacetQueryQp"),
              Some(
                TsTypeIntersect(
                  IArray(
                    TsTypeObject(
                      NoComments,
                      IArray(
                        TsMemberProperty(
                          NoComments,
                          ProtectionLevel.Default,
                          TsIdentSimple("facetName"),
                          Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("string"))), Empty)),
                          expr       = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false,
                        ),
                        TsMemberProperty(
                          NoComments,
                          ProtectionLevel.Default,
                          TsIdentSimple("facetQuery"),
                          Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("string"))), Empty)),
                          expr       = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false,
                        ),
                      ),
                    ),
                    TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("AlgoliaQueryParameters"))), Empty),
                  ),
                ),
              ),
              isOptional = false,
            ),
          ),
          Some(
            TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Promise"))), IArray(TsTypeRef.any)),
          ),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("destructured parameter 2") {
    val content =
      """class PartialValueApplicator extends Applicator {
    apply({args, target, value, config: {execute}}: ApplicateOptions): any;
  }
"""
    shouldParseAs(content, TsParser.tsDeclClass)(
      TsDeclClass(
        NoComments,
        declared   = false,
        isAbstract = false,
        TsIdentSimple("PartialValueApplicator"),
        Empty,
        Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Applicator"))), Empty)),
        Empty,
        IArray(
          TsMemberFunction(
            NoComments,
            ProtectionLevel.Default,
            TsIdentSimple("apply"),
            TsFunSig(
              NoComments,
              Empty,
              IArray(
                TsFunParam(
                  NoComments,
                  TsIdentSimple("hasArgsTargetValueConfig"),
                  Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("ApplicateOptions"))), Empty)),
                  isOptional = false,
                ),
              ),
              Some(TsTypeRef.any),
            ),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false,
          ),
        ),
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("bivarianceHack") {
    shouldParseAs(
      "type EventHandler<E extends SyntheticEvent<any>> = { bivarianceHack(event: E): void }[\"bivarianceHack\"]",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("EventHandler"),
        IArray(
          TsTypeParam(
            NoComments,
            TsIdentSimple("E"),
            Some(
              TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("SyntheticEvent"))), IArray(TsTypeRef.any)),
            ),
            None,
          ),
        ),
        TsTypeLookup(
          TsTypeObject(
            NoComments,
            IArray(
              TsMemberFunction(
                NoComments,
                ProtectionLevel.Default,
                TsIdentSimple("bivarianceHack"),
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(
                    TsFunParam(
                      NoComments,
                      TsIdentSimple("event"),
                      Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("E"))), Empty)),
                      isOptional = false,
                    ),
                  ),
                  Some(TsTypeRef.void),
                ),
                isStatic   = false,
                isReadOnly = false,
                isOptional = false,
              ),
            ),
          ),
          TsTypeLiteral(TsLiteralString("bivarianceHack")),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("double type lookup") {
    val RTS = TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("RTS"))), Empty)
    shouldParseAs("""UnionType<RTS, RTS["_A"]["_A"], RTS["_A"]["_O"], mixed>""", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent(IArray(TsIdentSimple("UnionType"))),
        IArray(
          RTS,
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_A"))),
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_O"))),
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("mixed"))), Empty),
        ),
      ),
    )
  }

  test("further enum stuff") {
    val content =
      """    const enum Button {
        MINUS = 0x00000004,
        SELECT = MINUS, } """
    shouldParseAs(content, TsParser.tsDeclEnum)(
      TsDeclEnum(
        NoComments,
        declared = false,
        isConst  = true,
        TsIdentSimple("Button"),
        IArray(
          TsEnumMember(NoComments, TsIdentSimple("MINUS"), Some(TsExpr.Literal(TsLiteralNumber("0x00000004")))),
          TsEnumMember(NoComments, TsIdentSimple("SELECT"), Some(TsExpr.Ref(TsTypeRef.of(TsIdentSimple("MINUS"))))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath,
      ),
    )
  }

  test("Exclude") {
    shouldParseAs("type Exclude<T, U> = T extends U ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Exclude"),
        IArray(
          TsTypeParam(NoComments, TsIdentSimple("T"), None, None),
          TsTypeParam(NoComments, TsIdentSimple("U"), None, None),
        ),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("U"))), Empty)),
          TsTypeRef.never,
          T,
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("Extract") {
    shouldParseAs("type Extract<T, U> = T extends U ? T : never", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Extract"),
        IArray(
          TsTypeParam(NoComments, TsIdentSimple("T"), None, None),
          TsTypeParam(NoComments, TsIdentSimple("U"), None, None),
        ),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("U"))), Empty)),
          T,
          TsTypeRef.never,
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("NonNullable") {
    shouldParseAs("type NonNullable<T> = T extends null | undefined ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("NonNullable"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeUnion(IArray(TsTypeRef.`null`, TsTypeRef.undefined))),
          TsTypeRef.never,
          T,
        ),
        CodePath.NoPath,
      ),
    )
  }
  test("ReturnType") {
    shouldParseAs(
      "type ReturnType<T extends (...args: any[]) => any> = T extends (...args: any[]) => infer R ? R : any",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("ReturnType"),
        IArray(
          TsTypeParam(
            NoComments,
            TsIdentSimple("T"),
            Some(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(
                    TsFunParam(
                      NoComments,
                      TsIdentSimple("args"),
                      Some(TsTypeRepeated(TsTypeRef.any)),
                      isOptional = false,
                    ),
                  ),
                  Some(TsTypeRef.any),
                ),
              ),
            ),
            None,
          ),
        ),
        TsTypeConditional(
          TsTypeExtends(
            T,
            TsTypeFunction(
              TsFunSig(
                NoComments,
                Empty,
                IArray(
                  TsFunParam(
                    NoComments,
                    TsIdentSimple("args"),
                    Some(TsTypeRepeated(TsTypeRef.any)),
                    isOptional = false,
                  ),
                ),
                Some(TsTypeInfer(TsTypeParam(NoComments, TsIdentSimple("R"), None, None))),
              ),
            ),
          ),
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("R"))), Empty),
          TsTypeRef.any,
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("InstanceType") {
    shouldParseAs(
      "type InstanceType<T extends new (...args: any[]) => any> = T extends new (...args: any[]) => infer R ? R : any",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("InstanceType"),
        IArray(
          TsTypeParam(
            NoComments,
            TsIdentSimple("T"),
            Some(
              TsTypeConstructor(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Empty,
                    IArray(
                      TsFunParam(
                        NoComments,
                        TsIdentSimple("args"),
                        Some(TsTypeRepeated(TsTypeRef.any)),
                        isOptional = false,
                      ),
                    ),
                    Some(TsTypeRef.any),
                  ),
                ),
              ),
            ),
            None,
          ),
        ),
        TsTypeConditional(
          TsTypeExtends(
            T,
            TsTypeConstructor(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Empty,
                  IArray(
                    TsFunParam(
                      NoComments,
                      TsIdentSimple("args"),
                      Some(TsTypeRepeated(TsTypeRef.any)),
                      isOptional = false,
                    ),
                  ),
                  Some(TsTypeInfer(TsTypeParam(NoComments, TsIdentSimple("R"), None, None))),
                ),
              ),
            ),
          ),
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("R"))), Empty),
          TsTypeRef.any,
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("inverted optional type mapping") {
    shouldParseAs(
      "type Required<T> = {[P in keyof T]-?: T[P]}",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Required"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeObject(
          NoComments,
          IArray(
            TsMemberTypeMapped(
              NoComments,
              ProtectionLevel.Default,
              ReadonlyModifier.Noop,
              TsIdentSimple("P"),
              TsTypeKeyOf(T),
              OptionalModifier.Deoptionalize,
              TsTypeLookup(T, TsTypeRef.of(TsIdentSimple("P"))),
            ),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("destructured renamed") {
    shouldParseAs(
      "mutate<T>({optimisticResponse, updateQueries: updateQueriesByName, refetchQueries, update: updateWithProxyFn, errorPolicy}: Fpp): Promise<Bar<T>>",
      TsParser.tsMember,
    )(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("mutate"),
        TsFunSig(
          NoComments,
          IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
          IArray(
            TsFunParam(
              NoComments,
              TsIdentSimple("hasOptimisticResponseUpdateQueriesRefetchQueriesUpdateErrorPolicy"),
              Some(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Fpp"))), Empty)),
              isOptional = false,
            ),
          ),
          Some(
            TsTypeRef(
              NoComments,
              TsQIdent(IArray(TsIdentSimple("Promise"))),
              IArray(
                TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Bar"))), IArray(T)),
              ),
            ),
          ),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("unique symbol") {
    shouldParseAs(
      "const foo: unique symbol",
      TsParser.tsDeclVars,
    )(
      IArray(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdentSimple("foo"),
          Some(TsTypeRef.Symbol),
          None,
          Zero,
          CodePath.NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("conditional types part 2") {
    val TT    = T
    val True  = TsTypeLiteral(TsLiteralBoolean(true))
    val False = TsTypeLiteral(TsLiteralBoolean(false))
    shouldParseAs(
      "type IsOptional<T> = undefined | null extends T ? true : undefined extends T ? true : null extends T ? true : false",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("IsOptional"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeConditional(
          TsTypeExtends(TsTypeUnion(IArray(TsTypeRef.undefined, TsTypeRef.`null`)), TT),
          True,
          TsTypeConditional(
            TsTypeExtends(TsTypeRef.undefined, TT),
            True,
            TsTypeConditional(TsTypeExtends(TsTypeRef.`null`, TT), True, False),
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("indexed type again") {
    shouldParseAs(
      "interface Validator<T> { [nominalTypeHack]?: T }",
      TsParser.tsDeclInterface,
    )(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdentSimple("Validator"),
        IArray(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        Empty,
        IArray(
          ts.TsMemberIndex(
            comments   = NoComments,
            isReadOnly = false,
            level      = ProtectionLevel.Default,
            indexing   = IndexingSingle(TsQIdent(IArray(TsIdentSimple("nominalTypeHack")))),
            valueType  = Some(T),
            isOptional = true,
          ),
        ),
        CodePath.NoPath,
      ),
    )
  }

  test("destructured array parameter") {
    shouldParseAs(
      " const keyValsToObjectR: (accum: any, [key, val]: [any, any]) => any",
      TsParser.tsDeclVars,
    )(
      IArray(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdentSimple("keyValsToObjectR"),
          Some(
            TsTypeFunction(
              TsFunSig(
                NoComments,
                Empty,
                IArray(
                  TsFunParam(NoComments, TsIdentSimple("accum"), Some(TsTypeRef.any), isOptional = false),
                  TsFunParam(
                    NoComments,
                    TsIdentSimple("hasKeyVal"),
                    Some(TsTypeTuple(IArray(TsTypeRef.any, TsTypeRef.any))),
                    isOptional = false,
                  ),
                ),
                Some(TsTypeRef.any),
              ),
            ),
          ),
          None,
          Zero,
          CodePath.NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("import types") {
    shouldParseAs(
      "var foo: import('@babel/types').Foo",
      TsParser.tsDeclVars,
    )(
      IArray(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = false,
          TsIdentSimple("foo"),
          Some(
            TsTypeRef(
              NoComments,
              TsQIdent(IArray(TsIdentImport(TsIdentModule(Some("babel"), List("types"))), TsIdentSimple("Foo"))),
              Empty,
            ),
          ),
          None,
          Zero,
          CodePath.NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("tuple optional") {
    shouldParseAs(
      "[number, number?]",
      TsParser.tsType,
    )(
      TsTypeTuple(IArray(TsTypeRef.number, TsTypeUnion(IArray(TsTypeRef.number, TsTypeRef.undefined)))),
    )
  }

  test("tuple variable") {
    shouldParseAs(
      "[number, number, ...T[]]",
      TsParser.tsType,
    )(
      TsTypeTuple(
        IArray(
          TsTypeRef(NoComments, TsQIdent.number, Empty),
          TsTypeRef(NoComments, TsQIdent.number, Empty),
          TsTypeRepeated(TsTypeRef(NoComments, TsQIdent.Array, IArray(TsTypeRef(NoComments, TsQIdent.of("T"), Empty)))),
        ),
      ),
    )
  }

  test("typeof import()") {
    shouldParseAs(
      "const sdk: typeof import(\"aws-sdk\")",
      TsParser.tsDeclVars,
    )(
      IArray(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdentSimple("sdk"),
          Some(TsTypeQuery(TsQIdent(IArray(TsIdentImport(TsIdentModule(None, List("aws-sdk"))))))),
          None,
          Zero,
          CodePath.NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("lookup of array") {
    shouldParseAs(
      """T[]['forEach']""",
      TsParser.tsType,
    )(
      TsTypeLookup(
        TsTypeRef(
          NoComments,
          TsQIdent.Array,
          IArray(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("T"))), Empty)),
        ),
        TsTypeLiteral(TsLiteralString("forEach")),
      ),
    )

    shouldParseAs(
      """T['forEach'][]""",
      TsParser.tsType,
    )(
      TsTypeRef(
        NoComments,
        TsQIdent.Array,
        IArray(
          TsTypeLookup(
            TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("T"))), Empty),
            TsTypeLiteral(TsLiteralString("forEach")),
          ),
        ),
      ),
    )
  }
  test("readonly type modifier") {
    shouldParseAs(
      """ReadonlyArray<readonly [K, V]>""",
      TsParser.tsType,
    )(
      TsTypeRef(
        NoComments,
        TsQIdent(IArray(TsIdentSimple("ReadonlyArray"))),
        IArray(
          TsTypeTuple(
            IArray(
              TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("K"))), IArray()),
              TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("V"))), IArray()),
            ),
          ),
        ),
      ),
    )
  }

  test("initial shebang") {
    shouldParseAs(
      """#!/usr/bin/env node
export {};
""",
      TsParser.parsedTsFile,
    )(
      TsParsedFile(
        NoComments,
        Empty,
        IArray(TsExport(NoComments, ExportType.Named, TsExporteeNames(Empty, None))),
        CodePath.NoPath,
      ),
    )
  }

  test("new bug") {
    shouldParseAs(
      """private readonly [kChannel]""",
      TsParser.tsMember,
    )(
      TsMemberIndex(
        NoComments,
        isReadOnly = false,
        ProtectionLevel.Private,
        IndexingSingle(TsQIdent(IArray(TsIdentSimple("kChannel")))),
        isOptional = false,
        None,
      ),
    )
  }

  test("readonly again") {
    shouldParseAs("""{ [attributeName: string]: string | number | boolean | readonly string[]; }""", TsParser.tsType)(
      TsTypeObject(
        NoComments,
        IArray(
          TsMemberIndex(
            NoComments,
            isReadOnly = false,
            ProtectionLevel.Default,
            IndexingDict(TsIdentSimple("attributeName"), TsTypeRef.string),
            isOptional = false,
            Some(
              TsTypeUnion(
                IArray(
                  TsTypeRef.string,
                  TsTypeRef.number,
                  TsTypeRef.boolean,
                  TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("Array"))), IArray(TsTypeRef.string)),
                ),
              ),
            ),
          ),
        ),
      ),
    )
  }

  test("({}: {}, {}: {}) workaround") {
    shouldParseAs("""protected _Handle_insert({}: {}, {}: {}): void""", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Protected,
        TsIdentSimple("_Handle_insert"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(
            TsFunParam(NoComments, TsIdentSimple("has0"), Some(TsTypeObject(NoComments, IArray())), isOptional = false),
            TsFunParam(NoComments, TsIdentSimple("has1"), Some(TsTypeObject(NoComments, IArray())), isOptional = false),
          ),
          Some(TsTypeRef.void),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )
  }

  test("[...]+?:") {
    val key = TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("key"))), IArray())
    val T   = TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("T"))), IArray()))

    shouldParseAs("""[key in keyof T]+?: T[key]""", TsParser.tsMemberTypeMapped)(
      TsMemberTypeMapped(
        NoComments,
        ProtectionLevel.Default,
        ReadonlyModifier.Noop,
        TsIdentSimple("key"),
        T,
        OptionalModifier.Optionalize,
        TsTypeLookup(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("T"))), IArray()), key),
      ),
    )
  }

  test("-readonly") {
    shouldParseAs("""{-readonly [P in keyof T]: number}""", TsParser.tsMembers)(
      IArray(
        TsMemberTypeMapped(
          NoComments,
          ProtectionLevel.Default,
          ReadonlyModifier.No,
          TsIdentSimple("P"),
          TsTypeKeyOf(T),
          Noop,
          TsTypeRef.number,
        ),
      ),
    )
  }

  test("asserts types") {
    shouldParseAs("""asserts assertion""", TsParser.tsType)(
      TsTypeAsserts(TsIdent("assertion"), None),
    )
    shouldParseAs("""asserts actual is T""".stripMargin, TsParser.tsType)(TsTypeAsserts(TsIdent("actual"), Some(T)))
  }

  test("[string, ...PrimitiveArray]") {
    shouldParseAs("""[string, ...PrimitiveArray]""", TsParser.tsTypeTuple)(
      TsTypeTuple(IArray(TsTypeRef.string, TsTypeRepeated(TsTypeRef.of(TsIdentSimple("PrimitiveArray"))))),
    )
  }

  test("expr with parents") {
    shouldParseAs("""(1 << 2)""", TsParser.expr)(
      TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("1")), "<<", TsExpr.Literal(TsLiteralNumber("2"))),
    )
  }

  test("stray ;") {
    shouldParseAs(
      """|class A {
         |  ;
         |  public operator: string
         |}""".stripMargin,
      TsParser.tsDecl,
    )(
      TsDeclClass(
        NoComments,
        declared   = false,
        isAbstract = false,
        TsIdentSimple("A"),
        IArray(),
        None,
        IArray(),
        IArray(
          TsMemberProperty(
            NoComments,
            ProtectionLevel.Default,
            TsIdentSimple("operator"),
            Some(TsTypeRef(NoComments, TsQIdent.string, IArray())),
            None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = false,
          ),
        ),
        Zero,
        CodePath.NoPath,
      ),
    )
  }
  test("expr") {
    shouldParseAs(
      """export declare const start = ActionTypes.Start""",
      TsParser.tsDecl,
    )(
      TsExport(
        NoComments,
        ExportType.Named,
        TsExporteeTree(
          TsDeclVar(
            NoComments,
            declared = true,
            readOnly = true,
            TsIdentSimple("start"),
            None,
            Some(
              TsExpr
                .Ref(
                  TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("ActionTypes"), TsIdentSimple("Start"))), Empty),
                ),
            ),
            Zero,
            CodePath.NoPath,
            isOptional = false,
          ),
        ),
      ),
    )

    shouldParseAs("""(LoggingLevel.ERROR)""", TsParser.expr)(
      TsExpr.Ref(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("LoggingLevel"), TsIdentSimple("ERROR"))), Empty)),
    )
    shouldParseAs("""WARNING""", TsParser.expr)(
      TsExpr.Ref(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("WARNING"))), Empty)),
    )
    shouldParseAs("""LoggingLevel.ERROR | WARNING""", TsParser.expr)(
      TsExpr.BinaryOp(
        TsExpr
          .Ref(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("LoggingLevel"), TsIdentSimple("ERROR"))), Empty)),
        "|",
        TsExpr.Ref(TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("WARNING"))), Empty)),
      ),
    )
    shouldParseAs("""LoggingLevel.ERROR(6 + 7)""", TsParser.expr)(
      TsExpr.Call(
        TsExpr.Ref(
          TsTypeRef(NoComments, TsQIdent(IArray(TsIdentSimple("LoggingLevel"), TsIdentSimple("ERROR"))), Empty),
        ),
        List(TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("6")), "+", TsExpr.Literal(TsLiteralNumber("7")))),
      ),
    )

    shouldParseAs("""public expire(key: string, ms: number = 0): void""", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdentSimple("expire"),
        TsFunSig(
          NoComments,
          Empty,
          IArray(
            TsFunParam(NoComments, TsIdentSimple("key"), Some(TsTypeRef.string), isOptional = false),
            TsFunParam(NoComments, TsIdentSimple("ms"), Some(TsTypeRef.number), isOptional  = false),
          ),
          Some(TsTypeRef.void),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )

    shouldParseAs("""1e-7""", TsParser.expr)(
      TsExpr.Literal(TsLiteralNumber("1e-7")),
    )

    shouldParseAs("""(0x000FFFF2 + 2)""", TsParser.expr)(
      TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("0x000FFFF2")), "+", TsExpr.Literal(TsLiteralNumber("2"))),
    )
    shouldParseAs("""(4)""", TsParser.expr)(
      TsExpr.Literal(TsLiteralNumber("4")),
    )

    shouldParseAs("""(4) >> 2""", TsParser.expr)(
      TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("4")), ">>", TsExpr.Literal(TsLiteralNumber("2"))),
    )

    shouldParseAs("""(0x000FFFFF + 1) >> 2""", TsParser.expr)(
      TsExpr.BinaryOp(
        TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("0x000FFFFF")), "+", TsExpr.Literal(TsLiteralNumber("1"))),
        ">>",
        TsExpr.Literal(TsLiteralNumber("2")),
      ),
    )
  }
}
