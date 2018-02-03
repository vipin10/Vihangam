package yoga.android.vipin.com.vihangamyog.Initials;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Map;

import yoga.android.vipin.com.vihangamyog.Firebasenotify.fcmnotifi;
import yoga.android.vipin.com.vihangamyog.R;

public class MainActivity extends AppCompatActivity {
SharedPreferences sp;
String ppp,nnn;
String TAG="ttt";
Boolean token1=false;
    String token;
    int height;
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView ivv=(ImageView)findViewById(R.id.ivvv);
        DisplayMetrics dm=this.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, displayMetrics);
        ImageView myView = (ImageView) findViewById(R.id.imagevieww);
        ObjectAnimator animator = ObjectAnimator.ofFloat(myView, "scaleX", 3.8f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myView, "scaleY", 3.8f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator1);
        set.setDuration(2000);
        set.start();
        height = displayMetrics.heightPixels;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -height, 0);
                ImageView imageView = (ImageView) findViewById(R.id.ivvv);
                imageView.setVisibility(View.VISIBLE);
                translateAnimation.setDuration(2000);
                imageView.setAnimation(translateAnimation);
            }
        },0);

        sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        nnn=sp.getString("phone",null);
        ppp=sp.getString("password",null);
        System.out.println("the no. and password is"+nnn+"  "+ppp+  ""+token1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        String msg = getString(R.string.msg_subscribed);
        Log.d(TAG, msg);




        // Get token
        token = FirebaseInstanceId.getInstance().getToken();

        myRef.setValue(token);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + "id", "1");
        childUpdates.put("/user-posts/" + "222" + "/" + "token", token);

        myRef.updateChildren(childUpdates);

        // Log and toast
        String mag = getString(R.string.msg_token_fmt, token);
        Log.d(TAG, mag);


        if (token1=false){
            firebasee();
            token1=true;
        }else if (token==null){
            token1=false;
        }

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
        }, 5000);

    }




    public void firebasee(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            String channelId  = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }


            }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
         moveTaskToBack(true);
    }
}
