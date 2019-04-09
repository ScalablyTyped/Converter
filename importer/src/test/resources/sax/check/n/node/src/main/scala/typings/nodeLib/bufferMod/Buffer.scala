package typings
package nodeLib.bufferMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("buffer", "Buffer")
@js.native
class Buffer protected ()
  extends nodeLib.Buffer {
  /**
    * Produces a Buffer backed by the same allocated memory as
    * the given {ArrayBuffer}.
    *
    *
    * @param arrayBuffer The ArrayBuffer with which to share memory.
    */
  def this(arrayBuffer: stdLib.ArrayBuffer) = this()
  /**
    * Allocates a new buffer containing the given {array} of octets.
    *
    * @param array The octets to store.
    */
  def this(array: js.Array[_]) = this()
  /**
    * Allocates a new buffer containing the given {array} of octets.
    *
    * @param array The octets to store.
    */
  def this(array: stdLib.Uint8Array) = this()
  /**
    * Copies the passed {buffer} data onto a new {Buffer} instance.
    *
    * @param buffer The buffer to copy.
    */
  def this(buffer: nodeLib.Buffer) = this()
  /**
    * Allocates a new buffer of {size} octets.
    *
    * @param size count of octets to allocate.
    */
  def this(size: scala.Double) = this()
  /**
    * Allocates a new buffer containing the given {str}.
    *
    * @param str String to store in buffer.
    * @param encoding encoding to use, optional.  Default is 'utf8'
    */
  def this(str: java.lang.String) = this()
  def this(str: java.lang.String, encoding: java.lang.String) = this()
}

@JSImport("buffer", "Buffer")
@js.native
object Buffer
  extends org.scalablytyped.runtime.Instantiable2[/* str */ java.lang.String, /* encoding */ java.lang.String, nodeLib.Buffer]
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
      (/* array */ js.Array[js.Any]) | (/* arrayBuffer */ stdLib.ArrayBuffer) | (/* buffer */ nodeLib.Buffer) | (/* size */ scala.Double) | (/* str */ java.lang.String) | (/* array */ stdLib.Uint8Array), 
      nodeLib.Buffer
    ] {
  /**
    * Allocates a new Buffer using an {array} of octets.
    */
  def from(array: js.Array[_]): nodeLib.Buffer = js.native
}

