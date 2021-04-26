package ru.geekbrains.lesson_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    EditText editTextDate;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextDate = findViewById(R.id.editTextDate);
        calendarView = findViewById(R.id.calendarView2);

        calendarView.setOnDateChangeListener(this);

        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-EEEE-yyyy");
        String date = sdfDate.format(calendarView.getDate());
        editTextDate.setText(date);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        int mYear = year;
        int mMonth = month;
        int mDay = dayOfMonth;
        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-EEEE-yyyy");
        String date = sdfDate.format(calendar.getTime());
        editTextDate.setText(date);
    }
}