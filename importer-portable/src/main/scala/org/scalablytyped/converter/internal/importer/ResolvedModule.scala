package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.TsIdentModule

sealed trait ResolvedModule {
  def moduleName: TsIdentModule
}

object ResolvedModule {
  case class Local(inFile:    InFile, moduleName:      TsIdentModule) extends ResolvedModule
  case class NotLocal(source: LibTsSource, moduleName: TsIdentModule) extends ResolvedModule
}
