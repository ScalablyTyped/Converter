package typings.nonNullable

import typings.nonNullable.anon.Badge
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("non-nullable", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def badge(props: BadgeBadgeProps): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("badge")(props.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  @JSImport("non-nullable", "name")
  @js.native
  val name: String = js.native
  
  /* Inlined std.NonNullable<non-nullable.non-nullable.RootSlotProps> */
  object other {
    
    @JSImport("non-nullable", "other")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("non-nullable", "other.className")
    @js.native
    def className: js.UndefOr[String] = js.native
    inline def className_=(x: js.UndefOr[String]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("className")(x.asInstanceOf[js.Any])
  }
  
  inline def root(props: BadgeRootProps): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("root")(props.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  type BadgeBadgeProps = js.UndefOr[BadgeSlotProps]
  
  trait BadgeOwnProps extends StObject {
    
    var slotProps: js.UndefOr[Badge] = js.undefined
  }
  object BadgeOwnProps {
    
    inline def apply(): BadgeOwnProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[BadgeOwnProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: BadgeOwnProps] (val x: Self) extends AnyVal {
      
      inline def setSlotProps(value: Badge): Self = StObject.set(x, "slotProps", value.asInstanceOf[js.Any])
      
      inline def setSlotPropsUndefined: Self = StObject.set(x, "slotProps", js.undefined)
    }
  }
  
  type BadgeRootProps = js.UndefOr[RootSlotProps]
  
  trait BadgeSlotProps extends StObject {
    
    var max: js.UndefOr[Double] = js.undefined
  }
  object BadgeSlotProps {
    
    inline def apply(): BadgeSlotProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[BadgeSlotProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: BadgeSlotProps] (val x: Self) extends AnyVal {
      
      inline def setMax(value: Double): Self = StObject.set(x, "max", value.asInstanceOf[js.Any])
      
      inline def setMaxUndefined: Self = StObject.set(x, "max", js.undefined)
    }
  }
  
  trait BadgeTypeMap[AdditionalProps] extends StObject {
    
    var props: AdditionalProps & BadgeOwnProps
  }
  object BadgeTypeMap {
    
    inline def apply[AdditionalProps](props: AdditionalProps & BadgeOwnProps): BadgeTypeMap[AdditionalProps] = {
      val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
      __obj.asInstanceOf[BadgeTypeMap[AdditionalProps]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: BadgeTypeMap[?], AdditionalProps] (val x: Self & BadgeTypeMap[AdditionalProps]) extends AnyVal {
      
      inline def setProps(value: AdditionalProps & BadgeOwnProps): Self = StObject.set(x, "props", value.asInstanceOf[js.Any])
    }
  }
  
  trait RootSlotProps extends StObject {
    
    var className: js.UndefOr[String] = js.undefined
  }
  object RootSlotProps {
    
    inline def apply(): RootSlotProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[RootSlotProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: RootSlotProps] (val x: Self) extends AnyVal {
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
    }
  }
}
