# Tso - Typescript to Scala converter

## Running
`Tso` is written to run in batch mode, and you can run the [main](importer/src/main/scala/com/olvind/tso/importer/Main.scala) 
 directly from from sbt (`importer/run`) or intellij. Since it's used both for development and for CI,
 it supports a bunch of command line options.

All parameters without a leading dash will be taken to be names of libraries to convert.

Specifying one or more libraries will put the converter in "debug mode". The only
 difference is that the UI is different, and no sbt plugin and commit is created.
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
| `-reactSlinky or -reactJapgolly | will use slinky or scalajs-react bindings for generating code that interacts with react

## Directories
By default, all files will be written to `~/tmp/tso-cache`. The only exception is the ivy artifacts, which are local-published
 to `~/.ivy2/local`.

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
