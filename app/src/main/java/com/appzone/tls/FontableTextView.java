package com.appzone.tls;

import android.content.Context;
import android.util.AttributeSet;

public class FontableTextView extends android.support.v7.widget.AppCompatTextView {
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
