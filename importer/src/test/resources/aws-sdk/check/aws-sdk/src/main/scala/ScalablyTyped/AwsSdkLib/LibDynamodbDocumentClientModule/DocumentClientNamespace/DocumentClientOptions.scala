package ScalablyTyped
package AwsSdkLib
package LibDynamodbDocumentClientModule
package DocumentClientNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait DocumentClientOptions extends AwsSdkLib.LibDynamodbDocumentClientModule.DocumentClientNamespace.ConverterOptions {
/**
         * An optional map of parameters to bind to every request sent by this service object.
         */
  val params: js.UndefOr[ScalablyTyped.runtime.StringDictionary[js.Any]] = js.undefined
/**
         * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
         */
  val service: js.UndefOr[AwsSdkLib.ClientsDynamodbModule.DynamoDB] = js.undefined
}

