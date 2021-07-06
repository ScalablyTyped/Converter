package org.scalablytyped.converter.internal
package scalajs

import java.util.regex.Pattern

import ammonite.ops._
import bloop.io.AbsolutePath
import com.olvind.logging
import org.scalablytyped.converter.internal.importer.build.BloopCompiler
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.transforms.Sorter

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.reflect.NameTransformer
import scala.tools.scalap.scalax.rules.scalasig._

/**
  * The new erasure check means we need to know the entire inheritance tree for all JS types we interact with.
  * It was way too much work to manually tag them, so this imports the information directly from JAR files.
  *
  * The trees are then serialized to a json file which is packaged with the application.
  *
  * The whole code is in a pretty throw-away state for various reasons
  *  - not the highest fidelity is required here
  *  - pretty soon it should import tasty instead
  */
object ImportScalaDefinitions extends App {
  private val defaultVersions: Versions = Versions(Versions.Scala213, Versions.ScalaJs1)

  val All: Array[AbsolutePath] = Await
    .result(
      BloopCompiler.resolve(
        defaultVersions.scalajsReact.concrete(defaultVersions),
        defaultVersions.scalaJsDom.concrete(defaultVersions),
        defaultVersions.slinkyWeb.concrete(defaultVersions),
        defaultVersions.slinkyNative.concrete(defaultVersions),
        defaultVersions.scalaJsLibrary.concrete(defaultVersions),
        defaultVersions.runtime.concrete(defaultVersions),
      ),
      Duration.Inf,
    )
    .filter(file => file.toString.contains("sjs1") || file.toString.contains("scalajs-library"))

  val projectRoot: os.Path = {
    var current = os.pwd

    def containsBuildSbt =
      os.list(current).exists(_.last === "build.sbt")

    while (!containsBuildSbt) {
      if (os.root == current) sys.error("Couldn't find project root folder")
      current = current / os.up
    }
    current
  }

  val tempDir: os.Path =
    os.temp.dir()
  val dumpSourceTo: os.Path =
    projectRoot / "import-scalajs-definitions" / "src" / "test" / "resources"
  val dumpJsonTo: os.Path =
    projectRoot / "scalajs" / "src" / "main" / "resources" / "scalajs-definitions.json"

  type MyTree = Tree with HasCodePath

  private val all: IArray[MyTree] = {
    implicit val wd: os.Path = tempDir

    All.foreach { jar =>
      %("unzip", "-o", jar.toString)
    }

    IArray
      .fromTraversable(os.walk(tempDir))
      .flatMap {
        case file if file.isFile && file.ext == "class" && !file.last.contains("$") =>
          val byteCode  = ByteCode(os.read.bytes(file))
          val classFile = ClassFileParser.parse(byteCode)

          ScalaSigParser.parse(classFile) match {
            case Some(scalaSig) =>
              IArray
                .fromTraversable(scalaSig.symbols)
                .filter(ScalaSigEntryParsers.isTopLevel)
                .mapNotNone(toTree)
                .flatMap {
                  case x: ContainerTree if x.name.unescaped === "package" => x.members.collect { case x: MyTree => x }
                  case x: MyTree                                          => IArray(x)
                  case _ => Empty
                }
            case None =>
              System.err.println(s"Couldnt parse $file")
              Empty
          }

        case _ => Empty
      }
  }

  def flatten(tree: IArray[Tree]): IArray[MyTree] =
    tree.flatMap {
      case x: ContainerTree => flatten(x.members)
      case x: MyTree        => IArray(x)
      case _ => Empty
    }

