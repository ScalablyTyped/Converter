package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName}
import org.scalablytyped.converter.internal.stringUtils.{joinCamelCase, toCamelCase}
import org.scalablytyped.converter.internal.ts._

import scala.collection.mutable

final class AdaptiveNamingImport(private val rewrites: Map[IArray[TsIdent], QualifiedName]) {
  def unapply(qident: TsQIdent): Some[QualifiedName] =
    Some(apply(qident))

  def apply(qident: TsQIdent): QualifiedName =
    qident match {
      /* hack/shortcut: all qualified idents are fully qualified, which means only abstract things should have length one */
      case TsQIdent(IArray.exactlyOne(one: TsIdentSimple)) => QualifiedName(IArray(ImportName(one)))
      case TsQIdent(parts) if rewrites.contains(parts) => rewrites(parts)
      /* this branch is mostly for enum members now, which don't have codepaths */
      case TsQIdent(IArray.initLast(parent, current: TsIdentSimple)) => rewrites(parent) + ImportName(current)
    }

  def apply(cp: CodePath): QualifiedName =
    apply(cp.forceHasPath.codePath)
}

object AdaptiveNamingImport {
  def apply(outputPkg: Name, tree: TsTree, depsRewrites: IArray[AdaptiveNamingImport]): AdaptiveNamingImport = {
    val allReferences: IArray[IArray[TsIdent]] =
      TsTreeTraverse
        .collect(tree) { case x: HasCodePath => x.codePath.forceHasPath.codePath.parts }
        .distinct
        .sorted(ShortestFirst)

    val registeredReferences =
      mutable.Map[IArray[TsIdent], QualifiedName](IArray.Empty -> QualifiedName(IArray(outputPkg)))
    val lowercaseIndex = mutable.Map.empty[String, IArray[TsIdent]]

    allReferences.foreach {
      case IArray.Empty => ()
      case whole @ IArray.initLast(parent, current) =>
        val parentTranslated = registeredReferences(parent)
        val variants         = variantsFor(current, parent.exists(_.isInstanceOf[TsIdentModule]))
        var continue         = true
        val iter             = variants.iterator
        while (continue && iter.hasNext) {
          val currentVariant = iter.next()
          val possibleQname  = QualifiedName(parentTranslated.parts :+ Name.necessaryRewrite(Name(currentVariant)))
          val lowercase      = possibleQname.parts.map(_.unescaped).mkString(".").toLowerCase
          lowercaseIndex get lowercase match {
            case Some(`whole`) =>
              continue = false
            case None =>
              registeredReferences.put(parent :+ current, possibleQname)
              lowercaseIndex.put(lowercase, whole)
              continue = false
            case Some(_) =>
          }
        }
    }

    depsRewrites.foreach { x: AdaptiveNamingImport =>
      registeredReferences ++= x.rewrites
    }

    new AdaptiveNamingImport(registeredReferences.toMap)
  }

  def variantsFor(tsIdent: TsIdent, hasModuleParent: Boolean): Stream[String] = {
    val base = tsIdent match {
      case TsIdent.namespaced   => Stream(Name.namespaced.unescaped)
      case TsIdent.Apply        => Stream(Name.APPLY.unescaped)
      case TsIdent.Global       => Stream(TsIdent.Global.value)
      case TsIdentSimple(value) => nameVariants(value)

      case m: TsIdentModule if hasModuleParent => // if this is an augmented module
        /* todo: We should look up what the augmented module is called and reuse it. I don't care enough to do it now */
        nameVariants(joinCamelCase(m.scopeOpt.toList ++ m.fragments)).map(_ + "AugmentingMod")

      case m: TsIdentModule =>
        val increasingLength: Stream[List[String]] = {
          val (libraryBits, moduleBits) =
            m match {
              case TsIdentModule(Some(scope), head :: tail) => (List(scope + head.capitalize), tail)
              case TsIdentModule(None, head :: tail)        => (List(head), tail)
            }

          val withoutLibrary = Stream(Nil) #::: moduleBits.indices.toStream.map(n => moduleBits.takeRight(n + 1))

          val withLibrary = withoutLibrary.map(ss => libraryBits ::: ss)

          withoutLibrary #::: withLibrary
        }

        val preferCamelCase: Stream[List[String]] = {
          val unCamelCased = increasingLength.filter(_.exists(str => str.contains("-") || str.contains("_")))
          increasingLength.map(_.map(toCamelCase)) ++ unCamelCased
        }

        preferCamelCase.flatMap(frags => nameVariants(addMod(joinCamelCase(frags))))

      case library: TsIdentLibrary =>
        nameVariants(toCamelCase(library.value))

      case _: TsIdentImport => sys.error("unexpected")
    }

    base #::: base.map(_ + "_")
  }

  private def addMod(str: String) = str match {
    case ""       => "mod"
    case nonEmpty => nonEmpty + "Mod"
  }

  private val ShortestFirst: Ordering[IArray[TsIdent]] =
    new Ordering[IArray[TsIdent]] {
      override def compare(one: IArray[TsIdent], two: IArray[TsIdent]): Int = {
        var idx = 0
        while (idx < one.length && idx < two.length) {
          one(idx).value.compareTo(two(idx).value) match {
            case 0 => // continue
            case n => return n
          }
          idx += 1
        }

        if (one.length < two.length) -1
        else if (two.length < one.length) 1
        else 0
      }
    }
}
