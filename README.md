# Tso - Typescript to Scala importer

The Typescript community has spent thousand upon thousand of hours typing up 
 javascript libraries in [DefinitelyTyped](http://definitelytyped.org/) and elsewhere.
 
Since [Scala.js](http://www.scala-js.org/) also has a need for this, we leverage their
 work to generate Scala.js versions of these libraries.   

The tool is written to work in batch mode, and generate and compile thousands of libraries
 at a time. It is absolutely possible for users to run it themselves as well, but we envision
 that most needs can be satisfied by users requesting a particular library published to npm.   

## Limitations

Typescript is explicitly designed to model all the insane things you can express in
 Javascript, while Scala.js is not. Particularity the type system differs throughout,
 so any conversion between them is best effort.
 
For users these changes manifest themselves mostly in two ways:

- Typescript is structurally typed, which means that types have subtyping relationships which
 don't transfer over to Scala (which is nominally typed). In other words, there
 will be times when you need to tell the Scala compiler about this by casting.
 
- Related with the first point, we simply don't support bounds now. Bounds in typescript
 are very rich, and most of that functionality doesn't transfer at all (type mappings in particular).
 In other words we are trading some typesafety for convenience here.

Also   

## Derived work

This project took [scala-js-ts-importer](http://github.com/sjrd/scala-js-ts-importer/) as a starting point,
and inherited a lot of decisions from it.

## License

Tso is distributed under the [Scala License](http://www.scala-lang.org/license.html).
