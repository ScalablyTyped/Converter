package typingsSlinky.reactSelect

import org.scalablytyped.runtime.StringDictionary
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.Props
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-select", JSImport.Default)
  @js.native
  class default[TValue] () extends ReactSelectClass[TValue]
  
  @js.native
  trait Option[TValue]
    extends StObject
       with /**
    * In the event that a custom menuRenderer is provided, Option should be able
    * to accept arbitrary key-value pairs. See react-virtualized-select.
    */
  /* property */ StringDictionary[js.Any] {
    
    /** Value for searching */
    var value: js.UndefOr[TValue] = js.native
  }
  object Option {
    
    @scala.inline
    def apply[TValue](): Option[TValue] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Option[TValue]]
    }
    
    @scala.inline
    implicit class OptionMutableBuilder[Self <: Option[?], TValue] (val x: Self & Option[TValue]) extends AnyVal {
      
      @scala.inline
      def setValue(value: TValue): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValueUndefined: Self = StObject.set(x, "value", js.undefined)
    }
  }
  
  type OptionValues = String | Double | Boolean
  
  @js.native
  trait ReactSelectClass[TValue]
    extends Component[ReactSelectProps[TValue], js.Object, js.Any] {
    
    def focus(): Unit = js.native
    
    def setValue(value: Option[TValue]): Unit = js.native
  }
  
  @js.native
  trait ReactSelectProps[TValue]
    extends StObject
       with Props[ReactSelectClass[TValue]] {
    
    /**
      * text to display when `allowCreate` is true.
      * @default 'Add "{label}"?'
      */
    var addLabelText: js.UndefOr[String] = js.native
  }
  object ReactSelectProps {
    
    @scala.inline
    def apply[TValue](): ReactSelectProps[TValue] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ReactSelectProps[TValue]]
    }
    
    @scala.inline
    implicit class ReactSelectPropsMutableBuilder[Self <: ReactSelectProps[?], TValue] (val x: Self & ReactSelectProps[TValue]) extends AnyVal {
      
      @scala.inline
      def setAddLabelText(value: String): Self = StObject.set(x, "addLabelText", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAddLabelTextUndefined: Self = StObject.set(x, "addLabelText", js.undefined)
    }
  }
}
