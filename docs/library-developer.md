---
id: library-developer
title: How to share code
---

If you want to distribute code written on top of ScalablyTyped, so there is a special workflow 
for producing free-standing libraries based on the generated code.

## Example project

Have a look at [mobx-slinky](https://github.com/ScalablyTyped/mobx-slinky)
 to get a taste of what's possible. It's published through bintray so you can test it
 in any Scala.js project.

# Setup

## Requirements

**This plugin needs sbt 1.8.x**.

Since we generate source code, it should work with any combination of 
Scala 2.12 / 2.13 / 3.2.0 and Scala.js 1.11+ 

Starting from 1.0.0-beta30, it is in many cases not possible to compile the generated code 
if you have the *macro paradise* plugin enabled, because of some old lingering bugs. 
So don't do that, it's a dead end anyway.

## Add to your `project/plugins.sbt`

```scala
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "@VERSION@")
```

## Activate the plugin for a project in your `build.sbt`:

```scala
project.enablePlugins(ScalablyTypedConverterGenSourcePlugin)
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

The conversion process itself is the same as the normal plugin, but the development process differs a bit:

- It supports minimizing transitive dependencies.
You typically want to focus on one library. The fact that it may use node, std, or whatever else is probably secondary.
You might even want to break such dependency chain explicitly for your users, so that all references to such libraries will end up as `js.Any` 

- You'll compile all the generated code completely normally as part of your build. 
The reason why this is beneficial for a distributing a library is that it'll be completely 
free-standing with no dependency on the plugin.

### Two different modes (`stSourceGenMode`)

- `stSourceGenMode := SourceGenMode.ResourceGenerator` (the default)

In this mode the plugin works as a source generator in sbt, and the source code will be placed in
`target/scala-2.13/src_managed/scalablytyped` (or similar)
 
- `stSourceGenMode := SourceGenMode.Manual(toDir: File)`
In this mode the plugin will only run when you run `stImport` manually, and you specify which directory
 the source files will be placed in. Note that the plugin *will delete any other files in this folder*,


### Compiling all that generated code

There may be a **lot**. 

[Ignoring libraries or modules (stIgnore)](conversion-options.md#stignore) will help, but our main tool here is called `stMinimize`.

By minimization we mean to remove everything from a library except what is referenced from somewhere else, so that
 things keep compiling.

The point is that you typically want everything from your main libraries, 
 but you care less about their (transitive) dependencies. 

Since you typically don't want to enumerate all transitive dependencies, the `Selection` helper type provided for this:

- `Selection.None` disables for all libraries (default)
- `Selection.NoneExcept(String*)` enables only given libraries 
- `Selection.All` enables for all libraries
- `Selection.AllExcept(String*)` enables only not given libraries (most useful) 

Using that, typical usage of `stMinimize` looks like this:

```scala
project.settings(
  Compile / stMinimize := Selection.AllExcept("axios", "material-ui", "mobx-react", "mobx")
)
``` 

Note that if you use a [react flavour](flavour.md) which generates a `components` package, all those
components are considered "entry points", and are not eligible for removal. 
In other words, if you use **only** react components from a library, it's fine to minimize that, too. 

### `stMinimizeKeep` 
If you want to just keep a few things from a library and minimize away the rest, there is also a mechanism for that.
The names you supply should be exactly as they appear in the generated scala code without the initial package prefix (typically `typings`).

```scala
project.settings(
  /* setup libraries */
  Compile / npmDependencies ++= Seq(
    "moment" -> "2.24.0",
    "react-big-calendar" -> "0.22",
    "@types/react-big-calendar" -> "0.22.3"
  ),
  /* say we want to minimize all */
  stMinimize := Selection.All,
  /* but keep these very specific things*/
  stMinimizeKeep ++= List(
    "moment.mod.^",
    "reactBigCalendar.mod.momentLocalizer",
    "reactBigCalendar.mod.View",
  ),
)
```

## Recommended settings

With [`stUseScalaJsDom`](conversion-options.md#stusescalajsdom) set to true, `stMinimize` which removes most unnecessary code
you should now have a reasonably small amount of code to compile.

With [`stOutputPackage`](conversion-options.md#stoutputpackage) it'll be shaded into another package so it won't clash with
other usage of ScalablyTyped.

A this point you can start adding your own code if wanted, and publish libraries completely 
free-standing libraries.

If you are only packaging a facade generated from scalablytyped, without any custom code, you are likely better by excluding the javadocs on the library package, which can be done with (sonatype requires the docs artifact to be uploaded even if it is empty):

```scala
    sources in (Compile, doc) := Nil,
```

## Troubleshooting

If you get Stackoverflow errors, make sure that the `-Ymacro-annotations` compiler option is not enabled, while this works fine on application development, it commonly causes issues on library development. 
