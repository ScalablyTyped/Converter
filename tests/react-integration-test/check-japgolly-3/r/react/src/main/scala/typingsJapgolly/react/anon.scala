package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.facade.Empty
import japgolly.scalajs.react.facade.JsNumber
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.reactDropzoneTypingsReactDropzoneMod.DropEvent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Accept extends StObject {
    
    var accept: js.UndefOr[String | js.Array[String]] = js.undefined
    
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    var getFilesFromEvent: js.UndefOr[
        js.Function1[
          /* event */ DropEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ Any
        ]
      ] = js.undefined
    
    var maxSize: js.UndefOr[Double] = js.undefined
    
    var minSize: js.UndefOr[Double] = js.undefined
    
    var noClick: js.UndefOr[Boolean] = js.undefined
    
    var noDrag: js.UndefOr[Boolean] = js.undefined
    
    var noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined
    
    var noKeyboard: js.UndefOr[Boolean] = js.undefined
    
    var onDrop: js.UndefOr[
        js.Function3[
          /* acceptedFiles */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* rejectedFiles */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onDropAccepted: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onDropRejected: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onFileDialogCancel: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    var preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  }
  object Accept {
    
    inline def apply(): Accept = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Accept]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Accept] (val x: Self) extends AnyVal {
      
      inline def setAccept(value: String | js.Array[String]): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      inline def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
      
      inline def setAcceptVarargs(value: String*): Self = StObject.set(x, "accept", js.Array(value*))
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setGetFilesFromEvent(
        value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ Any
      ): Self = StObject.set(x, "getFilesFromEvent", js.Any.fromFunction1(value))
      
      inline def setGetFilesFromEventUndefined: Self = StObject.set(x, "getFilesFromEvent", js.undefined)
      
      inline def setMaxSize(value: Double): Self = StObject.set(x, "maxSize", value.asInstanceOf[js.Any])
      
      inline def setMaxSizeUndefined: Self = StObject.set(x, "maxSize", js.undefined)
      
      inline def setMinSize(value: Double): Self = StObject.set(x, "minSize", value.asInstanceOf[js.Any])
      
      inline def setMinSizeUndefined: Self = StObject.set(x, "minSize", js.undefined)
      
      inline def setNoClick(value: Boolean): Self = StObject.set(x, "noClick", value.asInstanceOf[js.Any])
      
      inline def setNoClickUndefined: Self = StObject.set(x, "noClick", js.undefined)
      
      inline def setNoDrag(value: Boolean): Self = StObject.set(x, "noDrag", value.asInstanceOf[js.Any])
      
      inline def setNoDragEventsBubbling(value: Boolean): Self = StObject.set(x, "noDragEventsBubbling", value.asInstanceOf[js.Any])
      
      inline def setNoDragEventsBubblingUndefined: Self = StObject.set(x, "noDragEventsBubbling", js.undefined)
      
      inline def setNoDragUndefined: Self = StObject.set(x, "noDrag", js.undefined)
      
      inline def setNoKeyboard(value: Boolean): Self = StObject.set(x, "noKeyboard", value.asInstanceOf[js.Any])
      
      inline def setNoKeyboardUndefined: Self = StObject.set(x, "noKeyboard", js.undefined)
      
      inline def setOnDrop(
        value: (/* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDrop", js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], t1: /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], t2: /* event */ DropEvent) => (value(t0, t1, t2)).runNow()))
      
      inline def setOnDropAccepted(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDropAccepted", js.Any.fromFunction2((t0: /* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
      
      inline def setOnDropAcceptedUndefined: Self = StObject.set(x, "onDropAccepted", js.undefined)
      
      inline def setOnDropRejected(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDropRejected", js.Any.fromFunction2((t0: /* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
      
      inline def setOnDropRejectedUndefined: Self = StObject.set(x, "onDropRejected", js.undefined)
      
      inline def setOnDropUndefined: Self = StObject.set(x, "onDrop", js.undefined)
      
      inline def setOnFileDialogCancel(value: Callback): Self = StObject.set(x, "onFileDialogCancel", value.toJsFn)
      
      inline def setOnFileDialogCancelUndefined: Self = StObject.set(x, "onFileDialogCancel", js.undefined)
      
      inline def setPreventDropOnDocument(value: Boolean): Self = StObject.set(x, "preventDropOnDocument", value.asInstanceOf[js.Any])
      
      inline def setPreventDropOnDocumentUndefined: Self = StObject.set(x, "preventDropOnDocument", js.undefined)
    }
  }
  
  trait Changed extends StObject {
    
    var changed: js.Array[ViewToken]
    
    var viewableItems: js.Array[ViewToken]
  }
  object Changed {
    
    inline def apply(changed: js.Array[ViewToken], viewableItems: js.Array[ViewToken]): Changed = {
      val __obj = js.Dynamic.literal(changed = changed.asInstanceOf[js.Any], viewableItems = viewableItems.asInstanceOf[js.Any])
      __obj.asInstanceOf[Changed]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Changed] (val x: Self) extends AnyVal {
      
      inline def setChanged(value: js.Array[ViewToken]): Self = StObject.set(x, "changed", value.asInstanceOf[js.Any])
      
      inline def setChangedVarargs(value: ViewToken*): Self = StObject.set(x, "changed", js.Array(value*))
      
      inline def setViewableItems(value: js.Array[ViewToken]): Self = StObject.set(x, "viewableItems", value.asInstanceOf[js.Any])
      
      inline def setViewableItemsVarargs(value: ViewToken*): Self = StObject.set(x, "viewableItems", js.Array(value*))
    }
  }
  
  trait Children extends StObject {
    
    var children: js.UndefOr[Node] = js.undefined
  }
  object Children {
    
    inline def apply(): Children = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Children]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Children] (val x: Self) extends AnyVal {
      
      inline def setChildren(value: VdomNode): Self = StObject.set(x, "children", value.rawNode.asInstanceOf[js.Any])
      
      inline def setChildrenNull: Self = StObject.set(x, "children", null)
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setChildrenVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "children", js.Array(value*))
      
      inline def setChildrenVdomElement(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
    }
  }
  
  trait Equals extends StObject {
    
    @JSName("equals")
    var equals_FEquals: js.UndefOr[Boolean] = js.undefined
    
    def finalize(other: js.Object): Boolean
    
    @JSName("ne")
    var ne_FEquals: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.undefined
  }
  object Equals {
    
    inline def apply(finalize_ : js.Object => Boolean): Equals = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[Equals]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Equals] (val x: Self) extends AnyVal {
      
      inline def setEquals_(value: Boolean): Self = StObject.set(x, "equals", value.asInstanceOf[js.Any])
      
      inline def setEquals_Undefined: Self = StObject.set(x, "equals", js.undefined)
      
      inline def setFinalize_(value: js.Object => Boolean): Self = StObject.set(x, "finalize", js.Any.fromFunction1(value))
      
      inline def setNe_(value: /* other */ js.Object => Boolean): Self = StObject.set(x, "ne", js.Any.fromFunction1(value))
      
      inline def setNe_Undefined: Self = StObject.set(x, "ne", js.undefined)
    }
  }
  
  trait Html extends StObject {
    
    var __html: String
  }
  object Html {
    
    inline def apply(__html: String): Html = {
      val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
      __obj.asInstanceOf[Html]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Html] (val x: Self) extends AnyVal {
      
      inline def set__html(value: String): Self = StObject.set(x, "__html", value.asInstanceOf[js.Any])
    }
  }
}
