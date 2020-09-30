package org.scalablytyped.converter.internal
package ts.modules

import org.scalablytyped.converter.internal.ts.TsTreeScope.{ImportCacheKey, LoopDetector}
import org.scalablytyped.converter.internal.ts._

object Imports {
  def lookupFromImports[T <: TsNamedDecl](
      scope:        TsTreeScope.Scoped,
      Pick:         Picker[T],
      wanted:       IArray[TsIdent],
      loopDetector: LoopDetector,
      imports:      IArray[TsImport],
  ): IArray[(T, TsTreeScope)] = {
    lazy val key = ImportCacheKey(scope, Pick, wanted)

    if (scope.root.cache.isDefined && scope.root.cache.get.imports.contains(key)) {
      return scope.root.cache.get.imports(key).asInstanceOf[IArray[(T, TsTreeScope)]]
    }

    val ret: IArray[(T, TsTreeScope)] =
      pickImport(imports, wanted).flatMap { chosenImport =>
        val expanded: ExpandedMod = expandImportee(chosenImport.from, scope, loopDetector)

        chosenImport.imported.flatMap {
          case TsImportedStar(Some(renamed)) =>
            val all: IArray[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)

                case ExpandedMod.Whole(defaults, namespaceds, rest, _) =>
                  val ns = TsDeclNamespace(
                    NoComments,
                    declared = false,
                    renamed,
                    rest ++ defaults,
                    CodePath.NoPath,
                    JsLocation.Zero,
                  )

                  ns +: namespaceds.map(n => n.withName(renamed))
              }
            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedStar(None) =>
            val all: IArray[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)
                case ExpandedMod.Whole(defaults, namespaceds, rest, _) =>
                  rest.collect { case x: TsNamedDecl => x } ++ defaults ++ namespaceds
              }

            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedIdent(ident) =>
            val all: IArray[TsNamedDecl] =
              expanded match {
                case ExpandedMod.Picked(things) =>
                  things.map(_._1)
                case ExpandedMod.Whole(defaults, _, _, _) if defaults.nonEmpty =>
                  defaults.map(_.withName(ident))
                case ExpandedMod.Whole(_, namespaceds, rest, _) =>
                  val ns = TsDeclNamespace(
                    NoComments,
                    false,
                    ident,
                    rest,
                    CodePath.NoPath,
                    JsLocation.Zero,
                  )
                  namespaceds.map(_.withName(ident)) :+ ns
              }

            Utils.searchAmong(scope, Pick, wanted, all, loopDetector)

          case TsImportedDestructured(idents: IArray[(TsIdent, Option[TsIdentSimple])]) =>
            val all: IArray[TsNamedDecl] =
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
                  case IArray.headTail(`renamed`, rest) => ident +: rest
                  case other                            =>
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
      scope.root.cache.get.imports.put(key, ret)
    }

    ret
  }

  def expandImportee(from: TsImportee, scope: TsTreeScope, loopDetector: LoopDetector): ExpandedMod = {
    lazy val key = (scope, from)

    if (scope.root.cache.isDefined && scope.root.cache.get.expandImportee.contains(key)) {
      return scope.root.cache.get.expandImportee(key)
    }

    val ret: ExpandedMod = from match {
      case TsImporteeRequired(fromModule) =>
        scope.moduleScopes.get(fromModule) match {
          case Some(modScope @ TsTreeScope.Scoped(_, mod: TsDeclModule)) =>
            val newMod: TsDeclModule = CachedReplaceExports(modScope.`..`, loopDetector, mod)

            val withAugmented: TsDeclModule =
              scope.moduleAuxScopes.get(fromModule) match {
                case Some(auxScope @ TsTreeScope.Scoped(_, aux: TsAugmentedModule)) =>
                  val rewritten =
                    if (aux.exports.nonEmpty)
                      new ReplaceExports(loopDetector).visitTsAugmentedModule(auxScope.`..`)(aux)
                    else aux
                  FlattenTrees.mergeModuleAndAugmented(rewritten, newMod)
                case _ => newMod
              }

            val (namespaceds, rest, _) = withAugmented.members.partitionCollect2(
              { case x: TsNamedDecl if x.name === TsIdent.namespaced => x },
              { case x: TsNamedDecl                                  => DeriveCopy(x, CodePath.NoPath, None) },
            )

            ExpandedMod.Whole(Empty, namespaceds, rest.flatten, modScope)
          case _ =>
            scope.fatalMaybe(s"Couldn't find expected module $fromModule")
            ExpandedMod.Picked(Empty)
        }

      case TsImporteeFrom(fromModule) =>
        scope.moduleScopes.get(fromModule) match {
          case Some(modScope @ TsTreeScope.Scoped(_, mod: TsDeclModule)) =>
            val newMod = CachedReplaceExports(modScope.`..`, loopDetector, mod)

            val withAugmented: TsDeclModule =
              scope.moduleAuxScopes.get(fromModule) match {
                case Some(auxScope @ TsTreeScope.Scoped(_, aux: TsAugmentedModule)) =>
                  val rewritten =
                    if (aux.exports.nonEmpty)
                      new ReplaceExports(loopDetector).visitTsAugmentedModule(auxScope.`..`)(aux)
                    else aux
                  FlattenTrees.mergeModuleAndAugmented(rewritten, newMod)
                case _ => newMod
              }

            val (defaults, namespaceds, rest, _) = withAugmented.members.partitionCollect3(
              { case x: TsNamedDecl if x.name === TsIdent.default    => x },
              { case x: TsNamedDecl if x.name === TsIdent.namespaced => x },
              { case x: TsNamedDecl                                  => x },
            )

            ExpandedMod.Whole(defaults, namespaceds, rest, modScope)
          case _ =>
            //scope.logger.fatalMaybe(s"Couldn't find expected module $fromModule", constants.Pedantic)
            ExpandedMod.Picked(Empty)
        }

      case TsImporteeLocal(qident) =>
        ExpandedMod.Picked(scope.lookupInternal(Picker.NotModules, qident.parts, loopDetector))
    }

    if (scope.root.cache.isDefined && ret.nonEmpty) {
      scope.root.cache.get.expandImportee.put(key, ret)
    }

    ret

  }

  def pickImport(imports: IArray[TsImport], wanted: IArray[TsIdent]): IArray[TsImport] =
    imports.mapNotNone(validImport(wanted))

  def validImport(wanted: IArray[TsIdent])(i: TsImport): Option[TsImport] =
    wanted match {
      case IArray.Empty => None
      case IArray.first(first) =>
        val newImported: IArray[TsImported] = i.imported.mapNotNone {
          case im @ TsImportedIdent(`first`) =>
            Some(im)

          case TsImportedIdent(_) => None

          case TsImportedDestructured(idents) =>
            idents.collectFirst {
              case t @ (`first`, None)    => TsImportedDestructured(IArray(t))
              case t @ (_, Some(`first`)) => TsImportedDestructured(IArray(t))
            }

          case im @ TsImportedStar(Some(`first`)) =>
            Some(im)
          case TsImportedStar(_) => None
        }

        if (newImported.nonEmpty) Some(i.copy(imported = newImported)) else None
    }
}
