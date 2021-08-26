package org.scalablytyped.converter.internal

import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.stIncludeDev
import sbt.{Compile, Def, Test}
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

import scala.collection.immutable.SortedMap

object WantedLibs {
  lazy val setting: Def.Initialize[SortedMap[TsIdentLibrary, String]] =
    Def.setting {
      val b = SortedMap.newBuilder[TsIdentLibrary, String]

      def maybeAdd(values: Seq[(String, String)], include: Boolean): Unit =
        if (include) values.foreach { case (k, v) => b += ((TsIdentLibrary(k), v)) }

      maybeAdd((Compile / npmDependencies).value, include    = true)
      maybeAdd((Compile / npmDevDependencies).value, include = stIncludeDev.value)
      maybeAdd((Test / npmDependencies).value, include       = true)
      maybeAdd((Test / npmDevDependencies).value, include    = stIncludeDev.value)

      b.result()
    }
}
