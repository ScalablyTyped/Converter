package org.scalablytyped.converter.internal
package scalajs

import scala.util.hashing.MurmurHash3.productHash

sealed trait Tree extends Product with Serializable {
  val name:     Name
  val comments: Comments
  override def canEqual(that: Any): Boolean = that.## == ##
  override lazy val hashCode: Int = productHash(this)
}

sealed trait HasCodePath {
  val codePath: QualifiedName
}

sealed trait ContainerTree extends Tree with HasCodePath {
  val annotations: IArray[Annotation]
  val members:     IArray[Tree]

  def withMembers(members: IArray[Tree]): ContainerTree =
    this match {
      case x: PackageTree => x.copy(members = members)
      case x: ModuleTree  => x.copy(members = members)
    }

  lazy val index: Map[Name, IArray[Tree]] =
    members.groupBy(_.name)
}

sealed trait InheritanceTree extends Tree with HasCodePath {
  def annotations: IArray[Annotation]
  def isScalaJsDefined:  Boolean = annotations contains Annotation.ScalaJSDefined
  def receivesCompanion: Boolean = isScalaJsDefined || comments.has[Markers.CouldBeScalaJsDefined.type]
  val index: Map[Name, IArray[Tree]]

  def isNative: Boolean =
    annotations.exists {
      case Annotation.JsNative       => true
      case Annotation.ScalaJSDefined => true
      case _                         => false
    }
}

final case class PackageTree(
    annotations: IArray[Annotation],
    name:        Name,
    members:     IArray[Tree],
    comments:    Comments,
    codePath:    QualifiedName,
) extends ContainerTree

object PackageTree {
  implicit object PackageTreeKey extends Key[PackageTree] {
    override type Id = Name
    override def apply(t: PackageTree): Id = t.name
  }
}

final case class ClassTree(
    isImplicit:  Boolean,
    annotations: IArray[Annotation],
    name:        Name,
    tparams:     IArray[TypeParamTree],
    parents:     IArray[TypeRef],
    ctors:       IArray[CtorTree],
    members:     IArray[Tree],
    classType:   ClassType,
    isSealed:    Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
) extends InheritanceTree {
  lazy val index: Map[Name, IArray[Tree]] =
    members.groupBy(_.name)

  def renamed(newName: Name): ClassTree = {
    val anns =
      (Annotation.classRenamedFrom(name)(annotations), classType) match {
        case (as, ClassType.Trait) => as.filterNot(_.isInstanceOf[Annotation.JsName])
        case (anns, _)             => anns
      }

    copy(
      name        = newName,
      annotations = anns,
      codePath    = QualifiedName(codePath.parts.init :+ newName),
    )
  }

  def withSuffix[T: ToSuffix](t: T): ClassTree =
    renamed(name.withSuffix(t))
}

final case class ModuleTree(
    annotations: IArray[Annotation],
    name:        Name,
    parents:     IArray[TypeRef],
    members:     IArray[Tree],
    comments:    Comments,
    codePath:    QualifiedName,
    isOverride:  Boolean,
) extends ContainerTree
    with InheritanceTree

final case class TypeAliasTree(
    name:     Name,
    tparams:  IArray[TypeParamTree],
    alias:    TypeRef,
    comments: Comments,
    codePath: QualifiedName,
) extends Tree
    with HasCodePath

sealed trait MemberTree extends Tree with HasCodePath {
  val isOverride:  Boolean
  val annotations: IArray[Annotation]
  def withCodePath(newCodePath: QualifiedName): MemberTree
  def renamed(newName:          Name):          MemberTree
  def originalName: Name
}

final case class FieldTree(
    annotations: IArray[Annotation],
    name:        Name,
    tpe:         TypeRef,
    impl:        ImplTree,
    isReadOnly:  Boolean,
    isOverride:  Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
) extends MemberTree {

  def withSuffix[T: ToSuffix](t: T): FieldTree =
    renamed(name.withSuffix(t))

  def originalName: Name =
    annotations.collectFirst { case Annotation.JsName(name) => name }.getOrElse(name)

  def renamed(newName: Name): FieldTree =
    copy(
      name        = newName,
      annotations = Annotation.renamedFrom(name)(annotations),
      isOverride  = false,
      codePath    = QualifiedName(codePath.parts.init :+ newName),
    )

  def withCodePath(newCodePath: QualifiedName): FieldTree = copy(codePath = newCodePath)
}

