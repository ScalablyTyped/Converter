package typings.storybookVue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import org.scalablytyped.runtime.StringDictionary
  import typings.storybookVue.AnonKind
  import typings.vue.optionsMod.ComponentOptions
  import typings.vue.optionsMod.DefaultComputed
  import typings.vue.optionsMod.DefaultData
  import typings.vue.optionsMod.DefaultMethods
  import typings.vue.optionsMod.DefaultProps
  import typings.vue.optionsMod.PropsDefinition
  import typings.vue.vueMod.Vue

  type Addon = StringDictionary[js.Function2[/* storyName */ String, /* storyFn */ StoryFunction, Unit]]
  type StoryDecorator = js.Function2[
    /* story */ js.Function0[
      ComponentOptions[
        Vue, 
        DefaultData[Vue], 
        DefaultMethods[Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]
    ], 
    /* context */ AnonKind, 
    (ComponentOptions[
      Vue, 
      DefaultData[Vue], 
      DefaultMethods[Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | Null
  ]
  type StoryFunction = js.Function0[
    (ComponentOptions[
      Vue, 
      DefaultData[Vue], 
      DefaultMethods[Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | String
  ]
}
