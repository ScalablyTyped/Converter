package org.scalablytyped.converter.internal
package ts

import scala.collection.mutable

trait MemberCache {

  def members: IArray[TsContainerOrDecl]

  lazy val (
    nameds:  IArray[TsNamedDecl],
    exports: IArray[TsExport],
    imports: IArray[TsImport],
    unnamed: IArray[TsContainerOrDecl],
  ) =
    members.partitionCollect3(
      { case m: TsNamedDecl => m },
      { case x: TsExport    => x },
      { case x: TsImport    => x },
    )

  lazy val isModule: Boolean =
    exports.nonEmpty || imports.exists {
      case TsImport(_, _, _: TsImporteeLocal) => false
      case _ => true
    }

  @deprecated("kill with fire", "")
  lazy val membersByNameMeh: Map[TsIdent, IArray[TsNamedDecl]] = {
    val ret = mutable.Map.empty[TsIdent, List[TsNamedDecl]]

    members.foreach {
      case mod: TsDeclModule =>
        mod.members.foreach {
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
      case TsExport(_, _, _, TsExporteeTree(x: TsNamedDecl)) =>
        ret(x.name) = x :: ret.getOrElseUpdate(x.name, Nil)
      case _ => ()
    }

    ret.mapValues(IArray.fromTraversable).toMap
  }

  lazy val membersByName: Map[TsIdent, IArray[TsNamedDecl]] =
    nameds.groupBy(_.name)

  private lazy val modulesBase =
    nameds.collect { case m: TsDeclModule => (m.name, m) }

  lazy val modules: Map[TsIdentModule, TsDeclModule] =
    modulesBase.toMap

  lazy val augmentedModules: IArray[TsAugmentedModule] =
    nameds.collect { case m: TsAugmentedModule => m } ++ modulesBase.flatMap(_._2.augmentedModules)

  lazy val augmentedModulesMap: Map[TsIdentModule, IArray[TsAugmentedModule]] =
    nameds.collect { case m: TsAugmentedModule => m }.groupBy(_.name)
}

trait HasClassMembers {
  def members: IArray[TsMember]

  lazy val (membersByName: Map[TsIdentSimple, IArray[TsMember]], unnamed: IArray[TsMember]) = {
    val (named, unnamed: IArray[TsMember]) =
      members.partitionCollect {
        case x: TsMemberCall     => x
        case x: TsMemberFunction => x
        case x: TsMemberProperty => x
        case x: TsMemberCtor     => x
      }

    val map = named.groupBy {
      case x: TsMemberFunction => x.name
      case x: TsMemberProperty => x.name
      case _: TsMemberCall     => TsIdent.Apply
      case _: TsMemberCtor     => TsIdent.constructor
      case other => sys.error(s"Unexpected: ${other.asString}")
    }
    (map, unnamed)
  }
}
