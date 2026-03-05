package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
    public MapSchema sizeof(int sizeMap) {
        addValidation("sizeof", s -> s == null || (s.size() >= sizeMap));
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addValidation("shape", map -> schemas.entrySet()
                .stream()
                .allMatch(e ->
                        e.getValue().isValid(((String) map.get(e.getKey())))
                )
        );
        return this;
    }
}
