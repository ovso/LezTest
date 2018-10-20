package io.github.ovso.leztest.ui.result;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import io.github.ovso.leztest.R;
import timber.log.Timber;

public class ResultActivity extends AppCompatActivity {

  @BindView(R.id.image_view) SimpleDraweeView imageView;
  @BindView(R.id.toolbar) Toolbar toolbar;

  public final static String EXTRA_PARAM_IMAGE_URL = "image_url";
  public final static String EXTRA_PARAM_IMAGE_WIDTH = "image_width";
  public final static String EXTRA_PARAM_IMAGE_HEIGHT = "image_height";

  private Unbinder bind;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
    bind = ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    String imageUrl = getIntent().getStringExtra(EXTRA_PARAM_IMAGE_URL);
    int imageWidth = getIntent().getIntExtra(EXTRA_PARAM_IMAGE_WIDTH, 0);
    int imageHeight = getIntent().getIntExtra(EXTRA_PARAM_IMAGE_HEIGHT, 0);

    final float aspectRatio = (float) imageWidth / (float) imageHeight;
    imageView.setAspectRatio(aspectRatio);
    imageView.setImageURI(Uri.parse(imageUrl));
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onDestroy() {
    if (bind != null) {
      bind.unbind();
    }
    super.onDestroy();
  }
}