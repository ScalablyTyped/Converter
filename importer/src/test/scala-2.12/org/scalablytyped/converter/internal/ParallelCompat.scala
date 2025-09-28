package org.scalablytyped.converter.internal

// In Scala 2.12, parallel collections are built-in, no import needed
object ParallelCompat {
  implicit class ParOps[A](seq: Seq[A]) {
    def parMap[B](f: A => B): Seq[B] = seq.par.map(f).seq
  }
}
