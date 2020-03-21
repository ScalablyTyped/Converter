package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

object EnabledTypeMappingExpansion {
  val DefaultSelection: Selection[TsIdentLibrary] =
    Selection.AllExcept("std", "prop-types", "react").map(TsIdentLibrary.apply)
}
