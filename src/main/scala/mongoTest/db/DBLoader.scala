package mongoTest.db

import cats.effect.{IO, Resource}
import mongo4cats.client.*
import mongoTest.db.impl.BooksDAOImpl
import mongoTest.models.types.Book

object DBLoader {

	val mongoClient: Resource[IO, MongoClient[IO]] = MongoClient.fromConnectionString[IO]("mongodb://localhost:27017")

	def getAllBooks(): IO[List[Book]] =
		mongoClient.use { client => for {
			db 		 <- client.getDatabase("bookstore")
			result <- BooksDAOImpl().findAll(db)
		} yield result
	}
}
