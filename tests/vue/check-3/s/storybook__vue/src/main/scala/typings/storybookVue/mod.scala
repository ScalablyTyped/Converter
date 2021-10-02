package typings.storybookVue

import org.scalablytyped.runtime.StringDictionary
import typings.storybookVue.anon.Kind
import typings.vue.optionsMod.ComponentOptions
import typings.vue.optionsMod.DefaultComputed
import typings.vue.optionsMod.DefaultData
import typings.vue.optionsMod.DefaultMethods
import typings.vue.optionsMod.DefaultProps
import typings.vue.optionsMod.PropsDefinition
import typings.vue.vueMod.Vue
import typings.webpackEnv.NodeModule
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@storybook/vue", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def addDecorator(decorator: StoryDecorator): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("addDecorator")(decorator.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  inline def configure(loaders: js.Function0[Unit], module: NodeModule): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("configure")(loaders.asInstanceOf[js.Any], module.asInstanceOf[js.Any])).asInstanceOf[Unit]
  
  inline def getStorybook(): js.Array[StoryStore] = ^.asInstanceOf[js.Dynamic].applyDynamic("getStorybook")().asInstanceOf[js.Array[StoryStore]]
  
  inline def setAddon(addon: Addon): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("setAddon")(addon.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  inline def storiesOf(kind: String, module: NodeModule): Story = (^.asInstanceOf[js.Dynamic].applyDynamic("storiesOf")(kind.asInstanceOf[js.Any], module.asInstanceOf[js.Any])).asInstanceOf[Story]
  
  type Addon = StringDictionary[js.Function2[/* storyName */ String, /* storyFn */ StoryFunction, Unit]]
  
  trait Story extends StObject {
    
    def add(storyName: String, getStory: StoryFunction): this.type
    
    def addDecorator(decorator: StoryDecorator): this.type
    
    val kind: String
  }
  object Story {
    
    inline def apply(add: (String, StoryFunction) => Story, addDecorator: StoryDecorator => Story, kind: String): Story = {
      val __obj = js.Dynamic.literal(add = js.Any.fromFunction2(add), addDecorator = js.Any.fromFunction1(addDecorator), kind = kind.asInstanceOf[js.Any])
      __obj.asInstanceOf[Story]
    }
    
    extension [Self <: Story](x: Self) {
      
      inline def setAdd(value: (String, StoryFunction) => Story): Self = StObject.set(x, "add", js.Any.fromFunction2(value))
      
      inline def setAddDecorator(value: StoryDecorator => Story): Self = StObject.set(x, "addDecorator", js.Any.fromFunction1(value))
      
      inline def setKind(value: String): Self = StObject.set(x, "kind", value.asInstanceOf[js.Any])
    }
  }
  
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
    /* context */ Kind, 
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
  
  trait StoryObject extends StObject {
    
    var name: String
    
    def render(): (ComponentOptions[
        Vue, 
        DefaultData[Vue], 
        DefaultMethods[Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]) | String
    @JSName("render")
    var render_Original: StoryFunction
  }
  object StoryObject {
    
    inline def apply(
      name: String,
      render: () => (ComponentOptions[
          Vue, 
          DefaultData[Vue], 
          DefaultMethods[Vue], 
          DefaultComputed, 
          PropsDefinition[DefaultProps]
        ]) | String
    ): StoryObject = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any], render = js.Any.fromFunction0(render))
      __obj.asInstanceOf[StoryObject]
    }
    
    extension [Self <: StoryObject](x: Self) {
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      inline def setRender(
        value: () => (ComponentOptions[
              Vue, 
              DefaultData[Vue], 
              DefaultMethods[Vue], 
              DefaultComputed, 
              PropsDefinition[DefaultProps]
            ]) | String
      ): Self = StObject.set(x, "render", js.Any.fromFunction0(value))
    }
  }
  
  trait StoryStore extends StObject {
    
    var fileName: js.UndefOr[String] = js.undefined
    
    var kind: String
    
    var stories: js.Array[StoryObject]
  }
  object StoryStore {
    
    inline def apply(kind: String, stories: js.Array[StoryObject]): StoryStore = {
      val __obj = js.Dynamic.literal(kind = kind.asInstanceOf[js.Any], stories = stories.asInstanceOf[js.Any])
      __obj.asInstanceOf[StoryStore]
    }
    
    extension [Self <: StoryStore](x: Self) {
      
      inline def setFileName(value: String): Self = StObject.set(x, "fileName", value.asInstanceOf[js.Any])
      
      inline def setFileNameUndefined: Self = StObject.set(x, "fileName", js.undefined)
      
      inline def setKind(value: String): Self = StObject.set(x, "kind", value.asInstanceOf[js.Any])
      
      inline def setStories(value: js.Array[StoryObject]): Self = StObject.set(x, "stories", value.asInstanceOf[js.Any])
      
      inline def setStoriesVarargs(value: StoryObject*): Self = StObject.set(x, "stories", js.Array(value*))
    }
  }
}
