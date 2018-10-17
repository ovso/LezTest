package io.github.ovso.leztest.data.network.model.image;

import java.util.List;
import lombok.Getter;

@Getter public class ImageData {
  private Meta meta;
  private List<Document> documents;
}
