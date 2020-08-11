---
id: remotecache
title: Remote cache
---

The whole conversion and compilation process is unfortunately pretty slow. 
To alleviate this there is an option to use a remote cache, where all necessary files are transferred to a remote server where it can be pulled later. 
Think of it like a maven repo with transient libraries, where if they are not found the plugin will automatically rebuild them locally.

You publish cache by running `stPublishCache` in sbt, and this is something you could do both locally or in CI.
Cache is automatically pulled when necessary if it is setup.

### S3

The best alternative is to use S3, through AWS or elsewhere.

Credentials will be picked up from a [range of locations](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/credentials.html),
 or you can provide them explicitly.

#### AWS

```scala
Global / stRemoteCache := RemoteCache.S3Aws(
  bucket = "scalablytyped-demos", 
  region = "eu-central-1", 
  prefix = Some("st-cache")
)
```

#### Elsewhere

You'll typically override `endpoint`, and you'll have to compute the public URI (`pull`) yourself.

```scala
Global / stRemoteCache := RemoteCache.S3(
  bucket = "my-bucket", 
  pull = "https://my-bucket.https://fra1.digitaloceanspaces.com/scalablytyped"
).withEndpoint("https://fra1.digitaloceanspaces.com")
 .withStaticCredentials("myAccessKey", "mySecretKey")
 .withRegion("eu-central-1")
 .withPrefix("scalablytyped")

```


### Rsync

The other alternative if you have a running server and want to avoid using S3 is to use rsync.

This is how you set it up:
```scala
Global / stRemoteCache := RemoteCache.Rsync(
  push = "user@server.com:/path/to/st/cache", 
  pull = new java.net.URI("https://server.com/path/to/st/cache")
)
```

The first parameter specifies where files will be uploaded, and the second how to reach the files through http. 
Pushing requires access through ssh keys, while typically anybody can pull files.

