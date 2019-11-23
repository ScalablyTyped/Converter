package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.transforms.SetCodePath

object Exports {
  def expandExport(
      scope:        TsTreeScope,
      jsLocation:   ModuleSpec => JsLocation,
      e:            TsExport,
      loopDetector: LoopDetector,
      owner:        TsDeclNamespaceOrModule,
  ): Seq[TsNamedDecl] = {

    lazy val key = (scope.toString, e)

    if (scope.root.cache.isDefined && scope.root.cache.get.expandExport.contains(key)) {
      return scope.root.cache.get.expandExport(key)
    }

    val codePath = owner.codePath.forceHasPath

    val ret: Seq[TsNamedDecl] = e match {
      case TsExport(_, exportType, TsExporteeTree(exported)) =>
        exported match {
          case decl: TsNamedDecl =>
            export(codePath, jsLocation, scope, exportType, decl, None, loopDetector)

          case i @ TsImport(Seq(TsImportedIdent(ident)), _) =>
            Imports.expandImportee(i.from, scope, loopDetector) match {
              case founds if founds.nonEmpty =>
                founds match {
                  case ExpandedMod.Picked(things) =>
                    things.flatMap {
                      case (m: TsNamedDecl, newScope) =>
                        export(codePath, jsLocation, newScope, exportType, m, Some(ident), loopDetector)
                      case _ => Nil
                    }

                  case ExpandedMod.Whole(defaults, namespaceds, rest, newScope) =>
                    val restNs = TsDeclNamespace(
                      NoComments,
                      false,
                      ident,
                      rest,
                      CodePath.NoPath,
                      JsLocation.Zero,
                    )
                    (defaults ++ namespaceds :+ restNs).flatMap(
                      m => export(codePath, jsLocation, newScope, exportType, m, Some(ident), loopDetector),
                    )
                }

              case _ =>
                Imports.expandImportee(i.from, scope, loopDetector)
                scope.fatalMaybe(s"Could not resolve import $i")
                Nil
            }
        }

      case TsExport(_, exportType, TsExporteeNames(idents, fromOpt)) =>
        val newScope = fromOpt match {
          case Some(from) =>
            scope.moduleScopes.get(from) match {
              case Some(modScope) => modScope
              case None =>
                scope.fatalMaybe(s"Couldn't find expected module $from")
                scope
            }
          case None => scope
        }

        idents flatMap {
          case (qIdent, asNameOpt) =>
            val found = newScope.lookupInternal(Picker.All, qIdent.parts, loopDetector)
            if (found.isEmpty && newScope.root.pedantic) {
              //for debugging
              newScope.lookupInternal(Picker.All, qIdent.parts, loopDetector)
              newScope.logger.warn(s"Could not resolve $qIdent")
            }
            found flatMap {
              case (found, newNewScope) =>
                export(codePath, jsLocation, newNewScope, exportType, found, asNameOpt, loopDetector)
            }
        }

      case TsExport(_, exportType, TsExporteeStar(from)) =>
        scope.moduleScopes get from match {
          case Some(TsTreeScope.Scoped(newScope, mod: TsDeclModule)) =>
            val resolvedModule: TsDeclModule =
              if (scope.stack contains mod) mod
              else CachedReplaceExports(newScope, loopDetector, mod)

            resolvedModule.nameds.flatMap {
              case n if n.name === TsIdent.default => Nil
              case n                               => export(codePath, jsLocation, newScope, exportType, n, None, loopDetector)
            }
          case _ =>
            scope.fatalMaybe(s"Couldn't find expected module $from")
            Nil
        }
    }

    val ret2 = ret.map(SetCodePath.visitTsNamedDecl(codePath))

    if (scope.root.cache.isDefined && ret2.nonEmpty) {
      scope.root.cache.get.expandExport.put(key, ret2)
    }
    ret2
  }

