package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.internal.constants

sealed trait PublishLocalTarget {
  def path: os.Path =
    this match {
      case PublishLocalTarget.DefaultIvy2           => constants.defaultLocalPublishFolder
      case PublishLocalTarget.InHomeFolder(relPath) => os.Path(sys.props("user.home")) / relPath
    }
}

object PublishLocalTarget {
  case object DefaultIvy2 extends PublishLocalTarget
  case class InHomeFolder(relPath: os.RelPath) extends PublishLocalTarget
}
