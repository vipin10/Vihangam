package yoga.android.vipin.com.vihangamyog.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by vipin.rai on 12/12/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

   Context context;

    public DbHelper(Context context) {
        super(context, "DbHelper", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String Query="create table AshramData(ID INTEGER PRIMARY KEY AUTOINCREMENT,Alarmdate STRING,rowid INTEGER)";
       db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists AshramData");
        onCreate(db);
    }

    public void insertData(String dataDate, int rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Alarmdate", dataDate);
        cv.put("rowid", rowId);
        db.insert("AshramData", null, cv);
    }

    public void updateData(String dataDate, int rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Alarmdate", dataDate);
        cv.put("rowid", rowId);
        db.update("AshramData",cv,null, null);
    }

}
