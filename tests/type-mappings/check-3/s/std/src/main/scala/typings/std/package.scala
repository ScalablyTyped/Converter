package typings.std

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


/**
  * Exclude from T those types that are assignable to U
  */
type Exclude[T, U] = T

/**
  * Extract from T those types that are assignable to U
  */
type Extract[T, U] = T

/**
  * Obtain the return type of a constructor function type
  */
type InstanceType[T /* <: Instantiable1[/* args (repeated) */ Any, Any] */] = Any

/**
  * Exclude null and undefined from T
  */
type NonNullable[T] = T

/**
  * Make all properties in T optional
  */
/** NOTE: Mapped type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
  * This translation is imprecise and ignores the effect of the type mapping. 
  * TS definition: {{{
  {[ P in keyof T ]:? T[P]}
  }}}
  */
type Partial[T] = T

/**
  * From T pick a set of properties K
  */
/** NOTE: Mapped type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
  * This translation is imprecise and ignores the effect of the type mapping. 
  * TS definition: {{{
  {[ P in K ]: T[P]}
  }}}
  */
type Pick[T, K /* <: /* keyof T */ String */] = T

/**
  * Make all properties in T readonly
  */
/** NOTE: Mapped type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
  * This translation is imprecise and ignores the effect of the type mapping. 
  * TS definition: {{{
  {readonly [ P in keyof T ]: T[P]}
  }}}
  */
type Readonly[T] = T

/**
  * Construct a type with a set of properties K of type T
  */
/** NOTE: Mapped type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
  * This translation throws away the known field names. 
  * TS definition: {{{
  {[ P in K ]: T}
  }}}
  */
type Record[K /* <: /* keyof any */ String */, T] = StringDictionary[T]

/**
  * Make all properties in T required
  */
/** NOTE: Mapped type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
  * This translation is imprecise and ignores the effect of the type mapping. 
  * TS definition: {{{
  {[ P in keyof T ]: -? T[P]}
  }}}
  */
type Required[T] = T

/**
  * Obtain the return type of a function type
  */
type ReturnType[T /* <: js.Function1[/* repeated */ Any, Any] */] = Any
