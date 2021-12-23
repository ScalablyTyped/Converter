package typings.std

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.TopLevel
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
type Partial[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{[ P in keyof T ]:? T[P]}
  */ typings.std.stdStrings.Partial & TopLevel[T]

/**
  * From T pick a set of properties K
  */
type Pick[T, K /* <: /* keyof T */ String */] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{[ P in K ]: T[P]}
  */ typings.std.stdStrings.Pick & TopLevel[T]

type Proxify[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
  */ typings.std.stdStrings.Proxify & TopLevel[Any]

/**
  * Make all properties in T readonly
  */
type Readonly[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{readonly [ P in keyof T ]: T[P]}
  */ typings.std.stdStrings.Readonly & TopLevel[T]

/**
  * Construct a type with a set of properties K of type T
  */
type Record[K /* <: /* keyof any */ String */, T] = StringDictionary[T]

/**
  * Make all properties in T required
  */
type Required[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{[ P in keyof T ]: -? T[P]}
  */ typings.std.stdStrings.Required & TopLevel[T]

/**
  * Obtain the return type of a function type
  */
type ReturnType[T /* <: js.Function1[/* repeated */ Any, Any] */] = Any
