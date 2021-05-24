package typingsLaminar.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait CSSStyleSheet extends StyleSheet {
  
  def addRule(): Double = js.native
  def addRule(selector: js.UndefOr[scala.Nothing], style: js.UndefOr[scala.Nothing], index: Double): Double = js.native
  def addRule(selector: js.UndefOr[scala.Nothing], style: String): Double = js.native
  def addRule(selector: js.UndefOr[scala.Nothing], style: String, index: Double): Double = js.native
  def addRule(selector: String): Double = js.native
  def addRule(selector: String, style: js.UndefOr[scala.Nothing], index: Double): Double = js.native
  def addRule(selector: String, style: String): Double = js.native
  def addRule(selector: String, style: String, index: Double): Double = js.native
  
  val cssRules: org.scalajs.dom.raw.CSSRuleList = js.native
  
  def deleteRule(index: Double): Unit = js.native
  
  def insertRule(rule: String): Double = js.native
  def insertRule(rule: String, index: Double): Double = js.native
  
  val ownerRule: org.scalajs.dom.raw.CSSRule | Null = js.native
  
  def removeRule(): Unit = js.native
  def removeRule(index: Double): Unit = js.native
  
  val rules: org.scalajs.dom.raw.CSSRuleList = js.native
}
