package org.scalablytyped.converter.internal.importer.documentation

import org.scalablytyped.converter.internal.importer.Summary

object Readme {
  def apply(summary: Summary, runId: String, locOutput: Option[String]): String = s"""

# ScalablyTyped - The Javascript ecosystem for Scala.js!

[![Join the chat at https://gitter.im/ScalablyTyped/community](https://badges.gitter.im/ScalablyTyped/community.svg)](https://gitter.im/ScalablyTyped/community)

This is all example output of the ScalablyTyped Typescript to Scala.js converter.

Check out [https://www.scalablytyped.org](scalablytyped.org)

## About

This is one of the biggest Scala repos on the planet${describeSize(locOutput)}.

The jar files with all the libraries from this repo used to be published to bintray.
If you need to reconstruct exactly the jar files you had you can check out the repository from the date
 you have in your version number, and run `sbt publishLocal` yourself on the relevant libraries (with all dependencies).

"""

  def describeSize(locOutput: Option[String]) = locOutput match {
    case Some(output) =>
      s""":
```

$output
```
"""
    case None => " with millions of lines of code"
  }
}
