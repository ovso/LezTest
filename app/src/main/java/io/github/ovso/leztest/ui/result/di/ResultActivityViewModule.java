package io.github.ovso.leztest.ui.result.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.leztest.ui.result.ResultActivity;
import io.github.ovso.leztest.ui.result.ResultPresenter;

@Module public abstract class ResultActivityViewModule {

  @Binds abstract ResultPresenter.View bindResultView(ResultActivity activity);
}