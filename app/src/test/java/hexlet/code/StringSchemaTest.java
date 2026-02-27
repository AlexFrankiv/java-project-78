package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new Validator().string();
    }
    @Test
    void testNullAndEmpty() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
    }
    @Test
    void testAfterRequired() {
        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }
    @Test
    void testContains() {
        schema.required();

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }
    @Test
    void testMinLength() {
        schema.required();

        assertFalse(schema.minLength(3).isValid("wh"));
        assertTrue(schema.minLength(7).isValid("what does the fox say"));
    }
    @Test
    void test() {
        schema.required();

        assertTrue(schema.minLength(5).contains("hexlet").isValid("hexlet"));
    }
}
