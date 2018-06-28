package yoga.android.vipin.com.vihangamyog.Pray;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ohoussein.playpause.PlayPauseView;

import java.util.Calendar;

import yoga.android.vipin.com.vihangamyog.Database.DbHelper;
import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;



public class Praylayoutt extends AppCompatActivity {
Toolbar toolbar1;
ActionBar actionBar;
TextView mrng,alar;
Button bbt;
String a,b;
    Calendar calendar;
    String dateStart="";
    Context context=Praylayoutt.this;
    Cursor cursor;
    PlayPauseView view1,view2;
    SharedPreferences sp;
    LinearLayout l1,l2;
    TextView ttv1,ttv2;
    String strHrsToShow;
    String strHrsToShow1;
    SharedPreferences.Editor editor;
    String mrnghourss,evnghoursss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praylayoutt);
        toolbar1=findViewById(R.id.toolbar1);
         setSupportActionBar(toolbar1);
        calendar = Calendar.getInstance();
        actionBar=getSupportActionBar();
        DbHelper dbh=new DbHelper(context);
        view1 = (PlayPauseView) findViewById(R.id.play_pause_view);
        view2=findViewById(R.id.play_pause_view1);
        l1=findViewById(R.id.mrng);
        l2=findViewById(R.id.evng);
        ttv1=findViewById(R.id.mrngalarmm);
        ttv2=findViewById(R.id.evngalarmm);

        Intent myIntent = new Intent(Praylayoutt.this , AlarmBroadcastt.class);
        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(Praylayoutt.this, 0, myIntent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 05);
        calendar.set(Calendar.SECOND, 00);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000, pendingIntent);


        sp = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = sp.edit();
        if (sp.contains("mrngg")){
            mrnghourss=sp.getString("mrngg","");
            if (mrnghourss!=null)
            ttv1.setText(mrnghourss);
        }
        if (sp.contains("evng")){
            evnghoursss=sp.getString("evng","");
            if (evnghoursss!=null)
            ttv2.setText(evnghoursss);
        }
        Toast.makeText(this,"alarmtimeis"+mrnghourss+evnghoursss,Toast.LENGTH_LONG).show();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.toggle();
                view1.isPlay();
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view2.toggle();
                view2.isPlay();
            }
        });

        Toast.makeText(this,""+a+""+b,Toast.LENGTH_LONG).show();
       actionBar.setDisplayHomeAsUpEnabled(true);
       toolbar1.setBackgroundColor(R.color.colorAccent);
       toolbar1.setTitle("Pray");
        toolbar1.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimeee();

            }
        });


        editor.commit();
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
                String am_pm = "";
                Calendar datetime = Calendar.getInstance();
                datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                datetime.set(Calendar.MINUTE, minute);

                if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                    am_pm = "AM";
                else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                    am_pm = "PM";
                ttv1.setText("" + hourOfDay + ":" + minute + ":00");
                strHrsToShow=ttv1.getText().toString();
                //strHrsToShow = (datetime.get(Calendar.HOUR) == 0) ?"12":datetime.get(Calendar.HOUR)+"";
                editor.putString("mrngg",strHrsToShow);
                editor.commit();
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),false);



        timePickerDialog.create();
        timePickerDialog.show();
    }
    private void startTimeee() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(Praylayoutt.this, android.support.design.R.style.Base_Theme_AppCompat_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String am_pm1 = "";
                Calendar datetime = Calendar.getInstance();
                datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                datetime.set(Calendar.MINUTE, minute);

                if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                    am_pm1 = "AM";
                else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                    am_pm1 = "PM";
                ttv2.setText("" + hourOfDay + ":" + minute + ":00");
                strHrsToShow1=ttv2.getText().toString();
                //strHrsToShow1 = (datetime.get(Calendar.HOUR) == 0) ?"12":datetime.get(Calendar.HOUR)+"";
                editor.putString("evng",strHrsToShow1);
                editor.commit();
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),true);



        timePickerDialog.create();
        timePickerDialog.show();
    }

}
