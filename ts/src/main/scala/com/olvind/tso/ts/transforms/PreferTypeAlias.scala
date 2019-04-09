package com.olvind.tso
package ts
package transforms
import scala.collection.mutable

object PreferTypeAlias extends TreeTransformationScopedChanges {
  override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
    x match {

      /**
        * Given this:
        * ```typescript
        * interface Foo { [key: string]: value}
        * ```
        * We would normally end up with
        * ```scala
        * trait Foo extends StringDictionary[value]
        * ```
        * There is little value in keep these two types distinct
        */
      case i @ TsDeclInterface(comments, declared, name, tparams, Nil, members, codePath)
          if ExtractInterfaces.isTypeMapping(members) || ExtractInterfaces.isDictionary(members) =>
        if (hasCircularReference(codePath.forceHasPath.codePath, mutable.Set(), t, members.head)) i
        else {
          TsDeclTypeAlias(comments, declared, name, tparams, TsTypeObject(members), codePath)
        }

      /**
        * Given this:
        * ```typescript
        * interface Foo {bar: number}
        * interface Bar extends Foo {}
        * ```
        * In Typescript these two are structurally equal while in nominally typed Scala we need to cast a `Foo` to a `Bar`
        * For this reason we rewrite to a type alias to keep it as convenient.
        *
        * ```typescript
        * interface Foo {bar: number}
        * type Bar = Foo
        * ````
        * Note that we rewrite interfaces which extends one type, not more.
        * The reason is that scala wont't let you `new` an intersection type
        **/
      case i @ TsDeclInterface(comments, declared, name, tparams, Seq(singleInheritance), Nil, codePath) =>
        if (hasCircularReference(codePath.forceHasPath.codePath, mutable.Set(), t, singleInheritance)) i
        else {
          t.logger.info("Simplified to type alias")
          TsDeclTypeAlias(comments, declared, name, tparams, singleInheritance, codePath)
        }

      /**
        * We do this rewrite because in Scala we have no way to instantiate a new instance of `Foo``
        *
        * ```typescript
        * interface Foo {&LT;T extends object&GT;(a: T) => void}
        * ```
        * =>
        * ```typescript
        * type Foo = (a: object) => void;
        * ```
        **/
      case IsFunction(typeAlias) =>
        if (hasCircularReference(typeAlias.codePath.forceHasPath.codePath, mutable.Set(), t, typeAlias.alias)) x
        else {
          t.logger.info("Simplified to function type alias")
          typeAlias
        }

      /**
        * There is also a case where we prefer interfaces:
        * ```typescript
        * type Foo = { bar: number }
        * ```
        * We would end up with the following given the logic in `ExtractInterfaces`:
        * ```scala
        * trait Anon_Bar { bar: Double}
        * trait Foo extends Anon_Bar
        * ```
        *
        * So we rewrite it early instead
        */
      case TsDeclTypeAlias(cs, dec, name, tparams, TsTypeObject(members), cp)
          if members.nonEmpty && !ExtractInterfaces.isTypeMapping(members) && !ExtractInterfaces.isDictionary(
            members
          ) =>
        TsDeclInterface(cs, dec, name, tparams, Nil, members, cp)

      case other => other
    }
  private object IsFunction {
    def unapply(i: TsDeclInterface): Option[TsDeclTypeAlias] =
      if (i.members.size =/= 1 || i.inheritance.nonEmpty) None
      else {
        i.members.head match {
          case call: TsMemberCall =>
            Some(TsDeclTypeAlias(i.comments, i.declared, i.name, i.tparams, TsTypeFunction(call.signature), i.codePath))
          case _ => None
        }
      }
  }

  /** Simulate that we have already ran `PreferTypeAlias` on `tree` somehow.
    *
    * The point is that as long as we know that `tree` is not going to be
    *  a type alias itself, we can ignore the members
    */
  def memberHack(tree: TsTree): TsTree =
    tree match {
      case x: TsDeclInterface =>
        val newMembers = x.members collect {
          case x: TsMemberCall => x
        }
        x.copy(members = newMembers)
      case x: TsDeclClass =>
        val newMembers = x.members collect {
          case x: TsMemberCall => x
        }
        x.copy(members = newMembers)
      case other => other
    }

  /**
    * Typescript and Scala share limitations on recursive/circular types.
    * For instance this is not allowed
    * ```typescript
    * type T = T[] | number;
    * ```
    *
    * However, in both languages you can make it work by using an interface/trait
    * ```typescript
    * type T = TArray | number
    * interface TArray extends T[] [}
    * ```
    *
    * So to avoid compilation failure after we simplify, we leave it to the user of the generated
    *  code to cast appropriately
    */
  def hasCircularReference(self: TsQIdent, cache: mutable.Set[TsTypeRef], scope: TsTreeScope, tree: TsTree): Boolean = {
    val minimizedTree = memberHack(tree)
    TreeTraverse.collect(minimizedTree) { case x: TsQIdent if x === self => x } match {
      case Nil =>
        val refs = TreeTraverse.collect(minimizedTree) { case x: TsTypeRef => x }.to[Set]
        refs exists { ref =>
          if (cache(ref)) false
          else
            scope
              .lookupTypeIncludeScope(ref.name, /* lazy handling of type parameters */ skipValidation = true)
              .exists {
                case (found, newScope) =>
                  cache += ref
                  hasCircularReference(self, cache, newScope, found)
              }
        }
      case circularReferences =>
        scope.logger.info(
          s"Could not simplify ${TsTypeFormatter.qident(self)} to function type alias because of circular references $circularReferences"
        )
        true
    }
  }
}
