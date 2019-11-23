package com.olvind.tso
package ts

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.modules.{ExpandedMod, Exports, Imports}
import com.olvind.tso.ts.transforms.ExpandTypeMappings
import sourcecode.{Enclosing, File, Line, Text}

import scala.collection.mutable

/**
  * The facility for looking up types and terms in a given tree.
  */
sealed trait TsTreeScope {
  val root: TsTreeScope.Root
  def logger:          Logger[Unit]
  def stack:           List[TsTree]
  def tparams:         Map[TsIdent, TsTypeParam]
  def tkeys:           Set[TsIdent]
  def `..`           : TsTreeScope
  def moduleScopes:    Map[TsIdentModule, TsTreeScope.Scoped]
  def moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped]
  def exports:         Seq[TsExport]

  def fatalMaybe[T: Formatter](t: Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
    if (root.pedantic) logger.fatal(t) else logger.warn(t)

  final def /(current: TsTree): TsTreeScope.Scoped =
    new TsTreeScope.Scoped(this, current)

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
      case one :: _ => tparams.contains(one) || tkeys.contains(one)
      case _        => false
    }

  final def lookup(qname: TsQIdent, skipValidation: Boolean = false): Seq[TsNamedDecl] =
    lookupIncludeScope(qname, skipValidation).map(_._1)

  final def lookupIncludeScope(qname: TsQIdent, skipValidation: Boolean = false): Seq[(TsNamedDecl, TsTreeScope)] =
    lookupBase(Picker.All, qname, skipValidation)

  final def lookupType(qname: TsQIdent, skipValidation: Boolean = false): Seq[TsNamedDecl] =
    lookupBase(Picker.Types, qname, skipValidation).map(_._1)

  final def lookupTypeIncludeScope(qname: TsQIdent, skipValidation: Boolean = false): Seq[(TsNamedDecl, TsTreeScope)] =
    lookupBase(Picker.Types, qname, skipValidation)

  final def lookupBase[T <: TsNamedDecl](
      picker:         Picker[T],
      qname:          TsQIdent,
      skipValidation: Boolean = false,
  ): Seq[(T, TsTreeScope)] = {
    if ((TsQIdent Primitive qname) || isAbstract(qname))
      return Nil

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
      wanted:       List[TsIdent],
      loopDetector: LoopDetector,
  ): Seq[(T, TsTreeScope)] =
    loopDetector.including(wanted, this) match {
      case Left(_) =>
        Nil
      case Right(newLoopDetector) =>
        wanted match {
          case root.libName :: rest => lookupImpl(picker, rest, newLoopDetector)
          case other                => lookupImpl(picker, other, newLoopDetector)
        }
    }

  def lookupImpl[T <: TsNamedDecl](
      picker:       Picker[T],
      fragments:    List[TsIdent],
      loopDetector: LoopDetector,
  ): Seq[(T, TsTreeScope)]

  final override lazy val toString: String =
    s"TreeScope(${stack.reverse.map(_.asString).mkString(" / ")})"

  final def withinModule: Boolean =
    stack.exists {
      case _: TsDeclModule      => true
      case _: TsAugmentedModule => true
      case _ => false
    }
}

object TsTreeScope {
  trait TsLib {
    def libName: TsIdentLibrary

    /** the module resolution in typescript is somehow able to sometimes, maybe,
      *  use a module path discovered through `typings` in package.json:
      *
      *  in a given library foo:
      *  /package.json <-- {typings: typings/index.d.ts}
      *  /typings/index.d.ts <-- includes /typings/bar.d.ts
      *  /typings/bar.d.ts
      *
      *  in a downstream library you can then, sometimes, maybe, require `foo/bar` even though the module doesn't exist.
      *  Note that requiring `foo/typings/bar` will always work, even though *that* doesn't necessary refer to any javascript code!
      *
      *  utter madness.
      */
    def impliedPath:    Option[os.RelPath]
    def packageJsonOpt: Option[PackageJsonDeps]
    def tsConfig:       Option[TsConfig]
  }

