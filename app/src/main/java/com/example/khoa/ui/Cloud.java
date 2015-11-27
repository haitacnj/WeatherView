package com.example.khoa.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

import com.example.khoa.support.CloudRetrieve;
import com.example.khoa.support.kSize;

import java.util.Random;

/**
 * Created by Khoa on 11/14/2015.
 */
public class Cloud extends NaturalObject {

    protected ImageView texture;
    protected Random rand;

    public Cloud(Context ct) {
        super(ct);
        rand = new Random();
        texture = new ImageView(ct);
        prepare(rand.nextInt(1));
    }

    @Override
    protected void emotes(Canvas canvas, Paint p) {
        float left = texture.getX();
        if (left > 1080)
            left = -texture.getWidth();
        rand.nextInt(5);
        texture.setX(left + (float) rand.nextInt(5) / 10);
    }


    @Override
    protected void prepare(int i) {
        texture.setImageResource(CloudRetrieve.retrieveCloudType(i));
    }

    @Override
    protected void setSkyDimen(kSize ksize) {

    }

    @Override
    protected void howBig() {

    }
}
