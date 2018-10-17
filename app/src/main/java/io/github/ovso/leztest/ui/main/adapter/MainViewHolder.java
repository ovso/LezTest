package io.github.ovso.leztest.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.github.ovso.leztest.R;
import io.github.ovso.leztest.data.network.model.Disease;
import io.github.ovso.leztest.ui.base.adapter.BaseViewHolder;

public class MainViewHolder extends BaseViewHolder {

  @BindView(R.id.code_text_view) TextView codeTextView;
  @BindView(R.id.disease_text_view) TextView diseaseTextView;

  private MainViewHolder(View itemView) {
    super(itemView);
  }

  public void bind(Disease disease) {
    super.bind(disease);
    codeTextView.setText(disease.getCode());
    diseaseTextView.setText(disease.getName());
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