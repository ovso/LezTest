package io.github.ovso.leztest.ui.main;

import io.github.ovso.leztest.data.network.model.image.Document;

public interface MainPresenter {

  void onCreated();

  void onQueryTextChange(String query);

  void onLoadMore();

  interface View {

    void setupRecyclerView();

    void refresh();

    void navigateToDetail(Document item);

    void finish();

    void setLoaded();
  }
}
