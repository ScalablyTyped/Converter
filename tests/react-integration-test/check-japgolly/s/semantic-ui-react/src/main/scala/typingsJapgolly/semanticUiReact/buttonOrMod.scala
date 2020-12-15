package typingsJapgolly.semanticUiReact

import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.mod.StatelessComponent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object buttonOrMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  val default: StatelessComponent[ButtonOrProps] = js.native
  
  @js.native
  trait ButtonOrProps
    extends StrictButtonOrProps
       with /* key */ StringDictionary[js.Any]
  object ButtonOrProps {
    
    @scala.inline
    def apply(): ButtonOrProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ButtonOrProps]
    }
  }
  
  @js.native
  trait StrictButtonOrProps extends js.Object {
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[js.Any] = js.native
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.native
    
    /** Or buttons can have their text localized, or adjusted by using the text prop. */
    var text: js.UndefOr[Double | String] = js.native
  }
  object StrictButtonOrProps {
    
    @scala.inline
    def apply(): StrictButtonOrProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictButtonOrProps]
    }
    
    @scala.inline
    implicit class StrictButtonOrPropsOps[Self <: StrictButtonOrProps] (val x: Self) extends AnyVal {
      
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
      def setAs(value: js.Any): Self = this.set("as", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAs: Self = this.set("as", js.undefined)
      
      @scala.inline
      def setClassName(value: String): Self = this.set("className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteClassName: Self = this.set("className", js.undefined)
      
      @scala.inline
      def setText(value: Double | String): Self = this.set("text", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteText: Self = this.set("text", js.undefined)
    }
  }
}
