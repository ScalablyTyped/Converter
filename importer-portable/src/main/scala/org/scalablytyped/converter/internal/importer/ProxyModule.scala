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
  val FromExports     = Comments("/* from `exports` in `package.json` */\n")
  val TopLevelModule = Comments("/* Inferred short module name */\n")

  /* some things kind of implicitly end up being the top-level module. this will add such a default module if none exist */
  def topLevel(source: LibTsSource.FromFolder, existing: TsIdent => Boolean): Option[ProxyModule] = {
    def fromTypingsJson(files: Option[IArray[String]]): IArray[InFile] =
      files.getOrElse(IArray.Empty).collect {
        case path if path.endsWith("typings.json") =>
          val typingsJsonPath = source.folder.path / os.RelPath(path)
          val typingsJson     = Json.force[TypingsJson](typingsJsonPath)
          InFile(typingsJsonPath / os.up / typingsJson.main)
      }

    def fromFileEntry(files: Option[IArray[String]]): IArray[InFile] =
      files.getOrElse(IArray.Empty).mapNotNone(file => LibraryResolver.file(source.folder, file))

    def fromModuleDeclaration(files: Option[Map[String, String]]): IArray[InFile] = {
      val files1 = files match {
        case Some(files) => IArray.fromTraversable(files.values)
        case None        => IArray.Empty
      }

      files1
        .mapNotNone(file => LibraryResolver.file(source.folder, file))
        .mapNotNone {
          case existingFile if LibTsSource.hasTypescriptSources(existingFile.folder) => Some(existingFile)
          case _                                                                     => None
        }
    }

    val found = {
      val fromTypings = {
        val types = source.packageJsonOpt.flatMap(_.parsedTypes).orElse(source.packageJsonOpt.flatMap(_.parsedTypings))
        IArray(
          fromFileEntry(types),
          fromTypingsJson(source.packageJsonOpt.flatMap(_.parsedTypings)),
        ).flatten
      }

      if (fromTypings.nonEmpty) fromTypings
      else fromModuleDeclaration(source.packageJsonOpt.flatMap(_.parsedModules))
    }

    val sorted = found.sortBy(inFile => (inFile.path.last.startsWith("index"), inFile.path.toString().length))
    if (sorted.length > 1) {
      print(0)
    }
    val maybeChosenFile =
      sorted.lastOption

    maybeChosenFile
      .map { chosenFile =>
        val fromModule = LibraryResolver.moduleNameFor(source, chosenFile)
        val toModule   = TsIdentModule.fromLibrary(source.libName)
        ProxyModule(TopLevelModule, source.libName, fromModule, toModule)
      }
      .filterNot(pm => existing(pm.toModule))
  }

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
        val fromModule = resolve.module(source, source.folder, types) match {
          case Some(resolvedModule) => resolvedModule.moduleName
          case None                 => logger.fatal(s"couldn't resolve $tuple")
        }

        val toModule =
          libModule.copy(fragments = libModule.fragments ++ name.split("/").toList.filterNot(_ == "."))

        if (existing(toModule)) None
        else {
          logger.info(s"exposing module ${toModule.value} from ${fromModule.value}")
          Some(ProxyModule(FromExports, source.libName, fromModule, toModule))
        }
    }
  }
}
