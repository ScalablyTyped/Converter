package org.scalablytyped.converter.internal
package importer.build

import java.io._
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.jar.{JarEntry, JarOutputStream, Manifest}

import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}

import scala.collection.mutable
import scala.xml.Elem

object ContentForPublish {
  def apply(
      v:            Versions,
      paths:        CompilerPaths,
      p:            SbtProject,
      publication:  ZonedDateTime,
      externalDeps: Set[Dep],
  ): IvyLayout[os.RelPath, Array[Byte]] =
    IvyLayout(
      p          = p.reference,
      jarFile    = createJar(publication)(paths.classesDir),
      sourceFile = createJar(publication)(paths.sourcesDir),
      ivyFile    = fromXml(ivy(v, p, publication, externalDeps)),
      pomFile    = fromXml(pom(v, p, externalDeps)),
    )

  private def fromXml(xml: Elem): Array[Byte] = {
    val prelude: String = """<?xml version="1.0" encoding="UTF-8"?>"""
    (prelude + xml).getBytes(constants.Utf8)
  }

  private def createManifest(): Manifest = {
    val m = new java.util.jar.Manifest()
    m.getMainAttributes.put(java.util.jar.Attributes.Name.MANIFEST_VERSION, "1.0")
    m.getMainAttributes.putValue("Created-By", "ScalablyTypedConverter")
    m
  }

  // adapted from mill
  def createJar(publication: ZonedDateTime)(fromFolders: os.Path*): Array[Byte] = {
    val seen = mutable.Set[os.RelPath](os.RelPath("META-INF") / "MANIFEST.MF")
    val baos = new ByteArrayOutputStream(1024 * 1024)
    val jar  = new JarOutputStream(baos, createManifest())

    try {
      fromFolders.foreach { fromFolder =>
        os.walk(fromFolder).collect { case file if os.isFile(file) => file }.foreach { file =>
          val mapping = file.relativeTo(fromFolder)
          if (!seen(mapping)) {
            seen.add(mapping)
            val entry = new JarEntry(mapping.toString)
            entry.setTime(publication.toEpochSecond)
            jar.putNextEntry(entry)
            jar.write(os.read.bytes(file))
            jar.closeEntry()
          }
        }
      }
    } finally jar.close()

    baos.toByteArray
  }

  def ivy(v: Versions, p: SbtProject, publication: ZonedDateTime, externalDeps: Set[Dep]): Elem =
    <ivy-module version="2.0" xmlns:e="http://ant.apache.org/ivy/extra">
      <info organisation={p.reference.org}
            module={p.reference.mangledArtifact}
            revision={p.reference.version}
            status="release"
            publication={publication.format(DateTimeFormatter.ofPattern("ddMMyyyyhhmmss"))}>
        <description>
          {p.name}
        </description>
      </info>
      <configurations>
        <conf name="compile" visibility="public" description=""/>
        <conf name="runtime" visibility="public" description="" extends="compile"/>
        <conf name="test" visibility="public" description="" extends="runtime"/>
        <conf name="provided" visibility="public" description=""/>
        <conf name="optional" visibility="public" description=""/>
        <conf name="compile-internal" visibility="private" description="" extends="compile,optional,provided"/>
        <conf name="runtime-internal" visibility="private" description="" extends="runtime,optional"/>
        <conf name="test-internal" visibility="private" description="" extends="test,optional,provided"/>
        <conf name="plugin" visibility="private" description=""/>
        <conf name="pom" visibility="public" description=""/>
        <conf name="scala-tool" visibility="private" description=""/>
      </configurations>
      <publications>
        <artifact name={p.reference.mangledArtifact} type="jar" ext="jar" conf="compile"/>
        <artifact name={p.reference.mangledArtifact} type="pom" ext="pom" conf="pom"/>
        <artifact name={p.reference.mangledArtifact} type="src" ext="jar" conf="compile" e:classifier="sources"/>
      </publications>
      <dependencies>
        {v.scala.compiler.concrete(v).asIvy("scala-tool->default,optional(default)")}
        {v.scala.library.asIvy("scala-tool->default,optional(default);compile->default(compile)")}
        {v.scalaJsCompiler.toList.map(_.concrete(v).asIvy("plugin->default(compile)"))}
        {v.scalaJsLibrary.concrete(v).asIvy()}
        {v.scalaJsTestInterface.concrete(v).asIvy("test->default(compile)")}
        {v.runtime.concrete(v).asIvy()}
        {p.deps.map { case (_, d) => d.project.reference.asIvy() }}
        {externalDeps.map(d => d.concrete(v).asIvy())}
      </dependencies>
    </ivy-module>

  def pom(v: Versions, p: SbtProject, externalDeps: Set[Dep]): Elem =
    <project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0">
      <modelVersion>4.0.0</modelVersion>
      <groupId>{p.reference.org}</groupId>
      <artifactId>{p.reference.mangledArtifact}</artifactId>
      <packaging>jar</packaging>
      <description>{p.name}</description>
      <version>{p.reference.version}</version>
      <name>{p.name}</name>
      <organization>
        <name>{p.reference.org}</name>
      </organization>
      <dependencies>
        {v.scala.library.concrete(v).asMaven}
        {v.scalaJsLibrary.concrete(v).asMaven}
        {v.scalaJsTestInterface.concrete(v).asMavenTest}
        {v.runtime.concrete(v).asMaven}
        {p.deps.map { case (_, d) => d.project.reference.asMaven }}
        {externalDeps.map(d => d.concrete(v).asMaven)}
      </dependencies>
    </project>
}
