package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res

import scala.collection.mutable

class AvailableName(private val usedNames: mutable.Set[Name]) {
  def apply(wanted: Name): Name =
    usedNames(wanted) match {
      case true => apply(Name(wanted.unescaped + "_"))
      case false =>
        usedNames += wanted
        wanted
    }
}

object AvailableName {
  def apply(usedNames: IArray[Name]): AvailableName = {
    val m = mutable.HashSet.empty[Name]
    usedNames.foreach(m += _)
    new AvailableName(m)
  }
}

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
final class GenCompanions(memberToProp: MemberToProp, findProps: FindProps) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.exists { case mod: ModuleTree => mod.isNative; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Empty) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case cls: ClassTree if !nameConflict(cls.name) =>
          val clsRef = TypeRef(cls.codePath, asTypeArgs(cls.tparams), NoComments)

          findProps.forClassTree(
            cls                = cls,
            scope              = scope / cls,
            memberToProp       = memberToProp,
            maxNum             = FindProps.MaxParamsForMethod,
            acceptNativeTraits = false,
            keep               = FindProps.keepAll,
            selfRef            = clsRef,
          ) match {
            case Res.Error(_) =>
              IArray(cls)

            case Res.One(_, props) =>
              val modOpt: Option[ModuleTree] =
                generateCreator(Name.APPLY, props.yes, cls.codePath, cls.tparams)
                  .map { method =>
                    ModuleTree(Empty, cls.name, Empty, IArray(method), NoComments, cls.codePath, isOverride = false)
                  }
                  .filter(ensureNotTooManyStrings(scope))

              IArray.fromOptions(Some(cls), modOpt)

            case Res.Many(paramsMap) =>
              val methods: IArray[MethodTree] =
                IArray.fromTraversable(paramsMap.flatMap {
                  case (propsRef, params) => generateCreator(propsRef.name, params.yes, cls.codePath, cls.tparams)
                })

              val modOpt: Option[ModuleTree] =
                Some(ModuleTree(Empty, cls.name, Empty, methods, NoComments, cls.codePath, isOverride = false))
                  .filter(ensureNotTooManyStrings(scope))

              IArray.fromOptions(Some(cls), modOpt)
          }

        case other => IArray(other)
      })
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(scope: TreeScope)(mod: Tree): Boolean = {
    val MaxWeight = 32768 // an estimate. If you see the error again, decrease this

    object Dealias extends TreeTransformation {
      override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = FollowAliases(scope)(s)

      // ignore implementations
      override def leaveExprTree(scope:    TreeScope)(s: ExprTree):     ExprTree     = ExprTree.Null
      override def leaveExprRefTree(scope: TreeScope)(s: ExprTree.Ref): ExprTree.Ref = ExprTree.native
    }

    var stringLength = 0

    TreeTraverse.foreach(Dealias.visitTree(scope)(mod)) {
      case name: QualifiedName =>
        name.parts.foreach(p => stringLength += p.unescaped.length)
      case _ => ()
    }

    stringLength < MaxWeight
  }

  def generateCreator(
      name:        Name,
      props:       IArray[Prop],
      typeCp:      QualifiedName,
      typeTparams: IArray[TypeParamTree],
  ): Option[MethodTree] =
    props match {
      case Empty => None
      case props =>
        val (optionals, inLiterals, Empty) = props.partitionCollect2(
          { case Prop(Prop.Variant(_, Right(f)), _, _)  => f },
          { case Prop(Prop.Variant(_, Left(str)), _, _) => str },
        )
        val typeName = typeCp.parts.last

        val ret = TypeRef(QualifiedName(IArray(typeName)), asTypeArgs(typeTparams), NoComments)

        val impl: ExprTree = {
          import ExprTree._
          val objName = Name("__obj")
          Block.flatten(
            IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(inLiterals)))),
            optionals.map(f => f(objName)),
            IArray(Cast(Ref(QualifiedName(IArray(objName))), ret)),
          )
        }
        Some(
          MethodTree(
            IArray(Annotation.Inline),
            ProtectionLevel.Default,
            name,
            typeTparams,
            IArray(props.map(_.main.tree)),
            impl,
            ret,
            isOverride = false,
            NoComments,
            typeCp + name,
          ),
        )
    }
}
