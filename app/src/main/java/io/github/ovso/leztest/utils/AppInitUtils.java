package io.github.ovso.leztest.utils;

import io.github.ovso.leztest.BuildConfig;
import timber.log.Timber;

public class AppInitUtils {

  private AppInitUtils() {

  }

  public static void timer() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}