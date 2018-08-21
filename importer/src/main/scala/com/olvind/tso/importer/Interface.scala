package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.phases.PhaseListener
import com.olvind.tso.ts.TsSource
import fansi.{Color, Str}
import monix.execution.atomic.AtomicBoolean

import scala.collection.mutable
import scala.util.Try

class Interface(debugMode: Boolean, storingErrorLogger: Logger[Array[Logger.Stored]])
    extends Thread
    with PhaseListener[TsSource] {
  private val t0        = System.currentTimeMillis
  private val files     = mutable.Set.empty[InFile]
  private val succeeded = mutable.Map.empty[TsSource.TsLibSource, String]
  private val failed    = mutable.Map.empty[TsSource.TsLibSource, String]
  private val ignored   = mutable.Set.empty[TsSource.TsLibSource]
  private val active    = mutable.Map.empty[TsSource.TsLibSource, String]
  private val blocked   = mutable.Map.empty[TsSource.TsLibSource, (String, Set[Str])]
  private val hasExited = AtomicBoolean(false)

  def finish(): Summary = {
    require(blocked.isEmpty)
    require(active.isEmpty)
    hasExited.set(true)
    Summary(succeeded.keys.to[Set], failed.keys.to[Set])
  }

  override def on(phaseName: String, id: TsSource, event: PhaseListener.Event): Unit =
    synchronized {
      id match {
        case TsSource.HelperFile(file, _, _) =>
          files += file
        case x: TsSource.TsLibSource =>
          event match {
            case PhaseListener.Failure(phase) =>
              active -= x
              succeeded -= x //retardo design, but fix later. earlier stages count as "successful"
              failed += (x -> phase)
            case PhaseListener.Success(phase) =>
              active -= x
              succeeded += (x -> phase)
            case PhaseListener.Ignored =>
              active -= x
              ignored += x
            case PhaseListener.Started(phase) =>
              blocked -= x
              active += (x -> phase)
            case PhaseListener.Blocked(phase, on) =>
              active -= x
              blocked += (x -> (phase -> on))
          }
      }
      ()
    }

  override def run(): Unit =
    if (!debugMode) {
      while (!hasExited.get) {
        render()
        Try(Thread.sleep(1000))
      }
      render()
    }

  def render(): Unit =
    synchronized {
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
      active.to[Seq].map(x => (Color.Green(x._1.libName.value).render, x._2)).sorted.foreach(println)

      println("Blocked:")
      blocked
        .to[Seq]
        .map { case (name, (phase, on)) => s"${Color.LightGray(name.libName.value).render} ($phase) blocked on $on" }
        .sorted
        .foreach(println)

      println("Last ten errors: ")
      storingErrorLogger.underlying.takeRight(10).foreach { stored =>
        println(
          stored.ctx.get("id").fold("")(Color.Red(_).render + ": ") + stored.message.render.takeWhile(_ =/= '\n')
        )
      }
    }
}
