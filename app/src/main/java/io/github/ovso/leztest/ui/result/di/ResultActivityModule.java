package io.github.ovso.leztest.ui.result.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.leztest.data.network.ResultRequest;
import io.github.ovso.leztest.data.network.model.youtube.SearchItem;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.leztest.ui.result.ResultPresenter;
import io.github.ovso.leztest.ui.result.ResultPresenterImpl;
import io.github.ovso.leztest.ui.result.adapter.ResultAdapter;
import io.github.ovso.leztest.utils.ResourceProvider;
import io.github.ovso.leztest.utils.SchedulersFacade;
import javax.inject.Singleton;

@Module public class ResultActivityModule {

  @Provides ResultPresenter provideResultPresenter(ResultPresenter.View view,
      ResourceProvider resourceProvider, ResultRequest ResultRequest,
      SchedulersFacade schedulersFacade, BaseAdapterDataModel<SearchItem> adapterDataModel) {
    return new ResultPresenterImpl(view, resourceProvider, ResultRequest, schedulersFacade, adapterDataModel);
  }

  @Singleton @Provides ResultAdapter provideResultAdapter() {
    return new ResultAdapter();
  }
  @Provides BaseAdapterDataModel<SearchItem> provideAdapterDataModel(ResultAdapter adapter) {
    return adapter;
  }
  @Provides BaseAdapterView provideResultAdapterView(ResultAdapter adapter) {
    return adapter;
  }
}