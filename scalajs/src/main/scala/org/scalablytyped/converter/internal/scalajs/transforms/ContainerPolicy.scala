package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.maps._
import cats.data.Ior
import cats.instances.list._
import cats.syntax.alternative._

import scala.collection.mutable

object ContainerPolicy extends TreeTransformation {
  /* sneak import annotations through fields/methods which otherwise don't have them */
  case class ClassAnnotations(value: IArray[ClassAnnotation]) extends Comment.Data

  override def leaveContainerTree(scope: TreeScope)(_s: ContainerTree): ContainerTree = {
    val s = combineModules(_s)

    val classesToRename = mutable.ArrayBuffer.empty[QualifiedName]

    val rewrittenContainers = s.members.map {
      case pkg: PackageTree => moveMemberTreesIntoHatObject(pkg, Empty)
      case mod: ModuleTree =>
        Action(scope, mod) match {
          case Action.RemainModule =>
            mod.withMembers(mod.members map stripLocationAnns)
          case Action.ConvertToPackage(renameClassOpt) =>
            renameClassOpt foreach classesToRename.+=
            moveMemberTreesIntoHatObject(
              PackageTree(mod.annotations, mod.name, mod.members, mod.comments, mod.codePath),
              mod.parents,
            )
        }
      case other => other
    }

    val rewritten = rewrittenContainers.flatMap {
      case cls: ClassTree if classesToRename.contains(cls.codePath) =>
        val renamedClass = cls.withSuffix("")
        IArray(
          renamedClass,
          TypeAliasTree(
            cls.name,
            cls.tparams,
            TypeRef(renamedClass.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            NoComments,
            cls.codePath,
          ),
        )
      case other => IArray(other)
    }

    val isTopLevel = scope.stack.length < 3 // typings, libName
    if (isTopLevel)
      moveMemberTreesIntoHatObject(PackageTree(s.annotations, s.name, rewritten, s.comments, s.codePath), Empty)
    else
      s.withMembers(rewritten)
  }

  sealed trait Action

  object Action {
    case object RemainModule extends Action
    case class ConvertToPackage(renameClass: Option[QualifiedName]) extends Action

    def existsClassWithSameName(scope: TreeScope, name: Name): Option[QualifiedName] =
      for {
        owner <- scope.stack.collectFirst { case x: ContainerTree => x }
        sameName <- owner.index.get(name)
        cls <- sameName.collectFirst { case x: ClassTree => x.codePath }
      } yield cls

    def apply(scope: TreeScope, mod: ModuleTree): Action = {
      def containsPackage = mod.members.exists {
        case _: PackageTree => true
        case _ => false
      }

      /* these might receive a scala companion, which we cannot put inside a javascript object */
      def containsIllegal = mod.members.exists {
        case x: ClassTree =>
          x.receivesCompanion
        case x: TypeAliasTree if !x.comments.has[Markers.IsTrivial.type] =>
          FollowAliases(scope)(x.alias) match {
            case TypeRef.Union(_, _) => true
            case _                   => false
          }
        case x: ModuleTree =>
          x.annotations.isEmpty
        case _ => false
      }

      // avoid `object A extends A.B {trait B}`
      def inheritsFromMember = {
        def illegal(typeRef: TypeRef): Boolean = {
          val isLonger = typeRef.typeName.parts.length > mod.codePath.parts.length
          val isInside = typeRef.typeName.parts.startsWith(mod.codePath.parts)
          (isLonger && isInside) || typeRef.targs.exists(illegal)
        }

        mod.parents exists illegal
      }

      def requiresCustomImport = {
        def check(anns: IArray[Annotation], name: Name) =
          anns exists {
            case Annotation.JsGlobalScope           => true
            case Annotation.JsImport(_, _, Some(_)) => true
            case Annotation.JsImport(_, i, _) =>
              i match {
                case Imported.Namespace => true
                case Imported.Default   => name =/= Name.Default
                case Imported.Named(x)  => x.last =/= name
              }
            case Annotation.JsGlobal(x) => x.parts.last =/= name
            case _                      => false
          }

        mod.members.exists {
          case x: InheritanceTree => check(x.annotations, x.name)
          case x: ContainerTree   => check(x.annotations, x.name)
          case x: FieldTree       => check(x.annotations, x.name)
          case x: MethodTree      => check(x.annotations, x.name)
          case _ => false
        }
      }

      def tooBig = {
        def countClasses(x: ContainerTree): Int =
          x.members.foldLeft(0) {
            case (n, xx: ContainerTree)   => n + 1 + countClasses(xx)
            case (n, _:  InheritanceTree) => n + 1
            case (n, _) => n
          }

        if (mod.comments.has[Markers.EnumObject.type]) false
        else countClasses(mod) > 20
      }

      if (containsPackage || containsIllegal || inheritsFromMember || requiresCustomImport || tooBig)
        Action.ConvertToPackage(existsClassWithSameName(scope, mod.name))
      else Action.RemainModule
    }
  }

  def stripLocationAnns(tree: Tree): Tree = {
    def filterAnns(anns: IArray[ClassAnnotation]): IArray[ClassAnnotation] =
      anns.filter {
        case Annotation.JsNative          => true
        case Annotation.ScalaJSDefined    => true
        case Annotation.JsGlobalScope     => false
        case Annotation.JsName(_)         => false
        case Annotation.JsImport(_, _, _) => false
        case Annotation.JsGlobal(_)       => false
        case Annotation.Inline            => false
      }

    tree match {
      case x: PackageTree => x.copy(annotations = filterAnns(x.annotations))
      case x: ModuleTree  => x.copy(annotations = filterAnns(x.annotations))
      case x: ClassTree   => x.copy(annotations = filterAnns(x.annotations))
      case x => x
    }
  }

  def moveMemberTreesIntoHatObject(s: ContainerTree, inheritance: IArray[TypeRef]): ContainerTree = {
    val hatCp = s.codePath + Name.namespaced

    s.members.partitionCollect { case x: MemberTree => x } match {
      case (Empty, _) if inheritance.isEmpty => s
      case (members, rest) =>
        val rewritten: IArray[Ior[MemberTree, ModuleTree]] =
          members zip members.map(_.comments extract { case ClassAnnotations(anns) => anns }) map {
            case (f @ FieldTree(_, name, tpe, _, isReadonly, isOverride, _, codePath), extracted) =>
              extracted match {
                case Some((anns, restCs)) if tpe.typeName =/= QualifiedName.THIS =>
                  val mod = ModuleTree(anns, name, IArray(TypeRef.TopLevel(tpe)), Empty, restCs, codePath, isOverride)
                  if (isReadonly) Ior.Right(mod)
                  else Ior.Both(f, mod)
                case _ =>
                  Ior.Left(f)
              }

            case (m: MethodTree, extracted) =>
              extracted match {
                case Some((anns, restCs)) if m.name =/= Name.APPLY =>
                  val asApply =
                    m.copy(
                      annotations = Empty,
                      name        = Name.APPLY,
                      codePath    = m.codePath + Name.APPLY,
                      comments    = restCs,
                    )
                  Ior.Right(ModuleTree(anns, m.name, Empty, IArray(asApply), NoComments, m.codePath, m.isOverride))
                case _ =>
                  Ior.Left(m)
              }
            case (other, _) => Ior.Left(other)
          }

        //todo just inline this method
        val (mutables, hoisted) = rewritten.toList.separate

        val hatModule =
          setCodePath(
            hatCp,
            ModuleTree(
              s.annotations,
              Name.namespaced,
              inheritance,
              IArray.fromTraversable(mutables),
              NoComments,
              hatCp,
              isOverride = false,
            ),
          )
        combineModules(s.withMembers(rest ++ IArray.fromTraversable(hoisted) :+ hatModule))
    }
  }

  def combineModules(s: ContainerTree): ContainerTree = {
    val withCombinedModules: IArray[Tree] =
      s.index.flatMapToIArray {
        case (_, ts) =>
          val (mods, rest) = ts partitionCollect { case x: ModuleTree => x }
          val combinedModules: Option[ModuleTree] =
            mods.reduceOption { (mod1, mod2) =>
              ModuleTree(
                annotations = mod1.annotations,
                name        = mod1.name,
                parents     = (mod1.parents ++ mod2.parents).distinct,
                members     = (mod1.members ++ mod2.members).distinct,
                comments    = mod1.comments ++ mod2.comments,
                codePath    = mod1.codePath,
                isOverride  = false,
              )
            }

          rest ++ IArray.fromOption(combinedModules)
      }

    s.withMembers(withCombinedModules)
  }
}
