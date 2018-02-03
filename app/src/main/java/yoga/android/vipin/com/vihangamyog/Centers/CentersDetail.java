package yoga.android.vipin.com.vihangamyog.Centers;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
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

public class CentersDetail extends AppCompatActivity {
    ImageView iv1;
    TextView descr;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailstemple);
        iv1=findViewById(R.id.collapseimagee);
        descr=findViewById(R.id.descrip);
        Intent aa=getIntent();
       String asd= aa.getStringExtra("itemname");
       System.out.println("retreived text is "+asd);
       if (asd.equals("Vrittikut Ashram,Ballia")){
           iv1.setBackground(getDrawable(R.drawable.mandir2));
           descr.setText(R.string.ashramdetail);
       }else if(asd.equals("Maharshi Sadafaldeo Ashram, Jhunsi, Allahabad")){
           iv1.setBackground(getDrawable(R.drawable.mandir11));
           descr.setText(R.string.ashrame2detail);
       }else if(asd.equals("Shoonya Shikhar Ashram,garhwal")){
           iv1.setBackground(getDrawable(R.drawable.mandir2));
           descr.setText(R.string.ashramdetail);
        }else if (asd.equals("Madhumati Ashram,Gaya")){
           iv1.setBackground(getDrawable(R.drawable.mandir2));
           descr.setText(R.string.ashramdetail);
       }else if (asd.equals("Dandakvan Ashram,Gujrat")){
           iv1.setBackground(getDrawable(R.drawable.mandir2));
           descr.setText(R.string.ashramdetail);
       }else if (asd.equals("Swarveda Mahamandir,Varanasi")){
           iv1.setBackground(getDrawable(R.drawable.mandir2));
           descr.setText(R.string.ashramdetail);
       }
       else{
           Toast.makeText(this,"not working right now",Toast.LENGTH_LONG).show();
       }
    }
}
