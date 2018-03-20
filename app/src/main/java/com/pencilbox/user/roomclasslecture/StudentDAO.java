package com.pencilbox.user.roomclasslecture;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by User on 2/6/2018.
 */
@Dao
public interface StudentDAO {
    @Insert
    long insertStudent(Student students);

    @Query("select * from tbl_student")
    List<Student>getAllStudents();

    @Query("select * from tbl_student where studentId like:id")
    Student getStudentById(int id);

    @Query("select * from tbl_student")
    LiveData<List<Student>>getAllLiveStudents();

}
