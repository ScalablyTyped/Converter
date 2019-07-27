package com.olvind.tso.ts.parser
import com.olvind.tso.InFile

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
    os.RelPath("@emotion") / 'serialize / 'types / "index.d.ts" -> List(
      Patch(
        "resolve circular set of type aliases",
        "export type FunctionInterpolation<MP> = (mergedProps: MP) => Interpolation<MP>",
        "/* break circular type alias by converting to interface*/ export interface FunctionInterpolation<MP>{(mergedProps: MP): Interpolation<MP>}",
      ),
    ),
    os.RelPath("styled-components") / "index.d.ts" -> List(
      Patch(
        "resolve double Omit",
        "type WithOptionalTheme<P extends { theme?: T }, T> = Omit<P, \"theme\"> & {\n    theme?: T;\n};",
        "type WithOptionalTheme<P extends { theme?: T }, T> = P & {\n    theme?: T;\n};",
      ),
      Patch(
        "resolve circular set of type aliases",
        "export type InterpolationFunction<P> = (props: P) => Interpolation<P>;",
        "/* break circular type alias by converting to interface*/ export interface InterpolationFunction<P>{(props: P): Interpolation<P>}",
      ),
    ),
  )

  def apply(inFile: InFile, content: String): String = {
    val rewritten = Patches.collectFirst {
      case (path, patches) if inFile.path.endsWith(path.segments) =>
        patches.foldLeft(content) {
          case (c, p) => c.replace(p.from, p.to)
        }
    }

    rewritten getOrElse content
  }
}
