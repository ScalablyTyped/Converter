package org.scalablytyped.converter.internal
package ts

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.modules.{ExpandedMod, Exports, Imports}
import org.scalablytyped.converter.internal.ts.transforms.ExpandTypeMappings
import sourcecode.{Enclosing, File, Line, Text}

import scala.collection.mutable
import scala.util.hashing.MurmurHash3.{finalizeHash, mix, productHash}

/**
  * The facility for looking up types and terms in a given tree.
  */
sealed trait TsTreeScope {
  val root:              TsTreeScope.Root
  val lookupUnqualified: Boolean
  def logger:          Logger[Unit]
  def stack:           List[TsTree]
  def tparams:         Map[TsIdent, TsTypeParam]
  def tkeys:           Set[TsIdent]
  def `..`           : TsTreeScope
  def moduleScopes:    Map[TsIdentModule, TsTreeScope.Scoped]
  def moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped]
  def exports:         IArray[TsExport]

  def fatalMaybe[T: Formatter](t: Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
    if (root.pedantic) logger.fatal(t) else logger.warn(t)

  final def /(current: TsTree): TsTreeScope.Scoped =
    new TsTreeScope.Scoped(this, current, lookupUnqualified)

  final def surroundingTsContainer: Option[TsContainer] =
    this match {
      case TsTreeScope.Scoped(_, x: TsContainer) => Some(x)
      case TsTreeScope.Scoped(outer, _) => outer.surroundingTsContainer
      case _: TsTreeScope.Root => None
    }

  final def surroundingHasMembers: Option[HasClassMembers] =
    this match {
      case TsTreeScope.Scoped(_, x: HasClassMembers) => Some(x)
      case TsTreeScope.Scoped(outer, _) => outer.surroundingHasMembers
      case _: TsTreeScope => None
    }

  final def isAbstract(qident: TsQIdent): Boolean =
    qident.parts match {
      case IArray.exactlyOne(one) => tparams.contains(one) || tkeys.contains(one)
      case _                      => false
    }

  final def lookup(qname: TsQIdent, skipValidation: Boolean = false): IArray[TsNamedDecl] =
    lookupIncludeScope(qname, skipValidation).map(_._1)

  final def lookupIncludeScope(qname: TsQIdent, skipValidation: Boolean = false): IArray[(TsNamedDecl, TsTreeScope)] =
    lookupBase(Picker.All, qname, skipValidation)

  final def lookupType(qname: TsQIdent, skipValidation: Boolean = false): IArray[TsNamedDecl] =
    lookupBase(Picker.Types, qname, skipValidation).map(_._1)

  final def lookupTypeIncludeScope(
      qname:          TsQIdent,
      skipValidation: Boolean = false,
  ): IArray[(TsNamedDecl, TsTreeScope)] =
    lookupBase(Picker.Types, qname, skipValidation)

  final def lookupBase[T <: TsNamedDecl](
      picker:         Picker[T],
      qname:          TsQIdent,
      skipValidation: Boolean = false,
  ): IArray[(T, TsTreeScope)] = {
    if ((TsQIdent.Primitive(qname)) || isAbstract(qname))
      return Empty

    val res = lookupInternal(picker, qname.parts, LoopDetector.initial)

    if (res.isEmpty && !skipValidation) {
      //unused, it's just for easier debugging
      lookupInternal(picker, qname.parts, LoopDetector.initial)

      logger.fatalMaybe(s"Cannot resolve $qname", root.pedantic)
    }
    res
  }

  final def lookupInternal[T <: TsNamedDecl](
      picker:       Picker[T],
      wanted:       IArray[TsIdent],
      loopDetector: LoopDetector,
  ): IArray[(T, TsTreeScope)] =
    loopDetector.including(wanted, this) match {
      case Left(_) =>
        Empty
      case Right(newLoopDetector) =>
        wanted match {
          case IArray.headTail(root.libName, rest) =>
            var skipScopes = this
            def shouldSkip(scope: TsTreeScope): Boolean =
              scope match {
                case _: TsTreeScope.Root => false
                case TsTreeScope.Scoped(_, _: TsParsedFile) => false
                case _ => true
              }

            while (shouldSkip(skipScopes)) skipScopes = skipScopes.`..`

            skipScopes.lookupImpl(picker, rest, newLoopDetector)
          case other => lookupImpl(picker, other, newLoopDetector)
        }
    }

  def lookupImpl[T <: TsNamedDecl](
      picker:       Picker[T],
      fragments:    IArray[TsIdent],
      loopDetector: LoopDetector,
  ): IArray[(T, TsTreeScope)]

  final override lazy val toString: String =
    s"TreeScope(${stack.reverse.map(_.asString).mkString(" / ")})"

  final def withinModule: Boolean =
    stack.exists {
      case _: TsDeclModule      => true
      case _: TsAugmentedModule => true
      case _ => false
    }

  override def equals(obj: Any): Boolean =
    obj match {
      case that: TsTreeScope if root.libName === that.root.libName && hashCode === that.hashCode => stack === that.stack
      case _ => false
    }
}

