package cz.bald.sget.mobile.service

import com.google.gson.Gson
import cz.bald.sget.mobile.model.Test
import java.io.Reader

class JsonConvertManager {

  companion object {
    private val converter = Gson()

    fun convertJsonToTest(jsonReader: Reader): Test {
      val result = convertJsonToTest(jsonReader.readText())
      jsonReader.close()
      return result
    }

    fun convertJsonToTest(json: String): Test {
      return converter.fromJson(json, Test::class.java)
    }
  }
}
