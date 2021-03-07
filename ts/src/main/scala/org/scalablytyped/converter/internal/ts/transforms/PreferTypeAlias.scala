package org.scalablytyped.converter.internal
package ts
package transforms

import scala.collection.mutable

object PreferTypeAlias extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
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
      case i @ TsDeclInterface(comments, declared, name, tparams, Empty, members, codePath)
          if ExtractInterfaces.isTypeMapping(members) || ExtractInterfaces.isDictionary(members) =>
        if (hasCircularReference(codePath.forceHasPath.codePath, mutable.Set(), scope, members.head)) i
        else
          TsDeclTypeAlias(comments, declared, name, tparams, TsTypeObject(NoComments, members), codePath)

      /* the opposite of former */
      case ta @ TsDeclTypeAlias(comments, declared, name, tparams, TsTypeObject(_, members), codePath)
          if ExtractInterfaces.isDictionary(members) =>
        if (hasCircularReference(codePath.forceHasPath.codePath, mutable.Set(), scope, members.head))
          TsDeclInterface(comments, declared, name, tparams, Empty, members, codePath)
        else ta

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
        * ```
        * Note that we rewrite interfaces which extends one type, not more.
        * The reason is that scala wont't let you `new` an intersection type
        */
      case i @ TsDeclInterface(
            comments,
            declared,
            name,
            tparams,
            IArray.exactlyOne(singleInheritance),
            Empty,
            codePath,
          ) =>
        if (hasCircularReference(codePath.forceHasPath.codePath, mutable.Set(), scope, singleInheritance)) i
        else TsDeclTypeAlias(comments, declared, name, tparams, singleInheritance, codePath)

      /**
        * We do this rewrite because in Scala we have no way to instantiate a new instance of `Foo`
        *
        * ``typescript
        * interface Foo {&LT;T extends object&GT;(a: T) => void}
        * ```
        * =>
        * ```typescript
        * type Foo = (a: object) => void;
        * ```
        **/
      case IsFunction(typeAlias) =>
        if (hasCircularReference(typeAlias.codePath.forceHasPath.codePath, mutable.Set(), scope, typeAlias.alias)) x
        else {
          scope.logger.info("Simplified to function type alias")
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
        * So we rewrite it early instead.
        *
        * We also handle `type Bar = {something: number} | {whatever: string}`
        * and rewrite it into
        * `interface Bar { something: | undefined, whatever: string | undefined }`
        */
      case TsDeclTypeAlias(cs, dec, name, tparams, AllTypeObjects(members), cp)
          if members.nonEmpty &&
            !ExtractInterfaces.isTypeMapping(members) &&
            !ExtractInterfaces.isDictionary(members) =>
        TsDeclInterface(cs, dec, name, tparams, Empty, members, cp)

      /**
        * Rewrite this:
        * ```typescript
        * export type RuleSetConditions = RuleSetCondition[];
        * export type RuleSetCondition =
        * | RegExp
        * | RuleSetConditions
        * ````
        *
        * to
        * ```typescript
        * export interface RuleSetConditions extends RuleSetCondition[] {};
        * export type RuleSetCondition =
        * | RegExp
        * | RuleSetConditions
        * `
        *
        * Only the latter will be legal in scala, unfortunately
        */
      case ta @ TsDeclTypeAlias(
            cs,
            dec,
            name,
            tparams,
            arr @ TsTypeRef(_, TsQIdent.Std.Array | TsQIdent.Std.ReadonlyArray, IArray.exactlyOne(t)),
            cp,
          ) =>
        if (hasCircularReference(cp.forceHasPath.codePath, mutable.Set(), scope, t))
          TsDeclInterface(cs, dec, name, tparams, inheritance = IArray(arr), members = Empty, codePath = cp)
        else ta

      /* Encoding varargs as a type alias is rather pointless since we'll lose the varargs */
      case TsDeclTypeAlias(cs, dec, name, tparams, TsTypeFunction(sig @ TsFunSig(_, _, params, _)), cp)
          if params.exists(_.tpe.exists(_.isInstanceOf[TsTypeRepeated])) =>
        val call = TsMemberCall(NoComments, ProtectionLevel.Default, sig)
        TsDeclInterface(cs, dec, name, tparams, inheritance = Empty, members = IArray(call), codePath = cp)

      case other =>
        other
    }

  private object IsFunction {
    def unapply(i: TsDeclInterface): Option[TsDeclTypeAlias] =
      if (i.members.length =/= 1 || i.inheritance.nonEmpty) None
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
        val newMembers = x.members.collect {
          case x: TsMemberCall => x
        }
        x.copy(members = newMembers)
      case x: TsDeclClass =>
        val newMembers = x.members.collect {
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
    TsTreeTraverse.collect(minimizedTree) { case x: TsQIdent if x === self => x } match {
      case Empty =>
        val refs = TsTreeTraverse.collect(minimizedTree) { case x: TsTypeRef => x }.toSet
        refs.exists { ref =>
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
          s"Could not simplify ${TsTypeFormatter.qident(self)} to function type alias because of circular references $circularReferences",
        )
        true
    }
  }

  object AllTypeObjects {
    def unapply(arg: TsType): Option[IArray[TsMember]] =
      arg match {
        case TsTypeObject(_, members) => Some(members)

        case TsTypeIntersect(types) =>
          types.partitionCollect { case AllTypeObjects(members) => members } match {
            case (members, Empty) => Some(members.flatten)
            case _                => None
          }
        case _ => None
      }

  }
}
