package typings.utilDynamodb

import org.scalablytyped.runtime.Instantiable1
import typings.utilDynamodb.utilDynamodbBooleans.`false`
import typings.utilDynamodb.utilDynamodbBooleans.`true`
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait `0` extends StObject {
    
    var convertTopLevelContainer: `false`
  }
  object `0` {
    
    inline def apply(): `0` = {
      val __obj = js.Dynamic.literal(convertTopLevelContainer = false)
      __obj.asInstanceOf[`0`]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: `0`] (val x: Self) extends AnyVal {
      
      inline def setConvertTopLevelContainer(value: `false`): Self = StObject.set(x, "convertTopLevelContainer", value.asInstanceOf[js.Any])
    }
  }
  
  trait ConvertTopLevelContainer extends StObject {
    
    var convertTopLevelContainer: `true`
  }
  object ConvertTopLevelContainer {
    
    inline def apply(): ConvertTopLevelContainer = {
      val __obj = js.Dynamic.literal(convertTopLevelContainer = true)
      __obj.asInstanceOf[ConvertTopLevelContainer]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ConvertTopLevelContainer] (val x: Self) extends AnyVal {
      
      inline def setConvertTopLevelContainer(value: `true`): Self = StObject.set(x, "convertTopLevelContainer", value.asInstanceOf[js.Any])
    }
  }
  
  trait ConvertTopLevelContainerBoolean extends StObject {
    
    var convertTopLevelContainer: Boolean
  }
  object ConvertTopLevelContainerBoolean {
    
    inline def apply(convertTopLevelContainer: Boolean): ConvertTopLevelContainerBoolean = {
      val __obj = js.Dynamic.literal(convertTopLevelContainer = convertTopLevelContainer.asInstanceOf[js.Any])
      __obj.asInstanceOf[ConvertTopLevelContainerBoolean]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ConvertTopLevelContainerBoolean] (val x: Self) extends AnyVal {
      
      inline def setConvertTopLevelContainer(value: Boolean): Self = StObject.set(x, "convertTopLevelContainer", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Instantiable
    extends StObject
       with Instantiable1[/* args (repeated) */ Any, Any]
}
