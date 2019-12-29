package com.olvind.tso
package scalajs

import java.io._

import com.olvind.tso.scalajs.transforms.ShortenNames
import com.olvind.tso.stringUtils.quote

import scala.collection.mutable

object Printer {

  private class Registry() {

    private val fs = mutable.Map.empty[os.RelPath, Array[Byte]]

    def write(file: os.RelPath)(f: PrintWriter => Unit): Unit = {
      val w  = new StringWriter()
      val pw = new PrintWriter(w)

      try {
        f(pw)
        fs(file) = w.toString.getBytes(constants.Utf8)
      } finally {
        pw.close()
      }
    }

    def result: Map[os.RelPath, Array[Byte]] =
      fs.toMap
  }

  def apply(scope: TreeScope, tree: ContainerTree): Map[os.RelPath, Array[Byte]] = {
    val reg = new Registry()

    apply(
      _scope       = scope,
      reg          = reg,
      packages     = List(tree.name),
      targetFolder = os.RelPath(tree.name.value),
      tree         = tree,
    )

    reg.result
  }

  val Imports: String =
    """|import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |import scala.scalajs.js.annotation._""".stripMargin

  def apply(
      _scope:       TreeScope,
      reg:          Registry,
      packages:     List[Name],
      targetFolder: os.RelPath,
      tree:         ContainerTree,
  ): Unit = {
    val files: Map[ScalaOutput, Seq[Tree]] = tree match {
      case _: PackageTree => tree.members groupBy ScalaOutput.outputAs
      case other => Map(ScalaOutput.File(other.name) -> Seq(other))
    }
    val scope = _scope / tree

    files foreach {
      case (ScalaOutput.File(name), members: Seq[Tree]) =>
        reg.write(targetFolder / os.RelPath(s"${name.unescaped}.scala")) { writer =>
          val (imports, shortenedMembers) = ShortenNames(tree, scope)(members)
          writer println s"package ${formatQN(QualifiedName(packages))}"
          writer.println("")
          imports.foreach(i => writer.println(s"import ${formatQN(i.imported)}"))
          writer.println(Imports)
          writer.println("")
          shortenedMembers foreach printTree(scope, reg, Indenter(writer), packages, targetFolder, 0)
        }

      case (ScalaOutput.Package(name), pkgs) =>
        pkgs foreach {
          case pkg: PackageTree =>
            apply(scope, reg, packages :+ name, targetFolder / os.RelPath(name.unescaped), pkg)
          case _ => sys.error("i was too lazy to prove this with types")
        }

      case (ScalaOutput.PackageObject, members) =>
        reg.write(targetFolder / "package.scala") { writer =>
          val (imports, shortenedMembers) = ShortenNames(tree, scope)(members)

          packages.dropRight(1) match {
            case Nil => ()
            case remaining =>
              writer println s"package ${formatQN(QualifiedName(remaining))}"
          }

          writer.println("")
          writer.println(Imports)
          writer.println("")
          writer.println("package object " + formatName(tree.name) + " {")
          imports.foreach(i => writer.println(s"  import ${formatQN(i.imported)}"))
          if (imports.nonEmpty)
            writer.println("")
          shortenedMembers foreach printTree(scope, reg, Indenter(writer), packages, targetFolder, 2)
          writer.println("}")
        }
    }
  }
  private final case class Indenter(a: Appendable) {
    private var hasIndented: Boolean = false

    private def doIndent(indent: Int): Unit = {
      a.append(" " * indent)
      hasIndented = true
    }

    def print(indent: Int)(original: String): Unit = {
      var idx = 0

      while (idx < original.length) {
        if (!hasIndented) {
          doIndent(indent)
        }

        a.append(original(idx))

        if (original(idx) === '\n') {
          hasIndented = false
        }

        idx += 1
      }
    }
  }

