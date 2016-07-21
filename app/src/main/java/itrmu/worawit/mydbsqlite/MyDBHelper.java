package itrmu.worawit.mydbsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by worawit on 10/13/2015.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    public  static String DBName="StudentDB";
    public static String TBName="tb_student";
    public  static String col_stdID="_std_id";
    public static String col_stdName="std_name";
    public static String col_stdEmail="std_email";
    public static String col_stdTel="std_tel";
    private static int DBVersion=3;

    public String createTable="CREATE TABLE "+TBName+" ("+
            col_stdID+" integer PRIMARY KEY,"+
            col_stdName+" varchar(50) not null,"+
            col_stdEmail+" varchar(100) null,"+
            col_stdTel+" varchar(10) null)";


    // Constructor method
    // สร้างฐานข้อมูล ในเมธอท นี้
    public MyDBHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    // สร้าง Table ในเมธอท นี้
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    // เวลาเปลี่ยนแปลงโครงสร้าง Table จะทำงานที่เมธอท นี้
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBName);
        onCreate(db);
    }

}
