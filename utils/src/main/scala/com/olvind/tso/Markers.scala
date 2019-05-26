package com.olvind.tso

/* We need a few pieces of out of band information bundled within the tree,
    to be used like annotations. Instead of actually inventing annotations on
    the typescript side we rather just work with special comments.
 */
object Markers {
  case object IsTrivial extends Comment.Data
  case object ExpandedComments extends Comment.Data
  case class NameHint(value: String) extends Comment.Data
}
