package yoga.android.vipin.com.vihangamyog.Uploadpics;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

public class ViewAddPhotos extends AppCompatActivity {
ViewPager vp;
Uploadpicsadapt mAdapter;
TabLayout tl;
Toolbar toolbaraddp;
ActionBar actionbaradddp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewaddphotos);
        tl=findViewById(R.id.tab_layout);
        tl.addTab(tl.newTab().setText("MY UPLOADS"));
        tl.addTab(tl.newTab().setText("SOCIAL UPLOADS"));
        tl.setTabGravity(tl.GRAVITY_FILL);
        mAdapter = new Uploadpicsadapt(getSupportFragmentManager(),tl.getTabCount());
        vp = (ViewPager)findViewById(R.id.viewpp);
        vp.setAdapter(mAdapter);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        toolbaraddp=findViewById(R.id.toolbaraddp);
        setSupportActionBar(toolbaraddp);
        actionbaradddp=getSupportActionBar();
        actionbaradddp.setDisplayHomeAsUpEnabled(true);
        toolbaraddp.setBackgroundColor(R.color.colorAccent);
        toolbaraddp.setTitle("Pray");
        toolbaraddp.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), Homepagee.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);

    }

}

