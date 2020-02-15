package org.scalablytyped.converter.internal
package importer
package build

import org.scalablytyped.converter.internal.scalajs.Dep

trait Compiler {
  def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Set[Compiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit]
}

object Compiler {
  sealed trait InternalDep
  case class InternalDepClassFiles(name: String, path: os.Path) extends InternalDep
  case class InternalDepJar(path:        os.Path) extends InternalDep
}
