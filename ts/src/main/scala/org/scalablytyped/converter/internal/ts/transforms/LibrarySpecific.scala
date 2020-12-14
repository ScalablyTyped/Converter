package org.scalablytyped.converter.internal
package ts
package transforms

object LibrarySpecific {
  trait Named extends TreeTransformationScopedChanges {
    val libName: TsIdentLibrary
  }

  object std extends Named {
    override val libName = TsIdentLibrarySimple("std")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case i @ TsDeclInterface(_, _, TsIdentSimple("HTMLCollectionOf"), _, _, _, _) =>
          i.copy(inheritance = Empty)
        case other => other
      }
  }

  object styledComponents extends Named {
    override val libName = TsIdentLibrarySimple("styled-components")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        /* resolve double Omit */
        case ta @ TsDeclTypeAlias(_, _, _ @TsIdent("WithOptionalTheme"), _, TsTypeIntersect(types), _) =>
          types match {
            case IArray.headTail(omit: TsTypeRef, rest) if omit.name.parts.last.value === "Omit" =>
              ta.copy(alias = TsTypeIntersect(omit.tparams.head +: rest))
            case _ => ta
          }

        /* resolve circular set of type aliases */
        case TsDeclTypeAlias(cs, d, name @ TsIdent("InterpolationFunction"), tps, TsTypeFunction(sig), cp) =>
          val call = IArray(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
          TsDeclInterface(cs, d, name, tps, Empty, call, cp)
        case other => other
      }
  }

  object emotion extends Named {
    override val libName = TsIdentLibraryScoped("emotion", "serialize")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        /* resolve circular set of type aliases */
        case TsDeclTypeAlias(cs, d, name @ TsIdent("FunctionInterpolation"), tps, TsTypeFunction(sig), cp) =>
          val call = IArray(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
          TsDeclInterface(cs, d, name, tps, Empty, call, cp)
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
    override val libName: TsIdentLibrary = TsIdentLibraryScoped("uifabric", "foundation")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl = x match {
      /* break circular dependency */
      case TsDeclTypeAlias(cs, d, name @ TsIdent("ITokenFunction"), tps, TsTypeFunction(sig), cp) =>
        val call = IArray(TsMemberCall(NoComments, ProtectionLevel.Default, sig))
        TsDeclInterface(cs, d, name, tps, Empty, call, cp)
      case other => other
    }
  }

  object emberPolyfills extends Named {
    override val libName: TsIdentLibrary = TsIdentLibraryScoped("ember", "polyfills")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl = x match {
      /* Error: cyclic aliasing or subtyping involving type Mix */
      case ta @ TsDeclTypeAlias(_, _, name, tps, _, _) if name.value.startsWith("Mix") =>
        ta.copy(alias = TsTypeIntersect(TsTypeParam.asTypeArgs(tps)))
      case other => other
    }
  }

  object semanticUiReact extends Named {
    override val libName: TsIdentLibrary = TsIdentLibrarySimple("semantic-ui-react")
    val stdLib                 = TsQIdent(IArray(TsIdent.std))
    val reactMod               = TsQIdent(IArray(react.libName, TsIdentModule(None, List("react"))))
    val AllHTMLAttributes      = reactMod + TsIdent("AllHTMLAttributes")
    val InputHTMLAttributes    = reactMod + TsIdent("InputHTMLAttributes")
    val HTMLInputElement       = stdLib + TsIdent("HTMLInputElement")
    val TextareaHTMLAttributes = reactMod + TsIdent("TextareaHTMLAttributes")
    val HTMLTextareaElement    = stdLib + TsIdent("HTMLTextAreaElement")
    val FormHTMLAttributes     = reactMod + TsIdent("FormHTMLAttributes")
    val HTMLFormElement        = stdLib + TsIdent("HTMLFormElement")
    val ButtonHTMLAttributes   = reactMod + TsIdent("ButtonHTMLAttributes")
    val HTMLButtonElement      = stdLib + TsIdent("HTMLButtonElement")
    val TdHTMLAttributes       = reactMod + TsIdent("TdHTMLAttributes")
    val HTMLTableCellElement   = stdLib + TsIdent("HTMLTableCellElement")

    def event(name: TsQIdent, of: TsQIdent) =
      TsTypeRef(NoComments, name, IArray(TsTypeRef(NoComments, of, Empty)))

    val addDomProps = Map[TsIdent, TsTypeRef](
      TsIdentSimple("StrictInputProps") -> event(InputHTMLAttributes, HTMLInputElement),
      TsIdentSimple("StrictTextAreaProps") -> event(TextareaHTMLAttributes, HTMLTextareaElement),
      TsIdentSimple("StrictCheckboxProps") -> event(InputHTMLAttributes, HTMLInputElement),
      TsIdentSimple("StrictFormProps") -> event(FormHTMLAttributes, HTMLFormElement),
      TsIdentSimple("StrictButtonProps") -> event(ButtonHTMLAttributes, HTMLButtonElement),
      TsIdentSimple("StrictTableCellProps") -> event(TdHTMLAttributes, HTMLTableCellElement),
    )
    val removeIndex = Set[TsIdent](
      TsIdentSimple("InputProps"),
      TsIdentSimple("TextAreaProps"),
      TsIdentSimple("FormProps"),
      TsIdentSimple("ButtonProps"),
      TsIdentSimple("TableCellProps"),
    )

    override def enterTsParsedFile(t: TsTreeScope)(x: TsParsedFile): TsParsedFile =
      x.copy(members = x.members.filter {
        case xx: TsDeclModule => !xx.name.fragments.contains("src")
        case _ => true
      })

    override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
      x match {
        case i @ TsDeclInterface(_, _, name, _, inheritance, members, _) =>
          (addDomProps.get(name), removeIndex(name)) match {
            case (Some(newInheritance), _) =>
              i.copy(inheritance = inheritance :+ newInheritance)
            case (_, true) =>
              val newMembers = members.filter {
                case _: TsMemberIndex => false
                case _ => true
              }
              i.copy(members = newMembers)
            case _ => i
          }
      }
  }

  object react extends Named {
    val libName       = TsIdentLibrarySimple("react")
    val DOMAttributes = TsIdent("DOMAttributes")
    val ReactElement  = TsIdent("ReactElement")
    val ReactFragment = TsIdent("ReactFragment")
    val ReactNode     = TsIdent("ReactNode")
    val CSSProperties = TsIdent("CSSProperties")
    val Readonly      = TsQIdent(IArray(TsIdent("Readonly")))

    //Somewhere in here we need to take a look at the component, and if it has an "as" member with a known mapping and we don't have
    //an inheritance tree already, we should add that.

    override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
      x.name match {
        case CSSProperties =>
          /* restore compatibility with old CSSProperties syntax, that it it's own syntax and you don't have to provide type parameters */
          val hack = TsMemberProperty(
            Comments(Comment("/* fake member to keep old syntax */\n")),
            ProtectionLevel.Default,
            TsIdentSimple("hack"),
            Some(TsTypeUnion(IArray(TsTypeRef.any, TsTypeRef.undefined))),
            None,
            false,
            true,
          )
          x.copy(members = x.members :+ hack)

        /* drop useless type parameters */
        case ReactElement =>
          val newX = x.copy(tparams = Empty)
          new TypeRewriter(newX)
            .visitTsDeclInterface(TsTypeParam.asTypeArgs(x.tparams).map(_ -> TsTypeRef.any).toMap)(newX)

        /**
          * hack: react exposes just too many props for intrinsics (`div`, `a`, etc) to cross the 254
          * parameter limit for *many* components. I've personally never needed the `*Capture` props,
          * and they are easy to filter out en masse.
          */
        case DOMAttributes =>
          val newMembers = x.members.filter {
            case x: TsMemberFunction => !x.name.value.endsWith("Capture")
            case x: TsMemberProperty => !x.name.value.endsWith("Capture")
            case _ => true
          }
          x.copy(members = newMembers)
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
    IArray(atUifabricFoundation, aMap, emberPolyfills, emotion, react, semanticUiReact, std, styledComponents)
      .map(x => x.libName -> x)
      .toMap

  def apply(libName: TsIdentLibrary): Option[TreeTransformationScopedChanges] = patches.get(libName)
}
