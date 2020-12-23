package com.example.new3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class rank_item_adapter extends ArrayAdapter<item_data> {
    private int resourceId;
    public rank_item_adapter(Context context, int textViewResourceId, List<item_data> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        item_data item=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView name=view.findViewById(R.id.t1);
        TextView score=view.findViewById(R.id.t2);
        TextView level=view.findViewById(R.id.t3);
        str strr=new str();
        name.setText("姓名:"+item.getName());
        score.setText("用时:"+strr.tostr(item.getScore()));
        if(item.getLevel()==1){
            level.setText("难度:简单");
        }else if(item.getLevel()==2){
            level.setText("难度:一般");
        }else if(item.getLevel()==3){
            level.setText("难度:困难");
        }
        //return super.getView(position, convertView, parent);
        return view;
    }
}
