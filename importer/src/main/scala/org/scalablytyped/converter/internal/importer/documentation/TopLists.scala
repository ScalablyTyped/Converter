package org.scalablytyped.converter.internal
package importer.documentation

import org.scalablytyped.converter.internal.importer.build.ScalaProject

object TopLists {
  case class Lists(byScore: String, byName: String, byDependents: String)

  def link(title: String, url: String): String = s"[${title.take(25)}]($url)"

  val TakeUntilChr = Set('#', '!', '[', '\n')

  def desc(m: Npmjs.Data): String =
    m.collected.metadata.description
      .map(
        _.replaceAllLiterally("`", "")
          .replaceAllLiterally("|", "")
          .replaceAll("<[^>]+>", "") // remove html
          .takeWhile(x => !TakeUntilChr(x))
          .take(50),
      )
      .filter(_.nonEmpty)
      .getOrElse("-")

  def apply(successes: Set[ScalaProject]): Lists = {
    val withMetadata = successes.toArray.collect {
      case x if x.metadata.isDefined => x -> x.metadata.get
    }

    val byScoreRows = withMetadata.sortBy { case (p, m) => (-m.score.`final`, p.name) }.map {
      case (p, m) =>
        s"| ${m.score.`final`} | ${link(p.name, s"./${p.name.head}/${p.name}")} | ${desc(m)}"
    }

    val byNameRows = successes.toArray.sortBy { _.name }.map { x =>
      val nameLink    = link(x.name, s"./${x.name.head}/${x.name}")
      val description = x.metadata.fold("-")(desc)
      val keywords = x.metadata
        .flatMap(_.collected.metadata.keywords)
        .map(_.mkString(", "))
        .filter(_.nonEmpty)
        .getOrElse("-")
      s"| $nameLink | $description | $keywords |"
    }

    val byDependentsRows = withMetadata
      .sortBy { case (p, m) => (-m.evaluation.popularity.dependentsCount, p.name) }
      .map {
        case (p, m) =>
          s"| ${m.evaluation.popularity.dependentsCount} | ${link(p.name, s"./${p.name.head}/${p.name}")} | ${desc(m)}"
      }

    Lists(
      byScore      = s"""# Libraries by score
 Score | Library | Description
 ---| --- | ---
${byScoreRows.mkString("\n")} |
""",
      byName       = s"""# All Libraries
 Library | Description | keywords
 --- | --- | ---
${byNameRows.mkString("\n")}
""",
      byDependents = s"""# Libraries by number of dependents
 Number of dependents | Library  | Description
 --- | --- | ---
${byDependentsRows.mkString("\n")} |
""",
    )
  }
}
