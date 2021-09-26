package org.scalablytyped.converter.internal
package scalajs

import io.circe013.{Decoder, Encoder}

final case class Name(unescaped: String) {
  def withSuffix[T: ToSuffix](t: T): Name =
    new Name(unescaped + "_" + ToSuffix(t).unescaped)

  def value: String =
    ScalaNameEscape(unescaped)

  def isEscaped: Boolean =
    value =/= unescaped
}

object Name {
  implicit val encodes: Encoder[Name] = Encoder[String].contramap(_.unescaped)
  implicit val decodes: Decoder[Name] = Decoder[String].map(Name.apply)

  val mod:        Name = Name("mod")
  val std:        Name = Name("std")
  val typings:    Name = Name("typings")
  val global:     Name = Name("global")
  val dummy:      Name = Name("dummy")
  val Any:        Name = Name("Any")
  val AnyRef:     Name = Name("AnyRef")
  val AnyVal:     Name = Name("AnyVal")
  val Double:     Name = Name("Double")
  val Short:      Name = Name("Short")
  val Byte:       Name = Name("Byte")
  val Float:      Name = Name("Float")
  val Int:        Name = Name("Int")
  val Long:       Name = Name("Long")
  val Boolean:    Name = Name("Boolean")
  val Unit:       Name = Name("Unit")
  val Null:       Name = Name("Null")
  val Nothing:    Name = Name("Nothing")
  val String:     Name = Name("String")
  val Array:      Name = Name("Array")
  val update:     Name = Name("update")
  val value:      Name = Name("value")
  val scala:      Name = Name("scala")
  val scalajs:    Name = Name("scalajs")
  val js:         Name = Name("js")
  val java:       Name = Name("java")
  val lang:       Name = Name("lang")
  val Statics:    Name = Name("Statics")
  val `package`:  Name = Name("package")
  val Object:     Name = Name("Object")
  val Function:   Name = Name("Function")
  val Default:    Name = Name("default")
  val Symbol:     Name = Name("Symbol")
  val This:       Name = Name("This")
  val UndefOr:    Name = Name("UndefOr")
  val Dynamic:    Name = Name("Dynamic")
  val namespaced: Name = Name("^")
  val underscore: Name = Name("_")
  val org:        Name = Name("org")
  val com:        Name = Name("com")

  val APPLY:           Name = Name("<apply>")
  val CONSTRUCTOR:     Name = Name("<init>")
  val UNION:           Name = Name("<union>")
  val INTERSECTION:    Name = Name("<intersection>")
  val SINGLETON:       Name = Name("<typeof>")
  val STRING_LITERAL:  Name = Name("<string_literal>")
  val DOUBLE_LITERAL:  Name = Name("<double_literal>")
  val INT_LITERAL:     Name = Name("<int_literal>")
  val BOOLEAN_LITERAL: Name = Name("<boolean_literal>")
  val THIS:            Name = Name("<this>")
  val SUPER:           Name = Name("<super>")
  val WILDCARD:        Name = Name("<wildcard>")
  val UNDEFINED:       Name = Name("<undefined>")
  val REPEATED:        Name = Name("*")

  def FunctionArity(isThis: Boolean, arity: Int): Name =
    Name((if (isThis) This.unescaped else "") + "Function" + arity.toString)

  val Internal = Set(
    UNION,
    INTERSECTION,
    SINGLETON,
    STRING_LITERAL,
    DOUBLE_LITERAL,
    INT_LITERAL,
    BOOLEAN_LITERAL,
    THIS,
    SUPER,
    WILDCARD,
    REPEATED,
    APPLY,
    UNDEFINED,
  )

  implicit val NameSuffix: ToSuffix[Name] = {
    case UNION           => Suffix("Union")
    case INTERSECTION    => Suffix("Intersection")
    case SINGLETON       => Suffix("Singleton")
    case BOOLEAN_LITERAL => Suffix("Boolean")
    case DOUBLE_LITERAL  => Suffix("Double")
    case INT_LITERAL     => Suffix("Int")
    case STRING_LITERAL  => Suffix("String")
    case THIS            => Suffix("This")
    case WILDCARD        => Suffix("Wildcard")
    case REPEATED        => Suffix("Repeated")
    case APPLY           => Suffix("Apply")
    case other           => Suffix(other.unescaped)
  }

  implicit val OrderedName: Ordering[Name] = Ordering[String].on[Name](_.unescaped)

  def necessaryRewrite(name: Name): Name =
    necessaryRewrite(name.unescaped) match {
      case Some(rewritten) => Name(rewritten)
      case None            => name
    }

  /**
    * All names must pass through here, especially including the ones from arbitrary javascript strings.
    *
    * For performance reasons it's not done in the constructor or anything like that
    */
  def necessaryRewrite(ident: String): Option[String] =
    ident match {
      case "<apply>"  => None
      case "<global>" => None
      case "^"        => None
      case ident =>
        def unicodeName(c: Char): String =
          Character
            .getName(c.toInt)
            .takeWhile(_ =/= '(')
            .filter(_.isLetterOrDigit)
            .toLowerCase
            .capitalize

        val patchedChars =
          ident.flatMap {
            // we keep these, and only rewrite it for packages and modules, where it will be very visible
            case '-' => "-"
            case '@' => "@"
            case '^' => "^"
            case '[' => "["
            case ']' => "]"
            /* Zinc fails with two dollar signs in a name, while we want to keep for instance the JQuery `$` */
            case '$' => if (ident.count(_ === '$') > 1) "Dollar" else "$"
            /* override names from unicode */
            case '.'                                            => "Dot"
            case '\\'                                           => "Backslash"
            case '/'                                            => "Slash"
            case '\u0000'                                       => "Null"
            case ' '                                            => " "
            case c if !c.isUnicodeIdentifierPart || c.isControl => unicodeName(c)
            case c                                              => c.toString
          }

        /* can't have heading spaces, but inside the name we can escape them */
        val fixedSpaces: String = {
          val initialSpaces = patchedChars.takeWhile(_.isSpaceChar)
          "Space" * initialSpaces.length + patchedChars.drop(initialSpaces.length)
        }

        /* No kidding, instagram-private-api broke scalac with a stack overflow in the parser */
        val notTooLong = if (fixedSpaces.length > 500) fixedSpaces.take(500) else fixedSpaces

        val legal = notTooLong match {
          case ""        => "_empty" // must have a name
          case "-"       => "_dash" // `def `-`(d: Double) = d; `-`(d) doesn't do what you would think
          case "_"       => "_underscore" // can't import a top level member with this name
          case "package" => "_package" // does't work
          case i         => i
        }

        if (legal === ident) None else Some(legal)
    }
}
