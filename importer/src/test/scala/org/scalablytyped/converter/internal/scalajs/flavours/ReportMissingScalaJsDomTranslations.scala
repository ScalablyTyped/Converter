package org.scalablytyped.converter.internal.scalajs
package flavours

object ReportMissingScalaJsDomTranslations extends App {
  val conversions      = new ScalaJsDomNames(new QualifiedName.StdNames(Name.std)).All
  val conversionTarget = conversions.map(_.to).toSet
  val ScalaJsDom       = QualifiedName("org.scalajs.dom")
  val missing = ScalaJsClasses.ScalaJsTypes.collect {
    case (qname, _)
        if qname.startsWith(ScalaJsDom) &&
          !conversionTarget(qname) &&
          !qname.parts.contains(Name("raw")) &&
          !qname.parts.contains(Name("experimental")) &&
          !qname.parts.contains(Name("crypto")) &&
          !qname.parts.contains(Name("svg")) &&
          !qname.parts.contains(Name("html")) &&
          !qname.parts.contains(Name("idb")) &&
          !qname.parts(qname.parts.length - 2).unescaped.head.isUpper =>
      qname
  }

  missing.toList.sortBy(_.parts).foreach(qname => println(qname.parts.map(_.unescaped).mkString(".")))
}
