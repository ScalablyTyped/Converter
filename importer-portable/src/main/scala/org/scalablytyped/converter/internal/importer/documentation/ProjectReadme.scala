package org.scalablytyped.converter.internal
package importer.documentation

import org.scalablytyped.converter.internal.importer.documentation.Npmjs.Collected

object ProjectReadme {

  def apply(
      name:            String,
      declaredVersion: Option[LibraryVersion],
      dataOpt:         Option[Npmjs.Data],
      comments:        Comments,
  ): String = {
    val source =
      if (declaredVersion.exists(_.inGit.exists(_.isDefinitelyTyped)))
        link("DefinitelyTyped", "https://definitelytyped.org")
      else "first party type definitions"

    s"""
# Scala.js typings for $name

${declaredVersion.fold("")(renderVersion)}
${dataOpt.fold("")(renderData)}

## Note
This library has been generated from typescript code from $source.

Provided with :purple_heart: from ${link("ScalablyTyped", "https://github.com/oyvindberg/ScalablyTyped")}

## Usage
See ${link("the main readme", "../../readme.md")} for instructions.

${renderComments(comments)}
"""
  }

  def renderComments(comments: Comments): String =
    comments.rawCs.distinct match {
      case Nil => ""
      case cs =>
        s"""## Comments

These comments are from the typescript definitions and might be useful:
```
${cs.mkString}
```
"""
    }

  def renderVersion(v: LibraryVersion): String =
    v match {
      case LibraryVersion(_, Some(declared), _) => s"Typings are for version $declared\n"
      case _                                    => ""
    }

  def renderData(data: Npmjs.Data): String = {
    val metadata = data.collected.metadata

    s"""${metadata.description.fold("")(d => "## Library description:\n" + d)}

|                    |                 |
| ------------------ | :-------------: |
| Full name          | ${metadata.name} |
| Keywords           | ${metadata.keywords.fold("-")(_.mkString(", "))} |
| # releases         | ${metadata.releases.lastOption.fold("?")(_.count.toString)} |
| # dependents       | ${data.evaluation.popularity.dependentsCount} |
| # downloads        | ${data.evaluation.popularity.downloadsCount} |
| # stars            | ${data.collected.github.fold("?")(_.starsCount.toString)} |

## Links
${optList(
      optLink("Homepage", metadata.links.homepage),
      optLink("Bugs", metadata.links.bugs),
      optLink("Repository", metadata.links.repository),
      optLink("Npm", metadata.links.npm),
    )}
    
"""
  }

  def optList(elems: Option[String]*): String =
    elems.flatten.map(s => "- " + s).mkString("\n")

  def optLink(title: String, urlOpt: Option[String]): Option[String] =
    urlOpt.map(url => link(title, url))

  def link(title: String, url: String): String = s"[$title]($url)"
}
