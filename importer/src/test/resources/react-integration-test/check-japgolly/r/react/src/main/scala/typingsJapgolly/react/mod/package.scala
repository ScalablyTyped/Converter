package typingsJapgolly.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type AnimationEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  // tslint:disable-next-line:no-empty-interface
  type AudioHTMLAttributes[T] = typingsJapgolly.react.mod.MediaHTMLAttributes[T]
  type CElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] = typingsJapgolly.react.mod.ComponentElement[P, T]
  type CFactory[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] = typingsJapgolly.react.mod.ComponentFactory[P, T]
  type CSSProperties = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify CSS.Properties<string | number> */ js.Any
  type ChangeEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  /**
    * We use an intersection type to infer multiple type parameters from
    * a single argument, which is useful for many top-level API defs.
    * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
    */
  type ClassType[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */] = C with (org.scalablytyped.runtime.Instantiable2[/* props */ P, js.UndefOr[/* context */ js.Any], T])
  type ClassicElement[P] = typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]
  type ClassicFactory[P] = typingsJapgolly.react.mod.CFactory[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]
  type ClipboardEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  type ComponentFactory[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] = js.Function2[
    /* props */ js.UndefOr[typingsJapgolly.react.mod.ClassAttributes[T] with P], 
    /* repeated */ japgolly.scalajs.react.raw.React.Node, 
    typingsJapgolly.react.mod.CElement[P, T]
  ]
  /**
    * NOTE: prefer ComponentPropsWithRef, if the ref is forwarded,
    * or ComponentPropsWithoutRef when refs are not supported.
    */
  type ComponentProps[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */] = js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)
  type ComponentPropsWithRef[T /* <: japgolly.scalajs.react.raw.React.ElementType */] = typingsJapgolly.react.mod.PropsWithRef[typingsJapgolly.react.mod.ComponentProps[T]] | (typingsJapgolly.react.mod.PropsWithoutRef[_] with (typingsJapgolly.react.mod.RefAttributes[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ _
  ]))
  type ComponentPropsWithoutRef[T /* <: japgolly.scalajs.react.raw.React.ElementType */] = typingsJapgolly.react.mod.PropsWithoutRef[typingsJapgolly.react.mod.ComponentProps[T]]
  type ComponentState = js.Any
  type ComponentType[P] = (japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object]) | typingsJapgolly.react.mod.FunctionComponent[P]
  type CompositionEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  type Consumer[T] = typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.ConsumerProps[T]]
  type ContextType[C /* <: typingsJapgolly.react.mod.Context[_] */] = js.Any
  type DOMFactory[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */] = js.Function2[
    /* props */ js.UndefOr[(typingsJapgolly.react.mod.ClassAttributes[T] with P) | scala.Null], 
    /* repeated */ japgolly.scalajs.react.raw.React.Node, 
    japgolly.scalajs.react.raw.React.DomElement
  ]
  // Any prop that has a default prop becomes optional, but its type is unchanged
  // Undeclared default props are augmented into the resulting allowable attributes
  // If declared props have indexed properties, ignore default props entirely as keyof gets widened
  // Wrap in an outer-level conditional type to allow distribution over props that are unions
  type Defaultize[P, D] = ((typingsJapgolly.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof D> */ _
  ]) with (typingsJapgolly.std.Partial[
    typingsJapgolly.std.Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ _
    ]
  ]) with (typingsJapgolly.std.Partial[
    typingsJapgolly.std.Pick[
      D, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof D, keyof P> */ _
    ]
  ])) | P
  // The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
  // TODO (TypeScript 3.0): ReadonlyArray<unknown>
  type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ js.Any
  type DetailedHTMLProps[E /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T] = typingsJapgolly.react.mod.ClassAttributes[T] with E
  // this technically does accept a second argument, but it's already under a deprecation warning
  // and it's not even released so probably better to not define it.
  type Dispatch[A] = js.Function1[/* value */ A, scala.Unit]
  type DragEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]]
  // NOTE: callbacks are _only_ allowed to return either void, or a destructor.
  // The destructor is itself only allowed to return void.
  type EffectCallback = js.Function0[scala.Unit | js.Function0[js.UndefOr[scala.Unit]]]
  //
  // React Elements
  // ----------------------------------------------------------------------
  type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view' ]: P extends react.react._Global_.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'blockquote' | 'body' | 'br' | 'button' | 'canvas' | 'caption' | 'cite' | 'code' | 'col' | 'colgroup' | 'data' | 'datalist' | 'dd' | 'del' | 'details' | 'dfn' | 'dialog' | 'div' | 'dl' | 'dt' | 'em' | 'embed' | 'fieldset' | 'figcaption' | 'figure' | 'footer' | 'form' | 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'head' | 'header' | 'hgroup' | 'hr' | 'html' | 'i' | 'iframe' | 'img' | 'input' | 'ins' | 'kbd' | 'keygen' | 'label' | 'legend' | 'li' | 'link' | 'main' | 'map' | 'mark' | 'menu' | 'menuitem' | 'meta' | 'meter' | 'nav' | 'noindex' | 'noscript' | 'object' | 'ol' | 'optgroup' | 'option' | 'output' | 'p' | 'param' | 'picture' | 'pre' | 'progress' | 'q' | 'rp' | 'rt' | 'ruby' | 's' | 'samp' | 'script' | 'section' | 'select' | 'small' | 'source' | 'span' | 'strong' | 'style' | 'sub' | 'summary' | 'sup' | 'table' | 'template' | 'tbody' | 'td' | 'textarea' | 'tfoot' | 'th' | 'thead' | 'time' | 'title' | 'tr' | 'track' | 'u' | 'ul' | 'var' | 'video' | 'wbr' | 'webview' | 'svg' | 'animate' | 'animateMotion' | 'animateTransform' | 'circle' | 'clipPath' | 'defs' | 'desc' | 'ellipse' | 'feBlend' | 'feColorMatrix' | 'feComponentTransfer' | 'feComposite' | 'feConvolveMatrix' | 'feDiffuseLighting' | 'feDisplacementMap' | 'feDistantLight' | 'feDropShadow' | 'feFlood' | 'feFuncA' | 'feFuncB' | 'feFuncG' | 'feFuncR' | 'feGaussianBlur' | 'feImage' | 'feMerge' | 'feMergeNode' | 'feMorphology' | 'feOffset' | 'fePointLight' | 'feSpecularLighting' | 'feSpotLight' | 'feTile' | 'feTurbulence' | 'filter' | 'foreignObject' | 'g' | 'image' | 'line' | 'linearGradient' | 'marker' | 'mask' | 'metadata' | 'mpath' | 'path' | 'pattern' | 'polygon' | 'polyline' | 'radialGradient' | 'rect' | 'stop' | 'switch' | 'symbol' | 'text' | 'textPath' | 'tspan' | 'use' | 'view'] */ js.Any) | typingsJapgolly.react.mod.ComponentType[P]
  //
  // Event Handler Types
  // ----------------------------------------------------------------------
  type EventHandler[E /* <: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.Element] */] = js.Function1[/* event */ E, scala.Unit]
  type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any
  type FC[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  //
  // Factories
  // ----------------------------------------------------------------------
  type Factory[P] = js.Function2[
    /* props */ js.UndefOr[typingsJapgolly.react.mod.Attributes with P], 
    /* repeated */ japgolly.scalajs.react.raw.React.Node, 
    japgolly.scalajs.react.raw.React.Element
  ]
  type FocusEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]]
  // tslint:disable-next-line:no-empty-interface
  type FormEvent[T] = japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]
  type FormEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  type FunctionComponentFactory[P] = js.Function2[
    /* props */ js.UndefOr[typingsJapgolly.react.mod.Attributes with P], 
    /* repeated */ japgolly.scalajs.react.raw.React.Node, 
    typingsJapgolly.react.mod.FunctionComponentElement[P]
  ]
  type GetDerivedStateFromError[P, S] = /**
    * This lifecycle is invoked after an error has been thrown by a descendant component.
    * It receives the error that was thrown as a parameter and should return a value to update state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function1[/* error */ js.Any, typingsJapgolly.std.Partial[S] | scala.Null]
  type GetDerivedStateFromProps[P, S] = /**
    * Returns an update to a component's state based on its new props and old state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function2[/* nextProps */ P, /* prevState */ S, typingsJapgolly.std.Partial[S] | scala.Null]
  // tslint:disable-next-line:no-empty-interface
  type HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsJapgolly.react.mod.DetailedHTMLFactory[typingsJapgolly.react.mod.AllHTMLAttributes[T], T]
  type JSXElementConstructor[P] = (js.Function1[/* props */ P, japgolly.scalajs.react.raw.React.Element | scala.Null]) | (org.scalablytyped.runtime.Instantiable1[
    /* props */ P, 
    japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]
  ])
  type Key = java.lang.String | scala.Double
  type KeyboardEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  type LazyExoticComponent[T /* <: typingsJapgolly.react.mod.ComponentType[_] */] = typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.ComponentPropsWithRef[T]] with typingsJapgolly.react.AnonResult[T]
  type LegacyRef[T] = java.lang.String | japgolly.scalajs.react.raw.React.Ref
  // will show `Memo(${Component.displayName || Component.name})` in devtools by default,
  // but can be given its own specific name
  type MemoExoticComponent[T /* <: typingsJapgolly.react.mod.ComponentType[_] */] = typingsJapgolly.react.mod.NamedExoticComponent[typingsJapgolly.react.mod.ComponentPropsWithRef[T]] with typingsJapgolly.react.AnonType[T]
  // Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
  type MergePropTypes[P, T] = ((typingsJapgolly.std.Pick[P, typingsJapgolly.react.mod.NotExactlyAnyPropertyKeys[P]]) with (typingsJapgolly.std.Pick[
    T, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof T, NotExactlyAnyPropertyKeys<P>> */ _
  ]) with (typingsJapgolly.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, keyof T> */ _
  ])) | P | T
  type MouseEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]]
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
  type PointerEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]]
  /**
    * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
    */
  type ProfilerOnRenderCallback = js.Function7[
    /* id */ java.lang.String, 
    /* phase */ typingsJapgolly.react.reactStrings.mount | typingsJapgolly.react.reactStrings.update, 
    /* actualDuration */ scala.Double, 
    /* baseDuration */ scala.Double, 
    /* startTime */ scala.Double, 
    /* commitTime */ scala.Double, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any, 
    scala.Unit
  ]
  type PropsWithChildren[P] = P with typingsJapgolly.react.AnonChildren
  /** Ensures that the props do not include string ref, which cannot be forwarded */
  type PropsWithRef[P] = P | (typingsJapgolly.react.mod.PropsWithoutRef[P] with typingsJapgolly.react.AnonRefAny)
  /** Ensures that the props do not include ref at all */
  type PropsWithoutRef[P] = P | (typingsJapgolly.std.Pick[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<keyof P, 'ref'> */ js.Any
  ])
  // NOTE: only the Context object itself can get a displayName
  // https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
  type Provider[T] = typingsJapgolly.react.mod.ProviderExoticComponent[typingsJapgolly.react.mod.ProviderProps[T]]
  type ReactChild = japgolly.scalajs.react.raw.React.Element | typingsJapgolly.react.mod.ReactText
  type ReactComponentElement[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 175 */ js.Any */, P] = japgolly.scalajs.react.raw.React.Element
  type ReactEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  type ReactFragment = js.Object | typingsJapgolly.react.mod.ReactNodeArray
  // ReactHTML for ReactHTMLElement
  // tslint:disable-next-line:no-empty-interface
  type ReactHTMLElement[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsJapgolly.react.mod.DetailedReactHTMLElement[typingsJapgolly.react.mod.AllHTMLAttributes[T], T]
  //
  // Component API
  // ----------------------------------------------------------------------
  type ReactInstance = (japgolly.scalajs.react.raw.React.Component[js.Any with js.Object, js.Object]) | org.scalajs.dom.raw.Element
  type ReactManagedAttributes[C, P] = P | (typingsJapgolly.react.mod.Defaultize[
    (typingsJapgolly.react.mod.MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P, 
    js.Any
  ]) | (typingsJapgolly.react.mod.MergePropTypes[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ])
  type ReactNode = js.UndefOr[
    typingsJapgolly.react.mod.ReactChild | typingsJapgolly.react.mod.ReactFragment | typingsJapgolly.react.mod.ReactPortal | scala.Boolean
  ]
  //
  // React Nodes
  // http://facebook.github.io/react/docs/glossary.html
  // ----------------------------------------------------------------------
  type ReactText = java.lang.String | scala.Double
  /**
    * @deprecated Please use `ElementType`
    */
  type ReactType[P] = japgolly.scalajs.react.raw.React.ElementType
  // Unlike redux, the actions _can_ be anything
  type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]
  type ReducerAction[R /* <: typingsJapgolly.react.mod.Reducer[_, _] */] = js.Any
  // types used to try and prevent the compiler from reducing S
  // to a supertype common with the second argument to useReducer()
  type ReducerState[R /* <: typingsJapgolly.react.mod.Reducer[_, _] */] = js.Any
  type Ref[T] = (js.Function1[/* instance */ T | scala.Null, scala.Unit]) | japgolly.scalajs.react.raw.React.RefHandle[T] | scala.Null
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
  type SFC[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  /**
    * @deprecated Please use `FunctionComponentElement`
    */
  type SFCElement[P] = typingsJapgolly.react.mod.FunctionComponentElement[P]
  /**
    * @deprecated Please use `FunctionComponentFactory`
    */
  type SFCFactory[P] = typingsJapgolly.react.mod.FunctionComponentFactory[P]
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
  type StatelessComponent[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  /**
    * currentTarget - a reference to the element on which the event listener is registered.
    *
    * target - a reference to the element from which the event was originally dispatched.
    * This might be a child element to the element on which the event listener is registered.
    * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
    */
  type SyntheticEvent[T, E] = japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.EventTarget with T with org.scalajs.dom.raw.Element]
  type TouchEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]]
  type TransitionEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  type UIEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactUIEventFrom[T with org.scalajs.dom.raw.Element]]
  type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ js.Any
  //
  // React.PropTypes
  // ----------------------------------------------------------------------
  type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ js.Any
  type WeakValidationMap[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]:? null extends T[K]? react.react.Validator<T[K] | null | undefined> : undefined extends T[K]? react.react.Validator<T[K] | null | undefined> : react.react.Validator<T[K]>}
    */ typingsJapgolly.react.reactStrings.WeakValidationMap with js.Any
  type WheelEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]]
}
