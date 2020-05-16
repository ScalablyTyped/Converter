package org.scalablytyped.converter.internal
package scalajs
package flavours

import io.circe013.Decoder
import org.scalablytyped.converter.internal.scalajs.QualifiedName.StdNames
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyGenComponents.names.{
  AnyHtmlElement,
  SlinkyHtmlElement,
  SlinkySvgElement,
}
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyWeb.{CombinedTag, TagName}

object SlinkyTagsLoader {

  def apply(
      stdNames:        StdNames,
      reactNames:      ReactNames,
      scalaJsDomNames: ScalaJsDomNames,
      scope:           TreeScope,
  ): Map[TagName, CombinedTag] = {

    val stdHtmlTags: Map[TagName, TypeRef] = extractStdTags(scope, stdNames.HTMLElementTagNameMap)
    val stdSvgTags:  Map[TagName, TypeRef] = extractStdTags(scope, stdNames.SVGElementTagNameMap)

    val html = combinedTags(
      scope                = scope,
      jsxIntrinsicElements = reactNames.JsxIntrinsicElements,
      stdRefByTag          = stdSvgTags ++ stdHtmlTags,
    )

    val ret = html.groupBy(_.tagName) map { case (name, IArray.first(ct)) => name -> ct }

    val fallbackOpt = scope.lookup(reactNames.AllHTMLAttributes).collectFirst {
      case (_x: ClassTree, newScope) =>
        val x = FillInTParams(_x, newScope, IArray(TypeRef(stdNames.Element)), Empty)

        val parentMembers: IArray[Tree] =
          IArray
            .fromTraversable(ParentsResolver(newScope, x).transitiveParents.values)
            .flatMap(_.members)

        val attrs = parentMembers ++ x.members collect {
          case FieldTree(_, name, Optional(tpe), _, _, _, _, _) if AttrsByTag.AllHtmlAttrs(name.unescaped) =>
            name -> FollowAliases(newScope)(tpe)
          case FieldTree(_, name, tpe, _, _, _, _, _) if AttrsByTag.AllHtmlAttrs(name.unescaped) =>
            name -> FollowAliases(newScope)(tpe)
        }

        CombinedTag(
          TagName.Any,
          AnyHtmlElement,
          TypeRef(stdNames.Element),
          attrs.toMap,
        )
    }

    val withFallback = fallbackOpt.foldLeft(ret) { case (map, ct) => map.updated(TagName.Any, ct) }

    withFallback
  }

  private def extractStdTags(scope: TreeScope, qname: QualifiedName): Map[TagName, TypeRef] =
    scope
      .lookup(qname)
      .collectFirst {
        case (x: ClassTree, _) =>
          x.members.collect { case FieldTree(_, TagName(tag), ref, _, _, _, _, _) => (tag: TagName) -> ref }.toMap
      }
      .getOrElse(sys.error(s"Expected $qname to be a trait"))

