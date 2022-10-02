package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.transforms.ModulesCombine

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
final class GenCompanions(findProps: FindProps, enableLongApplyMethod: Boolean) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    genCompanions(scope, container) match {
      case Empty => container
      case newCompanions =>
        ModulesCombine.combineModules(container.withMembers(container.members ++ newCompanions))
    }

  def genCompanions(scope: TreeScope, container: ContainerTree): IArray[ModuleTree] =
    container.members.mapNotNone {
      case cls: ClassTree =>
        val clsRef = TypeRef(cls.codePath, asTypeArgs(cls.tparams), NoComments)

        val generatedBuilder: Option[ClassTree] =
          if (enableLongApplyMethod) None
          else {
            findProps.forClassTree(
              cls                = cls,
              scope              = scope / cls,
              maxNum             = Int.MaxValue,
              acceptNativeTraits = false,
              selfRef            = clsRef,
            ) match {
              case Res.One(_, props) if props.nonEmpty => GenBuilderClass(cls, props, cls.codePath)
              case _                                   => None
            }
          }
        val hasImplementation: Boolean = {

          /** When we rewrite type unions to inheritance we might produce two companions in the same scope, see `echarts` test.
            *  This test catches a bit too much (meaning we might not generate some companions), but it should be fairly safe */
          if (cls.comments.has[Marker.WasUnion])
            container.index(cls.name).length > 1
          else
            container.index(cls.name).exists {
              case c: ContainerTree => c.index.contains(Name.APPLY)
              case _: MemberTree    => true
              case _ => false
            }
        }

        val generatedCreators: IArray[Tree] =
          if (hasImplementation) Empty
          else
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
              case Res.One(_, props: IArray[Prop]) =>
                val cm = CreatorMethod(props, longApplyMethod = enableLongApplyMethod)

                IArray.fromOptions(
                  Some(generateCreator(Name.APPLY, cm, cls.codePath, cls.tparams))
                    .filter(_.params.nonEmpty)
                    .filter(ensureNotTooManyStrings(scope)),
                )

              case Res.Many(propsMap) =>
                propsMap.toIArray.mapNotNone {
                  case (_, props) if props.isEmpty => None
                  case (propsRef, props) =>
                    val cm = CreatorMethod(props, longApplyMethod = enableLongApplyMethod)

                    val tparams = cls.tparams.filter(tp => propsRef.targs.exists(_.name === tp.name))

                    Some(generateCreator(propsRef.name, cm, propsRef.typeName, tparams))
                      .filter(_.params.nonEmpty)
                      .filter(ensureNotTooManyStrings(scope))
                }
            }

        generatedCreators ++ IArray.fromOption(generatedBuilder) match {
          case Empty => None
          case some =>
            val related      = Marker.MinimizationRelated(some.collect { case m: HasCodePath => TypeRef(m.codePath) })
            val dontMinimize = Comments(related)
            val mod = ModuleTree(
              Empty,
              ProtectionLevel.Public,
              cls.name,
              Empty,
              some,
              dontMinimize,
              cls.codePath,
              isOverride = false,
            )
            Some(mod)
        }

      case _ => None
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
      name:          Name,
      creatorMethod: CreatorMethod,
      typeCp:        QualifiedName,
      typeTparams:   IArray[TypeParamTree],
  ): MethodTree = {

    val ret = TypeRef(typeCp, asTypeArgs(typeTparams), NoComments)

    val impl: ExprTree = {
      val objName = Name("__obj")
      Block.flatten(
        IArray(
          Val(
            objName,
            Call(Ref(QualifiedName.JsDynamic).select("literal"), IArray(creatorMethod.initializers.map(_.value))),
          ),
        ),
        creatorMethod.mutators.map(f => f.value(Ref(objName))),
        IArray(AsInstanceOf(Ref(QualifiedName(IArray(objName))), ret)),
      )
    }

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Public,
      name        = name,
      tparams     = typeTparams,
      params      = IArray(creatorMethod.params),
      impl        = impl,
      resultType  = ret,
      isOverride  = false,
      comments    = NoComments,
      codePath    = typeCp + name,
      isImplicit  = false,
    )
  }
}
