package com.pencilbox.user.roomclasslecture;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by User on 2/6/2018.
 */

@Entity(tableName = "tbl_student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    @ColumnInfo(name = "col_student_name")
    private String studentName;
    @ColumnInfo(name = "col_student_dep")
    private String studentDepartment;
    @ColumnInfo(name = "col_student_city")
    private String studentCity;

    public Student(String studentName, String studentDepartment, String studentCity) {
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
        this.studentCity = studentCity;
    }
    @Ignore
    public Student(int studentId, String studentName, String studentDepartment, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
        this.studentCity = studentCity;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }
}
