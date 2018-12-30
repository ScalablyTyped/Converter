package com.olvind.tso
package ts

object TsTypeFormatter {
  def qident(q: TsQIdent): String =
    q.parts.map(_.value).mkString(".")

  def sig(sig: TsFunSig): String =
    List[Option[String]](
      Some(tparams(sig.tparams)(tparam)),
      Some(sig.params.map(param).mkString("(", ", ", ")")),
      sig.resultType.map(apply).map(": " + _)
    ).mkString("")

  def tparam(tparam: TsTypeParam): String =
    tparam match {
      case TsTypeParam(_, name, bound, default) =>
        List[Option[String]](
          Some(name.value),
          bound.map(b   => s"extends ${apply(b)}"),
          default.map(d => s"= " + apply(d))
        ).flatten.mkString(" ")
    }

  def param(p: TsFunParam): String =
    p match {
      case TsFunParam(_, name, tpe, isOptional) =>
        List[Option[String]](
          Some(name.value),
          Some(if (isOptional) "?" else ""),
          tpe.map(x => s": ${apply(x)}"),
        ).flatten.mkString(" ")
    }

  def tparams[T](ts: Seq[T])(f: T => String): String =
    if (ts.isEmpty) "" else "<" + ts.map(f).mkString(", ") + ">"

  def level(l: ProtectionLevel): String =
    l match {
      case Default   => ""
      case Private   => "private"
      case Protected => "protected"
    }

  def member(m: TsMember): String = m match {
    case TsMemberCall(_, l, s) =>
      s"${level(l)} ${sig(s)}"
    case TsMemberCtor(_, _, s) =>
      s"new ${sig(s)}"
    case TsMemberFunction(_, l, name, s, isStatic, isReadOnly, isOptional) =>
      List[String](
        level(l),
        if (isStatic) "static" else "",
        if (isReadOnly) "readonly" else "",
        name.value,
        if (isOptional) "?" else "",
        sig(s)
      ).mkString(" ")

    case TsMemberProperty(_, l, name, tpe, literal, isStatic, isReadOnly, isOptional) =>
      List[Option[String]](
        Some(level(l)),
        Some(if (isStatic) "static" else ""),
        Some(if (isReadOnly) "readonly" else ""),
        Some(name.value),
        Some(if (isOptional) "?" else ""),
        tpe.map(apply).map(":" + _),
        literal.map(l => "= " + lit(l))
      ).flatten.mkString(" ")

    // lazy
    case TsMemberIndex(_, isReadOnly, l, indexing, isOptional, valueType) =>
      "indexed"
    case TsMemberTypeMapped(_, l, isReadOnly, key, from, optionalize, to) =>
      "typemapped"
  }

  def lit(lit: TsLiteral): String = lit match {
    case TsLiteralString(str)   => s"'$str'"
    case TsLiteralBoolean(bool) => bool.toString
    case TsLiteralNumber(num)   => num
  }

  def apply(tpe: TsType): String =
    tpe match {
      case TsTypeRef(_, name, ts)                   => qident(name) + tparams(ts)(apply)
      case TsTypeLiteral(l)                         => lit(l)
      case TsTypeObject(members)                    => s"{${members.map(member).mkString(", ")}}"
      case TsTypeFunction(s)                        => s"${sig(s)}"
      case TsTypeConstructor(f)                     => s"new ${apply(f)}"
      case TsTypeIs(ident, x)                       => s"${ident.value} is ${apply(x)}"
      case TsTypeTuple(tparams)                     => s"[${tparams.map(apply).mkString(", ")}]"
      case TsTypeQuery(expr)                        => s"typeof ${qident(expr)}"
      case TsTypeRepeated(underlying)               => s"...${apply(underlying)}"
      case TsTypeKeyOf(key)                         => s"keyof ${apply(key)}"
      case TsTypeLookup(from, key)                  => s"${apply(from)}[${apply(key)}]"
      case TsTypeThis()                             => "this"
      case TsTypeUnion(types)                       => types map apply mkString " | "
      case TsTypeIntersect(types)                   => types map apply mkString " & "
      case TsTypeConditional(pred, ifTrue, ifFalse) => s"${apply(pred)} ? ${apply(ifTrue)} : ${apply(ifFalse)}"
      case TsTypeExtends(one, two)                  => s"${apply(one)} extends ${apply(two)}"
      case TsTypeInfer(tparam)                      => s"infer ${tparam.name.value}"
    }
}
