---
id: flavour
title: Flavour
---

ScalablyTyped flavours so far enables interop with react.

You specify which one you want like this:
```scala
project.settings(
 // for Slinky web projects
  stFlavour := Flavour.Slinky,
  // for Slinky native projects
  stFlavour := Flavour.SlinkyNative,
  // for scalajs-react projects
  stFlavour := Flavour.Japgolly
)
``` 

## How?
They all work quite similarly:
- Replace all possible type references from generated types to types from scala-js-dom and the relevant React wrapper
- Identify all react components
- Generate a scala package with all the necessary boilerplate to make usage smooth.

## Slinky

The following video showcases how the Slinky flavour works:

<video autoplay="autoplay" src="https://olvind.com/videos/slinky_demo.mp4" height="744px" width="874"></video>
