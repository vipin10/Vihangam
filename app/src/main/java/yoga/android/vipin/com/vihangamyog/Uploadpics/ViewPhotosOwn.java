package yoga.android.vipin.com.vihangamyog.Uploadpics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoga.android.vipin.com.vihangamyog.R;

/**
 * Created by vipin.rai on 12/1/2017.
 */

public class ViewPhotosOwn extends Fragment {
    int mNum;
    RecyclerView rcvvv;

    static ViewPhotosOwn newInstance(int num) {
        ViewPhotosOwn f = new ViewPhotosOwn();

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
        View v = inflater.inflate(R.layout.viewphotosown, container, false);
        rcvvv=v.findViewById(R.id.recyclepicown);
        rcvvv.setAdapter(new Addviewphotos(getContext()));
        rcvvv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }


}

