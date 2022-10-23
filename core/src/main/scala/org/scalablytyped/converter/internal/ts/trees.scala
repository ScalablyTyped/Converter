package org.scalablytyped.converter.internal
package ts

import io.circe013.{Decoder, Encoder, KeyDecoder, KeyEncoder}

import scala.util.hashing.MurmurHash3.productHash

sealed trait TsTree extends Serializable with Product {

  override def canEqual(that: Any): Boolean = that.## == ##

  override lazy val hashCode: Int = productHash(this)

  lazy val asString: String = {
    val name = this match {
      case named: TsNamedDecl => named.name.value
      case TsMemberProperty(_, _, TsIdent(str), _, _, _, _) => str
      case TsMemberFunction(_, _, TsIdent(str), _, _, _, _) => str
      case _                                                => ""
    }
    s"${getClass.getSimpleName}($name)"
  }
}

sealed trait TsContainerOrDecl extends TsTree

sealed trait TsDecl extends TsContainerOrDecl

sealed trait TsContainer extends TsContainerOrDecl with MemberCache with CodePath.Has {
  def members: IArray[TsContainerOrDecl]

  def withMembers(newMembers: IArray[TsContainerOrDecl]): TsContainer
}

sealed trait TsNamedDecl extends TsDecl with CodePath.Has {
  val comments: Comments
  def withComments(cs:    Comments): TsNamedDecl
  final def addComment(c: Comment) = withComments(comments + c)

  def name: TsIdent
  def withName(name: TsIdentSimple): TsNamedDecl
}

sealed trait TsNamedValueDecl extends TsNamedDecl

final case class TsParsedFile(
    comments:   Comments,
    directives: IArray[Directive],
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
) extends TsContainer {

  lazy val isStdLib: Boolean =
    directives.exists {
      case Directive.NoStdLib => true
      case _                  => false
    }

  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsParsedFile =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): CodePath.Has = copy(codePath = newCodePath)
}

sealed trait TsDeclNamespaceOrModule extends TsContainer with TsNamedValueDecl with JsLocation.Has

sealed trait TsDeclModuleLike extends TsDeclNamespaceOrModule

final case class TsDeclNamespace(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentSimple,
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclNamespace =
    copy(codePath = newCodePath)

  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsDeclNamespace =
    copy(members = newMembers)

  override def withJsLocation(newLocation: JsLocation): TsDeclNamespace =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclNamespace =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclNamespace =
    copy(comments = cs)
}

final case class TsDeclModule(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentModule,
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclModuleLike {

  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsDeclModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsDeclModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclModule =
    copy(jsLocation = newLocation)

  override def withName(name: TsIdentSimple): TsDeclNamespace =
    TsDeclNamespace(comments, declared = false, name, members, codePath, jsLocation)

  override def withComments(cs: Comments): TsDeclModule =
    copy(comments = cs)
}

final case class TsAugmentedModule(
    comments:   Comments,
    name:       TsIdentModule,
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclModuleLike {
  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsAugmentedModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsAugmentedModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsAugmentedModule =
    copy(jsLocation = newLocation)

  override def withName(name: TsIdentSimple): TsDeclNamespace =
    TsDeclNamespace(NoComments, declared = false, name, members, codePath, jsLocation)

  override def withComments(cs: Comments): TsAugmentedModule =
    copy(comments = cs)
}

final case class TsGlobal(
    comments: Comments,
    declared: Boolean,
    members:  IArray[TsContainerOrDecl],
    codePath: CodePath,
) extends TsContainer
    with CodePath.Has {
  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsGlobal =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): CodePath.Has = copy(codePath = newCodePath)
}

final case class TsDeclClass(
    comments:   Comments,
    declared:   Boolean,
    isAbstract: Boolean,
    name:       TsIdentSimple,
    tparams:    IArray[TsTypeParam],
    parent:     Option[TsTypeRef],
    implements: IArray[TsTypeRef],
    members:    IArray[TsMember],
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with JsLocation.Has
    with HasClassMembers
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclClass =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclClass =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclClass =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclClass =
    copy(comments = cs)
}

final case class TsDeclInterface(
    comments:    Comments,
    declared:    Boolean,
    name:        TsIdentSimple,
    tparams:     IArray[TsTypeParam],
    inheritance: IArray[TsTypeRef],
    members:     IArray[TsMember],
    codePath:    CodePath,
) extends TsNamedDecl
    with HasClassMembers {

  override def withCodePath(newCodePath: CodePath): TsDeclInterface =
    copy(codePath = newCodePath)

  override def withName(newName: TsIdentSimple): TsDeclInterface =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclInterface =
    copy(comments = cs)
}

/* other decls */

final case class TsDeclEnum(
    comments:     Comments,
    declared:     Boolean,
    isConst:      Boolean,
    name:         TsIdentSimple,
    members:      IArray[TsEnumMember],
    isValue:      Boolean,
    exportedFrom: Option[TsTypeRef],
    jsLocation:   JsLocation,
    codePath:     CodePath,
) extends TsNamedValueDecl
    with JsLocation.Has
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclEnum =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclEnum =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclEnum =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclEnum =
    copy(comments = cs)

}

