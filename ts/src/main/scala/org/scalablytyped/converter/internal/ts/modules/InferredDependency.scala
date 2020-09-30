package org.scalablytyped.converter.internal
package ts
package modules

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.sets.{EmptySet, NonEmptySet}

/**
  * There is a tendency to use node things (at least, so far) without
  *  declaring it. This infers such use
  */
object InferredDependency {
  def apply(
      libName:            TsIdentLibrary,
      file:               TsParsedFile,
      nonResolvedModules: Set[TsIdentModule],
      logger:             Logger[Unit],
  ): Set[TsIdentLibrary] =
    Set.empty[TsIdentLibrary] ++ inferNode(nonResolvedModules) ++ inferFromPrefixes(file) - libName match {
      case e @ EmptySet() => e
      case inferred =>
        logger.info(s"Inferred dependencies $inferred for $libName")
        inferred
    }

  private def inferFromPrefixes(file: TsParsedFile) = {
    val prefixes: Set[TsIdent] =
      TsTreeTraverse
        .collect(file) {
          case TsQIdent(parts) if parts.nonEmpty => parts.head
        }
        .toSet

    libraryPrefix.filterKeys(prefixes).values
  }

  private def inferNode(nonResolvedModules: Set[TsIdentModule]): Option[TsIdentLibrary] =
    nonResolvedModules.filter(NodeModules) match {
      case NonEmptySet(_) => Option(TsIdentLibrarySimple("node"))
      case _              => None
    }

  private val libraryPrefix = Map[TsIdent, TsIdentLibrary](
    TsIdent("React") -> TsIdentLibrarySimple("react"),
    TsIdent("ng") -> TsIdentLibrarySimple("angular"),
    TsIdent("angular") -> TsIdentLibrarySimple("angular"),
    TsIdent("NodeJS") -> TsIdentLibrarySimple("node"),
    TsIdent("Buffer") -> TsIdentLibrarySimple("node"),
    TsIdent("global") -> TsIdentLibrarySimple("node"),
    TsIdent("moment") -> TsIdentLibrarySimple("moment"),
    TsIdent("Backbone") -> TsIdentLibrarySimple("backbone"),
    TsIdent("Leaflet") -> TsIdentLibrarySimple("leaflet"),
    TsIdent("Plotly") -> TsIdentLibrarySimple("plotly.js"),
  )

  private val NodeModules: Set[TsIdentModule] = Set(
    "buffer",
    "querystring",
    "events",
    "http",
    "cluster",
    "zlib",
    "os",
    "https",
    "punycode",
    "repl",
    "readline",
    "vm",
    "child_process",
    "url",
    "dns",
    "net",
    "dgram",
    "fs",
    "path",
    "string_decoder",
    "tls",
    "crypto",
    "stream",
    "util",
    "assert",
    "tty",
    "domain",
    "constants",
    "module",
    "process",
    "v8",
    "timers",
    "console",
    "async_hooks",
    "http2",
  ).map(TsIdentModule.simple)
}
