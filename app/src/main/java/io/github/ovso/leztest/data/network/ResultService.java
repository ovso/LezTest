package io.github.ovso.leztest.data.network;

import io.github.ovso.leztest.data.network.model.youtube.Search;
import io.reactivex.Single;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ResultService {
  @GET("/v2/search/image")
  Single<Search> images(@QueryMap Map<String, Object> queryMap);
}
