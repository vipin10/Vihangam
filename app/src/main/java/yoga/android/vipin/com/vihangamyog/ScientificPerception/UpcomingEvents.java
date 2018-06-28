package yoga.android.vipin.com.vihangamyog.ScientificPerception;


import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yoga.android.vipin.com.vihangamyog.Centers.Recycleadapt;
import yoga.android.vipin.com.vihangamyog.R;

public class UpcomingEvents extends Fragment {
    public static RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ContentLoadingProgressBar imageView;
    Dialog alertDialog;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        return layoutInflater.inflate(R.layout.upcoming_events, viewGroup, false);
    }
    @Override
    public void onViewCreated(View view, Bundle bundle){
        super.onViewCreated(view, bundle);
        recyclerView = (RecyclerView) view.findViewById(R.id.recommended_recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(new Upcomingeventsadapterr(getContext()) );
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setAnim();

}

    public  void setAnim(){
        RotateAnimation rotateAnimation=new RotateAnimation(0,359, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(Animation.RESTART);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        alertDialog = new Dialog(getActivity());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.pbar);
        imageView=(ContentLoadingProgressBar) alertDialog.findViewById(R.id.pbar_Cloud) ;
        imageView.setActivated(true);
        imageView.show();
        imageView.startAnimation(rotateAnimation);
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

    }

}
