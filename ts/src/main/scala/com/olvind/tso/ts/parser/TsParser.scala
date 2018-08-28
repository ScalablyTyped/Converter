package com.olvind.tso
package ts
package parser

import scala.util.parsing.combinator.syntactical._
import scala.util.parsing.input.Reader

object TsParser extends StdTokenParsers with ParserHelpers with ImplicitConversions1 { self =>
  type Tokens = TsLexer.type
  override val lexical: TsLexer.type = TsLexer

  protected def perhapsParens[T](p: Parser[T]): Parser[T] =
    p | Parser("(") ~> p <~ ")"

  /* enable direct use of parsers with strings */
  implicit def FromString[T](p: Parser[T]): String => ParseResult[T] =
    (str: String) => phrase(p)(new lexical.Scanner(str))

  def apply(content: String): ParseResult[TsParsedFile] =
    parsedTsFile(content)

  /* handle stray comments */
  override def Parser[T](f: Input => ParseResult[T]): TsParser.Parser[T] =
    (in: Reader[lexical.Token]) =>
      f(in) match {
        case Failure(_, next: Input)
            if next.first.isInstanceOf[lexical.CommentToken] || next.first.isInstanceOf[Directive] =>
          f(next.rest)
        case fail: Failure =>
          fail
        case other =>
          other
    }

  private val identifierName: Parser[String] =
    accept(
      "IdentifierName", {
        case lexical.Identifier(chars)                                  => chars
        case lexical.Keyword(chars) if chars.forall(Character.isLetter) => chars
        case lexical.NumericLit(chars)                                  => chars
      }
    )

  val comment: Parser[Comment] =
    accept(
      "comment", {
        case lexical.CommentBlockToken(chars)             => Comment(chars)
        case lexical.CommentLineToken(chars)              => Comment(chars)
        case lexical.CommentLineTokenAfterDelim(_, chars) => Comment(chars)
      }
    )

  lazy val comments: Parser[Comments] =
    comment.* ^^ Comments.apply

  def delimMaybeComment(delims: Char*): Parser[Option[Comment]] =
    accept(
      "Line comment (after delim)", {
        case lexical.CommentLineTokenAfterDelim(delim, chars) if delims contains delim =>
          Some(Comment(chars))
        case lexical.Keyword(chars) if chars.length === 1 && delims.contains(chars.head) =>
          None
      }
    )

  lazy val directive: Parser[Directive] =
    accept(
      "Directive", {
        case lexical.DirectiveToken("reference", "lib", value)   => DirectiveLibRef(value)
        case lexical.DirectiveToken("reference", "types", value) => DirectiveTypesRef(value)
        case lexical.DirectiveToken("references", "types", value) =>
          DirectiveTypesRef(value) // not sure if it's a typo, but we'll retain the hint
        case lexical.DirectiveToken("reference", "path", value)            => DirectivePathRef(value)
        case lexical.DirectiveToken("reference", "no-default-lib", "true") => DirectiveNoStdLib
      }
    ) named "directive"

  lazy val directives: Parser[Seq[Directive]] =
    directive.* named "directives"

  lazy val parsedTsFile: Parser[TsParsedFile] =
    comments ~ directives ~ tsContainerOrDecls ~ success(CodePath.NoPath) ^^ TsParsedFile

  lazy val tsNamedDecl: Parser[TsNamedDecl] =
    tsDeclInterface |
      tsDeclModule |
      tsDeclNamespace |
      tsDeclEnum |
      tsDeclVar |
      tsDeclFunction |
      tsDeclClass |
      tsDeclTypeAlias

  lazy val tsDecl: Parser[TsDecl] =
    tsNamedDecl | tsImport | exportAsNamespace | tsExport

  lazy val tsContainerOrDecl: Parser[TsContainerOrDecl] =
    directive.* ~> (tsDecl | tsGlobal) <~ delimMaybeComment(';').? <~ directive.*

