# java-fetch

```jshelllanguage
var response = Fetch.fetch("https://example.com/");
var expected = Thread.currentThread().getContextClassLoader().getResourceAsStream("example.html");
var actual = response.body();
try (expected; actual) {
    Assertions.assertEquals(inputStreamToString(expected), inputStreamToString(actual));
}
```
