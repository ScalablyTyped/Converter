package com.olvind.tso
package ts
package parser

import scala.util.parsing.combinator.syntactical._
import scala.util.parsing.input.{OffsetPosition, Reader}

object TsParser extends TsParser(None)

/**
  * We cache results of some parsers because scala parser combinators are sooo slow.
  * This means that a given `TsParser` is only valid for the given `path`, if provided
  *
  * @param path with length of file
  */
class TsParser(path: Option[(os.Path, Int)]) extends StdTokenParsers with ParserHelpers with ImplicitConversions1 {
  self =>
  type Tokens = TsLexer.type
  override val lexical: TsLexer.type = TsLexer

  protected def perhapsParens[T](p: Parser[T]): Parser[T] =
    p | Parser("(") ~> p <~ ")"

  /* enable direct use of parsers with strings */
  implicit def FromString[T](p: Parser[T]): String => ParseResult[T] =
    (str: String) => phrase(p)(new lexical.Scanner(str))

  def memo[P](p: Parser[P]): Parser[P] =
    path match {
      case Some((_, length)) =>
        val cache = Array.ofDim[ParseResult[P]](length + 1)

        in =>
          in.pos match {
            case OffsetPosition(_, offset) =>
              val existing = cache(offset)
              if (existing ne null) existing
              else {
                val res = p(in)
                cache(offset) = res
                res
              }
            case _ => p(in)
          }
      case None => p
    }

  def apply(content: String): ParseResult[TsParsedFile] =
    parsedTsFile(content)

