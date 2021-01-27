package com.liuyang.learn.jetpack.workmanager;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.liuyang.learn.R;
import com.liuyang.learn.databinding.WorkmanagerBinding;

public class WorkManagerLearnActivity extends AppCompatActivity {

  private WorkManager workManager = WorkManager.getInstance(this);

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WorkmanagerBinding binding = DataBindingUtil.setContentView(this, R.layout.workmanager);

    binding.enqueue.setOnClickListener(v -> {

      Constraints constraints = new Constraints.Builder()
          //.setRequiredNetworkType(NetworkType.CONNECTED)
          .build();

      Data data = new Data.Builder().putString("key", "v").build();
      OneTimeWorkRequest workRequest =
          new OneTimeWorkRequest.Builder(MyWorker.class)
              .setConstraints(constraints)
              .setInputData(data)
              .build();
      workManager.enqueue(workRequest);

      workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this,
          new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
              Log.e("==##", workInfo.getState().toString());
              if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                Log.e("==##", workInfo.getOutputData().getString("key"));
              }
            }
          });
    });
  }
}
