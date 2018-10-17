package io.github.ovso.leztest.ui.main;

import io.github.ovso.leztest.data.network.model.Disease;

public interface MainPresenter {

  void onCreated();

  void onItemClick(Disease disease);

  void onItemLikeClick(Disease item);

  void onQueryTextChange(String query);

  interface View {

    void setupRecyclerView();

    void refresh();

    void navigateToDetail(Disease disease);

    void finish();
  }
}
