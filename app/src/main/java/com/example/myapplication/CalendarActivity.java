package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import java.sql.Time;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    private CalendarView myCalendarView;
    private EditText eventTitle;
    private EditText eventNotes;
    private EditText eventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        myCalendarView = (CalendarView) findViewById(R.id.calendarView);
        eventTitle = (EditText) findViewById(R.id.nameEvent);
        eventNotes = (EditText) findViewById(R.id.notesEvent);
        eventTime = (EditText) findViewById(R.id.timeEvent);

        //Seta a data no calendário da view
        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = dayOfMonth + "/" + month + "/" + year;
                String title = eventTitle.getText().toString();
                String notes = eventNotes.getText().toString();
                String time = eventTime.getText().toString();

                Log.d(TAG, "onSelectedDayChange: date" + date);

                //Manda para a outra activity os dados
                Intent intent = new Intent(CalendarActivity.this, EventActivity.class);
                intent.putExtra("date", date);
                intent.putExtra("titleEvent", title);
                intent.putExtra("notesEvent", notes);
                intent.putExtra("timeEvent", time);
                intent.putExtra("view", View.VISIBLE);
                startActivity(intent);
            }

        });
    }

    //Método para voltar para a tela de eventos/compromissos
    public void backScreen(View view) {
        Intent nextActivity = new Intent(CalendarActivity.this, EventActivity.class);
        startActivity(nextActivity);
    }
}
