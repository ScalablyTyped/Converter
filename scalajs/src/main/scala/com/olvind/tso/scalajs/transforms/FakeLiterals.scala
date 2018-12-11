package com.olvind.tso
package scalajs
package transforms

import scala.collection.mutable

object FakeLiterals {
  /* hack: I needed some out of band communication that a TypeRef is actually to a fake literal type. We use reference equality */
  val LiteralTokenComment: Comments = new Comments(Nil)

  private case class LiteralRewriter(_s: ContainerSymbol, scope: SymbolScope) extends SymbolTransformation {
    val StringModuleName  = Name(_s.name.unescaped + "Strings")
    val collectedStrings  = mutable.HashSet.empty[String]
    val NumbersModuleName = Name(_s.name.unescaped + "Numbers")
    val collectedNumbers  = mutable.HashSet.empty[String]

    @deprecated("find a... less ad hoc approach here", "")
    def nameFor(underlying: String): Name = {
      val base =
        stringUtils unquote underlying flatMap {
          case '.'   => "DOT"
          case '`'   => "BACKTICK"
          case '\\'  => "BACKSLASH"
          case '$'   => "DOLLAR"
          case other => other.toString
        }

      val str = base match {
        case "_"       => "Underscore"
        case ""        => "Empty"
        case "package" => "PACKAGE"
        case "js"      => "JS"
        case other     => other
      }

      Name(str)
    }

    def module(collected: mutable.Set[String], moduleName: Name): Option[ModuleSymbol] =
      collected match {
        case empty if empty.isEmpty => None
        case found =>
          val members =
            found flatMap { underlying: String =>
              val name = nameFor(underlying)
              val `trait` =
                ClassSymbol(Seq(JsNative), name, Nil, Nil, Nil, Nil, ClassType.Trait, isSealed = true, NoComments)
              val impl = s"$underlying.asInstanceOf[${name.value}]"
              val `def` =
                MethodSymbol(
                  Annotation.jsName(name),
                  Default,
                  name,
                  Nil,
                  Nil,
                  MemberImplCustom(impl),
                  TypeRef(QualifiedName(name :: Nil), Nil, NoComments),
                  isOverride = false,
                  comments   = NoComments
                )
              Seq(`trait`, `def`)
            }

          Some(ModuleSymbol(Nil, moduleName, ModuleTypeScala, Nil, members.to[Seq], NoComments))
      }

    override def enterTypeRef(scope: SymbolScope)(s: TypeRef): TypeRef =
      s match {
        case TypeRef.Literal(underlying) if underlying.charAt(0) === '"' =>
          collectedStrings += underlying
          TypeRef(QualifiedName(List(_s.name, StringModuleName, nameFor(underlying))), Nil, LiteralTokenComment)

        case TypeRef.Literal(underlying) =>
          collectedNumbers += underlying
          TypeRef(QualifiedName(List(_s.name, NumbersModuleName, nameFor(underlying))), Nil, LiteralTokenComment)
        case other =>
          other
      }

    lazy val output: ContainerSymbol = {
      val ss         = visitContainerSymbol(scope)(_s)
      val nums       = module(collectedNumbers, NumbersModuleName)
      val strings    = module(collectedStrings, StringModuleName)
      val newMembers = ss.members ++ nums ++ strings
      ss match {
        case p: PackageSymbol => p.copy(members = newMembers)
        case m: ModuleSymbol  => m.copy(members = newMembers)
        case c: ClassSymbol   => c //todo: enforce with types that this is impossible
      }
    }
  }

  def apply(scope: SymbolScope)(s: ContainerSymbol): ContainerSymbol = LiteralRewriter(s, scope).output
}
