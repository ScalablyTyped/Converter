package org.scalablytyped.converter.internal
package importer

import bintry.{Client, Message, PackageSummary}
import monix.execution.atomic.AtomicLong

import scala.concurrent.ExecutionContext.Implicits.global

object BintrayCleanup extends App {
  val Ci.Config(config) = args

  val values: Map[String, String] =
    files
      .content(InFile(os.home / ".bintray" / ".credentials"))
      .split("\n")
      .map(_.split("=").map(_.trim).filter(_.nonEmpty).toList)
      .collect { case List(k, v) => (k, v) }
      .toMap

  private val user     = values("user")
  private val password = values("password")

  private lazy val client = Client(user, password)
  private lazy val repo   = client.repo(user, config.projectName)

  val deleted = AtomicLong(0)

  def deleteFrom(pos: Int): Unit =
    repo.packages(pos)().foreach { packages =>
      packages.foreach {
        case PackageSummary(name, _) =>
          if (!name.startsWith("sbt-")) { // leave old versions of plugin
            val Pkg = repo.get(name)
            Pkg().foreach { pkg =>
              pkg.versions.drop(4).foreach { d =>
                Pkg.version(d).delete().foreach {
                  case Message(msg) =>
                    deleted.increment()
                    println(s"Deleted $name $d $msg (${deleted.get})")
                }
              }
            }
          }
      }

      if (packages.nonEmpty) {
        deleteFrom(pos + packages.length)
      }
    }

  deleteFrom(0)

}
