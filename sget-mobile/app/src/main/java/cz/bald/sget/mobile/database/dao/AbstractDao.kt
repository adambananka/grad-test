package cz.bald.sget.mobile.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface AbstractDao<T> {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(item: T)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(vararg items: T)

  @Update
  fun update(item: T)

  @Delete
  fun delete(item: T)
}
