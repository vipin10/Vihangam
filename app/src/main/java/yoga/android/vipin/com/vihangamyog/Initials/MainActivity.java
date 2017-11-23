package yoga.android.vipin.com.vihangamyog.Initials;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yoga.android.vipin.com.vihangamyog.R;

public class MainActivity extends AppCompatActivity {
SharedPreferences sp;
String ppp,nnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        nnn=sp.getString("phone",null);
        ppp=sp.getString("password",null);
        System.out.println("the no. and password is"+nnn+"  "+ppp);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                if (nnn==null||ppp==null){
                    Intent ii=new Intent(getBaseContext(),loginpage.class);
                    startActivity(ii);
                }
                else
                {
                    Intent ii=new Intent(getBaseContext(),Homepagee.class);
                    startActivity(ii);
                }


                finish();
            }
        }, 3000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
         moveTaskToBack(true);
    }
}
