package com.olvind.tso
package ts

object ModuleNameParser {
  def apply(lit: TsLiteralString): TsIdentModule = apply(lit.value.split("/").toList)

  def apply(fragments: List[String]): TsIdentModule = {
    val rewritten: List[String] =
      fragments.flatMap {
        case f if f.startsWith("~") => List(f.drop(1))
        case f if f === "@types"    => Nil
        case f if f.contains("__") =>
          val Array(one, two) = f.split("__")
          List("@" + one, two)
        case "index" | "index.d.ts"   => Nil
        case f if f.endsWith(".d.ts") => List(f.replaceAll(".d.ts", ""))
        case f if f.endsWith(".ts")   => List(f.replaceAll(".ts", ""))
        case f                        => List(f)
      }

    rewritten match {
      case Nil => sys.error("Unexpected empty module name")
      /* relative module names handled in ResolveExternalReferences */
      case head :: _ if head.startsWith(".")      => TsIdentModule(None, fragments)
      case scope :: rest if scope.startsWith("@") => TsIdentModule(Some(scope.drop(1)), rest)
      case all                                    => TsIdentModule(None, all)
    }
  }
}
