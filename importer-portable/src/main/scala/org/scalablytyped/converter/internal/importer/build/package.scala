package org.scalablytyped.converter.internal.importer

/**
  * It felt really wrong to do, but this directory contains an entire simple scala build tool.
  *
  * All the hard parts are solved through coursier, zinc and bloop, but we do publishing ourselves.
  *
  * The single reason why this is is time.
  * `sbt clean publishLocal` takes 15-20 seconds *minimum*, while we do it in milliseconds
  *
  * This kind of adds up with ~5k projects.
  */
package object build {}
