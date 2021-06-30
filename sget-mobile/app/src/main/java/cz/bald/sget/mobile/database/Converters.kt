package cz.bald.sget.mobile.database

import androidx.room.TypeConverter
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.service.JsonConvertManager
import java.util.Date

class Converters {

  @TypeConverter
  fun timestampToDate(value: Long?): Date? {
    return if (value == null) null else Date(value)
  }

  @TypeConverter
  fun dateToTimestamp(date: Date?): Long? {
    return date?.time
  }

  @TypeConverter
  fun testSettingToString(value: TestSetting?): String? {
    return if (value == null) null else JsonConvertManager.convertTestSettingToJson(value)
  }

  @TypeConverter
  fun stringToTestSetting(value: String?): TestSetting? {
    return if (value == null) null else JsonConvertManager.convertJsonToTestSetting(value)
  }
}
