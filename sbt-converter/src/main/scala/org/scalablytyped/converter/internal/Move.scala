package org.scalablytyped.converter.internal

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.scalajs._
import scala.collection.immutable.SortedMap

object Move {
  def apply(
      logger:       Logger[Unit],
      combinedTree: PackageTree,
      instructions: SortedMap[QualifiedName, QualifiedName],
  ): PackageTree = {
    val (moved, appliedInstructions) =
      instructions.foldLeft((combinedTree, IArray.empty[(QualifiedName, QualifiedName)])) {
        case (unchanged @ (acc, accInstructions), newInstruction @ (from, to)) =>
          // skip `outputPackageName`
          val shortenedFrom = from.parts.drop(1)
          extract(shortenedFrom, acc) match {
            case None =>
              logger.warn(s"Couldn't find ${from.parts.mkString(".")}")
              unchanged
            case Some((newTree, extracted)) =>
              // skip `outputPackageName`
              val shortenedTo = to.parts.drop(1)
              inject(shortenedTo, extracted, newTree) match {
                case Left(msg) =>
                  logger.warn(s"Couldn't inject to ${to.parts.mkString(".")}: $msg")
                  unchanged
                case Right(injected) => injected -> (accInstructions :+ newInstruction)
              }
          }
      }

    object ReplacePrefixes extends scalajs.TreeTransformation {
      val replacements: IArray[(IArray[Name], IArray[Name])] =
        appliedInstructions.map { case (from, to) => from.parts -> to.parts }

      override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
        replacements.find { case (from, _) => tr.typeName.parts.startsWith(from) } match {
          case None => tr
          case Some((from, to)) =>
            tr.copy(typeName = QualifiedName(to ++ tr.typeName.parts.drop(from.length)))
        }
    }

    val dummyScope = new TreeScope.Root(Name.dummy, Name.dummy, Map(), logger, false) //not used
    ReplacePrefixes.visitPackageTree(dummyScope)(moved)
  }

  def inject(to: IArray[Name], extracted: IArray[Tree], current: PackageTree): Either[String, PackageTree] =
    (to, extracted) match {
      case (Empty, extracted) =>
        Right(current.copy(members = current.members ++ extracted))

      case (IArray.exactlyOne(head), IArray.exactlyOne(rename: PackageTree)) =>
        Right(current.copy(members = current.members :+ rename.copy(name = head)))

      case (IArray.exactlyOne(head), IArray.exactlyOne(rename: ModuleTree)) =>
        Right(current.copy(members = current.members :+ rename.copy(name = head)))

      case (IArray.headTail(head, tail), extracted) =>
        current.index.get(head) match {
          case None =>
            val next = PackageTree(Empty, head, Empty, NoComments, current.codePath + head)
            inject(tail, extracted, next).map { injected =>
              val newMembers = current.members :+ injected
              current.copy(members = newMembers)
            }

          case Some(IArray.exactlyOne(next: PackageTree)) =>
            inject(tail, extracted, next).map { injected =>
              val newMembers = current.members.map {
                case `next` => injected
                case other  => other
              }
              current.copy(members = newMembers)
            }
          case Some(other) =>
            Left(s"Expected package: got $other")
        }
    }

  def extract[C <: ContainerTree](remaining: IArray[Name], current: C): Option[(C, IArray[Tree])] =
    remaining match {
      case IArray.exactlyOne(head) =>
        current.index.get(head).map { found =>
          val newMembers = current.members.filterNot(_.name === head)
          (current.withMembers(newMembers).asInstanceOf[C], found)
        }
      case IArray.headTail(head, nonEmptyRest) =>
        for {
          next <- current.index.get(head).flatMap(_.collectFirst { case x: ContainerTree => x })
          (newNext, extracted) <- extract(nonEmptyRest, next)
          newMembers = current.members.map {
            case `next` => newNext
            case other  => other
          }
        } yield (current.withMembers(newMembers).asInstanceOf[C], extracted)

      case Empty => None
    }

}
