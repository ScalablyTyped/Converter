package org.scalablytyped.converter.internal
package importer
package build

import java.time.ZonedDateTime

import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}
import org.scalablytyped.converter.internal.ts.TsIdent
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ContentForPublishTest extends AnyFunSuite with Matchers {

  val dummyPath = os.root / 'tmp
  val versions  = Versions(Versions.Scala213, Versions.ScalaJs1)
  val project = SbtProject(
    name = "sbtprojectname",
    reference = Dep
      .ScalaJs(
        org     = "sbtprojectorg",
        name    = "sbtprojectartifactid",
        version = "sbtprojectversion",
      )
      .concrete(versions),
  )(
    dummyPath,
    Map(
      Source.FromFolder(InFolder(dummyPath), TsIdent.dummyLibrary) -> PublishedSbtProject(
        SbtProject(
          name      = "depname",
          reference = Dep.ScalaJs(org = "deporg", name = "departifactid", version = "depversion").concrete(versions),
        )(dummyPath, Map(), None),
      )(null, null, None),
    ),
    None,
  )

  val publication  = ZonedDateTime.of(2020, 12, 31, 23, 59, 59, 0, constants.TimeZone)
  val externalDeps = Set[Dep](Dep.ScalaJs("externaldeporg", "externaldepartifact", "externaldepversion"))

  test("ivy") {
    val xml = ContentForPublish.ivy(versions, project, publication, externalDeps)
    xml.toString should be(
      """<ivy-module version="2.0" xmlns:e="http://ant.apache.org/ivy/extra">
      <info organisation="sbtprojectorg" module="sbtprojectartifactid_sjs1_2.13" revision="sbtprojectversion" status="release" publication="31122020115959">
        <description>
          sbtprojectname
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
        <artifact name="sbtprojectartifactid_sjs1_2.13" type="jar" ext="jar" conf="compile"/>
        <artifact name="sbtprojectartifactid_sjs1_2.13" type="pom" ext="pom" conf="pom"/>
        <artifact name="sbtprojectartifactid_sjs1_2.13" type="src" ext="jar" conf="compile" e:classifier="sources"/>
      </publications>
      <dependencies>
        <dependency org="org.scala-lang" name="scala-compiler" rev="2.13.5" conf="scala-tool-&gt;default,optional(default)"/>
        <dependency org="org.scala-lang" name="scala-library" rev="2.13.5" conf="scala-tool-&gt;default,optional(default);compile-&gt;default(compile)"/>
        <dependency org="org.scala-js" name="scalajs-compiler_2.13.5" rev="1.8.0" conf="plugin-&gt;default(compile)"/>
        <dependency org="org.scala-js" name="scalajs-library_2.13" rev="1.8.0" conf="compile-&gt;default(compile)"/>
        <dependency org="org.scala-js" name="scalajs-test-interface_2.13" rev="1.8.0" conf="test-&gt;default(compile)"/>
        <dependency org="com.olvind" name="scalablytyped-runtime_sjs1_2.13" rev="2.4.2" conf="compile-&gt;default(compile)"/>
        <dependency org="deporg" name="departifactid_sjs1_2.13" rev="depversion" conf="compile-&gt;default(compile)"/>
        <dependency org="externaldeporg" name="externaldepartifact_sjs1_2.13" rev="externaldepversion" conf="compile-&gt;default(compile)"/>
      </dependencies>
    </ivy-module>""",
    )
  }

  test("pom") {
    val xml = ContentForPublish.pom(versions, project, externalDeps)
    xml.toString should be(
      """<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
      <modelVersion>4.0.0</modelVersion>
      <groupId>sbtprojectorg</groupId>
      <artifactId>sbtprojectartifactid_sjs1_2.13</artifactId>
      <packaging>jar</packaging>
      <description>sbtprojectname</description>
      <version>sbtprojectversion</version>
      <name>sbtprojectname</name>
      <organization>
        <name>sbtprojectorg</name>
      </organization>
      <dependencies>
        <dependency>
      <groupId>org.scala-lang</groupId>
      <artifactId>scala-library</artifactId>
      <version>2.13.5</version>
    </dependency>
        <dependency>
      <groupId>org.scala-js</groupId>
      <artifactId>scalajs-library_2.13</artifactId>
      <version>1.8.0</version>
    </dependency>
        <dependency>
      <groupId>org.scala-js</groupId>
      <artifactId>scalajs-test-interface_2.13</artifactId>
      <version>1.8.0</version>
      <scope>test</scope>
    </dependency>
        <dependency>
      <groupId>com.olvind</groupId>
      <artifactId>scalablytyped-runtime_sjs1_2.13</artifactId>
      <version>2.4.2</version>
    </dependency>
        <dependency>
      <groupId>deporg</groupId>
      <artifactId>departifactid_sjs1_2.13</artifactId>
      <version>depversion</version>
    </dependency>
        <dependency>
      <groupId>externaldeporg</groupId>
      <artifactId>externaldepartifact_sjs1_2.13</artifactId>
      <version>externaldepversion</version>
    </dependency>
      </dependencies>
    </project>""",
    )
  }
}
