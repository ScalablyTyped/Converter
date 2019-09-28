package com.olvind.tso
package ts
package parser

import com.olvind.tso.ts.CodePath.NoPath
import com.olvind.tso.ts.JsLocation.Zero
import com.olvind.tso.ts.OptionalModifier.Noop
import org.scalatest.Matchers._
import org.scalatest._

final class ParserTests extends FunSuite {
  private val T = TsTypeRef(TsIdent("T"))
  private val TParam: TsTypeParam = TsTypeParam(NoComments, TsIdent("T"), None, None)

  import ParserHarness._

  test("whole file") {
    withTsFile("parsertests/path-case.d.ts") { content =>
      val expected =
        TsParsedFile(
          NoComments,
          Seq(DirectivePathRef("./path-case.d.ts")),
          List(
            TsDeclModule(
              NoComments,
              declared = true,
              name     = TsIdentModule.simple("path-case"),
              members = List(
                TsDeclFunction(
                  NoComments,
                  declared = false,
                  name     = TsIdent("pathCase"),
                  signature = TsFunSig(
                    NoComments,
                    Nil,
                    List(
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
                  NoPath,
                ),
                TsExport(
                  NoComments,
                  ExportType.Namespaced,
                  TsExporteeNames(Seq((TsQIdent(List(TsIdent("pathCase"))), None)), None),
                ),
              ),
              NoPath,
              JsLocation.Zero,
            ),
          ),
          NoPath,
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
      List(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = false,
          TsIdent("_"),
          Some(TsTypeRef.string),
          None,
          Zero,
          NoPath,
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
        tparams     = Nil,
        inheritance = Nil,
        members = List(
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
        NoPath,
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
        tparams    = Nil,
        parent     = None,
        implements = Nil,
        members = List(
          TsMemberFunction(
            NoComments,
            level = ProtectionLevel.Default,
            name  = TsIdent.constructor,
            signature = TsFunSig(
              NoComments,
              Nil,
              List(
                TsFunParam(
                  NoComments,
                  TsIdent("params"),
                  tpe = Some(
                    TsTypeObject(
                      NoComments,
                      members = List(
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
            signature  = TsFunSig(NoComments, tparams = Nil, params = Nil, resultType = Some(TsTypeRef.void)),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false,
          ),
        ),
        Zero,
        NoPath,
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
        List(
          TsEnumMember(NoComments, TsIdent("ERROR"), Some(TsExpr.Literal(TsLiteralNumber("0")))),
          TsEnumMember(NoComments, TsIdent("WARNING"), Some(TsExpr.Literal(TsLiteralNumber("1")))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        NoPath,
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
        List(
          TsEnumMember(NoComments, TsIdent("OTHER_CAUSE"), Some(TsExpr.Literal(TsLiteralNumber("-1")))),
          TsEnumMember(NoComments, TsIdent("INTERNAL_SERVER_ERROR"), Some(TsExpr.Literal(TsLiteralNumber("1")))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        NoPath,
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
        List(
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
        NoPath,
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

    TreeTraverse
      .collect(tree) {
        case t: TsMemberFunction => t.comments
        case t: TsMemberProperty => t.comments
      }
      .flatMap(_.cs)
      .size should be(3)

    TreeTraverse.collect(tree) {
      case TsMemberProperty(_, level, _, _, _, false, _, _)                => level
      case TsMemberFunction(_, level, TsIdent.constructor, _, false, _, _) => level
    } should be(List(ProtectionLevel.Protected, ProtectionLevel.Private, ProtectionLevel.Default))

    TreeTraverse
      .collect(tree) {
        case TsMemberProperty(_, _, _, tpe, _, false, _, _) => tpe
      }
      .distinct should be(List(None))
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

    val names: Traversable[String] =
      TreeTraverse.collect(res) {
        case TsDeclVar(
            _,
            _,
            _,
            TsIdent(name),
            Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("BrorandStatic"))), _)),
            None,
            _,
            _,
            _,
            ) =>
          name
      }

    names should equal(Seq("Brorand1", "Brorand2", "Brorand3"))
  }

  test("constructor type literals") {
    shouldParseAs(
      "type ActionsClassConstructor = new (alt:Alt) => AltJS.ActionsClass",
      TsParser.tsDeclTypeAlias,
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("ActionsClassConstructor"),
        Nil,
        TsTypeConstructor(
          TsTypeFunction(
            TsFunSig(
              NoComments,
              Nil,
              List(TsFunParam(NoComments, TsIdent("alt"), Some(TsTypeRef(TsIdent("Alt"))), isOptional = false)),
              Some(TsTypeRef(TsQIdent(List(TsIdent("AltJS"), TsIdent("ActionsClass"))))),
            ),
          ),
        ),
        NoPath,
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
        Nil,
        TsTypeUnion(Seq(TsTypeRef.string, TsTypeRef(TsIdent("CanvasGradient")), TsTypeRef(TsIdent("CanvasPattern")))),
        NoPath,
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
              tparams = List(
                TsTypeParam(
                  NoComments,
                  name = TsIdent("Domain"),
                  upperBound = Some(
                    TsTypeObject(
                      NoComments,
                      members = List(
                        TsMemberFunction(
                          NoComments,
                          level = ProtectionLevel.Default,
                          name  = TsIdent("toString"),
                          signature =
                            TsFunSig(NoComments, tparams = Nil, params = Nil, resultType = Some(TsTypeRef.string)),
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
              params = Nil,
              resultType = Some(
                TsTypeRef(
                  NoComments,
                  name    = TsQIdent.of("Ordinal"),
                  tparams = List(TsTypeRef(TsIdent("Domain")), TsTypeRef(TsIdent("Range"))),
                ),
              ),
            ),
            Zero,
            NoPath,
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
          Nil,
          TsTypeIntersect(
            Seq(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(TsFunParam(NoComments, name = TsIdent("data"), tpe = Some(TsTypeRef.any), isOptional = false)),
                  Some(
                    TsTypeUnion(
                      Seq(
                        TsTypeRef.boolean,
                        TsTypeRef(NoComments, TsQIdent.of("PromiseLike"), List(TsTypeRef.boolean)),
                      ),
                    ),
                  ),
                ),
              ),
              TsTypeObject(
                NoComments,
                List(
                  TsMemberProperty(
                    NoComments,
                    level = ProtectionLevel.Default,
                    name  = TsIdent("errors"),
                    tpe = Some(
                      TsTypeRef(
                        NoComments,
                        name    = TsQIdent.Array,
                        tparams = List(TsTypeRef(TsIdent("ValidationError"))),
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
          NoPath,
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
            Seq(
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
            Seq(TsTypeLiteral(TsLiteralNumber("0")), TsTypeLiteral(TsLiteralNumber("1")), TsTypeRef.boolean),
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
          Nil,
          List(TsFunParam(NoComments, TsIdent("apiKey"), Some(TsTypeRef.string), isOptional = false)),
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
        Some(TsTypeRef.boolean),
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
        Nil,
        Nil,
        List(
          TsMemberCall(
            NoComments,
            ProtectionLevel.Default,
            TsFunSig(
              NoComments,
              List(
                TsTypeParam(
                  NoComments,
                  TsIdent("T"),
                  Some(TsTypeQuery(TsQIdent(List(TsIdent("FormComponent"))))),
                  None,
                ),
              ),
              List(TsFunParam(NoComments, TsIdent("component"), Some(T), isOptional = false)),
              Some(T),
            ),
          ),
        ),
        NoPath,
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
          List(TsTypeParam(NoComments, TsIdent("P"), None, None)),
          List(TsFunParam(NoComments, TsIdent("object"), Some(TsTypeObject(NoComments, Nil)), isOptional = false)),
          Some(
            TsTypeIs(
              TsIdent("object"),
              TsTypeRef(NoComments, TsQIdent.of("ReactElement"), List(TsTypeRef(TsIdent("P")))),
            ),
          ),
        ),
        Zero,
        NoPath,
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
          List(TParam),
          List(
            TsFunParam(
              NoComments,
              TsIdent("deferreds"),
              Some(TsTypeRepeated(TsTypeUnion(Seq(T, TsTypeRef(NoComments, TsQIdent.of("JQueryPromise"), List(T)))))),
              isOptional = false,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent.of("JQueryPromise"), List(T))),
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
          List(
            TsTypeParam(
              NoComments,
              TsIdent("C"),
              Some(
                TsTypeUnion(
                  Seq(
                    TsTypeRef(NoComments, TsQIdent.of("React", "ComponentClass"), List(TsTypeRef.any)),
                    TsTypeRef(NoComments, TsQIdent.of("React", "StatelessComponent"), List(TsTypeRef.any)),
                    TsTypeRef(NoComments, TsQIdent.of("React", "PureComponent"), List(TsTypeRef.any, TsTypeRef.any)),
                  ),
                ),
              ),
              None,
            ),
          ),
          List(TsFunParam(NoComments, TsIdent("component"), Some(TsTypeRef(TsIdent("C"))), isOptional = false)),
          Some(TsTypeRef(TsIdent("C"))),
        ),
        Zero,
        NoPath,
      ),
    )
  }

  test("keyword identifiers are apparently legal") {
    shouldParseAs("module|module[]", TsParser.tsType)(
      TsTypeUnion(
        Seq(TsTypeRef(TsIdent("module")), TsTypeRef(NoComments, TsQIdent.Array, List(TsTypeRef(TsIdent("module"))))),
      ),
    )

    shouldParseAs("public", TsParser.tsIdent)(TsIdent("public"))

    shouldParseAs("public: boolean", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("public"),
        Some(TsTypeRef.boolean),
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
        Some(TsTypeRef(TsIdent("private"))),
        expr       = None,
        isStatic   = true,
        isReadOnly = false,
        isOptional = true,
      ),
    )
  }

  test("global") {
    shouldParseAs("global {}", TsParser.tsGlobal)(
      TsGlobal(NoComments, declared = false, Nil, NoPath),
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

    val windowMembers = List(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("i"),
        Some(TsTypeRef.number),
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
        List(
          TsGlobal(
            NoComments,
            declared = false,
            List(
              TsDeclInterface(
                NoComments,
                declared = false,
                TsIdent("Window"),
                Nil,
                Nil,
                windowMembers,
                NoPath,
              ),
            ),
            NoPath,
          ),
        ),
        NoPath,
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

    shouldParseAs(m2, TsParser.tsContainerOrDecl)(
      TsGlobal(
        NoComments,
        declared = true,
        List(
          TsDeclNamespace(
            NoComments,
            declared = false,
            TsIdent("JSX"),
            List(
              TsDeclInterface(
                NoComments,
                declared = false,
                TsIdent("Element"),
                Nil,
                List(TsTypeRef(NoComments, TsQIdent.of("React", "ReactElement"), List(TsTypeRef.any))),
                Nil,
                NoPath,
              ),
            ),
            NoPath,
            JsLocation.Zero,
          ),
        ),
        NoPath,
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
        Nil,
        Nil,
        List(
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
        NoPath,
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
        Nil,
        Nil,
        List(
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
        NoPath,
      ),
    )
  }

  test("readonly index member") {
    val content = """{readonly [index: number]: string}"""
    shouldParseAs(content, TsParser.tsMembers)(
      List(
        TsMemberIndex(
          comments   = NoComments,
          isReadOnly = true,
          level      = ProtectionLevel.Default,
          indexing   = IndexingDict(TsIdent("index"), TsTypeRef.number),
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
          List(
            TsTypeParam(NoComments, TsIdent("K"), Some(TsTypeKeyOf(TsTypeRef(TsIdent("MSBaseReaderEventMap")))), None),
          ),
          List(
            TsFunParam(NoComments, TsIdent("type"), Some(TsTypeRef(TsIdent("K"))), isOptional = false),
            TsFunParam(
              NoComments,
              TsIdent("listener"),
              Some(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Nil,
                    List(
                      TsFunParam(
                        NoComments,
                        TsIdent("this"),
                        Some(TsTypeRef(TsIdent("FileReader"))),
                        isOptional = false,
                      ),
                      TsFunParam(
                        NoComments,
                        TsIdent("ev"),
                        Some(TsTypeLookup(TsTypeRef(TsIdent("MSBaseReaderEventMap")), TsTypeRef(TsIdent("K")))),
                        isOptional = false,
                      ),
                    ),
                    Some(TsTypeRef.any),
                  ),
                ),
              ),
              isOptional = false,
            ),
            TsFunParam(NoComments, TsIdent("useCapture"), Some(TsTypeRef.boolean), isOptional = true),
          ),
          Some(TsTypeRef.void),
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
        List(TParam),
        TsTypeObject(
          NoComments,
          List(
            TsMemberTypeMapped(
              NoComments,
              level       = ProtectionLevel.Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(T),
              optionalize = OptionalModifier.Optionalize,
              to          = TsTypeLookup(T, TsTypeRef(TsIdent("P"))),
            ),
          ),
        ),
        NoPath,
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
        List(
          TParam,
          TsTypeParam(NoComments, TsIdent("K"), Some(TsTypeKeyOf(T)), None),
        ),
        TsTypeObject(
          NoComments,
          List(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = ProtectionLevel.Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeRef(TsIdent("K")),
              optionalize = OptionalModifier.Noop,
              to          = TsTypeLookup(T, TsTypeRef(TsIdent("P"))),
            ),
          ),
        ),
        NoPath,
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
        List(TParam),
        TsTypeObject(
          NoComments,
          List(
            TsMemberTypeMapped(
              NoComments,
              level       = ProtectionLevel.Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(T),
              optionalize = OptionalModifier.Noop,
              to = TsTypeObject(
                NoComments,
                List(
                  TsMemberFunction(
                    NoComments,
                    level = ProtectionLevel.Default,
                    name  = TsIdent("get"),
                    signature = TsFunSig(
                      NoComments,
                      Nil,
                      Nil,
                      Some(TsTypeLookup(T, TsTypeRef(TsIdent("P")))),
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
                      Nil,
                      List(
                        TsFunParam(
                          NoComments,
                          TsIdent("v"),
                          Some(TsTypeLookup(T, TsTypeRef(TsIdent("P")))),
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
            ),
          ),
        ),
        NoPath,
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
        TsIdent("Readonly"),
        List(TParam),
        TsTypeObject(
          NoComments,
          List(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = ProtectionLevel.Default,
              isReadOnly  = true,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(T),
              optionalize = Noop,
              to          = TsTypeLookup(T, TsTypeRef(TsIdent("P"))),
            ),
          ),
        ),
        NoPath,
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
        Nil,
        Nil,
        List(
          TsMemberIndex(
            comments   = NoComments,
            isReadOnly = true,
            level      = ProtectionLevel.Default,
            indexing   = IndexingSingle(TsQIdent(List(TsIdent("Symbol"), TsIdent("toStringTag")))),
            isOptional = false,
            valueType  = Some(TsTypeLiteral(TsLiteralString("Symbol"))),
          ),
        ),
        NoPath,
      ),
    )
  }

  test("expr symbols") {
    shouldParseAs("""["@@transducer/init"](): TResult | void""", TsParser.tsMember)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("@@transducer/init"),
        TsFunSig(NoComments, Nil, Nil, Some(TsTypeUnion(List(TsTypeRef(TsIdent("TResult")), TsTypeRef.void)))),
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
          List(
            TsTypeParam(NoComments, TsIdent("P"), Some(TsTypeRef(TsIdent("Q"))), None),
            TsTypeParam(NoComments, TsIdent("Q"), None, None),
          ),
          List(
            TsFunParam(
              NoComments,
              TsIdent("element"),
              Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("SFCElement"))), List(TsTypeRef(TsIdent("P"))))),
              isOptional = false,
            ),
            TsFunParam(NoComments, TsIdent("props"), Some(TsTypeRef(TsIdent("Q"))), isOptional = true),
            TsFunParam(
              NoComments,
              TsIdent("children"),
              Some(TsTypeRepeated(TsTypeRef(TsIdent("ReactNode")))),
              isOptional = false,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("SFCElement"))), List(TsTypeRef(TsIdent("P"))))),
        ),
        Zero,
        NoPath,
      ),
    )

  }

  test("boolean expr") {
    shouldParseAs("true", TsParser.tsLiteral)(TsLiteralBoolean(true))
    shouldParseAs("false", TsParser.tsLiteral)(TsLiteralBoolean(false))
    shouldParseAs("boolean", TsParser.tsType)(TsTypeRef.boolean)
    shouldParseAs("trueSpeed: boolean", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("trueSpeed"),
        Some(TsTypeRef.boolean),
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
          Nil,
          List(
            TsFunParam(NoComments, TsIdent("hasToken"), Some(TsTypeRef(TsIdent("TokenAuthData"))), isOptional = false),
          ),
          Some(TsTypeRef(TsIdent("TokenHandshake"))),
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
        List(
          TsTypeParam(NoComments, TsIdent("P"), None, Some(TsTypeObject(NoComments, Nil))),
          TsTypeParam(NoComments, TsIdent("S"), None, Some(TsTypeObject(NoComments, Nil))),
        ),
        List(
          TsTypeRef(
            NoComments,
            TsQIdent.of("ComponentLifecycle"),
            List(TsTypeRef(TsIdent("P")), TsTypeRef(TsIdent("S"))),
          ),
        ),
        Nil,
        NoPath,
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
          Nil,
          List(TsFunParam(NoComments, TsIdent("obj"), Some(TsTypeRef.any), isOptional = false)),
          Some(TsTypeIs(TsIdent("obj"), TsTypeObject(NoComments, Nil))),
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
            List(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(TsFunParam(NoComments, TsIdent("input"), Some(TsTypeRef.string), isOptional = false)),
                  Some(TsTypeRef(NoComments, TsQIdent.of("Promise"), List(TsTypeRef(TsIdent("AutocompleteResult"))))),
                ),
              ),
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(
                    TsFunParam(NoComments, TsIdent("input"), Some(TsTypeRef.string), isOptional = false),
                    TsFunParam(
                      NoComments,
                      TsIdent("callback"),
                      Some(
                        TsTypeFunction(
                          TsFunSig(
                            NoComments,
                            Nil,
                            List(
                              TsFunParam(NoComments, TsIdent("err"), Some(TsTypeRef.any), isOptional = false),
                              TsFunParam(
                                NoComments,
                                TsIdent("result"),
                                Some(TsTypeRef(TsIdent("AutocompleteResult"))),
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
        TsQIdent(List(TsIdent("LoDashImplicitArrayWrapper"))),
        List(TsTypeLookup(T, TsTypeKeyOf(T))),
      ),
    )
  }

  test("type lookup") {
    shouldParseAs("KeywordTypeNode[\"kind\"]", TsParser.tsType)(
      TsTypeLookup(TsTypeRef(TsIdent("KeywordTypeNode")), TsTypeLiteral(TsLiteralString("kind"))),
    )
  }

  test("double expr") {
    shouldParseAs("swipeVelocityThreshold: 0.25", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("swipeVelocityThreshold"),
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
        TsIdent("KEYWORD"),
        Nil,
        TsTypeKeyOf(TsTypeQuery(TsQIdent.of("cssKeywords"))),
        NoPath,
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
        TsIdent("ManyArray"),
        List(TParam),
        Some(TsTypeRef.any),
        Nil,
        Nil,
        Zero,
        NoPath,
      ),
    )
  }

  test("trailing comma in tparams") {
    shouldParseAs("""interface A<B, C,> {}""", TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("A"),
        List(TsTypeParam(NoComments, TsIdent("B"), None, None), TsTypeParam(NoComments, TsIdent("C"), None, None)),
        Nil,
        Nil,
        NoPath,
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
        TsIdent("searchForFacetValues"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(
              NoComments,
              TsIdent("hasFacetNameFacetQueryQp"),
              Some(
                TsTypeIntersect(
                  List(
                    TsTypeObject(
                      NoComments,
                      List(
                        TsMemberProperty(
                          NoComments,
                          ProtectionLevel.Default,
                          TsIdent("facetName"),
                          Some(TsTypeRef.string),
                          expr       = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false,
                        ),
                        TsMemberProperty(
                          NoComments,
                          ProtectionLevel.Default,
                          TsIdent("facetQuery"),
                          Some(TsTypeRef.string),
                          expr       = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false,
                        ),
                      ),
                    ),
                    TsTypeRef(TsIdent("AlgoliaQueryParameters")),
                  ),
                ),
              ),
              isOptional = false,
            ),
          ),
          Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("Promise"))), List(TsTypeRef.any))),
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
        TsIdent("PartialValueApplicator"),
        Nil,
        Some(TsTypeRef(TsIdent("Applicator"))),
        Nil,
        List(
          TsMemberFunction(
            NoComments,
            ProtectionLevel.Default,
            TsIdent("apply"),
            TsFunSig(
              NoComments,
              Nil,
              List(
                TsFunParam(
                  NoComments,
                  TsIdent("hasArgsTargetValueConfig"),
                  Some(TsTypeRef(TsIdent("ApplicateOptions"))),
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
        NoPath,
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
        TsIdent("EventHandler"),
        List(
          TsTypeParam(
            NoComments,
            TsIdent("E"),
            Some(TsTypeRef(NoComments, TsQIdent.of("SyntheticEvent"), List(TsTypeRef.any))),
            None,
          ),
        ),
        TsTypeLookup(
          TsTypeObject(
            NoComments,
            List(
              TsMemberFunction(
                NoComments,
                ProtectionLevel.Default,
                TsIdent("bivarianceHack"),
                TsFunSig(
                  NoComments,
                  Nil,
                  List(TsFunParam(NoComments, TsIdent("event"), Some(TsTypeRef(TsIdent("E"))), isOptional = false)),
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
        NoPath,
      ),
    )
  }

  test("double type lookup") {
    val RTS = TsTypeRef(TsIdent("RTS"))
    shouldParseAs("""UnionType<RTS, RTS["_A"]["_A"], RTS["_A"]["_O"], mixed>""", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent.of("UnionType"),
        List(
          RTS,
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_A"))),
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_O"))),
          TsTypeRef(TsIdent("mixed")),
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
        TsIdent("Button"),
        List(
          TsEnumMember(NoComments, TsIdent("MINUS"), Some(TsExpr.Literal(TsLiteralNumber("0x00000004")))),
          TsEnumMember(NoComments, TsIdent("SELECT"), Some(TsExpr.Ref(TsTypeRef(TsIdent("MINUS"))))),
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        NoPath,
      ),
    )
  }

  test("Exclude") {
    shouldParseAs("type Exclude<T, U> = T extends U ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("Exclude"),
        List(TParam, TsTypeParam(NoComments, TsIdent("U"), None, None)),
        TsTypeConditional(TsTypeExtends(T, TsTypeRef(TsIdent("U"))), TsTypeRef.never, T),
        NoPath,
      ),
    )
  }

  test("Extract") {
    shouldParseAs("type Extract<T, U> = T extends U ? T : never", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("Extract"),
        List(TParam, TsTypeParam(NoComments, TsIdent("U"), None, None)),
        TsTypeConditional(TsTypeExtends(T, TsTypeRef(TsIdent("U"))), T, TsTypeRef.never),
        NoPath,
      ),
    )
  }

  test("NonNullable") {
    shouldParseAs("type NonNullable<T> = T extends null | undefined ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("NonNullable"),
        List(TParam),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeUnion(List(TsTypeRef.`null`, TsTypeRef.undefined))),
          TsTypeRef.never,
          T,
        ),
        NoPath,
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
        TsIdent("ReturnType"),
        List(
          TsTypeParam(
            NoComments,
            TsIdent("T"),
            Some(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(
                    TsFunParam(NoComments, TsIdent("args"), Some(TsTypeRepeated(TsTypeRef.any)), isOptional = false),
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
                Nil,
                List(TsFunParam(NoComments, TsIdent("args"), Some(TsTypeRepeated(TsTypeRef.any)), isOptional = false)),
                Some(TsTypeInfer(TsTypeParam(NoComments, TsIdent("R"), None, None))),
              ),
            ),
          ),
          TsTypeRef(TsIdent("R")),
          TsTypeRef.any,
        ),
        NoPath,
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
        TsIdent("InstanceType"),
        List(
          TsTypeParam(
            NoComments,
            TsIdent("T"),
            Some(
              TsTypeConstructor(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Nil,
                    List(
                      TsFunParam(NoComments, TsIdent("args"), Some(TsTypeRepeated(TsTypeRef.any)), isOptional = false),
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
                  Nil,
                  List(
                    TsFunParam(NoComments, TsIdent("args"), Some(TsTypeRepeated(TsTypeRef.any)), isOptional = false),
                  ),
                  Some(TsTypeInfer(TsTypeParam(NoComments, TsIdent("R"), None, None))),
                ),
              ),
            ),
          ),
          TsTypeRef(TsIdent("R")),
          TsTypeRef.any,
        ),
        NoPath,
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
        TsIdent("Required"),
        List(TParam),
        TsTypeObject(
          NoComments,
          List(
            TsMemberTypeMapped(
              NoComments,
              ProtectionLevel.Default,
              isReadOnly = false,
              TsIdent("P"),
              TsTypeKeyOf(T),
              OptionalModifier.Deoptionalize,
              TsTypeLookup(T, TsTypeRef(TsIdent("P"))),
            ),
          ),
        ),
        NoPath,
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
        TsIdent("mutate"),
        TsFunSig(
          NoComments,
          List(TParam),
          List(
            TsFunParam(
              NoComments,
              TsIdent("hasOptimisticResponseUpdateQueriesRefetchQueriesUpdateErrorPolicy"),
              Some(TsTypeRef(TsIdent("Fpp"))),
              isOptional = false,
            ),
          ),
          Some(
            TsTypeRef(
              NoComments,
              TsQIdent.of("Promise"),
              List(TsTypeRef(NoComments, TsQIdent.of(TsIdent("Bar")), List(T))),
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
      List(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdent("foo"),
          Some(TsTypeRef.Symbol),
          None,
          Zero,
          NoPath,
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
        TsIdent("IsOptional"),
        List(TParam),
        TsTypeConditional(
          TsTypeExtends(TsTypeUnion(List(TsTypeRef.undefined, TsTypeRef.`null`)), TT),
          True,
          TsTypeConditional(
            TsTypeExtends(TsTypeRef.undefined, TT),
            True,
            TsTypeConditional(TsTypeExtends(TsTypeRef.`null`, TT), True, False),
          ),
        ),
        NoPath,
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
        TsIdent("Validator"),
        List(TParam),
        Nil,
        List(
          ts.TsMemberIndex(
            comments   = NoComments,
            isReadOnly = false,
            level      = ProtectionLevel.Default,
            indexing   = IndexingSingle(TsQIdent(List(TsIdent("nominalTypeHack")))),
            valueType  = Some(T),
            isOptional = true,
          ),
        ),
        NoPath,
      ),
    )
  }

  test("destructured array parameter") {
    shouldParseAs(
      " const keyValsToObjectR: (accum: any, [key, val]: [any, any]) => any",
      TsParser.tsDeclVars,
    )(
      List(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdent("keyValsToObjectR"),
          Some(
            TsTypeFunction(
              TsFunSig(
                NoComments,
                Nil,
                List(
                  TsFunParam(NoComments, TsIdent("accum"), Some(TsTypeRef.any), isOptional = false),
                  TsFunParam(
                    NoComments,
                    TsIdent("hasKeyVal"),
                    Some(TsTypeTuple(List(TsTypeRef.any, TsTypeRef.any))),
                    isOptional = false,
                  ),
                ),
                Some(TsTypeRef.any),
              ),
            ),
          ),
          None,
          Zero,
          NoPath,
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
      List(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = false,
          TsIdent("foo"),
          Some(
            TsTypeRef(
              NoComments,
              TsQIdent(List(TsIdentImport(TsIdentModule(Some("babel"), List("types"))), TsIdent("Foo"))),
              Nil,
            ),
          ),
          None,
          Zero,
          NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("tuple optional") {
    shouldParseAs("[number, number?]", TsParser.tsType)(
      TsTypeTuple(List(TsTypeRef.number, TsTypeUnion(List(TsTypeRef.number, TsTypeRef.undefined)))),
    )
  }

  test("tuple variable") {
    shouldParseAs("[number, number, ...T[]]", TsParser.tsType)(
      TsTypeTuple(List(TsTypeRef.number, TsTypeRef.number, TsTypeRepeated(T))),
    )
  }

  test("typeof import()") {
    shouldParseAs(
      "const sdk: typeof import(\"aws-sdk\")",
      TsParser.tsDeclVars,
    )(
      List(
        TsDeclVar(
          NoComments,
          declared = false,
          readOnly = true,
          TsIdent("sdk"),
          Some(TsTypeQuery(TsQIdent(List(TsIdentImport(TsIdentModule(None, List("aws-sdk"))))))),
          None,
          Zero,
          NoPath,
          isOptional = false,
        ),
      ),
    )
  }

  test("lookup of array") {
    shouldParseAs("""T[]['forEach']""", TsParser.tsType)(
      TsTypeLookup(
        TsTypeRef(NoComments, TsQIdent.Array, List(T)),
        TsTypeLiteral(TsLiteralString("forEach")),
      ),
    )

    shouldParseAs("""T['forEach'][]""", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent.Array,
        List(TsTypeLookup(T, TsTypeLiteral(TsLiteralString("forEach")))),
      ),
    )
  }
  test("readonly type modifier") {
    shouldParseAs("""ReadonlyArray<readonly [K, V]>""", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent.of("ReadonlyArray"),
        List(TsTypeTuple(List(TsTypeRef(TsIdent("K")), TsTypeRef(TsIdent("V"))))),
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
        Nil,
        List(TsExport(NoComments, ExportType.Named, TsExporteeNames(Nil, None))),
        NoPath,
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
        IndexingSingle(TsQIdent(List(TsIdent("kChannel")))),
        isOptional = false,
        None,
      ),
    )
  }

  test("readonly again") {
    shouldParseAs("""{ [attributeName: string]: string | number | boolean | readonly string[]; }""", TsParser.tsType)(
      TsTypeObject(
        NoComments,
        List(
          TsMemberIndex(
            NoComments,
            isReadOnly = false,
            ProtectionLevel.Default,
            IndexingDict(TsIdent("attributeName"), TsTypeRef.string),
            isOptional = false,
            Some(
              TsTypeUnion(
                List(
                  TsTypeRef.string,
                  TsTypeRef.number,
                  TsTypeRef.boolean,
                  TsTypeRef(NoComments, TsQIdent.Array, List(TsTypeRef.string)),
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
        TsIdent("_Handle_insert"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(NoComments, TsIdent("has0"), Some(TsTypeObject(NoComments, Nil)), isOptional = false),
            TsFunParam(NoComments, TsIdent("has1"), Some(TsTypeObject(NoComments, Nil)), isOptional = false),
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
    shouldParseAs("""[key in keyof T]+?: T[key]""", TsParser.tsMemberTypeMapped)(
      TsMemberTypeMapped(
        NoComments,
        ProtectionLevel.Default,
        isReadOnly = false,
        TsIdent("key"),
        TsTypeKeyOf(T),
        OptionalModifier.Optionalize,
        TsTypeLookup(T, TsTypeRef(TsIdent("key"))),
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
            TsIdent("start"),
            None,
            Some(TsExpr.Ref(TsTypeRef(NoComments, TsQIdent(List(TsIdent("ActionTypes"), TsIdent("Start"))), Nil))),
            Zero,
            NoPath,
            isOptional = false,
          ),
        ),
      ),
    )

    shouldParseAs("""(LoggingLevel.ERROR)""", TsParser.expr)(
      TsExpr.Ref(TsTypeRef(NoComments, TsQIdent.of("LoggingLevel", "ERROR"), Nil)),
    )
    shouldParseAs("""WARNING""", TsParser.expr)(TsExpr.Ref(TsTypeRef(TsIdent("WARNING"))))
    shouldParseAs("""LoggingLevel.ERROR | WARNING""", TsParser.expr)(
      TsExpr.BinaryOp(
        TsExpr.Ref(TsTypeRef(NoComments, TsQIdent.of("LoggingLevel", "ERROR"), Nil)),
        "|",
        TsExpr.Ref(TsTypeRef(TsIdent("WARNING"))),
      ),
    )
    shouldParseAs("""(LoggingLevel.ERROR)(6 + 7)""", TsParser.expr)(
      TsExpr.Call(
        TsExpr.Ref(TsTypeRef(NoComments, TsQIdent.of("LoggingLevel", "ERROR"), Nil)),
        List(TsExpr.BinaryOp(TsExpr.Literal(TsLiteralNumber("6")), "+", TsExpr.Literal(TsLiteralNumber("7")))),
      ),
    )

    shouldParseAs("""public expire(key: string, ms: number = 0): void""", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        ProtectionLevel.Default,
        TsIdent("expire"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(NoComments, TsIdent("key"), Some(TsTypeRef.string), isOptional = false),
            TsFunParam(NoComments, TsIdent("ms"), Some(TsTypeRef.number), isOptional  = false),
          ),
          Some(TsTypeRef.void),
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false,
      ),
    )

    shouldParseAs("""1e-7""", TsParser.expr)(TsExpr.Literal(TsLiteralNumber("1e-7")))

//    shouldParseAs("""(0x000FFFFF + 1) >> 1""", TsParser.expr)(
//      null
//    )
  }
}
