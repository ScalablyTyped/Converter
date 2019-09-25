package com.olvind.tso.ts.parser

import com.olvind.logging
import com.olvind.tso.importer.Phase1ReadTypescript
import com.olvind.tso.ts.transforms.SetCodePath
import com.olvind.tso.ts._

import scala.reflect.ClassTag

trait TypeExpansionHarness  {
  val parser  = new TsParser(None)
  val libName = TsIdentLibrarySimple("testing")

  val Transformations: List[TsParsedFile => TsParsedFile] = {
    Phase1ReadTypescript.Pipeline(
      scope                    = TsTreeScope(libName, pedantic = true, Map(), logging.stdout),
      libName                  = libName,
      enableExpandTypeMappings = true,
      involvesReact    = true,
    )
  }

  def run(input: String): TsParsedFile = {
    val parsed       = parser(input).get
    val withCodePath = SetCodePath.visitTsParsedFile(CodePath.HasPath(libName, TsQIdent.empty))(parsed)

    Transformations.foldLeft(withCodePath) { case (acc, f) => f(acc) }
  }

  implicit class Extractor(x: TsParsedFile) {
    def extract[T: ClassTag](name: String): T =
      x.membersByName.get(TsIdentSimple(name)) match {
        case Some(ofName) =>
          val ofType = ofName.collectFirst { case x: T => x }
          ofType match {
            case Some(found) => found
            case None        => sys.error(s"Could not find ${implicitly[ClassTag[T]].runtimeClass} among $ofType")
          }
        case None => sys.error(s"No member with name $name among ${x.membersByName.keys}")
      }
  }
}
