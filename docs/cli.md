---
id: cli
title: Command line tool
---

- [I want to use sbt with scalajs-bundler (recommended)](plugin-no-bundler.md)
- [I want to use sbt without scalajs-bundler](cli.md)

The command line is the same functionality as the sbt plugin just without sbt.
You provide a directory where you have installed javascript packages so it has a `package.json` and a `node_modules`, 
optionally change some conversion options, 
and then start the conversion.

The output is a set of locally published jar files which you can paste into sbt 
or your build tool of choice.

## Running
The easiest way to run is with coursier's excellent runner.

1) Install the `cs` command with these instructions https://get-coursier.io/docs/cli-overview
2) Install the ScalablyTyped Converter (stc) `cs install stc`
3) Run `stc` (in a directory with package.json and node_modules) 


## Configuration
```
Usage: stc [options] [libs]

  -h, --help
  -v, --version
  -d, --directory <value>  Specify another directory instead of the current directory where your package.json and node_modules is
  --includeDev <value>     Include dev dependencies
  --includeProject <value>
                           Include project in current directory
  --useScalaJsDomTypes <value>
                           When true (which is the default) uses scala-js-dom types when possible instead of types we translate from typescript in std
  -f, --flavour <value>    One of normal, japgolly, slinky, slinky-native. See https://scalablytyped.org/docs/flavour
  --scalajs <value>        Scala.js version
  --scala <value>          Scala version
  --outputPackage <value>  Output package
  --enableScalaJSDefined <value>
                           Libraries you want to enable @ScalaJSDefined traits for.
  -s, --stdlib <value>     Which parts of typescript stdlib you want to enable
  --organization <value>   Organization used (locally) publish artifacts
  --ignoredLibs <value>    Libraries you want to ignore
  libs                     Libraries you want to convert from node_modules
```

## Publishing
The command line tool used to support publishing to bintray, but that service shut down.
As such, the flags `-publish-to-bintray-repo` and `--publish-git-repo-link` are now gone.
If you want this to return, make some noise (or a PR) at https://github.com/ScalablyTyped/Converter/issues/262

## Convert your Typescript project

If you happen to have a Typescript project, and you want to reuse parts of it for a Scala.js app 
 without going through npm we've got you covered.

This can enable all sorts of cool use cases where you can gradually migrate to or test Scala.js.
 
1) Build your Typescript project with --declaration so that it generates `.d.ts` files 
2) Run the cli tool from the project directory with `--includeProject=true`
 
Note, we use the name of the current directory as the library name. 
You might have to [tell webpack](https://webpack.js.org/configuration/resolve/#resolvealias)
 where to actually find it.
 

# Now what?

Have a look at [Where do I start?](usage.md)
