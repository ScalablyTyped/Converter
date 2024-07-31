package typings.awsSdk

import _root_.typings.awsSdk.clientsDynamodbMod.AttributeValue
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libDynamodbConverterMod {
  
  @JSImport("aws-sdk/lib/dynamodb/converter", "Converter")
  @js.native
  open class Converter () extends StObject
  /* static members */
  object Converter {
    
    @JSImport("aws-sdk/lib/dynamodb/converter", "Converter")
    @js.native
    val ^ : js.Any = js.native
    
    inline def input(data: Any): AttributeValue = ^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any]).asInstanceOf[AttributeValue]
    inline def input(data: Any, options: ConverterOptions): AttributeValue = (^.asInstanceOf[js.Dynamic].applyDynamic("input")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[AttributeValue]
    
    type ConverterOptions = _root_.typings.awsSdk.libDynamodbDocumentClientMod.DocumentClient.ConverterOptions
  }
}
