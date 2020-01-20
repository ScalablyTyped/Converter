package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type AnimationEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticAnimationEvent[T]]
  // tslint:disable-next-line:no-empty-interface
  type AudioHTMLAttributes[T] = typingsSlinky.react.mod.MediaHTMLAttributes[T]
  type CElement[P, T /* <: slinky.core.ReactComponentClass[P] */] = typingsSlinky.react.mod.ComponentElement[P, T]
  type CFactory[P, T /* <: slinky.core.ReactComponentClass[P] */] = typingsSlinky.react.mod.ComponentFactory[P, T]
  type CSSProperties = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify CSS.Properties<string | number> */ js.Any
  type ChangeEventHandler[T] = typingsSlinky.react.mod.EventHandler[typingsSlinky.react.mod.ChangeEvent[T]]
  /**
    * We use an intersection type to infer multiple type parameters from
    * a single argument, which is useful for many top-level API defs.
    * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
    */
  type ClassType[P, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */] = C with (org.scalablytyped.runtime.Instantiable2[/* props */ P, js.UndefOr[/* context */ js.Any], T])
  type ClassicElement[P] = typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]]
  type ClassicFactory[P] = typingsSlinky.react.mod.CFactory[P, slinky.core.ReactComponentClass[P]]
  type ClipboardEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticClipboardEvent[T]]
  type ComponentFactory[P, T /* <: slinky.core.ReactComponentClass[P] */] = js.Function2[
    /* props */ js.UndefOr[typingsSlinky.react.mod.ClassAttributes[T] with P], 
    /* repeated */ slinky.core.TagMod[scala.Any], 
    typingsSlinky.react.mod.CElement[P, T]
  ]
  /**
    * NOTE: prefer ComponentPropsWithRef, if the ref is forwarded,
    * or ComponentPropsWithoutRef when refs are not supported.
    */
  type ComponentProps[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */] = js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)
  type ComponentPropsWithRef[T /* <: slinky.core.facade.ReactElement */] = typingsSlinky.react.mod.PropsWithRef[typingsSlinky.react.mod.ComponentProps[T]] | (typingsSlinky.react.mod.PropsWithoutRef[_] with (typingsSlinky.react.mod.RefAttributes[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
  ]))
  type ComponentPropsWithoutRef[T /* <: slinky.core.facade.ReactElement */] = typingsSlinky.react.mod.PropsWithoutRef[typingsSlinky.react.mod.ComponentProps[T]]
  type ComponentState = js.Any
  type ComponentType[P] = slinky.core.ReactComponentClass[P] | slinky.core.ReactComponentClass[P]
  type CompositionEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticCompositionEvent[T]]
  type Consumer[T] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ConsumerProps[T]]
  type ContextType[C /* <: typingsSlinky.react.mod.Context[_] */] = js.Any
  type DOMFactory[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */] = js.Function2[
    /* props */ js.UndefOr[(typingsSlinky.react.mod.ClassAttributes[T] with P) | scala.Null], 
    /* repeated */ slinky.core.TagMod[scala.Any], 
    slinky.core.facade.ReactElement
  ]
  // Any prop that has a default prop becomes optional, but its type is unchanged
  // Undeclared default props are augmented into the resulting allowable attributes
  // If declared props have indexed properties, ignore default props entirely as keyof gets widened
  // Wrap in an outer-level conditional type to allow distribution over props that are unions
  type Defaultize[P, D] = ((typingsSlinky.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof D> */ _
  ]) with (typingsSlinky.std.Partial[
    typingsSlinky.std.Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ _
    ]
  ]) with (typingsSlinky.std.Partial[
    typingsSlinky.std.Pick[
      D, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof D, keyof P> */ _
    ]
  ])) | P
  // The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
  // TODO (TypeScript 3.0): ReadonlyArray<unknown>
  type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ js.Any
  type DetailedHTMLProps[E /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T] = typingsSlinky.react.mod.ClassAttributes[T] with E
  // this technically does accept a second argument, but it's already under a deprecation warning
  // and it's not even released so probably better to not define it.
  type Dispatch[A] = js.Function1[/* value */ A, scala.Unit]
  type DragEventHandler[T] = typingsSlinky.react.mod.EventHandler[typingsSlinky.react.mod.DragEvent[T]]
  // NOTE: callbacks are _only_ allowed to return either void, or a destructor.
  // The destructor is itself only allowed to return void.
  type EffectCallback = js.Function0[scala.Unit | js.Function0[js.UndefOr[scala.Unit]]]
  //
  // React Elements
  // ----------------------------------------------------------------------
  type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view' ]: P extends react.react._Global_.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view'] */ js.Any) | slinky.core.ReactComponentClass[P]
  //
  // Event Handler Types
  // ----------------------------------------------------------------------
  type EventHandler[E /* <: slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, _] */] = js.Function1[/* event */ E, scala.Unit]
  type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any
  type FC[P] = slinky.core.ReactComponentClass[P]
  //
  // Factories
  // ----------------------------------------------------------------------
  type Factory[P] = js.Function2[
    /* props */ js.UndefOr[typingsSlinky.react.mod.Attributes with P], 
    /* repeated */ slinky.core.TagMod[scala.Any], 
    slinky.core.facade.ReactElement
  ]
  type FocusEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticFocusEvent[T]]
  // tslint:disable-next-line:no-empty-interface
  type FormEvent[T] = slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, T]
  type FormEventHandler[T] = typingsSlinky.react.mod.EventHandler[
    slinky.core.SyntheticEvent[org.scalajs.dom.raw.EventTarget with T, org.scalajs.dom.raw.Event]
  ]
  type FunctionComponentFactory[P] = js.Function2[
    /* props */ js.UndefOr[typingsSlinky.react.mod.Attributes with P], 
    /* repeated */ slinky.core.TagMod[scala.Any], 
    typingsSlinky.react.mod.FunctionComponentElement[P]
  ]
  type GetDerivedStateFromError[P, S] = /**
    * This lifecycle is invoked after an error has been thrown by a descendant component.
    * It receives the error that was thrown as a parameter and should return a value to update state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function1[/* error */ js.Any, typingsSlinky.std.Partial[S] | scala.Null]
  type GetDerivedStateFromProps[P, S] = /**
    * Returns an update to a component's state based on its new props and old state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function2[/* nextProps */ P, /* prevState */ S, typingsSlinky.std.Partial[S] | scala.Null]
  // tslint:disable-next-line:no-empty-interface
  type HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsSlinky.react.mod.DetailedHTMLFactory[typingsSlinky.react.mod.AllHTMLAttributes[T], T]
  type JSXElementConstructor[P] = (js.Function1[/* props */ P, slinky.core.facade.ReactElement | scala.Null]) | (org.scalablytyped.runtime.Instantiable1[/* props */ P, slinky.core.ReactComponentClass[P]])
  type Key = java.lang.String | scala.Double
  type KeyboardEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticKeyboardEvent[T]]
  type LazyExoticComponent[T /* <: slinky.core.ReactComponentClass[_] */] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ComponentPropsWithRef[T]] with typingsSlinky.react.AnonResult[T]
  type LegacyRef[T] = java.lang.String | typingsSlinky.react.mod.Ref[T]
  // will show `Memo(${Component.displayName || Component.name})` in devtools by default,
  // but can be given its own specific name
  type MemoExoticComponent[T /* <: slinky.core.ReactComponentClass[_] */] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ComponentPropsWithRef[T]] with typingsSlinky.react.AnonType[T]
  // Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
  type MergePropTypes[P, T] = ((typingsSlinky.std.Pick[P, typingsSlinky.react.mod.NotExactlyAnyPropertyKeys[P]]) with (typingsSlinky.std.Pick[
    T, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof T, NotExactlyAnyPropertyKeys<P>> */ _
  ]) with (typingsSlinky.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof T> */ _
  ])) | P | T
  type MouseEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticMouseEvent[T]]
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
  type PointerEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticPointerEvent[T]]
  /**
    * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
    */
  type ProfilerOnRenderCallback = js.Function7[
    /* id */ java.lang.String, 
    /* phase */ typingsSlinky.react.reactStrings.mount | typingsSlinky.react.reactStrings.update, 
    /* actualDuration */ scala.Double, 
    /* baseDuration */ scala.Double, 
    /* startTime */ scala.Double, 
    /* commitTime */ scala.Double, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any, 
    scala.Unit
  ]
  type PropsWithChildren[P] = P with typingsSlinky.react.AnonChildren
  /** Ensures that the props do not include string ref, which cannot be forwarded */
  type PropsWithRef[P] = P | (typingsSlinky.react.mod.PropsWithoutRef[P] with typingsSlinky.react.AnonRefAny)
  /** Ensures that the props do not include ref at all */
  type PropsWithoutRef[P] = P | (typingsSlinky.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, 'ref'> */ js.Any
  ])
  // NOTE: only the Context object itself can get a displayName
  // https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
  type Provider[T] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ProviderProps[T]]
  type ReactChild = slinky.core.facade.ReactElement | typingsSlinky.react.mod.ReactText
  type ReactComponentElement[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */, P] = slinky.core.facade.ReactElement
  type ReactEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, T]]
  type ReactFragment = js.Object | typingsSlinky.react.mod.ReactNodeArray
  // ReactHTML for ReactHTMLElement
  // tslint:disable-next-line:no-empty-interface
  type ReactHTMLElement[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsSlinky.react.mod.DetailedReactHTMLElement[typingsSlinky.react.mod.AllHTMLAttributes[T], T]
  //
  // Component API
  // ----------------------------------------------------------------------
  type ReactInstance = slinky.core.ReactComponentClass[js.Any] | org.scalajs.dom.raw.Element
  type ReactManagedAttributes[C, P] = P | (typingsSlinky.react.mod.Defaultize[
    (typingsSlinky.react.mod.MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P, 
    js.Any
  ]) | (typingsSlinky.react.mod.MergePropTypes[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ])
  type ReactNode = js.UndefOr[
    typingsSlinky.react.mod.ReactChild | typingsSlinky.react.mod.ReactFragment | typingsSlinky.react.mod.ReactPortal | scala.Boolean
  ]
  //
  // React Nodes
  // http://facebook.github.io/react/docs/glossary.html
  // ----------------------------------------------------------------------
  type ReactText = java.lang.String | scala.Double
  /**
    * @deprecated Please use `ElementType`
    */
  type ReactType[P] = slinky.core.facade.ReactElement
  // Unlike redux, the actions _can_ be anything
  type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]
  type ReducerAction[R /* <: typingsSlinky.react.mod.Reducer[_, _] */] = js.Any
  // types used to try and prevent the compiler from reducing S
  // to a supertype common with the second argument to useReducer()
  type ReducerState[R /* <: typingsSlinky.react.mod.Reducer[_, _] */] = js.Any
  type Ref[T] = (js.Function1[/* instance */ T | scala.Null, scala.Unit]) | slinky.core.facade.ReactRef[T] | scala.Null
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
  type SFC[P] = slinky.core.ReactComponentClass[P]
  /**
    * @deprecated Please use `FunctionComponentElement`
    */
  type SFCElement[P] = typingsSlinky.react.mod.FunctionComponentElement[P]
  /**
    * @deprecated Please use `FunctionComponentFactory`
    */
  type SFCFactory[P] = typingsSlinky.react.mod.FunctionComponentFactory[P]
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
  type StatelessComponent[P] = slinky.core.ReactComponentClass[P]
  /**
    * currentTarget - a reference to the element on which the event listener is registered.
    *
    * target - a reference to the element from which the event was originally dispatched.
    * This might be a child element to the element on which the event listener is registered.
    * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
    */
  type SyntheticEvent[T, E] = slinky.core.SyntheticEvent[org.scalajs.dom.raw.EventTarget with T, E]
  type TouchEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticTouchEvent[T]]
  type TransitionEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticTransitionEvent[T]]
  type UIEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticUIEvent[T]]
  type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ js.Any
  //
  // React.PropTypes
  // ----------------------------------------------------------------------
  type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ js.Any
  type WeakValidationMap[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]:? null extends T[K]? react.react.Validator<T[K] | null | undefined> : undefined extends T[K]? react.react.Validator<T[K] | null | undefined> : react.react.Validator<T[K]>}
    */ typingsSlinky.react.reactStrings.WeakValidationMap with js.Any
  type WheelEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticWheelEvent[T]]
}
