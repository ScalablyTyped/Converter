package com.olvind.tso
package importer.build

import java.io._
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.jar.{JarEntry, JarOutputStream, Manifest}

import com.olvind.tso.scalajs.Dep

import scala.collection.mutable
import scala.xml.Elem

object ContentForPublish {
  def apply(
      v:            Versions,
      paths:        CompilerPaths,
      p:            SbtProject,
      publication:  ZonedDateTime,
      sourceFiles:  Layout[os.RelPath, Array[Byte]],
      externalDeps: Set[Dep],
  ): IvyLayout[os.RelPath, Array[Byte]] =
    IvyLayout(
      p          = p,
      jarFile    = createJar(paths.classesDir, publication),
      sourceFile = createJar(sourceFiles, publication),
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
    m.getMainAttributes.putValue("Created-By", "Tso")
    m
  }

  // adapted from mill
  private def createJar(fromFolder: os.Path, publication: ZonedDateTime): Array[Byte] = {
    val seen = mutable.Set[os.RelPath](os.RelPath("META-INF") / "MANIFEST.MF")
    val baos = new ByteArrayOutputStream(1024 * 1024)
    val jar  = new JarOutputStream(baos, createManifest())

    try {
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
    } finally jar.close()

    baos.toByteArray
  }

  private def createJar(sourceFiles: Layout[os.RelPath, Array[Byte]], publication: ZonedDateTime): Array[Byte] = {
    val baos = new ByteArrayOutputStream(1024 * 1024)
    val jar  = new JarOutputStream(baos, createManifest())

    try {
      sourceFiles.all.foreach {
        case (relFile, contents) =>
          val entry = new JarEntry(relFile.toString)
          entry.setTime(publication.toEpochSecond)
          jar.putNextEntry(entry)
          jar.write(contents)
          jar.closeEntry()
      }
    } finally jar.close()

    baos.toByteArray
  }

  def ivy(v: Versions, p: SbtProject, publication: ZonedDateTime, externalDeps: Set[Dep]): Elem =
    <ivy-module version="2.0" xmlns:e="http://ant.apache.org/ivy/extra">
      <info organisation={p.organization}
            module={p.artifactId}
            revision={p.version}
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
        <artifact name={p.artifactId} type="jar" ext="jar" conf="compile"/>
        <artifact name={p.artifactId} type="pom" ext="pom" conf="pom"/>
        <artifact name={p.artifactId} type="src" ext="jar" conf="compile" e:classifier="sources"/>
      </publications>
      <dependencies>
        <dependency org={v.scalaOrganization} name="scala-compiler" rev={v.scalaVersion} conf="scala-tool->default,optional(default)"/>
        <dependency org={v.scalaOrganization} name="scala-library" rev={v.scalaVersion} conf="scala-tool->default,optional(default);compile->default(compile)"/>
        <dependency org={v.scalaJsOrganization} name={s"scalajs-compiler_${v.scalaVersion}"} rev={v.scalaJsVersion} conf="plugin->default(compile)"/>
        <dependency org={v.scalaJsOrganization} name={v.s("scalajs-library")} rev={v.scalaJsVersion} conf="compile->default(compile)"/>
        <dependency org={v.scalaJsOrganization} name={v.s("scalajs-test-interface")} rev={v.scalaJsVersion} conf="test->default(compile)"/>
        <dependency org={v.RuntimeOrganization} name={v.sjs(v.RuntimeName)} rev={v.RuntimeVersion} conf="compile->default(compile)"/>
        {
      p.deps.map {
        case (_, d) =>
          <dependency org={d.project.organization} name={d.project.artifactId} rev={d.project.version} conf="compile->default(compile)"/>
      }
    }{
      externalDeps.map { d =>
        <dependency org={d.org} name={v.sjs(d.artifact)} rev={d.version} conf="compile->default(compile)"/>
      }
    }
      </dependencies>
    </ivy-module>

  def pom(v: Versions, p: SbtProject, externalDeps: Set[Dep]): Elem =
    <project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0">
      <modelVersion>4.0.0</modelVersion>
      <groupId>{p.organization}</groupId>
      <artifactId>{p.artifactId}</artifactId>
      <packaging>jar</packaging>
      <description>{p.name}</description>
      <version>{p.version}</version>
      <name>{p.name}</name>
      <organization>
        <name>{p.organization}</name>
      </organization>
      <dependencies>
        <dependency>
          <groupId>{v.scalaOrganization}</groupId>
          <artifactId>scala-library</artifactId>
          <version>{v.scalaVersion}</version>
        </dependency>
        <dependency>
          <groupId>{v.scalaJsOrganization}</groupId>
          <artifactId>{v.s("scalajs-library")}</artifactId>
          <version>{v.scalaJsVersion}</version>
        </dependency>
        <dependency>
          <groupId>{v.scalaJsOrganization}</groupId>
          <artifactId>{v.s("scalajs-test-interface")}</artifactId>
          <version>{v.scalaJsVersion}</version>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>{v.RuntimeOrganization}</groupId>
          <artifactId>{v.sjs(v.RuntimeName)}</artifactId>
          <version>{v.RuntimeVersion}</version>
        </dependency>
        {
      p.deps.map {
        case (_, d) =>
          <dependency>
          <groupId>{d.project.organization}</groupId>
          <artifactId>{d.project.artifactId}</artifactId>
          <version>{d.project.version}</version>
        </dependency>
      }
    }
        {
      externalDeps.map(
        d =>
          <dependency><groupId>{d.org}</groupId><artifactId>{v.sjs(d.artifact)}</artifactId><version>{d.version}</version></dependency>,
      )
    }
      </dependencies>
    </project>
}
