package yoga.android.vipin.com.vihangamyog.YoutubeAPI;


import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;

import yoga.android.vipin.com.vihangamyog.R;


public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder>{
Context con;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private LayoutInflater inflater;
    ArrayList<VideoDetails> singletons;
    int i;
    ArrayList<String> arr=new ArrayList<>();
    String videoidd;
    VideoDetails videoDetails=new VideoDetails();
    VideoDetails singleton;
    public  CustomListAdapter(Context con, ArrayList<VideoDetails> singletons)
    {

        this.con=con;
        this.singletons = singletons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lii= LayoutInflater.from(con).inflate(R.layout.recycleadapttttvideo,null,false);
        if (this.imageLoader == null) {
            this.imageLoader = AppController.getInstance().getImageLoader();
        }
       LinearLayout ly= (LinearLayout)lii.findViewById(R.id.asser);
        NetworkImageView networkImageView = (NetworkImageView) lii.findViewById(R.id.video_image);
        final TextView imgtitle = (TextView) lii.findViewById(R.id.imggtitle);
        final TextView tvVideoID=(TextView)lii.findViewById(R.id.tv_videoId);
        singleton = (VideoDetails) this.singletons.get(24);
        networkImageView.setImageUrl(singleton.getURL(), this.imageLoader);
        imgtitle.setText(singleton.getVideoName());

        return new ViewHolder(lii);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 24;

    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // System.out.println("the item is"+videoid);
                    Bundle bundle = new Bundle();
                    System.out.println("view clicked"+videoDetails.getVideoId());
                    bundle.putString("videoId",videoidd);
                    FragmentManager fragmentManager=((AppCompatActivity)con).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    YoutubeFragment1 youf = new YoutubeFragment1();
                    fragmentTransaction.add(R.id.your_placeholder, youf, "HELLO");
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
