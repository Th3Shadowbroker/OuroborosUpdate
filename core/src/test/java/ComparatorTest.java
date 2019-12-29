import org.th3shadowbroker.ouroboros.update.comparison.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparatorTest {

    @Test
    public void test() {
        // Testing of equal comparator
        Assertions.assertTrue(Comparator.EQUAL.isUpdateAvailable("Example_v1.0.0-SNAPSHOT", "Example_v1.0.1-SNAPSHOT"));
        Assertions.assertFalse(Comparator.EQUAL.isUpdateAvailable("Example_v1.0.0-SNAPSHOT", "Example_v1.0.0-SNAPSHOT"));

        // Testing of semantic comparator
        Assertions.assertTrue(Comparator.SEMANTIC.isUpdateAvailable("Example_v1.0.0-SNAPSHOT", "Example_v1.0.1-SNAPSHOT"));
        Assertions.assertFalse(Comparator.SEMANTIC.isUpdateAvailable("Example_v1.0.0-SNAPSHOT", "Example_v1.0.0-SNAPSHOT"));
    }

}
