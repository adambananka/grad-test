package cz.bald.sget.mobile.service

import com.google.gson.GsonBuilder
import cz.bald.sget.mobile.model.Test
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.model.enums.CzechSubject
import cz.bald.sget.mobile.model.enums.SlovakSubject
import cz.bald.sget.mobile.model.enums.Subject
import java.io.Reader

class JsonConvertManager {

  companion object {
    private val converter = GsonBuilder()
      .registerTypeAdapter(Subject::class.java, SubjectInterfaceAdapter())
      .registerTypeAdapter(SlovakSubject::class.java, SubjectInterfaceAdapter())
      .registerTypeAdapter(CzechSubject::class.java, SubjectInterfaceAdapter())
      .create()

    fun convertJsonToTest(jsonReader: Reader): Test {
      val result = convertJsonToTest(jsonReader.readText())
      jsonReader.close()
      return result
    }

    fun convertJsonToTest(json: String): Test {
      return converter.fromJson(json, Test::class.java)
    }

    fun convertTestSettingToJson(setting: TestSetting): String {
      return converter.toJson(setting)
    }

    fun convertJsonToTestSetting(json: String): TestSetting {
      return converter.fromJson(json, TestSetting::class.java)
    }
  }
}
