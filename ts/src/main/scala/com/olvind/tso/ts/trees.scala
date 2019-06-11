package com.olvind.tso
package ts

import com.olvind.logging.Formatter
import com.olvind.tso.seqs._
import com.olvind.tso.ts.transforms.ExtractInterfaces

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
  def members: Seq[TsContainerOrDecl]

  def withMembers(newMembers: Seq[TsContainerOrDecl]): TsContainer
}

sealed trait TsNamedDecl extends TsDecl with HasCodePath {
  def name: TsIdent
  def withName(name: TsIdent): TsNamedDecl
}

sealed trait TsNamedValueDecl extends TsNamedDecl

final case class TsParsedFile(
    comments:   Comments,
    directives: Seq[Directive],
    members:    Seq[TsContainerOrDecl],
    codePath:   CodePath,
) extends TsContainer {

  lazy val isStdLib: Boolean =
    directives exists {
      case DirectiveNoStdLib => true
      case _                 => false
    }

  override def withMembers(newMembers: Seq[TsContainerOrDecl]): TsParsedFile =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): HasCodePath = copy(codePath = newCodePath)
}

sealed trait TsDeclNamespaceOrModule extends TsContainer with TsNamedValueDecl with HasJsLocation

final case class TsDeclNamespace(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentNamespace,
    members:    Seq[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule {

  override def withCodePath(newCodePath: CodePath): TsDeclNamespace =
    copy(codePath = newCodePath)

  override def withMembers(newMembers: Seq[TsContainerOrDecl]): TsDeclNamespace =
    copy(members = newMembers)

  override def withJsLocation(newLocation: JsLocation): TsDeclNamespace =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdent): TsNamedDecl =
    // todo: a glitch in the matrix here
    copy(name = TsIdentNamespace(newName.value))
}

final case class TsDeclModule(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdentModule,
    members:    Seq[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule {

  override def withName(name: TsIdent): TsNamedDecl =
    copy(name = TsIdentModule(None, name.value.split("/").toList))

  override def withMembers(newMembers: Seq[TsContainerOrDecl]): TsDeclModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsDeclModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclModule =
    copy(jsLocation = newLocation)
}

final case class TsAugmentedModule(
    name:       TsIdentModule,
    members:    Seq[TsContainerOrDecl],
    codePath:   CodePath,
    jsLocation: JsLocation,
) extends TsDeclNamespaceOrModule {
  override def withMembers(newMembers: Seq[TsContainerOrDecl]): TsAugmentedModule =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): TsAugmentedModule =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsAugmentedModule =
    copy(jsLocation = newLocation)

  override def withName(name: TsIdent): TsNamedDecl =
    copy(name = TsIdentModule(None, name.value.split("/").toList))
}

final case class TsGlobal(
    comments: Comments,
    declared: Boolean,
    members:  Seq[TsContainerOrDecl],
    codePath: CodePath,
) extends TsContainer
    with HasCodePath {
  override def withMembers(newMembers: Seq[TsContainerOrDecl]): TsGlobal =
    copy(members = newMembers)

  override def withCodePath(newCodePath: CodePath): HasCodePath = copy(codePath = newCodePath)
}

final case class TsDeclClass(
    comments:   Comments,
    declared:   Boolean,
    isAbstract: Boolean,
    name:       TsIdent,
    tparams:    Seq[TsTypeParam],
    parent:     Option[TsTypeRef],
    implements: Seq[TsTypeRef],
    members:    Seq[TsMember],
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with HasJsLocation
    with HasClassMembers
    with HasCodePath {

  override def withCodePath(newCodePath: CodePath): TsDeclClass =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclClass =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdent): TsDeclClass =
    copy(name = newName)
}

final case class TsDeclInterface(
    comments:    Comments,
    declared:    Boolean,
    name:        TsIdent,
    tparams:     Seq[TsTypeParam],
    inheritance: Seq[TsTypeRef],
    members:     Seq[TsMember],
    codePath:    CodePath,
) extends TsNamedDecl
    with HasClassMembers
    with HasCodePath {

  override def withCodePath(newCodePath: CodePath): TsDeclInterface =
    copy(codePath = newCodePath)

  override def withName(newName: TsIdent): TsDeclInterface =
    copy(name = newName)
}

/* other decls */

final case class TsDeclEnum(
    comments:     Comments,
    declared:     Boolean,
    isConst:      Boolean,
    name:         TsIdent,
    members:      Seq[TsEnumMember],
    isValue:      Boolean,
    exportedFrom: Option[TsTypeRef],
    jsLocation:   JsLocation,
    codePath:     CodePath,
) extends TsNamedValueDecl
    with HasJsLocation
    with HasCodePath {

  override def withCodePath(newCodePath: CodePath): TsDeclEnum =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclEnum =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdent): TsDeclEnum =
    copy(name = newName)
}

final case class TsEnumMember(comments: Comments, name: TsIdent, expr: Option[TsExpr]) extends TsTree

final case class TsDeclVar(
    comments:   Comments,
    declared:   Boolean,
    readOnly:   Boolean,
    name:       TsIdent,
    tpe:        Option[TsType],
    expr:       Option[TsExpr],
    jsLocation: JsLocation,
    codePath:   CodePath,
    isOptional: Boolean,
) extends TsNamedValueDecl
    with HasJsLocation
    with HasCodePath {

  override def withCodePath(newCodePath: CodePath): TsDeclVar =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclVar =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdent): TsDeclVar =
    copy(name = newName)
}

