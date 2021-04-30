package org.scalablytyped.converter.internal
package ts

sealed trait Directive

object Directive {
  case object NoStdLib extends Directive

  sealed trait Ref extends Directive {
    def stringPath: String
  }

  /**
    * The path in
    * /// <reference path="../bluebird/bluebird-2.0.d.ts" />
    */
  final case class PathRef(stringPath: String) extends Ref

  /**
    * The types ref in
    * /// <reference types="react" />
    */
  final case class TypesRef(stringPath: String) extends Ref

  /**
    * The ref in
    * /// <reference lib="esnext" />
    */
  final case class LibRef(stringPath: String) extends Ref

  /**
    * The ref in
    * /// <reference lib="esnext" />
    */
  final case class AmdModule(stringPath: String) extends Ref

}
