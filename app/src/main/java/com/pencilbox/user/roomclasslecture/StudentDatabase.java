package com.pencilbox.user.roomclasslecture;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by User on 2/6/2018.
 */

@Database(entities = {Student.class},version = 2)
public abstract class StudentDatabase extends RoomDatabase{
    private static StudentDatabase db;
    public abstract StudentDAO studentDAO();

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("alter table tbl_student add column col_student_city text");
        }
    };

    public static StudentDatabase getInstance(Context context){
        if(db != null){
            return db;
        }else{
            db = Room.databaseBuilder(context,StudentDatabase.class,"student_db")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
            return db;
        }
    }
}
