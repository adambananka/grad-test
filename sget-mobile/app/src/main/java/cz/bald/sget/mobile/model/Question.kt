package cz.bald.sget.mobile.model

data class Question(
  val number: Int,
  val points: Int,
  val text: String,
  val answers: List<String>,
  val correctAnswer: String,
  var userAnswer: String
)
