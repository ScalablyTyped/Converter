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
        case other => other
      }
  }

  object chakraUiSystem extends Named {
    override val libName = TsIdentLibraryScoped("chakra-ui", "system")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case ta @ TsDeclTypeAlias(_, _, TsIdentSimple("ComponentWithAs"), _, TsTypeObject(_, members), _) =>
          val maybeRewritten: Option[TsTypeRef] =
            members.collectFirst {
              case TsMemberCall(
                  _,
                  _,
                  TsFunSig(
                    _,
                    IArray.exactlyOne(TsTypeParam(_, _, Some(bound), _)),
                    IArray.exactlyOne(TsFunParam(_, _, Some(argTpe: TsTypeRef))),
                    _,
                  ),
                  ) if argTpe.tparams.length == 4 =>
                val newTparams = IArray(
                  argTpe.tparams(0),
                  TsTypeRef.`object`,
                  argTpe.tparams(2),
                  bound,
                )
                val props    = argTpe.copy(tparams = newTparams)
                val reactMod = TsQIdent(IArray(react.libName, TsIdentModule(None, List("react"))))
                TsTypeRef(NoComments, reactMod + TsIdent("FC"), IArray(props))
            }
          maybeRewritten match {
            case Some(fc) => ta.copy(alias = fc)
            case None     => x
          }
        case other => other
      }
  }

  object muiMaterial extends Named {
    override val libName = TsIdentLibraryScoped("mui", "material")
    val OverridableComponentMod =
      TsQIdent(IArray(libName, TsIdentModule(Some("mui"), List("material", "OverridableComponent"))))
    val DefaultComponentProps = OverridableComponentMod + TsIdentSimple("DefaultComponentProps")

    override def enterTsType(t: TsTreeScope)(x: TsType): TsType =
      x match {
        case TsTypeRef(
            _,
            TsQIdent(IArray.last(TsIdentSimple("OverridableStringUnion"))),
            IArray.exactlyTwo(t, _),
            ) =>
          t
        case other => other
      }

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        // normal case. components can have their underlying intrinsic changed by specifying `as` prop.
        // we remove that possibility and rewrite this to something simpler.
        case int @ TsDeclInterface(_, _, TsIdentSimple("OverridableComponent"), _, _, members, _) =>
          val maybeRewritten: Option[TsDeclTypeAlias] =
            members.collectFirst {
              case TsMemberCall(_, _, TsFunSig(_, Empty, IArray.exactlyOne(TsFunParam(_, _, Some(propsType))), _)) =>
                val componentProp = {
                  val c = Comments(
                    Comment(
                      "/* you can set this property to change the underlying component. " +
                        "keep in mind that the types of callbacks may be different */\n",
                    ),
                  )
                  val tpe = TsTypeUnion(IArray(TsTypeRef.string, TsTypeRef.undefined))
                  TsMemberProperty(c, TsProtectionLevel.Default, TsIdent("component"), Some(tpe), None, false, true)
                }
                val addComponentProp =
                  TsTypeIntersect(IArray(propsType, TsTypeObject(NoComments, IArray(componentProp))))

                val fc = TsTypeFunction(
                  TsFunSig(
                    NoComments,
                    Empty,
                    IArray(TsFunParam(NoComments, TsIdent("props"), Some(addComponentProp))),
                    Some(TsTypeRef(react.Element)),
                  ),
                )
                TsDeclTypeAlias(int.comments, int.declared, int.name, int.tparams, fc, int.codePath)
            }

          maybeRewritten.getOrElse(x)

        // these traits allow a `href` prop to change all the callback prop types. so we keep that and output components with union props
        case ta @ TsDeclTypeAlias(
              _,
              _,
              TsIdentSimple("ExtendButtonBase" | "ExtendButton"),
              _,
              alias: TsTypeIntersect,
              _,
            ) =>
          val propsTypes = alias.types.map {
            case TsTypeFunction(TsFunSig(_, _, IArray.exactlyOne(TsFunParam(_, _, Some(propsType))), _)) =>
              propsType
            case TsTypeRef(_, _, IArray.exactlyOne(propsType)) =>
              TsTypeRef(NoComments, DefaultComponentProps, IArray(propsType))
            case other =>
              sys.error(s"unexpected $other")
          }
          ta.copy(alias = TsTypeRef(NoComments, react.ExoticComponent, IArray(TsTypeUnion(propsTypes))))
        case ta @ TsDeclTypeAlias(_, _, TsIdentSimple("IfEquals"), IArray.exactlyFour(_, _, yes, _), _, _) =>
          ta.copy(alias = TsTypeRef(yes.name))
        case x @ TsDeclTypeAlias(_, _, TsIdentSimple("ComponentsProps"), _, _, _)    => x.copy(alias   = TsTypeRef.number)
        case x @ TsDeclTypeAlias(_, _, TsIdentSimple("ComponentsVariants"), _, _, _) => x.copy(alias   = TsTypeRef.number)
        case x @ TsDeclInterface(_, _, TsIdentSimple("Components"), _, _, _, _)      => x.copy(members = Empty)

        case other => other
      }
  }

  object muiSystem extends Named {
    override val libName = TsIdentLibraryScoped("mui", "system")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case ta @ TsDeclTypeAlias(_, _, TsIdentSimple("SimpleSystemKeys"), _, _, _) =>
          ta.copy(alias = TsTypeUnion(
            IArray(
              "border",
              "borderTop",
              "borderRight",
              "borderBottom",
              "borderLeft",
              "borderColor",
              "borderRadius",
              "display",
              "displayPrint",
              "overflow",
              "textOverflow",
              "visibility",
              "whiteSpace'",
              "flexBasis",
              "flexDirection",
              "flexWrap",
              "justifyContent",
              "alignItems",
              "alignContent",
              "order",
              "flex",
              "flexGrow",
              "flexShrink",
              "alignSelf",
              "justifyItems",
              "justifySelf",
              "gap",
              "columnGap",
              "rowGap",
              "gridColumn",
              "gridRow",
              "gridAutoFlow",
              "gridAutoColumns",
              "gridAutoRows",
              "gridTemplateColumns",
              "gridTemplateRows",
              "gridTemplateAreas",
              "gridArea",
              "bgcolor",
              "color",
              "zIndex",
              "position",
              "top",
              "right",
              "bottom",
              "left",
              "boxShadow",
              "width",
              "maxWidth",
              "minWidth",
              "height",
              "maxHeight",
              "minHeight",
              "sizeWidth",
              "sizeHeight",
              "boxSizing",
              "m",
              "mt",
              "mr",
              "mb",
              "ml",
              "mx",
              "my",
              "p",
              "pt",
              "pr",
              "pb",
              "pl",
              "px",
              "py",
              "margin",
              "marginTop",
              "marginRight",
              "marginBottom",
              "marginLeft",
              "marginX",
              "marginY",
              "padding",
              "paddingTop",
              "paddingRight",
              "paddingBottom",
              "paddingLeft",
              "paddingX",
              "paddingY",
              "typography",
              "fontFamily",
              "fontSize",
              "fontStyle",
              "fontWeight",
              "letterSpacing",
              "lineHeight",
              "textAlign",
            ).map(str => TsTypeLiteral(TsLiteral.Str(str))),
          ),
          )
        case other => other
      }
  }

  object muiTypes extends Named {
    override val libName = TsIdentLibraryScoped("mui", "types")

    override def enterTsDecl(t: TsTreeScope)(x: TsDecl): TsDecl =
      x match {
        case ta @ TsDeclTypeAlias(_, _, TsIdentSimple("IfEquals"), IArray.exactlyFour(_, _, yes, _), _, _) =>
          ta.copy(alias = TsTypeRef(yes.name))
        case x @ TsDeclTypeAlias(_, _, TsIdentSimple("OverridableStringUnion"), IArray.exactlyTwo(one, _), _, _) =>
          x.copy(alias = TsTypeRef(one.name))

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

  object semanticUiReact extends Named {
    override val libName: TsIdentLibrary = TsIdentLibrarySimple("semantic-ui-react")
    val stdLib                 = TsQIdent(IArray(TsIdent.std))
    val AllHTMLAttributes      = react.mod + TsIdent("AllHTMLAttributes")
    val InputHTMLAttributes    = react.mod + TsIdent("InputHTMLAttributes")
    val HTMLInputElement       = stdLib + TsIdent("HTMLInputElement")
    val TextareaHTMLAttributes = react.mod + TsIdent("TextareaHTMLAttributes")
    val HTMLTextareaElement    = stdLib + TsIdent("HTMLTextAreaElement")
    val FormHTMLAttributes     = react.mod + TsIdent("FormHTMLAttributes")
    val HTMLFormElement        = stdLib + TsIdent("HTMLFormElement")
    val ButtonHTMLAttributes   = react.mod + TsIdent("ButtonHTMLAttributes")
    val HTMLButtonElement      = stdLib + TsIdent("HTMLButtonElement")
    val TdHTMLAttributes       = react.mod + TsIdent("TdHTMLAttributes")
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
    val libName = TsIdentLibrarySimple("react")

    // only use unprefixed names for the react library itself
    private val DOMAttributes         = TsIdent("DOMAttributes")
    private val JSXElementConstructor = TsIdent("JSXElementConstructor")
    private val ReactElement          = TsIdent("ReactElement")
    private val ReactFragment         = TsIdent("ReactFragment")
    private val ReactNode             = TsIdent("ReactNode")
    private val CSSProperties         = TsIdent("CSSProperties")

    val mod             = TsQIdent(IArray(react.libName, TsIdentModule(None, List("react"))))
    val Element         = mod + TsIdent.Global + TsIdent("JSX") + TsIdent("Element")
    val ExoticComponent = mod + TsIdent("ExoticComponent")

    //Somewhere in here we need to take a look at the component, and if it has an "as" member with a known mapping and we don't have
    //an inheritance tree already, we should add that.

    override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
      x.name match {
        case CSSProperties =>
          /* restore compatibility with old CSSProperties syntax, that it it's own syntax and you don't have to provide type parameters */
          val hack = TsMemberProperty(
            Comments(Comment("/* fake member to keep old syntax */\n")),
            TsProtectionLevel.Default,
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

        /* drop one of two types in a union type to help out the react flavours when encountering this */
        case JSXElementConstructor =>
          x.alias match {
            case TsTypeUnion(types) =>
              types.collectFirst { case x: TsTypeFunction => x } match {
                case Some(f) => x.copy(alias = f)
                case None    => x
              }
            case _ => x
          }

        case _ => x
      }
  }

  val patches: Map[TsIdentLibrary, Named] =
    IArray(
      aMap,
      chakraUiSystem,
      muiMaterial,
      muiSystem,
      muiTypes,
      react,
      semanticUiReact,
      std,
      styledComponents,
    ).map(x => x.libName -> x).toMap

  def apply(libName: TsIdentLibrary): Option[TreeTransformationScopedChanges] = patches.get(libName)
}
