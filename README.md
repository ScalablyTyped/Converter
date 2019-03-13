# Tso - Typescript to Scala converter

### Haven't people already tried this?

There are heaps of other projects which does this for different languages, 
with different levels of effort put into them, and different degrees of success.

This is a small sample:
- [DefinitelyScala](https://definitelyscala.com/)
- [scala-js-ts-importer](http://github.com/sjrd/scala-js-ts-importer)
- [Retyped for C#](https://retyped.com)
- [ts2k for Kotlin](https://github.com/Kotlin/ts2kt)
- [ReasonablyTyped for Reason ML](https://rrdelaney.github.io/ReasonablyTyped/)
- [typescript2java](https://github.com/ltearno/typescript2java)

You'll see there are two projects which target Scala.
`scala-js-ts-importer` is Sebastien's original attempt from some years ago,
 which forms the basis for both `DefinitelyScala` and `ScalablyTyped`.
  
`DefinitelyScala` is an awesome project, but it's not finished. 
This project tries to pick up where it left off and finish the task.   

`tso` powers `ScalablyTyped` with a huge set of features not frequently found elsewhere:
- Parser for ~all of Typescript
- Keeps ~all comments
- Full handling of dependencies between libraries, including those outside of `DefinitelyTyped`
- Full implementation of the module system, which all useful javascript libraries rely on
- ~All types and values are fully resolved, across library boundaries
- A naming scheme to avoid name collisions
- Scala.js must abide by JVM rules, so we handle erasure, overloads, overrides, default parameters, `var` conflicts, inheritance conflicts, etc.
- Better user convenience by converting to `@ScalaJSDefined` traits
- Bridges gap between structural and nominal typing somewhat by a strong bias towards type aliases instead of traits
- Answers `typeof` queries and type lookups (`React.Props["children"]`) 
- Fills in defaulted type parameters

All these features combined enable us to rewrite a very high percentage of all typings, 
somewhere around 97-98% of the newest version of all libraries in the current set.  

### Derived work
This project took [scala-js-ts-importer](http://github.com/sjrd/scala-js-ts-importer/) as a starting point,
and inherited a lot of decisions from it.

## License

Tso is distributed under the [Scala License](http://www.scala-lang.org/license.html).
