package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.collection.mutable
import scala.util.{Success, Try}

object FakeLiterals {
  /* hack: I needed some out of band communication that a TypeRef is actually to a fake literal type. We use reference equality */
  case class WasLiteral(lit: ExprTree.Lit) extends Comment.Data

  def apply(outputPkg: Name, scope: TreeScope, illegalNames: CleanIllegalNames)(tree: ContainerTree): ContainerTree =
    LiteralRewriter(outputPkg, illegalNames, tree, scope).output

  private case class LiteralRewriter(
      outputPkg:    Name,
      illegalNames: CleanIllegalNames,
      tree:         ContainerTree,
      scope:        TreeScope,
  ) extends TreeTransformation {

    val stringsByLowercase: Map[String, IArray[String]] =
      TreeTraverse
        .collect(tree) {
          case TypeRef.StringLiteral(underlying) => cleanName(underlying)
        }
        .groupBy(_.toLowerCase)
        .mapValues(_.distinct.sorted)

    def calculateName(underlying: String): Name = {
      val cleaned = cleanName(underlying)
      val n       = stringsByLowercase(cleaned.toLowerCase).indexWhere(_ === underlying)
      val suffix  = "_" * n
      Name(cleaned + suffix)
    }

    def cleanName(str: String): String =
      str match {
        case illegal if illegalNames.Illegal(Name(illegal)) => illegal + "_"
        case fine                                           => Name.necessaryRewrite(fine).getOrElse(fine)
      }

    val StringModuleName   = Name(tree.name.unescaped + "Strings")
    val collectedStrings   = mutable.HashMap.empty[ExprTree.Lit, Name]
    val NumbersModuleName  = Name(tree.name.unescaped + "Numbers")
    val collectedNumbers   = mutable.HashMap.empty[ExprTree.Lit, Name]
    val BooleansModuleName = Name(tree.name.unescaped + "Booleans")
    val collectedBooleans  = mutable.HashMap.empty[ExprTree.Lit, Name]

    def module(collected: mutable.HashMap[ExprTree.Lit, Name], moduleName: Name): Option[ModuleTree] =
      if (collected.isEmpty) None
      else {
        val members =
          collected.flatMap {
            case (underlying: ExprTree.Lit, name) =>
              val codePath = tree.codePath + moduleName + name
              val `trait` =
                ClassTree(
                  isImplicit = false,
                  IArray(Annotation.JsNative),
                  name,
                  Empty,
                  Empty,
                  Empty,
                  Empty,
                  ClassType.Trait,
                  isSealed = true,
                  NoComments,
                  codePath,
                )

              val `def` =
                MethodTree(
                  IArray(Annotation.Inline),
                  ProtectionLevel.Default,
                  name,
                  Empty,
                  Empty,
                  ExprTree.Cast(underlying, TypeRef(name)),
                  TypeRef(QualifiedName(IArray(name)), Empty, NoComments),
                  isOverride = false,
                  comments   = NoComments,
                  codePath,
                  isImplicit = false,
                )
              List(`trait`, `def`)
          }

        Some(
          ModuleTree(
            Empty,
            moduleName,
            Empty,
            IArray.fromTraversable(members),
            NoComments,
            tree.codePath + moduleName,
            isOverride = false,
          ),
        )
      }

    override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
      s match {
        case TypeRef.StringLiteral(underlying) =>
          val name = calculateName(underlying)
          val lit  = ExprTree.StringLit(underlying)
          collectedStrings(lit) = name
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, StringModuleName, name)),
            Empty,
            Comments(CommentData(WasLiteral(lit))),
          )

        case TypeRef.BooleanLiteral(underlying) =>
          val name = Name(underlying)
          val lit  = ExprTree.BooleanLit(underlying.toBoolean)
          collectedBooleans(lit) = name
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, BooleansModuleName, name)),
            Empty,
            Comments(CommentData(WasLiteral(lit))),
          )

        case TypeRef.NumberLiteral(underlying) =>
          val (newUnderlying, name) =
            (underlying, isTooBigForInt(underlying)) match {
              case (baseName, Some(long)) =>
                (long.toString + ".0", Name("_" + baseName))
              case (baseName, _) => (underlying, Name(baseName))
            }

          val lit = ExprTree.NumberLit(newUnderlying)
          collectedNumbers(lit) = name
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, NumbersModuleName, name)),
            Empty,
            Comments(CommentData(WasLiteral(lit))),
          )

        case other =>
          other
      }

    lazy val output: ContainerTree = {
      val ss         = visitContainerTree(scope)(tree)
      val nums       = module(collectedNumbers, NumbersModuleName)
      val strings    = module(collectedStrings, StringModuleName)
      val booleans   = module(collectedBooleans, BooleansModuleName)
      val newMembers = ss.members ++ IArray.fromOptions(nums, strings, booleans)
      ss match {
        case p: PackageTree => p.copy(members = newMembers)
        case m: ModuleTree  => m.copy(members = newMembers)
      }
    }
  }

  def isTooBigForInt(strNum: String): Option[Long] =
    Try(java.lang.Long.decode(strNum)) match {
      case Success(value) if value > Int.MaxValue || value < Int.MinValue => Some(value)
      case _                                                              => None
    }

}
