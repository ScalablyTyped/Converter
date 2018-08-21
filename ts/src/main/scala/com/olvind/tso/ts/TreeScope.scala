package com.olvind.tso
package ts

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.modules.{Exports, Imports}

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

    if (res.isEmpty && !skipValidation && constants.Pedantic) {
      //unused, it's just for easier debugging
      lookupInternal(picker, qname.parts, loopDetector)

      logger.fatal(s"Cannot resolve $qname")
    } else res
  }

  final def lookupInternal[T <: TsNamedDecl](picker:       Picker[T],
                                             wanted:       List[TsIdent],
                                             loopDetector: LoopDetector): Seq[(T, TreeScope)] =
    loopDetector.including(wanted, this) match {
      case Left(_) => Nil
      case Right(newLoopDetector) =>
        def withinModule(name: TsIdentModule): Boolean =
          stack.exists {
            case x: TsAugmentedModule => x.name === name
            case x: TsDeclModule      => x.name === name
            case _ => false
          }
        wanted match {
          case (_: TsIdentLibrary) :: (mod: TsIdentModule) :: rest if !withinModule(mod) =>
            moduleScopes(mod).lookupImpl(picker, rest, newLoopDetector)
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
  type Cache = mutable.Map[(String, Picker[_], List[TsIdent]), Seq[(TsNamedDecl, TreeScope)]]

  implicit val ScopedFormatter: Formatter[Scoped] = _.toString

  def apply(libName: TsIdentLibrary, deps: Map[TsIdentLibrary, TsParsedFile], logger: Logger[Unit]): TreeScope.Root =
    new Root(libName, deps, logger)

  class LoopDetector private (val stack: List[(List[TsIdent], String)]) {
    def this() = this(Nil)

    def including(wanted: List[TsIdent], scope: TreeScope): Either[Unit, LoopDetector] = {
      val tuple = (wanted, scope.toString)
      if (stack.contains(tuple)) Left(())
      else Right(new LoopDetector(tuple :: stack))
    }
  }

  def isFullyQualified(wanted: List[TsIdent]): Boolean =
    wanted.headOption match {
      case Some(_: TsIdentLibrary) => true
      case _ => false
    }

  final class Root private[TreeScope] (val libName: TsIdentLibrary,
                                       _deps:       Map[TsIdentLibrary, TsParsedFile],
                                       val logger:  Logger[Unit],
                                       val cache:   Option[Cache] = None)
      extends TreeScope {
    override val root          = this
    override def stack         = Nil
    override def tparams       = Map.empty
    override def `..`          = this
    override def tkeys         = Set.empty
    override def exports       = Nil
    private lazy val depScopes = _deps mapValues (f => (f, this / f))

    def caching: Root = new Root(libName, _deps, logger, Some(mutable.Map.empty))

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

    lazy val exports: Seq[TsExport] =
      outer.exports ++ (current match {
        case x: TsContainer => x.exports
        case _ => Seq.empty
      })

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
          case (Nil, Pick(x))                      => Seq((x, this))
          case (h :: Nil, Pick(x)) if x.name === h => Seq((x, this))
          case (frags, x: TsContainer) =>
            search(this, Pick, x, frags, loopDetector)

          case _ => Nil
        }

      def exportedFromModule: Seq[(T, TreeScope)] =
        current match {
          case _: TsDeclModule =>
            FirstNonEmpty(
              () => Exports.lookupExportFrom(this, Pick, wanted, loopDetector),
              () =>
                if (!wanted.contains(TsIdent.namespaced) && !wanted.contains(TsIdent.default))
                  Exports.lookupExportFrom(this, Pick, TsIdent.namespaced +: wanted, loopDetector)
                else Nil
            ).getOrElse(Nil)

          case _ => Nil
        }

      def augmentedModule: Seq[(T, TreeScope)] =
        current match {
          case x: TsAugmentedModule =>
            moduleScopes.get(x.name) match {
              case Some(x) => x.lookupInternal(Pick, wanted, loopDetector)
              case None    => Nil
            }

          case x: TsDeclModule =>
            moduleAuxScopes.get(x.name) match {
              case Some(x) => x lookupInternal (Pick, wanted, loopDetector)
              case None    => Nil
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
          ret = exportedFromModule
        if (ret.isEmpty)
          ret = surroundingTsContainer
            .flatMap(container => Imports.lookupFromImports(this, Pick, wanted, loopDetector, container.imports))
            .getOrElse(Nil)
        if (ret.isEmpty)
          ret = augmentedModule
        if (ret.isEmpty)
          ret = fromGlobals
        if (ret.isEmpty)
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
                               c:            TsContainer,
                               wanted:       List[TsIdent],
                               loopDetector: LoopDetector): Seq[(T, TreeScope)] =
    wanted match {
      case Nil =>
        c match {
          case Pick(x) => Seq((x, scope / x))
          case _       => Nil
        }

      case one :: Nil =>
        val ret = c.membersByNameMeh get one match {
          case Some(Seq(Pick(x: TsDeclEnum with T))) => Seq((x, scope / x))
          case Some(decls) => decls collect { case Pick(x) => (x, scope / x) }
          case None        => Nil
        }
        ret

      case h :: t =>
        c.membersByNameMeh get h match {
          case Some(Seq(Pick(x: TsDeclEnum with T))) => Seq((x, scope / x))
          case Some(decls) =>
            decls flatMap {
//              case x: TsContainer => search(scope / x, Pick, x, t)
              case x: TsContainer => (scope / x).lookupInternal(Pick, t, loopDetector)
              case TsDeclVar(_, _, _, _, Some(tr: TsTypeRef), _, _, cp: CodePath.HasPath, false) =>
                val hoisted = TsParsedFile(NoComments,
                                           Nil,
                                           Hoisting.hoistedMembersFrom(scope, cp, loopDetector)(tr),
                                           CodePath.NoPath)
                scope / hoisted lookupInternal (Pick, t, loopDetector)
              case _ => Nil
            }
          case None => Nil
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
//            extScope.lookupInternal(Pick, wanted, loopDetector)
            TreeScope.search(extScope, Pick, c, wanted, loopDetector)
        }
      case _ => Nil
    }

}
