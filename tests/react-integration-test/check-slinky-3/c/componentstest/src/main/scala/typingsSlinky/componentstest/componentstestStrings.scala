package typingsSlinky.componentstest

import typingsSlinky.componentstest.textFieldMod.TextFieldVariants
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object componentstestStrings {
  
  @js.native
  sealed trait button extends StObject
  inline def button: button = "button".asInstanceOf[button]
  
  @js.native
  sealed trait filled
    extends StObject
       with TextFieldVariants
  inline def filled: filled = "filled".asInstanceOf[filled]
  
  @js.native
  sealed trait outlined
    extends StObject
       with TextFieldVariants
  inline def outlined: outlined = "outlined".asInstanceOf[outlined]
  
  @js.native
  sealed trait standard
    extends StObject
       with TextFieldVariants
  inline def standard: standard = "standard".asInstanceOf[standard]
  
  @js.native
  sealed trait variant extends StObject
  inline def variant: variant = "variant".asInstanceOf[variant]
}
