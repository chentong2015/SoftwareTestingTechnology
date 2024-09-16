package hamcrest;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

public class MatchersTest {

    @Test
    public void testMatchers() {
        ArgumentMatchers.<Bar>anyList()
        Matchers.any(List.class)
        // Matchers.anyOf(List<String>)
    }
}
