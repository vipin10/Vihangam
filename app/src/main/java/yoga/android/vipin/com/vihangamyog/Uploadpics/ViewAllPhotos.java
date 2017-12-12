package yoga.android.vipin.com.vihangamyog.Uploadpics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import yoga.android.vipin.com.vihangamyog.R;
import yoga.android.vipin.com.vihangamyog.Videosguruji.Videosview;

/**
 * Created by vipin.rai on 12/1/2017.
 */

public class ViewAllPhotos extends Fragment {
    int mNum;
     RecyclerView rcv;

    static ViewAllPhotos newInstance(int num) {
        ViewAllPhotos f = new ViewAllPhotos();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewallphotos, container, false);
        rcv=v.findViewById(R.id.recyclepicall);
        rcv.setAdapter(new Addviewphotos(getContext()));
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }


}