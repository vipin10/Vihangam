package yoga.android.vipin.com.vihangamyog.Pray;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praylayoutt);
        toolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        calendar = Calendar.getInstance();
        actionBar=getSupportActionBar();
        DbHelper dbh=new DbHelper(context);
        /*SQLiteDatabase dbb= dbh.getReadableDatabase();
        cursor=dbb.rawQuery("SELECT * from AshramData",null);
        cursor.moveToLast();
        a=cursor.getString(1);*/
        Toast.makeText(this,""+a+""+b,Toast.LENGTH_LONG).show();
        actionBar.setDisplayHomeAsUpEnabled(true);
       toolbar1.setBackgroundColor(R.color.colorAccent);
        toolbar1.setTitle("Pray");
        mrng=findViewById(R.id.mrngprayertime);
        mrng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogshow();
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

    public void dialogshow(){
        AlertDialog.Builder builder=new AlertDialog.Builder(Praylayoutt.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View vvb=inflater.inflate(R.layout.mobilenumberdialog,null);
        builder.setView(vvb);
        alar =vvb.findViewById(R.id.mrngalarmm);
        bbt=vvb.findViewById(R.id.setdialogbuttonn);
        builder.setCancelable(false);
        final AlertDialog dialog = builder.create();
        dialog.show();
        alar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startTime();
            }
        });
   bbt.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Toast.makeText(Praylayoutt.this,"optionn clicked",Toast.LENGTH_LONG).show();
           DbHelper dbAutoSave = new DbHelper(context);
          // dbAutoSave.insertData("123",1);
           dbAutoSave.updateData(dateStart,1);
           dialog.dismiss();
       }
   });
    }
    private void startTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(Praylayoutt.this, android.support.design.R.style.Base_Theme_AppCompat_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                alar.setText("" + hourOfDay + ":" + minute + ":00");
                mrng.setText("" + hourOfDay + ":" + minute + ":00");
                dateStart = dateStart + " " + hourOfDay + ":" + minute + ":00";
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);
        timePickerDialog.create();
        timePickerDialog.show();
    }

}
