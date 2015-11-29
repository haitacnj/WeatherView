package com.example.khoa.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.example.khoa.support.kSize;

/**
 * Created by Khoa on 11/14/2015.
 */
public abstract class NaturalObject {

    protected NaturalFeeling feeling;
    protected NaturalAppear appear;
    protected int color;
    protected PointF where;
    protected kSize skyDimen;
    protected Bitmap bitmap;
    protected Bitmap finalBitmap;

    public NaturalObject(Context ct) {

    }

    protected abstract void emotes(Canvas canvas, Paint p);

    protected abstract void prepare(int i);

    protected abstract void setSkyDimen(kSize ksize);

    protected abstract void howBig();

    protected void whatColorULike(int wColor) {
        color = wColor;
    }


    protected void howDoYouFeel(NaturalFeeling howDoYouFeel) {
        feeling = howDoYouFeel;
    }

    protected void areUHere(NaturalAppear showing) {
        appear = showing;
    }

    public enum NaturalFeeling {
        happy,
        fine,
        normal,
        sad,
        angry
    }

    public enum NaturalAppear {
        full,
        ellipse,
        smoke,
        hide
    }


    public enum NaturalSize {
        small,
        rather,
        big,
        huge
    }

    public interface cloudState {
        public int updateCloud(int type);
    }

}