final case class TsDeclFunction(
    comments:   Comments,
    declared:   Boolean,
    name:       TsIdent,
    signature:  TsFunSig,
    jsLocation: JsLocation,
    codePath:   CodePath,
) extends TsNamedValueDecl
    with HasJsLocation
    with HasCodePath {

  override def withCodePath(newCodePath: CodePath): TsDeclFunction =
    copy(codePath = newCodePath)

  override def withJsLocation(newLocation: JsLocation): TsDeclFunction =
    copy(jsLocation = newLocation)

  override def withName(newName: TsIdent): TsDeclFunction =
    copy(name = newName)
}

final case class TsDeclTypeAlias(
    comments: Comments,
    declared: Boolean,
    name:     TsIdent,
    tparams:  Seq[TsTypeParam],
    alias:    TsType,
    codePath: CodePath,
) extends TsNamedDecl
    with HasCodePath {
  override def withCodePath(newCodePath: CodePath): TsDeclTypeAlias =
    copy(codePath = newCodePath)

  override def withName(newName: TsIdent): TsDeclTypeAlias =
    copy(name = newName)
}

/* functions and params */

final case class TsFunSig(
    comments:   Comments,
    tparams:    Seq[TsTypeParam],
    params:     Seq[TsFunParam],
    resultType: Option[TsType],
) extends TsTree

final case class TsFunParam(comments: Comments, name: TsIdent, tpe: Option[TsType], isOptional: Boolean)
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
    name:       TsIdent,
    upperBound: Option[TsType],
    default:    Option[TsType],
) extends TsTree

object TsTypeParam {
  def asTypeArgs(tps: Seq[TsTypeParam]): Seq[TsTypeRef] =
    tps.map(tp => TsTypeRef.of(tp.name))
}
// terms

sealed trait TsTerm extends TsTree

sealed abstract class TsLiteral(repr: String) extends TsTerm {
  def literal = repr
}

final case class TsLiteralNumber(value: String) extends TsLiteral(value)

final case class TsLiteralString(value: String) extends TsLiteral(stringUtils.quote(value))

final case class TsLiteralBoolean(value: Boolean) extends TsLiteral(value.toString)

sealed trait TsIdent extends TsTerm {
  def value: String
}

// here be dragons, i guess
sealed trait TsIdentInterchangeable extends TsIdent {
  override def equals(obj: Any): Boolean =
    obj match {
      case TsIdentSimple(v)    => value == v
      case TsIdentNamespace(v) => value == v
      case _                   => false
    }

  override lazy val hashCode: Int = value.hashCode
}

final case class TsIdentSimple(value: String) extends TsIdentInterchangeable

final case class TsIdentImport(from: TsIdentModule) extends TsIdent {
  override def value: String = from.value
}

final case class TsIdentModule(scopeOpt: Option[String], fragments: List[String]) extends TsIdent {
  @deprecated("this doesnt really work for node", "")
  lazy val inLibrary: TsIdentLibrary =
    scopeOpt match {
      case None        => TsIdentLibrarySimple(fragments.head)
      case Some(scope) => ts.TsIdentLibraryScoped(scope, fragments.headOption)
    }

  lazy val value: String =
    scopeOpt match {
      case None        => fragments.mkString("/")
      case Some(scope) => "@" + scope + "/" + fragments.mkString("/")
    }
}

object TsIdentModule {
  def simple(s: String): TsIdentModule =
    TsIdentModule(None, s :: Nil)
}

final case class TsIdentNamespace(value: String) extends TsIdentInterchangeable

sealed trait TsIdentLibrary extends TsIdent {
  def `__value`: String = this match {
    case TsIdentLibraryScoped(scope, Some(name)) => s"${scope}__$name"
    case TsIdentLibraryScoped(scope, None)       => scope
    case TsIdentLibrarySimple(value)             => value
  }
}

