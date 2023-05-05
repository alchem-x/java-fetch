package fetch;

import fetch.support.UnsafeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

class FetchTest {

    @Test
    void test() throws IOException {
        var response = Fetch.fetch("https://example.com/");
        var expected = Thread.currentThread().getContextClassLoader().getResourceAsStream("example.html");
        var actual = response.body();
        try (expected; actual) {
            Assertions.assertEquals(inputStreamToString(expected), inputStreamToString(actual));
        }
    }

    private static @NotNull String inputStreamToString(@Nullable InputStream inputStream) throws IOException {
        return new String(Objects.requireNonNull(inputStream).readAllBytes(), StandardCharsets.UTF_8);
    }
}
