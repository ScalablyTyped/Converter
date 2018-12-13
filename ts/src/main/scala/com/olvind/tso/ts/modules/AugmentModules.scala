package com.olvind.tso.ts.modules

import com.olvind.tso.Seq
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._
import com.olvind.tso.ts.transforms.SetCodePath

import scala.collection.mutable

/**
  * Here be dragons, i guess. The implementation of augmented modules is the bare minimum to make a few
  *  key libraries, like lodash, compile. We should really re-do all of this.
  */
object AugmentModules {

  /** Determine which container to extend.
    * By default it will be the provided module, but if it has a default or = export
    *  of a namespace, we put it there instead
    */
  def target(mod: TsDeclModule, scope: TsTreeScope): CodePath.HasPath = {
    val exportedNamespaceOpt: Option[CodePath] =
      mod.exports.firstDefined {
        case TsExport(_, exportType, TsExporteeNames(Seq((qIdent, None)), None)) if ExportType.NotNamed(exportType) =>
          (scope / mod)
            .lookupBase(Picker.Namespaces, qIdent, skipValidation = true)
            .headOption
            .map {
              case (namespace, _) => namespace.codePath
            }
        case _ => None
      }
    val codePath: CodePath = exportedNamespaceOpt getOrElse mod.codePath
    codePath.forceHasPath
  }

  def apply(rootScope: TsTreeScope)(file: TsParsedFile): TsParsedFile = {

    val targetToAux: Map[Option[CodePath.HasPath], Seq[TsAugmentedModule]] =
      file.augmentedModules.groupBy(aux => file.modules.get(aux.name).map(m => target(m, rootScope)))

    val toRemove = mutable.Set.empty[CodePath]

    object Merge extends TreeTransformationUnit {
      override def enterTsDeclNamespace(t: Unit)(x: TsDeclNamespace): TsDeclNamespace =
        targetToAux.get(Option(x.codePath.forceHasPath)) match {
          case Some(auxes) =>
            val auxMembers: Seq[TsContainerOrDecl] =
              auxes.flatMap(_.members).map(am => SetCodePath.visitTsContainerOrDecl(x.codePath.forceHasPath)(am))
            toRemove ++= auxes.map(_.codePath)
            x.copy(members = FlattenTrees.newMembers(x.members, auxMembers))
          case None => x
        }

      override def enterTsDeclModule(t: Unit)(x: TsDeclModule): TsDeclModule =
        targetToAux.get(Option(x.codePath.forceHasPath)) match {
          case Some(auxes) =>
            val auxMembers: Seq[TsContainerOrDecl] =
              auxes.flatMap(_.members).map(am => SetCodePath.visitTsContainerOrDecl(x.codePath.forceHasPath)(am))
            toRemove ++= auxes.map(_.codePath)
            x.copy(members = FlattenTrees.newMembers(x.members, auxMembers))
          case None => x
        }
    }

    object Remove extends TreeTransformationUnit {
      override def leaveTsParsedFile(t: Unit)(x: TsParsedFile): TsParsedFile = {
        val newMembers = x.members.filter {
          case aux: TsAugmentedModule if toRemove(aux.codePath) => false
          case _ => true
        }
        x.copy(members = newMembers)
      }
      override def leaveTsDeclModule(t: Unit)(x: TsDeclModule): TsDeclModule = {
        val newMembers = x.members.flatMap {
          case aux: TsAugmentedModule if toRemove(aux.codePath) => DeriveCopy.downgrade(aux)
          case other => Some(other)
        }
        x.copy(members = newMembers)
      }
    }
    (Merge >> Remove).visitTsParsedFile(())(file)
  }
}
