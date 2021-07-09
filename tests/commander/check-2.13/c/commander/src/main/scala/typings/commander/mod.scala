package typings.commander

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import typings.node.NodeJS.EventEmitter
import typings.std.RegExp
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
  class CommandCls ()
    extends StObject
       with typings.commander.mod.local.Command {
    def this(name: String) = this()
  }
  
  /* This class was inferred from a value with a constructor, it was renamed because a distinct type already exists with the same name. */
  @JSImport("commander", "Option")
  @js.native
  class OptionCls protected ()
    extends StObject
       with typings.commander.mod.local.Option {
    /**
      * Initialize a new `Option` with the given `flags` and `description`.
      *
      * @param {string} flags
      * @param {string} [description]
      */
    def this(flags: String) = this()
    def this(flags: String, description: String) = this()
  }
  
  type Command = typings.commander.mod.local.Command
  
  @js.native
  trait CommandOptions extends StObject {
    
    var isDefault: js.UndefOr[Boolean] = js.native
    
    var noHelp: js.UndefOr[Boolean] = js.native
  }
  object CommandOptions {
    
    @scala.inline
    def apply(): CommandOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[CommandOptions]
    }
    
    @scala.inline
    implicit class CommandOptionsMutableBuilder[Self <: CommandOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setIsDefault(value: Boolean): Self = StObject.set(x, "isDefault", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setIsDefaultUndefined: Self = StObject.set(x, "isDefault", js.undefined)
      
      @scala.inline
      def setNoHelp(value: Boolean): Self = StObject.set(x, "noHelp", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoHelpUndefined: Self = StObject.set(x, "noHelp", js.undefined)
    }
  }
  
  @js.native
  trait CommanderStatic
    extends StObject
       with typings.commander.mod.local.Command {
    
    var Command: Instantiable1[/* name */ js.UndefOr[String], typings.commander.mod.local.Command] = js.native
    
    var CommandOptions: typings.commander.mod.CommandOptions = js.native
    
    var Option: Instantiable2[
        /* flags */ String, 
        /* description */ js.UndefOr[String], 
        typings.commander.mod.local.Option
      ] = js.native
    
    var ParseOptionsResult: typings.commander.mod.ParseOptionsResult = js.native
  }
  
  type Option = typings.commander.mod.local.Option
  
  @js.native
  trait ParseOptionsResult extends StObject {
    
    var args: js.Array[String] = js.native
    
    var unknown: js.Array[String] = js.native
  }
  object ParseOptionsResult {
    
    @scala.inline
    def apply(args: js.Array[String], unknown: js.Array[String]): ParseOptionsResult = {
      val __obj = js.Dynamic.literal(args = args.asInstanceOf[js.Any], unknown = unknown.asInstanceOf[js.Any])
      __obj.asInstanceOf[ParseOptionsResult]
    }
    
    @scala.inline
    implicit class ParseOptionsResultMutableBuilder[Self <: ParseOptionsResult] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setArgs(value: js.Array[String]): Self = StObject.set(x, "args", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setArgsVarargs(value: String*): Self = StObject.set(x, "args", js.Array(value :_*))
      
      @scala.inline
      def setUnknown(value: js.Array[String]): Self = StObject.set(x, "unknown", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUnknownVarargs(value: String*): Self = StObject.set(x, "unknown", js.Array(value :_*))
    }
  }
  
  type _To = CommanderStatic
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: CommanderStatic = ^
  
  object local {
    
    @js.native
    trait Command
      extends StObject
         with EventEmitter
         with /* key */ StringDictionary[js.Any] {
      
      /**
        * Register callback `fn` for the command.
        *
        * @example
        *      program
        *        .command('help')
        *        .description('display verbose help')
        *        .action(function() {
        *           // output help here
        *        });
        *
        * @param {(...args: any[]) => void} fn
        * @returns {Command} for chaining
        */
      def action(fn: js.Function1[/* repeated */ js.Any, Unit]): typings.commander.mod.local.Command = js.native
      
      def alias(): String = js.native
      /**
        * Set an alias for the command.
        *
        * @param {string} alias
        * @return {(Command | string)}
        */
      def alias(alias: String): typings.commander.mod.local.Command = js.native
      
      /**
        * Allow unknown options on the command line.
        *
        * @param {boolean} [arg] if `true` or omitted, no error will be thrown for unknown options.
        * @returns {Command} for chaining
        */
      def allowUnknownOption(): typings.commander.mod.local.Command = js.native
      def allowUnknownOption(arg: Boolean): typings.commander.mod.local.Command = js.native
      
      var args: js.Array[String] = js.native
      
      /**
        * Define argument syntax for the top-level command.
        *
        * @param {string} desc
        * @returns {Command} for chaining
        */
      def arguments(desc: String): typings.commander.mod.local.Command = js.native
      
      /**
        * Add command `name`.
        *
        * The `.action()` callback is invoked when the
        * command `name` is specified via __ARGV__,
        * and the remaining arguments are applied to the
        * function for access.
        *
        * When the `name` is "*" an un-matched command
        * will be passed as the first arg, followed by
        * the rest of __ARGV__ remaining.
        *
        * @example
        *      program
        *        .version('0.0.1')
        *        .option('-C, --chdir <path>', 'change the working directory')
        *        .option('-c, --config <path>', 'set config path. defaults to ./deploy.conf')
        *        .option('-T, --no-tests', 'ignore test hook')
        *
        *      program
        *        .command('setup')
        *        .description('run remote setup commands')
        *        .action(function() {
        *          console.log('setup');
        *        });
        *
        *      program
        *        .command('exec <cmd>')
        *        .description('run the given remote command')
        *        .action(function(cmd) {
        *          console.log('exec "%s"', cmd);
        *        });
        *
        *      program
        *        .command('teardown <dir> [otherDirs...]')
        *        .description('run teardown commands')
        *        .action(function(dir, otherDirs) {
        *          console.log('dir "%s"', dir);
        *          if (otherDirs) {
        *            otherDirs.forEach(function (oDir) {
        *              console.log('dir "%s"', oDir);
        *            });
        *          }
        *        });
        *
        *      program
        *        .command('*')
        *        .description('deploy the given env')
        *        .action(function(env) {
        *          console.log('deploying "%s"', env);
        *        });
        *
        *      program.parse(process.argv);
        *
        * @param {string} name
        * @param {string} [desc] for git-style sub-commands
        * @param {CommandOptions} [opts] command options
        * @returns {Command} the new command
        */
      def command(name: String): typings.commander.mod.local.Command = js.native
      def command(name: String, desc: String): typings.commander.mod.local.Command = js.native
      def command(name: String, desc: String, opts: CommandOptions): typings.commander.mod.local.Command = js.native
      def command(name: String, desc: Unit, opts: CommandOptions): typings.commander.mod.local.Command = js.native
      
      def description(): String = js.native
      /**
        * Set the description to `str`.
        *
        * @param {string} str
        * @return {(Command | string)}
        */
      def description(str: String): typings.commander.mod.local.Command = js.native
      
      /** Output help information and exit.
        *
        * @param {(str: string) => string} [cb]
        */
      def help(): Unit = js.native
      def help(cb: js.Function1[/* str */ String, String]): Unit = js.native
      
      /**
        * Get the name of the command.
        *
        * @return {string}
        */
      def name(): String = js.native
      /**
        * Set the name of the command.
        *
        * @param {string} str
        * @return {Command}
        */
      def name(str: String): typings.commander.mod.local.Command = js.native
      
      /**
        * Define option with `flags`, `description` and optional
        * coercion `fn`.
        *
        * The `flags` string should contain both the short and long flags,
        * separated by comma, a pipe or space. The following are all valid
        * all will output this way when `--help` is used.
        *
        *    "-p, --pepper"
        *    "-p|--pepper"
        *    "-p --pepper"
        *
        * @example
        *     // simple boolean defaulting to false
        *     program.option('-p, --pepper', 'add pepper');
        *
        *     --pepper
        *     program.pepper
        *     // => Boolean
        *
        *     // simple boolean defaulting to true
        *     program.option('-C, --no-cheese', 'remove cheese');
        *
        *     program.cheese
        *     // => true
        *
        *     --no-cheese
        *     program.cheese
        *     // => false
        *
        *     // required argument
        *     program.option('-C, --chdir <path>', 'change the working directory');
        *
        *     --chdir /tmp
        *     program.chdir
        *     // => "/tmp"
        *
        *     // optional argument
        *     program.option('-c, --cheese [type]', 'add cheese [marble]');
        *
        * @param {string} flags
        * @param {string} [description]
        * @param {((arg1: any, arg2: any) => void) | RegExp} [fn] function or default
        * @param {*} [defaultValue]
        * @returns {Command} for chaining
        */
      def option(flags: String): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String, fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit]): typings.commander.mod.local.Command = js.native
      def option(
        flags: String,
        description: String,
        fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit],
        defaultValue: js.Any
      ): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String, fn: Unit, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String, fn: RegExp): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: String, fn: RegExp, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: Unit, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: Unit, fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit]): typings.commander.mod.local.Command = js.native
      def option(
        flags: String,
        description: Unit,
        fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit],
        defaultValue: js.Any
      ): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: Unit, fn: Unit, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: Unit, fn: RegExp): typings.commander.mod.local.Command = js.native
      def option(flags: String, description: Unit, fn: RegExp, defaultValue: js.Any): typings.commander.mod.local.Command = js.native
      
      /**
        * Return an object containing options as key-value pairs
        *
        * @returns {{[key: string]: string}}
        */
      def opts(): StringDictionary[String] = js.native
      
      /**
        * Output help information for this command.
        *
        * @param {(str: string) => string} [cb]
        */
      def outputHelp(): Unit = js.native
      def outputHelp(cb: js.Function1[/* str */ String, String]): Unit = js.native
      
      /**
        * Parse `argv`, settings options and invoking commands when defined.
        *
        * @param {string[]} argv
        * @returns {Command} for chaining
        */
      def parse(argv: js.Array[String]): typings.commander.mod.local.Command = js.native
      
      /**
        * Parse expected `args`.
        *
        * For example `["[type]"]` becomes `[{ required: false, name: 'type' }]`.
        *
        * @param {string[]} args
        * @returns {Command} for chaining
        */
      def parseExpectedArgs(args: js.Array[String]): typings.commander.mod.local.Command = js.native
      
      /**
        * Parse options from `argv` returning `argv` void of these options.
        *
        * @param {string[]} argv
        * @returns {ParseOptionsResult}
        */
      def parseOptions(argv: js.Array[String]): ParseOptionsResult = js.native
      
      def usage(): String = js.native
      /**
        * Set or get the command usage.
        *
        * @param {string} str
        * @return {(Command | string)}
        */
      def usage(str: String): typings.commander.mod.local.Command = js.native
      
      /**
        * Set the program version to `str`.
        *
        * This method auto-registers the "-V, --version" flag
        * which will print the version number when passed.
        *
        * @param {string} str
        * @param {string} [flags]
        * @returns {Command} for chaining
        */
      def version(str: String): typings.commander.mod.local.Command = js.native
      def version(str: String, flags: String): typings.commander.mod.local.Command = js.native
    }
    
    @js.native
    trait Option extends StObject {
      
      var bool: Boolean = js.native
      
      var description: String = js.native
      
      var flags: String = js.native
      
      var long: String = js.native
      
      var optional: Boolean = js.native
      
      var required: Boolean = js.native
      
      var short: js.UndefOr[String] = js.native
    }
    object Option {
      
      @scala.inline
      def apply(
        bool: Boolean,
        description: String,
        flags: String,
        long: String,
        optional: Boolean,
        required: Boolean
      ): typings.commander.mod.local.Option = {
        val __obj = js.Dynamic.literal(bool = bool.asInstanceOf[js.Any], description = description.asInstanceOf[js.Any], flags = flags.asInstanceOf[js.Any], long = long.asInstanceOf[js.Any], optional = optional.asInstanceOf[js.Any], required = required.asInstanceOf[js.Any])
        __obj.asInstanceOf[typings.commander.mod.local.Option]
      }
      
      @scala.inline
      implicit class OptionMutableBuilder[Self <: typings.commander.mod.local.Option] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setBool(value: Boolean): Self = StObject.set(x, "bool", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setDescription(value: String): Self = StObject.set(x, "description", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setFlags(value: String): Self = StObject.set(x, "flags", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setLong(value: String): Self = StObject.set(x, "long", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setOptional(value: Boolean): Self = StObject.set(x, "optional", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setRequired(value: Boolean): Self = StObject.set(x, "required", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setShort(value: String): Self = StObject.set(x, "short", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setShortUndefined: Self = StObject.set(x, "short", js.undefined)
      }
    }
  }
}