  def printTree(
      _scope:       TreeScope,
      reg:          Registry,
      w:            Indenter,
      packageNames: List[Name],
      folder:       os.RelPath,
      indent:       Int,
  )(
      tree: Tree,
  ): Unit = {
    val scope = _scope / tree

    val printSym: Tree => Unit =
      printTree(scope, reg, w, packageNames, folder, indent + 2)

    def print(ss: String*): Unit =
      ss foreach w.print(indent)

    def println(ss: String*): Unit = {
      print(ss: _*)
      print("\n")
    }

    tree match {
      case tree: PackageTree =>
        apply(scope, reg, packageNames :+ tree.name, folder / os.RelPath(tree.name.value), tree)

      case cls @ ClassTree(anns, name, tparams, parents, ctors, members, classType, isSealed, comments, _) =>
        print(Comments.format(comments))
        print(formatAnns(anns))

        val (defaultCtor, restCtors) = ctors.sortBy(_.params.size).toList match {
          case Nil                                                    => (CtorTree.defaultPublic, Nil)
          case head :: tail if (head.params.isEmpty || !cls.isNative) => (head, tail)
          case all                                                    => (CtorTree.defaultProtected, all)
        }

        print(Comments.format(defaultCtor.comments))
        print(if (isSealed) "sealed " else "", classType.asString, " ", formatName(name))

        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamTree(cls.isNative, indent) mkString ", ", "]")

        if (classType =/= ClassType.Trait) {
          print(" ")
          print(formatProtectionLevel(defaultCtor.level, isCtor = true))
          print(formatParams(indent + 2)(defaultCtor.params))
        }

        print(extendsClause(parents, isNative = cls.isNative, indent))

        if (members.nonEmpty || restCtors.nonEmpty) {
          println(" {")

          if (classType =/= ClassType.Trait)
            restCtors foreach printSym

          members foreach printSym
          println("}")
        } else
          println()

        println()

      case m @ ModuleTree(anns, name, parents, members, comments, _, isOverride) =>
        print(Comments.format(comments))
        print(formatAnns(anns))

        print(
          if (isOverride) "override " else "",
          "object ",
          formatName(name),
          extendsClause(parents, m.isNative, indent),
        )

        if (members.nonEmpty) {
          println(" {")

          members foreach printTree(scope, reg, w, packageNames, folder, indent + 2)
          println("}")
        } else
          println()
        println()

      case TypeAliasTree(name, tparams, alias, comments, _) =>
        print(Comments.format(comments))
        print("type ", formatName(name))
        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamTree(isNative = true, indent) mkString ", ", "]")

        println(s" = ", formatTypeRef(indent)(alias))

      case FieldTree(anns, name, tpe, impl, isReadOnly, isOverride, comments, _) =>
        print(Comments.format(comments))
        print(formatAnns(anns))

        print(
          "",
          if (isOverride) "override " else "",
          if (isReadOnly) "val" else "var",
          " ",
          typeAnnotation(formatName(name), indent, tpe, name),
        )

        impl match {
          case MemberImpl.NotImplemented => println()
          case MemberImpl.Undefined      => println(" = js.undefined")
          case MemberImpl.Native         => println(" = js.native")
          case MemberImpl.Custom(impl)   => println(" = ", impl)
        }

      case MethodTree(anns, level, name, tparams, params, impl, resultType, isOverride, comments, _) =>
        print(Comments.format(comments))
        print(formatAnns(anns))

        print(formatProtectionLevel(level, isCtor = false))
        print(s"${if (isOverride) "override " else ""}def ")

        val tparamString =
          if (tparams.isEmpty) ""
          else
            tparams.map(formatTypeParamTree(isNative = true, indent)).mkString("[", ", ", "]")

        var paramString = params.map(_.map(formatParamTree(indent)).mkString("(", ", ", ")"))
        if (paramString.map(_.length).sum > 100) {
          paramString = params.map(_.map(formatParamTree(indent)).mkString("(\n  ", ",\n  ", "\n)"))
        }

