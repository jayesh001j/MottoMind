package com.example.soulscript

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2 // Incremented version number
        private const val DATABASE_NAME = "Settings.db"
        const val TABLE_NAME = "Settings"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_LIKED = "liked"
        const val COLUMN_DARK_MODE = "dark_mode"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT,
                $COL_LIKED INTEGER,
                $COLUMN_DARK_MODE INTEGER
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE $TABLE_NAME ADD COLUMN $COL_LIKED INTEGER DEFAULT 0")
        }
        // Handle other upgrades if needed
    }

    fun saveDarkModeState(darkMode: Boolean) {
        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME") // Remove any existing entry
        val contentValues = ContentValues().apply {
            put(COLUMN_DARK_MODE, if (darkMode) 1 else 0)
        }
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getDarkModeState(): Boolean {
        val db = readableDatabase
        var darkMode = false
        val cursor = db.query(
            TABLE_NAME, arrayOf(COLUMN_DARK_MODE),
            null, null, null, null, null
        )
        if (cursor.moveToFirst()) {
            darkMode = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_DARK_MODE)) == 1
        }
        cursor.close()
        db.close()
        return darkMode
    }

    fun updateLikedStatus(id: Int, newLikedState: Boolean): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_LIKED, if (newLikedState) 1 else 0)
        }
        val result = db.update(TABLE_NAME, values, "$COL_ID=?", arrayOf(id.toString()))
        db.close()
        return result != -1
    }

    fun getLikedStatus(boolean: Boolean): Boolean {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COL_LIKED),
            "$COL_ID=?",
            arrayOf(boolean.toString()),
            null,
            null,
            null
        )
        var liked = false
        if (cursor.moveToFirst()) {
            liked = cursor.getInt(cursor.getColumnIndexOrThrow(COL_LIKED)) == 1
        }
        cursor.close()
        db.close()
        return liked
    }
}

