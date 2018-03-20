package com.pencilbox.user.roomclasslecture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by User on 2/6/2018.
 */

public class MainViewModel extends AndroidViewModel{
    private StudentDatabase db;
    public MainViewModel(@NonNull Application application) {
        super(application);
        db = StudentDatabase.getInstance(application);
    }

    public LiveData<List<Student>>getAllStudents(){
        return db.studentDAO().getAllLiveStudents();
    }
}
