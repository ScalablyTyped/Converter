package org.scalablytyped.converter.internal.ts.parser
import org.scalablytyped.converter.internal.InFile

/**
  * These are library specific hacks to make up for shortcomings in the converter
  *
  * OOPS. When changing these, keep in mind that this operates at the parser level,
  *  and the result is cached. Delete cache between runs or comment out in `Main`
  */
object Patches {
  final case class Patch(comment: String, from: String, to: String)

  private val Patches = Map[os.RelPath, Seq[Patch]](
    os.RelPath("redux") / "index.d.ts" -> List(
      Patch(
        "handle ambiguity because of non-whitespace aware parser",
        "): Store<S & StateExt, A> & Ext",
        "): Store<S & StateExt, A> & Ext,",
      ),
    ),
    os.RelPath("downshift") / 'typings / "index.d.ts" -> List(
      Patch(
        "handle ambiguity because of non-whitespace aware parser",
        "refKey?: string",
        "refKey?: string;",
      ),
    ),
  )

  def apply(inFile: InFile, content: String): String = {
    val rewritten = Patches.collectFirst {
      case (relPath, patches) if inFile.path.endsWith(relPath) =>
        patches.foldLeft(content) {
          case (c, p) => c.replace(p.from, p.to)
        }
    }

    rewritten.getOrElse(content)
  }
}
