package com.olvind.tso
package scalajs

import scala.util.hashing.MurmurHash3.productHash

sealed trait Tree extends Product with Serializable {
  val name:     Name
  val comments: Comments

  override lazy val hashCode: Int = productHash(this)
}

sealed trait HasCodePath {
  val codePath: QualifiedName
}

sealed trait ContainerTree extends Tree with HasCodePath {
  val annotations: Seq[ClassAnnotation]
  val members:     Seq[Tree]

  def withMembers(members: Seq[Tree]): ContainerTree =
    this match {
      case x: PackageTree => x.copy(members = members)
      case x: ModuleTree  => x.copy(members = members)
    }

  lazy val index: Map[Name, Seq[Tree]] =
    members.groupBy(_.name)
}

sealed trait InheritanceTree extends Tree with HasCodePath {
  def annotations: Seq[ClassAnnotation]
  def isScalaJsDefined: Boolean = annotations contains Annotation.ScalaJSDefined
  val index: Map[Name, Seq[Tree]]

  def isNative: Boolean = annotations.exists {
    case Annotation.JsNative       => true
    case Annotation.ScalaJSDefined => true
    case _                         => false
  }
}

final case class PackageTree(
    annotations: Seq[ClassAnnotation],
    name:        Name,
    members:     Seq[Tree],
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
    annotations: Seq[ClassAnnotation],
    name:        Name,
    tparams:     Seq[TypeParamTree],
    parents:     Seq[TypeRef],
    ctors:       Seq[CtorTree],
    members:     Seq[Tree],
    classType:   ClassType,
    isSealed:    Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
) extends InheritanceTree {
  lazy val index: Map[Name, Seq[Tree]] =
    members.groupBy(_.name)

  def renamed(newName: Name): ClassTree =
    copy(
      name        = newName,
      annotations = Annotation.classRenamedFrom(name)(annotations),
      codePath    = QualifiedName(codePath.parts.init :+ newName),
    )

  def withSuffix[T: ToSuffix](t: T): ClassTree =
    renamed(name withSuffix t)
}

final case class ModuleTree(
    annotations: Seq[ClassAnnotation],
    name:        Name,
    parents:     Seq[TypeRef],
    members:     Seq[Tree],
    comments:    Comments,
    codePath:    QualifiedName,
) extends ContainerTree
    with InheritanceTree {}

final case class TypeAliasTree(
    name:     Name,
    tparams:  Seq[TypeParamTree],
    alias:    TypeRef,
    comments: Comments,
    codePath: QualifiedName,
) extends Tree
    with HasCodePath

sealed trait MemberTree extends Tree {
  val isOverride: Boolean
  val codePath:   QualifiedName
  def withCodePath(newCodePath: QualifiedName): MemberTree
}

sealed trait MemberImpl
object MemberImpl {
  case object Native extends MemberImpl
  case object NotImplemented extends MemberImpl
  case object Undefined extends MemberImpl
  final case class Custom(impl: String) extends MemberImpl
}

final case class FieldTree(
    annotations: Seq[MemberAnnotation],
    name:        Name,
    tpe:         TypeRef,
    impl:        MemberImpl,
    isReadOnly:  Boolean,
    isOverride:  Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
) extends MemberTree {

  def withSuffix[T: ToSuffix](t: T): FieldTree =
    renamed(name withSuffix t)

  def originalName: Name =
    annotations.collectFirst { case Annotation.JsName(name) => name } getOrElse name

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
    annotations: Seq[MemberAnnotation],
    level:       ProtectionLevel,
    name:        Name,
    tparams:     Seq[TypeParamTree],
    params:      Seq[Seq[ParamTree]],
    impl:        MemberImpl,
    resultType:  TypeRef,
    isOverride:  Boolean,
    comments:    Comments,
    codePath:    QualifiedName,
) extends MemberTree {
  def withSuffix[T: ToSuffix](t: T): MethodTree =
    renamed(name withSuffix t)

  def originalName: Name =
    annotations.collectFirst { case Annotation.JsName(name) => name } getOrElse name

  def renamed(newName: Name): MethodTree =
    copy(
      name        = newName,
      annotations = Annotation.renamedFrom(name)(annotations),
      isOverride  = false,
      codePath    = QualifiedName(codePath.parts.init :+ newName),
    )

  def withCodePath(newCodePath: QualifiedName): MethodTree = copy(codePath = newCodePath)
}

final case class CtorTree(level: ProtectionLevel, params: Seq[ParamTree], comments: Comments) extends Tree {
  override val name = Name.CONSTRUCTOR
}

object CtorTree {
  val defaultPublic    = CtorTree(ProtectionLevel.Default, Seq(), NoComments)
  val defaultProtected = CtorTree(ProtectionLevel.Protected, Seq(), NoComments)
}

final case class TypeParamTree(name: Name, upperBound: Option[TypeRef], comments: Comments) extends Tree

object TypeParamTree {
  def asTypeArgs(tps: Seq[TypeParamTree]): Seq[TypeRef] =
    tps.map(x => TypeRef(x.name))

  implicit val TypeParamToSuffix: ToSuffix[TypeParamTree] = tp => ToSuffix(tp.name) +? tp.upperBound
}

