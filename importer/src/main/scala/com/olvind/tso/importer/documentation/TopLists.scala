package com.olvind.tso.importer.documentation

import com.olvind.tso.Set
import com.olvind.tso.importer.build.PublishedSbtProject

object TopLists {
  case class Lists(byScore: String, byName: String, byDependents: String)

  def link(title: String, url: String): String = s"[$title]($url)"

  def apply(successes: Set[PublishedSbtProject]): Lists = {
    val withMetadata = successes.toArray.collect {
      case x if x.project.metadata.isDefined => x -> x.project.metadata.get
    }

    val byScoreRows = withMetadata.sortBy { case (p, m) => (-m.score.`final`, p.project.name) }.map {
      case (p, m) =>
        s"| ${m.score.`final`} | ${link(p.project.name, s"./${p.project.name.head}/${p.project.name}")} | ${m.collected.metadata.description}"
    }
    val byNameRows = withMetadata.sortBy { case (p, m) => p.project.name }.map {
      case (p, m) =>
        s"| ${link(p.project.name, s"./${p.project.name.head}/${p.project.name}")} | ${m.collected.metadata.description} |"
    }

    val byDependentsRows = withMetadata
      .sortBy { case (p, m) => (-m.collected.npm.dependentsCount, p.project.name) }
      .map {
        case (p, m) =>
          s"| ${m.collected.npm.dependentsCount} | ${link(p.project.name, s"./${p.project.name.head}/${p.project.name}")} | ${m.collected.metadata.description}"
      }

    Lists(
      byScore      = s"""# Libraries by score
 Score | Library         | Description
 ------| :-------------: | :----------:
${byScoreRows.mkString("\n")} |
""",
      byName       = s"""# Libraries by stars
 Library | Description
 :-----: | :---------:
${byNameRows.mkString("\n")}
""",
      byDependents = s"""# Libraries by number of dependents
 Number of dependents | Library  | Description
 -------------------- | :------: | :---------:
${byDependentsRows.mkString("\n")} |
"""
    )
  }
}