  type C = mutable.Map[(String, Picker[_], List[TsIdent]), Seq[(TsNamedDecl, TsTreeScope)]]
  case class Cache(
      applyTypeMapping:  mutable.Map[TsTypeRef, ExpandTypeMappings.Res[Seq[TsMember]]] = mutable.Map.empty,
      lookupExportFrom:  C                                                             = mutable.Map.empty,
      lookupFromImports: C                                                             = mutable.Map.empty,
      replaceExports:    mutable.Map[TsIdentModule, TsDeclModule]                      = mutable.Map.empty,
      expandExport:      mutable.Map[(String, TsExport), Seq[TsNamedDecl]]             = mutable.Map.empty,
      expandImportee:    mutable.Map[(String, TsImportee), ExpandedMod]                = mutable.Map.empty,
  )
  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  def apply(
      libName:  TsIdentLibrary,
      pedantic: Boolean,
      deps:     Map[_ <: TsLib, TsParsedFile],
      logger:   Logger[Unit],
  ): TsTreeScope.Root =
    new Root(libName, pedantic, deps, logger)

  class LoopDetector private (val stack: List[Entry]) {
    def including(wanted: List[TsIdent], scope: TsTreeScope): Either[Unit, LoopDetector] = {
      val e = Entry.Idents(wanted, scope.toString)
      if (stack.contains(e)) Left(())
      else Right(new LoopDetector(e :: stack))
    }
    def including(ref: TsTypeRef, scope: TsTreeScope): Either[Unit, LoopDetector] = {
      val e = Entry.Ref(ref, scope.toString)
      if (stack.contains(e)) Left(())
      else Right(new LoopDetector(e :: stack))
    }
  }

  sealed trait Entry
  object Entry {
    final case class Idents(strings: List[TsIdent], scope: String) extends Entry
    final case class Ref(ref:        TsTypeRef, scope:     String) extends Entry
  }

  object LoopDetector {
    val initial = new LoopDetector(Nil)
  }

