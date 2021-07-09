package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Age extends StObject {
    
    var age: scala.Double = js.native
  }
  object Age {
    
    @scala.inline
    def apply(age: scala.Double): Age = {
      val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
      __obj.asInstanceOf[Age]
    }
    
    @scala.inline
    implicit class AgeMutableBuilder[Self <: Age] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Get extends StObject {
    
    def get(): js.UndefOr[scala.Double | Null] = js.native
    
    def set(): Unit = js.native
    def set(v: scala.Double): Unit = js.native
  }
  
  @js.native
  trait Name extends StObject {
    
    var name: String = js.native
  }
  object Name {
    
    @scala.inline
    def apply(name: String): Name = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Name]
    }
    
    @scala.inline
    implicit class NameMutableBuilder[Self <: Name] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Set extends StObject {
    
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
    implicit class SetMutableBuilder[Self <: Set] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setGet(value: () => String): Self = StObject.set(x, "get", js.Any.fromFunction0(value))
      
      @scala.inline
      def setSet(value: String => Unit): Self = StObject.set(x, "set", js.Any.fromFunction1(value))
    }
  }
}
