package com.olvind.tso
package ts.modules

import com.olvind.tso.ts._

object DeriveCopy {
  def apply(x: TsNamedDecl, rename: Option[TsIdent], generateInterface: Boolean): Seq[TsNamedDecl] = {
    val origin = x.codePath.forceHasPath.codePath
    x match {
      case x: TsDeclClass =>
        val `class` = x.copy(
          name = rename getOrElse x.name,
          members = x.members.collect {
            case c: TsMemberCtor => c
            case c @ TsMemberFunction(_, _, TsIdent.constructor, _, _, _, _) => c
            case x: TsMemberProperty if x.isStatic => x
            case x: TsMemberFunction if x.isStatic => x
          },
          declared   = true,
          implements = Nil,
          parent     = Some(TsTypeRef(origin, TsTypeParam.asTypeArgs(x.tparams)))
        )

        if (generateInterface && rename.isDefined) List(downgradeClass(x), `class`) else List(`class`)

      case x: TsDeclInterface =>
        List(
          TsDeclTypeAlias(
            comments = NoComments,
            declared = true,
            name     = rename getOrElse x.name,
            tparams  = x.tparams,
            alias    = TsTypeRef(origin, TsTypeParam.asTypeArgs(x.tparams)),
            codePath = x.codePath
          )
        )

      case x: TsDeclEnum =>
        List(
          TsDeclTypeAlias(
            comments = NoComments,
            declared = true,
            name     = rename getOrElse x.name,
            tparams  = Nil,
            alias    = TsTypeRef(origin, Nil),
            codePath = x.codePath
          )
        )

      case x: TsDeclVar =>
        List(x.copy(name = rename getOrElse x.name))

      case x: TsDeclFunction =>
        List(x.copy(name = rename getOrElse x.name))

      case x: TsDeclNamespace =>
        val newMembers = x.members.collect { case m: TsNamedDecl => apply(m, None, generateInterface) }.flatten
        val name = rename match {
          case Some(renamed) => TsIdentNamespace(renamed.value)
          case None          => x.name
        }
        List(x.copy(name = name, members = newMembers))

      case x: TsDeclModule =>
        val newMembers = x.members.collect { case m: TsNamedDecl => apply(m, None, generateInterface) }.flatten
        val name = rename match {
          case Some(_) => sys.error(s"Unexpected rename of module ${x.name}")
          case None    => x.name
        }
        List(x.copy(name = name, members = newMembers))

      case x: TsAugmentedModule =>
        val newMembers = x.members.collect({ case m: TsNamedDecl => apply(m, None, generateInterface) }).flatten
        val name = rename match {
          case Some(_) => sys.error(s"Unexpected rename of module ${x.name}")
          case None    => x.name
        }
        List(x.copy(name = name, members = newMembers))

      case x: TsDeclTypeAlias =>
        List(
          TsDeclTypeAlias(NoComments,
                          declared = false,
                          rename getOrElse x.name,
                          x.tparams,
                          TsTypeRef(x.codePath.forceHasPath.codePath, TsTypeParam.asTypeArgs(x.tparams)),
                          x.codePath)
        )
    }
  }

  def downgradeClass(x: TsDeclClass): TsDeclInterface = {
    val nonStatics: Seq[TsMember] =
      x.members filterNot {
        case _:  TsMemberCtor     => true
        case xx: TsMemberProperty => xx.isStatic
        case xx: TsMemberFunction => xx.isStatic || xx.name === TsIdent.constructor
        case _ => false
      }

    TsDeclInterface(x.comments, x.declared, x.name, x.tparams, x.parent.to[Seq] ++ x.implements, nonStatics, x.codePath)
  }

  def downgrade(x: TsContainerOrDecl): Seq[TsNamedDecl] = x match {
    case cls: TsDeclClass =>
      Seq(downgradeClass(cls))
    case x: TsDeclNamespace =>
      Seq(x.copy(members = x.members flatMap downgrade))
    case x: TsDeclEnum =>
      val tpe: TsTypeRef =
        x.members
          .collectFirst {
            case TsEnumMember(_, _, Some(Left(lit))) =>
              lit match {
                case TsLiteralNumber(_)  => TsTypeRef.number
                case TsLiteralBoolean(_) => TsTypeRef.boolean
                case TsLiteralString(_)  => TsTypeRef.string
              }
          }
          .getOrElse(TsTypeRef.any)

      Seq(TsDeclTypeAlias(NoComments, declared = false, x.name, Nil, tpe, x.codePath))
    case _: TsNamedValueDecl =>
      Nil
    case x: TsNamedDecl => Seq(x)
    case _ => Nil
  }

}
