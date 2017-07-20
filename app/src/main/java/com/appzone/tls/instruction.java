package com.appzone.tls;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class instruction extends Activity {

    class C01101 implements OnClickListener {
        C01101() {
        }

        public void onClick(View view) {
            instruction.this.finish();
        }
    }


    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);

        setContentView(R.layout.instruction);
        FrameLayout addholder = (FrameLayout) findViewById(R.id.lladd);

        super.onCreate(bundle);
        ((Button) findViewById(R.id.back_i)).setOnClickListener(new C01101());
    }
}
