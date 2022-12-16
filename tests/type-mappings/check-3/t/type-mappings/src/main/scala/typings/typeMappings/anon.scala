package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Age extends StObject {
    
    var age: scala.Double
  }
  object Age {
    
    inline def apply(age: scala.Double): Age = {
      val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
      __obj.asInstanceOf[Age]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Age] (val x: Self) extends AnyVal {
      
      inline def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Get extends StObject {
    
    def get(): js.UndefOr[scala.Double | Null] = js.native
    
    def set(): Unit = js.native
    def set(v: scala.Double): Unit = js.native
  }
  
  trait Name extends StObject {
    
    var name: String
  }
  object Name {
    
    inline def apply(name: String): Name = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Name]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Name] (val x: Self) extends AnyVal {
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    }
  }
  
  trait Set extends StObject {
    
    def get(): String
    
    def set(v: String): Unit
  }
  object Set {
    
    inline def apply(get: () => String, set: String => Unit): Set = {
      val __obj = js.Dynamic.literal(get = js.Any.fromFunction0(get), set = js.Any.fromFunction1(set))
      __obj.asInstanceOf[Set]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Set] (val x: Self) extends AnyVal {
      
      inline def setGet(value: () => String): Self = StObject.set(x, "get", js.Any.fromFunction0(value))
      
      inline def setSet(value: String => Unit): Self = StObject.set(x, "set", js.Any.fromFunction1(value))
    }
  }
}
