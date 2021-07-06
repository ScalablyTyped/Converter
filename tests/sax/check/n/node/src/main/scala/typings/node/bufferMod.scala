package typings.node

import typings.std.ArrayBuffer
import typings.std.Uint8Array
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/************************************************
*                                               *
*                   MODULES                     *
*                                               *
************************************************/
object bufferMod {
  
  @JSImport("buffer", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("buffer", "Buffer")
  @js.native
  class Buffer protected ()
    extends StObject
       with NodeBuffer {
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
    def this(array: js.Array[js.Any]) = this()
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
  /**
    * Raw data is stored in instances of the Buffer class.
    * A Buffer is similar to an array of integers but corresponds to a raw memory allocation outside the V8 heap.  A Buffer cannot be resized.
    * Valid string encodings: 'ascii'|'utf8'|'utf16le'|'ucs2'(alias of 'utf16le')|'base64'|'binary'(deprecated)|'hex'
    */
  /* was `typeof Buffer` */
  object Buffer {
    
    @JSImport("buffer", "Buffer")
    @js.native
    val ^ : js.Any = js.native
    
    /**
      * Allocates a new Buffer using an {array} of octets.
      */
    @scala.inline
    def from(array: js.Array[js.Any]): typings.node.Buffer = ^.asInstanceOf[js.Dynamic].applyDynamic("from")(array.asInstanceOf[js.Any]).asInstanceOf[typings.node.Buffer]
  }
  
  @JSImport("buffer", "INSPECT_MAX_BYTES")
  @js.native
  def INSPECT_MAX_BYTES: Double = js.native
  @scala.inline
  def INSPECT_MAX_BYTES_=(x: Double): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("INSPECT_MAX_BYTES")(x.asInstanceOf[js.Any])
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("buffer", "SlowBuffer")
  @js.native
  class SlowBuffer protected ()
    extends StObject
       with NodeBuffer {
    def this(array: js.Array[js.Any]) = this()
    def this(size: Double) = this()
    def this(size: Uint8Array) = this()
    def this(str: String) = this()
    def this(str: String, encoding: String) = this()
  }
  /* was `typeof SlowBuffer` */
  object SlowBuffer {
    
    @JSImport("buffer", "SlowBuffer")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def byteLength(string: String): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("byteLength")(string.asInstanceOf[js.Any]).asInstanceOf[Double]
    @scala.inline
    def byteLength(string: String, encoding: String): Double = (^.asInstanceOf[js.Dynamic].applyDynamic("byteLength")(string.asInstanceOf[js.Any], encoding.asInstanceOf[js.Any])).asInstanceOf[Double]
    
    @scala.inline
    def concat(list: js.Array[typings.node.Buffer]): typings.node.Buffer = ^.asInstanceOf[js.Dynamic].applyDynamic("concat")(list.asInstanceOf[js.Any]).asInstanceOf[typings.node.Buffer]
    @scala.inline
    def concat(list: js.Array[typings.node.Buffer], totalLength: Double): typings.node.Buffer = (^.asInstanceOf[js.Dynamic].applyDynamic("concat")(list.asInstanceOf[js.Any], totalLength.asInstanceOf[js.Any])).asInstanceOf[typings.node.Buffer]
    
    @scala.inline
    def isBuffer(obj: js.Any): Boolean = ^.asInstanceOf[js.Dynamic].applyDynamic("isBuffer")(obj.asInstanceOf[js.Any]).asInstanceOf[Boolean]
  }
}
