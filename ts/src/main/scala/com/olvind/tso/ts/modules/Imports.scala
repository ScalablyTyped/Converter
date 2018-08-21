package com.olvind.tso
package ts.modules

import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts._

object Imports {
  def lookupFromImports2[T <: TsNamedDecl](scope:        TreeScope.Scoped,
                                           picker:       Picker[T],
                                           wanted:       List[TsIdent],
                                           loopDetector: LoopDetector,
                                           imports:      Seq[TsImport]): Option[Seq[(T, TreeScope)]] =
    pickImport(imports, wanted) map {
      case (newWanteds, chosenImport) =>
        chosenImport.from match {
          case TsImporteeRequired(fromModule) =>
            newWanteds.flatMap(
              newWanted => Exports.lookupExportFrom(scope moduleScopes fromModule, picker, newWanted, loopDetector)
            )

          case TsImporteeFrom(fromModule) =>
            newWanteds.flatMap(
              newWanted => Exports.lookupExportFrom(scope moduleScopes fromModule, picker, newWanted, loopDetector)
            )
          case TsImporteeLocal(qident) =>
            newWanteds.flatMap(
              newWanted => scope.lookupInternal(picker, qident.parts ++ newWanted, loopDetector)
            )
        }
    }

  def lookupFromImports[T <: TsNamedDecl](scope:        TreeScope.Scoped,
                                          Pick:         Picker[T],
                                          wanted:       List[TsIdent],
                                          loopDetector: LoopDetector,
                                          imports:      Seq[TsImport]): Option[Seq[(T, TreeScope)]] =
    pickImport(imports, wanted) flatMap {
      case (newWanteds, chosenImport) =>
        chosenImport.imported.toList match {
//          case TsImportedStar(Some(renamed)) :: Nil  =>
//            lookup(newWanteds, chosenImport, scope, Picker.All, loopDetector).flatMap { founds =>
//
//              val asNamespace = TsDeclNamespace(
//                NoComments,
//                declared = false,
//                TsIdentNamespace(renamed.value),
//                founds.map(_._1),
//                CodePath.NoPath,
//                JsLocation.Zero
//              )
//
//              asNamespace match {
//                case Pick(t) => Some((t, scope) :: Nil)
//                case _       => None
//              }
//            }
          case _ =>
            lookup(newWanteds, chosenImport, scope, Pick, loopDetector)
        }
    }

  def lookup[T <: TsNamedDecl](newWanteds:   List[List[TsIdent]],
                               chosenImport: TsImport,
                               scope:        TreeScope,
                               picker:       Picker[T],
                               loopDetector: LoopDetector): Option[Seq[(T, TreeScope)]] =
    chosenImport.from match {
      case TsImporteeRequired(fromModule) =>
        FirstNonEmpty.ofLists(newWanteds) { newWanted =>
          Exports.lookupExportFrom(scope moduleScopes fromModule, picker, newWanted, loopDetector)
        }

      case TsImporteeFrom(fromModule) =>
        FirstNonEmpty.ofLists(newWanteds) { newWanted =>
          Exports.lookupExportFrom(scope moduleScopes fromModule, picker, newWanted, loopDetector)
        }
      case TsImporteeLocal(qident) =>
        FirstNonEmpty.ofLists(newWanteds) { newWanted =>
          scope.lookupInternal(picker, qident.parts ++ newWanted, loopDetector)
        }
    }

  def pickImport(imports: Seq[TsImport], wanted: List[TsIdent]): Option[(List[List[TsIdent]], TsImport)] =
    imports firstDefined validImport(wanted)

  def validImport(wanted: List[TsIdent])(i: TsImport): Option[(List[List[TsIdent]], TsImport)] =
    wanted match {
      case Nil => None
      case first :: rest =>
        i.imported firstDefined {
          case TsImportedIdent(`first`) =>
            val prefix: List[List[TsIdent]] =
              i.from match {
                case _: TsImporteeRequired => List(rest, TsIdent.namespaced +: rest)
                case _: TsImporteeFrom     => List(rest, TsIdent.default +: rest)
                case _: TsImporteeLocal    => List(rest)
              }
            Some((prefix, i))

          case TsImportedIdent(_) => None

          case TsImportedDestructured(idents) =>
            idents collectFirst {
              case (`first`, None)           => (List(wanted), i)
              case (original, Some(`first`)) => (List(original +: rest), i)
            }

          case TsImportedStar(asOpt) =>
            if (asOpt.contains(`first`))
              Some((List(rest, TsIdent.All +: rest, TsIdent.namespaced +: rest), i))
            else None
        }
    }
}
