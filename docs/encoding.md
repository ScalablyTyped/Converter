---
id: encoding
title: Anticipated questions about encoding
---

Finding a working encoding within the strict limits of Scala.js was hard, 
 and certainly a bunch of things are decidedly suboptimal.

However, we've made it to a place where most things work, which is great.

The following points try to explain the big picture:

### Whatsup with naming?

All the converted structures are put into a hierarchy:
- output package (typically `typings`, but it can be overriden with `stOutputPackage`)
- library name, for instance `react`
- if defined within a module, an abbreviated version of the module name with a `Mod` suffix. If the module is the top-level module in a library it is just called `mod`.
- if defined within (possibly several) typescript namespaces, all those names are kept
- finally the name of the thing itself.
 
for instance a typescript import such as this:
```typescript
import AnchorLong from "antd/es/anchor/AnchorLink";
```
will be in ScalablyTyped:
```
import typings.antd.esAnchorAnchorLinkMod.{default => AnchorLong}
```

Note: Earlier we used `Lib` and `NS` as a suffixes for all library and namespace names, we now managed to drop them.
Migration should be easy with a search/replace of `typings.xxxLib => typings.xxx`.

### Whatsup with the hats?

We convert typescript namespaces and modules into scala packages.

In idiomatic scala top level members inside would be placed into package objects,
but those are unfortunately [broken](https://github.com/scala-js/scala-js/issues/1892) when used as javascript facades.
For that reason we upgrade `var` and `def` to `object` instead.

You will see that quite a few packages have an object (and/or a class) called `^`. This is a reference to the module itself,
and you might need to refer it.

- To use classes which are exported as a module in commonjs (defined in Typescript as `export = class Foo {}`, used in Scala as `new typings.node.eventsMod.^()`)
- If you want to mutate top-level members (`typings.std.^.onerror = (x, _, _, _, _) => typings.std.console.warn(x)`)

### Whatsup with numbers?
We're used to deal with `Int`, `Double`, and so on. Javascript isn't.
In the general case it's hopeless to guess what a `number` is, so `Double` is all we get here.


### Whatsup with casting?

Since Typescript is structurally typed it's impossible that all subtyping relationships transfer to 
For instance:

```scala
@js.native
trait ArrayLike[T] extends /* n */ ScalablyTyped.runtime.NumberDictionary[T] {
  val length: Double
}
```
is a description of something that conforms to a minimal version of the `Array` interface.

You'll find that `Array` itself doesn't inherit it:
```scala
@js.native
trait Array[T] extends /* n */ ScalablyTyped.runtime.NumberDictionary[T] {
  val length: Double = js.native
  //...
}
```
Although we could extend the converter to recognize some of these cases, it is not currently done.
The fix is straightforward cast, demonstrating that you know something the compiler doesn't:

```scala
typings.std.Array(1).asInstanceOf[ArrayLike[Int]]
```
For good measure, bundle your knowledge somewhere so you don't litter you code with casts:
```scala
object Foo {
  def ArrayIsArrayLike[T](ts: typings.std.Array[T]): typings.std.ArrayLike[T] = ts.asInstanceOf[typings.std.ArrayLike[T]]
}
```

### Whatsup with bounds?
After conversion, all bounds are commented out. The converter has support for translating them,
 but they're commented out for now since they are often impractical to conform to.

Take for instance this:
```scala
@js.native
trait Crypto extends js.Object {
  def getRandomValues[T /* <: Int8Array | Int16Array | Int32Array | Uint8Array | Uint16Array | Uint32Array | Uint8ClampedArray | Float32Array | Float64Array | DataView | Null */](array: T): T
}
```

For now you'll have to be aware of this limitation and treat bounds as documentation.

### Whatsup with classes?

In Javascript classes are first class values, while in Scala they just float around in a parallel type-dimension.

To capture this (and the idea of a "newable" function), a family of interfaces is introduced (in the `runtime` helper artifact):

```scala
trait Instantiable1[T1, R] extends js.Object

object Instantiable1 {
  @inline implicit final class Instantiable1Opts[T1, R](private val ctor: Instantiable1[T1, R]) extends AnyVal {
    @inline def newInstance1(t1: T1): R =
      js.Dynamic.newInstance(ctor.asInstanceOf[js.Dynamic])(t1.asInstanceOf[js.Any]).asInstanceOf[R]
  }
}
```

Given this, we can capture that `window` owns a newable `Blob` thing for instance:
```scala
@js.native
trait Window {
  var Blob: Anon_BlobParts = ???
}

@js.native
trait Anon_BlobParts
  extends ScalablyTyped.runtime.Instantiable0[Blob]
  with ScalablyTyped.runtime.Instantiable1[/* blobParts */ js.Array[BlobPart], Blob]
  with ScalablyTyped.runtime.Instantiable2[/* blobParts */ js.Array[BlobPart], /* options */ BlobPropertyBag, Blob]

//usage
val blob: Blob = typings.std.window.Blob.newInstance0()
```

#### inferred classes
Since `Instantiable` has some drawbacks, statically reachable `Instantiable`s are upgraded to proper classes.

For instance for this

```scala
@js.native
trait HTMLDivElement extends HTMLElement

@JSGlobal("HTMLDivElement")
@js.native
object HTMLDivElement
  extends org.scalablytyped.runtime.Instantiable0[HTMLDivElement]
```

We will infer this class

```scala
@JSGlobal("HTMLDivElement")
@js.native
class HTMLDivElementCls () extends HTMLDivElement
```

These classes will frequently have a `Cls` suffix, again to avoid name conflicts.
We keep both interface/type alias and the class because both might be useful (and in the case of angular, needed).

Note: Be a bit wary with these classes. In typescript this pattern is sometimes used to signal
that a it can participate in an instanceof check, but can't be instantiated.
This applies to `HTMLDivElement` for instance.

### Whatsup with `this`?
Javascript and `this` is a long story. Surprisingly, it's not getting shorter with Scala.js

The problem is that Scala.js discards the Javascript `this` when it calls functions, even if the function is
owned (in Javascript terms) by an object. When calling methods it behaves as expected.

For instance given the following trait:
```scala

@js.native
trait UnderlyingSink extends js.Object {
  val start: WritableStreamDefaultControllerCallback = js.native
}

type WritableStreamDefaultControllerCallback =
  js.Function1[/* controller */ WritableStreamDefaultController, Unit]
```

It's generally impossible to know whether `this` is important in this context, and Scala.js is not going to supply it.
We play it safe and rewrite most such cases to methods, like this:

```scala
@js.native
trait UnderlyingSink extends js.Object {
  def start(controller: WritableStreamDefaultController): Unit = js.native
}
```

### Whatsup with strings?
The Javascript world is a stringly-typed world.
Typescript models the insanity with literal types.
Literal types are supposed to land in Scala 2.13/dotty, but we don't have them yet.
Even when we get them, erasure probably means they won't be too useful in this particular context.

Soo, we cheat a bit. Let's have a look at what it looks like in the `csstype` library:
```scala
package typings
package csstype

object csstypeStrings {
  @js.native
  sealed trait `-moz-initial` extends js.Object
  def `-moz-initial`: `-moz-initial` = "-moz-initial".asInstanceOf[`-moz-initial`]
}

```

A more precise encoding might still be
```scala
  def `-moz-initial`: `-moz-initial` with String = "-moz-initial".asInstanceOf[`-moz-initial` with String]
```
but that hasn't been explored yet. Erasure feels fairly arbitrary when it comes to intersection types.

So there is that. A neat lie to fool `scalac` into accepting things it was never built to be prepared for,
just have a glance at the method encoding below.


### Whatsup with all those methods?
The method encoding is somewhat complex, because of the huge disconnect between the flexible encoding
 Typescript provides to very richly describe an interface,
 and Scala's more rigid, JVM-conforming idea of what a method is.

Let's first take a case like `HTMLCanvasElement.getContext`,
where the value of the first parameter determines the return type.
Typescript is built to handle this, where you define very specific overloads, and a more general definition.
```typescript

interface HTMLCanvasElement extends HTMLElement {
    getContext(contextId: "2d", contextAttributes?: CanvasRenderingContext2DSettings): CanvasRenderingContext2D | null;
    getContext(contextId: "webgl" | "experimental-webgl", contextAttributes?: WebGLContextAttributes): WebGLRenderingContext | null;
    getContext(contextId: string, contextAttributes?: {}): CanvasRenderingContext2D | WebGLRenderingContext | null;
}
```

So what do we do in Scala? We could consolidate/discard the methods and go for a union type:
```scala
@js.native
trait HTMLCanvasElement extends HTMLElement {
  // we don't actually do this
  def getContext(contextId: String, contextAttributes: js.UndefOr[js.Object | CanvasRenderingContext2DSettings | WebGLContextAttributes]): CanvasRenderingContext2D | WebGLRenderingContext | Null = js.native
}
```

But where would the fun be? And the type-safety? This is what we actually end up with:

```scala
import typings.std.stdStrings.{`2d`, `experimental-webgl`, webgl}

@js.native
trait HTMLCanvasElement extends HTMLElement {
  def getContext(contextId: String): CanvasRenderingContext2D | WebGLRenderingContext | Null = js.native
  def getContext(contextId: String, contextAttributes: js.Object): CanvasRenderingContext2D | WebGLRenderingContext | Null = js.native
  @JSName("getContext")
  def getContext_2d(contextId: `2d`): CanvasRenderingContext2D | Null = js.native
  @JSName("getContext")
  def getContext_2d(contextId: `2d`, contextAttributes: CanvasRenderingContext2DSettings): CanvasRenderingContext2D | Null = js.native
  @JSName("getContext")
  def `getContext_experimental-webgl`(contextId: `experimental-webgl`): WebGLRenderingContext | Null = js.native
  @JSName("getContext")
  def `getContext_experimental-webgl`(contextId: `experimental-webgl`, contextAttributes: WebGLContextAttributes): WebGLRenderingContext | Null = js.native
  @JSName("getContext")
  def getContext_webgl(contextId: webgl): WebGLRenderingContext | Null = js.native
  @JSName("getContext")
  def getContext_webgl(contextId: webgl, contextAttributes: WebGLContextAttributes): WebGLRenderingContext | Null = js.native
}
```

Several things are in motion here.
- We use the faked literal strings to distinguish the different values `contextId` can have.
  In this particular case the methods are also renamed (`getContext_2d`),
   that's mostly only the case in the presence of type literals.
- All the overloads are duplicated to account for optional parameters,
  because default parameters in Scala don't work in the presence of overloads.
  Because of the renames it isn't strictly necessary in this case,
  but it's done all over the generated code, because further overloads might also appear in sub/super classes
  (including in dependencies)

Talking about overloads/overrides, there are more things to consider for the conversion.
Let's take a new example, `EventTarget`

```typescript
interface EventTarget {
    addEventListener(type: string, listener: EventListenerOrEventListenerObject | null, options?: boolean | AddEventListenerOptions): void;
}

declare type EventListenerOrEventListenerObject = EventListener | EventListenerObject;

interface EventListener {
    (evt: Event): void;
}
interface EventListenerObject {
    handleEvent(evt: Event): void;
}

interface MediaStream extends EventTarget {
    addEventListener<K extends keyof MediaStreamEventMap>(type: K, listener: (this: MediaStream, ev: MediaStreamEventMap[K]) => any, options?: boolean | AddEventListenerOptions): void;
    addEventListener(type: string, listener: EventListenerOrEventListenerObject, options?: boolean | AddEventListenerOptions): void;
}

interface MediaStreamEventMap {
    "active": Event;
    "addtrack": MediaStreamTrackEvent;
}
```

Notice that the second parameter of `addEventListener` in `EventTarget` has type `EventListenerOrEventListenerObject | null`,
 while in `MediaStream` it is not nullable. Boom - compile error!

To solve this situation, we also duplicate methods rather liberally around union types, such that `EventTarget` ends up as
```scala

@js.native
trait EventTarget extends js.Object {
  def addEventListener(`type`: String): Unit = js.native
  def addEventListener(`type`: String, listener: EventListenerOrEventListenerObject): Unit = js.native
  def addEventListener(`type`: String, listener: EventListenerOrEventListenerObject, options: AddEventListenerOptions): Unit = js.native
  def addEventListener(`type`: String, listener: EventListenerOrEventListenerObject, options: Boolean): Unit = js.native
  def addEventListener(`type`: String, listener: Null, options: AddEventListenerOptions): Unit = js.native
  def addEventListener(`type`: String, listener: Null, options: Boolean): Unit = js.native
}
type EventListenerOrEventListenerObject = EventListener | EventListenerObject

type EventListener = js.Function1[/* evt */ Event, Unit]

trait EventListenerObject extends js.Object {
  def handleEvent(evt: Event): Unit
}

```

The point is not necessarily that this is awesome, but that it compiles - even in
the presence of overrides in subclasses with different optionality of parameters

Let's have a look at `MediaStream` as well:
```scala
import typings.std.stdStrings.{active, addtrack}

@js.native
trait MediaStream extends EventTarget {
  @JSName("addEventListener")
  def addEventListener_active(`type`: active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _]): Unit = js.native
  @JSName("addEventListener")
  def addEventListener_active(`type`: active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _], options: AddEventListenerOptions): Unit = js.native
  @JSName("addEventListener")
  def addEventListener_active(`type`: active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _], options: Boolean): Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _]): Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _], options: AddEventListenerOptions): Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _], options: Boolean): Unit = js.native

```

- The general fallback definition of `addEventListener` is omitted since it didn't enrich what was defined in the superclass
- we use `this.type` to allow overrides which take the same callback function but with a more specific `this` context
- we expand the `<K extends keyof MediaStreamEventMap>` construct such that we maintain full type-safety of the callback based on the `type` parameter

Note also that this although this section mainly explores duplication of methods, there is also a consolidation step,
 which combines methods with the same JVM erasure, as Scala cares about that a lot.

### Whatsup with rewriting type unions to inheritance?

We've had some issues where unions of many types, among other issues like compile time, bumps
into the JVMs limit for how many string literals can be referenced in a class/method.

Scala is much better prepared to handle `trait`s with many implementations, so as long as all
types in a long type union is contained in the same library, we rewrite for instance this:

```scala
type BlobPart = BufferSource | Blob | String
```

Into this:

```scala
/* Rewritten from type alias, can be one of:
  - BufferSource
  - Blob
  - String
*/
type BlobPart = _BlobPart | String

trait _BlobPart extends js.Object

trait Blob extends _BlobPart

trait BufferSource extends _BlobPart

```

This mechanism also means that the fake string literals seen above can inherit from traits:
```
@js.native
sealed trait center
  extends AlignSetting
     with CanvasTextAlign
     with LineAlignSetting
     with PositionAlignSetting
     with ScrollLogicalPosition
```


### Whatsup with @js.native and all that?
So Scala.js has two types of interop, which is better described in the Scala.js documentation.

#### @ScalaJSDefined
We don't really use this annotation anymore, it's just the default for types which extend `js.Object`.

This is a nice encoding for objects the user themselves create, since it's newable:
```scala
new Props {
  override val foo = 1
}
```
We try to convert everything into this format, but we give up in case the structure is callable,
or if it has overloads.

#### @js.native
This describes things you can only consume, which is most of the surface of most libraries.

Because of the rather liberal use of method duplication (which causes overloads) described above,
 there will be cases where you'll need to instantiate a `@js.native` annotated trait.

This is done by casting, with no compiler help:
```scala
js.Dynamic.literal(foo = 1).asInstanceof[Props]
```

This will be improved in the future, but for now it is what it is.
Based on using 0.01% of the libraries it hasn't been a problem so far.


### Whatsup with type mappings?

Typescript provides this awesome way of transforming types called type mappings.

They work more or less like this:

```typescript
// from typescript's bundled definitions
/**
 * Make all properties in T optional
 */
type Partial<T> = {
    [P in keyof T]?: T[P];
};

/**
 * From T pick a set of properties K
 */
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};

/**
 * Construct a type with a set of properties K of type T
 */
type Record<K extends keyof any, T> = {
    [P in K]: T;
};

interface Person {
    age: number;
    name: string;
}

// these compile
const named: Pick<Person, "name"> = {name: "asdasd"};
const empty: Partial<Person> = {};
const record: Record<"a" | "b", number> = {a: 1, b: 2}
```

As you might imagine, converting these to Scala is not straightforward.
For static cases we can evaluate them and generate interfaces (though it's not implemented yet!),
but for generic cases (say `Partial<T>`) there isn't much we can do for now.

Just to get things working, we mostly ignore the effects of the type mappings in Scala for now,
 and keep the transformation in a comment:

```scala
type Partial[T] = /* import warning: ImportType.apply c Unsupported type mapping:
  {[ P in keyof T ]:? T[P]}
  */ typings.std.stdStrings.Partial with T
```
This is again not necessarily awesome, but it works.

Crucially, the encoding leaves a trace in the form of the string literal in the intersection type.

When you consume a structure like this it acts like a (subtle) red flag to indicate that you might not
get exactly the data the type system indicates.
When you produce such a value, you need to cast yourself:

```scala
val partialPerson: Partial[Person] = js.Dynamic.literal(name = "dsa").asInstanceOf[Partial[Person]]
```

Also notice that for `Record` the transformation is such that we cannot just ignore it,
so we fall back to `js.Any`.

### Whatsup with interface augmentation?
Another awesome feature of typescript is how you can describe that a library or a module augments
an existing structure.

```typescript
// in library foo
interface FooStatic {
    sayHello();
}

// in library foo-augmented
interface FooStatic {
    sayGoodbye();
}

import foo from 'foo';
import 'augments-foo';
foo.sayGoodbye();
```

The converter has some internal support for detecting this,
but we haven't experimented with outputting anything yet.
That means that you have to detect this yourself and cast.
Have a look at the `jquery`/`jquery-ui`
[demo](https://github.com/oyvindberg/ScalablyTypedDemos/blob/master/jquery/src/main/scala/demo/JQueryDemo.scala)
to see how it's done.
