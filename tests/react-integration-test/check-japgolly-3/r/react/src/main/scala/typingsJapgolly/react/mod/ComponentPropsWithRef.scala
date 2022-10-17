package typingsJapgolly.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * You'll have to cast your way around this structure, unfortunately. 
  * TS definition: {{{
  T extends react.react.ComponentClass<infer P, react.react.ComponentState> ? react.react.PropsWithoutRef<P> & react.react.RefAttributes</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> * / any> : react.react.PropsWithRef<react.react.ComponentProps<T>>
  }}}
  */
@js.native
trait ComponentPropsWithRef[T /* <: japgolly.scalajs.react.facade.React.ElementType */] extends StObject