final case class MethodTree(
    annotations: IArray[Annotation],
    level:       ProtectionLevel,
    name:        Name,
    tparams:     IArray[TypeParamTree],
    params:      IArray[IArray[ParamTree]],
    impl:        ImplTree,
    resultType:  TypeRef,
    isOverride:  Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
    isImplicit:  Boolean,
) extends MemberTree {
  def withSuffix[T: ToSuffix](t: T): MethodTree =
    renamed(name.withSuffix(t))

  def originalName: Name =
    annotations.collectFirst { case Annotation.JsName(name) => name }.getOrElse(name)

  def renamed(newName: Name): MethodTree =
    copy(
      name        = newName,
      annotations = Annotation.renamedFrom(name)(annotations),
      isOverride  = false,
      codePath    = QualifiedName(codePath.parts.init :+ newName),
    )

  def withCodePath(newCodePath: QualifiedName): MethodTree = copy(codePath = newCodePath)
}

final case class CtorTree(level: ProtectionLevel, params: IArray[ParamTree], comments: Comments) extends Tree {
  override val name = Name.CONSTRUCTOR
}

object CtorTree {
  val defaultPublic    = CtorTree(ProtectionLevel.Default, IArray(), NoComments)
  val defaultProtected = CtorTree(ProtectionLevel.Protected, IArray(), NoComments)
}

final case class TypeParamTree(
    name:        Name,
    params:      IArray[TypeParamTree],
    upperBound:  Option[TypeRef],
    comments:    Comments,
    ignoreBound: Boolean, // we ignore all bounds for code coming from typescript
) extends Tree

object TypeParamTree {
  def asTypeArgs(tps: IArray[TypeParamTree]): IArray[TypeRef] =
    tps.map(x => TypeRef(x.name))

  implicit val TypeParamToSuffix: ToSuffix[TypeParamTree] = tp => ToSuffix(tp.name) +? tp.upperBound
}

final case class ParamTree(
    name:       Name,
    isImplicit: Boolean,
    isVal:      Boolean,
    tpe:        TypeRef,
    default:    ImplTree,
    comments:   Comments,
) extends Tree

final case class TypeRef(typeName: QualifiedName, targs: IArray[TypeRef], comments: Comments) extends Tree {
  override val name: Name = typeName.parts.last

  def withOptional(optional: Boolean): TypeRef =
    if (optional) TypeRef.UndefOr(this) else this

  def withComments(cs: Comments): TypeRef =
    if (cs.cs.isEmpty) this else TypeRef(typeName, targs, comments ++ cs)
}

object TypeRef {
  def apply(n: Name): TypeRef =
    TypeRef(QualifiedName(IArray(n)), Empty, NoComments)
  def apply(qn: QualifiedName): TypeRef =
    TypeRef(qn, Empty, NoComments)

  def stripTargs(tr: TypeRef): TypeRef = tr.copy(targs = tr.targs.map(_ => TypeRef.Any))

  val Wildcard     = TypeRef(QualifiedName.WILDCARD, Empty, NoComments)
  val ScalaAny     = TypeRef(QualifiedName.ScalaAny, Empty, NoComments)
  val Any          = TypeRef(QualifiedName.Any, Empty, NoComments)
  val AnyVal       = TypeRef(QualifiedName.AnyVal, Empty, NoComments)
  val BigInt       = TypeRef(QualifiedName.BigInt, Empty, NoComments)
  val Boolean      = TypeRef(QualifiedName.Boolean, Empty, NoComments)
  val Double       = TypeRef(QualifiedName.Double, Empty, NoComments)
  val Dynamic      = TypeRef(QualifiedName.Dynamic, Empty, NoComments)
  val Int          = TypeRef(QualifiedName.Int, Empty, NoComments)
  val Long         = TypeRef(QualifiedName.Long, Empty, NoComments)
  val Nothing      = TypeRef(QualifiedName.Nothing, Empty, NoComments)
  val Null         = TypeRef(QualifiedName.Null, Empty, NoComments)
  val Object       = TypeRef(QualifiedName.Object, Empty, NoComments)
  val String       = TypeRef(QualifiedName.String, Empty, NoComments)
  val Symbol       = TypeRef(QualifiedName.Symbol, Empty, NoComments)
  val Unit         = TypeRef(QualifiedName.Unit, Empty, NoComments)
  val FunctionBase = TypeRef(QualifiedName.Function, Empty, NoComments)

