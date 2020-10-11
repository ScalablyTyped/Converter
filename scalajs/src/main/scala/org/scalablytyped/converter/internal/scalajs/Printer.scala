package org.scalablytyped.converter.internal
package scalajs

import java.io._

import org.scalablytyped.converter.internal.scalajs.transforms.ShortenNames
import org.scalablytyped.converter.internal.stringUtils.quote
import scala.collection.mutable

object Printer {
  implicit def defaulted(comp: Printer.type): default.type = default

  val default = new Impl(Name(""))

  private[Printer] class Registry() {

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

  def apply(
      scope:           TreeScope,
      parentsResolver: ParentsResolver,
      tree:            ContainerTree,
      outputPackage:   Name,
  ): Map[os.RelPath, Array[Byte]] = {
    val reg = new Registry()

    new Impl(outputPackage).apply(
      _scope          = scope,
      parentsResolver = parentsResolver,
      reg             = reg,
      packages        = IArray(tree.name),
      targetFolder    = os.RelPath(tree.name.unescaped),
      tree            = tree,
    )

    reg.result
  }

  val Imports: String =
    """|import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}""".stripMargin

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

        if (original(idx) == '\n') {
          hasIndented = false
        }

        idx += 1
      }
    }
  }

  final class Impl private[Printer] (outputPackage: Name) {
    def apply(
        _scope:          TreeScope,
        parentsResolver: ParentsResolver,
        reg:             Registry,
        packages:        IArray[Name],
        targetFolder:    os.RelPath,
        tree:            ContainerTree,
    ): Unit = {
      val files: Map[ScalaOutput, IArray[Tree]] = tree match {
        case _: PackageTree => tree.members.groupBy(ScalaOutput.outputAs)
        case other => Map(ScalaOutput.File(other.name) -> IArray(other))
      }
      val scope = _scope / tree

      val packageScalaFileName: String = {
        val normal  = "package"
        val escaped = "package_"

        def toEscape(name: String) = name.toLowerCase() == normal

        val shouldBeEscaped = files.exists {
          case (scalaOutput, _) =>
            scalaOutput match {
              case ScalaOutput.Package(Name(p)) if toEscape(p) => true
              case ScalaOutput.File(Name(p)) if toEscape(p)    => true
              case _                                           => false
            }
        }
        val name = if (shouldBeEscaped) escaped else normal
        s"$name.scala"
      }

      files.foreach {
        case (ScalaOutput.File(name), members: IArray[Tree]) =>
          reg.write(targetFolder / os.RelPath(s"${name.unescaped}.scala")) { writer =>
            val (imports, shortenedMembers) = ShortenNames(tree, scope, parentsResolver)(members)
            writer.println(s"package ${formatQN(QualifiedName(packages))}")
            writer.println("")
            imports.foreach(i => writer.println(s"import ${formatQN(i.imported)}"))
            writer.println(Imports)
            writer.println("")
            shortenedMembers.foreach(
              printTree(
                scope,
                parentsResolver,
                reg,
                Indenter(writer),
                packages,
                targetFolder,
                0,
              ),
            )
          }

        case (ScalaOutput.Package(name), pkgs) =>
          pkgs.foreach {
            case pkg: PackageTree =>
              apply(scope, parentsResolver, reg, packages :+ name, targetFolder / os.RelPath(name.unescaped), pkg)
            case _ => sys.error("i was too lazy to prove this with types")
          }

        case (ScalaOutput.PackageObject, members) =>
          reg.write(targetFolder / packageScalaFileName) { writer =>
            packages.dropRight(1) match {
              case IArray.Empty => ()
              case remaining =>
                writer.println(s"package ${formatQN(QualifiedName(remaining))}")
            }

            writer.println("")
            writer.println(Imports)
            writer.println("")
            writer.println("package object " + formatName(tree.name) + " {")
            members.foreach(
              printTree(
                scope,
                parentsResolver,
                reg,
                Indenter(writer),
                packages,
                targetFolder,
                2,
              ),
            )
            writer.println("}")
          }
      }
    }

    def printTree(
        _scope:          TreeScope,
        parentsResolver: ParentsResolver,
        reg:             Registry,
        w:               Indenter,
        packageNames:    IArray[Name],
        folder:          os.RelPath,
        indent:          Int,
    )(tree:              Tree): Unit = {
      val scope = _scope / tree

      def print(ss: String*): Unit =
        ss.foreach(w.print(indent))

      def println(ss: String*): Unit = {
        print(ss: _*)
        print("\n")
      }

      tree match {
        case tree: PackageTree =>
          apply(scope, parentsResolver, reg, packageNames :+ tree.name, folder / os.RelPath(tree.name.value), tree)

        case c @ ClassTree(
              isImplicit,
              anns,
              name,
              tparams,
              parents,
              ctors,
              members,
              classType,
              isSealed,
              comments,
              _,
            ) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          val (defaultCtor, restCtors) = ctors.sortBy(_.params.length).toList match {
            case Nil                                                  => (CtorTree.defaultPublic, Nil)
            case head :: tail if (head.params.isEmpty || !c.isNative) => (head, tail)
            case all                                                  => (CtorTree.defaultProtected, all)
          }

          print(Comments.format(defaultCtor.comments))
          print(
            if (isImplicit) "implicit " else "",
            if (isSealed) "sealed " else "",
            classType.asString,
            " ",
            formatName(name),
          )

          if (tparams.nonEmpty)
            print("[", tparams.map(formatTypeParamTree(indent)).mkString(", "), "]")

          if (classType =/= ClassType.Trait) {
            print(" ")
            print(formatProtectionLevel(defaultCtor.level, isCtor = true))
            print(formatParams(indent + 2)(defaultCtor.params))
          }

          print(extendsClause(parents, c.isNative, indent))

          if (members.nonEmpty || restCtors.nonEmpty) {
            println(" {")

            if (classType =/= ClassType.Trait)
              restCtors.foreach(printTree(scope, parentsResolver, reg, w, packageNames, folder, indent + 2))

            members.foreach(printTree(scope, parentsResolver, reg, w, packageNames, folder, indent + 2))
            println("}")
          } else
            println()

          println()

        case m @ ModuleTree(anns, name, parents, members, comments, _, isOverride) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          val isNative = m.isNative // shadows isNative
          print(
            if (isOverride) "override " else "",
            "object ",
            formatName(name),
            extendsClause(parents, isNative, indent),
          )

          if (members.nonEmpty) {
            println(" {")

            members.foreach(printTree(scope, parentsResolver, reg, w, packageNames, folder, indent + 2))
            println("}")
          } else
            println()
          println()

        case TypeAliasTree(name, tparams, alias, comments, _) =>
          print(Comments.format(comments))
          print("type ", formatName(name))
          if (tparams.nonEmpty) {
            print("[", tparams.map(formatTypeParamTree(indent)).mkString(", "), "]")
          }

          println(s" = ", formatTypeRef(indent)(alias))

        case FieldTree(anns, name, tpe, impl, isReadOnly, isOverride, comments, _) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          print(
            "",
            if (isOverride) "override " else "",
            if (isReadOnly) "val" else "var",
            " ",
            typeAnnotation(formatName(name), indent, tpe),
          )

          println(formatImpl(indent)(impl))

        case MethodTree(anns, level, name, tparams, params, impl, resultType, isOverride, comments, _, isImplicit) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          print(formatProtectionLevel(level, isCtor = false))
          print(if (isImplicit) "implicit " else "")
          print(s"${if (isOverride) "override " else ""}def ")

          val tparamString =
            if (tparams.isEmpty) ""
            else
              tparams.map(formatTypeParamTree(indent)).mkString("[", ", ", "]")

          var paramString = params.map(_.map(formatParamTree(indent)).mkString("(", ", ", ")"))
          if (paramString.toList.map(_.length).sum > 100) {
            paramString = params.map(_.map(formatParamTree(indent)).mkString("(\n  ", ",\n  ", "\n)"))
          }

          print(
            typeAnnotation(formatName(name) + tparamString + paramString.mkString, indent, resultType),
          )
          println(formatImpl(indent)(impl))

        case CtorTree(level, params, comments) =>
          print(Comments.format(comments))
          println(
            "",
            formatProtectionLevel(level, isCtor = true),
            "def this",
            formatParams(indent + 2)(params),
            " = this()",
          )

        case other => scope.logger.fatal(s"unexpected ${other.getClass.getSimpleName}")
      }
    }

    def formatParams(indent: Int)(ps: IArray[ParamTree]): String = {
      val base        = ps.map(formatParamTree(indent))
      var paramString = base.mkString("(", ", ", ")")
      if (paramString.length > 100 && ps.length > 1) {
        paramString = base.mkString("(\n  ", ",\n  ", "\n)")
      }
      paramString
    }

    def extendsClause(parents: IArray[TypeRef], isNative: Boolean, indent: Int): String =
      parents.toList.map(parent => formatTypeRef(indent + 6)(parent)) match {
        case Nil if isNative                    => " extends js.Object"
        case Nil                                => ""
        case head :: Nil if !head.contains(".") => " extends " + head
        case head :: Nil                        => "\n  extends " + head
        case head :: tail                       => "\n  extends " + head + tail.mkString("\n     with ", "\n     with ", "")
      }

    def formatTypeParams(indent: Int)(tparams: IArray[TypeParamTree]): String =
      if (tparams.isEmpty) ""
      else
        tparams.map(formatTypeParamTree(indent)).mkString("[", ", ", "]")

    def formatTypeParamTree(indent: Int)(tree: TypeParamTree): String =
      Comments.format(tree.comments) |+|
        formatName(tree.name) |+|
        formatTypeParams(indent)(tree.params) |+|
        (tree.upperBound match {
          case Some(bound) if tree.ignoreBound => " /* <: " |+| formatTypeRef(indent)(bound) |+| " */"
          case Some(bound)                     => " <: " |+| formatTypeRef(indent)(bound)
          case None                            => ""
        })

    def formatParamTree(indent: Int)(tree: ParamTree): String =
      IArray(
        Comments.format(tree.comments),
        if (tree.isImplicit) "implicit " else "",
        if (tree.isVal) "val " else "",
        typeAnnotation(formatName(tree.name), indent + 2, tree.tpe),
        formatImpl(indent)(tree.default),
      ).mkString

    def formatQN(q: QualifiedName): String =
      if (q.startsWith(QualifiedName.scala_js))
        formatQN(QualifiedName(q.parts.drop(QualifiedName.scala_js.parts.length - 1)))
      else q.parts.map(formatName).mkString(".")

    def formatName(name: Name): String = name match {
      case `outputPackage` => outputPackage.unescaped // this let's dots in chosen package name slip through
      case Name.APPLY      => "apply"
      case Name.THIS       => "this"
      case Name.SUPER      => "super"
      case other           => other.value
    }

    val StringOrdering: Ordering[String] = Ordering[String]

    /* for instance `val foo: Type_: Int` needs a space between `_` and `:` */
    def maybeSpace(tpe: String): String =
      if (tpe.last === '_' || tpe.last === '^' || tpe.last === '=') tpe |+| " "
      else tpe

    def typeAnnotation(preceding: String, indent: Int, tpe: TypeRef): String =
      maybeSpace(preceding) + ": " + formatTypeRef(indent)(tpe)

    def formatTypeRef(indent: Int)(t1: TypeRef): String = {
      val ret: String =
        t1 match {
          case TypeRef.ScalaFunction(paramTypes, retType) =>
            val params = paramTypes match {
              case IArray.exactlyOne(one) => formatTypeRef(indent)(one)
              case many                   => many.map(formatTypeRef(indent)).mkString("(", ", ", ")")
            }
            s"$params => ${formatTypeRef(indent)(retType)}"

          case TypeRef.ThisType(_)           => "this.type"
          case TypeRef.Wildcard              => "_"
          case TypeRef.Singleton(underlying) => formatTypeRef(indent)(underlying) |+| ".type"

          case TypeRef.Intersection(types, _) =>
            types.map(formatTypeRef(indent)).map(paramsIfNeeded).mkString(" with ")

          case TypeRef.UndefOr(tpe, _) =>
            formatTypeRef(indent)(TypeRef(QualifiedName.UndefOr, IArray(tpe), NoComments))

          case TypeRef.undefined => // keep this line after TypeRef.UndefOr. This line covers if it appears outside a union type
            formatTypeRef(indent)(TypeRef(QualifiedName.UndefOr, IArray(TypeRef.Nothing), NoComments))

          case TypeRef.Union(types, _) =>
            types.map(formatTypeRef(indent)).map(paramsIfNeeded).mkString(" | ")

          case TypeRef.StringLiteral(underlying)  => stringUtils.quote(underlying)
          case TypeRef.NumberLiteral(underlying)  => underlying
          case TypeRef.BooleanLiteral(underlying) => underlying

          case TypeRef.Repeated(underlying: TypeRef, _) =>
            maybeSpace(paramsIfNeeded(formatTypeRef(indent)(underlying))) + "*"

          case TypeRef(typeName, targs, _) =>
            val targsStr = targs match {
              case Empty => ""
              case nonEmpty =>
                val targStrs    = nonEmpty.map(formatTypeRef(indent + 2))
                val targsLength = targStrs.foldLeft[Integer](0)(_ + _.length)
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
        case Annotation.JsImport(module, imported, globalOpt) =>
          val importedString = imported match {
            case Imported.Namespace    => "JSImport.Namespace"
            case Imported.Default      => "JSImport.Default"
            case Imported.Named(names) => quote(names.map(_.unescaped).mkString("."))
          }
          val global = globalOpt.fold("")(g => ", " + quote(g.name.parts.map(_.unescaped).mkString(".")))
          s"@JSImport(${quote(module)}, $importedString$global)"
        case Annotation.ScalaJSDefined =>
          "" //"@ScalaJSDefined"
        case Annotation.JsGlobal(name: QualifiedName) =>
          s"@JSGlobal(${quote(name.parts.map(_.unescaped).mkString("."))})"
        case Annotation.JsGlobalScope =>
          s"@JSGlobalScope"
      }

    def formatAnns(anns: IArray[Annotation]): String =
      anns.map(formatAnn).filterNot(_.isEmpty) match {
        case Empty     => ""
        case formatted => formatted.sorted.mkString("", "\n", "\n")
      }

    def formatExpr(indent: Int)(e: ExprTree): String =
      e match {
        case ExprTree.Val(name, value) =>
          s"val ${name.value} = ${formatExpr(indent)(value)}"
        case ExprTree.TApply(ref, targs) =>
          s"${formatExpr(0)(ref)}[${targs.map(formatTypeRef(indent)).mkString(", ")}]"
        case ExprTree.If(pred, ifTrue, Some(ifFalse)) =>
          s"if (${formatExpr(indent)(pred)}) ${formatExpr(indent)(ifTrue)} else ${formatExpr(indent)(ifFalse)}"
        case ExprTree.If(pred, ifTrue, None) =>
          s"if (${formatExpr(indent)(pred)}) ${formatExpr(indent)(ifTrue)}"
        case ExprTree.Block(es) =>
          es.map(e => (" " * indent) + formatExpr(indent + 2)(e)).mkString("{\n", "\n", "\n}")
        case ExprTree.Null =>
          "null"
        case ExprTree.`:_*`(e) =>
          s"${formatExpr(indent)(e)} :_*"
        case ExprTree.Ref(value) =>
          formatQN(value)
        case ExprTree.StringLit(value) =>
          stringUtils.quote(value)
        case ExprTree.NumberLit(value) =>
          value
        case ExprTree.BooleanLit(value) =>
          value.toString
        case ExprTree.Unary(op, expr) =>
          s"$op${formatExpr(indent)(expr)}"
        case ExprTree.BinaryOp(one, op, two) =>
          s"${formatExpr(indent)(one)} $op ${formatExpr(indent)(two)}"
        case ExprTree.New(expr, Empty) =>
          s"new ${formatTypeRef(indent)(expr)}"
        case ExprTree.New(expr, params) =>
          s"new ${formatTypeRef(indent)(expr)}${params.map(formatExpr(indent)).mkString("(", ", ", ")")}"
        case ExprTree.Lambda(params, body) =>
          s"${params.map(formatParamTree(indent)).mkString("(", ", ", ")")} => ${formatExpr(indent)(body)}"
        case ExprTree.Call(function, paramss) =>
          val ps = paramss.map(params => params.map(formatExpr(indent)).mkString("(", ", ", ")")).mkString
          s"${formatExpr(indent)(function)}$ps"
        case ExprTree.Select(from, path) =>
          s"${paramsIfNeeded(formatExpr(indent)(from))}.${formatName(path)}"
        case ExprTree.Arg.Named(name, expr) =>
          s"${formatName(name)} = ${formatExpr(indent)(expr)}"
        case ExprTree.Arg.Pos(expr) =>
          formatExpr(indent)(expr)
        case ExprTree.Arg.Variable(expr) =>
          s"${formatExpr(indent)(expr)} :_*"
        case ExprTree.Throw(expr) =>
          s"throw ${formatExpr(indent)(expr)}"
      }

    def formatImpl(indent: Int)(e: ImplTree): String =
      e match {
        case NotImplemented => ""
        case e: ExprTree => " = " + formatExpr(indent)(e)
      }
  }
}
