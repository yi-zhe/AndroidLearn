package com.liuyang.learn.okhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.liuyang.learn.R;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpLearn extends AppCompatActivity {
  private static final String TAG = OkHttpLearn.class.getSimpleName();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.data_binding_basic);
    asyncDownload();
  }

  private void asyncUploadMultiPart() {
    MediaType typePng = MediaType.parse("image/png");
    OkHttpClient client = new OkHttpClient();
    RequestBody requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("title", "wangshu")
        .addFormDataPart("image", "wangshu.png",
            RequestBody.create(typePng, new File("/sdcard/wangshu.png")))
        .build();

    Request request = new Request.Builder()
        .header("Authorization", "Client-ID")
        .url("https://api.imgur.com/3/image")
        .post(requestBody)
        .build();

    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        Log.d(TAG, response.body().string());
      }
    });
  }

  private void asyncUpload() {
    MediaType typeMarkdown = MediaType.parse("text/x-markdown; charset=utf-8");
    String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
    File file = new File(dir, "wangshu.txt");
    Request request = new Request.Builder()
        .url("https://api.github.com/markdown/raw")
        .post(RequestBody.create(typeMarkdown, file))
        .build();
    OkHttpClient client = new OkHttpClient();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        Log.d(TAG, response.body().string());
      }
    });
  }

  private void asyncDownload() {
    String url =
        "https://img2018.cnblogs.com/common/1823680/202001/1823680-20200129171034643-645958880.png";
    Request request = new Request.Builder()
        .url(url)
        .build();
    OkHttpClient client = new OkHttpClient();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {

        Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
        Log.d(TAG, "size=" + bitmap.getWidth() + " " + bitmap.getHeight());
      }
    });
  }

  private void asyncPost() {
    RequestBody formBody = new FormBody.Builder()
        .add("ip", "59.108.54.37")
        .build();

    Request request = new Request.Builder()
        .url("http://ip.taobao.com/service/getIpInfo.php")
        .post(formBody)
        .build();

    OkHttpClient client = new OkHttpClient();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        Log.d(TAG, response.body().string());
      }
    });
  }

  private void asyncGet() {
    Request.Builder requestBuilder = new Request.Builder()
        .url("https://www.baidu.com")
        .method("GET", null);
    Request request = requestBuilder.build();
    OkHttpClient client = new OkHttpClient();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        Log.d(TAG, response.body().string());
      }
    });
  }
}
