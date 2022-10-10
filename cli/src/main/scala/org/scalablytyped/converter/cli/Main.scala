package org.scalablytyped.converter.cli

import com.olvind.logging.{stdout, storing, LogLevel, Logger}
import fansi.{Attr, Color, Str}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.importer.build.{BloopCompiler, PublishedSbtProject, SbtProject}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.phases.PhaseListener.NoListener
import org.scalablytyped.converter.internal.phases.{PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.sets.SetOps
import org.scalablytyped.converter.internal.ts.CalculateLibraryVersion.PackageJsonOnly
import org.scalablytyped.converter.internal.ts.{PackageJson, TsIdentLibrary}
import org.scalablytyped.converter.internal.{constants, files, sets, BuildInfo, InFolder, Json}
import org.scalablytyped.converter.{Flavour, Selection}
import scopt.{OParser, OParserBuilder, Read}

import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

object Main {
  class Paths(base: os.Path) {
    lazy val out: os.Path =
      files.existing(base / 'out)
    val node_modules: Option[os.Path] =
      Option(base / 'node_modules).filter(files.exists)
    val packageJson: Option[os.Path] =
      Option(base / "package.json").filter(files.exists)
  }

  val DefaultOptions = ConversionOptions(
    useScalaJsDomTypes     = true,
    outputPackage          = Name.typings,
    enableScalaJsDefined   = Selection.All,
    flavour                = Flavour.Normal,
    ignored                = SortedSet("typescript"),
    stdLibs                = SortedSet("es6"),
    expandTypeMappings     = EnabledTypeMappingExpansion.DefaultSelection,
    versions               = Versions(Versions.Scala3, Versions.ScalaJs1),
    organization           = "org.scalablytyped",
    enableReactTreeShaking = Selection.None,
    enableLongApplyMethod  = false,
    privateWithin          = None,
  )

  case class Config(
      conversion:     ConversionOptions,
      wantedLibs:     SortedSet[TsIdentLibrary],
      inDirectory:    os.Path,
      includeDev:     Boolean,
      includeProject: Boolean,
  ) {
    lazy val paths = new Paths(inDirectory)
    def mapConversion(f: ConversionOptions => ConversionOptions) = copy(conversion = f(conversion))
  }

  val DefaultConfig = Config(
    DefaultOptions,
    wantedLibs     = SortedSet(),
    inDirectory    = os.pwd,
    includeDev     = false,
    includeProject = false,
  )

  val parseCachePath = Some(files.existing(constants.defaultCacheFolder / 'parse).toNIO)
  val t0             = System.currentTimeMillis

  val logger: Logger[(Array[Logger.Stored], Unit)] =
    storing().zipWith(stdout.filter(LogLevel.warn))

  implicit val ReadsFlavour: Read[Flavour] =
    Read.reads(s => Flavour.byName.getOrElse(s, sys.error(s"'$s' is not among ${Flavour.byName.keys}")))

  implicit val ReadsVersionsScalaJs: Read[Versions.ScalaJs] =
    Read.stringRead.map(Versions.ScalaJs.apply)

  implicit val ReadsVersionsScala: Read[Versions.Scala] =
    Read.stringRead.map(Versions.Scala.apply)

  implicit val ReadsTsIdentLibrary: Read[TsIdentLibrary] =
    Read.stringRead.map(TsIdentLibrary.apply)

  implicit val ReadsProjectName: Read[ProjectName] =
    Read.stringRead.map(ProjectName)

  implicit val ReadsOsPath: Read[os.Path] =
    Read.stringRead.map { str =>
      Try(os.Path(str)) match {
        case Failure(_) =>
          os.pwd / os.RelPath(str)
        case Success(absolute) => absolute
      }
    }

  implicit def ReadsSelection[T: Ordering](implicit ts: Read[Seq[T]]): Read[Selection[T]] = Read.reads {
    case "all"                  => Selection.All
    case "none"                 => Selection.All
    case s if s.startsWith("+") => Selection.NoneExcept(ts.reads(s.drop(1)): _*)
    case s if s.startsWith("-") => Selection.AllExcept(ts.reads(s.drop(1)): _*)
    case _ =>
      sys.error(
        "Syntax: `all`/`none` for Selection.All/Selection.None, `+a,b` for Selection.NoneExcept(a, b), `-a,b` for Selection.AllExcept(a, b)",
      )
  }

  val ParseConversionOptions: OParser[Unit, Config] = {
    val builder: OParserBuilder[Config] = OParser.builder[Config]
    import builder._
    OParser.sequence(
      programName("stc"),
      head(s"ScalablyTyped Converter (version ${BuildInfo.version})"),
      help('h', "help"),
      version('v', "version"),
      opt[os.Path]('d', "directory")
        .action((x, c) => c.copy(inDirectory = x))
        .text("Specify another directory instead of the current directory where your package.json and node_modules is"),
      opt[Boolean]("includeDev")
        .action((x, c) => c.copy(includeDev = x))
        .text("Include dev dependencies"),
      opt[Boolean]("includeProject")
        .action((x, c) => c.copy(includeProject = x))
        .text("Include project in current directory"),
      opt[Boolean]("useScalaJsDomTypes")
        .action((x, c) => c.mapConversion(_.copy(useScalaJsDomTypes = x)))
        .text(
          "When true (which is the default) uses scala-js-dom types when possible instead of types we translate from typescript in std",
        ),
      opt[Flavour]('f', "flavour")
        .action((x, c) => c.mapConversion(_.copy(flavour = x)))
        .text(
          s"One of ${Flavour.byName.keys.mkString(", ")}. See https://scalablytyped.org/docs/flavour",
        ),
      opt[Versions.ScalaJs]("scalajs")
        .action((x, c) => c.mapConversion(cc => cc.copy(versions = cc.versions.copy(scalaJs = x))))
        .text(s"Scala.js version"),
      opt[Versions.Scala]("scala")
        .action((x, c) => c.mapConversion(cc => cc.copy(versions = cc.versions.copy(scala = x))))
        .text(s"Scala version"),
      opt[String]("outputPackage")
        .action((x, c) => c.mapConversion(_.copy(outputPackage = Name(x))))
        .text(s"Output package"),
      opt[Selection[TsIdentLibrary]]("enableScalaJSDefined")
        .action((x, c) => c.mapConversion(_.copy(enableScalaJsDefined = x)))
        .text(s"Libraries you want to enable @ScalaJSDefined traits for."),
      opt[Seq[String]]('s', "stdlib")
        .action((x, c) => c.mapConversion(_.copy(stdLibs = x.toSet.sorted)))
        .text(s"Which parts of typescript stdlib you want to enable"),
      opt[String]("organization")
        .action((x, c) => c.mapConversion(_.copy(organization = x)))
        .text(s"Organization used (locally) publish artifacts"),
      opt[Seq[String]]("ignoredLibs")
        .action((x, c) => c.mapConversion(_.copy(ignored = x.toSet.sorted)))
        .text(s"Libraries you want to ignore"),
      opt[String]("privateWithin")
        .action((x, c) => c.mapConversion(_.copy(privateWithin = Some(Name(x)))))
        .text(s"Libraries you want to ignore"),
      opt[Boolean]("experimentalEnableImplicitOps")
        .action { (x, c) =>
          logger.warn("--experimentalEnableImplicitOps has no effect since it became the default encoding")
          c
        }
        .text(s"Deprecated, doesn't do anything anymore"),
      opt[Boolean]("enableLongApplyMethod")
        .action((x, c) => c.mapConversion(_.copy(enableLongApplyMethod = x)))
        .text(s"Enables long apply methods, instead of implicit ops builders"),
      arg[Seq[TsIdentLibrary]]("libs")
        .text("Libraries you want to convert from node_modules")
        .unbounded()
        .optional()
        .action((x, c) => c.copy(wantedLibs = c.wantedLibs ++ x)),
    )
  }

  def table(Key: Attr)(kvs: (String, String)*): Str = {
    val headerLength = kvs.map { case (header, _) => header }.maxBy(_.length).length + 1
    val massaged = kvs.flatMap {
      case (header, value) => Seq[Str](Key(header.padTo(headerLength, ' ')), value, "\n")
    }
    Str.join(massaged)
  }

  def main(args: Array[String]): Unit =
    OParser.parse(ParseConversionOptions, args, DefaultConfig) match {
      case Some(
          c @ Config(
            conversion,
            libsFromCmdLine,
            inDir,
            includeDev,
            includeProject,
          ),
          ) =>
        val packageJsonPath = c.paths.packageJson.getOrElse(sys.error(s"$inDir does not contain package.json"))
        val nodeModulesPath = c.paths.node_modules.getOrElse(sys.error(s"$inDir does not contain node_modules"))
        require(files.exists(nodeModulesPath / "typescript" / "lib"), "must install typescript")

        val packageJson = Json.force[PackageJson](packageJsonPath)

        val projectSource: Option[LibTsSource.FromFolder] =
          if (includeProject) Some(LibTsSource.FromFolder(InFolder(inDir), TsIdentLibrary(inDir.last))) else None

        val wantedLibs: SortedSet[TsIdentLibrary] =
          libsFromCmdLine match {
            case sets.EmptySet() =>
              val fromPackageJson = packageJson.allLibs(includeDev, peer = true).keySet
              require(fromPackageJson.nonEmpty, "No libraries found in package.json")
              val ret = fromPackageJson -- conversion.ignoredLibs
              require(ret.nonEmpty, s"All libraries in package.json ignored")
              ret
            case otherwise => otherwise
          }

        val bootstrapped = Bootstrap.fromNodeModules(InFolder(nodeModulesPath), conversion, wantedLibs)

        val sources: Vector[LibTsSource] = {
          bootstrapped.initialLibs match {
            case Left(unresolved) => sys.error(unresolved.msg)
            case Right(initial)   => projectSource.foldLeft(initial)(_ :+ _)
          }
        }

        println(
          table(fansi.Color.LightBlue)(
            "directory" -> inDir.toString,
            "includeDev" -> includeDev.toString,
            "includeProject" -> includeProject.toString,
            "wantedLibs" -> sources.map(s => s.libName.value).mkString(", "),
            "useScalaJsDomTypes" -> conversion.useScalaJsDomTypes.toString,
            "flavour" -> conversion.flavour.toString,
            "outputPackage" -> conversion.outputPackage.unescaped,
            "enableScalaJsDefined" -> conversion.enableScalaJsDefined.map(_.value).toString,
            "stdLibs" -> conversion.stdLibs.toString,
            "expandTypeMappings" -> conversion.expandTypeMappings.map(_.value).toString,
            "ignoredLibs" -> conversion.ignoredLibs.map(_.value).toString,
//            "ignoredModulePrefixes" -> conversion.ignoredModulePrefixes.toString,
            "versions" -> conversion.versions.toString,
            "organization" -> conversion.organization,
            "enableLongApplyMethod" -> conversion.enableLongApplyMethod.toString,
          ),
        )

        val compiler = Await.result(
          BloopCompiler(logger.filter(LogLevel.debug).void, conversion.versions, failureCacheFolderOpt = None),
          Duration.Inf,
        )

        val Pipeline: RecPhase[LibTsSource, PublishedSbtProject] =
          RecPhase[LibTsSource]
            .next(
              new Phase1ReadTypescript(
                calculateLibraryVersion = PackageJsonOnly,
                resolve                 = bootstrapped.libraryResolver,
                ignored                 = conversion.ignoredLibs,
                ignoredModulePrefixes   = conversion.ignoredModulePrefixes,
                pedantic                = false,
                parser                  = PersistingParser(parseCachePath, bootstrapped.inputFolders, logger.void),
                expandTypeMappings      = conversion.expandTypeMappings,
              ),
              "typescript",
            )
            .next(
              new Phase2ToScalaJs(
                pedantic             = false,
                scalaVersion         = conversion.versions.scala,
                enableScalaJsDefined = conversion.enableScalaJsDefined,
                outputPkg            = conversion.outputPackage,
                flavour              = conversion.flavourImpl,
              ),
              "scala.js",
            )
            .next(
              new PhaseFlavour(conversion.flavourImpl, maybePrivateWithin = conversion.privateWithin),
              conversion.flavourImpl.toString,
            )
            .next(
              new Phase3Compile(
                versions                   = conversion.versions,
                compiler                   = compiler,
                targetFolder               = c.paths.out,
                organization               = conversion.organization,
                publishLocalFolder         = constants.defaultLocalPublishFolder,
                metadataFetcher            = Npmjs.No,
                softWrites                 = true,
                flavour                    = conversion.flavourImpl,
                generateScalaJsBundlerFile = false,
                ensureSourceFilesWritten   = true,
              ),
              "build",
            )

        val results: Map[LibTsSource, PhaseRes[LibTsSource, PublishedSbtProject]] =
          sources
            .map(source => source -> PhaseRunner(Pipeline, (_: LibTsSource) => logger.void, NoListener)(source))
            .toMap

        val td = System.currentTimeMillis - t0
        logger.warn(td)

        val failures: Map[LibTsSource, Either[Throwable, String]] =
          results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

        if (failures.nonEmpty) {
          println(
            Color.Red(s"Failure: You might try --ignoredLibs ${failures.keys.map(_.libName.value).mkString(", ")}"),
          )

          failures.foreach {
            case (source, Left(value)) =>
              println(s"${source.libName.value}: (${source.path})")
              value.printStackTrace()
            case (source, Right(value)) =>
              println(s"${source.libName.value}: $value (${source.path})")
          }

          System.exit(1)
        } else {
          val allSuccesses: Map[LibTsSource, PublishedSbtProject] = {
            def go(source: LibTsSource, p: PublishedSbtProject): Map[LibTsSource, PublishedSbtProject] =
              Map(source -> p) ++ p.project.deps.flatMap { case (k, v) => go(k, v) }

            results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
          }

          val short: Seq[SbtProject] =
            results
              .collect { case (_, PhaseRes.Ok(res)) => res.project }
              .toSeq
              .filter(_.name != Name.std.unescaped)
              .sortBy(_.name)

          println()
          println(s"Successfully converted ${allSuccesses.keys.map(x => Color.Green(x.libName.value)).mkString(", ")}")
          println("To use in sbt: ")
          println(Color.DarkGray(s"""libraryDependencies ++= Seq(
               |  ${short.map(p => p.reference.asSbt).mkString("", ",\n  ", "")}
               |)""".stripMargin))

          System.exit(0)
        }

      case _ =>
        System.exit(1)
    }

}
