---
id: running
title: Running
---

In batch mode ScalablyTypedConverter will process all files from the [DefinitelyTyped](http://definitelytyped.org/) project, as well as a selection of libraries from npm.

You can run the [main](https://github.com/ScalablyTyped/Converter/blob/master/importer/src/main/scala/org/scalablytyped/converter/Main.scala) 
 directly from from sbt (`importer/run`) or intellij. Since it's used both for development and for CI,
 it supports a bunch of command line options.

All parameters without a leading dash will be taken to be names of libraries to convert.

Specifying one or more libraries will put the converter in "debug mode". The only difference is that the UI is different, and no sbt plugin and commit is created.
For development you'll always use "debug mode".
 
`Main` supports a bunch of command line options:

| option | description |
| --- | --- |
| `-conserveSpace`      | The CI server (and perhaps your developer laptop) doesn't have much hard drive space. This thins out the `node_modules` folder resulting from installing all the libraries outside DefinitelyTyped and keeps only what we need
| `-debugMode`          | Force debugMode
| `-demoSet`            | Adds the set of all libraries used in the [demos](https://github.com/oyvindberg/ScalablyTypedDemos/)
| `-dontCleanProject`   | Normally the CI build aggressively resets the ScalablyTyped git repo. Enabling this will skip that
| `-enableParseCache`   | The Typescript parser is somewhat slow. Enabling this uses java serialization to cache when possible 
| `-forceCommit`        | Commit and build sbt plugin in debug mode 
| `-scala212`           | Build libraries with Scala 2.12 instead of 2.13
| `-scalajs1`           | Build libraries with Scala.js 1 instead of 0.6 
| `-offline`            | Skip pulling newest DefinitelyTyped and running `npm update`
| `-parallel`           | Faster, but with some [issues](https://github.com/oyvindberg/ScalablyTypedConverter/issues/74). May deadlock or produce unrepeatable builds for now
| `-pedantic`           | Make the converter more strict. Most things don't work yet in this mode
| `-publish`            | Publish to bintray. You'll need credentials in `~/.bintray/.credentials`
| `-softWrites`         | Will only write changed/deleted files. This is essential if you want to keep ScalablyTyped products open in an IDE to avoid reindexing the world.
| `-flavourNormal`      | default 
| `-flavourSlinky`      | Use slinky flavour, integrate with scala-js-dom, and generate slinky components 
| `-flavourJapgolly`    | Use scalajs-react flavour, integrate with scala-js-dom, and generate scalajs-react components 
| `-useScalaJsDomTypes` | Rewrite types to use scala-js-dom types when using `-flavourNormal`  
| `-benchmark`          | Run a benchmark run. Typically use with `-demoSet`. Let it first run once to build/parsecache everything  
| `-enableImplicitOps`  | Enable implicit ops  

### Directories
By default, all files will be written to `~/.cache/scalablytyped`. The only exception is the ivy artifacts, which are local-published
 to `~/.ivy2/local`.
