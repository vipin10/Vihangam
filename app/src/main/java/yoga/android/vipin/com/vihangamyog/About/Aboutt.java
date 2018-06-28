package yoga.android.vipin.com.vihangamyog.About;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;
import java.util.Locale;
import yoga.android.vipin.com.vihangamyog.Homedisplay.Dataa;
import yoga.android.vipin.com.vihangamyog.Initials.Homepagee;
import yoga.android.vipin.com.vihangamyog.R;

public class Aboutt extends Fragment {
Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vvv=inflater.inflate(R.layout.activity_aboutt,null,true);
        Locale locale = new Locale("hi");
        Configuration config = getActivity().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
        return vvv;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getActivity(), Homepagee.class);
        startActivityForResult(myIntent, 0);
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
                    toolbar.setTitle("Vihangam Yoga");
                    ft.replace(R.id.framee,new Dataa()).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
