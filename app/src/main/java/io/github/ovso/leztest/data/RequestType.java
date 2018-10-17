package io.github.ovso.leztest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor public enum RequestType {
  ALL(1), SINGLE(2);
  private int value;
}
