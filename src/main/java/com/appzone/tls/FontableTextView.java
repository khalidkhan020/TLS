package com.appzone.tls;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.appzone.truelovescore.R;


public class FontableTextView extends AppCompatTextView {
    public FontableTextView(Context paramContext) {
        super(paramContext);
    }

    public FontableTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        UiUtil.setCustomFont(this, paramContext, paramAttributeSet, R.styleable.FontableTextView, 0);
    }

    public FontableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        UiUtil.setCustomFont(this, paramContext, paramAttributeSet, R.styleable.FontableTextView, 0);
    }
}
