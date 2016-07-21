package itrmu.worawit.mydbsqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public  MyDBHelper helper;
    public  MyDBManage dbm;

    // ชุดที่เก็บข้อมูลที่ได้จาก db
    public Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // เรียกใช้งานคลาส MyDBManage
        dbm=new MyDBManage(this);
        // เปิดใช้
        dbm.openDB();

        // เพิ่มข้อมูล ลง db
        dbm.addStudent("123456789","วรวิทย์ สังฆทิพย์","worawith.n@gmail.com","0850055602");
        dbm.addStudent("44444","วีระ","worawith.n@gmail.com","0850055602");

        // เรียกใช้เมธอด queryStudent ที่คืนค่าเป็น Cursor
        cursor=dbm.queryStudent();

        // ไปยัง row ที่ 0
        cursor.moveToPosition(1);

        // ดึง column ที่ 1 ของ row ที่ 0
        String name=cursor.getString(1);

        Toast.makeText(this,""+name,Toast.LENGTH_SHORT).show();

    }
}
