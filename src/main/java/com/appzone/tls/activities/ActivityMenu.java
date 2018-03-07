package com.appzone.tls.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.appzone.truelovescore.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ActivityMenu extends Activity implements OnClickListener {

    AdView adView;
    public void onCreate(Bundle bundle) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(bundle);
        setContentView(R.layout.activity_manu);
        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.history_btn).setOnClickListener(this);
        findViewById(R.id.abt_btn).setOnClickListener(this);
        findViewById(R.id.instruction_btn).setOnClickListener(this);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityGame.class));
                break;
            case R.id.history_btn:
                startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityHistory.class));
                break;
            case R.id.instruction_btn:
              startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityInstruction.class));
                break;
            case R.id.abt_btn:
              startActivity(new Intent(ActivityMenu.this.getApplicationContext(), ActivityAboutUs.class));
                break;
        }
    }
}
