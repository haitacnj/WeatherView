package com.example.khoa.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.khoa.support.kSize;
import com.example.khoa.weatherview.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Khoa on 11/14/2015.
 */
public class WeatherView extends RelativeLayout implements NaturalObject.cloudState {

    protected float w;
    protected float h;
    protected float t;
    protected double a, b, c; // parameter of parabola of the sun
    protected Paint paint;
    protected Context ct;
    protected double x;
    protected double y;
    protected double runSpacing;
    protected NaturalObject sun;
    protected NaturalObject moon;
    protected List<Cloud> clouds;
    protected boolean isNight;
    protected Set<Integer> mySet;

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        ct = context;
        x = 0;
        sun = new Sun(context);
        moon = new Moon(context);
        clouds = new ArrayList<>();
        isNight = false;
        initialCloud();
    }

    private void initialCloud() {

        Random r = new Random();

        mySet = new HashSet<Integer>();
        while (mySet.size() < 3) {
            int idx = r.nextInt(20);
            Log.d("random value", "" + idx);
            mySet.add(idx);
        }

        for (Integer i : mySet) {
            Cloud c = new Cloud(ct, i, this);
            addView(c.texture);
            clouds.add(c);
        }

    }

    public WeatherView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        w = MeasureSpec.getSize(widthMeasureSpec);
        h = MeasureSpec.getSize(heightMeasureSpec);

        sun.setSkyDimen(new kSize((int) w, (int) h));
        moon.setSkyDimen(new kSize((int) w, (int) h));
    }

    public void objectStick(int i) {
        sun.prepare(i);
        moon.prepare(i);
        invalidate();
    }

    public void cloudStick() {
        for (Cloud cloud : clouds) {
            cloud.emotes(null, null);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        sun.emotes(canvas, paint);
        moon.emotes(canvas, paint);
    }

    public void checkState(int totalMinute) {
        if (360 < totalMinute && totalMinute < 1080) {
            //setBackgroundResource(R.mipmap.noon);
            //setBackgroundColor(Color.WHITE);
            setBackgroundResource(R.color.blue_sky);
            isNight = false;
        } else {
            setBackgroundResource(R.mipmap.night);
            isNight = true;
        }
    }


    @Override
    public int updateCloud(int type) {

        Iterator<Integer> neighboursItr = mySet.iterator();
        while (neighboursItr.hasNext()) {
            // try disconnecting vertices
            int neighbour = neighboursItr.next();
            if (neighbour == type) {
                neighboursItr.remove();
                break;
            }
        }

//        for (Integer i : mySet) {
//            if (i == type) {
//                mySet.remove(i);
//                break;
//            }
//        }

        int idx = -1;
        Random r = new Random();
        while (mySet.size() < 3) {
            idx = r.nextInt(20);
            mySet.add(idx);
        }

        return idx;
    }
}
