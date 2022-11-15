package org.scalablytyped.converter.internal.importer

import com.olvind.logging.Logger
import sourcecode.{Enclosing, File, Line}

import java.nio.file.Path
import scala.sys.process.{BasicIO, Process, ProcessIO}

// todo: replicated in bleep
object cli {
  sealed trait WrittenLine
  object WrittenLine {
    case class StdErr(line: String) extends WrittenLine
    case class StdOut(line: String) extends WrittenLine
  }

  case class WrittenLines(combined: Array[WrittenLine]) {
    def stdout: Array[String] = combined.collect { case WrittenLine.StdOut(line) => line }
    def stderr: Array[String] = combined.collect { case WrittenLine.StdErr(line) => line }
  }

  sealed trait StdIn
  object StdIn {
    case object No extends StdIn
    case object Attach extends StdIn
    case class Provided(data: Array[Byte]) extends StdIn
  }

  case class CliLogger(logger: Logger[_])(implicit l: Line, f: File, e: Enclosing) {
    def apply(writtenLine: WrittenLine): Unit =
      writtenLine match {
        case WrittenLine.StdErr(line) =>
          logger.warn(line)(implicitly, l, f, e)
        case WrittenLine.StdOut(line) =>
          logger.info(line)(implicitly, l, f, e)
      }
  }

  def apply(
      action:    String,
      cwd:       Path,
      cmd:       List[String],
      cliLogger: CliLogger,
      stdIn:     StdIn = StdIn.No,
      env:       List[(String, String)] = Nil,
  ): Either[WrittenLines, WrittenLines] = {
    val process = Process {
      val builder = new java.lang.ProcessBuilder(cmd: _*)
      builder.directory(cwd.toFile)
      builder.environment().clear()
      env.foreach { case (k, v) => builder.environment.put(k, v) }
      builder
    }

    val output = Array.newBuilder[WrittenLine]

    val processIO = new ProcessIO(
      writeInput = os =>
        stdIn match {
          case StdIn.No     => ()
          case StdIn.Attach => BasicIO.connectToIn(os)
          case StdIn.Provided(data) =>
            os.write(data)
            os.close()
        },
      processOutput = BasicIO.processFully { line =>
        val stdOut = WrittenLine.StdOut(line)
        output += stdOut
        cliLogger(stdOut)
      },
      processError = BasicIO.processFully { line =>
        val stdErr = WrittenLine.StdErr(line)
        output += stdErr
        cliLogger(stdErr)
      },
      daemonizeThreads = false,
    )

    val exitCode = process.run(processIO).exitValue()

    exitCode match {
      case 0 => Right(WrittenLines(output.result()))
      case n =>
        cliLogger.logger
          .withContext(action)
          .withContext(cwd.toString)
          .withContext(cmd)
          .withContext(env)
          .debug(s"Failed external command with error code $n")
        Left(WrittenLines(output.result()))
    }
  }
}
