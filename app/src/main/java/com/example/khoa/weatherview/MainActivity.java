package com.example.khoa.weatherview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.khoa.ui.WeatherView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    protected Timer timer;
    protected TimerTask timerTask;
    protected WeatherView weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiation();
        execution();

    }

    private void execution() {

    }

    private void initiation() {
        timer = new Timer();
        weatherView = (WeatherView) findViewById(R.id.weatherView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Calendar startCal = Calendar.getInstance();
        int timeDelay = (60 - startCal.get(Calendar.SECOND)) * 1000;
        Log.d("Time delay", "" + timeDelay);

        timerTask = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weatherView != null) {
                            Calendar cal = Calendar.getInstance();
                            int hour = cal.get(Calendar.HOUR_OF_DAY);
                            int minute = cal.get(Calendar.MINUTE);
                            int minusInDay = hour * 60 + minute;
                            Log.d("Minute delay", "" + minusInDay);
                            weatherView.timeStick(minusInDay);
                        }
                    }
                });

            }
        };

        timer.schedule(timerTask, 100, 60 * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timerTask.cancel();
    }
}
