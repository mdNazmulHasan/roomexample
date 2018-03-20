package com.pencilbox.user.roomclasslecture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/6/2018.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private List<Student>students;
    public StudentAdapter(@NonNull Context context, List<Student>students) {
        super(context, R.layout.row, students);
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row,parent,false);
        TextView nameTV = convertView.findViewById(R.id.rowNameValue);
        TextView deptTV = convertView.findViewById(R.id.rowDeptValue);
        TextView cityTV = convertView.findViewById(R.id.rowcityValue);

        nameTV.setText(students.get(position).getStudentName());
        deptTV.setText(students.get(position).getStudentDepartment());
        cityTV.setText(students.get(position).getStudentCity());
        return convertView;
    }
}
