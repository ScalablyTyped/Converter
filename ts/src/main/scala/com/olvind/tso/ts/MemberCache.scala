package com.olvind.tso
package ts

import com.olvind.tso.seqs.TraversableOps

import scala.collection.mutable

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

  @deprecated("kill with fire", "")
  lazy val membersByNameMeh: Map[TsIdent, Seq[TsNamedDecl]] = {
    val ret = mutable.Map.empty[TsIdent, List[TsNamedDecl]]

    members.foreach {
      case mod: TsDeclModule =>
        ret(mod.name) = mod :: ret.getOrElseUpdate(mod.name, Nil)

        mod.members foreach {
          case TsExportAsNamespace(ident) =>
            ret(ident) = mod :: ret.getOrElseUpdate(ident, Nil)
          case TsGlobal(_, _, ms, _) =>
            ms.foreach {
              case x: TsNamedDecl =>
                ret(x.name) = x :: ret.getOrElseUpdate(x.name, Nil)

              case _ => ()
            }
          case _ => ()
        }
      case x: TsNamedDecl =>
        ret(x.name) = x :: ret.getOrElseUpdate(x.name, Nil)
      case TsExport(_, _, TsExporteeTree(x: TsNamedDecl)) =>
        ret(x.name) = x :: ret.getOrElseUpdate(x.name, Nil)
      case _ => ()
    }

    ret.toMap
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
