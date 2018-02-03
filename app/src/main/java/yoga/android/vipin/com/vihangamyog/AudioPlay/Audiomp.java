package yoga.android.vipin.com.vihangamyog.AudioPlay;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

public class Audiomp extends AppCompatActivity {
RecyclerView rvva;
Toolbar toolbar3;
ActionBar actionBaraud;
    String FILENAME = "hello_file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiomp);
       /* try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = bufferedReader.readLine()) != null ) {
                System.out.println("the value iss"+line);            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //rvva=findViewById(R.id.audiosss);
        //rvva.setAdapter(new RecycleAudio(getBaseContext()));
        //rvva.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        toolbar3=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        actionBaraud=getSupportActionBar();
        actionBaraud.setDisplayHomeAsUpEnabled(true);
        toolbar3.setBackgroundColor(R.color.colorAccent);
        toolbar3.setTitle("Pray");
        toolbar3.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));
        Toast.makeText(this,"Such view will be here for listening to mp3 songs",Toast.LENGTH_LONG).show();
        /*MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), Homepagee.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);

    }
}
