package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.CastConversion.TParam

class ScalaJsLibNames(stdNames: QualifiedName.StdNames) {
  // format: off
  val All = IArray(
    CastConversion(stdNames.lib + Name("ArrayBuffer"), QualifiedName("scala.scalajs.js.typedarray.ArrayBuffer")),
    CastConversion(stdNames.lib + Name("ArrayBufferView"), QualifiedName("scala.scalajs.js.typedarray.ArrayBufferView")),
    CastConversion(stdNames.lib + Name("DataView"), QualifiedName("scala.scalajs.js.typedarray.DataView")),
    CastConversion(stdNames.lib + Name("Date"), QualifiedName("scala.scalajs.js.Date")),
    CastConversion(stdNames.lib + Name("Error"), QualifiedName("scala.scalajs.js.Error")),
    CastConversion(stdNames.lib + Name("EvalError"), QualifiedName("scala.scalajs.js.EvalError")),
    CastConversion(stdNames.lib + Name("Float32Array"), QualifiedName("scala.scalajs.js.typedarray.Float32Array")),
    CastConversion(stdNames.lib + Name("Float64Array"), QualifiedName("scala.scalajs.js.typedarray.Float64Array")),
    CastConversion(stdNames.lib + Name("Function"), QualifiedName("scala.scalajs.js.Function")),
    CastConversion(stdNames.lib + Name("Int16Array"), QualifiedName("scala.scalajs.js.typedarray.Int16Array")),
    CastConversion(stdNames.lib + Name("Int32Array"), QualifiedName("scala.scalajs.js.typedarray.Int32Array")),
    CastConversion(stdNames.lib + Name("Int8Array"), QualifiedName("scala.scalajs.js.typedarray.Int8Array")),
    CastConversion(stdNames.lib + Name("Iterable"), QualifiedName("scala.scalajs.js.Iterable"), TParam._1),
    CastConversion(stdNames.lib + Name("Iterator"), QualifiedName("scala.scalajs.js.Iterator"), TParam._1),
    CastConversion(stdNames.lib + Name("Object"), QualifiedName("scala.scalajs.js.Object")),
    CastConversion(stdNames.lib + Name("Promise"), QualifiedName("scala.scalajs.js.Promise"), TParam._1),
    CastConversion(stdNames.lib + Name("PropertyDescriptor"), QualifiedName("scala.scalajs.js.PropertyDescriptor")),
    CastConversion(stdNames.lib + Name("RangeError"), QualifiedName("scala.scalajs.js.RangeError")),
    CastConversion(stdNames.lib + Name("ReferenceError"), QualifiedName("scala.scalajs.js.ReferenceError")),
    CastConversion(stdNames.lib + Name("RegExp"), QualifiedName("scala.scalajs.js.RegExp")),
    CastConversion(stdNames.lib + Name("Symbol"), QualifiedName("scala.scalajs.js.Symbol")),
    CastConversion(stdNames.lib + Name("SyntaxError"), QualifiedName("scala.scalajs.js.SyntaxError")),
    CastConversion(stdNames.lib + Name("TypeError"), QualifiedName("scala.scalajs.js.TypeError")),
    CastConversion(stdNames.lib + Name("Uint16Array"), QualifiedName("scala.scalajs.js.typedarray.Uint16Array")),
    CastConversion(stdNames.lib + Name("Uint32Array"), QualifiedName("scala.scalajs.js.typedarray.Uint32Array")),
    CastConversion(stdNames.lib + Name("Uint8Array"), QualifiedName("scala.scalajs.js.typedarray.Uint8Array")),
    CastConversion(stdNames.lib + Name("Uint8ClampedArray"), QualifiedName("scala.scalajs.js.typedarray.Uint8ClampedArray")),
    CastConversion(stdNames.lib + Name("URIError"), QualifiedName("scala.scalajs.js.URIError")),

  )
  // format: on
}
