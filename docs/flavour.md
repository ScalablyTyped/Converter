---
id: flavour
title: Flavour
---

ScalablyTyped flavours so far enables rich interop with react.

## I just want to see example code

- [Slinky](https://github.com/ScalablyTyped/SlinkyDemos)
- [Scalajs-react demos](https://github.com/ScalablyTyped/ScalajsReactDemos)

## Getting started

You first [setup your sbt build](plugin.md), and then specify which one you want like this:

```scala
project.settings(
 // for Slinky web projects
  stFlavour := Flavour.Slinky,
  // for Slinky native projects
  stFlavour := Flavour.SlinkyNative,
  // for scalajs-react projects
  stFlavour := Flavour.ScalajsReact
)
``` 

Then look in the `components` package of the generated libraries:
```scala
import typings.antd.components.Button
```

## How?
They all work quite similarly:
- Replace all possible type references from generated types to types from scala-js-dom and the relevant React wrapper
- Identify all react components
- Generate a scala package with all the necessary boilerplate to make usage smooth.


## Slinky

The following video showcases how the Slinky flavour works:

<video autoplay="autoplay" controls="true" muted="true" src="https://olvind.com/videos/slinky_demo.mp4" height="744px" width="874"></video>
