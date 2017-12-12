package yoga.android.vipin.com.vihangamyog.Uploadpics;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vipin.rai on 12/1/2017.
 */

public class Uploadpicsadapt extends FragmentPagerAdapter {
    public Uploadpicsadapt(FragmentManager fm, int tabCount) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment ff=new Fragment();
        if (position==0){
           ff= ViewPhotosOwn.newInstance(position);
        }else if(position==1){
           ff= ViewAllPhotos.newInstance(position);

        }
        return ff ;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
