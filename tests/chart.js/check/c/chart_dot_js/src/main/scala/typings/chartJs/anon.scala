package typings.chartJs

import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.StringDictionary
import typings.chartJs.mod.Chart
import typings.chartJs.mod.ChartFontOptions
import typings.chartJs.mod.ChartOptions
import typings.std.ArrayLike
import typings.std.CanvasRenderingContext2D
import typings.std.HTMLCanvasElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Dictkey
    extends /* key */ StringDictionary[js.Any] {
    
    var global: ChartOptions with ChartFontOptions = js.native
  }
  object Dictkey {
    
    @scala.inline
    def apply(global: ChartOptions with ChartFontOptions): Dictkey = {
      val __obj = js.Dynamic.literal(global = global.asInstanceOf[js.Any])
      __obj.asInstanceOf[Dictkey]
    }
    
    @scala.inline
    implicit class DictkeyOps[Self <: Dictkey] (val x: Self) extends AnyVal {
      
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
      def setGlobal(value: ChartOptions with ChartFontOptions): Self = this.set("global", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait TypeofChart
    extends Instantiable2[
          (/* context */ ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement]) | (/* context */ CanvasRenderingContext2D) | (/* context */ HTMLCanvasElement) | (/* context */ String), 
          /* options */ js.Any, 
          Chart
        ] {
    
    var controllers: StringDictionary[js.Any] = js.native
    
    var defaults: Dictkey = js.native
  }
}