  lazy val tsContainerOrDecls: Parser[List[TsContainerOrDecl]] =
    rep(tsContainerOrDecl) <~ comments.?

  lazy val tsContainerOrDeclBody: Parser[List[TsContainerOrDecl]] =
    "{" ~> tsContainerOrDecls <~ "}"

  lazy val tsDeclNamespace: Parser[TsDeclNamespace] =
    comments ~ (isDeclared <~ "namespace") ~ rep1sep(tsIdent, ".") ~ tsContainerOrDeclBody ^^ {
      case (cs ~ declared ~ (initNameParts :+ lastNamePart)) ~ body =>
        initNameParts.foldRight(
          TsDeclNamespace(cs, declared, TsIdentNamespace(lastNamePart.value), body, CodePath.NoPath, JsLocation.Zero)
        ) { (name: TsIdentSimple, inner: TsDeclNamespace) =>
          TsDeclNamespace(NoComments,
                          declared,
                          TsIdentNamespace(name.value),
                          inner :: Nil,
                          CodePath.NoPath,
                          JsLocation.Zero)
        }
    }

  lazy val tsDeclModule: Parser[TsNamedDecl] = {
    comments ~ (isDeclared <~ "module") ~ either(tsIdentModule, rep1sep(tsIdent, ".")) ~ tsContainerOrDeclBody ^^ {
      case cs ~ declared ~ nameEither ~ body =>
        nameEither match {
          case Left(name) =>
            TsDeclModule(cs, declared, name, body, CodePath.NoPath, JsLocation.Zero)
          case Right(idents) =>
            val initNameParts :+ lastNamePart = idents

            initNameParts.foldRight(
              TsDeclNamespace(cs,
                              declared,
                              TsIdentNamespace(lastNamePart.value),
                              body,
                              CodePath.NoPath,
                              JsLocation.Zero)
            ) { (name: TsIdentSimple, inner: TsDeclNamespace) =>
              TsDeclNamespace(NoComments,
                              declared,
                              TsIdentNamespace(name.value),
                              inner :: Nil,
                              CodePath.NoPath,
                              JsLocation.Zero)
            }
        }
    }
  }

  lazy val tsGlobal: Parser[TsGlobal] =
    comments ~ (isDeclared <~ "global") ~ tsContainerOrDeclBody ~ success(CodePath.NoPath) ^^ TsGlobal

  lazy val tsImport: Parser[TsImport] = {

    val imported: Parser[Seq[TsImported]] = {
      val rename: Parser[TsIdent] = "as" ~> tsIdent

      repsep(
        "*" ~> rename ^^ (r => TsImportedStar(Some(r))) |
          "{" ~> rep(tsIdent ~ rename.? <~ ",".? ^^ { case x1 ~ x2 => (x1, x2) }) <~ "}" ^^ TsImportedDestructured |
          tsIdent ^^ TsImportedIdent,
        ","
      )
    }

    val importee: Parser[TsImportee] = {
      val required: Parser[TsImporteeRequired] =
        "=" ~> "require" ~> "(" ~> tsIdentModule <~ ")" ^^ TsImporteeRequired

      val from: Parser[TsImporteeFrom] =
        "from" ~> tsIdentModule ^^ TsImporteeFrom.apply

      val local: Parser[TsImporteeLocal] =
        "=" ~> qualifiedIdent ^^ TsImporteeLocal

      required | from | local
    }

    val normalImport: Parser[TsImport] =
      "import" ~> imported ~ importee ^^ TsImport

    val raw: Parser[TsImport] =
      "import" ~> tsIdentModule ^^ (id => TsImport(Seq(TsImportedStar(None)), TsImporteeFrom(id)))

    normalImport | raw
  }

