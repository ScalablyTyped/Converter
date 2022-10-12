package typings.punchcard

import typings.std.Extract
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  /** NOTE: Mapped type definitions are impossible to translate to Scala.
    * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
    * You'll have to cast your way around this structure, unfortunately. 
    * TS definition: {{{
    {[ fqn in punchcard.punchcard.ExtractTypes<F>['FQN'] ]: {  type :std.Extract<punchcard.punchcard.ExtractTypes<F>, punchcard.punchcard.TypeShape<any, fqn>>,   fields :std.Extract<punchcard.punchcard.ExtractTypes<F>, punchcard.punchcard.TypeShape<any, fqn>>['Members'],   resolvers :{}}}
    }}}
    */
  @js.native
  trait Collect[F /* <: Fields */] extends StObject
  
  type ExtractTypes[F /* <: Fields */] = Extract[
    /* import warning: importer.ImportType#apply Failed type conversion: F[keyof F] */ js.Any, 
    TypeShape[Any, Any]
  ]
  
  /* Inlined std.Readonly<{[member: string] : punchcard.punchcard.Shape}> */
  trait Fields extends StObject
  
  trait Shape extends StObject
  
  trait TypeShape[A, B] extends StObject
}
