package io.github.ovso.leztest.data.network;

import io.github.ovso.leztest.data.network.model.ModelGroupDetail;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModelService {
  @GET("/car_meta/model_groups/{id}") Single<ModelGroupDetail> getModel(@Path("id") int id);
}
