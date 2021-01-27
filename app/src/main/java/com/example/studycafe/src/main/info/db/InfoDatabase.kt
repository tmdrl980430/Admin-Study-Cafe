package com.example.studycafe.src.main.info.db

import androidx.room.RoomDatabase

abstract class InfoDatabase : RoomDatabase() {
    abstract fun infoDao() : InfoDAO
}