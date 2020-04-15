package org.scalablytyped.converter.internal.importer.documentation

import org.scalablytyped.converter.internal.importer.Summary
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

object Readme {
  def apply(summary: Summary, runId: String, locOutput: Option[String]): String = s"""

# ScalablyTyped - The Javascript ecosystem for Scala.js!

[![Join the chat at https://gitter.im/ScalablyTyped/community](https://badges.gitter.im/ScalablyTyped/community.svg)](https://gitter.im/ScalablyTyped/community)
[![Checkout the demos at https://github.com/ScalablyTyped/ScalablyTypedDemos/](https://img.shields.io/badge/Checkout-Demo-success.svg)](https://github.com/oyvindberg/ScalablyTypedDemos/)

## Warning :collision: :bomb: :sunglasses:

These pre-built typing libraries are now **deprecated**.
Please see [scalablytyped.org](https://scalablytyped.org) for the shiny new sbt plugin.

## About

This is the home of pre-built Scala.js typings for **${summary.successes.size}** Javascript libraries,
 which should span more or less the entire set of modern and popular libraries.

This should make it one of the biggest Scala repos on the planet${describeSize(locOutput)}

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

  def facades(summary: Summary) = {
    object FacadeName {
      def unapply(s: TsIdentLibrary): Option[String] =
        if (s.value.endsWith("-facade")) Some(s.value.replaceAllLiterally("-facade", ""))
        else None
    }

    summary.successes
      .collect { case FacadeName(name) => name }
      .map(x => "- " + s"[$x](facades/$x)")
      .mkString("\n")
  }
}
