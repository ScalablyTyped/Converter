package com.olvind.tso
package ts

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.modules.{ExpandedMod, Exports, Imports}
import sourcecode.{Enclosing, File, Line, Text}

import scala.collection.mutable

/**
  * The facility for looking up types and terms in a given tree.
  */
sealed trait TreeScope {
  val root: TreeScope.Root
  def logger:          Logger[Unit]
  def stack:           List[TsTree]
  def tparams:         Map[TsIdent, TsTypeParam]
  def tkeys:           Set[TsIdent]
  def `..`           : TreeScope
  def moduleScopes:    Map[TsIdentModule, TreeScope.Scoped]
  def moduleAuxScopes: Map[TsIdentModule, TreeScope.Scoped]
  def exports:         Seq[TsExport]

  def fatalMaybe[T: Formatter](t: Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
    if (root.pedantic) logger.fatal(t) else logger.warn(t)

  final def /(current: TsTree): TreeScope.Scoped =
    new TreeScope.Scoped(this, current)

  final def surroundingTsContainer: Option[TsContainer] =
    this match {
      case TreeScope.Scoped(_, x: TsContainer) => Some(x)
      case TreeScope.Scoped(outer, _) => outer.surroundingTsContainer
      case _: TreeScope.Root => None
    }

  final def surroundingHasMembers: Option[HasClassMembers] =
    this match {
      case TreeScope.Scoped(_, x: HasClassMembers) => Some(x)
      case TreeScope.Scoped(outer, _) => outer.surroundingHasMembers
      case _: TreeScope => None
    }

  final def lookup(qname: TsQIdent, skipValidation: Boolean = false): Seq[TsNamedDecl] =
    lookupIncludeScope(qname, skipValidation).map(_._1)

  final def lookupIncludeScope(qname: TsQIdent, skipValidation: Boolean = false): Seq[(TsNamedDecl, TreeScope)] =
    lookupBase(Picker.All, qname, skipValidation)

  final def lookupType(qname: TsQIdent, skipValidation: Boolean = false): Seq[TsNamedDecl] =
    lookupBase(Picker.Types, qname, skipValidation).map(_._1)

  final def lookupTypeIncludeScope(qname: TsQIdent, skipValidation: Boolean = false): Seq[(TsNamedDecl, TreeScope)] =
    lookupBase(Picker.Types, qname, skipValidation)

  final def lookupBase[T <: TsNamedDecl](picker:         Picker[T],
                                         qname:          TsQIdent,
                                         skipValidation: Boolean = false): Seq[(T, TreeScope)] = {
    if (TsQIdent Primitive qname)
      return Nil

    if (qname.parts.length === 1 && (tparams.contains(qname.parts.head) || tkeys(qname.parts.head)))
      return Nil

    val loopDetector = new LoopDetector

    val res = lookupInternal(picker, qname.parts, loopDetector)

    if (res.isEmpty && !skipValidation && root.pedantic) {
      //unused, it's just for easier debugging
      lookupInternal(picker, qname.parts, loopDetector)

      logger.fatal(s"Cannot resolve $qname")
    } else res
  }

  final def lookupInternal[T <: TsNamedDecl](picker:       Picker[T],
                                             wanted:       List[TsIdent],
                                             loopDetector: LoopDetector): Seq[(T, TreeScope)] =
    loopDetector.including(wanted, this) match {
      case Left(_) =>
        Nil
      case Right(newLoopDetector) =>
        wanted match {
          case root.libName :: rest => lookupImpl(picker, rest, newLoopDetector)
          case other                => lookupImpl(picker, other, newLoopDetector)
        }
    }

  def lookupImpl[T <: TsNamedDecl](picker:       Picker[T],
                                   fragments:    List[TsIdent],
                                   loopDetector: LoopDetector): Seq[(T, TreeScope)]

  final override lazy val toString: String =
    s"TreeScope(${stack.reverse.map(_.asString).mkString(" / ")})"

  final def withinModule: Boolean =
    stack.exists {
      case _: TsDeclModule      => true
      case _: TsAugmentedModule => true
      case _ => false
    }
}

object TreeScope {
  type C = mutable.Map[(String, Picker[_], List[TsIdent]), Seq[(TsNamedDecl, TreeScope)]]
  case class Cache(
      applyTypeMapping:  mutable.Map[TsTypeRef, Option[TsDeclInterface]]   = mutable.Map.empty,
      lookupExportFrom:  C                                                 = mutable.Map.empty,
      lookupFromImports: C                                                 = mutable.Map.empty,
      replaceExports:    mutable.Map[TsIdentModule, TsDeclModule]          = mutable.Map.empty,
      expandExport:      mutable.Map[(String, TsExport), Seq[TsNamedDecl]] = mutable.Map.empty,
      expandImportee:    mutable.Map[(String, TsImportee), ExpandedMod]    = mutable.Map.empty,
  )
  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  def apply(libName:  TsIdentLibrary,
            pedantic: Boolean,
            deps:     Map[TsIdentLibrary, TsParsedFile],
            logger:   Logger[Unit]): TreeScope.Root =
    new Root(libName, pedantic, deps, logger)

