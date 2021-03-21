package org.scalablytyped.converter.internal
package ts
package parser

import scala.util.parsing.combinator.syntactical._
import scala.util.parsing.input.{OffsetPosition, Reader}

object TsParser extends TsParser(None)

/****
  ** We cache results of some parsers because scala parser combinators are sooo slow.
  ** This means that a given `TsParser` is only valid for the given `path`, if provided
  **
  ** @param path with length of file
  **/
class TsParser(path: Option[(os.Path, Int)]) extends StdTokenParsers with ParserHelpers with ImplicitConversions1 {
  self =>
  type Tokens = TsLexer.type
  override val lexical: TsLexer.type = TsLexer

  protected def perhapsParens[T](p: Parser[T]): Parser[T] =
    p | ("(" ~> p <~ ")")

  /** enable direct use of parsers with strings **/
  implicit def FromString[T](p: Parser[T]): String => ParseResult[T] =
    (str: String) => phrase(p)(new lexical.Scanner(str.trim))

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

  /** handle stray comments **/
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

  val operator: Parser[String] = {
    val ops = List("+", "-", "^", "|", "*", "/", "%")

    /* handle specially, since they will occur as two separate tokens */
    val `<<`  = "<" ~> "<" ^^ (_ => "<<")
    val `>>`  = ">" ~> ">" ^^ (_ => ">>")
    val other = accept("Operator", { case lexical.Keyword(chars) if ops contains chars => chars })

    `<<` | `>>` | other
  }

  val comment: Parser[Comment] =
    accept(
      "comment", {
        case lexical.CommentBlockToken(chars) => Comment(chars)
        case lexical.CommentLineToken(chars)  => Comment(chars)
      },
    )

  lazy val comments: Parser[Comments] =
    memo(comment.* ^^ Comments.apply)

  lazy val directive: Parser[Directive] =
    accept(
      "Directive", {
        case lexical.DirectiveToken("reference", "lib", value)   => DirectiveLibRef(value)
        case lexical.DirectiveToken("reference", "types", value) => DirectiveTypesRef(value)
        case lexical.DirectiveToken("references", "types", value) =>
          DirectiveTypesRef(value) // not sure if it's a typo, but we'll retain the hint
        case lexical.DirectiveToken("reference", "path", value)            => DirectivePathRef(value)
        case lexical.DirectiveToken("reference", "no-default-lib", "true") => DirectiveNoStdLib
        case lexical.DirectiveToken("amd-module", "name", value)           => AmdModule(value)
      },
    ).named("directive")

  lazy val directives: Parser[IArray[Directive]] =
    (comments ~> directive).**.named("directives")

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
    directive.** ~> (tsDecl | tsGlobal) <~ ";".? <~ directive.**

  lazy val tsContainerOrDecls: Parser[IArray[TsContainerOrDecl]] =
    tsContainerOrDecl.** <~ comments.?

  lazy val tsContainerOrDeclBody: Parser[IArray[TsContainerOrDecl]] =
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
            IArray(inner),
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
            TsDeclModule(cs, declared, name, body.getOrElse(Empty), CodePath.NoPath, JsLocation.Zero)
          case Right(idents) =>
            val initNameParts :+ lastNamePart = idents

