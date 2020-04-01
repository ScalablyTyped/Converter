package org.scalablytyped.converter.internal

object environment {

  val OS: OpSystem.OpSystem = getOperatingSystem()

  object OpSystem extends Enumeration {
    type OpSystem = Value
    val WINDOWS, LINUX, MAC, UNKNOWN = Value
  }

  private def getOperatingSystem(): OpSystem.OpSystem = {
    // detecting the operating system using os.name System property
    val osName = System.getProperty("os.name").toLowerCase

    if (osName.contains("mac")) OpSystem.MAC
    else if (osName.contains("win")) OpSystem.WINDOWS
    else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) OpSystem.LINUX
    else OpSystem.UNKNOWN
  }
}
