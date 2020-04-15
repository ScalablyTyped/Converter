---
id: plugin-no-bundler
title: SBT plugin without scalajs-bundler
---

- [I want to use scalajs-bundler (recommended)](plugin.md)
- [I can't/won't use sbt](cli.md)

## Ensure you use the correct plugin

```scala
  project.enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
```

## Implement `externalNpm`

You need to implement the `externalNpm` task yourself.
You should call `npm` or `yarn` yourself, and return the directory where 
both `package.json` and `node_modules` can be found. 

This example uses the directory of the sbt project.
 
```scala
project.settings(
    externalNpm := {
      Process("yarn", baseDirectory.value).!
      baseDirectory.value
    }
)
```

## Follow the normal instructions

The rest of [Getting started with SBT plugin](plugin.md) applies.

You can check out the `storybook-react` and `react-native` demos in 
[SlinkyTypedDemos](https://github.com/oyvindberg/SlinkyTypedDemos/) 
for complete examples.
