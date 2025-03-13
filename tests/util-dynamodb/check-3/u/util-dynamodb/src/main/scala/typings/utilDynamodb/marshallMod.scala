package typings.utilDynamodb

import typings.awsSdkClientDynamodb.mod.AttributeValue
import typings.awsSdkClientDynamodb.mod.AttributeValue.BMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.BOOLMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.BSMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.LMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.MMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.NMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.NSMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.NULLMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.SMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.SSMember
import typings.awsSdkClientDynamodb.mod.AttributeValue.UnknownMember
import typings.std.Map
import typings.std.Record
import typings.std.Set
import typings.utilDynamodb.anon.ConvertTopLevelContainer
import typings.utilDynamodb.anon.ConvertTopLevelContainerBoolean
import typings.utilDynamodb.anon.`0`
import typings.utilDynamodb.modelsMod.NativeAttributeBinary
import typings.utilDynamodb.modelsMod.NativeAttributeValue
import typings.utilDynamodb.numberValueMod.NumberValue
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object marshallMod {
  
  @JSImport("util-dynamodb/marshall", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def marshall(): NULLMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")().asInstanceOf[NULLMember]
  inline def marshall(data: String): SMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[SMember]
  inline def marshall(data: String, options: marshallOptions): SMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[SMember]
  inline def marshall(data: js.Array[NativeAttributeValue]): js.Array[AttributeValue] = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[js.Array[AttributeValue]]
  inline def marshall(data: js.Array[NativeAttributeValue], options: marshallOptions): js.Array[AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[js.Array[AttributeValue]]
  inline def marshall(data: js.BigInt): NMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[NMember]
  inline def marshall(data: js.BigInt, options: marshallOptions): NMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[NMember]
  inline def marshall(data: Any): UnknownMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[UnknownMember]
  inline def marshall(data: Any, options: marshallOptions): UnknownMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[UnknownMember]
  inline def marshall(data: Boolean): BOOLMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[BOOLMember]
  inline def marshall(data: Boolean, options: marshallOptions): BOOLMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[BOOLMember]
  inline def marshall(data: Double): NMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[NMember]
  inline def marshall(data: Double, options: marshallOptions): NMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[NMember]
  inline def marshall(data: Null, options: marshallOptions): NULLMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[NULLMember]
  inline def marshall(data: Map[String, NativeAttributeValue]): Record[String, AttributeValue] = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[Record[String, AttributeValue]]
  inline def marshall(data: Map[String, NativeAttributeValue], options: marshallOptions): Record[String, AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Record[String, AttributeValue]]
  inline def marshall(data: Record[String, NativeAttributeValue]): Record[String, AttributeValue] = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[Record[String, AttributeValue]]
  inline def marshall(data: Record[String, NativeAttributeValue], options: marshallOptions): Record[String, AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Record[String, AttributeValue]]
  inline def marshall(data: Set[String]): SSMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[SSMember]
  inline def marshall(data: Set[String], options: marshallOptions): SSMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[SSMember]
  inline def marshall(data: NativeAttributeBinary): BMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[BMember]
  inline def marshall(data: NativeAttributeBinary, options: marshallOptions): BMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[BMember]
  inline def marshall(data: NumberValue): NMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[NMember]
  inline def marshall(data: NumberValue, options: marshallOptions): NMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[NMember]
  inline def marshall[O /* <: ConvertTopLevelContainerBoolean */](data: js.Array[NativeAttributeValue], options: marshallOptions & O): js.Array[AttributeValue] | LMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[js.Array[AttributeValue] | LMember]
  inline def marshall[O /* <: `0` */](data: Map[String, NativeAttributeValue], options: marshallOptions & O): Record[String, AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Record[String, AttributeValue]]
  inline def marshall[O /* <: `0` */](data: Record[String, NativeAttributeValue], options: marshallOptions & O): Record[String, AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Record[String, AttributeValue]]
  
  inline def marshall_Any(data: Any): Any = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[Any]
  inline def marshall_Any(data: Any, options: marshallOptions): Any = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[Any]
  
  inline def marshall_BSMember(data: Set[NativeAttributeBinary]): BSMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[BSMember]
  inline def marshall_BSMember(data: Set[NativeAttributeBinary], options: marshallOptions): BSMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[BSMember]
  
  inline def marshall_NSMember(data: Set[js.BigInt | Double | NumberValue]): NSMember = ^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any]).asInstanceOf[NSMember]
  inline def marshall_NSMember(data: Set[js.BigInt | Double | NumberValue], options: marshallOptions): NSMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[NSMember]
  
  inline def marshall_O_Array[O /* <: `0` */](data: js.Array[NativeAttributeValue], options: marshallOptions & O): js.Array[AttributeValue] = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[js.Array[AttributeValue]]
  
  inline def marshall_O_LMember[O /* <: ConvertTopLevelContainer */](data: js.Array[NativeAttributeValue], options: marshallOptions & O): LMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[LMember]
  
  inline def marshall_O_MMember[O /* <: ConvertTopLevelContainer */](data: Map[String, NativeAttributeValue], options: marshallOptions & O): MMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[MMember]
  inline def marshall_O_MMember[O /* <: ConvertTopLevelContainer */](data: Record[String, NativeAttributeValue], options: marshallOptions & O): MMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[MMember]
  
  inline def marshall_O_Union[O /* <: ConvertTopLevelContainerBoolean */](data: Map[String, NativeAttributeValue], options: marshallOptions & O): (Record[String, AttributeValue]) | MMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[(Record[String, AttributeValue]) | MMember]
  inline def marshall_O_Union[O /* <: ConvertTopLevelContainerBoolean */](data: Record[String, NativeAttributeValue], options: marshallOptions & O): (Record[String, AttributeValue]) | MMember = (^.asInstanceOf[js.Dynamic].applyDynamic("marshall")(data.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[(Record[String, AttributeValue]) | MMember]
  
  trait marshallOptions extends StObject {
    
    /**
      * Whether to allow numbers beyond Number.MAX_SAFE_INTEGER during marshalling.
      * When set to true, allows numbers that may lose precision when converted to JavaScript numbers.
      * When false (default), throws an error if a number exceeds Number.MAX_SAFE_INTEGER to prevent
      * unintended loss of precision. Consider using the NumberValue type from @aws-sdk/lib-dynamodb
      * for precise handling of large numbers.
      */
    var allowImpreciseNumbers: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Whether to convert typeof object to map attribute.
      */
    var convertClassInstanceToMap: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Whether to automatically convert empty strings, blobs, and sets to `null`
      */
    var convertEmptyValues: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Whether to convert the top level container
      * if it is a map or list.
      *
      * Default is true when using the DynamoDBDocumentClient,
      * but false if directly using the marshall function (backwards compatibility).
      */
    var convertTopLevelContainer: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Whether to remove undefined values from JS arrays/Sets/objects
      * when marshalling to DynamoDB lists/sets/maps respectively.
      *
      * A DynamoDB item is not itself considered a map. Only
      * attributes of an item are examined.
      */
    var removeUndefinedValues: js.UndefOr[Boolean] = js.undefined
  }
  object marshallOptions {
    
    inline def apply(): marshallOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[marshallOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: marshallOptions] (val x: Self) extends AnyVal {
      
      inline def setAllowImpreciseNumbers(value: Boolean): Self = StObject.set(x, "allowImpreciseNumbers", value.asInstanceOf[js.Any])
      
      inline def setAllowImpreciseNumbersUndefined: Self = StObject.set(x, "allowImpreciseNumbers", js.undefined)
      
      inline def setConvertClassInstanceToMap(value: Boolean): Self = StObject.set(x, "convertClassInstanceToMap", value.asInstanceOf[js.Any])
      
      inline def setConvertClassInstanceToMapUndefined: Self = StObject.set(x, "convertClassInstanceToMap", js.undefined)
      
      inline def setConvertEmptyValues(value: Boolean): Self = StObject.set(x, "convertEmptyValues", value.asInstanceOf[js.Any])
      
      inline def setConvertEmptyValuesUndefined: Self = StObject.set(x, "convertEmptyValues", js.undefined)
      
      inline def setConvertTopLevelContainer(value: Boolean): Self = StObject.set(x, "convertTopLevelContainer", value.asInstanceOf[js.Any])
      
      inline def setConvertTopLevelContainerUndefined: Self = StObject.set(x, "convertTopLevelContainer", js.undefined)
      
      inline def setRemoveUndefinedValues(value: Boolean): Self = StObject.set(x, "removeUndefinedValues", value.asInstanceOf[js.Any])
      
      inline def setRemoveUndefinedValuesUndefined: Self = StObject.set(x, "removeUndefinedValues", js.undefined)
    }
  }
}
