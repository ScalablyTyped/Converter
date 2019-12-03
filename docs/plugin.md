---
id: plugin
title: SBT Plugin
---

#SBT Plugin

First, add to your project/plugins.sbt
```scala
  addSbtPlugin("com.olvind" % "sbt-scalablytypedconverter" % "@VERSION@")
```

Then, in your build.sbt add:
```scala
  .enablePlugins(ScalablyTypedConverterPlugin)
```

There's quite a few settings that you can use to tweak how tso will generate files. All of these are optional:

| option                 | description |
| ---                    | --- |
| `tsoImport`            |  | 
| `tsoIgnore`            | A list of js projects to ignore |
| `tsoFlavour`           | The options are Plain, Normal, Slinky or Japgolly |
| `tsoPrettyStringType`  | The options are Regular, Simplifying |
| `tsoMinimize`          | Helps you select which javascript projects will be minimized |
| `tsoStdLib`            | You can select which Standard Library To use |
| `tsoTypescriptVersion` | the Typescript Version |
