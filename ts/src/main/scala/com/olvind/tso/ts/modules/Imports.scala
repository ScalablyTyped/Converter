package com.olvind.tso
package ts.modules

import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts._

object Imports {
  def lookupFromImports[T <: TsNamedDecl](
      scope:        TreeScope.Scoped,
      Pick:         Picker[T],
      wanted:       List[TsIdent],
      loopDetector: LoopDetector,
      imports:      Seq[TsImport]
  ): Seq[(T, TreeScope)] = {
    lazy val key: (String, Picker[T], List[TsIdent]) = (scope.toString, Pick, wanted)

    if (scope.root.cache.isDefined && scope.root.cache.get.lookupFromImports.contains(key)) {
      return scope.root.cache.get.lookupFromImports(key).asInstanceOf[Seq[(T, TreeScope)]]
    }

    val ret: Seq[(T, TreeScope)] =
      pickImport(imports, wanted) flatMap { chosenImport =>
        val expanded: ExpandedMod = expandImportee(chosenImport.from, scope, loopDetector)

        chosenImport.imported.flatMap {
          case TsImportedStar(Some(renamed)) =>
            val all: Seq[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)

                case ExpandedMod.Whole(defaults, namespaceds, rest, _) =>
                  val ns = TsDeclNamespace(
                    NoComments,
                    declared = false,
                    TsIdentNamespace(renamed.value),
                    rest ++ defaults,
                    CodePath.NoPath,
                    JsLocation.Zero
                  )

                  ns +: namespaceds.map(n => n.withName(renamed))
              }
            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedStar(None) =>
            val all: Seq[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)
                case ExpandedMod.Whole(defaults, namespaceds, rest, _) =>
                  rest.collect { case x: TsNamedDecl => x } ++ defaults ++ namespaceds
              }

            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedIdent(ident) =>
            val all: Seq[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)
                case ExpandedMod.Whole(defaults, _, _, _) if defaults.nonEmpty =>
                  defaults.map(_.withName(ident))
                case ExpandedMod.Whole(_, namespaceds, rest, _) =>
                  val ns = TsDeclNamespace(NoComments,
                                           false,
                                           TsIdentNamespace(ident.value),
                                           rest,
                                           CodePath.NoPath,
                                           JsLocation.Zero)
                  namespaceds.map(_.withName(ident)) :+ ns
              }

            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedDestructured(idents: List[(TsIdent, Option[TsIdent])]) =>
            val all: Seq[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)
                case ExpandedMod.Whole(defaults, namespaceds, rest, _) =>
                  defaults ++ namespaceds ++ rest.collect { case x: TsNamedDecl => x }
              }

            // this relies on filtering the import in `pickImport`
            idents.flatMap {
              case (_, None) =>
                Utils.searchAmong(scope, Pick, wanted, all, loopDetector)
              case (ident, Some(renamed)) =>
                val newWanted = wanted match {
                  case `renamed` :: rest => ident :: rest
                  case other             =>
                    /* complain i guess? */
                    other
                }
                Utils.searchAmong(scope, Pick, newWanted, all, loopDetector).map {
                  case (t, s) => t.withName(renamed).asInstanceOf[T] -> s
                }
            }
        }
      }

    if (scope.root.cache.isDefined && ret.nonEmpty) {
      scope.root.cache.get.lookupFromImports.put(key, ret)
    }

    ret
  }

  def expandImportee(from: TsImportee, scope: TreeScope, loopDetector: LoopDetector): ExpandedMod = {
    lazy val key = (scope.toString, from)

    if (scope.root.cache.isDefined && scope.root.cache.get.expandImportee.contains(key)) {
      return scope.root.cache.get.expandImportee(key)
    }

    val ret: ExpandedMod = from match {
      case TsImporteeRequired(fromModule) =>
        scope.moduleScopes get fromModule match {
          case Some(modScope @ TreeScope.Scoped(_, mod: TsDeclModule)) =>
            val newMod: TsDeclModule = CachedReplaceExports(modScope.`..`, loopDetector, mod)

            val withAugmented: TsDeclModule =
              scope.moduleAuxScopes.get(fromModule) match {
                case Some(auxScope @ TreeScope.Scoped(_, aux: TsAugmentedModule)) =>
                  val rewritten =
                    if (aux.exports.nonEmpty)
                      new ReplaceExports(loopDetector).visitTsAugmentedModule(auxScope.`..`)(aux)
                    else aux
                  FlattenTrees.mergeModuleAndAugmented(rewritten, newMod)
                case _ => newMod
              }

            val (namespaceds, rest) = withAugmented.members.partitionCollect {
              case x: TsNamedDecl if x.name === TsIdent.namespaced => x
            }

            ExpandedMod.Whole(Nil, namespaceds, rest, modScope)
          case _ =>
            scope.logger.fatalMaybe(s"Couldn't find expected module $fromModule", constants.Pedantic)
            ExpandedMod.Picked(Nil)
        }

      case TsImporteeFrom(fromModule) =>
        scope.moduleScopes get fromModule match {
          case Some(modScope @ TreeScope.Scoped(_, mod: TsDeclModule)) =>
            val newMod = CachedReplaceExports(modScope.`..`, loopDetector, mod)

            val withAugmented: TsDeclModule =
              scope.moduleAuxScopes.get(fromModule) match {
                case Some(auxScope @ TreeScope.Scoped(_, aux: TsAugmentedModule)) =>
                  val rewritten =
                    if (aux.exports.nonEmpty)
                      new ReplaceExports(loopDetector).visitTsAugmentedModule(auxScope.`..`)(aux)
                    else aux
                  FlattenTrees.mergeModuleAndAugmented(rewritten, newMod)
                case _ => newMod
              }

            val (defaults, namespaceds, rest) = withAugmented.members.partitionCollect2(
              { case x: TsNamedDecl if x.name === TsIdent.default    => x },
              { case x: TsNamedDecl if x.name === TsIdent.namespaced => x },
            )

            ExpandedMod.Whole(defaults, namespaceds, rest, modScope)
          case _ =>
            //scope.logger.fatalMaybe(s"Couldn't find expected module $fromModule", constants.Pedantic)
            ExpandedMod.Picked(Nil)
        }

      case TsImporteeLocal(qident) =>
        ExpandedMod.Picked(scope.lookupInternal(Picker.NotModules, qident.parts, loopDetector))
    }

    if (scope.root.cache.isDefined && ret.nonEmpty) {
      scope.root.cache.get.expandImportee.put(key, ret)
    }

    ret

  }

  def pickImport(imports: Seq[TsImport], wanted: List[TsIdent]): Seq[TsImport] =
    imports flatMap validImport(wanted)

  def validImport(wanted: List[TsIdent])(i: TsImport): Option[TsImport] =
    wanted match {
      case Nil => None
      case first :: _ =>
        val newImported: Seq[TsImported] = i.imported flatMap {
          case im @ TsImportedIdent(`first`) =>
            Some(im)

          case TsImportedIdent(_) => None

          case TsImportedDestructured(idents) =>
            idents collectFirst {
              case t @ (`first`, None)    => TsImportedDestructured(t :: Nil)
              case t @ (_, Some(`first`)) => TsImportedDestructured(t :: Nil)
            }

          case im @ TsImportedStar(Some(`first`)) =>
            Some(im)
          case im @ TsImportedStar(None) =>
            Some(im)
          case TsImportedStar(Some(_)) =>
            None
        }

        if (newImported.nonEmpty) Some(i.copy(imported = newImported)) else None
    }
}
