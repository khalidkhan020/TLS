package com.appzone.tls.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.appzone.tls.R;


public class ActivitySplash extends Activity {


    public void onCreate(Bundle bundle) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivitySplash.this.startActivity(new Intent(ActivitySplash.this, ActivityMenu.class));
                ActivitySplash.this.finish();
            }
        }, 2000);
        String s = "create table " + "love" + " (_id  INTEGER PRIMARY KEY AUTOINCREMENT, col1 text not null unique,col3 text not null, col2 text not null unique);";
        SQLiteDatabase sqlitedatabase = getApplicationContext().openOrCreateDatabase("love.db", 0, null);
        try {
            sqlitedatabase.execSQL(s);
        } catch (Exception e) {
        }
        sqlitedatabase.close();
    }
}
