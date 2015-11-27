package com.example.khoa.support;

import com.example.khoa.weatherview.R;

/**
 * Created by ka on 11/27/2015.
 */
public class CloudRetrieve {

    public static int retrieveCloudType(int type) {
        switch (type) {
            case 0:
                return R.mipmap.cloud;
            case 1:
                return R.mipmap.cloud2;
            default:
                return 0;
        }
    }

}
