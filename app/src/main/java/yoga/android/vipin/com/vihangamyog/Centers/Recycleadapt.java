package yoga.android.vipin.com.vihangamyog.Centers;

import android.app.Fragment;
import android.app.FragmentManager;
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
 * Created by vipin.rai on 11/20/2017.
 */

public class Recycleadapt extends RecyclerView.Adapter<Recycleadapt.ViewHolder> {
Context con;
    TextView ttv;
    ImageView ivvv;
    public  Recycleadapt(Context con){
        this.con=con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View vv= LayoutInflater.from(con).inflate(R.layout.recycleadapt,null,false);

        return new ViewHolder(vv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (position==0){
            ttv.setText("Vrittikut Ashram,Ballia");
        }else if (position==1){
            ttv.setText("Maharshi Sadafaldeo Ashram, Jhunsi, Allahabad");
        }else if(position==2){
            ttv.setText("Shoonya Shikhar Ashram,garhwal");
        }else if (position==3){
            ttv.setText("Madhumati Ashram,Gaya");
        }else if(position==4){
            ttv.setText("Dandakvan Ashram,Gujrat");
        }else if(position==5){
            ttv.setText("Swarveda Mahamandir,Varanasi");
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ttv=itemView.findViewById(R.id.textView6);
            ivvv=itemView.findViewById(R.id.imageView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getLayoutPosition()==0){
                      String firstas=((TextView)v.findViewById(R.id.textView6)).getText().toString();
                      Intent a=new Intent(con,CentersDetail.class);
                        Toast.makeText(con,"0 option"+getLayoutPosition(),Toast.LENGTH_LONG).show();
                        a.putExtra("itemname",firstas);
                      con.startActivity(a);
                    }else{
                        Toast.makeText(con,"wrong option",Toast.LENGTH_LONG).show();
                    }
                }
            });


        }
    }
}
