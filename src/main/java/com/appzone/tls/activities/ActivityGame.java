package com.appzone.tls.activities;

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
import android.view.Window;
import android.view.WindowManager;
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


import com.appzone.truelovescore.R;

import java.util.Random;

public class ActivityGame extends Activity {
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


    public void onCreate(Bundle bundle) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.main);
        this.handler = new C00931();
        findAllViews();

        findViewById(R.id.layout).setOnTouchListener(new C00982());
    }

    private void findAllViews() {
        this.image = findViewById(R.id.imageView1);
        this.imageview =  findViewById(R.id.imageView2);
        this.resultTV = findViewById(R.id.count);
        this.meTV = findViewById(R.id.textView_m);
        this.gfTV = findViewById(R.id.textView_f);
    }

    class C00931 extends Handler {
        C00931() {
        }

        public void handleMessage(Message message) {
            ActivityGame game;
            if (ActivityGame.this.state != 0) {
                game = ActivityGame.this;
                game.count_t--;
                if (ActivityGame.this.count_t == 0) {
                    ActivityGame.this.state = 0;
                }
            } else {
                game = ActivityGame.this;
                game.count_t++;
                if (ActivityGame.this.count_t == 100) {
                    ActivityGame.this.state = 1;
                }
            }
            ActivityGame.this.resultTV.setText(" Luck\n  " + ActivityGame.this.count_t + "%");
        }
    }

    class C00982 implements OnTouchListener {

        class C00961 implements OnClickListener {

            class C00941 implements Runnable {
                C00941() {
                }

                public void run() {
                    for (int i = 0; i < ActivityGame.this.amount + 400; i++) {
                        try {
                            ActivityGame.this.handler.sendMessage(ActivityGame.this.handler.obtainMessage());
                            Thread.sleep((long) (1000 / (ActivityGame.this.amount + 400)));
                        } catch (Exception exception) {
                            Toast.makeText(ActivityGame.this, exception.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                    ActivityGame.this.fb = 1;
                    ActivityGame.this.media.stop();
                }
            }

            class C00952 implements AnimationListener {
                C00952() {
                }

                public void onAnimationEnd(Animation animation1) {
                    if (ActivityGame.this.amount >= 0 && ActivityGame.this.amount <= 10) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Enemies - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 10 && ActivityGame.this.amount <= 20) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Some Day Some Way - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 20 && ActivityGame.this.amount <= 30) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Love is in the AIR - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 30 && ActivityGame.this.amount <= 40) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Find Someone Else - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 40 && ActivityGame.this.amount <= 50) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Artificial Relationship - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 50 && ActivityGame.this.amount <= 65) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Just Best Friends - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 65 && ActivityGame.this.amount <= 85) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "True Love - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
                    }
                    if (ActivityGame.this.amount > 85 && ActivityGame.this.amount <= 100) {
                        Toast.makeText(ActivityGame.this.getApplicationContext(), "Made for each other - " + ActivityGame.this.amount + "%", Toast.LENGTH_LONG).show();
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
                String s2 = ActivityGame.this.dilogMeEDT.getText().toString().toLowerCase();
                String s3 = ActivityGame.this.dilogGfEDT.getText().toString().toLowerCase();
                if (s2.length() == 0 || s3.length() == 0) {
                    ActivityGame.this.fb = 0;
                    ActivityGame.this.gfTV.setText("Enter Name");
                    ActivityGame.this.meTV.setText("Enter Name");
                    Toast.makeText(ActivityGame.this, ActivityGame.this.getString(R.string.ans), Toast.LENGTH_LONG).show();
                    return;
                }
                int i;
                ActivityGame.this.media = MediaPlayer.create(ActivityGame.this.getApplicationContext(), R.raw.wheel);
                ActivityGame.this.media.setLooping(true);
                ActivityGame.this.media.start();
                if (ActivityGame.this.dilogMeEDT.getText().toString().indexOf(" ") != -1) {
                    ActivityGame.this.meTV.setText(ActivityGame.this.dilogMeEDT.getText().toString().substring(0, ActivityGame.this.dilogMeEDT.getText().toString().indexOf(32)));
                } else {
                    ActivityGame.this.meTV.setText(ActivityGame.this.dilogMeEDT.getText());
                }
                if (ActivityGame.this.dilogGfEDT.getText().toString().indexOf(" ") != -1) {
                    ActivityGame.this.gfTV.setText(ActivityGame.this.dilogGfEDT.getText().toString().substring(0, ActivityGame.this.dilogGfEDT.getText().toString().indexOf(32)));
                } else {
                    ActivityGame.this.gfTV.setText(ActivityGame.this.dilogGfEDT.getText());
                }
                int sumsOfNames = 0;
                for (i = 0; i < s2.length(); i++) {
                    sumsOfNames += s2.charAt(i);
                }
                for (i = 0; i < s3.length(); i++) {
                    sumsOfNames += s3.charAt(i);
                }
                ActivityGame.this.amount = 100 - (sumsOfNames % 100);
                ActivityGame.this.random = new Random();
                if (ActivityGame.this.amount >= 0 && ActivityGame.this.amount <= 10) {
                    ActivityGame.this.rotation = 22;
                }
                if (ActivityGame.this.amount > 10 && ActivityGame.this.amount <= 20) {
                    ActivityGame.this.rotation = 67;
                }
                if (ActivityGame.this.amount > 20 && ActivityGame.this.amount <= 30) {
                    ActivityGame.this.rotation = 112;
                }
                if (ActivityGame.this.amount > 30 && ActivityGame.this.amount <= 40) {
                    ActivityGame.this.rotation = 157;
                }
                if (ActivityGame.this.amount > 40 && ActivityGame.this.amount <= 50) {
                    ActivityGame.this.rotation = 202;
                }
                if (ActivityGame.this.amount > 50 && ActivityGame.this.amount <= 65) {
                    ActivityGame.this.rotation = 247;
                }
                if (ActivityGame.this.amount > 65 && ActivityGame.this.amount <= 85) {
                    ActivityGame.this.rotation = 293;
                }
                if (ActivityGame.this.amount > 85 && ActivityGame.this.amount <= 100) {
                    ActivityGame.this.rotation = 338;
                }
                ActivityGame access$0 = ActivityGame.this;
                access$0.rotation += 1440;
                ActivityGame.this.animation = new RotateAnimation(0.0f, (float) ActivityGame.this.rotation, 1, 0.5f, 1, 0.5f);
                ActivityGame.this.animation.setDuration(6000);
                ActivityGame.this.animation.setFillAfter(true);
                ScaleAnimation scaleanimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
                scaleanimation.setDuration(600);
                scaleanimation.setRepeatCount(9);
                scaleanimation.setRepeatMode(2);
                scaleanimation.setFillAfter(true);
                Thread thread = new Thread(new C00941());
                ActivityGame.this.state = 0;
                ActivityGame.this.count_t = 0;
                ActivityGame.this.imageview.startAnimation(scaleanimation);
                ActivityGame.this.image.startAnimation(ActivityGame.this.animation);
                scaleanimation.setAnimationListener(new C00952());
                thread.start();
                SQLiteDatabase sQLiteDatabase = null;
                ContentValues contentvalues = null;
                try {
                    sQLiteDatabase = ActivityGame.this.getApplicationContext().openOrCreateDatabase(ActivityGame.DATABASE_NAME, 0, null);
                    ContentValues contentvalues2 = new ContentValues();
                    try {
                        Cursor cursor = sQLiteDatabase.query(ActivityGame.DATABASE_TABLE, new String[]{"col1", "col3", "col2"}, null, null, null, null, null, null);
                        cursor.moveToFirst();
                        if (cursor.getString(cursor.getColumnIndex("col1")).equals(ActivityGame.this.dilogMeEDT.getText().toString()) && cursor.getString(cursor.getColumnIndex("col2")).equals(ActivityGame.this.dilogGfEDT.getText().toString())) {
                            return;
                        }
                        contentvalues2.put("col1", ActivityGame.this.dilogMeEDT.getText().toString());
                        contentvalues2.put("col3", new StringBuilder(String.valueOf(ActivityGame.this.amount)).append("%").toString());
                        contentvalues2.put("col2", ActivityGame.this.dilogGfEDT.getText().toString());
                        sQLiteDatabase.insert(ActivityGame.DATABASE_TABLE, null, contentvalues2);
                        sQLiteDatabase.close();
                        contentvalues = contentvalues2;
                    } catch (Exception e) {
                        contentvalues = contentvalues2;
                        contentvalues.put("col1", ActivityGame.this.dilogMeEDT.getText().toString());
                        contentvalues.put("col3", new StringBuilder(String.valueOf(ActivityGame.this.amount)).append("%").toString());
                        contentvalues.put("col2", ActivityGame.this.dilogGfEDT.getText().toString());
                        sQLiteDatabase.insert(ActivityGame.DATABASE_TABLE, null, contentvalues);
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    contentvalues.put("col1", ActivityGame.this.dilogMeEDT.getText().toString());
                    contentvalues.put("col3", new StringBuilder(String.valueOf(ActivityGame.this.amount)).append("%").toString());
                    contentvalues.put("col2", ActivityGame.this.dilogGfEDT.getText().toString());
                    sQLiteDatabase.insert(ActivityGame.DATABASE_TABLE, null, contentvalues);
                    sQLiteDatabase.close();
                }
            }
        }

        class C00972 implements OnClickListener {
            C00972() {
            }

            public void onClick(DialogInterface dialoginterface, int what) {
                ActivityGame.this.fb = 0;
                ActivityGame.this.gfTV.setText("Enter Name");
                ActivityGame.this.meTV.setText("Enter Name");
            }
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            try {
                ActivityGame.this.builder = new Builder(ActivityGame.this);
                ActivityGame.this.dilogMeEDT = new EditText(ActivityGame.this);
                ActivityGame.this.dilogGfEDT = new EditText(ActivityGame.this);
                ActivityGame.this.dilogMeTV = new TextView(ActivityGame.this);
                ActivityGame.this.dilogGfTV = new TextView(ActivityGame.this);
                ActivityGame.this.dilogGfTV.setText(ActivityGame.this.getString(R.string.love));
                ActivityGame.this.dilogGfTV.setPadding(10, 0, 0, 0);
                ActivityGame.this.dilogMeTV.setText(ActivityGame.this.getString(R.string.me));
                ActivityGame.this.dilogMeTV.setPadding(10, 0, 0, 0);
                LinearLayout linearlayout = new LinearLayout(ActivityGame.this);
                linearlayout.setOrientation(LinearLayout.VERTICAL);
                linearlayout.addView(ActivityGame.this.dilogMeTV);
                linearlayout.addView(ActivityGame.this.dilogMeEDT);
                linearlayout.addView(ActivityGame.this.dilogGfTV);
                linearlayout.addView(ActivityGame.this.dilogGfEDT);
                ActivityGame.this.builder.setView(linearlayout);
                ActivityGame.this.builder.setCancelable(false);
                ActivityGame.this.builder.setTitle("Please provide the two Name");
                ActivityGame.this.builder.setPositiveButton("Find Love Score", new C00961());
                ActivityGame.this.builder.setNegativeButton("Cancel", new C00972());
                ActivityGame.this.builder.show();
            } catch (Exception exception) {
                Toast.makeText(ActivityGame.this, exception.toString(), Toast.LENGTH_LONG).show();
            }
            return false;
        }
    }


}
