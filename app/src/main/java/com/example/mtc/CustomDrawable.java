package com.example.mtc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

public class CustomDrawable extends Drawable {
    private Drawable drawable;
    private int width, height;

    public CustomDrawable(Drawable drawable, int width, int height) {
        this.drawable = drawable;
        this.width = width;
        this.height = height;
        drawable.setBounds(0, 0, width, height);
    }

    @Override
    public void draw(Canvas canvas) {
        drawable.draw(canvas);
    }

    @Override
    public void setAlpha(int alpha) {
        drawable.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
    }

//    @Override
//    public void setColorFilter(ColorFilter colorFilter) {
//        drawable.setColorFilter(colorFilter);
//    }

    @Override
    public int getOpacity() {
        return drawable.getOpacity();
    }
}

