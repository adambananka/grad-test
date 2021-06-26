package cz.bald.sget.mobile.model

import java.util.Date

data class Result(
  val test: String,
  var date: Date,
  val questions: Int,
  var correctQuestions: Int,
  var points: Int,
  val maxPoints: Int
)
