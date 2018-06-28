package yoga.android.vipin.com.vihangamyog.Settingss;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 6/21/2018.
 */

public class Feedbackp extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View vv=inflater.inflate(R.layout.feedback_page,container,false);
        return vv;
    }
}
