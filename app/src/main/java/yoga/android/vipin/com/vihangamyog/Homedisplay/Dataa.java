package yoga.android.vipin.com.vihangamyog.Homedisplay;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.MediaStoreSignature;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import yoga.android.vipin.com.vihangamyog.AudioPlay.Audiomp;
import yoga.android.vipin.com.vihangamyog.Database.WriteFile;
import yoga.android.vipin.com.vihangamyog.Pray.Praylayoutt;
import yoga.android.vipin.com.vihangamyog.R;
import yoga.android.vipin.com.vihangamyog.Uploadpics.ViewAddPhotos;
import yoga.android.vipin.com.vihangamyog.YoutubeAPI.ChannelActivity;

/**
 * Created by vipin.rai on 11/20/2017.
 */

public class Dataa extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    LinearLayout prayy;
     LinearLayout videoss;
     ImageView ivv;
     LinearLayout audiosss,uploadpics;
     StorageReference storageReference;
    Drawable d;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View vv = inflater.inflate(R.layout.content_homepagee, null, false);
        mDemoSlider = (SliderLayout) vv.findViewById(R.id.slider);
        prayy = vv.findViewById(R.id.prayli);
        videoss=vv.findViewById(R.id.watchvid);
        audiosss=vv.findViewById(R.id.audiosss);
        uploadpics=vv.findViewById(R.id.uploadpiccc);
        ivv=vv.findViewById(R.id.vichaarr);
        storageReference= FirebaseStorage.getInstance().getReference();
        StorageReference storageReference1 =storageReference.child("images/a1.jpg");

        try {
            if (isConnected())
            {
                Glide.with(this /* context */)
                        .using(new FirebaseImageLoader())
                        .load(storageReference1)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(ivv);
            }
            else {
            Glide.with(this /* context */)
                    .using(new FirebaseImageLoader())
                    .load(storageReference1)
                    .into(ivv);
        } }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteFile wr=new WriteFile();
        wr.wrii();
        wr.isExternalStorageWritable();
        wr.isExternalStorageReadable();

prayy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ii=new Intent(getActivity(), Praylayoutt.class);
        startActivity(ii);
    }
});
videoss.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent iii=new Intent(getActivity(),ChannelActivity.class);
         startActivity(iii);
    }
});
audiosss.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent iiii=new Intent(getActivity(), Audiomp.class);
        startActivity(iiii);
    }
});
uploadpics.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ii=new Intent(getActivity(), ViewAddPhotos.class);
        startActivity(ii);
    }
});

        //slidding images function in oncreate
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Events", R.drawable.saddg);
        file_maps.put("Events r displayed here", R.drawable.mandir);
        file_maps.put("Path to enlightenment", R.drawable.gurujii);
        file_maps.put("Sadguruji", R.drawable.gurur);
        file_maps.put("asd",R.drawable.gurur);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        return vv;
    }
    public boolean isConnected() throws InterruptedException, IOException
    {
        String command = "ping -c 1 google.com";
        return (Runtime.getRuntime().exec (command).waitFor() == 0);
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("VihangamYoga");
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
