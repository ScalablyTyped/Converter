package typingsJapgolly.reactSelect

import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.Props
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-select", JSImport.Default)
  @js.native
  open class default[TValue] () extends ReactSelectClass[TValue]
  
  trait Option[TValue]
    extends StObject
       with /**
    * In the event that a custom menuRenderer is provided, Option should be able
    * to accept arbitrary key-value pairs. See react-virtualized-select.
    */
  /* property */ StringDictionary[Any] {
    
    /** Value for searching */
    var value: js.UndefOr[TValue] = js.undefined
  }
  object Option {
    
    inline def apply[TValue](): Option[TValue] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Option[TValue]]
    }
    
    extension [Self <: Option[?], TValue](x: Self & Option[TValue]) {
      
      inline def setValue(value: TValue): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
      
      inline def setValueUndefined: Self = StObject.set(x, "value", js.undefined)
    }
  }
  
  type OptionValues = String | Double | Boolean
  
  @js.native
  trait ReactSelectClass[TValue]
    extends Component[ReactSelectProps[TValue], js.Object, Any] {
    
    def focus(): Unit = js.native
    
    def setValue(value: Option[TValue]): Unit = js.native
  }
  
  trait ReactSelectProps[TValue]
    extends StObject
       with Props[ReactSelectClass[TValue]] {
    
    /**
      * text to display when `allowCreate` is true.
      * @default 'Add "{label}"?'
      */
    var addLabelText: js.UndefOr[String] = js.undefined
  }
  object ReactSelectProps {
    
    inline def apply[TValue](): ReactSelectProps[TValue] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ReactSelectProps[TValue]]
    }
    
    extension [Self <: ReactSelectProps[?], TValue](x: Self & ReactSelectProps[TValue]) {
      
      inline def setAddLabelText(value: String): Self = StObject.set(x, "addLabelText", value.asInstanceOf[js.Any])
      
      inline def setAddLabelTextUndefined: Self = StObject.set(x, "addLabelText", js.undefined)
    }
  }
}
