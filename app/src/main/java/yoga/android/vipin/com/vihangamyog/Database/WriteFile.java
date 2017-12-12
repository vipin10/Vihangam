package yoga.android.vipin.com.vihangamyog.Database;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Config;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by vipin.rai on 12/12/2017.
 */

public class WriteFile extends Application{
static String filename="Vihangamdata";
    String string = "Hello world!";
    FileOutputStream outputStream;

    public void wrii(){
        File file=new File(Environment.getExternalStorageDirectory(),filename);
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    public static void main(String Args[]){
    WriteFile ww=new WriteFile();
    ww.isExternalStorageReadable();
    ww.isExternalStorageWritable();

    }





}
