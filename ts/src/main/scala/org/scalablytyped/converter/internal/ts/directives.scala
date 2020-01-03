package org.scalablytyped.converter.internal
package ts

sealed trait Directive

case object DirectiveNoStdLib extends Directive

sealed trait DirectiveRef extends Directive {
  def stringPath: String
}

/**
  * The path in
  * /// <reference path="../bluebird/bluebird-2.0.d.ts" />
  */
final case class DirectivePathRef(stringPath: String) extends DirectiveRef

/**
  * The types ref in
  * /// <reference types="react" />
  */
final case class DirectiveTypesRef(stringPath: String) extends DirectiveRef

/**
  * The ref in
  * /// <reference lib="esnext" />
  */
final case class DirectiveLibRef(stringPath: String) extends DirectiveRef

/**
  * The ref in
  * /// <reference lib="esnext" />
  */
final case class AmdModule(stringPath: String) extends DirectiveRef
