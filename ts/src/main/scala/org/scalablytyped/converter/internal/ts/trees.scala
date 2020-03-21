package org.scalablytyped.converter.internal
package ts

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts.transforms.ExtractInterfaces

import scala.util.hashing.MurmurHash3.productHash

sealed trait TsTree extends Serializable with Product {

  override lazy val hashCode: Int = productHash(this)

  lazy val asString: String = {
    val name = this match {
      case named: TsNamedDecl => named.name.value
      case TsMemberProperty(_, _, TsIdent(str), _, _, _, _, _) => str
      case TsMemberFunction(_, _, TsIdent(str), _, _, _, _)    => str
      case _                                                   => ""
    }
    s"${getClass.getSimpleName}($name)"
  }
}

sealed trait TsContainerOrDecl extends TsTree

sealed trait TsDecl extends TsContainerOrDecl

sealed trait TsContainer extends TsContainerOrDecl with MemberCache with HasCodePath {
  def members: IArray[TsContainerOrDecl]

  def withMembers(newMembers: IArray[TsContainerOrDecl]): TsContainer
}

sealed trait TsNamedDecl extends TsDecl with HasCodePath {
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
    directives exists {
      case DirectiveNoStdLib => true
      case _                 => false
    }

  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsParsedFile =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): HasCodePath = copy(codePath = newCodePath)
}

sealed trait TsDeclNamespaceOrModule extends TsContainer with TsNamedValueDecl with HasJsLocation

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

  override def withName(newName: TsIdentSimple): TsNamedDecl =
    copy(name = newName)
}

