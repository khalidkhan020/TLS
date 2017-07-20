package com.appzone.tls;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;


public class AboutUs extends Activity {

    class C00921 implements OnClickListener {
        C00921() {
        }

        public void onClick(View view) {
            AboutUs.this.finish();
        }
    }


    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);

        setContentView(R.layout.about);
        FrameLayout addholder = (FrameLayout) findViewById(R.id.lladd);

        ((Button) findViewById(R.id.back_a)).setOnClickListener(new C00921());
    }
}