  val tsExport: Parser[TsExport] = {
    val exportType: Parser[ExportType] =
      ("default" | "=").? ^^ {
        case Some("default") => ExportType.Defaulted
        case Some("=")       => ExportType.Namespaced
        case _               => ExportType.Named
      }

    val exportee: Parser[TsExportee] = {
      val from: Parser[TsIdentModule] =
        "from" ~> tsIdentModule

      val asNameOpt: Parser[Option[TsIdent]] =
        ("as" ~> tsIdent).?

      val exportedNames: Parser[TsExporteeNames] = {
        val maybeRenamedName: Parser[(TsQIdent, Option[TsIdent])] =
          qualifiedIdent ~ asNameOpt ^^ tuple2

        val one  = maybeRenamedName.map(Seq(_))
        val many = "{" ~> rep(maybeRenamedName <~ (";" | ",").?) <~ comments.? <~ "}"

        (one | many) ~ from.? ^^ TsExporteeNames
      }

      val exporteeStar: Parser[TsExporteeStar] =
        "*" ~> from ~ asNameOpt ^^ TsExporteeStar

      val exporteeTree: Parser[TsExporteeTree] =
        tsDecl ^^ TsExporteeTree

      exporteeTree | exportedNames | exporteeStar
    }

    (comments <~ "export") ~ exportType ~ exportee ^^ TsExport
  }

  lazy val exportAsNamespace: Parser[TsExportAsNamespace] =
    "export" ~> ("as" ~ "namespace" ~> tsIdent ^^ TsExportAsNamespace)

  lazy val isDeclared: TsParser.Parser[Boolean] =
    "declare".isDefined

  lazy val zeroLocation: Parser[JsLocation] = success(JsLocation.Zero)
  lazy val zeroCodePath: Parser[CodePath]   = success(CodePath.NoPath)

  lazy val tsDeclVar: Parser[TsDeclVar] = {
    val variable = ("var" | "let") ^^ (_ => false)
    val constant = "const" ^^ (_         => true)
    comments ~ isDeclared ~ (variable | constant) ~ tsIdent ~ typeAnnotationOpt ~ ("=" ~> tsLiteral).? ~ zeroLocation ~ zeroCodePath ~ success(
      false
    ) ^^ TsDeclVar
  }

  lazy val tsDeclFunction: Parser[TsDeclFunction] =
    comments ~ (isDeclared <~ "function") ~ identifierOrDefault ~ functionSignature ~ zeroLocation ~ zeroCodePath ^^ TsDeclFunction

  lazy val tsDeclEnum: Parser[TsDeclEnum] =
    comments ~ (isDeclared <~ ("const".? ~> "enum")) ~ tsIdent ~ ("{" ~> tsEnumMembers <~ "}") ~ zeroLocation ~ zeroCodePath ^^ TsDeclEnum

  lazy val tsEnumMembers: Parser[Seq[TsEnumMember]] = {
    val base: Parser[TsEnumMember] =
      comments ~ tsIdent ~ ("=" ~> either(tsLiteral, tsIdent)).? ~ delimMaybeComment(',').? ^^ {
        case cs ~ pn ~ lo ~ oc => TsEnumMember(cs +? oc.flatten, pn, lo)
      }

    rep(base)
  }

  lazy val tsDeclClass: Parser[TsDeclClass] = {
    val isAbstract: Parser[Boolean] =
      "abstract".isDefined

    val parent: Parser[Option[TsTypeRef]] =
      ("extends" ~> typeRef).?

    val implements: Parser[List[TsTypeRef]] =
      "implements" ~> repsep(typeRef, ",") | success(Nil)

    /* hack to avoid that `identifier` consumes `extends` for default exported classes without name */
    val hack: Parser[TsIdent] =
      tsIdent.filter(_.value =/= "extends")

    comments ~ isDeclared ~ (isAbstract <~ "class") ~ (hack ~ tsTypeParams).? ~ parent ~ implements ~ tsMembers ^^ {
      case cs ~ decl ~ abs ~ Some(ident ~ tparams) ~ par ~ impl ~ members =>
        TsDeclClass(cs, decl, abs, ident, tparams, par, impl, members, JsLocation.Zero, CodePath.NoPath)
      case cs ~ decl ~ abs ~ None ~ par ~ impl ~ members =>
        TsDeclClass(cs, decl, abs, TsIdent.default, Nil, par, impl, members, JsLocation.Zero, CodePath.NoPath)
    }
  }

