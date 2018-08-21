import sbt.{stringToOrganization, Def, ModuleID}
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.toPlatformDepsGroupID

object Deps {
  val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"
  val ammoniteOps       = "com.lihaoyi"            %% "ammonite-ops"             % "1.1.2"
  val sourcecode        = "com.lihaoyi"            %% "sourcecode"               % "0.1.4"
  val scalatest         = "org.scalatest"          %% "scalatest"                % "3.0.5"
  val fansi             = "com.lihaoyi"            %% "fansi"                    % "0.2.5"
  val bloop             = "ch.epfl.scala"          %% "bloop-backend"            % "1.0.0"

  val circe: Seq[ModuleID] =
    Seq("core", "generic", "parser").map(s => "io.circe" %% s"circe-$s" % "0.9.3")

  val scalaJsDom: Def.Initialize[ModuleID] =
    Def.setting("org.scala-js" %%% "scalajs-dom" % "0.9.6")
}
