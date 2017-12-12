package yoga.android.vipin.com.vihangamyog.Videosguruji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 11/30/2017.
 */

public class Videosview extends RecyclerView.Adapter<Videosview.ViewHolder> {
Context conn;

    public Videosview(Context conn){
    this.conn=conn;
    }

    @Override
    public Videosview.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lii=LayoutInflater.from(conn).inflate(R.layout.recycleadapttttvideo,null,false);
        return new ViewHolder(lii);
    }

    @Override
    public void onBindViewHolder(Videosview.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
