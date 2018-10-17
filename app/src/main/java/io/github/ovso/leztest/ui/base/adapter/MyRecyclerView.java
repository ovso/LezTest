package io.github.ovso.leztest.ui.base.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import io.github.ovso.leztest.utils.ObjectUtils;

public class MyRecyclerView extends RecyclerView {
  private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

  public MyRecyclerView(Context context) {
    super(context);
  }

  public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override public void setAdapter(Adapter adapter) {
    super.setAdapter(adapter);
    setOnItemClickListener(adapter);
  }

  public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
    onRecyclerViewItemClickListener = listener;
    setOnItemClickListener(getAdapter());
  }

  private void setOnItemClickListener(Adapter adapter) {
    if (!ObjectUtils.isEmpty(adapter)) {
      if ((adapter instanceof BaseRecyclerAdapter)) {
        ((BaseRecyclerAdapter) adapter).setOnRecyclerViewItemClickListener(
            onRecyclerViewItemClickListener);
      }
    }
  }
}