  lazy val tsDeclInterface: Parser[TsDeclInterface] = {
    val intfInheritance: Parser[List[TsTypeRef]] =
      "extends" ~> repsep(typeRef, ",") | success(Nil)

    comments ~ isDeclared ~ ("interface" ~> tsIdent) ~ tsTypeParams ~ intfInheritance ~ tsMembers ~ zeroCodePath ^^ TsDeclInterface
  }

  lazy val tsDeclTypeAlias: Parser[TsDeclTypeAlias] =
    comments ~ (isDeclared <~ "type") ~ tsIdent ~ tsTypeParams ~ ("=" ~> tsType) ~ zeroCodePath ^^ TsDeclTypeAlias

  lazy val tsTypeKeyOf: Parser[TsTypeKeyOf] =
    "keyof" ~> tsType ^^ TsTypeKeyOf

  lazy val typeParam: Parser[TsTypeParam] =
    comments ~ tsIdent ~ ("extends" ~> perhapsParens(tsType)).? ~ ("=" ~> tsType).? ^^ TsTypeParam.apply

  lazy val tsTypeParams: Parser[List[TsTypeParam]] =
    "<" ~> rep1sep(typeParam, ",") <~ ",".? <~ ">" | success(Nil)

  lazy val functionSignature: Parser[TsFunSig] =
    comments ~ tsTypeParams ~ ("(" ~> rep(functionParam) <~ ")") ~ typeAnnotationOpt ^^ TsFunSig

  lazy val functionParam: Parser[TsFunParam] = {
    /* todo: represent in tree */
    lazy val destructured: TsParser.Parser[TsIdent] =
      "{" ~> rep((tsIdent | ("..." ~> tsIdent)) <~ (":" <~ (tsIdent | destructured)).? <~ ",".?) <~ "}" ^^ (
          ids => TsIdent("has" + ids.map(_.value.capitalize).mkString(""))
      )

    comments ~ "...".isDefined ~ (tsIdent | destructured) ~ "?".isDefined ~ typeAnnotationOpt ~ delimMaybeComment(
      ','
    ).? ^^ {
      case cs ~ false ~ i ~ o ~ t ~ oc =>
        TsFunParam(cs +? oc.flatten, i, t, o)
      case cs ~ _ ~ i ~ _ ~ Some(ArrayType(t)) ~ oc =>
        TsFunParam(cs +? oc.flatten, i, Some(TsTypeRepeated(t)), isOptional = false)
      case cs ~ _ ~ i ~ o ~ t ~ oc =>
        val warning =
          s"Dropping repeated marker of param $i because its type $t is not an array type"
        TsFunParam(cs +? oc.flatten + Comment.warning(warning), i, t, o)
    }
  }

  lazy val typeAnnotation: Parser[TsType] =
    ":" ~> tsType

  lazy val typeAnnotationOpt: Parser[Option[TsType]] =
    typeAnnotation.?

