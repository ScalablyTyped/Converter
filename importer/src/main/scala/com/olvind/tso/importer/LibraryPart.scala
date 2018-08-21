package com.olvind.tso
package importer

import com.olvind.tso.ts.{LibTs, TsParsedFile, TsSource}

case class FileAndRefsRec(file: TsParsedFile, pathRefFiles: Seq[FileAndRefsRec])
case class FileAndRefs(file:    TsParsedFile, pathRefFiles: Seq[TsParsedFile]) {
  def toSeq: Seq[TsParsedFile] = file +: pathRefFiles
}

case class LibraryPart(
    file:  FileAndRefsRec,
    parts: Map[TsSource, Either[LibraryPart, LibTs]]
)
