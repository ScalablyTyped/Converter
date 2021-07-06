package typingsJapgolly.reactContextmenu

import org.scalajs.dom.raw.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object actionsMod {
  
  @JSImport("react-contextmenu/modules/actions", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @scala.inline
  def hideMenu(): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("hideMenu")().asInstanceOf[Unit]
  @scala.inline
  def hideMenu(opts: js.Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("hideMenu")(opts.asInstanceOf[js.Any]).asInstanceOf[Unit]
  @scala.inline
  def hideMenu(opts: js.Any, target: HTMLElement): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("hideMenu")(opts.asInstanceOf[js.Any], target.asInstanceOf[js.Any])).asInstanceOf[Unit]
  @scala.inline
  def hideMenu(opts: Unit, target: HTMLElement): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("hideMenu")(opts.asInstanceOf[js.Any], target.asInstanceOf[js.Any])).asInstanceOf[Unit]
  
  @scala.inline
  def showMenu(): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("showMenu")().asInstanceOf[Unit]
  @scala.inline
  def showMenu(opts: js.Any): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("showMenu")(opts.asInstanceOf[js.Any]).asInstanceOf[Unit]
  @scala.inline
  def showMenu(opts: js.Any, target: HTMLElement): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("showMenu")(opts.asInstanceOf[js.Any], target.asInstanceOf[js.Any])).asInstanceOf[Unit]
  @scala.inline
  def showMenu(opts: Unit, target: HTMLElement): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("showMenu")(opts.asInstanceOf[js.Any], target.asInstanceOf[js.Any])).asInstanceOf[Unit]
}
