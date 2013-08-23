package in.xnnyygn.attic.command.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpParams {

  private Map<String, List<String>> paramMap =
      new HashMap<String, List<String>>();

  public void set(String name, String value) {
    List<String> values = new ArrayList<String>();
    values.add(value);
    paramMap.put(name, values);
  }

  public String toQueryString() {
    StringBuilder queryString = new StringBuilder();
    for (Map.Entry<String, List<String>> pair : paramMap.entrySet()) {
      String name = pair.getKey();
      for (String value : pair.getValue()) {
        queryString.append(name).append('=').append(value).append('&');
      }
    }
    // remove trailing &
    if (!paramMap.isEmpty()) queryString.setLength(queryString.length() - 1);
    return queryString.toString();
  }

  @Override
  public String toString() {
    return paramMap.toString();
  }


}
