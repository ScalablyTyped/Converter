package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.ExprTree._

sealed trait ObjectUpdater
case class Initializer(value: ExprTree.Arg.Named) extends ObjectUpdater
case class Mutator(value:     ExprTree => ExprTree) extends ObjectUpdater

/**
  *  The process of "interpretation" takes a `Prop` and returns a parameter and a way to update a given object
  *
  *  Note that this is not the only possible way of doing it, [[GenBuilderOpsClass]] does it differently
  */
object defaultInterpretation {
  def apply(prop: Prop): (ObjectUpdater, Either[ExprTree.Val, ParamTree]) =
    prop match {
      case Prop.CompressedProp(name, tpe, asExpr, isRequired) =>
        val default = if (isRequired) NotImplemented else Null

        val param = ParamTree(name, isImplicit = false, isVal = false, tpe, default, NoComments)
        val updater =
          Mutator(ref => if (isRequired) asExpr(ref) else If(BinaryOp(Ref(name), "!=", Null), asExpr(ref), None))

        (updater, Right(param))

      case prop @ Prop.Normal(Prop.Variant(tpe, asExpr, _, _), _, optionality, _, _) =>
        def updateObj(value: ExprTree): Mutator =
          Mutator(ref =>
            Call(
              Select(ref, Name("updateDynamic")),
              IArray(IArray(StringLit(prop.originalName.unescaped)), IArray(value)),
            ),
          )

        optionality match {
          case Optionality.No =>
            val updater =
              if (prop.canBeInitializer) Initializer(Arg.Named(prop.name, asExpr(Ref(prop.name))))
              else updateObj(asExpr(Ref(prop.name)))

            (updater, Right(ParamTree(prop.name, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)))

          case Optionality.Null =>
            val updater =
              if (prop.canBeInitializer) Initializer(Arg.Named(prop.name, asExpr(Ref(prop.name))))
              else updateObj(asExpr(Ref(prop.name)))

            (updater, Left(Val(prop.name, if (prop.main.extendsAnyVal) Cast(Null, tpe) else Null)))

          case Optionality.Undef if prop.main.extendsAnyVal =>
            val updater = Mutator { ref =>
              If(
                pred    = Unary("!", Call(Ref(QualifiedName.isUndefined), IArray(IArray(Ref(prop.name))))),
                ifTrue  = updateObj(asExpr(Select(Ref(prop.name), Name("get")))).value(ref),
                ifFalse = None,
              )
            }
            val param =
              ParamTree(prop.name, isImplicit = false, isVal = false, TypeRef.UndefOr(tpe), undefined, NoComments)
            (updater, Right(param))

          case Optionality.Undef =>
            val updater = Mutator { ref =>
              If(
                pred    = BinaryOp(Ref(prop.name), "!=", Null),
                ifTrue  = updateObj(asExpr(Ref(prop.name))).value(ref),
                ifFalse = None,
              )
            }
            val param = ParamTree(prop.name, isImplicit = false, isVal = false, tpe, Null, NoComments)
            (updater, Right(param))

          case Optionality.NullOrUndef =>
            val updater = Mutator { ref =>
              val shortedDefaultImplementation =
                asExpr(Null) match {
                  // default implementation, save boilerplate
                  case Cast(Null, TypeRef.Any) =>
                    updateObj(asExpr(Ref(prop.name)))
                  case _ =>
                    updateObj(
                      If(
                        pred    = BinaryOp(Ref(prop.name), "!=", Null),
                        ifTrue  = asExpr(Cast(Ref(prop.name), tpe)),
                        ifFalse = Some(Null),
                      ),
                    )
                }

              If(
                pred    = Unary("!", Call(Ref(QualifiedName.isUndefined), IArray(IArray(Ref(prop.name))))),
                ifTrue  = shortedDefaultImplementation.value(ref),
                ifFalse = None,
              )
            }

            val newType = TypeRef.Union(IArray(TypeRef.undefined, TypeRef.Null, tpe), NoComments, sort = false)

            val param = ParamTree(prop.name, isImplicit = false, isVal = false, newType, undefined, NoComments)
            (updater, Right(param))
        }

    }
}