  val allJs: IArray[MyTree] = {
    val inheritanceByName: Map[QualifiedName, MyTree] =
      flatten(all).collect {
        case x: ClassTree     => x.codePath -> x
        case x: TypeAliasTree => x.codePath -> x
      }.toMap

    def isJs(tree: MyTree): Option[MyTree] = {
      def extendsJs(ref: TypeRef): Boolean =
        ref match {
          case typeRef if TypeRef.Primitive(typeRef) => true
          case TypeRef.Union(types, _)               => types.forall(extendsJs)
          case TypeRef.Intersection(types, _)        => types.forall(extendsJs)
          case TypeRef.JsAny                         => true
          case TypeRef.JsObject                      => true
          case other =>
            inheritanceByName.get(other.typeName) match {
              case Some(found) =>
                isJs(found).isDefined
              case _ =>
                println(s"didnt find parent ${Printer.formatQN(other.typeName)}")
                false
            }
        }

      def extendsJsMany(parents: IArray[TypeRef]): Boolean =
        parents.exists(extendsJs)

      tree match {
        case cls: ClassTree =>
          if (extendsJsMany(cls.parents)) Some(cls.copy(annotations = cls.annotations :+ Annotation.JsNative)) else None

        case obj: ModuleTree =>
          val isJsObject = extendsJsMany(obj.parents)
          obj.members.mapNotNone {
            case x: ClassTree     => isJs(x)
            case x: ModuleTree    => isJs(x)
            case x: FieldTree     => if (isJsObject) Some(x) else None
            case x: MethodTree    => if (isJsObject) Some(x) else None
            case x: TypeAliasTree => if (extendsJs(x.alias)) Some(x) else None
            case _ => None
          } match {
            case Empty => None
            case kept =>
              Some(
                obj.copy(
                  members     = kept,
                  parents     = if (isJsObject) obj.parents else Empty,
                  annotations = if (isJsObject) obj.annotations :+ Annotation.JsNative else obj.annotations,
                ),
              )
          }
        // don't bother implementing this property, theres a trick to obtain a recursive type parameter
        case ta: TypeAliasTree
            if ta.codePath.parts.head.unescaped === "japgolly" && ta.codePath.parts.last.unescaped == "ChildrenArray" =>
          val A  = TypeRef(Name("A"))
          val As = TypeRef(QualifiedName.JsArray, IArray(A), NoComments)
          Some(ta.copy(alias = TypeRef.Union(IArray(A, As), NoComments, sort = false)))
        case ta: TypeAliasTree =>
          if (extendsJs(ta.alias)) Some(ta) else None
        case _ =>
          None
      }
    }

    all.mapNotNone(isJs)
  }

  {
    val inContainers: IArray[Tree] =
      allJs.map { one =>
        val codePath = one.codePath.parts
        def pack(idx: Int): Tree =
          if (idx == codePath.length - 1) one
          else
            ModuleTree(
              Empty,
              codePath(idx),
              Empty,
              IArray(pack(idx + 1)),
              NoComments,
              QualifiedName(codePath.take(idx)),
              isOverride = false,
            )
        pack(0)
      }

    def combineContainerTrees[C <: ContainerTree](c: C): C = {
      val combinedMembers = c.index.flatMapToIArray {
        case (_, sameName) =>
          sameName.partitionCollect { case x: ContainerTree => combineContainerTrees(x) } match {
            case (Empty, rest) =>
              rest
            case (IArray.exactlyOne(onePkg), rest) =>
              onePkg +: rest
            case (IArray.headTail(head, tail), rest) =>
              combineContainerTrees(head.withMembers(head.members ++ tail.flatMap(_.members))) +: rest
          }
      }

      c.withMembers(combinedMembers).asInstanceOf[C]
    }

    val asPackageName = Name("imported")
    val scope         = new TreeScope.Root(Name.typings, asPackageName, Map.empty, logging.stdout, false)

    val combined = combineContainerTrees(
      PackageTree(Empty, asPackageName, inContainers, NoComments, QualifiedName(Empty)),
    )

    val asPackageComplete =
      Sorter.visitPackageTree(scope)(combined)
    val printed =
      Printer(scope, new ParentsResolver, asPackageComplete, Name.typings, Versions.Scala213)
    files.sync(printed, dumpSourceTo, deleteUnknowns = true, soft = true)
  }

  Json.persist[IArray[Tree]](dumpJsonTo)(flatten(allJs))

  %("git", "add", dumpSourceTo, dumpJsonTo)(projectRoot)

  private def toParamTrees(paramSymbols: Seq[Symbol]): IArray[ParamTree] =
    IArray
      .fromTraversable(paramSymbols)
      .map(ps =>
        ParamTree(
          name       = Name(processName(ps.name)),
          isImplicit = ps.isImplicit,
          isVal      = false,
          tpe        = toTypeRefForce(ps.asInstanceOf[MethodSymbol].infoType),
          default    = NotImplemented,
          comments   = NoComments,
        ),
      )

  lazy val Anies = Set(TypeRef.Any, TypeRef.AnyRef)

