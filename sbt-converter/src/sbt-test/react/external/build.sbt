import scala.sys.process.Process

lazy val testProject =
  project
    .in(file("."))
    .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
    .settings(
      externalNpm := {
        Process("yarn", baseDirectory.value).!
        baseDirectory.value
      },
      stFlavour := Flavour.Slinky,
      stIgnore += "csstype",
      scalaJSUseMainModuleInitializer := true,
      scalaVersion := "2.13.2",
      organization := "net.leibman",
    )