object TsTreeScope {
  trait TsLib {
    def libName:        TsIdentLibrary
    def packageJsonOpt: Option[PackageJsonDeps]
  }

  final case class ImportCacheKey(scope: TsTreeScope, picker: Picker[_], idents: IArray[TsIdent]) {
    override def canEqual(that: Any): Boolean = that.## == ##
    override val hashCode: Int = productHash(this)
  }

  case class Cache(
      typeMappings:   mutable.Map[TsTypeRef, ExpandTypeMappings.Res[IArray[TsMember]]] = mutable.Map.empty,
      imports:        mutable.Map[ImportCacheKey, IArray[(TsNamedDecl, TsTreeScope)]]  = mutable.Map.empty,
      exports:        mutable.Map[TsIdentModule, TsDeclModule]                         = mutable.Map.empty,
      expandExport:   mutable.Map[(TsTreeScope, TsExport), IArray[TsNamedDecl]]        = mutable.Map.empty,
      expandImportee: mutable.Map[(TsTreeScope, TsImportee), ExpandedMod]              = mutable.Map.empty,
  )
  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  def apply(
      libName:  TsIdentLibrary,
      pedantic: Boolean,
      deps:     Map[_ <: TsLib, TsParsedFile],
      logger:   Logger[Unit],
  ): TsTreeScope.Root =
    new Root(libName, pedantic, deps, logger, None, false)

  class LoopDetector private (val stack: List[Entry]) {
    def including(wanted: IArray[TsIdent], scope: TsTreeScope): Either[Unit, LoopDetector] = {
      val e = Entry.Idents(wanted, scope)
      if (stack.contains(e)) Left(())
      else Right(new LoopDetector(e :: stack))
    }
    def including(ref: TsTypeRef, scope: TsTreeScope): Either[Unit, LoopDetector] = {
      val e = Entry.Ref(ref, scope)
      if (stack.contains(e)) Left(())
      else Right(new LoopDetector(e :: stack))
    }
  }

  sealed trait Entry extends Product {
    override def canEqual(that: Any): Boolean = that.## == ##
    override lazy val hashCode: Int = productHash(this)
  }
  object Entry {
    final case class Idents(strings: IArray[TsIdent], scope: TsTreeScope) extends Entry
    final case class Ref(ref:        TsTypeRef, scope:       TsTreeScope) extends Entry
  }

  object LoopDetector {
    val initial = new LoopDetector(Nil)
  }

