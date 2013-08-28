package in.xnnyygn.attic.util;

import java.util.List;

public class CollectionUtils {

  public static <T> List<T> tail(List<T> list) throws IllegalArgumentException {
    if (list == null || list.isEmpty())
      throw new IllegalArgumentException("array should not be null or empty");
    return list.subList(1, list.size());
  }

}
