package com.appzone.tls.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.appzone.truelovescore.R;

public class ActivityMenu extends Activity implements OnClickListener {


    public void onCreate(Bundle bundle) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.activity_manu);
        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.history_btn).setOnClickListener(this);
        findViewById(R.id.exit_btn).setOnClickListener(this);
        findViewById(R.id.abt_btn).setOnClickListener(this);
        findViewById(R.id.instruction_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                ActivityMenu.this.startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityGame.class));
                break;
            case R.id.history_btn:
                ActivityMenu.this.startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityHistory.class));
                break;
            case R.id.instruction_btn:
                ActivityMenu.this.startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityInstruction.class));
                break;
            case R.id.abt_btn:
                ActivityMenu.this.startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityAboutUs.class));
                break;
            case R.id.exit_btn:
                        ActivityMenu.this.finish();

                break;
        }
    }
}
