package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{FromFolder, TsLibSource}
import com.olvind.tso.ts.{TsIdentLibraryScoped, TsIdentLibrarySimple}

object TypescriptSources {
  def apply(nodeModulesFolder: InFolder, dtFolder: InFolder, ignored: Set[String]): Set[Source] = {
    val dtSources       = forFolder(dtFolder, ignored)
    val dtLibs          = dtSources.map(_.libName)
    val externalSources = forFolder(nodeModulesFolder, ignored).filterNot(s => dtLibs(s.libName))

    Set.empty[Source] ++ dtSources ++ externalSources
  }

  def forFolder(folder: InFolder, ignored: Set[String]): Set[TsLibSource] =
    os.list(folder.path)
      .collect { case dir if os.isDir(dir) && !ignored(dir.last) => dir }
      .flatMap[TsLibSource, Set[TsLibSource]] {
        case path if path.last === "@types" => Nil
        case path if path.last.startsWith("@") =>
          os.list(path)
            .map(
              nestedPath =>
                FromFolder(InFolder(nestedPath), TsIdentLibraryScoped(path.last.drop(1), Some(nestedPath.last))),
            )
        case path if path.last.contains("__") =>
          val Array(one, two) = path.last.split("__")
          Seq(FromFolder(InFolder(path), TsIdentLibraryScoped(one, Some(two))))
        case path => Seq(FromFolder(InFolder(path), TsIdentLibrarySimple(path.last)))
      }(collection.breakOut)
}
