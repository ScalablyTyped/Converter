package com.olvind.tso
package ts

import scala.annotation.tailrec

/**
  * Sometimes we need to name things in Scala where they were anonymous in Typescript.
  *
  * This tries to look at the contents of the code and name it based on member names first,
  *  and then whatever other strings it can find. We try to make the names as short as
  *  possible, and only generate longer names on conflict.
  *
  * This means that our naming is order-dependent, which... might not be good at all.
  *
  * If the algorithm is unable to come up with a non-conflicting name, it adds the hashCode()
  * of the members.
  */
object DeriveNonConflictingName {
  def pretty(str: String): String =
    str.filter(_.isLetterOrDigit).capitalize

  val ExtractNameParts: PartialFunction[TsTree, String] = {
    case x: TsNamedDecl      => pretty(x.name.value)
    case x: TsMemberProperty => pretty(x.name.value)
    case x: TsMemberFunction => pretty(x.name.value)
    case x: TsFunParam       => pretty(x.name.value)
    case x: TsLiteral        => pretty(x.literal)
    case TsMemberIndex(_, _, _, IndexingDict(name, _), _, _) => pretty(name.value)
    case TsMemberIndex(_, _, _, IndexingSingle(name), _, _)  => pretty(name.parts.head.value)
  }

  val ExtractNamePartsSecondary: PartialFunction[TsTree, String] = {
    case x: TsTypeParam => pretty(x.name.value)
    case x: TsTypeRef   => pretty(x.name.parts.last.value)
  }

  val ExtractNamePartsTertiary: PartialFunction[TsTree, String] = {
    case x: TsQIdent         => pretty(x.parts.last.value)
    case x: TsMemberProperty => if (x.isOptional) "Optional" else ""
    case x: TsFunParam       => if (x.isOptional) "Optional" else ""
    case x: TsMemberFunction => if (x.isOptional) "Optional" else ""
  }

  def apply[T](prefix: String, members: Seq[TsTree])(tryCreate: TsIdent => Option[T]): T = {
    val names     = TreeTraverse.collectSeq(members)(ExtractNameParts)
    val secondary = TreeTraverse.collectSeq(members)(ExtractNamePartsSecondary)
    val tertiary  = TreeTraverse.collectSeq(members)(ExtractNamePartsTertiary)
    val base      = (prefix +: (names ++ secondary ++ tertiary)).distinct

    @tailrec
    def go(num: Int): T =
      (num > base.length, base take num mkString "") match {
        case (true, baseName) =>
          tryCreate(TsIdent(baseName + "_" + math.abs(members.hashCode()).toString)) getOrElse
            sys.error("Could not derive unique name")

        case (false, name) =>
          tryCreate(TsIdent(name)) match {
            case Some(ret) => ret
            case None      => go(num + 1)
          }

      }

    go(2)
  }
}
