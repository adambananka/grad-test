package cz.bald.sget.mobile.model

import cz.bald.sget.mobile.model.enum.Language
import cz.bald.sget.mobile.model.enum.Subject
import cz.bald.sget.mobile.model.enum.TestType
import java.time.Year

data class TestSetting(
  var type: TestType,
  var language: Language,
  var subject: Subject,
  var year: Year
)
