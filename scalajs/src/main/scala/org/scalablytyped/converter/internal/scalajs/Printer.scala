package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.scalajs.transforms.ShortenNames
import org.scalablytyped.converter.internal.stringUtils.quote

import java.io._

object debugPrinter extends Printer.Impl(Name(""), Versions.Scala3)

object Printer {
  implicit def defaulted(comp: Printer.type): debugPrinter.type = debugPrinter

  private[Printer] class Registry() {

    private val files = IArray.Builder.empty[(os.RelPath, String)]

    def write(file: os.RelPath)(f: PrintWriter => Unit): Unit = {
      val w  = new StringWriter()
      val pw = new PrintWriter(w)

      try {
        f(pw)
        files += ((file, w.toString))
      } finally {
        pw.close()
      }
    }

    def result: IArray[(os.RelPath, String)] =
      files.result()
  }

  def apply(
      scope:           TreeScope,
      parentsResolver: ParentsResolver,
      tree:            ContainerTree,
      outputPackage:   Name,
      scalaVersion:    Versions.Scala,
  ): IArray[(os.RelPath, String)] = {
    val reg = new Registry()

    new Impl(outputPackage, scalaVersion).apply(
      _scope          = scope,
      parentsResolver = parentsResolver,
      reg             = reg,
      packages        = IArray(tree.name),
      targetFolder    = os.RelPath(tree.name.unescaped),
      tree            = tree,
    )

    reg.result
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

        if (original(idx) == '\n') {
          hasIndented = false
        }

        idx += 1
      }
    }
  }

  sealed class Impl(outputPackage: Name, scalaVersion: Versions.Scala) {
    val Imports: String = {
      if (scalaVersion.is3)
        """|import org.scalablytyped.runtime.StObject
           |import scala.scalajs.js
           |import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}""".stripMargin
      else
        """|import org.scalablytyped.runtime.StObject
           |import scala.scalajs.js
           |import scala.scalajs.js.`|`
           |import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}""".stripMargin

    }
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
            printTrees(
              scope,
              parentsResolver,
              reg,
              Indenter(writer),
              packages,
              targetFolder,
              0,
              shortenedMembers,
            )
          }

        case (ScalaOutput.Package(name), pkgs) =>
          pkgs.foreach {
            case pkg: PackageTree =>
              apply(scope, parentsResolver, reg, packages :+ name, targetFolder / os.RelPath(name.unescaped), pkg)
            case _ => sys.error("i was too lazy to prove this with types")
          }

        case (ScalaOutput.PackageObject, members) if scalaVersion.is3 =>
          reg.write(targetFolder / packageScalaFileName) { writer =>
            val (imports, shortenedMembers) =
              ShortenNames(tree, scope, parentsResolver)(members)
            writer.println(s"package ${formatQN(QualifiedName(packages))}")
            writer.println("")
            imports.foreach(i => writer.println(s"import ${formatQN(i.imported)}"))
            writer.println(Imports)
            writer.println("")
            printTrees(
              scope,
              parentsResolver,
              reg,
              Indenter(writer),
              packages,
              targetFolder,
              if (scalaVersion.is3) 0 else 2,
              shortenedMembers,
            )
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
            printTrees(
              scope,
              parentsResolver,
              reg,
              Indenter(writer),
              packages,
              targetFolder,
              2,
              members,
            )
            writer.println("}")
          }

      }
    }

    def printTrees(
        _scope:          TreeScope,
        parentsResolver: ParentsResolver,
        reg:             Registry,
        w:               Indenter,
        packageNames:    IArray[Name],
        folder:          os.RelPath,
        indent:          Int,
        trees:           IArray[Tree],
    ): Unit = {
      def sameIshName(one: Tree, two: Tree): Boolean = {
        def nameFor(x: Tree) = {
          val name0 = x match {
            case x: MemberTree => x.originalName
            case x => x.name
          }
          name0.unescaped match {
            case setter if setter.endsWith("_=") => setter.dropRight(2)
            case name                            => name
          }
        }
        nameFor(one) === nameFor(two)
      }

      var last = Option.empty[Tree]

      trees.foreach { tree =>
        last match {
          case Some(last) if sameIshName(last, tree) =>
            ()
          case _ =>
            w.print(indent)("\n")
        }

        printTree(_scope, parentsResolver, reg, w, packageNames, folder, indent)(tree)

        last = Some(tree)
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

//        case c: ClassTree
//            if scalaVersion.is3 &&
//              c.classType === ClassType.Class &&
//              c.annotations.contains(Annotation.Inline) &&
//              c.ctors.length === 1 &&
//              c.parents.length === 1 &&
//              c.parents.head.name === Name.AnyVal =>
//          print("extension ")
//
//          if (c.tparams.nonEmpty)
//            print("[", c.tparams.map(formatTypeParamTree(indent)).mkString(", "), "]")
//
//          print(formatParams(indent + 2)(c.ctors.head.params.map(_.copy(isVal = false))))
//
//          println(" {")
//          printTrees(scope, parentsResolver, reg, w, packageNames, folder, indent + 2, c.members)
//          println("}")

        case c @ ClassTree(
              isImplicit,
              anns,
              level,
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
            formatProtectionLevel(level),
            if (isImplicit) "implicit " else "",
            if (isSealed) "sealed "
            else if (scalaVersion.is3 && classType === ClassType.Class) "open "
            else "",
            classType.asString,
            " ",
            formatName(name),
          )

          if (tparams.nonEmpty)
            print("[", tparams.map(formatTypeParamTree(indent)).mkString(", "), "]")

          if (classType =/= ClassType.Trait) {
            print(" ")
            print(formatProtectionLevel(defaultCtor.level))
            print(formatParams(indent + 2)(defaultCtor.params))
          }

          print(extendsClause(comments, parents, c.isNative, indent))

          if (members.nonEmpty || restCtors.nonEmpty) {
            println(" {")

            if (classType =/= ClassType.Trait)
              restCtors.foreach(printTree(scope, parentsResolver, reg, w, packageNames, folder, indent + 2))

            printTrees(scope, parentsResolver, reg, w, packageNames, folder, indent + 2, members)
            println("}")
          } else
            println()

        case m @ ModuleTree(anns, level, name, parents, members, comments, _, isOverride) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          val isNative = m.isNative // shadows isNative
          print(
            if (isOverride) "override " else "",
            formatProtectionLevel(level),
            "object ",
            formatName(name),
            extendsClause(comments, parents, isNative, indent),
          )

          if (members.nonEmpty) {
            println(" {")

            printTrees(scope, parentsResolver, reg, w, packageNames, folder, indent + 2, members)
            println("}")
          } else
            println()

        case TypeAliasTree(name, level, tparams, alias, comments, _) =>
          print(Comments.format(comments))

          print(formatProtectionLevel(level), "type ", formatName(name))
          if (tparams.nonEmpty) {
            print("[", tparams.map(formatTypeParamTree(indent)).mkString(", "), "]")
          }

          println(s" = ", formatTypeRef(indent)(alias))

        case FieldTree(anns, level, name, tpe, impl, isReadOnly, isOverride, comments, _) =>
          print(Comments.format(comments))
          print(formatAnns(anns))

          print(
            "",
            formatProtectionLevel(level),
            if (isOverride) "override " else "",
            if (isReadOnly) "val" else "var",
            " ",
            typeAnnotation(formatName(name), indent, tpe),
          )

          println(formatImpl(indent)(impl))

        case MethodTree(anns, level, name, tparams, params, impl, resultType, isOverride, comments, _, isImplicit) =>
          print(Comments.format(comments))
          if (scalaVersion.is3) {
            val (inline, rest) = anns.partitionCollect { case Annotation.Inline => Annotation.Inline }
            print(formatAnns(rest))
            if (inline.nonEmpty) print("inline ")
          } else {
            print(formatAnns(anns))
          }
          print(formatProtectionLevel(level))
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
            formatProtectionLevel(level),
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

    // This is unfortunate, the the `Printer` still changes the AST somewhat before printing: Namely it adds
    // `StObject` to the list of parents for native types.
    // The reason why it's still done here is that it significantly degrades the quality of the output if we do it
    //  earlier because of a number of type computations which would need exceptions.
    def extendsClause(cs: Comments, parents: IArray[TypeRef], isNative: Boolean, indent: Int): String = {
      val hasClass = cs.has[Marker.HasClassParent.type]
      val formattedParents = parents.toList.map {
        case TypeRef.JsObject => "StObject"
        case parent           => formatTypeRef(indent + 6)(parent)
      }

      val patchedParents =
        if (isNative && (parents.isEmpty || !hasClass))
          ("StObject" :: formattedParents).distinct
        else formattedParents

      patchedParents match {
        case Nil                                => ""
        case head :: Nil if !head.contains(".") => " extends " + head
        case head :: Nil                        => "\n  extends " + head
        case head :: tail                       => "\n  extends " + head + tail.mkString("\n     with ", "\n     with ", "")
      }
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

          case TypeRef.ThisType(_)                  => "this.type"
          case TypeRef.Wildcard if scalaVersion.is3 => "?"
          case TypeRef.Wildcard                     => "_"
          case TypeRef.Singleton(underlying)        => formatTypeRef(indent)(underlying) |+| ".type"

          case TypeRef.Intersection(types, _) if scalaVersion.is3 =>
            types.map(formatTypeRef(indent)).map(paramsIfNeeded).mkString(" & ")

          case TypeRef.Intersection(types, _) =>
            types.map(formatTypeRef(indent)).map(paramsIfNeeded).mkString(" with ")

          case TypeRef.UndefOr(tpe, _) =>
            formatTypeRef(indent)(TypeRef(QualifiedName.JsUndefOr, IArray(tpe), NoComments))

          case TypeRef.undefined => // keep this line after TypeRef.UndefOr. This line covers if it appears outside a union type
            formatTypeRef(indent)(TypeRef.Unit)

          case TypeRef.Union(types, _) =>
            types.map(formatTypeRef(indent)).map(paramsIfNeeded).mkString(" | ")

          case TypeRef.StringLiteral(underlying)  => stringUtils.quote(underlying)
          case TypeRef.DoubleLiteral(underlying)  => underlying
          case TypeRef.IntLiteral(underlying)     => underlying
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
      else s

    def formatProtectionLevel(p: ProtectionLevel): String =
      p match {
        case ProtectionLevel.Public                => ""
        case ProtectionLevel.Private(Some(within)) => s"private[${within.unescaped}] "
        case ProtectionLevel.Private(None)         => "private "
        case ProtectionLevel.Protected             => "protected "
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
          es.map(e => "  " + formatExpr(indent)(e)).mkString("{\n", "\n", "\n}")
        case ExprTree.undefined =>
          "js.undefined"
        case ExprTree.Null =>
          "null"
        case ExprTree.`:_*`(e) if scalaVersion.is3 =>
          s"${formatExpr(indent)(e)}*"
        case ExprTree.`:_*`(e) =>
          s"${formatExpr(indent)(e)} :_*"
        case ExprTree.Ref(value) =>
          formatQN(value)
        case ExprTree.StringLit(value) =>
          stringUtils.quote(value)
        case ExprTree.IntLit(value) =>
          value
        case ExprTree.DoubleLit(value) =>
          if (value.contains("e")) value else value + "d"
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