  /* we represent `js.UndefOr` as this fake type ref inside a union type. Note that t can also appear on it's own */
  val undefined = TypeRef(QualifiedName.UNDEFINED, Empty, NoComments)

  val Primitive = Set(Double, Int, Long, Boolean, Unit, Nothing)

  def StringDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.StringDictionary, IArray(typeParam), comments)

  def NumberDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.NumberDictionary, IArray(typeParam), comments)

  object TopLevel {
    def apply(tr: TypeRef): TypeRef =
      TypeRef(QualifiedName.TopLevel, IArray(tr), NoComments)

    def unapply(tr: TypeRef): Option[TypeRef] =
      tr match {
        case TypeRef(QualifiedName.TopLevel, IArray.exactlyOne(typeParam), NoComments) => Some(typeParam)
        case _                                                                         => None
      }
  }

  object Function {
    def apply(thisType: Option[TypeRef], typeParams: IArray[TypeRef], resType: TypeRef, comments: Comments): TypeRef = {
      val rewriteRepeated: IArray[TypeRef] =
        typeParams.lastOption match {
          case Some(Repeated(underlying, _)) =>
            val commented = underlying.withComments(Comments(Comment("/* repeated */")))
            typeParams.dropRight(1) :+ commented
          case _ =>
            typeParams
        }

      val finalTparams = IArray.fromOption(thisType) ++ (rewriteRepeated :+ resType)

      TypeRef(QualifiedName.FunctionArity(thisType.isDefined, typeParams.length), finalTparams, comments)
    }

    private val F = "Function(\\d+)".r

    def unapply(tr: TypeRef): Option[(IArray[TypeRef], TypeRef)] =
      if (tr.typeName.startsWith(QualifiedName.scala_js) && tr.typeName.parts.length === QualifiedName.scala_js.parts.length + 1) {
        tr.typeName.parts.last.unescaped match {
          case F(_) => Some((tr.targs.init, tr.targs.last))
          case _    => None
        }
      } else None
  }

  object ScalaFunction {
    def apply(typeParams: IArray[TypeRef], resType: TypeRef, comments: Comments): TypeRef = {
      val rewriteRepeated: IArray[TypeRef] =
        typeParams.lastOption match {
          case Some(Repeated(underlying, _)) =>
            val commented = underlying.withComments(Comments(Comment("/* repeated */")))
            typeParams.dropRight(1) :+ commented
          case _ =>
            typeParams
        }

      val finalTparams = rewriteRepeated :+ resType

      TypeRef(QualifiedName.ScalaFunctionArity(typeParams.length), finalTparams, comments)
    }

    private val F = "Function(\\d+)".r

    def unapply(tr: TypeRef): Option[(IArray[TypeRef], TypeRef)] =
      tr.typeName.parts match {
        case IArray.exactlyTwo(Name.scala, f) =>
          f.unescaped match {
            case F(_) => Some((tr.targs.init, tr.targs.last))
            case _    => None
          }
        case _ => None
      }

    def is(qn: QualifiedName): Boolean =
      qn.parts match {
        case IArray.exactlyTwo(Name.scala, f) =>
          f.unescaped match {
            case F(_) => true
            case _    => false
          }
        case _ => false
      }
  }

  def Tuple(typeParams: IArray[TypeRef]): TypeRef =
    typeParams match {
      case IArray.Empty                   => TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments)
      case IArray.exactlyOne(one)         => TypeRef(QualifiedName.Array, IArray(one), NoComments)
      case catch22 if catch22.length > 22 => TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments)
      case _                              => TypeRef(QualifiedName.Tuple(typeParams.length), typeParams, NoComments)
    }

  object Intersection {
    private def flattened(types: IArray[TypeRef]): IArray[TypeRef] =
      types.flatMap {
        case Intersection(inner, _) => inner
        case other                  => IArray(other)
      }

    def apply(types: IArray[TypeRef], comments: Comments): TypeRef = {
      val base: IArray[TypeRef] =
        flattened(types).distinct.partitionCollect { case TypeRef.Wildcard => TypeRef.Wildcard } match {
          // keep wildcard only if there is nothing else
          case (wildcards, Empty) => wildcards
          case (_, rest)          => rest
        }

      val ret = base match {
        case IArray.Empty           => TypeRef.Nothing
        case IArray.exactlyOne(one) => one
        case more                   => TypeRef(QualifiedName.INTERSECTION, more, NoComments)
      }

      ret.withComments(comments)
    }

    def unapply(typeRef: TypeRef): Option[(IArray[TypeRef], Comments)] =
      typeRef match {
        case TypeRef(QualifiedName.INTERSECTION, types, cs) =>
          Some((types, cs))

        case _ => None
      }
  }

  object UndefOr {
    def apply(tpe: TypeRef): TypeRef =
      Union(IArray(undefined, tpe), NoComments, sort = false)

    def unapply(typeRef: TypeRef): Option[(TypeRef, Comments)] =
      typeRef match {
        case Union(types, cs) if types.contains(undefined) =>
          val rest = types.filterNot(x => x === undefined || x === TypeRef.Nothing) match {
            case IArray.Empty           => TypeRef.Nothing
            case IArray.exactlyOne(one) => one
            case more                   => Union(more, NoComments, sort = false)
          }
          Some((rest, cs))
        case _ => None
      }
  }

  object Union {
    private def flatten(types: IArray[TypeRef]): IArray[TypeRef] =
      types.flatMap {
        case TypeRef(QualifiedName.UNION, inner, _) => flatten(inner)
        case other                                  => IArray(other)
      }

    /**
      * @param sort matters surprisingly much, since union types dont commute.
      * The best would be to always sort, but it's difficult because of subtyping.
      * What we do for now is that when we construct a union type it's sorted (for consistent builds),
      *  and when we encounter an existing we don't change it
      */
    def apply(types: IArray[TypeRef], comments: Comments, sort: Boolean): TypeRef = {
      val flattened: IArray[TypeRef] =
        flatten(types) match {
          case toSort if sort => toSort.sortBy(_.typeName.parts.last.unescaped)
          case otherwise      => otherwise
        }

      /* "a" | "a" | Foo[A] | Foo[B] => "a" | Foo[A | B] */
      val compressed: IArray[TypeRef] = {
        val byName = flattened.filterNot(tr => Name.Internal(tr.name)).groupBy(_.typeName)

        flattened.zipWithIndex.mapNotNone {
          case (tr, idx) =>
            byName.get(tr.typeName) match {
              case Some(more) if more.length > 1 =>
                val isFirst = flattened.indexWhere(_.typeName === tr.typeName) === idx
                if (isFirst) Some(tr.copy(targs = more.map(_.targs).transpose.map(Union(_, NoComments, sort = true))))
                else None
              case _ => Some(tr)
            }
        }.distinct
      }

      val ret = compressed match {
        case Empty                  => TypeRef.Nothing
        case IArray.exactlyOne(one) => one
        case more                   => TypeRef(QualifiedName.UNION, more, NoComments)
      }
      ret.withComments(comments)
    }

    def unapply(typeRef: TypeRef): Option[(IArray[TypeRef], Comments)] =
      typeRef match {
        case TypeRef(QualifiedName.UNION, types, comments) =>
          Some((types, comments))

        case _ => None
      }
  }
  abstract class LiteralCompanion(qname: QualifiedName) {
    def apply(underlying: String): TypeRef =
      TypeRef(qname, IArray(TypeRef(QualifiedName(IArray(Name(underlying))), Empty, NoComments)), NoComments)

    def unapply(typeRef: TypeRef): Option[String] =
      typeRef match {
        case TypeRef(`qname`, IArray.exactlyOne(TypeRef(QualifiedName(IArray.exactlyOne(name)), Empty, _)), _) =>
          Some(name.unescaped)

        case _ => None
      }
  }
  object StringLiteral extends LiteralCompanion(QualifiedName.STRING_LITERAL)
  object NumberLiteral extends LiteralCompanion(QualifiedName.NUMBER_LITERAL)
  object BooleanLiteral extends LiteralCompanion(QualifiedName.BOOLEAN_LITERAL)

  object Repeated {
    def apply(underlying: TypeRef, comments: Comments): TypeRef =
      TypeRef(QualifiedName.REPEATED, IArray(underlying), comments)

    def unapply(typeRef: TypeRef): Option[(TypeRef, Comments)] =
      typeRef match {
        case TypeRef(QualifiedName.REPEATED, IArray.exactlyOne(underlying), comments) =>
          Some((underlying, comments))

        case _ => None
      }
  }

  object Singleton {
    def apply(underlying: TypeRef): TypeRef =
      TypeRef(QualifiedName.SINGLETON, IArray(underlying), NoComments)

    def unapply(typeRef: TypeRef): Option[TypeRef] =
      typeRef match {
        case TypeRef(QualifiedName.SINGLETON, IArray.exactlyOne(underlying), _) =>
          Some(underlying)

        case _ => None
      }
  }

  object ThisType {
    def apply(comments: Comments): TypeRef =
      TypeRef(QualifiedName.THIS, Empty, comments)

    def unapply(typeRef: TypeRef): Option[Comments] =
      typeRef match {
        case TypeRef(QualifiedName.THIS, _, comments) =>
          Some(comments)
        case _ => None
      }
  }

  implicit val TypeRefSuffix: ToSuffix[TypeRef] =
    t => ToSuffix(t.typeName) ++ t.targs

  implicit val TypeRefOrdering: Ordering[TypeRef] =
    Ordering.by[TypeRef, String](Printer.formatTypeRef(0))
}

