package org.scalablytyped.converter.internal
package ts

import seqs._

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
  val Anon          = ""
  val Fn            = "Fn"
  val isMeaningless = Set(Anon, Fn)

  def apply[T](prefix: String, members: IArray[TsMember])(tryCreate: TsIdentSimple => Option[T]): T = {
    val fromCalls: Option[Detail] = {
      members.collect { case TsMemberCall(_, _, sig) => sig } match {
        case Empty => None
        case calls =>
          val longest = calls.maxBy(_.params.length)
          Some(Detail(s"Call", s"Call${longest.params.map(_.name.value.capitalize).mkString}"))
      }
    }

    /** note, we sort below. This is beneficial from a consistency perspective, and
      *  negative for the number of names we can generate. Prefer the former for now
      */
    val fromMembers: IArray[Detail] =
      members.collect {
        case x: TsMemberProperty =>
          val short = Detail.pretty(x.name.value)
          Detail(short, IArray.fromOptions(Some(short), Detail.prettyType(x.tpe)).mkString)
        case TsMemberIndex(_, _, _, IndexingSingle(qname), tpe) =>
          val short = Detail.pretty(qname.parts.last.value)
          Detail(short, IArray.fromOptions(Some(short), Detail.prettyType(tpe)).mkString)
        case x: TsMemberFunction => Detail(Detail.pretty(x.name.value))
      }

    val fromInstantiable: Option[Detail] =
      members.collectFirst {
        case TsMemberCtor(_, _, signature) =>
          val short = "Instantiable"
          Detail(
            short,
            IArray.fromOptions(Some(short), Detail.prettyType(signature.resultType)).mkString,
          )
      }

    val fromDict: Option[Detail] =
      members
        .collectFirst {
          case TsMemberIndex(_, _, _, IndexingDict(name, inType), outType) =>
            val short = Detail.pretty("Dict" + name.value)
            val long = IArray
              .fromOptions(Some(short), Some(Detail.prettyType(inType)), Detail.prettyType(outType))
              .mkString
            Detail(short, long)
        }

    val details = IArray.fromOptions(fromCalls, fromInstantiable, fromDict) ++ fromMembers.sorted.distinct

    val nameVariants: Stream[String] =
      for {
        longVersion <- Stream(false, true)
        amount <- Stream.range(if (isMeaningless(prefix)) 1 else 0, details.length + 1)
        idx <- Stream.range(0, details.length)
      } yield {
        val pick = details.drop(idx).take(amount)
        prefix + pick.map(_.pick(longVersion)).mkString("")
      }

    nameVariants
      .firstDefined(name => tryCreate(TsIdent(name)))
      .getOrElse(fallback(prefix, tryCreate))
  }

  private def fallback[T](prefix: String, tryCreate: TsIdentSimple => Option[T]): T = {
    var idx = 0
    while (true) {
      tryCreate(TsIdent(prefix + idx)) match {
        case Some(t) => return t
        case _       => ()
      }
      idx += 1
    }
    sys.error("unreachable")
  }

  final case class Detail(short: String, long: String) {
    def pick(wantLong: Boolean): String =
      if (wantLong) long else short
  }

  object Detail {
    def apply(s: String) = new Detail(s, s)

    implicit val ordering: Ordering[Detail] = Ordering[String].on[Detail](_.short)

    def pretty(str: String): String =
      str.filter(_.isLetterOrDigit).capitalize

    def prettyType(tpeOpt: Option[TsType]): Option[String] =
      tpeOpt match {
        case Some(tpe) => Some(prettyType(tpe))
        case None      => None
      }

    def prettyType(tpe: TsType): String =
      tpe match {
        case TsTypeRef(_, name, _) => pretty(name.parts.last.value)
        case _                     => ""
      }
  }
}
