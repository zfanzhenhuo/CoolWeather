package zhenhuo.com.asynctaskdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AsyncTaskDemo extends Activity {
    /*
    只有doInBackground()方法运行在其他线程，其他方法都是运行在主线程
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo);
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }

    public void loadImage(View v) {
        Intent intent = new Intent(getApplicationContext(), ImageTest.class);
        startActivity(intent);
    }

    public void loadProgress(View v) {
        Intent intent = new Intent(getApplicationContext(), ProgressBarTest.class);
        startActivity(intent);

    }

}
