---
id: release-announcement
title: Beta release announcement!
---


It's a great pleasure to finally open source the ScalablyTyped converter 
 and release the project as an sbt plugin. 

You now decide your own Scala version, your own Scala.js version and your own versions of libraries.

All projects built with the plugin will now continue to build forever, as opposed to the old distribution method
 where libraries had to be culled every now and then.
 

## Important changes:

### The [published ScalablyTyped distribution](https://github.com/oyvindberg/ScalablyTyped) is deprecated.

Once you factor in cross builds and flavours it's impossible to keep a useful set of precompiled binaries.

Going forward it'll continue to serve as QA to ensure that we're able to 
 convert the newest versions of important libraries.

It'll also be updated immediately to the newest available versions, Scala 2.13 and Scala.js 1.0.0 pre-releases.

All usage should be migrated to the new plugin.

### Facades are deprecated
Most usage of facades have been to enable better usage with react.
This is now solved by [flavours](flavour.md) instead. 

In particular the react-facade which was widely used in the demos and saw some use outside is now deprecated.

If you want to keep using it feel free to copy it into your own repository (it's MIT licensed).

If we come across anything which is not solved by (potentially writing new) flavours, we can revisit this.

### New naming convention

One of the recognizable features of ScalablyTyped was the rather peculiar naming scheme which served to avoid name collisions.

The final feature which was merged before release was "adaptive naming", which manages the same while generating much nicer looking code.

It typically looked like this:
```scala
import typingsSlinky.reactDashRouter.reactDashRouterMod.RouteProps
```

After the change, the same import is now
```scala
import typingsSlinky.reactRouter.mod.RouteProps
```

Everyone migrating to the plugin from the ScalablyTyped distribution will have to rewrite most of their imports.
It should be easy once you see the pattern. Most module names will have lost part of it's prefix, and the top-level
module for each library is now simply called `mod`. 

Consult [this commit](https://github.com/ScalablyTyped/SlinkyTypedDemos/commit/e135fc55aeaf53162d9cd472f5cc0bee76bdabe0)
to see what was needed to port the Slinky demos.