final case class TsEnumMember(comments: Comments, name: TsIdentSimple, expr: Option[TsExpr]) extends TsTree

final case class TsDeclVar(
    comments:   Comments,
    declared:   Boolean,
    readOnly:   Boolean,
    name:       TsIdentSimple,
    tpe:        Option[TsType],
    expr:       Option[TsExpr],
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with JsLocation.Has
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclVar =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclVar =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclVar =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclVar =
    copy(comments = cs)
}

final case class TsDeclFunction(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentSimple,
    signature:  TsFunSig,
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with JsLocation.Has
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclFunction =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclFunction =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclFunction =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclFunction =
    copy(comments = cs)
}

final case class TsDeclTypeAlias(
    comments: Comments,
    declared: Boolean,
    name:     TsIdentSimple,
    tparams:  IArray[TsTypeParam],
    alias:    TsType,
    codePath: CodePath,
) extends TsNamedDecl {
  override def withCodePath(newCodePath: CodePath): TsDeclTypeAlias =
    copy(codePath = newCodePath)

  override def withName(newName: TsIdentSimple): TsDeclTypeAlias =
    copy(name = newName)

  override def withComments(cs: Comments): TsDeclTypeAlias =
    copy(comments = cs)
}

/* functions and params */

final case class TsFunSig(
    comments:   Comments,
    tparams:    IArray[TsTypeParam],
    params:     IArray[TsFunParam],
    resultType: Option[TsType],
) extends TsTree

final case class TsFunParam(comments: Comments, name: TsIdentSimple, tpe: Option[TsType]) extends TsTree {

  override def equals(obj: Any): Boolean =
    obj match {
      case that: TsFunParam => tpe === that.tpe
      case _ => false
    }

  override lazy val hashCode: Int = tpe.hashCode
}

final case class TsTypeParam(
    comments:   Comments,
    name:       TsIdentSimple,
    upperBound: Option[TsType],
    default:    Option[TsType],
) extends TsTree

object TsTypeParam {
  def asTypeArgs(tps: IArray[TsTypeParam]): IArray[TsTypeRef] =
    tps.map(tp => TsTypeRef(tp.name))
}

sealed abstract class TsLiteral(repr: String) extends TsTree {
  val literal = repr
}

object TsLiteral {
  final case class Num(value:  String) extends TsLiteral(value)
  final case class Str(value:  String) extends TsLiteral(value)
  final case class Bool(value: Boolean) extends TsLiteral(value.toString)
}

sealed trait TsIdent extends TsTree {
  val value: String
}

final case class TsIdentSimple(value: String) extends TsIdent

final case class TsIdentImport(from: TsIdentModule) extends TsIdent {
  override val value: String = from.value
}

