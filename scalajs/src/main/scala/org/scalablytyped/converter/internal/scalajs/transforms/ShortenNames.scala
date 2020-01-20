package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.collection.mutable

object ShortenNames {
  val Forbidden: Set[Name] = Set(Name("|"), Name("_"), Name("scala"), Name("js"), Name("com"), Name("org"))

  case class ImportTree(imported: QualifiedName)

  def apply(owner: ContainerTree, scope: TreeScope)(members: IArray[Tree]): (IArray[ImportTree], IArray[Tree]) = {
    val collectedImports = mutable.Map.empty[Name, QualifiedName]

    object V extends TreeTransformation {
      override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef = {
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
              /* keep more expensive check last */
              !nameCollision(scope, longName, methodsAreConflict = isSingleton)) {

            collectedImports.get(shortName) match {
              case Some(alreadyImported) =>
                if (alreadyImported === tr.typeName) Some(tr.copy(typeName = QualifiedName(IArray(shortName))))
                else None
              case None =>
                val importNecessary = !inScope(scope, longName)
                if (importNecessary)
                  collectedImports += ((shortName, tr.typeName))
                Some(tr.copy(typeName = QualifiedName(IArray(shortName))))
            }
          } else None
        }

        rewrittenOpt getOrElse tr
      }
    }

    val newMembers = members.map(V.visitTree(scope))

    val imports: IArray[ImportTree] =
      IArray
        .fromTraversable(
          collectedImports.values
            .filterNot(_.startsWith(QualifiedName.scala))
            .filterNot(_.startsWith(QualifiedName.java_lang)),
        )
        .sortBy(Printer.formatQN)
        .map(ImportTree.apply)

    (imports, newMembers)
  }

  def dropOuterPackages(scope: TreeScope): List[Tree] = {
    val numPackages = scope.stack.count(_.isInstanceOf[PackageTree])
    scope.stack.dropRight(numPackages - 1)
  }

  def inScope(scope: TreeScope, longName: QualifiedName): Boolean =
    dropOuterPackages(scope).exists {
      case x: ContainerTree =>
        x.index get longName.parts.last match {
          case Some(trees) =>
            trees exists {
              case _: ClassTree     => true
              case _: TypeAliasTree => true
              case _ => false
            }
          case None => false
        }
      case _ => false
    }

  object nameCollision {
    def apply(scope: TreeScope, longName: QualifiedName, methodsAreConflict: Boolean): Boolean =
      dropOuterPackages(scope).exists {
        case x: InheritanceTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) ||
            among(x.index, longName, methodsAreConflict) ||
            amongParents(scope, x, longName, methodsAreConflict)
        case x: PackageTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) || among(
            x.index,
            longName,
            methodsAreConflict = true,
          )
        case x: TypeAliasTree =>
          (x.name === longName.parts.last && x.codePath =/= longName)
        case x: FieldTree =>
          (x.name === longName.parts.last && x.codePath =/= longName)
        case x: MethodTree =>
          (x.name === longName.parts.last && x.codePath =/= longName) ||
            (methodsAreConflict && x.params.exists(_.exists(_.name === longName.parts.last)))
        case _ => false
      }

    private def amongParents(
        scope:              TreeScope,
        x:                  InheritanceTree,
        longName:           QualifiedName,
        methodsAreConflict: Boolean,
    ): Boolean =
      ParentsResolver(scope, x).transitiveParents.exists {
        case (_, cls) => among(cls.index, longName, methodsAreConflict)
      }

    private def among(index: Map[Name, IArray[Tree]], longName: QualifiedName, methodsAreConflict: Boolean): Boolean =
      index get longName.parts.last match {
        case Some(trees) =>
          trees exists {
            case x: ClassTree     => x.codePath =/= longName
            case x: ModuleTree    => x.codePath =/= longName && methodsAreConflict
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
