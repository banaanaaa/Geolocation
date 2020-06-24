package com.banaanaaa.geolocation.model.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.banaanaaa.geolocation.model.entity.Point
import com.banaanaaa.geolocation.model.storage.dao.PointDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@Database(entities = [Point::class], version = 1, exportSchema = false)
abstract class PointRoomDatabase : RoomDatabase() {

    abstract fun pointDao(): PointDao

    private class PointDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
//        override fun onOpen(db: SupportSQLiteDatabase) {
//            super.onOpen(db)
//            INSTANCE?.let { database ->
//                scope.launch {
//                    for (i in 1..20) {
//                        INSTANCE?.let {
//                            database.pointDao().insert(Point("$i",
//                                Random.nextDouble(29.0, 31.0),
//                                Random.nextDouble(20.0, 100.0)))
//                        }
//                    }
//                }
//            }
//        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PointRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PointRoomDatabase {
            return INSTANCE
                ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PointRoomDatabase::class.java,
                    "point_database"
                )
                    .addCallback(PointDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}