package ru.geekbrains.lesson_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView textView;
    EditText edit1;
    Button button;
    Switch switch1;
    CheckBox checkBox;
    ToggleButton toggleButton;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        edit1 = findViewById(R.id.edit1);
        button = findViewById(R.id.button);
        switch1 = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.checkBox);
        toggleButton = findViewById(R.id.toggleButton);
        imageButton = findViewById(R.id.imageButton);


        edit1.setOnClickListener(this);
        button.setOnClickListener(this);
        switch1.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);

        switch1.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this);


        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-EEEE-yyyy");
        String time = sdfTime.format(Calendar.getInstance().getTime());
        String date = sdfDate.format(Calendar.getInstance().getTime());
        textView.setText(date + ' ' + time);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit1:
                textView.setText(edit1.getText());
                break;
            case R.id.button:
                switch1.setChecked(!switch1.isChecked());
                break;
            case R.id.switch1:
                checkBox.setChecked(!checkBox.isChecked());
                break;
            case R.id.checkBox:
                toggleButton.setChecked(!toggleButton.isChecked());
                break;
            case R.id.imageButton:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch1:
                checkBox.setChecked(isChecked);
                break;
            case R.id.checkBox:
                toggleButton.setChecked(isChecked);
                break;
            default:
                break;
        }
    }
}