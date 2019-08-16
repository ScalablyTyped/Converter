package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.modules.Exports.export
import com.olvind.tso.ts.transforms.SetCodePath

/* Skip traversing the entire tree if the module is cached */
object CachedReplaceExports {
  val Unique = TsIdent("__CachedReplaceExports__")
  def apply(scope: TsTreeScope, loopDetector: LoopDetector, x: TsDeclModule): TsDeclModule =
    if (scope.root.cache.isDefined && scope.root.cache.get.replaceExports.contains(x.name))
      scope.root.cache.get.replaceExports(x.name)
    else if (x.exports.isEmpty) x
    else
      /* bugfix for wrongly combined modules in @angular/core/testing */
      loopDetector.including(List(Unique, x.name), scope) match {
        case Right(newLoopDetector) =>
          new ReplaceExports(newLoopDetector).visitTsDeclModule(scope)(x)
        case Left(()) => x.copy(members = Nil)
      }
}

class ReplaceExports(loopDetector: LoopDetector) extends TreeTransformationScopedChanges {
  override def enterTsDeclNamespace(scope: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    if (x.exports.isEmpty && x.imports.isEmpty) x
    else {
      val newMembers: Seq[TsContainerOrDecl] = x.members.flatMap {
        case TsExport(_, ExportType.Named, TsExporteeTree(tree)) =>
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

            case TsImport(Seq(TsImportedIdent(to)), TsImporteeLocal(from)) =>
              scope
                .lookupInternal(Picker.All, from.parts, loopDetector)
                .map { case (d, _) => d.withName(to) }
                .map(SetCodePath.visitTsNamedDecl(x.codePath.forceHasPath))

            case other =>
              scope.logger.fatal(s"Unexpected $other")
          }
        case e: TsExport =>
          scope.fatalMaybe(s"Dropping unexpected export in namespace $e")
          Nil
        case _: TsImport => Nil

        case other => other :: Nil
      }

      x.copy(members = newMembers)
    }

  override def enterTsDeclModule(scope: TsTreeScope)(x: TsDeclModule): TsDeclModule = {
    if (scope.root.cache.isDefined && scope.root.cache.get.replaceExports.contains(x.name)) {
      return scope.root.cache.get.replaceExports(x.name)
    }
    val _1 = x.copy(members = x.members flatMap newMember(scope, x, spec => JsLocation.Module(x.name, spec)))
    val _2 = ensureTypesPresent(x, _1)
    val _3 = FlattenTrees.mergeModule(_2, _2.copy(members = Nil))

    if (scope.root.cache.isDefined) {
      scope.root.cache.get.replaceExports.put(x.name, _3)
    }

    _3
  }

  override def enterTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule = {
    val _1 = x.copy(members = x.members flatMap newMember(t, x, spec => JsLocation.Module(x.name, spec)))
    val _2 = ensureTypesPresent(x, _1)
    FlattenTrees.mergeAugmentedModule(_2, _2.copy(members = Nil))
  }

  override def leaveTsParsedFile(t: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = x.members.flatMap {
      case _: TsImport => Nil
      case TsExport(_, _, TsExporteeTree(x)) => Some(x)
      case other                             => Some(other)
    })

  def ensureTypesPresent[T <: TsContainer](old: T, `new`: T): T = {
    val newTypes: Set[TsIdent] =
      `new`.members.collect { case Picker.Types(tpe) => tpe.name }.to[Set]

    val missingTypes: Seq[TsContainerOrDecl] =
      old.members.collect {
        case TsExport(_, _, TsExporteeTree(Picker.Types(tpe)))
            if !newTypes.contains(tpe.name) => //todo: remove probably
          DeriveCopy.downgrade(tpe)
        case Picker.Types(tpe) if !newTypes.contains(tpe.name) => DeriveCopy.downgrade(tpe)
      }.flatten

    `new`.withMembers(`new`.members ++ missingTypes).asInstanceOf[T]
  }

  def newMember(scope: TsTreeScope, owner: TsDeclNamespaceOrModule, jsLocation: ModuleSpec => JsLocation)(
      decl:            TsContainerOrDecl,
  ): Seq[TsContainerOrDecl] = {
    lazy val hasExportedValues: Boolean =
      owner.exports.exists {
        case TsExport(_, _, TsExporteeTree(_: TsDeclInterface | _: TsDeclTypeAlias)) => false
        case _: TsExport => true
        case _ => false
      }

    decl match {
      /* fix for @angular/core */
      case TsExport(NoComments, _, TsExporteeStar(name)) if owner.name === name => Nil
      case e: TsExport =>
        val ret = Exports.expandExport(scope, jsLocation, e, loopDetector, owner)
        if (ret.isEmpty && scope.root.pedantic) {
          e match {
            /* OF COURSE somebody had to export an empty object */
            case TsExport(_, ExportType.Named, TsExporteeNames(names, None)) if names.isEmpty => ()
            case other                                                                        =>
              // for debugging
              Exports.expandExport(scope, jsLocation, other, loopDetector, owner: TsDeclNamespaceOrModule)

              scope.logger.fatal(("didn't expand to anything", other.toString))
          }
        }
        ret

      case g @ TsGlobal(_, _, ms, _) =>
        val ret: Seq[TsNamedDecl] =
          ms map {
            case x: TsNamedDecl => x
            case TsExport(_, _, TsExporteeTree(x: TsNamedDecl)) => x
          } map (x => Utils.withJsLocation(x, JsLocation.Global(TsQIdent.of(x.name))))

        Seq(g.copy(members = ret))

      case x: TsDeclModule      => Seq(x)
      case x: TsAugmentedModule => Seq(x)
      case x: TsNamedValueDecl  => if (hasExportedValues) DeriveCopy.downgrade(x).to[List] else Seq(x)
//      case _: TsImport          => Nil
      case x => Seq(x)
    }
  }
}
