package ru.geekbrains.lesson_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    //EditText edit_1;
    //TextView textView;
    //Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edit1 = findViewById(R.id.edit1);
        final EditText editText1 = findViewById(R.id.edit1);
        final TextView textView = findViewById(R.id.textView);

        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-EEEE-yyyy");
        String time = sdfTime.format(Calendar.getInstance().getTime());
        String date = sdfDate.format(Calendar.getInstance().getTime());
        textView.setText(time);
        editText1.setText(date);

        CheckBox checkBox = findViewById(R.id.checkBox);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        Button button = findViewById(R.id.button);
        Switch switch1 = findViewById(R.id.switch1);
        ImageButton imageButton = findViewById(R.id.imageButton);




        edit1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                textView.setText(edit1.getText());
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch1.setChecked(!switch1.isChecked());
            }
        });

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(!checkBox.isChecked());
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox.setChecked(isChecked);
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton.setChecked(!toggleButton.isChecked());
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleButton.setChecked(isChecked);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this, MainActivity2.class);
                //setContentView(R.layout.activity_main2);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }


    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit1:
                textView.setText(edit_1.getText());
                break;
            case R.id.button:
                switch1.setChecked(!switch1.isChecked());
                break;
            default:
                break;
        }
    }*/

}