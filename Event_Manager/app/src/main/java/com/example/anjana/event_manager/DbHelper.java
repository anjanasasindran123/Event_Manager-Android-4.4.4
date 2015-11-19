package com.example.anjana.event_manager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;



/**
 * Created by anjana on 19/11/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db;
    public static final String DB_NAME = "Newuser.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "newuserapplication";
    public static final String COLUMN_NAME_UNAME = "username";
    public static final String COLUMN_NAME_PASS = "password";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_MOBL = "mobnum";
    public static final String COLUMN_NAME_DATE = "eventdate";

    public static final String LOGIN_TABLE_NAME = "logindetails";




    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ("+ COLUMN_NAME_UNAME + " TEXT NOT NULL, " +
            COLUMN_NAME_PASS + " TEXT NOT NULL, " + COLUMN_NAME_EMAIL + " TEXT NOT NULL, " +
            COLUMN_NAME_MOBL + " TEXT NOT NULL, " + COLUMN_NAME_DATE + " TEXT);";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DbHelper(Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate ( SQLiteDatabase db ) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
