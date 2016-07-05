package com.coolweather.app.util;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