  /* handle stray comments */
  override def Parser[T](f: Input => ParseResult[T]): Parser[T] =
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
      },
    )

  val operator: Parser[String] =
    accept(
      "Operator", {
        case lexical.Keyword(chars) if lexical.ops.contains(chars) => chars
      },
    )

  val comment: Parser[Comment] =
    accept(
      "comment", {
        case lexical.CommentBlockToken(chars)             => Comment(chars)
        case lexical.CommentLineToken(chars)              => Comment(chars)
        case lexical.CommentLineTokenAfterDelim(_, chars) => Comment(chars)
      },
    )

  lazy val comments: Parser[Comments] =
    memo(comment.* ^^ Comments.apply)

  def delimMaybeComment(delims: Char*): Parser[Option[Comment]] =
    accept(
      "Line comment (after delim)", {
        case lexical.CommentLineTokenAfterDelim(delim, chars) if delims contains delim =>
          Some(Comment(chars))
        case lexical.Keyword(chars) if chars.length === 1 && delims.contains(chars.head) =>
          None
      },
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
        case lexical.DirectiveToken("reference", "no-default-lib", "true") => DirectiveNoStdLib
        case lexical.DirectiveToken("amd-module", "name", value)           => AmdModule(value)
      },
    ) named "directive"

  lazy val directives: Parser[Seq[Directive]] =
    (comments ~> directive).* named "directives"

  lazy val shebang = accept("Shebang", {
    case lexical.Shebang(_) => ()
  })

  lazy val parsedTsFile: Parser[TsParsedFile] =
    shebang.? ~> comments ~ directives ~ tsContainerOrDecls ~ success(CodePath.NoPath) ^^ TsParsedFile

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
    memo("{" ~>! tsContainerOrDecls <~ "}")

  lazy val tsDeclNamespace: Parser[TsDeclNamespace] =
    comments ~ (isDeclared <~ "namespace") ~ rep1sep(tsIdent, ".") ~ tsContainerOrDeclBody ^^ {
      case (cs ~ declared ~ (initNameParts :+ lastNamePart)) ~ body =>
        initNameParts.foldRight(
          TsDeclNamespace(cs, declared, lastNamePart, body, CodePath.NoPath, JsLocation.Zero),
        ) { (name: TsIdentSimple, inner: TsDeclNamespace) =>
          TsDeclNamespace(
            NoComments,
            declared,
            name,
            inner :: Nil,
            CodePath.NoPath,
            JsLocation.Zero,
          )
        }
    }

  lazy val tsDeclModule: Parser[TsNamedDecl] = {
    comments ~ (isDeclared <~ "module") ~ either(tsIdentModule, rep1sep(tsIdent, ".")) ~ tsContainerOrDeclBody.? ^^ {
      case cs ~ declared ~ nameEither ~ body =>
        nameEither match {
          case Left(name) =>
            TsDeclModule(cs, declared, name, body.getOrElse(Nil), CodePath.NoPath, JsLocation.Zero)
          case Right(idents) =>
            val initNameParts :+ lastNamePart = idents

            initNameParts.foldRight(
              TsDeclNamespace(
                cs,
                declared,
                lastNamePart,
                body.getOrElse(Nil),
                CodePath.NoPath,
                JsLocation.Zero,
              ),
            ) { (name: TsIdentSimple, inner: TsDeclNamespace) =>
              TsDeclNamespace(
                NoComments,
                declared,
                name,
                inner :: Nil,
                CodePath.NoPath,
                JsLocation.Zero,
              )
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
        ",",
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
        val many = "{" ~>! rep(maybeRenamedName <~! (";" | ",").?) <~ comments.? <~ "}"

        (one | many) ~ from.? ^^ TsExporteeNames
      }

      val exporteeStar: Parser[TsExporteeStar] =
        "*" ~> from ^^ TsExporteeStar

      val exporteeTree: Parser[TsExporteeTree] =
        tsDecl ^^ TsExporteeTree

      exporteeTree | exportedNames | exporteeStar
    }

    (comments <~ "export") ~ exportType ~! exportee ^^ TsExport
  }

  lazy val exportAsNamespace: Parser[TsExportAsNamespace] =
    "export" ~> ("as" ~ "namespace" ~>! tsIdent ^^ TsExportAsNamespace)

  lazy val isDeclared: Parser[Boolean] =
    "declare".isDefined

  lazy val zeroLocation: Parser[JsLocation] = success(JsLocation.Zero)
  lazy val zeroCodePath: Parser[CodePath]   = success(CodePath.NoPath)

  @deprecated("properly support multiple vars in one statement", "")
  lazy val tsDeclVar: Parser[TsDeclVar] = tsDeclVars ^^ {
    case Nil           => sys.error("Impossible")
    case first :: Nil  => first
    case first :: rest => first.copy(comments = Comments(Comment.warning(s"Dropped ${rest.map(_.name.value)}")))
  }

  lazy val tsDeclVars: Parser[List[TsDeclVar]] = {
    val variable = ("var" | "let") ^^ (_ => false)
    val constant = "const" ^^ (_         => true)
    comments ~ isDeclared ~ (variable | constant) ~ rep1sep(tsIdent ~ typeAnnotationOpt ~ ("=" ~> expr).?, ",") ^^ {
      case cs ~ declared ~ isReadonly ~ vars =>
        vars.map {
          case name ~ tpe ~ expr =>
            TsDeclVar(cs, declared, isReadonly, name, tpe, expr, JsLocation.Zero, CodePath.NoPath, isOptional = false)
        }
    }
  }

  lazy val tsDeclFunction: Parser[TsDeclFunction] =
    comments ~ (isDeclared <~ "function") ~ identifierOrDefault ~ functionSignature ~ zeroLocation ~ zeroCodePath ^^ TsDeclFunction

  lazy val tsDeclEnum: Parser[TsDeclEnum] =
    comments ~ isDeclared ~ ("const".isDefined <~ "enum") ~ tsIdent ~ ("{" ~> tsEnumMembers <~ "}") ~ success(true) ~ success(
      None,
    ) ~ zeroLocation ~ zeroCodePath ^^ TsDeclEnum

  lazy val tsEnumMembers: Parser[Seq[TsEnumMember]] = {
    val base: Parser[TsEnumMember] =
      comments ~ tsIdentLiberal ~ ("=" ~> expr).? ~ delimMaybeComment(',').? ^^ {
        case cs ~ name ~ exprOpt ~ oc => TsEnumMember(cs +? oc.flatten, name, exprOpt)
      }

    rep(base)
  }

  lazy val tsDeclClass: Parser[TsDeclClass] = {
    val isAbstract: Parser[Boolean] =
      "abstract".isDefined

    val functionCall: Parser[TsTypeRef] =
      expr ^^ {
        case TsExpr.Ref(ref) => ref
        case other =>
          val str = s"${TsExpr.format(other)}"
          TsTypeRef.any.copy(Comments(Comment.warning(s"class extends from : $str")))
      }

    val parent: Parser[Option[TsTypeRef]] =
      ("extends" ~> (functionCall | tsTypeRef)).?

    val implements: Parser[List[TsTypeRef]] =
      "implements" ~> repsep(tsTypeRef, ",") | success(Nil)

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
      "extends" ~> repsep(tsTypeRef, ",") | success(Nil)

    comments ~ isDeclared ~ ("interface" ~> tsIdent) ~ tsTypeParams ~ intfInheritance ~ tsMembers ~ zeroCodePath ^^ TsDeclInterface
  }

  lazy val tsDeclTypeAlias: Parser[TsDeclTypeAlias] =
    comments ~ (isDeclared <~ "type") ~ tsIdent ~ tsTypeParams ~ ("=" ~>! tsType) ~ zeroCodePath ^^ TsDeclTypeAlias

  lazy val tsTypeKeyOf: Parser[TsTypeKeyOf] =
    "keyof" ~>! baseTypeDesc ^^ TsTypeKeyOf

  lazy val typeParam: Parser[TsTypeParam] =
    comments ~ tsIdent ~ ("extends" ~>! perhapsParens(tsType)).? ~ ("=" ~>! tsType).? ^^ TsTypeParam.apply

  lazy val tsTypeParams: Parser[List[TsTypeParam]] =
    "<" ~>! rep1sep(typeParam, ",") <~! ",".? <~! ">" | success(Nil)

  val tsFunctionParams: Parser[List[TsFunParam]] = rep(functionParam) ^^ {
    /* */
    case ps if ps.count(_.name.value === "has") > 1 =>
      ps.zipWithIndex.map {
        case (p @ TsFunParam(_, TsIdentSimple("has"), _, _), idx) => p.copy(name = TsIdent("has" + idx))
        case (other, _)                                           => other
      }
    case ok => ok
  }

  lazy val functionSignature: Parser[TsFunSig] =
    comments ~ tsTypeParams ~ ("(" ~>! tsFunctionParams <~ ")") ~ typeAnnotationOpt ^^ TsFunSig

  lazy val functionParam: Parser[TsFunParam] = {
    /* Represent in tree? */
    lazy val destructuredObj: Parser[TsIdent] =
      "{" ~>! rep((tsIdent | ("..." ~> tsIdent)) <~ (":" <~ (tsIdent | destructured)).? <~ ",".?) <~ "}" ^^ (
          ids =>
            TsIdent("has" + ids.map(_.value.capitalize).mkString("")),
        )
    lazy val destructuredArray: Parser[TsIdent] =
      "[" ~>! repsep(tsIdent <~ (":" <~ (tsIdent | destructured)).?, ",") <~ "]" ^^ (
          ids =>
            TsIdent("has" + ids.map(_.value.capitalize).mkString("")),
        )
    lazy val destructured = destructuredArray | destructuredObj

    comments ~ "...".isDefined ~ (tsIdent | destructured) ~ "?".isDefined ~ (typeAnnotationOpt <~ ("=" ~ expr).?) ~ delimMaybeComment(
      ',',
    ).? ^^ {
      case cs ~ false ~ i ~ o ~ t ~ oc =>
        TsFunParam(cs +? oc.flatten, i, t, o)
      case cs ~ _ ~ i ~ _ ~ Some(ArrayType(t)) ~ oc =>
        TsFunParam(cs +? oc.flatten, i, Some(TsTypeRepeated(t)), isOptional = false)
      case cs ~ _ ~ i ~ o ~ t ~ oc =>
        val warning =
          s"Dropping repeated marker of param ${i.value} because its type ${t.fold("<none>")(tpe => TsTypeFormatter(tpe))} is not an array type"
        TsFunParam(cs +? oc.flatten + Comment.warning(warning), i, t, o)
    }
  }

  lazy val typeAnnotation: Parser[TsType] =
    ":" ~>! tsType

  lazy val typeAnnotationOpt: Parser[Option[TsType]] =
    typeAnnotation.?

  lazy val expr: Parser[TsExpr] = {
    lazy val lit:   Parser[TsExpr.Literal] = tsLiteral ^^ TsExpr.Literal
    lazy val ref:   Parser[TsExpr.Ref]     = ("{}" ^^ (_ => TsTypeRef.Object) | tsTypeRef) ^^ TsExpr.Ref
    lazy val call:  Parser[TsExpr.Call]    = ref ~ ("(" ~> repsep(expr, ",") <~ ")") ^^ TsExpr.Call
    lazy val unary: Parser[TsExpr.Unary]   = (operator ~ expr) ^^ TsExpr.Unary

    lazy val base: Parser[TsExpr] = perhapsParens(lit | call | unary | ref)

    lazy val binaryOp: Parser[TsExpr.BinaryOp] = (base ~ operator ~ expr) ^^ TsExpr.BinaryOp

    perhapsParens(binaryOp | base)
  }

  lazy val baseTypeDesc: Parser[TsType] = {
    val tsTypeFunction: Parser[TsTypeFunction] =
      comments ~ tsTypeParams ~ ("(" ~> tsFunctionParams <~ ")") ~ ("=>" ~> tsType) ^^ {
        case cs ~ tparams ~ params ~ resultType => TsTypeFunction(TsFunSig(cs, tparams, params, Some(resultType)))
      }

    ((tsIdent <~ "is") ~ tsType ^^ TsTypeIs
      | comments ~ tsMembers ^^ TsTypeObject
      | tsTypeFunction
      | "new" ~> tsTypeFunction ^^ TsTypeConstructor
      | "unique" ~> "symbol" ~> success(TsTypeRef(NoComments, TsQIdent.symbol, Nil))
      | "typeof" ~> qualifiedIdent ^^ TsTypeQuery
      | tsTypeTuple
      | "(" ~> tsType <~ ")"
      | tsLiteral ^^ TsTypeLiteral
      | "this" ~> success(TsTypeThis())
      | tsTypeKeyOf
      | "infer" ~> typeParam ^^ TsTypeInfer
      | "readonly" ~> tsType
      | tsTypeRef)
  }

  lazy val tsType: Parser[TsType] = {
    val tsTypeLookupAndArray: Parser[TsType] = memo {
      baseTypeDesc ~ rep("[" ~> tsType.? <~ "]") ^^ {
        case base ~ typeLookups =>
          (base /: typeLookups) {
            case (elem, Some(key)) => TsTypeLookup(elem, key)
            case (elem, None)      => ArrayType(elem)
          }
      }
    }

    val intersect = "&".? ~> rep1sep(tsTypeLookupAndArray, "&") ^^ {
      case head :: Nil => head
      case more        => TsTypeIntersect.simplified(more)
    }

    val union: Parser[TsType] =
      "|".? ~> rep1sep(intersect, "|") ^^ TsTypeUnion.simplified

    val _extends =
      union ~ "extends" ~ tsType ^^ { case _1 ~ _ ~ _2 => TsTypeExtends(_1, _2) }

    lazy val conditional: Parser[TsType] =
      _extends ~ "?" ~ tsType ~ ":" ~ tsType ^^ {
        case _1 ~ _ ~ _2 ~ _ ~ _3 => TsTypeConditional(_1, _2, _3)
      }

    conditional | _extends | union
  }

  lazy val tsTypeTuple: Parser[TsTypeTuple] = {
    val tsTypeRepeated: Parser[TsTypeRepeated] =
      "..." ~>! tsType ^? {
        case ArrayType(t) => TsTypeRepeated(t)
      }

    val normal: Parser[TsType] =
      tsType ~ "?".isDefined ^^ {
        case tpe ~ true  => TsTypeUnion(List(tpe, TsTypeRef.undefined))
        case tpe ~ false => tpe
      }

    "[" ~>! rep((tsTypeRepeated | normal) <~ delimMaybeComment(',').?) <~ "]" ^^ TsTypeTuple
  }

  lazy val tsTypeRef: Parser[TsTypeRef] = {
    val typeArgs: Parser[List[TsType]] =
      ("<" ~> rep1(tsType <~ delimMaybeComment(',').?) <~ ">") | success(List.empty[TsType])

    val base = comments ~ qualifiedIdent ~ typeArgs ^^ flatten3(TsTypeRef.apply)

    val empty = "{" ~> "}" ^^ (_ => TsTypeRef.`object`)

    perhapsParens(base | empty)
  }

  lazy val tsMembers: Parser[Seq[TsMember]] =
    memo("{" ~>! rep(tsMember <~! (";" | ",").*) <~ comments.? <~ "}")

  lazy val tsMemberNamed: Parser[TsMember] = {

    val intro: Parser[(ProtectionLevel, TsIdent, Boolean, Boolean)] =
      tsIdentLiberal.+ ^^ {
        case mods :+ name =>
          val level: ProtectionLevel =
            if (mods.contains(TsIdent("protected"))) ProtectionLevel.Protected
            else if (mods.contains(TsIdent("private"))) ProtectionLevel.Private
            else ProtectionLevel.Default

          val static   = mods.contains(TsIdent("static"))
          val readonly = mods.contains(TsIdent("readonly"))
          (level, name, static, readonly)
      }

    val function: Parser[TsMemberFunction] =
      comments ~ intro ~ "?".isDefined ~ functionSignature ^^ {
        case cs ~ ((level, name, static, readOnly)) ~ isOptional ~ sig =>
          TsMemberFunction(cs, level, name, sig, static, readOnly, isOptional)
      }

    val field: Parser[TsMemberProperty] =
      comments ~ intro ~ "?".isDefined ~ typeAnnotationOpt ~ ("=" ~> expr).? ^^ {
        case cs ~ ((level, name, static, readonly)) ~ optional ~ tpe ~ expr =>
          TsMemberProperty(cs, level, name, tpe, expr, static, readonly, optional)
      }

    function | field
  }

  lazy val tsMemberTypeMapped: Parser[TsMemberTypeMapped] = {
    val opt: Parser[OptionalModifier] = ("-?" | "+?" | "?").? ^^ {
      case Some("?")  => OptionalModifier.Optionalize
      case Some("+?") => OptionalModifier.Optionalize
      case Some("-?") => OptionalModifier.Deoptionalize
      case _          => OptionalModifier.Noop
    }

    comments ~ protectionLevel ~ "readonly".isDefined ~ ("[" ~> tsIdent <~ "in") ~! (tsType <~ "]") ~ opt ~ typeAnnotation ^^ TsMemberTypeMapped
  }

  lazy val tsMember: Parser[TsMember] = {

    val tsMemberCall: Parser[TsMemberCall] =
      comments ~ protectionLevel ~ functionSignature ^^ TsMemberCall

    val tsMemberCtor: Parser[TsMemberCtor] =
      comments ~ ("new" ~>! protectionLevel) ~ functionSignature ^^ TsMemberCtor

    val indexing: Parser[Indexing] = (
      ("[" ~> qualifiedIdent <~ "]") ^^ IndexingSingle
        | ("[" ~> tsIdent ~ typeAnnotation <~ "]") ^^ IndexingDict
    )

    val indexedType: Parser[TsType] =
      typeAnnotation | (functionSignature ^^ TsTypeFunction)

    val tsMemberIndex: Parser[TsMemberIndex] =
      comments ~ "readonly".isDefined ~ (protectionLevel <~ "readonly".isDefined) ~ indexing ~ "?".isDefined ~ indexedType.? ^^ TsMemberIndex

    tsMemberTypeMapped | tsMemberCall | tsMemberCtor | tsMemberIndex | tsMemberNamed
  }

  lazy val protectionLevel: Parser[ProtectionLevel] =
    ("private" | "protected" | "public").? ^^ {
      case Some("private")   => ProtectionLevel.Private
      case Some("protected") => ProtectionLevel.Protected
      case _                 => ProtectionLevel.Default
    }

  lazy val tsIdent: Parser[TsIdentSimple] =
    identifierName ^^ TsIdent.apply

  lazy val tsIdentLiberal: Parser[TsIdentSimple] =
    tsIdent | ((tsLiteralString | "[" ~> tsLiteralString <~ "]") ^^ (lit => TsIdent(lit.value)))

  lazy val tsIdentImport: Parser[TsIdentImport] =
    "import" ~> "(" ~> tsIdentModule <~ ")" ^^ TsIdentImport

  lazy val identifierOrDefault: Parser[TsIdent] =
    identifierName.? ^^ (oi => TsIdent(oi.getOrElse("default")))

  lazy val qualifiedIdent: Parser[TsQIdent] = {
    val normal = rep1sep(tsIdent, ".") ^^ TsQIdent.apply
    val withImport = tsIdentImport ~ rep("." ~> tsIdent) ^^ {
      case i ~ rest => TsQIdent(i :: rest)
    }
    withImport | normal
  }

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
      TsTypeRef(NoComments, TsQIdent.Array, List(elem))

    def unapply(typeRef: TsTypeRef): Option[TsType] =
      typeRef match {
        case TsTypeRef(NoComments, TsQIdent.Array, List(elem)) => Some(elem)
        case _                                                 => None
      }
  }
}