final case class TsDeclModule(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentModule,
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule {

  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsDeclModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsDeclModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclModule =
    copy(jsLocation = newLocation)

  override def withName(name: TsIdentSimple): TsDeclNamespace =
    TsDeclNamespace(comments, declared = false, name, members, codePath, jsLocation)
}

final case class TsAugmentedModule(
    name:       TsIdentModule,
    members:    IArray[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule {
  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsAugmentedModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsAugmentedModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsAugmentedModule =
    copy(jsLocation = newLocation)

  override def withName(name: TsIdentSimple): TsDeclNamespace =
    TsDeclNamespace(NoComments, declared = false, name, members, codePath, jsLocation)
}

final case class TsGlobal(
    comments: Comments,
    declared: Boolean,
    members:  IArray[TsContainerOrDecl],
    codePath: CodePath,
) extends TsContainer
    with HasCodePath {
  override def withMembers(newMembers: IArray[TsContainerOrDecl]): TsGlobal =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): HasCodePath = copy(codePath = newCodePath)
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
    with HasJsLocation
    with HasClassMembers
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclClass =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclClass =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclClass =
    copy(name = newName)
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
    with HasJsLocation
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclEnum =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclEnum =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclEnum =
    copy(name = newName)
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
    isOptional: Boolean,
) extends TsNamedValueDecl
    with HasJsLocation
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclVar =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclVar =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclVar =
    copy(name = newName)
}

final case class TsDeclFunction(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentSimple,
    signature:  TsFunSig,
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with HasJsLocation
    with TsNamedDecl {

  override def withCodePath(newCodePath: CodePath): TsDeclFunction =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclFunction =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdentSimple): TsDeclFunction =
    copy(name = newName)
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
}

/* functions and params */

final case class TsFunSig(
    comments:   Comments,
    tparams:    IArray[TsTypeParam],
    params:     IArray[TsFunParam],
    resultType: Option[TsType],
) extends TsTree

final case class TsFunParam(comments: Comments, name: TsIdentSimple, tpe: Option[TsType], isOptional: Boolean)
    extends TsTree {

  override def equals(obj: Any): Boolean =
    obj match {
      case that: TsFunParam =>
        tpe === that.tpe && isOptional === that.isOptional
      case _ => false
    }

  override lazy val hashCode: Int =
    (7 + tpe.##) * 31 + isOptional.##
}

final case class TsTypeParam(
    comments:   Comments,
    name:       TsIdentSimple,
    upperBound: Option[TsType],
    default:    Option[TsType],
) extends TsTree

object TsTypeParam {
  def asTypeArgs(tps: IArray[TsTypeParam]): IArray[TsTypeRef] =
    tps.map(tp => TsTypeRef.of(tp.name))
}
// terms

sealed trait TsTerm extends TsTree

sealed abstract class TsLiteral(repr: String) extends TsTerm {
  def literal = repr
}

final case class TsLiteralNumber(value: String) extends TsLiteral(value)

final case class TsLiteralString(value: String) extends TsLiteral(value)

final case class TsLiteralBoolean(value: Boolean) extends TsLiteral(value.toString)

sealed trait TsIdent extends TsTerm {
  val value: String
}

final case class TsIdentSimple(value: String) extends TsIdent

final case class TsIdentImport(from: TsIdentModule) extends TsIdent {
  override val value: String = from.value
}

final case class ModuleAliases(aliases: IArray[TsIdentModule]) extends Comment.Data

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
  def simple(s: String): TsIdentModule =
    TsIdentModule(None, s :: Nil)
}

sealed trait TsIdentLibrary extends TsIdent {
  def `__value`: String = this match {
    case TsIdentLibraryScoped(scope, name) => s"${scope}__$name"
    case TsIdentLibrarySimple(value)       => value
  }
}

object TsIdentLibrary {
  implicit val FormatterTsIdentLibrary: Formatter[TsIdentLibrary] =
    i => i.value

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
  def apply(str: String): TsIdentSimple =
    TsIdentSimple(str)

  def unapply(ident: TsIdent): Some[String] =
    Some(ident.value)

  val `this`:        TsIdentSimple = TsIdent("this")
  val Apply:         TsIdentSimple = TsIdent("<apply>")
  val update:        TsIdentSimple = TsIdent("update")
  val prototype:     TsIdentSimple = TsIdent("prototype")
  val constructor:   TsIdentSimple = TsIdent("constructor")
  val default:       TsIdentSimple = TsIdent("default")
  val namespaced:    TsIdentSimple = TsIdent("^")
  val namespacedCls: TsIdentSimple = TsIdent("Class")
  val Symbol:        TsIdentSimple = TsIdent("Symbol")
  val Global:        TsIdentSimple = TsIdent("_Global_")
  val dummy:         TsIdentSimple = TsIdent("dummy")

  val dummyLibrary: TsIdentLibrary = TsIdentLibrarySimple("dummyLibrary")
  val std:          TsIdentLibrary = TsIdentLibrarySimple("std")
  val node:         TsIdentLibrary = TsIdentLibrarySimple("node")

  implicit object TsIdentKey extends IsKey[TsIdent]
}

final case class TsQIdent(parts: IArray[TsIdent]) extends TsTree {
  def +(tsIdent: TsIdent): TsQIdent =
    TsQIdent(parts :+ tsIdent)

  def ++(tsIdents: IArray[TsIdent]): TsQIdent =
    TsQIdent(parts ++ tsIdents)
}

object TsQIdent {

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
  val ReadonlyArray: TsQIdent = TsQIdent.of("ReadonlyArray")
  val Boolean:       TsQIdent = TsQIdent.of("Boolean")
  val Function:      TsQIdent = TsQIdent.of("Function")
  val Object:        TsQIdent = TsQIdent.of("Object")
  val String:        TsQIdent = TsQIdent.of("String")

  object Std {
    val Array         = TsQIdent(IArray(TsIdent.std, TsIdent("Array")))
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

final case class TsTypeRef(comments: Comments, name: TsQIdent, tparams: IArray[TsType]) extends TsType

object TsTypeRef {
  def of(tsIdent: TsIdent): TsTypeRef =
    TsTypeRef(NoComments, TsQIdent.of(tsIdent), Empty)

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

final case class TsTypeConstructor(signature: TsTypeFunction) extends TsType

final case class TsTypeIs(ident: TsIdent, tpe: TsType) extends TsType

final case class TsTypeAsserts(ident: TsIdentSimple, isOpt: Option[TsTypeRef]) extends TsType

final case class TsTypeTuple(tparams: IArray[TsType]) extends TsType

final case class TsTypeQuery(expr: TsQIdent) extends TsType

final case class TsTypeRepeated(underlying: TsType) extends TsType

final case class TsTypeKeyOf(key: TsType) extends TsType

final case class TsTypeLookup(from: TsType, key: TsType) extends TsType

final case class TsTypeThis() extends TsType

final case class TsTypeIntersect private (types: IArray[TsType]) extends TsType

object TsTypeIntersect {
  private def flatten(types: IArray[TsType]): IArray[TsType] =
    types flatMap {
      case TsTypeIntersect(nested) => flatten(nested)
      case other                   => IArray(other)
    }

  def simplified(types: IArray[TsType]): TsType = {
    val withCombinedObjects = types.partitionCollect {
      case x: TsTypeObject if !ExtractInterfaces.isTypeMapping(x.members) => x
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

final case class TsTypeUnion private (types: IArray[TsType]) extends TsType

object TsTypeUnion {
  private def flatten(types: IArray[TsType]): IArray[TsType] =
    types flatMap {
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
  def level: ProtectionLevel
}

object TsMember {
  def optional(isOptional: Boolean)(m: TsMember): TsMember = m match {
    case x: TsMemberCall       => x
    case x: TsMemberCtor       => x
    case x: TsMemberTypeMapped => x
    case x: TsMemberFunction   => x.copy(isOptional = isOptional)
    case x: TsMemberIndex      => x.copy(isOptional = isOptional)
    case x: TsMemberProperty   => x.copy(isOptional = isOptional)
  }
}

final case class TsMemberCall(comments: Comments, level: ProtectionLevel, signature: TsFunSig) extends TsMember

final case class TsMemberCtor(comments: Comments, level: ProtectionLevel, signature: TsFunSig) extends TsMember

final case class TsMemberFunction(
    comments:   Comments,
    level:      ProtectionLevel,
    name:       TsIdentSimple,
    signature:  TsFunSig,
    isStatic:   Boolean,
    isReadOnly: Boolean,
    isOptional: Boolean,
) extends TsMember

sealed trait Indexing extends TsTree
case class IndexingDict(name:   TsIdent, tpe: TsType) extends Indexing
case class IndexingSingle(name: TsQIdent) extends Indexing

final case class TsMemberIndex(
    comments:   Comments,
    isReadOnly: Boolean,
    level:      ProtectionLevel,
    indexing:   Indexing,
    isOptional: Boolean,
    valueType:  Option[TsType],
) extends TsMember

sealed trait OptionalModifier {
  def apply(wasOptional: Boolean): Boolean =
    this match {
      case OptionalModifier.Noop          => wasOptional
      case OptionalModifier.Optionalize   => true
      case OptionalModifier.Deoptionalize => false
    }
}

object OptionalModifier {
  case object Noop extends OptionalModifier
  case object Optionalize extends OptionalModifier
  case object Deoptionalize extends OptionalModifier
}

sealed trait ReadonlyModifier {
  def apply(wasReadonly: Boolean): Boolean =
    this match {
      case ReadonlyModifier.Noop => wasReadonly
      case ReadonlyModifier.Yes  => true
      case ReadonlyModifier.No   => false
    }
}

object ReadonlyModifier {
  case object Noop extends ReadonlyModifier
  case object Yes extends ReadonlyModifier
  case object No extends ReadonlyModifier
}

final case class TsMemberTypeMapped(
    comments:    Comments,
    level:       ProtectionLevel,
    readonly:    ReadonlyModifier,
    key:         TsIdent,
    from:        TsType,
    optionalize: OptionalModifier,
    to:          TsType,
) extends TsMember

final case class TsMemberProperty(
    comments:   Comments,
    level:      ProtectionLevel,
    name:       TsIdentSimple,
    tpe:        Option[TsType],
    expr:       Option[TsExpr],
    isStatic:   Boolean,
    isReadOnly: Boolean,
    isOptional: Boolean,
) extends TsMember

//imports

sealed trait TsImported extends TsTree

final case class TsImportedIdent(ident: TsIdentSimple) extends TsImported

final case class TsImportedDestructured(idents: IArray[(TsIdent, Option[TsIdentSimple])]) extends TsImported

final case class TsImportedStar(asOpt: Option[TsIdentSimple]) extends TsImported

sealed trait TsImportee extends TsTree

final case class TsImporteeRequired(from: TsIdentModule) extends TsImportee

final case class TsImporteeFrom(from: TsIdentModule) extends TsImportee

final case class TsImporteeLocal(qident: TsQIdent) extends TsImportee

final case class TsImport(imported: IArray[TsImported], from: TsImportee) extends TsDecl with TsTree

//exports

sealed trait TsExportee extends TsTree

final case class TsExporteeNames(idents: IArray[(TsQIdent, Option[TsIdentSimple])], fromOpt: Option[TsIdentModule])
    extends TsExportee

final case class TsExporteeTree(decl: TsDecl) extends TsExportee

final case class TsExporteeStar(from: TsIdentModule) extends TsExportee

sealed trait ExportType

object ExportType {
  val NotNamed: Set[ExportType] = Set(ExportType.Namespaced, ExportType.Defaulted)

  case object Named extends ExportType

  case object Defaulted extends ExportType

  case object Namespaced extends ExportType
}

final case class TsExport(comments: Comments, tpe: ExportType, exported: TsExportee) extends TsDecl

final case class TsExportAsNamespace(ident: TsIdent) extends TsDecl
