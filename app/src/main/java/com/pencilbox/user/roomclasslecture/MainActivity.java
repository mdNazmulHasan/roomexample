package com.pencilbox.user.roomclasslecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameET, depET, cityET;
    private ListView listView;
    private StudentAdapter adapter;
    private List<Student>students = new ArrayList<>();
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        nameET = findViewById(R.id.studentName);
        depET = findViewById(R.id.studentDep);
        cityET = findViewById(R.id.studentCity);
        listView = findViewById(R.id.studentLV);
        getStudents();
    }

    public void saveStudent(View view) {
        String name = nameET.getText().toString();
        String dept = depET.getText().toString();
        String city = cityET.getText().toString();

        Student student = new Student(name,dept,city);
        long insertedRow = StudentDatabase.getInstance(this).studentDAO().insertStudent(student);
        if(insertedRow > 0){
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
            //getStudents();
        }else{
            Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();
        }
    }

    private void getStudents() {
        //students = StudentDatabase.getInstance(this).studentDAO().getAllStudents();
        mainViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                adapter = new StudentAdapter(MainActivity.this,students);
                listView.setAdapter(adapter);
            }
        });

    }
}
