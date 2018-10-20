package io.github.ovso.leztest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import com.fondesa.recyclerviewdivider.RecyclerViewDivider;
import io.github.ovso.leztest.R;
import io.github.ovso.leztest.data.network.model.image.Document;
import io.github.ovso.leztest.ui.base.BaseActivity;
import io.github.ovso.leztest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.leztest.ui.base.adapter.MyRecyclerView;
import io.github.ovso.leztest.ui.base.adapter.OnRecyclerViewItemClickListener;
import io.github.ovso.leztest.ui.base.listener.SimpleOnQueryTextListener;
import io.github.ovso.leztest.ui.main.adapter.MainAdapter;
import io.github.ovso.leztest.ui.result.ResultActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View,
    OnRecyclerViewItemClickListener<Document>, OnEndlessRecyclerScrollListener.OnLoadMoreListener {

  @Inject MainPresenter presenter;
  @Inject MainAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @Inject OnEndlessRecyclerScrollListener onScrollListener;
  @BindView(R.id.recycler_view) MyRecyclerView recyclerView;

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override protected void onCreated(@Nullable Bundle savedInstanceState) {
    presenter.onCreated();
  }

  @Override public void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
    recyclerView.setOnItemClickListener(this);
    onScrollListener.setLayoutManager(recyclerView.getLayoutManager());
    recyclerView.addOnScrollListener(onScrollListener);
    RecyclerViewDivider.with(this)
        .size(10)
        .color(ContextCompat.getColor(this, android.R.color.black))
        .build()
        .addTo(recyclerView);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void navigateToDetail(Document item) {
  }

  private SimpleOnQueryTextListener simpleOnQueryTextListener = new SimpleOnQueryTextListener() {
    @Override public boolean onQueryTextChange(String query) {
      presenter.onQueryTextChange(query);
      return false;
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.options_menu, menu);
    MenuItem searchMenu = menu.findItem(R.id.action_search);
    ((SearchView) searchMenu.getActionView()).setOnQueryTextListener(simpleOnQueryTextListener);
    return true;
  }

  @Override public void onItemClick(Document item) {
    Intent intent = new Intent(this, ResultActivity.class);
    intent.putExtra(ResultActivity.EXTRA_PARAM_IMAGE_URL, item.getThumbnail_url());
    intent.putExtra(ResultActivity.EXTRA_PARAM_IMAGE_WIDTH, item.getWidth());
    intent.putExtra(ResultActivity.EXTRA_PARAM_IMAGE_HEIGHT, item.getHeight());
    startActivity(intent);
  }

  @Override public void onLoadMore() {
    presenter.onLoadMore();
  }

  @Override public void setLoaded() {
    onScrollListener.setLoaded();
  }
}