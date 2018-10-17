package io.github.ovso.leztest.data.network.model.youtube;

import lombok.Getter;

@Getter public class SearchThumbnails {
  private ThumbnailsInfo defaults;
  private ThumbnailsInfo medium;
  private ThumbnailsInfo high;
}