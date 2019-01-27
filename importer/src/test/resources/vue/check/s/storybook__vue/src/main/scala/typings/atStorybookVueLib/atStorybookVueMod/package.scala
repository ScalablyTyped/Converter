package typings
package atStorybookVueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object atStorybookVueMod {
  type StoryDecorator = js.Function2[
    /* story */ js.Function0[
      vueLib.optionsMod.ComponentOptions[
        vueLib.vueVueMod.Vue, 
        vueLib.optionsMod.DefaultData[vueLib.vueVueMod.Vue], 
        vueLib.optionsMod.DefaultMethods[vueLib.vueVueMod.Vue], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
      ]
    ], 
    /* context */ atStorybookVueLib.Anon_Kind, 
    (vueLib.optionsMod.ComponentOptions[
      vueLib.vueVueMod.Vue, 
      vueLib.optionsMod.DefaultData[vueLib.vueVueMod.Vue], 
      vueLib.optionsMod.DefaultMethods[vueLib.vueVueMod.Vue], 
      vueLib.optionsMod.DefaultComputed, 
      vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
    ]) | scala.Null
  ]
  type StoryFunction = js.Function0[
    (vueLib.optionsMod.ComponentOptions[
      vueLib.vueVueMod.Vue, 
      vueLib.optionsMod.DefaultData[vueLib.vueVueMod.Vue], 
      vueLib.optionsMod.DefaultMethods[vueLib.vueVueMod.Vue], 
      vueLib.optionsMod.DefaultComputed, 
      vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
    ]) | java.lang.String
  ]
}
