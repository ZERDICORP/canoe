package canoe.api

import cats.arrow.FunctionK
import cats.{MonadThrow, StackSafeMonad}

trait ScenarioInstances {

  implicit def scenarioMonadThrowInstance[F[_]]: MonadThrow[({ type L[A] = Scenario[F, A] })#L] =
    new MonadThrow[({ type L[A] = Scenario[F, A] })#L] with StackSafeMonad[({ type L[A] = Scenario[F, A] })#L] {

      def pure[A](x: A): Scenario[F, A] =
        Scenario.pure(x)

      def raiseError[A](e: Throwable): Scenario[F, A] =
        Scenario.raiseError(e)

      def handleErrorWith[A](fa: Scenario[F, A])(f: Throwable => Scenario[F, A]): Scenario[F, A] =
        fa.handleErrorWith(f)

      def flatMap[A, B](fa: Scenario[F, A])(f: A => Scenario[F, B]): Scenario[F, B] =
        fa.flatMap(f)
    }

  implicit def scenarioFunctionKInstance[F[_]]: FunctionK[F, ({ type L[A] = Scenario[F, A] })#L] =
    new FunctionK[F, ({ type L[A] = Scenario[F, A] })#L] {
      def apply[A](fa: F[A]): Scenario[F, A] = Scenario.eval(fa)
    }
}
