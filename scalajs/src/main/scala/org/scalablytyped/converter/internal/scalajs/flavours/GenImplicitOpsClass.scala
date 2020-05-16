package org.scalablytyped.converter.internal
package scalajs
package flavours

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
      selfTParam +: original.tparams
    }
    val selfRef = TypeRef(QualifiedName(IArray(SelfName)), asTypeArgs(original.tparams), NoComments)

    val combineWithMember =
      genCombineWith(Name("combineWith"), mutableAllocateTypeName(Name("Other")), target, clsCodePath, selfRef)

    val duplicateMember =
      genDuplicateMember(Name("duplicate"), target, clsCodePath, selfRef)

    /* ignore inherited props, there will already be implicit sugar for those */
    val applicableMembers = props.yes.filter(_.isInherited === false)

    val sugarMembers: IArray[MethodTree] =
      applicableMembers.flatMap {
        case Prop(main @ Prop.Variant(ParamTree(propName, _, _, _, _, _), _, _), _, variants, _) =>
          val variantsForProp: Map[Name, Prop.VariantLike] = {
            def nameFor(tpe: TypeRef): String =
              tpe match {
                case tr if Name.Internal(tr.name) => tr.targs.map(nameFor).mkString("")
                case other                        => other.name.unescaped
              }

            val (renamedUndefined, definedAlternatives, _) = variants.partitionCollect2(
              { case Prop.Undefined => Name(s"without${propName.unescaped.capitalize}") -> Prop.Undefined },
              { case v: Prop.Variant if v.isRewritten => v },
            )

            val renamedDefined: Map[Name, Prop.Variant] =
              definedAlternatives.groupBy(param => nameFor(param.tree.tpe)).map {
                case (alternativeName, IArray.first(one)) =>
                  Name(s"with${propName.unescaped.capitalize}${alternativeName.capitalize}") -> one
              }

            val withMain = renamedDefined.updated(Name(s"with${propName.unescaped.capitalize}"), main)
            withMain ++ renamedUndefined.toMap
          }

          val ret = if (propName.value === "ret") Name("ret_") else Name("ret")

          val iterable = variantsForProp map {
            case (name, Prop.Undefined) =>
              val impl = {
                import ExprTree._
                Block(
                  Val(ret, Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name)))),
                  Call(Ref(QualifiedName.specialDelete), IArray(IArray(Ref(ret), StringLit(propName.unescaped)))),
                  Cast(Ref(ret), selfRef),
                )
              }
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
              )

            case (name, Prop.Variant(_param, asExpr, _)) =>
              val param = _param.copy(default = NotImplemented)

              val impl = {
                import ExprTree._
                asExpr match {
                  case Left(Arg.Named(name, expr)) =>
                    Block(
                      Val(ret, Cast(Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name))), TypeRef.Dynamic)),
                      Call(
                        Select(Ref(ret), Name("updateDynamic")),
                        IArray(
                          IArray(StringLit(name.unescaped)),
                          IArray(expr),
                        ),
                      ),
                      Cast(Ref(ret), selfRef),
                    )
                  case Right(mutateObject) =>
                    Block(
                      Val(ret, Cast(Ref(QualifiedName(IArray(Name.THIS, duplicateMember.name))), TypeRef.Dynamic)),
                      mutateObject(ret),
                      Cast(Ref(ret), selfRef),
                    )
                }
              }
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Default,
                name        = name,
                tparams     = Empty,
                params      = IArray(IArray(param)),
                impl        = impl,
                resultType  = selfRef,
                isOverride  = false,
                comments    = NoComments,
                codePath    = clsCodePath + name,
              )
          }

          IArray.fromTraversable(iterable)
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
