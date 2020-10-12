package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Age extends js.Object {
    
    var age: scala.Double = js.native
  }
  object Age {
    
    @scala.inline
    def apply(age: scala.Double): Age = {
      val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
      __obj.asInstanceOf[Age]
    }
    
    @scala.inline
    implicit class AgeOps[Self <: Age] (val x: Self) extends AnyVal {
      
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
      def setAge(value: scala.Double): Self = this.set("age", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Get extends js.Object {
    
    def get(): js.UndefOr[scala.Double | Null] = js.native
    
    def set(): Unit = js.native
    def set(v: scala.Double): Unit = js.native
  }
  
  @js.native
  trait Name extends js.Object {
    
    var name: String = js.native
  }
  object Name {
    
    @scala.inline
    def apply(name: String): Name = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Name]
    }
    
    @scala.inline
    implicit class NameOps[Self <: Name] (val x: Self) extends AnyVal {
      
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
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Set extends js.Object {
    
    def get(): String = js.native
    
    def set(v: String): Unit = js.native
  }
  object Set {
    
    @scala.inline
    def apply(get: () => String, set: String => Unit): Set = {
      val __obj = js.Dynamic.literal(get = js.Any.fromFunction0(get), set = js.Any.fromFunction1(set))
      __obj.asInstanceOf[Set]
    }
    
    @scala.inline
    implicit class SetOps[Self <: Set] (val x: Self) extends AnyVal {
      
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
      def setGet(value: () => String): Self = this.set("get", js.Any.fromFunction0(value))
      
      @scala.inline
      def setSet(value: String => Unit): Self = this.set("set", js.Any.fromFunction1(value))
    }
  }
}
