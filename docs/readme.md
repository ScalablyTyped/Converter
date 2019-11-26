# Tso - Typescript to Scala converter

tso can be used in two modes:

## In batch mode

In batch mode tso will process all the files from the [DefinitelyTyped](http://definitelytyped.org/) project.

You can run the [main](importer/src/main/scala/com/olvind/tso/importer/Main.scala) 
 directly from from sbt (`importer/run`) or intellij. Since it's used both for development and for CI,
 it supports a bunch of command line options.

All parameters without a leading dash will be taken to be names of libraries to convert.

Specifying one or more libraries will put the converter in "debug mode". The only difference is that the UI is different, and no sbt plugin and commit is created.
For development you'll always use "debug mode".
 
`Main` supports a bunch of command line options:

| option | description |
| --- | --- |
| `-conserveSpace`    | The CI server (and perhaps your developer laptop) doesn't have much hard drive space. This thins out the `node_modules` folder resulting from installing all the libraries outside DefinitelyTyped and keeps only what we need
| `-debugMode`        | Force debugMode
| `-demoSet`          | Adds the set of all libraries used in the [demos](https://github.com/oyvindberg/ScalablyTypedDemos/)
| `-dontCleanProject` | Normally the CI build aggressively resets the ScalablyTyped git repo. Enabling this will skip that
| `-enableParseCache` | The Typescript parser is somewhat slow. Enabling this uses java serialization to cache when possible 
| `-forceCommit`      | Commit and build sbt plugin in debug mode 
| `-nextVersions`     | Build libraries with Scala 2.13 and Scala.js 1.0.0-M8 instead
| `-offline`          | Skip pulling newest DefinitelyTyped and running `npm update`
| `-pedantic`         | Make the converter more strict. Most things don't work yet in this mode
| `-publish`          | Publish to bintray. You'll need credentials in `~/.bintray/.credentials`
| `-sequential`       | We have some [issues](https://github.com/oyvindberg/tso/issues/74) with parallel conversion. For now it's a must for consistent CI builds
| `-softWrites`       | Will only write changed/deleted files. This is essential if you want to keep ScalablyTyped products open in an IDE to avoid reindexing the world.
| `-flavourPlain`     | Don't generate companion objects, react components and so on. Fastest.
| `-flavourNormal`    | (default, but need to specify if you want more flavours). 
| `-flavourSlinky`    | Use slinky flavour, integrate with scalajs-dom, and generate slinky components 
| `-flavourJapgolly`  | Use scalajs-react flavour, integrate with scalajs-dom, and generate scalajs-react components 

### Directories
By default, all files will be written to `~/tmp/tso-cache`. The only exception is the ivy artifacts, which are local-published
 to `~/.ivy2/local`.

## As an sbt plugin
If you have your own Typescript projects, or want to process just a very selected set of public projects, you can use our sbt plugin.
Take a look at our demo to see the plugin in action.

First, add to your project/plugins.sbt
```scala
  addSbtPlugin("com.olvind" % "sbt-scalablytypedconverter" % "@VERSION@")
```

Then, in your build.sbt add:
```scala
  .enablePlugins(ScalablyTypedConverterPlugin)
```

There's quite a few settings that you can use to tweak how tso will generate files. All of these are optional:

| option                 | description |
| ---                    | --- |
| `tsoImport`            |  | 
| `tsoIgnore`            | A list of js projects to ignore |
| `tsoFlavour`           | The options are Plain, Normal, Slinky or Japgolly |
| `tsoPrettyStringType`  | The options are Regular, Simplifying |
| `tsoMinimize`          | Helps you select which javascript projects will be minimized |
| `tsoStdLib`            | You can select which Standard Library To use |
| `tsoTypescriptVersion` | the Typescript Version |

## Development
Developing a compiler is complex. Testing it well is expensive, so we focus on getting as wide testing as possible for the time spent.
For that reason we have a few levels of testing:

### Unit tests
Only really used for the parser, but utterly necessary to write one. All changes to the parser should come with a corresponding unit test.

### [ImporterTest](importer/src/test/scala/com/olvind/tso/importer/ImporterTest.scala)
Built in the same spirit as the scala compiler's `partest`, this takes smallish [pieces of typescript](importer/src/test/resources) 
 code and run it through the entire pipeline, including `scalac`. These are relatively cheap (~30 seconds for all tests 
 if they all recompile), and covers a *lot* of ground. If you're making changes, you'll get quite a few answers here. 
 
Note that for non-CI machines we update the checked in conversion results directly, as long as `scalac` is happy.
This means that after successfully running the test, the next step is to review the git changes in `importer/src/test/resources/*/check`.
In CI it's enforced that the checked in results are current, so we know which commit introduces which change.  

### Demo set
Do your changes look good when running `ImporterTest`? The next step is to run `tso` on the demo set. 
A good command to run might be:
```
sbt:tso-public> importer/runMain com.olvind.tso.importer.Main -softWrites -parseCache -offline -dontCleanProject -forceCommit -demoSet
```

Does any library fail? Fix it.

Does all libraries convert successfully? Inspect git changes.

### Full set
Did you make small innocent change and passed the demo set without problems? Skip this, it takes an hour or two, depending. 
 
Larger change? Run the command for demo set without the `-demoSet` option and go for a walk. 

### Pull request.
All changes go through a PR.   

## Derived work
This project took [scala-js-ts-importer](http://github.com/sjrd/scala-js-ts-importer/) as a starting point,
and inherited a lot of decisions from it.

## License
Tso is distributed under the [Scala License](http://www.scala-lang.org/license.html).
 
