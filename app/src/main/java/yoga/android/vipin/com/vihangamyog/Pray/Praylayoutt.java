package yoga.android.vipin.com.vihangamyog.Pray;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import yoga.android.vipin.com.vihangamyog.R;

public class Praylayoutt extends AppCompatActivity {
Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praylayoutt);
        toolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        toolbar1.setBackgroundColor(R.color.colorAccent);
        toolbar1.setTitle("Pray");
    }


}
