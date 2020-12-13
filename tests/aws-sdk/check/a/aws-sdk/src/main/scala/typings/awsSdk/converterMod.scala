package typings.awsSdk

import typings.awsSdk.dynamodbMod.AttributeValue
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object converterMod {
  
  @JSImport("aws-sdk/lib/dynamodb/converter", "Converter")
  @js.native
  class Converter () extends StObject
  /* static members */
  object Converter {
    
    @JSImport("aws-sdk/lib/dynamodb/converter", "Converter.input")
    @js.native
    def input(data: js.Any): AttributeValue = js.native
    @JSImport("aws-sdk/lib/dynamodb/converter", "Converter.input")
    @js.native
    def input(data: js.Any, options: ConverterOptions): AttributeValue = js.native
    
    type ConverterOptions = typings.awsSdk.documentClientMod.DocumentClient.ConverterOptions
  }
}
