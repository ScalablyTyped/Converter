package typingsSlinky.stardustUiReactComponentEventListener.components

import slinky.core.facade.ReactRef
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object EventListener {
  @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder[/* <: typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes */ T] (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    @scala.inline
    def capture(value: Boolean): this.type = set("capture", value.asInstanceOf[js.Any])
  }
  
  def withProps[/* <: typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes */ T](p: EventListenerOptions[T]): Builder[T] = new Builder[T](js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply[/* <: typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes */ T](
    listener: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Unit,
    targetRef: ReactRef[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
    ],
    `type`: T
  ): Builder[T] = {
    val __props = js.Dynamic.literal(listener = js.Any.fromFunction1(listener), targetRef = targetRef.asInstanceOf[js.Any])
    __props.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    new Builder[T](js.Array(this.component, __props.asInstanceOf[EventListenerOptions[T]]))
  }
}

