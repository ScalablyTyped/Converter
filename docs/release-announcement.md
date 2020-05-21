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

Once you factor in cross builds and flavours its impossible to keep a useful set of precompiled binaries.

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

## Get started

[with the sbt plugin](plugin.md)