sealed trait ImplTree extends Tree {
  override val name:     Name     = Name("ImplTree")
  override val comments: Comments = NoComments
}

case object NotImplemented extends ImplTree
sealed trait ExprTree extends ImplTree

object ExprTree {

  val undefined = Ref(QualifiedName.scala_js + Name("undefined"))
  val native    = Ref(QualifiedName.scala_js + Name("native"))

  case object Null extends ExprTree
  case class BinaryOp(one:          ExprTree, op: String, two: ExprTree) extends ExprTree
  case class Block(expressions:     IArray[ExprTree]) extends ExprTree
  case class Call(function:         ExprTree, params: IArray[IArray[Arg]]) extends ExprTree
  case class `:_*`(e:               ExprTree) extends ExprTree
  case class If(pred:               ExprTree, ifTrue: ExprTree, ifFalse: Option[ExprTree]) extends ExprTree
  case class Lambda(params:         IArray[ParamTree], body: ExprTree) extends ExprTree
  case class New(expr:              TypeRef, params: IArray[ExprTree]) extends ExprTree
  case class Ref(value:             QualifiedName) extends ExprTree
  case class Select(from:           ExprTree, path: Name) extends ExprTree
  case class TApply(ref:            ExprTree, targs: IArray[TypeRef]) extends ExprTree
  case class Unary(op:              String, expr: ExprTree) extends ExprTree
  case class Val(override val name: Name, value: ExprTree) extends ExprTree
  case class Throw(expr:            ExprTree) extends ExprTree

