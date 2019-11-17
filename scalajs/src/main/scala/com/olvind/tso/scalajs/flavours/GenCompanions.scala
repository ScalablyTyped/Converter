package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.seqs._

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
class GenCompanions(memberToParam: MemberToParam, params: Params) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.exists { case mod: ModuleTree => mod.isNative; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Nil) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case cls: ClassTree if cls.classType === ClassType.Trait && cls.isScalaJsDefined && !nameConflict(cls.name) =>
          List(cls) ++ generateModule(scope, cls).filter(ensureNotTooManyStrings)
        case other => List(other)
      })
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(mod: ModuleTree): Boolean = {
    val MaxWeight = 32768 // an estimate. If you see the error again, decrease this

    var stringLength = 0
    TreeTraverse.foreach(mod) {
      case QualifiedName(parts) => parts.foreach(p => stringLength += p.unescaped.length)
      case _                    => ()
    }

    stringLength < MaxWeight
  }

  def generateModule(scope: TreeScope, cls: ClassTree): Option[ModuleTree] =
    params.forClassTree(cls, scope, memberToParam, Params.MaxParamsForMethod) match {
      case Nil => None
      case params =>
        val (optionals, inLiterals, Nil) = params.partitionCollect2(
          { case Param(_, Right(f))  => f },
          { case Param(_, Left(str)) => str },
        )
        val applyRet = TypeRef(
          QualifiedName(cls.name :: Nil),
          cls.tparams.map(tp => TypeRef(QualifiedName(tp.name :: Nil), Nil, NoComments)),
          NoComments,
        )

        Some(
          ModuleTree(
            Nil,
            cls.name,
            Nil,
            Seq(
              MethodTree(
                Annotation.Inline :: Nil,
                ProtectionLevel.Default,
                Name.APPLY,
                cls.tparams,
                params.map(_.parameter) :: Nil,
                MemberImpl.Custom(s"""{
                                       |  val __obj = js.Dynamic.literal(${inLiterals.mkString(", ")})
                                       |${optionals.map(f => "  " + f("__obj")).mkString("\n")}
                                       |  __obj.asInstanceOf[${Printer.formatTypeRef(0)(applyRet)}]
                                       |}""".stripMargin),
                applyRet,
                isOverride = false,
                NoComments,
                cls.codePath + Name.APPLY,
              ),
            ),
            NoComments,
            cls.codePath,
          ),
        )
    }
}
