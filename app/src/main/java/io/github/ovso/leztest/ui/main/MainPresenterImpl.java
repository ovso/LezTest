package io.github.ovso.leztest.ui.main;

import io.github.ovso.leztest.data.network.ImageRequest;
import io.github.ovso.leztest.data.network.model.Disease;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.leztest.utils.ResourceProvider;
import io.github.ovso.leztest.utils.SchedulersFacade;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private ResourceProvider resourceProvider;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private SchedulersFacade schedulers;
  private BaseAdapterDataModel<Disease> adapterDataModel;
  private ImageRequest imageRequest;

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $ResourceProvider,
      SchedulersFacade $schedulers, BaseAdapterDataModel<Disease> $adapterDataModel,
      ImageRequest $imageRequest) {
    view = $view;
    resourceProvider = $ResourceProvider;
    schedulers = $schedulers;
    adapterDataModel = $adapterDataModel;
    imageRequest = $imageRequest;
  }

  @Override public void onCreated() {
    view.setupRecyclerView();
    reqDiseases();
  }

  private void reqDiseases() {
    Disposable disposable = imageRequest.images("설현", 1)
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
        .subscribe(o -> {
          boolean end = o.getMeta().is_end();
          Timber.d("end = " + end);
        }, throwable -> Timber.d(throwable));
    compositeDisposable.add(disposable);
  }

  @Override public void onItemClick(Disease disease) {
    view.navigateToDetail(disease);
  }

  @Override public void onItemLikeClick(Disease item) {
    Timber.d("onItemLikeClick = " + item);
  }

  @Override public void onQueryTextChange(String query) {

  }
}