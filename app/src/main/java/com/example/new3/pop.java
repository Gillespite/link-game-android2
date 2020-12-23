package com.example.new3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class pop extends AppCompatActivity {

    str strr;
    private database base1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        strr = new str();

        base1 = new database(this, "base1.db", null, 2);

        Intent intent = getIntent();
        final int score = intent.getIntExtra("score", -1);
        final int level = intent.getIntExtra("level", -1);
        TextView textt = findViewById(R.id.textt);
        textt.setText("您的成绩为" + strr.tostr(score));

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = base1.getWritableDatabase();
                ContentValues values = new ContentValues();
                EditText editText = findViewById(R.id.name);
                values.put("name", editText.getText().toString());
                values.put("score", score);
                values.put("level", level);
                db.insert("rank", null, values);
                //Cursor cursor=db.execSQL("");
                Toast.makeText(pop.this, "上传成功", Toast.LENGTH_SHORT).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(pop.this, rank.class);
                        startActivity(intent);
                    }
                }, 300);
            }
        });
    }
}