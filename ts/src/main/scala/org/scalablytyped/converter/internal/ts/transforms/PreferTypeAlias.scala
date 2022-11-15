package org.scalablytyped.converter.internal
package ts
package transforms

import scala.collection.{mutable, Map}

object PreferTypeAlias {
  // we'll rewrite `target` to not point to any types in `circular`
  case class Rewrite(target:         TsQIdent, circular: Set[TsQIdent])
  case class CircularGroup(typeRefs: List[TsTypeRef])

  def apply(lib: TsParsedFile, rootScope: TsTreeScope): TsParsedFile = {
    val withTypeAliasPreferred = PreferTypeAliasVisitor.visitTsParsedFile(rootScope)(lib)

    val scope = rootScope / withTypeAliasPreferred
    val groups: Set[CircularGroup] = findGroups(withTypeAliasPreferred, scope)

    val allNamesInGroup = groups.flatMap(_.typeRefs.map(_.name))

    // prefer these since they give good results when translating to a circular-safe interface
    val preferredRewrites: Set[TsQIdent] =
      allNamesInGroup.flatMap { name =>
        FollowAliases(scope)(TsTypeRef(name)) match {
          case TsTypeRef(_, dealiased, _) if dealiased.parts.last.value =/= "Array" => Some(dealiased)
          case TsTypeFunction(_)                                                    => Some(name)
          case TsTypeObject(_, members) if !TsType.isTypeMapping(members)           => Some(name)
          case _                                                                    => None
        }
      }

    val rewrites = breakCircularGroups(groups, preferredRewrites)

    rewrites.foreach(r =>
      scope.logger
        .withContext(r.circular.map(TsTypeFormatter.qident))
        .info(s"Rewriting: ${TsTypeFormatter.qident(r.target)} to break circular graph"),
    )

    new AvoidCircularVisitor(rewrites).visitTsParsedFile(rootScope)(withTypeAliasPreferred)
  }

  def findGroups(lib: TsParsedFile, scope: TsTreeScope): Set[CircularGroup] = {
    val found     = Set.newBuilder[CircularGroup]
    val libPrefix = lib.codePath.forceHasPath.codePath

    def look(container: TsContainer): Unit =
      container.members.foreach {
        case ta: TsDeclTypeAlias if !ta.comments.has[Marker.IsTrivial.type] =>
          val ref = TsTypeRef(NoComments, ta.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(ta.tparams))

          isInRecursiveGroup(scope / ta, List(ref), ta.alias, Empty).foreach { rawGroup =>
            val group = CircularGroup(rawGroup.typeRefs.filter(_.name.parts.startsWith(libPrefix.parts)))
            if (group.typeRefs.nonEmpty)
              found += group

          }
        case c: TsContainer => look(c)
        case _ => ()
      }

    look(lib)

    found.result()
  }

  def isInRecursiveGroup(
      scope:        TsTreeScope,
      acc:          List[TsTypeRef],
      current:      TsType,
      lastTypeArgs: IArray[TsType],
  ): IArray[CircularGroup] = {
    def anyOf(
        scope:        TsTreeScope,
        acc:          List[TsTypeRef],
        types:        IArray[TsType],
        lastTypeArgs: IArray[TsType],
    ): IArray[CircularGroup] =
      types.flatMap(tpe => isInRecursiveGroup(scope, acc, tpe, lastTypeArgs))

    def sig(
        scope:        TsTreeScope,
        acc:          List[TsTypeRef],
        sig:          TsFunSig,
        lastTypeArgs: IArray[TsType],
    ): IArray[CircularGroup] = {
      val types =
        sig.tparams.mapNotNone(_.upperBound) ++
          sig.params.mapNotNone(_.tpe) ++
          IArray.fromOption(sig.resultType)
      anyOf(scope / sig, acc, types, lastTypeArgs)
    }
    current match {
      case x: TsTypeRef =>
        val evaluated: IArray[CircularGroup] =
          if (acc.contains(x)) IArray(CircularGroup(acc))
          /* some types grow unbounded as we expand them without a reduction step. this may cause false positives, but it keeps code compiling */
          else if (acc.count(_.name === x.name) > 3) IArray(CircularGroup(acc))
          else
            scope.lookupType(x.name).flatMap {
              case ta: TsDeclTypeAlias =>
                val alias = FillInTParams(ta, x.tparams).alias
                isInRecursiveGroup(scope / ta, x :: acc, alias, x.tparams)
              case _ => Empty
            }

        evaluated ++ anyOf(scope, acc, x.tparams.filterNot(lastTypeArgs.contains), Empty)

      case TsTypeObject(_, members) =>
        members.flatMap {
          case x: TsMemberIndex =>
            val fromIndexing = x.indexing match {
              case Indexing.Dict(_, tpe) => Some(tpe)
              case Indexing.Single(_)    => None
            }
            anyOf(scope, acc, IArray.fromOptions(x.valueType, fromIndexing), Empty)
          case _ => Empty /** such a recursive link will be broken by [[ExtractInterfaces]] */
        }

      case TsTypeFunction(signature)  => sig(scope, acc, signature, Empty)
      case TsTypeConstructor(_, f)    => sig(scope, acc, f.signature, Empty)
      case TsTypeRepeated(underlying) => isInRecursiveGroup(scope, acc, underlying, Empty)
      case TsTypeTuple(elems)         => anyOf(scope, acc, elems.map(_.tpe), Empty)
      case TsTypeIntersect(types)     => anyOf(scope, acc, types, Empty)
      case TsTypeUnion(types)         => anyOf(scope, acc, types, Empty)
      case TsTypeConditional(_, _, _) =>
        // should likely check this, but there are recursive cases where it never completes, since the obvious implementation
        // would continue down both branches.
        Empty
      case TsTypeLiteral(_)    => Empty
      case TsTypeQuery(_)      => Empty
      case TsTypeKeyOf(_)      => Empty
      case TsTypeLookup(_, _)  => Empty
      case TsTypeThis()        => Empty
      case TsTypeIs(_, _)      => Empty
      case TsTypeAsserts(_, _) => Empty
      case TsTypeExtends(_, _) => Empty
      case TsTypeInfer(_)      => Empty
    }
  }

