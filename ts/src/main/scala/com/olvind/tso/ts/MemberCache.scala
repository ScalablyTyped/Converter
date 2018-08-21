package com.olvind.tso
package ts

import com.olvind.tso.seqs.TraversableOps

trait MemberCache {

  def members: Seq[TsContainerOrDecl]

  lazy val (nameds: Seq[TsNamedDecl], exports: Seq[TsExport], imports: Seq[TsImport], unnamed: Seq[TsContainerOrDecl]) =
    members.partitionCollect3(
      { case m: TsNamedDecl => m },
      { case x: TsExport    => x },
      { case x: TsImport    => x }
    )

  lazy val isModule: Boolean =
    exports.nonEmpty || imports.exists {
      case TsImport(_, _: TsImporteeLocal) => false
      case _ => true
    }

  @deprecated("kill with fire")
  lazy val membersByNameMeh: Map[TsIdent, Seq[TsNamedDecl]] = {
    val fromExports = exports collect {
      case TsExport(_, _, TsExporteeTree(x: TsNamedDecl)) => x
    }

    val ret = (nameds ++ fromExports).groupBy(_.name)

    val modulesAsNamespace =
      modules.flatMap {
        case (_, m) =>
          m.unnamed.flatMap {
            case TsExportAsNamespace(ident) => Map(ident -> m)
            case TsGlobal(_, _, ms, _)      => ms.collect { case x: TsNamedDecl => x.name -> x }
            case _                          => Nil
          }
      }

    //todo: optimize this
    modulesAsNamespace.foldLeft(ret) {
      case (ret, (ident, mod)) =>
        val v = ret.get(ident) match {
          case Some(found) => found :+ mod
          case None        => Seq(mod)
        }
        ret.updated(ident, v)
    }
  }

  lazy val membersByName: Map[TsIdent, Seq[TsNamedDecl]] =
    nameds.groupBy(_.name)

  lazy val modules: Map[TsIdentModule, TsDeclModule] =
    nameds.collect { case m: TsDeclModule => (m.name, m) }.toMap

  lazy val augmentedModules: Seq[TsAugmentedModule] =
    nameds.collect { case m: TsAugmentedModule => m } ++ modules.flatMap(_._2.augmentedModules)

  lazy val augmentedModulesMap: Map[TsIdentModule, Seq[TsAugmentedModule]] =
    nameds.collect { case m: TsAugmentedModule => m }.groupBy(_.name)
}

trait HasClassMembers {
  def members: Seq[TsMember]

  lazy val (membersByName: Map[TsIdent, Seq[TsMember]], unnamed: Seq[TsMember]) = {
    val (named, unnamed: Seq[TsMember]) =
      members.partitionCollect {
        case x: TsMemberCall     => x
        case x: TsMemberFunction => x
        case x: TsMemberProperty => x
        case x: TsMemberCtor     => x
      }

    val map = named groupBy {
      case x: TsMemberFunction => x.name
      case x: TsMemberProperty => x.name
      case _: TsMemberCall     => TsIdent.Apply
      case _: TsMemberCtor     => TsIdent.constructor
    }
    (map, unnamed)
  }
}
