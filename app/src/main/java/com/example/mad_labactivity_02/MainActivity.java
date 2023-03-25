package com.example.mad_labactivity_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button calendarButton, clockButton;
    private TextView selectedDateText, selectedTimeText;
    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        calendarButton = findViewById(R.id.calendar_button);
        clockButton = findViewById(R.id.clock_button);
        selectedDateText = findViewById(R.id.selected_date);
        selectedTimeText = findViewById(R.id.selected_time);

        // Set button click listeners
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalendarDialog();
            }
        });

        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showClockDialog();
            }
        });
    }

    // Display calendar dialog
    private void showCalendarDialog() {
        // Get current date
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int yearSelected, int monthOfYear, int dayOfMonth) {
                        // Set selected date in text view
                        selectedDateText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + yearSelected);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    // Display clock dialog
    private void showClockDialog() {
        // Get current time
        final Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        // Create time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minuteSelected) {
                        // Set selected time in text view
                        selectedTimeText.setText(String.format("%02d:%02d", hourOfDay, minuteSelected));
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }
}
