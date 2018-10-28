package com.olvind.tso
package ts
package transforms

object ExpandKeyOfTypeParams extends TreeVisitorScopedChanges {

  case class IndexedTypeParam(cs: Comments, typeParam: TsIdent, map: TsQIdent)

  private object IndexedTypeParams {
    def unapply(ts: Seq[TsTypeParam]): Option[(IndexedTypeParam, Seq[TsTypeParam])] =
      ts.collectFirst {
        case TsTypeParam(cs, name, Some(TsTypeKeyOf(TsTypeRef(map, Nil))), None) =>
          (IndexedTypeParam(cs, name, map), ts.filterNot(_.name === name))
      }
  }

  override def enterTsDeclInterface(scope: TreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(scope, x.members))

  override def enterTsDeclClass(scope: TreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(scope, x.members))

  override def enterTsParsedFile(scope: TreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newContainerMembers(scope, x.members))

  override def enterTsDeclModule(scope: TreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newContainerMembers(scope, x.members))

  override def enterTsDeclNamespace(scope: TreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newContainerMembers(scope, x.members))

  def newClassMembers(scope: TreeScope, members: Seq[TsMember]): Seq[TsMember] =
    members.flatMap {
      case m @ TsMemberFunction(_, _, name, sig @ TsFunSig(_, IndexedTypeParams(indexed, rest), _, _), _, _, _) =>
        lookupMemberPropertiesFrom(scope / m, indexed.map) match {
          case Nil => Seq(m)
          case nonEmpty =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")

            nonEmpty collect {
              case TsMemberProperty(_, Default, TsIdentSimple(n), Some(tpe), _, false, false, false) =>
                val mm = m.copy(signature = sig.copy(tparams = rest))

                new TypeRewriter(mm).visitTsMemberFunction(
                  Map(
                    TsTypeRef.of(indexed.typeParam) -> TsTypeLiteral(TsLiteralString(n)),
                    TsTypeLookup(TsTypeRef(indexed.map, Nil), Left(indexed.typeParam)) -> tpe
                  )
                )(mm)

            }
        }
      case other => Seq(other)
    }

  def newContainerMembers(scope: TreeScope, members: Seq[TsContainerOrDecl]): Seq[TsContainerOrDecl] =
    members flatMap {
      case m @ TsDeclFunction(_, _, name, sig @ TsFunSig(_, IndexedTypeParams(indexed, rest), _, _), _, _) =>
        lookupMemberPropertiesFrom(scope / m, indexed.map) match {
          case Nil => Seq(m)
          case nonEmpty =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")

            nonEmpty collect {
              case TsMemberProperty(_, Default, TsIdentSimple(n), Some(tpe), _, false, false, false) =>
                val mm = m.copy(signature = sig.copy(tparams = rest))
                new TypeRewriter(mm).visitTsDeclFunction(
                  Map(
                    TsTypeRef.of(indexed.typeParam) -> TsTypeLiteral(TsLiteralString(n)),
                    TsTypeLookup(TsTypeRef(indexed.map, Nil), Left(indexed.typeParam)) -> tpe
                  )
                )(mm)
            }
        }
      case other => Seq(other)
    }

  def lookupMemberPropertiesFrom(scope: TreeScope, name: TsQIdent): Seq[TsMemberProperty] =
    scope
      .lookupBase(Picker.Types, name)
      .flatMap {
        case (i: TsDeclInterface, newScope) =>
          val thisMemberProperties = i.members.collect {
            case x: TsMemberProperty => x
          }

          thisMemberProperties ++ i.inheritance.flatMap(tpe => mpsFromType(newScope, tpe))

        case (TsDeclTypeAlias(_, _, _, Nil, tpe, _), newScope) => mpsFromType(newScope, tpe)
        case other =>
          scope.logger.fatalMaybe(s"Unexpected not interface or type alias $other", constants.Pedantic)
          Nil
      }

  def mpsFromType(scope: TreeScope, tpe: TsType): Seq[TsMemberProperty] =
    tpe match {
      case TsTypeRef(parent, Nil) => lookupMemberPropertiesFrom(scope, parent)
      case TsTypeObject(
          Seq(TsMemberTypeMapped(cs, level, isReadOnly, key, TsTypeKeyOf(TsTypeRef(from, Nil)), opt, to))
          ) =>
        lookupMemberPropertiesFrom(scope, from)
          .map {
            case TsMemberProperty(cs0, level0, name0, Some(tpe0), lit, isStatic, isReadOnly0, wasOptional) =>
              TsMemberProperty(
                cs ++ cs0,
                if (level =/= Default) level else level0,
                name0,
                Some(new TypeRewriter(to).visitTsType(Map(TsTypeLookup(TsTypeRef(from, Nil), Left(key)) -> tpe0))(to)),
                lit,
                isStatic,
                isReadOnly || isReadOnly0,
                opt(wasOptional)
              )

            case other => scope.logger.fatal(s"Unexpected non member property: $other")
          }

      case TsTypeIntersect(types) =>
        types flatMap (tpe => mpsFromType(scope, tpe))

      case other =>
        scope.logger.warn(s"Doesnt know how to handle $other")
        Nil
    }
}
