package org.scalablytyped.converter.internal
package ts

import com.olvind.logging
import com.olvind.logging.Logger
import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.importer.Phase1ReadTypescript
import org.scalablytyped.converter.internal.ts.parser.TsParser
import org.scalablytyped.converter.internal.ts.transforms.SetCodePath
import org.scalablytyped.converter.internal.ts.parser.ParserHarness._
import scala.reflect.ClassTag
import scala.util.control.NonFatal

trait TypeExpansionHarness {
  val libName = TsIdentLibrarySimple("testing")

  def Transformations(logger: Logger[Unit]): List[TsParsedFile => TsParsedFile] =
    Phase1ReadTypescript.Pipeline(
      scope              = TsTreeScope(libName, pedantic = true, Map(), logger),
      libName            = libName,
      expandTypeMappings = Selection.All,
      involvesReact      = true,
    )

  def run(input: String): TsParsedFile = {
    val parsed       = TsParser.parsedTsFile(input).get
    val logger       = logging.stringWriter()
    val withCodePath = SetCodePath.visitTsParsedFile(CodePath.HasPath(libName, TsQIdent.empty))(parsed)

    try Transformations(logger.void).foldLeft(withCodePath) { case (acc, f) => f(acc) } catch {
      case NonFatal(th) =>
        println(logger.underlying.toString)
        throw th
    }
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
