package yoga.android.vipin.com.vihangamyog.History;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 11/27/2017.
 */

public class RecycleAdaptt extends RecyclerView.Adapter<RecycleAdaptt.ViewHolder> {
Context contextt;
ImageView babaa;
TextView tavava;
    public RecycleAdaptt(Context contextt){
        this.contextt=contextt;
    }

    @Override
    public RecycleAdaptt.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1= LayoutInflater.from(contextt).inflate(R.layout.recycleadaptt,null,false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(RecycleAdaptt.ViewHolder holder, int position) {
        if (position==0){
            tavava.setText("Vrittikut Ashram,Ballia");
        }else if (position==1){
            tavava.setText("Maharshi Sadafaldeo Ashram, Jhunsi, Allahabad");
        }else if(position==2){
            tavava.setText("Shoonya Shikhar Ashram,garhwal");
        }else if (position==3){
            tavava.setText("Madhumati Ashram,Gaya");
        }else if(position==4){
            tavava.setText("Dandakvan Ashram,Gujrat");
        }else if(position==5){
            tavava.setText("Swarveda Mahamandir,Varanasi");
        }


    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            tavava=itemView.findViewById(R.id.babaname);
            babaa=itemView.findViewById(R.id.imagii);
        }
    }
}
