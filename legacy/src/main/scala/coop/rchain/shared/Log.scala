package coop.rchain.shared

import cats.*
import cats.effect.Sync
import cats.syntax.all.*
import com.typesafe.scalalogging.Logger
import coop.rchain.catscontrib.effect.implicits.*

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

trait Log[F[_]] {
  def isTraceEnabled(implicit ev: LogSource): F[Boolean]
  def trace(msg: => String)(implicit ev: LogSource): F[Unit]
  def debug(msg: => String)(implicit ev: LogSource): F[Unit]
  def info(msg: => String)(implicit ev: LogSource): F[Unit]
  def warn(msg: => String)(implicit ev: LogSource): F[Unit]
  def warn(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit]
  def error(msg: => String)(implicit ev: LogSource): F[Unit]
  def error(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit]
}

object Log extends LogInstances {
  def apply[F[_]](implicit L: Log[F]): Log[F] = L

  class NOPLog[F[_]: Applicative] extends Log[F] {
    def isTraceEnabled(implicit ev: LogSource): F[Boolean]                       = false.pure[F]
    def trace(msg: => String)(implicit ev: LogSource): F[Unit]                   = ().pure[F]
    def debug(msg: => String)(implicit ev: LogSource): F[Unit]                   = ().pure[F]
    def info(msg: => String)(implicit ev: LogSource): F[Unit]                    = ().pure[F]
    def warn(msg: => String)(implicit ev: LogSource): F[Unit]                    = ().pure[F]
    def warn(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit]  = ().pure[F]
    def error(msg: => String)(implicit ev: LogSource): F[Unit]                   = ().pure[F]
    def error(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit] = ().pure[F]
  }

  // FunctorK
  implicit class LogMapKOps[F[_]](val log: Log[F]) extends AnyVal {
    def mapK[G[_]](nt: F ~> G): Log[G] = new Log[G] {
      override def isTraceEnabled(implicit ev: LogSource): G[Boolean]                       = nt(log.isTraceEnabled)
      override def trace(msg: => String)(implicit ev: LogSource): G[Unit]                   = nt(log.trace(msg))
      override def debug(msg: => String)(implicit ev: LogSource): G[Unit]                   = nt(log.debug(msg))
      override def info(msg: => String)(implicit ev: LogSource): G[Unit]                    = nt(log.info(msg))
      override def warn(msg: => String)(implicit ev: LogSource): G[Unit]                    = nt(log.warn(msg))
      override def warn(msg: => String, cause: Throwable)(implicit ev: LogSource): G[Unit]  =
        nt(log.warn(msg, cause))
      override def error(msg: => String)(implicit ev: LogSource): G[Unit]                   = nt(log.error(msg))
      override def error(msg: => String, cause: Throwable)(implicit ev: LogSource): G[Unit] =
        nt(log.error(msg, cause))
    }
  }
}

sealed abstract class LogInstances {

  def log[F[_]: Sync]: Log[F] = new Log[F] {

    def isTraceEnabled(implicit ev: LogSource): F[Boolean]                       =
      Sync[F].delay(Logger(ev.clazz).underlying.isTraceEnabled())
    def trace(msg: => String)(implicit ev: LogSource): F[Unit]                   =
      Sync[F].delay(Logger(ev.clazz).trace(msg))
    def debug(msg: => String)(implicit ev: LogSource): F[Unit]                   =
      Sync[F].delay(Logger(ev.clazz).debug(msg))
    def info(msg: => String)(implicit ev: LogSource): F[Unit]                    =
      Sync[F].delay(Logger(ev.clazz).info(msg))
    def warn(msg: => String)(implicit ev: LogSource): F[Unit]                    =
      Sync[F].delay(Logger(ev.clazz).warn(msg))
    def warn(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit]  =
      Sync[F].delay(Logger(ev.clazz).warn(msg, cause))
    def error(msg: => String)(implicit ev: LogSource): F[Unit]                   =
      Sync[F].delay(Logger(ev.clazz).error(msg))
    def error(msg: => String, cause: Throwable)(implicit ev: LogSource): F[Unit] =
      Sync[F].delay(Logger(ev.clazz).error(msg, cause))
  }

  val logId: Log[Id] = log[Id]
}
