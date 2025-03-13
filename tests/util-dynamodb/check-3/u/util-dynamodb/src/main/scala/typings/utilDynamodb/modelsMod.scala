package typings.utilDynamodb

import org.scalablytyped.runtime.StringDictionary
import typings.std.Blob
import typings.std.Buffer
import typings.std.InstanceType
import typings.std.Set
import typings.utilDynamodb.anon.Instantiable
import typings.utilDynamodb.modelsMod.global.File
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object modelsMod {
  
  /** NOTE: Conditional type definitions are impossible to translate to Scala.
    * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
    * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
    * TS definition: {{{
    {} extends T ? never : T
    }}}
    */
  type IfDefined[T] = T
  
  type NativeAttributeBinary = js.typedarray.ArrayBuffer | (IfDefined[Blob | Buffer | File]) | js.typedarray.DataView | js.typedarray.Int8Array
  
  /** 
  NOTE: Rewritten from type alias:
  {{{
  type NativeAttributeValue = util-dynamodb.util-dynamodb/models.NativeScalarAttributeValue | {[key: string] : util-dynamodb.util-dynamodb/models.NativeAttributeValue} | std.Array<util-dynamodb.util-dynamodb/models.NativeAttributeValue> | std.Set<number | bigint | util-dynamodb.util-dynamodb/models.NumberValue | string | util-dynamodb.util-dynamodb/models.NativeAttributeBinary | undefined> | std.InstanceType<{new (args : ...any): any}>
  }}}
  to avoid circular code involving: 
  - util-dynamodb.util-dynamodb/models.NativeAttributeValue
  */
  type NativeAttributeValue = NativeScalarAttributeValue | StringDictionary[Any] | js.Array[Any] | (Set[js.UndefOr[Double | js.BigInt | NumberValue | String | NativeAttributeBinary]]) | InstanceType[Instantiable]
  
  type NativeScalarAttributeValue = js.UndefOr[
    Null | Boolean | Double | NumberValue | js.BigInt | NativeAttributeBinary | String
  ]
  
  trait NumberValue extends StObject {
    
    val value: String
  }
  object NumberValue {
    
    inline def apply(value: String): NumberValue = {
      val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[NumberValue]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: NumberValue] (val x: Self) extends AnyVal {
      
      inline def setValue(value: String): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  /**
    * Declare File in case DOM is not added to the tsconfig lib causing
    * File interface is not defined. For developers with DOM lib added,
    * the File interface will be merged correctly.
    */
  object global {
    
    trait File extends StObject
  }
}
