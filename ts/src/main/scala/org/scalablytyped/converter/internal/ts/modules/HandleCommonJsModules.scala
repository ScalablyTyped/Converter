package org.scalablytyped.converter.internal
package ts
package modules

import org.scalablytyped.converter.internal.ts.transforms.{QualifyReferences, SetCodePath}

/**
  * It's really difficult to reconcile two module systems, this is a preparational step which
  *  helps us enable the following pattern:
  *
  * ```typescript
  * declare class A {}
  * declare namespace A {
  *   interface B {
  *     nested: A.B // (1)
  *     edgeCase: Types.B // (2)
  *   }
  *   type N = number
  *   export import Types = A;
  * }
  * type N = A.N // (3)
  * export = A;
  * ```
  *
  * The exportees (`class A` here) outside the namespace is handled ok, and end up named `TsIdent.namespaced`
  *  after we resolve everything.
  *
  * For the namespace we need to flatten it, and rewrite all references to it.
  *
  * Eventually we'll end up with something like this:
  *
  * ```typescript
  * export interface A {}
  * export declare class namespaced implements A {}
  * export interface B {
  *   nested: B;
  *   edgeCase: B;
  * }
  * export type N = number;
  * ```
  *
  */
object HandleCommonJsModules extends TreeTransformationScopedChanges {

  /**
    * If this is a commonjs module we extract the name of the exported thing
    */
  object EqualsExport {
    def unapply(x: TsDeclModule): Option[((TsExport, IArray[TsIdent]), IArray[TsContainerOrDecl])] = {
      val (es, rest) = x.members.partitionCollect {
        case e @ TsExport(
              _,
              _,
              ExportType.Namespaced,
              TsExporteeNames(IArray.exactlyOne((TsQIdent(qident), None)), _),
            ) =>
          e -> qident
      }
      es.headOption.map(e => e -> rest)
    }
  }

  override def enterTsDeclModule(t: TsTreeScope)(mod: TsDeclModule): TsDeclModule =
    mod match {
      case EqualsExport(((export, IArray.exactlyOne(target)), notExports)) =>
        val (namespaces, toplevel, _rest) = notExports.partitionCollect2(
          { case x: TsDeclNamespace if x.name.value === target.value => x },
          { case x: TsNamedDecl if x.name === target                 => x },
        )

        /**
          * Support things like this:
          *
          * ```typescript
          * type Err = Error;
          *
          * declare namespace createError {
          *     interface Error<T extends Err> extends Err {
          *         new (message?: string, obj?: any): T;
          *     }
          * }
          *
          * export = createError;
          * ```
          * `Err` refers to global error, not the one defined in the namespace.
          * Note that we cannot do this in arbitrary modules, as we might leave
          *  conflicting definitions in the same scope (2x `type Props = ...` for instance)
          */
        val rest = {
          val Q            = new QualifyReferences(skipValidation = true)
          val patchedScope = t.`..` / mod.copy(members = _rest.filter(_.isInstanceOf[TsImport]))
          _rest.map(Q.visitTsContainerOrDecl(patchedScope))
        }

        if (namespaces.isEmpty) mod
        else {
          /* lift up the namespace members and reset codepath */
          val flattened = namespaces
            .flatMap(_.members)
            .map {
              case x: TsNamedDecl => TsExport(NoComments, typeOnly = false, ExportType.Named, TsExporteeTree(x))
              case other => other
            }
            .map(x => SetCodePath.visitTsContainerOrDecl(mod.codePath.forceHasPath)(x))

          val maybeKeepOriginalExport = if (toplevel.nonEmpty) IArray(export) else Empty

          /* handle (3) */
          val patchedRest = rest.filter {
            case TsDeclTypeAlias(
                _,
                _,
                typeName,
                Empty,
                TsTypeRef(_, TsQIdent(IArray.exactlyTwo(`target`, referredName)), Empty),
                _,
                ) =>
              referredName =/= typeName
            case _ => true
          }
          val newMembers = flattened ++ patchedRest ++ toplevel ++ maybeKeepOriginalExport

          /* this is essentially a hack to make aws-sdk work, (2) */
          val patchedNewMembers =
            newMembers.map {
              case TsExport(
                  _,
                  _,
                  ExportType.Named,
                  TsExporteeTree(
                    TsImport(
                      _,
                      IArray.exactlyOne(TsImportedIdent(newName)),
                      TsImporteeLocal(TsQIdent(IArray.exactlyOne(name))),
                    ),
                  ),
                  ) if name.value === target.value =>
                TsExport(
                  NoComments,
                  typeOnly = false,
                  ExportType.Named,
                  TsExporteeTree(
                    TsDeclVar(
                      Comments(CommentData(Markers.IsTrivial)),
                      declared = true,
                      readOnly = true,
                      newName,
                      Some(TsTypeThis()),
                      None,
                      mod.jsLocation + newName,
                      mod.codePath + newName,
                    ),
                  ),
                )
              case other => other
            }

          /* handle (1) */
          object EraseNamespaceRefs extends TreeTransformationUnit {
            override def enterTsTypeRef(t: Unit)(x: TsTypeRef): TsTypeRef =
              x match {
                case TsTypeRef(_, TsQIdent(from), _) if from.head === target =>
                  from.drop(1) match {
                    case IArray.Empty => x
                    case to           => x.copy(name = TsQIdent(to))
                  }
                case other => other
              }
          }

          EraseNamespaceRefs.visitTsDeclModule(())(mod.withMembers(patchedNewMembers))
        }

      case _ => mod
    }
}
