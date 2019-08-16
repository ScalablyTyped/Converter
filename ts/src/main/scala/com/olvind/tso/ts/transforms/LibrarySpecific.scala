package com.olvind.tso
package ts
package transforms

object LibrarySpecific {
  trait Named extends TreeTransformationScopedChanges {
    val libName: TsIdentLibrary
  }

  object React extends Named {
    val libName       = TsIdentLibrarySimple("react")
    val ReactElement  = TsIdent("ReactElement")
    val ReactFragment = TsIdent("ReactFragment")
    val ReactNode     = TsIdent("ReactNode")
    val Readonly      = TsQIdent(List(TsIdent("Readonly")))

    override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
      x.name match {
        /* drop useless type parameters */
        case ReactElement =>
          val newX = x.copy(tparams = Nil)
          new TypeRewriter(newX)
            .visitTsDeclInterface(TsTypeParam.asTypeArgs(x.tparams).map(_ -> TsTypeRef.any).toMap)(newX)
        case _ => x
      }

    override def enterTsDeclTypeAlias(t: TsTreeScope)(x: TsDeclTypeAlias): TsDeclTypeAlias =
      x.name match {
        case ReactFragment =>
          x.alias match {
            case TsTypeUnion(types) =>
              val dropObject = types.filter {
                case TsTypeRef.`object` => false
                case _                  => true
              }
              x.copy(alias = TsTypeUnion.simplified(dropObject))
            case _ => x
          }

        case ReactNode =>
          x.alias match {
            case TsTypeUnion(types) =>
              val dropUseless = types.filter {
                case TsTypeRef.`null` => false
                case _                => true
              }
              x.copy(alias = TsTypeUnion.simplified(dropUseless))
            case _ => x
          }

        case _ => x
      }

  }

  val patches: Map[TsIdentLibrary, Named] =
    Seq(React).map(x => x.libName -> x).toMap

  def apply(libName: TsIdentLibrary): Option[TreeTransformationScopedChanges] = patches.get(libName)
}
