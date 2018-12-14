package com.olvind.tso.importer.documentation
import com.olvind.tso.importer.Summary
import com.olvind.tso.ts.TsIdentLibrary

object Readme {
  def apply(summary: Summary, runId: String, locOutput: Option[String]): String = s"""

# ScalablyTyped - The Javascript ecosystem for Scala.js!

This is the home of Scala.js typings for **${summary.successes.size}** Javascript libraries,
 which should span more or less the entire set of modern and popular libraries.

This should make it one of the biggest Scala repos on the planet${describeSize(locOutput)}

## Typing?
Javascript is infamously unityped. Given a library function like this:
```ecmascript 6
  const add = (a, b) => a + b
```

A typing is a library which wraps the unityped library and enriches it with types.
```scala
  def add(a: String, b: String): String = js.native
  def add(a: Double, b: Double): Double = js.native
```

This way both users and compilers should be pretty happy! :)

## How?

We <3
- Typescript
- Scala.js

The Typescript community has done an outstanding job over the years,
investing millions of hours in typing up libraries.

This project is an effort to extend this work to Scala.js.

## Does it work?
In the same sense as with normal libraries, there will be subjective and objective reasons
 to feel that a given typing library is better or worse.

This is an automatic conversion between two very different languages.
Not all idioms transfer well, some dont transfer yet, and some things will just be plain wrong.

Many of the typings will only shine with proper documentation,
a good and educational demo, and some Scala sugar on top.

These are things the community can help out with over time,
there is already a process setup for contributing "sugar"
in the form of `contrib` libraries (see below) and demos

With that in mind, let's consider what we have now a beginning, not an end.
The work on this has been a labor of love, so let's continue like that <3

## How can i get started?

We recommend using sbt with [scalajs-bundler](https://scalacenter.github.io/scalajs-bundler/)
and the ScalablyTyped plugin to easily keep versions in sync (more on versions below).

To see full examples head over and check out the
[demos](https://github.com/oyvindberg/ScalablyTypedDemos)!

There are demos both for frontend and backend javascript libraries,
 so feel free to check it out to see how it all fits together!


These should be the main steps you would have to follow:

### `project/plugins.sbt`
ScalablyTyped is hosted at bintray, so make sure to include the resolver
```scala
  resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
  addSbtPlugin("org.scalablytyped" % "sbt-scalablytyped" % "$runId")
```

### `build.sbt`
You'll have to include both the typing and the javascript dependency, and the resolver again.
```scala
  resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped"),
  libraryDependencies ++= Seq(ScalablyTyped.D.d3),
  npmDependencies in Compile ++= Seq("d3" -> "5.5.0"),
```
The version of the typing normally includes the relevant version of the library,
 so you can often "go to definition" and see what you should put in `npmDependencies`.

The sbt plugin itself is nothing except for a bunch of versions guaranteed to be in sync
```scala
object D {
  val d3 = "org.scalablytyped" % "d3_sjs0.6_2.12" % "5.0-dt-20181018Z-171237"
  val `d3-array` = "org.scalablytyped" % "d3-array_sjs0.6_2.12" % "1.2-dt-20181018Z-e09a78"
  // ...
}
```
### Code away
After that you should be good to go, and just reference things in your code
```scala
  import typings.d3DashGeoLib.d3DashGeoMod.{GeoContext, GeoPath, GeoPermissibleObjects, GeoProjection}
```

## Contrib libraries
As you can imagine with all this casting and other nonsense,
a more scala-like facade will often be a better way.

For now we just have the following contrib-libs:
${contribs(summary)}

These libraries can depend both on typings and external libraries, and
 will be versioned and published alongside ScalablyTyped typings.

If you try one of the typings and end up writing a small facade feel free to PR it! :)


## Haven't people already tried this?

There are heaps of other projects which does this for different languages,
with different levels of effort put into them, and different degrees of success.

This is a small sample:
- [DefinitelyScala](https://definitelyscala.com/)
- [scala-js-ts-importer](http://github.com/sjrd/scala-js-ts-importer)
- [Retyped for C#](https://retyped.com)
- [ts2k for Kotlin](https://github.com/Kotlin/ts2kt)
- [ReasonablyTyped for Reason ML](https://rrdelaney.github.io/ReasonablyTyped/)
- [typescript2java](https://github.com/ltearno/typescript2java)

You'll see there are two projects which target Scala.
`scala-js-ts-importer` is Sébastien's original attempt from some years ago,
 which forms the basis for both `DefinitelyScala` and `ScalablyTyped`.

`DefinitelyScala` is an awesome project, but it's not finished.
This project tries to pick up where it left off and finish the task.

The converter, `tso`, powers `ScalablyTyped` with a huge set of features not frequently found elsewhere:
- Parser for ~all of typescript 3.2
- Keeps ~all comments
- Full handling of dependencies between libraries, including those outside of `DefinitelyTyped`
- Full implementation of the module system, which all useful javascript libraries rely on
- ~All types and values are fully resolved, across library boundaries
- A naming scheme to avoid name collisions
- Scala.js must abide by JVM rules, so we handle erasure, overloads, overrides, default parameters, `var` conflicts, inheritance conflicts, etc.
- Better user convenience by converting to `@ScalaJSDefined` traits
- Bridges gap between structural and nominal typing somewhat by a strong bias towards type aliases instead of traits
- Answers `typeof` queries and type lookups (`React.Props["children"]`)
- Fills in defaulted type parameters

All these features combined enable us to rewrite a very high percentage of all typings,
somewhere around 97-98% of the newest version of all libraries in the current set.

## Is it production ready?

Typings should leave little to no trace of their existence in the finished
javascript artifact, and hence not be directly responsible for runtime errors.

That said... These typings are all just documentation, and we're working with Javascript here.
Test well.

Users should beware though, that we currently have limited space for published artifacts at Bintray.
This necessarily means that we'll have to cull old versions of typings to make room for new ones.

We'll probably establish some kind of regime with selected LTS (Long Term Support) releases
 or something, but no promises for now.

If you choose to depend on a typing now, be prepared to do one of the following:
- keep updating to newest version of typings (breaking old builds)
- locally cache/store typing artifacts
- copy/paste the typing source code into your own repository
- build typing artifacts from ScalablyTyped source code
- donate money/server towards artifact hosting

## Anticipated questions about the encoding
There are loads of details as to how the conversion is done.
Not everything is optimal of course.
The following points try to explain the big picture:

### Whatsup with fooLib, fooNs, fooMod, foo and all that?

Typescript does namespacing differently than Scala, so you can have
a library, a `var`/`function`, a `module` and a `namespace` all with the same name.

For that reason we need to setup a rather elaborate renaming scheme on the Scala side
 to avoid name collisions.
The `Foo` without suffix is reserved for companion objects with static members, enums,
 and for conversion of things like `declare val foo: {...}` which is also converted into an `object`.

Module names in particular tend to be pretty long, because we flatten the module namespace.

On the bright side javascript imports were never super clean in the first place,
and we have way better tooling in Scala to handle it - meaning you shouldn't write much of those yourself.

A somewhat nice way of handling this is to bundle your commonly used imports somewhere, for instance:
```scala
package object myapp {
  type Avatar = typings.materialDashUiLib.avatarMod.default
  val React = typings.reactLib.ReactDsl
}
```

### Whatsup with those version strings?

Oh yes, you've noticed the long version strings - Good! If you didn't, they look like this:

```scala
libraryDependencies ++= Seq(
  "org.scalablytyped" %%% "node" % "10.9.x-dt-20180910Z-53a4c0",
  "org.scalablytyped" %%% "rxjs" % "6.3.2-a446da"
)
```

A `ScalablyTyped` package is generated based on two or three axis:
- a library at a given version
- if the typings are declared outside the library, the version of the typings
- the version of the `tso` converter

A good versioning scheme has the following properties
- sortable/monotonously increasing
- uniquely identifiable/reproducible
- not too long

When defining the `ScalablyTyped` versioning scheme there was also a strong preference towards
 doing less work. We're after all effectively designing a scheme for working with a gigantic
 monorepo with millions of lines of code with limited computing resources.

So to avoid wasting resources we encode the effects of the converter, not it's version:
We digest the generated source code.

The current version scheme is not bullet proof, but should be a pretty good compromise:
- For a library typed in `DefinitelyTyped`:
    `<version declared in typing>-dt-<date of latest commit of typing>-<digest>`
- For a library which ships with typings:
    `<version of library>-<digest>`

This is sortable until the digest part, and survives a library's integration of third party typings.
It also scales all the way down to local development, where we only fire up `scalac` when there are
 actual code changes.

Since we recognize that keeping many of these complex versions in sync is going to be an issue,
 every complete build of `ScalablyTyped` also generates the sbt plugin mentioned above.

### Whatsup with old versions?

ScalablyTyped only considers the newest version of libraries, and that is already considerable scope.

### Whatsup with numbers?
We're used to deal with `Int`, `Double`, and so on. Javascript isn't.
In the general case it's hopeless to guess what a `number` is, so `Double` is all we get here.


### Whatsup with casting?

Since Typescript is structurally typed it's impossible that all subtyping relationships transfer to scala.
For instance:

```scala
@js.native
trait ArrayLike[T] extends /* n */ ScalablyTyped.runtime.NumberDictionary[T] {
  val length: scala.Double
}
```
is a description of something that conforms to a minimal version of the `Array` interface.

You'll find that `Array` itself doesn't inherit it:
```scala
@js.native
trait Array[T] extends /* n */ ScalablyTyped.runtime.NumberDictionary[T] {
  val length: scala.Double = js.native
  //...
}
```
Although we could extend the converter to recognize some of these cases, it is not currently done.
The fix is straightforward cast, demonstrating that you know something the compiler doesn't:

```scala
stdLib.Array(1).asInstanceOf[ArrayLike[Int]]
```
For good measure, bundle your knowledge somewhere so you don't litter you code with casts:
```scala
object Foo {
  def ArrayIsArrayLike[T](ts: stdLib.Array[T]): stdLib.ArrayLike[T] = ts.asInstanceOf[stdLib.ArrayLike[T]]
}
```

### Whatsup with bounds?
After conversion, all bounds are commented out. The converter has support for translating them,
 but they're commented out for now since they are often impractical to conform to.

Take for instance this:
```scala
@js.native
trait Crypto extends js.Object {
  def getRandomValues[T /* <: Int8Array | Int16Array | Int32Array | Uint8Array | Uint16Array | Uint32Array | Uint8ClampedArray | Float32Array | Float64Array | DataView | scala.Null */](array: T): T
}
```

For now you'll have to be aware of this limitation and treat bounds as documentation.

### Whatsup with Instantiable?
In Javascript classes are first class values, while in Scala they just float around in a parallel type-dimension.
To capture this (and the idea of a "newable" function),
a family of interfaces is introduced (in the `runtime` helper artifact):

```scala
trait Instantiable1[T1, R] extends js.Object

object Instantiable1 {
  @inline implicit final class Instantiable1Opts[T1, R](private val ctor: Instantiable1[T1, R]) extends AnyVal {
    @inline def newInstance1(t1: T1): R =
      js.Dynamic.newInstance(ctor.asInstanceOf[js.Dynamic])(t1.asInstanceOf[js.Any]).asInstanceOf[R]
  }
}
```
Barring better solutions to this problem, this will be extended with even more traits which can handle
 type parameters as well, but it's not done yet.

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

val blob: Blob = stdLibMembers.window.Blob.newInstance0()
```

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
  js.Function1[/* controller */ WritableStreamDefaultController, scala.Unit]
```

It's generally impossible to know whether `this` is important in this context, and Scala.js is not going to supply it.
We play it safe and rewrite most such cases to methods, like this:

```scala
@js.native
trait UnderlyingSink extends js.Object {
  def start(controller: WritableStreamDefaultController): scala.Unit = js.native
}
```

### Whatsup with looong compile times?

It shouldn't be too bad, except for one thing: instantiating a class with insanely deeply nested inheritance.
A case study is `csstype`.

Thousand of lines of members defining the entirety of CSS, including the legal values on the right hand side.

Here is a taste:

```scala
trait StandardLonghandProperties[TLength] extends js.Object {
  /**
     * The CSS **`align-content`** property defines how the browser distributes space between and around content items along the cross\\-axis of their container, which is serving as a flexbox container.
     *
     * **Initial value**: `normal`
     *
     * ---
     *
     * _Supported in Flex Layout_
     *
     * |  Chrome  | Firefox |  Safari   |  Edge  |   IE   |
     * | :------: | :-----: | :-------: | :----: | :----: |
     * |  **29**  | **28**  |   **9**   | **12** | **11** |
     * | 21 _-x-_ |         | 6.1 _-x-_ |        |        |
     *
     * ---
     *
     * _Supported in Grid Layout_
     *
     * | Chrome | Firefox |  Safari  |  Edge  | IE  |
     * | :----: | :-----: | :------: | :----: | :-: |
     * | **57** | **52**  | **10.1** | **16** | n/a |
     *
     * ---
     *
     * @see https://developer.mozilla.org/docs/Web/CSS/align-content
     */
  val alignContent: js.UndefOr[AlignContentProperty] = js.undefined
}

type AlignContentProperty = Globals | ContentDistribution | ContentPosition | csstypeLib.csstypeLibStrings.baseline | csstypeLib.csstypeLibStrings.normal | java.lang.String
type Globals = csstypeLib.csstypeLibStrings.`-moz-initial` | csstypeLib.csstypeLibStrings.inherit | csstypeLib.csstypeLibStrings.initial | csstypeLib.csstypeLibStrings.revert | csstypeLib.csstypeLibStrings.unset
type ContentDistribution = csstypeLib.csstypeLibStrings.`space-around` | csstypeLib.csstypeLibStrings.`space-between` | csstypeLib.csstypeLibStrings.`space-evenly` | csstypeLib.csstypeLibStrings.stretch
type ContentPosition = csstypeLib.csstypeLibStrings.center | csstypeLib.csstypeLibStrings.end | csstypeLib.csstypeLibStrings.`flex-end` | csstypeLib.csstypeLibStrings.`flex-start` | csstypeLib.csstypeLibStrings.start
```

Instantiating a single CSS style (for use in react, for instance) can add a second or two
 to your build time - Enjoy!

### Whatsup with strings?
The Javascript world is a stringly-typed world.
Typescript models the insanity with literal types.
Literal types are supposed to land in Scala 2.13/dotty, but we don't have them yet.
Even when we get them, erasure probably means they won't be too useful in this particular context.

Soo, we cheat a bit. Wondering about what those `csstypeLib.csstypeLibStrings` things above?
```scala
package typings
package csstypeLib

object csstypeLibStrings {
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
  def getContext(contextId: java.lang.String, contextAttributes: js.UndefOr[js.Object | CanvasRenderingContext2DSettings | WebGLContextAttributes]): CanvasRenderingContext2D | WebGLRenderingContext | scala.Null = js.native
}
```

But where would the fun be? And the type-safety? This is what we actually end up with:

```scala
@js.native
trait HTMLCanvasElement extends HTMLElement {
  def getContext(contextId: java.lang.String): CanvasRenderingContext2D | WebGLRenderingContext | scala.Null = js.native
  def getContext(contextId: java.lang.String, contextAttributes: js.Object): CanvasRenderingContext2D | WebGLRenderingContext | scala.Null = js.native
  @JSName("getContext")
  def getContext_2d(contextId: stdLib.stdLibStrings.`2d`): CanvasRenderingContext2D | scala.Null = js.native
  @JSName("getContext")
  def getContext_2d(contextId: stdLib.stdLibStrings.`2d`, contextAttributes: CanvasRenderingContext2DSettings): CanvasRenderingContext2D | scala.Null = js.native
  @JSName("getContext")
  def `getContext_experimental-webgl`(contextId: stdLib.stdLibStrings.`experimental-webgl`): WebGLRenderingContext | scala.Null = js.native
  @JSName("getContext")
  def `getContext_experimental-webgl`(contextId: stdLib.stdLibStrings.`experimental-webgl`, contextAttributes: WebGLContextAttributes): WebGLRenderingContext | scala.Null = js.native
  @JSName("getContext")
  def getContext_webgl(contextId: stdLib.stdLibStrings.webgl): WebGLRenderingContext | scala.Null = js.native
  @JSName("getContext")
  def getContext_webgl(contextId: stdLib.stdLibStrings.webgl, contextAttributes: WebGLContextAttributes): WebGLRenderingContext | scala.Null = js.native
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
  def addEventListener(`type`: java.lang.String): scala.Unit = js.native
  def addEventListener(`type`: java.lang.String, listener: EventListenerOrEventListenerObject): scala.Unit = js.native
  def addEventListener(`type`: java.lang.String, listener: EventListenerOrEventListenerObject, options: AddEventListenerOptions): scala.Unit = js.native
  def addEventListener(`type`: java.lang.String, listener: EventListenerOrEventListenerObject, options: scala.Boolean): scala.Unit = js.native
  def addEventListener(`type`: java.lang.String, listener: scala.Null, options: AddEventListenerOptions): scala.Unit = js.native
  def addEventListener(`type`: java.lang.String, listener: scala.Null, options: scala.Boolean): scala.Unit = js.native
}
type EventListenerOrEventListenerObject = EventListener | EventListenerObject

type EventListener = js.Function1[/* evt */ Event, scala.Unit]

trait EventListenerObject extends js.Object {
  def handleEvent(evt: Event): scala.Unit
}

```

The point is not necessarily that this is awesome, but that it compiles - even in
the presence of overrides in subclasses with different optionality of parameters

Let's have a look at `MediaStream` as well:
```scala

@js.native
trait MediaStream extends EventTarget {
  @JSName("addEventListener")
  def addEventListener_active(`type`: stdLib.stdLibStrings.active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _]): scala.Unit = js.native
  @JSName("addEventListener")
  def addEventListener_active(`type`: stdLib.stdLibStrings.active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _], options: AddEventListenerOptions): scala.Unit = js.native
  @JSName("addEventListener")
  def addEventListener_active(`type`: stdLib.stdLibStrings.active, listener: js.ThisFunction1[/* this */ this.type, /* ev */ Event, _], options: scala.Boolean): scala.Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: stdLib.stdLibStrings.addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _]): scala.Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: stdLib.stdLibStrings.addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _], options: AddEventListenerOptions): scala.Unit = js.native
  @JSName("addEventListener")
  def addEventListener_addtrack(`type`: stdLib.stdLibStrings.addtrack, listener: js.ThisFunction1[/* this */ this.type, /* ev */ MediaStreamTrackEvent, _], options: scala.Boolean): scala.Unit = js.native

```

- The general fallback definition of `addEventListener` is omitted since it didn't enrich what was defined in the superclass
- we use `this.type` to allow overrides which take the same callback function but with a more specific `this` context
- we expand the `<K extends keyof MediaStreamEventMap>` construct such that we maintain full type-safety of the callback based on the `type` parameter

Note also that this although this section mainly explores duplication of methods, there is also a consolidation step,
 which combines methods with the same JVM erasure, as Scala cares about that a lot.

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

Just to get things working, we mostly ignore the effects of the type mappings in Scala for now.
```scala
type Partial[T] = stdLib.stdLibStrings.Partial with T
type Pick[T, K /* <: java.lang.String */] = stdLib.stdLibStrings.Pick with T
type Record[K /* <: java.lang.String */, T] = stdLib.stdLibStrings.Record with js.Any
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
interface FooStatic{
    sayHello();
}

// in library foo-augmented
interface FooStatic{
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

"""

  def describeSize(locOutput: Option[String]) = locOutput match {
    case Some(output) =>
      s""":
```

$output
```
"""
    case None => " with millions of lines of code"
  }

  def contribs(summary: Summary) = {
    object ContribName {
      def unapply(s: TsIdentLibrary): Option[String] =
        if (s.value.endsWith("-contrib")) Some(s.value.replaceAllLiterally("-contrib", ""))
        else None
    }

    summary.successes
      .collect { case ContribName(name) => name }
      .map(x => "- " + s"[$x](contrib/$x)")
      .mkString("\n")
  }
}
