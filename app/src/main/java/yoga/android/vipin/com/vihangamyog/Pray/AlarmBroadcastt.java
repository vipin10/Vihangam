package yoga.android.vipin.com.vihangamyog.Pray;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by vipin.rai on 6/26/2018.
 */

public class AlarmBroadcastt extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm started",Toast.LENGTH_LONG).show();
    }
}
