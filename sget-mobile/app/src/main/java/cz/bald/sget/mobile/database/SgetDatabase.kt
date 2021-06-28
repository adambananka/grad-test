package cz.bald.sget.mobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [/*Entity::class*/], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class SgetDatabase : RoomDatabase() {

  //abstract fun entityDao(): EntityDao

  companion object {
    private var INSTANCE: SgetDatabase? = null

    fun getInstance(context: Context): SgetDatabase {
      if (INSTANCE == null) {
        synchronized(SgetDatabase::class){
          INSTANCE = Room.databaseBuilder(context.applicationContext,
            SgetDatabase::class.java, "sget-database")
            .build()
        }
      }
      return INSTANCE!!
    }
  }
}
