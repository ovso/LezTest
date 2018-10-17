package io.github.ovso.leztest.data.network;

import io.github.ovso.leztest.data.network.model.SearchItem;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;

public interface BrandService {
  @GET("car_meta/brands") Single<List<SearchItem>> getBrands();
}