  def toTree(sym: Symbol): Option[Tree] =
    sym match {
      case obj: ObjectSymbol =>
        val name     = Name(processName(obj.name))
        val codePath = QualifiedName(processName(obj.path))

        val parents: IArray[TypeRef] =
          (toTypeRef(obj.infoType) match {
            case Left(unknownType) =>
              sys.error(unknownType.toString)
            case Right(TypeRef.Intersection(types, _)) => types
            case Right(tpe)                            => IArray(tpe)
          }).filter(_.typeName =/= codePath).filterNot(Anies)

        val members = IArray.fromTraversable(obj.children).mapNotNone(toTree)
        Some(ModuleTree(Empty, name, parents, members, NoComments, codePath, isOverride = false))

      case x: AliasSymbol =>
        val name     = Name(processName(x.name))
        val codePath = QualifiedName(processName(x.symbolInfo.owner.path)) + name
        val (tparams, alias) = x.infoType match {
          case PolyType(typeRef, symbols) =>
            (toTypeParameterTrees(symbols), toTypeRefForce(typeRef))
          case other => (Empty, toTypeRefForce(other))
        }
        val ref = TypeAliasTree(name, tparams, alias, NoComments, codePath)
        Some(ref)

      case c: ClassSymbol if c.name != "<refinement>" =>
        def go(infoType: Type, tparams: IArray[TypeParamTree]): InheritanceTree =
          infoType match {
            case ClassInfoType(_, parentTypes) =>
              val codePath = QualifiedName(processName(c.path))
              val parents =
                IArray.fromTraversable(parentTypes).map(toTypeRefForce).filter(_.typeName =/= codePath).filterNot(Anies)
              val name = Name(processName(c.name))

              val classType =
                if (c.isTrait) ClassType.Trait
                else if (c.isAbstract) ClassType.AbstractClass
                else ClassType.Class

              val (ctors, _, members) =
                IArray
                  .fromTraversable(c.children)
                  .mapNotNone(toTree)
                  .partitionCollect2(
                    { case x: CtorTree => x }, { case x if x.name.unescaped.contains("$") => null },
                  )

              val membersWithoutAccessors = {
                val byName: Map[String, IArray[Tree]] =
                  members.groupBy(_.name.unescaped.replace("_=", ""))

                byName.flatMapToIArray {
                  case (_, members) =>
                    val (getters, setters, _) = members.partitionCollect2(
                      { case x: FieldTree                                                                      => x },
                      { case x: MethodTree if x.params.flatten.length === 1 && x.name.unescaped.endsWith("_=") => x },
                    )

                    if (getters.nonEmpty && setters.nonEmpty) {
                      IArray(getters.head.copy(isReadOnly = false))
                    } else members.distinct
                }
              }

              if (c.isModule)
                ModuleTree(
                  annotations = Empty,
                  name        = name,
                  parents     = parents,
                  members     = membersWithoutAccessors,
                  comments    = NoComments,
                  codePath    = codePath,
                  isOverride  = false,
                )
              else
                ClassTree(
                  isImplicit  = c.isImplicit,
                  annotations = Empty,
                  name        = name,
                  tparams     = tparams,
                  parents     = parents,
                  ctors       = ctors,
                  members     = membersWithoutAccessors,
                  classType   = classType,
                  isSealed    = c.isSealed,
                  comments    = NoComments,
                  codePath    = codePath,
                )

            case PolyType(inner, tparams) =>
              val tps = toTypeParameterTrees(tparams)
              go(inner, tps)
            case other =>
              sys.error(s"unexpected $other")
          }

        val cls = go(c.infoType, Empty)

        val JapgollyComponent = QualifiedName("japgolly.scalajs.react.raw.React.Component")

        val patched = cls match {
          case cls @ ClassTree(_, _, _, _, _, _, _, _, _, _, JapgollyComponent) =>
            // resolving type aliases within classes is a bucket of complexity we don't need in the converter :)
            object x extends TreeTransformation {
              override def leaveTypeRef(scope: TreeScope)(ref: TypeRef): TypeRef =
                ref.name.unescaped match {
                  case "Props" =>
                    TypeRef.Intersection(
                      IArray(
                        TypeRef(Name("P")),
                        TypeRef(QualifiedName("japgolly.scalajs.react.raw.PropsWithChildren")),
                      ),
                      NoComments,
                    )
                  case "State" =>
                    TypeRef(Name("S"))
                  case _ => ref
                }
            }
            x.visitClassTree(new TreeScope.Root(Name.dummy, Name.dummy, Map.empty, logging.stdout, false))(cls)
          case _ => cls
        }

        Some(patched)

      case m: MethodSymbol =>
        def go(
            infoType: Type,
            tparams:  IArray[TypeParamTree],
        ): (TypeRef, IArray[TypeParamTree], IArray[ParamTree]) =
          infoType match {
            case trt: TypeRefType =>
              (toTypeRefForce(trt), Empty, Empty)
            case SingleType(_, symbol) =>
              (TypeRef.Singleton(TypeRef(QualifiedName(processName(symbol.path)))), Empty, Empty)
            case ExistentialType(typeRef, symbols) =>
              val existentialNames = symbols.map(s => Name(processName(s.name))).toSet
              val ret              = toTypeRefForce(typeRef)

              val targs = ret.targs.map {
                case tp if existentialNames(tp.name) => TypeRef.Wildcard
                case tp                              => tp
              }

              (ret.copy(targs = targs), Empty, Empty)
            case NullaryMethodType(resultType) =>
              (toTypeRefForce(resultType), tparams, Empty)
            case MethodType(NoPrefixType, _) =>
              (TypeRef.JsAny, Empty, Empty)
            case MethodType(resultType, paramSymbols) =>
              val params = toParamTrees(paramSymbols)
              (toTypeRefForce(resultType), tparams, params)
            case PolyType(inner, tparams) =>
              val tps = toTypeParameterTrees(tparams)
              go(inner, tps)
            case x: ConstantType =>
              (TypeRef.NumberLiteral(x.toString), Empty, Empty)
            case AnnotatedType(typeRef, _) =>
              go(typeRef, tparams)
            case NoType =>
              (TypeRef.Nothing, Empty, Empty)
            case ThisType(_) =>
              (TypeRef.JsAny, Empty, Empty)
            case RefinedType(_: ClassSymbol, _) =>
              (TypeRef.JsAny, Empty, Empty)
            case other =>
              sys.error(s"Unexpected $other")
          }

        val (ret, tparams, params) = go(m.infoType, Empty)
        val codePath               = QualifiedName(processName(m.path))
        val name                   = Name(processName(m.name))

        val tree = if (m.isMethod && !(m.isAccessor && params.isEmpty)) {
          val level =
            if (m.isPrivate) ProtectionLevel.Private
            else if (m.isProtected) ProtectionLevel.Protected
            else ProtectionLevel.Default

          if (name.unescaped === "this")
            CtorTree(level, params, NoComments)
          else
            MethodTree(
              annotations = Empty,
              level       = level,
              name        = name,
              tparams     = tparams,
              params      = IArray(params),
              impl        = ExprTree.native,
              resultType  = ret,
              isOverride  = m.isOverride,
              comments    = NoComments,
              codePath    = codePath,
              isImplicit  = m.isImplicit,
            )
        } else
          FieldTree(
            annotations = Empty,
            name        = name,
            tpe         = ret,
            impl        = ExprTree.native,
            isReadOnly  = !m.isMutable,
            isOverride  = m.isOverride,
            comments    = NoComments,
            codePath    = codePath,
          )
        Some(tree)

      case _ =>
        None
    }

