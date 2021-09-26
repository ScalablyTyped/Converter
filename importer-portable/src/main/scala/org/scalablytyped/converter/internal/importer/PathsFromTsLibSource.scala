package org.scalablytyped.converter.internal
package importer

object PathsFromTsLibSource {
  val V  = "v[\\d\\.]+".r
  val TS = "ts[\\d\\.]+".r

  def filesFrom(bound: InFolder): IArray[InFile] = {
    def skip(dir: os.Path) =
      dir.last match {
        case "node_modules" => true
        /* The presence of these folders mostly means unnecessary duplication.
           If we desperately want these perhaps the user can configure that,
            though it won't be as easy as just discarding them
         */
        case "amd" => true
        case "umd" => true
        case "es"  => true
        case "es6" => true
        /* DefinitelyTyped uses this pattern for newer versions of typescript. We just use the default */
        case TS() => true
        /* DefinitelyTyped uses this pattern for old versions of the library */
        case V() => true
        case _   => false
      }

    IArray.fromTraversable(
      os.walk(bound.path, skip)
        .filter(path => path.last.endsWith(".d.ts") && os.isFile(path))
        .filterNot(_.last.contains(".src.")) // filter out files like highlight.src.d.ts,
        .map(InFile.apply),
    )
  }
}
