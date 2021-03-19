package org.scalablytyped.converter.internal
package ts

object TsTypeFormatter extends TsTypeFormatter(true)

class TsTypeFormatter(val keepComments: Boolean) {
  def dropComments = new TsTypeFormatter(false)

  def qident(q: TsQIdent): String =
    q.parts.map(_.value).mkString(".")

  def sig(sig: TsFunSig): String =
    List[Option[String]](
      tparams(sig.tparams)(tparam),
      Some(sig.params.map(param).mkString("(", ", ", ")")),
      sig.resultType.map(apply).map(": " + _),
    ).flatten.mkString("")

  def tparam(tparam: TsTypeParam): String =
    tparam match {
      case TsTypeParam(_, name, bound, default) =>
        List[Option[String]](
          Some(name.value),
          bound.map(b   => s"extends ${apply(b)}"),
          default.map(d => s"= " + apply(d)),
        ).flatten.mkString(" ")
    }

  def param(p: TsFunParam): String =
    p match {
      case TsFunParam(_, name, tpe) =>
        List[Option[String]](Some(name.value), tpe.map(x => s": ${apply(x)}")).flatten.mkString(" ")
    }

  def tparams[T <: AnyRef](ts: IArray[T])(f: T => String): Option[String] =
    if (ts.isEmpty) None else Some("<" + ts.map(f).mkString(", ") + ">")

  def level(l: ProtectionLevel): Option[String] =
    l match {
      case ProtectionLevel.Default   => None
      case ProtectionLevel.Private   => Some("private")
      case ProtectionLevel.Protected => Some("protected")
    }

  def member(m: TsMember): String = m match {
    case TsMemberCall(_, l, s) =>
      s"${level(l)} ${sig(s)}"
    case TsMemberCtor(_, _, s) =>
      s"new ${sig(s)}"
    case TsMemberFunction(_, l, name, methodType, s, isStatic, isReadOnly) =>
      List[Option[String]](
        level(l),
        methodType match {
          case MethodType.Normal => None
          case MethodType.Getter => Some("get")
          case MethodType.Setter => Some("set")
        },
        if (isStatic) Some("static") else None,
        if (isReadOnly) Some("readonly") else None,
        Some(name.value),
        Some(sig(s)),
      ).flatten.mkString(" ")

    case TsMemberProperty(_, l, name, tpe, expr, isStatic, isReadOnly) =>
      List[Option[String]](
        level(l),
        Some(if (isStatic) "static" else ""),
        Some(if (isReadOnly) "readonly" else ""),
        Some(name.value),
        tpe.map(apply).map(":" + _),
        expr.map(l => "= " + TsExpr.format(l)),
      ).flatten.mkString(" ")

    // lazy
    case TsMemberIndex(_, isReadOnly, l, indexing, valueType) =>
      List[Option[String]](
        if (isReadOnly) Some("readonly") else None,
        level(l),
        Some(indexing match {
          case IndexingDict(name, tpe) => s"[${name.value}: ${apply(tpe)}]"
          case IndexingSingle(name)    => s"[${qident(name)}]"
        }),
        valueType.map(tpe => s": ${apply(tpe)}"),
      ).flatten.mkString(" ").replaceAllLiterally(" ?", "?")

    case TsMemberTypeMapped(_, l, readonly, key, from, optionalize, to) =>
      List[Option[String]](
        level(l),
        readonly match {
          case ReadonlyModifier.Noop => None
          case ReadonlyModifier.Yes  => Some("readonly")
          case ReadonlyModifier.No   => Some("-readonly")
        },
        Some("["),
        Some(key.value),
        Some("in"),
        Some(apply(from)),
        Some("]:"),
        optionalize match {
          case OptionalModifier.Noop          => None
          case OptionalModifier.Optionalize   => Some("?")
          case OptionalModifier.Deoptionalize => Some("-?")
        },
        Some(apply(to)),
      ).flatten
        .mkString(" ")
        .replaceAllLiterally(" ?", "?")
  }

  def lit(lit: TsLiteral): String = lit match {
    case TsLiteralString(str)   => s"'$str'"
    case TsLiteralBoolean(bool) => bool.toString
    case TsLiteralNumber(num)   => num
  }

  def tupleElement(elem: TsTupleElement): String = {
    val label = elem.label.map(_.value + ": ").getOrElse("")
    label + apply(elem.tpe)
  }

  def apply(tpe: TsType): String =
    tpe match {
      case TsTypeRef(cs, name, ts) =>
        Comments.format(cs, keepComments) + qident(name) + tparams(ts)(apply).getOrElse("")
      case TsTypeLiteral(l)                         => lit(l)
      case TsTypeObject(cs, members)                => Comments.format(cs, keepComments) + s"{${members.map(member).mkString(", ")}}"
      case TsTypeFunction(s)                        => s"${sig(s)}"
      case TsTypeConstructor(f)                     => s"new ${apply(f)}"
      case TsTypeIs(ident, x)                       => s"${ident.value} is ${apply(x)}"
      case TsTypeTuple(elems)                       => s"[${elems.map(tupleElement).mkString(", ")}]"
      case TsTypeQuery(expr)                        => s"typeof ${qident(expr)}"
      case TsTypeRepeated(underlying)               => s"...${apply(underlying)}"
      case TsTypeKeyOf(key)                         => s"keyof ${apply(key)}"
      case TsTypeLookup(from, key)                  => s"${apply(from)}[${apply(key)}]"
      case TsTypeThis()                             => "this"
      case TsTypeAsserts(ident, isOpt)              => "asserts " + ident.value + isOpt.fold("")("is " + _)
      case TsTypeUnion(types)                       => types.map(apply).mkString(" | ")
      case TsTypeIntersect(types)                   => types.map(apply).mkString(" & ")
      case TsTypeConditional(pred, ifTrue, ifFalse) => s"${apply(pred)} ? ${apply(ifTrue)} : ${apply(ifFalse)}"
      case TsTypeExtends(one, two)                  => s"${apply(one)} extends ${apply(two)}"
      case TsTypeInfer(tparam)                      => s"infer ${tparam.name.value}"
    }
}
