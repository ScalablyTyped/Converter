package typings.awsSdk

import org.scalablytyped.runtime.StringDictionary
import typings.awsSdk.documentClientMod.DocumentClient.DocumentClientOptions
import typings.awsSdk.dynamodbMod.ClientConfiguration
import typings.awsSdk.dynamodbMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object documentClientMod {
  
  @JSImport("aws-sdk/lib/dynamodb/document_client", "DocumentClient")
  @js.native
  /**
    * Creates a DynamoDB document client with a set of configuration options.
    */
  class DocumentClient () extends js.Object {
    def this(options: DocumentClientOptions with ClientConfiguration) = this()
  }
  object DocumentClient {
    
    @js.native
    trait ConverterOptions extends js.Object {
      
      /**
        * An optional flag indicating that the document client should cast
        * empty strings, buffers, and sets to NULL shapes
        */
      var convertEmptyValues: js.UndefOr[Boolean] = js.native
      
      /**
        * Whether to return numbers as a NumberValue object instead of
        * converting them to native JavaScript numbers. This allows for the
        * safe round-trip transport of numbers of arbitrary size.
        */
      var wrapNumbers: js.UndefOr[Boolean] = js.native
    }
    object ConverterOptions {
      
      @scala.inline
      def apply(): ConverterOptions = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[ConverterOptions]
      }
      
      @scala.inline
      implicit class ConverterOptionsOps[Self <: ConverterOptions] (val x: Self) extends AnyVal {
        
        @scala.inline
        def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
        
        @scala.inline
        def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
        
        @scala.inline
        def set(key: String, value: js.Any): Self = {
          x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
          x
        }
        
        @scala.inline
        def setConvertEmptyValues(value: Boolean): Self = this.set("convertEmptyValues", value.asInstanceOf[js.Any])
        
        @scala.inline
        def deleteConvertEmptyValues: Self = this.set("convertEmptyValues", js.undefined)
        
        @scala.inline
        def setWrapNumbers(value: Boolean): Self = this.set("wrapNumbers", value.asInstanceOf[js.Any])
        
        @scala.inline
        def deleteWrapNumbers: Self = this.set("wrapNumbers", js.undefined)
      }
    }
    
    @js.native
    trait DocumentClientOptions extends ConverterOptions {
      
      /**
        * An optional map of parameters to bind to every request sent by this service object.
        */
      var params: js.UndefOr[StringDictionary[js.Any]] = js.native
      
      /**
        * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
        */
      var service: js.UndefOr[^] = js.native
    }
    object DocumentClientOptions {
      
      @scala.inline
      def apply(): DocumentClientOptions = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[DocumentClientOptions]
      }
      
      @scala.inline
      implicit class DocumentClientOptionsOps[Self <: DocumentClientOptions] (val x: Self) extends AnyVal {
        
        @scala.inline
        def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
        
        @scala.inline
        def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
        
        @scala.inline
        def set(key: String, value: js.Any): Self = {
          x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
          x
        }
        
        @scala.inline
        def setParams(value: StringDictionary[js.Any]): Self = this.set("params", value.asInstanceOf[js.Any])
        
        @scala.inline
        def deleteParams: Self = this.set("params", js.undefined)
        
        @scala.inline
        def setService(value: ^): Self = this.set("service", value.asInstanceOf[js.Any])
        
        @scala.inline
        def deleteService: Self = this.set("service", js.undefined)
      }
    }
    
    trait _AttributeAction extends js.Object
    
    /* Rewritten from type alias, can be one of: 
      - typings.awsSdk.awsSdkStrings.ADD
      - typings.awsSdk.awsSdkStrings.PUT
      - typings.awsSdk.awsSdkStrings.DELETE
      - java.lang.String
    */
    type AttributeAction = _AttributeAction | String
  }
}
