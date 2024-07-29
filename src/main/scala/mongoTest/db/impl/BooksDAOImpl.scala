package mongoTest.db.impl

import cats.effect.IO
import mongoTest.db.api.BooksDAO
import mongoTest.models.types.Book
import io.circe.generic.auto._
import mongo4cats.circe._
import mongo4cats.database.MongoDatabase

class BooksDAOImpl extends BooksDAO {
	def findAll(
		db: MongoDatabase[IO]
	): IO[List[Book]] = {
		for {
			collection <- db.getCollectionWithCodec[Book]("books")
			books <- collection.find.all.map(_.toList)
		} yield books
	}
}

object BooksDAOImpl {
	def apply(): BooksDAOImpl = new BooksDAOImpl()
}