  def toTypeParameterTrees(tparams: Seq[TypeSymbol]): IArray[TypeParamTree] =
    IArray.fromTraversable(tparams).map { tp =>
      TypeParamTree(
        name        = Name(processName(tp.symbolInfo.name)),
        params      = Empty,
        upperBound  = None,
        comments    = NoComments,
        ignoreBound = true,
      )
    }

  def toTypeRefForce(tpe: Type): TypeRef = // todo: not sure why even bother with `Either` in the first place
    toTypeRef(tpe) match {
      case Left(unexpected) => sys.error(s"Unexpected: $unexpected")
      case Right(tr)        => tr
    }

  def sequence[L <: AnyRef, R <: AnyRef](ts: IArray[Either[L, R]]): Either[L, IArray[R]] =
    ts.partitionCollect2({ case Left(left) => left }, { case Right(right) => right }) match {
      case (Empty, rights, _) => Right(rights)
      case (lefts, _, _)      => Left(lefts.head)
    }

  def toTypeRef(tpe: Type): Either[Type, TypeRef] =
    tpe match {
      case NoType =>
        Left(NoType)
      case NoPrefixType =>
        Left(NoPrefixType)
      case ThisType(_) =>
        Right(TypeRef.ThisType(NoComments))
      case ConstantType(constant) =>
        constant match {
          case x: String  => Right(TypeRef.StringLiteral(x))
          case x: Double  => Right(TypeRef.NumberLiteral(x.toString))
          case x: Int     => Right(TypeRef.NumberLiteral(x.toString))
          case x: Boolean => Right(TypeRef.BooleanLiteral(x.toString))
          case null => Right(TypeRef.Null)
          case _    => Left(tpe)
        }
      case SingleType(NoPrefixType, _) => // todo
        Right(TypeRef.JsAny)
      case SingleType(typeRef, _) =>
        toTypeRef(typeRef).map(TypeRef.Singleton(_))
      case NullaryMethodType(resultType) =>
        toTypeRef(resultType)
      case TypeRefType(prefix, symbol, typeArgs) =>
        val qname = (prefix, symbol) match {
          case (ThisType(prefixSym), AliasSymbol(aliasSym)) =>
            QualifiedName(processName(prefixSym.path)) + Name(processName(aliasSym.name))
          case _ =>
            QualifiedName(processName(symbol.path))
        }

        val targs = IArray.fromTraversable(typeArgs).map(toTypeRefForce)
        qname.parts match {
          case IArray.last(Name("_"))                                             => Right(TypeRef.Wildcard)
          case IArray.last(Name("|"))                                             => Right(TypeRef.Union(targs, NoComments, sort = false))
          case IArray.last(Name("<repeated>"))                                    => Right(TypeRef.Union(targs, NoComments, sort = false))
          case IArray.last(Name("<intersection>"))                                => Right(TypeRef.Intersection(targs, NoComments))
          case IArray.exactlyThree(Name("scala"), Name("Predef"), Name("String")) => Right(TypeRef.String)
          case _                                                                  => Right(TypeRef(qname, targs, NoComments))
        }

      case MethodType(resultType, paramSymbols) =>
        val params: IArray[Either[Type, TypeRef]] =
          IArray.fromTraversable(paramSymbols).map {
            case symbol: MethodSymbol => toTypeRef(symbol.infoType)
            case other => sys.error(s"Unexpected $other")
          }
        for {
          ret <- toTypeRef(resultType)
          ps <- sequence(params)
        } yield TypeRef.JsFunction(None, ps, ret, NoComments)

      case AnnotatedType(typeRef, _) =>
        toTypeRef(typeRef)
      case AnnotatedWithSelfType(typeRef, _, _) =>
        toTypeRef(typeRef)
      case ExistentialType(typeRef, _) =>
        toTypeRef(typeRef)
      case RefinedType(_, typeRefs) =>
        sequence(IArray.fromTraversable(typeRefs).map(toTypeRef)).map(types => TypeRef.Intersection(types, NoComments))
      // todo: from here and out - whatever. we have enough
      case PolyType(_, _) =>
        Right(TypeRef.JsAny)
      case TypeBoundsType(_, _)           => Left(tpe)
      case ClassInfoType(_, _)            => Left(tpe)
      case PolyTypeWithCons(_, _, _)      => Left(tpe)
      case ClassInfoTypeWithCons(_, _, _) => Left(tpe)
      //      case TypeSymbol(symbolInfo) =>
      //      case AliasSymbol(symbolInfo) =>
      //      case ObjectSymbol(symbolInfo) =>
      //      case MethodSymbol(symbolInfo, aliasRef) =>
      //      case ClassSymbol(symbolInfo, thisTypeRef) =>
    }

