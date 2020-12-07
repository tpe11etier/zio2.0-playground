package dev.xymox.zio.playground

import zio._
import zio.console._
import zio.duration.Duration

import java.util.concurrent.TimeUnit

object Semaphores extends App {

  val task = for {
    _ <- putStrLn("Start")
    _ <- ZIO.sleep(Duration(2, TimeUnit.SECONDS))
    _ <- putStrLn("End")
  } yield ()

  val semTask = (sem: Semaphore) =>
    for {
      _ <- sem.withPermit(task)
    } yield ()

  val semTaskN = (sem: Semaphore) =>
    for {
      _ <- sem.withPermits(5)(task)
    } yield ()

  val semTaskSeq = (sem: Semaphore) => (1 to 3).map(_ => semTask(sem))

  val semTaskNSeq = (sem: Semaphore) => (1 to 10).map(_ => semTaskN(sem))

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = for {
    _ <- putStrLn("Binary Semaphore first...")
    sem <- Semaphore.make(permits = 1)
    seq <- ZIO.effectTotal(semTaskSeq(sem))
    _ <- ZIO.collectAllPar(seq)
    _ <- putStrLn("Completed. Counting version now...")
    sem2 <- Semaphore.make(5)
    seq2 <- ZIO.effectTotal(semTaskNSeq(sem2))
    _ <- ZIO.collectAllPar(seq2)
  } yield ExitCode.success
}
