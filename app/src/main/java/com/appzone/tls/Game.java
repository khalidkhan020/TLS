package com.appzone.tls;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends Activity {
    private static final String DATABASE_NAME = "love.db";
    private static final String DATABASE_TABLE = "love";
    int amount;
    Animation animation;
    Builder builder;
    int count_t;
    EditText dilogGfEDT;
    TextView dilogGfTV;
    EditText dilogMeEDT;
    TextView dilogMeTV;
    int fb;
    TextView gfTV;
    Handler handler;
    ImageView image;
    ImageView imageview;
    TextView meTV;
    MediaPlayer media;
    Random random;
    TextView resultTV;
    int rotation;
    int state;

    class C00931 extends Handler {
        C00931() {
        }

        public void handleMessage(Message message) {
            Game game;
            if (Game.this.state != 0) {
                game = Game.this;
                game.count_t--;
                if (Game.this.count_t == 0) {
                    Game.this.state = 0;
                }
            } else {
                game = Game.this;
                game.count_t++;
                if (Game.this.count_t == 100) {
                    Game.this.state = 1;
                }
            }
            Game.this.resultTV.setText(" Luck\n  " + Game.this.count_t + "%");
        }
    }

    class C00982 implements OnTouchListener {

        class C00961 implements OnClickListener {

            class C00941 implements Runnable {
                C00941() {
                }

                public void run() {
                    for (int i = 0; i < Game.this.amount + 400; i++) {
                        try {
                            Game.this.handler.sendMessage(Game.this.handler.obtainMessage());
                            Thread.sleep((long) (1000 / (Game.this.amount + 400)));
                        } catch (Exception exception) {
                            Toast.makeText(Game.this, exception.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                    Game.this.fb = 1;
                    Game.this.media.stop();
                }
            }

            class C00952 implements AnimationListener {
                C00952() {
                }

                public void onAnimationEnd(Animation animation1) {
                    if (Game.this.amount >= 0 && Game.this.amount <= 10) {
                        Toast.makeText(Game.this.getApplicationContext(), "Enemies - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 10 && Game.this.amount <= 20) {
                        Toast.makeText(Game.this.getApplicationContext(), "Some Day Some Way - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 20 && Game.this.amount <= 30) {
                        Toast.makeText(Game.this.getApplicationContext(), "Love is in the AIR - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 30 && Game.this.amount <= 40) {
                        Toast.makeText(Game.this.getApplicationContext(), "Find Someone Else - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 40 && Game.this.amount <= 50) {
                        Toast.makeText(Game.this.getApplicationContext(), "Artificial Relationship - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 50 && Game.this.amount <= 65) {
                        Toast.makeText(Game.this.getApplicationContext(), "Just Best Friends - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 65 && Game.this.amount <= 85) {
                        Toast.makeText(Game.this.getApplicationContext(), "True Love - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (Game.this.amount > 85 && Game.this.amount <= 100) {
                        Toast.makeText(Game.this.getApplicationContext(), "Made for each other - " + Game.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                }

                public void onAnimationRepeat(Animation animation1) {
                }

                public void onAnimationStart(Animation animation1) {
                }
            }

            C00961() {
            }

            public void onClick(DialogInterface dialoginterface, int what) {
                String s2 = Game.this.dilogMeEDT.getText().toString().toLowerCase();
                String s3 = Game.this.dilogGfEDT.getText().toString().toLowerCase();
                if (s2.length() == 0 || s3.length() == 0) {
                    Game.this.fb = 0;
                    Game.this.gfTV.setText("Enter Name");
                    Game.this.meTV.setText("Enter Name");
                    Toast.makeText(Game.this, Game.this.getString(R.string.ans), Toast.LENGTH_LONG).show();
                    return;
                }
                int i;
                Game.this.media = MediaPlayer.create(Game.this.getApplicationContext(), R.raw.wheel);
                Game.this.media.setLooping(true);
                Game.this.media.start();
                if (Game.this.dilogMeEDT.getText().toString().indexOf(" ") != -1) {
                    Game.this.meTV.setText(Game.this.dilogMeEDT.getText().toString().substring(0, Game.this.dilogMeEDT.getText().toString().indexOf(32)));
                } else {
                    Game.this.meTV.setText(Game.this.dilogMeEDT.getText());
                }
                if (Game.this.dilogGfEDT.getText().toString().indexOf(" ") != -1) {
                    Game.this.gfTV.setText(Game.this.dilogGfEDT.getText().toString().substring(0, Game.this.dilogGfEDT.getText().toString().indexOf(32)));
                } else {
                    Game.this.gfTV.setText(Game.this.dilogGfEDT.getText());
                }
                int sumsOfNames = 0;
                for (i = 0; i < s2.length(); i++) {
                    sumsOfNames += s2.charAt(i);
                }
                for (i = 0; i < s3.length(); i++) {
                    sumsOfNames += s3.charAt(i);
                }
                Game.this.amount = 100 - (sumsOfNames % 100);
                Game.this.random = new Random();
                if (Game.this.amount >= 0 && Game.this.amount <= 10) {
                    Game.this.rotation = 22;
                }
                if (Game.this.amount > 10 && Game.this.amount <= 20) {
                    Game.this.rotation = 67;
                }
                if (Game.this.amount > 20 && Game.this.amount <= 30) {
                    Game.this.rotation = 112;
                }
                if (Game.this.amount > 30 && Game.this.amount <= 40) {
                    Game.this.rotation = 157;
                }
                if (Game.this.amount > 40 && Game.this.amount <= 50) {
                    Game.this.rotation = 202;
                }
                if (Game.this.amount > 50 && Game.this.amount <= 65) {
                    Game.this.rotation = 247;
                }
                if (Game.this.amount > 65 && Game.this.amount <= 85) {
                    Game.this.rotation = 293;
                }
                if (Game.this.amount > 85 && Game.this.amount <= 100) {
                    Game.this.rotation = 338;
                }
                Game access$0 = Game.this;
                access$0.rotation += 1440;
                Game.this.animation = new RotateAnimation(0.0f, (float) Game.this.rotation, 1, 0.5f, 1, 0.5f);
                Game.this.animation.setDuration(6000);
                Game.this.animation.setFillAfter(true);
                ScaleAnimation scaleanimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
                scaleanimation.setDuration(600);
                scaleanimation.setRepeatCount(9);
                scaleanimation.setRepeatMode(2);
                scaleanimation.setFillAfter(true);
                Thread thread = new Thread(new C00941());
                Game.this.state = 0;
                Game.this.count_t = 0;
                Game.this.imageview.startAnimation(scaleanimation);
                Game.this.image.startAnimation(Game.this.animation);
                scaleanimation.setAnimationListener(new C00952());
                thread.start();
                SQLiteDatabase sQLiteDatabase = null;
                ContentValues contentvalues = null;
                try {
                    sQLiteDatabase = Game.this.getApplicationContext().openOrCreateDatabase(Game.DATABASE_NAME, 0, null);
                    ContentValues contentvalues2 = new ContentValues();
                    try {
                        Cursor cursor = sQLiteDatabase.query(Game.DATABASE_TABLE, new String[]{"col1", "col3", "col2"}, null, null, null, null, null, null);
                        cursor.moveToFirst();
                        if (cursor.getString(cursor.getColumnIndex("col1")).equals(Game.this.dilogMeEDT.getText().toString()) && cursor.getString(cursor.getColumnIndex("col2")).equals(Game.this.dilogGfEDT.getText().toString())) {
                            return;
                        }
                        contentvalues2.put("col1", Game.this.dilogMeEDT.getText().toString());
                        contentvalues2.put("col3", new StringBuilder(String.valueOf(Game.this.amount)).append("%").toString());
                        contentvalues2.put("col2", Game.this.dilogGfEDT.getText().toString());
                        sQLiteDatabase.insert(Game.DATABASE_TABLE, null, contentvalues2);
                        sQLiteDatabase.close();
                        contentvalues = contentvalues2;
                    } catch (Exception e) {
                        contentvalues = contentvalues2;
                        contentvalues.put("col1", Game.this.dilogMeEDT.getText().toString());
                        contentvalues.put("col3", new StringBuilder(String.valueOf(Game.this.amount)).append("%").toString());
                        contentvalues.put("col2", Game.this.dilogGfEDT.getText().toString());
                        sQLiteDatabase.insert(Game.DATABASE_TABLE, null, contentvalues);
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    contentvalues.put("col1", Game.this.dilogMeEDT.getText().toString());
                    contentvalues.put("col3", new StringBuilder(String.valueOf(Game.this.amount)).append("%").toString());
                    contentvalues.put("col2", Game.this.dilogGfEDT.getText().toString());
                    sQLiteDatabase.insert(Game.DATABASE_TABLE, null, contentvalues);
                    sQLiteDatabase.close();
                }
            }
        }

        class C00972 implements OnClickListener {
            C00972() {
            }

            public void onClick(DialogInterface dialoginterface, int what) {
                Game.this.fb = 0;
                Game.this.gfTV.setText("Enter Name");
                Game.this.meTV.setText("Enter Name");
            }
        }

        C00982() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            try {
                Game.this.builder = new Builder(Game.this);
                Game.this.dilogMeEDT = new EditText(Game.this);
                Game.this.dilogGfEDT = new EditText(Game.this);
                Game.this.dilogMeTV = new TextView(Game.this);
                Game.this.dilogGfTV = new TextView(Game.this);
                Game.this.dilogGfTV.setText(Game.this.getString(R.string.love));
                Game.this.dilogGfTV.setPadding(10, 0, 0, 0);
                Game.this.dilogMeTV.setText(Game.this.getString(R.string.me));
                Game.this.dilogMeTV.setPadding(10, 0, 0, 0);
                LinearLayout linearlayout = new LinearLayout(Game.this);
                linearlayout.setOrientation(LinearLayout.VERTICAL);
                linearlayout.addView(Game.this.dilogMeTV);
                linearlayout.addView(Game.this.dilogMeEDT);
                linearlayout.addView(Game.this.dilogGfTV);
                linearlayout.addView(Game.this.dilogGfEDT);
                Game.this.builder.setView(linearlayout);
                Game.this.builder.setCancelable(false);
                Game.this.builder.setTitle("Please provide the two Name");
                Game.this.builder.setPositiveButton("Find Love Score", new C00961());
                Game.this.builder.setNegativeButton("Cancel", new C00972());
                Game.this.builder.show();
            } catch (Exception exception) {
                Toast.makeText(Game.this, exception.toString(), Toast.LENGTH_LONG).show();
            }
            return false;
        }
    }

    private void findAllViews() {
        this.image = (ImageView) findViewById(R.id.imageView1);
        this.imageview = (ImageView) findViewById(R.id.imageView2);
        this.resultTV = (TextView) findViewById(R.id.count);
        this.meTV = (TextView) findViewById(R.id.textView_m);
        this.gfTV = (TextView) findViewById(R.id.textView_f);
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.main);
        FrameLayout addholder = (FrameLayout) findViewById(R.id.lladd);

        this.handler = new C00931();
        findAllViews();
        ((LinearLayout) findViewById(R.id.layout)).setOnTouchListener(new C00982());
    }

    private void inserValueInDB() {
    }
}
