---
id: plugin
title: SBT plugin
---

The plugin uses [scalajs-bundler](https://scalacenter.github.io/scalajs-bundler/)
to download NPM packages, and translates typescript type definitions into Scala.js jars before your project compiles.

- [I can't/won't use scalajs-bundler](plugin-no-bundler.md)
- [I can't/won't use sbt](cli.md)

# I just want to see how it works

Then check out the demo projects:
- [Demos](https://github.com/ScalablyTyped/Demos)
- [React/Slinky demos](https://github.com/ScalablyTyped/SlinkyDemos)
- `Scalajs-React demos` (help wanted!)

# Setup

## Note
Scalajs-bundler has some functionality where it picks up `npmDependencies` from your classpath.
This plugin generates parts of the classpath, so to avoid a circular dependency that functionality is disabled.

## Requirements

Due to conflicting scala library dependencies **this plugin needs sbt 1.3.0 or newer**.

Since we generate source code, it should work with any combination of 
Scala 2.12 / 2.13 and Scala.js 1.x / 0.6.x 

Note that the scalajs-react [flavour](flavour.md) won't work with Scala.js 1.x until the library has been updated. 
 
## Add to your `project/plugins.sbt`

```scala
resolvers += Resolver.bintrayRepo("oyvindberg", "converter")

// for Scala.js 1.x.x
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "@VERSION@")

// for Scala.js 0.6.x
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter06" % "@VERSION@")
```

## Activate the plugin for a project in your `build.sbt`:

```scala
project.enablePlugins(ScalablyTypedConverterPlugin)
```

## Setup your npm packages

```scala    
project.settings(
  Compile / npmDependencies ++= Seq(
    "react-router-dom" -> "5.1.2",
    "@types/react-router-dom" -> "5.1.2"
  )
)
```

Note that some packages contain first-party typescript type definitions, 
while for others like `react-router-dom` we need to get separate `@types` packages. 
These are originally from [DefinitelyTyped](https://github.com/DefinitelyTyped/DefinitelyTyped).  

Version numbers and `@types` packages are probably most conveniently found at [npmjs.com](https://npmjs.com).

## Choose your flavour (optional)

We have put a lot of effort into top-notch interop with two well-known 
Scala.js react wrapper libraries. If you want to use either make sure to choose the corresponding [flavour](flavour.md). 

### Slinky

```scala
project.settings(
 // for Slinky web projects
  stFlavour := Flavour.Slinky,
  // for Slinky native projects
  stFlavour := Flavour.SlinkyNative,
)
```

### Scalajs-react

```scala
project.settings(
  stFlavour := Flavour.Japgolly
)
```

## Use yarn instead of npm

The plugin checks for updated npm dependencies on each compile, and yarn responds much faster than npm.
 
Configure scalajs-bundler like this:
```scala
project.settings(
  useYarn := true
)
```
Yarn will need to be present on your system for this to work. You should also check in `yarn.lock`.

## How it works

Hopefully everything will work automatically. Change an npm dependency, reimport project, wait, voila. 


The plugin taps into the `allDependencies` task in sbt, and this has some consequences for how it works.

Whenever the task is evaluated, typically through a `compile` or an import into an IDE, the plugin

- Runs a customized version of `installNpmDependencies` from scalajs-bundler, changed to avoid touching the classpath.

- Computes a digest from the resulting `package.json` file and of the configuration of the plugin

- If we have a stored conversion with the given digest and if all the generated artifacts exist locally, we return those

- Otherwise we run converter, compiling only the missing libraries if any. Libraries are also digested by their contents, 
 to avoid unnecessary recompilations.

Importing a build with a configuration the machine has seen and compiled before should be very fast. 

## Customize the generated code

### `stIgnore`
There are a few reasons you might want to ignore things:
- A dependency of a library you want to use might fail conversion/compilation and you can try to salvage the situation by ignoring it.
- A dependency is slow to convert/build and you have no use for it
- A library has a circular set of dependencies (it's javascript, of course it happens) you might break the circuit by ignoring a library.

The consequence of ignoring a library is typically that whenever another library references something in it, 
that reference will be translated as `js.Any` with a comment (and there will be warnings when importing).

You cannot ignore the `std` library.
 
Some usage examples: 

- `csstype` is a type-only library from DefinitelyTyped which describes all of react CSS with Typescript interfaces, enabling
 type-safe use. It is a dependency of `react`, and used throughout that ecosystem. 
 This is something you either want, or don't care about. If you don't, you can exclude it like this: 

```scala
project.settings(
  stIgnore += "csstype"
)
```

- Let's say you want to use an old version of `material-ui` which comes bundled with 5000 icons, modelled as react component classes.
You also don't need the icons. If that's the case, you can also exclude prefixes of module names with the same mechanism

```scala
project.settings(
  stIgnore ++= List("material-ui/svg-icons")
)
```

### `stEnableScalaJsDefined` 

As explained in the corresponding [Scala.js documentation page](https://www.scala-js.org/doc/interoperability/sjs-defined-js-classes.html),
`@ScalaJSDefined` traits are more convenient because they can be `new`ed, extended and so on.

However, there an imperfection somewhere in Scala.js and/or scalac with handling huge amounts of annotations 
 which makes compilation of some libraries *insanely* much slower.
`@material-ui/core` takes ~600 seconds to compile with `@ScalaJSDefined` traits, and ~35 without. 

This setting also uses `Selection`, so an example usage is:
```scala
project.settings(
  stEnableScalaJsDefined := Selection.All()
)
```

By default this is off, that is `Selection.None()`

### `stStdLib`
This mirrors the `--lib` option to typescript, see 
[compiler options](https://www.typescriptlang.org/docs/handbook/compiler-options.html).

The main usage is to limit which DOM/Javascript APIs are available. 
For instance, a node application should not access the DOM at all, 
 and a browser application should only use things you have polyfilled.
      
```scala
project.settings(
  stStdlib := List("es6", "es2018.asyncgenerator")
)
```

Note that if you use `scala-js-dom` APIs they are naturally not affected.

Also note that if you use a [flavour](flavour.md) which translates types to `scala-js-dom` types, 
 only types found in the chosen stdlib will be translated.
 
### `stOutputPackage`
You can adjust the top-level package into which we put the generated code.
       
```scala
project.settings(
  stOutputPackage := "org.awesome.sauce",
)
```


### `stUseScalaJsDom`
When `true` (which is the default) uses scala-js-dom types when possible instead of types we translate from typescript in `std`.
`true` is also implied by the react flavours.

Benefit from setting to `false`:
- more comprehensive DOM API. scala-js-dom is nowhere close to the coverage typescript has. 
We keep all the generated types which dont exist in scala-js-dom, but the ones which are there will have fewer things defined on them.
- more coherent DOM API, since it will all be equal instead of belonging to two different worlds.

Benefit from keeping as `true`:
- less code to compile when `stMinimize` is enabled for `std`.
- easier interop with other Scala.js libraries

## Customize the build

Do you find the debug output tiring?

```scala
Global / stQuiet := true
```

By default we store caches and built artifacts in `~/.cache/scalablytyped` or a similar directory for your operating system.

If that doesn't suit you, you can specify another directory 

```scala
Global / stDir := file("/some/other/dir")
```

# Now what?

Have a look at [Where do I start?](usage.md)
