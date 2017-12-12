package yoga.android.vipin.com.vihangamyog.AudioPlay;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoga.android.vipin.com.vihangamyog.R;

public class RecycleAudio extends RecyclerView.Adapter<RecycleAudio.ViewHolder> {
    Context conn;

    public RecycleAudio(Context conn){
        this.conn=conn;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lii= LayoutInflater.from(conn).inflate(R.layout.activity_recycle_audio,null,false);
        return new ViewHolder(lii);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

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

