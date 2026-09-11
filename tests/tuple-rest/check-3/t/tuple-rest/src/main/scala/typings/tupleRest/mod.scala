package typings.tupleRest

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("tuple-rest", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object iter {
    
    @JSImport("tuple-rest", "iter")
    @js.native
    val ^ : js.Any = js.native
    
    inline def array(source: Source): js.Array[String] = ^.asInstanceOf[js.Dynamic].applyDynamic("array")(source.asInstanceOf[js.Any]).asInstanceOf[js.Array[String]]
    
    inline def compose(
      /* import warning: parser.TsParser#functionParam Dropping repeated marker of param streams because its type [Source, ...Array<Transform>, Destination] is not an array type */ streams: js.Array[Source | Destination | Transform]
    ): Destination = ^.asInstanceOf[js.Dynamic].applyDynamic("compose")(streams.asInstanceOf[js.Any]).asInstanceOf[Destination]
  }
  
  inline def pipeline(
    /* import warning: parser.TsParser#functionParam Dropping repeated marker of param streams because its type [Source, ...Array<Transform>, Destination] is not an array type */ streams: js.Array[Source | Destination | Transform]
  ): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("pipeline")(streams.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  @JSImport("tuple-rest", "trailing")
  @js.native
  val trailing: js.Array[String | Double] = js.native
  
  trait Destination extends StObject
  
  trait Source extends StObject
  
  trait Transform extends StObject
}
