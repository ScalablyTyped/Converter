package typings.storybookVue.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StoryStore extends js.Object {
  
  var fileName: js.UndefOr[String] = js.native
  
  var kind: String = js.native
  
  var stories: js.Array[StoryObject] = js.native
}
object StoryStore {
  
  @scala.inline
  def apply(kind: String, stories: js.Array[StoryObject]): StoryStore = {
    val __obj = js.Dynamic.literal(kind = kind.asInstanceOf[js.Any], stories = stories.asInstanceOf[js.Any])
    __obj.asInstanceOf[StoryStore]
  }
  
  @scala.inline
  implicit class StoryStoreOps[Self <: StoryStore] (val x: Self) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setKind(value: String): Self = this.set("kind", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setStoriesVarargs(value: StoryObject*): Self = this.set("stories", js.Array(value :_*))
    
    @scala.inline
    def setStories(value: js.Array[StoryObject]): Self = this.set("stories", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFileName(value: String): Self = this.set("fileName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteFileName: Self = this.set("fileName", js.undefined)
  }
}
