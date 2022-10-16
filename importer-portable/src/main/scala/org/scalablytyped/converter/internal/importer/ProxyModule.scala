package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.ts._

case class ProxyModule(
    comments:   Comments,
    libName:    TsIdentLibrary,
    fromModule: TsIdentModule,
    toModule:   TsIdentModule,
) {
  val asModule = TsDeclModule(
    comments = comments,
    declared = false,
    name     = toModule,
    members = IArray(
      TsExport(
        comments = NoComments,
        typeOnly = false,
        tpe      = ExportType.Named,
        exported = TsExportee.Star(None, fromModule),
      ),
    ),
    codePath   = CodePath.HasPath(libName, TsQIdent(IArray(toModule))),
    jsLocation = JsLocation.Zero,
  )
}

object ProxyModule {
  val FromExports = Comments("/* from `exports` in `package.json` */\n")

  def fromExports(
      source:   LibTsSource,
      logger:   Logger[_],
      resolve:  LibraryResolver,
      existing: TsIdent => Boolean,
      exports:  Map[String, String],
  ): Iterable[ProxyModule] = {
    val expandedGlobs = exports.flatMap {
      case tuple @ (exportedName, exportedTypesRelPath) =>
        exportedTypesRelPath.split('*') match {
          case Array(_) => Some(tuple)
          case Array(pre, post) =>
            val splitPrePath = pre.split('/').filterNot(_ == ".")

            // last part of `pre` may not be a full path fragment, so drop it and consider it below
            val (folderPrePart, preFileNameStart) =
              if (pre.endsWith("/")) (splitPrePath, "")
              else (splitPrePath.dropRight(1), splitPrePath.lastOption.getOrElse(""))

            val lookIn = folderPrePart.foldLeft(source.folder.path)(_ / _)

            // need to take whatever the glob expanded to and expand it into both `name` and `types`
            val expandedFragments = os.walk(lookIn).flatMap { path =>
              val relPathString = path.relativeTo(lookIn).toString()

              if (relPathString.startsWith(preFileNameStart) && relPathString.endsWith(post))
                Some(relPathString.drop(preFileNameStart.length).dropRight(post.length))
              else None
            }

            val expanded =
              expandedFragments.map(m => (exportedName.replace("*", m), exportedTypesRelPath.replace("*", m)))
            expanded

          case _ => logger.fatal(s"need to add support for more than one '*' in glob pattern $exportedTypesRelPath")
        }
    }

    val libModule = TsIdentModule.fromLibrary(source.libName)

    expandedGlobs.flatMap {
      case tuple @ (name, types) =>
        resolve.module(source, source.folder, types) match {
          case None =>
            // exports are manually annotated, no surprise there are typos
            logger.warn(s"couldn't resolve export $tuple")
            None

          case Some(resolvedModule) =>
            val fromModule = resolvedModule.moduleName
            val toModule   = libModule.copy(fragments = libModule.fragments ++ name.split("/").toList.filterNot(_ == "."))

            if (existing(toModule)) None
            else {
              logger.info(s"exposing module ${toModule.value} from ${fromModule.value}")
              Some(ProxyModule(FromExports, source.libName, fromModule, toModule))
            }
        }
    }
  }
}
