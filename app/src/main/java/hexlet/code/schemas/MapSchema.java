package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        addPredicate(s -> s != null);
        return this;
    }
    public MapSchema sizeof(int sizeMap) {
        addPredicate(s -> s == null || (s.size() >= sizeMap));
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addPredicate(map -> schemas.entrySet()
                .stream()
                .allMatch(e ->
                        e.getValue().isValid(((String) map.get(e.getKey())))
                )
        );
        return this;
    }
}