  lazy val tsType: Parser[TsType] = {

    val baseTypeDesc: Parser[TsType] = {
      val tsTypeFunction: Parser[TsTypeFunction] =
        comments ~ tsTypeParams ~ ("(" ~> rep(functionParam) <~ ")") ~ ("=>" ~> tsType) ^^ {
          case cs ~ tparams ~ params ~ resultType => TsTypeFunction(TsFunSig(cs, tparams, params, Some(resultType)))
        }

      ((tsIdent <~ "is") ~ tsType ^^ TsTypeIs
        | tsMembers ^^ TsTypeObject
        | tsTypeFunction
        | "new" ~> tsTypeFunction ^^ TsTypeConstructor
        | "unique" ~> "symbol" ~> success(TsTypeRef(TsQIdent.symbol, Nil))
        | "typeof" ~> qualifiedIdent ^^ TsTypeQuery
        | "[" ~> rep1(tsType <~ delimMaybeComment(',').?) <~ "]" ^^ TsTypeTuple
        | "(" ~> tsType <~ ")"
        | tsLiteral ^^ TsTypeLiteral
        | "this" ~> success(TsTypeThis())
        | tsTypeKeyOf
        | "infer" ~> typeParam ^^ TsTypeInfer
        | typeRef)
    }

    val tsTypeLookup: Parser[TsType] =
      baseTypeDesc ~ rep("[" ~> either(tsTypeKeyOf, tsIdent).^^(_.swap) <~ "]") ^^ {
        case base ~ typeLookups =>
          (base /: typeLookups) { (elem, key) =>
            TsTypeLookup(elem, key)
          }
      }

    val arrayType: Parser[TsType] =
      tsTypeLookup ~ rep("[" ~ "]") ^^ {
        case base ~ arrayDims =>
          (base /: arrayDims) { (elem, _) =>
            ArrayType(elem)
          }
      }

    val union: Parser[TsType] =
      "|".? ~> rep1sep(arrayType, "|") ^^ TsTypeUnion.simplified

    val intersect = "&".? ~> rep1sep(union, "&") ^^ {
      case head :: Nil => head
      case more        => TsTypeIntersect.simplified(more)
    }

    val _extends =
      intersect ~ "extends" ~ tsType ^^ { case _1 ~ _ ~ _2 => TsTypeExtends(_1, _2) }

    lazy val conditional: Parser[TsType] =
      _extends ~ "?" ~ tsType ~ ":" ~ tsType ^^ {
        case _1 ~ _ ~ _2 ~ _ ~ _3 => TsTypeConditional(_1, _2, _3)
      }

    conditional | _extends | intersect
  }

  lazy val typeRef: Parser[TsTypeRef] = {

    val typeArgs: Parser[List[TsType]] =
      ("<" ~> rep1(tsType <~ delimMaybeComment(',').?) <~ ">") | success(List.empty[TsType])

    val core = qualifiedIdent ~ typeArgs ^^ flatten2(TsTypeRef.apply)

    val empty = "{" ~> "}" ^^ (_ => TsTypeRef.`object`)

    perhapsParens(core | empty)
  }

  lazy val tsMembers: Parser[Seq[TsMember]] =
    "{" ~> rep(tsMember <~ (";" | ",").*) <~ comments.? <~ "}"

  lazy val tsMemberNamed: Parser[TsMember] = {

    val intro: Parser[(ProtectionLevel, TsIdent, Boolean, Boolean)] = {
      def mapper(
          mods: List[TsIdent],
          name: TsIdent
      ): (ProtectionLevel, TsIdent, Boolean, Boolean) = {
        val level: ProtectionLevel =
          if (mods.contains(TsIdent("protected"))) Protected
          else if (mods.contains(TsIdent("private"))) Private
          else Default

        val static   = mods.contains(TsIdent("static"))
        val readonly = mods.contains(TsIdent("readonly"))
        (level, name, static, readonly)
      }

      tsIdent.+ ^^ {
        case mods :+ name => mapper(mods, name)
      }
    }

    val function: Parser[TsMemberFunction] =
      comments ~ intro ~ "?".isDefined ~ functionSignature ^^ {
        case cs ~ ((level, name, static, readOnly)) ~ isOptional ~ sig =>
          TsMemberFunction(cs, level, name, sig, static, readOnly, isOptional)
      }

    val field: Parser[TsMemberProperty] =
      comments ~ intro ~ "?".isDefined ~ typeAnnotationOpt ^^ {
        case cs ~ ((level, name, static, readonly)) ~ optional ~ tpe =>
          TsMemberProperty(cs, level, name, tpe, static, readonly, optional)
      }

    function | field
  }

