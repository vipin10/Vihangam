package yoga.android.vipin.com.vihangamyog.YoutubeAPI;



import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

import static java.security.AccessController.getContext;


public class ChannelActivity  extends AppCompatActivity {
    RecyclerView lvVideo;
    ArrayList<VideoDetails> videoDetailsArrayList;
    String TAG="ChannelActivity";
    String URL="https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UC1NF71EwP41VdjAU1iXdLkw&maxResults=25&key=AIzaSyBU1TUHuSsCGG9jTmhT9lm_tVhOWLv3qn0";
    Toolbar toolbar1;
    ActionBar actionBar;
    String API_KEY="AIzaSyBU1TUHuSsCGG9jTmhT9lm_tVhOWLv3qn0";
    private static final int RECOVERY_REQUEST = 1;
    ProgressBar pd;
    CustomListAdapter customListAdapter;
    String videoid;

    public static ChannelActivity createInstance(){
        System.out.println("Activity recreated");
        return new ChannelActivity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        lvVideo=findViewById(R.id.videoList1);
        pd=findViewById(R.id.progressBar2);
        pd.setProgress(3);
        System.out.println("OnCreate Recreated");
        videoDetailsArrayList=new ArrayList<>();
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        toolbar1=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar1);
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar1.setBackgroundColor(R.color.colorAccent);
        toolbar1.setTitle("Pray");
        toolbar1.setTitleTextColor(getResources().getColor(R.color.colorwhiteee));
        showVideo();
        customListAdapter=new CustomListAdapter(ChannelActivity.this,videoDetailsArrayList);

    }

    @Override
    public void recreate() {
        super.recreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lvVideo.setVisibility(View.GONE);

    }

    private void showVideo() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.setVisibility(View.GONE);
                try {

                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        JSONObject jsonVideoId=jsonObject1.getJSONObject("id");
                        System.out.println("response"+jsonVideoId);
                        JSONObject jsonsnippet= jsonObject1.getJSONObject("snippet");
                        JSONObject jsonObjectdefault = jsonsnippet.getJSONObject("thumbnails").getJSONObject("medium");

                        VideoDetails videoDetails=new VideoDetails();
                       videoid =jsonVideoId.getString("videoId");
                        Log.e(TAG," New Video Id" +videoid);
                        videoDetails.setURL(jsonObjectdefault.getString("url"));
                        videoDetails.setVideoName(jsonsnippet.getString("title"));
                        videoDetails.setVideoDesc(jsonsnippet.getString("description"));
                        videoDetails.setVideoId(videoid);
                        videoDetailsArrayList.add(videoDetails);
                    }
                    System.out.println("the video id"+videoDetailsArrayList);
                    lvVideo.setAdapter(new CustomListAdapter(ChannelActivity.this,videoDetailsArrayList) );
                    lvVideo.setLayoutManager(new LinearLayoutManager(ChannelActivity.this));
                    customListAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    pd.setVisibility(View.GONE);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                pd.setVisibility(View.GONE);
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), Homepagee.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);

    }

}
