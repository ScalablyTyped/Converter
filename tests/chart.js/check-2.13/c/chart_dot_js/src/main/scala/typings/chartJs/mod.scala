package typings.chartJs

import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import typings.std.ArrayLike
import typings.std.CanvasRenderingContext2D
import typings.std.HTMLCanvasElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod extends Shortcut {
  
  @JSImport("chart.js", JSImport.Namespace)
  @js.native
  class ^ protected ()
    extends StObject
       with typings.chartJs.mod.Chart {
    def this(context: String, options: js.Any) = this()
    def this(context: ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement], options: js.Any) = this()
    def this(context: CanvasRenderingContext2D, options: js.Any) = this()
    def this(context: HTMLCanvasElement, options: js.Any) = this()
  }
  @JSImport("chart.js", JSImport.Namespace)
  @js.native
  val ^ : js.Object with (Instantiable2[
    /* context */ String | CanvasRenderingContext2D | HTMLCanvasElement | (ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement]), 
    /* options */ js.Any, 
    typings.chartJs.mod.Chart
  ]) = js.native
  
  @js.native
  trait Chart extends StObject {
    
    def clear(): js.Object = js.native
    
    var data: ChartData = js.native
    
    def destroy(): js.Object = js.native
    
    def generateLegend(): js.Object = js.native
    
    def getDatasetAtEvent(e: js.Any): js.Array[js.Object] = js.native
    
    def getElementAtEvent(e: js.Any): js.Object = js.native
    
    def getElementsAtEvent(e: js.Any): js.Array[js.Object] = js.native
    
    def render(): js.Object = js.native
    def render(duration: js.Any): js.Object = js.native
    def render(duration: js.Any, `lazy`: js.Any): js.Object = js.native
    def render(duration: Unit, `lazy`: js.Any): js.Object = js.native
    
    def resize(): js.Object = js.native
    
    def stop(): js.Object = js.native
    
    def toBase64(): String = js.native
    
    def update(): js.Object = js.native
    def update(duration: js.Any): js.Object = js.native
    def update(duration: js.Any, `lazy`: js.Any): js.Object = js.native
    def update(duration: Unit, `lazy`: js.Any): js.Object = js.native
  }
  /* static member */
  @JSImport("chart.js", "Chart")
  @js.native
  val Chart: Instantiable2[
    /* context */ String | CanvasRenderingContext2D | HTMLCanvasElement | (ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement]), 
    /* options */ js.Any, 
    typings.chartJs.mod.Chart
  ] = js.native
  
  /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
  @JSImport("chart.js", "Chart")
  @js.native
  class ChartCls protected ()
    extends StObject
       with typings.chartJs.mod.Chart {
    def this(context: String, options: js.Any) = this()
    def this(context: ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement], options: js.Any) = this()
    def this(context: CanvasRenderingContext2D, options: js.Any) = this()
    def this(context: HTMLCanvasElement, options: js.Any) = this()
  }
  
  /* static member */
  object defaults {
    
    @JSImport("chart.js", "defaults")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("chart.js", "defaults.global")
    @js.native
    def global: ChartOptions with ChartFontOptions = js.native
    @scala.inline
    def global_=(x: ChartOptions with ChartFontOptions): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("global")(x.asInstanceOf[js.Any])
  }
  
  @js.native
  trait ChartData extends StObject {
    
    var labels: js.UndefOr[js.Array[String | js.Array[String]]] = js.native
  }
  object ChartData {
    
    @scala.inline
    def apply(): ChartData = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ChartData]
    }
    
    @scala.inline
    implicit class ChartDataMutableBuilder[Self <: ChartData] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setLabels(value: js.Array[String | js.Array[String]]): Self = StObject.set(x, "labels", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setLabelsUndefined: Self = StObject.set(x, "labels", js.undefined)
      
      @scala.inline
      def setLabelsVarargs(value: (String | js.Array[String])*): Self = StObject.set(x, "labels", js.Array(value :_*))
    }
  }
  
  @js.native
  trait ChartFontOptions extends StObject {
    
    var foo: Boolean = js.native
  }
  object ChartFontOptions {
    
    @scala.inline
    def apply(foo: Boolean): ChartFontOptions = {
      val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
      __obj.asInstanceOf[ChartFontOptions]
    }
    
    @scala.inline
    implicit class ChartFontOptionsMutableBuilder[Self <: ChartFontOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setFoo(value: Boolean): Self = StObject.set(x, "foo", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ChartOptions extends StObject {
    
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
    implicit class ChartOptionsMutableBuilder[Self <: ChartOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setPlugins(value: StringDictionary[js.Any]): Self = StObject.set(x, "plugins", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPluginsUndefined: Self = StObject.set(x, "plugins", js.undefined)
      
      @scala.inline
      def setResponsive(value: Boolean): Self = StObject.set(x, "responsive", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setResponsiveUndefined: Self = StObject.set(x, "responsive", js.undefined)
    }
  }
  
  type _To = js.Object with (Instantiable2[
    /* context */ String | CanvasRenderingContext2D | HTMLCanvasElement | (ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement]), 
    /* options */ js.Any, 
    typings.chartJs.mod.Chart
  ])
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: js.Object with (Instantiable2[
    /* context */ String | CanvasRenderingContext2D | HTMLCanvasElement | (ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement]), 
    /* options */ js.Any, 
    typings.chartJs.mod.Chart
  ]) = ^
  
  /* static member */
  object controllers
}
