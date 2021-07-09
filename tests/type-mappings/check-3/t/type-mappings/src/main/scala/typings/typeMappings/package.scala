package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

  
  type Double[T] = typings.std.Partial[typings.std.Partial[T]]
  
  type IPersonRecord = typings.typeMappings.PersonRecord
  
  type NewedPerson = typings.std.InstanceType[org.scalablytyped.runtime.Instantiable0[typings.typeMappings.Person]]
  
  type NonNullablePerson = typings.std.NonNullable[typings.typeMappings.Person]
  
  type Omit[T, K /* <: /* keyof any */ java.lang.String */] = typings.std.Pick[T, typings.std.Exclude[/* keyof T */ java.lang.String, K]]
  
  type Proxify[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
    */ typings.typeMappings.typeMappingsStrings.Proxify & org.scalablytyped.runtime.TopLevel[js.Any]
  
  type ReturnedPerson = typings.std.ReturnType[js.Function0[typings.typeMappings.Person]]
  
  type T = typings.std.Pick[
    typings.typeMappings.anon.Name | typings.typeMappings.anon.Age, 
    typings.typeMappings.typeMappingsStrings.name & typings.typeMappings.typeMappingsStrings.age
  ]
