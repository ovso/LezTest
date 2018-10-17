package io.github.ovso.leztest.data.network.model;

import java.util.List;
import lombok.Getter;

@Getter public class BrandGroup extends SearchItem {
  private List<ModelGroup> model_groups;
}
