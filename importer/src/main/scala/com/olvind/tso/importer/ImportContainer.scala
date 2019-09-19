package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts._
import seqs._

object ImportContainer {
  private def handleNamespaced(members: Seq[Tree]): (Seq[TypeRef], Seq[MemberTree], Seq[Tree]) =
    members.partitionCollect4(
      { case x: FieldTree if x.name === Name.namespaced     => x },
      { case x: MethodTree if x.name === Name.namespaced    => x },
      { case x: ContainerTree if x.name === Name.namespaced => x },
      { case x: MemberTree                                  => x },
    ) match {
      case (namespacedFields, namespacedMethods, containers, memberSyms, rest) =>
        val rewrittenMethods = namespacedMethods.map(_.copy(name = Name.APPLY))

        val asParents: Seq[TypeRef] =
          namespacedFields.map(x => x.tpe).toList.distinct match {
            case Nil => Nil
            /* This is a shortcut so we don't have to implement the members */
            case more => Seq(TypeRef.TopLevel(TypeRef.Intersection(more)))
          }

        val (membersFromContainers, restFromContainers) =
          containers.flatMap(_.members).partitionCollect { case x: MemberTree => x }

        (asParents, memberSyms ++ rewrittenMethods ++ membersFromContainers, rest ++ restFromContainers)
    }

  def setCodePath[T <: Tree](base: QualifiedName, t: T): T =
    t match {
      case x: ModuleTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: PackageTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: ClassTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: TypeAliasTree => x.copy(codePath = base).asInstanceOf[T]
      case x: FieldTree     => x.copy(codePath = base).asInstanceOf[T]
      case x: MethodTree    => x.copy(codePath = base).asInstanceOf[T]
      case x => x
    }

  def apply(
      isWithinScalaModule: Boolean,
      importName:          ImportName,
      scope:               TsTreeScope,
      cs:                  Comments,
      name:                TsIdent,
      jsLocation:          JsLocation,
      members:             Seq[TsContainerOrDecl],
      codePath:            CodePath,
  ): ContainerTree = {

    val newCodePath = importName(codePath)
    val anns        = ImportJsLocation(jsLocation, isWithinScalaModule)
    val inModule    = scope.stack.length > 1 && (isWithinScalaModule)

    val (inheritance, liftedMembers, rest) =
      handleNamespaced(members flatMap ImportTree.decl(scope, inModule, importName))

    val scalaName = importName(name)

    val container: ContainerTree = if (inModule) {
      val nameAnns: Option[Annotation.JsName] =
        name match {
          case x: TsIdentNamespace if isWithinScalaModule => Option(Annotation.JsName(Name(x.value)))
          case _ => None
        }

      val allMembers = liftedMembers ++ rest
      ModuleTree(anns ++ nameAnns, scalaName, inheritance, allMembers, cs, newCodePath)
    } else {
      val membersModule =
        if (liftedMembers.nonEmpty || inheritance.nonEmpty)
          Some(
            ModuleTree(
              anns,
              Name.namespaced,
              inheritance,
              liftedMembers,
              NoComments,
              newCodePath + Name.namespaced,
            ),
          )
        else None

      PackageTree(anns, scalaName, rest ++ membersModule, cs, newCodePath)
    }

    setCodePath(container.codePath, container)
  }
}
