package com.olvind.tso
package scalajs
package transforms

import scala.collection.mutable

object ShortenNames {
  val Forbidden: Set[Name] = Set(Name("|"), Name("scala"), Name("js"), Name("com"), Name("org"))

  case class ImportTree(imported: QualifiedName)

  def apply(owner: ContainerTree, scope: TreeScope)(members: Seq[Tree]): (Seq[ImportTree], Seq[Tree]) = {
    val collectedImports = mutable.Map.empty[Name, QualifiedName]

    object V extends TreeTransformation {
      override def enterTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef = {
        val shortName = tr.name
        val longName  = tr.typeName

        lazy val isSingleton = scope.stack match {
          case _ :: TypeRef.Singleton(_) :: _ => true
          case _                              => false
        }

        val rewrittenOpt: Option[TypeRef] = {
          if (!Name.Internal(shortName) &&
              !Forbidden.contains(shortName) &&
              owner.name =/= shortName &&
              tr.typeName.parts.length > 1 &&
              /* the printer has special logic for these */
              tr =/= TypeRef.Nothing &&
              TypeRef.ScalaFunction.unapply(tr).isEmpty &&
              !tr.typeName.startsWith(QualifiedName.scala_js) &&
              /* keep more expensive checks last */
              !nameCollision.among(owner.index, longName, methodsAreConflict = isSingleton) &&
              !nameCollision.inScope(scope, longName, methodsAreConflict     = isSingleton)) {

            collectedImports.get(shortName) match {
              case Some(alreadyImported) =>
                if (alreadyImported === tr.typeName) Some(tr.copy(typeName = QualifiedName(List(shortName))))
                else None
              case None =>
                val importNecessary = tr.typeName.parts.dropRight(1) =/= owner.codePath.parts
                if (importNecessary)
                  collectedImports += ((shortName, tr.typeName))
                Some(tr.copy(typeName = QualifiedName(List(shortName))))
            }
          } else None
        }

        rewrittenOpt getOrElse tr
      }
    }

    val newMembers = members.map(V.visitTree(scope))

    val imports: Seq[ImportTree] =
      collectedImports.values
        .filterNot(_.startsWith(QualifiedName.scala))
        .filterNot(_.startsWith(QualifiedName.java_lang))
        .to[Seq]
        .sortBy(Printer.formatQN)
        .map(ImportTree.apply)

    (imports, newMembers)
  }

  object nameCollision {
    def inScope(scope: TreeScope, longName: QualifiedName, methodsAreConflict: Boolean): Boolean =
      scope.stack.exists {
        case x: InheritanceTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) ||
            among(x.index, longName, methodsAreConflict) ||
            amongParents(scope, x, longName, methodsAreConflict)
        case x: PackageTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) || among(x.index, longName, methodsAreConflict)
        case x: TypeAliasTree =>
          (x.name === longName.parts.last && x.codePath =/= longName)
        case x: FieldTree =>
          (x.name === longName.parts.last && x.codePath =/= longName)
        case x: MethodTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) ||
            (methodsAreConflict && x.params.exists(_.exists(_.name === longName.parts.last)))
        case _ => false
      }

    def amongParents(
        scope:              TreeScope,
        x:                  InheritanceTree,
        longName:           QualifiedName,
        methodsAreConflict: Boolean,
    ): Boolean =
      ParentsResolver(scope, x).transitiveParents.exists {
        case (_, cls) => among(cls.index, longName, methodsAreConflict)
      }

    def among(index: Map[Name, Seq[Tree]], longName: QualifiedName, methodsAreConflict: Boolean): Boolean =
      index get longName.parts.last match {
        case Some(trees) =>
          trees exists {
            case x: ClassTree     => x.codePath =/= longName
            case x: ModuleTree    => methodsAreConflict
            case x: PackageTree   => x.codePath =/= longName
            case x: TypeAliasTree => x.codePath =/= longName
            case x: FieldTree     => x.isReadOnly
            case _: MethodTree    => methodsAreConflict
            case _ => false
          }
        case None => false
      }
  }
}
