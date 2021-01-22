package org.scalablytyped.converter.internal
package ts
package modules

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.modules.Exports.export
import org.scalablytyped.converter.internal.ts.transforms.SetCodePath

/* Skip traversing the entire tree if the module is cached */
object CachedReplaceExports {
  val Unique = TsIdent("__CachedReplaceExports__")
  def apply(scope: TsTreeScope, loopDetector: LoopDetector, x: TsDeclModule): TsDeclModule =
    if (scope.root.cache.isDefined && scope.root.cache.get.exports.contains(x.name))
      scope.root.cache.get.exports(x.name)
    else if (x.exports.isEmpty) x
    else
      /* bugfix for wrongly combined modules in @angular/core/testing */
      loopDetector.including(IArray(Unique, x.name), scope) match {
        case Right(newLoopDetector) =>
          new ReplaceExports(newLoopDetector).visitTsDeclModule(scope)(x)
        case Left(()) => x.copy(members = Empty)
      }
}

class ReplaceExports(loopDetector: LoopDetector) extends TreeTransformationScopedChanges {
  override def enterTsDeclNamespace(scope: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    if (x.exports.isEmpty && x.imports.isEmpty) x
    else {
      val newMembers: IArray[TsContainerOrDecl] = x.members.flatMap {
        case TsExport(_, _, ExportType.Named, TsExporteeTree(tree)) =>
          tree match {
            case namedExport: TsNamedDecl =>
              export(
                x.codePath.forceHasPath,
                _ => x.jsLocation / namedExport, //todo
                scope,
                ExportType.Named,
                namedExport,
                None,
                loopDetector,
              )

            case TsImport(_, IArray.exactlyOne(TsImportedIdent(to)), TsImporteeLocal(from)) =>
              scope
                .lookupInternal(Picker.ButNot(Picker.All, x), from.parts, loopDetector)
                .map { case (d, _) => d.withName(to) }
                .map(SetCodePath.visitTsNamedDecl(x.codePath.forceHasPath))

            case other =>
              scope.logger.fatal(s"Unexpected $other")
          }
        case TsExport(NoComments, _, ExportType.Named, TsExporteeNames(Empty, None)) =>
          Empty
        case e: TsExport =>
          scope.fatalMaybe(s"Dropping unexpected export in namespace $e")
          Empty
        case _: TsImport => Empty

        case other => IArray(other)
      }

      x.copy(members = newMembers)
    }

  override def enterTsDeclModule(scope: TsTreeScope)(x: TsDeclModule): TsDeclModule = {
    if (scope.root.cache.isDefined && scope.root.cache.get.exports.contains(x.name)) {
      return scope.root.cache.get.exports(x.name)
    }
    val _1 = x.copy(members = newMembers(scope, x, spec => JsLocation.Module(x.name, spec), x.members))
    val _2 = ensureTypesPresent(x, _1)
    val _3 = FlattenTrees.mergeModule(_2, _2.copy(members = Empty))

    if (scope.root.cache.isDefined) {
      scope.root.cache.get.exports.put(x.name, _3)
    }

    _3
  }

  override def enterTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule = {
    val _1 = x.copy(members = newMembers(t, x, spec => JsLocation.Module(x.name, spec), x.members))
    val _2 = ensureTypesPresent(x, _1)
    FlattenTrees.mergeAugmentedModule(_2, _2.copy(members = Empty))
  }

  override def leaveTsParsedFile(t: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = x.members.mapNotNone {
      case _: TsImport => None
      case TsExport(_, _, _, TsExporteeTree(x)) => Some(x)
      case other                                => Some(other)
    })

  def ensureTypesPresent[T <: TsContainer](old: T, `new`: T): T = {
    val newTypes: Set[TsIdent] =
      `new`.members.collect { case Picker.Types(tpe) => tpe.name }.toSet

    val missingTypes: IArray[TsContainerOrDecl] =
      old.members
        .collect {
          case TsExport(_, _, _, TsExporteeTree(Picker.Types(tpe))) if !newTypes.contains(tpe.name) =>
            KeepTypesOnly(tpe)
          case Picker.Types(tpe) if !newTypes.contains(tpe.name) => KeepTypesOnly(tpe)
        }
        .mapNotNone(identity)

    `new`.withMembers(`new`.members ++ missingTypes).asInstanceOf[T]
  }

  case class CanBeShadowed(maybe: Boolean, trees: IArray[TsContainerOrDecl])

  def newMembers(
      scope:      TsTreeScope,
      owner:      TsDeclNamespaceOrModule,
      jsLocation: ModuleSpec => JsLocation,
      trees:      IArray[TsContainerOrDecl],
  ): IArray[TsContainerOrDecl] = {
    val (canBeShadowed, canNotBe) = trees.map(newMember(scope, owner, jsLocation)).partition(_.maybe)
    val keep                      = canNotBe.flatMap(_.trees)
    val keepMaybe = {
      val takenName = keep.collect { case x: TsNamedDecl => x.name }.toSet
      canBeShadowed.flatMap(_.trees.filter {
        case x: TsNamedDecl => !takenName(x.name)
        case _ => true
      })
    }
    keepMaybe ++ keep
  }

  def newMember(scope: TsTreeScope, owner: TsDeclNamespaceOrModule, jsLocation: ModuleSpec => JsLocation)(
      decl:            TsContainerOrDecl,
  ): CanBeShadowed = {
    lazy val hasExportedValues: Boolean =
      owner.exports.exists {
        case TsExport(_, _, _, TsExporteeTree(_: TsDeclInterface | _: TsDeclTypeAlias)) => false
        case _: TsExport => true
        case _ => false
      }

    decl match {
      /* fix for @angular/core */
      case TsExport(NoComments, _, _, TsExporteeStar(_, name)) if owner.name === name =>
        CanBeShadowed(maybe = false, Empty)
      case e: TsExport =>
        val ret = Exports.expandExport(scope, jsLocation, e, loopDetector, owner)
        if (ret.isEmpty && scope.root.pedantic) {
          e match {
            /* OF COURSE somebody had to export an empty object */
            case TsExport(_, _, ExportType.Named, TsExporteeNames(names, None)) if names.isEmpty => ()
            case other                                                                           =>
              // for debugging
              Exports.expandExport(scope, jsLocation, other, loopDetector, owner: TsDeclNamespaceOrModule)

              scope.logger.fatal(("didn't expand to anything", other.toString))
          }
        }
        val canBeShadowed = e match {
          case TsExport(_, _, ExportType.Named, TsExporteeStar(_, _)) => true
          case _                                                      => false
        }
        CanBeShadowed(canBeShadowed, ret)

      case g @ TsGlobal(_, _, ms, _) =>
        val ret: IArray[TsNamedDecl] =
          ms.collect {
              case x: TsNamedDecl => x
              case TsExport(_, _, _, TsExporteeTree(x: TsNamedDecl)) => x
            }
            .map(x => Utils.withJsLocation(x, JsLocation.Global(TsQIdent.of(x.name))))

        CanBeShadowed(maybe = false, IArray(g.copy(members = ret)))

      case x: TsDeclModule      => CanBeShadowed(maybe = false, IArray(x))
      case x: TsAugmentedModule => CanBeShadowed(maybe = false, IArray(x))
      // might clash with an interface in the presence of commonjs modules
      case x: TsDeclTypeAlias => CanBeShadowed(maybe = true, IArray(x))
      case x: TsNamedValueDecl =>
        if (hasExportedValues) CanBeShadowed(maybe = false, IArray.fromOption(KeepTypesOnly(x)))
        else CanBeShadowed(maybe                   = false, IArray(x))
      case x => CanBeShadowed(maybe = false, IArray(x))
    }
  }
}
