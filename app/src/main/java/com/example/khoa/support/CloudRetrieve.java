package com.example.khoa.support;

import com.example.khoa.weatherview.R;

/**
 * Created by ka on 11/27/2015.
 */
public class CloudRetrieve {

    public static int retrieveCloudType(int type) {
        switch (type) {
            case 0:
                return R.mipmap.wcloud1;
            case 1:
                return R.mipmap.wcloud2;
            case 2:
                return R.mipmap.wcloud3;
            case 3:
                return R.mipmap.wcloud4;
            case 4:
                return R.mipmap.wcloud5;
            case 5:
                return R.mipmap.wcloud6;
            case 6:
                return R.mipmap.wcloud7;
            case 7:
                return R.mipmap.wcloud8;
            case 8:
                return R.mipmap.wcloud9;
            case 9:
                return R.mipmap.wcloud10;
            case 10:
                return R.mipmap.wcloud11;
            case 11:
                return R.mipmap.wcloud12;
            case 12:
                return R.mipmap.wcloud13;
            case 13:
                return R.mipmap.wcloud14;
            case 14:
                return R.mipmap.wcloud15;
            case 15:
                return R.mipmap.wcloud16;
            case 16:
                return R.mipmap.wcloud17;
            case 17:
                return R.mipmap.wcloud18;
            case 18:
                return R.mipmap.wcloud19;
            case 19:
                return R.mipmap.wcloud20;
            default:
                return R.mipmap.wcloud1;
        }
    }

    public static kSize retrieveCLoudSize(int type) {
        switch (type) {
            case 0:
                new kSize(256, 128);
            case 1:
                new kSize(512, 128);
            case 2:
                new kSize(720, 360);

        }

        return new kSize(0, 0);
    }

}
