package typings.awsSdk

import org.scalablytyped.runtime.Instantiable1
import typings.awsSdk.clientsDynamodbMod.ClientConfiguration
import typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/lib/services/dynamodb", JSImport.Namespace)
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
        typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient
      ] = js.native
  }
  
}

