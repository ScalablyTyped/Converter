package typings.storybookVue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import org.scalablytyped.runtime.StringDictionary
  import typings.storybookVue.Anon_Kind
  import typings.vue.mod.types.options.ComponentOptions
  import typings.vue.mod.types.options.DefaultComputed
  import typings.vue.mod.types.options.DefaultData
  import typings.vue.mod.types.options.DefaultMethods
  import typings.vue.mod.types.options.DefaultProps
  import typings.vue.mod.types.options.PropsDefinition
  import typings.vue.mod.types.vue.Vue

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
    /* context */ Anon_Kind, 
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
