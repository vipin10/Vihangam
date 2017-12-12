package yoga.android.vipin.com.vihangamyog.Videosguruji;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import yoga.android.vipin.com.vihangamyog.R;

public class videosplay extends AppCompatActivity {

    RecyclerView rvvv;
Toolbar toolbar1;
ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videosplay);
        rvvv=findViewById(R.id.videossss);
        rvvv.setAdapter(new Videosview(getBaseContext()));
        rvvv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        toolbar1=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar1);
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //toolbar1.setBackgroundColor(R.color.colorAccent);
        toolbar1.setTitle("Pray");
        toolbar1.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));
    }
}
