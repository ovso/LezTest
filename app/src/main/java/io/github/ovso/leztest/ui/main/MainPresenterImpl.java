package io.github.ovso.leztest.ui.main;

import io.github.ovso.leztest.data.network.ImageRequest;
import io.github.ovso.leztest.data.network.model.image.Document;
import io.github.ovso.leztest.data.network.model.image.ImageData;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.leztest.utils.ResourceProvider;
import io.github.ovso.leztest.utils.SchedulersFacade;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private ResourceProvider resourceProvider;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private SchedulersFacade schedulers;
  private BaseAdapterDataModel<Document> adapterDataModel;
  private ImageRequest imageRequest;
  private int page = 1;
  private String query;
  private boolean isEnd;

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $ResourceProvider,
      SchedulersFacade $schedulers, BaseAdapterDataModel<Document> $adapterDataModel,
      ImageRequest $imageRequest) {
    view = $view;
    resourceProvider = $ResourceProvider;
    schedulers = $schedulers;
    adapterDataModel = $adapterDataModel;
    imageRequest = $imageRequest;
  }

  @Override public void onCreated() {
    view.setupRecyclerView();
  }

  @Override public void onQueryTextChange(String $query) {
    this.query = $query;
    compositeDisposable.clear();
    adapterDataModel.clear();
    view.refresh();
    isEnd = false;
    page = 1;
    reqImages($query);
  }

  private void reqImages(String $query) {
    Single.just($query)
        .delay(1, TimeUnit.SECONDS)
        .flatMap(q -> imageRequest.images(q, page))
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
        .subscribe(new SingleObserver<ImageData>() {
          @Override public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
          }

          @Override public void onSuccess(ImageData imageData) {
            isEnd = imageData.getMeta().is_end();

            Timber.d("isEnd = " + isEnd);
            Timber.d("TotalCount = " + imageData.getMeta().getTotal_count());
            Timber.d("pageCount = " + imageData.getMeta().getPageable_count());

            adapterDataModel.addAll(imageData.getDocuments());
            view.refresh();
            view.setLoaded();
          }

          @Override public void onError(Throwable e) {
            Timber.d(e);
            adapterDataModel.clear();
            view.refresh();
          }
        });
  }

  @Override public void onLoadMore() {
    if (!isEnd) {
      page++;
      reqImages(query);
    }
  }
}