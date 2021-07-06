import ammonite.ops._

import scala.util.Try

case class DemoRepo(repo: String, name: String)(implicit path: os.Path) {

  def update(): Unit = {
    %.git("checkout", "master")
    %.git("fetch")
    %.git("reset", "--hard", "origin/master")
    // pick up changes from `update` branch if any
    Try(%.git("merge", "origin/update"))
  }

  def build(version: String): Unit = {
    val pluginsFile = path / "project" / "plugins.sbt"
    val newLines = os.read.lines(pluginsFile).flatMap {
      case line if line.contains(s"""addSbtPlugin("org.scala-js" % "sbt-scalajs" %""") =>
        Some(s"""addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.6.0")""")
      case line if line.contains(s"""addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" %""") =>
        Some(s"""addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0")""")
      case line if line.contains(s"""addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" %""") =>
        Some(s"""addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "$version")""")
      case line if line.contains("resolvers +=") =>
        None
      case line => Some(line)
    }
    os.write.over(path / "project" / "build.properties", "sbt.version=1.5.4")
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

  def cleanLocal() = {
    val existing = os.walk(os.home / ".ivy2" / "local" / "org.scalablytyped.converter").filter(_.last == version)
    if (existing.nonEmpty) {
      println(s"Cleaning existing locally published")
      existing.foreach(println)
      existing.foreach(folder => os.remove.all(folder))
    }
  }

  def publishLocal() =
    %("sbt", "clean", "publishLocal")

  def publish() = {
    %("sbt", "ci-release", "docs/mdoc")
    %("yarn", "publish-gh-pages")(wd / "website")
    %.git("push", "origin", "HEAD")
    %.git("push", "origin", tag)
  }
}

def mustHave(name: String) =
  sys.env.getOrElse(name, sys.error(s"Set env $name"))

@main
def doRelease(version: String): Int = {
  mustHave("PGP_PASSPHRASE")
  mustHave("PGP_SECRET")
  mustHave("SONATYPE_PASSWORD")
  mustHave("SONATYPE_USERNAME")
  mustHave("CI_COMMIT_TAG") // just set to true

  val repo = Repo(version)(os.pwd)
  repo.assertClean()
  repo.refreshTag()
  repo.cleanLocal()
  repo.publishLocal()
  val demoRepos = DemoRepo.initialized(os.Path("/tmp/st-release-temp"))
  demoRepos.foreach(_.update())
  demoRepos.foreach(_.build(version))
  demoRepos.foreach(_.pushCache())
  // at this point we're ready to push everything
  repo.assertClean()
  repo.publish()
  demoRepos.foreach(_.pushGit())
  0
}
