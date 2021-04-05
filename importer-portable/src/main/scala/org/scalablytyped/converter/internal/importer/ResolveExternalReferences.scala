package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.importer.Source.TsSource
import org.scalablytyped.converter.internal.ts._

import scala.collection.mutable

object ResolveExternalReferences {

  case class Result(
      rewritten:      TsParsedFile,
      resolvedDeps:   Set[Source],
      unresolvedDeps: Set[TsIdentModule],
  )

  def apply(resolve: LibraryResolver, source: TsSource, tsParsedFile: TsParsedFile, logger: Logger[Unit]): Result = {
    val imported: Set[TsIdentModule] = {
      val fromImports = tsParsedFile.imports.collect {
        case TsImport(_, _, TsImportee.From(from))     => from
        case TsImport(_, _, TsImportee.Required(from)) => from
      }
      val fromExports = tsParsedFile.exports.collect {
        case TsExport(_, _, _, TsExportee.Names(_, Some(from))) => from
      }
      fromImports.toSet ++ fromExports.toSet
    }

    /**
      * Todo: `InferredDependency` takes care of undeclared node dependency.
      * However, that is not solid enough when there actually exists a library
      * with the same name as the requested module.
      */
    val doResolve: TsIdentModule => Option[(Source, TsIdentModule)] = {
      case TsIdentModule(None, "events" :: Nil) => None
      case jsName if jsName.value.endsWith(".js") =>
        resolve.module(source, jsName.value.dropRight(".js".length))
      case name =>
        resolve.module(source, name.value)
    }
    val v = new V(doResolve, imported)

    val root  = TsTreeScope(source.libName, pedantic = true, Map.empty, logger)
    val after = v.visitTsParsedFile(root)(tsParsedFile)

    val newImports: IArray[TsImport] =
      v.importTypes.mapToIArray {
        case (TsIdentImport(from), name) =>
          TsImport(typeOnly = false, IArray(TsImported.Star(Some(name))), TsImportee.From(from))
      }

    Result(after.withMembers(after.members ++ newImports), v.foundSources.to[Set], v.notFound.to[Set])
  }

  private class V(doResolve: TsIdentModule => Option[(Source, TsIdentModule)], imported: Set[TsIdentModule])
      extends TreeTransformationScopedChanges {
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

    override def enterTsContainer(t: TsTreeScope)(x: TsContainer): TsContainer =
      x match {
        case m: TsDeclModule =>
          val newName: Option[TsIdentModule] = doResolve(m.name).flatMap {
            case (_, newName) if newName =/= m.name => Some(newName)
            case _                                  => None
          }

          val isWithinModule = t.`..`.stack.exists {
            case _: TsDeclModule => true
            case _ => false
          }

          if (newName.isDefined || imported(m.name) || isWithinModule) {
            t.logger.info(s"Inferred augmented module $newName (${m.name})")
            TsAugmentedModule(m.comments, newName.getOrElse(m.name), m.members, m.codePath, m.jsLocation)
          } else {
            m
          }

        case other => other
      }

    override def enterTsExporteeStar(t: TsTreeScope)(x: TsExportee.Star): TsExportee.Star =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsImporteeRequired(t: TsTreeScope)(x: TsImportee.Required): TsImportee.Required =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsImporteeFrom(t: TsTreeScope)(x: TsImportee.From): TsImportee.From =
      x.copy(from = resolveAndStore(x.from))

    override def enterTsExporteeNames(t: TsTreeScope)(x: TsExportee.Names): TsExportee.Names =
      x.fromOpt.fold(x)(from => x.copy(fromOpt = Some(resolveAndStore(from))))

    override def enterTsQIdent(t: TsTreeScope)(x: TsQIdent): TsQIdent =
      x match {
        case TsQIdent(IArray.headTail(TsIdentImport(from), rest)) =>
          val newFrom = resolveAndStore(from)
          val name    = TsIdentSimple("imported_" + newFrom.fragments.last)
          importTypes.put(TsIdentImport(newFrom), name)
          TsQIdent(name +: rest)
        case other => other
      }
  }

}
