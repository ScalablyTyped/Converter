package org.scalablytyped.converter.internal

import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._
import sbt.{Compile, Def, Test}

import scala.collection.immutable.SortedMap

object WantedLibs {
  lazy val setting: Def.Initialize[SortedMap[TsIdentLibrary, String]] =
    Def.setting {
      val b = SortedMap.newBuilder[TsIdentLibrary, String]

      def maybeAdd(values: Seq[(String, String)], include: Boolean): Unit =
        if (include) values.foreach { case (k, v) => b += ((TsIdentLibrary(k), v)) }

      maybeAdd((Compile / stNpmDependencies).value, include    = true)
      maybeAdd((Compile / stNpmDevDependencies).value, include = stIncludeDev.value)
      maybeAdd((Test / stNpmDependencies).value, include       = true)
      maybeAdd((Test / stNpmDevDependencies).value, include    = stIncludeDev.value)

      b.result()
    }
}
