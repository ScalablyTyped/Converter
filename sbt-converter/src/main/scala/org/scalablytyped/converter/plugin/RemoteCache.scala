package org.scalablytyped.converter.plugin

import java.net.URI

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region

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

  case class S3(
      push: S3.PushConfiguration,
      pull: URI,
  ) extends RemoteCache

  object S3 {
    case class PushConfiguration(
        bucket:              String,
        prefix:              Option[String] = None,
        region:              Option[Region] = None,
        endpointOverride:    Option[URI] = None,
        credentialsProvider: Option[AwsCredentialsProvider] = None,
    )
  }
}
