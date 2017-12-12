package yoga.android.vipin.com.vihangamyog.History;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 11/27/2017.
 */

public class Babaji extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
View view1;
RecyclerView rvv;
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
        file_maps.put("Ashram 2",R.drawable.mandir);
        file_maps.put("Ashram 1",R.drawable.mandir1);
        file_maps.put("Ashram 3",R.drawable.mandir4);
        file_maps.put("Ashram 4", R.drawable.mandir5);


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
}
