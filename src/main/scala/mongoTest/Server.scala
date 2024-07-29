package mongoTest

import com.comcast.ip4s.{ipv4, port}
import mongoTest.routes.Routes
import cats.*
import cats.effect.*
import org.http4s.ember.server.*
import org.http4s.implicits.*

object Server extends IOApp {

	override def run(
		args: List[String]
	): IO[ExitCode] = {

		EmberServerBuilder
			.default[IO]
			.withHost(ipv4"0.0.0.0")
			.withPort(port"6868")
			.withHttpApp(Routes.routes.orNotFound)
			.build.use(_ => IO.never)
			.as(ExitCode.Success)
	}
}