object TsIdentLibrary {
  implicit val FormatterTsIdentLibrary: Formatter[TsIdentLibrary] =
    i => i.value
}

final case class TsIdentLibrarySimple(value: String) extends TsIdentLibrary

final case class TsIdentLibraryScoped(scope: String, nameOpt: Option[String]) extends TsIdentLibrary {
  def value: String =
    nameOpt match {
      case Some(name) => s"@$scope/$name"
      case None       => s"@$scope"
    }
}

object TsIdent {
  def apply(str: String): TsIdentSimple =
    TsIdentSimple(str)

  def unapply(ident: TsIdent): Some[String] =
    Some(ident.value)

  val `this`:        TsIdent = TsIdent("this")
  val Apply:         TsIdent = TsIdent("<apply>")
  val update:        TsIdent = TsIdent("update")
  val prototype:     TsIdent = TsIdent("prototype")
  val constructor:   TsIdent = TsIdent("constructor")
  val default:       TsIdent = TsIdent("default")
  val namespaced:    TsIdent = TsIdent("^")
  val namespacedCls: TsIdent = TsIdent("Class")
  val Symbol:        TsIdent = TsIdent("Symbol")
  val Global:        TsIdent = TsIdent("Global")
  val Record:        TsIdent = TsIdent("Record")

  val dummy: TsIdentLibrary = TsIdentLibrarySimple("dummy")
  val std:   TsIdentLibrary = TsIdentLibrarySimple("std")

  implicit object TsIdentKey extends IsKey[TsIdent]
}

final case class TsQIdent(parts: List[TsIdent]) extends TsTree {
  def +(tsIdent: TsIdent): TsQIdent =
    TsQIdent(parts :+ tsIdent)

  def ++(tsIdents: Seq[TsIdent]): TsQIdent =
    TsQIdent(parts ++ tsIdents)
}

object TsQIdent {

  def of(ss:      String*) = TsQIdent(ss.toList.map(TsIdent.apply))
  def of(tsIdent: TsIdent) = TsQIdent(tsIdent :: Nil)

  val empty: TsQIdent = TsQIdent(Nil)

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
  val Primitive = Set(any, bigint, number, boolean, never, `null`, `object`, string, symbol, undefined, unknown, void)

  val Array:    TsQIdent = TsQIdent.of("Array")
  val Boolean:  TsQIdent = TsQIdent.of("Boolean")
  val Function: TsQIdent = TsQIdent.of("Function")
  val Object:   TsQIdent = TsQIdent.of("Object")
  val String:   TsQIdent = TsQIdent.of("String")

  object Std {
    private val std = TsIdentLibrarySimple("std")

    val Array         = TsQIdent(List(std, TsIdent("Array")))
    val Boolean       = TsQIdent(List(std, TsIdent("Boolean")))
    val ConcatArray   = TsQIdent(List(std, TsIdent("ConcatArray")))
    val Function      = TsQIdent(List(std, TsIdent("Function")))
    val Object        = TsQIdent(List(std, TsIdent("Object")))
    val Promise       = TsQIdent(List(std, TsIdent("Promise")))
    val PromiseLike   = TsQIdent(List(std, TsIdent("PromiseLike")))
    val ReadonlyArray = TsQIdent(List(std, TsIdent("ReadonlyArray")))
    val String        = TsQIdent(List(std, TsIdent("String")))
  }
}

//types

sealed abstract class TsType extends TsTree

final case class TsTypeRef(comments: Comments, name: TsQIdent, tparams: Seq[TsType]) extends TsType

object TsTypeRef {
  def of(tsIdent: TsIdent): TsTypeRef =
    TsTypeRef(NoComments, TsQIdent.of(tsIdent), Nil)

  val any       = TsTypeRef(NoComments, TsQIdent.any, Nil)
  val boolean   = TsTypeRef(NoComments, TsQIdent.boolean, Nil)
  val Boolean   = TsTypeRef(NoComments, TsQIdent.Boolean, Nil)
  val Symbol    = TsTypeRef(NoComments, TsQIdent.symbol, Nil)
  val `object`  = TsTypeRef(NoComments, TsQIdent.`object`, Nil)
  val Object    = TsTypeRef(NoComments, TsQIdent.Object, Nil)
  val string    = TsTypeRef(NoComments, TsQIdent.string, Nil)
  val String    = TsTypeRef(NoComments, TsQIdent.String, Nil)
  val never     = TsTypeRef(NoComments, TsQIdent.never, Nil)
  val number    = TsTypeRef(NoComments, TsQIdent.number, Nil)
  val `null`    = TsTypeRef(NoComments, TsQIdent.`null`, Nil)
  val void      = TsTypeRef(NoComments, TsQIdent.void, Nil)
  val undefined = TsTypeRef(NoComments, TsQIdent.undefined, Nil)
}