final case class TsIdentModule(scopeOpt: Option[String], fragments: List[String]) extends TsIdent {
  @deprecated("this doesnt really work for node", "")
  def inLibrary: TsIdentLibrary =
    scopeOpt match {
      case None        => TsIdentLibrarySimple(fragments.head)
      case Some(scope) => TsIdentLibraryScoped(scope, fragments.head)
    }

  lazy val value: String =
    scopeOpt match {
      case None        => fragments.mkString("/")
      case Some(scope) => "@" + scope + "/" + fragments.mkString("/")
    }

  override lazy val hashCode: Int = value.hashCode

  override def equals(obj: Any): Boolean =
    obj match {
      case other: TsIdentModule if other.hashCode == hashCode => other.value == value
      case _ => false
    }
}

object TsIdentModule {
  def fromLibrary(lib: TsIdentLibrary): TsIdentModule =
    lib match {
      case TsIdentLibrarySimple(name)        => TsIdentModule(None, name.split("\\.").toList)
      case TsIdentLibraryScoped(scope, name) => TsIdentModule(Some(scope), name.split("\\.").toList)
    }

  def simple(s: String): TsIdentModule =
    TsIdentModule(None, s :: Nil)

  implicit val encodes: Encoder[TsIdentModule] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[TsIdentModule] = io.circe013.generic.semiauto.deriveDecoder
}

sealed trait TsIdentLibrary extends TsIdent {
  def `__value`: String = this match {
    case TsIdentLibraryScoped(scope, name) => s"${scope}__$name"
    case TsIdentLibrarySimple(value)       => value
  }
}

object TsIdentLibrary {
  implicit val ordering: Ordering[TsIdentLibrary] =
    Ordering[String].on[TsIdentLibrary](_.value)
  implicit val TsIdentLibraryDecoder: Decoder[TsIdentLibrary] =
    Decoder[String].map(TsIdentLibrary.apply)
  implicit val TsIdentLibraryEncoder: Encoder[TsIdentLibrary] =
    Encoder[String].contramap[TsIdentLibrary](_.value)
  implicit val TsIdentLibraryKeyDec: KeyDecoder[TsIdentLibrary] =
    KeyDecoder[String].map(TsIdentLibrary.apply)
  implicit val TsIdentLibraryKeyEnc: KeyEncoder[TsIdentLibrary] =
    KeyEncoder[String].contramap[TsIdentLibrary](_.value)

  val Scoped   = "@([^/]+)/(.+)".r
  val Scoped__ = "(.+)__(.+)".r

  def apply(str: String): TsIdentLibrary =
    str match {
      case Scoped("types", name)   => apply(name) // @types/babel__core exists
      case Scoped(scope, name)     => TsIdentLibraryScoped(scope, name)
      case Scoped__("types", name) => apply(name)
      case Scoped__(scope, name)   => TsIdentLibraryScoped(scope, name)
      case other                   => TsIdentLibrarySimple(other)
    }
}

final case class TsIdentLibrarySimple(value: String) extends TsIdentLibrary

final case class TsIdentLibraryScoped(scope: String, name: String) extends TsIdentLibrary {
  val value: String = s"@$scope/$name"
}

object TsIdent {
  implicit val encodes:  Encoder[TsIdent]  = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes:  Decoder[TsIdent]  = io.circe013.generic.semiauto.deriveDecoder
  implicit val ordering: Ordering[TsIdent] = Ordering[String].on[TsIdent](_.value)

  def apply(str: String): TsIdentSimple =
    TsIdentSimple(str)

  def unapply(ident: TsIdent): Some[String] =
    Some(ident.value)

  val `this`:       TsIdentSimple = TsIdent("this")
  val Apply:        TsIdentSimple = TsIdent("<apply>") // keep in sync with Name.necessaryRewrite
  val Global:       TsIdentSimple = TsIdent("<global>") // keep in sync with Name.necessaryRewrite
  val Destructured: TsIdentSimple = TsIdent("<destructured>") // for parameters with no name.

