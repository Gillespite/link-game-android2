package com.example.new3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class rank extends AppCompatActivity {

    private database base1;
    SQLiteDatabase db;

    public List<item_data> itemlist=new ArrayList<item_data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        base1 = new database(this, "base1.db", null, 2);

        db = base1.getWritableDatabase();

        init();

        rank_item_adapter adapter=new rank_item_adapter(rank.this,R.layout.rank_item,itemlist);

        ListView listView=findViewById(R.id.ranklist);
        listView.setAdapter(adapter);

        Button bt1=findViewById(R.id.back);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rank.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        Cursor cursor = db.rawQuery("select * from rank order by score asc;", null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int score = cursor.getInt(cursor.getColumnIndex("score"));
                int level = cursor.getInt(cursor.getColumnIndex("level"));
                item_data item=new item_data(name,score,level);
                itemlist.add(item);
                //Log.d("fuck", "name is " + name);
                //Log.d("fuck", "score is " + score);
                //Log.d("fuck", "level is " + level);
            } while (cursor.moveToNext());
        }
    }
}