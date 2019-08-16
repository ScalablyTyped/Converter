package com.olvind.tso
package ts
package transforms

object LibrarySpecific {
  trait Named extends TreeTransformationScopedChanges {
    val libName: TsIdentLibrary
  }

  object styledComponents extends Named {
    override val libName = TsIdentLibrarySimple("styled-components")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        /* resolve double Omit */
        case ta @ TsDeclTypeAlias(_, _, _ @TsIdent("WithOptionalTheme"), _, TsTypeIntersect(types), _) =>
          types.toList match {
            case (omit: TsTypeRef) :: rest if omit.name.parts.last.value === "Omit" =>
              ta.copy(alias = TsTypeIntersect(omit.tparams.head :: rest))
            case _ => ta
          }

        /* resolve circular set of type aliases */
        case TsDeclTypeAlias(cs, d, name @ TsIdent("InterpolationFunction"), tps, TsTypeFunction(sig), cp) =>
          val call = List(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
          TsDeclInterface(cs, d, name, tps, Nil, call, cp)
        case other => other
      }
  }

  object emotion extends Named {
    override val libName = TsIdentLibraryScoped("emotion", Some("serialize"))

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        /* resolve circular set of type aliases */
        case TsDeclTypeAlias(cs, d, name @ TsIdent("FunctionInterpolation"), tps, TsTypeFunction(sig), cp) =>
          val call = List(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
          TsDeclInterface(cs, d, name, tps, Nil, call, cp)
        case other => other
      }
  }

  object aMap extends Named {
    override val libName = TsIdentLibrarySimple("amap-js-api")

    override def enterTsDeclTypeAlias(t: TsTreeScope)(x: TsDeclTypeAlias): TsDeclTypeAlias =
      x match {
        /* avoid insane definition of `Merge` */
        case merge @ TsDeclTypeAlias(_, _, TsIdent("Merge"), tparams, _, _) =>
          merge.copy(alias = TsTypeIntersect(TsTypeParam.asTypeArgs(tparams)))
        case other => other
      }
  }

  object atUifabricFoundation extends Named {
    override val libName: TsIdentLibrary = TsIdentLibraryScoped("uifabric", Some("foundation"))

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl = x match {
      /* break circular dependency */
      case TsDeclTypeAlias(cs, d, name @ TsIdent("ITokenFunction"), tps, TsTypeFunction(sig), cp) =>
        val call = List(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
        TsDeclInterface(cs, d, name, tps, Nil, call, cp)
      case other => other
    }
  }

  object emberPolyfills extends Named {
    override val libName: TsIdentLibrary = TsIdentLibraryScoped("ember", Some("polyfills"))

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl = x match {
      /* Error: cyclic aliasing or subtyping involving type Mix */
      case ta @ TsDeclTypeAlias(_, _, name, tps, _, _) if name.value.startsWith("Mix") =>
        ta.copy(alias = TsTypeIntersect(TsTypeParam.asTypeArgs(tps)))
      case other => other
    }
  }

  object react extends Named {
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
    Seq(atUifabricFoundation, aMap, emberPolyfills, emotion, react, styledComponents).map(x => x.libName -> x).toMap

  def apply(libName: TsIdentLibrary): Option[TreeTransformationScopedChanges] = patches.get(libName)
}
