package mylib.internal.baz.materialUi

import mylib.internal.baz.materialUi.MaterialUI.Styles.MuiTheme
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] object stylesMod {
  
  @JSImport("material-ui/styles", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def getMuiTheme(muiTheme: MuiTheme*): MuiTheme = ^.asInstanceOf[js.Dynamic].applyDynamic("getMuiTheme")(muiTheme.asInstanceOf[Seq[js.Any]]*).asInstanceOf[MuiTheme]
  
  @JSImport("material-ui/styles", "spacing")
  @js.native
  def spacing: Any = js.native
  inline def spacing_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("spacing")(x.asInstanceOf[js.Any])
  
  @JSImport("material-ui/styles", "transitions")
  @js.native
  def transitions: Any = js.native
  inline def transitions_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("transitions")(x.asInstanceOf[js.Any])
  
  @JSImport("material-ui/styles", "typography")
  @js.native
  def typography: Any = js.native
  inline def typography_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("typography")(x.asInstanceOf[js.Any])
  
  @JSImport("material-ui/styles", "zIndex")
  @js.native
  def zIndex: Any = js.native
  inline def zIndex_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("zIndex")(x.asInstanceOf[js.Any])
}
