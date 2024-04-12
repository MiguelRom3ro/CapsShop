package com.miguelrr.capsshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miguelrr.capsshop.data.database.dao.CapDao
import com.miguelrr.capsshop.data.database.dao.ShoppingCarDao
import com.miguelrr.capsshop.data.database.entity.CapEntity
import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity

@Database(entities = [CapEntity::class, ShoppingCarEntity::class], version = 2)
abstract class CapDatabase : RoomDatabase() {

    abstract fun getCapDao() : CapDao

    abstract fun getShoppingCarDao() : ShoppingCarDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Eliminar la columna cap
                db.execSQL("CREATE TABLE shoppingcar_table_new (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, id_user INTEGER NOT NULL, id_cap INTEGER NOT NULL, amount INTEGER NOT NULL)")
                db.execSQL("DROP TABLE shoppingcar_table")
                db.execSQL("ALTER TABLE shoppingcar_table_new RENAME TO shoppingcar_table")
            }
        }
    }
}