            initNameParts.foldRight(
              TsDeclNamespace(
                cs,
                declared,
                lastNamePart,
                body.getOrElse(Empty),
                CodePath.NoPath,
                JsLocation.Zero,
              ),
            ) { (name: TsIdentSimple, inner: TsDeclNamespace) =>
              TsDeclNamespace(
                NoComments,
                declared,
                name,
                IArray(inner),
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

    val imported: Parser[IArray[TsImported]] = {
      val rename = "as" ~> tsIdent

      repsep_(
        "*" ~> rename ^^ (r => TsImportedStar(Some(r))) |
          "{" ~> (tsIdent ~ rename.? <~ ",".? ^^ { case x1 ~ x2 => (x1, x2) }).** <~ "}" ^^ TsImportedDestructured |
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
      "import" ~> "type".isDefined ~ imported ~ importee ^^ TsImport

    val raw: Parser[TsImport] =
      "import" ~> tsIdentModule ^^ (id => TsImport(typeOnly = false, IArray(TsImportedStar(None)), TsImporteeFrom(id)))

    normalImport | raw
  }

  val tsExport: Parser[TsExport] = {
    val exportType: Parser[ExportType] =
      ("default" | "=").? ^^ {
        case Some("default") => ExportType.Defaulted
        case Some("=")       => ExportType.Namespaced
        case _               => ExportType.Named
      }

    val exportee: Parser[Boolean ~ TsExportee] = {
      val from: Parser[TsIdentModule] =
        "from" ~> tsIdentModule

      val asNameOpt: Parser[Option[TsIdentSimple]] =
        ("as" ~> tsIdent).?

      val exportedNames: Parser[Boolean ~ TsExporteeNames] = {
        val maybeRenamedName: Parser[(TsQIdent, Option[TsIdentSimple])] =
          qualifiedIdent ~ asNameOpt ^^ tuple2

        val one  = maybeRenamedName.map(IArray(_))
        val many = "{" ~>! (maybeRenamedName <~! (";" | ",").?).** <~ comments.? <~ "}"

        val base = (one | many) ~ from.? ^^ TsExporteeNames
        ("type".isDefined ~ base) | (success(false) ~ base)
      }

      val exporteeStar: Parser[Boolean ~ TsExporteeStar] =
        success(false) ~ ("*" ~> ("as" ~> tsIdent).? ~ from ^^ TsExporteeStar.apply)

      val exporteeTree: Parser[Boolean ~ TsExporteeTree] =
        success(false) ~ (tsDecl ^^ TsExporteeTree)

      exporteeTree | exportedNames | exporteeStar
    }

    (comments <~ "export") ~ exportType ~! exportee ^^ {
      case cs ~ exportType ~ (typeOnly ~ exportee) => TsExport(cs, typeOnly, exportType, exportee)
    }
  }

  lazy val exportAsNamespace: Parser[TsExportAsNamespace] =
    "export" ~> ("as" ~ "namespace" ~>! tsIdent ^^ TsExportAsNamespace)

  lazy val isDeclared: Parser[Boolean] =
    "declare".isDefined

  lazy val zeroLocation: Parser[JsLocation] = success(JsLocation.Zero)
  lazy val zeroCodePath: Parser[CodePath]   = success(CodePath.NoPath)

  @deprecated("properly support multiple vars in one statement", "")
  lazy val tsDeclVar: Parser[TsDeclVar] = tsDeclVars ^^ {
    case IArray.Empty             => sys.error("Impossible")
    case IArray.exactlyOne(first) => first
    case IArray.headTail(first, rest) =>
      first.copy(comments = Comments(Comment.warning(s"Dropped ${rest.map(_.name.value)}")))
  }

  lazy val tsDeclVars: Parser[IArray[TsDeclVar]] = {
    val variable = ("var" | "let") ^^ (_ => false)
    val constant = "const" ^^ (_         => true)
    comments ~ isDeclared ~ (variable | constant) ~ rep1sep_(tsIdent ~ typeAnnotationOpt ~ ("=" ~> expr).?, ",") ^^ {
      case cs ~ declared ~ isReadonly ~ vars =>
        vars.map {
          case name ~ tpe ~ expr =>
            TsDeclVar(cs, declared, isReadonly, name, tpe, expr, JsLocation.Zero, CodePath.NoPath)
        }
    }
  }

  lazy val tsDeclFunction: Parser[TsDeclFunction] =
    comments ~ (isDeclared <~ "function") ~ identifierOrDefault ~ functionSignature ~ zeroLocation ~ zeroCodePath ^^ TsDeclFunction

  lazy val tsDeclEnum: Parser[TsDeclEnum] =
    comments ~ isDeclared ~ ("const".isDefined <~ "enum") ~ tsIdent ~ ("{" ~> tsEnumMembers <~ "}") ~ success(true) ~ success(
      None,
    ) ~ zeroLocation ~ zeroCodePath ^^ TsDeclEnum

  lazy val tsEnumMembers: Parser[IArray[TsEnumMember]] = {
    val member: Parser[TsEnumMember] =
      comments ~ tsIdentLiberal ~ ("=" ~> expr).? ^^ {
        case cs ~ name ~ exprOpt => TsEnumMember(cs, name, exprOpt)
      }

    repsep_(member, ",") <~ ",".?
  }

  lazy val tsDeclClass: Parser[TsDeclClass] = {
    val isAbstract: Parser[Boolean] =
      "abstract".isDefined

    val functionCall: Parser[TsTypeRef] =
      expr.filter(!_.isInstanceOf[TsExpr.Ref]) ^^ { notRef =>
        val str = s"${TsExpr.format(notRef)}"
        TsTypeRef.any.copy(Comments(Comment.warning(s"class extends from : $str")))
      }

    val parent: Parser[Option[TsTypeRef]] =
      ("extends" ~> (functionCall | tsTypeRef)).?

    val implements: Parser[IArray[TsTypeRef]] =
      "implements" ~> repsep_(tsTypeRef, ",") | success(Empty)

    /** hack to avoid that `identifier` consumes `extends` for default exported classes without name **/
    val hack: Parser[TsIdentSimple] =
      tsIdent.filter(_.value =/= "extends")

    comments ~ isDeclared ~ (isAbstract <~ "class") ~ (hack.? ~ tsTypeParams).? ~ parent ~ implements ~ tsMembers ^^ {
      case cs ~ decl ~ abs ~ Some(ident ~ tparams) ~ par ~ impl ~ members =>
        TsDeclClass(
          cs,
          decl,
          abs,
          ident.getOrElse(TsIdent.default),
          tparams,
          par,
          impl,
          members,
          JsLocation.Zero,
          CodePath.NoPath,
        )
      case cs ~ decl ~ abs ~ None ~ par ~ impl ~ members =>
        TsDeclClass(cs, decl, abs, TsIdent.default, Empty, par, impl, members, JsLocation.Zero, CodePath.NoPath)
    }
  }

  lazy val tsDeclInterface: Parser[TsDeclInterface] = {
    val intfInheritance: Parser[IArray[TsTypeRef]] =
      "extends" ~> repsep_(tsTypeRef, ",") | success(Empty)

    comments ~ isDeclared ~ ("interface" ~> tsIdent) ~ tsTypeParams ~ intfInheritance ~ tsMembers ~ zeroCodePath ^^ TsDeclInterface
  }

  lazy val tsDeclTypeAlias: Parser[TsDeclTypeAlias] =
    comments ~ (isDeclared <~ "type") ~ tsIdent ~ tsTypeParams ~ ("=" ~>! tsType) ~ zeroCodePath ^^ TsDeclTypeAlias

  lazy val tsTypeKeyOf: Parser[TsTypeKeyOf] =
    "keyof" ~>! baseTypeDesc ^^ TsTypeKeyOf

  lazy val typeParam: Parser[TsTypeParam] =
    comments ~ tsIdent ~ ("extends" ~>! perhapsParens(tsType)).? ~ ("=" ~>! tsType).? ^^ TsTypeParam.apply

  lazy val tsTypeParams: Parser[IArray[TsTypeParam]] =
    "<" ~>! repsep_(typeParam, ",") <~! ",".? <~! ">" | success(Empty)

  val tsFunctionParams: Parser[IArray[TsFunParam]] = functionParam.** ^^ {

    /** **/
    case ps if ps.count(_.name.value === "has") > 1 =>
      ps.zipWithIndex.map {
        case (p @ TsFunParam(_, TsIdentSimple("has"), _), idx) => p.copy(name = TsIdent("has" + idx))
        case (other, _)                                        => other
      }
    case ok => ok
  }

  lazy val functionSignature: Parser[TsFunSig] =
    comments ~ tsTypeParams ~ ("(" ~>! tsFunctionParams <~ ")") ~ typeAnnotationOpt ^^ TsFunSig

  lazy val functionParam: Parser[TsFunParam] = {

    /** Represent in tree? **/
    lazy val destructuredObj: Parser[TsIdentSimple] =
      "{" ~>! rep((tsIdentLiberal | ("..." ~> tsIdent)) <~ (":" <~ (tsIdent | destructured)).? <~ ",".?) <~ "}" ^^ (
          ids =>
            TsIdent("has" + ids.map(_.value.capitalize).mkString("")),
        )
    lazy val destructuredArray: Parser[TsIdentSimple] =
      "[" ~>! ",".? ~> repsep(tsIdent <~ (":" <~ (tsIdent | destructured)).?, ",") <~ "]" ^^ (
          ids =>
            TsIdent("has" + ids.map(_.value.capitalize).mkString("")),
        )
    lazy val destructured = destructuredArray | destructuredObj

    comments ~ "...".isDefined ~ (tsIdent | destructured) ~ "?".isDefined ~ (typeAnnotationOpt <~ ("=" ~ expr).?) <~ ",".? ^^ {
      case cs ~ false ~ i ~ o ~ t =>
        TsFunParam(cs, i, t.map(OptionalType.maybe(_, o)))
      case cs ~ _ ~ i ~ _ ~ Some(ArrayType(t)) =>
        TsFunParam(cs, i, Some(TsTypeRepeated(t)))
      case cs ~ _ ~ i ~ o ~ t =>
        val warning =
          s"Dropping repeated marker of param ${i.value} because its type ${t.fold("<none>")(tpe => TsTypeFormatter(tpe))} is not an array type"
        TsFunParam(cs + Comment.warning(warning), i, t.map(OptionalType.maybe(_, o)))
    }
  }

  lazy val typeAnnotation: Parser[TsType] =
    ":" ~>! tsType

  lazy val typeAnnotationOpt: Parser[Option[TsType]] =
    typeAnnotation.?

  lazy val expr: Parser[TsExpr] = {

    val lit:   Parser[TsExpr.Literal] = tsLiteral ^^ TsExpr.Literal
    val ref:   Parser[TsExpr.Ref]     = qualifiedIdent ^^ TsExpr.Ref
    val call:  Parser[TsExpr.Call]    = ref ~ ("(" ~> upgrade(repsep(expr, ",")) <~ ")") ^^ TsExpr.Call
    val unary: Parser[TsExpr.Unary]   = (operator ~ expr) ^^ TsExpr.Unary

    val base: Parser[TsExpr] = perhapsParens(lit | call | unary | ref)

    lazy val binaryOp: Parser[TsExpr.BinaryOp] = {
      val first = ("(" ~> binaryOp <~ ")") | base /* avoid left recursion for ever */
      (first ~ operator ~ expr) ^^ TsExpr.BinaryOp
    }

    val cast: Parser[TsExpr.Cast] = (base <~ "as") ~ tsType ^^ TsExpr.Cast

    perhapsParens(binaryOp | cast) | base
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
      | "unique" ~> "symbol" ~> success(TsTypeRef(NoComments, TsQIdent.symbol, Empty))
      | "typeof" ~> qualifiedIdent ^^ TsTypeQuery
      | tsTypeTuple
      | "(" ~> tsType <~ ")"
      | tsLiteral ^^ TsTypeLiteral
      | "this" ~> success(TsTypeThis())
      | "asserts" ~> tsIdent ~ ("is" ~> tsTypeRef).? ^^ TsTypeAsserts
      | tsTypeKeyOf
      | "infer" ~> typeParam ^^ TsTypeInfer
      | "readonly" ~> tsType
      | tsTypeRef)
  }

  lazy val tsType: Parser[TsType] = {
    val tsTypeLookupAndArray: Parser[TsType] = memo {
      baseTypeDesc ~ rep("[" ~> tsType.? <~ "]") ^^ {
        case base ~ typeLookups =>
          typeLookups.foldLeft(base) {
            case (elem, Some(key)) => TsTypeLookup(elem, key)
            case (elem, None)      => ArrayType(elem)
          }
      }
    }

    val intersect = "&".? ~> rep1sep_(tsTypeLookupAndArray, "&") ^^ {
      case IArray.exactlyOne(head) => head
      case more                    => TsTypeIntersect.simplified(more)
    }

    val union: Parser[TsType] =
      "|".? ~> rep1sep_(intersect, "|") ^^ TsTypeUnion.simplified

    val _extends =
      union ~ "extends" ~ tsType ^^ { case _1 ~ _ ~ _2 => TsTypeExtends(_1, _2) }

    lazy val conditional: Parser[TsType] =
      _extends ~ "?" ~ tsType ~ ":" ~ tsType ^^ {
        case _1 ~ _ ~ _2 ~ _ ~ _3 => TsTypeConditional(_1, _2, _3)
      }

    conditional | _extends | union
  }

  lazy val tsTypeTuple: Parser[TsTypeTuple] = {
    val repeatedElem: Parser[TsTupleElement] =
      "..." ~>! (tsIdent <~ ":").? ~ tsType ^^ {
        case label ~ tpe => TsTupleElement(label, TsTypeRepeated(tpe))
      }

    val unlabeledNonRepeatedElem: Parser[TsType] =
      tsType ~ "?".isDefined ^^ {
        case tpe ~ true  => TsTypeUnion(IArray(tpe, TsTypeRef.undefined))
        case tpe ~ false => tpe
      }

    val nonRepeatedElem: Parser[TsTupleElement] = (tsIdent ~ "?".isDefined <~ ":").? ~ unlabeledNonRepeatedElem ^^ {
      case None ~ tpe                => TsTupleElement(None, tpe)
      case Some(label ~ false) ~ tpe => TsTupleElement(Some(label), tpe)
      case Some(label ~ true) ~ tpe  => TsTupleElement(Some(label), TsTypeUnion(IArray(tpe, TsTypeRef.undefined)))
    }

    val tupleElem = repeatedElem | nonRepeatedElem

    "[" ~>! (tupleElem <~ ",".?).** <~ "]" ^^ TsTypeTuple
  }

  lazy val tsTypeRef: Parser[TsTypeRef] = {
    val typeArgs: Parser[IArray[TsType]] =
      ("<" ~> rep1_(tsType <~ ",".?) <~ ">") | success(IArray.Empty)

    val base = comments ~ qualifiedIdent ~ typeArgs ^^ flatten3(TsTypeRef.apply)

    val empty = "{" ~> "}" ^^ (_ => TsTypeRef.`object`)

    perhapsParens(base | empty)
  }

  lazy val tsMembers: Parser[IArray[TsMember]] =
    memo("{" ~>! ";".? ~> (tsMember <~! (";" | ",").*).** <~ comments.? <~ "}")

  lazy val tsMemberNamed: Parser[TsMember] = {

    val intro: Parser[(ProtectionLevel, TsIdentSimple, Boolean, Boolean, MethodType)] =
      tsIdentLiberal.+ ^^ {
        case mods :+ name =>
          val level: ProtectionLevel =
            if (mods.contains(TsIdent("protected"))) ProtectionLevel.Protected
            else if (mods.contains(TsIdent("private")) || name.value.startsWith("#")) ProtectionLevel.Private
            else ProtectionLevel.Default

          val static   = mods.contains(TsIdent("static"))
          val readonly = mods.contains(TsIdent("readonly"))
          val methodType =
            if (mods.contains(TsIdent("get"))) MethodType.Getter
            else if (mods.contains(TsIdent("set"))) MethodType.Setter
            else MethodType.Normal

          val fixedName =
            if (name.value.startsWith("#")) TsIdentSimple(name.value.drop(1))
            else name

          (level, fixedName, static, readonly, methodType)
      }

    val function: Parser[TsMember] =
      comments ~ intro ~ "?".isDefined ~ functionSignature ^^ {
        case cs ~ ((level, name, static, readOnly, methodType)) ~ false ~ sig =>
          TsMemberFunction(cs, level, name, methodType, sig, static, readOnly)
        case cs ~ ((level, name, static, readOnly, MethodType.Normal)) ~ true ~ sig =>
          TsMemberProperty(cs, level, name, Some(OptionalType(TsTypeFunction(sig))), None, static, readOnly)
      }

    val field: Parser[TsMemberProperty] =
      comments ~ intro ~ "?".isDefined ~ typeAnnotationOpt ~ ("=" ~> expr).? ^^ {
        case cs ~ ((level, name, static, readonly, _)) ~ optional ~ tpe ~ expr =>
          TsMemberProperty(cs, level, name, tpe.map(OptionalType.maybe(_, optional)), expr, static, readonly)
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

    val readonly: Parser[ReadonlyModifier] = {
      ("readonly" | "-readonly").? ^^ {
        case Some("readonly")  => ReadonlyModifier.Yes
        case Some("-readonly") => ReadonlyModifier.No
        case _                 => ReadonlyModifier.Noop
      }
    }

    comments ~ protectionLevel ~ readonly ~ ("[" ~> tsIdent <~ "in") ~! (tsType <~ "]") ~ opt ~ typeAnnotation ^^ TsMemberTypeMapped
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
      comments ~ "readonly".isDefined ~ (protectionLevel <~ "readonly".isDefined) ~ indexing ~ "?".isDefined ~ indexedType.? ^^ {
        case cs ~ readOnly ~ level ~ indexing ~ isOptional ~ valueType =>
          TsMemberIndex(cs, readOnly, level, indexing, valueType.map(OptionalType.maybe(_, isOptional)))
      }

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

  lazy val identifierOrDefault: Parser[TsIdentSimple] =
    identifierName.? ^^ (oi => TsIdent(oi.getOrElse("default")))

  lazy val qualifiedIdent: Parser[TsQIdent] = {
    val normal = rep1sep_(tsIdent, ".") ^^ TsQIdent.apply
    val withImport = tsIdentImport ~ rep_("." ~> tsIdent) ^^ {
      case i ~ rest => TsQIdent(i +: rest)
    }
    withImport | normal
  }

  lazy val tsLiteralString: Parser[TsLiteralString] =
    stringLit ^^ TsLiteralString.apply

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
      TsTypeRef(NoComments, TsQIdent.Array, IArray(elem))

    def unapply(typeRef: TsTypeRef): Option[TsType] =
      typeRef match {
        case TsTypeRef(NoComments, TsQIdent.Array, IArray.exactlyOne(elem))         => Some(elem)
        case TsTypeRef(NoComments, TsQIdent.ReadonlyArray, IArray.exactlyOne(elem)) => Some(elem)
        case _                                                                      => None
      }
  }
}