  class LoopDetector private (val stack: List[(List[TsIdent], String)]) {
    def this() = this(Nil)

    def including(wanted: List[TsIdent], scope: TreeScope): Either[Unit, LoopDetector] = {
      val tuple = (wanted, scope.toString)
      if (stack.contains(tuple)) Left(())
      else Right(new LoopDetector(tuple :: stack))
    }
  }

  final class Root private[TreeScope] (val libName:  TsIdentLibrary,
                                       val pedantic: Boolean,
                                       _deps:        Map[TsIdentLibrary, TsParsedFile],
                                       val logger:   Logger[Unit],
                                       val cache:    Option[Cache] = None)
      extends TreeScope {
    override val root          = this
    override def stack         = Nil
    override def tparams       = Map.empty
    override def `..`          = this
    override def tkeys         = Set.empty
    override def exports       = Nil
    private lazy val depScopes = _deps mapValues (f => (f, this / f))

    def caching: Root = new Root(libName, pedantic, _deps, logger, Some(Cache()))

    override lazy val moduleScopes: Map[TsIdentModule, TreeScope.Scoped] = {
      val ret = mutable.Map.empty[TsIdentModule, TreeScope.Scoped]
      depScopes.values.foreach {
        case (dep: TsParsedFile, depScope: Scoped) =>
          dep.modules.foreach {
            case (modName, mod) => ret += (modName -> depScope / mod)
          }
      }
      ret.toMap
    }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TreeScope.Scoped] =
      depScopes.values.foldLeft(Map.empty[TsIdentModule, TreeScope.Scoped]) {
        case (mods, (dep, depScope)) =>
          mods ++ dep.augmentedModulesMap.mapValues(
            mod => depScope / mod.reduce(FlattenTrees.mergeAugmentedModule)
          )
      }

    override def lookupImpl[T <: TsNamedDecl](picker:       Picker[T],
                                              fragments:    List[TsIdent],
                                              loopDetector: LoopDetector): Seq[(T, TreeScope)] =
      fragments match {
        case (depName: TsIdentLibrary) :: tail =>
          depScopes.get(depName) match {
            case Some((dep, libScope)) => search(libScope, picker, dep, tail, loopDetector)
            case None                  => Nil
          }

        case _ =>
          depScopes.values.to[Seq] flatMap {
            case (lib, libScope) =>
              search(libScope, picker, lib, fragments, loopDetector)
          }
      }
  }

  object Scoped {
    def unapply(ts: TreeScope): Option[(TreeScope, TsTree)] =
      ts match {
        case x: Scoped => Some((x.outer, x.current))
        case _: Root   => None
      }
  }

  final class Scoped private[TreeScope] (val outer: TreeScope, val current: TsTree) extends TreeScope {
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

    override lazy val moduleScopes: Map[TsIdentModule, TreeScope.Scoped] = {
      val ret = outer.moduleScopes ++ (current match {
        case x: TsContainer => x.modules.mapValues(mod => this / mod)
        case _ => Map.empty
      })
      ret
    }

    override lazy val moduleAuxScopes: Map[TsIdentModule, TreeScope.Scoped] = {
      val ret = outer.moduleAuxScopes ++ (current match {
        case x: TsContainer =>
          x.augmentedModulesMap.mapValues(
            mods => this / mods.reduce(FlattenTrees.mergeAugmentedModule)
          )
        case _ => Map.empty
      })
      ret
    }

