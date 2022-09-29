---
id: usage
title: What do I do now?
---


<br/>
**TL;DR**: Using a react flavour? look in `typings.<lib>.components`. Else look in `typings.<lib>.mod`.

<br/>

Ok, you generated thousands of lines of code. Great! Now how to use it?
(If you haven't, check [how to setup the plugin](plugin.md))

## Have a look around! 

The converter plugin generates source jars which are attached to your IDE, 
 as such you can browse just as any other library.
 
<video autoplay="autoplay" controls="true" muted="true" src="https://olvind.com/videos/navigation.mp4" height="744px" width="874"></video>

## Anatomy of a typing library

All typing libraries follow the same hierarchy. Not all libraries will have all these entities, and many will have
 a substantial amount of top-level traits in the root folder as well.

```text
typings
  foo
    anon/
    components/
    mod/
    *Mod/
    global/
    fooStrings.scala
    fooInts.scala
    fooBooleans.scala
    fooRequire.scala
    ... top-level types
```

For react it can look like this:
```text
typings
  react
    anon
    components
    experimentalMod
    mod
    package.scala
    reactBooleans.scala
    reactRequire.scala
    reactStrings.scala
```

### Modules 

Typically, you'll want to use Javascript modules. 
The key thing to note is that every possible Javascript module name get its own Scala package/object in ScalablyTyped.

React has two modules, `'react'` and `'react/experimental'`. The module which corresponds to the library itself 
(`'react'` here) by convention ends up as `mod`. Since most Javascript libraries export most things up to the top,
that's where you should look first.

All the other modules receive names ending in `Mod`. Since there was considerable pushback against directly translated 
 long package names (`reactExperimentalMod` in this case) they are abbreviated.

In this case `'react/experimental'` ends up as just `experimentalMod`.
  
### Globals

Some libraries such as std, node, electron and others offer some/all functionality through the global namespace.
To clarify when you make use of it, all global references are reachable through `typings.<lib>.global` 
(possibly with `_` suffix, in case of name clashes).
   
### React components

If you use a [react flavour](flavour.md), all generated components will be put in tje `typings.<lib>.components` package. 
   
### Anonymous interfaces

Typescript has a lot of unnamed types, which we try to give a name in ScalablyTyped.
Since these are not stable in the same sense as named API is stable, they are extracted into the `typings.<lib>.anon` package.
You won't always have a choice, but try to limit use of these.

### Extracted literals

Whenever concrete strings, numbers or booleans appear in source code, they are collected into objects and reused for 
 the entire typing library, see [encoding](encoding.md#whatsup-with-strings).
 
 These end up in for instance `typings.react.reactStrings`.
 
## I still cannot find out where to start!

Javascript libraries can work in so many different ways. Look at typescript examples and try to translate.

Here is one concrete pattern you might come across:

### jqueryui 
This is one of many libraries which work by monkey-patching jquery when loaded, as such there isn't really an "entry point",
 like most other libraries. In Typescript this is modelled with interface augmentation, which we don't have in Scala.js.
 
Your only hint from the code itself is that it has a [`JQuery`](https://github.com/ScalablyTyped/Distribution/blob/master/j/jqueryui/src/main/scala/typings/jqueryui/JQuery.scala) 
trait, same as `jquery` itself. The solution here is to ensure jqueryui is loaded by touching `typings.jqueryui.jqueryuiRequire`, and casting
`typings.jquery.JQuery` to `typings.jqueryui.JQuery`. 

See an entire solution in the [demo](https://github.com/ScalablyTyped/Demos/blob/master/jquery/src/main/scala/demo/JQueryDemo.scala)