  def InstanceOf(target: ExprTree, of: TypeRef): ExprTree =
    TApply(Select(target, Name("isInstanceOf")), IArray(of))

  object Cast {
    def apply(target: ExprTree, of: TypeRef): ExprTree =
      TApply(Select(target, Name("asInstanceOf")), IArray(of))

    def unapply(expr: ExprTree): Option[(ExprTree, TypeRef)] =
      expr match {
        case TApply(Select(target, Name("asInstanceOf")), IArray.exactlyOne(of)) => Some((target, of))
        case _                                                                   => None
      }
  }
  sealed trait Lit extends ExprTree
  case class BooleanLit(value: Boolean) extends Lit
  case class NumberLit(value:  String) extends Lit
  case class StringLit(value:  String) extends Lit

  sealed trait Arg extends ExprTree
  object Arg {
    case class Named(override val name: Name, expr: ExprTree) extends Arg
    case class Pos(expr:                ExprTree) extends Arg
    case class Variable(expr:           ExprTree) extends Arg
    implicit def fromExpr(expr: ExprTree):         Arg = Pos(expr)
    implicit def fromTuple(t:   (Name, ExprTree)): Arg = Named(t._1, t._2)
  }

  object Block {
    def apply(es:   ExprTree*)         = new Block(IArray.fromTraversable(es))
    def flatten(es: IArray[ExprTree]*) = new Block(IArray.fromTraversable(es).flatten)
  }

  object Ref {
    def apply(name: Name): Ref =
      apply(QualifiedName(IArray(name)))

    def apply(tr: TypeRef): ExprTree =
      if (tr.targs.isEmpty) apply(tr.typeName)
      else TApply(Ref(tr.typeName), tr.targs)
  }
}
