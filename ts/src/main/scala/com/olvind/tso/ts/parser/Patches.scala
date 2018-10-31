package com.olvind.tso.ts.parser
import ammonite.ops.RelPath
import com.olvind.tso.InFile

import ammonite.ops._

/**
  * These are library specific hacks to make up for shortcomings in the parser.
  * For now, it's about lack of whitespace awareness
  */
object Patches {
  final case class Patch(from: String, to: String)

  val patches: Map[RelPath, Patch] =
    Map[RelPath, Patch](
      // handle ambiguities because of non-whitespace aware parser
      "redux" / "index.d.ts" -> Patch(
        "\\): Store<S & StateExt, A> & Ext",
        "\\): Store<S & StateExt, A> & Ext,"
      ),

      "downshift" / 'typings / "index.d.ts" -> Patch(
        "refKey\\?: string",
        "refKey?: string;",
      ),

      // resolve circular set of type aliases
      "styled-components" / "index.d.ts" -> Patch(
        "export type InterpolationFunction<P> = \\(props: P\\) => Interpolation<P>;",
        "/* Return type should be Interpolation<P> */ export type InterpolationFunction<P> = (props: P) => InterpolationValue;",
      ),
      "create-emotion-styled" / 'types / "common.d.ts" -> Patch(
        "export type FunctionInterpolation<Props> = \\(props: Props, context: any\\) => Interpolation<Props>;",
        "/* Return type should be Interpolation<Props> */ export type FunctionInterpolation<Props> = (props: Props, context: any) => BaseInterpolation;",
      ),
    )

  def apply(inFile: InFile, content: String): String = {
    val rewritten = patches.collectFirst {
      case (path, patch) if inFile.path.segments.endsWith(path.segments) =>
        content.replaceAll(patch.from, patch.to)
    }

    rewritten getOrElse content
  }
}
