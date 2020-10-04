import ammonite.ops._

import scala.util.Try
import scala.util.control.NonFatal

case class DemoRepo(repo: String, name: String, path: os.Path) {
  private implicit val wd = path

  def update(): Unit = {
    %.git("checkout", "master")
    %.git("fetch")
    %.git("reset", "--hard", "origin/master")
  }

  def build(version: String): Unit = {
    val pluginsFile = path / "project" / "plugins.sbt"
    val newLines = os.read.lines(pluginsFile).map {
      case line if line.contains("sbt-converter") =>
        s"""addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "$version")"""
      case line => line
    }
    os.write.over(pluginsFile, newLines.mkString("\n"))
    %.sbt("dist")
    %.git("add", "-A")
    %.git("commit", "-m", s"Bump to $version")
  }

  def pushCache(): Unit =
    %.sbt("stPublishCache")

  def publish(): Unit =
    %.git("push", "origin", "HEAD")
}

object DemoRepo {
  def initialized(in: os.Path): List[DemoRepo] =
    List(
      "git@github.com:ScalablyTyped/Demos.git",
      "git@github.com:ScalablyTyped/ScalaJsReactDemos.git",
      "git@github.com:ScalablyTyped/SlinkyDemos.git",
    ).map { repo =>
      val name        = repo.split("/").last.replace(".git", "")
      implicit val wd = in
      val repoPath    = in / name

      if (!os.exists(repoPath)) {
        %.git("clone", repo)
      }
      DemoRepo(repo, name, repoPath)
    }
}

class Repo(version: String)(implicit val wd: os.Path) {
  val tag = s"v$version"

  def assertClean() =
    %%("git", "status", "--porcelain").out.string match {
      case ""       => ()
      case nonEmpty => sys.error(s"Expected clean directory, git changes $nonEmpty")
    }

  def refreshTag() = {
    Try(%%.git("tag", "-d", tag))
    %.git("tag", tag)
  }
  def publishLocal() =
    %("sbt", "clean", "publishLocal")

  def publish() = {
    %("sbt", "publish")
    %.git("push", "origin", tag)
  }
}

@main
  def doRelease(version: String): Int =
    try {
      val repo = new Repo(version)(os.pwd)
      repo.assertClean()
      repo.refreshTag()
      repo.publishLocal()
      val releaseTemp = os.Path("/tmp/st-release-temp")
      os.makeDir.all(releaseTemp)
      val demoRepos = DemoRepo.initialized(releaseTemp)
      demoRepos.foreach(_.update())
      demoRepos.foreach(_.build(version))
      demoRepos.foreach(_.pushCache())
      // at this point we're ready to push everything
      repo.publish()
      demoRepos.foreach(_.publish())
      0
    } catch {
      case NonFatal(th) =>
        println(s"Release of $version failed")
        th.printStackTrace()
        1
    }
