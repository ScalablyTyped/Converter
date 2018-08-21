package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TreeScope.LoopDetector

class ReplaceExports(loopDetector: LoopDetector) extends TreeVisitorScopedChanges {
  override def enterTsDeclModule(t: TreeScope)(x: TsDeclModule): TsDeclModule =
    ensureTypesPresent(
      x,
      x.copy(
        jsLocation = JsLocation.Module(x.name, ModuleSpec.Namespaced),
        members    = x.members flatMap newMember(t, x.codePath.forceHasPath, spec => JsLocation.Module(x.name, spec))
      )
    ).asInstanceOf[TsDeclModule]

  override def enterTsAugmentedModule(t: TreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    ensureTypesPresent(
      x,
      x.copy(
        jsLocation = JsLocation.Module(x.name, ModuleSpec.Namespaced),
        members    = x.members flatMap newMember(t, x.codePath.forceHasPath, spec => JsLocation.Module(x.name, spec))
      )
    ).asInstanceOf[TsAugmentedModule]

  def ensureTypesPresent(old: TsContainer, `new`: TsContainer): TsContainer = {
    val newTypes: Map[TsIdent, TsNamedDecl] =
      `new`.members.collect {
        case Picker.Types(tpe) => tpe.name -> tpe
      }.toMap

    val missingTypes: Seq[TsNamedDecl] =
      old.members.collect {
        case TsExport(_, _, TsExporteeTree(Picker.Types(tpe))) if !newTypes.contains(tpe.name) =>
          DeriveCopy.downgrade(tpe)
        case Picker.Types(tpe) if !newTypes.contains(tpe.name) => DeriveCopy.downgrade(tpe)
      }.flatten

    `new`.withMembers(`new`.members ++ missingTypes)
  }

  def newMember(scope: TreeScope, codePath: CodePath.HasPath, jsLocation: ModuleSpec => JsLocation)(
      decl:            TsContainerOrDecl
  ): Seq[TsContainerOrDecl] =
    decl match {
      case e: TsExport =>
        val ret = Exports.expandExport(scope, jsLocation, codePath, e, loopDetector)
        if (ret.isEmpty && constants.Pedantic) {
          e match {
            /* OF COURSE somebody had to export an empty object */
            case TsExport(_, ExportType.Named, TsExporteeNames(names, None)) if names.isEmpty => ()
            case other                                                                        =>
              // for debugging
              Exports.expandExport(scope, jsLocation, codePath, other, loopDetector)

              scope.logger.fatal(("didn't expand to anything", other.toString))
          }
        }
        ret

      case g @ TsGlobal(_, _, ms, _) =>
        val ret: Seq[TsNamedDecl] =
          ms map {
            case x: TsNamedDecl => x
            case TsExport(_, _, TsExporteeTree(x: TsNamedDecl)) => x
          } map (x => Exports.withJsLocation(x, JsLocation.Global(TsQIdent(List(x.name)))))

        Seq(g.copy(members = ret))

      case x: TsDeclNamespace if scope.withinModule  => DeriveCopy.downgrade(x)
      case _: TsNamedValueDecl if scope.withinModule => Nil

      // todo: Want to remove imports during this step, but it somehow breaks ResolveTypeQueries down the line
//      case _: TsImport => Nil

      case x => Seq(x)
    }
}
