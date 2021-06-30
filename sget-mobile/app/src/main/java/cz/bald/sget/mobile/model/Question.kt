package cz.bald.sget.mobile.model

import cz.bald.sget.mobile.model.enums.QuestionType

data class Question(
  val number: Int,
  val points: Int,
  val type: QuestionType,
  val text: String,
  val answers: List<String>,
  val correctAnswer: String,
  var userAnswer: String
)
