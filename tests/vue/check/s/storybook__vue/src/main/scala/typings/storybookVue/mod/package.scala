package typings.storybookVue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type Addon = org.scalablytyped.runtime.StringDictionary[
    js.Function2[
      /* storyName */ java.lang.String, 
      /* storyFn */ typings.storybookVue.mod.StoryFunction, 
      scala.Unit
    ]
  ]
  type StoryDecorator = js.Function2[
    /* story */ js.Function0[
      typings.vue.optionsMod.ComponentOptions[
        typings.vue.vueMod.Vue, 
        typings.vue.optionsMod.DefaultData[typings.vue.vueMod.Vue], 
        typings.vue.optionsMod.DefaultMethods[typings.vue.vueMod.Vue], 
        typings.vue.optionsMod.DefaultComputed, 
        typings.vue.optionsMod.PropsDefinition[typings.vue.optionsMod.DefaultProps]
      ]
    ], 
    /* context */ typings.storybookVue.AnonKind, 
    (typings.vue.optionsMod.ComponentOptions[
      typings.vue.vueMod.Vue, 
      typings.vue.optionsMod.DefaultData[typings.vue.vueMod.Vue], 
      typings.vue.optionsMod.DefaultMethods[typings.vue.vueMod.Vue], 
      typings.vue.optionsMod.DefaultComputed, 
      typings.vue.optionsMod.PropsDefinition[typings.vue.optionsMod.DefaultProps]
    ]) | scala.Null
  ]
  type StoryFunction = js.Function0[
    (typings.vue.optionsMod.ComponentOptions[
      typings.vue.vueMod.Vue, 
      typings.vue.optionsMod.DefaultData[typings.vue.vueMod.Vue], 
      typings.vue.optionsMod.DefaultMethods[typings.vue.vueMod.Vue], 
      typings.vue.optionsMod.DefaultComputed, 
      typings.vue.optionsMod.PropsDefinition[typings.vue.optionsMod.DefaultProps]
    ]) | java.lang.String
  ]
}
