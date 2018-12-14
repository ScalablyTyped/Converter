package com.olvind.tso
package scalajs

sealed trait Tree {
  val name:     Name
  val comments: Comments
}

sealed trait ContainerTree extends Tree {
  val members: Seq[Tree]

  lazy val index: Map[Name, Seq[Tree]] =
    members.groupBy(_.name)
}

final case class PackageTree(
    annotations: Seq[ClassAnnotation],
    name:        Name,
    members:     Seq[Tree],
    comments:    Comments
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
    members:     Seq[MemberTree],
    classType:   ClassType,
    isSealed:    Boolean,
    comments:    Comments
) extends ContainerTree

sealed trait ModuleType
case object ModuleTypeNative extends ModuleType
case object ModuleTypeScala extends ModuleType

final case class ModuleTree(
    annotations: Seq[ClassAnnotation],
    name:        Name,
    moduleType:  ModuleType,
    parents:     Seq[TypeRef],
    members:     Seq[Tree],
    comments:    Comments
) extends ContainerTree

final case class TypeAliasTree(
    name:     Name,
    tparams:  Seq[TypeParamTree],
    alias:    TypeRef,
    comments: Comments
) extends Tree

sealed trait MemberTree extends Tree {
  val isOverride: Boolean
}

sealed trait MemberImpl

case object MemberImplNative extends MemberImpl
case object MemberImplNotImplemented extends MemberImpl
final case class MemberImplCustom(impl: String) extends MemberImpl

final case class FieldTree(
    annotations: Seq[MemberAnnotation],
    name:        Name,
    tpe:         TypeRef,
    impl:        MemberImpl,
    isReadOnly:  Boolean,
    isOverride:  Boolean,
    comments:    Comments
) extends MemberTree {

  def withSuffix[T: ToSuffix](t: T): FieldTree =
    renamed(name withSuffix t)

  def renamed(newName: Name): FieldTree =
    copy(
      name        = newName,
      annotations = Annotation.renamedFrom(name)(annotations),
      isOverride  = false
    )
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
    comments:    Comments
) extends MemberTree {
  def withSuffix[T: ToSuffix](t: T): MethodTree =
    renamed(name withSuffix t)

  def renamed(newName: Name): MethodTree =
    copy(
      name        = newName,
      annotations = Annotation.renamedFrom(name)(annotations),
      isOverride  = false
    )
}

final case class CtorTree(level: ProtectionLevel, params: Seq[ParamTree], comments: Comments) extends Tree {
  override val name = Name.CONSTRUCTOR
}

object CtorTree {
  val defaultPublic    = CtorTree(Default, Seq(), NoComments)
  val defaultProtected = CtorTree(Protected, Seq(), NoComments)
}

final case class TypeParamTree(name: Name, upperBound: Option[TypeRef], comments: Comments) extends Tree

object TypeParamTree {
  implicit object TypeParamsToSuffix extends ToSuffix[Seq[TypeParamTree]] {
    override def to(tparams: Seq[TypeParamTree]): Suffix =
      Suffix(
        tparams
          .map(tp => tp.name.unescaped + tp.upperBound.fold("")(_.name.unescaped))
          .mkString("")
      )
  }
}

final case class ParamTree(name: Name, tpe: TypeRef, comments: Comments) extends Tree

final case class TypeRef(typeName: QualifiedName, targs: Seq[TypeRef], comments: Comments) extends Tree {
  override val name: Name = typeName.parts.last

  def withOptional(optional: Boolean): TypeRef =
    (typeName, optional) match {
      case (QualifiedName.UndefOr, _) => this
      case (_, true)                  => TypeRef(QualifiedName.UndefOr, Seq(this), comments)
      case _                          => this
    }

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

  def UndefOr(of: TypeRef): TypeRef =
    TypeRef(QualifiedName.UndefOr, Seq(of), NoComments)

  def StringDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.StringDictionary, Seq(typeParam), comments)

  def NumberDictionary(typeParam: TypeRef, comments: Comments): TypeRef =
    TypeRef(QualifiedName.NumberDictionary, Seq(typeParam), comments)

  def TopLevel(typeParam: TypeRef): TypeRef =
    TypeRef(QualifiedName.TopLevel, Seq(typeParam), NoComments)

  def Function(thisType: Option[TypeRef], typeParams: Seq[TypeRef], resType: TypeRef, comments: Comments): TypeRef = {
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

  def Tuple(typeParams: Seq[TypeRef]): TypeRef =
    typeParams.length match {
      case n if n > 22 => TypeRef(QualifiedName.Array, Seq(TypeRef.Any), NoComments)
      case _           => TypeRef(QualifiedName.Tuple(typeParams.length), typeParams, NoComments)
    }

  object Intersection {
    private def flattened(types: List[TypeRef]): List[TypeRef] =
      types flatMap {
        case Intersection(inner) => inner
        case other               => List(other)
      }

    def apply(types: Seq[TypeRef]): TypeRef = {
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

  object Union {
    private def flattened(types: List[TypeRef]): List[TypeRef] =
      types flatMap {
        case Union(inner) => inner
        case other        => List(other)
      }

    def apply(types: Seq[TypeRef]): TypeRef =
      flattened(types.to[List]).distinct match {
        case Nil        => TypeRef.Nothing
        case one :: Nil => one
        case more       => TypeRef(QualifiedName.UNION, more, NoComments)
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

  implicit object TypeRefSuffix extends ToSuffix[TypeRef] {
    override def to(t: TypeRef): Suffix = ToSuffix(t.typeName) ++ t.targs.map(to)
  }
}
