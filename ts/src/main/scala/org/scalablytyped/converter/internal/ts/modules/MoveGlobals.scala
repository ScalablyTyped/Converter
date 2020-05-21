package org.scalablytyped.converter.internal
package ts
package modules

/**
  * Move globals into their own namespace:
  *
  * given a file like this:
  * ```typescript
  * declare class Foo(){};
  * declare const foo: Foo;
  * declare module "bar" {
  *   class Bar extends Foo {}
  * }
  * ```
  *
  * We keep types at the top-level, but move all the values inside a faux `global`.
  *
  * ```typescript
  * declare interface Foo {};
  * declare namespace <global> {
  *   class Foo implements <outer>.Foo()
  *   const foo: <outer>.Foo
  * }
  * declare module "bar" {
  *   class Bar implements <outer>.Foo {}
  * }
  * ```
  */
object MoveGlobals {
  def apply(file: TsParsedFile): TsParsedFile = {
    val (modules, named, rest) =
      file.members.partitionCollect2({ case x: TsDeclModuleLike => x }, { case x: TsNamedValueDecl => x })

    val globalCp = file.codePath.forceHasPath + TsIdent.Global

    val keepToplevel = named.mapNotNone(m => KeepTypesOnly(m))

    val globalMembers = named.flatMap(x => DeriveCopy(x, globalCp, None))

    if (globalMembers.isEmpty) file
    else {
      val global =
        TsDeclNamespace(NoComments, declared = false, TsIdent.Global, globalMembers, globalCp, JsLocation.Zero)
      file.copy(members = modules ++ rest ++ keepToplevel :+ global)
    }
  }
}
