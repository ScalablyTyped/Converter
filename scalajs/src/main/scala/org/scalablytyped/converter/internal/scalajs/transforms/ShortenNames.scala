package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.maps._
import scala.collection.mutable

object ShortenNames {
  val Forbidden: Set[Name] = Set(Name("|"), Name.underscore, Name.scala, Name.js, Name.com, Name.org, Name("List"))

  case class ImportTree(imported: QualifiedName)

  def apply(owner: ContainerTree, scope: TreeScope, parentsResolver: ParentsResolver)(
      members:     IArray[Tree],
  ): (IArray[ImportTree], IArray[Tree]) = {
    val collectedImports = mutable.Map.empty[Name, QualifiedName]

    object V extends TreeTransformation {
      override def leaveExprRefTree(scope: TreeScope)(s: ExprTree.Ref): ExprTree.Ref =
        maybeImport(scope, longName = s.value) match {
          case Some(rewritten) => s.copy(value = rewritten)
          case None            => s
        }

      override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
        maybeImport(scope, longName = tr.typeName) match {
          case Some(rewritten) => tr.copy(typeName = rewritten)
          case None            => tr
        }

      override def leaveExprTree(scope: TreeScope)(s: ExprTree): ExprTree =
        s match {
          case ExprTree.Ref(value) =>
            maybeImport(scope, value) match {
              case Some(rewritten) => ExprTree.Ref(rewritten)
              case None            => s
            }
          case _ => s
        }

      def maybeImport(scope: TreeScope, longName: QualifiedName): Option[QualifiedName] = {
        lazy val methodsAreConflict = {
          def isSingleton = scope.stack match {
            case _ :: TypeRef.Singleton(_) :: _ => true
            case _                              => false
          }
          def isRef = scope.stack.exists {
            case _: ExprTree.Ref => true
            case _ => false
          }
          isSingleton || isRef
        }

        val shortName = longName.parts.last

        val rewrittenOpt: Option[QualifiedName] = {
          if (!Name.Internal(shortName) &&
              longName.parts.head =/= Name.THIS &&
              longName.parts.head =/= Name.SUPER &&
              !Forbidden.contains(shortName) &&
              owner.name =/= shortName &&
              longName.parts.length > 1 &&
              /* the printer has special logic for these */
              longName =/= TypeRef.Nothing.typeName &&
              !TypeRef.ScalaFunction.is(longName) &&
              !longName.startsWith(QualifiedName.scala_js) &&
              /* keep more expensive check last */
              !nameCollision(scope, parentsResolver, longName, methodsAreConflict = methodsAreConflict)) {

            collectedImports.get(shortName) match {
              case Some(alreadyImported) =>
                if (alreadyImported === longName) Some(QualifiedName(IArray(shortName)))
                else None
              case None =>
                val importNecessary = !inScope(scope, longName)
                if (importNecessary)
                  collectedImports += ((shortName, longName))
                Some(QualifiedName(IArray(shortName)))
            }
          } else None
        }

        rewrittenOpt
      }
    }

    val newMembers = members.map(V.visitTree(scope))

    def keepImport(qn: QualifiedName): Boolean =
      if (qn.startsWith(QualifiedName.scala) && qn.parts.length == 2) false
      else if (qn.startsWith(QualifiedName.java_lang)) false
      else if (qn === QualifiedName.StObject) false
      else true

    val imports: IArray[ImportTree] =
      collectedImports
        .toIArrayValues(keep = keepImport)
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
      case x: ContainerTree if x.codePath === longName => true
      case x: ContainerTree =>
        x.index.get(longName.parts.last) match {
          case Some(trees) =>
            trees.exists {
              case _: ClassTree     => true
              case _: TypeAliasTree => true
              case _ => false
            }
          case None => false
        }
      case _ => false
    }

  object nameCollision {
    def apply(
        scope:              TreeScope,
        parentsResolver:    ParentsResolver,
        longName:           QualifiedName,
        methodsAreConflict: Boolean,
    ): Boolean = {
      val shortName = longName.parts.last

      dropOuterPackages(scope).exists {
        case x: InheritanceTree =>
          def ctorClash = x match {
            case c: ClassTree => c.ctors.exists(_.params.exists(_.name === shortName))
            case _ => false
          }
          def tparamsClash = x match {
            case cls: ClassTree => cls.tparams.exists(_.name === shortName)
            case _ => false
          }

          (x.name === shortName && x.codePath =/= longName) ||
          among(x.index, longName, methodsAreConflict) ||
          amongParents(scope, parentsResolver, x, longName, methodsAreConflict) ||
          tparamsClash ||
          ctorClash

        case x: PackageTree =>
          (x.name === shortName && x.codePath =/= longName) ||
            among(x.index, longName, methodsAreConflict = true)
        case x: TypeAliasTree =>
          (x.name === shortName && x.codePath =/= longName) ||
            x.tparams.exists(_.name === shortName)
        case x: FieldTree =>
          (x.name === shortName && x.codePath =/= longName)
        case x: MethodTree =>
          (x.name === shortName && x.codePath =/= longName) ||
            (methodsAreConflict && x.params.exists(_.exists(_.name === shortName))) ||
            x.tparams.exists(_.name === shortName)
        case x: ExprTree.Block =>
          x.expressions.exists {
            case ExprTree.Val(name, _) => longName.parts.head === name
            case _                     => false
          }
        case _ => false
      }
    }

    private def amongParents(
        scope:              TreeScope,
        parentsResolver:    ParentsResolver,
        x:                  InheritanceTree,
        longName:           QualifiedName,
        methodsAreConflict: Boolean,
    ): Boolean =
      parentsResolver(scope, x).transitiveParents.exists {
        case (_, cls) => among(cls.index, longName, methodsAreConflict)
      }

    private def among(index: Map[Name, IArray[Tree]], longName: QualifiedName, methodsAreConflict: Boolean): Boolean =
      index.get(longName.parts.last) match {
        case Some(trees) =>
          trees.exists {
            case x: ClassTree     => x.codePath =/= longName
            case x: ModuleTree    => x.codePath =/= longName && methodsAreConflict
            case x: PackageTree   => x.codePath =/= longName
            case x: TypeAliasTree => x.codePath =/= longName
            case x: FieldTree     => x.isReadOnly || methodsAreConflict
            case _: MethodTree    => methodsAreConflict
            case _ => false
          }
        case None => false
      }
  }
}
