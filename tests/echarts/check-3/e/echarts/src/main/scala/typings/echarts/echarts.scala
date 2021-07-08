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
      
      trait Inside
        extends StObject
           with DataZoom {
        
        var disabled: js.UndefOr[Boolean] = js.undefined
        
        var id: js.UndefOr[String] = js.undefined
        
        var `type`: js.UndefOr[String] = js.undefined
      }
      object Inside {
        
        inline def apply(): Inside = {
          val __obj = js.Dynamic.literal()
          __obj.asInstanceOf[Inside]
        }
        
        extension [Self <: Inside](x: Self) {
          
          inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
          
          inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
          
          inline def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
          
          inline def setIdUndefined: Self = StObject.set(x, "id", js.undefined)
          
          inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
          
          inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
        }
      }
      
      trait Slider
        extends StObject
           with DataZoom {
        
        var id: js.UndefOr[String] = js.undefined
        
        var `type`: js.UndefOr[String] = js.undefined
      }
      object Slider {
        
        inline def apply(): Slider = {
          val __obj = js.Dynamic.literal()
          __obj.asInstanceOf[Slider]
        }
        
        extension [Self <: Slider](x: Self) {
          
          inline def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
          
          inline def setIdUndefined: Self = StObject.set(x, "id", js.undefined)
          
          inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
          
          inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
        }
      }
    }
  }
}
