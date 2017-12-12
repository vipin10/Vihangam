package yoga.android.vipin.com.vihangamyog.AudioPlay;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import yoga.android.vipin.com.vihangamyog.R;

public class Audiomp extends AppCompatActivity {
RecyclerView rvva;
Toolbar toolbar3;
ActionBar actionBaraud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiomp);
        rvva=findViewById(R.id.audiosss);
        rvva.setAdapter(new RecycleAudio(getBaseContext()));
        rvva.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        toolbar3=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        actionBaraud=getSupportActionBar();
        actionBaraud.setDisplayHomeAsUpEnabled(true);
       // toolbar3.setBackgroundColor(R.color.colorAccent);
        toolbar3.setTitle("Pray");
        toolbar3.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
    }
}
