package org.scalablytyped.converter.plugin

import java.net.URI

import software.amazon.awssdk.auth.credentials.{AwsBasicCredentials, AwsCredentialsProvider, StaticCredentialsProvider}
import software.amazon.awssdk.regions.Region

sealed trait RemoteCache

object RemoteCache {
  case object Disabled extends RemoteCache

  /** @param push location for rsync push, format: user@server:/directory . You'll need to be able to log in to the server with ssh keys
    * @param pull location for http pull, format https://server/directory
    *
    *             The "directory" above will contain two folders after sync: `runs` and `org.scalablytyped`
    */
  case class Rsync(push: String, pull: URI) extends RemoteCache

  /** @param bucket              target bucket
    * @param pull                location for http pull, format https://server/directory
    * @param prefix              optional prefix where to store the artifacts, using / as separator (https://docs.aws.amazon.com/AmazonS3/latest/user-guide/using-folders.html). Without leading or tailing /
    * @param region              optional region (e.g. `eu-central-1`)
    * @param endpoint            optional endpoint override, useful e.g. for non-AWS S3 endpoints like DigitalOcean (e.g. `https://fra1.digitaloceanspaces.com`)
    * @param credentialsProvider optional credentialsProvider, if not set the DefaultCredentialsProvider is used (https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/credentials.html)
    *
    * It is recommended to use the Builder, e.g. :
    * {{{
    * S3("my-bucket", "https://my-bucket.s3.aws.amazon.com/scalablytyped")
    *   .withStaticCredentials("myAccessKey", "mySecretKey")
    *   .withRegion("eu-central-1")
    *   .withPrefix("scalablytyped")
    * }}}
    *
    * The "bucket/prefix" will contain two prefixes after sync: `runs` and `org.scalablytyped`
    */
  case class S3(
      bucket:              String,
      pull:                URI,
      prefix:              Option[String],
      region:              Option[Region],
      endpoint:            Option[URI],
      credentialsProvider: Option[AwsCredentialsProvider],
  ) extends RemoteCache {
    def withPrefix(prefix: String) = copy(prefix = Some(prefix))

    def withEndpoint(endpoint: String) = copy(endpoint = Some(new URI(endpoint)))

    def withRegion(region: String) = copy(region = Some(Region.of(region)))

    def withAwsRegion(region: Region) = copy(region = Some(region))

    def withStaticCredentials(accessKey: String, secretKey: String) =
      copy(credentialsProvider =
        Some(
          StaticCredentialsProvider.create(
            AwsBasicCredentials.create(
              accessKey,
              secretKey,
            ),
          ),
        ),
      )

    def withAwsCredentialsProvider(awsCredentialsProvider: AwsCredentialsProvider) =
      copy(credentialsProvider = Some(awsCredentialsProvider))
  }

  object S3 {
    def apply(bucket: String, pull: URI): S3 = S3(bucket, pull, None, None, None, None)
  }

  /** If you use AWS S3 this will derive the URI from where data will be pulled
    */
  def S3Aws(bucket: String, region: String, prefix: Option[String] = None): S3 = {
    val awsRegion = Region.of(region)
    val pull = prefix.foldLeft(s"https://$bucket.s3.${awsRegion.id()}.amazonaws.com") { case (base, prefix) =>
      s"$base/$prefix"
    }
    S3(
      bucket = bucket,
      pull = new URI(pull),
      prefix = prefix,
      region = Some(awsRegion),
      endpoint = None,
      credentialsProvider = None,
    )
  }
}
