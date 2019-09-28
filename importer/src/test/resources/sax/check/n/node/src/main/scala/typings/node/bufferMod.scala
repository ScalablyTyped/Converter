package typings.node

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.std.ArrayBuffer
import typings.std.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`

/************************************************
*                                               *
*                   MODULES                     *
*                                               *
************************************************/
@JSImport("buffer", Namespace)
@js.native
object bufferMod extends js.Object {
  @js.native
  class Buffer protected () extends typings.node.Buffer {
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
    def this(buffer: typings.node.Buffer) = this()
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
  
  @js.native
  class SlowBuffer protected () extends typings.node.Buffer {
    def this(array: js.Array[_]) = this()
    def this(size: Double) = this()
    def this(size: Uint8Array) = this()
    def this(str: String) = this()
    def this(str: String, encoding: String) = this()
  }
  
  var INSPECT_MAX_BYTES: Double = js.native
  @js.native
  object Buffer
    extends Instantiable2[/* str */ String, /* encoding */ String, typings.node.Buffer]
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
          (/* array */ js.Array[js.Any]) | (/* arrayBuffer */ ArrayBuffer) | (/* buffer */ typings.node.Buffer) | (/* size */ Double) | (/* str */ String) | (/* array */ Uint8Array), 
          typings.node.Buffer
        ] {
    /**
      * Allocates a new Buffer using an {array} of octets.
      */
    def from(array: js.Array[_]): typings.node.Buffer = js.native
  }
  
  @js.native
  object SlowBuffer
    extends Instantiable2[/* str */ String, /* encoding */ String, typings.node.Buffer]
       with Instantiable1[
          (/* array */ js.Array[js.Any]) | (/* size */ Double) | (/* str */ String) | (/* size */ Uint8Array), 
          typings.node.Buffer
        ] {
    def byteLength(string: String): Double = js.native
    def byteLength(string: String, encoding: String): Double = js.native
    def concat(list: js.Array[typings.node.Buffer]): typings.node.Buffer = js.native
    def concat(list: js.Array[typings.node.Buffer], totalLength: Double): typings.node.Buffer = js.native
    def isBuffer(obj: js.Any): Boolean = js.native
  }
  
}

