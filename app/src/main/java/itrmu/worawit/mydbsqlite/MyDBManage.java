package itrmu.worawit.mydbsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by worawit on 10/13/2015.
 */
// คลาสนี้สร้างไว้ สำหรับจัดการฐานข้อมูล คือ เปิด ปิด ฐานข้อมูล และแสดง เพิ่ม ลบ แก้ไข ฐานข้อมูล
public class MyDBManage {

    // เรียกใช้คลาส MyDBHelper ของเรา
    private MyDBHelper helper;

    // คลาสแอนดรอยด์มีให้ สำหรับจัดการฐานข้อมูล แสดง เพิ่ม ลบ แก้ไข
    private SQLiteDatabase db;

    // constructor method
    public MyDBManage(Context context) {
        // เรียกใช้คลาส MyDBHelper
        helper=new MyDBHelper(context);
    }

    // เมธอท สำหรับเปิดฐานข้อมูล
    public void openDB(){
        // คำสั่งเปิดฐานข้อมูล โดยสามารถอ่านและเขียนข้อมูลลงได้
        db=helper.getWritableDatabase();
    }

    // เมธอท สำหรับปิดฐานข้อมูล
    public void closeDB(){
        // คำสั่งปิดฐานข้อมูล
        helper.close();
    }

    // เมธอท insert
    public void addStudent(String id,String name,String email,String tel){

        ContentValues values=new ContentValues();
        values.put(helper.col_stdID,id);
        values.put(helper.col_stdName,name);
        values.put(helper.col_stdEmail,email);
        values.put(helper.col_stdTel,tel);

        // คำสั่งในการ insert
        db.insert(helper.TBName, null, values);
    }

    // เมธอท ดึงข้อมูล
    public Cursor queryStudent(){
        String[] data={helper.col_stdID,helper.col_stdName,helper.col_stdEmail,helper.col_stdTel};

       return db.query(helper.TBName,data,null,null,null,null,null);
    }








}
