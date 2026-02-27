package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NumberSchemaTest {
    private NumberSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new Validator().number();
    }
    @Test
    void testNullAndEmpty() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));
    }
    @Test
    void testAfterRequired() {
        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }
    @Test
    void testPositive() {
        schema.required().positive();

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }
    @Test
    void testRange() {
        schema.required().range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
