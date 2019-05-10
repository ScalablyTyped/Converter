package com.olvind.tso
package importer

import ammonite.ops.ls
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
    ls(folder.path)
      .collect { case files.IsDirectory(dir) if !ignored(dir.name) => dir }
      .flatMap[TsLibSource, Set[TsLibSource]] {
        case path if path.name === "@types" => Nil
        case path if path.name.startsWith("@") =>
          ls(path).map(
            nestedPath =>
              FromFolder(InFolder(nestedPath), TsIdentLibraryScoped(path.name.drop(1), Some(nestedPath.name))),
          )
        case path if path.name.contains("__") =>
          val Array(one, two) = path.name.split("__")
          Seq(FromFolder(InFolder(path), TsIdentLibraryScoped(one, Some(two))))
        case path => Seq(FromFolder(InFolder(path), TsIdentLibrarySimple(path.name)))
      }(collection.breakOut)
}
