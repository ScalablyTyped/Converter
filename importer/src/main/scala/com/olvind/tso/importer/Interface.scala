package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.phases.PhaseListener
import com.olvind.tso.ts.TsIdentLibrary
import fansi.Color
import monix.execution.atomic.AtomicBoolean

import scala.collection.mutable
import scala.util.Try

class Interface(debugMode: Boolean, storingErrorLogger: Logger[Array[Logger.Stored]])
    extends Thread
    with PhaseListener[Source] {

  import PhaseListener._
  private val t0     = System.currentTimeMillis
  private val files  = mutable.Set.empty[InFile]
  private val status = mutable.Map.empty[TsIdentLibrary, Event[Source]]

  private def failed    = status.collect { case (lib, x: Failure[Source]) => (lib, x) }
  private def ignored   = status.collect { case (lib, _: Ignored[Source]) => lib }
  private def active    = status.collect { case (lib, x: Started[Source]) => (lib, x) }
  private def blocked   = status.collect { case (lib, x: Blocked[Source]) => (lib, x) }
  private def succeeded = status.collect { case (lib, x: Success[Source]) => lib -> x }
  private val hasExited = AtomicBoolean(false)

  def finish(): Summary = {
    require(blocked.isEmpty)
    require(active.isEmpty)
    hasExited.set(true)
    Summary(succeeded.keys.to[Set], failed.keys.to[Set])
  }

  override def on(phaseName: String, id: Source, event: PhaseListener.Event[Source]): Unit =
    synchronized {
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

    def row[N: Numeric](title: String, num: N): Unit =
      println(fansi.Str.join(title, ": ", fansi.Bold.On(num.toString)).render)

    row("Successes", numSucceded)
    row("Failed", numFailed)
    row("Ignored", numIgnored)
    row("Files", numFiles)
    row("Seconds elapsed", td)
    row("Seconds per library", processedPerSecond)

    println("Active:")
    active.to[Seq].map(x => (Color.Green(x._1.value).render, x._2.phase)).sorted.foreach(x => println(x.toString))

    println("Blocked:")
    blocked
      .to[Seq]
      .map {
        case (name, Blocked(phase, on)) =>
          s"${Color.LightGray(name.value).render} ($phase) blocked on ${on.map(_.libName) -- succeeded.keys map (_.value)}"
      }
      .sorted
      .foreach(println)

    println("Last ten errors: ")
    storingErrorLogger.underlying.takeRight(10).foreach { stored =>
      println(
        stored.ctx.get("id").fold("")(Color.Red(_).render + ": ") + stored.message.render
          .takeWhile(_ =/= '\n')
          .take(200),
      )
    }
    System.out.println(sb)
  }
}
