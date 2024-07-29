package mongoTest.models.types

import org.mongodb.scala.bson.ObjectId

case class Book(
	_id:     ObjectId,
	title:   String,
	author:  String,
	pages:   Int,
	genres:  List[String],
	rating:  Int,
	reviews: List[Review]
)
