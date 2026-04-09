package imported

import org.scalajs.dom.AnimationEvent
import org.scalajs.dom.ClipboardEvent
import org.scalajs.dom.CompositionEvent
import org.scalajs.dom.DataTransfer
import org.scalajs.dom.Element
import org.scalajs.dom.EventTarget
import org.scalajs.dom.FocusEvent
import org.scalajs.dom.HTMLAnchorElement
import org.scalajs.dom.HTMLAreaElement
import org.scalajs.dom.HTMLAudioElement
import org.scalajs.dom.HTMLBRElement
import org.scalajs.dom.HTMLBaseElement
import org.scalajs.dom.HTMLBodyElement
import org.scalajs.dom.HTMLButtonElement
import org.scalajs.dom.HTMLCanvasElement
import org.scalajs.dom.HTMLDListElement
import org.scalajs.dom.HTMLDataListElement
import org.scalajs.dom.HTMLDivElement
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.HTMLEmbedElement
import org.scalajs.dom.HTMLFieldSetElement
import org.scalajs.dom.HTMLFormElement
import org.scalajs.dom.HTMLHRElement
import org.scalajs.dom.HTMLHeadElement
import org.scalajs.dom.HTMLHeadingElement
import org.scalajs.dom.HTMLHtmlElement
import org.scalajs.dom.HTMLIFrameElement
import org.scalajs.dom.HTMLImageElement
import org.scalajs.dom.HTMLInputElement
import org.scalajs.dom.HTMLLIElement
import org.scalajs.dom.HTMLLabelElement
import org.scalajs.dom.HTMLLegendElement
import org.scalajs.dom.HTMLLinkElement
import org.scalajs.dom.HTMLMapElement
import org.scalajs.dom.HTMLMenuElement
import org.scalajs.dom.HTMLMetaElement
import org.scalajs.dom.HTMLOListElement
import org.scalajs.dom.HTMLObjectElement
import org.scalajs.dom.HTMLOptGroupElement
import org.scalajs.dom.HTMLOptionElement
import org.scalajs.dom.HTMLParagraphElement
import org.scalajs.dom.HTMLParamElement
import org.scalajs.dom.HTMLPreElement
import org.scalajs.dom.HTMLProgressElement
import org.scalajs.dom.HTMLQuoteElement
import org.scalajs.dom.HTMLScriptElement
import org.scalajs.dom.HTMLSelectElement
import org.scalajs.dom.HTMLSourceElement
import org.scalajs.dom.HTMLSpanElement
import org.scalajs.dom.HTMLStyleElement
import org.scalajs.dom.HTMLTableCellElement
import org.scalajs.dom.HTMLTableElement
import org.scalajs.dom.HTMLTableRowElement
import org.scalajs.dom.HTMLTextAreaElement
import org.scalajs.dom.HTMLTitleElement
import org.scalajs.dom.HTMLTrackElement
import org.scalajs.dom.HTMLVideoElement
import org.scalajs.dom.InputEvent
import org.scalajs.dom.KeyboardEvent
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.PointerEvent
import org.scalajs.dom.TouchEvent
import org.scalajs.dom.TouchList
import org.scalajs.dom.TransitionEvent
import org.scalajs.dom.UIEvent
import org.scalajs.dom.WheelEvent
import org.scalajs.dom.Window
import slinky.core.ReactComponentClass
import slinky.core.StatelessComponent.State
import slinky.core.SyntheticEvent
import slinky.core.facade.ErrorBoundaryInfo
import slinky.core.facade.React.Component
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactInstance
import slinky.native.AlertButton
import slinky.native.AlertOptions
import slinky.native.ScrollOptions
import slinky.native.ScrollTarget
import slinky.native.ScrollToEndParams
import slinky.native.ScrollToIndexParams
import slinky.native.ScrollToItemParams
import slinky.native.ScrollToOffsetParams
import slinky.readwrite.ObjectOrWritten
import slinky.readwrite.Reader
import slinky.readwrite.Writer
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object slinky {
  
  object core {
    
    @js.native
    class AttrPair[A] protected ()
      extends StObject
         with TagMod[A] {
      def this(name: String, value: js.Any) = this()
      
      val name: String = js.native
      
      val value: js.Any = js.native
    }
    
    @js.native
    class Component ()
      extends StObject
         with slinky.core.facade.React.Component {
      
      def componentDidCatch(error: js.Error, info: ErrorBoundaryInfo): Unit = js.native
      
      def componentDidMount(): Unit = js.native
      
      def componentDidUpdate(prevProps: Props, prevState: State): Unit = js.native
      def componentDidUpdate(prevProps: Props, prevState: State, snapshot: Snapshot): Unit = js.native
      
      def componentWillMount(): Unit = js.native
      
      def componentWillReceiveProps(nextProps: Props): Unit = js.native
      
      def componentWillUnmount(): Unit = js.native
      
      def componentWillUpdate(nextProps: Props, nextState: State): Unit = js.native
      
      def getSnapshotBeforeUpdate(prevProps: Props, prevState: State): Snapshot = js.native
      
      def initialState(): State = js.native
      
      def props(): Props = js.native
      
      def render(): ReactElement = js.native
      
      def setState(fn: State => State): Unit = js.native
      def setState(fn: State => State, callback: () => Unit): Unit = js.native
      def setState(fn: (State, Props) => State): Unit = js.native
      def setState(fn: (State, Props) => State, callback: () => Unit): Unit = js.native
      def setState(s: State): Unit = js.native
      def setState(s: State, callback: () => Unit): Unit = js.native
      
      def shouldComponentUpdate(nextProps: Props, nextState: State): Boolean = js.native
      
      def state(): State = js.native
    }
    
    @js.native
    class DefinitionBase[Props, State, Snapshot] protected ()
      extends StObject
         with slinky.core.facade.React.Component {
      def this(jsProps: js.Object) = this()
      
      def componentDidCatch(error: js.Error, info: ErrorBoundaryInfo): Unit = js.native
      
      def componentDidMount(): Unit = js.native
      
      def componentDidUpdate(prevProps: Props, prevState: State): Unit = js.native
      def componentDidUpdate(prevProps: Props, prevState: State, snapshot: Snapshot): Unit = js.native
      
      def componentWillMount(): Unit = js.native
      
      def componentWillReceiveProps(nextProps: Props): Unit = js.native
      
      def componentWillUnmount(): Unit = js.native
      
      def componentWillUpdate(nextProps: Props, nextState: State): Unit = js.native
      
      def getSnapshotBeforeUpdate(prevProps: Props, prevState: State): Snapshot = js.native
      
      def initialState(): State = js.native
      
      val jsProps: js.Object = js.native
      
      def props(): Props = js.native
      
      private def propsReader(): Reader[Props] = js.native
      
      def readPropsValue(value: js.Object): Props = js.native
      
      def readStateValue(value: js.Object): State = js.native
      
      def render(): ReactElement = js.native
      
      def setState(fn: State => State): Unit = js.native
      def setState(fn: State => State, callback: () => Unit): Unit = js.native
      def setState(fn: (State, Props) => State): Unit = js.native
      def setState(fn: (State, Props) => State, callback: () => Unit): Unit = js.native
      def setState(s: State): Unit = js.native
      def setState(s: State, callback: () => Unit): Unit = js.native
      
      def shouldComponentUpdate(nextProps: Props, nextState: State): Boolean = js.native
      
      def state(): State = js.native
      
      private def stateReader(): Reader[State] = js.native
      
      def stateWriter(): Writer[State] = js.native
    }
    
    @js.native
    trait ExternalPropsWriterProvider extends StObject
    
    @js.native
    class OptionalAttrPair[A] protected ()
      extends StObject
         with TagMod[A] {
      def this(name: String, value: Option[js.Any]) = this()
      
      val name: String = js.native
      
      val value: Option[js.Any] = js.native
    }
    
    @js.native
    trait ReactComponentClass[P] extends StObject
    
    @js.native
    trait ReactElementMod
      extends StObject
         with TagMod[Any]
    
    @js.native
    trait RefAttr[T] extends StObject
    
    @js.native
    trait StateReaderProvider extends StObject
    
    @js.native
    trait StateWriterProvider extends StObject
    
    @js.native
    class StatelessComponent ()
      extends StObject
         with Component {
      
      type State = Unit
      
      def initialState(): State = js.native
    }
    
    @js.native
    class StatelessDefinition[Props, Snapshot] protected ()
      extends StObject
         with DefinitionBase[Props, Unit, Snapshot] {
      def this(jsProps: js.Object) = this()
      
      override def initialState(): Unit = js.native
      
      val jsProps: js.Object = js.native
    }
    
    @js.native
    trait SyntheticEvent[TargetType, EventType] extends StObject {
      
      val bubbles: Boolean = js.native
      
      val cancelable: Boolean = js.native
      
      val currentTarget: TargetType = js.native
      
      val defaultPrevented: Boolean = js.native
      
      val eventPhase: Int = js.native
      
      def isDefaultPrevented(): Boolean = js.native
      
      def isPropagationStopped(): Boolean = js.native
      
      val isTrusted: Boolean = js.native
      
      val nativeEvent: EventType = js.native
      
      def preventDefault(): Unit = js.native
      
      def stopPropagation(): Unit = js.native
      
      val target: TargetType = js.native
      
      val timeStamp: Int = js.native
      
      val `type`: String = js.native
    }
    
    @js.native
    trait TagMod[A] extends StObject
    
    object facade {
      
      @js.native
      trait EffectCallbackReturn extends StObject
      
      @js.native
      trait ErrorBoundaryInfo extends StObject {
        
        val componentStack: String = js.native
      }
      
      @js.native
      object HooksRaw extends StObject {
        
        def useContext[T](context: ReactContext[T]): T = js.native
        
        def useDebugValue(value: String): Unit = js.native
        
        def useEffect(thunk: js.Function0[EffectCallbackReturn]): Unit = js.native
        def useEffect(thunk: js.Function0[EffectCallbackReturn], watchedObjects: js.Array[js.Any]): Unit = js.native
        
        def useImperativeHandle[R](ref: ReactRef[R], value: js.Function0[R]): Unit = js.native
        def useImperativeHandle[R](ref: ReactRef[R], value: js.Function0[R], deps: js.Array[js.Any]): Unit = js.native
        
        def useLayoutEffect(thunk: js.Function0[EffectCallbackReturn]): Unit = js.native
        def useLayoutEffect(thunk: js.Function0[EffectCallbackReturn], watchedObjects: js.Array[js.Any]): Unit = js.native
        
        def useMemo[T](callback: js.Function0[T], watchedObjects: js.Array[js.Any]): T = js.native
        
        def useReducer[T, A](reducer: js.Function2[T, A, T], initialState: T): js.Tuple2[T, js.Function1[A, Unit]] = js.native
        def useReducer[T, I, A](reducer: js.Function2[T, A, T], initialState: I, init: js.Function1[I, T]): js.Tuple2[T, js.Function1[A, Unit]] = js.native
        
        def useRef[T](initialValue: T): ReactRef[T] = js.native
        
        def useState[T](default: T | js.Function0[T]): js.Tuple2[T, js.Function1[js.Any, Unit]] = js.native
      }
      
      @js.native
      trait PrivateComponentClass extends StObject {
        
        val contextR: js.Dynamic = js.native
        
        var propsR: js.Object = js.native
        
        val refsR: js.Dynamic = js.native
        
        def setStateR(fn: js.Function2[js.Object, js.Object, js.Object]): Unit = js.native
        def setStateR(fn: js.Function2[js.Object, js.Object, js.Object], callback: js.Function0[Unit]): Unit = js.native
        def setStateR(newState: js.Object): Unit = js.native
        def setStateR(newState: js.Object, callback: js.Function0[Unit]): Unit = js.native
        
        var stateR: js.Object = js.native
      }
      
      object React {
        
        @js.native
        object Children extends StObject {
          
          def count(children: ReactChildren): Int = js.native
          
          def forEach(children: ReactChildren, transformer: ReactElement => Unit): Unit = js.native
          def forEach(children: ReactChildren, transformer: (ReactElement, Int) => Unit): Unit = js.native
          
          def map(children: ReactChildren, transformer: ReactElement => ReactElement): ReactChildren = js.native
          def map(children: ReactChildren, transformer: (ReactElement, Int) => ReactElement): ReactChildren = js.native
          
          def only(children: ReactChildren): ReactElement = js.native
          
          def toArray(children: ReactChildren): js.Array[ReactElement] = js.native
        }
        
        @js.native
        class Component protected () extends StObject {
          def this(jsProps: js.Object) = this()
          
          def forceUpdate(): Unit = js.native
          def forceUpdate(callback: js.Function0[Unit]): Unit = js.native
          
          val jsProps: js.Object = js.native
        }
      }
      
      @js.native
      trait ReactChildren
        extends StObject
           with ReactElement
      
      @js.native
      trait ReactContext[T] extends StObject
      
      @js.native
      trait ReactContextRaw extends StObject {
        
        val Consumer: js.Object = js.native
        
        val Provider: js.Object = js.native
      }
      
      @js.native
      trait ReactElement
        extends StObject
           with ReactElementMod
      
      @js.native
      trait ReactInstance extends StObject
      
      @js.native
      object ReactRaw extends StObject {
        
        @js.native
        object Children extends StObject {
          
          def count(children: ReactChildren): Int = js.native
          
          def forEach(children: ReactChildren, transformer: js.Function1[ReactElement, Unit]): Unit = js.native
          def forEach(children: ReactChildren, transformer: js.Function2[ReactElement, Int, Unit]): Unit = js.native
          
          def map(children: ReactChildren, transformer: js.Function1[ReactElement, ReactElement]): ReactChildren = js.native
          def map(children: ReactChildren, transformer: js.Function2[ReactElement, Int, ReactElement]): ReactChildren = js.native
          
          def only(children: ReactChildren): ReactElement = js.native
          
          def toArray(children: ReactChildren): js.Array[ReactElement] = js.native
        }
        
        val Fragment: js.Object = js.native
        
        val Profiler: js.Object = js.native
        
        val StrictMode: js.Object = js.native
        
        val Suspense: js.Object = js.native
        
        def createContext[T](defaultValue: T): ReactContext[T] = js.native
        
        val createElement: js.Dynamic = js.native
        def createElement(elementName: String | js.Object, properties: js.Dictionary[js.Any], contents: ReactElement): ReactElement = js.native
        
        def createRef[T](): ReactRef[T] = js.native
        
        def forwardRef[P](fn: js.Object): js.Function = js.native
        
        def memo(fn: js.Function, compare: js.UndefOr[js.Object]): js.Function = js.native
      }
      
      @js.native
      trait ReactRef[T] extends StObject {
        
        var current: T = js.native
      }
    }
  }
  
  object native {
    
    @js.native
    object Alert extends StObject {
      
      def alert(
        title: String,
        message: js.UndefOr[String],
        buttons: js.UndefOr[ObjectOrWritten[Seq[AlertButton]]],
        options: js.UndefOr[ObjectOrWritten[AlertOptions]],
        `type`: js.UndefOr[String]
      ): Unit = js.native
    }
    
    @js.native
    object AppRegistry extends StObject {
      
      def registerComponent(appKey: String, componentProvider: js.Function0[ReactComponentClass[_]]): Unit = js.native
    }
    
    @js.native
    trait FlatListInstance[T] extends StObject {
      
      def flashScrollIndicators(): Unit = js.native
      
      def recordInteraction(): Unit = js.native
      
      def scrollToEnd(): Unit = js.native
      def scrollToEnd(params: ObjectOrWritten[ScrollToEndParams]): Unit = js.native
      
      def scrollToIndex(params: ObjectOrWritten[ScrollToIndexParams]): Unit = js.native
      
      def scrollToItem(params: ObjectOrWritten[ScrollToItemParams[T]]): Unit = js.native
      
      def scrollToOffset(params: ObjectOrWritten[ScrollToOffsetParams]): Unit = js.native
    }
    
    object Image {
      
      @js.native
      object Component extends StObject {
        
        def abortPrefetch(requestId: Int): Unit = js.native
        
        def getSize(
          uri: String,
          success: js.Function2[Int, Int, Unit],
          failure: js.UndefOr[js.Function1[js.Error, Unit]]
        ): Unit = js.native
        
        def prefetch(uri: String): Int | Unit = js.native
        
        def queryCache(urls: js.Array[String]): js.Promise[js.Dictionary[String]] = js.native
      }
    }
    
    @js.native
    trait ImageInterface extends StObject
    
    @js.native
    object Keyboard extends StObject {
      
      def addListener(eventName: String, callBack: js.Function0[Unit]): Unit = js.native
      
      def dismiss(): Unit = js.native
      
      def removeAllListeners(eventName: String): Unit = js.native
      
      def removeListener(eventName: String, callBack: js.Function0[Unit]): Unit = js.native
    }
    
    object Picker {
      
      @js.native
      object Component extends StObject {
        
        val Item: js.Object = js.native
      }
    }
    
    @js.native
    object Platform extends StObject {
      
      val OS: String = js.native
    }
    
    @js.native
    object RawClipboard extends StObject {
      
      def getString(): js.Promise[String] = js.native
      
      def setString(content: String): Unit = js.native
    }
    
    @js.native
    trait ScaledSize extends StObject {
      
      var fontScale: Double = js.native
      
      var height: Double = js.native
      
      var scale: Double = js.native
      
      var width: Double = js.native
    }
    
    @js.native
    trait ScrollViewInstance extends StObject {
      
      def flashScrollIndicators(): Unit = js.native
      
      def scrollTo(target: ObjectOrWritten[ScrollTarget]): Unit = js.native
      
      def scrollToEnd(): Unit = js.native
      def scrollToEnd(options: ObjectOrWritten[ScrollOptions]): Unit = js.native
    }
    
    @js.native
    trait SectionListInstance[T] extends StObject {
      
      def flashScrollIndicators(): Unit = js.native
      
      def recordInteraction(): Unit = js.native
      
      def scrollToEnd(): Unit = js.native
      def scrollToEnd(params: ObjectOrWritten[ScrollToEndParams]): Unit = js.native
      
      def scrollToIndex(params: ObjectOrWritten[ScrollToIndexParams]): Unit = js.native
      
      def scrollToItem(params: ObjectOrWritten[ScrollToItemParams[T]]): Unit = js.native
      
      def scrollToOffset(params: ObjectOrWritten[ScrollToOffsetParams]): Unit = js.native
    }
    
    @js.native
    trait TextInputInstance extends StObject {
      
      def clear(): Unit = js.native
      
      def isFocused(): Boolean = js.native
    }
    
    @js.native
    object useWindowDimensions extends StObject {
      
      def apply(): ScaledSize = js.native
    }
  }
  
  object readwrite {
    
    @js.native
    trait ObjectOrWritten[T] extends StObject
  }
  
  object web {
    
    @js.native
    object ReactDOM extends StObject {
      
      def createPortal(child: ReactElement, container: Element, key: js.UndefOr[String]): ReactElement = js.native
      
      def findDOMNode(instance: Component): Element = js.native
      
      def flushSync[T](callback: js.Function0[T]): T = js.native
      
      def hydrate(component: ReactElement, target: Element): ReactInstance = js.native
      
      def render(component: ReactElement, target: Element): ReactInstance = js.native
      
      def unmountComponentAtNode(container: Element): Unit = js.native
    }
    
    @js.native
    object ReactDOMClient extends StObject {
      
      def createRoot(target: Element): ReactRoot = js.native
      
      def hydrate(component: ReactElement, target: Element): ReactRoot = js.native
    }
    
    @js.native
    object ReactDOMServer extends StObject {
      
      def renderToNodeStream(element: ReactElement): js.Object = js.native
      
      def renderToStaticMarkup(element: ReactElement): String = js.native
      
      def renderToStaticNodeStream(element: ReactElement): js.Object = js.native
      
      def renderToString(element: ReactElement): String = js.native
    }
    
    @js.native
    trait ReactRoot extends StObject {
      
      def render(component: ReactElement): ReactInstance = js.native
      
      def unmount(): Unit = js.native
    }
    
    @js.native
    trait SyntheticAnimationEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, AnimationEvent] {
      
      val animationName: String = js.native
      
      val elapsedTime: Float = js.native
      
      val pseudoElement: String = js.native
    }
    
    @js.native
    trait SyntheticClipboardEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, ClipboardEvent] {
      
      val clipboardData: DataTransfer = js.native
    }
    
    @js.native
    trait SyntheticCompositionEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, CompositionEvent] {
      
      val data: String = js.native
    }
    
    @js.native
    trait SyntheticFocusEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, FocusEvent] {
      
      val relatedTarget: EventTarget = js.native
    }
    
    @js.native
    trait SyntheticInputEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, InputEvent] {
      
      val data: String = js.native
    }
    
    @js.native
    trait SyntheticKeyboardEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, KeyboardEvent] {
      
      val altKey: Boolean = js.native
      
      val charCode: Int = js.native
      
      val ctrlKey: Boolean = js.native
      
      def getModifierState(key: String): Boolean = js.native
      
      val key: String = js.native
      
      val keyCode: Int = js.native
      
      val locale: String = js.native
      
      val location: Int = js.native
      
      val metaKey: Boolean = js.native
      
      val repeat: Boolean = js.native
      
      val shiftKey: Boolean = js.native
      
      val which: Int = js.native
    }
    
    @js.native
    trait SyntheticMouseEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, MouseEvent] {
      
      val altKey: Boolean = js.native
      
      val button: Int = js.native
      
      val buttons: Int = js.native
      
      val clientX: Double = js.native
      
      val clientY: Double = js.native
      
      val ctrlKey: Boolean = js.native
      
      def getModifierState(key: String): Boolean = js.native
      
      val metaKey: Boolean = js.native
      
      val pageX: Double = js.native
      
      val pageY: Double = js.native
      
      val relatedTarget: EventTarget = js.native
      
      val screenX: Double = js.native
      
      val screenY: Double = js.native
      
      val shiftKey: Boolean = js.native
    }
    
    @js.native
    trait SyntheticPointerEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, PointerEvent] {
      
      val height: Double = js.native
      
      val isPrimary: Boolean = js.native
      
      val pointerId: Int = js.native
      
      val pointerType: String = js.native
      
      val pressure: Double = js.native
      
      val tangentialPressure: Double = js.native
      
      val tiltX: Double = js.native
      
      val tiltY: Double = js.native
      
      val twist: Double = js.native
      
      val width: Double = js.native
    }
    
    @js.native
    trait SyntheticTouchEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, TouchEvent] {
      
      val altKey: Boolean = js.native
      
      val changedTouches: TouchList = js.native
      
      val ctrlKey: Boolean = js.native
      
      def getModifierState(key: String): Boolean = js.native
      
      val metaKey: Boolean = js.native
      
      val shiftKey: Boolean = js.native
      
      val targetTouches: TouchList = js.native
      
      val touches: TouchList = js.native
    }
    
    @js.native
    trait SyntheticTransitionEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, TransitionEvent] {
      
      val elapsedTime: Float = js.native
      
      val propertyName: String = js.native
      
      val pseudoElement: String = js.native
    }
    
    @js.native
    trait SyntheticUIEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, UIEvent] {
      
      val detail: Double = js.native
      
      val view: Window = js.native
    }
    
    @js.native
    trait SyntheticWheelEvent[TargetType]
      extends StObject
         with SyntheticEvent[TargetType, WheelEvent] {
      
      val deltaMode: Int = js.native
      
      val deltaX: Double = js.native
      
      val deltaY: Double = js.native
      
      val deltaZ: Double = js.native
    }
    
    object html {
      
      object default {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object a {
        
        object tag {
          
          type RefType = HTMLAnchorElement
        }
      }
      
      object abbr {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object accept {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object action {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object address {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object alt {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object area {
        
        object tag {
          
          type RefType = HTMLAreaElement
        }
      }
      
      object aria {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object article {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object aside {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object async {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object audio {
        
        object tag {
          
          type RefType = HTMLAudioElement
        }
      }
      
      object autoComplete {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object autoFocus {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object b {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object base {
        
        object tag {
          
          type RefType = HTMLBaseElement
        }
      }
      
      object bdi {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object bdo {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object big {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object blockquote {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object body {
        
        object tag {
          
          type RefType = HTMLBodyElement
        }
      }
      
      object br {
        
        object tag {
          
          type RefType = HTMLBRElement
        }
      }
      
      object button {
        
        object tag {
          
          type RefType = HTMLButtonElement
        }
      }
      
      object canvas {
        
        object tag {
          
          type RefType = HTMLCanvasElement
        }
      }
      
      object caption {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object capture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object challenge {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object checked {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object cite {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object className {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object code {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object col {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object colSpan {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object colgroup {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object cols {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object content {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object contentEditable {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object controls {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object coords {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dangerouslySetInnerHTML {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object data {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object datalist {
        
        object tag {
          
          type RefType = HTMLDataListElement
        }
      }
      
      object dd {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object defaultChecked {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object defaultValue {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object defer {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object del {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object details {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object dfn {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object dialog {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object dir {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object disabled {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object div {
        
        object tag {
          
          type RefType = HTMLDivElement
        }
      }
      
      object dl {
        
        object tag {
          
          type RefType = HTMLDListElement
        }
      }
      
      object download {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object draggable {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dt {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object em {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object embed {
        
        object tag {
          
          type RefType = HTMLEmbedElement
        }
      }
      
      object fieldset {
        
        object tag {
          
          type RefType = HTMLFieldSetElement
        }
      }
      
      object figcaption {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object figure {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object footer {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object form {
        
        object tag {
          
          type RefType = HTMLFormElement
        }
      }
      
      object h1 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object h2 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object h3 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object h4 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object h5 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object h6 {
        
        object tag {
          
          type RefType = HTMLHeadingElement
        }
      }
      
      object head {
        
        object tag {
          
          type RefType = HTMLHeadElement
        }
      }
      
      object header {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object headers {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object height {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object hidden {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object high {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object hr {
        
        object tag {
          
          type RefType = HTMLHRElement
        }
      }
      
      object href {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object html {
        
        object tag {
          
          type RefType = HTMLHtmlElement
        }
      }
      
      object htmlFor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object i {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object icon {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object id {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object iframe {
        
        object tag {
          
          type RefType = HTMLIFrameElement
        }
      }
      
      object img {
        
        object tag {
          
          type RefType = HTMLImageElement
        }
      }
      
      object input {
        
        object tag {
          
          type RefType = HTMLInputElement
        }
      }
      
      object ins {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object integrity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object kbd {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object key {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object keygen {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object kind {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object label {
        
        object tag {
          
          type RefType = HTMLLabelElement
        }
      }
      
      object lang {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object legend {
        
        object tag {
          
          type RefType = HTMLLegendElement
        }
      }
      
      object li {
        
        object tag {
          
          type RefType = HTMLLIElement
        }
      }
      
      object link {
        
        object tag {
          
          type RefType = HTMLLinkElement
        }
      }
      
      object list {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object loop {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object low {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object main {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object manifest {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object map {
        
        object tag {
          
          type RefType = HTMLMapElement
        }
      }
      
      object mark {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object max {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object media {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object menu {
        
        object tag {
          
          type RefType = HTMLMenuElement
        }
      }
      
      object menuitem {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object meta {
        
        object tag {
          
          type RefType = HTMLMetaElement
        }
      }
      
      object meter {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object method {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object min {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object multiple {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object muted {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object name {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object nav {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object noValidate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object nonce {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object noscript {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object `object` {
        
        object tag {
          
          type RefType = HTMLObjectElement
        }
      }
      
      object ol {
        
        object tag {
          
          type RefType = HTMLOListElement
        }
      }
      
      object on {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAbort {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAbortCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationEndCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationIteration {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationIterationCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAnimationStartCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onBeforeInput {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onBeforeInputCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onBlur {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onBlurCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlay {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlayCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlayThrough {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlayThroughCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCancel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onClick {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onClickCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onClose {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCloseCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionEndCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionStartCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionUpdate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCompositionUpdateCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onContextMenu {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onContextMenuCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCopy {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCopyCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCut {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCutCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDoubleClick {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDoubleClickCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDrag {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEndCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEnter {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEnterCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragExit {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragLeave {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragOver {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragOverCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragStartCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDrop {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDropCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDurationChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDurationChangeCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEmptied {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEmptiedCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEncrypted {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEncryptedCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEnded {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEndedCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onError {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onErrorCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onFocus {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onFocusCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onGotPointerCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onInput {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onInvalid {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyDown {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyDownCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyPress {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyPressCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyUp {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyUpCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoad {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadStartCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedData {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedDataCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedMetadata {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedMetadataCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLostPointerCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseDown {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseDownCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseEnter {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseLeave {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseMove {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseOut {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseOutCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseOver {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseUp {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseUpCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPaste {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPasteCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPause {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPauseCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlay {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlayCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlaying {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlayingCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerCancel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerCancelCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerDown {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerDownCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerEnter {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerLeave {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerMove {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerOut {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerOutCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerOver {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerUp {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPointerUpCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onProgress {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onProgressCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onRateChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onRateChangeCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onScroll {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onScrollCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeeked {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeekedCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeeking {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeekingCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSelect {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSelectCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onStalled {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onStalledCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSubmit {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSubmitCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSuspend {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSuspendCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTimeUpdate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTimeUpdateCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onToggle {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onToggleCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchCancel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchCancelCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchEndCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchMove {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchMoveCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTouchStartCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTransitionEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onVolumeChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onVolumeChangeCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onWaiting {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onWaitingCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onWheel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onWheelCapture {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object open {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object optgroup {
        
        object tag {
          
          type RefType = HTMLOptGroupElement
        }
      }
      
      object optimum {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object option {
        
        object tag {
          
          type RefType = HTMLOptionElement
        }
      }
      
      object output {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object p {
        
        object tag {
          
          type RefType = HTMLParagraphElement
        }
      }
      
      object param {
        
        object tag {
          
          type RefType = HTMLParamElement
        }
      }
      
      object pattern {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object picture {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object placeholder {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object poster {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pre {
        
        object tag {
          
          type RefType = HTMLPreElement
        }
      }
      
      object preload {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object profile {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object progress {
        
        object tag {
          
          type RefType = HTMLProgressElement
        }
      }
      
      object q {
        
        object tag {
          
          type RefType = HTMLQuoteElement
        }
      }
      
      object readOnly {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object ref {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object required {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object reversed {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object role {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rowSpan {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rows {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rp {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object rt {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object ruby {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object s {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object samp {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object sandbox {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object scope {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object scoped {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object script {
        
        object tag {
          
          type RefType = HTMLScriptElement
        }
      }
      
      object scrolling {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object section {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object select {
        
        object tag {
          
          type RefType = HTMLSelectElement
        }
      }
      
      object selected {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object shape {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object size {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object sizes {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object small {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object source {
        
        object tag {
          
          type RefType = HTMLSourceElement
        }
      }
      
      object span {
        
        object tag {
          
          type RefType = HTMLSpanElement
        }
      }
      
      object spellCheck {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object src {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object start {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object step {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strong {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object style {
        
        object tag {
          
          type RefType = HTMLStyleElement
        }
      }
      
      object sub {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object summary {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object sup {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object suppressContentEditableWarning {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object tabIndex {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object table {
        
        object tag {
          
          type RefType = HTMLTableElement
        }
      }
      
      object target {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object tbody {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object td {
        
        object tag {
          
          type RefType = HTMLTableCellElement
        }
      }
      
      object textarea {
        
        object tag {
          
          type RefType = HTMLTextAreaElement
        }
      }
      
      object tfoot {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object th {
        
        object tag {
          
          type RefType = HTMLTableCellElement
        }
      }
      
      object thead {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object time {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object title {
        
        object tag {
          
          type RefType = HTMLTitleElement
        }
      }
      
      object tr {
        
        object tag {
          
          type RefType = HTMLTableRowElement
        }
      }
      
      object track {
        
        object tag {
          
          type RefType = HTMLTrackElement
        }
      }
      
      object `type` {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object u {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object ul {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object value {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object `var` {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object video {
        
        object tag {
          
          type RefType = HTMLVideoElement
        }
      }
      
      object wbr {
        
        object tag {
          
          type RefType = HTMLElement
        }
      }
      
      object width {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object wrap {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
    }
    
    object svg {
      
      object a {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object accentHeight {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object accumulate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object additive {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object alignmentBaseline {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object alphabetic {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object altGlyph {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object altGlyphDef {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object altGlyphItem {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object amplitude {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object animate {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object animateColor {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object animateMotion {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object animateTransform {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object arabicForm {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object aria {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object ascent {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object attributeName {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object attributeType {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object azimuth {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object baseFrequency {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object baseProfile {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object baselineShift {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object bbox {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object begin {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object bias {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object by {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object calcMode {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object capHeight {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object circle {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object className {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object clip {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object clipPath {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object clipPathUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object clipRule {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object colorInterpolation {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object colorInterpolationFilters {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object colorProfile {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object colorRendering {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object contentScriptType {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object contentStyleType {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object cursor {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object cx {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object cy {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object d {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dangerouslySetInnerHTML {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object defaultChecked {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object defs {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object desc {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object descent {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object diffuseConstant {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object direction {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object display {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object divisor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dominantBaseline {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dur {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dx {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object dy {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object edgeMode {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object elevation {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object ellipse {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object enableBackground {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object end {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object exponent {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object externalResourcesRequired {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object feBlend {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feColorMatrix {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feComponentTransfer {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feComposite {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feConvolveMatrix {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feDiffuseLighting {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feDisplacementMap {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feDistantLight {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feFlood {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feFuncA {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feFuncB {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feFuncG {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feFuncR {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feGaussianBlur {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feImage {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feMerge {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feMergeNode {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feMorphology {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feOffset {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object fePointLight {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feSpecularLighting {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feSpotLight {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feTile {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object feTurbulence {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object fill {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fillOpacity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fillRule {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object filter {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object filterRes {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object filterUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object floodColor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object floodOpacity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object font {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object fontFamily {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontSize {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontSizeAdjust {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontStretch {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontStyle {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontVariant {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fontWeight {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object foreignObject {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object format {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object from {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fx {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object fy {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object g {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object g1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object g2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object glyph {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object glyphName {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object glyphOrientationHorizontal {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object glyphOrientationVertical {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object glyphRef {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object gradientTransform {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object gradientUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object hanging {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object height {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object hkern {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object horizAdvX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object horizOriginX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object id {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object ideographic {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object image {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object imageRendering {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object in {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object in2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object intercept {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object k {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object k1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object k2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object k3 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object k4 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object kernelMatrix {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object kernelUnitLength {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object kerning {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object key {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object keyPoints {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object keySplines {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object keyTimes {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object lang {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object lengthAdjust {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object letterSpacing {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object lightingColor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object limitingConeAngle {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object line {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object linearGradient {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object local {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object marker {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object markerEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object markerHeight {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object markerMid {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object markerStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object markerUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object markerWidth {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object mask {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object maskContentUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object maskUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object mathematical {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object max {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object media {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object metadata {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object method {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object min {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object mode {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object mpath {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object name {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object numOctaves {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object offset {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAbort {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAutoComplete {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onAutoCompleteError {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onBlur {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlay {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCanPlayThrough {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCancel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onClick {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onClose {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onContextMenu {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onCueChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDoubleClick {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDrag {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEnd {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragEnter {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragExit {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragLeave {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragOver {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDragStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDrop {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onDurationChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEmptied {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onEnded {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onError {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onFocus {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onInput {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onInvalid {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyDown {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyPress {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onKeyUp {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoad {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadStart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedData {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onLoadedMetadata {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseDown {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseEnter {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseLeave {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseMove {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseOut {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseOver {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseUp {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onMouseWheel {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPause {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlay {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onPlaying {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onProgress {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onRateChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onReset {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onResize {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onScroll {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeeked {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSeeking {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSelect {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onShow {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSort {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onStalled {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSubmit {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onSuspend {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onTimeUpdate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onToggle {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onVolumeChange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object onWaiting {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object opacity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object operator {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object order {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object orient {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object orientation {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object origin {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object overflow {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object overlinePosition {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object overlineThickness {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object panose1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object path {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object pathLength {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pattern {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object patternContentUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object patternTransform {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object patternUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pointerEvents {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object points {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pointsAtX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pointsAtY {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object pointsAtZ {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object polygon {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object polyline {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object preserveAlpha {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object preserveAspectRatio {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object primitiveUnits {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object r {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object radialGradient {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object radius {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rect {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object ref {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object refX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object refY {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object renderingIntent {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object repeatCount {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object repeatDur {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object requiredExtensions {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object requiredFeatures {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object restart {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object result {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object role {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rotate {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object rx {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object ry {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object scale {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object script {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object seed {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object set {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object shapeRendering {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object slope {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object spacing {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object specularConstant {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object specularExponent {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object spreadMethod {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object startOffset {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stdDeviation {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stemh {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stemv {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stitchTiles {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stop {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object stopColor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stopOpacity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strikethroughPosition {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strikethroughThickness {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object string {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object stroke {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeDasharray {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeDashoffset {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeLinecap {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeLinejoin {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeMiterlimit {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeOpacity {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object strokeWidth {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object style {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object suppressContentEditableWarning {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object surfaceScale {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object svg {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object switch {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object symbol {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object systemLanguage {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object tableValues {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object target {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object targetX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object targetY {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object text {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object textAnchor {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object textDecoration {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object textLength {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object textPath {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object textRendering {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object title {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object to {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object transform {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object tref {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object tspan {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object `type` {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object u1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object u2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object underlinePosition {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object underlineThickness {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object unicode {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object unicodeBidi {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object unicodeRange {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object unitsPerEm {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object use {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object vAlphabetic {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vHanging {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vIdeographic {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vMathematical {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object values {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object version {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vertAdvY {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vertOriginX {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vertOriginY {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object view {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object viewBox {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object viewTarget {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object visibility {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object vkern {
        
        object tag {
          
          type RefType = Element
        }
      }
      
      object width {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object widths {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object wordSpacing {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object writingMode {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object x {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object x1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object x2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object xChannelSelector {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object xHeight {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object y {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object y1 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object y2 {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object yChannelSelector {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object z {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
      
      object zoomAndPan {
        
        object tag {
          
          type RefType = scala.Nothing
        }
      }
    }
  }
}
