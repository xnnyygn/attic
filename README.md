# Attic #

Attic is a simple intercepeter for acceptance test.

## Usage ##

1. mvn package
2. cd assembly/target/attic-assembly-${version}-SNAPSHOT-bin
3. bin/attic.sh /path/to/your/attic/script

## Options ##

* -e encoding
* -CP additional command path, e.g if full class name of your command is foo.bar.BazCommand, you should set CP to `foo.bar` and use `Baz` in your script file

## Example ##

~~~
http.SetUri http://www.google.com/search
http.SetParam q foo
selenium.GetBy htmlunit
selenium.AssertCurrentTitleMatches ^foo.*$
selenium.Close
~~~

## Command List ##

### Base ###

| Syntax                | Description                     |
|:----------------------|:--------------------------------|
| `Println <text>`      | print text                      |
| `Pause <millis>`      | pause specified milliseconds    |
| `EchoVariable <name>` | print value of variable by name |

### HTTP ###

| Syntax                         | Description                     |
|:-------------------------------|:--------------------------------|
| `http.SetUri <uri>`            |                                 |
| `http.SetUrl <url>`            |                                 |
| `http.SetParam <name> <value>` |                                 |
| `http.SetEncoding <encoding>`  |                                 |

### HTTP Client ###

| Syntax                                   | Description                     |
|:-----------------------------------------|:--------------------------------|
| `httpclient.GetAndPrint`                 |use HTTP GET to retrieve response and print it, the url is from http.SetUrl or http.SetUri + http.SetParam |
| `httpclient.GetAsString (<responseKey>)` |use HTTP GET to retrieve response and store to variables, the default value of response key is httpclient.response.string |

### selenium ###

| Syntax                                     | Description                     |
|:-------------------------------------------|:--------------------------------|
| `selenium.Get`                             | get url response in firefox, url comes from http.SetUrl or http.SetUri + http.SetParam, the second invocation will reuse the same web driver of first invocation, in other words, there is only one web driver during running of a script |
| `selenium.GetBy <browser>`                 | get url response in specified browser, supported browser: htmlunit, firefox, chrome, ie |
| `selenium.Open`                            | same as selenium.Get |
| `selenium.VerifyText <selector> <text>`    | verify text of selected element by selenium |
| `selenium.AssertCurrentUrlMatches <regex>` | |
| `selenium.AssertCurrentTitleMatches <regex>` | |
| `selenium.Close` | close web driver, if no web driver, do nothing |

## Command Development ##

### basic ###

All commands should be named like 'XxxCommand'. A command will be located by full class name which consisted of command path, command name and Command suffix. e.g `Pause` command is mapped to `in.xnnyygn.attic.command.PauseCommand`. The default command path is `in.xnnyygn.attic.command`.
Commands share one context during one script. You can set variable in A command and use it by B command in the same script.
Command arguments start from 1, the '0' mapped to command name itself which is similar to shell.

### core interfaces ###

~~~
public interface Command {

  void setArguments(CommandArguments arguments);
  
  void execute(CommandContext context);
  
}
~~~

~~~
public interface CommandArguments {
  
  String getName();
  
  String getParameter(int index);
  
  String getParameter(int index, String defaultValue);
  
  int getParameterCount();
  
}
~~~

~~~
public interface CommandContext {

  boolean containsVariable(String key);
  
  <T> T getVariable(String key);

  <T> void setVariable(String key, T value);

  <T> T remove(String key);

}
~~~