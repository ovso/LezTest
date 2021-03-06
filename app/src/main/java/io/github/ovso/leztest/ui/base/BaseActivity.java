package io.github.ovso.leztest.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import io.github.ovso.leztest.R;

public abstract class BaseActivity extends DaggerAppCompatActivity {
  protected @BindView(R.id.toolbar) Toolbar toolbar;
  private Unbinder bind;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResID());
    bind = ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    onCreated(savedInstanceState);
  }

  protected abstract int getLayoutResID();

  protected abstract void onCreated(@Nullable Bundle savedInstanceState);

  @Override protected void onDestroy() {
    super.onDestroy();
    if (bind != null) {
      bind.unbind();
    }
  }
}