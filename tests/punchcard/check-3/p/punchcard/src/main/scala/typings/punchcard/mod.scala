package typings.punchcard

import org.scalablytyped.runtime.TopLevel
import typings.std.Extract
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  type Collect[F /* <: Fields */] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ fqn in punchcard.punchcard.ExtractTypes<F>['FQN'] ]: {  type :std.Extract<punchcard.punchcard.ExtractTypes<F>, punchcard.punchcard.TypeShape<any, fqn>>,   fields :std.Extract<punchcard.punchcard.ExtractTypes<F>, punchcard.punchcard.TypeShape<any, fqn>>['Members'],   resolvers :{}}}
    */ "Collect" & TopLevel[js.Any]
  
  type ExtractTypes[F /* <: Fields */] = Extract[
    /* import warning: importer.ImportType#apply Failed type conversion: F[keyof F] */ js.Any, 
    TypeShape[js.Any, js.Any]
  ]
  
  /* Inlined std.Readonly<{[member: string] : punchcard.punchcard.Shape}> */
  trait Fields extends StObject
  
  trait Shape extends StObject
  
  trait TypeShape[A, B] extends StObject
}
