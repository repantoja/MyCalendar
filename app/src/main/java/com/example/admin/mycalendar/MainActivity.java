package com.example.admin.mycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    private CalendarView calendar;
    private static final String TAG = "CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set main layout
        setContentView(R.layout.activity_main);
        //initialized the calendar
        initializeCalendar();

    }

    public void initializeCalendar(){
        calendar = (CalendarView)findViewById(R.id.calendar1);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day){
                String date = (month + 1) + "/" + day + "/" + year;
                Log.d(TAG, date);
                Intent intent = new Intent(MainActivity.this, TodoActivity.class);
                intent.putExtra("date", date);
                //pass info to activity
                startActivity(intent);
            }
        });
    }

}
