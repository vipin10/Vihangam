package yoga.android.vipin.com.vihangamyog.YoutubeAPI;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import yoga.android.vipin.com.vihangamyog.R;


public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder>{
Context con;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    ArrayList<VideoDetails> singletons;
    ArrayList<String> arr=new ArrayList<>();
    VideoDetails singleton;
    NetworkImageView networkImageView;
    TextView imgtitle;
    List<String> listOfString;
    String idddd;
    String jjjj;
    final String mypreference = "mypref";
    Boolean clicke=true;
    public  CustomListAdapter(Context con, ArrayList<VideoDetails> singletons)
    {

        this.con=con;
        this.singletons = singletons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lii= LayoutInflater.from(con).inflate(R.layout.recycleadapttttvideo,null,false);
        return new ViewHolder(lii);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        if (this.imageLoader == null) {
            this.imageLoader = AppController.getInstance().getImageLoader();
        }
        holder.setIsRecyclable(false);
        singleton =this.singletons.get(i);
        networkImageView.setImageUrl(singleton.getURL(), this.imageLoader);
        imgtitle.setText(singleton.getVideoName());
        idddd=singleton.getVideoId();
        jjjj=singleton.getVideoName();
        for (int j=0;j<=25;j++){
            String dd=singleton.getVideoId();
            String aaab=singleton.getVideoName();
            listOfString= new ArrayList<String>();
            //listOfString.add(dd);
            listOfString.add(aaab);
        }
        System.out.println("dddd"+listOfString);
    }

    @Override
    public int getItemCount() {
        return singletons.size();

    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(final View itemView) {
            super(itemView);
            LinearLayout ly= (LinearLayout)itemView.findViewById(R.id.asser);
            networkImageView =itemView.findViewById(R.id.video_image);
            imgtitle =itemView.findViewById(R.id.imggtitle);
            final TextView tvVideoID=itemView.findViewById(R.id.tv_videoId);
            System.out.println("singleton"+singletons);

             itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=  getLayoutPosition();
                    VideoDetails sing=singletons.get(position);
                    idddd=sing.getVideoId();
                    Bundle bundle = new Bundle();
                    System.out.println("view clicked"+idddd);
                    FragmentManager fragmentManager=((AppCompatActivity)con).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    YoutubeFragment1 youf = new YoutubeFragment1();
                    fragmentTransaction.replace(R.id.your_placeholder, youf, "HELLO");
                    bundle.putString("videoId",idddd);
                    bundle.putBoolean("boo",clicke);
                    fragmentTransaction.commit();
                    youf.setArguments(bundle);


                }
            });
        }


    }

}




/*extends BaseAdapter {
    Activity activity;
    FragmentManager fm;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private LayoutInflater inflater;
    ArrayList<VideoDetails> singletons;
  Boolean bb=false;

    public CustomListAdapter(Activity activity, ArrayList<VideoDetails> singletons) {
        this.activity = activity;
        this.singletons = singletons;
    }

    public int getCount() {
        return this.singletons.size();
    }

    public Object getItem(int i) {
        return this.singletons.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (this.inflater == null) {
            this.inflater = (LayoutInflater) this.activity.getLayoutInflater();
        }
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.recycleadapttttvideo, null);
        }
        if (this.imageLoader == null) {
            this.imageLoader = AppController.getInstance().getImageLoader();
        }
        NetworkImageView networkImageView = (NetworkImageView) convertView.findViewById(R.id.video_image);
        final TextView imgtitle = (TextView) convertView.findViewById(R.id.imggtitle);
        final TextView tvVideoID=(TextView)convertView.findViewById(R.id.tv_videoId);



       ((LinearLayout) convertView.findViewById(R.id.asser)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bb=true;
            }
        });


        VideoDetails singleton = (VideoDetails) this.singletons.get(i);
        networkImageView.setImageUrl(singleton.getURL(), this.imageLoader);
        imgtitle.setText(singleton.getVideoName());
        return convertView;
    }

}*/