  // copied from `ScalaSigPrinter`. tweaked slightly
  object processName {
    val _syms = Map(
      "\\$bar" -> "|",
      "\\$tilde" -> "~",
      "\\$bang" -> "!",
      "\\$up" -> "^",
      "\\$plus" -> "+",
      "\\$minus" -> "-",
      "\\$eq" -> "=",
      "\\$less" -> "<",
      "\\$times" -> "*",
      "\\$div" -> "/",
      "\\$bslash" -> "\\\\",
      "\\$greater" -> ">",
      "\\$qmark" -> "?",
      "\\$percent" -> "%",
      "\\$amp" -> "&",
      "\\$colon" -> ":",
      "\\$u2192" -> "→",
      "\\$hash" -> "#",
    )
    val pattern            = Pattern.compile(_syms.keys.foldLeft("")((x, y) => if (x == "") y else x + "|" + y))
    val placeholderPattern = "_\\$(\\d)+"

    private def stripPrivatePrefix(name: String) = {
      val i = name.lastIndexOf("$$")
      if (i > 0) name.substring(i + 2) else name
    }

    def apply(name: String) = {
      val stripped = stripPrivatePrefix(name)
      val m        = pattern.matcher(stripped)
      var temp     = stripped
      while (m.find) {
        val key = m.group
        val re  = "\\" + key
        temp = temp.replaceAll(re, _syms(re))
      }
      val result = temp.replaceAll(placeholderPattern, "_")
      NameTransformer
        .decode(result)
        // local adaptations below
        .replace(".package", "") // we just flatten package objects anyway
        .trim // didnt bother to figure out why this was needed
    }
  }
}
