package com.example.new3;

public class str {
    public int to(String a){
        return Integer.valueOf(a);
    }

    public int toint(String a){
        //Log.d("fuck",a.substring(0,2)+","+a.substring(3,5)+","+a.substring(6,8));
        //return 1;
        return to(a.substring(0,2))*60*60+to(a.substring(3,5))*60+to(a.substring(6,8));
    }

    public String tostr(int t){
        return t/(60)+"分 "+t%60+"秒";
    }
}
