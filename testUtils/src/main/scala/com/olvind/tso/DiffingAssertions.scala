package com.olvind.tso

import org.scalactic.{CanEqual, TypeCheckedTripleEquals}
import org.scalatest.{Assertion, Assertions}

trait DiffingAssertions extends Assertions with TypeCheckedTripleEquals {

  def shouldEqual[L, R](expected: L)(actual: R)(implicit ev: CanEqual[L, R]): Assertion =
    assert(expected === actual)
}
