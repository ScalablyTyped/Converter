package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.phases.PhaseListener
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import fansi.Color
import monix.execution.atomic.AtomicBoolean

import scala.collection.mutable
import scala.util.Try

object Interface {
  def apply[T](debugMode: Boolean)(f: PhaseListener[Source] => T) = {
    val i = new Interface(debugMode)
    i.start()
    try {
      f(i)
    } finally {
      i.finish()
    }
  }

  private class Interface(debugMode: Boolean) extends Thread with PhaseListener[Source] {

    import PhaseListener._
    private val t0     = System.currentTimeMillis
    private val files  = mutable.Set.empty[InFile]
    private val status = mutable.Map.empty[TsIdentLibrary, Event[Source]]
    private var failed = List.empty[(TsIdentLibrary, Failure[Source])]

    private def ignored   = status.collect { case (lib, _: Ignored[Source]) => lib }
    private def active    = status.collect { case (lib, x: Started[Source]) => (lib, x) }
    private def blocked   = status.collect { case (lib, x: Blocked[Source]) => (lib, x) }
    private def succeeded = status.collect { case (lib, x: Success[Source]) => lib -> x }
    private val hasExited = AtomicBoolean(false)

    def finish(): Unit = {
      require(blocked.isEmpty)
      require(active.isEmpty)
      hasExited.set(true)
    }

    override def on(phaseName: String, id: Source, event: PhaseListener.Event[Source]): Unit =
      synchronized {
        event match {
          case fail @ Failure(_, _) =>
            failed = (id.libName -> fail) :: failed.filterNot(_._1 === id.libName)
          case _ => ()
        }

        id match {
          case Source.TsHelperFile(file, _, _) =>
            files += file
          case x: Source =>
            status(x.libName) = event
        }
        ()
      }

    override def run(): Unit =
      if (!debugMode) {
        while (!hasExited.get) {
          render()
          Try(Thread.sleep(1000))
        }
      }

    def render(): Unit = {
      val sb = new StringBuffer()
      def println(s: String) = sb.append(s).append("\n")

      val numSucceded        = succeeded.size
      val numFailed          = failed.size
      val numIgnored         = ignored.size
      val numFiles           = files.size
      val td                 = (System.currentTimeMillis() - t0) / 1000.0
      val numProcessed       = numFailed + numSucceded
      val processedPerSecond = td / numProcessed
      //reset terminal
      println("\u001b[2J")
      //move cursor to start of screen
      println("\u001b[H")

      def row[N: Numeric](title: String, num: N) =
        println(fansi.Str.join(title, ": ", fansi.Bold.On(num.toString)).render)

      row("Successes", numSucceded)
      row("Failed", numFailed)
      row("Ignored", numIgnored)
      row("Files", numFiles)
      row("Seconds elapsed", td)
      row("Seconds per library", processedPerSecond)

      println("Active:")
      active.to[Vector].map(x => (Color.Green(x._1.value).render, x._2.phase)).sorted.foreach(x => println(x.toString))

      println("Blocked:")
      blocked
        .to[Vector]
        .map {
          case (name, Blocked(phase, on)) =>
            s"${Color.LightGray(name.value).render} ($phase) blocked on ${(on.map(_.libName) -- succeeded.keys).map(_.value)}"
        }
        .sorted
        .foreach(println)

      val n = math.min(10, failed.size)
      println(s"Last $n errors: ")

      failed.take(n).foreach {
        case (lib, failure) =>
          val errorStrings = failure.errors
            .map {
              case (lib: Source.TsLibSource, Left(th)) =>
                s"dependency ${lib.libName.value} failed ${th.getClass.getSimpleName}: ${th.getMessage}"
              case (lib: Source.TsLibSource, Right(str)) =>
                s"dependency ${lib.libName.value} failed: $str"
              case (file: Source.TsHelperFile, _) if file.inLib.libName =/= lib =>
                s"dependency ${file.inLib.libName.value} failed"
              case (file: Source.TsHelperFile, Left(th)) =>
                s"file ${file.file.path} failed ${th.getClass.getSimpleName}: ${th.getMessage}"
              case (file: Source.TsHelperFile, Right(str)) =>
                s"file ${file.file.path} failed $str"
            }

          val errorMsg = errorStrings
            .map(_.takeWhile(_ =/= '\n'))
            .toVector
            .distinct
            .mkString(", ")

          println(s"${Color.Red(lib.value)}: $errorMsg")
      }

      System.out.println(sb)
    }
  }
}
