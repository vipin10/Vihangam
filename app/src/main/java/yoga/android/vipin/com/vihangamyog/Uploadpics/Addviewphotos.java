package yoga.android.vipin.com.vihangamyog.Uploadpics;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 12/2/2017.
 */

public class Addviewphotos extends RecyclerView.Adapter<Addviewphotos.ViewHolder> {
    Context contexta;

    public Addviewphotos(Context contexta){
        this.contexta=contexta;
    }
    @Override
    public Addviewphotos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvadd= LayoutInflater.from(contexta).inflate(R.layout.addviewphotos,null,false);
        return new ViewHolder(vvadd);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
