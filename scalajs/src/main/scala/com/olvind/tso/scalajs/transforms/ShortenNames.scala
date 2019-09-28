package com.olvind.tso
package scalajs
package transforms

import scala.collection.mutable

object ShortenNames {
  case class Import(imported: QualifiedName)

  def apply(owner: ContainerTree, scope: TreeScope)(members: Seq[Tree]): (Seq[Import], Seq[Tree]) = {
    val collectedImports = mutable.Map.empty[Name, QualifiedName]

    object V extends TreeTransformation {
      override def leaveExprRefTree(scope: TreeScope)(s: ExprTree.Ref): ExprTree.Ref =
        maybeImport(scope, fullName = s.value) match {
          case Some(rewritten) => s.copy(value = rewritten)
          case None            => s
        }

      override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
        maybeImport(scope, fullName = tr.typeName) match {
          case Some(rewritten) => tr.copy(typeName = rewritten)
          case None            => tr
        }

      override def leaveExprTree(scope: TreeScope)(s: ExprTree): ExprTree =
        s match {
          case ExprTree.Ref(value) =>
            maybeImport(scope, fullName = value) match {
              case Some(rewritten) => ExprTree.Ref(rewritten)
              case None            => s
            }
          case _ => s
        }

      def maybeImport(scope: TreeScope, fullName: QualifiedName): Option[QualifiedName] = {
        lazy val membersAreConflict = {
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

        val (left: QualifiedName, right: QualifiedName) =
          fullName match {
//            case scalajsName
//                if scalajsName.startsWith(QualifiedName.scala_js) &&
//                  (scalajsName.parts.length === QualifiedName.scala_js.parts.length + 1) =>
//              val short = QualifiedName(Name.js, scalajsName.parts.last)
//              (short, QualifiedName.scala_js)
            case _ =>
              val short = QualifiedName(fullName.parts.takeRight(1))
              (short, fullName)
          }

        val leftFirst = left.parts.head

        if (!Name.Internal(leftFirst) &&
            owner.name =/= leftFirst &&
            right.parts.length > 1 &&
            /* the printer has special logic for these */
            right =/= QualifiedName.Nothing &&
            !TypeRef.ScalaFunction.unapply(right) &&
            !(right.startsWith(QualifiedName.scala_js) && right.parts.length === QualifiedName.scala_js.parts.length + 1) &&
            /* keep more expensive checks last */
            !nameCollision.among(owner.index, right, membersAreConflict) &&
            !nameCollision.inScope(scope, right, membersAreConflict)) {

          collectedImports get leftFirst match {
            case Some(alreadyImported) =>
              if (alreadyImported === right) Some(left)
              else None
            case None =>
              val importNecessary = right.parts.dropRight(left.parts.length) =/= owner.codePath.parts
              if (importNecessary)
                collectedImports += ((leftFirst, right))
              Some(left)
          }
        } else None
      }
    }

    val newMembers = members.map(V.visitTree(scope))

    val imports: Seq[Import] =
      collectedImports.values
        .filterNot(x => x.startsWith(QualifiedName.scala) && x.parts.length === 2)
        .filterNot(_.startsWith(QualifiedName.java_lang))
        .to[Seq]
        .sortBy(Printer.formatQN)
        .map(Import.apply)

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
        membersAreConflict: Boolean,
    ): Boolean =
      ParentsResolver(scope, x).transitiveParents.exists {
        case (_, cls) => among(cls.index, longName, membersAreConflict)
      }

    def among(index: Map[Name, Seq[Tree]], longName: QualifiedName, membersAreConflict: Boolean): Boolean =
      index get longName.parts.last match {
        case Some(trees) =>
          trees exists {
            case x: ClassTree     => x.codePath =/= longName
            case _: ModuleTree    => membersAreConflict
            case x: PackageTree   => x.codePath =/= longName
            case x: TypeAliasTree => x.codePath =/= longName
            case x: FieldTree     => x.isReadOnly || membersAreConflict
            case _: MethodTree    => membersAreConflict
            case _ => false
          }
        case None => false
      }
  }
}
