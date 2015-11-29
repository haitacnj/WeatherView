package com.example.khoa.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
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
    protected int seed;
    protected cloudState cloudState;

    public Cloud(Context ct, int sd, cloudState state) {
        super(ct);
        seed = sd;
        cloudState = state;
        rand = new Random(System.currentTimeMillis());
        texture = new ImageView(ct);
        texture.setAlpha(0.7f);
        prepare(seed);
    }

    @Override
    protected void emotes(Canvas canvas, Paint p) {
        float left = texture.getX();
        if (left > 1080) {
            int res = cloudState.updateCloud(seed);
            texture.setImageResource(CloudRetrieve.retrieveCloudType(res));
            left = -texture.getWidth();
            texture.setY(rand.nextInt(500));
        } else {

        }

        texture.setX(left + (float) rand.nextInt(6) / 5);

    }


    @Override
    protected void prepare(int i) {

        texture.setImageResource(CloudRetrieve.retrieveCloudType(i));
        Log.e("Cloud type", "" + i);
        texture.setY(rand.nextInt(500));
        texture.setX(rand.nextInt(1000));

    }

    @Override
    protected void setSkyDimen(kSize ksize) {

    }

    @Override
    protected void howBig() {

    }
}
