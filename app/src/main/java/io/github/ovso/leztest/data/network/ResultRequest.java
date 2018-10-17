package io.github.ovso.leztest.data.network;

import android.text.TextUtils;
import io.github.ovso.leztest.Security;
import io.github.ovso.leztest.data.KeyName;
import io.github.ovso.leztest.data.network.model.youtube.Search;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.Headers;

public class ResultRequest extends BaseRequest<ResultService> {

  @Inject
  public ResultRequest() {

  }

  @Override protected Class getApiClass() {
    return ResultService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().build();
  }

  @Override protected String getBaseUrl() {
    return BaseUrl.SEARCH_IMAGE.getUrl();
  }

  public Single<Search> imageList(String q, String pageToken) {
    return null;
  }

  private Map<String, Object> createQueryMap(String q, String pageToken) {
    Map<String, Object> queryMap = new HashMap<>();
    queryMap.put(KeyName.Q.getValue(), q);
    queryMap.put(KeyName.MAX_RESULTS.getValue(), 50);
    queryMap.put(KeyName.ORDER.getValue(), "relevance");
    queryMap.put(KeyName.TYPE.getValue(), "video");
    queryMap.put(KeyName.VIDEO_TYPE.getValue(), "any");
    queryMap.put(KeyName.KEY.getValue(), Security.KEY.getValue());
    queryMap.put(KeyName.PART.getValue(), "snippet");
    if (!TextUtils.isEmpty(pageToken)) {
      queryMap.put(KeyName.PAGE_TOKEN.getValue(), pageToken);
    }
    return queryMap;
  }
}