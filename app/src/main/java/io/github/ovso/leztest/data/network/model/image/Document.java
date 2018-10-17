package io.github.ovso.leztest.data.network.model.image;

import java.util.Date;
import lombok.Getter;

@Getter public class Document {
  private String collection;
  private String thumbnail_url;
  private String image_url;
  private int width;
  private int height;
  private String display_sitename;
  private String doc_url;
  private Date datetime;
}
