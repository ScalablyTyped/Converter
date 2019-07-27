package typings
package atStorybookVueLib

import atStorybookVueLib.Anon_Kind
import org.scalablytyped.runtime.StringDictionary
import vueLib.typesOptionsMod.ComponentOptions
import vueLib.typesOptionsMod.DefaultComputed
import vueLib.typesOptionsMod.DefaultData
import vueLib.typesOptionsMod.DefaultMethods
import vueLib.typesOptionsMod.DefaultProps
import vueLib.typesOptionsMod.PropsDefinition
import vueLib.typesVueMod.Vue
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
