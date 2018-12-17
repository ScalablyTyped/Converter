package com.olvind.tso

import com.olvind.logging.Logger

import scala.collection.immutable.SortedSet

package object phases {
  type IsCircular       = Boolean
  type GetDeps[Id, T]   = SortedSet[Id] => PhaseRes[Id, Map[Id, T]]
  type Phase[Id, T, TT] = (Id, T, GetDeps[Id, TT], IsCircular, Logger[Unit]) => PhaseRes[Id, TT]
}
