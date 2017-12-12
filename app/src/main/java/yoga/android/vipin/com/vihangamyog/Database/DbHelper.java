package yoga.android.vipin.com.vihangamyog.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vipin.rai on 12/12/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    String DATABASE_NAME="VihangamDb";


    public DbHelper(Context context) {
        super(context, "DbHelper", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String Query="create table AshramData(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name STRING)";
       db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
