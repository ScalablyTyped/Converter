package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs

import scala.collection.mutable

object GenImplicitOpsClass {
  def apply(
      original: ClassTree,
      props:    FindProps.Filtered[Unit],
      ownerCp:  QualifiedName,
      scope:    TreeScope,
  ): Option[ClassTree] = {
    val target      = Name("x")
    val clsName     = Name(s"${original.name.unescaped}Ops")
    val clsCodePath = ownerCp + clsName

    /* we need to add a few type parameter names into an unknown set, so this avoids collisions */
    val mutableAllocateTypeName = AvailableName(original.tparams.map(_.name))

    /**
      * We generate a Self type like this:
      * ```implicit class DOMAttributesOps[Self[t] &lt;: DOMAttributes[t], T] (val x: Self[T])```
      * because subclasses can use * the methods defined here without losing the type of the subclass
      */
    val SelfName = mutableAllocateTypeName(Name("Self"))
    val tparams = {
      val higherKindedParams =
        original.tparams.map(tp => tp.copy(name = mutableAllocateTypeName(Name(tp.name.unescaped.toLowerCase))))

      val selfTParam = TypeParamTree(
        name       = SelfName,
        params     = higherKindedParams,
        upperBound = Some(TypeRef(original.codePath, asTypeArgs(higherKindedParams), NoComments)),
        comments   = NoComments,
      )

      /* We have a hack in the printer which comments out bounds for javascript types.
       * Here we generate a scala class, so just imitate same behaviour
       */
      val withoutBounds = original.tparams.map(_.copy(upperBound = None))
      selfTParam +: withoutBounds
    }

    val selfRef = TypeRef(QualifiedName(IArray(SelfName)), asTypeArgs(original.tparams), NoComments)

    val combineWithMember =
      genCombineWith(Name("combineWith"), mutableAllocateTypeName(Name("Other")), target, clsCodePath, selfRef)

    val duplicateMember =
      genDuplicateMember(Name("duplicate"), target, clsCodePath, selfRef)

    val sugarMembers: IArray[MethodTree] =
      props.yes.flatMap {
        /* ignore inherited props, there will already be implicit sugar for those */
        case prop: Prop.Normal if prop.isInherited === false =>
          val variantsForProp: Map[Name, Prop.Variant] = {

            val fromVariants: Map[Name, Prop.Variant] =
              prop.variants.filter(_.isRewritten).groupBy(param => nameFor(param.tpe)).map {
                case (alternativeName, IArray.first(one)) =>
                  Name(s"with${prop.name.unescaped.capitalize}${alternativeName.capitalize}") -> one
              }

            fromVariants.updated(Name(s"with${prop.name.unescaped.capitalize}"), prop.main)
          }

          val paramName = Name("value")
          val ret       = Name("ret")

          val variantsMethods: IArray[MethodTree] = variantsForProp.mapToIArray {
            case (methodName, Prop.Variant(tpe, asExpr, _, _)) =>
              val impl = {
                import ExprTree._
                Block(
                  Val(ret, Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name)))),
                  Call(
                    Select(Cast(Ref(ret), TypeRef.Dynamic), Name("updateDynamic")),
                    IArray(
                      IArray(StringLit(prop.originalName.unescaped)),
                      IArray(asExpr(Ref(paramName))),
                    ),
                  ),
                  Ref(ret),
                )
              }
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Default,
                name        = methodName,
                tparams     = Empty,
                params = IArray(
                  IArray(ParamTree(paramName, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)),
                ),
                impl       = impl,
                resultType = selfRef,
                isOverride = false,
                comments   = NoComments,
                codePath   = clsCodePath + methodName,
              )
          }

          val undefinedCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Undef | Optionality.NullOrUndef =>
              val impl = {
                import ExprTree._
                Block(
                  Val(ret, Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name)))),
                  Call(
                    Select(Cast(Ref(ret), TypeRef.Dynamic), Name("updateDynamic")),
                    IArray(IArray(StringLit(prop.originalName.unescaped)), IArray(undefined)),
                  ),
                  Ref(ret),
                )
              }
              val name = Name(s"without${prop.name.unescaped.capitalize}")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Default,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = selfRef,
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                ),
              )

            case _ => None
          }

          val nullCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Null | Optionality.NullOrUndef =>
              val impl = {
                import ExprTree._
                Block(
                  Val(ret, Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name)))),
                  Call(
                    Select(Cast(Ref(ret), TypeRef.Dynamic), Name("updateDynamic")),
                    IArray(IArray(StringLit(prop.originalName.unescaped)), IArray(Null)),
                  ),
                  Ref(ret),
                )
              }
              val name = Name(s"with${prop.name.unescaped.capitalize}Null")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Default,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = selfRef,
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                ),
              )

            case _ => None
          }

          variantsMethods ++ IArray.fromOptions(undefinedCaseOpt, nullCaseOpt)
        case _ => Empty
      }

    val sugarCtor = CtorTree(
      ProtectionLevel.Default,
      IArray(ParamTree(target, isImplicit = false, isVal = true, selfRef, NotImplemented, NoComments)),
      NoComments,
    )

    val generalMembers = IArray(duplicateMember, combineWithMember)

    // throw away setters for two fields with same name but different casing,
    val allMembers = generalMembers ++ sugarMembers.distinctBy(_.name.unescaped.toLowerCase)
    if (sugarMembers.nonEmpty)
      Some(
        ClassTree(
          isImplicit  = true,
          annotations = IArray(Annotation.Inline),
          name        = clsName,
          tparams     = tparams,
          parents     = IArray(TypeRef.AnyVal),
          ctors       = IArray(sugarCtor),
          members     = allMembers,
          classType   = ClassType.Class,
          isSealed    = false,
          comments    = NoComments,
          codePath    = clsCodePath,
        ),
      )
    else None
  }

  def nameFor(tpe: TypeRef): String =
    tpe match {
      case tr if Name.Internal(tr.name) => tr.targs.map(nameFor).mkString("")
      case other                        => other.name.unescaped
    }

  def genDuplicateMember(duplicateName: Name, target: Name, ownerCp: QualifiedName, clsRef: TypeRef): MethodTree = {

    val impl = {
      import ExprTree._
      Cast(
        Call(
          Ref(QualifiedName.DynamicGlobalObjectAssign),
          IArray(
            IArray(
              Call(Ref(QualifiedName.DynamicLiteral), IArray(IArray())),
              Ref(target),
            ),
          ),
        ),
        clsRef,
      )
    }

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Default,
      name        = duplicateName,
      tparams     = Empty,
      params      = Empty,
      impl        = impl,
      resultType  = clsRef,
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + duplicateName,
    )

  }

  def genCombineWith(
      combineName:   Name,
      otherTypeName: Name,
      target:        Name,
      ownerCp:       QualifiedName,
      clsRef:        TypeRef,
  ): MethodTree = {
    val otherType = TypeRef(otherTypeName)
    val otherName = Name("other")
    val impl = {
      import ExprTree._
      Cast(
        Call(
          Ref(QualifiedName.DynamicGlobalObjectAssign),
          IArray(
            IArray(
              Call(Ref(QualifiedName.DynamicLiteral), IArray(IArray())),
              Ref(target),
              Cast(Ref(otherName), TypeRef.Any),
            ),
          ),
        ),
        TypeRef.Intersection(IArray(clsRef, otherType), NoComments),
      )
    }

    val otherParam = IArray(
      IArray(ParamTree(otherName, isImplicit = false, isVal = false, otherType, NotImplemented, NoComments)),
    )

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Default,
      name        = combineName,
      tparams     = IArray(TypeParamTree(otherTypeName, Empty, Some(TypeRef.Any), NoComments)),
      params      = otherParam,
      impl        = impl,
      resultType  = TypeRef.Intersection(IArray(clsRef, otherType), NoComments),
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + combineName,
    )
  }

  object AvailableName {
    def apply(usedNames: IArray[Name]): AvailableName = {
      val m = mutable.HashSet.empty[Name]
      usedNames.foreach(m += _)
      new AvailableName(m)
    }
  }

  class AvailableName(private val usedNames: mutable.Set[Name]) {
    def apply(wanted: Name): Name =
      if (usedNames(wanted)) {
        apply(Name(wanted.unescaped + "_"))
      } else {
        usedNames += wanted
        wanted
      }
  }
}
