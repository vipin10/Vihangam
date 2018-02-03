package yoga.android.vipin.com.vihangamyog.History;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 11/27/2017.
 */

public class RecycleAdaptt extends RecyclerView.Adapter<RecycleAdaptt.ViewHolder> {
Context contextt;
ImageView babaa;
TextView tavava;
String firstas;
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
            tavava.setText("Sadguru Sadafal Deo Ji Maharaj");
        }else if (position==1){
            tavava.setText("Sadguru Dharamchandradeo Ji Maharaj");
        }else if(position==2){
            tavava.setText("Sadguru Swatantradeo Maharaj");
        }else if (position==3){
            tavava.setText("Sadguru Pravar Vigyandeo Maharaj");
        }/*else if(position==4){
            tavava.setText("Sadguru Sadafal Deo Ji Maharaj");
        }else if(position==5){
            tavava.setText("Sadguru Sadafal Deo Ji Maharaj");
        }*/


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            tavava=itemView.findViewById(R.id.babaname);
            babaa=itemView.findViewById(R.id.imagii);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getLayoutPosition()==0){
                        firstas=((TextView)v.findViewById(R.id.babaname)).getText().toString();
                        Intent a=new Intent(contextt,Babajidetail.class);
                        Toast.makeText(contextt,"0 option"+getLayoutPosition(), Toast.LENGTH_LONG).show();
                        a.putExtra("itemname",firstas);
                        contextt.startActivity(a);
                    }else if(getLayoutPosition()==1){
                        firstas=((TextView)v.findViewById(R.id.babaname)).getText().toString();
                        Intent a=new Intent(contextt,Babajidetail.class);
                        Toast.makeText(contextt,"1 option"+getLayoutPosition(),Toast.LENGTH_LONG).show();
                        a.putExtra("itemname",firstas);
                        contextt.startActivity(a);
                    }
                    else if(getLayoutPosition()==2){
                        firstas=((TextView)v.findViewById(R.id.babaname)).getText().toString();
                        Intent a=new Intent(contextt,Babajidetail.class);
                        Toast.makeText(contextt,"2 option"+getLayoutPosition(),Toast.LENGTH_LONG).show();
                        a.putExtra("itemname",firstas);
                        contextt.startActivity(a);
                    }
                    else if(getLayoutPosition()==3){
                        firstas=((TextView)v.findViewById(R.id.babaname)).getText().toString();
                        Intent a=new Intent(contextt,Babajidetail.class);
                        Toast.makeText(contextt,"3 option"+getLayoutPosition(),Toast.LENGTH_LONG).show();
                        a.putExtra("itemname",firstas);
                        contextt.startActivity(a);
                    }

                }
            });

        }
    }
}