        print(
          typeAnnotation(formatName(name) + tparamString + paramString.mkString, indent, resultType, name),
        )
        impl match {
          case MemberImpl.NotImplemented => println()
          case MemberImpl.Native         => println(" = js.native")
          case MemberImpl.Undefined      => println(" = js.undefined")
          case MemberImpl.Custom(impl)   => println(" = ", impl)
        }

      case CtorTree(level, params, comments) =>
        print(Comments.format(comments))
        println(
          "",
          formatProtectionLevel(level, isCtor = true),
          "def this",
          formatParams(indent + 2)(params),
          " = this()",
        )

      case tree @ ParamTree(_, _, _, _, comments) =>
        print(Comments.format(comments))
        println(formatParamTree(indent)(tree))

      case tree @ TypeParamTree(_, _, comments) =>
        print(Comments.format(comments))
        print(formatTypeParamTree(isNative = true, indent)(tree))

      case tree @ TypeRef(_, _, comments) =>
        print(Comments.format(comments))
        print(formatTypeRef(indent)(tree))
    }
  }

  def formatParams(indent: Int)(ps: Seq[ParamTree]): String = {
    val base        = ps.map(formatParamTree(indent))
    var paramString = base.mkString("(", ", ", ")")
    if (paramString.length > 100 && ps.length > 1) {
      paramString = base.mkString("(\n  ", ",\n  ", "\n)")
    }
    paramString
  }

  def extendsClause(parents: Seq[TypeRef], isNative: Boolean, indent: Int): String =
    parents.toList.map(parent => formatTypeRef(indent + 6)(parent)) match {
      case Nil if isNative                    => " extends js.Object"
      case Nil                                => ""
      case head :: Nil if !head.contains(".") => " extends " + head
      case head :: Nil                        => "\n  extends " + head
      case head :: tail                       => "\n  extends " + head + tail.mkString("\n     with ", "\n     with ", "")
    }

  def formatTypeParamTree(isNative: Boolean, indent: Int)(tree: TypeParamTree): String =
    Comments.format(tree.comments) |+|
      formatName(tree.name) |+|
      (tree.upperBound match {
        case Some(bound) if isNative => " /* <: " |+| formatTypeRef(indent)(bound) |+| " */"
        case Some(bound)             => " <: " |+| formatTypeRef(indent)(bound)
        case None                    => ""
      })

  def formatParamTree(indent: Int)(tree: ParamTree): String =
    Seq(
      Comments.format(tree.comments),
      if (tree.isImplicit) "implicit " else "",
      typeAnnotation(formatName(tree.name), indent + 2, tree.tpe, Name.WILDCARD),
      tree.default.fold("")(d => s" = ${formatDefaultedTypeRef(indent)(d)}"),
    ).mkString

  def formatDefaultedTypeRef(indent: Int)(ref: TypeRef): String =
    ref match {
      case TypeRef.`null`    => "null"
      case TypeRef.undefined => "js.undefined"
      case other             => formatTypeRef(indent + 2)(other)
    }

  def formatQN(q: QualifiedName): String =
    q.parts match {
      case Name.scala :: Name.scalajs :: Name.js :: name :: Nil => "js." + formatName(name)
      case other                                                => other.map(formatName).mkString(".")
    }

  def formatName(name: Name): String = name match {
    case Name.APPLY => "apply"
    case other      => other.value
  }

  val StringOrdering: Ordering[String] = Ordering[String]

  def typeAnnotation(preceding: String, indent: Int, tpe: TypeRef, owner: Name): String = {
    /* for instance `val foo: Type_: Int` needs a space between `_` and `:` */
    val colon = if (preceding.last === '_' || preceding.last === '^') " : " else ": "

    preceding + colon + formatTypeRef(indent)(tpe)
  }

  def formatTypeRef(indent: Int)(t1: TypeRef): String = {
    val ret: String =
      t1 match {
        case TypeRef.ScalaFunction(paramTypes, retType) =>
          val params = paramTypes match {
            case Seq(one) => formatTypeRef(indent)(one)
            case many     => (many map formatTypeRef(indent)).mkString("(", ", ", ")")
          }
          s"$params => ${formatTypeRef(indent)(retType)}"

        case TypeRef.ThisType(_)           => "this.type"
        case TypeRef.Wildcard              => "_"
        case TypeRef.Singleton(underlying) => formatTypeRef(indent)(underlying) |+| ".type"

        case TypeRef.Intersection(types) =>
          /* ensure we have ran the logic in the apply method */
          TypeRef.Intersection(types) match {
            case TypeRef.Intersection(types) => types map formatTypeRef(indent) map paramsIfNeeded mkString " with "
            case other                       => formatTypeRef(indent)(other)
          }

        case TypeRef.UndefOr(tpe) =>
          formatTypeRef(indent)(TypeRef(QualifiedName.UndefOr, List(tpe), NoComments))

        case TypeRef.Union(types) =>
          types map formatTypeRef(indent) map paramsIfNeeded mkString " | "

        case TypeRef.StringLiteral(_) | TypeRef.NumberLiteral(_) | TypeRef.BooleanLiteral(_) =>
          sys.error("Should be rewritten")

        case TypeRef.Repeated(underlying: TypeRef, _) =>
          paramsIfNeeded(formatTypeRef(indent)(underlying)) |+| "*"

        case TypeRef(typeName, targs, _) =>
          val targsStr = targs match {
            case Nil => ""
            case nonEmpty =>
              val targStrs    = nonEmpty map formatTypeRef(indent + 2)
              val targsLength = targStrs.foldLeft(0)(_ + _.length)
              val sep         = if (targsLength > 80) "\n" + (" " * indent) else ""
              targStrs.mkString(s"[$sep", s", $sep", s"${sep.dropRight(2)}]")
          }

          formatQN(typeName) |+| targsStr
      }

    Comments.format(t1.comments) |+| ret
  }

  def paramsIfNeeded(s: String): String =
    if (s.exists(_.isWhitespace)) s"($s)"
    else if (s.last === '^') s"$s "
    else s

  def formatProtectionLevel(p: ProtectionLevel, isCtor: Boolean): String =
    p match {
      case ProtectionLevel.Default             => ""
      case ProtectionLevel.Private if isCtor   => "protected "
      case ProtectionLevel.Private             => "/* private */ "
      case ProtectionLevel.Protected if isCtor => "protected "
      case ProtectionLevel.Protected           => "/* protected */ "
    }

  def formatAnn(a: Annotation): String =
    a match {
      case Annotation.Inline =>
        "@scala.inline"
      case Annotation.JsBracketAccess =>
        "@JSBracketAccess"
      case Annotation.JsBracketCall =>
        "@JSBracketCall"
      case Annotation.JsNative =>
        "@js.native"
      case Annotation.JsName(name: Name) =>
        s"@JSName(${quote(name.unescaped)})"
      case Annotation.JsNameSymbol(name) =>
        s"@JSName(${formatQN(name)})"
      case Annotation.JsImport(module, imported) =>
        val importedString = imported match {
          case Imported.Namespace    => "JSImport.Namespace"
          case Imported.Default      => "JSImport.Default"
          case Imported.Named(names) => quote(names.map(_.unescaped).mkString("."))
        }
        s"@JSImport(${quote(module)}, $importedString)"
      case Annotation.ScalaJSDefined =>
        "" //"@ScalaJSDefined"
      case Annotation.JsGlobal(name: QualifiedName) =>
        s"@JSGlobal(${quote(name.parts.map(_.unescaped).mkString("."))})"
      case Annotation.JsGlobalScope =>
        s"@JSGlobalScope"
    }

  def formatAnns(anns: Seq[Annotation]): String =
    anns map formatAnn filterNot (_.isEmpty) match {
      case Nil       => ""
      case formatted => formatted.sorted.mkString("", "\n", "\n")
    }
}
