package typings
package commanderLib.commanderMod.localNs

import commanderLib.commanderMod.CommandOptions
import commanderLib.commanderMod.ParseOptionsResult
import nodeLib.NodeJSNs.EventEmitter
import org.scalablytyped.runtime.StringDictionary
import stdLib.RegExp
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Command
  extends EventEmitter
     with /* key */ StringDictionary[js.Any] {
  var args: js.Array[String] = js.native
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
  def action(fn: js.Function1[/* repeated */ js.Any, Unit]): commanderLib.commanderMod.localNs.Command = js.native
  def alias(): String = js.native
  /**
    * Set an alias for the command.
    *
    * @param {string} alias
    * @return {(Command | string)}
    */
  def alias(alias: String): commanderLib.commanderMod.localNs.Command = js.native
  /**
    * Allow unknown options on the command line.
    *
    * @param {boolean} [arg] if `true` or omitted, no error will be thrown for unknown options.
    * @returns {Command} for chaining
    */
  def allowUnknownOption(): commanderLib.commanderMod.localNs.Command = js.native
  def allowUnknownOption(arg: Boolean): commanderLib.commanderMod.localNs.Command = js.native
  /**
    * Define argument syntax for the top-level command.
    *
    * @param {string} desc
    * @returns {Command} for chaining
    */
  def arguments(desc: String): commanderLib.commanderMod.localNs.Command = js.native
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
  def command(name: String): commanderLib.commanderMod.localNs.Command = js.native
  def command(name: String, desc: String): commanderLib.commanderMod.localNs.Command = js.native
  def command(name: String, desc: String, opts: CommandOptions): commanderLib.commanderMod.localNs.Command = js.native
  def description(): String = js.native
  /**
    * Set the description to `str`.
    *
    * @param {string} str
    * @return {(Command | string)}
    */
  def description(str: String): commanderLib.commanderMod.localNs.Command = js.native
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
  def name(str: String): commanderLib.commanderMod.localNs.Command = js.native
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
  def option(flags: String): commanderLib.commanderMod.localNs.Command = js.native
  def option(flags: String, description: String): commanderLib.commanderMod.localNs.Command = js.native
  def option(flags: String, description: String, defaultValue: js.Any): commanderLib.commanderMod.localNs.Command = js.native
  def option(flags: String, description: String, fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit]): commanderLib.commanderMod.localNs.Command = js.native
  def option(
    flags: String,
    description: String,
    fn: js.Function2[/* arg1 */ js.Any, /* arg2 */ js.Any, Unit],
    defaultValue: js.Any
  ): commanderLib.commanderMod.localNs.Command = js.native
  def option(flags: String, description: String, fn: RegExp): commanderLib.commanderMod.localNs.Command = js.native
  def option(flags: String, description: String, fn: RegExp, defaultValue: js.Any): commanderLib.commanderMod.localNs.Command = js.native
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
  def parse(argv: js.Array[String]): commanderLib.commanderMod.localNs.Command = js.native
  /**
    * Parse expected `args`.
    *
    * For example `["[type]"]` becomes `[{ required: false, name: 'type' }]`.
    *
    * @param {string[]} args
    * @returns {Command} for chaining
    */
  def parseExpectedArgs(args: js.Array[String]): commanderLib.commanderMod.localNs.Command = js.native
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
  def usage(str: String): commanderLib.commanderMod.localNs.Command = js.native
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
  def version(str: String): commanderLib.commanderMod.localNs.Command = js.native
  def version(str: String, flags: String): commanderLib.commanderMod.localNs.Command = js.native
}

