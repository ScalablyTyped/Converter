package com.olvind.tso
package ts
package parser

import com.olvind.tso.ts.JsLocation.Zero
import com.olvind.tso.ts.OptionalModifier.Noop
import org.scalatest.Matchers._
import org.scalatest._

final class ParserTests extends FunSuite {
  private val T = TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("T"))), Nil)

  import ParserHarness._

  test("whole file") {
    withTsFile("path-case.d.ts") { content =>
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
                        isOptional = false
                      ),
                      TsFunParam(
                        NoComments,
                        name       = TsIdent("locale"),
                        tpe        = Some(TsTypeRef.string),
                        isOptional = true
                      )
                    ),
                    Some(TsTypeRef.string)
                  ),
                  Zero,
                  CodePath.NoPath
                ),
                TsExport(NoComments,
                         ExportType.Namespaced,
                         TsExporteeNames(Seq((TsQIdent(List(TsIdent("pathCase"))), None)), None))
              ),
              CodePath.NoPath,
              JsLocation.Zero
            )
          ),
          CodePath.NoPath
        )

      shouldParseAs(content, TsParser.parsedTsFile)(expected)
    }
  }

  test("handle byte order mark") {
    withTsFile("adm-zip.d.ts") { content =>
      parseAs(content, TsParser.tsContainerOrDecls)
    }
  }

  test("handle nbsp") {
    shouldParseAs("\u00a0var _: string", TsParser.tsDeclVar)(
      TsDeclVar(NoComments,
                declared = false,
                readOnly = false,
                TsIdent("_"),
                Some(TsTypeRef.string),
                None,
                Zero,
                CodePath.NoPath,
                isOptional = false)
    )
  }

  test("windows line separators and mixed newlines/whitespace") {
    withTsFile("adal.d.ts") { content =>
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
            level      = Default,
            name       = TsIdent("algorithm"),
            tpe        = Some(TsTypeRef.string),
            literal    = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true
          ),
          TsMemberProperty(
            NoComments,
            level      = Default,
            name       = TsIdent("saltLength"),
            tpe        = Some(TsTypeRef.number),
            literal    = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true
          ),
          TsMemberProperty(
            NoComments,
            level      = Default,
            name       = TsIdent("iterations"),
            tpe        = Some(TsTypeRef.number),
            literal    = None,
            isStatic   = false,
            isReadOnly = false,
            isOptional = true
          )
        ),
        CodePath.NoPath
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
            level = Default,
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
                      members = List(
                        TsMemberIndex(NoComments,
                                      isReadOnly = false,
                                      level      = Default,
                                      indexing   = IndexingDict(TsIdent("key"), TsTypeRef.string),
                                      valueType  = TsTypeRef.any,
                                      isOptional = false)
                      )
                    )
                  ),
                  isOptional = true
                )
              ),
              None
            ),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false
          ),
          TsMemberFunction(
            NoComments,
            level      = Default,
            name       = TsIdent("destroy"),
            signature  = TsFunSig(NoComments, tparams = Nil, params = Nil, resultType = Some(TsTypeRef.void)),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false
          )
        ),
        Zero,
        CodePath.NoPath
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
      TsParser.tsDeclEnum
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        TsIdent("LoggingLevel"),
        List(
          TsEnumMember(NoComments, TsIdent("ERROR"), Some(Left(TsLiteralNumber("0")))),
          TsEnumMember(NoComments, TsIdent("WARNING"), Some(Left(TsLiteralNumber("1"))))
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath
      )
    )

    shouldParseAs(
      "const enum ErrorCode { OTHER_CAUSE = -1, INTERNAL_SERVER_ERROR = 1,}",
      TsParser.tsDeclEnum
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        TsIdent("ErrorCode"),
        List(
          TsEnumMember(NoComments, TsIdent("OTHER_CAUSE"), Some(Left(TsLiteralNumber("-1")))),
          TsEnumMember(NoComments, TsIdent("INTERNAL_SERVER_ERROR"), Some(Left(TsLiteralNumber("1"))))
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath
      )
    )

    shouldParseAs(
      """enum HitType {'pageview', /* arne */
        |'screenview', 'event', 'transaction', 'item', 'social', 'exception', 'timing'}""".stripMargin,
      TsParser.tsDeclEnum
    )(
      TsDeclEnum(
        NoComments,
        declared = false,
        TsIdent("HitType"),
        List(
          TsEnumMember(NoComments, TsIdent("pageview"), None),
          TsEnumMember(NoComments, TsIdent("screenview"), None),
          TsEnumMember(NoComments, TsIdent("event"), None),
          TsEnumMember(NoComments, TsIdent("transaction"), None),
          TsEnumMember(NoComments, TsIdent("item"), None),
          TsEnumMember(NoComments, TsIdent("social"), None),
          TsEnumMember(NoComments, TsIdent("exception"), None),
          TsEnumMember(NoComments, TsIdent("timing"), None)
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath
      )
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
        |     * Default Constructor.
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
    } should be(List(Protected, Private, Default))

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
        case TsDeclVar(_,
                       _,
                       _,
                       TsIdent(name),
                       Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("BrorandStatic"))), _)),
                       None,
                       _,
                       _,
                       _) =>
          name
      }

    names should equal(Seq("Brorand1", "Brorand2", "Brorand3"))
  }

  test("constructor type literals") {
    shouldParseAs(
      "type ActionsClassConstructor = new (alt:Alt) => AltJS.ActionsClass",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("ActionsClassConstructor"),
        Nil,
        TsTypeConstructor(
          TsTypeFunction(
            TsFunSig(
              NoComments,
              Nil,
              List(
                TsFunParam(NoComments,
                           TsIdentSimple("alt"),
                           Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Alt"))), Nil)),
                           isOptional = false)
              ),
              Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("AltJS"), TsIdentSimple("ActionsClass"))), Nil))
            )
          )
        ),
        CodePath.NoPath
      )
    )
  }

  test("top level type alias") {
    shouldParseAs(
      "type ChartColor = string | CanvasGradient | CanvasPattern",
      TsParser.tsContainerOrDecl
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdent("ChartColor"),
        Nil,
        TsTypeUnion(
          Seq(
            TsTypeRef.string,
            TsTypeRef(NoComments, TsQIdent.of("CanvasGradient"), Nil),
            TsTypeRef(NoComments, TsQIdent.of("CanvasPattern"), Nil)
          )
        ),
        CodePath.NoPath
      )
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
                      members = List(
                        TsMemberFunction(
                          NoComments,
                          level = Default,
                          name  = TsIdent("toString"),
                          signature =
                            TsFunSig(NoComments, tparams = Nil, params = Nil, resultType = Some(TsTypeRef.string)),
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false
                        )
                      )
                    )
                  ),
                  None
                ),
                TsTypeParam(NoComments, name = TsIdent("Range"), upperBound = None, default = None)
              ),
              params = Nil,
              resultType = Some(
                TsTypeRef(NoComments,
                          name = TsQIdent.of("Ordinal"),
                          tparams = List(TsTypeRef(NoComments, TsQIdent.of("Domain"), Nil),
                                         TsTypeRef(NoComments, TsQIdent.of("Range"), Nil)))
              )
            ),
            Zero,
            CodePath.NoPath
          )
        )
      )
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
                      Seq(TsTypeRef(NoComments, TsQIdent.boolean, Nil),
                          TsTypeRef(NoComments,
                                    TsQIdent.of("PromiseLike"),
                                    List(TsTypeRef(NoComments, TsQIdent.boolean, Nil))))
                    )
                  )
                )
              ),
              TsTypeObject(
                List(
                  TsMemberProperty(
                    NoComments,
                    level = Default,
                    name  = TsIdent("errors"),
                    tpe = Some(
                      TsTypeRef(NoComments,
                                name    = TsQIdent.Array,
                                tparams = List(TsTypeRef(NoComments, TsQIdent.of("ValidationError"), Nil)))
                    ),
                    literal    = None,
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false
                  )
                )
              )
            )
          ),
          CodePath.NoPath
        )
      )
    )

    shouldParseAs(content, TsParser.tsExport)(expected)
  }

  test("string literal types") {
    shouldParseAs("""toolbarPlacement?: "default" | "top" | "bottom"""", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        level = Default,
        name  = TsIdent("toolbarPlacement"),
        tpe = Some(
          TsTypeUnion(
            Seq(TsTypeLiteral(TsLiteralString("default")),
                TsTypeLiteral(TsLiteralString("top")),
                TsTypeLiteral(TsLiteralString("bottom")))
          )
        ),
        literal    = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = true
      )
    )
  }

  test("numeric literals type") {
    shouldParseAs("""primary_key?: 0 | 1 | boolean""", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        level = Default,
        name  = TsIdent("primary_key"),
        tpe = Some(
          TsTypeUnion(
            Seq(TsTypeLiteral(TsLiteralNumber("0")),
                TsTypeLiteral(TsLiteralNumber("1")),
                TsTypeRef(NoComments, TsQIdent.boolean, Nil))
          )
        ),
        literal    = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = true
      )
    )
  }

  test("negative numbers") {
    shouldParseAs("OTHER_CAUSE = -1", TsParser.tsEnumMembers.map(_.head))(
      TsEnumMember(NoComments, TsIdent("OTHER_CAUSE"), Some(Left(TsLiteralNumber("-1"))))
    )
  }

  test("this type") {
    shouldParseAs("useBasicAuth(apiKey: string): this", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdent("useBasicAuth"),
        TsFunSig(NoComments,
                 Nil,
                 List(TsFunParam(NoComments, TsIdent("apiKey"), Some(TsTypeRef.string), isOptional = false)),
                 Some(TsTypeThis())),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("`static` identifier") {
    shouldParseAs("static: boolean", TsParser.tsMemberNamed)(
      TsMemberProperty(NoComments,
                       Default,
                       TsIdent("static"),
                       Some(TsTypeRef(NoComments, TsQIdent.boolean, Nil)),
                       literal    = None,
                       isStatic   = false,
                       isReadOnly = false,
                       isOptional = false)
    )
  }

  test("numeric identifier") {
    shouldParseAs("0?: string", TsParser.tsMemberNamed)(
      TsMemberProperty(NoComments,
                       level      = Default,
                       name       = TsIdent("0"),
                       tpe        = Some(TsTypeRef.string),
                       literal    = None,
                       isStatic   = false,
                       isReadOnly = false,
                       isOptional = true)
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
            Default,
            TsFunSig(
              NoComments,
              List(
                TsTypeParam(NoComments, TsIdent("T"), Some(TsTypeQuery(TsQIdent(List(TsIdent("FormComponent"))))), None)
              ),
              List(
                TsFunParam(NoComments,
                           TsIdent("component"),
                           Some(TsTypeRef(NoComments, TsQIdent.of("T"), Nil)),
                           isOptional = false)
              ),
              Some(TsTypeRef(NoComments, TsQIdent.of("T"), Nil))
            )
          )
        ),
        CodePath.NoPath
      )
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
          List(
            TsFunParam(NoComments, TsIdent("object"), Some(TsTypeObject(Nil)), isOptional = false)
          ),
          Some(
            TsTypeIs(TsIdent("object"),
                     TsTypeRef(NoComments,
                               TsQIdent.of("ReactElement"),
                               List(TsTypeRef(NoComments, TsQIdent.of("P"), Nil))))
          )
        ),
        Zero,
        CodePath.NoPath
      )
    )
  }

  test("complex type with comment") {
    shouldParseAs(
      """when<T>(...deferreds: Array<T|JQueryPromise<T>/* as JQueryDeferred<T> */>): JQueryPromise<T>""".stripMargin,
      TsParser.tsMemberNamed
    )(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdent("when"),
        TsFunSig(
          NoComments,
          List(TsTypeParam(NoComments, TsIdent("T"), None, None)),
          List(
            TsFunParam(
              NoComments,
              TsIdent("deferreds"),
              Some(
                TsTypeRepeated(
                  TsTypeUnion(
                    Seq(
                      TsTypeRef(NoComments, TsQIdent.of("T"), Nil),
                      TsTypeRef(NoComments,
                                TsQIdent.of("JQueryPromise"),
                                List(TsTypeRef(NoComments, TsQIdent.of("T"), Nil)))
                    )
                  )
                )
              ),
              isOptional = false
            )
          ),
          Some(TsTypeRef(NoComments, TsQIdent.of("JQueryPromise"), List(TsTypeRef(NoComments, TsQIdent.of("T"), Nil))))
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("extends union type - this will be interesting") {
    shouldParseAs(
      "function withRouter<C extends React.ComponentClass<any> | React.StatelessComponent<any> | React.PureComponent<any, any>>(component: C): C",
      TsParser.tsDeclFunction
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
                    TsTypeRef(NoComments,
                              TsQIdent.of("React", "ComponentClass"),
                              List(TsTypeRef(NoComments, TsQIdent.any, Nil))),
                    TsTypeRef(NoComments,
                              TsQIdent.of("React", "StatelessComponent"),
                              List(TsTypeRef(NoComments, TsQIdent.any, Nil))),
                    TsTypeRef(NoComments,
                              TsQIdent.of("React", "PureComponent"),
                              List(TsTypeRef(NoComments, TsQIdent.any, Nil), TsTypeRef(NoComments, TsQIdent.any, Nil)))
                  )
                )
              ),
              None
            )
          ),
          List(
            TsFunParam(NoComments,
                       TsIdent("component"),
                       Some(TsTypeRef(NoComments, TsQIdent.of("C"), Nil)),
                       isOptional = false)
          ),
          Some(TsTypeRef(NoComments, TsQIdent.of("C"), Nil))
        ),
        Zero,
        CodePath.NoPath
      )
    )
  }

  test("keyword identifiers are apparently legal") {
    shouldParseAs("module|module[]", TsParser.tsType)(
      TsTypeUnion(
        Seq(TsTypeRef(NoComments, TsQIdent.of("module"), Nil),
            TsTypeRef(NoComments, TsQIdent.Array, List(TsTypeRef(NoComments, TsQIdent.of("module"), Nil))))
      )
    )

    shouldParseAs("public", TsParser.tsIdent)(
      TsIdent("public")
    )

    shouldParseAs("public: boolean", TsParser.tsMemberNamed)(
      TsMemberProperty(NoComments,
                       Default,
                       TsIdent("public"),
                       Some(TsTypeRef(NoComments, TsQIdent.boolean, Nil)),
                       literal    = None,
                       isStatic   = false,
                       isReadOnly = false,
                       isOptional = false)
    )

    shouldParseAs("static public?: private", TsParser.tsMemberNamed)(
      TsMemberProperty(
        NoComments,
        Default,
        TsIdent("public"),
        Some(TsTypeRef(NoComments, TsQIdent.of("private"), Nil)),
        literal    = None,
        isStatic   = true,
        isReadOnly = false,
        isOptional = true
      )
    )
  }

  test("global") {
    shouldParseAs("global {}", TsParser.tsGlobal)(
      TsGlobal(NoComments, declared = false, Nil, CodePath.NoPath)
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
      TsMemberProperty(NoComments,
                       Default,
                       TsIdent("i"),
                       Some(TsTypeRef(NoComments, TsQIdent.number, Nil)),
                       literal    = None,
                       isStatic   = false,
                       isReadOnly = false,
                       isOptional = false)
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
              TsDeclInterface(NoComments, declared = false, TsIdent("Window"), Nil, Nil, windowMembers, CodePath.NoPath)
            ),
            CodePath.NoPath
          )
        ),
        CodePath.NoPath,
        JsLocation.Zero
      )
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
      Nil,
      List(
        TsTypeRef(NoComments, TsQIdent.of("React", "ReactElement"), List(TsTypeRef(NoComments, TsQIdent.any, Nil)))
      ),
      Nil,
      CodePath.NoPath
    )

    shouldParseAs(m2, TsParser.tsContainerOrDecl)(
      TsGlobal(
        NoComments,
        declared = true,
        List(
          TsDeclNamespace(NoComments,
                          declared = false,
                          TsIdentNamespace("JSX"),
                          List(elementInterface),
                          CodePath.NoPath,
                          JsLocation.Zero)
        ),
        CodePath.NoPath
      )
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
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("name"),
                           tpe        = Some(TsTypeRef.string),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false),
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("size"),
                           tpe        = Some(TsTypeRef.number),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false),
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("type"),
                           tpe        = Some(TsTypeRef.number),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = true,
                           isOptional = false)
        ),
        CodePath.NoPath
      )
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
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("default"),
                           tpe        = Some(TsTypeRef.string),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = false,
                           isOptional = true),
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("hue-1"),
                           tpe        = Some(TsTypeRef.string),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = false,
                           isOptional = true),
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("hue-2"),
                           tpe        = Some(TsTypeRef.string),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = false,
                           isOptional = true),
          TsMemberProperty(NoComments,
                           level      = Default,
                           name       = TsIdent("hue-3"),
                           tpe        = Some(TsTypeRef.string),
                           literal    = None,
                           isStatic   = false,
                           isReadOnly = false,
                           isOptional = true)
        ),
        CodePath.NoPath
      )
    )
  }

  test("readonly index member") {
    val content = """{readonly [index: number]: string}"""
    shouldParseAs(content, TsParser.tsMembers)(
      List(
        TsMemberIndex(
          comments   = NoComments,
          isReadOnly = true,
          level      = Default,
          indexing   = IndexingDict(TsIdent("index"), TsTypeRef(NoComments, TsQIdent.number, Nil)),
          valueType  = TsTypeRef.string,
          isOptional = false
        )
      )
    )
  }

  test("type queries / lookups") {

    val addEventListener =
      """addEventListener<K extends keyof MSBaseReaderEventMap>(type: K, listener: (this: FileReader, ev: MSBaseReaderEventMap[K]) => any, useCapture?: boolean): void"""

    shouldParseAs(addEventListener, TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdent("addEventListener"),
        TsFunSig(
          NoComments,
          List(
            TsTypeParam(NoComments,
                        TsIdent("K"),
                        Some(TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("MSBaseReaderEventMap"), Nil))),
                        None)
          ),
          List(
            TsFunParam(NoComments,
                       TsIdent("type"),
                       Some(TsTypeRef(NoComments, TsQIdent.of("K"), Nil)),
                       isOptional = false),
            TsFunParam(
              NoComments,
              TsIdent("listener"),
              Some(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Nil,
                    List(
                      TsFunParam(NoComments,
                                 TsIdent("this"),
                                 Some(TsTypeRef(NoComments, TsQIdent.of("FileReader"), Nil)),
                                 isOptional = false),
                      TsFunParam(
                        NoComments,
                        TsIdent("ev"),
                        Some(
                          TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("MSBaseReaderEventMap"), Nil),
                                       TsTypeRef.of(TsIdent("K")))
                        ),
                        isOptional = false
                      )
                    ),
                    Some(TsTypeRef(NoComments, TsQIdent.any, Nil))
                  )
                )
              ),
              isOptional = false
            ),
            TsFunParam(NoComments,
                       TsIdent("useCapture"),
                       Some(TsTypeRef(NoComments, TsQIdent.boolean, Nil)),
                       isOptional = true)
          ),
          Some(TsTypeRef(NoComments, TsQIdent.void, Nil))
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
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
        List(TsTypeParam(NoComments, TsIdent("T"), None, None)),
        TsTypeObject(
          List(
            TsMemberTypeMapped(
              NoComments,
              level       = Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("T"), Nil)),
              optionalize = OptionalModifier.Optionalize,
              to          = TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Nil), TsTypeRef.of(TsIdent("P")))
            )
          )
        ),
        CodePath.NoPath
      )
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
          TsTypeParam(NoComments, TsIdent("T"), None, None),
          TsTypeParam(NoComments, TsIdent("K"), Some(TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent.of("T"), Nil))), None)
        ),
        TsTypeObject(
          List(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeRef(NoComments, TsQIdent.of("K"), Nil),
              optionalize = OptionalModifier.Noop,
              to          = TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Nil), TsTypeRef.of(TsIdent("P")))
            )
          )
        ),
        CodePath.NoPath
      )
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
        List(TsTypeParam(NoComments, TsIdent("T"), None, None)),
        TsTypeObject(
          List(
            TsMemberTypeMapped(
              NoComments,
              level       = Default,
              isReadOnly  = false,
              key         = TsIdent("P"),
              from        = TsTypeKeyOf(T),
              optionalize = OptionalModifier.Noop,
              to = TsTypeObject(
                List(
                  TsMemberFunction(
                    NoComments,
                    level = Default,
                    name  = TsIdent("get"),
                    signature = TsFunSig(
                      NoComments,
                      Nil,
                      Nil,
                      Some(TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Nil), TsTypeRef.of(TsIdent("P"))))
                    ),
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false
                  ),
                  TsMemberFunction(
                    NoComments,
                    Default,
                    TsIdent("set"),
                    TsFunSig(
                      NoComments,
                      Nil,
                      List(
                        TsFunParam(
                          NoComments,
                          TsIdent("v"),
                          Some(TsTypeLookup(TsTypeRef(NoComments, TsQIdent.of("T"), Nil), TsTypeRef.of(TsIdent("P")))),
                          isOptional = false
                        )
                      ),
                      Some(TsTypeRef(NoComments, TsQIdent.void, Nil))
                    ),
                    isStatic   = false,
                    isReadOnly = false,
                    isOptional = false
                  )
                )
              )
            )
          )
        ),
        CodePath.NoPath
      )
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
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeObject(
          List(
            TsMemberTypeMapped(
              comments    = NoComments,
              level       = Default,
              isReadOnly  = true,
              key         = TsIdentSimple("P"),
              from        = TsTypeKeyOf(T),
              optionalize = Noop,
              to          = TsTypeLookup(T, TsTypeRef.of(TsIdentSimple("P")))
            )
          )
        ),
        CodePath.NoPath
      )
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
          ts.TsMemberIndex(
            comments   = NoComments,
            isReadOnly = true,
            level      = Default,
            indexing   = IndexingSingle(TsQIdent(List(TsIdent("Symbol"), TsIdent("toStringTag")))),
            isOptional = false,
            valueType  = TsTypeLiteral(TsLiteralString("Symbol"))
          )
        ),
        CodePath.NoPath
      )
    )
  }

  test("literal symbols") {
    shouldParseAs("""["@@transducer/init"](): TResult | void""", TsParser.tsMember)(
      TsMemberIndex(
        comments   = NoComments,
        isReadOnly = false,
        level      = Default,
        indexing   = IndexingSingle(TsQIdent(List(TsIdentSimple("@@transducer/init")))),
        isOptional = false,
        valueType = TsTypeFunction(
          TsFunSig(
            NoComments,
            Nil,
            Nil,
            Some(
              TsTypeUnion(
                List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("TResult"))), Nil), TsTypeRef.void)
              )
            )
          )
        )
      )
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
            TsTypeParam(NoComments, TsIdent("P"), Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("Q"))), Nil)), None),
            TsTypeParam(NoComments, TsIdent("Q"), None, None)
          ),
          List(
            TsFunParam(
              NoComments,
              TsIdent("element"),
              Some(
                TsTypeRef(NoComments,
                          TsQIdent(List(TsIdent("SFCElement"))),
                          List(TsTypeRef(NoComments, TsQIdent(List(TsIdent("P"))), Nil)))
              ),
              isOptional = false
            ),
            TsFunParam(NoComments,
                       TsIdent("props"),
                       Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("Q"))), Nil)),
                       isOptional = true),
            TsFunParam(
              NoComments,
              TsIdent("children"),
              Some(TsTypeRepeated(TsTypeRef(NoComments, TsQIdent(List(TsIdent("ReactNode"))), Nil))),
              isOptional = false
            )
          ),
          Some(
            TsTypeRef(NoComments,
                      TsQIdent(List(TsIdent("SFCElement"))),
                      List(TsTypeRef(NoComments, TsQIdent(List(TsIdent("P"))), Nil)))
          )
        ),
        Zero,
        CodePath.NoPath
      )
    )

  }

  test("boolean literal") {
    shouldParseAs("true", TsParser.tsLiteral)(TsLiteralBoolean(true))
    shouldParseAs("false", TsParser.tsLiteral)(TsLiteralBoolean(false))
    shouldParseAs("boolean", TsParser.tsType)(
      TsTypeRef(NoComments, TsQIdent(List(TsIdent("boolean"))), Nil)
    )
    shouldParseAs("trueSpeed: boolean", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        Default,
        TsIdent("trueSpeed"),
        Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("boolean"))), Nil)),
        literal    = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("destructured parameter name") {
    shouldParseAs("static delegating({ token }: TokenAuthData): TokenHandshake", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdent("delegating"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(NoComments,
                       TsIdent("hasToken"),
                       Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("TokenAuthData"))), Nil)),
                       isOptional = false)
          ),
          Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("TokenHandshake"))), Nil))
        ),
        isStatic   = true,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("default type parameter") {
    shouldParseAs("interface Component<P = {}, S = {}> extends ComponentLifecycle<P, S> { }", TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdent("Component"),
        List(TsTypeParam(NoComments, TsIdent("P"), None, Some(TsTypeObject(Nil))),
             TsTypeParam(NoComments, TsIdent("S"), None, Some(TsTypeObject(Nil)))),
        List(
          TsTypeRef(
            NoComments,
            TsQIdent(List(TsIdent("ComponentLifecycle"))),
            List(TsTypeRef(NoComments, TsQIdent(List(TsIdent("P"))), Nil),
                 TsTypeRef(NoComments, TsQIdent(List(TsIdent("S"))), Nil))
          )
        ),
        Nil,
        CodePath.NoPath
      )
    )
  }

  test("empty type") {
    shouldParseAs("isEmptyObject(obj: any): obj is {}", TsParser.tsMemberNamed)(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdent("isEmptyObject"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(NoComments, TsIdent("obj"), Some(TsTypeRef.any), isOptional = false)
          ),
          Some(TsTypeIs(TsIdent("obj"), TsTypeObject(Nil)))
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
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
        Default,
        TsIdent("loadOptions"),
        Some(
          TsTypeUnion(
            List(
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(
                    TsFunParam(NoComments,
                               TsIdent("input"),
                               Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("string"))), Nil)),
                               isOptional = false)
                  ),
                  Some(
                    TsTypeRef(NoComments,
                              TsQIdent(List(TsIdent("Promise"))),
                              List(TsTypeRef(NoComments, TsQIdent(List(TsIdent("AutocompleteResult"))), Nil)))
                  )
                )
              ),
              TsTypeFunction(
                TsFunSig(
                  NoComments,
                  Nil,
                  List(
                    TsFunParam(NoComments,
                               TsIdent("input"),
                               Some(TsTypeRef(NoComments, TsQIdent(List(TsIdent("string"))), Nil)),
                               isOptional = false),
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
                              TsFunParam(NoComments,
                                         TsIdent("result"),
                                         Some(
                                           TsTypeRef(NoComments, TsQIdent(List(TsIdent("AutocompleteResult"))), Nil)
                                         ),
                                         isOptional = false)
                            ),
                            Some(TsTypeRef.void)
                          )
                        )
                      ),
                      isOptional = false
                    )
                  ),
                  Some(TsTypeRef.void)
                )
              )
            )
          )
        ),
        literal    = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("keyof 1") {
    shouldParseAs("LoDashImplicitArrayWrapper<T[keyof T]>", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent(List(TsIdent("LoDashImplicitArrayWrapper"))),
        List(
          TsTypeLookup(TsTypeRef(NoComments, TsQIdent(List(TsIdent("T"))), Nil),
                       TsTypeKeyOf(TsTypeRef(NoComments, TsQIdent(List(TsIdent("T"))), Nil)))
        )
      )
    )
  }

  test("type lookup") {
    shouldParseAs("KeywordTypeNode[\"kind\"]", TsParser.tsType)(
      TsTypeLookup(TsTypeRef(NoComments, TsQIdent(List(TsIdent("KeywordTypeNode"))), Nil),
                   TsTypeLiteral(TsLiteralString("kind")))
    )
  }

  test("double literal") {
    shouldParseAs("swipeVelocityThreshold: 0.25", TsParser.tsMember)(
      TsMemberProperty(
        NoComments,
        Default,
        TsIdentSimple("swipeVelocityThreshold"),
        Some(TsTypeLiteral(TsLiteralNumber("0.25"))),
        literal    = None,
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("keyof typeof") {
    shouldParseAs("type KEYWORD = keyof typeof cssKeywords", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(NoComments,
                      declared = false,
                      TsIdentSimple("KEYWORD"),
                      Nil,
                      TsTypeKeyOf(TsTypeQuery(TsQIdent(List(TsIdentSimple("cssKeywords"))))),
                      CodePath.NoPath)
    )
  }

  test("class extends method call? wtf") {
    shouldParseAs(
      """       class ManyArray<T> extends Ember.Object.extend(
            Ember.MutableArray,
            Ember.Evented
        ) {}
 """,
      TsParser.tsDeclClass
    )(
      TsDeclClass(
        NoComments,
        false,
        false,
        TsIdentSimple("ManyArray"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        Some(TsTypeRef.any),
        Nil,
        Nil,
        Zero,
        CodePath.NoPath
      )
    )
  }

  test("trailing comma in tparams") {
    shouldParseAs("""interface A<B, C,> {}""", TsParser.tsDeclInterface)(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdentSimple("A"),
        List(TsTypeParam(NoComments, TsIdentSimple("B"), None, None),
             TsTypeParam(NoComments, TsIdentSimple("C"), None, None)),
        Nil,
        Nil,
        CodePath.NoPath
      )
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
        Default,
        TsIdentSimple("searchForFacetValues"),
        TsFunSig(
          NoComments,
          Nil,
          List(
            TsFunParam(
              NoComments,
              TsIdentSimple("hasFacetNameFacetQueryQp"),
              Some(
                TsTypeIntersect(
                  List(
                    TsTypeObject(
                      List(
                        TsMemberProperty(
                          NoComments,
                          Default,
                          TsIdentSimple("facetName"),
                          Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("string"))), Nil)),
                          literal    = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false
                        ),
                        TsMemberProperty(
                          NoComments,
                          Default,
                          TsIdentSimple("facetQuery"),
                          Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("string"))), Nil)),
                          literal    = None,
                          isStatic   = false,
                          isReadOnly = false,
                          isOptional = false
                        )
                      )
                    ),
                    TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("AlgoliaQueryParameters"))), Nil)
                  )
                )
              ),
              isOptional = false
            )
          ),
          Some(
            TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Promise"))), List(TsTypeRef.any))
          )
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
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
        Nil,
        Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Applicator"))), Nil)),
        Nil,
        List(
          TsMemberFunction(
            NoComments,
            Default,
            TsIdentSimple("apply"),
            TsFunSig(
              NoComments,
              Nil,
              List(
                TsFunParam(
                  NoComments,
                  TsIdentSimple("hasArgsTargetValueConfig"),
                  Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("ApplicateOptions"))), Nil)),
                  isOptional = false
                )
              ),
              Some(TsTypeRef.any)
            ),
            isStatic   = false,
            isReadOnly = false,
            isOptional = false
          )
        ),
        Zero,
        CodePath.NoPath
      )
    )
  }

  test("bivarianceHack") {
    shouldParseAs(
      "type EventHandler<E extends SyntheticEvent<any>> = { bivarianceHack(event: E): void }[\"bivarianceHack\"]",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("EventHandler"),
        List(
          TsTypeParam(
            NoComments,
            TsIdentSimple("E"),
            Some(
              TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("SyntheticEvent"))), List(TsTypeRef.any))
            ),
            None
          )
        ),
        TsTypeLookup(
          TsTypeObject(
            List(
              TsMemberFunction(
                NoComments,
                Default,
                TsIdentSimple("bivarianceHack"),
                TsFunSig(
                  NoComments,
                  Nil,
                  List(
                    TsFunParam(NoComments,
                               TsIdentSimple("event"),
                               Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("E"))), Nil)),
                               isOptional = false)
                  ),
                  Some(TsTypeRef.void)
                ),
                isStatic   = false,
                isReadOnly = false,
                isOptional = false
              )
            )
          ),
          TsTypeLiteral(TsLiteralString("bivarianceHack"))
        ),
        CodePath.NoPath
      )
    )
  }

  test("double type lookup") {
    val RTS = TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("RTS"))), Nil)
    shouldParseAs("""UnionType<RTS, RTS["_A"]["_A"], RTS["_A"]["_O"], mixed>""", TsParser.tsType)(
      TsTypeRef(
        NoComments,
        TsQIdent(List(TsIdentSimple("UnionType"))),
        List(
          RTS,
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_A"))),
          TsTypeLookup(TsTypeLookup(RTS, TsTypeLiteral(TsLiteralString("_A"))), TsTypeLiteral(TsLiteralString("_O"))),
          TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("mixed"))), Nil)
        )
      )
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
        TsIdentSimple("Button"),
        List(
          TsEnumMember(NoComments, TsIdentSimple("MINUS"), Some(Left(TsLiteralNumber("0x00000004")))),
          TsEnumMember(NoComments, TsIdentSimple("SELECT"), Some(Right(TsIdentSimple("MINUS"))))
        ),
        isValue      = true,
        exportedFrom = None,
        Zero,
        CodePath.NoPath
      )
    )
  }

  test("Exclude") {
    shouldParseAs("type Exclude<T, U> = T extends U ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Exclude"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None),
             TsTypeParam(NoComments, TsIdentSimple("U"), None, None)),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("U"))), Nil)),
          TsTypeRef.never,
          T
        ),
        CodePath.NoPath
      )
    )
  }

  test("Extract") {
    shouldParseAs("type Extract<T, U> = T extends U ? T : never", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Extract"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None),
             TsTypeParam(NoComments, TsIdentSimple("U"), None, None)),
        TsTypeConditional(
          TsTypeExtends(T, TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("U"))), Nil)),
          T,
          TsTypeRef.never
        ),
        CodePath.NoPath
      )
    )
  }

  test("NonNullable") {
    shouldParseAs("type NonNullable<T> = T extends null | undefined ? never : T", TsParser.tsDeclTypeAlias)(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("NonNullable"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeConditional(TsTypeExtends(T, TsTypeUnion(List(TsTypeRef.`null`, TsTypeRef.undefined))),
                          TsTypeRef.never,
                          T),
        CodePath.NoPath
      )
    )
  }
  test("ReturnType") {
    shouldParseAs(
      "type ReturnType<T extends (...args: any[]) => any> = T extends (...args: any[]) => infer R ? R : any",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("ReturnType"),
        List(
          TsTypeParam(
            NoComments,
            TsIdentSimple("T"),
            Some(
              TsTypeFunction(
                TsFunSig(NoComments,
                         Nil,
                         List(
                           TsFunParam(NoComments,
                                      TsIdentSimple("args"),
                                      Some(TsTypeRepeated(TsTypeRef.any)),
                                      isOptional = false)
                         ),
                         Some(TsTypeRef.any))
              )
            ),
            None
          )
        ),
        TsTypeConditional(
          TsTypeExtends(
            T,
            TsTypeFunction(
              TsFunSig(
                NoComments,
                Nil,
                List(
                  TsFunParam(NoComments, TsIdentSimple("args"), Some(TsTypeRepeated(TsTypeRef.any)), isOptional = false)
                ),
                Some(TsTypeInfer(TsTypeParam(NoComments, TsIdentSimple("R"), None, None)))
              )
            )
          ),
          TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("R"))), Nil),
          TsTypeRef.any
        ),
        CodePath.NoPath
      )
    )
  }

  test("InstanceType") {
    shouldParseAs(
      "type InstanceType<T extends new (...args: any[]) => any> = T extends new (...args: any[]) => infer R ? R : any",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("InstanceType"),
        List(
          TsTypeParam(
            NoComments,
            TsIdentSimple("T"),
            Some(
              TsTypeConstructor(
                TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Nil,
                    List(
                      TsFunParam(NoComments,
                                 TsIdentSimple("args"),
                                 Some(TsTypeRepeated(TsTypeRef.any)),
                                 isOptional = false)
                    ),
                    Some(TsTypeRef.any)
                  )
                )
              )
            ),
            None
          )
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
                    TsFunParam(NoComments,
                               TsIdentSimple("args"),
                               Some(TsTypeRepeated(TsTypeRef.any)),
                               isOptional = false)
                  ),
                  Some(TsTypeInfer(TsTypeParam(NoComments, TsIdentSimple("R"), None, None)))
                )
              )
            )
          ),
          TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("R"))), Nil),
          TsTypeRef.any
        ),
        CodePath.NoPath
      )
    )
  }

  test("inverted optional type mapping") {
    shouldParseAs(
      "type Required<T> = {[P in keyof T]-?: T[P]}",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("Required"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeObject(
          List(
            TsMemberTypeMapped(
              NoComments,
              Default,
              isReadOnly = false,
              TsIdentSimple("P"),
              TsTypeKeyOf(T),
              OptionalModifier.Deoptionalize,
              TsTypeLookup(T, TsTypeRef.of(TsIdentSimple("P")))
            )
          )
        ),
        CodePath.NoPath
      )
    )
  }

  test("type alias conditional") {
    pending
    shouldParseAs(
      "export type ExtractProps<TComponent> = TComponent extends ReactComponent<infer TProps> ? TProps : {};",
      TsParser.tsDeclTypeAlias
    )(null)
  }

  test("destructured renamed") {
    shouldParseAs(
      "mutate<T>({optimisticResponse, updateQueries: updateQueriesByName, refetchQueries, update: updateWithProxyFn, errorPolicy}: Fpp): Promise<Bar<T>>",
      TsParser.tsMember
    )(
      TsMemberFunction(
        NoComments,
        Default,
        TsIdentSimple("mutate"),
        TsFunSig(
          NoComments,
          List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
          List(
            TsFunParam(
              NoComments,
              TsIdentSimple("hasOptimisticResponseUpdateQueriesRefetchQueriesUpdateErrorPolicy"),
              Some(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Fpp"))), Nil)),
              isOptional = false
            )
          ),
          Some(
            TsTypeRef(NoComments,
                      TsQIdent(List(TsIdentSimple("Promise"))),
                      List(
                        TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("Bar"))), List(T))
                      ))
          )
        ),
        isStatic   = false,
        isReadOnly = false,
        isOptional = false
      )
    )
  }

  test("unique symbol") {
    shouldParseAs(
      "const foo: unique symbol",
      TsParser.tsDeclVar
    )(
      TsDeclVar(
        NoComments,
        declared = false,
        readOnly = true,
        TsIdentSimple("foo"),
        Some(TsTypeRef.Symbol),
        None,
        Zero,
        CodePath.NoPath,
        isOptional = false
      )
    )
  }

  test("conditional types part 2") {
    val TT    = T
    val True  = TsTypeLiteral(TsLiteralBoolean(true))
    val False = TsTypeLiteral(TsLiteralBoolean(false))
    shouldParseAs(
      "type IsOptional<T> = undefined | null extends T ? true : undefined extends T ? true : null extends T ? true : false",
      TsParser.tsDeclTypeAlias
    )(
      TsDeclTypeAlias(
        NoComments,
        declared = false,
        TsIdentSimple("IsOptional"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        TsTypeConditional(
          TsTypeExtends(TsTypeUnion(List(TsTypeRef.undefined, TsTypeRef.`null`)), TT),
          True,
          TsTypeConditional(TsTypeExtends(TsTypeRef.undefined, TT),
                            True,
                            TsTypeConditional(TsTypeExtends(TsTypeRef.`null`, TT), True, False))
        ),
        CodePath.NoPath
      )
    )
  }

  test("indexed type again") {
    shouldParseAs(
      "interface Validator<T> { [nominalTypeHack]?: T }",
      TsParser.tsDeclInterface
    )(
      TsDeclInterface(
        NoComments,
        declared = false,
        TsIdentSimple("Validator"),
        List(TsTypeParam(NoComments, TsIdentSimple("T"), None, None)),
        Nil,
        List(
          ts.TsMemberIndex(
            comments   = NoComments,
            isReadOnly = false,
            level      = Default,
            indexing   = IndexingSingle(TsQIdent(List(TsIdentSimple("nominalTypeHack")))),
            valueType  = T,
            isOptional = true
          )
        ),
        CodePath.NoPath
      )
    )
  }

  test("destructured array parameter") {
    shouldParseAs(
      " const keyValsToObjectR: (accum: any, [key, val]: [any, any]) => any",
      TsParser.tsDeclVar
    )(
      TsDeclVar(
        NoComments,
        declared = false,
        readOnly = true,
        TsIdentSimple("keyValsToObjectR"),
        Some(
          TsTypeFunction(
            TsFunSig(
              NoComments,
              Nil,
              List(
                TsFunParam(NoComments, TsIdentSimple("accum"), Some(TsTypeRef.any), isOptional = false),
                TsFunParam(NoComments,
                           TsIdentSimple("hasKeyVal"),
                           Some(TsTypeTuple(List(TsTypeRef.any, TsTypeRef.any))),
                           isOptional = false)
              ),
              Some(TsTypeRef.any)
            )
          )
        ),
        None,
        Zero,
        CodePath.NoPath,
        isOptional = false
      )
    )
  }

  test("import types") {
    shouldParseAs(
      "var foo: import('@babel/types').Foo",
      TsParser.tsDeclVar
    )(
      TsDeclVar(
        NoComments,
        false,
        false,
        TsIdentSimple("foo"),
        Some(
          TsTypeRef(NoComments,
                    TsQIdent(List(TsIdentImport(TsIdentModule(Some("babel"), List("types"))), TsIdentSimple("Foo"))),
                    Nil)
        ),
        None,
        Zero,
        CodePath.NoPath,
        false
      )
    )
  }

  test("tuple optional") {
    shouldParseAs(
      "[number, number?]",
      TsParser.tsType
    )(
      TsTypeTuple(List(TsTypeRef.number, TsTypeUnion(List(TsTypeRef.number, TsTypeRef.undefined))))
    )
  }

  test("tuple variable") {
    shouldParseAs(
      "[number, number, ...T[]]",
      TsParser.tsType
    )(
      TsTypeTuple(
        List(
          TsTypeRef(NoComments, TsQIdent.number, Nil),
          TsTypeRef(NoComments, TsQIdent.number, Nil),
          TsTypeRepeated(TsTypeRef(NoComments, TsQIdent.of("T"), Nil))
        )
      )
    )
  }

  test("typeof import()") {
    shouldParseAs(
      "const sdk: typeof import(\"aws-sdk\")",
      TsParser.tsDeclVar
    )(
      TsDeclVar(
        NoComments,
        declared = false,
        readOnly = true,
        TsIdentSimple("sdk"),
        Some(TsTypeQuery(TsQIdent(List(TsIdentImport(TsIdentModule(None, List("aws-sdk"))))))),
        None,
        Zero,
        CodePath.NoPath,
        isOptional = false
      )
    )
  }

  test("lookup of array") {
    shouldParseAs(
      """T[]['forEach']""",
      TsParser.tsType
    )(
      TsTypeLookup(
        TsTypeRef(NoComments, TsQIdent.Array, List(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("T"))), List()))),
        TsTypeLiteral(TsLiteralString("forEach"))
      )
    )

    shouldParseAs(
      """T['forEach'][]""",
      TsParser.tsType
    )(
      TsTypeRef(
        NoComments,
        TsQIdent.Array,
        List(
          TsTypeLookup(TsTypeRef(NoComments, TsQIdent(List(TsIdentSimple("T"))), List()),
                       TsTypeLiteral(TsLiteralString("forEach")))
        )
      )
    )
  }
}
