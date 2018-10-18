package io.github.ovso.leztest.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import io.github.ovso.leztest.R;
import io.github.ovso.leztest.data.network.model.image.Document;
import io.github.ovso.leztest.ui.base.adapter.BaseViewHolder;

public class MainViewHolder extends BaseViewHolder {

  @BindView(R.id.image_view) ImageView imageView;

  private MainViewHolder(View itemView) {
    super(itemView);
  }

  public void bind(Document document) {
    super.bind(document);
    Glide.with(itemView).load(document.getThumbnail_url()).into(imageView);
  }

  public static MainViewHolder create(ViewGroup parent) {
    return new MainViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_main, parent, false));
  }

  @OnClick(R.id.root_view) void onItemClick() {
    onRecyclerViewItemClickListener.onItemClick(data);
  }
}