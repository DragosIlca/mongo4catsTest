package mongoTest.routes

import org.http4s.HttpRoutes
import cats.effect.IO
import org.http4s.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.dsl._

import mongo4cats.circe._
import mongoTest.db.DBLoader

object Routes {
	def routes: HttpRoutes[IO] = {
		val dsl = Http4sDsl[IO]
		import dsl._

		HttpRoutes.of[IO] {
			case GET -> Root / "books" => Ok(DBLoader.getAllBooks().map(_.asJson))
		}
	}
}
