package io.github.ovso.leztest.data.network;

import io.github.ovso.leztest.data.network.model.CarDetail;
import io.reactivex.Single;
import javax.inject.Inject;
import okhttp3.Headers;

public class DetailRequest extends BaseRequest<DetailService> {

  @Inject
  public DetailRequest() {

  }

  @Override protected Class getApiClass() {
    return DetailService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().build();
  }

  @Override protected String getBaseUrl() {
    return null;
  }

  public Single<CarDetail> getCarDetail(int carId) {
    return getApi().getCarDetail(carId);
  }
}