    override def lookupImpl[T <: TsNamedDecl](Pick:         Picker[T],
                                              wanted:       List[TsIdent],
                                              loopDetector: LoopDetector): Seq[(T, TreeScope)] = {

      def local: Seq[(T, TreeScope)] =
        (wanted, current) match {
          case (Nil, Pick(x)) => Seq((x, this))
          case (frags, x: TsContainer) =>
            search(this, Pick, x, frags, loopDetector)
          case (frags, x: TsDeclVar) =>
            search(this, Pick, x, frags, loopDetector)
          case _ => Nil
        }

      def exportedFromModule: Seq[(T, TreeScope)] =
        current match {
          case x: TsDeclNamespaceOrModule => Exports.lookupExportFrom(this, Pick, wanted, loopDetector, x)
          case _ => Nil
        }

      def importedFromModule: Seq[(T, TreeScope)] =
        current match {
          case x: TsContainer =>
            Imports.lookupFromImports(this, Pick, wanted, loopDetector, x.imports)
          case _ => Nil
        }

      def augmentedModule: Seq[(T, TreeScope)] =
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

      def fromGlobals: Seq[(T, TreeScope)] =
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

      def prototype: Seq[(T, TreeScope)] =
        wanted match {
          case head :: TsIdent.prototype :: tail :: Nil =>
            lookupInternal(Picker.HasClassMemberss, head :: Nil, loopDetector).flatMap {
              case (cls, newScope) =>
                cls.membersByName.get(tail) match {
                  case Some(found) =>
                    val hoisted = found.flatMap(
                      member => Hoisting.memberToDecl(cls.codePath.forceHasPath + TsIdent.prototype)(member)
                    )
                    hoisted.collect {
                      case Pick(x) => (x, newScope)
                    }
                  case None => Nil
                }
            }
          case _ => Nil
        }

      var ret: Seq[(T, TreeScope)] = Nil

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

  def search[T <: TsNamedDecl](scope:        TreeScope,
                               Pick:         Picker[T],
                               c:            TsTree,
                               wanted:       List[TsIdent],
                               loopDetector: LoopDetector): Seq[(T, TreeScope)] =
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
              case Some(Seq(Pick(x: TsDeclEnum with T))) => Seq((x, scope / x))
              case Some(decls) => decls collect { case Pick(x) => (x, scope / x) }
              case None        => Nil
            }

          case TsDeclVar(_, _, _, _, Some(tr: TsTypeRef), _, _, cp: CodePath.HasPath, false) =>
            Hoisting.hoistedMembersFrom(scope, cp, loopDetector)(tr).collect {
              case Pick(x) if one === x.name => x -> scope
            }
          case _ => Nil
        }

      case h :: t =>
        c match {
          case cc: TsContainer =>
            cc.membersByNameMeh get h match {
              case Some(Seq(Pick(x: TsDeclEnum with T))) => Seq((x, scope / x))
              case Some(decls) =>
                decls flatMap {
                  case x: TsContainer =>
                    (scope / x).lookupInternal(Pick, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(_: TsTypeThis), _, _, _, false) =>
                    search(scope, Pick, c, t, loopDetector)
                  case TsDeclVar(_, _, _, _, Some(tr: TsTypeRef), _, _, cp: CodePath.HasPath, false) =>
                    Hoisting.hoistedMembersFrom(scope, cp, loopDetector)(tr).collect {
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
  def apply[T <: TsNamedDecl](scope:        TreeScope.Scoped,
                              Pick:         Picker[T],
                              wanted:       List[TsIdent],
                              loopDetector: LoopDetector): Seq[(T, TreeScope)] =
    scope.current match {
      case x: TsDeclNamespace =>
        val p: Picker[TsDeclNamespace] = {
          case xx: TsDeclNamespace if xx.codePath =/= x.codePath => Some(xx)
          case _ => None
        }
        scope.`..`.lookupInternal(p, List(x.name), loopDetector).flatMap {
          case (c, extScope) =>
            TreeScope.search(extScope, Pick, c, wanted, loopDetector)
        }
      case _ => Nil
    }

}
