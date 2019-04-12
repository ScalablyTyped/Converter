package typings
package atStorybookVueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object atStorybookVueMod {
  type Addon = org.scalablytyped.runtime.StringDictionary[
    js.Function2[/* storyName */ java.lang.String, /* storyFn */ StoryFunction, scala.Unit]
  ]
  type StoryDecorator = js.Function2[
    /* story */ js.Function0[
      vueLib.typesOptionsMod.ComponentOptions[
        vueLib.typesVueMod.Vue, 
        vueLib.typesOptionsMod.DefaultData[vueLib.typesVueMod.Vue], 
        vueLib.typesOptionsMod.DefaultMethods[vueLib.typesVueMod.Vue], 
        vueLib.typesOptionsMod.DefaultComputed, 
        vueLib.typesOptionsMod.PropsDefinition[vueLib.typesOptionsMod.DefaultProps]
      ]
    ], 
    /* context */ atStorybookVueLib.Anon_Kind, 
    (vueLib.typesOptionsMod.ComponentOptions[
      vueLib.typesVueMod.Vue, 
      vueLib.typesOptionsMod.DefaultData[vueLib.typesVueMod.Vue], 
      vueLib.typesOptionsMod.DefaultMethods[vueLib.typesVueMod.Vue], 
      vueLib.typesOptionsMod.DefaultComputed, 
      vueLib.typesOptionsMod.PropsDefinition[vueLib.typesOptionsMod.DefaultProps]
    ]) | scala.Null
  ]
  type StoryFunction = js.Function0[
    (vueLib.typesOptionsMod.ComponentOptions[
      vueLib.typesVueMod.Vue, 
      vueLib.typesOptionsMod.DefaultData[vueLib.typesVueMod.Vue], 
      vueLib.typesOptionsMod.DefaultMethods[vueLib.typesVueMod.Vue], 
      vueLib.typesOptionsMod.DefaultComputed, 
      vueLib.typesOptionsMod.PropsDefinition[vueLib.typesOptionsMod.DefaultProps]
    ]) | java.lang.String
  ]
}