  val update:        TsIdentSimple = TsIdent("update")
  val prototype:     TsIdentSimple = TsIdent("prototype")
  val constructor:   TsIdentSimple = TsIdent("constructor")
  val default:       TsIdentSimple = TsIdent("default")
  val namespaced:    TsIdentSimple = TsIdent("^") // keep in sync with Name.necessaryRewrite
  val namespacedCls: TsIdentSimple = TsIdent("Class")
  val Symbol:        TsIdentSimple = TsIdent("Symbol")
  val dummy:         TsIdentSimple = TsIdent("dummy")

  val dummyLibrary: TsIdentLibrary = TsIdentLibrarySimple("dummyLibrary")
  val std:          TsIdentLibrary = TsIdentLibrarySimple("std")
  val node:         TsIdentLibrary = TsIdentLibrarySimple("node")
}

final case class TsQIdent(parts: IArray[TsIdent]) extends TsTree {
  def +(tsIdent: TsIdent): TsQIdent =
    TsQIdent(parts :+ tsIdent)

  def ++(tsIdents: IArray[TsIdent]): TsQIdent =
    TsQIdent(parts ++ tsIdents)
}

object TsQIdent {
  implicit val encodes:  Encoder[TsQIdent]  = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes:  Decoder[TsQIdent]  = io.circe013.generic.semiauto.deriveDecoder
  implicit val ordering: Ordering[TsQIdent] = Ordering.by(_.parts)

  def of(ss:      String*) = TsQIdent(IArray.fromTraversable(ss.map(TsIdent.apply)))
  def of(tsIdent: TsIdent) = TsQIdent(IArray(tsIdent))

  val empty: TsQIdent = TsQIdent(IArray.Empty)

  val any:       TsQIdent = TsQIdent.of("any")
  val bigint:    TsQIdent = TsQIdent.of("bigint")
  val number:    TsQIdent = TsQIdent.of("number")
  val boolean:   TsQIdent = TsQIdent.of("boolean")
  val never:     TsQIdent = TsQIdent.of("never")
  val `null`:    TsQIdent = TsQIdent.of("null")
  val `object`:  TsQIdent = TsQIdent.of("object")
  val string:    TsQIdent = TsQIdent.of("string")
  val symbol:    TsQIdent = TsQIdent.of("symbol")
  val undefined: TsQIdent = TsQIdent.of("undefined")
  val unknown:   TsQIdent = TsQIdent.of("unknown")
  val void:      TsQIdent = TsQIdent.of("void")
  val Primitive =
    Set(any, bigint, number, boolean, never, `null`, `object`, string, symbol, undefined, unknown, void)

  val Array:         TsQIdent = TsQIdent.of("Array")
  val BigInt:        TsQIdent = TsQIdent.of("BigInt")
  val ReadonlyArray: TsQIdent = TsQIdent.of("ReadonlyArray")
  val Boolean:       TsQIdent = TsQIdent.of("Boolean")
  val Function:      TsQIdent = TsQIdent.of("Function")
  val Object:        TsQIdent = TsQIdent.of("Object")
  val String:        TsQIdent = TsQIdent.of("String")

  object Std {
    val Array         = TsQIdent(IArray(TsIdent.std, TsIdent("Array")))
    val BigInt        = TsQIdent(IArray(TsIdent.std, TsIdent("BigInt")))
    val Boolean       = TsQIdent(IArray(TsIdent.std, TsIdent("Boolean")))
    val ConcatArray   = TsQIdent(IArray(TsIdent.std, TsIdent("ConcatArray")))
    val Function      = TsQIdent(IArray(TsIdent.std, TsIdent("Function")))
    val Object        = TsQIdent(IArray(TsIdent.std, TsIdent("Object")))
    val Promise       = TsQIdent(IArray(TsIdent.std, TsIdent("Promise")))
    val PromiseLike   = TsQIdent(IArray(TsIdent.std, TsIdent("PromiseLike")))
    val Readonly      = TsQIdent(IArray(TsIdent.std, TsIdent("Readonly")))
    val ReadonlyArray = TsQIdent(IArray(TsIdent.std, TsIdent("ReadonlyArray")))
    val Record        = TsQIdent(IArray(TsIdent.std, TsIdent("Record")))
    val String        = TsQIdent(IArray(TsIdent.std, TsIdent("String")))
  }
}

