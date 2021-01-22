package com.liuyang.learn.jetpack.navigation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liuyang.learn.R;

/**
 * 移动端源码分析入口
 * 1. API
 * 2. APT中生成的代码
 * 3. gradle的transform 字节码插桩
 * 4. Lifecycle
 * 5. 断点分析代码的时候做好记录同时画类图
 */
public class NavigationLearnActivity extends AppCompatActivity {

  BottomNavigationView bottomNavigationView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigation_learn);
    findViewById(R.id.action_page1);
    bottomNavigationView = findViewById(R.id.nav_view);
    // Fragment的生命周期

    /**
     * 1. NavHostFragment
     * 2. NavController
     * 3. Navigator -> navigate       NavDestination
     *     FragmentNavigator  FragmentManager
     *     ActivityNavigator  startActivity
     */

    NavHostFragment navHostFragment =
        (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
    NavController controller = navHostFragment.getNavController();

    NavigationUI.setupWithNavController(bottomNavigationView, controller);
  }

  @Override
  public boolean onSupportNavigateUp() {
    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
    return NavHostFragment.findNavController(fragment).navigateUp();
  }
}
