package com.olvind.tso
package ts

import scala.annotation.implicitNotFound
import scala.collection.mutable

object TreeTraverse {
  trait TreeVisit[T] extends ((TsTree, T) => Unit)

  /**
    * Statically whitelist non-`TsTree` members of `TsTree` which `No` will not visit
    */
  @implicitNotFound("Must run `pf` for ${T}")
  private[TreeTraverse] sealed trait NotTree[T]

  private[TreeTraverse] object NotTree {
    implicit val n0: NotTree[Boolean]          = null
    implicit val n1: NotTree[String]           = null
    implicit val n2: NotTree[Double]           = null
    implicit val n3: NotTree[ProtectionLevel]  = null
    implicit val n4: NotTree[Directive]        = null
    implicit val n5: NotTree[Comments]         = null
    implicit val n6: NotTree[Int]              = null
    implicit val n7: NotTree[Long]             = null
    implicit val n8: NotTree[Seq[String]]      = null
    implicit val n9: NotTree[JsLocation]       = null
    implicit val na: NotTree[CodePath]         = null
    implicit val nb: NotTree[ExportType]       = null
    implicit val nd: NotTree[OptionalModifier] = null
  }

  def collect[T](tree: TsTree)(visit: PartialFunction[TsTree, T]): Seq[T] =
    collectSeq(Seq(tree))(visit)

  def collectSeq[T](tree: Traversable[TsTree])(visit: PartialFunction[TsTree, T]): Seq[T] = {
    val ret = mutable.Buffer.empty[T]

    val visitor: TreeVisit[mutable.Seq[T]] =
      (tree, _) => visit lift tree foreach ret.+=

    tree foreach apply(visitor, ret)

    ret.to[Seq]
  }

  private object No {
    @inline def unapply[N: NotTree](t: N): Boolean = true

    @inline def unapply[N: NotTree](ot: Seq[N]): Boolean = true

    @inline def unapply[N: NotTree](ot: Option[N]): Boolean = true
  }

  def apply[T](visit: TreeVisit[T], acc: T)(tree: TsTree): Unit = {

    visit(tree, acc)

    object Yes {
      @inline def unapply(t: TsTree): Boolean = {
        apply(visit, acc)(t)
        true
      }

      @inline def unapply(ot: Option[TsTree]): Boolean = {
        ot foreach apply(visit, acc)
        true
      }

      @inline def unapply(ot: Seq[TsTree]): Boolean = {
        ot foreach apply(visit, acc)
        true
      }

      object OptionEither {
        @inline def unapply(oett: Option[Either[TsTree, TsTree]]): Boolean = {
          oett foreach { ett =>
            ett.left foreach apply(visit, acc)
            ett.right foreach apply(visit, acc)
          }
          true
        }
      }

      object TupledSeq {
        @inline def unapply(ot: Seq[(TsTree, Option[TsTree])]): Boolean = {
          ot foreach {
            case (t1: TsTree, ot2: Option[TsTree]) =>
              apply(visit, acc)(t1)
              ot2.foreach(t2 => apply(visit, acc)(t2))
          }
          true
        }
      }

      object Either {
        @inline def unapply[L, R](lr: Either[L, R]): Some[(Option[L], Option[R])] =
          Some((lr.left.toOption, lr.right.toOption))
      }

    }

    tree match {
      case TsDeclClass(No(), No(), No(), Yes(), Yes(), Yes(), Yes(), Yes(), No(), No()) =>
      case TsDeclEnum(No(), No(), Yes(), Yes(), No(), No())                             =>
      case TsDeclFunction(No(), No(), Yes(), Yes(), No(), No())                         =>
      case TsGlobal(No(), No(), Yes(), No())                                            =>
      case TsDeclInterface(No(), No(), Yes(), Yes(), Yes(), Yes(), No())                =>
      case TsDeclModule(No(), No(), Yes(), Yes(), No(), No())                           =>
      case TsDeclNamespace(No(), No(), Yes(), Yes(), No(), No())                        =>
      case TsDeclTypeAlias(No(), No(), Yes(), Yes(), Yes(), No())                       =>
      case TsDeclVar(No(), No(), No(), Yes(), Yes(), Yes(), No(), No(), No())           =>
      case TsAugmentedModule(Yes(), Yes(), No(), No())                                  =>
      case TsEnumMember(No(), Yes(), Yes.OptionEither())                                =>
      case TsExportAsNamespace(Yes())                                                   =>
      case TsExporteeNames(Yes.TupledSeq(), Yes())                                      =>
      case TsExporteeStar(Yes(), Yes())                                                 =>
      case TsExporteeTree(Yes())                                                        =>
      case TsExport(No(), No(), Yes())                                                  =>
      case TsFunParam(No(), Yes(), Yes(), No())                                         =>
      case TsFunSig(No(), Yes(), Yes(), Yes())                                          =>
      case TsIdent(No())                                                                =>
      case TsImportedDestructured(Yes.TupledSeq())                                      =>
      case TsImportedIdent(Yes())                                                       =>
      case TsImportedStar(Yes())                                                        =>
      case TsImporteeFrom(Yes())                                                        =>
      case TsImporteeLocal(Yes())                                                       =>
      case TsImporteeRequired(Yes())                                                    =>
      case TsImport(Yes(), Yes())                                                       =>
      case TsLiteralBoolean(No())                                                       =>
      case TsLiteralNumber(No())                                                        =>
      case TsLiteralString(No())                                                        =>
      case TsMemberCall(No(), No(), Yes())                                              =>
      case TsMemberCtor(No(), No(), Yes())                                              =>
      case TsMemberFunction(No(), No(), Yes(), Yes(), No(), No(), No())                 =>
      case TsMemberIndex(No(), No(), No(), Yes(), No(), Yes())                          =>
      case TsMemberProperty(No(), No(), Yes(), Yes(), No(), No(), No())                 =>
      case TsMemberTypeMapped(No(), No(), No(), Yes(), Yes(), No(), Yes())              =>
      case TsParsedFile(No(), No(), Yes(), No())                                        =>
      case TsQIdent(Yes())                                                              =>
      case TsTypeConstructor(Yes())                                                     =>
      case TsTypeConditional(Yes(), Yes(), Yes())                                       =>
      case TsTypeExtends(Yes(), Yes())                                                  =>
      case TsTypeFunction(Yes())                                                        =>
      case TsTypeKeyOf(Yes())                                                           =>
      case TsTypeInfer(Yes())                                                           =>
      case TsTypeIntersect(Yes())                                                       =>
      case TsTypeIs(Yes(), Yes())                                                       =>
      case TsTypeLiteral(Yes())                                                         =>
      case TsTypeLookup(Yes(), Yes.Either(Yes(), Yes()))                                =>
      case TsTypeObject(Yes())                                                          =>
      case TsTypeParam(No(), Yes(), Yes(), Yes())                                       =>
      case TsTypeQuery(Yes())                                                           =>
      case TsTypeRef(Yes(), Yes())                                                      =>
      case TsTypeRepeated(Yes())                                                        =>
      case TsTypeThis()                                                                 =>
      case TsTypeTuple(Yes())                                                           =>
      case TsTypeUnion(Yes())                                                           =>
      case IndexingDict(Yes(), Yes())                                                   =>
      case IndexingSingle(Yes())                                                        =>
    }
  }
}
