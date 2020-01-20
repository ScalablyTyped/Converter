package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import org.scalablytyped.runtime.Instantiable1
  import org.scalablytyped.runtime.Instantiable2
  import org.scalajs.dom.raw.Element
  import org.scalajs.dom.raw.Event
  import org.scalajs.dom.raw.EventTarget
  import org.scalajs.dom.raw.HTMLElement
  import slinky.core.ReactComponentClass
  import slinky.core.TagMod
  import slinky.core.facade.ReactRef
  import slinky.web.SyntheticAnimationEvent
  import slinky.web.SyntheticClipboardEvent
  import slinky.web.SyntheticCompositionEvent
  import slinky.web.SyntheticFocusEvent
  import slinky.web.SyntheticKeyboardEvent
  import slinky.web.SyntheticMouseEvent
  import slinky.web.SyntheticPointerEvent
  import slinky.web.SyntheticTouchEvent
  import slinky.web.SyntheticTransitionEvent
  import slinky.web.SyntheticUIEvent
  import slinky.web.SyntheticWheelEvent
  import typingsSlinky.react.AnonChildren
  import typingsSlinky.react.AnonRefAny
  import typingsSlinky.react.AnonResult
  import typingsSlinky.react.AnonType
  import typingsSlinky.react.reactStrings.mount
  import typingsSlinky.react.reactStrings.update
  import typingsSlinky.std.Partial
  import typingsSlinky.std.Pick

  type AnimationEventHandler[T] = EventHandler[SyntheticAnimationEvent[T]]
  // tslint:disable-next-line:no-empty-interface
  type AudioHTMLAttributes[T] = MediaHTMLAttributes[T]
  type CElement[P, T /* <: ReactComponentClass[P] */] = ComponentElement[P, T]
  type CFactory[P, T /* <: ReactComponentClass[P] */] = ComponentFactory[P, T]
  type CSSProperties = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify CSS.Properties<string | number> */ js.Any
  type ChangeEventHandler[T] = EventHandler[ChangeEvent[T]]
  /**
    * We use an intersection type to infer multiple type parameters from
    * a single argument, which is useful for many top-level API defs.
    * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
    */
  type ClassType[P, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */] = C with (Instantiable2[/* props */ P, js.UndefOr[/* context */ js.Any], T])
  type ClassicElement[P] = CElement[P, ReactComponentClass[P]]
  type ClassicFactory[P] = CFactory[P, ReactComponentClass[P]]
  type ClipboardEventHandler[T] = EventHandler[SyntheticClipboardEvent[T]]
  type ComponentFactory[P, T /* <: ReactComponentClass[P] */] = js.Function2[
    /* props */ js.UndefOr[ClassAttributes[T] with P], 
    /* repeated */ TagMod[Any], 
    CElement[P, T]
  ]
  /**
    * NOTE: prefer ComponentPropsWithRef, if the ref is forwarded,
    * or ComponentPropsWithoutRef when refs are not supported.
    */
  type ComponentProps[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */] = js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)
  type ComponentPropsWithRef[T /* <: slinky.core.facade.ReactElement */] = PropsWithRef[ComponentProps[T]] | (PropsWithoutRef[_] with (RefAttributes[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
  ]))
  type ComponentPropsWithoutRef[T /* <: slinky.core.facade.ReactElement */] = PropsWithoutRef[ComponentProps[T]]
  type ComponentState = js.Any
  type ComponentType[P] = ReactComponentClass[P] | ReactComponentClass[P]
  type CompositionEventHandler[T] = EventHandler[SyntheticCompositionEvent[T]]
  type Consumer[T] = ReactComponentClass[ConsumerProps[T]]
  type ContextType[C /* <: Context[_] */] = js.Any
  type DOMFactory[P /* <: DOMAttributes[T] */, T /* <: Element */] = js.Function2[
    /* props */ js.UndefOr[(ClassAttributes[T] with P) | Null], 
    /* repeated */ TagMod[Any], 
    slinky.core.facade.ReactElement
  ]
  // Any prop that has a default prop becomes optional, but its type is unchanged
  // Undeclared default props are augmented into the resulting allowable attributes
  // If declared props have indexed properties, ignore default props entirely as keyof gets widened
  // Wrap in an outer-level conditional type to allow distribution over props that are unions
  type Defaultize[P, D] = ((Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof D> */ _
  ]) with (Partial[
    Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ _
    ]
  ]) with (Partial[
    Pick[
      D, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof D, keyof P> */ _
    ]
  ])) | P
  // The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
  // TODO (TypeScript 3.0): ReadonlyArray<unknown>
  type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ js.Any
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  // this technically does accept a second argument, but it's already under a deprecation warning
  // and it's not even released so probably better to not define it.
  type Dispatch[A] = js.Function1[/* value */ A, Unit]
  type DragEventHandler[T] = EventHandler[DragEvent[T]]
  // NOTE: callbacks are _only_ allowed to return either void, or a destructor.
  // The destructor is itself only allowed to return void.
  type EffectCallback = js.Function0[Unit | js.Function0[js.UndefOr[Unit]]]
  //
  // React Elements
  // ----------------------------------------------------------------------
  type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view' ]: P extends react.react._Global_.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view'] */ js.Any) | ReactComponentClass[P]
  //
  // Event Handler Types
  // ----------------------------------------------------------------------
  type EventHandler[E /* <: slinky.core.SyntheticEvent[Event, _] */] = js.Function1[/* event */ E, Unit]
  type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any
  type FC[P] = ReactComponentClass[P]
  //
  // Factories
  // ----------------------------------------------------------------------
  type Factory[P] = js.Function2[
    /* props */ js.UndefOr[Attributes with P], 
    /* repeated */ TagMod[Any], 
    slinky.core.facade.ReactElement
  ]
  type FocusEventHandler[T] = EventHandler[SyntheticFocusEvent[T]]
  // tslint:disable-next-line:no-empty-interface
  type FormEvent[T] = slinky.core.SyntheticEvent[Event, T]
  type FormEventHandler[T] = EventHandler[slinky.core.SyntheticEvent[EventTarget with T, Event]]
  type FunctionComponentFactory[P] = js.Function2[
    /* props */ js.UndefOr[Attributes with P], 
    /* repeated */ TagMod[Any], 
    FunctionComponentElement[P]
  ]
  type GetDerivedStateFromError[P, S] = /**
    * This lifecycle is invoked after an error has been thrown by a descendant component.
    * It receives the error that was thrown as a parameter and should return a value to update state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function1[/* error */ js.Any, Partial[S] | Null]
  type GetDerivedStateFromProps[P, S] = /**
    * Returns an update to a component's state based on its new props and old state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function2[/* nextProps */ P, /* prevState */ S, Partial[S] | Null]
  // tslint:disable-next-line:no-empty-interface
  type HTMLFactory[T /* <: HTMLElement */] = DetailedHTMLFactory[AllHTMLAttributes[T], T]
  type JSXElementConstructor[P] = (js.Function1[/* props */ P, slinky.core.facade.ReactElement | Null]) | (Instantiable1[/* props */ P, ReactComponentClass[P]])
  type Key = String | Double
  type KeyboardEventHandler[T] = EventHandler[SyntheticKeyboardEvent[T]]
  type LazyExoticComponent[T /* <: ReactComponentClass[_] */] = ReactComponentClass[ComponentPropsWithRef[T]] with AnonResult[T]
  type LegacyRef[T] = String | Ref[T]
  // will show `Memo(${Component.displayName || Component.name})` in devtools by default,
  // but can be given its own specific name
  type MemoExoticComponent[T /* <: ReactComponentClass[_] */] = ReactComponentClass[ComponentPropsWithRef[T]] with AnonType[T]
  // Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
  type MergePropTypes[P, T] = ((Pick[P, NotExactlyAnyPropertyKeys[P]]) with (Pick[
    T, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof T, NotExactlyAnyPropertyKeys<P>> */ _
  ]) with (Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof T> */ _
  ])) | P | T
  type MouseEventHandler[T] = EventHandler[SyntheticMouseEvent[T]]
  type NativeAnimationEvent = org.scalajs.dom.raw.AnimationEvent
  type NativeClipboardEvent = org.scalajs.dom.raw.ClipboardEvent
  type NativeCompositionEvent = org.scalajs.dom.raw.CompositionEvent
  type NativeDragEvent = org.scalajs.dom.raw.DragEvent
  type NativeFocusEvent = org.scalajs.dom.raw.FocusEvent
  type NativeKeyboardEvent = org.scalajs.dom.raw.KeyboardEvent
  type NativeMouseEvent = org.scalajs.dom.raw.MouseEvent
  type NativePointerEvent = org.scalajs.dom.raw.PointerEvent
  type NativeTouchEvent = org.scalajs.dom.raw.TouchEvent
  type NativeTransitionEvent = org.scalajs.dom.raw.TransitionEvent
  type NativeUIEvent = org.scalajs.dom.raw.UIEvent
  type NativeWheelEvent = org.scalajs.dom.raw.WheelEvent
  type NotExactlyAnyPropertyKeys[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof T, ExactlyAnyPropertyKeys<T>> */ js.Any
  type PointerEventHandler[T] = EventHandler[SyntheticPointerEvent[T]]
  /**
    * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
    */
  type ProfilerOnRenderCallback = js.Function7[
    /* id */ String, 
    /* phase */ mount | update, 
    /* actualDuration */ Double, 
    /* baseDuration */ Double, 
    /* startTime */ Double, 
    /* commitTime */ Double, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any, 
    Unit
  ]
  type PropsWithChildren[P] = P with AnonChildren
  /** Ensures that the props do not include string ref, which cannot be forwarded */
  type PropsWithRef[P] = P | (PropsWithoutRef[P] with AnonRefAny)
  /** Ensures that the props do not include ref at all */
  type PropsWithoutRef[P] = P | (Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, 'ref'> */ js.Any
  ])
  // NOTE: only the Context object itself can get a displayName
  // https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
  type Provider[T] = ReactComponentClass[ProviderProps[T]]
  type ReactChild = slinky.core.facade.ReactElement | ReactText
  type ReactComponentElement[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */, P] = slinky.core.facade.ReactElement
  type ReactEventHandler[T] = EventHandler[slinky.core.SyntheticEvent[Event, T]]
  type ReactFragment = js.Object | ReactNodeArray
  // ReactHTML for ReactHTMLElement
  // tslint:disable-next-line:no-empty-interface
  type ReactHTMLElement[T /* <: HTMLElement */] = DetailedReactHTMLElement[AllHTMLAttributes[T], T]
  //
  // Component API
  // ----------------------------------------------------------------------
  type ReactInstance = ReactComponentClass[js.Any] | Element
  type ReactManagedAttributes[C, P] = P | (Defaultize[
    (MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P, 
    js.Any
  ]) | (MergePropTypes[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ])
  type ReactNode = js.UndefOr[ReactChild | ReactFragment | ReactPortal | Boolean]
  //
  // React Nodes
  // http://facebook.github.io/react/docs/glossary.html
  // ----------------------------------------------------------------------
  type ReactText = String | Double
  /**
    * @deprecated Please use `ElementType`
    */
  type ReactType[P] = slinky.core.facade.ReactElement
  // Unlike redux, the actions _can_ be anything
  type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]
  type ReducerAction[R /* <: Reducer[_, _] */] = js.Any
  // types used to try and prevent the compiler from reducing S
  // to a supertype common with the second argument to useReducer()
  type ReducerState[R /* <: Reducer[_, _] */] = js.Any
  type Ref[T] = (js.Function1[/* instance */ T | Null, Unit]) | ReactRef[T] | Null
  type Requireable[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<T> */ js.Any
  //
  // Class Interfaces
  // ----------------------------------------------------------------------
  /**
    * @deprecated as of recent React versions, function components can no
    * longer be considered 'stateless'. Please use `FunctionComponent` instead.
    *
    * @see [React Hooks](https://reactjs.org/docs/hooks-intro.html)
    */
  type SFC[P] = ReactComponentClass[P]
  /**
    * @deprecated Please use `FunctionComponentElement`
    */
  type SFCElement[P] = FunctionComponentElement[P]
  /**
    * @deprecated Please use `FunctionComponentFactory`
    */
  type SFCFactory[P] = FunctionComponentFactory[P]
  //
  // React Hooks
  // ----------------------------------------------------------------------
  // based on the code in https://github.com/facebook/react/pull/13968
  // Unlike the class component setState, the updates are not allowed to be partial
  type SetStateAction[S] = S | (js.Function1[/* prevState */ S, S])
  /**
    * @deprecated as of recent React versions, function components can no
    * longer be considered 'stateless'. Please use `FunctionComponent` instead.
    *
    * @see [React Hooks](https://reactjs.org/docs/hooks-intro.html)
    */
  type StatelessComponent[P] = ReactComponentClass[P]
  /**
    * currentTarget - a reference to the element on which the event listener is registered.
    *
    * target - a reference to the element from which the event was originally dispatched.
    * This might be a child element to the element on which the event listener is registered.
    * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
    */
  type SyntheticEvent[T, E] = slinky.core.SyntheticEvent[EventTarget with T, E]
  type TouchEventHandler[T] = EventHandler[SyntheticTouchEvent[T]]
  type TransitionEventHandler[T] = EventHandler[SyntheticTransitionEvent[T]]
  type UIEventHandler[T] = EventHandler[SyntheticUIEvent[T]]
  type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ js.Any
  //
  // React.PropTypes
  // ----------------------------------------------------------------------
  type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ js.Any
  type WeakValidationMap[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]:? null extends T[K]? react.react.Validator<T[K] | null | undefined> : undefined extends T[K]? react.react.Validator<T[K] | null | undefined> : react.react.Validator<T[K]>}
    */ typingsSlinky.react.reactStrings.WeakValidationMap with js.Any
  type WheelEventHandler[T] = EventHandler[SyntheticWheelEvent[T]]
}
