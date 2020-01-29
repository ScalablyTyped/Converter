---
id: about
title: Development
---

## Come help us work on ScalablyTyped!

Developing a compiler is complex. Testing it well is expensive, so we focus on getting as wide testing as possible for the time spent.
For that reason we have a few levels of testing:

### Unit tests
Only really used for the parser, but utterly necessary to write one. All changes to the parser should come with a corresponding unit test.

### [ImporterTest](https://github.com/ScalablyTyped/Converter/blob/master/importer/src/test/scala/org/scalablytyped/converter/internal/importer/ImporterTest.scala)
Built in the same spirit as the scala compiler's `partest`, this takes smallish [pieces of typescript](https://github.com/ScalablyTyped/Converter/tree/master/importer/src/test/resources) 
 code and run it through the entire pipeline, including `scalac`. These are relatively cheap (~30 seconds for all tests 
 if they all recompile), and covers a *lot* of ground. If you're making changes, you'll get quite a few answers here. 
 
Note that for non-CI machines we update the checked in conversion results directly, as long as `scalac` is happy.
This means that after successfully running the test, the next step is to review the git changes in `importer/src/test/resources/*/check`.
In CI it's enforced that the checked in results are current, so we know which commit introduces which change.  

### Demo set
Do your changes look good when running `ImporterTest`? The next step is to run the demo set. 

See [Running](running.md) for more information about the parameters.

A good command to run might be:
```
sbt:ScalablyTypedConverter> importer/runMain org.scalablytyped.converter.Main -softWrites -parseCache -offline -dontCleanProject -forceCommit -demoSet
```

Does any library fail? Fix it.

Does all libraries convert successfully? Inspect git changes.

### Full set
Did you make small innocent change and passed the demo set without problems? Skip this, it takes an hour or two, depending. 
 
Larger change? Run the command for demo set without the `-demoSet` option and go for a walk. 

### Pull request.
All changes go through a PR.   
