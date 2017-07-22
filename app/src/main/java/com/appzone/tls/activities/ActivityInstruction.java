package com.appzone.tls.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.appzone.tls.R;

public class ActivityInstruction extends Activity {

    public void onCreate(Bundle bundle) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.activity_instruction);
        super.onCreate(bundle);
        findViewById(R.id.back_i).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityInstruction.this.finish();
            }
        });
    }
}
