package typingsSlinky.reactSelect

import org.scalablytyped.runtime.StringDictionary
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.Props
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait Option[TValue]
    extends /**
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
    implicit class OptionOps[Self <: Option[_], TValue] (val x: Self with Option[TValue]) extends AnyVal {
      
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
      def setValue(value: TValue): Self = this.set("value", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteValue: Self = this.set("value", js.undefined)
    }
  }
  
  @js.native
  trait ReactSelectClass[TValue]
    extends Component[ReactSelectProps[TValue], js.Object, js.Any] {
    
    def focus(): Unit = js.native
    
    def setValue(value: Option[TValue]): Unit = js.native
  }
  
  @js.native
  trait ReactSelectProps[TValue] extends Props[ReactSelectClass[TValue]] {
    
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
    implicit class ReactSelectPropsOps[Self <: ReactSelectProps[_], TValue] (val x: Self with ReactSelectProps[TValue]) extends AnyVal {
      
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
      def setAddLabelText(value: String): Self = this.set("addLabelText", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAddLabelText: Self = this.set("addLabelText", js.undefined)
    }
  }
  
  @JSImport("react-select", JSImport.Default)
  @js.native
  class default[TValue] () extends ReactSelectClass[TValue]
  
  type OptionValues = String | Double | Boolean
}
