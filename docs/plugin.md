---
id: plugin
title: SBT plugin
---

The plugin uses [scalajs-bundler](https://scalacenter.github.io/scalajs-bundler/)
to download NPM packages, and translates typescript type definitions into Scala.js jars before your project compiles.

- [I can't/won't use scalajs-bundler](plugin-no-bundler.md)
- [I can't/won't use sbt](cli.md)

## I just want to see how it works

Then check out the demo projects:
- [Demos](https://github.com/ScalablyTyped/Demos)
- [React/Slinky demos](https://github.com/ScalablyTyped/SlinkyDemos)
- [React/Scalajs-react demos](https://github.com/ScalablyTyped/ScalajsReactDemos)

# Setup

## Notes

- Scalajs-bundler has some functionality where it picks up `npmDependencies` from your classpath.
This plugin generates parts of the classpath, so to avoid a circular dependency that functionality is disabled.
- You're only supposed to use the plugin once in your build. 
If you really want more than one conversion make sure to [shade](conversion-options.md#stoutputpackage) them into different packages

## Requirements

**This plugin needs sbt 1.4.x**. Not higher or lower. 
This is unfortunate, but some more design work is needed to avoid this.
The last version for sbt 1.3.x was 1.0.0-beta26. 

Since we generate source code, it should work with any combination of 
Scala 2.12 / 2.13 and Scala.js 1.x / 0.6.x 

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

While optional, it's recommended to have a look at [conversion options](conversion-options.md) to see what the possibilities are. 

# Now what?

Have a look at [Where do I start?](usage.md)