final case class ParamTree(name: Name, tpe: TypeRef, default: Option[TypeRef], comments: Comments) extends Tree

final case class TypeRef(typeName: QualifiedName, targs: Seq[TypeRef], comments: Comments) extends Tree {
  override val name: Name = typeName.parts.last

  def withOptional(optional: Boolean): TypeRef =
    if (optional) TypeRef.UndefOr(this) else this

  def withComments(cs: Comments): TypeRef =
    TypeRef(typeName, targs, comments ++ cs)
}

object TypeRef {
  def apply(n: Name): TypeRef =
    TypeRef(QualifiedName(List(n)), Nil, NoComments)
  def apply(qn: QualifiedName): TypeRef =
    TypeRef(qn, Nil, NoComments)

  val Wildcard     = TypeRef(QualifiedName.WILDCARD, Nil, NoComments)
  val JObject      = TypeRef(QualifiedName.JObject, Nil, NoComments)
  val Any          = TypeRef(QualifiedName.Any, Nil, NoComments)
  val Boolean      = TypeRef(QualifiedName.Boolean, Nil, NoComments)
  val Double       = TypeRef(QualifiedName.Double, Nil, NoComments)
  val Dynamic      = TypeRef(QualifiedName.Dynamic, Nil, NoComments)
  val Int          = TypeRef(QualifiedName.Int, Nil, NoComments)
  val Long         = TypeRef(QualifiedName.Long, Nil, NoComments)
  val Nothing      = TypeRef(QualifiedName.Nothing, Nil, NoComments)
  val Null         = TypeRef(QualifiedName.Null, Nil, NoComments)
  val Object       = TypeRef(QualifiedName.Object, Nil, NoComments)
  val String       = TypeRef(QualifiedName.String, Nil, NoComments)
  val Symbol       = TypeRef(QualifiedName.Symbol, Nil, NoComments)
  val Unit         = TypeRef(QualifiedName.Unit, Nil, NoComments)
  val FunctionBase = TypeRef(QualifiedName.Function, Nil, NoComments)

  val `null`    = TypeRef(QualifiedName(Name("null") :: Nil), Nil, NoComments)
  val undefined = TypeRef(QualifiedName(Name("js.undefined") :: Nil), Nil, NoComments)

  val Primitive = Set(Double, Int, Long, Boolean, Unit, Nothing)

