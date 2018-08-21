package com.olvind.tso

import com.olvind.logging.Logger

package object phases {
  type IsCircular       = Boolean
  type GetDeps[Id, T]   = Set[Id] => PhaseRes[Id, Map[Id, T]]
  type Phase[Id, T, TT] = (Id, T, GetDeps[Id, TT], IsCircular, Logger[Unit]) => PhaseRes[Id, TT]
}
