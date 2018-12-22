package typings
package nodeLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_From
  extends /**
     * Allocates a new buffer containing the given {str}.
     *
     * @param str String to store in buffer.
     * @param encoding encoding to use, optional.  Default is 'utf8'
     */
org.scalablytyped.runtime.Instantiable2[/* str */ java.lang.String, /* encoding */ java.lang.String, Buffer]
     with /**
     * Allocates a new buffer containing the given {str}.
     *
     * @param str String to store in buffer.
     * @param encoding encoding to use, optional.  Default is 'utf8'
     */
/**
     * Allocates a new buffer of {size} octets.
     *
     * @param size count of octets to allocate.
     */
/**
     * Allocates a new buffer containing the given {array} of octets.
     *
     * @param array The octets to store.
     */
/**
     * Produces a Buffer backed by the same allocated memory as
     * the given {ArrayBuffer}.
     *
     *
     * @param arrayBuffer The ArrayBuffer with which to share memory.
     */
/**
     * Copies the passed {buffer} data onto a new {Buffer} instance.
     *
     * @param buffer The buffer to copy.
     */
org.scalablytyped.runtime.Instantiable1[
      (/* array */ js.Array[js.Any]) | (/* arrayBuffer */ stdLib.ArrayBuffer) | (/* buffer */ Buffer) | (/* size */ scala.Double) | (/* str */ java.lang.String) | (/* array */ stdLib.Uint8Array), 
      Buffer
    ] {
  /**
       * Allocates a new Buffer using an {array} of octets.
       */
  def from(array: js.Array[_]): Buffer = js.native
}

