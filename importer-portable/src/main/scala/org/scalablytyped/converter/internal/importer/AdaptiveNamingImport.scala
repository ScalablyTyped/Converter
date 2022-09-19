package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName, ScalaJsClasses}
import org.scalablytyped.converter.internal.stringUtils.{joinCamelCase, toCamelCase}
import org.scalablytyped.converter.internal.ts._

import scala.collection.mutable

final class AdaptiveNamingImport(private val rewrites: Map[IArray[TsIdent], QualifiedName]) { self =>
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
  def apply(
      outputPkg:                Name,
      libraryName:              TsIdentLibrary,
      library:                  TsParsedFile,
      depsRewrites:             IArray[AdaptiveNamingImport],
      cleanIllegalNames:        CleanIllegalNames,
      useDeprecatedModuleNames: Boolean,
  ): AdaptiveNamingImport = {
    val allReferences: IArray[IArray[TsIdent]] =
      TsTreeTraverse
        .collect(library) {
          /* we won't output these, so ignore the name collision */
          case x: TsDeclTypeAlias if x.comments.has[Marker.IsTrivial.type] => IArray.Empty
          case x: CodePath.Has                                             => x.codePath.forceHasPath.codePath.parts
        }
        .distinct
        .sorted(ShortestAndLowercaseFirst)

    val registeredReferences =
      mutable.Map[IArray[TsIdent], QualifiedName](IArray.Empty -> QualifiedName(IArray(outputPkg)))

    val lowercaseIndex = mutable.Map.empty[String, IArray[TsIdent]]

    // very obviously a hack. node is the only library seen so far where the shortest module name (`assert`)
    // doesnt correspond to the library name
    if (libraryName.value === "node") {
      lowercaseIndex(s"${outputPkg.unescaped.toLowerCase}.node.mod") = IArray(TsIdentSimple("_____"))
    }

    val illegalNames = (cleanIllegalNames.Illegal ++ ScalaJsClasses.jsObjectMembersByName.keys).map(_.value)

    allReferences.foreach {
      case IArray.Empty => ()
      case whole @ IArray.initLast(parent, current) =>
        val parentTranslated = registeredReferences(parent)
        val variants = variantsFor(
          current,
          parent.exists(_.isInstanceOf[TsIdentModule]),
          parent.collectFirst { case x: TsIdentLibrary => x },
          illegalNames,
          useDeprecatedModuleNames,
        )
        var continue = true
        val iter     = variants.iterator
        while (continue && iter.hasNext) {
          val currentVariant = iter.next()
          val possibleQname  = QualifiedName(parentTranslated.parts :+ Name.necessaryRewrite(Name(currentVariant)))
          val lowercase      = possibleQname.parts.map(_.unescaped).mkString(".").toLowerCase
          lowercaseIndex.get(lowercase) match {
            case Some(`whole`) =>
              continue = false
            case None =>
              registeredReferences.put(parent :+ current, possibleQname)
              lowercaseIndex.put(lowercase, whole)
              continue = false
            case Some(_) =>
              if (!iter.hasNext)
                sys.error(s"Couldn't translate $whole")
          }
        }
    }

    depsRewrites.foreach { x: AdaptiveNamingImport =>
      registeredReferences ++= x.rewrites
    }

    new AdaptiveNamingImport(registeredReferences.toMap)
  }

  def variantsFor(
      tsIdent:                  TsIdent,
      hasModuleParent:          Boolean,
      inLib:                    Option[TsIdentLibrary],
      illegalNames:             Set[String],
      useDeprecatedModuleNames: Boolean,
  ): Stream[String] = {
    val base = tsIdent match {
      case TsIdent.namespaced                          => Stream(Name.namespaced.unescaped)
      case TsIdent.Apply                               => Stream(Name.APPLY.unescaped)
      case TsIdent.Global                              => Stream(Name.global.unescaped, "global_", "global__")
      case TsIdentSimple(value) if illegalNames(value) => Stream(value + "_")
      case TsIdentSimple(value)                        => nameVariants(value)

      case m: TsIdentModule if hasModuleParent => // if this is an augmented module
        /* todo: We should look up what the augmented module is called and reuse it. I don't care enough to do it now */
        nameVariants(joinCamelCase(m.scopeOpt.toList ++ m.fragments)).map(_ + "AugmentingMod")

      case m: TsIdentModule if useDeprecatedModuleNames =>
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

      case m: TsIdentModule =>
        val shortenedFragments = {
          inLib match {
            case Some(TsIdentLibrarySimple(value)) if m.fragments.head == value =>
              m.fragments.drop(1)
            case Some(TsIdentLibraryScoped(scope, name)) if m.scopeOpt.contains(scope) && m.fragments.head == name =>
              m.fragments.drop(1)
            case _ =>
              m.fragments
          }
        }
        Stream(addMod(joinCamelCase(shortenedFragments.map(toCamelCase))))

      case library: TsIdentLibrary => variantsForLibName(library)
      case _:       TsIdentImport  => sys.error("unexpected")
    }

    base #::: base.map(_ + "_") #::: base.map(_ + "__")
  }

  def variantsForLibName(library: TsIdentLibrary) =
    nameVariants(toCamelCase(library.value))
  private def addMod(str: String) = str match {
    case ""       => Name.mod.unescaped
    case nonEmpty => nonEmpty + "Mod"
  }

  /**
    * The point of preferring lowercase is to choose values before types.
    * `interface Console{}; declare console: Console` should become
    * `interface Console_{}; declare console: Console_`
    */
  private val ShortestAndLowercaseFirst: Ordering[IArray[TsIdent]] =
    new Ordering[IArray[TsIdent]] {
      override def compare(one: IArray[TsIdent], two: IArray[TsIdent]): Int = {
        var idx = 0
        while (idx < one.length && idx < two.length) {
          compareStringPreferLower(one(idx).value, two(idx).value) match {
            case 0 => // continue
            case n => return n
          }
          idx += 1
        }

        if (one.length < two.length) -1
        else if (two.length < one.length) 1
        else 0
      }

      /* copied String.compareTo */
      def compareStringPreferLower(v1: String, v2: String): Int = {
        val len1 = v1.length
        val len2 = v2.length
        val lim  = Math.min(len1, len2)
        var k    = 0
        while (k < lim) {
          val c1 = v1(k)
          val c2 = v2(k)

          /* added check to sort lowercase first */
          if (c1.isLower && !c2.isLower) return -1
          else if (c2.isLower && !c1.isLower) return 1

          if (c1 != c2) return c1 - c2

          k += 1
        }
        len1 - len2
      }
    }
}
