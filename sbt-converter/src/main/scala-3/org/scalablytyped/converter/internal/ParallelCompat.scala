package org.scalablytyped.converter.internal

import scala.collection.parallel.CollectionConverters._

// In Scala 2.13+, we need the parallel collections library
object ParallelCompat {
  implicit class ParOps[A](seq: Seq[A]) {
    def parMap[B](f: A => B): Seq[B] = seq.par.map(f).seq
  }
}
