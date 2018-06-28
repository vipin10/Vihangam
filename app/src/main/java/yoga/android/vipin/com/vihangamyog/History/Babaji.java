package yoga.android.vipin.com.vihangamyog.History;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import yoga.android.vipin.com.vihangamyog.Homedisplay.Dataa;
import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 11/27/2017.
 */

public class Babaji extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
View view1;
RecyclerView rvv;
Toolbar toolbar;
    private SliderLayout mDemoSlider;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View vv=inflater.inflate(R.layout.fragment_babajilist,null,true);
        rvv=(RecyclerView)vv.findViewById(R.id.babaji_rc);
        rvv.setAdapter(new RecycleAdaptt(getContext()) );
        rvv.setLayoutManager(new LinearLayoutManager(getContext()));
        mDemoSlider = (SliderLayout)vv.findViewById(R.id.slider1);

        //slidding images function in oncreate

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Sadafaldevji maharaj",R.drawable.guruu);
        file_maps.put("Dharamchandradeo Ji Maharaj",R.drawable.guruu3);
        file_maps.put("Swatantradeo Maharaj",R.drawable.guruu2);
        file_maps.put("Vigyandeo Maharaj", R.drawable.guruu4);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        return vv;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent1 = new Intent(getActivity(), Homepagee.class);
        startActivityForResult(myIntent1, 1);
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.framee,new Dataa()).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
