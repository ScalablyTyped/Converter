package typings.nodeLib.bufferMod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import typings.stdLib.ArrayBuffer
import typings.stdLib.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("buffer", "Buffer")
@js.native
class Buffer protected ()
  extends typings.nodeLib.Buffer {
  /**
    * Produces a Buffer backed by the same allocated memory as
    * the given {ArrayBuffer}.
    *
    *
    * @param arrayBuffer The ArrayBuffer with which to share memory.
    */
  def this(arrayBuffer: ArrayBuffer) = this()
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
  def this(array: Uint8Array) = this()
  /**
    * Copies the passed {buffer} data onto a new {Buffer} instance.
    *
    * @param buffer The buffer to copy.
    */
  def this(buffer: typings.nodeLib.Buffer) = this()
  /**
    * Allocates a new buffer of {size} octets.
    *
    * @param size count of octets to allocate.
    */
  def this(size: Double) = this()
  /**
    * Allocates a new buffer containing the given {str}.
    *
    * @param str String to store in buffer.
    * @param encoding encoding to use, optional.  Default is 'utf8'
    */
  def this(str: String) = this()
  def this(str: String, encoding: String) = this()
}

@JSImport("buffer", "Buffer")
@js.native
object Buffer
  extends Instantiable2[/* str */ String, /* encoding */ String, typings.nodeLib.Buffer]
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
Instantiable1[
      (/* array */ js.Array[js.Any]) | (/* arrayBuffer */ ArrayBuffer) | (/* buffer */ typings.nodeLib.Buffer) | (/* size */ Double) | (/* str */ String) | (/* array */ Uint8Array), 
      typings.nodeLib.Buffer
    ] {
  /**
    * Allocates a new Buffer using an {array} of octets.
    */
  def from(array: js.Array[_]): typings.nodeLib.Buffer = js.native
}

