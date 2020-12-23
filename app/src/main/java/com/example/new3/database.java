package com.example.new3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public static final String CREATE_BASE
            ="create table rank("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"score integer,"
            +"level integer)";

    private Context mycontext;
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mycontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BASE);
        db.execSQL("insert into rank(name,score,level) values(\"admin\",123,2);");
        Toast.makeText(mycontext,"数据库建立成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists rank");
    }
}
