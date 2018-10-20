package io.github.ovso.leztest.ui.main.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.facebook.drawee.view.SimpleDraweeView;
import io.github.ovso.leztest.R;
import io.github.ovso.leztest.data.network.model.image.Document;
import io.github.ovso.leztest.ui.base.adapter.BaseViewHolder;

public class MainViewHolder extends BaseViewHolder {
  @BindView(R.id.image_view) SimpleDraweeView imageView;

  private MainViewHolder(View itemView) {
    super(itemView);
  }

  public void bind(Document document) {
    super.bind(document);
    float aspectRatio = (float) document.getWidth() / (float) document.getHeight();
    imageView.setAspectRatio(aspectRatio);
    imageView.setImageURI(Uri.parse(document.getThumbnail_url()));
    itemView.setOnClickListener(v -> onRecyclerViewItemClickListener.onItemClick(document));
  }

  public static MainViewHolder create(ViewGroup parent) {
    return new MainViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_main, parent, false));
  }
}