  lazy val tsMemberTypeMapped: Parser[TsMemberTypeMapped] = {
    val opt: Parser[OptionalModifier] = ("-?" | "?").? ^^ {
      case Some("?")  => OptionalModifier.Optionalize
      case Some("-?") => OptionalModifier.Deoptionalize
      case _          => OptionalModifier.Noop
    }

    comments ~ protectionLevel ~ "readonly".isDefined ~ ("[" ~> tsIdent <~ "in") ~ (tsType <~ "]") ~ opt ~ typeAnnotation ^^ TsMemberTypeMapped
  }

  lazy val tsMember: Parser[TsMember] = {

    val tsMemberCall: Parser[TsMemberCall] =
      comments ~ protectionLevel ~ functionSignature ^^ TsMemberCall

    val tsMemberCtor: Parser[TsMemberCtor] =
      comments ~ ("new" ~> protectionLevel) ~ functionSignature ^^ TsMemberCtor

    val indexing: Parser[Indexing] = (
      ("[" ~> tsIdent ~ typeAnnotation <~ "]") ^^ IndexingDict
        | ("[" ~> qualifiedIdent <~ "]") ^^ IndexingSingle
    )

    val indexedType: Parser[TsType] =
      typeAnnotation |
        (comments ~ tsTypeParams ~ ("(" ~> rep(functionParam) <~ ")") ~ (":" ~> tsType) ^^ {
          case cs ~ tparams ~ params ~ resultType => TsTypeFunction(TsFunSig(cs, tparams, params, Some(resultType)))
        })

    val tsMemberIndex: Parser[TsMemberIndex] =
      comments ~ "readonly".isDefined ~ protectionLevel ~ indexing ~ "?".isDefined ~ indexedType ^^ TsMemberIndex

    tsMemberCall | tsMemberCtor | tsMemberIndex | tsMemberNamed | tsMemberTypeMapped
  }

  lazy val protectionLevel: Parser[ProtectionLevel] =
    ("private" | "protected" | "public").? ^^ {
      case Some("private")   => Private
      case Some("protected") => Protected
      case _                 => Default
    }

  lazy val tsIdent: Parser[TsIdentSimple] =
    identifierName ^^ TsIdent.apply | (tsLiteralString ^^ (lit => TsIdentSimple(lit.value)))

  lazy val identifierOrDefault: Parser[TsIdent] =
    identifierName.? ^^ (oi => TsIdent(oi.getOrElse("default")))

  lazy val qualifiedIdent: Parser[TsQIdent] =
    rep1sep(tsIdent, ".") ^^ TsQIdent.apply

  lazy val tsLiteralString: Parser[TsLiteralString] =
    stringLit ^^ EscapeStrings.java ^^ TsLiteralString.apply

  lazy val tsIdentModule: Parser[TsIdentModule] =
    tsLiteralString ^^ ModuleNameParser.apply

  lazy val tsLiteralNumber: Parser[TsLiteralNumber] =
    numericLit ^^ TsLiteralNumber

  lazy val tsLiteralBoolean: Parser[TsLiteralBoolean] =
    accept("boolean literal", {
      case lexical.Keyword("true")  => TsLiteralBoolean(true)
      case lexical.Keyword("false") => TsLiteralBoolean(false)
    })

  lazy val tsLiteral: Parser[TsLiteral] =
    tsLiteralString | tsLiteralNumber | tsLiteralBoolean

  object ArrayType {
    def apply(elem: TsType): TsTypeRef =
      TsTypeRef(TsQIdent.Array, List(elem))

    def unapply(typeRef: TsTypeRef): Option[TsType] =
      typeRef match {
        case TsTypeRef(TsQIdent.Array, List(elem)) => Some(elem)
        case _                                     => None
      }
  }
}
