package org.scalablytyped.converter.internal.importer.build

import org.scalatest.funsuite.AnyFunSuite
import scala.concurrent.ExecutionContext.Implicits.global

import org.scalatest.Ignore

@Ignore // Disabled to avoid downloading binaries in CI
class ScalaCliCompilerTest extends AnyFunSuite {

  val testVersion  = ScalaCliCompiler.DefaultScalaCliVersion
  val testCacheDir = os.temp.dir() / "scala-cli-test"

  test("verify current system os.name and os.arch") {
    val osName = System.getProperty("os.name")
    val osArch = System.getProperty("os.arch")
    println(s"Current system: os.name='$osName', os.arch='$osArch'")
    assert(osName.nonEmpty)
    assert(osArch.nonEmpty)
  }

  private def verifyBinary(targetPath: os.Path): Unit = {
    assert(os.exists(targetPath), s"Binary should exist at $targetPath")
    assert(os.isFile(targetPath), s"$targetPath should be a file")

    // Verify executable permission is set
    assert(targetPath.toIO.canExecute, s"$targetPath should have executable permission (+x)")

    // Also verify using os.perms for more detailed check
    val perms           = os.perms(targetPath)
    val ownerCanExecute = (perms.value & 0x40) != 0 // 0100 octal = 0x40 hex = 64 decimal
    assert(
      ownerCanExecute,
      s"$targetPath should have owner execute permission (current perms: ${perms.value.toOctalString})",
    )

    // Verify it's actually a binary, not a gzipped file
    val firstBytes = os.read.bytes(targetPath, offset = 0, count = 4)
    assert(
      firstBytes(0) != 0x1f.toByte || firstBytes(1) != 0x8b.toByte,
      s"$targetPath appears to still be gzipped (magic bytes: 0x1f8b)",
    )

    // Check for common executable magic numbers
    val isMachO = (firstBytes(0) == 0xcf.toByte && firstBytes(1) == 0xfa.toByte) || // Mach-O 64-bit
      (firstBytes(0) == 0xce.toByte && firstBytes(1) == 0xfa.toByte) || // Mach-O 32-bit
      (firstBytes(0) == 0xca.toByte && firstBytes(1) == 0xfe.toByte) // Mach-O fat binary
    val isELF = firstBytes(0) == 0x7f.toByte && firstBytes(1) == 'E'.toByte &&
      firstBytes(2) == 'L'.toByte && firstBytes(3) == 'F'.toByte
    val isShebang = firstBytes(0) == '#'.toByte && firstBytes(1) == '!'.toByte
    val isPE      = firstBytes(0) == 'M'.toByte && firstBytes(1) == 'Z'.toByte // Windows PE

    assert(
      isMachO || isELF || isShebang || isPE,
      s"$targetPath doesn't appear to be a valid executable (first bytes: ${firstBytes.map("%02x".format(_)).mkString(" ")})",
    )
  }

  test("download scala-cli for macOS x86_64") {
    val resultFuture = ScalaCliCompiler.downloadScalaCli(
      osName   = "Mac OS X",
      osArch   = "x86_64",
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath = scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    verifyBinary(targetPath)
  }

  test("download scala-cli for macOS aarch64") {
    val resultFuture = ScalaCliCompiler.downloadScalaCli(
      osName   = "Mac OS X",
      osArch   = "aarch64",
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath = scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    verifyBinary(targetPath)
  }

  test("download scala-cli for Linux x86_64") {
    val resultFuture = ScalaCliCompiler.downloadScalaCli(
      osName   = "Linux",
      osArch   = "x86_64",
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath = scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    verifyBinary(targetPath)
  }

  test("download scala-cli for Linux aarch64") {
    val resultFuture = ScalaCliCompiler.downloadScalaCli(
      osName   = "Linux",
      osArch   = "aarch64",
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath = scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    verifyBinary(targetPath)
  }

  test("download scala-cli for Windows x86_64") {
    val resultFuture = ScalaCliCompiler.downloadScalaCli(
      osName   = "Windows 10",
      osArch   = "amd64", // Test with "amd64" which should normalize to "x86_64"
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath = scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    verifyBinary(targetPath)
  }

  test("handle architecture normalization") {
    // Test that both "amd64" and "x86_64" work for Linux
    val resultFuture1 = ScalaCliCompiler.downloadScalaCli(
      osName   = "Linux",
      osArch   = "amd64", // Should normalize to x86_64
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath1 = scala.concurrent.Await.result(resultFuture1, scala.concurrent.duration.Duration.Inf)
    assert(os.exists(targetPath1))

    // Test that "arm64" normalizes to "aarch64" for macOS
    val resultFuture2 = ScalaCliCompiler.downloadScalaCli(
      osName   = "Mac OS X",
      osArch   = "arm64", // Should normalize to aarch64
      version  = testVersion,
      cacheDir = testCacheDir,
    )
    val targetPath2 = scala.concurrent.Await.result(resultFuture2, scala.concurrent.duration.Duration.Inf)
    assert(os.exists(targetPath2))
  }

  test("fail for unsupported OS") {
    assertThrows[RuntimeException] {
      val resultFuture = ScalaCliCompiler.downloadScalaCli(
        osName   = "FreeBSD",
        osArch   = "x86_64",
        version  = testVersion,
        cacheDir = testCacheDir,
      )
      scala.concurrent.Await.result(resultFuture, scala.concurrent.duration.Duration.Inf)
    }
  }
}
