package org.scalablytyped.converter.plugin

import java.net.URI

sealed trait RemoteCache

object RemoteCache {
  case object Disabled extends RemoteCache

  /**
    * @param push location for rsync push, format: user@server:/directory . You'll need to be able to log in to the server with ssh keys
    * @param pull location for http pull, format https://server/directory
    *
    * The "directory" above will contain two folders after sync: `runs` and `org.scalablytyped`
    */
  case class Rsync(push: String, pull: URI) extends RemoteCache
}
