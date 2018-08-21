package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.transforms.SetCodePath

object Exports {
  def expandExport(scope:        TreeScope,
                   jsLocation:   ModuleSpec => JsLocation,
                   codePath:     CodePath.HasPath,
                   e:            TsExport,
                   loopDetector: LoopDetector): Seq[TsNamedDecl] = {

    val ret = e match {
      case TsExport(_, exportType, TsExporteeTree(exported)) =>
        exported match {
          case namedExport: TsNamedDecl =>
            export(loc(exportType, jsLocation, namedExport.name),
                   scope,
                   exportType,
                   namedExport,
                   None,
                   loopDetector,
                   generateInterface = true)

          /* todo: Only seen this shape for now. Double check and update tree */
          case TsImport(Seq(TsImportedIdent(ident)), from) if exportType === ExportType.Named =>
            val founds: Seq[(TsNamedDecl, TreeScope)] = from match {
              case TsImporteeRequired(newFrom) =>
                scope
                  .moduleScopes(newFrom)
                  .lookupInternal(Picker.NotModules, TsIdent.namespaced :: Nil, loopDetector)
                  .map {
                    case (d, s) => (d.withName(ident), s)
                  }
              case TsImporteeFrom(newFrom) =>
                scope
                  .moduleScopes(newFrom)
                  .lookupInternal(Picker.NotModules, TsIdent.default :: Nil, loopDetector)
                  .map {
                    case (d, s) => (d.withName(ident), s)
                  }

              case TsImporteeLocal(qident) =>
                val ret = scope.lookupInternal(Picker.NotOrNamespaceModules, qident.parts, loopDetector)
                ret.map {
                  case (d, s) => (d.withName(ident), s)
                }
            }

            founds flatMap {
              case (found, newScope) =>
                export(loc(exportType, jsLocation, found.name),
                       newScope,
                       exportType,
                       found,
                       if (ident =/= found.name) Some(ident) else None,
                       loopDetector,
                       generateInterface = false)
            }
        }

      case TsExport(_, exportType, TsExporteeNames(idents, fromOpt)) =>
        idents flatMap {
          case (qIdent, asNameOpt) =>
            val newScope = fromOpt match {
              case Some(from) => scope.moduleScopes(from)
              case None       => scope
            }

            newScope.lookupInternal(Picker.NotModules, qIdent.parts, loopDetector) flatMap {
              case (m, newNewScope) =>
                val withLocation = loc(exportType, jsLocation, m.name)
                export(withLocation, newNewScope, exportType, m, asNameOpt, loopDetector, generateInterface = false)
            }
        }

      case TsExport(_, exportType, TsExporteeStar(from, None /* todo*/ )) =>
        scope.moduleScopes(from) match {
          case TreeScope.Scoped(newScope, mod: TsDeclModule) =>
            val resolvedModule: TsDeclModule =
              if (mod.exports.isEmpty) mod
              else
                new ReplaceExports(loopDetector)
                  .visitTsDeclModule(newScope)(mod)

            resolvedModule.nameds.flatMap { n =>
              export(jsLocation(ModuleSpec.Specified(Seq(n.name))),
                     newScope,
                     exportType,
                     n,
                     None,
                     loopDetector,
                     generateInterface = false)
            }
        }
    }

    ret.map(SetCodePath.visitTsNamedDecl(codePath))
  }

  def export(jsLocation:        JsLocation,
             scope:             TreeScope,
             exportType:        ExportType,
             namedDecl:         TsNamedDecl,
             renamedOpt:        Option[TsIdent],
             loopDetector:      LoopDetector,
             generateInterface: Boolean,
  ): Seq[TsNamedDecl] = {
    val newName = effectiveName(exportType, renamedOpt)

    def shouldDerive: Boolean = {
      if (newName.isDefined) return true

      scope.surroundingTsContainer match {
        case Some(x: HasCodePath) =>
          val moduleParts = x.codePath.forceHasPath.codePath.parts
          val thisParts   = namedDecl.codePath.forceHasPath.codePath.parts
          thisParts =/= moduleParts && thisParts.dropRight(1) =/= moduleParts
        case _ => true
      }
    }

    namedDecl match {
      case x: TsDeclNamespace if ExportType.Types.LocalNamed(exportType) =>
        val fromExports =
          x.exports.flatMap(e => expandExport(scope, _ => JsLocation.Zero, x.codePath.forceHasPath, e, loopDetector))

        val ret = (x.nameds ++ fromExports)
          .flatMap {
            case x: TsDeclNamespace => Seq(x.copy(members = x.members.flatMap(DeriveCopy.downgrade)))
            case other => DeriveCopy(other, None, generateInterface)
          }
          .map(decl => withJsLocation(decl, jsLocation / decl))

        ret

      case x: TsNamedDecl with Renameable =>
        val base =
          if (shouldDerive) DeriveCopy(x, newName, generateInterface)
          else Seq(withRename(newName)(x))
        base
          .map(x => withJsLocation(x, jsLocation))

      case x: TsAugmentedModule =>
        DeriveCopy(x, newName, generateInterface).map(x => withJsLocation(x, jsLocation))
    }
  }

  def loc(exportType: ExportType, jsLocation: ModuleSpec => JsLocation, name: TsIdent): JsLocation =
    exportType match {
      case ExportType.Named      => jsLocation(ModuleSpec.Specified(Seq(name)))
      case ExportType.Namespaced => jsLocation(ModuleSpec.Namespaced)
      case ExportType.Defaulted  => jsLocation(ModuleSpec.Defaulted)
    }

  def withJsLocation[T <: TsTree](tree: T, jsLocation: JsLocation): T =
    tree match {
      case x: HasJsLocation => x.withJsLocation(jsLocation).asInstanceOf[T]
      case _ => tree
    }

