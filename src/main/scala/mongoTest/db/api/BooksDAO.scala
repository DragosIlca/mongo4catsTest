package mongoTest.db.api

import cats.Monad
import cats.effect.IO
import cats.effect.kernel.Async
import mongo4cats.database.MongoDatabase
import mongoTest.models.types.Book

trait BooksDAO {
	def findAll(db: MongoDatabase[IO]): IO[List[Book]]
}
