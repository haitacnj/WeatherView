package com.example.khoa.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.example.khoa.support.kSize;
import com.example.khoa.weatherview.R;

import java.util.Calendar;

/**
 * Created by Khoa on 11/14/2015.
 */
public class Moon extends NaturalObject {

    protected int lightIntensity;
    protected float runSpacing;

    protected float a, b, c, t;

    public Moon(Context ct) {
        super(ct);
        bitmap = BitmapFactory.decodeResource(ct.getResources(), R.mipmap.moon);
        runSpacing = 0;
        where = new PointF();
        skyDimen = new kSize(0, 0);
    }

    @Override
    protected void emotes(Canvas canvas, Paint p) {
        if (appear == NaturalAppear.hide) {
            return;
        }

        canvas.drawBitmap(finalBitmap, (float) where.x - t / 2, (float) where.y - t / 2, p);
    }


    @Override
    protected void prepare(int i) {
        if (i <= 360){
            where.x = (i + 360) * runSpacing;
            where.y = a * where.x * where.x + b * where.x + c;
            areUHere(NaturalAppear.full);
        } else {
            if( i >= 1080){
                where.x = (i - 1080) * runSpacing;
                where.y = a * where.x * where.x + b * where.x + c;
                areUHere(NaturalAppear.full);
            }else {
                where.x = 0;
                where.y = skyDimen.height;
                areUHere(NaturalAppear.hide);
            }

        }
    }

    @Override
    protected void setSkyDimen(kSize ksize) {
        skyDimen = ksize;
        howBig();
    }

    @Override
    protected void howBig() {
        runSpacing = skyDimen.width / 720;

        t = skyDimen.height / 4;

        c = (float) ((2 * Math.pow(t, 5) - 8 * skyDimen.width * Math.pow(t, 4) + 16 * Math.pow((float) skyDimen.width, 2) * Math.pow(t, 3) - 16 * Math.pow((float) skyDimen.width, 3) * Math.pow(t, 2)) / (10 * Math.pow((float) skyDimen.width, 2) * Math.pow(t, 2) - 4 * Math.pow((float) skyDimen.width, 3) * t - 8 * (float) skyDimen.width * Math.pow(t, 3) + 2 * Math.pow(t, 4)));
        b = (16 * t - 4 * c) / (2 * t - t * t / skyDimen.width);
        a = (16 * t - 4 * c) / (t * t - 2 * t * skyDimen.width);

        where.x = 0;
        where.y = c;

        finalBitmap = Bitmap.createScaledBitmap(bitmap, (int) t, (int) t, false);
    }
}
