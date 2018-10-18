package io.github.ovso.leztest.ui.main;

import io.github.ovso.leztest.data.network.model.image.Document;

public interface MainPresenter {

  void onCreated();

  void onItemClick(Document item);

  void onItemLikeClick(Document item);

  void onQueryTextChange(String query);

  interface View {

    void setupRecyclerView();

    void refresh();

    void navigateToDetail(Document item);

    void finish();
  }
}
