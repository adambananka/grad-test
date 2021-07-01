package cz.bald.sget.mobile.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface AbstractDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: T): List<Long>

    @Update
    suspend fun update(item: T)

    @Delete
    suspend fun delete(item: T)
}
