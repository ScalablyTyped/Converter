package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.modules.Exports.export
import com.olvind.tso.ts.transforms.SetCodePath

/* Skip traversing the entire tree if the module is cached */
object CachedReplaceExports {
  def apply(scope: TreeScope, loopDetector: LoopDetector, x: TsDeclModule): TsDeclModule =
    if (scope.root.cache.isDefined && scope.root.cache.get.replaceExports.contains(x.name))
      scope.root.cache.get.replaceExports(x.name)
    else if (x.exports.isEmpty) x
    else new ReplaceExports(loopDetector).visitTsDeclModule(scope)(x)
}

class ReplaceExports(loopDetector: LoopDetector) extends TreeVisitorScopedChanges {
  override def enterTsDeclNamespace(scope: TreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    if (x.exports.isEmpty && x.imports.isEmpty) x
    else {
      val newMembers: Seq[TsContainerOrDecl] = x.members.flatMap {
        case _: TsImport => Nil
        case TsExport(_, ExportType.Named, TsExporteeTree(tree)) =>
          tree match {
            case namedExport: TsNamedDecl =>
              export(x.codePath.forceHasPath,
                     _ => x.jsLocation / namedExport, //todo
                     scope,
                     ExportType.Named,
                     namedExport,
                     None,
                     loopDetector)

            case TsImport(Seq(TsImportedIdent(to)), TsImporteeLocal(from)) =>
              val ret = scope
                .lookupInternal(Picker.All, from.parts, loopDetector)
                .map { case (d, _) => d.withName(to) }
                .map(SetCodePath.visitTsNamedDecl(x.codePath.forceHasPath))

              /* yeah, so this happened. aws-sdk defines a namespace that exports itself */
              ret map {
                case copy: TsDeclNamespace if copy.codePath === x.codePath || copy.name.value === "Types" =>
                  TsDeclVar(
                    NoComments,
                    declared = false,
                    readOnly = true,
                    copy.name,
                    Some(TsTypeThis()), //todo: need to represent singleton types on typescript side somehow
                    None,
                    x.jsLocation,
                    copy.codePath,
                    isOptional = false
                  )
                case other => other
              }

            case other => scope.logger.fatal(s"Unexpected $other")
          }

        case other => other :: Nil
      }

      x.copy(members = newMembers)
    }

  override def enterTsDeclModule(scope: TreeScope)(x: TsDeclModule): TsDeclModule = {
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

  override def enterTsAugmentedModule(t: TreeScope)(x: TsAugmentedModule): TsAugmentedModule = {
    val _1 = x.copy(members = x.members flatMap newMember(t, x, spec => JsLocation.Module(x.name, spec)))
    val _2 = ensureTypesPresent(x, _1)
    FlattenTrees.mergeAugmentedModule(_2, _2.copy(members = Nil))
  }

  override def leaveTsParsedFile(t: TreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = x.members.filterNot(_.isInstanceOf[TsImport]))

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

  def newMember(scope: TreeScope, owner: TsDeclNamespaceOrModule, jsLocation: ModuleSpec => JsLocation)(
      decl:            TsContainerOrDecl
  ): Seq[TsContainerOrDecl] =
    decl match {
      /* fix for @angular/core */
      case TsExport(NoComments, _, TsExporteeStar(name, None)) if owner.name === name => Nil
      case e: TsExport =>
        val ret = Exports.expandExport(scope, jsLocation, e, loopDetector, owner)
        if (ret.isEmpty && constants.Pedantic) {
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
          } map (x => Utils.withJsLocation(x, JsLocation.Global(TsQIdent(List(x.name)))))

        Seq(g.copy(members = ret))

      case x: TsDeclModule      => Seq(x)
      case x: TsAugmentedModule => Seq(x)
      case x: TsNamedValueDecl  => DeriveCopy.downgrade(x).to[List]
      case _: TsImport          => Nil
      case x => Seq(x)
    }
}
