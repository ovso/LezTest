package io.github.ovso.leztest.ui.main.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.leztest.data.network.model.Disease;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.leztest.ui.main.MainPresenter;
import io.github.ovso.leztest.ui.main.MainPresenterImpl;
import io.github.ovso.leztest.ui.main.adapter.MainAdapter;
import io.github.ovso.leztest.utils.ResourceProvider;
import io.github.ovso.leztest.utils.SchedulersFacade;
import javax.inject.Singleton;

@Module public class MainActivityModule {

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view,
      ResourceProvider resourceProvider, SchedulersFacade schedulersFacade,
      BaseAdapterDataModel<Disease> adapterDataModel) {
    return new MainPresenterImpl(view, resourceProvider, schedulersFacade, adapterDataModel);
  }

  @Singleton @Provides MainAdapter provideMainAdapter() {
    return new MainAdapter();
  }

  @Provides BaseAdapterDataModel<Disease> provideMainAdapterDataModel(MainAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterView provideMainAdapterView(MainAdapter adapter) {
    return adapter;
  }
}