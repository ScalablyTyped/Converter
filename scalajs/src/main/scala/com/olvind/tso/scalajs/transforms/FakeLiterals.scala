package com.olvind.tso
package scalajs
package transforms

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

object FakeLiterals {
  def apply(scope: TreeScope)(s: ContainerTree): ContainerTree = LiteralRewriter(s, scope).output

  /* hack: I needed some out of band communication that a TypeRef is actually to a fake literal type. We use reference equality */
  val LiteralTokenComment: Comments = new Comments(Nil)

  private case class LiteralRewriter(_s: ContainerTree, scope: TreeScope) extends TreeTransformation {
    val StringModuleName  = Name(_s.name.unescaped + "Strings")
    val collectedStrings  = mutable.HashMap.empty[String, Name]
    val NumbersModuleName = Name(_s.name.unescaped + "Numbers")
    val collectedNumbers  = mutable.HashMap.empty[String, Name]

    def module(collected: mutable.HashMap[String, Name], moduleName: Name): Option[ModuleTree] =
      if (collected.isEmpty) None
      else {
        val members =
          collected.flatMap {
            case (underlying: String, name) =>
              val codePath = _s.codePath + moduleName + name
              val `trait` =
                ClassTree(
                  Seq(Annotation.JsNative),
                  name,
                  Nil,
                  Nil,
                  Nil,
                  Nil,
                  ClassType.Trait,
                  isSealed = true,
                  NoComments,
                  codePath,
                )

              val `def` =
                MethodTree(
                  Annotation.jsName(name) :+ Annotation.Inline,
                  ProtectionLevel.Default,
                  name,
                  Nil,
                  Nil,
                  MemberImpl.Custom(s"$underlying.asInstanceOf[${name.value}]"),
                  TypeRef(QualifiedName(name :: Nil), Nil, NoComments),
                  isOverride = false,
                  comments   = NoComments,
                  codePath,
                )
              Seq(`trait`, `def`)
          }

        Some(ModuleTree(Nil, moduleName, Nil, members.to[Seq], NoComments, _s.codePath + moduleName))
      }

    override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
      s match {
        case TypeRef.Literal(underlying) if underlying.charAt(0) === '"' =>
          val name = Name(prettyString.nameFor(stringUtils.unquote(underlying)))
          collectedStrings(underlying) = name
          TypeRef(QualifiedName(List(ScalaConfig.outputPkg, _s.name, StringModuleName, name)), Nil, LiteralTokenComment)

        case TypeRef.Literal(underlying) =>
          val (newUnderlying, name) =
            (prettyString.nameFor(underlying), isTooBigForInt(underlying)) match {
              case (baseName, true) =>
                (underlying + ".0", Name("_" + baseName))
              case (baseName, _) => (underlying, Name(baseName))
            }

          collectedNumbers(newUnderlying) = name
          TypeRef(
            QualifiedName(List(ScalaConfig.outputPkg, _s.name, NumbersModuleName, name)),
            Nil,
            LiteralTokenComment,
          )
        case other =>
          other
      }

    lazy val output: ContainerTree = {
      val ss         = visitContainerTree(scope)(_s)
      val nums       = module(collectedNumbers, NumbersModuleName)
      val strings    = module(collectedStrings, StringModuleName)
      val newMembers = ss.members ++ nums ++ strings
      ss match {
        case p: PackageTree => p.copy(members = newMembers)
        case m: ModuleTree  => m.copy(members = newMembers)
      }
    }
  }

  def isTooBigForInt(strNum: String) = Try(java.lang.Long.decode(strNum)) match {
    case Failure(_)     => false
    case Success(value) => value > Int.MaxValue
  }
}
