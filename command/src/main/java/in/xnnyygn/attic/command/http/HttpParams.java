package in.xnnyygn.attic.command.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpParams {

  private static final List<String> NIL = new ArrayList<String>(0);
  private Map<String, List<String>> paramMap =
      new HashMap<String, List<String>>();

  public void set(String name, String value) {
    List<String> values = new ArrayList<String>();
    values.add(value);
    paramMap.put(name, values);
  }

  public String getValue(String name) {
    List<String> values = getValues(name);
    return values.isEmpty() ? null : values.get(0);
  }

  public List<String> getValues(String name) {
    return paramMap.containsKey(name) ? paramMap.get(name) : NIL;
  }

  public Set<String> getNames() {
    return paramMap.keySet();
  }
  
  public String toQueryString(String encoding) {
    StringBuilder queryString = new StringBuilder();
    for (Map.Entry<String, List<String>> pair : paramMap.entrySet()) {
      String name = pair.getKey();
      for (String value : pair.getValue()) {
        queryString.append(name).append('=');
        queryString.append(encode(value, encoding)).append('&');
      }
    }
    // remove trailing &
    if (!paramMap.isEmpty()) queryString.setLength(queryString.length() - 1);
    return queryString.toString();
  }

  private String encode(String string, String encoding) {
    try {
      return URLEncoder.encode(string, encoding);
    } catch (UnsupportedEncodingException e) {
      System.err.println(String.format(
          "failed to encode [%s] with encoding [%s]", string, encoding));
      return string;
    }
  }

  @Override
  public String toString() {
    return paramMap.toString();
  }

}