  def combinedTags(
      scope:                TreeScope,
      jsxIntrinsicElements: QualifiedName,
      stdRefByTag:          Map[TagName, TypeRef],
  ): IArray[CombinedTag] = {
    def go(newScope: TreeScope, tagName: TagName.Concrete, tagInterfaceRef: TypeRef): Option[CombinedTag] =
      newScope
        .lookup(tagInterfaceRef.typeName)
        .collectFirst {
          case (_ta: TypeAliasTree, newnewScope) =>
            val ta = FillInTParams(_ta, newnewScope, tagInterfaceRef.targs, Empty)
            ta.alias match {
              case TypeRef.Intersection(types) =>
                types
                  .mapNotNone(tpe => go(newnewScope, tagName, tpe))
                  .reduceOption((ct1, ct2) => ct1.copy(attributes = ct1.attributes ++ ct2.attributes))
              case otherwise => go(newnewScope, tagName, otherwise)
            }

          case (_tagInterface: ClassTree, newnewScope) =>
            val tagInterface = FillInTParams(_tagInterface, newnewScope, tagInterfaceRef.targs, Empty)
            val isSvg        = tagInterfaceRef.name.unescaped.contains("SVG")

            val slinkyAttrsByTag = if (isSvg) AttrsByTag.Svg else AttrsByTag.Html
            val stdRef           = stdRefByTag(tagName)
            val (_, attrs)       = slinkyAttrsByTag(tagName)

            val parentMembers: IArray[Tree] =
              IArray
                .fromTraversable(ParentsResolver(newnewScope, tagInterface).transitiveParents.values)
                .flatMap(_.members)

            val members: IArray[(Name, TypeRef)] =
              parentMembers ++ tagInterface.members collect {
                case FieldTree(_, name, Optional(tpe), _, _, _, _, _) if attrs(name.unescaped) =>
                  name -> FollowAliases(newnewScope)(tpe)
                case FieldTree(_, name, tpe, _, _, _, _, _) if attrs(name.unescaped) =>
                  name -> FollowAliases(newnewScope)(tpe)
              }

            val slinkyTagRef = if (isSvg) SlinkySvgElement(tagName) else SlinkyHtmlElement(tagName)

            Some(
              CombinedTag(
                tagName      = tagName,
                slinkyTagRef = slinkyTagRef,
                stdRef       = stdRef,
                attributes   = members.toMap,
              ),
            )
        }
        .flatten

    scope
      .lookup(jsxIntrinsicElements)
      .collectFirst {
        case (tagMap: ClassTree, newScope: TreeScope) =>
          tagMap.members.mapNotNone {
            case FieldTree(_, TagName(tagName), tagInterfaceRef, _, _, _, _, _)
                if AttrsByTag.All.contains(tagName) && stdRefByTag.contains(tagName) =>
              go(newScope, tagName, tagInterfaceRef)
            case _ => None
          }
      }
      .getOrElse(Empty)
  }

  // slinky model
  case class TagsModel(tags: Seq[Tag], attributes: Seq[Attribute])

  // slinky model
  case class Tag(tagName: String, scalaJSType: String, docLines: Seq[String])

  // slinky model
  case class Attribute(
      attributeName:  String,
      attributeType:  String,
      docLines:       Seq[String],
      compatibleTags: Option[Seq[String]],
      withDash:       Boolean,
  ) /* tag, identifier, doc */

  /* extract what we need from the slinky json files */
  type AttrsByTag = Map[TagName.Concrete, (Tag, Set[String])]
  object AttrsByTag {
    private implicit val TagDecoder:       Decoder[Tag]       = io.circe013.generic.semiauto.deriveDecoder[Tag]
    private implicit val AttributeDecoder: Decoder[Attribute] = io.circe013.generic.semiauto.deriveDecoder[Attribute]
    private implicit val TagsModelDecoder: Decoder[TagsModel] = io.circe013.generic.semiauto.deriveDecoder[TagsModel]

    private def massage(model: TagsModel): AttrsByTag =
      model.tags.map { tag =>
        val attrsForTag = model.attributes.collect {
          case Attribute(name, _, _, None, _)                                                        => name
          case Attribute(name, _, _, Some(compatibleTags), _) if compatibleTags contains tag.tagName => name
        }
        TagName.Concrete(tag.tagName) -> ((tag, attrsForTag.toSet))
      }.toMap

    private val HtmlModel = Json.forceResource[TagsModel]("/html.json")
    private val SvgModel  = Json.forceResource[TagsModel]("/svg.json")

    val Html:         AttrsByTag  = massage(HtmlModel)
    val Svg:          AttrsByTag  = massage(SvgModel)
    val All:          AttrsByTag  = Html ++ Svg
    val AllHtmlAttrs: Set[String] = HtmlModel.attributes.map(_.attributeName).toSet
    val AllSvgAttrs:  Set[String] = SvgModel.attributes.map(_.attributeName).toSet
    val AllAttrs:     Set[String] = AllHtmlAttrs ++ AllSvgAttrs
  }
}
