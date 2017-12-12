package yoga.android.vipin.com.vihangamyog.Pray;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

public class Praylayoutt extends AppCompatActivity {
Toolbar toolbar1;
ActionBar actionBar;
TextView mrng;
    Calendar calendar;
    String dateStart="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praylayoutt);
        toolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        calendar = Calendar.getInstance();
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
       // toolbar1.setBackgroundColor(R.color.colorAccent);
        toolbar1.setTitle("Pray");
        mrng=findViewById(R.id.mrngprayertime);
        mrng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime();
            }
        });
        toolbar1.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), Homepagee.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);

    }
    private void startTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(Praylayoutt.this, android.support.design.R.style.Base_Theme_AppCompat_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mrng.setText("" + hourOfDay + ":" + minute + ":00");
                dateStart = dateStart + " " + hourOfDay + ":" + minute + ":00";
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.create();
        timePickerDialog.show();
    }
}
