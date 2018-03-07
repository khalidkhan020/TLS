package com.appzone.tls.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.appzone.truelovescore.R;


public class ActivityHistory extends Activity implements OnClickListener {


    public void onCreate(Bundle bundle) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.activity_history);
        ListView listView = findViewById(R.id.history_list);
        SQLiteDatabase sqlitedatabase = openOrCreateDatabase("love.db", 0, null);
        Cursor cursor = sqlitedatabase.query("love", null, null, null, null, null, null, null);
        cursor.moveToFirst();
        listView.setAdapter(new SimpleCursorAdapter(this, R.layout.history_list_item, cursor, new String[]{"col1", "col3", "col2"}, new int[]{R.id.me, R.id.percent, R.id.lover}));
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.back_h).setOnClickListener(this);
        sqlitedatabase.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                SQLiteDatabase sqlitedatabase1 = ActivityHistory.this.openOrCreateDatabase("love.db", 0, null);
                sqlitedatabase1.delete("love", null, null);
                sqlitedatabase1.close();
                startActivity(new Intent(ActivityHistory.this, ActivityMenu.class));
                finish();
                break;
            case R.id.back_h:
                finish();
                break;
        }
    }
}
