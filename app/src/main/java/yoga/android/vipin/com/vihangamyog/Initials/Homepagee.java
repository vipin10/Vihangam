package yoga.android.vipin.com.vihangamyog.Initials;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import yoga.android.vipin.com.vihangamyog.About.Aboutt;
import yoga.android.vipin.com.vihangamyog.Centers.centerslist;
import yoga.android.vipin.com.vihangamyog.History.Babaji;
import yoga.android.vipin.com.vihangamyog.Homedisplay.Dataa;
import yoga.android.vipin.com.vihangamyog.R;
import yoga.android.vipin.com.vihangamyog.ScientificPerception.UpcomingEvents;
import yoga.android.vipin.com.vihangamyog.Settingss.Feedbackp;
import yoga.android.vipin.com.vihangamyog.products.Bookreaderrr;
import yoga.android.vipin.com.vihangamyog.products.Productsss;

public class Homepagee extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout mDemoSlider;
    Toolbar toolbar;
    FirebaseAuth mauth;
    String FILENAME = "hello_file";
    String string = "hello world!";
    SharedPreferences spp;
   SharedPreferences.Editor edt;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepagee);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(R.color.colorAccent);
        mauth = FirebaseAuth.getInstance();
        toolbar.setTitle(R.string.vihangam);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.framee, new Dataa()).commit();
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        spp=getApplicationContext().getSharedPreferences("MyPref1",0);
        edt=spp.edit();
        if (spp.contains("on")){
         a=spp.getInt("on",2);
           /* if (a == 1){
                Toast.makeText(this,a,Toast.LENGTH_LONG).show();
                Locale locale = new Locale("hi");
                Configuration config = this.getResources().getConfiguration();
                config.locale = locale;
                this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
            }else if (a==2){
                Toast.makeText(this,a,Toast.LENGTH_LONG).show();
            }*/
        }

        View header = navigationView.getHeaderView(0);
        Switch tv = (Switch) header.findViewById(R.id.switchhhh);
        tv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edt.putInt("on",1);
                    edt.commit();
                    // If the switch button is on
                   // rl.setBackgroundColor(Color.parseColor("#FF80DFB0"));

                    // Show the switch button checked status as toast message
                    Toast.makeText(getApplicationContext(),
                            "Switch is on", Toast.LENGTH_LONG).show();
                }
                else {
                    // If the switch button is off
                   // rl.setBackgroundColor(Color.parseColor("#ed252f"));
                    edt.putInt("on",2);
                    edt.commit();
                    // Show the switch button checked status as toast message
                    Toast.makeText(getApplicationContext(),
                            "Switch is off", Toast.LENGTH_LONG).show();
                }
            }
        });
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILENAME, getBaseContext().MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fm = new Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_centers) {
            toolbar.setTitle(R.string.ashrams);
            ft.replace(R.id.framee, new centerslist()).commit();

            // Handle the camera action
        }
        else if (id==R.id.nav_doha){
          ft.replace(R.id.framee, new Productsss()).commit();
        }
        else if (id == R.id.nav_society) {

        } else if (id == R.id.nav_History) {
            toolbar.setTitle(R.string.inspirations);
            toolbar.setTitleTextColor(R.color.lightblue);
            ft.replace(R.id.framee,new Babaji()).commit();
            Toast.makeText(getBaseContext(),  R.string.navigation_drawer_open, Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_settings) {
            Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext() .getPackageName())));
            }
        }else if (id==R.id.nav_share){
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch(Exception e) {
                //e.toString();
            }
            Toast.makeText(this,R.string.sukrit_products,Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.nav_feedback){
            ft.replace(R.id.framee, new Feedbackp()).commit();
        }
        else if (id==R.id.nav_products){
            toolbar.setTitle(R.string.sukrit_products);
            ft.replace(R.id.framee,new Bookreaderrr()).commit();
        }
        else if(id==R.id.about){
            toolbar.setTitle(R.string.about);
            ft.replace(R.id.framee,new Aboutt()).commit();
        }
        else if (id==R.id.nav_eventss){
            toolbar.setTitle(R.string.upcoming_events);
            ft.replace(R.id.framee,new UpcomingEvents()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