final case class TsTypeLiteral(literal: TsLiteral) extends TsType

final case class TsTypeObject(comments: Comments, members: Seq[TsMember]) extends TsType with HasClassMembers

final case class TsTypeFunction(signature: TsFunSig) extends TsType

final case class TsTypeConstructor(signature: TsTypeFunction) extends TsType

final case class TsTypeIs(ident: TsIdent, tpe: TsType) extends TsType

final case class TsTypeTuple(tparams: Seq[TsType]) extends TsType

final case class TsTypeQuery(expr: TsQIdent) extends TsType

final case class TsTypeRepeated(underlying: TsType) extends TsType

final case class TsTypeKeyOf(key: TsType) extends TsType

final case class TsTypeLookup(from: TsType, key: TsType) extends TsType

final case class TsTypeThis() extends TsType

final case class TsTypeIntersect private (types: Seq[TsType]) extends TsType

object TsTypeIntersect {
  private def flatten(types: List[TsType]): List[TsType] =
    types flatMap {
      case TsTypeIntersect(nested) => flatten(nested.to[List])
      case other                   => other :: Nil
    }

  def simplified(types: Seq[TsType]): TsType = {
    val withCombinedObjects = types.partitionCollect {
      case x: TsTypeObject if !ExtractInterfaces.isTypeMapping(x.members) => x
    } match {
      case (Nil, all)      => all
      case (Seq(_), _)     => types // just keep order
      case (objects, rest) => TsTypeObject(NoComments, objects.flatMap(_.members)) +: rest
    }
    flatten(withCombinedObjects.to[List]).distinct match {
      case Nil      => TsTypeRef.never
      case Seq(one) => one
      case more     => new TsTypeIntersect(more)
    }
  }
}

final case class TsTypeUnion private (types: Seq[TsType]) extends TsType

object TsTypeUnion {
  private def flatten(types: List[TsType]): List[TsType] =
    types flatMap {
      case TsTypeUnion(nested) => flatten(nested.to[List])
      case other               => other :: Nil
    }

  def simplified(types: Seq[TsType]): TsType =
    flatten(types.to[List]).distinct match {
      case Nil      => TsTypeRef.never
      case Seq(one) => one
      case more     => new TsTypeUnion(more)
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
    name:       TsIdent,
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

final case class TsMemberTypeMapped(
    comments:    Comments,
    level:       ProtectionLevel,
    isReadOnly:  Boolean,
    key:         TsIdent,
    from:        TsType,
    optionalize: OptionalModifier,
    to:          TsType,
) extends TsMember

final case class TsMemberProperty(
    comments:   Comments,
    level:      ProtectionLevel,
    name:       TsIdent,
    tpe:        Option[TsType],
    expr:       Option[TsExpr],
    isStatic:   Boolean,
    isReadOnly: Boolean,
    isOptional: Boolean,
) extends TsMember

//imports

sealed trait TsImported extends TsTree

final case class TsImportedIdent(ident: TsIdent) extends TsImported

final case class TsImportedDestructured(idents: List[(TsIdent, Option[TsIdent])]) extends TsImported

final case class TsImportedStar(asOpt: Option[TsIdent]) extends TsImported

sealed trait TsImportee extends TsTree

final case class TsImporteeRequired(from: TsIdentModule) extends TsImportee

final case class TsImporteeFrom(from: TsIdentModule) extends TsImportee

final case class TsImporteeLocal(qident: TsQIdent) extends TsImportee

final case class TsImport(imported: Seq[TsImported], from: TsImportee) extends TsDecl with TsTree

//exports

sealed trait TsExportee extends TsTree

final case class TsExporteeNames(idents: Seq[(TsQIdent, Option[TsIdent])], fromOpt: Option[TsIdentModule])
    extends TsExportee

final case class TsExporteeTree(decl: TsDecl) extends TsExportee

final case class TsExporteeStar(from: TsIdentModule, renamedOpt: Option[TsIdent]) extends TsExportee

sealed trait ExportType

object ExportType {
  val NotNamed: Set[ExportType] = Set(ExportType.Namespaced, ExportType.Defaulted)

  case object Named extends ExportType

  case object Defaulted extends ExportType

  case object Namespaced extends ExportType
}

final case class TsExport(comments: Comments, tpe: ExportType, exported: TsExportee) extends TsDecl

final case class TsExportAsNamespace(ident: TsIdent) extends TsDecl
