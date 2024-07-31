package typingsSlinky.stardustUiReactComponentEventListener.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.stardustUiReactComponentEventListener.distEsTypesMod.EventListenerOptions
import _root_.typingsSlinky.stardustUiReactComponentEventListener.distEsTypesMod.EventTypes
import slinky.core.facade.ReactRef
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object EventListener {
  
  inline def apply[T /* <: EventTypes */](
    listener: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Unit,
    targetRef: ReactRef[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ Any
    ],
    `type`: T
  ): Builder[T] = {
    val __props = js.Dynamic.literal(listener = js.Any.fromFunction1(listener), targetRef = targetRef.asInstanceOf[js.Any])
    __props.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    new Builder[T](js.Array(this.component, __props.asInstanceOf[EventListenerOptions[T]]))
  }
  
  @JSImport("@stardust-ui/react-component-event-listener", "EventListener")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder[T /* <: EventTypes */] (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    inline def capture(value: Boolean): this.type = set("capture", value.asInstanceOf[js.Any])
  }
  
  type Props[T /* <: EventTypes */] = EventListenerOptions[T]
  
  def withProps[T /* <: EventTypes */](p: EventListenerOptions[T]): Builder[T] = new Builder[T](js.Array(this.component, p.asInstanceOf[js.Any]))
}
