package ScalablyTyped
package AtStorybookVueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object AtStorybookVueModule {
  type StoryDecorator = js.Function2[
    /* story */ js.Function0[
      VueLib.VueTypesOptionsModule.ComponentOptions[
        VueLib.VueTypesVueModule.Vue, 
        VueLib.VueTypesOptionsModule.DefaultData[VueLib.VueTypesVueModule.Vue], 
        VueLib.VueTypesOptionsModule.DefaultMethods[VueLib.VueTypesVueModule.Vue], 
        VueLib.VueTypesOptionsModule.DefaultComputed, 
        VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]
      ]
    ], 
    /* context */ AtStorybookVueLib.Anon_Kind, 
    (VueLib.VueTypesOptionsModule.ComponentOptions[
      VueLib.VueTypesVueModule.Vue, 
      VueLib.VueTypesOptionsModule.DefaultData[VueLib.VueTypesVueModule.Vue], 
      VueLib.VueTypesOptionsModule.DefaultMethods[VueLib.VueTypesVueModule.Vue], 
      VueLib.VueTypesOptionsModule.DefaultComputed, 
      VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]
    ]) | scala.Null
  ]
  type StoryFunction = js.Function0[
    (VueLib.VueTypesOptionsModule.ComponentOptions[
      VueLib.VueTypesVueModule.Vue, 
      VueLib.VueTypesOptionsModule.DefaultData[VueLib.VueTypesVueModule.Vue], 
      VueLib.VueTypesOptionsModule.DefaultMethods[VueLib.VueTypesVueModule.Vue], 
      VueLib.VueTypesOptionsModule.DefaultComputed, 
      VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]
    ]) | java.lang.String
  ]
}
