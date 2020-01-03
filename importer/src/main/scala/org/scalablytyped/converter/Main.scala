package org.scalablytyped.converter

import org.scalablytyped.converter.internal.importer.{Config, Main}

object Main {
  def main(args: Array[String]): Unit = {
    val Config(config) = args
    /* I havent found a way to configure bloop to customize the global ExecutionContext, so this is it */
    System.setProperty("scala.concurrent.context.numThreads", config.parallelScalas.toString)
    new Main(config).run()
  }
}
