package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.{FromFolder, TsLibSource}
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

object TypescriptSources {
  def apply(nodeModulesFolder: InFolder, dtFolder: InFolder, ignored: Set[TsIdentLibrary]): Set[Source] = {
    val externalSources     = forFolder(nodeModulesFolder, ignored).filter(_.hasSources)
    val externalSourcesLibs = externalSources.map(_.libName)
    val dtSources           = forFolder(dtFolder, ignored).filterNot(s => externalSourcesLibs(s.libName))

    Set.empty[Source] ++ externalSources ++ dtSources
  }

  def forFolder(folder: InFolder, ignored: Set[TsIdentLibrary]): Set[TsLibSource] =
    os.list(folder.path)
      .collect { case dir if os.isDir(dir) => dir }
      .flatMap {
        case path if path.last.startsWith("@") =>
          if (path.last.startsWith("@types")) Nil
          else
            os.list(path)
              .map(nestedPath =>
                FromFolder(InFolder(nestedPath), TsIdentLibrary(s"${path.last}/${nestedPath.last}")): TsLibSource,
              )
        case path => List(FromFolder(InFolder(path), TsIdentLibrary(path.last)))
      }
      .filterNot(s => ignored(s.libName))
      .to[Set]
}
