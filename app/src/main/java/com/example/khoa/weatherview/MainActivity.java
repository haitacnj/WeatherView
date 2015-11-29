package com.example.khoa.weatherview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.khoa.ui.WeatherView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    protected Timer timer;
    protected TimerTask timerTask;
    protected TimerTask cloudTimer;
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
        weatherView.checkState(startCal.get(Calendar.HOUR_OF_DAY) * 60 + startCal.get(Calendar.MINUTE));

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
                            weatherView.objectStick(minusInDay);
                        }
                    }
                });

            }
        };

        cloudTimer = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        weatherView.cloudStick();
                    }
                });
            }
        };

        timer.schedule(timerTask, 0, 60 * 1000);
        timer.schedule(cloudTimer, 100, 200);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timerTask.cancel();
    }

    public class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page
         */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

}
