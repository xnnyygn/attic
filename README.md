
# attic #

Attic is a simple intercepeter for acceptance test.

## Usage ##

mvn package

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