  def export(
      ownerCp:      CodePath.HasPath,
      jsLocation:   ModuleSpec => JsLocation,
      scope:        TsTreeScope,
      exportType:   ExportType,
      _namedDecl:   TsNamedDecl,
      renamedOpt:   Option[TsIdent],
      loopDetector: LoopDetector,
  ): Seq[TsNamedDecl] = {
    val limitedScope = scope match {
      case TsTreeScope.Scoped(outer, `_namedDecl`) => outer
      case other                                   => other
    }

    val rewritten = _namedDecl match {
      case x: TsDeclModule if x.exports.nonEmpty => CachedReplaceExports(limitedScope, loopDetector, x)
      case x: TsDeclNamespace if x.exports.nonEmpty =>
        new ReplaceExports(loopDetector).visitTsNamedDecl(limitedScope)(x)
      case other => other
    }

    exportType match {
      case ExportType.Namespaced =>
        rewritten match {
          case x: TsContainer =>
            val xx = Utils.withJsLocation(x, jsLocation(ModuleSpec.Namespaced))

            xx.members flatMap {
              case xxx: TsNamedDecl => DeriveCopy(xxx, ownerCp, None)
              case _ => Nil
            }

          case x =>
            val xx = Utils.withJsLocation(x, jsLocation(ModuleSpec.Namespaced))
            DeriveCopy(xx, ownerCp, Some(TsIdent.namespaced))
        }

      case ExportType.Named =>
        DeriveCopy(rewritten, ownerCp, renamedOpt).map(x => Utils.withJsLocation(x, jsLocation(ModuleSpec(x.name))))

      case ExportType.Defaulted =>
        DeriveCopy(rewritten, ownerCp, Some(TsIdent.default))
          .map(x => Utils.withJsLocation(x, jsLocation(ModuleSpec.Defaulted)))
    }
  }

  case class PickedExport(export: TsExport, newWanted: List[TsIdent])

  /**
    * This is used when resolving. If we have an import in current scope which points
    * to a module, this finds the matching export in the pointee.
    */
  def pickExports(exports: Seq[TsExport], wanted: List[TsIdent]): Seq[PickedExport] =
    exports.flatMap {
      case e @ TsExport(_, ExportType.Namespaced, _) =>
        Some(PickedExport(e, wanted))

      case e @ TsExport(_, ExportType.Defaulted, _) =>
        if (wanted.headOption.contains(TsIdent.default)) Some(PickedExport(e, wanted.tail))
        else None

      case e @ TsExport(_, ExportType.Named, exported) =>
        exported match {
          case exported @ TsExporteeNames(idents, _) => //
            idents.collectFirst {
              case tuple @ (TsQIdent(parts), None) if wanted.startsWith(parts) =>
                PickedExport(e.copy(exported = exported.copy(idents = List(tuple))), wanted.drop(parts.length))
            }

          case TsExporteeTree(i: TsImport) =>
            Imports.validImport(wanted)(i) map (ii => PickedExport(e.copy(exported = TsExporteeTree(ii)), wanted))

          case TsExporteeTree(x: TsNamedDecl) =>
            if (wanted.headOption.contains(x.name)) Some(PickedExport(e, wanted)) else None

          case TsExporteeTree(other) =>
            sys.error(s"Unexpected $other")

          case TsExporteeStar(_) =>
            Some(PickedExport(e, wanted))
        }
    }

  /**
    * Structures which come from an `import` do not have a fixed javascript location, that can
    *  only be determined once they are exported
    */
  def rewriteLocationToOwner(jsLocation: JsLocation, ms: ModuleSpec): JsLocation =
    (jsLocation, ms) match {
      case (m: JsLocation.Module, spec) => m.copy(spec = spec)
      case (JsLocation.Global(jsPath), ModuleSpec.Specified(idents)) => JsLocation.Global(jsPath ++ idents)
      case (JsLocation.Global(jsPath), other)                        => sys.error(s"Unexpected $jsPath and $other")
      case (JsLocation.Zero, _)                                      => JsLocation.Zero
    }

  def lookupExportFrom[T <: TsNamedDecl](
      scope:        TsTreeScope.Scoped,
      Pick:         Picker[T],
      wanted:       List[TsIdent],
      loopDetector: LoopDetector,
      owner:        TsDeclNamespaceOrModule,
  ): Seq[(T, TsTreeScope)] =
    pickExports(scope.exports, wanted).flatMap {
      case PickedExport(e, newWanteds) =>
        val expanded: Seq[TsNamedDecl] =
          expandExport(scope, ms => rewriteLocationToOwner(owner.jsLocation, ms), e, loopDetector, owner)

        Utils.searchAmong(scope, Pick, newWanteds, expanded, loopDetector)
    }
}
