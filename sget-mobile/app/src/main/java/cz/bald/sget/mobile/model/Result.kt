package cz.bald.sget.mobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Result(
  @PrimaryKey(autoGenerate = true) var id: Long,
  val test: TestSetting,
  var date: Date,
  val questions: Int,
  var correctQuestions: Int,
  var points: Int,
  val maxPoints: Int
)
