package org.scalablytyped.converter.internal.scalajs
package flavours

class ScalaJsDomNamesTest extends org.scalatest.funsuite.AnyFunSuite {
  test("check that scalajs-dom names exist and matches expectations") {
    val conversions1 = new ScalaJsDomNames(new QualifiedName.StdNames(Name.std)).All
    val conversions2 = new ScalaJsLibNames(new QualifiedName.StdNames(Name.std)).All

    (conversions1 ++ conversions2).foreach { conversion =>
      ScalaJsClasses.ScalaJsTypes(conversion.to) match {
        case cls: ClassTree =>
          if (conversion.tparams.length != cls.tparams.length)
            fail(s"Conversion $conversion should have had ${cls.tparams.length} tparams ")

        case ta: TypeAliasTree =>
          if (conversion.tparams.length != ta.tparams.length)
            fail(s"Conversion $conversion should have had ${ta.tparams.length} tparams ")
      }
    }
  }
}