//types

sealed abstract class TsType extends TsTree

object TsType {
  def isTypeMapping(members: IArray[TsMember]): Boolean =
    members match {
      case IArray.exactlyOne(_: TsMemberTypeMapped) => true
      case _ => false
    }
}

final case class TsTypeRef(comments: Comments, name: TsQIdent, tparams: IArray[TsType]) extends TsType

object TsTypeRef {
  def apply(tsIdent: TsIdent): TsTypeRef =
    apply(TsQIdent.of(tsIdent))
  def apply(tsQIdent: TsQIdent): TsTypeRef =
    TsTypeRef(NoComments, tsQIdent, Empty)

  val any       = TsTypeRef(NoComments, TsQIdent.any, Empty)
  val boolean   = TsTypeRef(NoComments, TsQIdent.boolean, Empty)
  val Boolean   = TsTypeRef(NoComments, TsQIdent.Boolean, Empty)
  val Symbol    = TsTypeRef(NoComments, TsQIdent.symbol, Empty)
  val `object`  = TsTypeRef(NoComments, TsQIdent.`object`, Empty)
  val Object    = TsTypeRef(NoComments, TsQIdent.Object, Empty)
  val string    = TsTypeRef(NoComments, TsQIdent.string, Empty)
  val String    = TsTypeRef(NoComments, TsQIdent.String, Empty)
  val never     = TsTypeRef(NoComments, TsQIdent.never, Empty)
  val number    = TsTypeRef(NoComments, TsQIdent.number, Empty)
  val `null`    = TsTypeRef(NoComments, TsQIdent.`null`, Empty)
  val void      = TsTypeRef(NoComments, TsQIdent.void, Empty)
  val undefined = TsTypeRef(NoComments, TsQIdent.undefined, Empty)
}

final case class TsTypeLiteral(literal: TsLiteral) extends TsType

final case class TsTypeObject(comments: Comments, members: IArray[TsMember]) extends TsType with HasClassMembers

final case class TsTypeFunction(signature: TsFunSig) extends TsType

final case class TsTypeConstructor(isAbstract: Boolean, signature: TsTypeFunction) extends TsType

final case class TsTypeIs(ident: TsIdent, tpe: TsType) extends TsType

final case class TsTypeAsserts(ident: TsIdentSimple, isOpt: Option[TsType]) extends TsType

final case class TsTupleElement(label: Option[TsIdent], tpe: TsType)

object TsTupleElement {
  def unlabeled(tpe: TsType): TsTupleElement = TsTupleElement(label = None, tpe)
}

final case class TsTypeTuple(elems: IArray[TsTupleElement]) extends TsType

final case class TsTypeQuery(expr: TsQIdent) extends TsType

final case class TsTypeRepeated(underlying: TsType) extends TsType

final case class TsTypeKeyOf(key: TsType) extends TsType

final case class TsTypeLookup(from: TsType, key: TsType) extends TsType

final case class TsTypeThis() extends TsType

final case class TsTypeIntersect(types: IArray[TsType]) extends TsType

object TsTypeIntersect {
  private def flatten(types: IArray[TsType]): IArray[TsType] =
    types.flatMap {
      case TsTypeIntersect(nested) => flatten(nested)
      case other                   => IArray(other)
    }

  def simplified(types: IArray[TsType]): TsType = {
    val withCombinedObjects = types.partitionCollect {
      case x: TsTypeObject if !TsType.isTypeMapping(x.members) => x
    } match {
      case (Empty, all)              => all
      case (IArray.exactlyOne(_), _) => types // just keep order
      case (objects, rest)           => TsTypeObject(NoComments, objects.flatMap(_.members).distinct) +: rest
    }
    flatten(withCombinedObjects).distinct match {
      case IArray.Empty           => TsTypeRef.never
      case IArray.exactlyOne(one) => one
      case more                   => new TsTypeIntersect(more)
    }
  }
}

