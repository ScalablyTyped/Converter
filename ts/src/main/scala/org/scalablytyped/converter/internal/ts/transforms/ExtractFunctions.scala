package org.scalablytyped.converter.internal
package ts
package transforms

object ExtractFunctions extends TreeTransformationScopedChanges {

  override def enterTsContainer(scope: TsTreeScope)(x: TsContainer): TsContainer = {
    val newMembers: IArray[TsContainerOrDecl] =
      x.members flatMap {
        case v: TsDeclVar =>
          v.tpe match {
            case Some(tpe) =>
              extract(FollowAliases(scope)(tpe)) match {
                case (Some(f), restOpt) =>
                  IArray.fromOptions(
                    restOpt.map(tpe => v.copy(tpe = Some(tpe))),
                    Some(TsDeclFunction(v.comments, v.declared, v.name, f.signature, v.jsLocation, v.codePath)),
                  )
                case _ => IArray(v)
              }
            case None => IArray(v)
          }
        case other => IArray(other)
      }

    x.withMembers(newMembers)
  }

  def extract(tpe: TsType): (Option[TsTypeFunction], Option[TsType]) =
    tpe match {
      case f: TsTypeFunction => (Some(f), None)
      case TsTypeIntersect(types) =>
        val splits = types.map(extract)
        val fs     = splits.collect { case (Some(f), _) => f }
        val rest   = splits.collect { case (_, Some(rest)) => rest }
        fs.headOption match {
          case Some(f) =>
            rest match {
              case Empty => (Some(f), None)
              case some  => (Some(f), Some(TsTypeIntersect(some)))
            }
          case None => (None, Some(tpe))
        }

      case other => (None, Some(other))
    }
}
