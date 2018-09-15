package ScalablyTyped
package AwsDashSdkLib.AwsDashSdkLibDynamodbDocumentUnderscoreClientModule.DocumentClientNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ConverterOptions extends js.Object {
  /**
           * An optional flag indicating that the document client should cast
           * empty strings, buffers, and sets to NULL shapes
           */
  val convertEmptyValues: js.UndefOr[scala.Boolean] = js.undefined
  /**
           * Whether to return numbers as a NumberValue object instead of
           * converting them to native JavaScript numbers. This allows for the
           * safe round-trip transport of numbers of arbitrary size.
           */
  val wrapNumbers: js.UndefOr[scala.Boolean] = js.undefined
}

