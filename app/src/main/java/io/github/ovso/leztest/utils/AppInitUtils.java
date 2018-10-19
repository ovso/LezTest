package io.github.ovso.leztest.utils;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.github.ovso.leztest.BuildConfig;
import timber.log.Timber;

public final class AppInitUtils {

  private AppInitUtils() {

  }

  public static void timer() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  public static void fresco(Context context) {
    Fresco.initialize(context);
  }
}