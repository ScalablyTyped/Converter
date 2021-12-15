package typingsJapgolly.stardustUiReactComponentEventListener

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.facade.React.RefHandle
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesMod {
  
  type EventHandler[T /* <: EventTypes */] = js.Function1[
    /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any, 
    Unit
  ]
  
  trait EventListenerOptions[T /* <: EventTypes */] extends StObject {
    
    /** Indicating that events of this type will be dispatched to the registered listener before being dispatched to any EventTarget beneath it in the DOM tree. */
    var capture: js.UndefOr[Boolean] = js.undefined
    
    /** A function which receives a notification when an event of the specified type occurs. */
    var listener: EventHandler[T]
    
    /** A ref object with a target node. */
    var targetRef: RefHandle[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
      ]
    
    /** A case-sensitive string representing the event type to listen for. */
    var `type`: T
  }
  object EventListenerOptions {
    
    inline def apply[T /* <: EventTypes */](
      listener: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Callback,
      targetRef: RefHandle[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
        ],
      `type`: T
    ): EventListenerOptions[T] = {
      val __obj = js.Dynamic.literal(listener = js.Any.fromFunction1((t0: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any) => listener(t0).runNow()), targetRef = targetRef.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[EventListenerOptions[T]]
    }
    
    extension [Self <: EventListenerOptions[?], T /* <: EventTypes */](x: Self & EventListenerOptions[T]) {
      
      inline def setCapture(value: Boolean): Self = StObject.set(x, "capture", value.asInstanceOf[js.Any])
      
      inline def setCaptureUndefined: Self = StObject.set(x, "capture", js.undefined)
      
      inline def setListener(
        value: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Callback
      ): Self = StObject.set(x, "listener", js.Any.fromFunction1((t0: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any) => value(t0).runNow()))
      
      inline def setTargetRef(
        value: RefHandle[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
            ]
      ): Self = StObject.set(x, "targetRef", value.asInstanceOf[js.Any])
      
      inline def setType(value: T): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type EventTypes = /* keyof / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any */ String
  
  type TargetRef = RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ]
}
