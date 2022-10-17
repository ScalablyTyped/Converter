package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * You'll have to cast your way around this structure, unfortunately. 
  * TS definition: {{{
  C extends {  propTypes :infer T,   defaultProps :infer D} ? react.react.Defaultize<react.react.MergePropTypes<P, / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / any>, D> : C extends {  propTypes :infer T} ? react.react.MergePropTypes<P, / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / any> : C extends {  defaultProps :infer D} ? react.react.Defaultize<P, D> : P
  }}}
  */
@js.native
trait ReactManagedAttributes[C, P] extends StObject
