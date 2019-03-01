package com.olvind.tso
package scalajs

import java.io._

import ammonite.ops.RelPath
import com.olvind.tso.stringUtils.quote

import scala.collection.mutable

object Printer {

  private class Registry() {

    private val fs = mutable.Map.empty[RelPath, Array[Byte]]

    def write(file: RelPath)(f: PrintWriter => Unit): Unit = {
      val w  = new StringWriter()
      val pw = new PrintWriter(w)

      try {
        f(pw)
        fs(file) = w.toString.getBytes(constants.Utf8)
      } finally {
        pw.close()
      }
    }

    def result: Map[RelPath, Array[Byte]] =
      fs.toMap
  }

  def apply(tree: ContainerTree, mainPkg: Name): Map[RelPath, Array[Byte]] = {
    val reg = new Registry()

    apply(
      reg          = reg,
      mainPkg      = mainPkg,
      scalaPrefix  = List(tree.name),
      targetFolder = RelPath(mainPkg.value) / tree.name.value,
      tree         = tree
    )

    reg.result
  }

  val Imports: String =
    """|import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |import scala.scalajs.js.annotation._""".stripMargin

  def apply(reg: Registry, mainPkg: Name, scalaPrefix: List[Name], targetFolder: RelPath, tree: ContainerTree): Unit = {
    val files: Map[ScalaOutput, Seq[Tree]] = tree match {
      case _: PackageTree => tree.members groupBy ScalaOutput.outputAs
      case other => Map(ScalaOutput.File(other.name) -> Seq(other))
    }

    files foreach {
      case (ScalaOutput.File(name), members: Seq[Tree]) =>
        reg.write(targetFolder / RelPath(s"${name.unescaped}.scala")) { writer =>
          writer println s"package ${formatName(mainPkg)}"
          writer println s"package ${formatQN(Nil, QualifiedName(scalaPrefix))}"
          writer.println("")
          writer.println(Imports)
          writer.println("")
          members foreach printTree(reg, Indenter(writer), mainPkg, scalaPrefix, targetFolder, 0)
        }

      case (ScalaOutput.Package(name), pkgs) =>
        pkgs foreach {
          case pkg: PackageTree =>
            apply(reg, mainPkg, scalaPrefix :+ name, targetFolder / RelPath(name.unescaped), pkg)
          case _ => sys.error("i was too lazy to prove this with types")
        }

      case (ScalaOutput.PackageObject, members) =>
        reg.write(targetFolder / "package.scala") { writer =>
          writer println s"package ${formatName(mainPkg)}"
          scalaPrefix.dropRight(1) match {
            case Nil => ()
            case remaining =>
              writer println s"package ${formatQN(Nil, QualifiedName(remaining))}"
          }

          writer.println("")
          writer.println(Imports)
          writer.println("")
          writer.println("package object " + formatName(tree.name) + " {")

          members foreach printTree(reg, Indenter(writer), mainPkg, scalaPrefix, targetFolder, 2)
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

  def printTree(reg: Registry, w: Indenter, mainPkg: Name, prefix: List[Name], folder: RelPath, indent: Int)(
      tree:          Tree
  ): Unit = {

    val printSym: Tree => Unit =
      printTree(reg, w, mainPkg, prefix, folder, indent + 2)

    def print(ss: String*): Unit =
      ss foreach w.print(indent)

    def println(ss: String*): Unit = {
      print(ss: _*)
      print("\n")
    }

    tree match {
      case tree: PackageTree =>
        apply(reg, mainPkg, prefix :+ tree.name, folder / RelPath(tree.name.value), tree)

      case ClassTree(anns, name, tparams, parents, ctors, members, classType, isSealed, comments, _) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        val (defaultCtor, restCtors) = ctors.sortBy(_.params.size).toList match {
          case Nil                                 => (CtorTree.defaultPublic, Nil)
          case head :: tail if head.params.isEmpty => (head, tail)
          case all                                 => (CtorTree.defaultProtected, all)
        }

        print(formatComments(defaultCtor.comments))
        print(if (isSealed) "sealed " else "", classType.asString, " ", formatName(name))

        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamTree(prefix, indent) mkString ", ", "]")

        if (classType =/= ClassType.Trait) {
          print(" ")
          print(formatProtectionLevel(defaultCtor.level, isCtor = true))
          print((defaultCtor.params map formatParamTree(prefix, indent)).mkString("(", ", ", ")"))
        }

        print(extendsClause(prefix, parents, isNative = true, indent))

        if (members.nonEmpty || restCtors.nonEmpty) {
          println(" {")

          if (classType =/= ClassType.Trait)
            restCtors foreach printSym

          members foreach printSym
          println("}")
        } else
          println()

        println()

      case ModuleTree(anns, name, moduleType, parents, members, comments, _) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        val isNative = moduleType match {
          case ModuleTypeNative => true
          case ModuleTypeScala  => false
        }

        print("object ", formatName(name), extendsClause(prefix, parents, isNative, indent))

        val newPrefix =
          if (name.unescaped.endsWith("Members") || moduleType === ModuleTypeScala) prefix else prefix :+ name

        if (members.nonEmpty) {
          println(" {")

          members foreach printTree(reg, w, mainPkg, newPrefix, folder, indent + 2)
          println("}")
        } else
          println()
        println()

      case TypeAliasTree(name, tparams, alias, comments, _) =>
        print(formatComments(comments))
        print("type ", formatName(name))
        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamTree(prefix, indent) mkString ", ", "]")
        println(s" = ", formatTypeRef(prefix, indent)(alias))

      case FieldTree(anns, name, tpe, fieldType, isReadOnly, isOverride, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        print(
          "",
          if (isOverride) "override " else "",
          if (isReadOnly) "val" else "var",
          " ",
          typeAnnotation(formatName(name), formatTypeRef(prefix, indent)(tpe))
        )

        fieldType match {
          case MemberImplNotImplemented => println()
          case MemberImplNative         => println(" = js.native")
          case MemberImplCustom(impl)   => println(" = ", impl)
        }

      case MethodTree(anns, level, name, tparams, params, fieldType, resultType, isOverride, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        print(formatProtectionLevel(level, isCtor = false))
        print(s"${if (isOverride) "override " else ""}def ")

        val nameString = formatName(name)
        val tparamString =
          if (tparams.isEmpty) ""
          else
            tparams.map(formatTypeParamTree(prefix, indent)).mkString("[", ", ", "]")

        var paramString = params.map(_.map(formatParamTree(prefix, indent)).mkString("(", ", ", ")"))
        if (paramString.map(_.length).sum > 100) {
          paramString = params.map(_.map(formatParamTree(prefix, indent)).mkString("(\n  ", ",\n  ", "\n)"))
        }
        print(
          typeAnnotation(nameString + tparamString + paramString.mkString, formatTypeRef(prefix, indent)(resultType))
        )
        fieldType match {
          case MemberImplNotImplemented => println()
          case MemberImplNative         => println(" = js.native")
          case MemberImplCustom(impl)   => println(" = ", impl)
        }

      case CtorTree(level, params, comments) =>
        print(formatComments(comments))
        println("",
                formatProtectionLevel(level, isCtor = true),
                "def this(",
                (params map formatParamTree(prefix, indent)) mkString ", ",
                ") = this()")

      case tree @ ParamTree(_, _, _, comments) =>
        print(formatComments(comments))
        println(formatParamTree(prefix, indent)(tree))

      case tree @ TypeParamTree(_, _, comments) =>
        print(formatComments(comments))
        print(formatTypeParamTree(prefix, indent)(tree))

      case tree @ TypeRef(_, _, comments) =>
        print(formatComments(comments))
        print(formatTypeRef(prefix, indent)(tree))
    }
  }

  def extendsClause(prefix: List[Name], parents: Seq[TypeRef], isNative: Boolean, indent: Int): String =
    parents.toList.map(parent => formatTypeRef(prefix, indent + 6)(parent)) match {
      case Nil if isNative                    => " extends js.Object"
      case Nil                                => ""
      case head :: Nil if !head.contains(".") => " extends " + head
      case head :: Nil                        => "\n  extends " + head
      case head :: tail                       => "\n  extends " + head + tail.mkString("\n     with ", "\n     with ", "")
    }

  def formatTypeParamTree(prefix: List[Name], indent: Int)(tree: TypeParamTree): String =
    formatComments(tree.comments) |+|
      formatName(tree.name) |+|
      tree.upperBound.fold("")(bound => " /* <: " |+| formatTypeRef(prefix, indent)(bound) |+| " */")

  def formatParamTree(prefix: List[Name], indent: Int)(tree: ParamTree): String =
    Seq(
      formatComments(tree.comments),
      typeAnnotation(formatName(tree.name), formatTypeRef(prefix, indent + 2)(tree.tpe)),
      tree.default.fold("")(d => s" = ${formatDefaultedTypeRef(prefix, indent)(d)}")
    ).foldLeft("")(_ |+| _)

  def formatDefaultedTypeRef(prefix: List[Name], indent: Int)(ref: TypeRef): String =
    ref match {
      case TypeRef.`null`    => "null"
      case TypeRef.undefined => "js.undefined"
      case other             => formatTypeRef(prefix, indent + 2)(other)
    }

  def formatQN(prefix: List[Name], q: QualifiedName): String =
    q.parts match {
      case Name.scala :: Name.scalajs :: Name.js :: name :: Nil => "js." + formatName(name)
      case `prefix` :+ name                                     => formatName(name)
      case other                                                => other.map(formatName).mkString(".")
    }

  def formatName(name: Name): String = name match {
    case Name.APPLY => "apply"
    case other      => other.value
  }

  val StringOrdering: Ordering[String] = Ordering[String]

  /* for instance `val foo: Type_: Int` needs a space between `_` and `:` */
  def typeAnnotation(preceding: String, formattedType: String): String = {
    val colon = if (preceding.last === '_' || preceding.last === '^') " : " else ": "
    preceding + colon + formattedType
  }

  def formatTypeRef(prefix: List[Name], indent: Int)(t1: TypeRef): String = {
    val ret: String =
      t1 match {
        case TypeRef.ThisType(_) => "this.type"
        case TypeRef.Wildcard    => "_"

        case TypeRef.Intersection(types) =>
          types map formatTypeRef(prefix, indent) map paramsIfNeeded mkString " with "

        case TypeRef.Union(types) =>
          types map formatTypeRef(prefix, indent) map paramsIfNeeded mkString " | "

        case TypeRef.Literal(literal: String) =>
          literal |+| ".type"

        case TypeRef.Repeated(underlying: TypeRef, _) =>
          paramsIfNeeded(formatTypeRef(prefix, indent)(underlying)) |+| "*"

        case TypeRef(typeName, targs, _) =>
          val targsStr = targs match {
            case Nil => ""
            case nonEmpty =>
              val targStrs    = nonEmpty map formatTypeRef(prefix, indent + 2)
              val targsLength = targStrs.foldLeft(0)(_ + _.length)
              val sep         = if (targsLength > 80) "\n" + (" " * indent) else ""
              targStrs.mkString(s"[$sep", s", $sep", s"${sep.dropRight(2)}]")
          }

          formatQN(prefix, typeName) |+| targsStr
      }

    formatComments(t1.comments) |+| ret
  }

  def paramsIfNeeded(s: String): String =
    if (s.exists(_.isWhitespace)) s"($s)" else s

  def formatProtectionLevel(p: ProtectionLevel, isCtor: Boolean): String =
    p match {
      case Default             => ""
      case Private if isCtor   => "protected "
      case Private             => "/* private */ "
      case Protected if isCtor => "protected "
      case Protected           => "/* protected */ "
    }

  def formatAnn(prefix: List[Name])(a: Annotation): String =
    a match {
      case Inline =>
        "@scala.inline"
      case JsBracketAccess =>
        "@JSBracketAccess"
      case JsBracketCall =>
        "@JSBracketCall"
      case JsNative =>
        "@js.native"
      case JsName(name: Name) =>
        s"@JSName(${quote(name.unescaped)})"
      case JsNameSymbol(name) =>
        s"@JSName(${formatQN(prefix, name)})"
      case JsImport(module, imported) =>
        val importedString = imported match {
          case Imported.Namespace   => "JSImport.Namespace"
          case Imported.Default     => "JSImport.Default"
          case Imported.Named(name) => quote(name.unescaped)
        }
        s"@JSImport(${quote(module)}, $importedString)"
      case ScalaJSDefined =>
        "" //"@ScalaJSDefined"
      case JsGlobal(name: QualifiedName) =>
        s"@JSGlobal(${quote(name.parts.map(_.unescaped).mkString("."))})"
      case JsGlobalScope =>
        s"@JSGlobalScope"
    }

  def formatAnns(prefix: List[Name], anns: Seq[Annotation]): String =
    anns map formatAnn(prefix) filterNot (_.isEmpty) match {
      case Nil       => ""
      case formatted => formatted.sorted.mkString("", "\n", "\n")
    }

  def formatComments(comments: Comments): String =
    comments.cs
      .map(
        comment =>
          stringUtils.formatComment(
            stringUtils.escapeUnicodeEscapes(
              stringUtils.escapeNestedComments(comment.raw)
            )
        )
      )
      .mkString("")
}
