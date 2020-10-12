package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.transforms.Sorter

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
final class GenCompanions(findProps: FindProps, enableLongApplyMethod: Boolean) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    genCompanions(scope, container) match {
      case Empty => container
      case newCompanions =>
        val asMap: Map[QualifiedName, ModuleTree] =
          newCompanions.map(mod => mod.codePath -> mod).toMap

        val merged: IArray[Tree] = merge(container, asMap)

        val sorted = Sorter.sorted(merged)
        container.withMembers(sorted)
    }

  def genCompanions(scope: TreeScope, container: ContainerTree): IArray[ModuleTree] =
    container.members.mapNotNone {
      case cls: ClassTree =>
        val clsRef = TypeRef(cls.codePath, asTypeArgs(cls.tparams), NoComments)

        val generatedImplicitOps: Option[ClassTree] =
          if (enableLongApplyMethod) None
          else {
            findProps.forClassTree(
              cls                = cls,
              scope              = scope / cls,
              maxNum             = Int.MaxValue,
              acceptNativeTraits = false,
              selfRef            = clsRef,
            ) match {
              case Res.One(_, props) if props.nonEmpty => GenImplicitOpsClass(cls, props, cls.codePath, scope)
              case _                                   => None
            }
          }

        val generatedCreators: IArray[Tree] =
          findProps.forClassTree(
            cls                = cls,
            scope              = scope / cls,
            maxNum             = FindProps.MaxParamsForMethod,
            acceptNativeTraits = false,
            selfRef            = clsRef,
          ) match {
            case Res.Error(_) =>
              Empty

            case Res.One(_, props) if props.isEmpty => Empty
            case Res.One(_, props) =>
              val requiredProps =
                if (enableLongApplyMethod) props
                else props.filter(_.optionality === Optionality.No)

              IArray.fromOptions(
                Some(generateCreator(Name.APPLY, requiredProps, cls.codePath, cls.tparams))
                  .filter(_.params.nonEmpty)
                  .filter(ensureNotTooManyStrings(scope)),
              )

            case Res.Many(propsMap) =>
              propsMap.toIArray.mapNotNone {
                case (_, props) if props.isEmpty => None
                case (propsRef, props) =>
                  val requiredProps =
                    if (enableLongApplyMethod) props
                    else props.filter(_.optionality === Optionality.No)

                  Some(generateCreator(propsRef.name, requiredProps, cls.codePath, cls.tparams))
                    .filter(_.params.nonEmpty)
                    .filter(ensureNotTooManyStrings(scope))
              }
          }

        generatedCreators ++ IArray.fromOption(generatedImplicitOps) match {
          case Empty => None
          case some =>
            val related      = Minimization.Related(some.collect { case m: HasCodePath => TypeRef(m.codePath) })
            val dontMinimize = Comments(CommentData(related))
            val mod          = ModuleTree(Empty, cls.name, Empty, some, dontMinimize, cls.codePath, isOverride = false)
            Some(mod)
        }

      case _ => None
    }

  def merge(container: ContainerTree, newCompanions: Map[QualifiedName, ModuleTree]): IArray[Tree] =
    container.index.flatMapToIArray {
      case (_, sameName) =>
        sameName.partitionCollect4(
          { case x: ClassTree  => x },
          { case x: ModuleTree => x },
          { case x: FieldTree  => x },
          { case x: MethodTree => x },
        ) match {
          case (IArray.exactlyOne(cls), modules, fields, methods, rest) =>
            newCompanions.get(cls.codePath) match {
              case Some(newCompanion) =>
                (modules, fields, methods) match {
                  case (Empty, Empty, Empty) =>
                    IArray(cls, newCompanion) ++ rest
                  case (IArray.exactlyOne(existingCompanion), Empty, Empty) =>
                    val mergedCompanion = existingCompanion.copy(
                      members  = existingCompanion.members ++ newCompanion.members,
                      comments = existingCompanion.comments ++ newCompanion.comments,
                    )

                    IArray(cls, mergedCompanion) ++ rest
                  case (Empty, IArray.exactlyOne(existingField), Empty) =>
                    val asHat = {
                      existingField.copy(name = Name.namespaced, codePath = newCompanion.codePath + Name.namespaced)
                    }
                    val mergedCompanion = newCompanion.copy(members = newCompanion.members :+ asHat)

                    IArray(cls, mergedCompanion) ++ rest
                  case (Empty, Empty, methods) if methods.nonEmpty =>
                    val asApply =
                      methods.map(m => m.copy(name = Name.APPLY, codePath = newCompanion.codePath + Name.APPLY))
                    val mergedCompanion = newCompanion.copy(members = newCompanion.members ++ asApply)

                    IArray(cls, mergedCompanion) ++ rest

                }
              case None => sameName
            }
          case _ => sameName
        }
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(scope: TreeScope)(mod: MethodTree): Boolean = {
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
  ): MethodTree = {
    val interpretedProps = props.map(defaultInterpretation.apply)

    val (mutators, initializers, Empty) = interpretedProps.partitionCollect2(
      { case (x: Mutator, _)     => x },
      { case (x: Initializer, _) => x },
    )
    val typeName = typeCp.parts.last

    val ret = TypeRef(QualifiedName(IArray(typeName)), asTypeArgs(typeTparams), NoComments)

    val impl: ExprTree = {
      val objName = Name("__obj")
      Block.flatten(
        IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(initializers.map(_.value))))),
        mutators.map(f => f.value(Ref(objName))),
        IArray(Cast(Ref(QualifiedName(IArray(objName))), ret)),
      )
    }

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Default,
      name        = name,
      tparams     = typeTparams,
      params      = IArray(interpretedProps.map(_._2)),
      impl        = impl,
      resultType  = ret,
      isOverride  = false,
      comments    = NoComments,
      codePath    = typeCp + name,
      isImplicit  = false,
    )
  }
}
