package ScalablyTyped.runtime

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}

/**
  * This is a copy of `scala.scalajs.js.Symbol` with more static symbols added.
  *
  * Let's consider this a hack and replace it sometime. The problem is
  * that the `JSName` is veery picky about where referenced Symbols can live,
  *  and I was too lazy to rewrite the scala.js trees enough to make it happy.
  */
@js.native
@JSGlobal
object Symbol extends js.Object {

  /** Creates a new unique symbol without description.
    *
    *  @group factories
    */
  def apply(): js.Symbol = js.native

  /** Creates a new unique symbol with the specified description.
    *
    *  @group factories
    */
  def apply(description: String): js.Symbol = js.native

  /** Retrieves the symbol with the specified key in the global symbol registry.
    *
    *  The returned symbol's description is also the key.
    *
    *  Asking twice `forKey` with the same key returns the same symbol,
    *  globally.
    *
    *  @group registry
    */
  @JSName("for")
  def forKey(key: String): js.Symbol = js.native

  /** Retrieves the key under which the specified symbol is registered in the
    *  global symbol registry, or `undefined` if it is not registered.
    *
    *  @group registry
    */
  def keyFor(sym: js.Symbol): js.UndefOr[String] = js.native

  /**
    * A method that returns the default async iterator for an object. Called by the semantics of
    * the for-await-of statement.
    */
  val asyncIterator: js.Symbol = js.native

  /**
    * A method that determines if a constructor object recognizes an object as one of the
    * constructor’s instances. Called by the semantics of the instanceof operator.
    */
  val hasInstance: js.Symbol = js.native

  /**
    * A Boolean value that if true indicates that an object should flatten to its array elements
    * by Array.prototype.concat.
    */
  val isConcatSpreadable: js.Symbol = js.native

  /**
    * A method that returns the default iterator for an object. Called by the semantics of the
    * for-of statement.
    */
  val iterator: js.Symbol = js.native

  /**
    * A regular expression method that matches the regular expression against a string. Called
    * by the String.prototype.match method.
    */
  val `match`: js.Symbol = js.native

  /**
    * A regular expression method that replaces matched substrings of a string. Called by the
    * String.prototype.replace method.
    */
  val replace: js.Symbol = js.native

  val observable: js.Symbol = js.native

  /**
    * A regular expression method that returns the index within a string that matches the
    * regular expression. Called by the String.prototype.search method.
    */
  val search: js.Symbol = js.native

  /**
    * A function valued property that is the constructor function that is used to create
    * derived objects.
    */
  val species: js.Symbol = js.native

  /**
    * A regular expression method that splits a string at the indices that match the regular
    * expression. Called by the String.prototype.split method.
    */
  val split: js.Symbol = js.native

  /**
    * A method that converts an object to a corresponding primitive value.
    * Called by the ToPrimitive abstract operation.
    */
  val toPrimitive: js.Symbol = js.native

  /**
    * A String value that is used in the creation of the default string description of an object.
    * Called by the built-in method Object.prototype.toString.
    */
  val toStringTag: js.Symbol = js.native

  /**
    * An Object whose own property names are property names that are excluded from the 'with'
    * environment bindings of the associated objects.
    */
  val unscopables: js.Symbol = js.native
}
