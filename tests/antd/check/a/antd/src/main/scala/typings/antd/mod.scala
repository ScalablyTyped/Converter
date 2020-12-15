package typings.antd

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  /* Inlined parent std.Omit<rc-field-form.rc-field-form/es/Form.FormProps, 'form'> */
  @js.native
  trait FormProps extends js.Object {
    
    var name: js.UndefOr[String] = js.native
    
    var prefixCls: js.UndefOr[String] = js.native
  }
  object FormProps {
    
    @scala.inline
    def apply(): FormProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[FormProps]
    }
    
    @scala.inline
    implicit class FormPropsOps[Self <: FormProps] (val x: Self) extends AnyVal {
      
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
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteName: Self = this.set("name", js.undefined)
      
      @scala.inline
      def setPrefixCls(value: String): Self = this.set("prefixCls", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePrefixCls: Self = this.set("prefixCls", js.undefined)
    }
  }
}
