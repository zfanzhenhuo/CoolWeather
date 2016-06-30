package zhenhuo.com.asynctaskdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class ImageTest extends Activity {
    private ImageView imageView;
    private ProgressBar progressBar;
    private static String url = "http://k.sinaimg.cn/n/sports/transform/20160530/1maV-fxsqxyc1659860.jpg/w57078c.jpg";


    class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressBar.setVisibility(View.GONE);
            imageView.setImageBitmap(bitmap);//进行UI操作
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            //获取传递进来的参数
            String url = params[0];//获取url，params为可变长度字符串
            Bitmap bitmap = null;
            URLConnection connection;
            InputStream is;
            try {
                connection = new URL(url).openConnection();
                is = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                Thread.sleep(3000);
                bitmap = BitmapFactory.decodeStream(bis);
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        imageView = (ImageView) findViewById(R.id.iv);
        progressBar = (ProgressBar) findViewById(R.id.pr);
        //设置传递进去的参数
        new MyAsyncTask().execute(url);
    }


}
