package zhenhuo.com.asynctaskdemo;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        Log.i("Main", "---doInBackground---");
        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.i("Main", "---onPreExecute---");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.i("Main", "---onPostExecute---");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i("Main", "---onProgressUpdate---");
        super.onProgressUpdate(values);
    }
}