  final class Root private[TsTreeScope] (
      val libName:           TsIdentLibrary,
      val pedantic:          Boolean,
      _deps:                 Map[_ <: TsLib, TsParsedFile],
      val logger:            Logger[Unit],
      val cache:             Option[Cache],
      val lookupUnqualified: Boolean,
  ) extends TsTreeScope {

    override def hashCode: Int = libName.hashCode

    override val root    = this
    override def stack   = Nil
    override def tparams = Map.empty
    override def `..`    = this
    override def tkeys   = Set.empty
    override def exports = Empty

    private lazy val depScopes: Map[TsIdentLibrary, (TsLib, TsParsedFile, Scoped)] = _deps.map {
      case (s, file) => s.libName -> ((s, file, this / file))
    }

    def caching: Root =
      new Root(libName, pedantic, _deps, logger, Some(Cache()), lookupUnqualified)

    def enableUnqualifiedLookup: Root =
      new Root(libName, pedantic, _deps, logger, cache, lookupUnqualified = true)

    override lazy val moduleScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = mutable.Map.empty[TsIdentModule, TsTreeScope.Scoped]
      depScopes.values.foreach {
        case (_, dep: TsParsedFile, depScope: Scoped) =>
          dep.modules.foreach { case (_, mod) => addModuleScope(ret, mod, depScope) }
      }
      ret.toMap
    }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = mutable.Map.empty[TsIdentModule, TsTreeScope.Scoped]
      depScopes.values.foreach {
        case (_, dep: TsParsedFile, depScope: Scoped) =>
          dep.augmentedModulesMap.foreach {
            case (modName, auxMods) =>
              val mod      = auxMods.reduce(FlattenTrees.mergeAugmentedModule)
              val modScope = depScope / mod
              ret += (modName -> modScope)
          }
      }
      ret.toMap
    }

    override def lookupImpl[T <: TsNamedDecl](
        picker:       Picker[T],
        fragments:    IArray[TsIdent],
        loopDetector: LoopDetector,
    ): IArray[(T, TsTreeScope)] =
      fragments match {
        case IArray.headTail(depName: TsIdentLibrary, tail) =>
          depScopes.get(depName) match {
            case Some((_, dep, libScope)) => search(libScope, picker, dep, tail, loopDetector)
            case None                     => Empty
          }

        case _ =>
          depScopes
            .get(TsIdent.std)
            .map { case (_, lib, libScope) => search(libScope, picker, lib, fragments, loopDetector) }
            .getOrElse(Empty) match {
            case Empty =>
              depScopes.flatMapToIArray {
                case (_, (_, lib, libScope)) => search(libScope, picker, lib, fragments, loopDetector)
              }
            case found => found
          }
      }
  }

  object Scoped {
    def unapply(ts: TsTreeScope): Option[(TsTreeScope, TsTree)] =
      ts match {
        case x: Scoped => Some((x.outer, x.current))
        case _: Root   => None
      }
  }

  final class Scoped private[TsTreeScope] (val outer: TsTreeScope, val current: TsTree, val lookupUnqualified: Boolean)
      extends TsTreeScope {

    // lazy val with no locking
    private var hasHash = false
    private var hash: Int = _
    override def hashCode: Int = {
      if (!hasHash) {
        hasHash = true
        hash    = finalizeHash(mix(mix(2, outer.##), current.##), 2)
      }
      hash
    }

    var _stack: List[TsTree] = null
    override def stack = {
      if (_stack == null) {
        _stack = current :: outer.stack
      }
      _stack
    }

    override val root        = outer.root
    override lazy val logger = outer.logger.withContext("scope", this)
//    override val stack        = current :: outer.stack
    override def `..`         = outer
    override lazy val tparams = outer.tparams ++ HasTParams(current).map(x => x.name -> x).toMap
    override lazy val tkeys =
      current match {
        case x: TsMemberTypeMapped => outer.tkeys + x.key
        case _ => outer.tkeys
      }

//    if (stack.drop(1).contains(current)) {
//      logger.fatal(s"Circular tree detected")
//    }

    lazy val exports: IArray[TsExport] =
      current match {
        case x: TsContainer => x.exports
        case _ => Empty
      }

    override lazy val moduleScopes: Map[TsIdentModule, TsTreeScope.Scoped] =
      current match {
        case x: TsContainer if x.modules.nonEmpty =>
          val ret = mutable.Map.empty[TsIdentModule, TsTreeScope.Scoped]
          ret ++= outer.moduleScopes
          x.modules.foreach { case (_, mod) => addModuleScope(ret, mod, this) }
          ret.toMap
        case _ => outer.moduleScopes
      }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = outer.moduleAuxScopes ++ (current match {
        case x: TsContainer =>
          x.augmentedModulesMap.mapValues(mods => this / mods.reduce(FlattenTrees.mergeAugmentedModule))
        case _ => Map.empty
      })
      ret
    }

    override def lookupImpl[T <: TsNamedDecl](
        Pick:         Picker[T],
        wanted:       IArray[TsIdent],
        loopDetector: LoopDetector,
    ): IArray[(T, TsTreeScope)] = {

      def local: IArray[(T, TsTreeScope)] =
        (wanted, current) match {
          case (IArray.Empty, Pick(x)) => IArray((x, this))
          case (frags, x: TsContainer) =>
            search(this, Pick, x, frags, loopDetector)
          case (frags, x: TsDeclVar) =>
            search(this, Pick, x, frags, loopDetector)
          case _ => Empty
        }

      def exportedFromModule: IArray[(T, TsTreeScope)] =
        current match {
          case x: TsDeclNamespaceOrModule => Exports.lookupExportFrom(this, Pick, wanted, loopDetector, x)
          case _ => Empty
        }

      def importedFromModule: IArray[(T, TsTreeScope)] =
        current match {
          case x: TsContainer =>
            Imports.lookupFromImports(this, Pick, wanted, loopDetector, x.imports)
          case _ => Empty
        }

      def augmentedModule: IArray[(T, TsTreeScope)] =
        current match {
          case x: TsAugmentedModule =>
            moduleScopes.get(x.name) match {
              case Some(xx) => xx.lookupInternal(Pick, wanted, loopDetector)
              case None     => Empty
            }

          case x: TsDeclModule =>
            moduleAuxScopes.get(x.name) match {
              case Some(xx) => xx.lookupInternal(Pick, wanted, loopDetector)
              case None     => Empty
            }

          case _ => Empty
        }

      def fromGlobals: IArray[(T, TsTreeScope)] =
        (wanted, current) match {
          case (IArray.headTail(TsIdent.Global, tail), x: TsContainer) =>
            val globalOpt = x.unnamed.collectFirst { case x: TsGlobal => x }
            globalOpt match {
              case Some(global) =>
                search(this, Pick, global, tail, loopDetector)
              case None => Empty
            }
          case _ => Empty
        }

      def prototype: IArray[(T, TsTreeScope)] =
        wanted match {
          case IArray.exactlyThree(head, TsIdent.prototype, (tail: TsIdentSimple)) =>
            lookupInternal(Picker.HasClassMemberss, IArray(head), loopDetector).flatMap {
              case (cls, newScope) =>
                cls.membersByName.get(tail) match {
                  case Some(found) =>
                    found
                      .mapNotNone(member =>
                        Hoisting.memberToDecl(cls.codePath + TsIdent.prototype, JsLocation.Zero)(member),
                      )
                      .collect {
                        case Pick(x) => (x, newScope)
                      }
                  case None => Empty
                }
            }
          case _ => Empty
        }

      var ret: IArray[(T, TsTreeScope)] = Empty

      if (current.isInstanceOf[TsDecl] || current.isInstanceOf[TsContainer]) {
        ret = local

        if (ret.isEmpty && lookupUnqualified)
          ret = importedFromModule
        if (ret.isEmpty && lookupUnqualified)
          ret = augmentedModule
        if (ret.isEmpty && lookupUnqualified)
          ret = exportedFromModule
        if (ret.isEmpty)
          ret = fromGlobals
        if (ret.isEmpty && lookupUnqualified && !wanted.headOption.contains(TsIdent.dummyLibrary)) //optimization
          ret = ExtendingScope(this, Pick, wanted, loopDetector)
        if (ret.isEmpty)
          ret = prototype
      }

      if (ret.isEmpty)
        ret = outer.lookupInternal(Pick, wanted, loopDetector)

      ret
    }
  }

  def search[T <: TsNamedDecl](
      scope:        TsTreeScope,
      Pick:         Picker[T],
      c:            TsTree,
      wanted:       IArray[TsIdent],
      loopDetector: LoopDetector,
  ): IArray[(T, TsTreeScope)] =
    wanted match {
      case IArray.Empty =>
        c match {
          case Pick(x) => IArray((x, scope / x))
          case _       => Empty
        }

      case IArray.exactlyOne(one) =>
        c match {
          case cc: TsContainer =>
            cc.membersByNameMeh.get(one) match {
              case Some(decls) => decls.collect { case Pick(x) => (x, scope / x) }
              case None        => Empty
            }

          case TsDeclVar(_, _, _, _, Some(tpe), _, jsLocation, cp) =>
            Hoisting.fromType(scope, cp, jsLocation, loopDetector, tpe).collect {
              case Pick(x) if one === x.name => x -> scope
            }

          case _ => Empty
        }

      case IArray.headTail(h, t) =>
        c match {
          case cc: TsContainer =>
            cc.membersByName.get(h).orElse(cc.membersByNameMeh.get(h)) match {
              case Some(decls) =>
                decls.flatMap {

                  /** Yeah, enums aren't too well integrated with the rest.
                    *  On the positive side it feels almost as hacked in in typescript
                    */
                  case x: TsDeclEnum if t.length === 1 =>
                    val member = x.members.find(m => t.head === m.name).map { m =>
                      val fakeTa = {
                        val codePath = x.exportedFrom.fold(x.codePath.forceHasPath.codePath)(_.name).parts match {
                          case IArray.Empty                   => sys.error("Unexpected empty codePath")
                          case IArray.headTail(libName, rest) => CodePath.HasPath(libName, TsQIdent(rest :+ m.name))
                        }
                        TsDeclTypeAlias(NoComments, false, m.name, Empty, TsExpr.typeOfOpt(m.expr), codePath)
                      }

                      def fakeVar = {
                        val loc = x.jsLocation + m.name
                        TsDeclVar(NoComments, false, true, m.name, None, m.expr, loc, x.codePath + m.name)
                      }
                      if (x.isConst) IArray(fakeTa) else IArray(fakeTa, fakeVar)
                    }
                    member match {
                      case Some(founds) =>
                        founds.collect {
                          case Pick(x) => x -> scope
                        }
                      case _ => IArray.Empty
                    }
                  case x: TsContainer =>
                    (scope / x).lookupInternal(Pick, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(_: TsTypeThis), _, _, _) =>
                    // this is the second part of the aws-sdk hack, see HandleCommonJsModules
                    search(scope, Pick, c, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(tpe), _, jsLocation, cp) =>
                    Hoisting.fromType(scope, cp, jsLocation, loopDetector, tpe).collect {
                      case Pick(x) if t.headOption.contains(x.name) => x -> scope
                    }

                  case _ => IArray.Empty
                }
              case None => Empty
            }
          case _ => Empty
        }
    }

  private def addModuleScope(
      ret:           mutable.Map[TsIdentModule, TsTreeScope.Scoped],
      mod:           TsDeclModule,
      outsideModule: TsTreeScope,
  ): Unit = {
    def addAlternative(modName: TsIdentModule, modScope: TsTreeScope.Scoped): Unit = {
      val alternative = modName.copy(fragments =
        if (modName.fragments.endsWith("index")) modName.fragments.dropRight(1) else modName.fragments :+ "index",
      )

      if (!ret.contains(alternative)) {
        ret += (alternative -> modScope)
      }
    }

    val modScope = outsideModule / mod
    addAlternative(mod.name, modScope)
    ret += (mod.name -> modScope)
    mod.comments.cs.foreach {
      case CommentData(ModuleAliases(aliases)) =>
        aliases.foreach { alias =>
          ret += ((alias, modScope))
          addAlternative(alias, modScope)
        }
      case _ => ()
    }
  }

}

/**
  * In Typescript, namespaces and modules can extend each other.
  *
  * This is the first take at implementing support for it. No real changes to output
  *  so far, but this enabled us to look for a similar entity up-tree to resolve names.
  */
object ExtendingScope {
  def apply[T <: TsNamedDecl](
      scope:        TsTreeScope.Scoped,
      Pick:         Picker[T],
      wanted:       IArray[TsIdent],
      loopDetector: LoopDetector,
  ): IArray[(T, TsTreeScope)] =
    scope.current match {
      case x: TsDeclNamespace =>
        val p: Picker[TsDeclNamespace] = {
          case xx: TsDeclNamespace if xx.codePath =/= x.codePath => Some(xx)
          case _ => None
        }
        scope.`..`.lookupInternal(p, IArray(x.name), loopDetector).flatMap {
          case (c, extScope) =>
            TsTreeScope.search(extScope, Pick, c, wanted, loopDetector)
        }
      case _ => Empty
    }

}
