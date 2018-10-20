package io.github.ovso.leztest.ui.main.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.leztest.ui.main.MainActivity;
import io.github.ovso.leztest.ui.main.MainPresenter;
import io.github.ovso.leztest.ui.main.OnEndlessRecyclerScrollListener;

@Module public abstract class MainActivityViewModule {

  @Binds abstract MainPresenter.View bindMainView(MainActivity activity);

  @Binds abstract OnEndlessRecyclerScrollListener.OnLoadMoreListener bindOnLoadMoreListener(
      MainActivity activity);
}