  final class Root private[TsTreeScope] (
      val libName:  TsIdentLibrary,
      val pedantic: Boolean,
      _deps:        Map[_ <: TsLib, TsParsedFile],
      val logger:   Logger[Unit],
      val cache:    Option[Cache] = None,
  ) extends TsTreeScope {
    override val root    = this
    override def stack   = Nil
    override def tparams = Map.empty
    override def `..`    = this
    override def tkeys   = Set.empty
    override def exports = Nil

    private lazy val depScopes = _deps.map { case (s, file) => s.libName -> ((s, file, this / file)) }

    def caching: Root = new Root(libName, pedantic, _deps, logger, Some(Cache()))

    override lazy val moduleScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = mutable.Map.empty[TsIdentModule, TsTreeScope.Scoped]
      depScopes.values.foreach {
        case (libSource, dep: TsParsedFile, depScope: Scoped) =>
          dep.modules.foreach {
            case (modName, mod) =>
              val modScope = depScope / mod
              ret += (modName -> modScope)

              libSource.impliedPath.foreach { impliedPath =>
                modName match {
                  case TsIdentModule(scopeOpt, libName :: rest) if rest.startsWith(impliedPath) =>
                    val shortenedModuleName = TsIdentModule(scopeOpt, libName :: rest.drop(impliedPath.segments.length))
                    if (!ret.contains(shortenedModuleName))
                      ret += (shortenedModuleName -> modScope)

                  case _ => ()
                }
              }
          }
      }
      ret.toMap
    }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = mutable.Map.empty[TsIdentModule, TsTreeScope.Scoped]
      depScopes.values.foreach {
        case (libSource, dep: TsParsedFile, depScope: Scoped) =>
          dep.augmentedModulesMap.foreach {
            case (modName, mod) =>
              val modScope = depScope / mod.reduce(FlattenTrees.mergeAugmentedModule)
              ret += (modName -> modScope)

              libSource.impliedPath.foreach { impliedPath =>
                modName match {
                  case TsIdentModule(scopeOpt, libName :: rest) if rest.startsWith(impliedPath) =>
                    val shortenedModuleName = TsIdentModule(scopeOpt, libName :: rest.drop(impliedPath.segments.length))
                    if (!ret.contains(shortenedModuleName))
                      ret += (shortenedModuleName -> modScope)

                  case _ => ()
                }
              }
          }
      }
      ret.toMap
    }

    override def lookupImpl[T <: TsNamedDecl](
        picker:       Picker[T],
        fragments:    List[TsIdent],
        loopDetector: LoopDetector,
    ): Seq[(T, TsTreeScope)] =
      fragments match {
        case (depName: TsIdentLibrary) :: tail =>
          depScopes.get(depName) match {
            case Some((_, dep, libScope)) => search(libScope, picker, dep, tail, loopDetector)
            case None                     => Nil
          }

        case _ =>
          depScopes
            .find(_._1 === TsIdent.std)
            .map { case (_, (_, lib, libScope)) => search(libScope, picker, lib, fragments, loopDetector) }
            .getOrElse(Nil) match {
            case Nil =>
              depScopes.values.to[Seq] flatMap {
                case (_, lib, libScope) =>
                  search(libScope, picker, lib, fragments, loopDetector)
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

  final class Scoped private[TsTreeScope] (val outer: TsTreeScope, val current: TsTree) extends TsTreeScope {
    override val root         = outer.root
    override lazy val logger  = outer.logger.withContext("scope", this)
    override val stack        = current :: outer.stack
    override def `..`         = outer
    override lazy val tparams = outer.tparams ++ HasTParams(current).map(x => x.name -> x)
    override lazy val tkeys =
      current match {
        case x: TsMemberTypeMapped => outer.tkeys + x.key
        case _ => outer.tkeys
      }

    if (stack.drop(1).contains(current)) {
      logger.fatal(s"Circular tree detected")
    }

    lazy val exports: Seq[TsExport] =
      current match {
        case x: TsContainer => x.exports
        case _ => Seq.empty
      }

    override lazy val moduleScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = outer.moduleScopes ++ (current match {
        case x: TsContainer => x.modules.mapValues(mod => this / mod)
        case _ => Map.empty
      })
      ret
    }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TsTreeScope.Scoped] = {
      val ret = outer.moduleAuxScopes ++ (current match {
        case x: TsContainer =>
          x.augmentedModulesMap.mapValues(
            mods => this / mods.reduce(FlattenTrees.mergeAugmentedModule),
          )
        case _ => Map.empty
      })
      ret
    }

    override def lookupImpl[T <: TsNamedDecl](
        Pick:         Picker[T],
        wanted:       List[TsIdent],
        loopDetector: LoopDetector,
    ): Seq[(T, TsTreeScope)] = {

      def local: Seq[(T, TsTreeScope)] =
        (wanted, current) match {
          case (Nil, Pick(x)) => Seq((x, this))
          case (frags, x: TsContainer) =>
            search(this, Pick, x, frags, loopDetector)
          case (frags, x: TsDeclVar) =>
            search(this, Pick, x, frags, loopDetector)
          case _ => Nil
        }

      def exportedFromModule: Seq[(T, TsTreeScope)] =
        current match {
          case x: TsDeclNamespaceOrModule => Exports.lookupExportFrom(this, Pick, wanted, loopDetector, x)
          case _ => Nil
        }

      def importedFromModule: Seq[(T, TsTreeScope)] =
        current match {
          case x: TsContainer =>
            Imports.lookupFromImports(this, Pick, wanted, loopDetector, x.imports)
          case _ => Nil
        }

      def augmentedModule: Seq[(T, TsTreeScope)] =
        current match {
          case x: TsAugmentedModule =>
            moduleScopes.get(x.name) match {
              case Some(xx) => xx.lookupInternal(Pick, wanted, loopDetector)
              case None     => Nil
            }

          case x: TsDeclModule =>
            moduleAuxScopes.get(x.name) match {
              case Some(xx) => xx lookupInternal (Pick, wanted, loopDetector)
              case None     => Nil
            }

          case _ => Nil
        }

      def fromGlobals: Seq[(T, TsTreeScope)] =
        (wanted, current) match {
          case (TsIdent.Global :: tail, x: TsContainer) =>
            val globalOpt = x.unnamed collectFirst { case x: TsGlobal => x }
            globalOpt match {
              case Some(global) =>
                search(this, Pick, global, tail, loopDetector)
              case None => Nil
            }
          case _ => Nil
        }

      def prototype: Seq[(T, TsTreeScope)] =
        wanted match {
          case head :: TsIdent.prototype :: tail :: Nil =>
            lookupInternal(Picker.HasClassMemberss, head :: Nil, loopDetector).flatMap {
              case (cls, newScope) =>
                cls.membersByName.get(tail) match {
                  case Some(found) =>
                    found
                      .flatMap(
                        member => Hoisting.memberToDecl(cls.codePath + TsIdent.prototype, JsLocation.Zero)(member),
                      )
                      .collect {
                        case Pick(x) => (x, newScope)
                      }
                  case None => Nil
                }
            }
          case _ => Nil
        }

      var ret: Seq[(T, TsTreeScope)] = Nil

      if (current.isInstanceOf[TsDecl] || current.isInstanceOf[TsContainer]) {
        ret = local

        if (ret.isEmpty)
          ret = importedFromModule
        if (ret.isEmpty)
          ret = augmentedModule
        if (ret.isEmpty)
          ret = exportedFromModule
        if (ret.isEmpty)
          ret = fromGlobals
        if (ret.isEmpty && !wanted.headOption.contains(TsIdent.dummy)) //optimization
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
      wanted:       List[TsIdent],
      loopDetector: LoopDetector,
  ): Seq[(T, TsTreeScope)] =
    wanted match {
      case Nil =>
        c match {
          case Pick(x) => Seq((x, scope / x))
          case _       => Nil
        }

      case one :: Nil =>
        c match {
          case cc: TsContainer =>
            cc.membersByNameMeh get one match {
              case Some(decls) => decls collect { case Pick(x) => (x, scope / x) }
              case None        => Nil
            }

          case TsDeclVar(_, _, _, _, Some(tpe), _, jsLocation, cp, false) =>
            Hoisting.fromType(scope, cp, jsLocation, loopDetector, tpe).collect {
              case Pick(x) if one === x.name => x -> scope
            }

          case _ => Nil
        }

      case h :: t =>
        c match {
          case cc: TsContainer =>
            cc.membersByName get h orElse cc.membersByNameMeh.get(h) match {
              case Some(decls) =>
                decls flatMap {

                  /** Yeah, enums aren't too well integrated with the rest.
                    *  On the positive side it feels almost as hacked in in typescript
                    */
                  case x: TsDeclEnum if t.length === 1 =>
                    val member = x.members.find(_.name === t.head).toList.flatMap { m =>
                      val fakeTa = {
                        val codePath = x.exportedFrom.fold(x.codePath.forceHasPath.codePath)(_.name).parts match {
                          case Nil             => sys.error("Unexpected empty codePath")
                          case libName :: rest => CodePath.HasPath(libName, TsQIdent(rest :+ m.name))
                        }
                        TsDeclTypeAlias(NoComments, false, m.name, Nil, TsExpr.typeOfOpt(m.expr), codePath)
                      }

                      def fakeVar = {
                        val loc = x.jsLocation + m.name
                        TsDeclVar(NoComments, false, true, m.name, None, m.expr, loc, x.codePath + m.name, false)
                      }
                      if (x.isConst) List(fakeTa) else List(fakeTa, fakeVar)
                    }

                    member.collect {
                      case Pick(x) => x -> scope
                    }
                  case x: TsContainer =>
                    (scope / x).lookupInternal(Pick, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(_: TsTypeThis), _, _, _, false) =>
                    // this is the second part of the aws-sdk hack, see HandleCommonJsModules
                    search(scope, Pick, c, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(tpe), _, jsLocation, cp, false) =>
                    Hoisting.fromType(scope, cp, jsLocation, loopDetector, tpe).collect {
                      case Pick(x) if t.headOption.contains(x.name) => x -> scope
                    }

                  case _ => Nil
                }
              case None => Nil
            }
          case _ => Nil
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
      wanted:       List[TsIdent],
      loopDetector: LoopDetector,
  ): Seq[(T, TsTreeScope)] =
    scope.current match {
      case x: TsDeclNamespace =>
        val p: Picker[TsDeclNamespace] = {
          case xx: TsDeclNamespace if xx.codePath =/= x.codePath => Some(xx)
          case _ => None
        }
        scope.`..`.lookupInternal(p, List(x.name), loopDetector).flatMap {
          case (c, extScope) =>
            TsTreeScope.search(extScope, Pick, c, wanted, loopDetector)
        }
      case _ => Nil
    }

}
