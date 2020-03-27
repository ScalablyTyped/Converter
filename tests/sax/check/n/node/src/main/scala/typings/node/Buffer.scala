package typings.node

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import typings.std.ArrayBuffer
import typings.std.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/**
  * Raw data is stored in instances of the Buffer class.
  * A Buffer is similar to an array of integers but corresponds to a raw memory allocation outside the V8 heap.  A Buffer cannot be resized.
  * Valid string encodings: 'ascii'|'utf8'|'utf16le'|'ucs2'(alias of 'utf16le')|'base64'|'binary'(deprecated)|'hex'
  */
@JSGlobal("Buffer")
@js.native
object Buffer
  extends /**
  * Allocates a new buffer containing the given {array} of octets.
  *
  * @param array The octets to store.
  */
/**
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
  * Copies the passed {buffer} data onto a new {Buffer} instance.
  *
  * @param buffer The buffer to copy.
  */
/**
  * Produces a Buffer backed by the same allocated memory as
  * the given {ArrayBuffer}.
  *
  *
  * @param arrayBuffer The ArrayBuffer with which to share memory.
  */
Instantiable1[
      (/* array */ js.Array[js.Any]) | (/* arrayBuffer */ ArrayBuffer) | (/* buffer */ Buffer) | (/* size */ Double) | (/* str */ String) | (/* array */ Uint8Array), 
      Buffer
    ]
     with Instantiable2[/* str */ String, /* encoding */ String, Buffer] {
  /**
    * Allocates a new Buffer using an {array} of octets.
    */
  def from(array: js.Array[_]): Buffer = js.native
}

