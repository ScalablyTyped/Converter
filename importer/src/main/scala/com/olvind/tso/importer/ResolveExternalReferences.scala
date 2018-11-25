package com.olvind.tso.importer

import com.olvind.logging.Logger
import com.olvind.tso.Set
import com.olvind.tso.importer.Source.TsSource
import com.olvind.tso.ts._

import scala.collection.mutable

object ResolveExternalReferences {

  case class Result(
      rewritten:      TsParsedFile,
      resolvedDeps:   Set[Source],
      unresolvedDeps: Set[TsIdentModule]
  )

  def apply(resolve: LibraryResolver, source: TsSource, tsParsedFile: TsParsedFile, logger: Logger[Unit]): Result = {
    val imported: Set[TsIdentModule] =
      tsParsedFile.imports.collect {
        case TsImport(_, TsImporteeFrom(from))     => from
        case TsImport(_, TsImporteeRequired(from)) => from
      }.toSet ++ tsParsedFile.exports.collect {
        case TsExport(_, _, TsExporteeNames(_, Some(from))) => from
      }

    val doResolve: TsIdentModule => Option[(Source, TsIdentModule)] = {
      case jsName if jsName.value.endsWith(".js") =>
        resolve.lookup(source, jsName.value.dropRight(".js".length))
      case name =>
        resolve.lookup(source, name.value)
    }
    val v = new V(doResolve, imported)

    val root  = TreeScope(source.libName, pedantic = true, Map.empty, logger)
    val after = v.visitTsParsedFile(root)(tsParsedFile)

    val newImports: Iterable[TsImport] =
      v.importTypes map {
        case (TsIdentImport(from), name) => TsImport(TsImportedStar(Some(name)) :: Nil, TsImporteeFrom(from))
      }

    Result(after.withMembers(after.members ++ newImports), v.foundSources.to[Set], v.notFound.to[Set])
  }

  private class V(doResolve: TsIdentModule => Option[(Source, TsIdentModule)], imported: Set[TsIdentModule])
      extends TreeVisitorScopedChanges {
    val foundSources = mutable.Set.empty[Source]
    val notFound     = mutable.Set.empty[TsIdentModule]
    val importTypes  = mutable.Map.empty[TsIdentImport, TsIdentSimple]

    private def resolveAndStore(name: TsIdentModule): TsIdentModule =
      doResolve(name) match {
        case Some((found: Source, moduleName)) =>
          foundSources += found
          moduleName
        case None =>
          notFound += name
          name
      }

    override def enterTsContainer(t: TreeScope)(x: TsContainer): TsContainer =
      x match {
        case m: TsDeclModule =>
          val newName: Option[TsIdentModule] = doResolve(m.name) flatMap {
            case (_, newName) if newName =/= m.name => Some(newName)
            case _                                  => None
          }

          val isWithinModule = t.`..`.stack exists {
            case _: TsDeclModule => true
            case _ => false
          }

          if (newName.isDefined || imported(m.name) || isWithinModule) {
            t.logger.info(s"Inferred augmented module $newName (${m.name})")
            TsAugmentedModule(newName.getOrElse(m.name), m.members, m.codePath, m.jsLocation)
          } else {
            m
          }

        case other => other
      }

    override def enterTsExporteeStar(t: TreeScope)(x: TsExporteeStar): TsExporteeStar =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsImporteeRequired(t: TreeScope)(x: TsImporteeRequired): TsImporteeRequired =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsImporteeFrom(t: TreeScope)(x: TsImporteeFrom): TsImporteeFrom =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsExporteeNames(t: TreeScope)(x: TsExporteeNames): TsExporteeNames =
      x.fromOpt.fold(x)(from => x.copy(fromOpt = Some(resolveAndStore(from))))

    override def enterTsQIdent(t: TreeScope)(x: TsQIdent): TsQIdent =
      x match {
        case TsQIdent((x: TsIdentImport) :: rest) =>
          val from = resolveAndStore(x.from)
          val name = TsIdentSimple("imported_" + from.value)
          importTypes.put(x, name)
          TsQIdent(name :: rest)
        case other => other
      }
  }

}
