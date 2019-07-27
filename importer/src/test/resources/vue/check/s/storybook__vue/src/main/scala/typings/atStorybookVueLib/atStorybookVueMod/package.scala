package typings.atStorybookVueLib

import org.scalablytyped.runtime.StringDictionary
import typings.atStorybookVueLib.Anon_Kind
import typings.vueLib.typesOptionsMod.ComponentOptions
import typings.vueLib.typesOptionsMod.DefaultComputed
import typings.vueLib.typesOptionsMod.DefaultData
import typings.vueLib.typesOptionsMod.DefaultMethods
import typings.vueLib.typesOptionsMod.DefaultProps
import typings.vueLib.typesOptionsMod.PropsDefinition
import typings.vueLib.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object atStorybookVueMod {
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
