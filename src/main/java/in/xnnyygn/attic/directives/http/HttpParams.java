package in.xnnyygn.attic.directives.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpParams {

  private final Map<String, List<String>> params =
      new HashMap<String, List<String>>();

  public void setParam(String name, String value) {
    if (!params.containsKey(name)) {
      params.put(name, new ArrayList<String>());
    }
    params.get(name).add(value);
  }

  public String getParamValue(String name) {
    return params.containsKey(name) ? params.get(name).get(0) : null;
  }

  public String toQueryString() throws UnsupportedEncodingException {
    StringBuilder queryStringBuilder = new StringBuilder();
    for (Map.Entry<String, List<String>> param : params.entrySet()) {
      String name = param.getKey();
      for (String value : param.getValue()) {
        queryStringBuilder.append(name).append('=')
            .append(URLEncoder.encode(value, "UTF-8")).append('&');
      }
    }
    if (!params.isEmpty())
      queryStringBuilder.deleteCharAt(queryStringBuilder.length() - 1);
    return queryStringBuilder.toString();
  }

  public Set<String> getNames() {
    return params.keySet();
  }

  @Override
  public String toString() {
    return params.toString();
  }

}
