package zhenhuo.com.asynctaskdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class ProgressBarTest extends Activity {
    private ProgressBar progressBar;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_progress);
        progressBar = (ProgressBar) findViewById(R.id.pb);
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (myAsyncTask != null && myAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            //cancel方法只是将对应的AsyncTask标记为cancel状态，并不是真正的取消线程的执行
            myAsyncTask.cancel(true);
        }

    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //用进程睡眠模拟进度更新，不能直接在这个方法更新UI
            for (int i = 0; i < 100; i++) {
                if (isCancelled()) {
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (isCancelled()) {
                return;
            }
            //获取进度更新值
            progressBar.setProgress(values[0]);
        }
    }
}
