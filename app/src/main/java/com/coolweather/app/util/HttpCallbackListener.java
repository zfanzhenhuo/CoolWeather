package com.coolweather.app.util;

import org.json.JSONException;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public interface HttpCallbackListener {
    void onFinish(String response) throws JSONException;

    void onError(Exception e);
}
