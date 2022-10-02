package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.transforms.FakeLiterals

case class CreatorMethod(
    params:       IArray[ParamTree],
    initializers: IArray[ObjectUpdater.Initializer],
    mutators:     IArray[ObjectUpdater.Mutator],
)

sealed trait ObjectUpdater
object ObjectUpdater {
  case class Initializer(value: ExprTree.Arg.Named) extends ObjectUpdater
  case class Mutator(value:     ExprTree => ExprTree) extends ObjectUpdater
}

object CreatorMethod {
  def apply(props: IArray[Prop], longApplyMethod: Boolean): CreatorMethod = {
    val interpretedProps = props.map(prop => if (longApplyMethod) full(prop) else minimal(prop))

    val updaters = interpretedProps.collect {
      case Const(objectUpdater)      => objectUpdater
      case Provide(objectUpdater, _) => objectUpdater
    }

    val (mutators: IArray[ObjectUpdater.Mutator], initializers: IArray[ObjectUpdater.Initializer], Empty) =
      updaters.partitionCollect2(
        { case x: ObjectUpdater.Mutator     => x },
        { case x: ObjectUpdater.Initializer => x },
      )

    val params: IArray[ParamTree] =
      interpretedProps.collect { case Provide(_, param) => param }

    CreatorMethod(params, initializers, mutators)
  }

  /** A definition of how to construct a Javascript object on a low-level
    *
    * ST has two way of constructing objects:
    * - with an initial `apply` creator method and a builder to set all optional props
    * - the so called `enableLongApplyMethod` mode, where all props are provided via an `apply` method.
    *
    * This piece of code is only concerned with creating the apply methods. It's reused both for react flavours and
    *  for companions
    *
    * A [[Prop]] can be either constant or provided by the user.
    * - constants are literals and `null`
    * - provided are parameters which the user will provide. These values may be rewritten before we put them into the object
    *
    */
  sealed trait CreatorMethodFragment
  case class Const(objectUpdater:   ObjectUpdater) extends CreatorMethodFragment
  case class Provide(objectUpdater: ObjectUpdater, param: ParamTree) extends CreatorMethodFragment
  case object NotNeeded extends CreatorMethodFragment

  // use this to construct a minimal object, with required props, null and literals
  def minimal(prop: Prop): CreatorMethodFragment =
    prop match {
      // this branch is very rarely needed, only if there are > 254 required props (including in parents)
      // will the user have to provide a valid instance of a parent type
      case Prop.CompressedProp(name, tpe, asExpr, true) =>
        Provide(
          ObjectUpdater.Mutator(asExpr),
          ParamTree(name, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments),
        )

      // required literals
      case prop @ Prop.Normal(Prop.Variant(tpe, _, _, _), _, Optionality.No, _, _)
          if tpe.comments.has[Marker.WasLiteral] =>
        val literal = tpe.comments.extract { case Marker.WasLiteral(lit) => lit }.get._1

        Const(requiredProp(prop, literal))

      // required props
      case prop @ Prop.Normal(Prop.Variant(tpe, asExpr, _, _), _, Optionality.No, _, _) =>
        Provide(
          requiredProp(prop, asExpr(Ref(prop.name))),
          ParamTree(prop.name, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments),
        )

      // required null
      case prop @ Prop.Normal(_, _, Optionality.Null, _, _) =>
        Const(requiredProp(prop, Null))

      case _ => NotNeeded
    }

  // use this to
  def full(prop: Prop): CreatorMethodFragment =
    prop match {
      case Prop.CompressedProp(name, tpe, asExpr, isRequired) =>
        val default = if (isRequired) NotImplemented else Null

        Provide(
          ObjectUpdater.Mutator(ref =>
            if (isRequired) asExpr(ref) else If(BinaryOp(Ref(name), "!=", Null), asExpr(ref), None),
          ),
          ParamTree(name, isImplicit = false, isVal = false, tpe, default, NoComments),
        )

      case prop @ Prop.Normal(Prop.Variant(tpe, _, _, _), _, Optionality.No, _, _)
          if tpe.comments.has[Marker.WasLiteral] =>
        val lit = tpe.comments.extract { case Marker.WasLiteral(lit) => lit }.get._1

        Const(requiredProp(prop, lit))

      case prop @ Prop.Normal(Prop.Variant(tpe, asExpr, _, _), _, optionality, _, _) =>
        optionality match {
          case Optionality.No =>
            Provide(
              requiredProp(prop, asExpr(Ref(prop.name))),
              ParamTree(prop.name, isImplicit = false, isVal = false, tpe, NotImplemented, NoComments),
            )

          case Optionality.Null =>
            val default = if (prop.main.extendsAnyVal) AsInstanceOf(Null, tpe) else Null

            Provide(
              updateObj(
                prop,
                If(
                  pred    = BinaryOp(Ref(prop.name), "!=", Null),
                  ifTrue  = asExpr(AsInstanceOf(Ref(prop.name), tpe)),
                  ifFalse = Some(Null),
                ),
              ),
              ParamTree(prop.name, isImplicit = false, isVal = false, tpe, default, NoComments),
            )

          case Optionality.Undef if prop.main.extendsAnyVal =>
            Provide(
              ObjectUpdater.Mutator { ref =>
                If(
                  pred    = Unary("!", Call(Ref(QualifiedName.isUndefined), IArray(IArray(Ref(prop.name))))),
                  ifTrue  = updateObj(prop, asExpr(Ref(prop.name))).value(ref),
                  ifFalse = None,
                )
              },
              ParamTree(prop.name, isImplicit = false, isVal = false, TypeRef.UndefOr(tpe), undefined, NoComments),
            )

          case Optionality.Undef =>
            Provide(
              ObjectUpdater.Mutator { ref =>
                If(
                  pred    = BinaryOp(Ref(prop.name), "!=", Null),
                  ifTrue  = updateObj(prop, asExpr(Ref(prop.name))).value(ref),
                  ifFalse = None,
                )
              },
              ParamTree(prop.name, isImplicit = false, isVal = false, tpe, Null, NoComments),
            )

          case Optionality.NullOrUndef =>
            val updater = ObjectUpdater.Mutator { ref =>
              val shortedDefaultImplementation =
                asExpr(Null) match {
                  // default implementation, save boilerplate
                  case AsInstanceOf(Null, TypeRef.JsAny) =>
                    updateObj(prop, asExpr(Ref(prop.name)))
                  case _ =>
                    updateObj(
                      prop,
                      If(
                        pred    = BinaryOp(Ref(prop.name), "!=", Null),
                        ifTrue  = asExpr(AsInstanceOf(Ref(prop.name), tpe)),
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
            Provide(updater, param)
        }
    }

  def requiredProp(prop: Prop.Normal, value: ExprTree): ObjectUpdater =
    if (prop.canBeInitializer) ObjectUpdater.Initializer(Arg.Named(prop.name, value)) else updateObj(prop, value)

  def updateObj(prop: Prop.Normal, value: ExprTree): ObjectUpdater.Mutator =
    ObjectUpdater.Mutator(ref =>
      Call(
        Select(ref, Name("updateDynamic")),
        IArray(IArray(StringLit(prop.originalName.unescaped)), IArray(value)),
      ),
    )
}
