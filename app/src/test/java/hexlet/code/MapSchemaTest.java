package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapSchemaTest {
    private MapSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new Validator().map();
    }
    @Test
    void testNull() {
        assertTrue(schema.isValid(null));
    }
    @Test
    void testAfterRequired() {
        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }
    @Test
    void testSize() {

        schema.required().sizeof(2);

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
    @Test
    void shapeTest() {
        var schemaString = new Validator().string();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", schemaString.required());
        schemas.put("lastName", schemaString.required().minLength(2));

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human1.put("firstName", "Jane");
        human1.put("lastName", "S");
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human1.put("firstName", null);
        human1.put("lastName", "Smith");
        assertFalse(schema.isValid(human3));
    }
}
