/* reimplement parts of os-lib as an im-memory file system */
package object os {

  type Generator[+T] = geny.Generator[T]
  val Generator = geny.Generator

  val root: Path = Path("/")
  val home: Path = root
  val pwd:  Path = root

  val up:  RelPath = RelPath.up
  val rel: RelPath = RelPath.rel

  object / {
    def unapply(p: Path): Option[(Path, String)] =
      if (p.segmentCount != 0) Some((p / up, p.last))
      else None
  }

  def isFile(path: ReadablePath): Boolean = ???

  object read {
    def apply(path: ReadablePath): String = ???

    def bytes(path: ReadablePath): Array[Byte] = ???
  }
  def exists(path: Path): Boolean = ???

  object remove {
    def all(path:   Path): Unit = ???
    def apply(path: Path): Unit = ???
  }

  def walk(
      path:          Path,
      skip:          Path => Boolean = _ => false,
      preOrder:      Boolean = true,
      followLinks:   Boolean = false,
      maxDepth:      Int = Int.MaxValue,
      includeTarget: Boolean = false,
  ): IndexedSeq[Path] = ???

  object makeDir {
    def all(path: Path): Unit = ???
  }
}
