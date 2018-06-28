package yoga.android.vipin.com.vihangamyog.ScientificPerception;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 6/22/2018.
 */

public class Upcomingeventsadapterr extends RecyclerView.Adapter<Upcomingeventsadapterr.ViewHolder> {
    Context con;

    public  Upcomingeventsadapterr(Context con)
    {
        this.con=con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vv= LayoutInflater.from(con).inflate(R.layout.activity_upcoming_events,null,false);
        return new ViewHolder(vv);
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
