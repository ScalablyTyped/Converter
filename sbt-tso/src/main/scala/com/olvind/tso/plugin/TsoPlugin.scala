package com.olvind.tso
package plugin

import com.olvind.logging.LogLevel
import com.olvind.tso.importer.Source.StdLibSource
import com.olvind.tso.importer._
import com.olvind.tso.maps._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs._
import com.olvind.tso.seqs._
import com.olvind.tso.ts._
import os.Path
import sbt.Keys._
import sbt._
import sbt.internal.util.ManagedLogger
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.collection.immutable.SortedMap
import scala.collection.mutable

sealed trait ReactBinding

object ReactBindingNative extends ReactBinding

object ReactBindingSlinky extends ReactBinding

object ReactBindingJagpolly extends ReactBinding

object TsoPlugin extends AutoPlugin {
  object autoImport {
    val tsoImport            = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val tsoReactBinding      = settingKey[ReactBinding]("The type of react binding to use")
    val tsoPedantic          = settingKey[Boolean]("How harsh to be")
    val tsoTypescriptVersion = settingKey[String]("The version of the typescript library that it should use")

    import ScalaJSBundlerPlugin.autoImport._

    lazy val baseTSOImportSettings: Seq[Def.Setting[_]] = Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (tsoTypescriptVersion).value))(_ => Seq.empty)
      },
      tsoReactBinding := ReactBindingNative,
      tsoTypescriptVersion := "3.6.3",
      tsoImport := {
        println(s">>>>>>>>>>>>>>>>>>>>>>>>> Using ${(tsoReactBinding).value} value")

        //TODO check to see if nothing has changed, if nothing has changed, then do nothing.
        ImportTypings(
          npmDependencies = (npmDependencies in Compile).value.to[Seq],
          npmDirectory    = (npmInstallDependencies in Compile).value,
          target          = (sourceManaged in Compile).value / "tso",
          reactBinding    = (tsoReactBinding).value,
          sbtLogger       = streams.value.log,
        )
      },
      sourceGenerators in Compile += tsoImport.taskValue,
    )
  }

  import autoImport._
  override def requires = JvmPlugin && ScalaJSBundlerPlugin

  override def trigger = allRequirements

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = inConfig(Compile)(baseTSOImportSettings)

  override lazy val buildSettings: Seq[Nothing] = Seq()

  override lazy val globalSettings: Seq[Nothing] = Seq()

}

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  def main(args: Array[String]): Unit = {
    val tsoCache = os.home / "tmp" / "tso-cache"
    println(
      runImport(
        List(("semantic-ui-react" -> "1")),
        InFolder(tsoCache / "npm" / "node_modules"),
        Main.existing(tsoCache / 'work),
        _ => com.olvind.logging.stdout.filter(LogLevel.warn),
        ReactBindingSlinky,
      ).map(_.size),
    )
  }

  private def runImport(
      npmDependencies: Seq[(String, String)],
      source:          InFolder,
      targetFolder:    os.Path,
      loggerFor:       Source => com.olvind.logging.Logger[Unit],
      reactBinding:    ReactBinding,
  ): Either[Map[Source, List[Either[Throwable, String]]], Seq[File]] = {

    val stdLibSource: Source =
      StdLibSource(
        InFile(source.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdent.std,
      )

    val binding = reactBinding match {
      case ReactBindingNative   => None
      case ReactBindingSlinky   => Option(com.olvind.tso.importer.ReactBinding.slinky)
      case ReactBindingJagpolly => Option(com.olvind.tso.importer.ReactBinding.scalajsReact)
    }

    val InitialPhase: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, Seq(InFolder(source.path / "@types"), source), None),
          None,
          Set.empty,
          stdLibSource,
          pedantic = false,
          parser.parseFile,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false, binding), "scala.js")

    def Pipeline(keep: Set[QualifiedName]): RecPhase[Source, Map[Source, Seq[os.Path]]] =
      InitialPhase
        .next[Phase2Res](
          (_, lib, _, _, _) => {
            val updated = lib match {
              case Phase2Res.Facade => Phase2Res.Facade
              case lib: Phase2Res.LibScalaJs =>
                object Foo extends scalajs.TreeTransformation {
                  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
                    if (s.comments has Markers.VIP) s
                    else
                      s.copy(
                        parents = s.parents.filter(tr => keep(tr.typeName)),
                        members = s.members.filter {
                          case x: MemberTree if x.name === Name.APPLY => true
                          case x: scalajs.HasCodePath                 => keep(x.codePath)
                          case _ => true
                        },
                      )
                  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
                    s.copy(members = s.members.filter {
                      case x: scalajs.HasCodePath => keep(x.codePath)
                      case _ => true
                    })
                }
                val scope   = new scalajs.TreeScope.Root(Name.dummy, Map.empty, com.olvind.logging.stdout, false)
                val newTree = Foo.visitPackageTree(scope)(lib.packageTree)

                lib.copy()(
                  libName      = lib.libName,
                  scalaName    = lib.scalaName,
                  libVersion   = lib.libVersion,
                  packageTree  = newTree,
                  dependencies = lib.dependencies,
                  isStdLib     = lib.isStdLib,
                  facades      = lib.facades,
                )
            }
            PhaseRes.Ok(updated)
          },
          "keepReferenced",
        )
        .next(new Phase3WriteFiles(targetFolder = targetFolder, softWrites = false), "build")

    val sources: Set[Source] =
      npmDependencies
        .map {
          case (name, _) =>
            val libName = TsIdentLibrary(name) match {
              case TsIdentLibraryScoped("types", Some(value)) => TsIdentLibrarySimple(value)
              case other                                      => other
            }

            Source.FromFolder(InFolder(source.path / os.RelPath(name)), libName): Source
        }
        .groupBy(_.libName)
        .flatMap {
          case (TsIdentLibrarySimple("typescript"), _) => None
          case (_, sameName)                           => sameName.find(s => os.walk.stream(s.folder.path).exists(_.last.endsWith(".d.ts")))
        }
        .to[Set] + stdLibSource

    sources.foreach(src => println(s">>>>>>>>>>>>>>>>>>>>>>>>> ${src}"))

    val afterPhase1 = sources
      .map(s => s -> PhaseRunner(InitialPhase, loggerFor, NoListener)(s))
      .toMap
      .toSorted

    val used: Set[QualifiedName] = PhaseRes.sequenceMap(afterPhase1) match {
      case PhaseRes.Ok(Phase2Res.Unpack(libs: SortedMap[Source.TsLibSource, Phase2Res.LibScalaJs], _)) =>
        val vipsTrees: Seq[QualifiedName] =
          libs.values.to[Seq].flatMap { lib =>
            TreeTraverse.collect(lib.packageTree) {
              case x: Tree with scalajs.HasCodePath if x.comments has Markers.VIP => x.codePath
            }
          }

        val scope = new scalajs.TreeScope.Root(
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          com.olvind.logging.stdout,
          false,
        )
        val cache = mutable.Map.empty[QualifiedName, Seq[QualifiedName]]
        var toCheck: List[QualifiedName] = vipsTrees.toList
        val keep = mutable.ArrayBuffer[QualifiedName](vipsTrees: _*)

        while (toCheck.nonEmpty) {
          val currentCp = toCheck.head
          val newToCheck: Seq[QualifiedName] =
            if (cache.contains(currentCp)) Nil
            else {
              val currents = scope.lookup(currentCp)
              val referenced = TreeTraverse.collectSeq(currents.map(_._1)) {
                case TypeRef(typeName, _, _) if !cache.contains(typeName) && typeName =/= currentCp => typeName
              }
              cache.put(currentCp, referenced)

              if (referenced.nonEmpty)
                println(currentCp + " ==> " + referenced.size ++ s" (first ten: ${referenced.take(10)})")

              keep ++= referenced
              referenced
            }
          toCheck = newToCheck.toList ++ toCheck.tail
        }
        keep.flatMap(qname => qname.parts.indices.map(n => QualifiedName(qname.parts.take(n + 1))))(collection.breakOut)
      case _ => Set.empty
    }

    sources
      .map(PhaseRunner(Pipeline(used), loggerFor, NoListener))
      .to[Seq]
      .partitionCollect2({ case PhaseRes.Failure(x) => x }, { case PhaseRes.Ok(x) => x }) match {
      case (Nil, filesBySource: Seq[Map[Source, Seq[Path]]], _) =>
        Right(maps.smash(filesBySource).foldLeft(Seq.empty[File]) { _ ++ _._2.map(_.toIO) })
      case (errors, _, _) => Left(maps.sum(errors))
    }
  }

  def apply(
      npmDependencies: Seq[(String, String)],
      npmDirectory:    File,
      target:          File,
      reactBinding:    ReactBinding,
      sbtLogger:       ManagedLogger,
  ): Seq[File] =
    runImport(
      npmDependencies,
      InFolder(os.Path(npmDirectory / "node_modules")),
      os.Path(target),
      (s: Source) => WrapSbtLogger(sbtLogger)(s).filter(LogLevel.warn).void,
      reactBinding,
    ) match {
      case Right(files) => files
      case Left(errors) =>
        errors foreach System.err.println
        Nil
    }
}
