package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.ts._

import scala.collection.mutable

object ResolveExternalReferences {

  case class Result(
      rewritten:         TsParsedFile,
      resolvedModules:   Set[ResolvedModule],
      unresolvedModules: Set[TsIdentModule],
  )

  def apply(
      resolve:      LibraryResolver,
      source:       LibTsSource,
      folder:       InFolder,
      tsParsedFile: TsParsedFile,
      logger:       Logger[Unit],
  ): Result = {
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

    val root    = TsTreeScope(source.libName, pedantic = true, Map.empty, logger)
    val visitor = new V(resolve, source, folder, imported)
    val after   = visitor.visitTsParsedFile(root)(tsParsedFile)

    val newImports: IArray[TsImport] =
      visitor.importTypes.mapToIArray {
        case (TsIdentImport(from), name) =>
          TsImport(typeOnly = false, IArray(TsImported.Star(Some(name))), TsImportee.From(from))
      }

    Result(after.withMembers(after.members ++ newImports), visitor.resolvedModules.to(Set), visitor.notFound.to(Set))
  }

  private class V(resolve: LibraryResolver, source: LibTsSource, folder: InFolder, imported: Set[TsIdentModule])
      extends TreeTransformationScopedChanges {
    val resolvedModules = mutable.Set.empty[ResolvedModule]
    val notFound        = mutable.Set.empty[TsIdentModule]
    val importTypes     = mutable.Map.empty[TsIdentImport, TsIdentSimple]

    /**
      * Todo: `InferredDependency` takes care of undeclared node dependency.
      * However, that is not solid enough when there actually exists a library
      * with the same name as the requested module.
      */
    def doResolve(mod: TsIdentModule): Option[ResolvedModule] = mod match {
      case TsIdentModule(None, "events" :: Nil) => None
      case jsName if jsName.value.endsWith(".js") =>
        resolve.module(source, folder, jsName.value.dropRight(".js".length))
      case name =>
        resolve.module(source, folder, name.value)
    }

    private def resolveAndStore(name: TsIdentModule): TsIdentModule =
      doResolve(name) match {
        case Some(found) =>
          resolvedModules += found
          found.moduleName
        case None =>
          notFound += name
          doResolve(name)
          name
      }

    override def enterTsContainer(t: TsTreeScope)(x: TsContainer): TsContainer =
      x match {
        case m: TsDeclModule =>
          val newName: Option[TsIdentModule] = doResolve(m.name).flatMap {
            case resolved if resolved.moduleName =/= m.name => Some(resolved.moduleName)
            case _                                          => None
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