  def breakCircularGroups(groups: Set[CircularGroup], preferredRewrites: Set[TsQIdent]): IArray[Rewrite] = {
    val b             = IArray.Builder.empty[Rewrite]
    var currentGroups = groups
    while (currentGroups.nonEmpty) {
      val chosen: TsQIdent =
        currentGroups.flatMap(_.typeRefs).collectFirst { case tr if preferredRewrites(tr.name) => tr.name }.getOrElse {
          // pick one type we'll rewrite to break the chain, and try to cover as many groups as possible
          val occurrences = mutable.Map.empty[TsQIdent, Int]
          currentGroups.foreach { group =>
            group.typeRefs.foreach { typeRef =>
              occurrences.update(typeRef.name, occurrences.getOrElse(typeRef.name, 0) + 1)
            }
          }

          occurrences.max._1
        }

      val (intersectsChosen, notIntersects) = currentGroups.partition(_.typeRefs.exists(_.name === chosen))
      b += Rewrite(chosen, intersectsChosen.flatMap(_.typeRefs.map(_.name)))
      currentGroups = notIntersects
    }

    b.result()
  }

  object PreferTypeAliasVisitor extends TreeTransformationScopedChanges {
    override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
      x match {

        /**
          * Given this:
          * {{{
          * interface Foo { [key: string]: value}
          * }}}
          * We would normally end up with
          * {{{scala
          * trait Foo extends StringDictionary[value]
          * }}}
          * There is little value in keep these two types distinct
          */
        case TsDeclInterface(comments, declared, name, tparams, Empty, members, codePath)
            if ExtractInterfaces.isDictionary(members) =>
          TsDeclTypeAlias(comments, declared, name, tparams, TsTypeObject(NoComments, members), codePath)

        /**
          * Given this:
          * {{{
          * interface Foo {bar: number}
          * interface Bar extends Foo {}
          * }}}
          * In Typescript these two are structurally equal while in nominally typed Scala we need to cast a `Foo` to a `Bar`
          * For this reason we rewrite to a type alias to keep it as convenient.
          *
          * {{{
          * interface Foo {bar: number}
          * type Bar = Foo
          * }}}
          * Note that we rewrite interfaces which extends one type, not more.
          * The reason is that scala wont't let you `new` an intersection type
          */
        case i @ TsDeclInterface(_, _, _, _, IArray.exactlyOne(single), Empty, _) =>
          TsDeclTypeAlias(i.comments, i.declared, i.name, i.tparams, single, i.codePath)

        /**
          * We do this rewrite because in Scala we have no way to instantiate a new instance of `Foo`
          *
          * {{{
          * interface Foo {<T extends object>(a: T) => void}
          * }}}
          * into
          * {{{
          * type Foo<T extends object> = (a: T) => void;
          * }}}
          **/
        case i @ TsDeclInterface(_, _, _, _, Empty, IArray.exactlyOne(call: TsMemberCall), _) =>
          TsDeclTypeAlias(i.comments, i.declared, i.name, i.tparams, TsTypeFunction(call.signature), i.codePath)

        /**
          * There is also a case where we prefer interfaces:
          * {{{
          * type Foo = { bar: number }
          * }}}
          * We would end up with the following given the logic in `ExtractInterfaces`:
          * {{{scala
          * trait Anon_Bar { bar: Double}
          * trait Foo extends Anon_Bar
          * }}}
          *
          * So we rewrite it early instead.
          */
        case TsDeclTypeAlias(cs, dec, name, tparams, AllTypeObjects(members), cp)
            if members.nonEmpty &&
              !TsType.isTypeMapping(members) &&
              !ExtractInterfaces.isDictionary(members) =>
          TsDeclInterface(cs, dec, name, tparams, Empty, members, cp)

        /* Encoding varargs as a type alias is rather pointless since we'll lose the varargs */
        case TsDeclTypeAlias(cs, dec, name, tparams, TsTypeFunction(sig @ TsFunSig(_, _, params, _)), cp)
            if params.exists(_.tpe.exists(_.isInstanceOf[TsTypeRepeated])) =>
          val call = TsMemberCall(NoComments, TsProtectionLevel.Default, sig)
          TsDeclInterface(cs, dec, name, tparams, inheritance = Empty, members = IArray(call), codePath = cp)

        case other =>
          other
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

  class AvoidCircularVisitor(rewrites: IArray[Rewrite]) extends TreeTransformationScopedChanges {
    val map: Map[TsQIdent, Set[TsQIdent]] = rewrites.map(r => (r.target, r.circular + r.target)).toMap

    object ReplaceTypes extends TreeTransformation[Set[TsQIdent]] {
      override def leaveTsTypeRef(toReplace: Set[TsQIdent])(x: TsTypeRef): TsTypeRef =
        if (toReplace(x.name)) TsTypeRef.any
        else x

      override def withTree(t: Set[TsQIdent], tree: TsTree): Set[TsQIdent] =
        tree match {
          /* Handle if the current tree introduces a new type parameter which shadows what we are trying to inline */
          case HasTParams(tparams) =>
            t.filter {
              case TsQIdent(IArray.exactlyOne(one: TsIdentSimple)) if tparams.exists(_.name === one) => false
              case _ => true
            }
          case _ => t
        }
    }

    override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case ta @ TsDeclTypeAlias(comments0, declared, name, tparams, alias, codePath)
            if map.contains(codePath.forceHasPath.codePath) =>
          val rewrite     = map(codePath.forceHasPath.codePath)
          val isTypeParam = TsTypeParam.asTypeArgs(tparams).toSet

          val newComment = Comment {
            val formattedCircularGroup = rewrite.toList.sorted.map(TsTypeFormatter.qident).mkString("- ", "\n- ", "\n")
            s"""/** 
                 |NOTE: Rewritten from type alias:
                 |{{{
                 |type ${name.value} = ${TsTypeFormatter(alias)}
                 |}}}
                 |to avoid circular code involving: 
                 |$formattedCircularGroup
                 |*/
                 |""".stripMargin
          }

          val comments = comments0 + newComment

          FollowAliases(scope)(alias) match {
            case TsTypeIntersect(AllTypeRefs(typeRefs)) if !typeRefs.exists(isTypeParam) =>
              TsDeclInterface(comments, declared, name, tparams, inheritance = typeRefs, members = Empty, codePath)
            case TsTypeObject(_, members) =>
              TsDeclInterface(comments, declared, name, tparams, Empty, members, codePath)
            case TsTypeFunction(signature) =>
              val call = TsMemberCall(NoComments, TsProtectionLevel.Default, signature)
              TsDeclInterface(comments, declared, name, tparams, Empty, IArray(call), codePath)
            case tr: TsTypeRef =>
              TsDeclInterface(comments, declared, name, tparams, inheritance = IArray(tr), members = Empty, codePath)
            case _ =>
              ReplaceTypes.visitTsDeclTypeAlias(rewrite)(ta.copy(comments = comments))
          }

        case i: TsDeclInterface if map.contains(i.codePath.forceHasPath.codePath) =>
          val ii = ReplaceTypes.visitTsDeclInterface(map(i.codePath.forceHasPath.codePath))(i.copy(members = Empty))
          ii.copy(members = i.members)

        case other =>
          other
      }
  }
  object AllTypeRefs {
    def unapply(ts: IArray[TsType]): Option[IArray[TsTypeRef]] =
      ts.partitionCollect { case x: TsTypeRef => x } match {
        case (refs, Empty) => Some(refs)
        case _             => None
      }
  }
}
