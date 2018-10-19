package io.github.ovso.leztest;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.ovso.leztest.di.DaggerAppComponent;
import io.github.ovso.leztest.utils.AppInitUtils;

public class App extends DaggerApplication {

  @Override public void onCreate() {
    super.onCreate();
    AppInitUtils.timer();
    AppInitUtils.fresco(this);
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder().application(this).build();
  }
}
