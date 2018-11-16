package com.olvind.tso.ts.parser
import ammonite.ops.RelPath
import com.olvind.tso.InFile

import ammonite.ops._

/**
  * These are library specific hacks to make up for shortcomings in the parser.
  */
object Patches {
  final case class Patch(comment: String, from: String, to: String)

  private val Patches = Map[RelPath, Seq[Patch]](
    "redux" / "index.d.ts" -> List(
      Patch(
        "handle ambiguity because of non-whitespace aware parser",
        "): Store<S & StateExt, A> & Ext",
        "): Store<S & StateExt, A> & Ext,"
      )
    ),
    "downshift" / 'typings / "index.d.ts" -> List(
      Patch(
        "handle ambiguity because of non-whitespace aware parser",
        "refKey?: string",
        "refKey?: string;",
      )
    ),
    "styled-components" / "index.d.ts" -> List(
      Patch(
        "resolve circular set of type aliases",
        "export type InterpolationFunction<P> = (props: P) => Interpolation<P>;",
        "/* Return type should be (P) => Interpolation<P> */ export type InterpolationFunction<P> = (props: P) => InterpolationValue;",
      ),
      Patch(
        "protect against `Omit` inside `Omit` such that `InlineNestedIdentityAlias` doesn't understand it",
        "type WithOptionalTheme<P extends { theme?: T }, T> = Omit<P, 'theme'>",
        "type WithOptionalTheme<P extends { theme?: T }, T> = P",
      )
    ),
    "create-emotion-styled" / 'types / "common.d.ts" -> List(
      Patch(
        "resolve circular set of type aliases",
        "export type InterpolationFunction<P> = (props: P) => Interpolation<P>;",
        "/* Return type should be Interpolation<Props> */ export type InterpolationFunction<P> = (props: P) => BaseInterpolation<P>;",
      )
    ),
  )

  def apply(inFile: InFile, content: String): String = {
    val rewritten = Patches.collectFirst {
      case (path, patches) if inFile.path.segments.endsWith(path.segments) =>
        patches.foldLeft(content) {
          case (c, p) => c.replace(p.from, p.to)
        }
    }

    rewritten getOrElse content
  }
}
