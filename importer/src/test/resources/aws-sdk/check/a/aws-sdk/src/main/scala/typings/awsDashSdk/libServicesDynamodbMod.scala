package typings.awsDashSdk

import org.scalablytyped.runtime.Instantiable1
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.awsDashSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("aws-sdk/lib/services/dynamodb", Namespace)
@js.native
object libServicesDynamodbMod extends js.Object {
  @js.native
  class DynamoDBCustomizations () extends js.Object
  
  /* static members */
  @js.native
  object DynamoDBCustomizations extends js.Object {
    /**
      * The document client simplifies working with items in Amazon DynamoDB by abstracting away the notion of attribute values.
      * This abstraction annotates native JavaScript types supplied as input parameters, as well as converts annotated response data to native JavaScript types.
      */
    var DocumentClient: Instantiable1[
        js.UndefOr[/* options */ DocumentClientOptions with ClientConfiguration], 
        typings.awsDashSdk.libDynamodbDocumentUnderscoreClientMod.DocumentClient
      ] = js.native
  }
  
}

