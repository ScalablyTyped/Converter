package typings.winston

import typings.winston.configMod.AbstractConfigSetLevels
import typings.winston.configMod.Config
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait LoggerOptions extends js.Object {
    
    var levels: js.UndefOr[AbstractConfigSetLevels] = js.native
  }
  object LoggerOptions {
    
    @scala.inline
    def apply(): LoggerOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[LoggerOptions]
    }
    
    @scala.inline
    implicit class LoggerOptionsOps[Self <: LoggerOptions] (val x: Self) extends AnyVal {
      
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
      def setLevels(value: AbstractConfigSetLevels): Self = this.set("levels", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLevels: Self = this.set("levels", js.undefined)
    }
  }
  
  object config {
    
    @JSImport("winston", "config")
    @js.native
    val ^ : Config = js.native
    
    /* Syntax to write `config` instead of `config.^` */
    @scala.inline
    implicit def __is(ignored: config.type): Config = typings.winston.mod.config.^
  }
}
