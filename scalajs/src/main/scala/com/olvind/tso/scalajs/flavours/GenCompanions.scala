package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.seqs._

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
class GenCompanions(memberParameter: MemberParameter) extends TreeTransformation {
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
          List(cls) ++ generateModule(scope, cls)
        case other => List(other)
      })
    }

  def generateModule(scope: TreeScope, cls: ClassTree): Option[ModuleTree] =
    Param.forClassTree(cls, scope, memberParameter, Param.MaxParamsForMethod) match {
      case Nil => None
      case params =>
        val (optionals, inLiterals, Nil) = params.partitionCollect2(
          { case Param(_, _, Right(f))  => f },
          { case Param(_, _, Left(str)) => str },
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
