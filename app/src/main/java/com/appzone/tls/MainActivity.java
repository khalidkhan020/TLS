package com.appzone.tls;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;


public class MainActivity extends Activity {
    Handler handler;
    SeekBar seekbar;
    Thread start;

    class C01011 extends Handler {
        C01011() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    class C01022 implements Runnable {
        C01022() {
        }

        public void run() {
            for (int i = 0; i < 150; i++) {
                try {
                    MainActivity.this.handler.sendMessage(MainActivity.this.handler.obtainMessage());
                    Thread.sleep(20);
                } catch (Exception e) {
                }
            }
            MainActivity.this.startActivity(new Intent(MainActivity.this, Manu.class));
             MainActivity.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.front);
        this.handler = new C01011();
        this.start = new Thread(new C01022());
        String s = "create table " + "love" + " (_id  INTEGER PRIMARY KEY AUTOINCREMENT, col1 text not null unique,col3 text not null, col2 text not null unique);";
        SQLiteDatabase sqlitedatabase = getApplicationContext().openOrCreateDatabase("love.db", 0, null);
        try {
            sqlitedatabase.execSQL(s);
        } catch (Exception e) {
        }
        sqlitedatabase.close();
        this.start.start();
    }
}
