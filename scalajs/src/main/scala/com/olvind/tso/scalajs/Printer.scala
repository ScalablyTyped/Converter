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

  def apply(lib: LibScalaJs[_], mainPkg: Name): Map[RelPath, Array[Byte]] = {
    val reg = new Registry()

    apply(
      reg          = reg,
      mainPkg      = mainPkg,
      scalaPrefix  = List(lib.packageSymbol.name),
      targetFolder = RelPath(mainPkg.value) / lib.packageSymbol.name.value,
      sym          = lib.packageSymbol
    )

    reg.result
  }

  val Imports: String =
    """|import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |import scala.scalajs.js.annotation._""".stripMargin

  def apply(reg:          Registry,
            mainPkg:      Name,
            scalaPrefix:  List[Name],
            targetFolder: RelPath,
            sym:          ContainerSymbol): Unit = {
    val files: Map[ScalaOutput, Seq[Symbol]] = sym match {
      case _: PackageSymbol => sym.members groupBy ScalaOutput.outputAs
      case other => Map(ScalaOutput.File(other.name) -> Seq(other))
    }

    files foreach {
      case (ScalaOutput.File(name), members: Seq[Symbol]) =>
        reg.write(targetFolder / RelPath(s"${name.unescaped}.scala")) { writer =>
          writer println s"package ${formatName(mainPkg)}"
          writer println s"package ${formatQN(Nil, QualifiedName(scalaPrefix))}"
          writer.println("")
          writer.println(Imports)
          writer.println("")
          members foreach printSymbol(reg, Indenter(writer), mainPkg, scalaPrefix, targetFolder, 0)
        }

      case (ScalaOutput.Package(name), pkgs) =>
        pkgs foreach {
          case pkg: PackageSymbol =>
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
          writer.println("package object " + formatName(sym.name) + " {")

          members foreach printSymbol(reg, Indenter(writer), mainPkg, scalaPrefix, targetFolder, 2)
          writer.println("}")
        }

      case (ScalaOutput.StaticsObject, _) =>
        sys.error("This codepath should no longer be reached, still missing some refactoring")
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

  def printSymbol(reg: Registry, w: Indenter, mainPkg: Name, prefix: List[Name], folder: RelPath, indent: Int)(
      sym:             Symbol
  ): Unit = {

    val printSym: Symbol => Unit =
      printSymbol(reg, w, mainPkg, prefix, folder, indent + 2)

    def print(ss: String*): Unit =
      ss foreach w.print(indent)

    def println(ss: String*): Unit = {
      print(ss: _*)
      print("\n")
    }

    sym match {
      case sym: PackageSymbol =>
        apply(reg, mainPkg, prefix :+ sym.name, folder / RelPath(sym.name.value), sym)

      case ClassSymbol(anns, name, tparams, parents, ctors, members, classType, isSealed, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        val sealedKw = if (isSealed) "sealed " else ""
        val (defaultCtor, restCtors) = ctors.sortBy(_.params.size).toList match {
          case Nil                                 => (CtorSymbol.defaultPublic, Nil)
          case head :: tail if head.params.isEmpty => (head, tail)
          case all                                 => (CtorSymbol.defaultProtected, all)
        }

        print(sealedKw, classType.asString, " ", formatName(name))

        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamSymbol(prefix, indent) mkString ", ", "]")

        if (classType =/= ClassType.Trait) {
          print(" ")
          print(formatProtectionLevel(defaultCtor.level, isCtor = true))
          print((defaultCtor.params map formatParamSymbol(prefix, indent)).mkString("(", ", ", ")"))
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

      case ModuleSymbol(anns, name, moduleType, parents, members, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        val isNative = moduleType match {
          case ModuleTypeNative => true
          case ModuleTypeScala  => false
        }

        print("object ", formatName(name), extendsClause(prefix, parents, isNative, indent))

        val newPrefix = if (name.unescaped.endsWith("Members")) prefix else prefix :+ name

        if (members.nonEmpty) {
          println(" {")

          members foreach printSymbol(reg, w, mainPkg, newPrefix, folder, indent + 2)
          println("}")
        } else
          println()
        println()

      case TypeAliasSymbol(name, tparams, alias, comments) =>
        print(formatComments(comments))
        print("type ", formatName(name))
        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamSymbol(prefix, indent) mkString ", ", "]")
        println(s" = ", formatTypeRef(prefix, indent)(alias))

      case FieldSymbol(anns, name, tpe, fieldType, isReadOnly, isOverride, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        print(
          "",
          if (isOverride) "override " else "",
          if (isReadOnly) "val" else "var",
          " ",
          formatName(name),
          ": ",
          formatTypeRef(prefix, indent)(tpe)
        )

        fieldType match {
          case MemberImplNotImplemented => println()
          case MemberImplNative         => println(" = js.native")
          case MemberImplCustom(impl)   => println(" = ", impl)
        }

      case MethodSymbol(anns, level, name, tparams, params, fieldType, resultType, isOverride, comments) =>
        print(formatComments(comments))
        print(formatAnns(prefix, anns))

        print(formatProtectionLevel(level, isCtor = false))
        print(s"${if (isOverride) "override " else ""}def ", formatName(name))
        if (tparams.nonEmpty)
          print("[", tparams map formatTypeParamSymbol(prefix, indent) mkString ", ", "]")

        var paramString = params.map(_.map(formatParamSymbol(prefix, indent)).mkString("(", ", ", ")"))
        if (paramString.map(_.length).sum > 100) {
          paramString = params.map(_.map(formatParamSymbol(prefix, indent)).mkString("(\n  ", ",\n  ", "\n)"))
        }
        print(paramString.mkString, ": ")
        print(formatTypeRef(prefix, indent)(resultType))
        fieldType match {
          case MemberImplNotImplemented => println()
          case MemberImplNative         => println(" = js.native")
          case MemberImplCustom(impl)   => println(" = ", impl)
        }

      case CtorSymbol(level, params, comments) =>
        print(formatComments(comments))
        println("",
                formatProtectionLevel(level, isCtor = true),
                "def this(",
                (params map formatParamSymbol(prefix, indent)) mkString ", ",
                ") = this()")

      case sym @ ParamSymbol(_, _, comments) =>
        print(formatComments(comments))
        println(formatParamSymbol(prefix, indent)(sym))

      case sym @ TypeParamSymbol(_, _, comments) =>
        print(formatComments(comments))
        print(formatTypeParamSymbol(prefix, indent)(sym))

      case sym @ TypeRef(_, _, comments) =>
        print(formatComments(comments))
        print(formatTypeRef(prefix, indent)(sym))
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

  def formatTypeParamSymbol(prefix: List[Name], indent: Int)(sym: TypeParamSymbol): String =
    formatComments(sym.comments) |+|
      formatName(sym.name) |+|
      sym.upperBound.fold("")(bound => " /* <: " |+| formatTypeRef(prefix, indent)(bound) |+| " */")

  def formatParamSymbol(prefix: List[Name], indent: Int)(sym: ParamSymbol): String =
    Seq(
      formatComments(sym.comments),
      formatName(sym.name),
      ": ",
      formatTypeRef(prefix, indent + 2)(sym.tpe)
    ).foldLeft("")(_ |+| _)

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

  def formatTypeRef(prefix: List[Name], indent: Int)(t1: TypeRef): String = {
    val ret: String =
      t1 match {
        case TypeRef.ThisType(_)       => "this.type"
        case TypeRef.Ignored           => "_"
        case TypeRef(typeName, Nil, _) => formatQN(prefix, typeName)

        case TypeRef.Intersection(types) =>
          types map formatTypeRef(prefix, indent) map paramsIfNeeded mkString " with "

        case TypeRef.Union(types) =>
          types map formatTypeRef(prefix, indent) map paramsIfNeeded mkString " | "

        case TypeRef.Literal(literal: String) =>
          literal |+| ".type"

        case TypeRef.Repeated(underlying: TypeRef, _) =>
          paramsIfNeeded(formatTypeRef(prefix, indent)(underlying)) |+| "*"

        case TypeRef(typeName, targs, _) =>
          val targStrs    = targs map formatTypeRef(prefix, indent + 2)
          val targsLength = targStrs.foldLeft(0)(_ + _.length)
          val sep         = if (targsLength > 80) "\n" + (" " * indent) else ""
          val targsStr    = targStrs.mkString(s"[$sep", s", $sep", s"${sep.dropRight(2)}]")
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
    if (anns.isEmpty) "" else (anns map formatAnn(prefix)).sorted.mkString("", "\n", "\n")

  def formatComments(comments: Comments): String =
    comments.cs
      .map(comment => stringUtils.escapeUnicodeEscapes(stringUtils.escapeNestedComments(comment.raw)))
      .mkString("")
}