  def withRename[T <: TsNamedDecl with Renameable](renamedOpt: Option[TsIdent])(tree: T): T =
    renamedOpt match {
      case None          => tree
      case Some(newName) => tree.withName(newName).asInstanceOf[T]
    }

  def effectiveName[T <: TsNamedDecl](exportType: ExportType, renamedOpt: Option[TsIdent]): Option[TsIdent] =
    exportType match {
      case ExportType.Defaulted  => Some(TsIdent.default)
      case ExportType.Namespaced => Some(TsIdent.namespaced)
      case _                     => renamedOpt
    }

  case class Res(export: TsExport, newWanted: List[List[TsIdent]])

  /**
    * This is used when resolving. If we have an import in current scope which points
    * to a module, this finds the matching export in the pointee.
    */
  def pickExports(exports: Seq[TsExport], wanted: List[TsIdent]): Seq[Res] =
    exports.flatMap {
      case e @ TsExport(_, ExportType.Namespaced, _) =>
        if (wanted.headOption.contains(TsIdent.namespaced)) Some(Res(e, wanted.tail :: Nil)) else None

      case e @ TsExport(_, ExportType.Defaulted, _) =>
        if (wanted.headOption.contains(TsIdent.default)) Some(Res(e, wanted.tail :: Nil)) else None

      case e @ TsExport(_, ExportType.Named, exported) =>
        exported match {
          case exported @ TsExporteeNames(idents, _) => //
            idents.collectFirst {
              case tuple @ (TsQIdent(parts), None) if wanted.startsWith(parts) =>
                Res(e.copy(exported = exported.copy(idents = List(tuple))), wanted.drop(parts.length) :: Nil)
            }

          case TsExporteeTree(im: TsImport) =>
            Imports.validImport(wanted)(im) map {
              case (newWanteds, i) => Res(e.copy(exported = TsExporteeTree(i)), newWanteds)
            }

          case TsExporteeTree(x: TsNamedDecl) =>
            if (wanted.headOption.contains(x.name)) Some(Res(e, wanted.tail :: Nil)) else None

          case TsExporteeStar(_, Some(renamed)) =>
            if (wanted.headOption.contains(renamed)) {
              Some(Res(e, (TsIdent.All :: wanted.tail) :: Nil))
            } else None

          case TsExporteeStar(_, None) =>
            Some(Res(e, wanted :: Nil))
        }
    }

  def lookupExportFrom[T <: TsNamedDecl](scope:        TreeScope.Scoped,
                                         Pick:         Picker[T],
                                         wanted:       List[TsIdent],
                                         loopDetector: LoopDetector): Seq[(T, TreeScope)] = {

    lazy val key: (String, Picker[_], List[TsIdent]) = (scope.toString, Pick, wanted)

    if (scope.root.cache.isDefined && scope.root.cache.get.contains(key)) {
      return scope.root.cache.get(key).asInstanceOf[Seq[(T, TreeScope)]]
    }
    require(wanted.count(x => x === TsIdent.default || x === TsIdent.namespaced) < 2)

    val outer: Seq[(T, TreeScope)] = wanted match {
      case Nil =>
//        scope.current match {
//          case Pick(x) => Seq((x, scope))
//          case _       => Nil
//        }

        Nil

      case TsIdent.All :: Nil =>
        scope.current match {
          case mod: TsDeclModule =>
            val rewrittenMod: TsDeclModule =
              if (mod.exports.isEmpty) mod
              else new ReplaceExports(loopDetector).visitTsDeclModule(scope)(mod)

//            Lower.mod(rewrittenMod) match {
//              case Pick(x) => (x, scope) :: Nil
//              case _       => Nil
//            }

            rewrittenMod.members collect { case Pick(x) => (x, scope) }

          case other => scope.logger.fatal(s"Unexpected ${other.asString} at $scope")
        }

      case _ =>
        val ret = pickExports(scope.exports, wanted).flatMap {
          case Res(e, newWanteds) =>
            val found: Seq[TsNamedDecl] =
              expandExport(scope,
                           _ => JsLocation.Zero,
                           scope.surroundingTsContainer.get.codePath.forceHasPath,
                           e,
                           loopDetector)

            FirstNonEmpty
              .ofLists(newWanteds) {
                case Nil =>
                  val foo: Seq[(T, TreeScope.Scoped)] = for {
                    Pick(f) <- found
                    Pick(d) <- DeriveCopy(f, None, generateInterface = false)
                  } yield (d, scope)
                  foo

                case lookFurther if found.nonEmpty =>
                  val inContainer: Seq[(T, TreeScope)] =
                    found.flatMap {
                      case x: TsContainer => TreeScope.search(scope, Pick, x, lookFurther, loopDetector)
                      case _ => Nil
                    }

                  if (inContainer.isEmpty) {
                    val extraOpt: Option[Seq[TsNamedValueDecl]] = found.collectFirst {
                      case TsDeclVar(_, _, _, TsIdent.namespaced, Some(tr: TsTypeRef), _, _, codePath, _) =>
                        Hoisting.hoistedMembersFrom(scope, codePath.forceHasPath, loopDetector)(tr)
                    }

                    TreeScope.search(
                      scope,
                      Pick,
                      TsParsedFile(NoComments, Nil, extraOpt.foldLeft(found)(_ ++ _), CodePath.NoPath),
                      lookFurther,
                      loopDetector
                    )

                  } else inContainer

                case _ => Nil
              }
              .getOrElse(Nil)
        }

        if (ret.nonEmpty) ret else scope.lookupInternal(Pick, wanted, loopDetector)
    }

    if (scope.root.cache.isDefined && outer.nonEmpty) {
      scope.root.cache.get.put(key, outer)
    }

    outer
  }
}
