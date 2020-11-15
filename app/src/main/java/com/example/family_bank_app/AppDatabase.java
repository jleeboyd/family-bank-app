package com.example.family_bank_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Abstract class for Room Database setup
@Database(entities = {AccountEntity.class, TransactionEntity.class}, version = 11, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccountDao accountDao();

}