final case class TsTypeUnion(types: IArray[TsType]) extends TsType

object TsTypeUnion {
  private def flatten(types: IArray[TsType]): IArray[TsType] =
    types.flatMap {
      case TsTypeUnion(nested) => flatten(nested)
      case other               => IArray(other)
    }

  def simplified(types: IArray[TsType]): TsType =
    flatten(types).distinct match {
      case IArray.Empty           => TsTypeRef.never
      case IArray.exactlyOne(one) => one
      case more                   => new TsTypeUnion(more)
    }
}

sealed trait TsTypePredicate extends TsType

final case class TsTypeConditional(pred: TsType, ifTrue: TsType, ifFalse: TsType) extends TsTypePredicate

// T extends (...args: any[]) => infer R ? R : any
final case class TsTypeExtends(tpe: TsType, `extends`: TsType) extends TsTypePredicate

final case class TsTypeInfer(tparam: TsTypeParam) extends TsTypePredicate

//members

sealed abstract class TsMember extends TsTree {
  def level: TsProtectionLevel
}

final case class TsMemberCall(comments: Comments, level: TsProtectionLevel, signature: TsFunSig) extends TsMember

final case class TsMemberCtor(comments: Comments, level: TsProtectionLevel, signature: TsFunSig) extends TsMember

final case class TsMemberFunction(
    comments:   Comments,
    level:      TsProtectionLevel,
    name:       TsIdentSimple,
    methodType: MethodType,
    signature:  TsFunSig,
    isStatic:   Boolean,
    isReadOnly: Boolean,
) extends TsMember

sealed trait Indexing extends TsTree
object Indexing {
  case class Dict(name:   TsIdent, tpe: TsType) extends Indexing
  case class Single(name: TsQIdent) extends Indexing
}

final case class TsMemberIndex(
    comments:   Comments,
    isReadOnly: Boolean,
    level:      TsProtectionLevel,
    indexing:   Indexing,
    valueType:  Option[TsType],
) extends TsMember

final case class TsMemberTypeMapped(
    comments:    Comments,
    level:       TsProtectionLevel,
    readonly:    ReadonlyModifier,
    key:         TsIdent,
    from:        TsType,
    as:          Option[TsType],
    optionalize: OptionalModifier,
    to:          TsType,
) extends TsMember

final case class TsMemberProperty(
    comments:   Comments,
    level:      TsProtectionLevel,
    name:       TsIdentSimple,
    tpe:        Option[TsType],
    expr:       Option[TsExpr],
    isStatic:   Boolean,
    isReadOnly: Boolean,
) extends TsMember

//imports

sealed trait TsImported extends TsTree
object TsImported {
  final case class Ident(ident:         TsIdentSimple) extends TsImported
  final case class Destructured(idents: IArray[(TsIdent, Option[TsIdentSimple])]) extends TsImported
  final case class Star(asOpt:          Option[TsIdentSimple]) extends TsImported
}

sealed trait TsImportee extends TsTree
object TsImportee {
  final case class Required(from: TsIdentModule) extends TsImportee
  final case class From(from:     TsIdentModule) extends TsImportee
  final case class Local(qident:  TsQIdent) extends TsImportee
}

final case class TsImport(typeOnly: Boolean, imported: IArray[TsImported], from: TsImportee) extends TsDecl with TsTree

//exports

sealed trait TsExportee extends TsTree
object TsExportee {
  case class Names(idents: IArray[(TsQIdent, Option[TsIdentSimple])], fromOpt: Option[TsIdentModule]) extends TsExportee
  case class Tree(decl:    TsDecl) extends TsExportee
  case class Star(as:      Option[TsIdentSimple], from: TsIdentModule) extends TsExportee
}

final case class TsExport(comments: Comments, typeOnly: Boolean, tpe: ExportType, exported: TsExportee) extends TsDecl

final case class TsExportAsNamespace(ident: TsIdentSimple) extends TsDecl
