package cz.bald.sget.mobile.model

import java.time.LocalDate

data class Result(
  val test: String,
  val date: LocalDate,
  val questions: Int,
  val correctQuestions: Int,
  val points: Int,
  val maxPoints: Int
)
