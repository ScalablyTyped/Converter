package typingsSlinky.react.mod

import _root_.typingsSlinky.react.reactStrings.mount
import _root_.typingsSlinky.react.reactStrings.update
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ProfilerProps extends StObject {
  
  var children: js.UndefOr[slinky.core.facade.ReactElement] = js.undefined
  
  var id: String
  
  var onRender: ProfilerOnRenderCallback
}
object ProfilerProps {
  
  inline def apply(
    id: String,
    onRender: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ Any) => Unit
  ): ProfilerProps = {
    val __obj = js.Dynamic.literal(id = id.asInstanceOf[js.Any], onRender = js.Any.fromFunction7(onRender))
    __obj.asInstanceOf[ProfilerProps]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: ProfilerProps] (val x: Self) extends AnyVal {
    
    inline def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    inline def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
    
    inline def setOnRender(
      value: (/* id */ String, /* phase */ mount | update, /* actualDuration */ Double, /* baseDuration */ Double, /* startTime */ Double, /* commitTime */ Double, /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ Any) => Unit
    ): Self = StObject.set(x, "onRender", js.Any.fromFunction7(value))
  }
}
