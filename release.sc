import ammonite.ops._

import scala.util.Try

case class DemoRepo(repo: String, name: String)(implicit path: os.Path) {

  def update(): Unit = {
    %.git("checkout", "master")
    %.git("fetch")
    %.git("reset", "--hard", "origin/master")
  }

  def build(version: String): Unit = {
    val pluginsFile = path / "project" / "plugins.sbt"
    val newLines = os.read.lines(pluginsFile).map {
      case line if line.contains(s"""addSbtPlugin("org.scala-js" % "sbt-scalajs" %)""") =>
        s"""addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.3.0")"""
      case line if line.contains(s"""addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" %""") =>
        s"""addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0")"""
      case line if line.contains(s"""addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" %""") =>
        s"""addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "$version")"""
      case line => line
    }
    os.write.over(path / "project" / "build.properties", "sbt.version=1.4.1")
    os.write.over(pluginsFile, newLines.mkString("\n"))
    %.sbt("compile", "dist")
    %.git("add", "-A")
    %.git("commit", "-m", s"Bump to $version")
  }

  def pushCache(): Unit =
    %.sbt("stPublishCache")

  def pushGit(): Unit =
    %.git("push", "origin", "HEAD")
}

object DemoRepo {
  val repos = List("Demos", "ScalaJsReactDemos", "SlinkyDemos")

  def initialized(in: os.Path): List[DemoRepo] = {
    os.makeDir.all(in)

    repos.map { name =>
      val repo     = s"git@github.com:ScalablyTyped/$name.git"
      val repoPath = in / name
      if (!os.exists(repoPath)) {
        %.git("clone", repo)(in)
      }
      DemoRepo(repo, name)(repoPath)
    }
  }
}

case class Repo(version: String)(implicit val wd: os.Path) {
  val tag = s"v$version"

  def assertClean() =
    %%.git("status", "--porcelain").out.string match {
      case ""       => ()
      case nonEmpty => sys.error(s"Expected clean directory, git changes:\n$nonEmpty")
    }

  def refreshTag() = {
    Try(%%.git("tag", "-d", tag))
    %.git("tag", tag)
  }

  def publishLocal() =
    %("sbt", "clean", "publishLocal")

  def publish() = {
    %("sbt", "publish", "docs/mdoc")
    %("yarn", "publish-gh-pages")(wd / "website")
    %.git("push", "origin", "HEAD")
    %.git("push", "origin", tag)
  }
}

@main
  def doRelease(version: String): Int = {
    val repo = Repo(version)(os.pwd)
    repo.assertClean()
    repo.refreshTag()
    repo.publishLocal()
    val demoRepos = DemoRepo.initialized(os.Path("/tmp/st-release-temp"))
    demoRepos.foreach(_.update())
    demoRepos.foreach(_.build(version))
    demoRepos.foreach(_.pushCache())
    // at this point we're ready to push everything
    repo.publish()
    demoRepos.foreach(_.pushGit())
    0
  }