  def StringDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.StringDictionary, Seq(typeParam), comments)

  def NumberDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.NumberDictionary, Seq(typeParam), comments)

  def TopLevel(typeParam: TypeRef): TypeRef =
    TypeRef(QualifiedName.TopLevel, Seq(typeParam), NoComments)

  object Function {
    def apply(thisType: Option[TypeRef], typeParams: Seq[TypeRef], resType: TypeRef, comments: Comments): TypeRef = {
      val rewriteRepeated: Seq[TypeRef] =
        typeParams.lastOption match {
          case Some(Repeated(underlying, _)) =>
            val commented = underlying.withComments(underlying.comments + Comment("/* repeated */"))
            typeParams.dropRight(1) :+ commented
          case _ =>
            typeParams
        }

      val finalTparams = thisType.to[Seq] ++ (rewriteRepeated :+ resType)

      TypeRef(QualifiedName.FunctionArity(thisType.isDefined, typeParams.size), finalTparams, comments)
    }

    private val F = "Function(\\d+)".r

    def unapply(tr: TypeRef): Option[(Seq[TypeRef], TypeRef)] =
      if (tr.typeName.startsWith(QualifiedName.scala_js) && tr.typeName.parts.length === QualifiedName.scala_js.parts.length + 1) {
        tr.typeName.parts.last.unescaped match {
          case F(_) => Some((tr.targs.init, tr.targs.last))
          case _    => None
        }
      } else None
  }

  object ScalaFunction {
    def apply(typeParams: Seq[TypeRef], resType: TypeRef, comments: Comments): TypeRef = {
      val rewriteRepeated: Seq[TypeRef] =
        typeParams.lastOption match {
          case Some(Repeated(underlying, _)) =>
            val commented = underlying.withComments(underlying.comments + Comment("/* repeated */"))
            typeParams.dropRight(1) :+ commented
          case _ =>
            typeParams
        }

      val finalTparams = rewriteRepeated :+ resType

      TypeRef(QualifiedName.ScalaFunctionArity(typeParams.size), finalTparams, comments)
    }

    private val F = "Function(\\d+)".r

    def unapply(tr: TypeRef): Option[(Seq[TypeRef], TypeRef)] =
      tr.typeName.parts match {
        case Name.scala :: f :: Nil =>
          f.unescaped match {
            case F(_) => Some((tr.targs.init, tr.targs.last))
            case _    => None
          }
        case _ => None
      }
  }

  def Tuple(typeParams: Seq[TypeRef]): TypeRef =
    typeParams match {
      case Nil                            => TypeRef(QualifiedName.Array, Seq(TypeRef.Any), NoComments)
      case Seq(one)                       => TypeRef(QualifiedName.Array, Seq(one), NoComments)
      case catch22 if catch22.length > 22 => TypeRef(QualifiedName.Array, Seq(TypeRef.Any), NoComments)
      case _                              => TypeRef(QualifiedName.Tuple(typeParams.length), typeParams, NoComments)
    }

  object Intersection {
    private def flattened(types: List[TypeRef]): List[TypeRef] =
      types flatMap {
        case Intersection(inner) => inner
        case other               => List(other)
      }

    def apply(types: Iterable[TypeRef]): TypeRef = {
      val base = flattened(types.to[List]).distinct

      base match {
        case Nil        => TypeRef.Nothing
        case one :: Nil => one
        case more       => TypeRef(QualifiedName.INTERSECTION, more, NoComments)
      }
    }

    def unapply(typeRef: TypeRef): Option[Seq[TypeRef]] =
      typeRef match {
        case TypeRef(QualifiedName.INTERSECTION, types, _) =>
          Some(types)

        case _ => None
      }
  }

  object UndefOr {
    def apply(tpe: TypeRef): TypeRef =
      Union(List(undefined, tpe), sort = false)

    def unapply(typeRef: TypeRef): Option[TypeRef] =
      typeRef match {
        case Union(types) if types.contains(undefined) =>
          val rest = types.filterNot(x => x === undefined || x === TypeRef.Nothing) match {
            case Nil      => TypeRef.Nothing
            case Seq(one) => one
            case more     => Union(more, sort = false)
          }
          Some(rest)
        case _ => None
      }
  }

  object Union {
    private def flatten(types: List[TypeRef]): List[TypeRef] =
      types flatMap {
        case Union(inner) => flatten(inner.toList)
        case other        => List(other)
      }

    /**
      * @param sort matters surprisingly much, since union types dont commute.
      * The best would be to always sort, but it's difficult because of subtyping.
      * What we do for now is that when `tso` constructs a union type it's sorted (for consistent builds),
      *  and when we encounter an existing we don't change it
      */
    def apply(types: Seq[TypeRef], sort: Boolean): TypeRef = {
      val flattened = flatten(types.to[List]) match {
        case toSort if sort => toSort.sortBy(_.typeName.parts.last.unescaped)
        case otherwise      => otherwise
      }

      /* "a" | "a" | Foo[A] | Foo[B] => "a" | Foo[A | B] */
      val compressed: List[TypeRef] = {
        val byName = flattened.filterNot(tr => Name.Internal(tr.name)).groupBy(_.typeName)

        flattened.zipWithIndex.flatMap {
          case (tr, idx) =>
            byName.get(tr.typeName) match {
              case Some(more) if more.length > 1 =>
                val isFirst = flattened.indexWhere(_.typeName === tr.typeName) === idx
                if (isFirst) List(tr.copy(targs = more.map(_.targs).transpose.map(Union(_, sort = true))))
                else Nil
              case _ => List(tr)
            }
        }.distinct
      }

      compressed match {
        case Nil        => TypeRef.Nothing
        case one :: Nil => one
        case more       => TypeRef(QualifiedName.UNION, more, NoComments)
      }
    }

    def unapply(typeRef: TypeRef): Option[Seq[TypeRef]] =
      typeRef match {
        case TypeRef(QualifiedName.UNION, types, _) =>
          Some(types)

        case _ => None
      }
  }

  object Literal {
    def apply(underlying: String): TypeRef =
      TypeRef(QualifiedName.LITERAL, Seq(TypeRef(QualifiedName(List(Name(underlying))), Nil, NoComments)), NoComments)

    def unapply(typeRef: TypeRef): Option[String] =
      typeRef match {
        case TypeRef(QualifiedName.LITERAL, Seq(TypeRef(QualifiedName(name :: Nil), Nil, _)), _) =>
          Some(name.unescaped)

        case _ => None
      }
  }

  object Repeated {
    def apply(underlying: TypeRef, comments: Comments): TypeRef =
      TypeRef(QualifiedName.REPEATED, Seq(underlying), comments)

    def unapply(typeRef: TypeRef): Option[(TypeRef, Comments)] =
      typeRef match {
        case TypeRef(QualifiedName.REPEATED, Seq(underlying), comments) =>
          Some((underlying, comments))

        case _ => None
      }
  }

  object Singleton {
    def apply(underlying: TypeRef): TypeRef =
      TypeRef(QualifiedName.SINGLETON, Seq(underlying), NoComments)

    def unapply(typeRef: TypeRef): Option[TypeRef] =
      typeRef match {
        case TypeRef(QualifiedName.SINGLETON, Seq(underlying), _) =>
          Some(underlying)

        case _ => None
      }
  }

  object ThisType {
    def apply(comments: Comments): TypeRef =
      TypeRef(QualifiedName.THIS_TYPE, Nil, comments)

    def unapply(typeRef: TypeRef): Option[Comments] =
      typeRef match {
        case TypeRef(QualifiedName.THIS_TYPE, _, comments) =>
          Some(comments)
        case _ => None
      }
  }

  implicit val TypeRefSuffix: ToSuffix[TypeRef] =
    t => ToSuffix(t.typeName) ++ t.targs.map(x => ToSuffix(x))
}
