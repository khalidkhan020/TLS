package com.appzone.tls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class Manu extends Activity {
    int count;

    class C01031 implements OnClickListener {
        C01031() {
        }

        public void onClick(View view) {
              Manu.this.startActivity(new Intent(Manu.this.getApplicationContext(), Game.class));
        }
    }

    class C01042 implements OnClickListener {
        C01042() {
        }

        public void onClick(View view) {
            Manu.this.startActivity(new Intent(Manu.this.getApplicationContext(), History.class));
        }
    }

    class C01063 implements OnClickListener {

        class C01051 implements Runnable {
            C01051() {
            }

            public void run() {
                Manu.this.finish();
            }
        }

        C01063() {
        }

        public void onClick(View view) {

            new Handler().postDelayed(new C01051(), 3000);
        }
    }

    class C01074 implements OnClickListener {
        C01074() {
        }

        public void onClick(View view) {
              Manu.this.startActivity(new Intent(Manu.this.getApplicationContext(), AboutUs.class));
        }
    }

    class C01085 implements OnClickListener {
        C01085() {
        }

        public void onClick(View view) {
              Manu.this.startActivity(new Intent(Manu.this.getApplicationContext(), instruction.class));
        }
    }


    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);

        setContentView(R.layout.manu);
        FrameLayout addholder = (FrameLayout) findViewById(R.id.lladd);


        ((Button) findViewById(R.id.start_btn)).setOnClickListener(new C01031());
        ((Button) findViewById(R.id.history_btn)).setOnClickListener(new C01042());
        ((Button) findViewById(R.id.exit_btn)).setOnClickListener(new C01063());
        ((Button) findViewById(R.id.abt_btn)).setOnClickListener(new C01074());
        ((Button) findViewById(R.id.instruction_btn)).setOnClickListener(new C01085());
    }
}
