package com.appzone.tls;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class History extends Activity {

    class C00991 implements OnClickListener {
        C00991() {
        }

        public void onClick(View view) {
            SQLiteDatabase sqlitedatabase1 = History.this.openOrCreateDatabase("love.db", 0, null);
            sqlitedatabase1.delete("love", null, null);
            sqlitedatabase1.close();
            History.this.startActivity(new Intent(History.this, Manu.class));
            History.this.finish();
        }
    }

    class C01002 implements OnClickListener {
        C01002() {
        }

        public void onClick(View view) {
            History.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);

        super.onCreate(bundle);
        setContentView(R.layout.history);
        ListView listView = (ListView) findViewById(R.id.history_list);
        FrameLayout addholder = (FrameLayout) findViewById(R.id.lladd);
        SQLiteDatabase sqlitedatabase = openOrCreateDatabase("love.db", 0, null);
        Cursor cursor = sqlitedatabase.query("love", null, null, null, null, null, null, null);
        cursor.moveToFirst();
        listView.setAdapter(new SimpleCursorAdapter(this, R.layout.history_list_item, cursor, new String[]{"col1", "col3", "col2"}, new int[]{R.id.me, R.id.percent, R.id.lover}));
        ((Button) findViewById(R.id.clear)).setOnClickListener(new C00991());
        ((Button) findViewById(R.id.back_h)).setOnClickListener(new C01002());
        sqlitedatabase.close();
    }
}
