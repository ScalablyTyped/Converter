package typings.echarts

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object echarts {
  
  object EChartOption {
    
    /* Rewritten from type alias, can be one of: 
      - typings.echarts.echarts.EChartOption.DataZoom.Inside
      - typings.echarts.echarts.EChartOption.DataZoom.Slider
    */
    trait DataZoom extends StObject
    object DataZoom {
      
      @js.native
      trait Inside
        extends StObject
           with DataZoom {
        
        var disabled: js.UndefOr[Boolean] = js.native
        
        var id: js.UndefOr[String] = js.native
        
        var `type`: js.UndefOr[String] = js.native
      }
      object Inside {
        
        @scala.inline
        def apply(): Inside = {
          val __obj = js.Dynamic.literal()
          __obj.asInstanceOf[Inside]
        }
        
        @scala.inline
        implicit class InsideMutableBuilder[Self <: Inside] (val x: Self) extends AnyVal {
          
          @scala.inline
          def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
          
          @scala.inline
          def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setIdUndefined: Self = StObject.set(x, "id", js.undefined)
          
          @scala.inline
          def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
        }
      }
      
      @js.native
      trait Slider
        extends StObject
           with DataZoom {
        
        var id: js.UndefOr[String] = js.native
        
        var `type`: js.UndefOr[String] = js.native
      }
      object Slider {
        
        @scala.inline
        def apply(): Slider = {
          val __obj = js.Dynamic.literal()
          __obj.asInstanceOf[Slider]
        }
        
        @scala.inline
        implicit class SliderMutableBuilder[Self <: Slider] (val x: Self) extends AnyVal {
          
          @scala.inline
          def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setIdUndefined: Self = StObject.set(x, "id", js.undefined)
          
          @scala.inline
          def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
          
          @scala.inline
          def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
        }
      }
    }
  }
}
