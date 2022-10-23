package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs
import ExprTree._

import scala.collection.mutable

object GenBuilderClass {
  def apply(original: ClassTree, props: IArray[Prop], ownerCp: QualifiedName): Option[ClassTree] = {
    val x           = Name("x")
    val clsName     = Name("MutableBuilder")
    val clsCodePath = ownerCp + clsName
    val value       = Name("value")

    /* we need to add a few type parameter names into an unknown set, so this avoids collisions */
    val mutableAllocateTypeName = AvailableName(original.tparams.map(_.name), IArray(original.name))

    /**
      * We generate a Self type like this:
      * ```implicit class DOMAttributesOps[Self[t] &lt;: DOMAttributes[t], T] (val x: Self[T])```
      * because subclasses can use * the methods defined here without losing the type of the subclass
      */
    val SelfName = mutableAllocateTypeName(Name("Self"))
    val selfRef  = TypeRef(QualifiedName(IArray(SelfName)), Empty, NoComments)

    val tparams = {
      val selfTParam = TypeParamTree(
        name        = SelfName,
        params      = Empty,
        upperBound  = Some(TypeRef(original.codePath, original.tparams.map(_ => TypeRef.Wildcard), NoComments)),
        comments    = NoComments,
        ignoreBound = false,
      )

      selfTParam +: original.tparams
    }

    val globalSet = Select(Ref(QualifiedName.StObject), Name("set"))

    val sugarMembers: IArray[MethodTree] =
      props.flatMap {
        /* ignore inherited props, there will already be implicit sugar for those */
        case prop: Prop.Normal if prop.isInherited === false =>
          val variantsForProp: Map[Name, Prop.Variant] = {

            val fromVariants: Map[Name, Prop.Variant] =
              prop.variants.filter(_.isRewritten).groupBy(param => nameFor(param.tpe)).map {
                case (alternativeName, IArray.first(one)) =>
                  Name(s"set${prop.name.unescaped.capitalize}${alternativeName.capitalize}") -> one
              }

            fromVariants.updated(Name(s"set${prop.name.unescaped.capitalize}"), prop.main)
          }

          val variantsMethods: IArray[MethodTree] = variantsForProp.mapToIArray {
            case (methodName, Prop.Variant(tpe, asExpr, _, _)) =>
              val impl = Call(
                globalSet,
                IArray(IArray(Ref(x), StringLit(prop.originalName.unescaped), asExpr(Ref(value)))),
              )
              val valueParam = ParamTree(value, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Public,
                name        = methodName,
                tparams     = Empty,
                params      = IArray(IArray(valueParam)),
                impl        = impl,
                resultType  = selfRef,
                isOverride  = false,
                comments    = NoComments,
                codePath    = clsCodePath + methodName,
                isImplicit  = false,
              )
          }

          val undefinedCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Undef | Optionality.NullOrUndef =>
              val impl = Call(
                globalSet,
                IArray(IArray(Ref(x), StringLit(prop.originalName.unescaped), undefined)),
              )
              val name = Name(s"set${prop.name.unescaped.capitalize}Undefined")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Public,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = selfRef,
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                  isImplicit  = false,
                ),
              )

            case _ => None
          }

          val nullCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Null | Optionality.NullOrUndef =>
              val impl = Call(
                globalSet,
                IArray(IArray(Ref(x), StringLit(prop.originalName.unescaped), Null)),
              )
              val name = Name(s"set${prop.name.unescaped.capitalize}Null")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Public,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = selfRef,
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                  isImplicit  = false,
                ),
              )

            case _ => None
          }

          variantsMethods ++ IArray.fromOptions(undefinedCaseOpt, nullCaseOpt)
        case _ => Empty
      }

    val sugarCtor = {
      // append an intersection type to bind otherwise free type parameters to `Self`
      val paramType = original.tparams match {
        case Empty => selfRef
        case _ =>
          TypeRef.Intersection(IArray(selfRef, TypeRef(ownerCp, asTypeArgs(original.tparams), NoComments)), NoComments)
      }

      CtorTree(
        ProtectionLevel.Public,
        IArray(
          ParamTree(
            x,
            isImplicit = false,
            isVal      = true,
            tpe        = paramType,
            default    = NotImplemented,
            comments   = NoComments,
          ),
        ),
        NoComments,
      )
    }

    // throw away setters for two fields with same name but different casing,
    val allMembers = sugarMembers.distinctBy(_.name.unescaped.toLowerCase)
    if (allMembers.nonEmpty)
      Some(
        ClassTree(
          isImplicit  = true,
          annotations = IArray(Annotation.Inline),
          level       = ProtectionLevel.Public,
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

  object AvailableName {
    def apply(usedNamess: IArray[Name]*): AvailableName = {
      val m = mutable.HashSet.empty[Name]
      usedNamess.foreach(usedNames => usedNames.foreach(m += _))
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
