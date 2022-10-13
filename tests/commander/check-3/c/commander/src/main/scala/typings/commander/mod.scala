package typings.commander

import org.scalablytyped.runtime.Shortcut
import typings.commander.typingsMod.CommanderStatic
import typings.commander.typingsMod.local.Command
import typings.commander.typingsMod.local.Option
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inferred short module name */
object mod extends Shortcut {
  
  @JSImport("commander", JSImport.Namespace)
  @js.native
  val ^ : CommanderStatic = js.native
  
  /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
  @JSImport("commander", "Command")
  @js.native
  /**
    * Initialize a new `Command`.
    *
    * @param {string} [name]
    */
  open class CommandCls ()
    extends StObject
       with Command {
    def this(name: String) = this()
  }
  
  /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
  @JSImport("commander", "Option")
  @js.native
  open class OptionCls protected ()
    extends StObject
       with Option {
    /**
      * Initialize a new `Option` with the given `flags` and `description`.
      *
      * @param {string} flags
      * @param {string} [description]
      */
    def this(flags: String) = this()
    def this(flags: String, description: String) = this()
    
    /* CompleteClass */
    var bool: Boolean = js.native
    
    /* CompleteClass */
    var description: String = js.native
    
    /* CompleteClass */
    var flags: String = js.native
    
    /* CompleteClass */
    var long: String = js.native
    
    /* CompleteClass */
    var optional: Boolean = js.native
    
    /* CompleteClass */
    var required: Boolean = js.native
  }
  
  type _To = CommanderStatic
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: CommanderStatic = ^
}
