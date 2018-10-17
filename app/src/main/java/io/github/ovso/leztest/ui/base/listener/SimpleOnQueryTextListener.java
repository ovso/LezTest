package io.github.ovso.leztest.ui.base.listener;

import android.support.v7.widget.SearchView;

public abstract class SimpleOnQueryTextListener implements SearchView.OnQueryTextListener {
  @Override public boolean onQueryTextSubmit(String newText) {
    return false;
  }
}
