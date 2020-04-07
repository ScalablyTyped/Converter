---
id: changelog
title: Changelog
---

## 1.0.0-beta9
[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta8...v1.0.0-beta9)

- Improved integration with scalajs-bundler, hopefully for the last time.
- Fixed handling of modules with explicit `/index` in the module name. This fixes babylonjs and probably other libraries.
- Generate `@ScalaJSDefined` traits in the presence of a member starting with `$`.

### Contributors
    11  Øyvind Raddum Berg
     2  Ben Hutchison

## 1.0.0-beta8
[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta7...v1.0.0-beta8)

Improve plugin behaviour and performance by only instantiating compiler, and only installing npm deps when needed, 
and not leaking file handles

Further contributions towards a working windows version. 

### Contributors
     7  Øyvind Raddum Berg
     2  Mykola Khoroshevskyi
     1  Anthony Cerruti

## 1.0.0-beta7
[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta6...v1.0.0-beta7)

Support running the plugin and CI build on windows.
If you see any further issues please file an [issue](https://github.com/ScalablyTyped/Converter/issues/new)

### Contributors
     7  Mykola Khoroshevskyi
     2  Øyvind Raddum Berg

## 1.0.0-beta6

[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta5...v1.0.0-beta6)

This is a big release because we finally enable expansion of [mapped types](https://www.typescriptlang.org/docs/handbook/advanced-types.html#mapped-types) for most static cases.

Given the following typescript definition:

```typescript
interface Person {
    name: string
    age: number
    favouriteColor: "red" | "blue"
}

declare const patch: (p: Person, pp: Pick<Partial<Person>, "name" | "age">) => Person;

``` 

We now end up with these Scala.js definitions:
```scala
trait Person extends js.Object {
  var age: Double = js.native
  var favouriteColor: red | blue = js.native
  var name: String = js.native
}

/* Inlined std.Pick<std.Partial<type-mappings.Person>, 'name' | 'age'> */
trait PickPartialPersonnameage extends js.Object {
  var age: js.UndefOr[Double] = js.native
  var name: js.UndefOr[String] = js.native
}

@JSGlobal("patch")
@js.native
object patch extends js.Object {
  def apply(p: Person, pp: PickPartialPersonnameage): Person = js.native
}
```

This functionality is widely used in typescript, so finally enabling this is a big improvement.

Note that the functionality has been enabled for a few 
[selected libraries](https://github.com/ScalablyTyped/Converter/pull/123/commits/b5ca33fc89ae5c387190117f6480195bd770174d#diff-dda33cf244aa28da6ffad51bad89b6ee) for quite a while.

Also note that this still has quite a few limitations, in particular it gives up when encountering most conditional types.
This can be improved down the road. This functionality will probably never be available for cases like `Partial<T>`.

### Improved naming scheme for anonymous object types

There has long been a naming scheme in order to name anonymous things like this:
```typescript
declare const foo: (someObject: {foo: number, bar?: string}) => void; 
```
```scala
@JSGlobal("foo")
@js.native
object foo extends js.Object {
  def apply(someObject: AnonFooBar): Unit = js.native
}
```

Since we suddenly got a lot more anonymous object types because of the expanded type mappings, the scheme needed some improvements.
Generated names like AnonFoo will generally be shorter than before.

### Rewritten tag detection in slinky flavour

For the slinky flavour the generated components receive an element type like `a`, `div`, etc.

This enables the user to supply DOM props with normal Slinky syntax. For instance a component like this
```scala
import slinky.web.html.button.tag
// import ...

object Paper
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  /* The following DOM/SVG props were specified: className, contentEditable, dangerouslySetInnerHTML, defaultChecked, defaultValue, dir, draggable, height, hidden, id, lang, placeholder, spellCheck, style, suppressContentEditableWarning, tabIndex, title, width */
  def apply(about: String = null /*, ... */) = ???
}
```
can be used like this
```scala
Paper(about = "foo")(className := "className")
```

After the rewrite both element detection and props trimming is much more reliable than before.

In particular we used to only check if the actual props matched the name of a prop for the identified element,
 now we only trim it if the type is exactly what the given element would accept.

### Improved parser
For better or worse ScalablyTyped has it's own parser. 
It received some improvements and is now able to parse 100% of DefinitelyTyped for the first time

### Improved plugin
- Fixed a bug where we compile the same library simultaneously and ended up with corrupt jar files. Fixed by a file-level lock
- Should now be less susceptible to OOM after a usage of a class loader cache was removed.

### Contributors
    17  Øyvind Raddum Berg
     1  Jocelyn Boullier
     1  Lorenzo Gabriele
     1  Mushtaq Ahmed

## 1.0.0-beta5
[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta4...v1.0.0-beta5)

- Full support for Scala.js 1.0.0
- Redesigned the sbt plugin to use `allDependencies` rather than `unmanagedDependencies`

### Contributors
    18  Øyvind Raddum Berg
     1  FabioPinheiro

## 1.0.0-beta4
[Full changelog](https://github.com/ScalablyTyped/Converter/compare/v1.0.0-beta3...v1.0.0-beta4)

Rewrote the plugin from just a source generator to compiling all the libraries for you. 
For most use cases this is a huge improvement.

### Contributors
     8  Øyvind Raddum Berg

## 1.0.0-beta3 and 1.0.0-beta2
Bugfix releases

## 1.0.0-beta1 - Beta release announcement!

It's a great pleasure to finally open source the ScalablyTyped converter 
 and release the project as an sbt plugin. 

You now decide your own Scala version, your own Scala.js version and your own versions of libraries.

All projects built with the plugin will now continue to build forever, as opposed to the old distribution method
 where libraries had to be culled every now and then.
 

## Important changes:

### The [published ScalablyTyped distribution](https://github.com/oyvindberg/ScalablyTyped) is deprecated.

Once you factor in cross builds and flavours it's impossible to keep a useful set of precompiled binaries.

Going forward it'll continue to serve as QA to ensure that we're able to 
 convert the newest versions of important libraries.

It'll also be updated immediately to the newest available versions, Scala 2.13 and Scala.js 1.0.0 pre-releases.

All usage should be migrated to the new plugin.

### Facades are deprecated
Most usage of facades have been to enable better usage with react.
This is now solved by [flavours](flavour.md) instead. 

In particular the react-facade which was widely used in the demos and saw some use outside is now deprecated.

If you want to keep using it feel free to copy it into your own repository (it's MIT licensed).

If we come across anything which is not solved by (potentially writing new) flavours, we can revisit this.

### New naming convention

One of the recognizable features of ScalablyTyped was the rather peculiar naming scheme which served to avoid name collisions.

The final feature which was merged before release was "adaptive naming", which manages the same while generating much nicer looking code.

It typically looked like this:
```scala
import typings.reactDashRouter.reactDashRouterMod.RouteProps
```

After the change, the same import is now
```scala
import typings.reactRouter.mod.RouteProps
```

Everyone migrating to the plugin from the ScalablyTyped distribution will have to rewrite most of their imports.
It should be easy once you see the pattern. Most module names will have lost part of it's prefix, and the top-level
module for each library is now simply called `mod`. 

Consult [this commit](https://github.com/ScalablyTyped/SlinkyTypedDemos/commit/e135fc55aeaf53162d9cd472f5cc0bee76bdabe0)
to see what was needed to port the Slinky demos.




