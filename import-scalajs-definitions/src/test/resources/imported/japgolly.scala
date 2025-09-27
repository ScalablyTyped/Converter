package imported

import japgolly.scalajs.react.component.Scala.MountedImpure
import japgolly.scalajs.react.component.Scala.MountedPure
import japgolly.scalajs.react.facade.Hooks.HookDeps
import japgolly.scalajs.react.facade.Hooks.UseEffectArg
import japgolly.scalajs.react.facade.Hooks.UseReducer
import japgolly.scalajs.react.facade.Hooks.UseReducerDispatch
import japgolly.scalajs.react.facade.Hooks.UseState
import japgolly.scalajs.react.facade.Hooks.UseStateSetter
import japgolly.scalajs.react.facade.React.Children.MapFn
import japgolly.scalajs.react.facade.React.Component
import japgolly.scalajs.react.facade.React.Component.Props
import japgolly.scalajs.react.facade.React.Component.State
import japgolly.scalajs.react.facade.React.ComponentElement
import japgolly.scalajs.react.facade.React.ComponentUntyped
import japgolly.scalajs.react.facade.React.Context
import japgolly.scalajs.react.facade.React.DomElement
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.ForwardRefComponent
import japgolly.scalajs.react.facade.React.Key
import japgolly.scalajs.react.facade.React.Lazy
import japgolly.scalajs.react.facade.React.LazyResult
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.facade.React.RefFn
import japgolly.scalajs.react.facade.React.RefHandle
import japgolly.scalajs.react.facade.ReactDOM.Container
import japgolly.scalajs.react.facade.ReactDOM.DomNode
import japgolly.scalajs.react.internal.Box
import org.scalajs.dom.CompositionEvent
import org.scalajs.dom.DataTransfer
import org.scalajs.dom.Document
import org.scalajs.dom.DragEvent
import org.scalajs.dom.Event
import org.scalajs.dom.EventTarget
import org.scalajs.dom.FocusEvent
import org.scalajs.dom.KeyboardEvent
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.PointerEvent
import org.scalajs.dom.Text
import org.scalajs.dom.TouchEvent
import org.scalajs.dom.TouchList
import org.scalajs.dom.UIEvent
import org.scalajs.dom.WheelEvent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object japgolly {
  
  object scalajs {
    
    object react {
      
      object ScalaComponent {
        
        type RawMounted[P, S, B] = japgolly.scalajs.react.component.Scala.RawMounted[P, S, B]
        
        type Vars[P, S, B] = japgolly.scalajs.react.component.Scala.Vars[P, S, B]
      }
      
      object callback {
        
        object Timer {
          
          object RealTimer {
            
            type Handle = js.timers.SetTimeoutHandle
          }
        }
      }
      
      object component {
        
        object Js {
          
          type RawMounted[P, S] = Component[P, S]
        }
        
        object JsFn {
          
          type Mounted = Unit
          
          type UnusedObject = Box[Unit]
        }
        
        object JsForwardRef {
          
          type Mounted = Unit
        }
        
        object Scala {
          
          type RawMounted[P, S, B] = (japgolly.scalajs.react.component.Js.RawMounted[Box[P], Box[S]]) with (Vars[P, S, B])
          
          @js.native
          trait Vars[P, S, B] extends StObject {
            
            var backend: B = js.native
            
            var mountedImpure: MountedImpure[P, S, B] = js.native
            
            var mountedPure: MountedPure[P, S, B] = js.native
          }
        }
        
        object ScalaFn {
          
          type Mounted = japgolly.scalajs.react.component.JsFn.Mounted
        }
        
        object ScalaForwardRef {
          
          type Mounted = japgolly.scalajs.react.component.JsForwardRef.Mounted
        }
        
        object builder {
          
          object Lifecycle {
            
            type NoSnapshot = japgolly.scalajs.react.component.builder.LifecycleF.NoSnapshot
          }
          
          object LifecycleF {
            
            type NoSnapshot = Unit
          }
          
          object ViaReactComponent {
            
            @js.native
            trait Method
              extends StObject
                 with js.PropertyDescriptor {
              
              val key: String = js.native
            }
            
            type SetPrototypeOf = js.Function2[js.Object, js.Object, Unit]
          }
        }
      }
      
      object facade {
        
        type ChildrenArray[A] = A | js.Array[A]
        
        type Empty = Void | Null | Boolean
        
        @js.native
        trait HasDisplayName extends StObject {
          
          val displayName: js.UndefOr[String] = js.native
        }
        
        @js.native
        trait Hooks extends StObject {
          
          type HookDeps = js.UndefOr[js.Array[_]] | Null
          
          type UseEffectArg = js.Function0[js.UndefOr[js.Function0[Any]]]
          
          type UseReducer[S, A] = js.Tuple2[S, UseReducerDispatch[A]]
          
          type UseReducerDispatch[A] = js.Function1[A, Unit]
          
          type UseState[S] = js.Tuple2[S, UseStateSetter[S]]
          
          type UseStateSetter[S] = js.Function1[S | (js.Function1[S, S]), Unit]
          
          def useCallback[F](callback: F, deps: js.UndefOr[HookDeps]): F = js.native
          
          def useContext[A](ctx: Context[A]): A = js.native
          
          def useDebugValue(desc: Any): Unit = js.native
          def useDebugValue[A](value: A, desc: A => Any): Unit = js.native
          
          def useEffect(effect: UseEffectArg, deps: js.UndefOr[HookDeps]): Unit = js.native
          
          def useImperativeHandle[A](
            ref: (RefHandle[A | Null]) | (A | Null => Any) | Null | Unit,
            create: js.Function0[A],
            deps: js.UndefOr[HookDeps]
          ): Unit = js.native
          
          def useLayoutEffect(effect: js.Function0[js.UndefOr[js.Function0[Any]]], deps: js.UndefOr[HookDeps]): Unit = js.native
          
          def useMemo[A](f: js.Function0[A], deps: js.UndefOr[HookDeps]): A = js.native
          
          def useReducer[S, A](reducer: js.Function2[S, A, S], initialState: S): UseReducer[S, A] = js.native
          def useReducer[I, S, A](reducer: js.Function2[S, A, S], initialArg: I, init: js.Function1[I, S]): UseReducer[S, A] = js.native
          
          def useRef[A](f: A): RefHandle[A] = js.native
          
          def useState[S](initial: S | js.Function0[S]): UseState[S] = js.native
        }
        
        @js.native
        trait Interaction extends StObject {
          
          val __count: Int = js.native
          
          val id: Int = js.native
          
          val name: String = js.native
          
          val timestamp: Double = js.native
        }
        
        type JsNumber = Byte | Short | Int | Float | Double
        
        object Profiler {
          
          type OnRender = js.Function7[String, String, Double, Double, Double, Double, js.Set[Interaction], Unit]
        }
        
        type PropsChildren = Node
        
        @js.native
        trait PropsWithChildren extends StObject {
          
          val children: PropsChildren = js.native
        }
        
        @js.native
        trait React
          extends StObject
             with Hooks {
          
          val Children: japgolly.scalajs.react.facade.React.Children = js.native
          
          val Fragment: js.Symbol = js.native
          
          val Profiler: js.Symbol = js.native
          
          val SecretInternals: japgolly.scalajs.react.facade.SecretInternals = js.native
          
          val StrictMode: js.Symbol = js.native
          
          def cloneElement(element: DomElement): DomElement = js.native
          def cloneElement(element: DomElement, props: js.Object): DomElement = js.native
          def cloneElement(element: DomElement, props: js.Object, children: Node): DomElement = js.native
          def cloneElement[P](element: ComponentElement[P]): ComponentElement[P] = js.native
          def cloneElement[P](element: ComponentElement[P], props: P): ComponentElement[P] = js.native
          def cloneElement[P](element: ComponentElement[P], props: P, children: Node): ComponentElement[P] = js.native
          
          def createContext[A](defaultValue: A): Context[A] = js.native
          
          def createElement(s: this.type.type, props: SuspenseProps, children: Node): Element = js.native
          def createElement(`type`: String): DomElement = js.native
          def createElement(`type`: String, props: js.Object): DomElement = js.native
          def createElement(`type`: String, props: js.Object, children: Node): DomElement = js.native
          def createElement(`type`: js.Symbol, props: js.Object, children: Node): Element = js.native
          def createElement[A](contextConsumer: ComponentClass[Null, Null], props: Null, childrenFn: js.Function1[A, Node]): Element = js.native
          def createElement[P](l: Lazy[P], props: P, children: Node): Element = js.native
          def createElement[P](`type`: ComponentType[P]): ComponentElement[P] = js.native
          def createElement[P](`type`: ComponentType[P], props: P): ComponentElement[P] = js.native
          def createElement[P](`type`: ComponentType[P], props: P, children: Node): ComponentElement[P] = js.native
          
          def createRef[A](): RefHandle[A] = js.native
          
          def forwardRef[P, R](f: js.Function2[P with PropsWithChildren, ForwardedRef[R], Node]): ForwardRefComponent[P, R] = js.native
          
          def `lazy`[P](f: js.Function0[js.Promise[LazyResult[P]]]): Lazy[P] = js.native
          
          def memo[P, A](f: js.Function1[P, A], areEqual: js.Function2[P, P, Boolean]): js.Object = js.native
          
          val version: String = js.native
        }
        @js.native
        object React extends StObject {
          
          @js.native
          trait Children extends StObject {
            
            type MapFn[A] = (js.Function1[Node, A]) | (js.Function2[Node, Int, A])
            
            def count(c: PropsChildren): Int = js.native
            
            def forEach(c: js.UndefOr[PropsChildren | Null], fn: MapFn[Any]): Unit = js.native
            
            def map[A](c: js.UndefOr[PropsChildren | Null], fn: MapFn[A]): js.UndefOr[Null | js.Array[A]] = js.native
            
            def only(c: PropsChildren): Node = js.native
            
            def toArray(c: PropsChildren): js.Array[Node] = js.native
          }
          
          @js.native
          class Component[P, S] protected () extends StObject {
            def this(ctorProps: P) = this()
            
            type Props = P with PropsWithChildren
            
            type State = S
            
            def componentDidCatch(error: Error, info: ErrorInfo): Unit = js.native
            
            def componentDidMount(): Unit = js.native
            
            def componentDidUpdate(prevProps: Props, prevState: State): Unit = js.native
            
            def componentWillMount(): Unit = js.native
            
            def componentWillReceiveProps(nextProps: Props): Unit = js.native
            
            def componentWillUnmount(): Unit = js.native
            
            def componentWillUpdate(nextProps: Props, nextState: State): Unit = js.native
            
            val constructor: Constructor[P] = js.native
            
            val ctorProps: P = js.native
            
            def forceUpdate(callback: js.Function0[Any]): Unit = js.native
            
            def modState(updateFn: js.Function2[State, Props, State | Null], callback: js.Function0[Any]): Unit = js.native
            
            def props(): Props = js.native
            
            def render(): Node = js.native
            
            def setState(partialState: State | Null, callback: js.Function0[Any]): Unit = js.native
            
            def shouldComponentUpdate(nextProps: Props, nextState: State): Boolean = js.native
            
            var state: State = js.native
          }
          
          type ComponentClass[P, S] = (js.Function1[P, Component[P, S]]) with HasDisplayName
          
          type ComponentClassP[P] = (js.Function1[P, Component[P, _]]) with HasDisplayName
          
          type ComponentClassUntyped = (js.Function1[_, Component[_, _]]) with HasDisplayName
          
          @js.native
          trait ComponentElement[P]
            extends StObject
               with Element {
            
            def props(): P with PropsWithChildren = js.native
            
            def `type`(): Constructor[P] = js.native
          }
          
          type ComponentType[Props] = ((js.Function1[Props, Component[Props, _]]) with HasDisplayName) | (ForwardRefComponent[Props, _]) | StatelessFunctionalComponent[Props]
          
          type ComponentUntyped = Component[_, _]
          
          type Constructor[P] = (js.Function1[P, js.Any]) with HasDisplayName
          
          @js.native
          trait Context[A] extends StObject {
            
            val Consumer: ComponentClass[Null, Null] = js.native
            
            val Provider: ComponentClass[ValueProps[A], Null] = js.native
            
            var displayName: js.UndefOr[String] = js.native
          }
          
          @js.native
          trait DomElement
            extends StObject
               with Element {
            
            def props(): PropsWithChildren = js.native
            
            def `type`(): String = js.native
          }
          
          @js.native
          trait Element extends StObject {
            
            def key(): Key | Null = js.native
            
            def ref(): Ref | Null = js.native
          }
          
          @js.native
          trait ElementRef
            extends StObject
               with js.Any
          
          @js.native
          trait ErrorInfo extends StObject {
            
            val componentStack: String = js.native
          }
          
          @js.native
          trait ForwardRefComponent[P, R] extends StObject {
            
            var displayName: js.UndefOr[String] = js.native
            
            def props(): P with PropsWithChildren = js.native
            
            val render: js.Function2[P, ForwardedRef[R], Node] = js.native
          }
          
          type ForwardedRef[A] = (RefHandle[A | Null]) | Null
          
          @js.native
          trait Lazy[P] extends StObject
          
          @js.native
          trait LazyResult[P] extends StObject {
            
            val default: LazyResultValue[P] = js.native
          }
          
          type LazyResultValue[P] = ComponentType[P]
          
          type Node = ChildrenArray[Empty | String | JsNumber | Element]
          
          type Ref = RefFn[ElementRef] | RefHandle[Any]
          
          type RefFn[A] = js.Function1[A | Null, Unit]
          
          @js.native
          trait RefHandle[A] extends StObject {
            
            var current: A = js.native
          }
          
          type StatelessFunctionalComponent[Props] = js.Function1[Props, Node]
          
          @js.native
          trait ValueProps[A] extends StObject {
            
            val value: A = js.native
          }
        }
        
        @js.native
        trait ReactDOM extends StObject {
          
          type Container = org.scalajs.dom.Element | Document
          
          type DomNode = org.scalajs.dom.Element | Text
          
          def createPortal(child: Node, container: Container): Node = js.native
          
          def findDOMNode(componentOrElement: org.scalajs.dom.Element | ComponentUntyped): DomNode | Null = js.native
          
          def flushSync[R](f: js.Function0[R]): R = js.native
          def flushSync[A, R](f: js.Function1[A, R], a: A): R = js.native
          
          def hydrate(element: Node, container: Container, callback: js.Function0[Any]): ComponentUntyped = js.native
          
          def render(element: Node, container: Container, callback: js.Function0[Any]): ComponentUntyped = js.native
          
          def unmountComponentAtNode(container: org.scalajs.dom.Node): Boolean = js.native
          
          val version: String = js.native
        }
        
        @js.native
        trait ReactDOMServer extends StObject {
          
          def renderToStaticMarkup(e: Node): String = js.native
          
          def renderToString(e: Node): String = js.native
          
          val version: String = js.native
        }
        
        object RecursiveTypeAliases {
          
          type ChildrenArray[A] = js.Array[japgolly.scalajs.react.facade.ChildrenArray[A]]
        }
        
        @js.native
        trait SchedulerTracing extends StObject {
          
          def unstable_trace[A](name: String, timestamp: Double, callback: js.Function0[A]): A = js.native
        }
        
        @js.native
        trait SecretInternals extends StObject {
          
          val SchedulerTracing: japgolly.scalajs.react.facade.SchedulerTracing = js.native
        }
        
        @js.native
        trait SuspenseProps extends StObject {
          
          var fallback: Node = js.native
        }
        
        @js.native
        trait SyntheticAnimationEvent[DOMEventTarget]
          extends StObject
             with SyntheticEvent[DOMEventTarget] {
          
          val animationName: String = js.native
          
          val elapsedTime: Double = js.native
          
          val pseudoElement: String = js.native
        }
        
        @js.native
        trait SyntheticClipboardEvent[DOMEventTarget]
          extends StObject
             with SyntheticEvent[DOMEventTarget] {
          
          def clipboardData(): DataTransfer = js.native
        }
        
        @js.native
        trait SyntheticCompositionEvent[DOMEventTarget]
          extends StObject
             with SyntheticEvent[DOMEventTarget] {
          
          val data: String = js.native
          
          override val nativeEvent: CompositionEvent = js.native
        }
        
        @js.native
        trait SyntheticDragEvent[DOMEventTarget]
          extends StObject
             with SyntheticMouseEvent[DOMEventTarget] {
          
          val dataTransfer: DataTransfer = js.native
          
          override val nativeEvent: DragEvent = js.native
        }
        
        @js.native
        trait SyntheticEvent[DOMEventTarget] extends StObject {
          
          val bubbles: Boolean = js.native
          
          val cancelable: Boolean = js.native
          
          val currentTarget: DOMEventTarget = js.native
          
          def defaultPrevented(): Boolean = js.native
          
          val eventPhase: Double = js.native
          
          val eventType: String = js.native
          
          def isDefaultPrevented(): Boolean = js.native
          
          def isPersistent(): Boolean = js.native
          
          def isPropagationStopped(): Boolean = js.native
          
          val isTrusted: Boolean = js.native
          
          val nativeEvent: Event = js.native
          
          def persist(): Unit = js.native
          
          def preventDefault(): Unit = js.native
          
          def stopPropagation(): Unit = js.native
          
          val target: DOMEventTarget = js.native
          
          val timeStamp: Double = js.native
        }
        
        @js.native
        trait SyntheticFocusEvent[DOMEventTarget]
          extends StObject
             with SyntheticUIEvent[DOMEventTarget] {
          
          override val nativeEvent: FocusEvent = js.native
          
          val relatedTarget: EventTarget = js.native
        }
        
        @js.native
        trait SyntheticFormEvent[DOMEventTarget]
          extends StObject
             with SyntheticUIEvent[DOMEventTarget]
        
        @js.native
        trait SyntheticKeyboardEvent[DOMEventTarget]
          extends StObject
             with SyntheticUIEvent[DOMEventTarget] {
          
          val altKey: Boolean = js.native
          
          val charCode: Int = js.native
          
          val code: String = js.native
          
          val ctrlKey: Boolean = js.native
          
          def getModifierState(keyArg: String): Boolean = js.native
          
          val key: String = js.native
          
          val keyCode: Int = js.native
          
          val locale: String = js.native
          
          val location: Double = js.native
          
          val metaKey: Boolean = js.native
          
          override val nativeEvent: KeyboardEvent = js.native
          
          val repeat: Boolean = js.native
          
          val shiftKey: Boolean = js.native
          
          val which: Int = js.native
        }
        
        @js.native
        trait SyntheticMouseEvent[DOMEventTarget]
          extends StObject
             with SyntheticUIEvent[DOMEventTarget] {
          
          val altKey: Boolean = js.native
          
          val button: Int = js.native
          
          val buttons: Int = js.native
          
          val clientX: Double = js.native
          
          val clientY: Double = js.native
          
          val ctrlKey: Boolean = js.native
          
          def getModifierState(keyArg: String): Boolean = js.native
          
          val metaKey: Boolean = js.native
          
          val movementX: Long = js.native
          
          val movementY: Long = js.native
          
          override val nativeEvent: MouseEvent = js.native
          
          val pageX: Double = js.native
          
          val pageY: Double = js.native
          
          val relatedTarget: EventTarget = js.native
          
          val screenX: Double = js.native
          
          val screenY: Double = js.native
          
          val shiftKey: Boolean = js.native
        }
        
        @js.native
        trait SyntheticPointerEvent[DOMEventTarget]
          extends StObject
             with SyntheticMouseEvent[DOMEventTarget] {
          
          val height: Double = js.native
          
          val isPrimary: Boolean = js.native
          
          override val nativeEvent: PointerEvent = js.native
          
          val pointerId: Double = js.native
          
          val pointerType: String = js.native
          
          val pressure: Double = js.native
          
          val tangentialPressure: Double = js.native
          
          val tiltX: Double = js.native
          
          val tiltY: Double = js.native
          
          val twist: Int = js.native
          
          val width: Double = js.native
        }
        
        @js.native
        trait SyntheticTouchEvent[DOMEventTarget]
          extends StObject
             with SyntheticUIEvent[DOMEventTarget] {
          
          val altKey: Boolean = js.native
          
          val changedTouches: TouchList = js.native
          
          val ctrlKey: Boolean = js.native
          
          def getModifierState(keyArg: String): Boolean = js.native
          
          val metaKey: Boolean = js.native
          
          override val nativeEvent: TouchEvent = js.native
          
          val shiftKey: Boolean = js.native
          
          val targetTouches: TouchList = js.native
          
          val touches: TouchList = js.native
        }
        
        @js.native
        trait SyntheticTransitionEvent[DOMEventTarget]
          extends StObject
             with SyntheticEvent[DOMEventTarget] {
          
          val elapsedTime: Double = js.native
          
          val propertyName: String = js.native
          
          val pseudoElement: String = js.native
        }
        
        @js.native
        trait SyntheticUIEvent[DOMEventTarget]
          extends StObject
             with SyntheticEvent[DOMEventTarget] {
          
          def detail(): Double = js.native
          
          override val nativeEvent: UIEvent = js.native
          
          val view: js.Object = js.native
        }
        
        @js.native
        trait SyntheticWheelEvent[DOMEventTarget]
          extends StObject
             with SyntheticMouseEvent[DOMEventTarget] {
          
          val deltaMode: Double = js.native
          
          val deltaX: Double = js.native
          
          val deltaY: Double = js.native
          
          val deltaZ: Double = js.native
          
          override val nativeEvent: WheelEvent = js.native
        }
        
        type Void = Unit
        
        @js.native
        object performance extends StObject {
          
          def now(): Double = js.native
        }
      }
      
      object internal {
        
        @js.native
        trait Box[A] extends StObject {
          
          val unbox: A = js.native
        }
      }
      
      object util {
        
        object ConsoleHijack {
          
          object Internals {
            
            @js.native
            trait JsVarargsFn
              extends StObject
                 with js.Function {
              
              def apply(args: Any): Unit = js.native
            }
            
            type VsprintfFn = js.Function2[String, js.Array[Any], String]
          }
        }
        
        object Effect {
          
          object Sync {
            
            type Untyped[A] = js.Function0[A]
          }
        }
      }
      
      object vdom {
        
        object Attr {
          
          type EventHandler[E] = js.Function0[Unit] | (js.Function1[E[scala.Nothing], Unit])
        }
        
        type HtmlTopNode = org.scalajs.dom.html.Element
        
        type SvgTopNode = org.scalajs.dom.svg.Element
        
        type TopNode = org.scalajs.dom.Node
        
        object VdomBuilder {
          
          type RawChild = Node
          
          type RawRefFn[A] = RefFn[A]
        }
      }
    }
  }
}
