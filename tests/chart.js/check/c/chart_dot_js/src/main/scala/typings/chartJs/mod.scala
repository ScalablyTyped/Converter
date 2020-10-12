package typings.chartJs

import org.scalablytyped.runtime.StringDictionary
import typings.chartJs.anon.Dictkey
import typings.chartJs.anon.TypeofChart
import typings.std.ArrayLike
import typings.std.CanvasRenderingContext2D
import typings.std.HTMLCanvasElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* static members */
object mod {
  
  @JSImport("chart.js", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  @JSImport("chart.js", JSImport.Namespace)
  @js.native
  class ^ protected ()
    extends typings.chartJs.mod.Chart {
    def this(context: String, options: js.Any) = this()
    def this(context: ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement], options: js.Any) = this()
    def this(context: CanvasRenderingContext2D, options: js.Any) = this()
    def this(context: HTMLCanvasElement, options: js.Any) = this()
  }
  
  @JSImport("chart.js", "Chart")
  @js.native
  val Chart: TypeofChart = js.native
  
  @JSImport("chart.js", "controllers")
  @js.native
  def controllers: StringDictionary[js.Any] = js.native
  @scala.inline
  def controllers_=(x: StringDictionary[js.Any]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("controllers")(x.asInstanceOf[js.Any])
  
  @JSImport("chart.js", "defaults")
  @js.native
  def defaults: Dictkey = js.native
  @scala.inline
  def defaults_=(x: Dictkey): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("defaults")(x.asInstanceOf[js.Any])
  
  @js.native
  trait Chart extends js.Object {
    
    def clear(): js.Object = js.native
    
    var data: ChartData = js.native
    
    def destroy(): js.Object = js.native
    
    def generateLegend(): js.Object = js.native
    
    def getDatasetAtEvent(e: js.Any): js.Array[js.Object] = js.native
    
    def getElementAtEvent(e: js.Any): js.Object = js.native
    
    def getElementsAtEvent(e: js.Any): js.Array[js.Object] = js.native
    
    def render(): js.Object = js.native
    def render(duration: js.UndefOr[scala.Nothing], `lazy`: js.Any): js.Object = js.native
    def render(duration: js.Any): js.Object = js.native
    def render(duration: js.Any, `lazy`: js.Any): js.Object = js.native
    
    def resize(): js.Object = js.native
    
    def stop(): js.Object = js.native
    
    def toBase64(): String = js.native
    
    def update(): js.Object = js.native
    def update(duration: js.UndefOr[scala.Nothing], `lazy`: js.Any): js.Object = js.native
    def update(duration: js.Any): js.Object = js.native
    def update(duration: js.Any, `lazy`: js.Any): js.Object = js.native
  }
  
  @js.native
  trait ChartData extends js.Object {
    
    var labels: js.UndefOr[js.Array[String | js.Array[String]]] = js.native
  }
  object ChartData {
    
    @scala.inline
    def apply(): ChartData = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ChartData]
    }
    
    @scala.inline
    implicit class ChartDataOps[Self <: ChartData] (val x: Self) extends AnyVal {
      
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
      def setLabelsVarargs(value: (String | js.Array[String])*): Self = this.set("labels", js.Array(value :_*))
      
      @scala.inline
      def setLabels(value: js.Array[String | js.Array[String]]): Self = this.set("labels", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLabels: Self = this.set("labels", js.undefined)
    }
  }
  
  @js.native
  trait ChartFontOptions extends js.Object {
    
    var foo: Boolean = js.native
  }
  object ChartFontOptions {
    
    @scala.inline
    def apply(foo: Boolean): ChartFontOptions = {
      val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
      __obj.asInstanceOf[ChartFontOptions]
    }
    
    @scala.inline
    implicit class ChartFontOptionsOps[Self <: ChartFontOptions] (val x: Self) extends AnyVal {
      
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
      def setFoo(value: Boolean): Self = this.set("foo", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ChartOptions extends js.Object {
    
    // Plugins can require any options
    var plugins: js.UndefOr[StringDictionary[js.Any]] = js.native
    
    var responsive: js.UndefOr[Boolean] = js.native
  }
  object ChartOptions {
    
    @scala.inline
    def apply(): ChartOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ChartOptions]
    }
    
    @scala.inline
    implicit class ChartOptionsOps[Self <: ChartOptions] (val x: Self) extends AnyVal {
      
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
      def setPlugins(value: StringDictionary[js.Any]): Self = this.set("plugins", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePlugins: Self = this.set("plugins", js.undefined)
      
      @scala.inline
      def setResponsive(value: Boolean): Self = this.set("responsive", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteResponsive: Self = this.set("responsive", js.undefined)
    }
  }
}
