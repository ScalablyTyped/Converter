package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{FromFolder, TsLibSource}
import com.olvind.tso.ts.TsIdentLibrary

object TypescriptSources {
  def apply(nodeModulesFolder: InFolder, dtFolder: InFolder, ignored: Set[TsIdentLibrary]): Set[Source] = {
    val dtSources       = forFolder(dtFolder, ignored)
    val dtLibs          = dtSources.map(_.libName)
    val externalSources = forFolder(nodeModulesFolder, ignored).filterNot(s => dtLibs(s.libName))

    Set.empty[Source] ++ dtSources ++ externalSources
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
