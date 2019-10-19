package typings.awsSdk.mod.lib.services

import org.scalablytyped.runtime.Instantiable1
import typings.awsSdk.mod.clients.dynamodb.ClientConfiguration
import typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient.DocumentClientOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("aws-sdk/lib/services/dynamodb", JSImport.Namespace)
@js.native
object dynamodb extends js.Object {
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
        typings.awsSdk.mod.lib.dynamodb.documentClient.DocumentClient
      ] = js.native
  }
  
}

