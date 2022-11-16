package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.collection.mutable
import scala.util.{Success, Try}

object FakeLiterals {
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
        .map { case (k, v) => (k, v.distinct.sorted) }

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
    val collectedStrings   = mutable.HashMap.empty[Name, ExprTree.Lit]
    val DoublesModuleName  = Name(tree.name.unescaped + "Doubles")
    val collectedDoubles   = mutable.HashMap.empty[Name, ExprTree.Lit]
    val IntsModuleName     = Name(tree.name.unescaped + "Ints")
    val collectedInts      = mutable.HashMap.empty[Name, ExprTree.Lit]
    val BooleansModuleName = Name(tree.name.unescaped + "Booleans")
    val collectedBooleans  = mutable.HashMap.empty[Name, ExprTree.Lit]

    def module(collected: mutable.HashMap[Name, ExprTree.Lit], moduleName: Name): Option[ModuleTree] =
      if (collected.isEmpty) None
      else {
        val members =
          collected.zipWithIndex.flatMap {
            case ((name, underlying: ExprTree.Lit), idx) =>
              val codePath = tree.codePath + moduleName + name
              val `trait` =
                ClassTree(
                  isImplicit = false,
                  IArray(Annotation.JsNative),
                  ProtectionLevel.Public,
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

              def `def` =
                MethodTree(
                  IArray(Annotation.Inline),
                  ProtectionLevel.Public,
                  name,
                  Empty,
                  Empty,
                  ExprTree.AsInstanceOf(underlying, TypeRef(name)),
                  TypeRef(QualifiedName(IArray(name)), Empty, NoComments),
                  isOverride = false,
                  comments   = NoComments,
                  codePath,
                  isImplicit = false,
                )

              // for instance @expo/vector-icons has 11500 different literal strings,
              // and it causes: Class too large: typings/expoVectorIcons/expoVectorIconsStrings
              if (idx <= 10000) List(`trait`, `def`) else List(`trait`)
          }

        Some(
          ModuleTree(
            Empty,
            ProtectionLevel.Public,
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
          collectedStrings(name) = lit
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, StringModuleName, name)),
            Empty,
            Comments(Marker.WasLiteral(lit)),
          )

        case TypeRef.BooleanLiteral(underlying) =>
          val name = Name(underlying)
          val lit  = ExprTree.BooleanLit(underlying.toBoolean)
          collectedBooleans(name) = lit
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, BooleansModuleName, name)),
            Empty,
            Comments(Marker.WasLiteral(lit)),
          )

        case TypeRef.DoubleLiteral(underlying) =>
          val name = Name(underlying)
          val lit  = ExprTree.DoubleLit(underlying)
          collectedDoubles(name) = lit
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, DoublesModuleName, name)),
            Empty,
            Comments(Marker.WasLiteral(lit)),
          )

        case TypeRef.IntLiteral(underlying) =>
          val name = Name(underlying)
          val lit  = ExprTree.IntLit(underlying)
          collectedInts(name) = lit
          TypeRef(
            QualifiedName(IArray(outputPkg, tree.name, IntsModuleName, name)),
            Empty,
            Comments(Marker.WasLiteral(lit)),
          )

        case other =>
          other
      }

    lazy val output: ContainerTree = {
      val ss         = visitContainerTree(scope)(tree)
      val doubles    = module(collectedDoubles, DoublesModuleName)
      val ints       = module(collectedInts, IntsModuleName)
      val strings    = module(collectedStrings, StringModuleName)
      val booleans   = module(collectedBooleans, BooleansModuleName)
      val newMembers = ss.members ++ IArray.fromOptions(doubles, ints, strings, booleans)
      ss match {
        case p: PackageTree => p.copy(members = newMembers)
        case m: ModuleTree  => m.copy(members = newMembers)
      }
    }
  }
}
