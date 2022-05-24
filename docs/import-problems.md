---
id: import-problems
title: What if I hit problems importing libraries?
---

The goal of ScalablyTyped is to enable conversion of 100% of valid Typescript type definition files to Scala.js. 
However, Typescript is a complex and evolving language, and inevitably there will be corner cases that it doesn't *yet* handle.

If you try the converter on a Typescript library and it doesn't terminate, runs out of memory on a large heap, or throws an exception, here's the process for diagnosing and fixing the problem:

1. Search for, or raise, an issue identifying the library you're importing and what's going wrong.

2. Work on a minimized test case for the failure. Create a PR branch on a fork. Import the full TS code example, placing it under `/tests/<library-name>/in/`. There are lots of existing examples to follow. You can ignore the `/tests/<library-name>/check/` directory.

   It's advisable to check the `package.json` of the library being imported to verify exactly which TS file is published to NPM.

3. Register the new TS directory in the [ImporterTest](https://github.com/ScalablyTyped/Converter/blob/master/importer/src/test/scala/org/scalablytyped/converter/internal/importer/ImporterTest.scala). 
You can try setting the `pedantic` flag to false initially. See [dev guidelines](devel/about.md) for further info.

4. Start `sbt`. Run the import tests `testOnly org.scalablytyped.converter.internal.importer.ImporterTest3`. Does the unit test run show the same failure that you saw during import? It should.

5. Minimize! The aim is to find the structure in the TS that is causing problems, while removing all irrelevant code. No sugar coating it - minimizing can be effort intensive with some trial-and-error. It's likely you can remove 95-99% of the TS. 

6. Send PR. A minimized failing test gives the maintainers a clear problem to fix. You can see an example PR at [#139](https://github.com/ScalablyTyped/Converter/pull/139)

## Finding clues with debugger

It is possible to run the converter, and the converter unit tests, in a debugger, which may yield clues to what's going wrong.

1. The easiest is to run the [CLI tool](cli.md) directly from your IDE. 
Install the libraries as described and start it in a debugger.

2. Set breakpoints or Pause debug to understand what the converter is doing when it fails. Eg if it is running out of memory, where is it executing when doing so?

3. One useful technique can be adding `println`s via the debugger. Set a Breakpoint, then uncheck **Suspend**, and instead check **Evaluate and Log**. You can enter an expression referring data in scope at the point. 
